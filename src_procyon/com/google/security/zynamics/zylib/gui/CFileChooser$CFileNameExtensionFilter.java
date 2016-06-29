package com.google.security.zynamics.zylib.gui;

import javax.swing.filechooser.*;
import java.io.*;
import java.util.*;

class CFileChooser$CFileNameExtensionFilter extends FileFilter
{
    private final List m_fileExtensions;
    private final String m_fileDescription;
    final /* synthetic */ CFileChooser this$0;
    
    public CFileChooser$CFileNameExtensionFilter(final CFileChooser this$0, final List fileExtensions, final String fileDescription) {
        this.this$0 = this$0;
        this.m_fileExtensions = fileExtensions;
        this.m_fileDescription = fileDescription;
    }
    
    @Override
    public boolean accept(final File file) {
        boolean endsWith = false;
        final String lowerCase = file.getName().toLowerCase();
        final Iterator<String> iterator = this.m_fileExtensions.iterator();
        while (iterator.hasNext()) {
            endsWith = lowerCase.endsWith(iterator.next().toLowerCase());
            if (endsWith) {
                break;
            }
        }
        return endsWith || file.isDirectory();
    }
    
    @Override
    public String getDescription() {
        return this.m_fileDescription;
    }
}
