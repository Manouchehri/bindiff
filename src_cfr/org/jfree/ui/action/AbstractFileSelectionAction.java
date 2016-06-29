/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.action;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.jfree.ui.ExtensionFileFilter;
import org.jfree.ui.action.AbstractActionDowngrade;
import org.jfree.util.StringUtils;

public abstract class AbstractFileSelectionAction
extends AbstractActionDowngrade {
    private JFileChooser fileChooser;
    private Component parent;

    public AbstractFileSelectionAction(Component component) {
        this.parent = component;
    }

    protected abstract String getFileExtension();

    protected abstract String getFileDescription();

    protected File getCurrentDirectory() {
        return new File(".");
    }

    protected File performSelectFile(File file, int n2, boolean bl2) {
        if (this.fileChooser == null) {
            this.fileChooser = this.createFileChooser();
        }
        this.fileChooser.setSelectedFile(file);
        this.fileChooser.setDialogType(n2);
        int n3 = this.fileChooser.showDialog(this.parent, null);
        if (n3 != 0) return null;
        File file2 = this.fileChooser.getSelectedFile();
        String string = file2.getAbsolutePath();
        if (StringUtils.endsWithIgnoreCase(string, this.getFileExtension())) return new File(string);
        string = new StringBuffer().append(string).append(this.getFileExtension()).toString();
        return new File(string);
    }

    protected JFileChooser createFileChooser() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.addChoosableFileFilter(new ExtensionFileFilter(this.getFileDescription(), this.getFileExtension()));
        jFileChooser.setMultiSelectionEnabled(false);
        jFileChooser.setCurrentDirectory(this.getCurrentDirectory());
        return jFileChooser;
    }
}

