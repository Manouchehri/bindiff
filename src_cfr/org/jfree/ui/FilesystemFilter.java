/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.io.File;
import java.io.FilenameFilter;
import javax.swing.filechooser.FileFilter;

public class FilesystemFilter
extends FileFilter
implements FilenameFilter {
    private String[] fileext;
    private String descr;
    private boolean accDirs;

    public FilesystemFilter(String string, String string2) {
        this(string, string2, true);
    }

    public FilesystemFilter(String string, String string2, boolean bl2) {
        this(new String[]{string}, string2, bl2);
    }

    public FilesystemFilter(String[] arrstring, String string, boolean bl2) {
        this.fileext = (String[])arrstring.clone();
        this.descr = string;
        this.accDirs = bl2;
    }

    @Override
    public boolean accept(File file, String string) {
        File file2 = new File(file, string);
        if (file2.isDirectory() && this.acceptsDirectories()) {
            return true;
        }
        int n2 = 0;
        while (n2 < this.fileext.length) {
            if (string.endsWith(this.fileext[n2])) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory() && this.acceptsDirectories()) {
            return true;
        }
        int n2 = 0;
        while (n2 < this.fileext.length) {
            if (file.getName().endsWith(this.fileext[n2])) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return this.descr;
    }

    public void acceptDirectories(boolean bl2) {
        this.accDirs = bl2;
    }

    public boolean acceptsDirectories() {
        return this.accDirs;
    }
}

