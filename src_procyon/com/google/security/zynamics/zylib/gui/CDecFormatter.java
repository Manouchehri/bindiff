package com.google.security.zynamics.zylib.gui;

import javax.swing.*;
import javax.swing.text.*;

public class CDecFormatter extends AbstractFormatter
{
    private static final long serialVersionUID = 8368311921001233300L;
    private final CDecFormatter$DecFilter filter;
    private final int m_maxChar;
    private final int m_minNumber;
    private final int m_maxNumber;
    
    public CDecFormatter() {
        this(Integer.MAX_VALUE);
    }
    
    public CDecFormatter(final int maxChar) {
        this.filter = new CDecFormatter$DecFilter(this, null);
        this.m_maxChar = maxChar;
        this.m_minNumber = -1;
        this.m_maxNumber = -1;
    }
    
    public CDecFormatter(final int maxChar, final int minNumber, final int maxNumber) {
        this.filter = new CDecFormatter$DecFilter(this, null);
        this.m_maxChar = maxChar;
        this.m_minNumber = minNumber;
        this.m_maxNumber = maxNumber;
    }
    
    private boolean isValid(final String s, final int n) {
        if (((JFormattedTextField.AbstractFormatter)this).getFormattedTextField().getText().length() - n + s.length() > this.m_maxChar) {
            ((JFormattedTextField.AbstractFormatter)this).invalidEdit();
            return false;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (Character.digit(s.charAt(i), 10) == -1) {
                ((JFormattedTextField.AbstractFormatter)this).invalidEdit();
                return false;
            }
        }
        if (this.m_minNumber != -1 && this.m_maxNumber != -1) {
            final String value = String.valueOf(((JFormattedTextField.AbstractFormatter)this).getFormattedTextField().getText());
            final String value2 = String.valueOf(s);
            final int int1 = Integer.parseInt((value2.length() != 0) ? value.concat(value2) : new String(value));
            if (int1 < this.m_minNumber || int1 > this.m_maxNumber) {
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
        return s.equals("") ? 0L : Long.parseLong(s);
    }
    
    @Override
    public String valueToString(final Object o) {
        if (o == null) {
            return null;
        }
        return Long.toString((long)o);
    }
}
