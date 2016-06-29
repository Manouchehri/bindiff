/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter$1;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter$FilenameFilter;
import java.io.File;
import java.io.IOException;
import javax.swing.JFormattedTextField;
import javax.swing.text.DocumentFilter;

public class CFilenameFormatter
extends JFormattedTextField.AbstractFormatter {
    private static final int MAX_CHAR = 255;
    private final CFilenameFormatter$FilenameFilter filter;
    private final File m_directory;

    public CFilenameFormatter(File file) {
        this.filter = new CFilenameFormatter$FilenameFilter(this, null);
        Preconditions.checkArgument(file.exists(), "Error: Direcctory must exist.");
        this.m_directory = file;
    }

    private boolean isValid(String string, int n2) {
        if (this.getFormattedTextField().getText().length() - n2 + string.length() > 255 || string.indexOf("\\") > -1 || string.indexOf("/") > -1) {
            this.invalidEdit();
            return false;
        }
        String string2 = String.valueOf(this.m_directory.getPath());
        String string3 = String.valueOf(File.separator);
        File file = new File(new StringBuilder(0 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string).length()).append(string2).append(string3).append(string).toString());
        if (file.exists()) return true;
        try {
            if (!file.createNewFile()) {
                this.invalidEdit();
                return false;
            }
            file.delete();
            return true;
        }
        catch (IOException var4_4) {
            this.invalidEdit();
            return false;
        }
    }

    @Override
    protected DocumentFilter getDocumentFilter() {
        return this.filter;
    }

    @Override
    public Object stringToValue(String string) {
        return string;
    }

    @Override
    public String valueToString(Object object) {
        if (object != null) return object.toString();
        return null;
    }

    static /* synthetic */ boolean access$100(CFilenameFormatter cFilenameFormatter, String string, int n2) {
        return cFilenameFormatter.isValid(string, n2);
    }
}

