/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

public class CFileChooser$FileExtension {
    private final String m_description;
    private final String[] m_extensions;

    public /* varargs */ CFileChooser$FileExtension(String string, String ... arrstring) {
        this.m_description = string;
        this.m_extensions = arrstring;
    }

    static /* synthetic */ String[] access$000(CFileChooser$FileExtension cFileChooser$FileExtension) {
        return cFileChooser$FileExtension.m_extensions;
    }

    static /* synthetic */ String access$100(CFileChooser$FileExtension cFileChooser$FileExtension) {
        return cFileChooser$FileExtension.m_description;
    }
}

