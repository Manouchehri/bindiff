/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.CHexFormatter$1;
import com.google.security.zynamics.zylib.gui.CHexFormatter$HexFilter;
import javax.swing.JFormattedTextField;
import javax.swing.text.DocumentFilter;

public class CHexFormatter
extends JFormattedTextField.AbstractFormatter {
    private static final long serialVersionUID = 6996845563062947862L;
    private final CHexFormatter$HexFilter filter;
    private int maxSize;

    public CHexFormatter() {
        this.filter = new CHexFormatter$HexFilter(this, null);
        this.maxSize = Integer.MAX_VALUE;
    }

    public CHexFormatter(int n2) {
        this.filter = new CHexFormatter$HexFilter(this, null);
        this.maxSize = Integer.MAX_VALUE;
        Preconditions.checkArgument(n2 > 0, "Error: Maximum input size must be positive");
        this.maxSize = n2;
    }

    private boolean isValid(String string, int n2) {
        if (this.getFormattedTextField().getText().length() - n2 + string.length() > this.maxSize) {
            this.invalidEdit();
            return false;
        }
        int n3 = 0;
        while (n3 < string.length()) {
            char c2 = string.charAt(n3);
            if (Character.digit(c2, 16) == -1) {
                this.invalidEdit();
                return false;
            }
            ++n3;
        }
        return true;
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
        return (String)object;
    }

    static /* synthetic */ boolean access$100(CHexFormatter cHexFormatter, String string, int n2) {
        return cHexFormatter.isValid(string, n2);
    }
}

