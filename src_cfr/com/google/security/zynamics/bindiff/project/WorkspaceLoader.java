/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.database.WorkspaceDatabase;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionDiffMetaData;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public final class WorkspaceLoader
extends CEndlessHelperThread {
    private static int MAX_LOAD_WORKSPACE_ERRORS = 15;
    private final Workspace workspace;
    private final File workspaceFile;
    private String errors;

    public WorkspaceLoader(File file, Workspace workspace) {
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
        WorkspaceDatabase workspaceDatabase = new WorkspaceDatabase(this.workspaceFile);
        Throwable throwable = null;
        try {
            Object object;
            String string;
            MatchesDatabase matchesDatabase;
            Object object22;
            File file;
            Object object3;
            List list = workspaceDatabase.loadDiffPaths(false);
            List list2 = workspaceDatabase.loadDiffPaths(true);
            int n2 = 0;
            int n3 = list.size();
            this.errors = "";
            String string2 = FileUtils.ensureTrailingSlash(this.workspaceFile.getParentFile().getAbsolutePath());
            for (String string32 : list) {
                ++n2;
                String string4 = String.valueOf(string2);
                String string5 = String.valueOf(string32);
                file = new File(string5.length() != 0 ? string4.concat(string5) : new String(string4));
                object3 = file.exists() ? file : new File(string32);
                object22 = String.valueOf(object3.getPath());
                Logger.logInfo(new StringBuilder(21 + String.valueOf(object22).length()).append(" - Preloading Diff '").append((String)object22).append("'").toString(), new Object[0]);
                try {
                    matchesDatabase = new MatchesDatabase((File)object3);
                    object = null;
                    try {
                        this.setDescription(String.format("Preloading Diffs %d/%d '%s'", n2, n3, object3.getName()));
                        object22 = matchesDatabase.loadDiffMetaData((File)object3);
                    }
                    catch (Throwable var15_24) {
                        object = var15_24;
                        throw var15_24;
                    }
                    finally {
                        if (matchesDatabase != null) {
                            if (object != null) {
                                try {
                                    matchesDatabase.close();
                                }
                                catch (Throwable var15_23) {
                                    object.addSuppressed(var15_23);
                                }
                            } else {
                                matchesDatabase.close();
                            }
                        }
                    }
                }
                catch (SQLException var13_19) {
                    Logger.logException(var13_19);
                    if (object3 == null) continue;
                    object = String.valueOf(this.errors);
                    string = String.valueOf(object3.getName());
                    this.errors = new StringBuilder(4 + String.valueOf(object).length() + String.valueOf(string).length()).append((String)object).append(" - ").append(string).append("\n").toString();
                    continue;
                }
                String string6 = String.valueOf(this.errors);
                String string7 = String.valueOf(this.workspace.addDiff((File)object3, (DiffMetaData)object22, false));
                this.errors = string7.length() != 0 ? string6.concat(string7) : new String(string6);
            }
            n2 = 0;
            n3 = list2.size();
            for (String string32 : list2) {
                String string8 = String.valueOf(string2);
                String string9 = String.valueOf(string32);
                file = new File(string9.length() != 0 ? string8.concat(string9) : new String(string8));
                object3 = file.exists() ? file : new File(string32);
                object22 = String.valueOf(object3.getPath());
                Logger.logInfo(new StringBuilder(30 + String.valueOf(object22).length()).append(" - Preloading Function Diff '").append((String)object22).append("'").toString(), new Object[0]);
                object22 = null;
                this.setDescription(String.format("Preloading Function Diffs %d/%d '%s'", ++n2, n3, object3.getName()));
                try {
                    matchesDatabase = new MatchesDatabase((File)object3);
                    object = null;
                    try {
                        object22 = matchesDatabase.loadFunctionDiffMetaData(false);
                    }
                    catch (Throwable var15_26) {
                        object = var15_26;
                        throw var15_26;
                    }
                    finally {
                        if (matchesDatabase != null) {
                            if (object != null) {
                                try {
                                    matchesDatabase.close();
                                }
                                catch (Throwable var15_25) {
                                    object.addSuppressed(var15_25);
                                }
                            } else {
                                matchesDatabase.close();
                            }
                        }
                    }
                }
                catch (SQLException var13_20) {
                    if (object3 == null) continue;
                    object = String.valueOf(this.errors);
                    string = String.valueOf(object3.getName());
                    this.errors = new StringBuilder(4 + String.valueOf(object).length() + String.valueOf(string).length()).append((String)object).append(" - ").append(string).append("\n").toString();
                    continue;
                }
                String string10 = String.valueOf(this.errors);
                String string11 = String.valueOf(this.workspace.addDiff((File)object3, (DiffMetaData)object22, true));
                this.errors = string11.length() != 0 ? string10.concat(string11) : new String(string10);
            }
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            while (n5 != -1) {
                n5 = this.errors.indexOf("\n", n4);
                if (n5 == -1) continue;
                if (++n6 >= MAX_LOAD_WORKSPACE_ERRORS) {
                    this.errors = this.errors.substring(0, n5);
                    this.errors = String.valueOf(this.errors).concat("...");
                    break;
                }
                n4 = n5 + 1;
            }
            if (this.errors.length() > 0) {
                String string12 = String.valueOf("Diff loading failed for at least one item:\n\n");
                String string13 = String.valueOf(this.errors);
                this.errors = string13.length() != 0 ? string12.concat(string13) : new String(string12);
            }
            this.workspace.setWorkspaceFile(this.workspaceFile);
            this.setDescription("Connecting to comment database...");
            this.workspace.setLoaded(true);
            for (Object object22 : this.workspace.getListeners()) {
                object22.loadedWorkspace(this.workspace);
            }
            Logger.logInfo("Workspace loaded.", new Object[0]);
            return;
        }
        catch (Throwable var3_5) {
            throwable = var3_5;
            throw var3_5;
        }
        finally {
            if (workspaceDatabase != null) {
                if (throwable != null) {
                    try {
                        workspaceDatabase.close();
                    }
                    catch (Throwable var3_4) {
                        throwable.addSuppressed(var3_4);
                    }
                } else {
                    workspaceDatabase.close();
                }
            }
        }
    }
}

