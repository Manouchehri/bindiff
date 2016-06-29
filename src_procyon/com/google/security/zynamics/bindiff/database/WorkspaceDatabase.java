package com.google.security.zynamics.bindiff.database;

import java.io.*;
import com.google.security.zynamics.bindiff.log.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;

public class WorkspaceDatabase extends SqliteDatabase
{
    private static final String STATEMENT_CREATE_METADATA_TABLE = "CREATE TABLE IF NOT EXISTS metadata (version INT NOT NULL)";
    private static final String STATEMENT_CREATE_DIFFS_TABLE = "CREATE TABLE IF NOT EXISTS diffs (matchesDbPath VARCHAR NOT NULL, isfunctiondiff NUMERIC NOT NULL DEFAULT 0)";
    
    public WorkspaceDatabase(final File file) {
        super(file);
        this.createTables();
    }
    
    private void setFormatVersionNumber() {
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("INSERT INTO metadata (version) VALUES (?)")) {
            prepareStatement.setInt(1, 1);
            prepareStatement.executeUpdate();
        }
    }
    
    private void createTables() {
        try (final Statement statement = this.connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS metadata (version INT NOT NULL)");
            this.setFormatVersionNumber();
        }
        try (final Statement statement2 = this.connection.createStatement()) {
            statement2.executeUpdate("CREATE TABLE IF NOT EXISTS diffs (matchesDbPath VARCHAR NOT NULL, isfunctiondiff NUMERIC NOT NULL DEFAULT 0)");
        }
    }
    
    public List loadDiffPaths(final boolean b) {
        final ArrayList<String> list = new ArrayList<String>();
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT matchesDbPath FROM diffs WHERE isfunctiondiff = ?")) {
            prepareStatement.setBoolean(1, b);
            final ResultSet executeQuery = prepareStatement.executeQuery();
            while (executeQuery.next()) {
                list.add(executeQuery.getString("matchesDbPath"));
            }
        }
        catch (SQLException ex) {
            Logger.logException(ex, ex.getMessage());
            if (b) {
                throw new SQLException("Failed to load workspace: Couldn't load function diff paths.", ex);
            }
            throw new SQLException("Failed to load workspace: Couldn't load diff paths.", ex);
        }
        return list;
    }
    
    public void saveWorkspace(final Workspace workspace) {
        this.connection.setAutoCommit(false);
        try (final PreparedStatement prepareStatement = this.connection.prepareStatement("DELETE FROM diffs")) {
            prepareStatement.executeUpdate();
            this.connection.commit();
        }
        catch (SQLException ex) {
            this.connection.rollback();
            Logger.logException(ex, ex.getMessage());
            final String s = "Failed to write to workspace file. Couldn't delete old entries: ";
            final String value = String.valueOf(ex.getMessage());
            throw new SQLException((value.length() != 0) ? s.concat(value) : new String(s), ex);
        }
        finally {
            this.connection.setAutoCommit(true);
        }
        this.connection.setAutoCommit(false);
        try (final PreparedStatement prepareStatement2 = this.connection.prepareStatement("INSERT INTO diffs (matchesDbPath, isfunctiondiff) VALUES (?, ?)")) {
            final String ensureTrailingSlash = FileUtils.ensureTrailingSlash(workspace.getWorkspaceDirPath());
            for (final Diff diff : workspace.getDiffList()) {
                String s2 = diff.getMatchesDatabase().getAbsolutePath();
                if (s2.startsWith(ensureTrailingSlash)) {
                    s2 = s2.substring(ensureTrailingSlash.length());
                }
                prepareStatement2.setString(1, s2);
                prepareStatement2.setInt(2, diff.isFunctionDiff() ? 1 : 0);
                prepareStatement2.addBatch();
            }
            prepareStatement2.executeBatch();
            this.connection.commit();
        }
        catch (SQLException ex2) {
            this.connection.rollback();
            Logger.logException(ex2, ex2.getMessage());
            final String s3 = "Failed to save workspace file. Couldn't write new entries: ";
            final String value2 = String.valueOf(ex2.getMessage());
            throw new SQLException((value2.length() != 0) ? s3.concat(value2) : new String(s3), ex2);
        }
        finally {
            this.connection.setAutoCommit(true);
        }
    }
}
