/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.database;

import com.google.security.zynamics.bindiff.database.QueryBuilder;
import com.google.security.zynamics.bindiff.database.SqliteDatabase;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.io.proto.BinExportReader;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffDirectories;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionDiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.bindiff.project.matches.InstructionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.types.Matches;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchesDatabase
extends SqliteDatabase {
    public static int UNSAVED_BASICBLOCKMATCH_ALGORITH_ID = -1;
    private static int DEFAULT_FILE_TABLE_COLUMN_COUNT = 13;

    public MatchesDatabase(File file) {
        super(file);
    }

    private void addBasicblockMatches(FunctionMatchData functionMatchData) {
        int n2 = this.getFunctionMatchId(functionMatchData);
        int n3 = this.getNextBasicblockMatchId();
        PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO basicblock VALUES (?, ?, ?, ?, ?, ?)");
        Throwable throwable = null;
        try {
            PreparedStatement preparedStatement2 = this.connection.prepareStatement("INSERT INTO instruction VALUES (?, ?, ?)");
            Throwable throwable2 = null;
            try {
                int n4 = this.getAlgorithmIdForManuallyMatchedBasicblocks();
                for (BasicBlockMatchData basicBlockMatchData : functionMatchData.getBasicblockMatches()) {
                    int n5 = basicBlockMatchData.getAlgorithmId();
                    preparedStatement.setInt(1, n3);
                    preparedStatement.setInt(2, n2);
                    preparedStatement.setLong(3, basicBlockMatchData.getAddress(ESide.PRIMARY));
                    preparedStatement.setLong(4, basicBlockMatchData.getAddress(ESide.SECONDARY));
                    preparedStatement.setInt(5, n5 == UNSAVED_BASICBLOCKMATCH_ALGORITH_ID ? n4 : n5);
                    preparedStatement.setInt(6, n5 == UNSAVED_BASICBLOCKMATCH_ALGORITH_ID ? 1 : 0);
                    preparedStatement.addBatch();
                    for (InstructionMatchData instructionMatchData : basicBlockMatchData.getInstructionMatches()) {
                        preparedStatement2.setInt(1, n3);
                        preparedStatement2.setLong(2, instructionMatchData.getAddress(ESide.PRIMARY));
                        preparedStatement2.setLong(3, instructionMatchData.getAddress(ESide.SECONDARY));
                        preparedStatement2.addBatch();
                    }
                    ++n3;
                }
                preparedStatement.executeBatch();
                preparedStatement2.executeBatch();
                return;
            }
            catch (Throwable var8_12) {
                throwable2 = var8_12;
                throw var8_12;
            }
            finally {
                if (preparedStatement2 != null) {
                    if (throwable2 != null) {
                        try {
                            preparedStatement2.close();
                        }
                        catch (Throwable var8_11) {
                            throwable2.addSuppressed(var8_11);
                        }
                    } else {
                        preparedStatement2.close();
                    }
                }
            }
        }
        catch (Throwable var6_8) {
            throwable = var6_8;
            throw var6_8;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var6_7) {
                        throwable.addSuppressed(var6_7);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    private void alterFileTable() {
        PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM file");
        Throwable throwable = null;
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            Throwable throwable2 = null;
            try {
                if (resultSet.getMetaData().getColumnCount() != DEFAULT_FILE_TABLE_COLUMN_COUNT) return;
                PreparedStatement preparedStatement2 = this.connection.prepareStatement("ALTER TABLE file ADD COLUMN functionname VARCHAR");
                Throwable throwable3 = null;
                try {
                    PreparedStatement preparedStatement3 = this.connection.prepareStatement("ALTER TABLE file ADD COLUMN functiontype INT");
                    Throwable throwable4 = null;
                    try {
                        PreparedStatement preparedStatement4 = this.connection.prepareStatement("ALTER TABLE file ADD COLUMN flowgraphoffset INT");
                        Throwable throwable5 = null;
                        try {
                            preparedStatement2.executeUpdate();
                            preparedStatement3.executeUpdate();
                            preparedStatement4.executeUpdate();
                            return;
                        }
                        catch (Throwable var11_20) {
                            throwable5 = var11_20;
                            throw var11_20;
                        }
                        finally {
                            if (preparedStatement4 != null) {
                                if (throwable5 != null) {
                                    try {
                                        preparedStatement4.close();
                                    }
                                    catch (Throwable var11_19) {
                                        throwable5.addSuppressed(var11_19);
                                    }
                                } else {
                                    preparedStatement4.close();
                                }
                            }
                        }
                    }
                    catch (Throwable var9_17) {
                        throwable4 = var9_17;
                        throw var9_17;
                    }
                    finally {
                        if (preparedStatement3 != null) {
                            if (throwable4 != null) {
                                try {
                                    preparedStatement3.close();
                                }
                                catch (Throwable var9_16) {
                                    throwable4.addSuppressed(var9_16);
                                }
                            } else {
                                preparedStatement3.close();
                            }
                        }
                    }
                }
                catch (Throwable var7_13) {
                    throwable3 = var7_13;
                    throw var7_13;
                }
                finally {
                    if (preparedStatement2 != null) {
                        if (throwable3 != null) {
                            try {
                                preparedStatement2.close();
                            }
                            catch (Throwable var7_12) {
                                throwable3.addSuppressed(var7_12);
                            }
                        } else {
                            preparedStatement2.close();
                        }
                    }
                }
            }
            catch (Throwable var5_9) {
                throwable2 = var5_9;
                throw var5_9;
            }
            finally {
                if (resultSet != null) {
                    if (throwable2 != null) {
                        try {
                            resultSet.close();
                        }
                        catch (Throwable var5_8) {
                            throwable2.addSuppressed(var5_8);
                        }
                    } else {
                        resultSet.close();
                    }
                }
            }
        }
        catch (Throwable var3_5) {
            throwable = var3_5;
            throw var3_5;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var3_4) {
                        throwable.addSuppressed(var3_4);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    private int countFunctionSimilarity(double d2, double d3) {
        PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT COUNT(*) AS intervalcount FROM function WHERE similarity >= ? AND similarity < ?");
        Throwable throwable = null;
        try {
            preparedStatement.setDouble(1, d2);
            preparedStatement.setDouble(2, d3);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) return 0;
            int n2 = resultSet.getInt("intervalcount");
            return n2;
        }
        catch (Throwable var7_7) {
            throwable = var7_7;
            throw var7_7;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var9_9) {
                        throwable.addSuppressed(var9_9);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    private int[] countFunctionSimilarityIntervals() {
        int[] arrn = new int[11];
        int n2 = 0;
        while (n2 <= 10) {
            arrn[n2] = this.countFunctionSimilarity((double)n2 * 0.1, (double)(n2 + 1) * 0.1);
            ++n2;
        }
        return arrn;
    }

    private int countMatchedFunctions() {
        Statement statement = this.connection.createStatement();
        Throwable throwable = null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS matchedfunctioncount FROM function");
            if (!resultSet.next()) return 0;
            int n2 = resultSet.getInt("matchedfunctioncount");
            return n2;
        }
        catch (Throwable var3_5) {
            throwable = var3_5;
            throw var3_5;
        }
        finally {
            if (statement != null) {
                if (throwable != null) {
                    try {
                        statement.close();
                    }
                    catch (Throwable var5_7) {
                        throwable.addSuppressed(var5_7);
                    }
                } else {
                    statement.close();
                }
            }
        }
    }

    private void deleteBasiblockMatches(long l2, long l3) {
        QueryBuilder queryBuilder;
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        Throwable throwable;
        Throwable throwable2;
        preparedStatement = this.connection.prepareStatement("SELECT basicblock.id FROM function INNER JOIN basicblock ON basicblock.functionid = function.id WHERE function.address1 = ? AND function.address2 = ?");
        throwable2 = null;
        try {
            preparedStatement.setLong(1, l2);
            preparedStatement.setLong(2, l3);
            resultSet = preparedStatement.executeQuery();
            throwable = null;
            try {
                queryBuilder = new QueryBuilder("DELETE FROM instruction WHERE basicblockid IN ");
                while (resultSet.next()) {
                    queryBuilder.appendInSet(resultSet.getString(1));
                }
                queryBuilder.execute(this.connection);
            }
            catch (Throwable var9_13) {
                throwable = var9_13;
                throw var9_13;
            }
            finally {
                if (resultSet != null) {
                    if (throwable != null) {
                        try {
                            resultSet.close();
                        }
                        catch (Throwable var9_12) {
                            throwable.addSuppressed(var9_12);
                        }
                    } else {
                        resultSet.close();
                    }
                }
            }
        }
        catch (Throwable var7_7) {
            throwable2 = var7_7;
            throw var7_7;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable2 != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var7_6) {
                        throwable2.addSuppressed(var7_6);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
        preparedStatement = this.connection.prepareStatement("SELECT id FROM function WHERE address1 = ? AND address2 = ?");
        throwable2 = null;
        try {
            preparedStatement.setLong(1, l2);
            preparedStatement.setLong(2, l3);
            resultSet = preparedStatement.executeQuery();
            throwable = null;
            try {
                queryBuilder = new QueryBuilder("DELETE FROM basicblock WHERE functionid IN ");
                if (resultSet.next()) {
                    queryBuilder.appendInSet(resultSet.getString(1));
                }
                queryBuilder.execute(this.connection);
                return;
            }
            catch (Throwable var9_15) {
                throwable = var9_15;
                throw var9_15;
            }
            finally {
                if (resultSet != null) {
                    if (throwable != null) {
                        try {
                            resultSet.close();
                        }
                        catch (Throwable var9_14) {
                            throwable.addSuppressed(var9_14);
                        }
                    } else {
                        resultSet.close();
                    }
                }
            }
        }
        catch (Throwable var7_9) {
            throwable2 = var7_9;
            throw var7_9;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable2 != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var7_8) {
                        throwable2.addSuppressed(var7_8);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    /*
     * Exception decompiling
     */
    private int getAlgorithmIdForManuallyMatchedBasicblocks() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    private int getFunctionMatchId(FunctionMatchData functionMatchData) {
        PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT id FROM function WHERE address1 = ? AND address2 = ?");
        Throwable throwable = null;
        try {
            preparedStatement.setLong(1, functionMatchData.getAddress(ESide.PRIMARY));
            preparedStatement.setLong(2, functionMatchData.getAddress(ESide.SECONDARY));
            ResultSet resultSet = preparedStatement.executeQuery();
            int n2 = resultSet.next() ? resultSet.getInt(1) : -1;
            return n2;
        }
        catch (Throwable var4_5) {
            throwable = var4_5;
            throw var4_5;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var6_7) {
                        throwable.addSuppressed(var6_7);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    /*
     * Exception decompiling
     */
    private int getNextBasicblockMatchId() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    private void addBinExportMetaData(File file, DiffMetaData diffMetaData) {
        Object object;
        if (file == null) {
            return;
        }
        File file2 = DiffDirectories.getBinExportFile(file, diffMetaData, ESide.PRIMARY);
        if (file2.exists() && file2.canRead()) {
            object = new BinExportReader(file2, ESide.PRIMARY);
            diffMetaData.setAddressSpace(object.getAddressSpaceBits(), ESide.PRIMARY);
            diffMetaData.setArchitectureName(object.getArchitectureName(), ESide.PRIMARY);
            diffMetaData.setMaxMnemonicLen(object.getMaxMnemonicLen(), ESide.PRIMARY);
        }
        if (!(object = DiffDirectories.getBinExportFile(file, diffMetaData, ESide.SECONDARY)).exists()) return;
        if (!object.canRead()) return;
        BinExportReader binExportReader = new BinExportReader(file2, ESide.SECONDARY);
        diffMetaData.setAddressSpace(binExportReader.getAddressSpaceBits(), ESide.SECONDARY);
        diffMetaData.setArchitectureName(binExportReader.getArchitectureName(), ESide.SECONDARY);
        diffMetaData.setMaxMnemonicLen(binExportReader.getMaxMnemonicLen(), ESide.SECONDARY);
    }

    private void setFunctionMatchCounts(long l2, long l3, FunctionMatchData functionMatchData) {
        PreparedStatement preparedStatement = this.connection.prepareStatement("UPDATE function SET basicblocks = ?, edges = ?, instructions = ?WHERE address1 = ? and address2 = ?");
        Throwable throwable = null;
        try {
            preparedStatement.setInt(1, functionMatchData.getSizeOfMatchedBasicblocks());
            preparedStatement.setInt(2, functionMatchData.getSizeOfMatchedJumps());
            preparedStatement.setInt(3, functionMatchData.getSizeOfMatchedInstructions());
            preparedStatement.setLong(4, l2);
            preparedStatement.setLong(5, l3);
            preparedStatement.executeUpdate();
            return;
        }
        catch (Throwable var8_7) {
            throwable = var8_7;
            throw var8_7;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var8_6) {
                        throwable.addSuppressed(var8_6);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    public void changeExportFilename(String string, ESide eSide) {
        PreparedStatement preparedStatement = this.connection.prepareStatement("update file set filename = ? where id = ?");
        Throwable throwable = null;
        try {
            preparedStatement.setString(1, string);
            preparedStatement.setInt(2, eSide == ESide.PRIMARY ? 1 : 2);
            preparedStatement.executeUpdate();
            return;
        }
        catch (Throwable var5_6) {
            throwable = var5_6;
            throw var5_6;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var5_5) {
                        throwable.addSuppressed(var5_5);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    public void changeFileTable(Diff diff) {
        if (!diff.isLoaded()) {
            throw new IllegalStateException("Function diff has to be loaded before saving.");
        }
        if (!diff.isFunctionDiff()) {
            throw new IllegalArgumentException("Must be a function diff.");
        }
        this.alterFileTable();
        RawFunction rawFunction = (RawFunction)diff.getCallgraph(ESide.PRIMARY).getNodes().get(0);
        RawFunction rawFunction2 = (RawFunction)diff.getCallgraph(ESide.SECONDARY).getNodes().get(0);
        PreparedStatement preparedStatement = this.connection.prepareStatement("UPDATE file SET functionname = ?, functiontype = ?, flowgraphoffset = ? WHERE id = ?");
        Throwable throwable = null;
        try {
            preparedStatement.setString(1, rawFunction.getName());
            preparedStatement.setInt(2, EFunctionType.getOrdinal(rawFunction.getFunctionType()));
            preparedStatement.setInt(3, ((FunctionDiffMetaData)diff.getMetaData()).getFlowgraphOffset(ESide.PRIMARY));
            preparedStatement.setInt(4, 1);
            preparedStatement.addBatch();
            preparedStatement.setString(1, rawFunction2.getName());
            preparedStatement.setInt(2, EFunctionType.getOrdinal(rawFunction2.getFunctionType()));
            preparedStatement.setInt(3, ((FunctionDiffMetaData)diff.getMetaData()).getFlowgraphOffset(ESide.SECONDARY));
            preparedStatement.setInt(4, 2);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            return;
        }
        catch (Throwable var6_7) {
            throwable = var6_7;
            throw var6_7;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var6_6) {
                        throwable.addSuppressed(var6_6);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    public void deleteBasicblockMatch(FunctionMatchData functionMatchData, BasicBlockMatchData basicBlockMatchData) {
        PreparedStatement preparedStatement;
        int n2;
        Throwable throwable;
        int n3;
        n3 = -1;
        n2 = -1;
        try {
            preparedStatement = this.connection.prepareStatement("SELECT function.id, basicblock.id FROM function INNER JOIN basicblock ON basicblock.address1 = ? and basicblock.address2 = ? INNER JOIN instruction ON basicblock.id = instruction.basicblockid WHERE function.address1 = ? and function.address2 = ? GROUP BY basicblock.functionid;");
            throwable = null;
            try {
                preparedStatement.setLong(1, basicBlockMatchData.getAddress(ESide.PRIMARY));
                preparedStatement.setLong(2, basicBlockMatchData.getAddress(ESide.SECONDARY));
                preparedStatement.setLong(3, functionMatchData.getAddress(ESide.PRIMARY));
                preparedStatement.setLong(4, functionMatchData.getAddress(ESide.SECONDARY));
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    n3 = resultSet.getInt(1);
                    n2 = resultSet.getInt(2);
                }
            }
            catch (Throwable var7_12) {
                throwable = var7_12;
                throw var7_12;
            }
            finally {
                if (preparedStatement != null) {
                    if (throwable != null) {
                        try {
                            preparedStatement.close();
                        }
                        catch (Throwable var7_11) {
                            throwable.addSuppressed(var7_11);
                        }
                    } else {
                        preparedStatement.close();
                    }
                }
            }
        }
        catch (SQLException var5_6) {
            throw new SQLException("Couldn't delete non existing basicblock match from database.", var5_6);
        }
        try {
            preparedStatement = this.connection.prepareStatement("DELETE FROM basicblock WHERE id = ? AND functionid = ? ");
            throwable = null;
            try {
                preparedStatement.setInt(1, n2);
                preparedStatement.setInt(2, n3);
                preparedStatement.executeUpdate();
            }
            catch (Throwable var7_14) {
                throwable = var7_14;
                throw var7_14;
            }
            finally {
                if (preparedStatement != null) {
                    if (throwable != null) {
                        try {
                            preparedStatement.close();
                        }
                        catch (Throwable var7_13) {
                            throwable.addSuppressed(var7_13);
                        }
                    } else {
                        preparedStatement.close();
                    }
                }
            }
        }
        catch (SQLException var5_7) {
            String string;
            String string2 = String.valueOf(var5_7.getMessage());
            if (string2.length() != 0) {
                string = "Failed to delete basic block match from database: ".concat(string2);
                throw new SQLException(string);
            }
            string = new String("Failed to delete basic block match from database: ");
            throw new SQLException(string);
        }
        try {
            preparedStatement = this.connection.prepareStatement("DELETE FROM instruction WHERE basicblockid = ?");
            throwable = null;
            try {
                preparedStatement.setInt(1, n2);
                preparedStatement.executeUpdate();
                return;
            }
            catch (Throwable var7_16) {
                throwable = var7_16;
                throw var7_16;
            }
            finally {
                if (preparedStatement != null) {
                    if (throwable != null) {
                        try {
                            preparedStatement.close();
                        }
                        catch (Throwable var7_15) {
                            throwable.addSuppressed(var7_15);
                        }
                    } else {
                        preparedStatement.close();
                    }
                }
            }
        }
        catch (SQLException var5_8) {
            String string;
            String string3 = String.valueOf("Failed to delete instruction matches of removed basic block match from database: ");
            String string4 = String.valueOf(var5_8.getMessage());
            if (string4.length() != 0) {
                string = string3.concat(string4);
                throw new SQLException(string);
            }
            string = new String(string3);
            throw new SQLException(string);
        }
    }

    public String[] getIDBNames() {
        String[] arrstring = new String[2];
        try {
            Statement statement = this.connection.createStatement();
            Throwable throwable = null;
            try {
                ResultSet resultSet = statement.executeQuery("SELECT filename FROM file ORDER BY id");
                int n2 = 0;
                while (resultSet.next()) {
                    arrstring[n2++] = resultSet.getString("filename");
                }
                String[] arrstring2 = arrstring;
                return arrstring2;
            }
            catch (Throwable var4_6) {
                throwable = var4_6;
                throw var4_6;
            }
            finally {
                if (statement != null) {
                    if (throwable != null) {
                        try {
                            statement.close();
                        }
                        catch (Throwable var7_9) {
                            throwable.addSuppressed(var7_9);
                        }
                    } else {
                        statement.close();
                    }
                }
            }
        }
        catch (SQLException var2_3) {
            String string;
            String string2 = String.valueOf(var2_3.getMessage());
            if (string2.length() != 0) {
                string = "Couldn't read IDB names: ".concat(string2);
                throw new SQLException(string);
            }
            string = new String("Couldn't read IDB names: ");
            throw new SQLException(string);
        }
    }

    public void loadBasicblockMatches(FunctionMatchData functionMatchData) {
        if (functionMatchData == null) {
            return;
        }
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT basicblock.address1 AS priBasicblockAddr, basicblock.address2 AS secBasicblockAddr, basicblock.algorithm, instruction.address1 AS priInstructionAddr, instruction.address2 AS secInstructionAddr FROM function INNER JOIN basicblock ON basicblock.functionid = function.id INNER JOIN basicblockalgorithm ON basicblockalgorithm.id = basicblock.algorithm LEFT JOIN instruction ON basicblock.id = instruction.basicblockid WHERE function.address1 = ? AND function.address2 = ? ORDER BY priBasicblockAddr, priInstructionAddr;");
            Throwable throwable = null;
            try {
                preparedStatement.setLong(1, functionMatchData.getAddress(ESide.PRIMARY));
                preparedStatement.setLong(2, functionMatchData.getAddress(ESide.SECONDARY));
                ArrayList<BasicBlockMatchData> arrayList = new ArrayList<BasicBlockMatchData>();
                ArrayList<InstructionMatchData> arrayList2 = new ArrayList<InstructionMatchData>();
                ResultSet resultSet = preparedStatement.executeQuery();
                long l2 = 0;
                long l3 = 0;
                long l4 = 0;
                int n2 = 0;
                long l5 = 0;
                long l6 = 0;
                while (resultSet.next()) {
                    boolean bl2;
                    l3 = resultSet.getLong(1);
                    if (l2 != l3 && !resultSet.isFirst()) {
                        Matches matches = new Matches(arrayList2);
                        BasicBlockMatchData basicBlockMatchData = new BasicBlockMatchData(l2, l4, n2, matches);
                        arrayList.add(basicBlockMatchData);
                        arrayList2 = new ArrayList();
                        l2 = l3;
                        l4 = resultSet.getLong(2);
                        n2 = resultSet.getInt(3);
                    }
                    boolean bl3 = bl2 = resultSet.getObject(4) == null || resultSet.getObject(5) == null;
                    if (!bl2) {
                        l5 = resultSet.getLong(4);
                        l6 = resultSet.getLong(5);
                    }
                    if (resultSet.isFirst()) {
                        l4 = resultSet.getLong(2);
                        n2 = resultSet.getInt(3);
                        l2 = l3;
                        arrayList2 = new ArrayList();
                    }
                    if (bl2) continue;
                    InstructionMatchData instructionMatchData = new InstructionMatchData(l5, l6);
                    arrayList2.add(instructionMatchData);
                }
                Matches matches = new Matches(arrayList2);
                BasicBlockMatchData basicBlockMatchData = new BasicBlockMatchData(l3, l4, n2, matches);
                arrayList.add(basicBlockMatchData);
                functionMatchData.loadBasicblockMatches(arrayList);
                return;
            }
            catch (Throwable var4_7) {
                throwable = var4_7;
                throw var4_7;
            }
            finally {
                if (preparedStatement != null) {
                    if (throwable != null) {
                        try {
                            preparedStatement.close();
                        }
                        catch (Throwable var4_6) {
                            throwable.addSuppressed(var4_6);
                        }
                    } else {
                        preparedStatement.close();
                    }
                }
            }
        }
        catch (SQLException var2_3) {
            String string;
            String string2 = String.valueOf(var2_3.getMessage());
            if (string2.length() != 0) {
                string = "Couldn't read basic block and instruction matches.\n".concat(string2);
                throw new IOException(string);
            }
            string = new String("Couldn't read basic block and instruction matches.\n");
            throw new IOException(string);
        }
    }

    /*
     * Exception decompiling
     */
    public String loadDiffDescription() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public DiffMetaData loadDiffMetaData(File var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [9[TRYBLOCK]], but top level block is 13[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    public IAddressPair loadFunctionDiffAddressPair() {
        PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT function.address1, function.address2 FROM function");
        Throwable throwable = null;
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long l2 = resultSet.getLong(1);
                long l3 = resultSet.getLong(2);
                if (!resultSet.next()) {
                    AddressPair addressPair = new AddressPair(l2, l3);
                    return addressPair;
                }
            }
            throw new SQLException("Illegal BinDiff database state: Function matches must be unique.");
        }
        catch (Throwable var3_4) {
            throwable = var3_4;
            throw var3_4;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var9_8) {
                        throwable.addSuppressed(var9_8);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    public FunctionDiffMetaData loadFunctionDiffMetaData(boolean bl2) {
        DiffMetaData diffMetaData = this.loadDiffMetaData(null);
        if (bl2) return new FunctionDiffMetaData(diffMetaData, null, null, null, null, null, null, null, null);
        IAddressPair iAddressPair = this.loadFunctionDiffAddressPair();
        IAddress iAddress = iAddressPair.getIAddress(ESide.PRIMARY);
        IAddress iAddress2 = iAddressPair.getIAddress(ESide.SECONDARY);
        PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT functionname, functiontype, flowgraphoffset FROM file ORDER BY id");
        Throwable throwable = null;
        try {
            FunctionDiffMetaData functionDiffMetaData;
            String string = null;
            String string2 = null;
            EFunctionType eFunctionType = null;
            EFunctionType eFunctionType2 = null;
            Integer n2 = null;
            Integer n3 = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                string = resultSet.getString("functionname");
                eFunctionType = EFunctionType.getType(resultSet.getInt("functiontype"));
                n2 = resultSet.getInt("flowgraphoffset");
            }
            if (resultSet.next()) {
                string2 = resultSet.getString("functionname");
                eFunctionType2 = EFunctionType.getType(resultSet.getInt("functiontype"));
                n3 = resultSet.getInt("flowgraphoffset");
            }
            if (string == null) throw new SQLException("Failed to load function diff meta data: Primary and secondary function must not be null.");
            if (string2 == null) {
                throw new SQLException("Failed to load function diff meta data: Primary and secondary function must not be null.");
            }
            if (eFunctionType == null) throw new SQLException("Failed to load function diff meta data: Primary and secondary function type must not be null.");
            if (eFunctionType2 == null) {
                throw new SQLException("Failed to load function diff meta data: Primary and secondary function type must not be null.");
            }
            FunctionDiffMetaData functionDiffMetaData2 = functionDiffMetaData = new FunctionDiffMetaData(diffMetaData, iAddress, iAddress2, string, string2, eFunctionType, eFunctionType2, n2, n3);
            return functionDiffMetaData2;
        }
        catch (Throwable var8_9) {
            throwable = var8_9;
            throw var8_9;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var17_18) {
                        throwable.addSuppressed(var17_18);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    public MatchData loadFunctionMatches(Diff diff) {
        DiffMetaData diffMetaData = diff.getMetaData();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        try {
            Statement statement = this.connection.createStatement();
            Throwable throwable = null;
            try {
                Object object;
                ResultSet resultSet = statement.executeQuery("SELECT function.id, function.address1, function.address2, function.similarity, function.confidence, function.flags, function.algorithm, function.basicblocks, function.edges, function.instructions FROM function");
                ArrayList<Object> arrayList = new ArrayList<Object>();
                while (resultSet.next()) {
                    n2 += resultSet.getInt("basicblocks");
                    n3 += resultSet.getInt("edges");
                    n4 += resultSet.getInt("instructions");
                    object = new FunctionMatchData(resultSet.getInt("id"), resultSet.getLong("address1"), resultSet.getLong("address2"), resultSet.getDouble("similarity"), resultSet.getDouble("confidence"), resultSet.getInt("flags"), resultSet.getInt("algorithm"), resultSet.getInt("basicblocks"), resultSet.getInt("edges"), resultSet.getInt("instructions"));
                    arrayList.add(object);
                }
                diffMetaData.setSizeOfMatchedBasicblocks(n2);
                diffMetaData.setSizeOfMatchedJumps(n3);
                diffMetaData.setSizeOfMatchedInstructions(n4);
                object = new MatchData(arrayList, diffMetaData);
                return object;
            }
            catch (Throwable var8_10) {
                throwable = var8_10;
                throw var8_10;
            }
            finally {
                if (statement != null) {
                    if (throwable != null) {
                        try {
                            statement.close();
                        }
                        catch (Throwable var11_13) {
                            throwable.addSuppressed(var11_13);
                        }
                    } else {
                        statement.close();
                    }
                }
            }
        }
        catch (SQLException var6_7) {
            String string;
            String string2 = String.valueOf(var6_7.getMessage());
            if (string2.length() != 0) {
                string = "Couldn't load diff. Reading function matches from database failed: ".concat(string2);
                throw new SQLException(string);
            }
            string = new String("Couldn't load diff. Reading function matches from database failed: ");
            throw new SQLException(string);
        }
    }

    public Map loadMatchedCallAddresses(Diff diff) {
        Object object22;
        HashMap<AddressPair, AddressPair> hashMap = new HashMap<AddressPair, AddressPair>();
        ArrayList<IAddress> arrayList = new ArrayList<IAddress>();
        for (Object object22 : diff.getCallgraph(ESide.PRIMARY).getEdges()) {
            arrayList.add(object22.getSourceInstructionAddr());
        }
        String string = "SELECT function.address1, instruction.address1, function.address2, instruction.address2 FROM function INNER JOIN basicblock ON function.id = basicblock.functionid INNER JOIN instruction ON basicblock.id = instruction.basicblockid WHERE instruction.address1 IN ";
        object22 = new StringBuilder("SELECT function.address1, instruction.address1, function.address2, instruction.address2 FROM function INNER JOIN basicblock ON function.id = basicblock.functionid INNER JOIN instruction ON basicblock.id = instruction.basicblockid WHERE instruction.address1 IN ");
        boolean bl2 = true;
        try {
            long l2;
            long l3;
            long l4;
            long l5;
            Throwable throwable;
            Statement statement;
            statement = this.connection.createStatement();
            throwable = null;
            try {
                for (IAddress object3 : arrayList) {
                    if (bl2) {
                        object22.append("(");
                        bl2 = false;
                    } else {
                        object22.append(",");
                    }
                    l3 = object3.toLong();
                    object22.append(new StringBuilder(20).append(l3).toString());
                    if (object22.length() < 999990) continue;
                    object22.append(")");
                    ResultSet resultSet = statement.executeQuery(object22.toString());
                    Throwable throwable2 = null;
                    try {
                        while (resultSet.next()) {
                            l5 = resultSet.getLong(1);
                            l4 = resultSet.getLong(2);
                            l2 = resultSet.getLong(3);
                            long l6 = resultSet.getLong(4);
                            hashMap.put(new AddressPair(l5, l4), new AddressPair(l2, l6));
                        }
                    }
                    catch (Throwable var13_25) {
                        throwable2 = var13_25;
                        throw var13_25;
                    }
                    finally {
                        if (resultSet != null) {
                            if (throwable2 != null) {
                                try {
                                    resultSet.close();
                                }
                                catch (Throwable var13_24) {
                                    throwable2.addSuppressed(var13_24);
                                }
                            } else {
                                resultSet.close();
                            }
                        }
                    }
                    object22 = new StringBuilder("SELECT function.address1, instruction.address1, function.address2, instruction.address2 FROM function INNER JOIN basicblock ON function.id = basicblock.functionid INNER JOIN instruction ON basicblock.id = instruction.basicblockid WHERE instruction.address1 IN ");
                    bl2 = true;
                }
            }
            catch (Throwable var9_12) {
                throwable = var9_12;
                throw var9_12;
            }
            finally {
                if (statement != null) {
                    if (throwable != null) {
                        try {
                            statement.close();
                        }
                        catch (Throwable var9_11) {
                            throwable.addSuppressed(var9_11);
                        }
                    } else {
                        statement.close();
                    }
                }
            }
            if (bl2) return Collections.unmodifiableMap(hashMap);
            if (object22.length() == "SELECT function.address1, instruction.address1, function.address2, instruction.address2 FROM function INNER JOIN basicblock ON function.id = basicblock.functionid INNER JOIN instruction ON basicblock.id = instruction.basicblockid WHERE instruction.address1 IN ".length()) return Collections.unmodifiableMap(hashMap);
            object22.append(")");
            statement = this.connection.createStatement();
            throwable = null;
            try {
                ResultSet resultSet = statement.executeQuery(object22.toString());
                Throwable throwable3 = null;
                try {
                    while (resultSet.next()) {
                        l3 = resultSet.getLong(1);
                        l5 = resultSet.getLong(2);
                        l4 = resultSet.getLong(3);
                        l2 = resultSet.getLong(4);
                        hashMap.put(new AddressPair(l3, l5), new AddressPair(l4, l2));
                    }
                    return Collections.unmodifiableMap(hashMap);
                }
                catch (Throwable var11_21) {
                    Throwable throwable4 = var11_21;
                    throw var11_21;
                }
                finally {
                    if (resultSet != null) {
                        if (throwable3 != null) {
                            try {
                                resultSet.close();
                            }
                            catch (Throwable var11_20) {
                                throwable3.addSuppressed(var11_20);
                            }
                        } else {
                            resultSet.close();
                        }
                    }
                }
            }
            catch (Throwable var9_14) {
                throwable = var9_14;
                throw var9_14;
            }
            finally {
                if (statement != null) {
                    if (throwable != null) {
                        try {
                            statement.close();
                        }
                        catch (Throwable var9_13) {
                            throwable.addSuppressed(var9_13);
                        }
                    } else {
                        statement.close();
                    }
                }
            }
        }
        catch (SQLException var7_8) {
            String string2;
            String string3 = String.valueOf(var7_8.getMessage());
            if (string3.length() != 0) {
                string2 = "Couldn't read calls matches from database: ".concat(string3);
                throw new SQLException(string2);
            }
            string2 = new String("Couldn't read calls matches from database: ");
            throw new SQLException(string2);
        }
    }

    public void saveDiffDescription(String string) {
        PreparedStatement preparedStatement = this.connection.prepareStatement("UPDATE metadata SET description = ?");
        Throwable throwable = null;
        try {
            preparedStatement.setString(1, string);
            preparedStatement.executeUpdate();
            return;
        }
        catch (Throwable var4_5) {
            throwable = var4_5;
            throw var4_5;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var4_4) {
                        throwable.addSuppressed(var4_4);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    public void setFunctionDiffCounts(RawFunction rawFunction, RawFunction rawFunction2) {
        PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT basicblocks, libbasicblocks, edges, libedges, instructions, libinstructions FROM file ORDER BY id ");
        Throwable throwable = null;
        try {
            ResultSet resultSet;
            Throwable throwable2;
            block24 : {
                block25 : {
                    resultSet = preparedStatement.executeQuery();
                    throwable2 = null;
                    if (resultSet.next()) {
                        rawFunction.setSizeOfBasicblocks(resultSet.getInt("basicblocks") + resultSet.getInt("libbasicblocks"));
                        rawFunction.setSizeOfJumps(resultSet.getInt("edges") + resultSet.getInt("libedges"));
                        rawFunction.setSizeOfInstructions(resultSet.getInt("instructions") + resultSet.getInt("libinstructions"));
                    }
                    if (!resultSet.next()) break block24;
                    rawFunction2.setSizeOfBasicblocks(resultSet.getInt("basicblocks") + resultSet.getInt("libbasicblocks"));
                    rawFunction2.setSizeOfJumps(resultSet.getInt("edges") + resultSet.getInt("libedges"));
                    rawFunction2.setSizeOfInstructions(resultSet.getInt("instructions") + resultSet.getInt("libinstructions"));
                    if (resultSet == null) return;
                    if (throwable2 == null) break block25;
                    try {
                        resultSet.close();
                        return;
                    }
                    catch (Throwable var7_8) {
                        throwable2.addSuppressed(var7_8);
                        return;
                    }
                }
                resultSet.close();
                return;
            }
            try {
                try {
                    throw new SQLException("Invalid matches database state. File table must consist of exactly two records.");
                }
                catch (Throwable var7_10) {
                    throwable2 = var7_10;
                    throw var7_10;
                }
            }
            catch (Throwable var8_11) {
                if (resultSet == null) throw var8_11;
                if (throwable2 == null) {
                    resultSet.close();
                    throw var8_11;
                }
                try {
                    resultSet.close();
                    throw var8_11;
                }
                catch (Throwable var9_12) {
                    throwable2.addSuppressed(var9_12);
                    throw var8_11;
                }
            }
        }
        catch (Throwable var5_6) {
            throwable = var5_6;
            throw var5_6;
        }
        finally {
            if (preparedStatement != null) {
                if (throwable != null) {
                    try {
                        preparedStatement.close();
                    }
                    catch (Throwable var7_9) {
                        throwable.addSuppressed(var7_9);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    public void updateFunctionMatch(long l2, long l3, FunctionMatchData functionMatchData) {
        boolean bl2 = this.connection.getAutoCommit();
        this.connection.setAutoCommit(false);
        try {
            this.deleteBasiblockMatches(l2, l3);
            this.addBasicblockMatches(functionMatchData);
            this.setFunctionMatchCounts(l2, l3, functionMatchData);
            this.connection.commit();
        }
        catch (SQLException var7_5) {
            Logger.logException(var7_5, "Couldn't update function match. Executing rollback.");
            this.connection.rollback();
        }
        this.connection.setAutoCommit(bl2);
    }
}

