/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;

public class LengthLimitingDocument
extends PlainDocument {
    private int maxlen;

    public LengthLimitingDocument() {
        this(-1);
    }

    public LengthLimitingDocument(int n2) {
        this.maxlen = n2;
    }

    public void setMaxLength(int n2) {
        this.maxlen = n2;
    }

    public int getMaxLength() {
        return this.maxlen;
    }

    @Override
    public void insertString(int n2, String string, AttributeSet attributeSet) {
        if (string == null) {
            return;
        }
        if (this.maxlen < 0) {
            super.insertString(n2, string, attributeSet);
        }
        char[] arrc = string.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(arrc, 0, Math.min(this.maxlen, arrc.length));
        super.insertString(n2, stringBuffer.toString(), attributeSet);
    }
}

