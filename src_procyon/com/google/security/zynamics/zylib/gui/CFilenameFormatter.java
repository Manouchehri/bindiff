package com.google.security.zynamics.zylib.gui;

import javax.swing.*;
import com.google.common.base.*;
import java.io.*;
import javax.swing.text.*;

public class CFilenameFormatter extends AbstractFormatter
{
    private static final int MAX_CHAR = 255;
    private final CFilenameFormatter$FilenameFilter filter;
    private final File m_directory;
    
    public CFilenameFormatter(final File directory) {
        this.filter = new CFilenameFormatter$FilenameFilter(this, null);
        Preconditions.checkArgument(directory.exists(), (Object)"Error: Direcctory must exist.");
        this.m_directory = directory;
    }
    
    private boolean isValid(final String s, final int n) {
        if (((JFormattedTextField.AbstractFormatter)this).getFormattedTextField().getText().length() - n + s.length() > 255 || s.indexOf("\\") > -1 || s.indexOf("/") > -1) {
            ((JFormattedTextField.AbstractFormatter)this).invalidEdit();
            return false;
        }
        final String value = String.valueOf(this.m_directory.getPath());
        final String value2 = String.valueOf(File.separator);
        final File file = new File(new StringBuilder(0 + String.valueOf(value).length() + String.valueOf(value2).length() + String.valueOf(s).length()).append(value).append(value2).append(s).toString());
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    ((JFormattedTextField.AbstractFormatter)this).invalidEdit();
                    return false;
                }
                file.delete();
            }
            catch (IOException ex) {
                ((JFormattedTextField.AbstractFormatter)this).invalidEdit();
                return false;
            }
        }
        return true;
    }
    
    @Override
    protected DocumentFilter getDocumentFilter() {
        return this.filter;
    }
    
    @Override
    public Object stringToValue(final String s) {
        return s;
    }
    
    @Override
    public String valueToString(final Object o) {
        if (o == null) {
            return null;
        }
        return o.toString();
    }
}
