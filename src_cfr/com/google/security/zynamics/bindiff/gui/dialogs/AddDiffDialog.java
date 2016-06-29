/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog$InternalDiffChooserListener;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.CFileChooser;
import com.google.security.zynamics.zylib.gui.CFileChooser$FileExtension;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AddDiffDialog
extends BaseDialog {
    private static int TEXTFIELD_WIDTH = 500;
    private static int LABEL_WIDTH = 180;
    private static int ROW_HEIGHT = 25;
    private final Workspace workspace;
    private final AddDiffDialog$InternalDiffChooserListener diffChooserListener;
    private final AddDiffDialog$InternalButtonListener buttonListener;
    private final JButton addButton;
    private final JButton cancelButton;
    private final FileChooserPanel diffChooser;
    private final JTextField primaryExportBinary;
    private final JTextField secondaryExportBinary;
    private final JTextField destinationDirName;
    private boolean diffPressed;

    public AddDiffDialog(Window window, Workspace workspace) {
        super(window, "Add Existing Diff");
        this.diffChooserListener = new AddDiffDialog$InternalDiffChooserListener(this, null);
        this.buttonListener = new AddDiffDialog$InternalButtonListener(this, null);
        this.addButton = new JButton(this.buttonListener);
        this.cancelButton = new JButton(this.buttonListener);
        this.diffChooser = new FileChooserPanel("", this.diffChooserListener, "...", TEXTFIELD_WIDTH, ROW_HEIGHT, 0);
        this.primaryExportBinary = new JTextField();
        this.secondaryExportBinary = new JTextField();
        this.destinationDirName = new JTextField();
        this.diffPressed = false;
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
        this.setVisible(true);
    }

    private static File chooseFile(Component component, String string, File file) {
        CFileChooser cFileChooser = new CFileChooser(new CFileChooser$FileExtension(String.format("BinDiff Matches Database (*.%s)", "BinDiff"), "BinDiff"));
        cFileChooser.setCurrentDirectory(file);
        cFileChooser.setApproveButtonText("Ok");
        cFileChooser.setDialogTitle(string);
        if (cFileChooser.showOpenDialog(component) != 0) return null;
        return cFileChooser.getSelectedFile();
    }

    private JPanel createButtonPanel() {
        this.addButton.setText("Add");
        this.cancelButton.setText("Cancel");
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(10, 0, 5, 5));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel2.add(this.addButton);
        jPanel2.add(this.cancelButton);
        jPanel.add((Component)jPanel2, "East");
        return jPanel;
    }

    private JPanel createDestinationFolderPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 0, 0, 0));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new TitledBorder("Diff Destination"));
        this.destinationDirName.setPreferredSize(new Dimension(this.destinationDirName.getPreferredSize().width, ROW_HEIGHT));
        jPanel2.add((Component)this.destinationDirName, "North");
        jPanel.add((Component)jPanel2, "North");
        return jPanel;
    }

    private JPanel createExportSourcesPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder("Export Binaries"));
        JPanel jPanel2 = new JPanel(new GridLayout(2, 1, 5, 5));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("Primary Callgraph:", LABEL_WIDTH, this.primaryExportBinary, ROW_HEIGHT));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("Secondary Callgraph:", LABEL_WIDTH, this.secondaryExportBinary, ROW_HEIGHT));
        jPanel.add((Component)jPanel2, "North");
        return jPanel;
    }

    private JPanel createFileChooserPane() {
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new TitledBorder("Diff Matches Database:"));
        jPanel2.add((Component)GuiUtils.createHorizontalNamedComponentPanel("Choose Diff:", LABEL_WIDTH, this.diffChooser, ROW_HEIGHT), "North");
        jPanel.add((Component)jPanel2, "North");
        jPanel.add((Component)this.createExportSourcesPanel(), "Center");
        return jPanel;
    }

    private Pair getIDBName(File file) {
        MatchesDatabase matchesDatabase = new MatchesDatabase(file);
        Throwable throwable = null;
        try {
            String[] arrstring = matchesDatabase.getIDBNames();
            Pair pair = new Pair(arrstring[0], arrstring[1]);
            return pair;
        }
        catch (Throwable var4_5) {
            throwable = var4_5;
            throw var4_5;
        }
        finally {
            if (matchesDatabase != null) {
                if (throwable != null) {
                    try {
                        matchesDatabase.close();
                    }
                    catch (Throwable var6_7) {
                        throwable.addSuppressed(var6_7);
                    }
                } else {
                    matchesDatabase.close();
                }
            }
        }
    }

    private void updatedExportedSources() {
        Pair pair;
        File file = new File(this.diffChooser.getText());
        try {
            pair = this.getIDBName(file);
        }
        catch (SQLException var3_3) {
            String string = String.valueOf(var3_3.getMessage());
            CMessageBox.showInformation(this, string.length() != 0 ? "Couldn't load necessary diff information: ".concat(string) : new String("Couldn't load necessary diff information: "));
            return;
        }
        String string = (String)pair.first();
        String string2 = (String)pair.second();
        if (string == null || "".equals(string) || string2 == null || "".equals(string2)) {
            CMessageBox.showInformation(this, "Couldn't load necessary diff information.");
            return;
        }
        String string3 = String.format("%s%s%s.%s", file.getParent(), File.separator, string, "BinExport");
        String string4 = String.format("%s%s%s.%s", file.getParent(), File.separator, string2, "BinExport");
        if (!new File(string3).exists()) {
            this.primaryExportBinary.setBackground(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND);
        } else {
            this.primaryExportBinary.setBackground(Colors.GRAY240);
        }
        if (!new File(string4).exists()) {
            this.secondaryExportBinary.setBackground(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND);
        } else {
            this.secondaryExportBinary.setBackground(Colors.GRAY240);
        }
        this.primaryExportBinary.setText(string3);
        this.secondaryExportBinary.setText(string4);
        String string5 = String.format("%s vs %s", string, string2);
        this.destinationDirName.setText(string5);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean validateDiffSources() {
        String string;
        File file = this.getMatchesBinary();
        File file2 = this.getBinExportBinary(ESide.PRIMARY);
        File file3 = this.getBinExportBinary(ESide.SECONDARY);
        File file4 = this.getDestinationDirectory();
        string = "";
        if (file == null) {
            string = "Can't add diff to workspace. Can't find matches binary.";
        } else if (file2 == null) {
            string = "Can't add diff to workspace. Can't find primary BinExport binary.";
        } else if (file3 == null) {
            string = "Can't add diff to workspace. Can't find secondary BinExport binary.";
        } else if (file4 == null) {
            string = "Can't add diff to workspace. Destination folder is not defined.";
        } else if (this.workspace.containsDiff(file.getPath())) {
            string = "Diff is already added to the workspace.";
        } else if (file4.exists() && file4.list().length != 0) {
            if (!file.getParent().equals(file4.getPath())) {
                string = "Can't add diff to workspace. Destination folder already exists in workspace.";
            } else if (this.workspace.containsDiff(file.getPath())) {
                string = "Can't add diff to workspace. Diff is already part of the current workspace.";
            }
        } else {
            try {
                if (!file4.mkdir()) {
                    string = "Can't add diff to workspace. Destination folder cannot be created.";
                }
            }
            catch (Exception var6_6) {
                string = "Can't add diff to workspace. Destination folder cannot be created.";
            }
            finally {
                file4.delete();
            }
        }
        if (string.equals("")) return string.equals("");
        CMessageBox.showInformation(this, string);
        return string.equals("");
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel.add((Component)this.createFileChooserPane(), "North");
        jPanel.add((Component)this.createDestinationFolderPanel(), "Center");
        jPanel.add((Component)this.createButtonPanel(), "South");
        this.primaryExportBinary.setEditable(false);
        this.secondaryExportBinary.setEditable(false);
        this.primaryExportBinary.setBorder(new LineBorder(Color.GRAY));
        this.secondaryExportBinary.setBorder(new LineBorder(Color.GRAY));
        this.add((Component)jPanel, "Center");
    }

    public boolean getAddButtonPressed() {
        return this.diffPressed;
    }

    public File getBinExportBinary(ESide eSide) {
        String string = eSide == ESide.PRIMARY ? this.primaryExportBinary.getText() : this.secondaryExportBinary.getText();
        if (!string.endsWith(".BinExport")) return null;
        File file = new File(string);
        if (!file.exists()) return null;
        return file;
    }

    public File getDestinationDirectory() {
        if (!this.destinationDirName.getText().equals("")) return new File(String.format("%s%s%s", this.workspace.getWorkspaceDirPath(), File.separator, this.destinationDirName.getText()));
        return null;
    }

    public File getMatchesBinary() {
        File file = new File(this.diffChooser.getText());
        if (!file.exists()) return null;
        return file;
    }

    static /* synthetic */ JButton access$200(AddDiffDialog addDiffDialog) {
        return addDiffDialog.addButton;
    }

    static /* synthetic */ boolean access$300(AddDiffDialog addDiffDialog) {
        return addDiffDialog.validateDiffSources();
    }

    static /* synthetic */ boolean access$402(AddDiffDialog addDiffDialog, boolean bl2) {
        addDiffDialog.diffPressed = bl2;
        return addDiffDialog.diffPressed;
    }

    static /* synthetic */ File access$500(Component component, String string, File file) {
        return AddDiffDialog.chooseFile(component, string, file);
    }

    static /* synthetic */ FileChooserPanel access$600(AddDiffDialog addDiffDialog) {
        return addDiffDialog.diffChooser;
    }

    static /* synthetic */ void access$700(AddDiffDialog addDiffDialog) {
        addDiffDialog.updatedExportedSources();
    }
}

