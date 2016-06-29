/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class ExtensionFileFilter
extends FileFilter {
    private String description;
    private String extension;

    public ExtensionFileFilter(String string, String string2) {
        this.description = string;
        this.extension = string2;
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        String string = file.getName().toLowerCase();
        if (!string.endsWith(this.extension)) return false;
        return true;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}

