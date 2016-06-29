/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog$InternalDestinationDirectoryListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.io.DirectoryChooser;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ExportViewDialog
extends BaseDialog {
    private static int DIALOG_WIDTH = 600;
    private static int DIALOG_HEIGHT = 263;
    private static int LABEL_WIDTH = 200;
    private static int ROW_HEIGHT = 25;
    private final Window window;
    private final String description;
    private final FileChooserPanel destinationChooserPanel;
    private final JTextField primaryImageName;
    private final JTextField secondaryImageName;
    private final JTextField combinedImageName;
    private final JComboBox imageFormat;
    private final JComboBox captureRegion;
    private final JButton okButton = new JButton("Ok");
    private final JButton cancelButton = new JButton("Cancel");
    private final ActionListener directoryChooserListener;
    private final ActionListener buttonListener;
    private boolean okPressed;

    public ExportViewDialog(Window window, String string, String string2, File file, String string3) {
        super(window, string);
        this.directoryChooserListener = new ExportViewDialog$InternalDestinationDirectoryListener(this, null);
        this.buttonListener = new ExportViewDialog$InternalButtonListener(this, null);
        this.okPressed = false;
        this.window = window;
        this.description = string2;
        this.okButton.addActionListener(this.buttonListener);
        this.cancelButton.addActionListener(this.buttonListener);
        this.destinationChooserPanel = new FileChooserPanel(file.getPath(), this.directoryChooserListener, "...", 0, ROW_HEIGHT, 0);
        String string4 = String.valueOf(string3);
        this.primaryImageName = new JTextField(string4.length() != 0 ? "primary_".concat(string4) : new String("primary_"));
        String string5 = String.valueOf(string3);
        this.secondaryImageName = new JTextField(string5.length() != 0 ? "secondary_".concat(string5) : new String("secondary_"));
        String string6 = String.valueOf(string3);
        this.combinedImageName = new JTextField(string6.length() != 0 ? "combined_".concat(string6) : new String("combined_"));
        this.imageFormat = new JComboBox();
        this.imageFormat.addItem("PNG");
        this.imageFormat.addItem("JPEG");
        this.imageFormat.addItem("GIF");
        this.imageFormat.addItem("SVG");
        this.captureRegion = new JComboBox();
        this.captureRegion.addItem("Graph");
        this.captureRegion.addItem("View");
        this.init();
        this.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
        this.setMinimumSize(new Dimension(DIALOG_WIDTH, DIALOG_HEIGHT));
        GuiHelper.centerChildToParent(window, this, true);
    }

    private boolean confirmOverwrites() {
        Object object;
        Object object2;
        String string;
        String string2 = "";
        File file = this.getPrimaryImageFile();
        if (file.exists()) {
            object2 = String.valueOf(string2);
            object = String.valueOf(file.getPath());
            string2 = new StringBuilder(1 + String.valueOf(object2).length() + String.valueOf(object).length()).append((String)object2).append((String)object).append("\n").toString();
        }
        if ((object2 = this.getSecondaryImageFile()).exists()) {
            object = String.valueOf(string2);
            string = String.valueOf(object2.getPath());
            string2 = new StringBuilder(1 + String.valueOf(object).length() + String.valueOf(string).length()).append((String)object).append(string).append("\n").toString();
        }
        if ((object = this.getCombinedImageFile()).exists()) {
            string = String.valueOf(string2);
            String string3 = String.valueOf(object.getPath());
            string2 = new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(string3).length()).append(string).append(string3).append("\n").toString();
        }
        if (string2.equals("")) return true;
        if (CMessageBox.showYesNoQuestion(this, String.format("%s\n These files already exist. Overwrite?", string2)) != 0) return false;
        return true;
    }

    private File getImageFile(String string) {
        String string2 = this.destinationChooserPanel.getText().replace('\\', File.separatorChar).replace('/', File.separatorChar);
        if (!string2.endsWith(File.separator)) {
            String string3 = String.valueOf(string2);
            String string4 = String.valueOf(File.separator);
            string2 = string4.length() != 0 ? string3.concat(string4) : new String(string3);
        }
        String[] arrstring = new String[]{".png", ".jpeg", ".gif", ".svg"};
        String string5 = String.valueOf(string2);
        String string6 = arrstring[this.imageFormat.getSelectedIndex()];
        string2 = new StringBuilder(0 + String.valueOf(string5).length() + String.valueOf(string).length() + String.valueOf(string6).length()).append(string5).append(string).append(string6).toString();
        return new File(string2);
    }

    private String selectDirectory(Window window) {
        DirectoryChooser directoryChooser = new DirectoryChooser("Choose Destination Directory");
        directoryChooser.setCurrentDirectory(new File(this.destinationChooserPanel.getText()));
        if (directoryChooser.showOpenDialog(window) != 0) return null;
        return directoryChooser.getSelectedFile().getAbsolutePath();
    }

    private boolean validatePaths() {
        try {
            File file;
            File file2;
            File file3 = this.getPrimaryImageFile();
            if (file3.createNewFile()) {
                file3.delete();
            }
            if ((file2 = this.getSecondaryImageFile()).createNewFile()) {
                file2.delete();
            }
            if (!(file = this.getCombinedImageFile()).createNewFile()) return true;
            file.delete();
            return true;
        }
        catch (Exception var1_2) {
            return false;
        }
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel jPanel2 = new JPanel(new GridLayout(6, 1, 3, 3));
        jPanel2.setBorder(new TitledBorder(this.description));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("Destination directory:", LABEL_WIDTH, this.destinationChooserPanel, ROW_HEIGHT));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("Primary image name:", LABEL_WIDTH, this.primaryImageName, ROW_HEIGHT));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("Secondary image name:", LABEL_WIDTH, this.secondaryImageName, ROW_HEIGHT));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("Combined image name:", LABEL_WIDTH, this.combinedImageName, ROW_HEIGHT));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("Image file format:", LABEL_WIDTH, this.imageFormat, ROW_HEIGHT));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("Clip Area:", LABEL_WIDTH, this.captureRegion, ROW_HEIGHT));
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(new EmptyBorder(8, 5, 5, 5));
        JPanel jPanel4 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel4.add(this.okButton);
        jPanel4.add(this.cancelButton);
        jPanel3.add((Component)jPanel4, "East");
        jPanel.add((Component)jPanel2, "North");
        jPanel.add((Component)jPanel3, "South");
        this.add((Component)jPanel, "Center");
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
        if (this.captureRegion.getSelectedIndex() != 0) return false;
        return true;
    }

    public boolean isCapturePart() {
        if (this.captureRegion.getSelectedIndex() != 1) return false;
        return true;
    }

    public boolean isGIF() {
        if (this.imageFormat.getSelectedIndex() != 2) return false;
        return true;
    }

    public boolean isJPEG() {
        if (this.imageFormat.getSelectedIndex() != 1) return false;
        return true;
    }

    public boolean isOkPressed() {
        return this.okPressed;
    }

    public boolean isPNG() {
        if (this.imageFormat.getSelectedIndex() != 0) return false;
        return true;
    }

    public boolean isSVG() {
        if (this.imageFormat.getSelectedIndex() != 3) return false;
        return true;
    }

    static /* synthetic */ JButton access$200(ExportViewDialog exportViewDialog) {
        return exportViewDialog.okButton;
    }

    static /* synthetic */ boolean access$300(ExportViewDialog exportViewDialog) {
        return exportViewDialog.validatePaths();
    }

    static /* synthetic */ Window access$400(ExportViewDialog exportViewDialog) {
        return exportViewDialog.window;
    }

    static /* synthetic */ boolean access$500(ExportViewDialog exportViewDialog) {
        return exportViewDialog.confirmOverwrites();
    }

    static /* synthetic */ boolean access$602(ExportViewDialog exportViewDialog, boolean bl2) {
        exportViewDialog.okPressed = bl2;
        return exportViewDialog.okPressed;
    }

    static /* synthetic */ String access$700(ExportViewDialog exportViewDialog, Window window) {
        return exportViewDialog.selectDirectory(window);
    }

    static /* synthetic */ FileChooserPanel access$800(ExportViewDialog exportViewDialog) {
        return exportViewDialog.destinationChooserPanel;
    }
}

