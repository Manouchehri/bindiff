package com.google.security.zynamics.zylib.gui;

import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.*;

final class CFileChooser$2 implements FilenameFilter
{
    final /* synthetic */ JFileChooser val$chooser;
    
    CFileChooser$2(final JFileChooser val$chooser) {
        this.val$chooser = val$chooser;
    }
    
    @Override
    public boolean accept(final File file, final String s) {
        final FileFilter fileFilter = this.val$chooser.getFileFilter();
        final String value = String.valueOf(file.getPath());
        final String value2 = String.valueOf(File.pathSeparator);
        return fileFilter.accept(new File(new StringBuilder(0 + String.valueOf(value).length() + String.valueOf(value2).length() + String.valueOf(s).length()).append(value).append(value2).append(s).toString()));
    }
}
