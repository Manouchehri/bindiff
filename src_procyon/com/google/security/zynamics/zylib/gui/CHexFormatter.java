package com.google.security.zynamics.zylib.gui;

import javax.swing.*;
import com.google.common.base.*;
import javax.swing.text.*;

public class CHexFormatter extends AbstractFormatter
{
    private static final long serialVersionUID = 6996845563062947862L;
    private final CHexFormatter$HexFilter filter;
    private int maxSize;
    
    public CHexFormatter() {
        this.filter = new CHexFormatter$HexFilter(this, null);
        this.maxSize = Integer.MAX_VALUE;
    }
    
    public CHexFormatter(final int maxSize) {
        this.filter = new CHexFormatter$HexFilter(this, null);
        this.maxSize = Integer.MAX_VALUE;
        Preconditions.checkArgument(maxSize > 0, (Object)"Error: Maximum input size must be positive");
        this.maxSize = maxSize;
    }
    
    private boolean isValid(final String s, final int n) {
        if (((JFormattedTextField.AbstractFormatter)this).getFormattedTextField().getText().length() - n + s.length() > this.maxSize) {
            ((JFormattedTextField.AbstractFormatter)this).invalidEdit();
            return false;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (Character.digit(s.charAt(i), 16) == -1) {
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
        return (String)o;
    }
}
