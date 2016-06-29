package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import java.awt.event.*;
import com.google.common.base.*;
import java.io.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.database.*;
import com.google.security.zynamics.zylib.gui.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.*;
import javax.swing.border.*;

public class AddDiffDialog extends BaseDialog
{
    private static int TEXTFIELD_WIDTH;
    private static int LABEL_WIDTH;
    private static int ROW_HEIGHT;
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
    
    public AddDiffDialog(final Window window, final Workspace workspace) {
        super(window, "Add Existing Diff");
        this.diffChooserListener = new AddDiffDialog$InternalDiffChooserListener(this, null);
        this.buttonListener = new AddDiffDialog$InternalButtonListener(this, null);
        this.addButton = new JButton(this.buttonListener);
        this.cancelButton = new JButton(this.buttonListener);
        this.diffChooser = new FileChooserPanel("", this.diffChooserListener, "...", AddDiffDialog.TEXTFIELD_WIDTH, AddDiffDialog.ROW_HEIGHT, 0);
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
    
    private static File chooseFile(final Component component, final String dialogTitle, final File currentDirectory) {
        final CFileChooser cFileChooser = new CFileChooser(new CFileChooser$FileExtension[] { new CFileChooser$FileExtension(String.format("BinDiff Matches Database (*.%s)", "BinDiff"), new String[] { "BinDiff" }) });
        cFileChooser.setCurrentDirectory(currentDirectory);
        cFileChooser.setApproveButtonText("Ok");
        cFileChooser.setDialogTitle(dialogTitle);
        if (cFileChooser.showOpenDialog(component) == 0) {
            return cFileChooser.getSelectedFile();
        }
        return null;
    }
    
    private JPanel createButtonPanel() {
        this.addButton.setText("Add");
        this.cancelButton.setText("Cancel");
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 0, 5, 5));
        final JPanel panel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel2.add(this.addButton);
        panel2.add(this.cancelButton);
        panel.add(panel2, "East");
        return panel;
    }
    
    private JPanel createDestinationFolderPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 0, 0, 0));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new TitledBorder("Diff Destination"));
        this.destinationDirName.setPreferredSize(new Dimension(this.destinationDirName.getPreferredSize().width, AddDiffDialog.ROW_HEIGHT));
        panel2.add(this.destinationDirName, "North");
        panel.add(panel2, "North");
        return panel;
    }
    
    private JPanel createExportSourcesPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Export Binaries"));
        final JPanel panel2 = new JPanel(new GridLayout(2, 1, 5, 5));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Primary Callgraph:", AddDiffDialog.LABEL_WIDTH, this.primaryExportBinary, AddDiffDialog.ROW_HEIGHT));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Secondary Callgraph:", AddDiffDialog.LABEL_WIDTH, this.secondaryExportBinary, AddDiffDialog.ROW_HEIGHT));
        panel.add(panel2, "North");
        return panel;
    }
    
    private JPanel createFileChooserPane() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new TitledBorder("Diff Matches Database:"));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Choose Diff:", AddDiffDialog.LABEL_WIDTH, this.diffChooser, AddDiffDialog.ROW_HEIGHT), "North");
        panel.add(panel2, "North");
        panel.add(this.createExportSourcesPanel(), "Center");
        return panel;
    }
    
    private Pair getIDBName(final File file) {
        try (final MatchesDatabase matchesDatabase = new MatchesDatabase(file)) {
            final String[] idbNames = matchesDatabase.getIDBNames();
            return new Pair(idbNames[0], idbNames[1]);
        }
    }
    
    private void updatedExportedSources() {
        final File file = new File(this.diffChooser.getText());
        Pair idbName;
        try {
            idbName = this.getIDBName(file);
        }
        catch (SQLException ex) {
            final String s = "Couldn't load necessary diff information: ";
            final String value = String.valueOf(ex.getMessage());
            CMessageBox.showInformation(this, (value.length() != 0) ? s.concat(value) : new String(s));
            return;
        }
        final String s2 = (String)idbName.first();
        final String s3 = (String)idbName.second();
        if (s2 == null || "".equals(s2) || s3 == null || "".equals(s3)) {
            CMessageBox.showInformation(this, "Couldn't load necessary diff information.");
            return;
        }
        final String format = String.format("%s%s%s.%s", file.getParent(), File.separator, s2, "BinExport");
        final String format2 = String.format("%s%s%s.%s", file.getParent(), File.separator, s3, "BinExport");
        if (!new File(format).exists()) {
            this.primaryExportBinary.setBackground(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND);
        }
        else {
            this.primaryExportBinary.setBackground(Colors.GRAY240);
        }
        if (!new File(format2).exists()) {
            this.secondaryExportBinary.setBackground(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND);
        }
        else {
            this.secondaryExportBinary.setBackground(Colors.GRAY240);
        }
        this.primaryExportBinary.setText(format);
        this.secondaryExportBinary.setText(format2);
        this.destinationDirName.setText(String.format("%s vs %s", s2, s3));
    }
    
    private boolean validateDiffSources() {
        final File matchesBinary = this.getMatchesBinary();
        final File binExportBinary = this.getBinExportBinary(ESide.PRIMARY);
        final File binExportBinary2 = this.getBinExportBinary(ESide.SECONDARY);
        final File destinationDirectory = this.getDestinationDirectory();
        String s = "";
        if (matchesBinary == null) {
            s = "Can't add diff to workspace. Can't find matches binary.";
        }
        else if (binExportBinary == null) {
            s = "Can't add diff to workspace. Can't find primary BinExport binary.";
        }
        else if (binExportBinary2 == null) {
            s = "Can't add diff to workspace. Can't find secondary BinExport binary.";
        }
        else if (destinationDirectory == null) {
            s = "Can't add diff to workspace. Destination folder is not defined.";
        }
        else if (this.workspace.containsDiff(matchesBinary.getPath())) {
            s = "Diff is already added to the workspace.";
        }
        else if (destinationDirectory.exists() && destinationDirectory.list().length != 0) {
            if (!matchesBinary.getParent().equals(destinationDirectory.getPath())) {
                s = "Can't add diff to workspace. Destination folder already exists in workspace.";
            }
            else if (this.workspace.containsDiff(matchesBinary.getPath())) {
                s = "Can't add diff to workspace. Diff is already part of the current workspace.";
            }
        }
        else {
            try {
                if (!destinationDirectory.mkdir()) {
                    s = "Can't add diff to workspace. Destination folder cannot be created.";
                }
            }
            catch (Exception ex) {
                s = "Can't add diff to workspace. Destination folder cannot be created.";
            }
            finally {
                destinationDirectory.delete();
            }
        }
        if (!s.equals("")) {
            CMessageBox.showInformation(this, s);
        }
        return s.equals("");
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.add(this.createFileChooserPane(), "North");
        panel.add(this.createDestinationFolderPanel(), "Center");
        panel.add(this.createButtonPanel(), "South");
        this.primaryExportBinary.setEditable(false);
        this.secondaryExportBinary.setEditable(false);
        this.primaryExportBinary.setBorder(new LineBorder(Color.GRAY));
        this.secondaryExportBinary.setBorder(new LineBorder(Color.GRAY));
        this.add(panel, "Center");
    }
    
    public boolean getAddButtonPressed() {
        return this.diffPressed;
    }
    
    public File getBinExportBinary(final ESide eSide) {
        final String s = (eSide == ESide.PRIMARY) ? this.primaryExportBinary.getText() : this.secondaryExportBinary.getText();
        if (s.endsWith(".BinExport")) {
            final File file = new File(s);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }
    
    public File getDestinationDirectory() {
        if (this.destinationDirName.getText().equals("")) {
            return null;
        }
        return new File(String.format("%s%s%s", this.workspace.getWorkspaceDirPath(), File.separator, this.destinationDirName.getText()));
    }
    
    public File getMatchesBinary() {
        final File file = new File(this.diffChooser.getText());
        if (file.exists()) {
            return file;
        }
        return null;
    }
    
    static {
        AddDiffDialog.TEXTFIELD_WIDTH = 500;
        AddDiffDialog.LABEL_WIDTH = 180;
        AddDiffDialog.ROW_HEIGHT = 25;
    }
}
