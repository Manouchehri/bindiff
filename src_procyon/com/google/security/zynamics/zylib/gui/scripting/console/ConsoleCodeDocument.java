package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.scripting.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.text.*;

public class ConsoleCodeDocument extends CodeDocumentPython
{
    private static final long serialVersionUID = -4854242616532427400L;
    private final SimpleAttributeSet pythonPromptAttr;
    private KeyListener inputKeyListener;
    private String remainingTextString;
    private AttributeSet remainingTextAttr;
    private final ConsoleHelpers helpers;
    
    public ConsoleCodeDocument() {
        super(false);
        this.pythonPromptAttr = new SimpleAttributeSet();
        this.remainingTextString = null;
        this.remainingTextAttr = null;
        this.helpers = new ConsoleHelpers(this, this.normal);
        this.putProperty("__EndOfLine__", "\n");
        StyleConstants.setForeground(this.pythonPromptAttr, Color.LIGHT_GRAY);
        StyleConstants.setBold(this.pythonPromptAttr, true);
        StyleConstants.setFontSize(this.pythonPromptAttr, 13);
    }
    
    public void flushRemainingText(final int n) {
        if (this.remainingTextString == null) {
            return;
        }
        try {
            this.insertString(n, this.remainingTextString, this.remainingTextAttr);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        this.remainingTextString = null;
        this.remainingTextAttr = null;
    }
    
    public int getCaretOffsetInLine(final int n) {
        return this.helpers.getCaretOffsetInLine(n);
    }
    
    public String getCurrentLine(final int n) {
        return this.helpers.getCurrentLine(n);
    }
    
    public int getLineStartOffset(final int n) {
        return this.helpers.getLineStartOffset(n);
    }
    
    public String getWord(final int n) {
        return this.helpers.getWord(n);
    }
    
    public void insertChar(final int n, final String s) {
        if (n < 0) {
            return;
        }
        try {
            super.insertString(n, s, this.normal);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void insertPrompt(final int n, final String s) {
        try {
            super.insertString(n, s, this.pythonPromptAttr);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void insertString(final int n, final String s, final AttributeSet remainingTextAttr) {
        if (n < 0) {
            return;
        }
        if (s.length() > 1) {
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '\n') {
                    this.remainingTextString = s.substring(i + 1);
                    this.remainingTextAttr = remainingTextAttr;
                    this.inputKeyListener.keyPressed(new KeyEvent(new Container(), 401, 0L, 0, 10, '\n'));
                    break;
                }
                this.insertChar(n + i, new StringBuilder(1).append(s.charAt(i)).toString());
            }
        }
        else if (s.length() == 1) {
            this.insertChar(n, s);
        }
    }
    
    public void setCurrentLine(final int n, final int n2, final String s) {
        final Element paragraphElement = this.getParagraphElement(n);
        final int startOffset = paragraphElement.getStartOffset();
        final int endOffset = paragraphElement.getEndOffset();
        try {
            this.remove(startOffset + n2, endOffset - (startOffset + n2 + 1));
            super.insertString(startOffset + n2, s, this.normal);
        }
        catch (BadLocationException ex) {
            System.out.println("Bad location!");
            ex.printStackTrace();
        }
    }
    
    public void setInputKeyListener(final KeyListener inputKeyListener) {
        this.inputKeyListener = inputKeyListener;
    }
}
