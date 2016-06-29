package com.google.security.zynamics.bindiff.database;

import com.google.security.zynamics.bindiff.io.proto.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.types.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.log.*;
import java.io.*;

public class MatchesDatabase extends SqliteDatabase
{
    public static int UNSAVED_BASICBLOCKMATCH_ALGORITH_ID;
    private static int DEFAULT_FILE_TABLE_COLUMN_COUNT;
    
    public MatchesDatabase(final File file) {
        super(file);
    }
    
    private void addBasicblockMatches(final FunctionMatchData functionMatchData) {
        final int functionMatchId = this.getFunctionMatchId(functionMatchData);
        int nextBasicblockMatchId = this.getNextBasicblockMatchId();
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("INSERT INTO basicblock VALUES (?, ?, ?, ?, ?, ?)");
             final PreparedStatement prepareStatement2 = this.connection.prepareStatement("INSERT INTO instruction VALUES (?, ?, ?)")) {
            final int algorithmIdForManuallyMatchedBasicblocks = this.getAlgorithmIdForManuallyMatchedBasicblocks();
            for (final BasicBlockMatchData basicBlockMatchData : functionMatchData.getBasicblockMatches()) {
                final int algorithmId = basicBlockMatchData.getAlgorithmId();
                prepareStatement.setInt(1, nextBasicblockMatchId);
                prepareStatement.setInt(2, functionMatchId);
                prepareStatement.setLong(3, basicBlockMatchData.getAddress(ESide.PRIMARY));
                prepareStatement.setLong(4, basicBlockMatchData.getAddress(ESide.SECONDARY));
                prepareStatement.setInt(5, (algorithmId == MatchesDatabase.UNSAVED_BASICBLOCKMATCH_ALGORITH_ID) ? algorithmIdForManuallyMatchedBasicblocks : algorithmId);
                prepareStatement.setInt(6, (algorithmId == MatchesDatabase.UNSAVED_BASICBLOCKMATCH_ALGORITH_ID) ? 1 : 0);
                prepareStatement.addBatch();
                for (final InstructionMatchData instructionMatchData : basicBlockMatchData.getInstructionMatches()) {
                    prepareStatement2.setInt(1, nextBasicblockMatchId);
                    prepareStatement2.setLong(2, instructionMatchData.getAddress(ESide.PRIMARY));
                    prepareStatement2.setLong(3, instructionMatchData.getAddress(ESide.SECONDARY));
                    prepareStatement2.addBatch();
                }
                ++nextBasicblockMatchId;
            }
            prepareStatement.executeBatch();
            prepareStatement2.executeBatch();
        }
    }
    
    private void alterFileTable() {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT * FROM file");
             final ResultSet executeQuery = prepareStatement.executeQuery()) {
            if (executeQuery.getMetaData().getColumnCount() == MatchesDatabase.DEFAULT_FILE_TABLE_COLUMN_COUNT) {
                try (final PreparedStatement prepareStatement2 = this.connection.prepareStatement("ALTER TABLE file ADD COLUMN functionname VARCHAR");
                     final PreparedStatement prepareStatement3 = this.connection.prepareStatement("ALTER TABLE file ADD COLUMN functiontype INT");
                     final PreparedStatement prepareStatement4 = this.connection.prepareStatement("ALTER TABLE file ADD COLUMN flowgraphoffset INT")) {
                    prepareStatement2.executeUpdate();
                    prepareStatement3.executeUpdate();
                    prepareStatement4.executeUpdate();
                }
            }
        }
    }
    
    private int countFunctionSimilarity(final double n, final double n2) {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT COUNT(*) AS intervalcount FROM function WHERE similarity >= ? AND similarity < ?")) {
            prepareStatement.setDouble(1, n);
            prepareStatement.setDouble(2, n2);
            final ResultSet executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                return executeQuery.getInt("intervalcount");
            }
        }
        return 0;
    }
    
    private int[] countFunctionSimilarityIntervals() {
        final int[] array = new int[11];
        for (int i = 0; i <= 10; ++i) {
            array[i] = this.countFunctionSimilarity(i * 0.1, (i + 1) * 0.1);
        }
        return array;
    }
    
    private int countMatchedFunctions() {
        try (final Statement statement = this.connection.createStatement()) {
            final ResultSet executeQuery = statement.executeQuery("SELECT COUNT(*) AS matchedfunctioncount FROM function");
            if (executeQuery.next()) {
                return executeQuery.getInt("matchedfunctioncount");
            }
        }
        return 0;
    }
    
    private void deleteBasiblockMatches(final long n, final long n2) {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT basicblock.id FROM function INNER JOIN basicblock ON basicblock.functionid = function.id WHERE function.address1 = ? AND function.address2 = ?")) {
            prepareStatement.setLong(1, n);
            prepareStatement.setLong(2, n2);
            try (final ResultSet executeQuery = prepareStatement.executeQuery()) {
                final QueryBuilder queryBuilder = new QueryBuilder("DELETE FROM instruction WHERE basicblockid IN ");
                while (executeQuery.next()) {
                    queryBuilder.appendInSet(executeQuery.getString(1));
                }
                queryBuilder.execute(this.connection);
            }
        }
        try (final PreparedStatement prepareStatement2 = this.connection.prepareStatement("SELECT id FROM function WHERE address1 = ? AND address2 = ?")) {
            prepareStatement2.setLong(1, n);
            prepareStatement2.setLong(2, n2);
            try (final ResultSet executeQuery2 = prepareStatement2.executeQuery()) {
                final QueryBuilder queryBuilder2 = new QueryBuilder("DELETE FROM basicblock WHERE functionid IN ");
                if (executeQuery2.next()) {
                    queryBuilder2.appendInSet(executeQuery2.getString(1));
                }
                queryBuilder2.execute(this.connection);
            }
        }
    }
    
    private int getAlgorithmIdForManuallyMatchedBasicblocks() {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT MAX(id) AS maxid FROM basicblockalgorithm");
             final ResultSet executeQuery = prepareStatement.executeQuery()) {
            executeQuery.next();
            return executeQuery.getInt("maxid");
        }
    }
    
    private int getFunctionMatchId(final FunctionMatchData functionMatchData) {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT id FROM function WHERE address1 = ? AND address2 = ?")) {
            prepareStatement.setLong(1, functionMatchData.getAddress(ESide.PRIMARY));
            prepareStatement.setLong(2, functionMatchData.getAddress(ESide.SECONDARY));
            final ResultSet executeQuery = prepareStatement.executeQuery();
            return executeQuery.next() ? executeQuery.getInt(1) : -1;
        }
    }
    
    private int getNextBasicblockMatchId() {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("select coalesce(max(id) + 1, 1) as maxid from basicblock");
             final ResultSet executeQuery = prepareStatement.executeQuery()) {
            return executeQuery.next() ? executeQuery.getInt(1) : -1;
        }
    }
    
    private void addBinExportMetaData(final File file, final DiffMetaData diffMetaData) {
        if (file == null) {
            return;
        }
        final File binExportFile = DiffDirectories.getBinExportFile(file, diffMetaData, ESide.PRIMARY);
        if (binExportFile.exists() && binExportFile.canRead()) {
            final BinExportReader binExportReader = new BinExportReader(binExportFile, ESide.PRIMARY);
            diffMetaData.setAddressSpace(binExportReader.getAddressSpaceBits(), ESide.PRIMARY);
            diffMetaData.setArchitectureName(binExportReader.getArchitectureName(), ESide.PRIMARY);
            diffMetaData.setMaxMnemonicLen(binExportReader.getMaxMnemonicLen(), ESide.PRIMARY);
        }
        final File binExportFile2 = DiffDirectories.getBinExportFile(file, diffMetaData, ESide.SECONDARY);
        if (binExportFile2.exists() && binExportFile2.canRead()) {
            final BinExportReader binExportReader2 = new BinExportReader(binExportFile, ESide.SECONDARY);
            diffMetaData.setAddressSpace(binExportReader2.getAddressSpaceBits(), ESide.SECONDARY);
            diffMetaData.setArchitectureName(binExportReader2.getArchitectureName(), ESide.SECONDARY);
            diffMetaData.setMaxMnemonicLen(binExportReader2.getMaxMnemonicLen(), ESide.SECONDARY);
        }
    }
    
    private void setFunctionMatchCounts(final long n, final long n2, final FunctionMatchData functionMatchData) {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("UPDATE function SET basicblocks = ?, edges = ?, instructions = ?WHERE address1 = ? and address2 = ?")) {
            prepareStatement.setInt(1, functionMatchData.getSizeOfMatchedBasicblocks());
            prepareStatement.setInt(2, functionMatchData.getSizeOfMatchedJumps());
            prepareStatement.setInt(3, functionMatchData.getSizeOfMatchedInstructions());
            prepareStatement.setLong(4, n);
            prepareStatement.setLong(5, n2);
            prepareStatement.executeUpdate();
        }
    }
    
    public void changeExportFilename(final String s, final ESide eSide) {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("update file set filename = ? where id = ?")) {
            prepareStatement.setString(1, s);
            prepareStatement.setInt(2, (eSide == ESide.PRIMARY) ? 1 : 2);
            prepareStatement.executeUpdate();
        }
    }
    
    public void changeFileTable(final Diff diff) {
        if (!diff.isLoaded()) {
            throw new IllegalStateException("Function diff has to be loaded before saving.");
        }
        if (!diff.isFunctionDiff()) {
            throw new IllegalArgumentException("Must be a function diff.");
        }
        this.alterFileTable();
        final RawFunction rawFunction = diff.getCallgraph(ESide.PRIMARY).getNodes().get(0);
        final RawFunction rawFunction2 = diff.getCallgraph(ESide.SECONDARY).getNodes().get(0);
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("UPDATE file SET functionname = ?, functiontype = ?, flowgraphoffset = ? WHERE id = ?")) {
            prepareStatement.setString(1, rawFunction.getName());
            prepareStatement.setInt(2, EFunctionType.getOrdinal(rawFunction.getFunctionType()));
            prepareStatement.setInt(3, ((FunctionDiffMetaData)diff.getMetaData()).getFlowgraphOffset(ESide.PRIMARY));
            prepareStatement.setInt(4, 1);
            prepareStatement.addBatch();
            prepareStatement.setString(1, rawFunction2.getName());
            prepareStatement.setInt(2, EFunctionType.getOrdinal(rawFunction2.getFunctionType()));
            prepareStatement.setInt(3, ((FunctionDiffMetaData)diff.getMetaData()).getFlowgraphOffset(ESide.SECONDARY));
            prepareStatement.setInt(4, 2);
            prepareStatement.addBatch();
            prepareStatement.executeBatch();
        }
    }
    
    public void deleteBasicblockMatch(final FunctionMatchData functionMatchData, final BasicBlockMatchData basicBlockMatchData) {
        int int1 = -1;
        int int2 = -1;
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT function.id, basicblock.id FROM function INNER JOIN basicblock ON basicblock.address1 = ? and basicblock.address2 = ? INNER JOIN instruction ON basicblock.id = instruction.basicblockid WHERE function.address1 = ? and function.address2 = ? GROUP BY basicblock.functionid;")) {
            prepareStatement.setLong(1, basicBlockMatchData.getAddress(ESide.PRIMARY));
            prepareStatement.setLong(2, basicBlockMatchData.getAddress(ESide.SECONDARY));
            prepareStatement.setLong(3, functionMatchData.getAddress(ESide.PRIMARY));
            prepareStatement.setLong(4, functionMatchData.getAddress(ESide.SECONDARY));
            final ResultSet executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                int1 = executeQuery.getInt(1);
                int2 = executeQuery.getInt(2);
            }
        }
        catch (SQLException ex) {
            throw new SQLException("Couldn't delete non existing basicblock match from database.", ex);
        }
        try (final PreparedStatement prepareStatement2 = this.connection.prepareStatement("DELETE FROM basicblock WHERE id = ? AND functionid = ? ")) {
            prepareStatement2.setInt(1, int2);
            prepareStatement2.setInt(2, int1);
            prepareStatement2.executeUpdate();
        }
        catch (SQLException ex2) {
            final String s = "Failed to delete basic block match from database: ";
            final String value = String.valueOf(ex2.getMessage());
            throw new SQLException((value.length() != 0) ? s.concat(value) : new String(s));
        }
        try (final PreparedStatement prepareStatement3 = this.connection.prepareStatement("DELETE FROM instruction WHERE basicblockid = ?")) {
            prepareStatement3.setInt(1, int2);
            prepareStatement3.executeUpdate();
        }
        catch (SQLException ex3) {
            final String value2 = String.valueOf("Failed to delete instruction matches of removed basic block match from database: ");
            final String value3 = String.valueOf(ex3.getMessage());
            throw new SQLException((value3.length() != 0) ? value2.concat(value3) : new String(value2));
        }
    }
    
    public String[] getIDBNames() {
        final String[] array = new String[2];
        try (final Statement statement = this.connection.createStatement()) {
            final ResultSet executeQuery = statement.executeQuery("SELECT filename FROM file ORDER BY id");
            int n = 0;
            while (executeQuery.next()) {
                array[n++] = executeQuery.getString("filename");
            }
            return array;
        }
        catch (SQLException ex) {
            final String s = "Couldn't read IDB names: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s.concat(value) : new String(s));
        }
    }
    
    public void loadBasicblockMatches(final FunctionMatchData functionMatchData) {
        if (functionMatchData == null) {
            return;
        }
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT basicblock.address1 AS priBasicblockAddr, basicblock.address2 AS secBasicblockAddr, basicblock.algorithm, instruction.address1 AS priInstructionAddr, instruction.address2 AS secInstructionAddr FROM function INNER JOIN basicblock ON basicblock.functionid = function.id INNER JOIN basicblockalgorithm ON basicblockalgorithm.id = basicblock.algorithm LEFT JOIN instruction ON basicblock.id = instruction.basicblockid WHERE function.address1 = ? AND function.address2 = ? ORDER BY priBasicblockAddr, priInstructionAddr;")) {
            prepareStatement.setLong(1, functionMatchData.getAddress(ESide.PRIMARY));
            prepareStatement.setLong(2, functionMatchData.getAddress(ESide.SECONDARY));
            final ArrayList<BasicBlockMatchData> list = new ArrayList<BasicBlockMatchData>();
            ArrayList<InstructionMatchData> list2 = new ArrayList<InstructionMatchData>();
            final ResultSet executeQuery = prepareStatement.executeQuery();
            long n = 0L;
            long long1 = 0L;
            long n2 = 0L;
            int n3 = 0;
            long long2 = 0L;
            long long3 = 0L;
            while (executeQuery.next()) {
                long1 = executeQuery.getLong(1);
                if (n != long1 && !executeQuery.isFirst()) {
                    list.add(new BasicBlockMatchData(n, n2, n3, new Matches(list2)));
                    list2 = new ArrayList<InstructionMatchData>();
                    n = long1;
                    n2 = executeQuery.getLong(2);
                    n3 = executeQuery.getInt(3);
                }
                final boolean b = executeQuery.getObject(4) == null || executeQuery.getObject(5) == null;
                if (!b) {
                    long2 = executeQuery.getLong(4);
                    long3 = executeQuery.getLong(5);
                }
                if (executeQuery.isFirst()) {
                    n2 = executeQuery.getLong(2);
                    n3 = executeQuery.getInt(3);
                    n = long1;
                    list2 = new ArrayList<InstructionMatchData>();
                }
                if (!b) {
                    list2.add(new InstructionMatchData(long2, long3));
                }
            }
            list.add(new BasicBlockMatchData(long1, n2, n3, new Matches(list2)));
            functionMatchData.loadBasicblockMatches(list);
        }
        catch (SQLException ex) {
            final String s = "Couldn't read basic block and instruction matches.\n";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s));
        }
    }
    
    public String loadDiffDescription() {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT description FROM metadata");
             final ResultSet executeQuery = prepareStatement.executeQuery()) {
            return executeQuery.next() ? executeQuery.getString("description") : "";
        }
    }
    
    public DiffMetaData loadDiffMetaData(final File file) {
        try {
            String string;
            String string2;
            String string3;
            double double1;
            double double2;
            try (final Statement statement = this.connection.createStatement();
                 final ResultSet executeQuery = statement.executeQuery("SELECT version, description, created, similarity, confidence FROM metadata")) {
                executeQuery.next();
                string = executeQuery.getString("version");
                string2 = executeQuery.getString("description");
                string3 = executeQuery.getString("created");
                double1 = executeQuery.getDouble("similarity");
                double2 = executeQuery.getDouble("confidence");
            }
            try (final Statement statement2 = this.connection.createStatement();
                 final ResultSet executeQuery2 = statement2.executeQuery("SELECT filename, exefilename, hash, functions, libfunctions, calls, basicblocks, libbasicblocks, edges, libedges, instructions, libinstructions FROM file")) {
                executeQuery2.next();
                final String string4 = executeQuery2.getString("filename");
                final String string5 = executeQuery2.getString("exefilename");
                final String string6 = executeQuery2.getString("hash");
                final int n = executeQuery2.getInt("functions") + executeQuery2.getInt("libfunctions");
                final int int1 = executeQuery2.getInt("calls");
                final int n2 = executeQuery2.getInt("basicblocks") + executeQuery2.getInt("libbasicblocks");
                final int n3 = executeQuery2.getInt("edges") + executeQuery2.getInt("libedges");
                final int n4 = executeQuery2.getInt("instructions") + executeQuery2.getInt("libinstructions");
                executeQuery2.next();
                final DiffMetaData diffMetaData = new DiffMetaData(string, string2, DiffMetaData.dbDateStringToCalendar(string3), double1, double2, string4, executeQuery2.getString("filename"), string5, executeQuery2.getString("exefilename"), string6, executeQuery2.getString("hash"), this.countFunctionSimilarityIntervals(), this.countMatchedFunctions(), n, executeQuery2.getInt("functions") + executeQuery2.getInt("libfunctions"), int1, executeQuery2.getInt("calls"), n2, executeQuery2.getInt("basicblocks") + executeQuery2.getInt("libbasicblocks"), n3, executeQuery2.getInt("edges") + executeQuery2.getInt("libedges"), n4, executeQuery2.getInt("instructions") + executeQuery2.getInt("libinstructions"));
                this.addBinExportMetaData(file, diffMetaData);
                return diffMetaData;
            }
        }
        catch (IOException | SQLException ex3) {
            final SQLException ex2;
            final SQLException ex = ex2;
            final String s = "Couldn't load diff. Reading meta data from matches database failed: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s.concat(value) : new String(s), ex);
        }
    }
    
    public IAddressPair loadFunctionDiffAddressPair() {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT function.address1, function.address2 FROM function")) {
            final ResultSet executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                final long long1 = executeQuery.getLong(1);
                final long long2 = executeQuery.getLong(2);
                if (!executeQuery.next()) {
                    return new AddressPair(long1, long2);
                }
            }
            throw new SQLException("Illegal BinDiff database state: Function matches must be unique.");
        }
    }
    
    public FunctionDiffMetaData loadFunctionDiffMetaData(final boolean b) {
        final DiffMetaData loadDiffMetaData = this.loadDiffMetaData(null);
        if (!b) {
            final IAddressPair loadFunctionDiffAddressPair = this.loadFunctionDiffAddressPair();
            final IAddress iAddress = loadFunctionDiffAddressPair.getIAddress(ESide.PRIMARY);
            final IAddress iAddress2 = loadFunctionDiffAddressPair.getIAddress(ESide.SECONDARY);
            try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT functionname, functiontype, flowgraphoffset FROM file ORDER BY id")) {
                String string = null;
                String string2 = null;
                EFunctionType type = null;
                EFunctionType type2 = null;
                Integer value = null;
                Integer value2 = null;
                final ResultSet executeQuery = prepareStatement.executeQuery();
                if (executeQuery.next()) {
                    string = executeQuery.getString("functionname");
                    type = EFunctionType.getType(executeQuery.getInt("functiontype"));
                    value = executeQuery.getInt("flowgraphoffset");
                }
                if (executeQuery.next()) {
                    string2 = executeQuery.getString("functionname");
                    type2 = EFunctionType.getType(executeQuery.getInt("functiontype"));
                    value2 = executeQuery.getInt("flowgraphoffset");
                }
                if (string == null || string2 == null) {
                    throw new SQLException("Failed to load function diff meta data: Primary and secondary function must not be null.");
                }
                if (type == null || type2 == null) {
                    throw new SQLException("Failed to load function diff meta data: Primary and secondary function type must not be null.");
                }
                return new FunctionDiffMetaData(loadDiffMetaData, iAddress, iAddress2, string, string2, type, type2, value, value2);
            }
        }
        return new FunctionDiffMetaData(loadDiffMetaData, null, null, null, null, null, null, null, null);
    }
    
    public MatchData loadFunctionMatches(final Diff diff) {
        final DiffMetaData metaData = diff.getMetaData();
        int sizeOfMatchedBasicblocks = 0;
        int sizeOfMatchedJumps = 0;
        int sizeOfMatchedInstructions = 0;
        try (final Statement statement = this.connection.createStatement()) {
            final ResultSet executeQuery = statement.executeQuery("SELECT function.id, function.address1, function.address2, function.similarity, function.confidence, function.flags, function.algorithm, function.basicblocks, function.edges, function.instructions FROM function");
            final ArrayList<FunctionMatchData> list = new ArrayList<FunctionMatchData>();
            while (executeQuery.next()) {
                sizeOfMatchedBasicblocks += executeQuery.getInt("basicblocks");
                sizeOfMatchedJumps += executeQuery.getInt("edges");
                sizeOfMatchedInstructions += executeQuery.getInt("instructions");
                list.add(new FunctionMatchData(executeQuery.getInt("id"), executeQuery.getLong("address1"), executeQuery.getLong("address2"), executeQuery.getDouble("similarity"), executeQuery.getDouble("confidence"), executeQuery.getInt("flags"), executeQuery.getInt("algorithm"), executeQuery.getInt("basicblocks"), executeQuery.getInt("edges"), executeQuery.getInt("instructions")));
            }
            metaData.setSizeOfMatchedBasicblocks(sizeOfMatchedBasicblocks);
            metaData.setSizeOfMatchedJumps(sizeOfMatchedJumps);
            metaData.setSizeOfMatchedInstructions(sizeOfMatchedInstructions);
            return new MatchData(list, metaData);
        }
        catch (SQLException ex) {
            final String s = "Couldn't load diff. Reading function matches from database failed: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s.concat(value) : new String(s));
        }
    }
    
    public Map loadMatchedCallAddresses(final Diff diff) {
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        final ArrayList<IAddress> list = new ArrayList<IAddress>();
        final Iterator<RawCall> iterator = (Iterator<RawCall>)diff.getCallgraph(ESide.PRIMARY).getEdges().iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().getSourceInstructionAddr());
        }
        StringBuilder sb = new StringBuilder("SELECT function.address1, instruction.address1, function.address2, instruction.address2 FROM function INNER JOIN basicblock ON function.id = basicblock.functionid INNER JOIN instruction ON basicblock.id = instruction.basicblockid WHERE instruction.address1 IN ");
        int n = 1;
        try {
            try (final Statement statement = this.connection.createStatement()) {
                for (final IAddress address : list) {
                    if (n != 0) {
                        sb.append("(");
                        n = 0;
                    }
                    else {
                        sb.append(",");
                    }
                    sb.append(new StringBuilder(20).append(address.toLong()).toString());
                    if (sb.length() >= 999990) {
                        sb.append(")");
                        try (final ResultSet executeQuery = statement.executeQuery(sb.toString())) {
                            while (executeQuery.next()) {
                                hashMap.put(new AddressPair(executeQuery.getLong(1), executeQuery.getLong(2)), new AddressPair(executeQuery.getLong(3), executeQuery.getLong(4)));
                            }
                        }
                        sb = new StringBuilder("SELECT function.address1, instruction.address1, function.address2, instruction.address2 FROM function INNER JOIN basicblock ON function.id = basicblock.functionid INNER JOIN instruction ON basicblock.id = instruction.basicblockid WHERE instruction.address1 IN ");
                        n = 1;
                    }
                }
            }
            if (n == 0 && sb.length() != "SELECT function.address1, instruction.address1, function.address2, instruction.address2 FROM function INNER JOIN basicblock ON function.id = basicblock.functionid INNER JOIN instruction ON basicblock.id = instruction.basicblockid WHERE instruction.address1 IN ".length()) {
                sb.append(")");
                try (final Statement statement2 = this.connection.createStatement();
                     final ResultSet executeQuery2 = statement2.executeQuery(sb.toString())) {
                    while (executeQuery2.next()) {
                        hashMap.put(new AddressPair(executeQuery2.getLong(1), executeQuery2.getLong(2)), new AddressPair(executeQuery2.getLong(3), executeQuery2.getLong(4)));
                    }
                }
            }
        }
        catch (SQLException ex) {
            final String s = "Couldn't read calls matches from database: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s.concat(value) : new String(s));
        }
        return Collections.unmodifiableMap((Map<?, ?>)hashMap);
    }
    
    public void saveDiffDescription(final String s) {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("UPDATE metadata SET description = ?")) {
            prepareStatement.setString(1, s);
            prepareStatement.executeUpdate();
        }
    }
    
    public void setFunctionDiffCounts(final RawFunction rawFunction, final RawFunction rawFunction2) {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT basicblocks, libbasicblocks, edges, libedges, instructions, libinstructions FROM file ORDER BY id ");
             final ResultSet executeQuery = prepareStatement.executeQuery()) {
            if (executeQuery.next()) {
                rawFunction.setSizeOfBasicblocks(executeQuery.getInt("basicblocks") + executeQuery.getInt("libbasicblocks"));
                rawFunction.setSizeOfJumps(executeQuery.getInt("edges") + executeQuery.getInt("libedges"));
                rawFunction.setSizeOfInstructions(executeQuery.getInt("instructions") + executeQuery.getInt("libinstructions"));
            }
            if (executeQuery.next()) {
                rawFunction2.setSizeOfBasicblocks(executeQuery.getInt("basicblocks") + executeQuery.getInt("libbasicblocks"));
                rawFunction2.setSizeOfJumps(executeQuery.getInt("edges") + executeQuery.getInt("libedges"));
                rawFunction2.setSizeOfInstructions(executeQuery.getInt("instructions") + executeQuery.getInt("libinstructions"));
                return;
            }
            throw new SQLException("Invalid matches database state. File table must consist of exactly two records.");
        }
    }
    
    public void updateFunctionMatch(final long n, final long n2, final FunctionMatchData functionMatchData) {
        final boolean autoCommit = this.connection.getAutoCommit();
        this.connection.setAutoCommit(false);
        try {
            this.deleteBasiblockMatches(n, n2);
            this.addBasicblockMatches(functionMatchData);
            this.setFunctionMatchCounts(n, n2, functionMatchData);
            this.connection.commit();
        }
        catch (SQLException ex) {
            Logger.logException(ex, "Couldn't update function match. Executing rollback.");
            this.connection.rollback();
        }
        this.connection.setAutoCommit(autoCommit);
    }
    
    static {
        MatchesDatabase.UNSAVED_BASICBLOCKMATCH_ALGORITH_ID = -1;
        MatchesDatabase.DEFAULT_FILE_TABLE_COLUMN_COUNT = 13;
    }
}
