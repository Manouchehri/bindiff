package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.zylib.gui.FileChooser.*;
import java.awt.event.*;
import java.io.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.io.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;

public class ExportViewDialog extends BaseDialog
{
    private static int DIALOG_WIDTH;
    private static int DIALOG_HEIGHT;
    private static int LABEL_WIDTH;
    private static int ROW_HEIGHT;
    private final Window window;
    private final String description;
    private final FileChooserPanel destinationChooserPanel;
    private final JTextField primaryImageName;
    private final JTextField secondaryImageName;
    private final JTextField combinedImageName;
    private final JComboBox imageFormat;
    private final JComboBox captureRegion;
    private final JButton okButton;
    private final JButton cancelButton;
    private final ActionListener directoryChooserListener;
    private final ActionListener buttonListener;
    private boolean okPressed;
    
    public ExportViewDialog(final Window window, final String s, final String description, final File file, final String s2) {
        super(window, s);
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.directoryChooserListener = new ExportViewDialog$InternalDestinationDirectoryListener(this, null);
        this.buttonListener = new ExportViewDialog$InternalButtonListener(this, null);
        this.okPressed = false;
        this.window = window;
        this.description = description;
        this.okButton.addActionListener(this.buttonListener);
        this.cancelButton.addActionListener(this.buttonListener);
        this.destinationChooserPanel = new FileChooserPanel(file.getPath(), this.directoryChooserListener, "...", 0, ExportViewDialog.ROW_HEIGHT, 0);
        final String s3 = "primary_";
        final String value = String.valueOf(s2);
        this.primaryImageName = new JTextField((value.length() != 0) ? s3.concat(value) : new String(s3));
        final String s4 = "secondary_";
        final String value2 = String.valueOf(s2);
        this.secondaryImageName = new JTextField((value2.length() != 0) ? s4.concat(value2) : new String(s4));
        final String s5 = "combined_";
        final String value3 = String.valueOf(s2);
        this.combinedImageName = new JTextField((value3.length() != 0) ? s5.concat(value3) : new String(s5));
        (this.imageFormat = new JComboBox()).addItem("PNG");
        this.imageFormat.addItem("JPEG");
        this.imageFormat.addItem("GIF");
        this.imageFormat.addItem("SVG");
        (this.captureRegion = new JComboBox()).addItem("Graph");
        this.captureRegion.addItem("View");
        this.init();
        this.setSize(ExportViewDialog.DIALOG_WIDTH, ExportViewDialog.DIALOG_HEIGHT);
        this.setMinimumSize(new Dimension(ExportViewDialog.DIALOG_WIDTH, ExportViewDialog.DIALOG_HEIGHT));
        GuiHelper.centerChildToParent(window, this, true);
    }
    
    private boolean confirmOverwrites() {
        String s = "";
        final File primaryImageFile = this.getPrimaryImageFile();
        if (primaryImageFile.exists()) {
            final String value = String.valueOf(s);
            final String value2 = String.valueOf(primaryImageFile.getPath());
            s = new StringBuilder(1 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(value2).append("\n").toString();
        }
        final File secondaryImageFile = this.getSecondaryImageFile();
        if (secondaryImageFile.exists()) {
            final String value3 = String.valueOf(s);
            final String value4 = String.valueOf(secondaryImageFile.getPath());
            s = new StringBuilder(1 + String.valueOf(value3).length() + String.valueOf(value4).length()).append(value3).append(value4).append("\n").toString();
        }
        final File combinedImageFile = this.getCombinedImageFile();
        if (combinedImageFile.exists()) {
            final String value5 = String.valueOf(s);
            final String value6 = String.valueOf(combinedImageFile.getPath());
            s = new StringBuilder(1 + String.valueOf(value5).length() + String.valueOf(value6).length()).append(value5).append(value6).append("\n").toString();
        }
        return s.equals("") || CMessageBox.showYesNoQuestion(this, String.format("%s\n These files already exist. Overwrite?", s)) == 0;
    }
    
    private File getImageFile(final String s) {
        String replace = this.destinationChooserPanel.getText().replace('\\', File.separatorChar).replace('/', File.separatorChar);
        if (!replace.endsWith(File.separator)) {
            final String value = String.valueOf(replace);
            final String value2 = String.valueOf(File.separator);
            replace = ((value2.length() != 0) ? value.concat(value2) : new String(value));
        }
        final String[] array = { ".png", ".jpeg", ".gif", ".svg" };
        final String value3 = String.valueOf(replace);
        final String s2 = array[this.imageFormat.getSelectedIndex()];
        return new File(new StringBuilder(0 + String.valueOf(value3).length() + String.valueOf(s).length() + String.valueOf(s2).length()).append(value3).append(s).append(s2).toString());
    }
    
    private String selectDirectory(final Window window) {
        final DirectoryChooser directoryChooser = new DirectoryChooser("Choose Destination Directory");
        directoryChooser.setCurrentDirectory(new File(this.destinationChooserPanel.getText()));
        if (directoryChooser.showOpenDialog(window) == 0) {
            return directoryChooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    
    private boolean validatePaths() {
        try {
            final File primaryImageFile = this.getPrimaryImageFile();
            if (primaryImageFile.createNewFile()) {
                primaryImageFile.delete();
            }
            final File secondaryImageFile = this.getSecondaryImageFile();
            if (secondaryImageFile.createNewFile()) {
                secondaryImageFile.delete();
            }
            final File combinedImageFile = this.getCombinedImageFile();
            if (combinedImageFile.createNewFile()) {
                combinedImageFile.delete();
            }
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        final JPanel panel2 = new JPanel(new GridLayout(6, 1, 3, 3));
        panel2.setBorder(new TitledBorder(this.description));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Destination directory:", ExportViewDialog.LABEL_WIDTH, this.destinationChooserPanel, ExportViewDialog.ROW_HEIGHT));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Primary image name:", ExportViewDialog.LABEL_WIDTH, this.primaryImageName, ExportViewDialog.ROW_HEIGHT));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Secondary image name:", ExportViewDialog.LABEL_WIDTH, this.secondaryImageName, ExportViewDialog.ROW_HEIGHT));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Combined image name:", ExportViewDialog.LABEL_WIDTH, this.combinedImageName, ExportViewDialog.ROW_HEIGHT));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Image file format:", ExportViewDialog.LABEL_WIDTH, this.imageFormat, ExportViewDialog.ROW_HEIGHT));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Clip Area:", ExportViewDialog.LABEL_WIDTH, this.captureRegion, ExportViewDialog.ROW_HEIGHT));
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(new EmptyBorder(8, 5, 5, 5));
        final JPanel panel4 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel4.add(this.okButton);
        panel4.add(this.cancelButton);
        panel3.add(panel4, "East");
        panel.add(panel2, "North");
        panel.add(panel3, "South");
        this.add(panel, "Center");
        this.pack();
    }
    
    @Override
    public void dispose() {
        this.okButton.removeActionListener(this.buttonListener);
        this.cancelButton.removeActionListener(this.buttonListener);
        super.dispose();
    }
    
    public File getCombinedImageFile() {
        return this.getImageFile(this.combinedImageName.getText());
    }
    
    public File getPrimaryImageFile() {
        return this.getImageFile(this.primaryImageName.getText());
    }
    
    public File getSecondaryImageFile() {
        return this.getImageFile(this.secondaryImageName.getText());
    }
    
    public boolean isCaptureAll() {
        return this.captureRegion.getSelectedIndex() == 0;
    }
    
    public boolean isCapturePart() {
        return this.captureRegion.getSelectedIndex() == 1;
    }
    
    public boolean isGIF() {
        return this.imageFormat.getSelectedIndex() == 2;
    }
    
    public boolean isJPEG() {
        return this.imageFormat.getSelectedIndex() == 1;
    }
    
    public boolean isOkPressed() {
        return this.okPressed;
    }
    
    public boolean isPNG() {
        return this.imageFormat.getSelectedIndex() == 0;
    }
    
    public boolean isSVG() {
        return this.imageFormat.getSelectedIndex() == 3;
    }
    
    static {
        ExportViewDialog.DIALOG_WIDTH = 600;
        ExportViewDialog.DIALOG_HEIGHT = 263;
        ExportViewDialog.LABEL_WIDTH = 200;
        ExportViewDialog.ROW_HEIGHT = 25;
    }
}
