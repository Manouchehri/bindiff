package com.google.security.zynamics.bindiff.project;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.common.base.*;
import java.io.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.bindiff.database.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.util.*;

public final class WorkspaceLoader extends CEndlessHelperThread
{
    private static int MAX_LOAD_WORKSPACE_ERRORS;
    private final Workspace workspace;
    private final File workspaceFile;
    private String errors;
    
    public WorkspaceLoader(final File file, final Workspace workspace) {
        this.workspaceFile = (File)Preconditions.checkNotNull(file);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.errors = "";
    }
    
    @Override
    protected void runExpensiveCommand() {
        this.loadMetaData();
    }
    
    public String getErrorMessage() {
        return this.errors;
    }
    
    public boolean hasErrors() {
        return "".equals(this.getErrorMessage());
    }
    
    public void loadMetaData() {
        this.workspace.setLoaded(false);
        if (this.workspaceFile == null) {
            throw new IOException("Load workspace failed. Workspace file cannot be null.");
        }
        if (this.workspaceFile.isDirectory()) {
            throw new IOException("Load workspace failed. Workspace file is a directory.");
        }
        Logger.logInfo("Loading workspace '%s'...", this.workspaceFile.getPath());
        this.setDescription("Reading workspace data...");
        try (final WorkspaceDatabase workspaceDatabase = new WorkspaceDatabase(this.workspaceFile)) {
            final List loadDiffPaths = workspaceDatabase.loadDiffPaths(false);
            final List loadDiffPaths2 = workspaceDatabase.loadDiffPaths(true);
            int n = 0;
            final int size = loadDiffPaths.size();
            this.errors = "";
            final String ensureTrailingSlash = FileUtils.ensureTrailingSlash(this.workspaceFile.getParentFile().getAbsolutePath());
            for (final String s : loadDiffPaths) {
                ++n;
                final String value = String.valueOf(ensureTrailingSlash);
                final String value2 = String.valueOf(s);
                final File file = new File((value2.length() != 0) ? value.concat(value2) : new String(value));
                final File file2 = file.exists() ? file : new File(s);
                Object o = String.valueOf(file2.getPath());
                Logger.logInfo(new StringBuilder(21 + String.valueOf(o).length()).append(" - Preloading Diff '").append((String)o).append("'").toString(), new Object[0]);
                try (final MatchesDatabase matchesDatabase = new MatchesDatabase(file2)) {
                    this.setDescription(String.format("Preloading Diffs %d/%d '%s'", n, size, file2.getName()));
                    o = matchesDatabase.loadDiffMetaData(file2);
                }
                catch (SQLException ex) {
                    Logger.logException(ex);
                    if (file2 == null) {
                        continue;
                    }
                    final String value3 = String.valueOf(this.errors);
                    final String value4 = String.valueOf(file2.getName());
                    this.errors = new StringBuilder(4 + String.valueOf(value3).length() + String.valueOf(value4).length()).append(value3).append(" - ").append(value4).append("\n").toString();
                    continue;
                }
                final String value5 = String.valueOf(this.errors);
                final String value6 = String.valueOf(this.workspace.addDiff(file2, (DiffMetaData)o, false));
                this.errors = ((value6.length() != 0) ? value5.concat(value6) : new String(value5));
            }
            int n2 = 0;
            final int size2 = loadDiffPaths2.size();
            for (final String s2 : loadDiffPaths2) {
                ++n2;
                final String value7 = String.valueOf(ensureTrailingSlash);
                final String value8 = String.valueOf(s2);
                final File file3 = new File((value8.length() != 0) ? value7.concat(value8) : new String(value7));
                final File file4 = file3.exists() ? file3 : new File(s2);
                final String value9 = String.valueOf(file4.getPath());
                Logger.logInfo(new StringBuilder(30 + String.valueOf(value9).length()).append(" - Preloading Function Diff '").append(value9).append("'").toString(), new Object[0]);
                DiffMetaData loadFunctionDiffMetaData = null;
                this.setDescription(String.format("Preloading Function Diffs %d/%d '%s'", n2, size2, file4.getName()));
                try (final MatchesDatabase matchesDatabase2 = new MatchesDatabase(file4)) {
                    loadFunctionDiffMetaData = matchesDatabase2.loadFunctionDiffMetaData(false);
                }
                catch (SQLException ex2) {
                    if (file4 == null) {
                        continue;
                    }
                    final String value10 = String.valueOf(this.errors);
                    final String value11 = String.valueOf(file4.getName());
                    this.errors = new StringBuilder(4 + String.valueOf(value10).length() + String.valueOf(value11).length()).append(value10).append(" - ").append(value11).append("\n").toString();
                    continue;
                }
                final String value12 = String.valueOf(this.errors);
                final String value13 = String.valueOf(this.workspace.addDiff(file4, loadFunctionDiffMetaData, true));
                this.errors = ((value13.length() != 0) ? value12.concat(value13) : new String(value12));
            }
            int n3 = 0;
            int i = 0;
            int n4 = 0;
            while (i != -1) {
                i = this.errors.indexOf("\n", n3);
                if (i != -1) {
                    if (++n4 >= WorkspaceLoader.MAX_LOAD_WORKSPACE_ERRORS) {
                        this.errors = this.errors.substring(0, i);
                        this.errors = String.valueOf(this.errors).concat("...");
                        break;
                    }
                    n3 = i + 1;
                }
            }
            if (this.errors.length() > 0) {
                final String value14 = String.valueOf("Diff loading failed for at least one item:\n\n");
                final String value15 = String.valueOf(this.errors);
                this.errors = ((value15.length() != 0) ? value14.concat(value15) : new String(value14));
            }
            this.workspace.setWorkspaceFile(this.workspaceFile);
            this.setDescription("Connecting to comment database...");
            this.workspace.setLoaded(true);
            final Iterator iterator3 = this.workspace.getListeners().iterator();
            while (iterator3.hasNext()) {
                iterator3.next().loadedWorkspace(this.workspace);
            }
            Logger.logInfo("Workspace loaded.", new Object[0]);
        }
    }
    
    static {
        WorkspaceLoader.MAX_LOAD_WORKSPACE_ERRORS = 15;
    }
}
