/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import java.io.File;
import java.io.FilenameFilter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

final class CFileChooser$2
implements FilenameFilter {
    final /* synthetic */ JFileChooser val$chooser;

    CFileChooser$2(JFileChooser jFileChooser) {
        this.val$chooser = jFileChooser;
    }

    @Override
    public boolean accept(File file, String string) {
        String string2 = String.valueOf(file.getPath());
        String string3 = String.valueOf(File.pathSeparator);
        return this.val$chooser.getFileFilter().accept(new File(new StringBuilder(0 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string).length()).append(string2).append(string3).append(string).toString()));
    }
}

