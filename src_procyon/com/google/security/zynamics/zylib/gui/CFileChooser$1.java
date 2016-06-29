package com.google.security.zynamics.zylib.gui;

import javax.swing.filechooser.*;
import java.io.*;

class CFileChooser$1 extends FileFilter
{
    final /* synthetic */ String val$fileExtension;
    final /* synthetic */ String val$fileDescription;
    final /* synthetic */ CFileChooser this$0;
    
    CFileChooser$1(final CFileChooser this$0, final String val$fileExtension, final String val$fileDescription) {
        this.this$0 = this$0;
        this.val$fileExtension = val$fileExtension;
        this.val$fileDescription = val$fileDescription;
    }
    
    @Override
    public boolean accept(final File file) {
        if ("".equals(this.val$fileExtension)) {
            return file.isDirectory() || file.canExecute();
        }
        return file.isDirectory() || file.getName().toLowerCase().endsWith(this.val$fileExtension.toLowerCase()) || this.val$fileExtension.equals("*");
    }
    
    @Override
    public String getDescription() {
        final String val$fileDescription = this.val$fileDescription;
        final String val$fileExtension = this.val$fileExtension;
        return new StringBuilder(5 + String.valueOf(val$fileDescription).length() + String.valueOf(val$fileExtension).length()).append(val$fileDescription).append(" (*.").append(val$fileExtension).append(")").toString();
    }
}
