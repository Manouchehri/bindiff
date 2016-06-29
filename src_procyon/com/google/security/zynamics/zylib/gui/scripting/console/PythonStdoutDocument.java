package com.google.security.zynamics.zylib.gui.scripting.console;

import java.awt.*;
import javax.swing.text.*;

class PythonStdoutDocument extends DefaultStyledDocument
{
    private static final long serialVersionUID = 4657150237257401496L;
    private final SimpleAttributeSet outputAttrA;
    private final SimpleAttributeSet outputAttrB;
    private final SimpleAttributeSet outputErrAttr;
    boolean flipflop;
    int lastPosition;
    SimpleAttributeSet outputAttr;
    
    public PythonStdoutDocument() {
        this.outputAttrA = new SimpleAttributeSet();
        this.outputAttrB = new SimpleAttributeSet();
        this.outputErrAttr = new SimpleAttributeSet();
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
    
    public void append(final String s) {
        try {
            super.insertString(this.lastPosition, s, this.outputAttr);
            this.lastPosition += s.length();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void appendErr(final String s) {
        try {
            super.insertString(this.lastPosition, s, this.outputErrAttr);
            this.lastPosition += s.length();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void flip() {
        this.outputAttr = (this.flipflop ? this.outputAttrA : this.outputAttrB);
        this.flipflop = !this.flipflop;
    }
}
