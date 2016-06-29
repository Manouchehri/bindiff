/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;

public class IntegerDocument
extends PlainDocument {
    @Override
    public void insertString(int n2, String string, AttributeSet attributeSet) {
        super.insertString(n2, string, attributeSet);
        if (string == null) return;
        if (string.equals("-") && n2 == 0) {
            if (string.length() < 2) return;
        }
        try {
            Integer.parseInt(this.getText(0, this.getLength()));
            return;
        }
        catch (NumberFormatException var4_4) {
            this.remove(n2, string.length());
        }
    }
}

