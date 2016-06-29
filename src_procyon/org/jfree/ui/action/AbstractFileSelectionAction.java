package org.jfree.ui.action;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import org.jfree.util.*;
import org.jfree.ui.*;
import javax.swing.filechooser.*;

public abstract class AbstractFileSelectionAction extends AbstractActionDowngrade
{
    private JFileChooser fileChooser;
    private Component parent;
    
    public AbstractFileSelectionAction(final Component parent) {
        this.parent = parent;
    }
    
    protected abstract String getFileExtension();
    
    protected abstract String getFileDescription();
    
    protected File getCurrentDirectory() {
        return new File(".");
    }
    
    protected File performSelectFile(final File selectedFile, final int dialogType, final boolean b) {
        if (this.fileChooser == null) {
            this.fileChooser = this.createFileChooser();
        }
        this.fileChooser.setSelectedFile(selectedFile);
        this.fileChooser.setDialogType(dialogType);
        if (this.fileChooser.showDialog(this.parent, null) == 0) {
            String s = this.fileChooser.getSelectedFile().getAbsolutePath();
            if (!StringUtils.endsWithIgnoreCase(s, this.getFileExtension())) {
                s += this.getFileExtension();
            }
            return new File(s);
        }
        return null;
    }
    
    protected JFileChooser createFileChooser() {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new ExtensionFileFilter(this.getFileDescription(), this.getFileExtension()));
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setCurrentDirectory(this.getCurrentDirectory());
        return fileChooser;
    }
}
