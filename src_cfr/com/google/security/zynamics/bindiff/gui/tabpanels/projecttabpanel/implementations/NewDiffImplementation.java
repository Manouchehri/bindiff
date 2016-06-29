/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.implementations;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.exceptions.BinExportException;
import com.google.security.zynamics.bindiff.exceptions.DifferException;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.processes.DiffProcess;
import com.google.security.zynamics.bindiff.processes.ExportProcess;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.bindiff.utils.ExternalAppUtils;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

public final class NewDiffImplementation
extends CEndlessHelperThread {
    private final MainWindow parentWindow;
    private final Workspace workspace;
    private File primaryBinExportFile;
    private File secomndaryBinExportFile;
    private final File primaryIDBFile;
    private final File secondaryIDBFile;
    private final File destinationDirectory;
    private String matchedPath;

    public NewDiffImplementation(MainWindow mainWindow, Workspace workspace, File file, File file2, File file3, File file4, File file5) {
        this.parentWindow = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.destinationDirectory = (File)Preconditions.checkNotNull(file5, "Destination directorycannot be null");
        this.primaryIDBFile = file;
        this.secondaryIDBFile = file2;
        this.primaryBinExportFile = file3;
        this.secomndaryBinExportFile = file4;
    }

    private String createUniqueExportFileName(ESide eSide) {
        String string;
        String string2 = "";
        if (this.primaryBinExportFile != null) {
            string2 = this.primaryBinExportFile.getName();
        } else if (this.primaryIDBFile != null) {
            string2 = this.primaryIDBFile.getName();
        }
        string2 = CFileUtils.removeFileExtension(string2);
        String string3 = "";
        if (this.secomndaryBinExportFile != null) {
            string3 = this.secomndaryBinExportFile.getName();
        } else if (this.secondaryIDBFile != null) {
            string3 = this.secondaryIDBFile.getName();
        }
        string3 = CFileUtils.removeFileExtension(string3);
        if (string2.equals(string3)) {
            string2 = String.valueOf(string2).concat("_primary");
            string3 = String.valueOf(string3).concat("_secondary");
        }
        string2 = CFileUtils.forceFilenameEndsWithExtension(string2, "BinExport");
        string3 = CFileUtils.forceFilenameEndsWithExtension(string3, "BinExport");
        if (eSide == ESide.PRIMARY) {
            string = string2;
            return string;
        }
        string = string3;
        return string;
    }

    @Override
    protected void runExpensiveCommand() {
        this.newDiff();
    }

    public String createNewDiff() {
        try {
            String string;
            Object object;
            this.setDescription("Creating destination directory...");
            if (!this.destinationDirectory.isDirectory() && !this.destinationDirectory.mkdirs()) {
                Logger.logSevere("Could not create destination directory.", new Object[0]);
                CMessageBox.showError(this.parentWindow, "Could not create destination directory.");
                return null;
            }
            String string2 = this.createUniqueExportFileName(ESide.PRIMARY);
            String string3 = this.createUniqueExportFileName(ESide.SECONDARY);
            if (this.primaryIDBFile != null) {
                try {
                    object = String.valueOf(this.primaryIDBFile.getPath());
                    string = String.valueOf(this.destinationDirectory.getPath());
                    Logger.logInfo(new StringBuilder(32 + String.valueOf(object).length() + String.valueOf(string).length()).append("- Exporting primary IDB '").append((String)object).append("' to '").append(string).append("'").toString(), new Object[0]);
                    this.setDescription("Exporting primary IDB...");
                    object = ExternalAppUtils.getIdaExe(this.primaryIDBFile);
                    if (object == null || !object.canExecute()) {
                        string = "Can't start disassembler. Please set correct path in the main settings first.";
                        Logger.logSevere("Can't start disassembler. Please set correct path in the main settings first.", new Object[0]);
                        CMessageBox.showError(this.parentWindow, "Can't start disassembler. Please set correct path in the main settings first.");
                        return null;
                    }
                    ExportProcess.startExportProcess((File)object, this.destinationDirectory, this.primaryIDBFile, string2);
                }
                catch (BinExportException var3_5) {
                    Logger.logException(var3_5, var3_5.getMessage());
                    CMessageBox.showError(this.parentWindow, var3_5.getMessage());
                    try {
                        CFileUtils.deleteDirectory(this.destinationDirectory);
                        return null;
                    }
                    catch (IOException var4_12) {
                        Logger.logException(var4_12, String.format("Couldn't delete diff folder '%s' after diffing failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                        CMessageBox.showWarning(this.parentWindow, String.format("Couldn't delete diff folder '%s' after diffing failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                    }
                    return null;
                }
            }
            if (this.primaryBinExportFile != null) {
                try {
                    object = new File(String.format("%s%s%s", this.destinationDirectory.getPath(), File.separator, string2));
                    if (!object.exists()) {
                        this.setDescription("Copying primary BinExport binary...");
                        ByteStreams.copy(new FileInputStream(this.primaryBinExportFile), new FileOutputStream((File)object));
                    }
                    this.primaryBinExportFile = object;
                }
                catch (IOException var3_6) {
                    Logger.logException(var3_6, "New Diff failed. Couldn't copy already exported primary binaries into the new diff directory.");
                    CMessageBox.showError(this.parentWindow, "New Diff failed. Couldn't copy already exported primary binaries into the new diff directory.");
                    try {
                        CFileUtils.deleteDirectory(this.destinationDirectory);
                        return null;
                    }
                    catch (IOException var4_13) {
                        Logger.logException(var4_13, String.format("Couldn't delete diff folder '%s' after diffing failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                        CMessageBox.showWarning(this.parentWindow, String.format("Couldn't delete diff folder '%s' after diffing failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                    }
                    return null;
                }
            }
            if (this.secondaryIDBFile != null) {
                try {
                    object = String.valueOf(this.secondaryIDBFile.getPath());
                    string = String.valueOf(this.destinationDirectory.getPath());
                    Logger.logInfo(new StringBuilder(34 + String.valueOf(object).length() + String.valueOf(string).length()).append("- Exporting secondary IDB '").append((String)object).append("' to '").append(string).append("'").toString(), new Object[0]);
                    this.setDescription("Exporting secondary IDB...");
                    object = ExternalAppUtils.getIdaExe(this.secondaryIDBFile);
                    if (object == null || !object.canExecute()) {
                        string = "Can't start disassembler. Please set correct path in the main settings first.";
                        Logger.logSevere("Can't start disassembler. Please set correct path in the main settings first.", new Object[0]);
                        CMessageBox.showError(this.parentWindow, "Can't start disassembler. Please set correct path in the main settings first.");
                        return null;
                    }
                    ExportProcess.startExportProcess((File)object, this.destinationDirectory, this.secondaryIDBFile, string3);
                }
                catch (BinExportException var3_7) {
                    Logger.logException(var3_7, var3_7.getMessage());
                    CMessageBox.showError(this.parentWindow, var3_7.getMessage());
                    try {
                        CFileUtils.deleteDirectory(this.destinationDirectory);
                        return null;
                    }
                    catch (IOException var4_14) {
                        Logger.logException(var4_14, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                        CMessageBox.showWarning(this.parentWindow, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                    }
                    return null;
                }
            }
            if (this.secomndaryBinExportFile != null) {
                try {
                    object = new File(String.format("%s%s%s", this.destinationDirectory.getPath(), File.separator, string3));
                    if (!object.exists()) {
                        this.setDescription("Copying primary BinExport binary...");
                        ByteStreams.copy(new FileInputStream(this.secomndaryBinExportFile), new FileOutputStream((File)object));
                    }
                    this.secomndaryBinExportFile = object;
                }
                catch (IOException var3_8) {
                    Logger.logException(var3_8, "New Diff failed. Couldn't copy secondary BinExport binaries into the new diff directory.");
                    CMessageBox.showError(this.parentWindow, "New Diff failed. Couldn't copy secondary BinExport binaries into the new diff directory.");
                    try {
                        CFileUtils.deleteDirectory(this.destinationDirectory);
                        return null;
                    }
                    catch (IOException var4_15) {
                        Logger.logException(var4_15, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                        CMessageBox.showWarning(this.parentWindow, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                    }
                    return null;
                }
            }
            try {
                object = ExternalAppUtils.getCommandLineDiffer();
                string = "";
                string = this.primaryIDBFile != null ? ExportProcess.getExportedFileName(string2, this.destinationDirectory) : this.primaryBinExportFile.getPath();
                String string4 = "";
                string4 = this.secondaryIDBFile != null ? ExportProcess.getExportedFileName(string3, this.destinationDirectory) : this.secomndaryBinExportFile.getPath();
                String string5 = String.valueOf(this.destinationDirectory.getName());
                Logger.logInfo(new StringBuilder(18 + String.valueOf(string5).length()).append("- Start Diffing '").append(string5).append("'").toString(), new Object[0]);
                this.setDescription("Diffing...");
                DiffProcess.startDiffProcess((String)object, string, string4, this.destinationDirectory);
                string5 = DiffProcess.getBinDiffFileName(string, string4);
                Logger.logInfo("- Diffing done successfully.'", new Object[0]);
                return string5;
            }
            catch (BinExportException var3_9) {
                Logger.logException(var3_9, var3_9.getMessage());
                CMessageBox.showError(this.parentWindow, var3_9.getMessage());
                return null;
            }
            catch (DifferException var3_10) {
                Logger.logException(var3_10, var3_10.getMessage());
                CMessageBox.showError(this.parentWindow, var3_10.getMessage());
            }
            return null;
        }
        catch (Exception var1_2) {
            Logger.logException(var1_2, "New Diff failed..");
            CMessageBox.showError(this.parentWindow, "New Diff failed.");
            return null;
        }
    }

    public String getMatchesPath() {
        return this.matchedPath;
    }

    public void newDiff() {
        try {
            this.matchedPath = this.createNewDiff();
            if (this.matchedPath == null) {
                return;
            }
            File file = new File(this.matchedPath);
            if (file.exists()) {
                this.setDescription("Preloading Diff...");
                DiffMetaData diffMetaData = DiffLoader.preloadDiffMatches(file);
                this.setDescription("Adding Diff to workspace...");
                this.workspace.addDiff(file, diffMetaData, false);
                return;
            }
            Logger.logSevere("Create and add new Diff to workspace failed. Diff binary does not exist.", new Object[0]);
            CMessageBox.showError(this.parentWindow, "Adding new Diff to workspace failed. Diff binary does not exist.");
            return;
        }
        catch (SQLException var1_2) {
            Logger.logException(var1_2, "New Diff failed. Couldn't read matches database.");
            String string = String.valueOf(var1_2.getMessage());
            CMessageBox.showError(this.parentWindow, string.length() != 0 ? "New Diff failed. Couldn't read matches database: ".concat(string) : new String("New Diff failed. Couldn't read matches database: "));
        }
    }
}

