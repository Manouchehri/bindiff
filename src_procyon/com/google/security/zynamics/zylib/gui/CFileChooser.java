package com.google.security.zynamics.zylib.gui;

import com.google.common.base.*;
import java.util.*;
import javax.swing.filechooser.*;
import com.google.security.zynamics.zylib.io.*;
import java.io.*;
import com.google.security.zynamics.zylib.resources.*;
import javax.swing.border.*;
import com.google.security.zynamics.zylib.system.*;
import javax.swing.*;
import java.awt.*;

public class CFileChooser extends JFileChooser
{
    private static final long serialVersionUID = -5907483378595594768L;
    private final List m_fileFilters;
    private final JCheckBox m_checkBox;
    private boolean m_askFileOverwrite;
    
    public CFileChooser() {
        this("");
    }
    
    public CFileChooser(final CFileChooser$FileExtension... array) {
        this.m_fileFilters = new ArrayList();
        this.m_checkBox = new JCheckBox();
        this.m_askFileOverwrite = false;
        Preconditions.checkNotNull(array, (Object)"File extensions can't be null.");
        for (final CFileChooser$FileExtension cFileChooser$FileExtension : array) {
            final CFileChooser$CFileNameExtensionFilter cFileChooser$CFileNameExtensionFilter = new CFileChooser$CFileNameExtensionFilter(this, Arrays.asList(cFileChooser$FileExtension.m_extensions), cFileChooser$FileExtension.m_description);
            this.m_fileFilters.add(cFileChooser$CFileNameExtensionFilter);
            this.addChoosableFileFilter(cFileChooser$CFileNameExtensionFilter);
        }
    }
    
    public CFileChooser(final List list, final String s) {
        this.m_fileFilters = new ArrayList();
        this.m_checkBox = new JCheckBox();
        this.m_askFileOverwrite = false;
        Preconditions.checkNotNull(list, (Object)"Error: File extensions can't be null.");
        Preconditions.checkNotNull(s, (Object)"Error: File descriptions can't be null.");
        this.addChoosableFileFilter(new CFileChooser$CFileNameExtensionFilter(this, list, s));
    }
    
    public CFileChooser(final String s) {
        this(s, "");
    }
    
    public CFileChooser(final String s, final String s2) {
        this.m_fileFilters = new ArrayList();
        this.m_checkBox = new JCheckBox();
        this.m_askFileOverwrite = false;
        Preconditions.checkNotNull(s, (Object)"Error: File extension can't be null.");
        Preconditions.checkNotNull(s2, (Object)"Error: File description can't be null.");
        if (s.isEmpty()) {
            return;
        }
        this.addChoosableFileFilter(new CFileChooser$1(this, s, s2));
    }
    
    private static int showNativeFileDialog(final JFileChooser fileChooser) {
        final FileDialog fileDialog = new FileDialog((Frame)fileChooser.getParent());
        fileDialog.setDirectory(fileChooser.getCurrentDirectory().getPath());
        final File selectedFile = fileChooser.getSelectedFile();
        fileDialog.setFile((selectedFile == null) ? "" : selectedFile.getPath());
        fileDialog.setFilenameFilter(new CFileChooser$2(fileChooser));
        if (fileChooser.getDialogType() == 1) {
            fileDialog.setMode(1);
        }
        else {
            fileDialog.setMode(0);
        }
        if (fileChooser.getFileSelectionMode() == 1) {
            System.setProperty("apple.awt.fileDialogForDirectories", "true");
        }
        fileDialog.setVisible(true);
        System.setProperty("apple.awt.fileDialogForDirectories", "false");
        if (fileDialog.getFile() == null) {
            return 1;
        }
        final String value = String.valueOf(FileUtils.ensureTrailingSlash(fileDialog.getDirectory()));
        final String value2 = String.valueOf(fileDialog.getFile());
        fileChooser.setSelectedFile(new File((value2.length() != 0) ? value.concat(value2) : new String(value)));
        return 0;
    }
    
    @Override
    public void approveSelection() {
        if (this.m_askFileOverwrite && this.getSelectedFile().exists() && CMessageBox.showYesNoQuestion(this, Constants.ASK_FILE_OVERWRITE) == 1) {
            return;
        }
        super.approveSelection();
    }
    
    public boolean getAskFileOverwrite() {
        return this.m_askFileOverwrite;
    }
    
    public boolean isSelectedCheckBox() {
        return this.m_checkBox.isSelected();
    }
    
    public void setAskFileOverwrite(final boolean askFileOverwrite) {
        this.m_askFileOverwrite = askFileOverwrite;
    }
    
    public void setCheckBox(final String text) {
        this.m_checkBox.setText(text);
        this.m_checkBox.setBorder(new EmptyBorder(0, 0, 0, 0));
        final JButton button = (JButton)GuiHelper.findComponentByPredicate(this, new CFileChooser$3(this, this.getApproveButtonText()));
        Container container = null;
        if (button != null) {
            final Container parent = button.getParent();
            if (parent instanceof JComponent) {
                container = parent;
            }
        }
        if (container == null) {
            this.setAccessory(this.m_checkBox);
            return;
        }
        if (SystemHelpers.isRunningMacOSX()) {
            container.add(this.m_checkBox, 0);
            return;
        }
        final JPanel panel = new JPanel(container.getLayout());
        final Component[] components = container.getComponents();
        for (int length = components.length, i = 0; i < length; ++i) {
            panel.add(components[i]);
        }
        container.setLayout(new BorderLayout(0, 0));
        container.add(this.m_checkBox, "Before");
        container.add(panel, "Center");
    }
    
    public void setFileFilter(final int n) {
        this.setFileFilter(this.m_fileFilters.get(n));
    }
    
    @Override
    public int showOpenDialog(final Component component) {
        if (!SystemHelpers.isRunningMacOSX()) {
            return super.showOpenDialog(component);
        }
        this.setDialogType(0);
        return showNativeFileDialog(this);
    }
}
