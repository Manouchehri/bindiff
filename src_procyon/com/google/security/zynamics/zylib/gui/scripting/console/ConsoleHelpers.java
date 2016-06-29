package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.scripting.*;
import javax.swing.text.*;

public class ConsoleHelpers
{
    private final SyntaxDocument document;
    private final MutableAttributeSet normal;
    
    public ConsoleHelpers(final SyntaxDocument document, final MutableAttributeSet normal) {
        this.document = document;
        this.normal = normal;
    }
    
    public int getCaretOffsetInLine(final int n) {
        return n - this.document.getParagraphElement(n).getStartOffset();
    }
    
    public String getCurrentLine(final int n) {
        final Element paragraphElement = this.document.getParagraphElement(n);
        String text = "";
        try {
            text = this.document.getText(paragraphElement.getStartOffset(), paragraphElement.getEndOffset() - paragraphElement.getStartOffset());
        }
        catch (BadLocationException ex) {
            System.out.println("Bad location!");
            ex.printStackTrace();
        }
        return text;
    }
    
    public int getLineStartOffset(final int n) {
        return this.document.getParagraphElement(n).getStartOffset();
    }
    
    public MutableAttributeSet getNormal() {
        return this.normal;
    }
    
    public String getWord(final int n) {
        int n2 = n;
        final Element paragraphElement = this.document.getParagraphElement(n2);
        String text;
        try {
            text = this.document.getText(paragraphElement.getStartOffset(), paragraphElement.getEndOffset() - paragraphElement.getStartOffset());
        }
        catch (Exception ex) {
            return "";
        }
        if (text.length() == 0) {
            return "";
        }
        if (paragraphElement.getStartOffset() > 0) {
            n2 -= paragraphElement.getStartOffset();
        }
        for (int i = n2 - 1; i >= 0; --i) {
            if (this.document.isDelimiter(new StringBuilder(1).append(text.charAt(i)).toString()) || i == 0) {
                return text.substring(i + 1, n2).trim();
            }
        }
        return "";
    }
}
