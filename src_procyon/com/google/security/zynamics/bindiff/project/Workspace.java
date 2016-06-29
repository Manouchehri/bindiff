package com.google.security.zynamics.bindiff.project;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.io.*;
import com.google.security.zynamics.bindiff.database.*;

public final class Workspace
{
    private File workspaceFile;
    private final List diffs;
    private String name;
    private boolean isLoaded;
    private final ListenerProvider listeners;
    private MainWindow parentWindow;
    
    public Workspace() {
        this.workspaceFile = null;
        this.diffs = new ArrayList();
        this.isLoaded = false;
        this.listeners = new ListenerProvider();
    }
    
    private void createCommentDatabase() {
        try {
            final CommentsDatabase commentsDatabase = new CommentsDatabase(this, true);
            final Throwable t = null;
            if (commentsDatabase != null) {
                if (t != null) {
                    try {
                        commentsDatabase.close();
                    }
                    catch (Throwable t2) {
                        t.addSuppressed(t2);
                    }
                }
                else {
                    commentsDatabase.close();
                }
            }
        }
        catch (SQLException ex) {
            Logger.logException(ex, ex.getMessage());
            CMessageBox.showError(this.parentWindow, ex.getMessage());
        }
    }
    
    public void addDiff(final Diff diff) {
        if (this.diffs.contains(diff)) {
            return;
        }
        Object o = null;
        for (final Diff diff2 : this.diffs) {
            if (diff2.getMatchesDatabase().equals(diff.getMatchesDatabase())) {
                o = diff2;
            }
        }
        if (o != null) {
            this.diffs.remove(o);
        }
        this.diffs.add(diff);
        if (this.isLoaded) {
            final Iterator iterator2 = this.listeners.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().addedDiff(diff);
            }
            this.saveWorkspace();
        }
    }
    
    public String addDiff(final File file, final DiffMetaData diffMetaData, final boolean b) {
        final StringBuffer sb = new StringBuffer("");
        File binExportFile = null;
        File binExportFile2 = null;
        if (diffMetaData == null || !file.exists()) {
            final StringBuffer sb2 = sb;
            final String value = String.valueOf(file.getPath());
            sb2.append(new StringBuilder(4 + String.valueOf(value).length()).append(" - ").append(value).append("\n").toString());
        }
        if (diffMetaData != null) {
            binExportFile = DiffDirectories.getBinExportFile(file, diffMetaData, ESide.PRIMARY);
            if (!binExportFile.exists() || binExportFile.isDirectory()) {
                final StringBuffer sb3 = sb;
                final String value2 = String.valueOf(binExportFile.getPath());
                sb3.append(new StringBuilder(4 + String.valueOf(value2).length()).append(" - ").append(value2).append("\n").toString());
            }
            binExportFile2 = DiffDirectories.getBinExportFile(file, diffMetaData, ESide.SECONDARY);
            if (!binExportFile2.exists() || binExportFile2.isDirectory()) {
                final StringBuffer sb4 = sb;
                final String value3 = String.valueOf(binExportFile2.getPath());
                sb4.append(new StringBuilder(4 + String.valueOf(value3).length()).append(" - ").append(value3).append("\n").toString());
            }
        }
        final Diff diff = new Diff(diffMetaData, file, binExportFile, binExportFile2, b);
        if (diff != null) {
            try {
                this.addDiff(diff);
            }
            catch (SQLException ex) {
                Logger.logException(ex, ex.getMessage());
                CMessageBox.showError(this.parentWindow, ex.getMessage());
            }
        }
        return sb.toString();
    }
    
    public void addListener(final IWorkspaceListener workspaceListener) {
        this.listeners.addListener(workspaceListener);
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
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().closedWorkspace();
        }
        Logger.logInfo("Workspace closed.", new Object[0]);
    }
    
    public boolean containsDiff(final String s) {
        final Iterator<Diff> iterator = this.diffs.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getMatchesDatabase().getPath().equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    public List getDiffList() {
        return this.diffs;
    }
    
    public List getDiffList(final boolean b) {
        final ArrayList<Diff> list = new ArrayList<Diff>();
        for (final Diff diff : this.diffs) {
            if (diff.isFunctionDiff() == b) {
                list.add(diff);
            }
        }
        return list;
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
    
    public void newWorkspace(final File workspaceFile) {
        if (this.isLoaded) {
            throw new IOException("Couldn't create new workspace. Existing workspace has to be closed first.");
        }
        this.workspaceFile = workspaceFile;
        this.name = workspaceFile.getName();
        this.isLoaded = true;
        this.saveWorkspace();
        this.createCommentDatabase();
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().loadedWorkspace(this);
        }
        Logger.logInfo("Created a new Workspace.", new Object[0]);
    }
    
    public void removeDiff(final Diff diff) {
        this.diffs.remove(diff);
    }
    
    public void removeListener(final IWorkspaceListener workspaceListener) {
        this.listeners.removeListener(workspaceListener);
    }
    
    public void saveWorkspace() {
        if (this.workspaceFile == null) {
            throw new SQLException("Couldn't save workspace. No workspace is loaded.");
        }
        try (final WorkspaceDatabase workspaceDatabase = new WorkspaceDatabase(this.workspaceFile)) {
            workspaceDatabase.saveWorkspace(this);
        }
    }
    
    public void setLoaded(final boolean isLoaded) {
        this.isLoaded = isLoaded;
    }
    
    public void setParentWindow(final MainWindow parentWindow) {
        this.parentWindow = parentWindow;
    }
    
    public void setWorkspaceFile(final File workspaceFile) {
        this.workspaceFile = workspaceFile;
        this.name = workspaceFile.getName();
    }
}
