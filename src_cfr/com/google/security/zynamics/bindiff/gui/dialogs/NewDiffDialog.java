/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$InternalPrimaryFileChooserListener;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$InternalSecondaryFileChooserListener;
import com.google.security.zynamics.bindiff.project.diff.DiffDirectories;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CFileChooser;
import com.google.security.zynamics.zylib.gui.CFileChooser$FileExtension;
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
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class NewDiffDialog
extends BaseDialog {
    private static int IDB_FILEFILTER_INDEX = 0;
    private static int TEXTFIELD_WITH = 500;
    private static int LABEL_WITH = 180;
    private static int ROW_HEIGHT = 25;
    private final File workspaceDir;
    private final NewDiffDialog$InternalPrimaryFileChooserListener primaryFileListener;
    private final NewDiffDialog$InternalSecondaryFileChooserListener secondaryFileListener;
    private final NewDiffDialog$InternalButtonListener buttonListener;
    private final JButton diffButton;
    private final JButton cancelButton;
    private final FileChooserPanel primaryChooser;
    private final FileChooserPanel secondaryChooser;
    private final JTextField destinationDirName;
    private boolean diffPressed;
    private File lastSelectedFile;

    public NewDiffDialog(Window window, File file) {
        super(window, "New Diff");
        this.primaryFileListener = new NewDiffDialog$InternalPrimaryFileChooserListener(this, null);
        this.secondaryFileListener = new NewDiffDialog$InternalSecondaryFileChooserListener(this, null);
        this.buttonListener = new NewDiffDialog$InternalButtonListener(this, null);
        this.diffButton = new JButton(this.buttonListener);
        this.cancelButton = new JButton(this.buttonListener);
        this.primaryChooser = new FileChooserPanel("", this.primaryFileListener, "...", TEXTFIELD_WITH, ROW_HEIGHT, 0);
        this.secondaryChooser = new FileChooserPanel("", this.secondaryFileListener, "...", TEXTFIELD_WITH, ROW_HEIGHT, 0);
        this.destinationDirName = new JTextField();
        this.diffPressed = false;
        this.lastSelectedFile = null;
        this.workspaceDir = (File)Preconditions.checkNotNull(file);
        Preconditions.checkArgument(file.exists(), "Workspace directory doesn't exist.");
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
        this.setVisible(true);
    }

    private static File chooseFile(Component component, String string, File file, int n2) {
        CFileChooser cFileChooser = new CFileChooser(new CFileChooser$FileExtension(String.format("IDA Pro Database/BinExport Binary (*.%s;*.%s;*.%s)", "idb", "i64", "BinExport"), "idb", "i64", "BinExport"));
        cFileChooser.setCurrentDirectory(file);
        cFileChooser.setFileFilter(n2);
        cFileChooser.setApproveButtonText("Ok");
        cFileChooser.setDialogTitle(string);
        if (cFileChooser.showOpenDialog(component) != 0) return null;
        return cFileChooser.getSelectedFile();
    }

    private Component createButtonPanel() {
        this.diffButton.setText("Diff");
        this.cancelButton.setText("Cancel");
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(10, 0, 5, 5));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel2.add(this.diffButton);
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
        jPanel.add((Component)jPanel2, "Center");
        return jPanel;
    }

    private JPanel createFilesChooserPane() {
        JPanel jPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel jPanel3 = new JPanel(new GridLayout(1, 1, 5, 5));
        jPanel2.setBorder(new TitledBorder("Primary Source"));
        jPanel3.setBorder(new TitledBorder("Secondary Source"));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("Primary file:", LABEL_WITH, this.primaryChooser, ROW_HEIGHT));
        jPanel3.add(GuiUtils.createHorizontalNamedComponentPanel("Secondary file:", LABEL_WITH, this.secondaryChooser, ROW_HEIGHT));
        jPanel.add(jPanel2);
        jPanel.add(jPanel3);
        return jPanel;
    }

    private boolean isDiffExisting(File file) {
        String[] arrstring = file.list();
        int n2 = arrstring.length;
        int n3 = 0;
        while (n3 < n2) {
            String string = arrstring[n3];
            if (string.toLowerCase().endsWith("BinDiff".toLowerCase())) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    private void updateDestinationFolder() {
        String string = DiffDirectories.getDiffDestinationDirectoryName(this.primaryChooser.getText(), this.secondaryChooser.getText());
        this.destinationDirName.setText(string);
    }

    private boolean validateDiffSources() {
        File file = this.getIdb(ESide.PRIMARY);
        File file2 = this.getBinExportBinary(ESide.PRIMARY);
        if (file == null && file2 == null) {
            CMessageBox.showInformation(this, "Primary source files not set or do not exist.");
            return false;
        }
        File file3 = this.getIdb(ESide.SECONDARY);
        File file4 = this.getBinExportBinary(ESide.SECONDARY);
        if (file3 == null && file4 == null) {
            CMessageBox.showInformation(this, "Secondary source files not set or do not exist.");
            return false;
        }
        File file5 = this.getDestinationDirectory();
        if (file5 == null) {
            CMessageBox.showInformation(this, "Destination folder is not set.");
            return false;
        }
        if (file5.exists() && this.isDiffExisting(file5)) {
            CMessageBox.showInformation(this, "Diff file already exists in the workspace.");
            return false;
        }
        try {
            if (file5.exists()) return true;
            if (file5.mkdirs()) return true;
            CMessageBox.showInformation(this, "Could not create destination folder.");
            return false;
        }
        catch (SecurityException var6_6) {
            CMessageBox.showInformation(this, "Could not create destination folder.");
            return false;
        }
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel.add((Component)this.createFilesChooserPane(), "North");
        jPanel.add((Component)this.createDestinationFolderPanel(), "Center");
        jPanel.add(this.createButtonPanel(), "South");
        this.add((Component)jPanel, "Center");
    }

    public File getBinExportBinary(ESide eSide) {
        File file = new File(eSide == ESide.PRIMARY ? this.primaryChooser.getText() : this.secondaryChooser.getText());
        if (!file.exists()) return null;
        File file2 = file;
        return file2;
    }

    public File getDestinationDirectory() {
        if (!this.destinationDirName.getText().equals("")) return new File(String.format("%s%s%s", this.workspaceDir.getPath(), File.separator, this.destinationDirName.getText()));
        return null;
    }

    public boolean getDiffButtonPressed() {
        return this.diffPressed;
    }

    public File getIdb(ESide eSide) {
        String string;
        File file;
        String string2 = string = eSide == ESide.PRIMARY ? this.primaryChooser.getText() : this.secondaryChooser.getText();
        if (!string.endsWith(".idb")) {
            if (!string.endsWith(".i64")) return null;
        }
        if (!(file = new File(string)).exists()) return null;
        return file;
    }

    static /* synthetic */ JButton access$300(NewDiffDialog newDiffDialog) {
        return newDiffDialog.diffButton;
    }

    static /* synthetic */ boolean access$400(NewDiffDialog newDiffDialog) {
        return newDiffDialog.validateDiffSources();
    }

    static /* synthetic */ boolean access$502(NewDiffDialog newDiffDialog, boolean bl2) {
        newDiffDialog.diffPressed = bl2;
        return newDiffDialog.diffPressed;
    }

    static /* synthetic */ File access$600(NewDiffDialog newDiffDialog) {
        return newDiffDialog.lastSelectedFile;
    }

    static /* synthetic */ int access$700() {
        return IDB_FILEFILTER_INDEX;
    }

    static /* synthetic */ File access$800(Component component, String string, File file, int n2) {
        return NewDiffDialog.chooseFile(component, string, file, n2);
    }

    static /* synthetic */ FileChooserPanel access$900(NewDiffDialog newDiffDialog) {
        return newDiffDialog.primaryChooser;
    }

    static /* synthetic */ File access$602(NewDiffDialog newDiffDialog, File file) {
        newDiffDialog.lastSelectedFile = file;
        return newDiffDialog.lastSelectedFile;
    }

    static /* synthetic */ void access$1000(NewDiffDialog newDiffDialog) {
        newDiffDialog.updateDestinationFolder();
    }

    static /* synthetic */ FileChooserPanel access$1100(NewDiffDialog newDiffDialog) {
        return newDiffDialog.secondaryChooser;
    }
}

