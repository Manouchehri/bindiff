/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DiffPairTableData;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog$InternalDirectoryChooserListener;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.IdbPairTable;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.IdbPairTableModel;
import com.google.security.zynamics.zylib.gui.CFileChooser;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class DirectoryDiffDialog
extends BaseDialog {
    private static int DLG_WIDTH = 800;
    private static int DLG_HEIGHT = 400;
    private static int MAX_LISTED_FILES = 16;
    private final DirectoryDiffDialog$InternalDirectoryChooserListener dirChooserListener;
    private final DirectoryDiffDialog$InternalButtonListener buttonListener;
    private final FileChooserPanel primaryDirChooser;
    private final FileChooserPanel secondaryDirChooser;
    private final JButton selectAllButton;
    private final JButton deselectAllButton;
    private final JButton diffButton;
    private final JButton cancelButton;
    private final IdbPairTable diffsTable;
    private final String workspacePath;
    private boolean diffButtonPressed;

    public DirectoryDiffDialog(Window window, File file) {
        super(window, "Directory Diff");
        this.dirChooserListener = new DirectoryDiffDialog$InternalDirectoryChooserListener(this, null);
        this.buttonListener = new DirectoryDiffDialog$InternalButtonListener(this, null);
        this.primaryDirChooser = new FileChooserPanel("", this.dirChooserListener);
        this.secondaryDirChooser = new FileChooserPanel("", this.dirChooserListener);
        this.selectAllButton = new JButton(this.buttonListener);
        this.deselectAllButton = new JButton(this.buttonListener);
        this.diffButton = new JButton(this.buttonListener);
        this.cancelButton = new JButton(this.buttonListener);
        this.diffButtonPressed = true;
        Preconditions.checkNotNull(file);
        Preconditions.checkArgument(file.exists(), "Workspace directory doesn't exist");
        this.workspacePath = file.getPath();
        this.diffsTable = new IdbPairTable(file, new IdbPairTableModel());
        this.init();
        this.pack();
        this.setPreferredSize(new Dimension(DLG_WIDTH, DLG_HEIGHT));
        this.setSize(new Dimension(DLG_WIDTH, DLG_HEIGHT));
        GuiHelper.centerChildToParent(window, this, true);
        this.setVisible(true);
    }

    private File chooseFile(Component component, ESide eSide) {
        String string;
        File file;
        CFileChooser cFileChooser = new CFileChooser();
        if (eSide == ESide.PRIMARY) {
            string = "Choose Primary Directory";
            file = new File(this.secondaryDirChooser.getText()).getParentFile();
            if (file != null) {
                BinDiffConfigFile.getInstance().getMainSettings().setDirectoryDiffLastPrimaryDir(file.getPath());
            }
        } else {
            if (eSide != ESide.SECONDARY) {
                if ($assertionsDisabled) throw new RuntimeException();
                throw new AssertionError();
            }
            string = "Choose Secondary Directory";
            file = new File(this.primaryDirChooser.getText()).getParentFile();
            if (file != null) {
                BinDiffConfigFile.getInstance().getMainSettings().setDirectoryDiffLastSecondaryDir(file.getPath());
            }
        }
        cFileChooser.setCurrentDirectory(file);
        cFileChooser.setFileSelectionMode(1);
        cFileChooser.setApproveButtonText("Ok");
        cFileChooser.setDialogTitle(string);
        boolean bl2 = false;
        while (!bl2) {
            if (0 != cFileChooser.showOpenDialog(component)) return null;
            File file2 = cFileChooser.getSelectedFile();
            if (!file2.exists()) {
                CMessageBox.showInformation(component, "The selected file does not exist.");
                continue;
            }
            if (!file2.isDirectory()) {
                CMessageBox.showInformation(component, "The selected file must be a directory.");
                continue;
            }
            if (!file2.getPath().equals(ESide.PRIMARY == eSide ? this.secondaryDirChooser.getText() : this.primaryDirChooser.getText())) return file2;
            CMessageBox.showInformation(component, "Primary and secondary directory cannot be identical.");
        }
        return null;
    }

    private Component createButtonsPanel() {
        this.selectAllButton.setText("Select All");
        this.deselectAllButton.setText("Deselect All");
        this.diffButton.setText("Diff");
        this.cancelButton.setText("Cancel");
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel2.add(this.selectAllButton);
        jPanel2.add(this.deselectAllButton);
        JPanel jPanel3 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel3.add(this.diffButton);
        jPanel3.add(this.cancelButton);
        jPanel.add((Component)jPanel2, "West");
        jPanel.add((Component)jPanel3, "East");
        return jPanel;
    }

    private Component createFileChooserPanel() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new TitledBorder("Primary Directory"));
        jPanel2.add((Component)this.primaryDirChooser, "Center");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(new TitledBorder("Secondary Directory"));
        jPanel3.add((Component)this.secondaryDirChooser, "Center");
        jPanel.add(jPanel2);
        jPanel.add(jPanel3);
        return jPanel;
    }

    private Component createTablePanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder("Found IDB Pairs"));
        JScrollPane jScrollPane = new JScrollPane(this.diffsTable);
        jPanel.add((Component)jScrollPane, "Center");
        return jPanel;
    }

    /*
     * Unable to fully structure code
     */
    private String cutErrorMessage(String var1_1) {
        var2_2 = "";
        var3_3 = 0;
        var4_4 = 0;
        var5_5 = 0;
        do lbl-1000: // 3 sources:
        {
            if (var3_3 == -1) return var1_1;
            var3_3 = var1_1.indexOf("\n", var4_4);
            if (var4_4 == -1) ** GOTO lbl-1000
            var4_4 = var3_3 + 1;
        } while (++var5_5 < DirectoryDiffDialog.MAX_LISTED_FILES);
        var2_2 = var1_1.substring(0, var4_4);
        return String.valueOf(var2_2).concat("...");
    }

    private void selectAll(boolean bl2) {
        IdbPairTableModel idbPairTableModel = this.diffsTable.getTableModel();
        List list = idbPairTableModel.getTableData();
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) {
                idbPairTableModel.fireTableDataChanged();
                return;
            }
            DiffPairTableData diffPairTableData = (DiffPairTableData)iterator.next();
            diffPairTableData.getSelectionCheckBox().setSelected(bl2);
        } while (true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean validateSelectedDiffs() {
        String string = "";
        String string2 = "";
        String string3 = "";
        List list = this.getSelectedIdbPairs();
        if (list.size() == 0) {
            CMessageBox.showInformation(this, "Can't start diff process. There is no diff selected.");
            return false;
        }
        for (DiffPairTableData diffPairTableData : list) {
            File file;
            String string4;
            string4 = String.format("%s%s%s", this.workspacePath, File.separator, diffPairTableData.getDestinationDirectory());
            file = new File(string4);
            try {
                if (!file.mkdir()) {
                    String string5 = String.valueOf(string);
                    String string6 = String.valueOf(String.format(" - %s", String.valueOf(string4).concat("\n")));
                    string = string6.length() != 0 ? string5.concat(string6) : new String(string5);
                }
            }
            catch (Exception var9_10) {
                String string7 = String.valueOf(string);
                String string8 = String.valueOf(String.format(" - %s", String.valueOf(string4).concat("\n")));
                string = string8.length() != 0 ? string7.concat(string8) : new String(string7);
            }
            finally {
                file.delete();
            }
            String string9 = diffPairTableData.getIDBLocation();
            if (!string9.endsWith(File.separator)) {
                String string10 = String.valueOf(string9);
                String string11 = String.valueOf(File.separator);
                string9 = string11.length() != 0 ? string10.concat(string11) : new String(string10);
            }
            String string12 = String.format("%s%s%s", this.getSourceBasePath(ESide.PRIMARY), string9, diffPairTableData.getIDBName());
            String string13 = String.format("%s%s%s", this.getSourceBasePath(ESide.SECONDARY), string9, diffPairTableData.getIDBName());
            File file2 = new File(string12);
            File file3 = new File(string13);
            if (!file2.exists()) {
                String string14 = String.valueOf(string2);
                String string15 = String.valueOf(String.format(" - %s", String.valueOf(string12).concat("\n")));
                String string16 = string2 = string15.length() != 0 ? string14.concat(string15) : new String(string14);
            }
            if (!file3.exists()) {
                String string17 = String.valueOf(string2);
                String string18 = String.valueOf(String.format(" - %s", String.valueOf(string13).concat("\n")));
                String string19 = string2 = string18.length() != 0 ? string17.concat(string18) : new String(string17);
            }
            if (!file.exists()) continue;
            String string20 = String.valueOf(string3);
            String string21 = String.valueOf(String.format(" - %s", String.valueOf(string4).concat("\n")));
            string3 = string21.length() != 0 ? string20.concat(string21) : new String(string20);
        }
        string = this.cutErrorMessage(string);
        string2 = this.cutErrorMessage(string2);
        if (!(string3 = this.cutErrorMessage(string3)).equals("")) {
            string3 = String.format("%s\n\n%s", "Can't start diff process. Some diff destination folders already exist.\nPlease rename affected destination folders.", string3);
            CMessageBox.showInformation(this, string3);
            return false;
        }
        if (!string.equals("")) {
            string = String.format("%s\n\n%s", "Can't start diff process. Some destination folders cannot be created.", string);
            CMessageBox.showInformation(this, string);
            return false;
        }
        if (string2.equals("")) return true;
        string2 = String.format("%s\n\n%s", "Can't start diff process. Can't find some source files.", string2);
        CMessageBox.showInformation(this, string2);
        return false;
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel.add(this.createFileChooserPanel(), "North");
        jPanel.add(this.createTablePanel(), "Center");
        jPanel.add(this.createButtonsPanel(), "South");
        this.add((Component)jPanel, "Center");
    }

    public boolean getDiffButtonPressed() {
        return this.diffButtonPressed;
    }

    public List getSelectedIdbPairs() {
        ArrayList<DiffPairTableData> arrayList = new ArrayList<DiffPairTableData>();
        IdbPairTableModel idbPairTableModel = this.diffsTable.getTableModel();
        Iterator iterator = idbPairTableModel.getTableData().iterator();
        while (iterator.hasNext()) {
            DiffPairTableData diffPairTableData = (DiffPairTableData)iterator.next();
            if (!diffPairTableData.getSelectionCheckBox().isSelected()) continue;
            arrayList.add(diffPairTableData);
        }
        return arrayList;
    }

    public String getSourceBasePath(ESide eSide) {
        String string;
        if (eSide == ESide.PRIMARY) {
            string = this.primaryDirChooser.getText();
            return string;
        }
        string = this.secondaryDirChooser.getText();
        return string;
    }

    static /* synthetic */ JButton access$200(DirectoryDiffDialog directoryDiffDialog) {
        return directoryDiffDialog.selectAllButton;
    }

    static /* synthetic */ void access$300(DirectoryDiffDialog directoryDiffDialog, boolean bl2) {
        directoryDiffDialog.selectAll(bl2);
    }

    static /* synthetic */ JButton access$400(DirectoryDiffDialog directoryDiffDialog) {
        return directoryDiffDialog.deselectAllButton;
    }

    static /* synthetic */ JButton access$500(DirectoryDiffDialog directoryDiffDialog) {
        return directoryDiffDialog.diffButton;
    }

    static /* synthetic */ IdbPairTable access$600(DirectoryDiffDialog directoryDiffDialog) {
        return directoryDiffDialog.diffsTable;
    }

    static /* synthetic */ boolean access$700(DirectoryDiffDialog directoryDiffDialog) {
        return directoryDiffDialog.validateSelectedDiffs();
    }

    static /* synthetic */ boolean access$802(DirectoryDiffDialog directoryDiffDialog, boolean bl2) {
        directoryDiffDialog.diffButtonPressed = bl2;
        return directoryDiffDialog.diffButtonPressed;
    }

    static /* synthetic */ FileChooserPanel access$900(DirectoryDiffDialog directoryDiffDialog) {
        return directoryDiffDialog.primaryDirChooser;
    }

    static /* synthetic */ FileChooserPanel access$1000(DirectoryDiffDialog directoryDiffDialog) {
        return directoryDiffDialog.secondaryDirChooser;
    }

    static /* synthetic */ File access$1100(DirectoryDiffDialog directoryDiffDialog, Component component, ESide eSide) {
        return directoryDiffDialog.chooseFile(component, eSide);
    }
}

