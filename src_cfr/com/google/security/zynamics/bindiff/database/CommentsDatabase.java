/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.database;

import com.google.security.zynamics.bindiff.database.SqliteDatabase;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class CommentsDatabase
extends SqliteDatabase {
    private static final String STATEMENT_CREATE_BASICBLOCK_COMMENT_TABLE = "CREATE TABLE IF NOT EXISTS bd_basicblockComments (pe_hash VARCHAR(40) NOT NULL, functionAddr BIGINT NOT NULL, basicblockAddr BIGINT NOT NULL, comment long VARCHAR NOT NULL, primary key (pe_hash, functionAddr, basicblockAddr))";
    private static final String STATEMENT_CREATE_INSTRUCTION_COMMENT_TABLE = "CREATE TABLE IF NOT EXISTS bd_instructionComments(pe_hash VARCHAR(40) NOT NULL, functionAddr BIGINT NOT NULL, instructionAddr BIGINT NOT NULL, placement SMALLINT NOT NULL, comment long VARCHAR NOT NULL, PRIMARY KEY (pe_hash, functionAddr, instructionAddr, placement))";

    public CommentsDatabase(Workspace workspace, boolean bl2) {
        super(workspace.getWorkspaceFile());
        if (!bl2) return;
        this.createTables();
    }

    private void createTables() {
        Throwable throwable;
        Statement statement;
        try {
            statement = this.connection.createStatement();
            throwable = null;
            try {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS bd_basicblockComments (pe_hash VARCHAR(40) NOT NULL, functionAddr BIGINT NOT NULL, basicblockAddr BIGINT NOT NULL, comment long VARCHAR NOT NULL, primary key (pe_hash, functionAddr, basicblockAddr))");
            }
            catch (Throwable var3_6) {
                throwable = var3_6;
                throw var3_6;
            }
            finally {
                if (statement != null) {
                    if (throwable != null) {
                        try {
                            statement.close();
                        }
                        catch (Throwable var3_5) {
                            throwable.addSuppressed(var3_5);
                        }
                    } else {
                        statement.close();
                    }
                }
            }
        }
        catch (SQLException var1_2) {
            String string;
            String string2 = String.valueOf(var1_2.getMessage());
            if (string2.length() != 0) {
                string = "Could not create basic block comment tables: ".concat(string2);
                throw new SQLException(string, var1_2);
            }
            string = new String("Could not create basic block comment tables: ");
            throw new SQLException(string, var1_2);
        }
        try {
            statement = this.connection.createStatement();
            throwable = null;
            try {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS bd_instructionComments(pe_hash VARCHAR(40) NOT NULL, functionAddr BIGINT NOT NULL, instructionAddr BIGINT NOT NULL, placement SMALLINT NOT NULL, comment long VARCHAR NOT NULL, PRIMARY KEY (pe_hash, functionAddr, instructionAddr, placement))");
                return;
            }
            catch (Throwable var3_8) {
                throwable = var3_8;
                throw var3_8;
            }
            finally {
                if (statement != null) {
                    if (throwable != null) {
                        try {
                            statement.close();
                        }
                        catch (Throwable var3_7) {
                            throwable.addSuppressed(var3_7);
                        }
                    } else {
                        statement.close();
                    }
                }
            }
        }
        catch (SQLException var1_3) {
            String string;
            String string3 = String.valueOf(var1_3.getMessage());
            if (string3.length() != 0) {
                string = "Could not create instruction comment tables: ".concat(string3);
                throw new SQLException(string, var1_3);
            }
            string = new String("Could not create instruction comment tables: ");
            throw new SQLException(string, var1_3);
        }
    }

    public Map readBasicblockComments(String string, IAddress iAddress) {
        HashMap<CAddress, String> hashMap = new HashMap<CAddress, String>();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT basicblockAddr, comment FROM bd_basicblockComments WHERE pe_hash = ? AND functionAddr = ?");
            Throwable throwable = null;
            try {
                preparedStatement.setString(1, string);
                preparedStatement.setLong(2, iAddress.toLong());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    CAddress cAddress = new CAddress(resultSet.getLong("basicblockAddr"));
                    String string2 = resultSet.getString("comment");
                    hashMap.put(cAddress, string2);
                }
                return hashMap;
            }
            catch (Throwable var6_9) {
                throwable = var6_9;
                throw var6_9;
            }
            finally {
                if (preparedStatement != null) {
                    if (throwable != null) {
                        try {
                            preparedStatement.close();
                        }
                        catch (Throwable var6_8) {
                            throwable.addSuppressed(var6_8);
                        }
                    } else {
                        preparedStatement.close();
                    }
                }
            }
        }
        catch (SQLException var4_5) {
            String string3;
            String string4 = String.valueOf(var4_5.getMessage());
            if (string4.length() != 0) {
                string3 = "Couldn't read basic block comments: ".concat(string4);
                throw new SQLException(string3, var4_5);
            }
            string3 = new String("Couldn't read basic block comments: ");
            throw new SQLException(string3, var4_5);
        }
    }

    public Map readFunctionComments(String string) {
        HashMap<CAddress, String> hashMap = new HashMap<CAddress, String>();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT functionAddr, comment FROM bd_functionComments WHERE pe_hash = ?");
            Throwable throwable = null;
            try {
                preparedStatement.setString(1, string);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    CAddress cAddress = new CAddress(resultSet.getLong("functionAddr"));
                    String string2 = resultSet.getString("comment");
                    hashMap.put(cAddress, string2);
                }
                return hashMap;
            }
            catch (Throwable var5_8) {
                throwable = var5_8;
                throw var5_8;
            }
            finally {
                if (preparedStatement != null) {
                    if (throwable != null) {
                        try {
                            preparedStatement.close();
                        }
                        catch (Throwable var5_7) {
                            throwable.addSuppressed(var5_7);
                        }
                    } else {
                        preparedStatement.close();
                    }
                }
            }
        }
        catch (SQLException var3_4) {
            String string3;
            String string4 = String.valueOf(var3_4.getMessage());
            if (string4.length() != 0) {
                string3 = "Couldn't read function comments: ".concat(string4);
                throw new SQLException(string3, var3_4);
            }
            string3 = new String("Couldn't read function comments: ");
            throw new SQLException(string3, var3_4);
        }
    }

    public Map readInstructionComments(String string, IAddress iAddress) {
        HashMap<Pair, String> hashMap = new HashMap<Pair, String>();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT instructionAddr, placement, comment FROM bd_instructionComments WHERE pe_hash = ? AND functionAddr = ?");
            Throwable throwable = null;
            try {
                preparedStatement.setString(1, string);
                preparedStatement.setLong(2, iAddress.toLong());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    CAddress cAddress = new CAddress(resultSet.getLong("instructionAddr"));
                    ECommentPlacement eCommentPlacement = ECommentPlacement.valueOf(resultSet.getInt("placement"));
                    String string2 = resultSet.getString("comment");
                    Pair pair = Pair.make(cAddress, (Object)eCommentPlacement);
                    hashMap.put(pair, string2);
                }
                return hashMap;
            }
            catch (Throwable var6_9) {
                throwable = var6_9;
                throw var6_9;
            }
            finally {
                if (preparedStatement != null) {
                    if (throwable != null) {
                        try {
                            preparedStatement.close();
                        }
                        catch (Throwable var6_8) {
                            throwable.addSuppressed(var6_8);
                        }
                    } else {
                        preparedStatement.close();
                    }
                }
            }
        }
        catch (SQLException var4_5) {
            String string3;
            String string4 = String.valueOf(var4_5.getMessage());
            if (string4.length() != 0) {
                string3 = "Couldn't read instruction comments: ".concat(string4);
                throw new SQLException(string3, var4_5);
            }
            string3 = new String("Couldn't read instruction comments: ");
            throw new SQLException(string3, var4_5);
        }
    }

    public void writeBasicblockComment(String string, IAddress iAddress, IAddress iAddress2, String string2) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT COUNT(*) AS counter FROM bd_basicblockComments WHERE pe_hash = ? AND functionAddr = ? AND basicblockAddr = ?");
            Throwable throwable = null;
            try {
                preparedStatement.setString(1, string);
                preparedStatement.setLong(2, iAddress.toLong());
                preparedStatement.setLong(3, iAddress2.toLong());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) return;
                if (resultSet.getInt("counter") == 0) {
                    if (string2.isEmpty()) return;
                    PreparedStatement preparedStatement2 = this.connection.prepareStatement("INSERT INTO bd_basicblockComments VALUES (?, ?, ?, ?)");
                    Throwable throwable2 = null;
                    try {
                        preparedStatement2.setString(1, string);
                        preparedStatement2.setLong(2, iAddress.toLong());
                        preparedStatement2.setLong(3, iAddress2.toLong());
                        preparedStatement2.setString(4, string2);
                        preparedStatement2.executeUpdate();
                        return;
                    }
                    catch (Throwable var10_18) {
                        throwable2 = var10_18;
                        throw var10_18;
                    }
                    finally {
                        if (preparedStatement2 != null) {
                            if (throwable2 != null) {
                                try {
                                    preparedStatement2.close();
                                }
                                catch (Throwable var10_17) {
                                    throwable2.addSuppressed(var10_17);
                                }
                            } else {
                                preparedStatement2.close();
                            }
                        }
                    }
                }
                if (string2.isEmpty()) {
                    PreparedStatement preparedStatement3 = this.connection.prepareStatement("DELETE FROM bd_basicblockComments WHERE pe_hash = ? AND functionAddr = ? AND basicblockAddr = ?");
                    Throwable throwable3 = null;
                    try {
                        preparedStatement3.setString(1, string);
                        preparedStatement3.setLong(2, iAddress.toLong());
                        preparedStatement3.setLong(3, iAddress2.toLong());
                        preparedStatement3.executeUpdate();
                        return;
                    }
                    catch (Throwable var10_20) {
                        throwable3 = var10_20;
                        throw var10_20;
                    }
                    finally {
                        if (preparedStatement3 != null) {
                            if (throwable3 != null) {
                                try {
                                    preparedStatement3.close();
                                }
                                catch (Throwable var10_19) {
                                    throwable3.addSuppressed(var10_19);
                                }
                            } else {
                                preparedStatement3.close();
                            }
                        }
                    }
                }
                PreparedStatement preparedStatement4 = this.connection.prepareStatement("UPDATE bd_basicblockComments SET comment = ? WHERE pe_hash = ? AND functionAddr = ? AND basicblockAddr = ?");
                Throwable throwable4 = null;
                try {
                    preparedStatement4.setString(1, string2);
                    preparedStatement4.setString(2, string);
                    preparedStatement4.setLong(3, iAddress.toLong());
                    preparedStatement4.setLong(4, iAddress2.toLong());
                    preparedStatement4.executeUpdate();
                    return;
                }
                catch (Throwable var10_22) {
                    throwable4 = var10_22;
                    throw var10_22;
                }
                finally {
                    if (preparedStatement4 != null) {
                        if (throwable4 != null) {
                            try {
                                preparedStatement4.close();
                            }
                            catch (Throwable var10_21) {
                                throwable4.addSuppressed(var10_21);
                            }
                        } else {
                            preparedStatement4.close();
                        }
                    }
                }
            }
            catch (Throwable var7_10) {
                throwable = var7_10;
                throw var7_10;
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
        catch (SQLException var5_6) {
            String string3;
            String string4 = String.valueOf(var5_6.getMessage());
            if (string4.length() != 0) {
                string3 = "Couldn't write basic block comment into database: ".concat(string4);
                throw new SQLException(string3, var5_6);
            }
            string3 = new String("Couldn't write basic block comment into database: ");
            throw new SQLException(string3, var5_6);
        }
    }

    public void writeFunctionComment(String string, IAddress iAddress, String string2) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT COUNT(*) AS counter FROM bd_functionComments WHERE pe_hash = ? AND functionAddr = ?");
            Throwable throwable = null;
            try {
                preparedStatement.setString(1, string);
                preparedStatement.setLong(2, iAddress.toLong());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    return;
                }
                if (resultSet.getInt("counter") == 0) {
                    if (string2.isEmpty()) return;
                    PreparedStatement preparedStatement2 = this.connection.prepareStatement("INSERT INTO bd_functionComments VALUES (?, ?, ?)");
                    Throwable throwable2 = null;
                    try {
                        preparedStatement2.setString(1, string);
                        preparedStatement2.setLong(2, iAddress.toLong());
                        preparedStatement2.setString(3, string2);
                        preparedStatement2.executeUpdate();
                        return;
                    }
                    catch (Throwable var9_18) {
                        throwable2 = var9_18;
                        throw var9_18;
                    }
                    finally {
                        if (preparedStatement2 != null) {
                            if (throwable2 != null) {
                                try {
                                    preparedStatement2.close();
                                }
                                catch (Throwable var9_17) {
                                    throwable2.addSuppressed(var9_17);
                                }
                            } else {
                                preparedStatement2.close();
                            }
                        }
                    }
                }
                if (string2.isEmpty()) {
                    PreparedStatement preparedStatement3 = this.connection.prepareStatement("DELETE FROM bd_functionComments WHERE pe_hash = ? AND functionAddr = ?");
                    Throwable throwable3 = null;
                    try {
                        preparedStatement3.setString(1, string);
                        preparedStatement3.setLong(2, iAddress.toLong());
                        preparedStatement3.executeUpdate();
                        return;
                    }
                    catch (Throwable var9_20) {
                        throwable3 = var9_20;
                        throw var9_20;
                    }
                    finally {
                        if (preparedStatement3 != null) {
                            if (throwable3 != null) {
                                try {
                                    preparedStatement3.close();
                                }
                                catch (Throwable var9_19) {
                                    throwable3.addSuppressed(var9_19);
                                }
                            } else {
                                preparedStatement3.close();
                            }
                        }
                    }
                }
                PreparedStatement preparedStatement4 = this.connection.prepareStatement("UPDATE bd_functionComments SET comment = ? WHERE pe_hash = ? AND functionAddr = ?");
                Throwable throwable4 = null;
                try {
                    preparedStatement4.setString(1, string2);
                    preparedStatement4.setString(2, string);
                    preparedStatement4.setLong(3, iAddress.toLong());
                    preparedStatement4.executeUpdate();
                    return;
                }
                catch (Throwable var9_22) {
                    throwable4 = var9_22;
                    throw var9_22;
                }
                finally {
                    if (preparedStatement4 != null) {
                        if (throwable4 != null) {
                            try {
                                preparedStatement4.close();
                            }
                            catch (Throwable var9_21) {
                                throwable4.addSuppressed(var9_21);
                            }
                        } else {
                            preparedStatement4.close();
                        }
                    }
                }
            }
            catch (Throwable var6_9) {
                throwable = var6_9;
                throw var6_9;
            }
            finally {
                if (preparedStatement != null) {
                    if (throwable != null) {
                        try {
                            preparedStatement.close();
                        }
                        catch (Throwable var7_10) {
                            throwable.addSuppressed(var7_10);
                        }
                    } else {
                        preparedStatement.close();
                    }
                }
            }
        }
        catch (SQLException var4_5) {
            String string3;
            String string4 = String.valueOf(var4_5.getMessage());
            if (string4.length() != 0) {
                string3 = "Couldn't save function comment in database: ".concat(string4);
                throw new SQLException(string3, var4_5);
            }
            string3 = new String("Couldn't save function comment in database: ");
            throw new SQLException(string3, var4_5);
        }
    }

    public void writeInstructionComment(String string, IAddress iAddress, IAddress iAddress2, ECommentPlacement eCommentPlacement, String string2) {
        try {
            if (!string2.isEmpty()) {
                PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT OR REPLACE INTO bd_instructionComments (pe_hash, functionAddr, instructionAddr, placement, comment) VALUES (?, ?, ?, ?, ?)");
                Throwable throwable = null;
                try {
                    preparedStatement.setString(1, string);
                    preparedStatement.setLong(2, iAddress.toLong());
                    preparedStatement.setLong(3, iAddress2.toLong());
                    preparedStatement.setShort(4, (short)ECommentPlacement.getOrdinal(eCommentPlacement));
                    preparedStatement.setString(5, string2);
                    preparedStatement.executeUpdate();
                    return;
                }
                catch (Throwable var8_12) {
                    throwable = var8_12;
                    throw var8_12;
                }
                finally {
                    if (preparedStatement != null) {
                        if (throwable != null) {
                            try {
                                preparedStatement.close();
                            }
                            catch (Throwable var8_11) {
                                throwable.addSuppressed(var8_11);
                            }
                        } else {
                            preparedStatement.close();
                        }
                    }
                }
            }
            PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE FROM bd_instructionComments WHERE pe_hash = ? AND functionAddr = ? AND instructionAddr = ? AND placement = ?");
            Throwable throwable = null;
            try {
                preparedStatement.setString(1, string);
                preparedStatement.setLong(2, iAddress.toLong());
                preparedStatement.setLong(3, iAddress2.toLong());
                preparedStatement.setShort(4, (short)ECommentPlacement.getOrdinal(eCommentPlacement));
                preparedStatement.executeUpdate();
                return;
            }
            catch (Throwable var8_14) {
                throwable = var8_14;
                throw var8_14;
            }
            finally {
                if (preparedStatement != null) {
                    if (throwable != null) {
                        try {
                            preparedStatement.close();
                        }
                        catch (Throwable var8_13) {
                            throwable.addSuppressed(var8_13);
                        }
                    } else {
                        preparedStatement.close();
                    }
                }
            }
        }
        catch (SQLException var6_8) {
            String string3;
            String string4 = String.valueOf(var6_8.getMessage());
            if (string4.length() != 0) {
                string3 = "Couldn't store instruction comment in database: ".concat(string4);
                throw new SQLException(string3, var6_8);
            }
            string3 = new String("Couldn't store instruction comment in database: ");
            throw new SQLException(string3, var6_8);
        }
    }
}

