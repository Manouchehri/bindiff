/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.textfields;

import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;

public class JTextFieldLimit
extends DefaultStyledDocument {
    private static final long serialVersionUID = -8124048672190684534L;
    private final int limit;

    public JTextFieldLimit() {
        this(30000);
    }

    public JTextFieldLimit(int n2) {
        this.limit = n2;
    }

    @Override
    public void insertString(int n2, String string, AttributeSet attributeSet) {
        if (string == null) {
            return;
        }
        if (this.getLength() + string.length() > this.limit) return;
        super.insertString(n2, string, attributeSet);
    }
}

