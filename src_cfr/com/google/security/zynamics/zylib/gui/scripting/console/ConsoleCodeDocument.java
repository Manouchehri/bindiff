/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.scripting.CodeDocumentPython;
import com.google.security.zynamics.zylib.gui.scripting.SyntaxDocument;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsoleHelpers;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintStream;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ConsoleCodeDocument
extends CodeDocumentPython {
    private static final long serialVersionUID = -4854242616532427400L;
    private final SimpleAttributeSet pythonPromptAttr = new SimpleAttributeSet();
    private KeyListener inputKeyListener;
    private String remainingTextString = null;
    private AttributeSet remainingTextAttr = null;
    private final ConsoleHelpers helpers;

    public ConsoleCodeDocument() {
        super(false);
        this.helpers = new ConsoleHelpers(this, this.normal);
        this.putProperty("__EndOfLine__", "\n");
        StyleConstants.setForeground(this.pythonPromptAttr, Color.LIGHT_GRAY);
        StyleConstants.setBold(this.pythonPromptAttr, true);
        StyleConstants.setFontSize(this.pythonPromptAttr, 13);
    }

    public void flushRemainingText(int n2) {
        if (this.remainingTextString == null) {
            return;
        }
        try {
            this.insertString(n2, this.remainingTextString, this.remainingTextAttr);
        }
        catch (Exception var2_2) {
            var2_2.printStackTrace();
        }
        this.remainingTextString = null;
        this.remainingTextAttr = null;
    }

    public int getCaretOffsetInLine(int n2) {
        return this.helpers.getCaretOffsetInLine(n2);
    }

    public String getCurrentLine(int n2) {
        return this.helpers.getCurrentLine(n2);
    }

    public int getLineStartOffset(int n2) {
        return this.helpers.getLineStartOffset(n2);
    }

    public String getWord(int n2) {
        return this.helpers.getWord(n2);
    }

    public void insertChar(int n2, String string) {
        if (n2 < 0) {
            return;
        }
        try {
            super.insertString(n2, string, this.normal);
            return;
        }
        catch (Exception var3_3) {
            var3_3.printStackTrace();
        }
    }

    public void insertPrompt(int n2, String string) {
        try {
            super.insertString(n2, string, this.pythonPromptAttr);
            return;
        }
        catch (Exception var3_3) {
            var3_3.printStackTrace();
        }
    }

    @Override
    public void insertString(int n2, String string, AttributeSet attributeSet) {
        if (n2 < 0) {
            return;
        }
        if (string.length() <= 1) {
            if (string.length() != 1) return;
            this.insertChar(n2, string);
            return;
        }
        int n3 = 0;
        while (n3 < string.length()) {
            if (string.charAt(n3) == '\n') {
                this.remainingTextString = string.substring(n3 + 1);
                this.remainingTextAttr = attributeSet;
                this.inputKeyListener.keyPressed(new KeyEvent(new Container(), 401, 0, 0, 10, '\n'));
                return;
            }
            char c2 = string.charAt(n3);
            this.insertChar(n2 + n3, new StringBuilder(1).append(c2).toString());
            ++n3;
        }
    }

    public void setCurrentLine(int n2, int n3, String string) {
        Element element = this.getParagraphElement(n2);
        int n4 = element.getStartOffset();
        int n5 = element.getEndOffset();
        try {
            this.remove(n4 + n3, n5 - (n4 + n3 + 1));
            super.insertString(n4 + n3, string, this.normal);
            return;
        }
        catch (BadLocationException var7_7) {
            System.out.println("Bad location!");
            var7_7.printStackTrace();
        }
    }

    public void setInputKeyListener(KeyListener keyListener) {
        this.inputKeyListener = keyListener;
    }
}

