/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting.console;

import java.awt.Color;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

class PythonStdoutDocument
extends DefaultStyledDocument {
    private static final long serialVersionUID = 4657150237257401496L;
    private final SimpleAttributeSet outputAttrA = new SimpleAttributeSet();
    private final SimpleAttributeSet outputAttrB = new SimpleAttributeSet();
    private final SimpleAttributeSet outputErrAttr = new SimpleAttributeSet();
    boolean flipflop;
    int lastPosition;
    SimpleAttributeSet outputAttr;

    public PythonStdoutDocument() {
        StyleConstants.setFontFamily(this.outputAttrA, "Courier");
        StyleConstants.setFontSize(this.outputAttrA, 11);
        StyleConstants.setForeground(this.outputAttrA, new Color(0.4f, 0.4f, 0.4f));
        StyleConstants.setFontFamily(this.outputAttrB, "Courier");
        StyleConstants.setFontSize(this.outputAttrB, 11);
        StyleConstants.setForeground(this.outputAttrB, new Color(0.1f, 0.1f, 0.1f));
        StyleConstants.setFontFamily(this.outputErrAttr, "Courier");
        StyleConstants.setFontSize(this.outputErrAttr, 11);
        StyleConstants.setForeground(this.outputErrAttr, new Color(1.0f, 0.2f, 0.2f));
        this.lastPosition = 0;
        this.flipflop = false;
        this.outputAttr = this.outputAttrA;
    }

    public void append(String string) {
        try {
            super.insertString(this.lastPosition, string, this.outputAttr);
            this.lastPosition += string.length();
            return;
        }
        catch (Exception var2_2) {
            var2_2.printStackTrace();
        }
    }

    public void appendErr(String string) {
        try {
            super.insertString(this.lastPosition, string, this.outputErrAttr);
            this.lastPosition += string.length();
            return;
        }
        catch (Exception var2_2) {
            var2_2.printStackTrace();
        }
    }

    public void flip() {
        this.outputAttr = this.flipflop ? this.outputAttrA : this.outputAttrB;
        this.flipflop = !this.flipflop;
    }
}

