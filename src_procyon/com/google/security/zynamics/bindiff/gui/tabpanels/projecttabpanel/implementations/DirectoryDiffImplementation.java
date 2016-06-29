package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.implementations;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import java.io.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.*;
import com.google.security.zynamics.bindiff.processes.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.diff.*;

public class DirectoryDiffImplementation extends CEndlessHelperThread
{
    private final List diffingErrorMessages;
    private final List openingDiffErrorMessages;
    private final MainWindow parentWindow;
    private final Workspace workspace;
    private final String primarySourcePath;
    private final String secondarySourcePath;
    private final List idbPairs;
    
    public DirectoryDiffImplementation(final MainWindow mainWindow, final Workspace workspace, final String s, final String s2, final List list) {
        this.diffingErrorMessages = new ArrayList();
        this.openingDiffErrorMessages = new ArrayList();
        this.parentWindow = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.primarySourcePath = (String)Preconditions.checkNotNull(s);
        this.secondarySourcePath = (String)Preconditions.checkNotNull(s2);
        this.idbPairs = (List)Preconditions.checkNotNull(list);
    }
    
    private String createUniqueExportFileName(final File file, final File file2, final ESide eSide) {
        String s = CFileUtils.removeFileExtension(file.getName());
        String s2 = CFileUtils.removeFileExtension(file2.getName());
        if (s.equals(s2)) {
            s = String.valueOf(s).concat("_primary");
            s2 = String.valueOf(s2).concat("_secondary");
        }
        final String forceFilenameEndsWithExtension = CFileUtils.forceFilenameEndsWithExtension(s, "BinExport");
        final String forceFilenameEndsWithExtension2 = CFileUtils.forceFilenameEndsWithExtension(s2, "BinExport");
        return (eSide == ESide.PRIMARY) ? forceFilenameEndsWithExtension : forceFilenameEndsWithExtension2;
    }
    
    private void deleteDirectory(final MainWindow mainWindow, final File file) {
        try {
            CFileUtils.deleteDirectory(file);
        }
        catch (IOException ex) {
            Logger.logException(ex, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", file.getPath()));
            CMessageBox.showWarning(mainWindow, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", file.getPath()));
        }
    }
    
    private List directoryDiff() {
        final ArrayList<String> list = new ArrayList<String>();
        final String commandLineDiffer = ExternalAppUtils.getCommandLineDiffer();
        if (!new File(commandLineDiffer).exists()) {
            final String format = String.format("Can't start directory diff. Couldn't find engine at '%s'", commandLineDiffer);
            Logger.logSevere(format, new Object[0]);
            CMessageBox.showError(this.parentWindow, format);
            return list;
        }
        final String primarySourcePath = this.primarySourcePath;
        final String secondarySourcePath = this.secondarySourcePath;
        Logger.logInfo(new StringBuilder(29 + String.valueOf(primarySourcePath).length() + String.valueOf(secondarySourcePath).length()).append("Start Directory Diff '").append(primarySourcePath).append("' vs '").append(secondarySourcePath).append("'").toString(), new Object[0]);
        final String path = this.workspace.getWorkspaceDir().getPath();
        for (final DiffPairTableData diffPairTableData : this.idbPairs) {
            final String format2 = String.format("%s%s%s", path, File.separator, diffPairTableData.getDestinationDirectory());
            final String format3 = String.format("%s%s%s%s%s", this.primarySourcePath, File.separator, diffPairTableData.getIDBLocation(), File.separator, diffPairTableData.getIDBName());
            final String format4 = String.format("%s%s%s%s%s", this.secondarySourcePath, File.separator, diffPairTableData.getIDBLocation(), File.separator, diffPairTableData.getIDBName());
            this.setDescription(String.format("%s vs %s", diffPairTableData.getIDBName(), diffPairTableData.getIDBName()));
            final File file = new File(format3);
            final File file2 = new File(format4);
            final String uniqueExportFileName = this.createUniqueExportFileName(file, file2, ESide.PRIMARY);
            final String uniqueExportFileName2 = this.createUniqueExportFileName(file, file2, ESide.SECONDARY);
            final File file3 = new File(format2);
            if (file3.exists()) {
                this.diffingErrorMessages.add(String.format("'%s' failed. Reason: Destination folder already exists.", diffPairTableData.getDestinationDirectory()));
            }
            else {
                file3.mkdir();
                if (!file3.exists()) {
                    this.diffingErrorMessages.add(String.format("'%s' failed. Reason: Destination folder cannot be created.", diffPairTableData.getDestinationDirectory()));
                }
                else {
                    try {
                        Logger.logInfo(new StringBuilder(39 + String.valueOf(format3).length() + String.valueOf(format2).length()).append(" - Start exporting primary IDB '").append(format3).append("' to '").append(format2).append("'").toString(), new Object[0]);
                        final File idaExe = ExternalAppUtils.getIdaExe(file);
                        if (idaExe == null || !idaExe.canExecute()) {
                            Logger.logSevere("Can't start disassembler. Please set correct path in the main settings first.", new Object[0]);
                            CMessageBox.showError(this.parentWindow, "Can't start disassembler. Please set correct path in the main settings first.");
                            this.deleteDirectory(this.parentWindow, file3);
                            return list;
                        }
                        ExportProcess.startExportProcess(idaExe, file3, file, uniqueExportFileName);
                        Logger.logInfo(new StringBuilder(56 + String.valueOf(format3).length() + String.valueOf(format2).length()).append(" - Finished exporting primary IDB '").append(format3).append("' to '").append(format2).append("' successfully.").toString(), new Object[0]);
                    }
                    catch (BinExportException ex) {
                        Logger.logInfo(" - Exporting primary '%s' to '%s' failed. Reason: %s", format3, format2, ex.getMessage());
                        this.diffingErrorMessages.add(String.format("Exporting primary '%s' failed. Reason: %s", format3, ex.getMessage()));
                        this.deleteDirectory(this.parentWindow, file3);
                        continue;
                    }
                    try {
                        Logger.logInfo(new StringBuilder(41 + String.valueOf(format4).length() + String.valueOf(format2).length()).append(" - Start exporting secondary IDB '").append(format4).append("' to '").append(format2).append("'").toString(), new Object[0]);
                        final File idaExe2 = ExternalAppUtils.getIdaExe(file2);
                        if (idaExe2 == null || !idaExe2.canExecute()) {
                            Logger.logSevere("Can't start disassembler. Please set correct path in the main settings first.", new Object[0]);
                            CMessageBox.showError(this.parentWindow, "Can't start disassembler. Please set correct path in the main settings first.");
                            return list;
                        }
                        ExportProcess.startExportProcess(idaExe2, file3, file2, uniqueExportFileName2);
                        Logger.logInfo(new StringBuilder(58 + String.valueOf(format4).length() + String.valueOf(format2).length()).append(" - Finished exporting secondary IDB '").append(format4).append("' to '").append(format2).append("' successfully.").toString(), new Object[0]);
                    }
                    catch (BinExportException ex2) {
                        Logger.logInfo(" - Exporting secondary '%s' to '%s' failed. Reason: %s", format4, format2, ex2.getMessage());
                        this.diffingErrorMessages.add(String.format("Exporting secondary '%s' failed. Reason: %s", format4, ex2.getMessage()));
                        this.deleteDirectory(this.parentWindow, file3);
                        continue;
                    }
                    try {
                        final String exportedFileName = ExportProcess.getExportedFileName(uniqueExportFileName, file3);
                        final String exportedFileName2 = ExportProcess.getExportedFileName(uniqueExportFileName2, file3);
                        final String value = String.valueOf(file3.getName());
                        Logger.logInfo(new StringBuilder(19 + String.valueOf(value).length()).append(" - Start Diffing '").append(value).append("'").toString(), new Object[0]);
                        DiffProcess.startDiffProcess(commandLineDiffer, exportedFileName, exportedFileName2, file3);
                        final String binDiffFileName = DiffProcess.getBinDiffFileName(exportedFileName, exportedFileName2);
                        Logger.logInfo(" - Diffing '%s' done successfully.", file3.getName());
                        list.add(binDiffFileName);
                    }
                    catch (BinExportException ex3) {
                        Logger.logInfo(" - Diffing '%s' failed. Reason: %s", file3.getName(), ex3.getMessage());
                        this.diffingErrorMessages.add(String.format("Diffing '%s' failed. Reason: %s", diffPairTableData.getDestinationDirectory(), ex3.getMessage()));
                    }
                    catch (DifferException ex4) {
                        Logger.logInfo(" - Diffing '%s' failed. Reason: %s", file3.getName(), ex4.getMessage());
                        this.diffingErrorMessages.add(String.format("Diffing '%s' failed. Reason: %s", diffPairTableData.getDestinationDirectory(), ex4.getMessage()));
                    }
                }
            }
        }
        if (this.diffingErrorMessages.size() == 0) {
            final String primarySourcePath2 = this.primarySourcePath;
            final String secondarySourcePath2 = this.secondarySourcePath;
            Logger.logInfo(new StringBuilder(46 + String.valueOf(primarySourcePath2).length() + String.valueOf(secondarySourcePath2).length()).append("Finished Directory Diff '").append(primarySourcePath2).append("' vs '").append(secondarySourcePath2).append("' successfully.").toString(), new Object[0]);
        }
        else {
            final String primarySourcePath3 = this.primarySourcePath;
            final String secondarySourcePath3 = this.secondarySourcePath;
            Logger.logInfo(new StringBuilder(45 + String.valueOf(primarySourcePath3).length() + String.valueOf(secondarySourcePath3).length()).append("Finished Directory Diff '").append(primarySourcePath3).append("' vs '").append(secondarySourcePath3).append("' with errors.").toString(), new Object[0]);
        }
        return list;
    }
    
    @Override
    protected void runExpensiveCommand() {
        final List directoryDiff = this.directoryDiff();
        if (directoryDiff.size() > 0) {
            this.setGeneralDescription("Preloading diffs...");
        }
        for (final String s : directoryDiff) {
            if (s == null) {
                continue;
            }
            final File file = new File(s);
            try {
                this.setDescription(String.format("Loading '%s'", file.getName()));
                if (!file.exists()) {
                    continue;
                }
                this.workspace.addDiff(file, DiffLoader.preloadDiffMatches(file), false);
            }
            catch (Exception ex) {
                this.openingDiffErrorMessages.add(String.format("Could not load '%s' into workspace.", file.getName()));
            }
        }
    }
    
    public List getDiffingErrorMessages() {
        return this.diffingErrorMessages;
    }
    
    public List getOpeningDiffErrorMessages() {
        return this.openingDiffErrorMessages;
    }
}
