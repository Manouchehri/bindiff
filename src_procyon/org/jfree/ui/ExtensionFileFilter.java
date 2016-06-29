package org.jfree.ui;

import javax.swing.filechooser.*;
import java.io.*;

public class ExtensionFileFilter extends FileFilter
{
    private String description;
    private String extension;
    
    public ExtensionFileFilter(final String description, final String extension) {
        this.description = description;
        this.extension = extension;
    }
    
    public boolean accept(final File file) {
        return file.isDirectory() || file.getName().toLowerCase().endsWith(this.extension);
    }
    
    public String getDescription() {
        return this.description;
    }
}
