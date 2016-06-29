package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.gui.components.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.common.io.*;
import java.io.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.database.*;
import java.sql.*;

public class FunctionDiffViewSaver extends CEndlessHelperThread
{
    private final ViewTabPanelFunctions controller;
    private final Window parent;
    private final File primaryExportFileTarget;
    private final File secondaryExportFileTarget;
    private final File binDiffFileTarget;
    private final boolean overridePrimaryExport;
    private final boolean overrideSecondaryExport;
    private boolean cleanupPrimaryExportFile;
    private boolean cleanupSecondaryExportFile;
    private boolean cleanupBinDiffFile;
    private final Diff diffToSave;
    private Diff savedDiff;
    private boolean addSavedDiffToWorkspace;
    
    public FunctionDiffViewSaver(final ViewTabPanelFunctions viewTabPanelFunctions, final File file, final File file2, final File file3, final boolean overridePrimaryExport, final boolean overrideSecondaryExport) {
        this.cleanupPrimaryExportFile = false;
        this.cleanupSecondaryExportFile = false;
        this.cleanupBinDiffFile = false;
        this.addSavedDiffToWorkspace = false;
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.parent = viewTabPanelFunctions.getMainWindow();
        this.diffToSave = viewTabPanelFunctions.getGraphs().getDiff();
        this.primaryExportFileTarget = (File)Preconditions.checkNotNull(file);
        this.secondaryExportFileTarget = (File)Preconditions.checkNotNull(file2);
        this.binDiffFileTarget = (File)Preconditions.checkNotNull(file3);
        this.overridePrimaryExport = overridePrimaryExport;
        this.overrideSecondaryExport = overrideSecondaryExport;
    }
    
    private void cleanUp() {
        String s = "";
        if (this.primaryExportFileTarget != null && this.primaryExportFileTarget.exists() && this.cleanupPrimaryExportFile && !this.primaryExportFileTarget.delete()) {
            s = String.format("Failed to delete '%'.\n", this.primaryExportFileTarget.getPath());
        }
        if (this.secondaryExportFileTarget != null && this.secondaryExportFileTarget.exists() && this.cleanupSecondaryExportFile && !this.secondaryExportFileTarget.delete()) {
            s = String.format("Failed to delete '%'.\n", this.secondaryExportFileTarget.getPath());
        }
        if (this.binDiffFileTarget != null && this.binDiffFileTarget.exists() && this.cleanupBinDiffFile && !this.binDiffFileTarget.delete()) {
            s = String.format("Failed to delete '%s'.\n", this.binDiffFileTarget.getPath());
        }
        final File parentFile = this.binDiffFileTarget.getParentFile();
        if (parentFile.list().length == 0 && !parentFile.delete()) {
            s = String.format("Failed to delete '%s'.\n", parentFile.getPath());
        }
        if (!"".equals(s)) {
            final String substring = s.substring(0, s.length() - 2);
            Logger.logWarning(substring, new Object[0]);
            MessageBox.showWarning(this.parent, substring);
        }
    }
    
    private void cloneDiffObjectOnSaveAs() {
        final FlowGraphViewData flowGraphViewData = this.diffToSave.getViewManager().getFlowgraphViewsData().get(0);
        if (this.binDiffFileTarget.exists() && !this.binDiffFileTarget.equals(this.diffToSave.getMatchesDatabase()) && this.diffToSave.getMatchesDatabase().getParent().equals(this.binDiffFileTarget.getParent())) {
            this.diffToSave.willOverwriteDiff(this.binDiffFileTarget.getPath());
            this.savedDiff = this.diffToSave.cloneDiffObjectOnSaveAs(this.binDiffFileTarget, this.primaryExportFileTarget, this.secondaryExportFileTarget, flowGraphViewData);
        }
        else if (!this.binDiffFileTarget.exists() && this.diffToSave.getMatchesDatabase().getParent().equals(this.binDiffFileTarget.getParent())) {
            this.savedDiff = this.diffToSave.cloneDiffObjectOnSaveAs(this.binDiffFileTarget, this.primaryExportFileTarget, this.secondaryExportFileTarget, flowGraphViewData);
        }
        else {
            this.addSavedDiffToWorkspace = !this.binDiffFileTarget.equals(this.diffToSave.getMatchesDatabase());
            this.savedDiff = this.diffToSave;
        }
        this.addSavedDiffToWorkspace = (this.addSavedDiffToWorkspace || this.savedDiff != this.diffToSave);
    }
    
    private boolean copyBinDiffFile() {
        final File matchesDatabase = this.diffToSave.getMatchesDatabase();
        if (matchesDatabase.getPath().equals(this.binDiffFileTarget.getPath())) {
            this.savedDiff = this.diffToSave;
            return true;
        }
        this.cleanupBinDiffFile = !this.binDiffFileTarget.exists();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            this.cloneDiffObjectOnSaveAs();
            inputStream = new FileInputStream(matchesDatabase);
            outputStream = new FileOutputStream(this.binDiffFileTarget);
            ByteStreams.copy(inputStream, outputStream);
        }
        catch (FileNotFoundException ex) {
            Logger.logException(ex, "Save function diff view failed. Couldn't copy BinDiff file into workspace.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn't copy BinDiff file into workspace.");
            return false;
        }
        catch (IOException ex2) {
            Logger.logException(ex2, "Save function diff view failed. Couldn't copy BinExport files into workspace.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn't copy BinExport files into workspace.");
            return false;
        }
        finally {
            if (inputStream != null) {
                try {
                    ((FileInputStream)inputStream).close();
                }
                catch (IOException ex3) {
                    Logger.logWarning(ex3, "Couldn't close file input stream.");
                }
            }
            if (outputStream != null) {
                try {
                    ((FileOutputStream)outputStream).close();
                }
                catch (IOException ex4) {
                    Logger.logWarning(ex4, "Couldn't close file output stream.");
                }
            }
        }
        return true;
    }
    
    private boolean copyExportFile(final ESide eSide) {
        final File exportFile = this.diffToSave.getExportFile(eSide);
        final File file = (eSide == ESide.PRIMARY) ? this.primaryExportFileTarget : this.secondaryExportFileTarget;
        if (file.exists() && ((eSide == ESide.PRIMARY && !this.overridePrimaryExport) || (eSide == ESide.SECONDARY && !this.overrideSecondaryExport))) {
            return true;
        }
        if (exportFile.getPath().equals(file.getPath())) {
            return true;
        }
        if (eSide == ESide.PRIMARY) {
            this.cleanupPrimaryExportFile = !file.exists();
        }
        else {
            this.cleanupSecondaryExportFile = !file.exists();
        }
        try {
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                inputStream = new FileInputStream(exportFile);
                outputStream = new FileOutputStream(file);
                ByteStreams.copy(inputStream, outputStream);
            }
            finally {
                if (inputStream != null) {
                    try {
                        ((FileInputStream)inputStream).close();
                    }
                    catch (IOException ex) {
                        Logger.logWarning(ex, "Couldn't close file input stream.");
                    }
                }
                if (outputStream != null) {
                    try {
                        ((FileOutputStream)outputStream).close();
                    }
                    catch (IOException ex2) {
                        Logger.logWarning(ex2, "Couldn't close file output stream.");
                    }
                }
            }
        }
        catch (FileNotFoundException ex3) {
            Logger.logException(ex3, "Save function diff view failed. Couldn't copy BinExport files.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn't copy BinExport files.");
            return false;
        }
        catch (IOException ex4) {
            Logger.logException(ex4, "Save function diff view failed. Couldn't copy BinExport files.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn't copy BinExport files.");
            return false;
        }
        return true;
    }
    
    private void saveView() {
        this.controller.writeComments();
        this.controller.writeFlowgraphMatches();
    }
    
    private boolean updateDiff() {
        try {
            this.savedDiff.setMatchesDatabase(this.binDiffFileTarget);
            this.savedDiff.setExportFile(this.primaryExportFileTarget, ESide.PRIMARY);
            this.savedDiff.setExportFile(this.secondaryExportFileTarget, ESide.SECONDARY);
        }
        catch (UnsupportedOperationException ex) {
            Logger.logException(ex, "Save function diff view failed. Couldn't update diff object.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn't update diff object.");
            return false;
        }
        return true;
    }
    
    private boolean updateMatchesDatabase() {
        final String forceFilenameEndsNotWithExtension = CFileUtils.forceFilenameEndsNotWithExtension(this.primaryExportFileTarget.getName(), "BinExport");
        final String forceFilenameEndsNotWithExtension2 = CFileUtils.forceFilenameEndsNotWithExtension(this.secondaryExportFileTarget.getName(), "BinExport");
        if (!this.binDiffFileTarget.exists()) {
            return false;
        }
        try (final MatchesDatabase matchesDatabase = new MatchesDatabase(this.binDiffFileTarget)) {
            matchesDatabase.changeExportFilename(forceFilenameEndsNotWithExtension, ESide.PRIMARY);
            matchesDatabase.changeExportFilename(forceFilenameEndsNotWithExtension2, ESide.SECONDARY);
            matchesDatabase.changeFileTable(this.savedDiff);
        }
        catch (SQLException ex) {
            final String s = "Save function diff view failed. Couldn't update export file name in matches database.";
            final String value = String.valueOf(ex.getMessage());
            Logger.logSevere((value.length() != 0) ? s.concat(value) : new String(s), new Object[0]);
            final Window parent = this.parent;
            final String s2 = "Save function diff view failed. Couldn't update export file name in matches database: ";
            final String value2 = String.valueOf(ex.getMessage());
            MessageBox.showError(parent, (value2.length() != 0) ? s2.concat(value2) : new String(s2));
            return false;
        }
        return true;
    }
    
    private void updateWorkspace() {
        if (this.addSavedDiffToWorkspace) {
            this.controller.getWorkspace().addDiff(this.savedDiff);
        }
    }
    
    @Override
    protected void runExpensiveCommand() {
        this.setDescription("Copying primary BinExport file...");
        if (!this.copyExportFile(ESide.PRIMARY)) {
            this.cleanUp();
            return;
        }
        this.setDescription("Copying secondary BinExport file...");
        if (!this.copyExportFile(ESide.SECONDARY)) {
            this.cleanUp();
            return;
        }
        this.setDescription("Copying BinDiff file...");
        if (!this.copyBinDiffFile()) {
            this.cleanUp();
            return;
        }
        this.setDescription("Updating BinDiff database...");
        if (!this.updateMatchesDatabase()) {
            this.cleanUp();
            return;
        }
        this.setDescription("Updating Diff...");
        if (!this.updateDiff()) {
            this.cleanUp();
            return;
        }
        this.setDescription("Saving comments and changed matches...");
        this.saveView();
        this.setDescription("Updating Workspace...");
        this.updateWorkspace();
        this.setDescription("Completed successfully.");
        try {
            Thread.sleep(300L);
        }
        catch (InterruptedException ex) {}
    }
}
