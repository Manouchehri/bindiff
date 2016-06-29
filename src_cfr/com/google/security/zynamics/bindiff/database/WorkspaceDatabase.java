/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.database;

import com.google.security.zynamics.bindiff.database.SqliteDatabase;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkspaceDatabase
extends SqliteDatabase {
    private static final String STATEMENT_CREATE_METADATA_TABLE = "CREATE TABLE IF NOT EXISTS metadata (version INT NOT NULL)";
    private static final String STATEMENT_CREATE_DIFFS_TABLE = "CREATE TABLE IF NOT EXISTS diffs (matchesDbPath VARCHAR NOT NULL, isfunctiondiff NUMERIC NOT NULL DEFAULT 0)";

    public WorkspaceDatabase(File file) {
        super(file);
        this.createTables();
    }

    private void setFormatVersionNumber() {
        PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO metadata (version) VALUES (?)");
        Throwable throwable = null;
        try {
            preparedStatement.setInt(1, 1);
            preparedStatement.executeUpdate();
            return;
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
                    catch (Throwable var3_3) {
                        throwable.addSuppressed(var3_3);
                    }
                } else {
                    preparedStatement.close();
                }
            }
        }
    }

    private void createTables() {
        Throwable throwable;
        Statement statement;
        statement = this.connection.createStatement();
        throwable = null;
        try {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS metadata (version INT NOT NULL)");
            this.setFormatVersionNumber();
        }
        catch (Throwable var3_4) {
            throwable = var3_4;
            throw var3_4;
        }
        finally {
            if (statement != null) {
                if (throwable != null) {
                    try {
                        statement.close();
                    }
                    catch (Throwable var3_3) {
                        throwable.addSuppressed(var3_3);
                    }
                } else {
                    statement.close();
                }
            }
        }
        statement = this.connection.createStatement();
        throwable = null;
        try {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS diffs (matchesDbPath VARCHAR NOT NULL, isfunctiondiff NUMERIC NOT NULL DEFAULT 0)");
            return;
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

    public List loadDiffPaths(boolean bl2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT matchesDbPath FROM diffs WHERE isfunctiondiff = ?");
            Throwable throwable = null;
            try {
                preparedStatement.setBoolean(1, bl2);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    arrayList.add(resultSet.getString("matchesDbPath"));
                }
                return arrayList;
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
            Logger.logException(var3_4, var3_4.getMessage());
            if (!bl2) throw new SQLException("Failed to load workspace: Couldn't load diff paths.", var3_4);
            throw new SQLException("Failed to load workspace: Couldn't load function diff paths.", var3_4);
        }
    }

    public void saveWorkspace(Workspace workspace) {
        PreparedStatement preparedStatement;
        Throwable throwable;
        this.connection.setAutoCommit(false);
        try {
            preparedStatement = this.connection.prepareStatement("DELETE FROM diffs");
            throwable = null;
            try {
                preparedStatement.executeUpdate();
                this.connection.commit();
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
            this.connection.rollback();
            Logger.logException(var2_3, var2_3.getMessage());
            String string2 = String.valueOf(var2_3.getMessage());
            if (string2.length() != 0) {
                string = "Failed to write to workspace file. Couldn't delete old entries: ".concat(string2);
                throw new SQLException(string, var2_3);
            }
            string = new String("Failed to write to workspace file. Couldn't delete old entries: ");
            throw new SQLException(string, var2_3);
        }
        finally {
            this.connection.setAutoCommit(true);
        }
        this.connection.setAutoCommit(false);
        try {
            preparedStatement = this.connection.prepareStatement("INSERT INTO diffs (matchesDbPath, isfunctiondiff) VALUES (?, ?)");
            throwable = null;
            try {
                String string = FileUtils.ensureTrailingSlash(workspace.getWorkspaceDirPath());
                for (Diff diff : workspace.getDiffList()) {
                    String string3 = diff.getMatchesDatabase().getAbsolutePath();
                    if (string3.startsWith(string)) {
                        string3 = string3.substring(string.length());
                    }
                    preparedStatement.setString(1, string3);
                    preparedStatement.setInt(2, !diff.isFunctionDiff() ? 0 : 1);
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
                this.connection.commit();
                return;
            }
            catch (Throwable var4_10) {
                throwable = var4_10;
                throw var4_10;
            }
            finally {
                if (preparedStatement != null) {
                    if (throwable != null) {
                        try {
                            preparedStatement.close();
                        }
                        catch (Throwable var4_9) {
                            throwable.addSuppressed(var4_9);
                        }
                    } else {
                        preparedStatement.close();
                    }
                }
            }
        }
        catch (SQLException var2_4) {
            String string;
            this.connection.rollback();
            Logger.logException(var2_4, var2_4.getMessage());
            String string4 = String.valueOf(var2_4.getMessage());
            if (string4.length() != 0) {
                string = "Failed to save workspace file. Couldn't write new entries: ".concat(string4);
                throw new SQLException(string, var2_4);
            }
            string = new String("Failed to save workspace file. Couldn't write new entries: ");
            throw new SQLException(string, var2_4);
        }
        finally {
            this.connection.setAutoCommit(true);
        }
    }
}

