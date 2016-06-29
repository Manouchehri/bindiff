/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.scripting.SyntaxDocument;
import java.io.PrintStream;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;

public class ConsoleHelpers {
    private final SyntaxDocument document;
    private final MutableAttributeSet normal;

    public ConsoleHelpers(SyntaxDocument syntaxDocument, MutableAttributeSet mutableAttributeSet) {
        this.document = syntaxDocument;
        this.normal = mutableAttributeSet;
    }

    public int getCaretOffsetInLine(int n2) {
        return n2 - this.document.getParagraphElement(n2).getStartOffset();
    }

    public String getCurrentLine(int n2) {
        Element element = this.document.getParagraphElement(n2);
        String string = "";
        try {
            return this.document.getText(element.getStartOffset(), element.getEndOffset() - element.getStartOffset());
        }
        catch (BadLocationException var4_4) {
            System.out.println("Bad location!");
            var4_4.printStackTrace();
        }
        return string;
    }

    public int getLineStartOffset(int n2) {
        return this.document.getParagraphElement(n2).getStartOffset();
    }

    public MutableAttributeSet getNormal() {
        return this.normal;
    }

    public String getWord(int n2) {
        String string;
        int n3 = n2;
        Element element = this.document.getParagraphElement(n3);
        try {
            string = this.document.getText(element.getStartOffset(), element.getEndOffset() - element.getStartOffset());
        }
        catch (Exception var5_5) {
            return "";
        }
        int n4 = string.length();
        if (n4 == 0) {
            return "";
        }
        int n5 = 0;
        if (element.getStartOffset() > 0) {
            n3 -= element.getStartOffset();
        }
        n5 = n3 - 1;
        while (n5 >= 0) {
            char c2 = string.charAt(n5);
            if (this.document.isDelimiter(new StringBuilder(1).append(c2).toString())) return string.substring(n5 + 1, n3).trim();
            if (n5 == 0) {
                return string.substring(n5 + 1, n3).trim();
            }
            --n5;
        }
        return "";
    }
}

