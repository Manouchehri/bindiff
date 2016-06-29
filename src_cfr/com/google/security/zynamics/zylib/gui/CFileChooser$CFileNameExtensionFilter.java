/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CFileChooser;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.swing.filechooser.FileFilter;

class CFileChooser$CFileNameExtensionFilter
extends FileFilter {
    private final List m_fileExtensions;
    private final String m_fileDescription;
    final /* synthetic */ CFileChooser this$0;

    public CFileChooser$CFileNameExtensionFilter(CFileChooser cFileChooser, List list, String string) {
        this.this$0 = cFileChooser;
        this.m_fileExtensions = list;
        this.m_fileDescription = string;
    }

    @Override
    public boolean accept(File file) {
        String string;
        boolean bl2 = false;
        String string2 = file.getName().toLowerCase();
        Iterator iterator = this.m_fileExtensions.iterator();
        while (iterator.hasNext() && !(bl2 = string2.endsWith((string = (String)iterator.next()).toLowerCase()))) {
        }
        if (bl2) return true;
        if (file.isDirectory()) return true;
        return false;
    }

    @Override
    public String getDescription() {
        return this.m_fileDescription;
    }
}

