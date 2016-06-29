/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project;

import com.google.security.zynamics.bindiff.database.CommentsDatabase;
import com.google.security.zynamics.bindiff.database.WorkspaceDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.IWorkspaceListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffDirectories;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Workspace {
    private File workspaceFile = null;
    private final List diffs = new ArrayList();
    private String name;
    private boolean isLoaded = false;
    private final ListenerProvider listeners = new ListenerProvider();
    private MainWindow parentWindow;

    private void createCommentDatabase() {
        try {
            CommentsDatabase commentsDatabase = new CommentsDatabase(this, true);
            Throwable throwable = null;
            if (commentsDatabase == null) return;
            if (throwable == null) {
                commentsDatabase.close();
                return;
            }
            try {
                commentsDatabase.close();
                return;
            }
            catch (Throwable var3_4) {
                throwable.addSuppressed(var3_4);
                return;
            }
        }
        catch (SQLException var1_2) {
            Logger.logException(var1_2, var1_2.getMessage());
            CMessageBox.showError(this.parentWindow, var1_2.getMessage());
        }
    }

    public void addDiff(Diff diff) {
        if (this.diffs.contains(diff)) {
            return;
        }
        Diff diff2 = null;
        for (Object object2 : this.diffs) {
            if (!object2.getMatchesDatabase().equals(diff.getMatchesDatabase())) continue;
            diff2 = object2;
        }
        if (diff2 != null) {
            this.diffs.remove(diff2);
        }
        this.diffs.add(diff);
        if (!this.isLoaded) return;
        Iterator iterator = this.listeners.iterator();
        do {
            Object object2;
            if (!iterator.hasNext()) {
                this.saveWorkspace();
                return;
            }
            object2 = (IWorkspaceListener)iterator.next();
            object2.addedDiff(diff);
        } while (true);
    }

    public String addDiff(File file, DiffMetaData diffMetaData, boolean bl2) {
        Object object;
        StringBuffer stringBuffer = new StringBuffer("");
        File file2 = null;
        File file3 = null;
        if (diffMetaData == null || !file.exists()) {
            object = String.valueOf(file.getPath());
            stringBuffer.append(new StringBuilder(4 + String.valueOf(object).length()).append(" - ").append((String)object).append("\n").toString());
        }
        if (diffMetaData != null) {
            file2 = DiffDirectories.getBinExportFile(file, diffMetaData, ESide.PRIMARY);
            if (!file2.exists() || file2.isDirectory()) {
                object = String.valueOf(file2.getPath());
                stringBuffer.append(new StringBuilder(4 + String.valueOf(object).length()).append(" - ").append((String)object).append("\n").toString());
            }
            if (!(file3 = DiffDirectories.getBinExportFile(file, diffMetaData, ESide.SECONDARY)).exists() || file3.isDirectory()) {
                object = String.valueOf(file3.getPath());
                stringBuffer.append(new StringBuilder(4 + String.valueOf(object).length()).append(" - ").append((String)object).append("\n").toString());
            }
        }
        if ((object = new Diff(diffMetaData, file, file2, file3, bl2)) == null) return stringBuffer.toString();
        try {
            this.addDiff((Diff)object);
            return stringBuffer.toString();
        }
        catch (SQLException var8_8) {
            Logger.logException(var8_8, var8_8.getMessage());
            CMessageBox.showError(this.parentWindow, var8_8.getMessage());
        }
        return stringBuffer.toString();
    }

    public void addListener(IWorkspaceListener iWorkspaceListener) {
        this.listeners.addListener(iWorkspaceListener);
    }

    public void closeWorkspace() {
        if (!this.isLoaded()) {
            return;
        }
        Logger.logInfo("Closing workspace '%s'...", this.workspaceFile.getPath());
        this.diffs.clear();
        this.workspaceFile = null;
        this.name = "";
        this.isLoaded = false;
        Iterator iterator = this.listeners.iterator();
        do {
            if (!iterator.hasNext()) {
                Logger.logInfo("Workspace closed.", new Object[0]);
                return;
            }
            IWorkspaceListener iWorkspaceListener = (IWorkspaceListener)iterator.next();
            iWorkspaceListener.closedWorkspace();
        } while (true);
    }

    public boolean containsDiff(String string) {
        Diff diff;
        Iterator iterator = this.diffs.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!(diff = (Diff)iterator.next()).getMatchesDatabase().getPath().equals(string));
        return true;
    }

    public List getDiffList() {
        return this.diffs;
    }

    public List getDiffList(boolean bl2) {
        ArrayList<Diff> arrayList = new ArrayList<Diff>();
        Iterator iterator = this.diffs.iterator();
        while (iterator.hasNext()) {
            Diff diff = (Diff)iterator.next();
            if (diff.isFunctionDiff() != bl2) continue;
            arrayList.add(diff);
        }
        return arrayList;
    }

    public ListenerProvider getListeners() {
        return this.listeners;
    }

    public MainWindow getWindow() {
        return this.parentWindow;
    }

    public File getWorkspaceDir() {
        return this.workspaceFile.getParentFile();
    }

    public String getWorkspaceDirPath() {
        return this.workspaceFile.getParent();
    }

    public File getWorkspaceFile() {
        return this.workspaceFile;
    }

    public String getWorkspaceFileName() {
        return this.name;
    }

    public String getWorkspaceFilePath() {
        return this.workspaceFile.getPath();
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public void newWorkspace(File file) {
        if (this.isLoaded) {
            throw new IOException("Couldn't create new workspace. Existing workspace has to be closed first.");
        }
        this.workspaceFile = file;
        this.name = file.getName();
        this.isLoaded = true;
        this.saveWorkspace();
        this.createCommentDatabase();
        Iterator iterator = this.listeners.iterator();
        do {
            if (!iterator.hasNext()) {
                Logger.logInfo("Created a new Workspace.", new Object[0]);
                return;
            }
            IWorkspaceListener iWorkspaceListener = (IWorkspaceListener)iterator.next();
            iWorkspaceListener.loadedWorkspace(this);
        } while (true);
    }

    public void removeDiff(Diff diff) {
        this.diffs.remove(diff);
    }

    public void removeListener(IWorkspaceListener iWorkspaceListener) {
        this.listeners.removeListener(iWorkspaceListener);
    }

    public void saveWorkspace() {
        if (this.workspaceFile == null) {
            throw new SQLException("Couldn't save workspace. No workspace is loaded.");
        }
        WorkspaceDatabase workspaceDatabase = new WorkspaceDatabase(this.workspaceFile);
        Throwable throwable = null;
        try {
            workspaceDatabase.saveWorkspace(this);
            return;
        }
        catch (Throwable var3_4) {
            throwable = var3_4;
            throw var3_4;
        }
        finally {
            if (workspaceDatabase != null) {
                if (throwable != null) {
                    try {
                        workspaceDatabase.close();
                    }
                    catch (Throwable var3_3) {
                        throwable.addSuppressed(var3_3);
                    }
                } else {
                    workspaceDatabase.close();
                }
            }
        }
    }

    public void setLoaded(boolean bl2) {
        this.isLoaded = bl2;
    }

    public void setParentWindow(MainWindow mainWindow) {
        this.parentWindow = mainWindow;
    }

    public void setWorkspaceFile(File file) {
        this.workspaceFile = file;
        this.name = file.getName();
    }
}

