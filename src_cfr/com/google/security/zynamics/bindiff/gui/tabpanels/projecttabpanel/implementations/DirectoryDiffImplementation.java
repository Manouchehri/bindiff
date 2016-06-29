/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.implementations;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.exceptions.BinExportException;
import com.google.security.zynamics.bindiff.exceptions.DifferException;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DiffPairTableData;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirectoryDiffImplementation
extends CEndlessHelperThread {
    private final List diffingErrorMessages = new ArrayList();
    private final List openingDiffErrorMessages = new ArrayList();
    private final MainWindow parentWindow;
    private final Workspace workspace;
    private final String primarySourcePath;
    private final String secondarySourcePath;
    private final List idbPairs;

    public DirectoryDiffImplementation(MainWindow mainWindow, Workspace workspace, String string, String string2, List list) {
        this.parentWindow = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.primarySourcePath = (String)Preconditions.checkNotNull(string);
        this.secondarySourcePath = (String)Preconditions.checkNotNull(string2);
        this.idbPairs = (List)Preconditions.checkNotNull(list);
    }

    private String createUniqueExportFileName(File file, File file2, ESide eSide) {
        String string;
        String string2 = file.getName();
        string2 = CFileUtils.removeFileExtension(string2);
        String string3 = file2.getName();
        if (string2.equals(string3 = CFileUtils.removeFileExtension(string3))) {
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

    private void deleteDirectory(MainWindow mainWindow, File file) {
        try {
            CFileUtils.deleteDirectory(file);
            return;
        }
        catch (IOException var3_3) {
            Logger.logException(var3_3, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", file.getPath()));
            CMessageBox.showWarning(mainWindow, String.format("Couldn't delete diff folder '%s' after exporting failed.\nPlease delete this folder manually.", file.getPath()));
        }
    }

    private List directoryDiff() {
        Object object;
        ArrayList<String> arrayList = new ArrayList<String>();
        String string = ExternalAppUtils.getCommandLineDiffer();
        if (!new File(string).exists()) {
            String string2 = String.format("Can't start directory diff. Couldn't find engine at '%s'", string);
            Logger.logSevere(string2, new Object[0]);
            CMessageBox.showError(this.parentWindow, string2);
            return arrayList;
        }
        String string3 = this.primarySourcePath;
        Object object2 = this.secondarySourcePath;
        Logger.logInfo(new StringBuilder(29 + String.valueOf(string3).length() + String.valueOf(object2).length()).append("Start Directory Diff '").append(string3).append("' vs '").append((String)object2).append("'").toString(), new Object[0]);
        string3 = this.workspace.getWorkspaceDir().getPath();
        object2 = this.idbPairs;
        Object object3 = object2.iterator();
        while (object3.hasNext()) {
            String string4;
            Object object4;
            object = (DiffPairTableData)object3.next();
            String string5 = String.format("%s%s%s", string3, File.separator, object.getDestinationDirectory());
            String string6 = String.format("%s%s%s%s%s", this.primarySourcePath, File.separator, object.getIDBLocation(), File.separator, object.getIDBName());
            String string7 = String.format("%s%s%s%s%s", this.secondarySourcePath, File.separator, object.getIDBLocation(), File.separator, object.getIDBName());
            this.setDescription(String.format("%s vs %s", object.getIDBName(), object.getIDBName()));
            File file = new File(string6);
            File file2 = new File(string7);
            String string8 = this.createUniqueExportFileName(file, file2, ESide.PRIMARY);
            String string9 = this.createUniqueExportFileName(file, file2, ESide.SECONDARY);
            File file3 = new File(string5);
            if (file3.exists()) {
                object4 = String.format("'%s' failed. Reason: Destination folder already exists.", object.getDestinationDirectory());
                this.diffingErrorMessages.add(object4);
                continue;
            }
            file3.mkdir();
            if (!file3.exists()) {
                object4 = String.format("'%s' failed. Reason: Destination folder cannot be created.", object.getDestinationDirectory());
                this.diffingErrorMessages.add(object4);
                continue;
            }
            try {
                Logger.logInfo(new StringBuilder(39 + String.valueOf(string6).length() + String.valueOf(string5).length()).append(" - Start exporting primary IDB '").append(string6).append("' to '").append(string5).append("'").toString(), new Object[0]);
                object4 = ExternalAppUtils.getIdaExe(file);
                if (object4 == null || !object4.canExecute()) {
                    string4 = "Can't start disassembler. Please set correct path in the main settings first.";
                    Logger.logSevere("Can't start disassembler. Please set correct path in the main settings first.", new Object[0]);
                    CMessageBox.showError(this.parentWindow, "Can't start disassembler. Please set correct path in the main settings first.");
                    this.deleteDirectory(this.parentWindow, file3);
                    return arrayList;
                }
                ExportProcess.startExportProcess((File)object4, file3, file, string8);
                Logger.logInfo(new StringBuilder(56 + String.valueOf(string6).length() + String.valueOf(string5).length()).append(" - Finished exporting primary IDB '").append(string6).append("' to '").append(string5).append("' successfully.").toString(), new Object[0]);
            }
            catch (BinExportException var15_17) {
                Logger.logInfo(" - Exporting primary '%s' to '%s' failed. Reason: %s", string6, string5, var15_17.getMessage());
                string4 = String.format("Exporting primary '%s' failed. Reason: %s", string6, var15_17.getMessage());
                this.diffingErrorMessages.add(string4);
                this.deleteDirectory(this.parentWindow, file3);
                continue;
            }
            try {
                Logger.logInfo(new StringBuilder(41 + String.valueOf(string7).length() + String.valueOf(string5).length()).append(" - Start exporting secondary IDB '").append(string7).append("' to '").append(string5).append("'").toString(), new Object[0]);
                object4 = ExternalAppUtils.getIdaExe(file2);
                if (object4 == null || !object4.canExecute()) {
                    string4 = "Can't start disassembler. Please set correct path in the main settings first.";
                    Logger.logSevere("Can't start disassembler. Please set correct path in the main settings first.", new Object[0]);
                    CMessageBox.showError(this.parentWindow, "Can't start disassembler. Please set correct path in the main settings first.");
                    return arrayList;
                }
                ExportProcess.startExportProcess((File)object4, file3, file2, string9);
                Logger.logInfo(new StringBuilder(58 + String.valueOf(string7).length() + String.valueOf(string5).length()).append(" - Finished exporting secondary IDB '").append(string7).append("' to '").append(string5).append("' successfully.").toString(), new Object[0]);
            }
            catch (BinExportException var15_18) {
                Logger.logInfo(" - Exporting secondary '%s' to '%s' failed. Reason: %s", string7, string5, var15_18.getMessage());
                string4 = String.format("Exporting secondary '%s' failed. Reason: %s", string7, var15_18.getMessage());
                this.diffingErrorMessages.add(string4);
                this.deleteDirectory(this.parentWindow, file3);
                continue;
            }
            try {
                object4 = ExportProcess.getExportedFileName(string8, file3);
                string4 = ExportProcess.getExportedFileName(string9, file3);
                String string10 = String.valueOf(file3.getName());
                Logger.logInfo(new StringBuilder(19 + String.valueOf(string10).length()).append(" - Start Diffing '").append(string10).append("'").toString(), new Object[0]);
                DiffProcess.startDiffProcess(string, (String)object4, string4, file3);
                string10 = DiffProcess.getBinDiffFileName((String)object4, string4);
                Logger.logInfo(" - Diffing '%s' done successfully.", file3.getName());
                arrayList.add(string10);
            }
            catch (BinExportException var15_19) {
                Logger.logInfo(" - Diffing '%s' failed. Reason: %s", file3.getName(), var15_19.getMessage());
                string4 = String.format("Diffing '%s' failed. Reason: %s", object.getDestinationDirectory(), var15_19.getMessage());
                this.diffingErrorMessages.add(string4);
            }
            catch (DifferException var15_20) {
                Logger.logInfo(" - Diffing '%s' failed. Reason: %s", file3.getName(), var15_20.getMessage());
                string4 = String.format("Diffing '%s' failed. Reason: %s", object.getDestinationDirectory(), var15_20.getMessage());
                this.diffingErrorMessages.add(string4);
            }
        }
        if (this.diffingErrorMessages.size() == 0) {
            object3 = this.primarySourcePath;
            object = this.secondarySourcePath;
            Logger.logInfo(new StringBuilder(46 + String.valueOf(object3).length() + String.valueOf(object).length()).append("Finished Directory Diff '").append((String)object3).append("' vs '").append((String)object).append("' successfully.").toString(), new Object[0]);
            return arrayList;
        }
        object3 = this.primarySourcePath;
        object = this.secondarySourcePath;
        Logger.logInfo(new StringBuilder(45 + String.valueOf(object3).length() + String.valueOf(object).length()).append("Finished Directory Diff '").append((String)object3).append("' vs '").append((String)object).append("' with errors.").toString(), new Object[0]);
        return arrayList;
    }

    @Override
    protected void runExpensiveCommand() {
        List list = this.directoryDiff();
        if (list.size() > 0) {
            this.setGeneralDescription("Preloading diffs...");
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            if (string == null) continue;
            File file = new File(string);
            try {
                this.setDescription(String.format("Loading '%s'", file.getName()));
                if (!file.exists()) continue;
                DiffMetaData diffMetaData = DiffLoader.preloadDiffMatches(file);
                this.workspace.addDiff(file, diffMetaData, false);
            }
            catch (Exception var5_6) {
                String string2 = String.format("Could not load '%s' into workspace.", file.getName());
                this.openingDiffErrorMessages.add(string2);
                continue;
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

