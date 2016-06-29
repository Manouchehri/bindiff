package com.google.security.zynamics.bindiff.gui.dialogs;

import java.io.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import java.awt.event.*;
import com.google.common.base.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.*;

public class NewDiffDialog extends BaseDialog
{
    private static int IDB_FILEFILTER_INDEX;
    private static int TEXTFIELD_WITH;
    private static int LABEL_WITH;
    private static int ROW_HEIGHT;
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
    
    public NewDiffDialog(final Window window, final File file) {
        super(window, "New Diff");
        this.primaryFileListener = new NewDiffDialog$InternalPrimaryFileChooserListener(this, null);
        this.secondaryFileListener = new NewDiffDialog$InternalSecondaryFileChooserListener(this, null);
        this.buttonListener = new NewDiffDialog$InternalButtonListener(this, null);
        this.diffButton = new JButton(this.buttonListener);
        this.cancelButton = new JButton(this.buttonListener);
        this.primaryChooser = new FileChooserPanel("", this.primaryFileListener, "...", NewDiffDialog.TEXTFIELD_WITH, NewDiffDialog.ROW_HEIGHT, 0);
        this.secondaryChooser = new FileChooserPanel("", this.secondaryFileListener, "...", NewDiffDialog.TEXTFIELD_WITH, NewDiffDialog.ROW_HEIGHT, 0);
        this.destinationDirName = new JTextField();
        this.diffPressed = false;
        this.lastSelectedFile = null;
        this.workspaceDir = (File)Preconditions.checkNotNull(file);
        Preconditions.checkArgument(file.exists(), (Object)"Workspace directory doesn't exist.");
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
        this.setVisible(true);
    }
    
    private static File chooseFile(final Component component, final String dialogTitle, final File currentDirectory, final int fileFilter) {
        final CFileChooser cFileChooser = new CFileChooser(new CFileChooser$FileExtension[] { new CFileChooser$FileExtension(String.format("IDA Pro Database/BinExport Binary (*.%s;*.%s;*.%s)", "idb", "i64", "BinExport"), new String[] { "idb", "i64", "BinExport" }) });
        cFileChooser.setCurrentDirectory(currentDirectory);
        cFileChooser.setFileFilter(fileFilter);
        cFileChooser.setApproveButtonText("Ok");
        cFileChooser.setDialogTitle(dialogTitle);
        if (cFileChooser.showOpenDialog(component) == 0) {
            return cFileChooser.getSelectedFile();
        }
        return null;
    }
    
    private Component createButtonPanel() {
        this.diffButton.setText("Diff");
        this.cancelButton.setText("Cancel");
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 0, 5, 5));
        final JPanel panel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel2.add(this.diffButton);
        panel2.add(this.cancelButton);
        panel.add(panel2, "East");
        return panel;
    }
    
    private JPanel createDestinationFolderPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 0, 0, 0));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new TitledBorder("Diff Destination"));
        this.destinationDirName.setPreferredSize(new Dimension(this.destinationDirName.getPreferredSize().width, NewDiffDialog.ROW_HEIGHT));
        panel2.add(this.destinationDirName, "North");
        panel.add(panel2, "Center");
        return panel;
    }
    
    private JPanel createFilesChooserPane() {
        final JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        final JPanel panel2 = new JPanel(new GridLayout(1, 1, 5, 5));
        final JPanel panel3 = new JPanel(new GridLayout(1, 1, 5, 5));
        panel2.setBorder(new TitledBorder("Primary Source"));
        panel3.setBorder(new TitledBorder("Secondary Source"));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Primary file:", NewDiffDialog.LABEL_WITH, this.primaryChooser, NewDiffDialog.ROW_HEIGHT));
        panel3.add(GuiUtils.createHorizontalNamedComponentPanel("Secondary file:", NewDiffDialog.LABEL_WITH, this.secondaryChooser, NewDiffDialog.ROW_HEIGHT));
        panel.add(panel2);
        panel.add(panel3);
        return panel;
    }
    
    private boolean isDiffExisting(final File file) {
        final String[] list = file.list();
        for (int length = list.length, i = 0; i < length; ++i) {
            if (list[i].toLowerCase().endsWith("BinDiff".toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    
    private void updateDestinationFolder() {
        this.destinationDirName.setText(DiffDirectories.getDiffDestinationDirectoryName(this.primaryChooser.getText(), this.secondaryChooser.getText()));
    }
    
    private boolean validateDiffSources() {
        final File idb = this.getIdb(ESide.PRIMARY);
        final File binExportBinary = this.getBinExportBinary(ESide.PRIMARY);
        if (idb == null && binExportBinary == null) {
            CMessageBox.showInformation(this, "Primary source files not set or do not exist.");
            return false;
        }
        final File idb2 = this.getIdb(ESide.SECONDARY);
        final File binExportBinary2 = this.getBinExportBinary(ESide.SECONDARY);
        if (idb2 == null && binExportBinary2 == null) {
            CMessageBox.showInformation(this, "Secondary source files not set or do not exist.");
            return false;
        }
        final File destinationDirectory = this.getDestinationDirectory();
        if (destinationDirectory == null) {
            CMessageBox.showInformation(this, "Destination folder is not set.");
            return false;
        }
        if (destinationDirectory.exists() && this.isDiffExisting(destinationDirectory)) {
            CMessageBox.showInformation(this, "Diff file already exists in the workspace.");
            return false;
        }
        try {
            if (!destinationDirectory.exists() && !destinationDirectory.mkdirs()) {
                CMessageBox.showInformation(this, "Could not create destination folder.");
                return false;
            }
        }
        catch (SecurityException ex) {
            CMessageBox.showInformation(this, "Could not create destination folder.");
            return false;
        }
        return true;
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.add(this.createFilesChooserPane(), "North");
        panel.add(this.createDestinationFolderPanel(), "Center");
        panel.add(this.createButtonPanel(), "South");
        this.add(panel, "Center");
    }
    
    public File getBinExportBinary(final ESide eSide) {
        final File file = new File((eSide == ESide.PRIMARY) ? this.primaryChooser.getText() : this.secondaryChooser.getText());
        return file.exists() ? file : null;
    }
    
    public File getDestinationDirectory() {
        if (this.destinationDirName.getText().equals("")) {
            return null;
        }
        return new File(String.format("%s%s%s", this.workspaceDir.getPath(), File.separator, this.destinationDirName.getText()));
    }
    
    public boolean getDiffButtonPressed() {
        return this.diffPressed;
    }
    
    public File getIdb(final ESide eSide) {
        final String s = (eSide == ESide.PRIMARY) ? this.primaryChooser.getText() : this.secondaryChooser.getText();
        if (s.endsWith(".idb") || s.endsWith(".i64")) {
            final File file = new File(s);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }
    
    static {
        NewDiffDialog.IDB_FILEFILTER_INDEX = 0;
        NewDiffDialog.TEXTFIELD_WITH = 500;
        NewDiffDialog.LABEL_WITH = 180;
        NewDiffDialog.ROW_HEIGHT = 25;
    }
}
