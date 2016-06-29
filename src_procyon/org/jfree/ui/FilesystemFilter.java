package org.jfree.ui;

import javax.swing.filechooser.*;
import java.io.*;

public class FilesystemFilter extends FileFilter implements FilenameFilter
{
    private String[] fileext;
    private String descr;
    private boolean accDirs;
    
    public FilesystemFilter(final String s, final String s2) {
        this(s, s2, true);
    }
    
    public FilesystemFilter(final String s, final String s2, final boolean b) {
        this(new String[] { s }, s2, b);
    }
    
    public FilesystemFilter(final String[] array, final String descr, final boolean accDirs) {
        this.fileext = array.clone();
        this.descr = descr;
        this.accDirs = accDirs;
    }
    
    public boolean accept(final File file, final String s) {
        if (new File(file, s).isDirectory() && this.acceptsDirectories()) {
            return true;
        }
        for (int i = 0; i < this.fileext.length; ++i) {
            if (s.endsWith(this.fileext[i])) {
                return true;
            }
        }
        return false;
    }
    
    public boolean accept(final File file) {
        if (file.isDirectory() && this.acceptsDirectories()) {
            return true;
        }
        for (int i = 0; i < this.fileext.length; ++i) {
            if (file.getName().endsWith(this.fileext[i])) {
                return true;
            }
        }
        return false;
    }
    
    public String getDescription() {
        return this.descr;
    }
    
    public void acceptDirectories(final boolean accDirs) {
        this.accDirs = accDirs;
    }
    
    public boolean acceptsDirectories() {
        return this.accDirs;
    }
}
