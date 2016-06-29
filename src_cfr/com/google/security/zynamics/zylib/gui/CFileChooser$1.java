/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CFileChooser;
import java.io.File;
import javax.swing.filechooser.FileFilter;

class CFileChooser$1
extends FileFilter {
    final /* synthetic */ String val$fileExtension;
    final /* synthetic */ String val$fileDescription;
    final /* synthetic */ CFileChooser this$0;

    CFileChooser$1(CFileChooser cFileChooser, String string, String string2) {
        this.this$0 = cFileChooser;
        this.val$fileExtension = string;
        this.val$fileDescription = string2;
    }

    @Override
    public boolean accept(File file) {
        if ("".equals(this.val$fileExtension)) {
            if (file.isDirectory()) return true;
            if (file.canExecute()) return true;
            return false;
        }
        if (file.isDirectory()) return true;
        if (file.getName().toLowerCase().endsWith(this.val$fileExtension.toLowerCase())) return true;
        if (this.val$fileExtension.equals("*")) return true;
        return false;
    }

    @Override
    public String getDescription() {
        String string = this.val$fileDescription;
        String string2 = this.val$fileExtension;
        return new StringBuilder(5 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(" (*.").append(string2).append(")").toString();
    }
}

