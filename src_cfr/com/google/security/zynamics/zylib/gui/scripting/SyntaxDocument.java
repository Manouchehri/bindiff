/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.general.Convert;
import java.awt.Color;
import java.util.HashSet;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public abstract class SyntaxDocument
extends DefaultStyledDocument {
    private static final long serialVersionUID = 5437418885392724717L;
    private static final int DEFAULT_FONT_SIZE = 13;
    private final DefaultStyledDocument doc;
    private final Element rootElement;
    private boolean multiLineComment;
    private final MutableAttributeSet comment = new SimpleAttributeSet();
    private final MutableAttributeSet keyword = new SimpleAttributeSet();
    private final MutableAttributeSet type = new SimpleAttributeSet();
    private final MutableAttributeSet constant = new SimpleAttributeSet();
    private final MutableAttributeSet number = new SimpleAttributeSet();
    private final MutableAttributeSet quote = new SimpleAttributeSet();
    private final boolean m_addBraces;
    protected final MutableAttributeSet normal = new SimpleAttributeSet();

    public SyntaxDocument(boolean bl2) {
        this.doc = this;
        this.m_addBraces = bl2;
        this.rootElement = this.doc.getDefaultRootElement();
        this.putProperty("__EndOfLine__", "\n");
        StyleConstants.setForeground(this.normal, Color.black);
        StyleConstants.setFontSize(this.normal, 13);
        StyleConstants.setForeground(this.comment, Color.gray);
        StyleConstants.setItalic(this.comment, true);
        StyleConstants.setFontSize(this.comment, 13);
        StyleConstants.setForeground(this.keyword, Color.blue.darker());
        StyleConstants.setFontSize(this.keyword, 13);
        StyleConstants.setForeground(this.quote, Color.red);
        StyleConstants.setFontSize(this.quote, 13);
        StyleConstants.setForeground(this.type, Color.PINK.darker());
        StyleConstants.setFontSize(this.type, 13);
        StyleConstants.setForeground(this.number, Color.green.darker());
        StyleConstants.setFontSize(this.number, 13);
        StyleConstants.setForeground(this.constant, Color.red.darker().darker());
        StyleConstants.setFontSize(this.constant, 13);
    }

    private void applyHighlighting(String string, int n2) {
        int n3 = this.rootElement.getElement(n2).getStartOffset();
        int n4 = this.rootElement.getElement(n2).getEndOffset() - 1;
        int n5 = n4 - n3;
        int n6 = string.length();
        if (n4 >= n6) {
            n4 = n6 - 1;
        }
        if (this.endingMultiLineComment(string, n3, n4) || this.isMultiLineComment() || this.startingMultiLineComment(string, n3, n4)) {
            this.doc.setCharacterAttributes(n3, n4 - n3 + 1, this.comment, false);
            return;
        }
        this.doc.setCharacterAttributes(n3, n5, this.normal, true);
        int n7 = string.indexOf(this.getSingleLineDelimiter(), n3);
        if (n7 > -1 && n7 < n4) {
            this.doc.setCharacterAttributes(n7, n4 - n7 + 1, this.comment, false);
            n4 = n7 - 1;
        }
        this.checkForTokens(string, n3, n4);
    }

    private void checkForTokens(String string, int n2, int n3) {
        while (n2 <= n3) {
            while (this.isDelimiter(string.substring(n2, n2 + 1))) {
                if (n2 >= n3) return;
                ++n2;
            }
            if (this.isQuoteDelimiter(string.substring(n2, n2 + 1))) {
                n2 = this.getQuoteToken(string, n2, n3);
                continue;
            }
            n2 = this.getOtherToken(string, n2, n3);
        }
    }

    private void commentLinesAfter(String string, int n2) {
        int n3 = this.rootElement.getElement(n2).getEndOffset();
        int n4 = this.indexOf(string, this.getEndDelimiter(), n3);
        if (n4 < 0) {
            return;
        }
        int n5 = this.lastIndexOf(string, this.getStartDelimiter(), n4);
        if (n5 >= 0) {
            if (n5 > n3) return;
        }
        this.doc.setCharacterAttributes(n3, n4 - n3 + 1, this.comment, false);
    }

    private boolean commentLinesBefore(String string, int n2) {
        int n3 = this.rootElement.getElement(n2).getStartOffset();
        int n4 = this.lastIndexOf(string, this.getStartDelimiter(), n3 - 2);
        if (n4 < 0) {
            return false;
        }
        int n5 = this.indexOf(string, this.getEndDelimiter(), n4);
        if (n5 < n3 & n5 != -1) {
            return false;
        }
        this.doc.setCharacterAttributes(n4, n3 - n4 + 1, this.comment, false);
        return true;
    }

    private boolean endingMultiLineComment(String string, int n2, int n3) {
        int n4 = this.indexOf(string, this.getEndDelimiter(), n2);
        if (n4 < 0) return false;
        if (n4 > n3) {
            return false;
        }
        this.setMultiLineComment(false);
        return true;
    }

    private String getLine(String string, int n2) {
        int n3 = this.rootElement.getElementIndex(n2);
        Element element = this.rootElement.getElement(n3);
        int n4 = element.getStartOffset();
        int n5 = element.getEndOffset();
        return string.substring(n4, n5 - 1);
    }

    private int getOtherToken(String string, int n2, int n3) {
        int n4;
        for (n4 = n2 + 1; n4 <= n3 && !this.isDelimiter(string.substring(n4, n4 + 1)); ++n4) {
        }
        String string2 = string.substring(n2, n4);
        if (this.isKeyword(string2)) {
            this.doc.setCharacterAttributes(n2, n4 - n2, this.keyword, false);
            return n4 + 1;
        }
        if (this.isType(string2)) {
            this.doc.setCharacterAttributes(n2, n4 - n2, this.type, false);
            return n4 + 1;
        }
        if (this.isConstant(string2)) {
            this.doc.setCharacterAttributes(n2, n4 - n2, this.constant, false);
            return n4 + 1;
        }
        if (!Convert.isDecString(string2)) return n4 + 1;
        this.doc.setCharacterAttributes(n2, n4 - n2, this.number, false);
        return n4 + 1;
    }

    private int getQuoteToken(String string, int n2, int n3) {
        String string2 = string.substring(n2, n2 + 1);
        String string3 = this.getEscapeString(string2);
        int n4 = n2;
        int n5 = string.indexOf(string3, n4 + 1);
        while (n5 > -1 && n5 < n3) {
            n4 = n5 + 1;
            n5 = string.indexOf(string3, n4);
        }
        n5 = string.indexOf(string2, n4 + 1);
        n4 = n5 < 0 || n5 > n3 ? n3 : n5;
        this.doc.setCharacterAttributes(n2, n4 - n2 + 1, this.quote, false);
        return n4 + 1;
    }

    private void highlightLinesAfter(String string, int n2) {
        int n3;
        int n4 = this.rootElement.getElement(n2).getEndOffset();
        int n5 = this.indexOf(string, this.getStartDelimiter(), n4);
        int n6 = this.indexOf(string, this.getEndDelimiter(), n4);
        if (n5 < 0) {
            n5 = string.length();
        }
        if (n6 < 0) {
            n6 = string.length();
        }
        if ((n3 = Math.min(n5, n6)) < n4) {
            return;
        }
        int n7 = this.rootElement.getElementIndex(n3);
        int n8 = n2 + 1;
        while (n8 < n7) {
            Element element = this.rootElement.getElement(n8);
            Element element2 = this.doc.getCharacterElement(element.getStartOffset());
            AttributeSet attributeSet = element2.getAttributes();
            if (attributeSet.isEqual(this.comment)) {
                this.applyHighlighting(string, n8);
            }
            ++n8;
        }
    }

    private int indexOf(String string, String string2, int n2) {
        int n3;
        while ((n3 = string.indexOf(string2, n2)) != -1) {
            String string3 = this.getLine(string, n3).trim();
            if (string3.startsWith(string2)) return n3;
            if (string3.endsWith(string2)) {
                return n3;
            }
            n2 = n3 + 1;
        }
        return n3;
    }

    private boolean isMultiLineComment() {
        return this.multiLineComment;
    }

    private int lastIndexOf(String string, String string2, int n2) {
        int n3;
        while ((n3 = string.lastIndexOf(string2, n2)) != -1) {
            String string3 = this.getLine(string, n3).trim();
            if (string3.startsWith(string2)) return n3;
            if (string3.endsWith(string2)) {
                return n3;
            }
            n2 = n3 - 1;
        }
        return n3;
    }

    private void setMultiLineComment(boolean bl2) {
        this.multiLineComment = bl2;
    }

    private boolean startingMultiLineComment(String string, int n2, int n3) {
        int n4 = this.indexOf(string, this.getStartDelimiter(), n2);
        if (n4 < 0) return false;
        if (n4 > n3) {
            return false;
        }
        this.setMultiLineComment(true);
        return true;
    }

    protected String addMatchingBrace(int n2) {
        StringBuffer stringBuffer = new StringBuffer();
        int n3 = this.rootElement.getElementIndex(n2);
        int n4 = this.rootElement.getElement(n3).getStartOffset();
        do {
            String string;
            if (!(string = this.doc.getText(n4, 1)).equals(" ") && !string.equals("\t")) {
                string = String.valueOf(stringBuffer.toString());
                String string2 = String.valueOf(stringBuffer.toString());
                return new StringBuilder(5 + String.valueOf(string).length() + String.valueOf(string2).length()).append("{\n").append(string).append("\t\n").append(string2).append("}").toString();
            }
            stringBuffer.append(string);
            ++n4;
        } while (true);
    }

    protected abstract String getEndDelimiter();

    protected abstract String getEscapeString(String var1);

    protected abstract String getSingleLineDelimiter();

    protected abstract String getStartDelimiter();

    protected abstract HashSet getTabCompletionWords();

    protected abstract boolean isConstant(String var1);

    protected abstract boolean isKeyword(String var1);

    protected abstract boolean isQuoteDelimiter(String var1);

    protected abstract boolean isType(String var1);

    @Override
    public void insertString(int n2, String string, AttributeSet attributeSet) {
        if (this.m_addBraces && string.equals("{")) {
            string = this.addMatchingBrace(n2);
        }
        super.insertString(n2, string, attributeSet);
        this.processChangedLines(n2, string.length());
    }

    public abstract boolean isDelimiter(String var1);

    public void processChangedLines(int n2, int n3) {
        String string = this.doc.getText(0, this.doc.getLength());
        int n4 = this.rootElement.getElementIndex(n2);
        int n5 = this.rootElement.getElementIndex(n2 + n3);
        this.setMultiLineComment(this.commentLinesBefore(string, n4));
        for (int i2 = n4; i2 <= n5; ++i2) {
            this.applyHighlighting(string, i2);
        }
        if (this.isMultiLineComment()) {
            this.commentLinesAfter(string, n5);
            return;
        }
        this.highlightLinesAfter(string, n5);
    }

    @Override
    public void remove(int n2, int n3) {
        super.remove(n2, n3);
        this.processChangedLines(n2, 0);
    }
}

