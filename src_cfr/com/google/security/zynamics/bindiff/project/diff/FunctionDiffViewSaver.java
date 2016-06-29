/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.gui.components.MessageBox;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FunctionDiffViewSaver
extends CEndlessHelperThread {
    private final ViewTabPanelFunctions controller;
    private final Window parent;
    private final File primaryExportFileTarget;
    private final File secondaryExportFileTarget;
    private final File binDiffFileTarget;
    private final boolean overridePrimaryExport;
    private final boolean overrideSecondaryExport;
    private boolean cleanupPrimaryExportFile = false;
    private boolean cleanupSecondaryExportFile = false;
    private boolean cleanupBinDiffFile = false;
    private final Diff diffToSave;
    private Diff savedDiff;
    private boolean addSavedDiffToWorkspace = false;

    public FunctionDiffViewSaver(ViewTabPanelFunctions viewTabPanelFunctions, File file, File file2, File file3, boolean bl2, boolean bl3) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.parent = viewTabPanelFunctions.getMainWindow();
        this.diffToSave = viewTabPanelFunctions.getGraphs().getDiff();
        this.primaryExportFileTarget = (File)Preconditions.checkNotNull(file);
        this.secondaryExportFileTarget = (File)Preconditions.checkNotNull(file2);
        this.binDiffFileTarget = (File)Preconditions.checkNotNull(file3);
        this.overridePrimaryExport = bl2;
        this.overrideSecondaryExport = bl3;
    }

    private void cleanUp() {
        File file;
        String string = "";
        if (this.primaryExportFileTarget != null && this.primaryExportFileTarget.exists() && this.cleanupPrimaryExportFile && !this.primaryExportFileTarget.delete()) {
            string = String.format("Failed to delete '%'.\n", this.primaryExportFileTarget.getPath());
        }
        if (this.secondaryExportFileTarget != null && this.secondaryExportFileTarget.exists() && this.cleanupSecondaryExportFile && !this.secondaryExportFileTarget.delete()) {
            string = String.format("Failed to delete '%'.\n", this.secondaryExportFileTarget.getPath());
        }
        if (this.binDiffFileTarget != null && this.binDiffFileTarget.exists() && this.cleanupBinDiffFile && !this.binDiffFileTarget.delete()) {
            string = String.format("Failed to delete '%s'.\n", this.binDiffFileTarget.getPath());
        }
        if ((file = this.binDiffFileTarget.getParentFile()).list().length == 0 && !file.delete()) {
            string = String.format("Failed to delete '%s'.\n", file.getPath());
        }
        if ("".equals(string)) return;
        string = string.substring(0, string.length() - 2);
        Logger.logWarning(string, new Object[0]);
        MessageBox.showWarning(this.parent, string);
    }

    private void cloneDiffObjectOnSaveAs() {
        FlowGraphViewData flowGraphViewData = (FlowGraphViewData)this.diffToSave.getViewManager().getFlowgraphViewsData().get(0);
        if (this.binDiffFileTarget.exists() && !this.binDiffFileTarget.equals(this.diffToSave.getMatchesDatabase()) && this.diffToSave.getMatchesDatabase().getParent().equals(this.binDiffFileTarget.getParent())) {
            this.diffToSave.willOverwriteDiff(this.binDiffFileTarget.getPath());
            this.savedDiff = this.diffToSave.cloneDiffObjectOnSaveAs(this.binDiffFileTarget, this.primaryExportFileTarget, this.secondaryExportFileTarget, flowGraphViewData);
        } else if (!this.binDiffFileTarget.exists() && this.diffToSave.getMatchesDatabase().getParent().equals(this.binDiffFileTarget.getParent())) {
            this.savedDiff = this.diffToSave.cloneDiffObjectOnSaveAs(this.binDiffFileTarget, this.primaryExportFileTarget, this.secondaryExportFileTarget, flowGraphViewData);
        } else {
            this.addSavedDiffToWorkspace = !this.binDiffFileTarget.equals(this.diffToSave.getMatchesDatabase());
            this.savedDiff = this.diffToSave;
        }
        this.addSavedDiffToWorkspace = this.addSavedDiffToWorkspace || this.savedDiff != this.diffToSave;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean copyBinDiffFile() {
        File file = this.diffToSave.getMatchesDatabase();
        if (file.getPath().equals(this.binDiffFileTarget.getPath())) {
            this.savedDiff = this.diffToSave;
            return true;
        }
        this.cleanupBinDiffFile = !this.binDiffFileTarget.exists();
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            this.cloneDiffObjectOnSaveAs();
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(this.binDiffFileTarget);
            ByteStreams.copy(fileInputStream, fileOutputStream);
            return true;
        }
        catch (FileNotFoundException var4_6) {
            Logger.logException(var4_6, "Save function diff view failed. Couldn't copy BinDiff file into workspace.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn't copy BinDiff file into workspace.");
            boolean bl2 = false;
            return bl2;
        }
        catch (IOException var4_7) {
            Logger.logException(var4_7, "Save function diff view failed. Couldn't copy BinExport files into workspace.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn't copy BinExport files into workspace.");
            boolean bl3 = false;
            return bl3;
        }
        finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }
                catch (IOException var6_12) {
                    Logger.logWarning(var6_12, "Couldn't close file input stream.");
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                }
                catch (IOException var6_13) {
                    Logger.logWarning(var6_13, "Couldn't close file output stream.");
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean copyExportFile(ESide eSide) {
        File file;
        File file2 = this.diffToSave.getExportFile(eSide);
        File file3 = file = eSide == ESide.PRIMARY ? this.primaryExportFileTarget : this.secondaryExportFileTarget;
        if (file.exists()) {
            if (eSide == ESide.PRIMARY) {
                if (!this.overridePrimaryExport) return true;
            }
            if (eSide == ESide.SECONDARY && !this.overrideSecondaryExport) {
                return true;
            }
        }
        if (file2.getPath().equals(file.getPath())) {
            return true;
        }
        if (eSide == ESide.PRIMARY) {
            this.cleanupPrimaryExportFile = !file.exists();
        } else {
            this.cleanupSecondaryExportFile = !file.exists();
        }
        try {
            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;
            try {
                fileInputStream = new FileInputStream(file2);
                fileOutputStream = new FileOutputStream(file);
                ByteStreams.copy(fileInputStream, fileOutputStream);
                return true;
            }
            finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    }
                    catch (IOException var6_8) {
                        Logger.logWarning(var6_8, "Couldn't close file input stream.");
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    }
                    catch (IOException var6_9) {
                        Logger.logWarning(var6_9, "Couldn't close file output stream.");
                    }
                }
            }
        }
        catch (FileNotFoundException var4_5) {
            Logger.logException(var4_5, "Save function diff view failed. Couldn't copy BinExport files.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn't copy BinExport files.");
            return false;
        }
        catch (IOException var4_6) {
            Logger.logException(var4_6, "Save function diff view failed. Couldn't copy BinExport files.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn't copy BinExport files.");
            return false;
        }
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
            return true;
        }
        catch (UnsupportedOperationException var1_1) {
            Logger.logException(var1_1, "Save function diff view failed. Couldn't update diff object.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn't update diff object.");
            return false;
        }
    }

    private boolean updateMatchesDatabase() {
        String string = CFileUtils.forceFilenameEndsNotWithExtension(this.primaryExportFileTarget.getName(), "BinExport");
        String string2 = CFileUtils.forceFilenameEndsNotWithExtension(this.secondaryExportFileTarget.getName(), "BinExport");
        if (!this.binDiffFileTarget.exists()) {
            return false;
        }
        try {
            MatchesDatabase matchesDatabase = new MatchesDatabase(this.binDiffFileTarget);
            Throwable throwable = null;
            try {
                matchesDatabase.changeExportFilename(string, ESide.PRIMARY);
                matchesDatabase.changeExportFilename(string2, ESide.SECONDARY);
                matchesDatabase.changeFileTable(this.savedDiff);
                return true;
            }
            catch (Throwable var5_7) {
                throwable = var5_7;
                throw var5_7;
            }
            finally {
                if (matchesDatabase != null) {
                    if (throwable != null) {
                        try {
                            matchesDatabase.close();
                        }
                        catch (Throwable var5_6) {
                            throwable.addSuppressed(var5_6);
                        }
                    } else {
                        matchesDatabase.close();
                    }
                }
            }
        }
        catch (SQLException var3_4) {
            String string3 = String.valueOf(var3_4.getMessage());
            Logger.logSevere(string3.length() != 0 ? "Save function diff view failed. Couldn't update export file name in matches database.".concat(string3) : new String("Save function diff view failed. Couldn't update export file name in matches database."), new Object[0]);
            String string4 = String.valueOf(var3_4.getMessage());
            MessageBox.showError(this.parent, string4.length() != 0 ? "Save function diff view failed. Couldn't update export file name in matches database: ".concat(string4) : new String("Save function diff view failed. Couldn't update export file name in matches database: "));
            return false;
        }
    }

    private void updateWorkspace() {
        if (!this.addSavedDiffToWorkspace) return;
        this.controller.getWorkspace().addDiff(this.savedDiff);
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
            Thread.sleep(300);
            return;
        }
        catch (InterruptedException var1_1) {
            // empty catch block
        }
    }
}

