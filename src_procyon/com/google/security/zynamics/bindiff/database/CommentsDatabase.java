package com.google.security.zynamics.bindiff.database;

import com.google.security.zynamics.bindiff.project.*;
import java.util.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.sql.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class CommentsDatabase extends SqliteDatabase
{
    private static final String STATEMENT_CREATE_BASICBLOCK_COMMENT_TABLE = "CREATE TABLE IF NOT EXISTS bd_basicblockComments (pe_hash VARCHAR(40) NOT NULL, functionAddr BIGINT NOT NULL, basicblockAddr BIGINT NOT NULL, comment long VARCHAR NOT NULL, primary key (pe_hash, functionAddr, basicblockAddr))";
    private static final String STATEMENT_CREATE_INSTRUCTION_COMMENT_TABLE = "CREATE TABLE IF NOT EXISTS bd_instructionComments(pe_hash VARCHAR(40) NOT NULL, functionAddr BIGINT NOT NULL, instructionAddr BIGINT NOT NULL, placement SMALLINT NOT NULL, comment long VARCHAR NOT NULL, PRIMARY KEY (pe_hash, functionAddr, instructionAddr, placement))";
    
    public CommentsDatabase(final Workspace workspace, final boolean b) {
        super(workspace.getWorkspaceFile());
        if (b) {
            this.createTables();
        }
    }
    
    private void createTables() {
        try (final Statement statement = this.connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS bd_basicblockComments (pe_hash VARCHAR(40) NOT NULL, functionAddr BIGINT NOT NULL, basicblockAddr BIGINT NOT NULL, comment long VARCHAR NOT NULL, primary key (pe_hash, functionAddr, basicblockAddr))");
        }
        catch (SQLException ex) {
            final String s = "Could not create basic block comment tables: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s.concat(value) : new String(s), ex);
        }
        try (final Statement statement2 = this.connection.createStatement()) {
            statement2.executeUpdate("CREATE TABLE IF NOT EXISTS bd_instructionComments(pe_hash VARCHAR(40) NOT NULL, functionAddr BIGINT NOT NULL, instructionAddr BIGINT NOT NULL, placement SMALLINT NOT NULL, comment long VARCHAR NOT NULL, PRIMARY KEY (pe_hash, functionAddr, instructionAddr, placement))");
        }
        catch (SQLException ex2) {
            final String s2 = "Could not create instruction comment tables: ";
            final String value2 = String.valueOf(ex2.getMessage());
            throw new SQLException((value2.length() != 0) ? s2.concat(value2) : new String(s2), ex2);
        }
    }
    
    public Map readBasicblockComments(final String s, final IAddress address) {
        final HashMap<CAddress, String> hashMap = new HashMap<CAddress, String>();
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT basicblockAddr, comment FROM bd_basicblockComments WHERE pe_hash = ? AND functionAddr = ?")) {
            prepareStatement.setString(1, s);
            prepareStatement.setLong(2, address.toLong());
            final ResultSet executeQuery = prepareStatement.executeQuery();
            while (executeQuery.next()) {
                hashMap.put(new CAddress(executeQuery.getLong("basicblockAddr")), executeQuery.getString("comment"));
            }
        }
        catch (SQLException ex) {
            final String s2 = "Couldn't read basic block comments: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s2.concat(value) : new String(s2), ex);
        }
        return hashMap;
    }
    
    public Map readFunctionComments(final String s) {
        final HashMap<CAddress, String> hashMap = new HashMap<CAddress, String>();
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT functionAddr, comment FROM bd_functionComments WHERE pe_hash = ?")) {
            prepareStatement.setString(1, s);
            final ResultSet executeQuery = prepareStatement.executeQuery();
            while (executeQuery.next()) {
                hashMap.put(new CAddress(executeQuery.getLong("functionAddr")), executeQuery.getString("comment"));
            }
        }
        catch (SQLException ex) {
            final String s2 = "Couldn't read function comments: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s2.concat(value) : new String(s2), ex);
        }
        return hashMap;
    }
    
    public Map readInstructionComments(final String s, final IAddress address) {
        final HashMap<Pair, String> hashMap = new HashMap<Pair, String>();
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT instructionAddr, placement, comment FROM bd_instructionComments WHERE pe_hash = ? AND functionAddr = ?")) {
            prepareStatement.setString(1, s);
            prepareStatement.setLong(2, address.toLong());
            final ResultSet executeQuery = prepareStatement.executeQuery();
            while (executeQuery.next()) {
                hashMap.put(Pair.make(new CAddress(executeQuery.getLong("instructionAddr")), ECommentPlacement.valueOf(executeQuery.getInt("placement"))), executeQuery.getString("comment"));
            }
        }
        catch (SQLException ex) {
            final String s2 = "Couldn't read instruction comments: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s2.concat(value) : new String(s2), ex);
        }
        return hashMap;
    }
    
    public void writeBasicblockComment(final String s, final IAddress address, final IAddress address2, final String s2) {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT COUNT(*) AS counter FROM bd_basicblockComments WHERE pe_hash = ? AND functionAddr = ? AND basicblockAddr = ?")) {
            prepareStatement.setString(1, s);
            prepareStatement.setLong(2, address.toLong());
            prepareStatement.setLong(3, address2.toLong());
            final ResultSet executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                if (executeQuery.getInt("counter") == 0) {
                    if (!s2.isEmpty()) {
                        try (final PreparedStatement prepareStatement2 = this.connection.prepareStatement("INSERT INTO bd_basicblockComments VALUES (?, ?, ?, ?)")) {
                            prepareStatement2.setString(1, s);
                            prepareStatement2.setLong(2, address.toLong());
                            prepareStatement2.setLong(3, address2.toLong());
                            prepareStatement2.setString(4, s2);
                            prepareStatement2.executeUpdate();
                        }
                    }
                }
                else if (s2.isEmpty()) {
                    try (final PreparedStatement prepareStatement3 = this.connection.prepareStatement("DELETE FROM bd_basicblockComments WHERE pe_hash = ? AND functionAddr = ? AND basicblockAddr = ?")) {
                        prepareStatement3.setString(1, s);
                        prepareStatement3.setLong(2, address.toLong());
                        prepareStatement3.setLong(3, address2.toLong());
                        prepareStatement3.executeUpdate();
                    }
                }
                else {
                    try (final PreparedStatement prepareStatement4 = this.connection.prepareStatement("UPDATE bd_basicblockComments SET comment = ? WHERE pe_hash = ? AND functionAddr = ? AND basicblockAddr = ?")) {
                        prepareStatement4.setString(1, s2);
                        prepareStatement4.setString(2, s);
                        prepareStatement4.setLong(3, address.toLong());
                        prepareStatement4.setLong(4, address2.toLong());
                        prepareStatement4.executeUpdate();
                    }
                }
            }
        }
        catch (SQLException ex) {
            final String s3 = "Couldn't write basic block comment into database: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s3.concat(value) : new String(s3), ex);
        }
    }
    
    public void writeFunctionComment(final String s, final IAddress address, final String s2) {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT COUNT(*) AS counter FROM bd_functionComments WHERE pe_hash = ? AND functionAddr = ?")) {
            prepareStatement.setString(1, s);
            prepareStatement.setLong(2, address.toLong());
            final ResultSet executeQuery = prepareStatement.executeQuery();
            if (!executeQuery.next()) {
                return;
            }
            if (executeQuery.getInt("counter") == 0) {
                if (!s2.isEmpty()) {
                    try (final PreparedStatement prepareStatement2 = this.connection.prepareStatement("INSERT INTO bd_functionComments VALUES (?, ?, ?)")) {
                        prepareStatement2.setString(1, s);
                        prepareStatement2.setLong(2, address.toLong());
                        prepareStatement2.setString(3, s2);
                        prepareStatement2.executeUpdate();
                    }
                }
            }
            else if (s2.isEmpty()) {
                try (final PreparedStatement prepareStatement3 = this.connection.prepareStatement("DELETE FROM bd_functionComments WHERE pe_hash = ? AND functionAddr = ?")) {
                    prepareStatement3.setString(1, s);
                    prepareStatement3.setLong(2, address.toLong());
                    prepareStatement3.executeUpdate();
                }
            }
            else {
                try (final PreparedStatement prepareStatement4 = this.connection.prepareStatement("UPDATE bd_functionComments SET comment = ? WHERE pe_hash = ? AND functionAddr = ?")) {
                    prepareStatement4.setString(1, s2);
                    prepareStatement4.setString(2, s);
                    prepareStatement4.setLong(3, address.toLong());
                    prepareStatement4.executeUpdate();
                }
            }
        }
        catch (SQLException ex) {
            final String s3 = "Couldn't save function comment in database: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s3.concat(value) : new String(s3), ex);
        }
    }
    
    public void writeInstructionComment(final String s, final IAddress address, final IAddress address2, final ECommentPlacement eCommentPlacement, final String s2) {
        try {
            if (!s2.isEmpty()) {
                try (final PreparedStatement prepareStatement = this.connection.prepareStatement("INSERT OR REPLACE INTO bd_instructionComments (pe_hash, functionAddr, instructionAddr, placement, comment) VALUES (?, ?, ?, ?, ?)")) {
                    prepareStatement.setString(1, s);
                    prepareStatement.setLong(2, address.toLong());
                    prepareStatement.setLong(3, address2.toLong());
                    prepareStatement.setShort(4, (short)ECommentPlacement.getOrdinal(eCommentPlacement));
                    prepareStatement.setString(5, s2);
                    prepareStatement.executeUpdate();
                }
            }
            else {
                try (final PreparedStatement prepareStatement2 = this.connection.prepareStatement("DELETE FROM bd_instructionComments WHERE pe_hash = ? AND functionAddr = ? AND instructionAddr = ? AND placement = ?")) {
                    prepareStatement2.setString(1, s);
                    prepareStatement2.setLong(2, address.toLong());
                    prepareStatement2.setLong(3, address2.toLong());
                    prepareStatement2.setShort(4, (short)ECommentPlacement.getOrdinal(eCommentPlacement));
                    prepareStatement2.executeUpdate();
                }
            }
        }
        catch (SQLException ex) {
            final String s3 = "Couldn't store instruction comment in database: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s3.concat(value) : new String(s3), ex);
        }
    }
}
