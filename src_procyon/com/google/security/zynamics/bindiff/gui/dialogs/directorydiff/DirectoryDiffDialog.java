package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import java.io.*;
import java.awt.event.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;
import java.util.*;

public class DirectoryDiffDialog extends BaseDialog
{
    private static int DLG_WIDTH;
    private static int DLG_HEIGHT;
    private static int MAX_LISTED_FILES;
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
    
    public DirectoryDiffDialog(final Window window, final File file) {
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
        Preconditions.checkArgument(file.exists(), (Object)"Workspace directory doesn't exist");
        this.workspacePath = file.getPath();
        this.diffsTable = new IdbPairTable(file, new IdbPairTableModel());
        this.init();
        this.pack();
        this.setPreferredSize(new Dimension(DirectoryDiffDialog.DLG_WIDTH, DirectoryDiffDialog.DLG_HEIGHT));
        this.setSize(new Dimension(DirectoryDiffDialog.DLG_WIDTH, DirectoryDiffDialog.DLG_HEIGHT));
        GuiHelper.centerChildToParent(window, this, true);
        this.setVisible(true);
    }
    
    private File chooseFile(final Component component, final ESide eSide) {
        final CFileChooser cFileChooser = new CFileChooser();
        String dialogTitle;
        File currentDirectory;
        if (eSide == ESide.PRIMARY) {
            dialogTitle = "Choose Primary Directory";
            currentDirectory = new File(this.secondaryDirChooser.getText()).getParentFile();
            if (currentDirectory != null) {
                BinDiffConfigFile.getInstance().getMainSettings().setDirectoryDiffLastPrimaryDir(currentDirectory.getPath());
            }
        }
        else if (eSide == ESide.SECONDARY) {
            dialogTitle = "Choose Secondary Directory";
            currentDirectory = new File(this.primaryDirChooser.getText()).getParentFile();
            if (currentDirectory != null) {
                BinDiffConfigFile.getInstance().getMainSettings().setDirectoryDiffLastSecondaryDir(currentDirectory.getPath());
            }
        }
        else {
            assert false;
            throw new RuntimeException();
        }
        cFileChooser.setCurrentDirectory(currentDirectory);
        cFileChooser.setFileSelectionMode(1);
        cFileChooser.setApproveButtonText("Ok");
        cFileChooser.setDialogTitle(dialogTitle);
        int i = 0;
        while (i == 0) {
            if (0 == cFileChooser.showOpenDialog(component)) {
                final File selectedFile = cFileChooser.getSelectedFile();
                if (!selectedFile.exists()) {
                    CMessageBox.showInformation(component, "The selected file does not exist.");
                }
                else if (!selectedFile.isDirectory()) {
                    CMessageBox.showInformation(component, "The selected file must be a directory.");
                }
                else {
                    if (!selectedFile.getPath().equals((ESide.PRIMARY == eSide) ? this.secondaryDirChooser.getText() : this.primaryDirChooser.getText())) {
                        return selectedFile;
                    }
                    CMessageBox.showInformation(component, "Primary and secondary directory cannot be identical.");
                }
            }
            else {
                i = 1;
            }
        }
        return null;
    }
    
    private Component createButtonsPanel() {
        this.selectAllButton.setText("Select All");
        this.deselectAllButton.setText("Deselect All");
        this.diffButton.setText("Diff");
        this.cancelButton.setText("Cancel");
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        final JPanel panel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel2.add(this.selectAllButton);
        panel2.add(this.deselectAllButton);
        final JPanel panel3 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel3.add(this.diffButton);
        panel3.add(this.cancelButton);
        panel.add(panel2, "West");
        panel.add(panel3, "East");
        return panel;
    }
    
    private Component createFileChooserPanel() {
        final JPanel panel = new JPanel(new GridLayout(1, 2, 5, 5));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new TitledBorder("Primary Directory"));
        panel2.add(this.primaryDirChooser, "Center");
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(new TitledBorder("Secondary Directory"));
        panel3.add(this.secondaryDirChooser, "Center");
        panel.add(panel2);
        panel.add(panel3);
        return panel;
    }
    
    private Component createTablePanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Found IDB Pairs"));
        panel.add(new JScrollPane(this.diffsTable), "Center");
        return panel;
    }
    
    private String cutErrorMessage(final String s) {
        int i = 0;
        int n = 0;
        int n2 = 0;
        while (i != -1) {
            i = s.indexOf("\n", n);
            if (n != -1) {
                ++n2;
                n = i + 1;
                if (n2 >= DirectoryDiffDialog.MAX_LISTED_FILES) {
                    return String.valueOf(s.substring(0, n)).concat("...");
                }
                continue;
            }
        }
        return s;
    }
    
    private void selectAll(final boolean selected) {
        final IdbPairTableModel tableModel = this.diffsTable.getTableModel();
        final Iterator iterator = tableModel.getTableData().iterator();
        while (iterator.hasNext()) {
            iterator.next().getSelectionCheckBox().setSelected(selected);
        }
        tableModel.fireTableDataChanged();
    }
    
    private boolean validateSelectedDiffs() {
        String s = "";
        String s2 = "";
        String s3 = "";
        final List selectedIdbPairs = this.getSelectedIdbPairs();
        if (selectedIdbPairs.size() == 0) {
            CMessageBox.showInformation(this, "Can't start diff process. There is no diff selected.");
            return false;
        }
        for (final DiffPairTableData diffPairTableData : selectedIdbPairs) {
            final String format = String.format("%s%s%s", this.workspacePath, File.separator, diffPairTableData.getDestinationDirectory());
            final File file = new File(format);
            try {
                if (!file.mkdir()) {
                    final String value = String.valueOf(s);
                    final String value2 = String.valueOf(String.format(" - %s", String.valueOf(format).concat("\n")));
                    s = ((value2.length() != 0) ? value.concat(value2) : new String(value));
                }
            }
            catch (Exception ex) {
                final String value3 = String.valueOf(s);
                final String value4 = String.valueOf(String.format(" - %s", String.valueOf(format).concat("\n")));
                s = ((value4.length() != 0) ? value3.concat(value4) : new String(value3));
            }
            finally {
                file.delete();
            }
            String idbLocation = diffPairTableData.getIDBLocation();
            if (!idbLocation.endsWith(File.separator)) {
                final String value5 = String.valueOf(idbLocation);
                final String value6 = String.valueOf(File.separator);
                idbLocation = ((value6.length() != 0) ? value5.concat(value6) : new String(value5));
            }
            final String format2 = String.format("%s%s%s", this.getSourceBasePath(ESide.PRIMARY), idbLocation, diffPairTableData.getIDBName());
            final String format3 = String.format("%s%s%s", this.getSourceBasePath(ESide.SECONDARY), idbLocation, diffPairTableData.getIDBName());
            final File file2 = new File(format2);
            final File file3 = new File(format3);
            if (!file2.exists()) {
                final String value7 = String.valueOf(s2);
                final String value8 = String.valueOf(String.format(" - %s", String.valueOf(format2).concat("\n")));
                s2 = ((value8.length() != 0) ? value7.concat(value8) : new String(value7));
            }
            if (!file3.exists()) {
                final String value9 = String.valueOf(s2);
                final String value10 = String.valueOf(String.format(" - %s", String.valueOf(format3).concat("\n")));
                s2 = ((value10.length() != 0) ? value9.concat(value10) : new String(value9));
            }
            if (file.exists()) {
                final String value11 = String.valueOf(s3);
                final String value12 = String.valueOf(String.format(" - %s", String.valueOf(format).concat("\n")));
                s3 = ((value12.length() != 0) ? value11.concat(value12) : new String(value11));
            }
        }
        final String cutErrorMessage = this.cutErrorMessage(s);
        final String cutErrorMessage2 = this.cutErrorMessage(s2);
        final String cutErrorMessage3 = this.cutErrorMessage(s3);
        if (!cutErrorMessage3.equals("")) {
            CMessageBox.showInformation(this, String.format("%s\n\n%s", "Can't start diff process. Some diff destination folders already exist.\nPlease rename affected destination folders.", cutErrorMessage3));
            return false;
        }
        if (!cutErrorMessage.equals("")) {
            CMessageBox.showInformation(this, String.format("%s\n\n%s", "Can't start diff process. Some destination folders cannot be created.", cutErrorMessage));
            return false;
        }
        if (!cutErrorMessage2.equals("")) {
            CMessageBox.showInformation(this, String.format("%s\n\n%s", "Can't start diff process. Can't find some source files.", cutErrorMessage2));
            return false;
        }
        return true;
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.add(this.createFileChooserPanel(), "North");
        panel.add(this.createTablePanel(), "Center");
        panel.add(this.createButtonsPanel(), "South");
        this.add(panel, "Center");
    }
    
    public boolean getDiffButtonPressed() {
        return this.diffButtonPressed;
    }
    
    public List getSelectedIdbPairs() {
        final ArrayList<DiffPairTableData> list = new ArrayList<DiffPairTableData>();
        for (final DiffPairTableData diffPairTableData : this.diffsTable.getTableModel().getTableData()) {
            if (diffPairTableData.getSelectionCheckBox().isSelected()) {
                list.add(diffPairTableData);
            }
        }
        return list;
    }
    
    public String getSourceBasePath(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.primaryDirChooser.getText() : this.secondaryDirChooser.getText();
    }
    
    static {
        DirectoryDiffDialog.DLG_WIDTH = 800;
        DirectoryDiffDialog.DLG_HEIGHT = 400;
        DirectoryDiffDialog.MAX_LISTED_FILES = 16;
    }
}
