/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CDecFormatter$1;
import com.google.security.zynamics.zylib.gui.CDecFormatter$DecFilter;
import javax.swing.JFormattedTextField;
import javax.swing.text.DocumentFilter;

public class CDecFormatter
extends JFormattedTextField.AbstractFormatter {
    private static final long serialVersionUID = 8368311921001233300L;
    private final CDecFormatter$DecFilter filter;
    private final int m_maxChar;
    private final int m_minNumber;
    private final int m_maxNumber;

    public CDecFormatter() {
        this(Integer.MAX_VALUE);
    }

    public CDecFormatter(int n2) {
        this.filter = new CDecFormatter$DecFilter(this, null);
        this.m_maxChar = n2;
        this.m_minNumber = -1;
        this.m_maxNumber = -1;
    }

    public CDecFormatter(int n2, int n3, int n4) {
        this.filter = new CDecFormatter$DecFilter(this, null);
        this.m_maxChar = n2;
        this.m_minNumber = n3;
        this.m_maxNumber = n4;
    }

    private boolean isValid(String string, int n2) {
        int n3;
        if (this.getFormattedTextField().getText().length() - n2 + string.length() > this.m_maxChar) {
            this.invalidEdit();
            return false;
        }
        for (n3 = 0; n3 < string.length(); ++n3) {
            char c2 = string.charAt(n3);
            if (Character.digit(c2, 10) != -1) continue;
            this.invalidEdit();
            return false;
        }
        if (this.m_minNumber == -1) return true;
        if (this.m_maxNumber == -1) return true;
        String string2 = String.valueOf(this.getFormattedTextField().getText());
        String string3 = String.valueOf(string);
        n3 = Integer.parseInt(string3.length() != 0 ? string2.concat(string3) : new String(string2));
        if (n3 >= this.m_minNumber) {
            if (n3 <= this.m_maxNumber) return true;
        }
        this.invalidEdit();
        return false;
    }

    @Override
    protected DocumentFilter getDocumentFilter() {
        return this.filter;
    }

    @Override
    public Object stringToValue(String string) {
        long l2;
        if (string.equals("")) {
            l2 = 0;
            return l2;
        }
        l2 = Long.parseLong(string);
        return l2;
    }

    @Override
    public String valueToString(Object object) {
        if (object != null) return Long.toString((Long)object);
        return null;
    }

    static /* synthetic */ boolean access$100(CDecFormatter cDecFormatter, String string, int n2) {
        return cDecFormatter.isValid(string, n2);
    }
}

