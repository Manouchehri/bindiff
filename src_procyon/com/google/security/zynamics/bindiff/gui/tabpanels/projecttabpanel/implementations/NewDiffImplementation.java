package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.implementations;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.common.io.*;
import java.io.*;
import com.google.security.zynamics.bindiff.processes.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.project.matches.*;

public final class NewDiffImplementation extends CEndlessHelperThread
{
    private final MainWindow parentWindow;
    private final Workspace workspace;
    private File primaryBinExportFile;
    private File secomndaryBinExportFile;
    private final File primaryIDBFile;
    private final File secondaryIDBFile;
    private final File destinationDirectory;
    private String matchedPath;
    
    public NewDiffImplementation(final MainWindow mainWindow, final Workspace workspace, final File primaryIDBFile, final File secondaryIDBFile, final File primaryBinExportFile, final File secomndaryBinExportFile, final File file) {
        this.parentWindow = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.destinationDirectory = (File)Preconditions.checkNotNull(file, (Object)"Destination directorycannot be null");
        this.primaryIDBFile = primaryIDBFile;
        this.secondaryIDBFile = secondaryIDBFile;
        this.primaryBinExportFile = primaryBinExportFile;
        this.secomndaryBinExportFile = secomndaryBinExportFile;
    }
    
    private String createUniqueExportFileName(final ESide eSide) {
        String s = "";
        if (this.primaryBinExportFile != null) {
            s = this.primaryBinExportFile.getName();
        }
        else if (this.primaryIDBFile != null) {
            s = this.primaryIDBFile.getName();
        }
        String s2 = CFileUtils.removeFileExtension(s);
        String s3 = "";
        if (this.secomndaryBinExportFile != null) {
            s3 = this.secomndaryBinExportFile.getName();
        }
        else if (this.secondaryIDBFile != null) {
            s3 = this.secondaryIDBFile.getName();
        }
        String s4 = CFileUtils.removeFileExtension(s3);
        if (s2.equals(s4)) {
            s2 = String.valueOf(s2).concat("_primary");
            s4 = String.valueOf(s4).concat("_secondary");
        }
        final String forceFilenameEndsWithExtension = CFileUtils.forceFilenameEndsWithExtension(s2, "BinExport");
        final String forceFilenameEndsWithExtension2 = CFileUtils.forceFilenameEndsWithExtension(s4, "BinExport");
        return (eSide == ESide.PRIMARY) ? forceFilenameEndsWithExtension : forceFilenameEndsWithExtension2;
    }
    
    @Override
    protected void runExpensiveCommand() {
        this.newDiff();
    }
    
    public String createNewDiff() {
        try {
            this.setDescription("Creating destination directory...");
            if (!this.destinationDirectory.isDirectory() && !this.destinationDirectory.mkdirs()) {
                Logger.logSevere("Could not create destination directory.", new Object[0]);
                CMessageBox.showError(this.parentWindow, "Could not create destination directory.");
                return null;
            }
            final String uniqueExportFileName = this.createUniqueExportFileName(ESide.PRIMARY);
            final String uniqueExportFileName2 = this.createUniqueExportFileName(ESide.SECONDARY);
            Label_0469: {
                if (this.primaryIDBFile != null) {
                    try {
                        final String value = String.valueOf(this.primaryIDBFile.getPath());
                        final String value2 = String.valueOf(this.destinationDirectory.getPath());
                        Logger.logInfo(new StringBuilder(32 + String.valueOf(value).length() + String.valueOf(value2).length()).append("- Exporting primary IDB '").append(value).append("' to '").append(value2).append("'").toString(), new Object[0]);
                        this.setDescription("Exporting primary IDB...");
                        final File idaExe = ExternalAppUtils.getIdaExe(this.primaryIDBFile);
                        if (idaExe == null || !idaExe.canExecute()) {
                            Logger.logSevere("Can't start disassembler. Please set correct path in the main settings first.", new Object[0]);
                            CMessageBox.showError(this.parentWindow, "Can't start disassembler. Please set correct path in the main settings first.");
                            return null;
                        }
                        ExportProcess.startExportProcess(idaExe, this.destinationDirectory, this.primaryIDBFile, uniqueExportFileName);
                        break Label_0469;
                    }
                    catch (BinExportException ex) {
                        Logger.logException(ex, ex.getMessage());
                        CMessageBox.showError(this.parentWindow, ex.getMessage());
                        try {
                            CFileUtils.deleteDirectory(this.destinationDirectory);
                        }
                        catch (IOException ex2) {
                            Logger.logException(ex2, String.format("Couldn't delete diff folder '%s' after diffing failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                            CMessageBox.showWarning(this.parentWindow, String.format("Couldn't delete diff folder '%s' after diffing failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                        }
                        return null;
                    }
                }
                if (this.primaryBinExportFile != null) {
                    try {
                        final File primaryBinExportFile = new File(String.format("%s%s%s", this.destinationDirectory.getPath(), File.separator, uniqueExportFileName));
                        if (!primaryBinExportFile.exists()) {
                            this.setDescription("Copying primary BinExport binary...");
                            ByteStreams.copy(new FileInputStream(this.primaryBinExportFile), new FileOutputStream(primaryBinExportFile));
                        }
                        this.primaryBinExportFile = primaryBinExportFile;
                    }
                    catch (IOException ex3) {
                        Logger.logException(ex3, "New Diff failed. Couldn't copy already exported primary binaries into the new diff directory.");
                        CMessageBox.showError(this.parentWindow, "New Diff failed. Couldn't copy already exported primary binaries into the new diff directory.");
                        try {
                            CFileUtils.deleteDirectory(this.destinationDirectory);
                        }
                        catch (IOException ex4) {
                            Logger.logException(ex4, String.format("Couldn't delete diff folder '%s' after diffing failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                            CMessageBox.showWarning(this.parentWindow, String.format("Couldn't delete diff folder '%s' after diffing failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                        }
                        return null;
                    }
                }
            }
            Label_0876: {
                if (this.secondaryIDBFile != null) {
                    try {
                        final String value3 = String.valueOf(this.secondaryIDBFile.getPath());
                        final String value4 = String.valueOf(this.destinationDirectory.getPath());
                        Logger.logInfo(new StringBuilder(34 + String.valueOf(value3).length() + String.valueOf(value4).length()).append("- Exporting secondary IDB '").append(value3).append("' to '").append(value4).append("'").toString(), new Object[0]);
                        this.setDescription("Exporting secondary IDB...");
                        final File idaExe2 = ExternalAppUtils.getIdaExe(this.secondaryIDBFile);
                        if (idaExe2 == null || !idaExe2.canExecute()) {
                            Logger.logSevere("Can't start disassembler. Please set correct path in the main settings first.", new Object[0]);
                            CMessageBox.showError(this.parentWindow, "Can't start disassembler. Please set correct path in the main settings first.");
                            return null;
                        }
                        ExportProcess.startExportProcess(idaExe2, this.destinationDirectory, this.secondaryIDBFile, uniqueExportFileName2);
                        break Label_0876;
                    }
                    catch (BinExportException ex5) {
                        Logger.logException(ex5, ex5.getMessage());
                        CMessageBox.showError(this.parentWindow, ex5.getMessage());
                        try {
                            CFileUtils.deleteDirectory(this.destinationDirectory);
                        }
                        catch (IOException ex6) {
                            Logger.logException(ex6, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                            CMessageBox.showWarning(this.parentWindow, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                        }
                        return null;
                    }
                }
                if (this.secomndaryBinExportFile != null) {
                    try {
                        final File secomndaryBinExportFile = new File(String.format("%s%s%s", this.destinationDirectory.getPath(), File.separator, uniqueExportFileName2));
                        if (!secomndaryBinExportFile.exists()) {
                            this.setDescription("Copying primary BinExport binary...");
                            ByteStreams.copy(new FileInputStream(this.secomndaryBinExportFile), new FileOutputStream(secomndaryBinExportFile));
                        }
                        this.secomndaryBinExportFile = secomndaryBinExportFile;
                    }
                    catch (IOException ex7) {
                        Logger.logException(ex7, "New Diff failed. Couldn't copy secondary BinExport binaries into the new diff directory.");
                        CMessageBox.showError(this.parentWindow, "New Diff failed. Couldn't copy secondary BinExport binaries into the new diff directory.");
                        try {
                            CFileUtils.deleteDirectory(this.destinationDirectory);
                        }
                        catch (IOException ex8) {
                            Logger.logException(ex8, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                            CMessageBox.showWarning(this.parentWindow, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", this.destinationDirectory.getPath()));
                        }
                        return null;
                    }
                }
                try {
                    final String commandLineDiffer = ExternalAppUtils.getCommandLineDiffer();
                    String s;
                    if (this.primaryIDBFile != null) {
                        s = ExportProcess.getExportedFileName(uniqueExportFileName, this.destinationDirectory);
                    }
                    else {
                        s = this.primaryBinExportFile.getPath();
                    }
                    String s2;
                    if (this.secondaryIDBFile != null) {
                        s2 = ExportProcess.getExportedFileName(uniqueExportFileName2, this.destinationDirectory);
                    }
                    else {
                        s2 = this.secomndaryBinExportFile.getPath();
                    }
                    final String value5 = String.valueOf(this.destinationDirectory.getName());
                    Logger.logInfo(new StringBuilder(18 + String.valueOf(value5).length()).append("- Start Diffing '").append(value5).append("'").toString(), new Object[0]);
                    this.setDescription("Diffing...");
                    DiffProcess.startDiffProcess(commandLineDiffer, s, s2, this.destinationDirectory);
                    final String binDiffFileName = DiffProcess.getBinDiffFileName(s, s2);
                    Logger.logInfo("- Diffing done successfully.'", new Object[0]);
                    return binDiffFileName;
                }
                catch (BinExportException ex9) {
                    Logger.logException(ex9, ex9.getMessage());
                    CMessageBox.showError(this.parentWindow, ex9.getMessage());
                }
                catch (DifferException ex10) {
                    Logger.logException(ex10, ex10.getMessage());
                    CMessageBox.showError(this.parentWindow, ex10.getMessage());
                }
            }
            return null;
        }
        catch (Exception ex11) {
            Logger.logException(ex11, "New Diff failed..");
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
            final File file = new File(this.matchedPath);
            if (file.exists()) {
                this.setDescription("Preloading Diff...");
                final DiffMetaData preloadDiffMatches = DiffLoader.preloadDiffMatches(file);
                this.setDescription("Adding Diff to workspace...");
                this.workspace.addDiff(file, preloadDiffMatches, false);
            }
            else {
                Logger.logSevere("Create and add new Diff to workspace failed. Diff binary does not exist.", new Object[0]);
                CMessageBox.showError(this.parentWindow, "Adding new Diff to workspace failed. Diff binary does not exist.");
            }
        }
        catch (SQLException ex) {
            Logger.logException(ex, "New Diff failed. Couldn't read matches database.");
            final MainWindow parentWindow = this.parentWindow;
            final String s = "New Diff failed. Couldn't read matches database: ";
            final String value = String.valueOf(ex.getMessage());
            CMessageBox.showError(parentWindow, (value.length() != 0) ? s.concat(value) : new String(s));
        }
    }
}
