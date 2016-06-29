package com.google.security.zynamics.zylib.gui.scripting;

import java.awt.*;
import javax.swing.text.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;

public abstract class SyntaxDocument extends DefaultStyledDocument
{
    private static final long serialVersionUID = 5437418885392724717L;
    private static final int DEFAULT_FONT_SIZE = 13;
    private final DefaultStyledDocument doc;
    private final Element rootElement;
    private boolean multiLineComment;
    private final MutableAttributeSet comment;
    private final MutableAttributeSet keyword;
    private final MutableAttributeSet type;
    private final MutableAttributeSet constant;
    private final MutableAttributeSet number;
    private final MutableAttributeSet quote;
    private final boolean m_addBraces;
    protected final MutableAttributeSet normal;
    
    public SyntaxDocument(final boolean addBraces) {
        this.comment = new SimpleAttributeSet();
        this.keyword = new SimpleAttributeSet();
        this.type = new SimpleAttributeSet();
        this.constant = new SimpleAttributeSet();
        this.number = new SimpleAttributeSet();
        this.quote = new SimpleAttributeSet();
        this.normal = new SimpleAttributeSet();
        this.doc = this;
        this.m_addBraces = addBraces;
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
    
    private void applyHighlighting(final String s, final int n) {
        final int startOffset = this.rootElement.getElement(n).getStartOffset();
        int n2 = this.rootElement.getElement(n).getEndOffset() - 1;
        final int n3 = n2 - startOffset;
        final int length = s.length();
        if (n2 >= length) {
            n2 = length - 1;
        }
        if (this.endingMultiLineComment(s, startOffset, n2) || this.isMultiLineComment() || this.startingMultiLineComment(s, startOffset, n2)) {
            this.doc.setCharacterAttributes(startOffset, n2 - startOffset + 1, this.comment, false);
            return;
        }
        this.doc.setCharacterAttributes(startOffset, n3, this.normal, true);
        final int index = s.indexOf(this.getSingleLineDelimiter(), startOffset);
        if (index > -1 && index < n2) {
            this.doc.setCharacterAttributes(index, n2 - index + 1, this.comment, false);
            n2 = index - 1;
        }
        this.checkForTokens(s, startOffset, n2);
    }
    
    private void checkForTokens(final String s, int i, final int n) {
        while (i <= n) {
            while (this.isDelimiter(s.substring(i, i + 1))) {
                if (i >= n) {
                    return;
                }
                ++i;
            }
            if (this.isQuoteDelimiter(s.substring(i, i + 1))) {
                i = this.getQuoteToken(s, i, n);
            }
            else {
                i = this.getOtherToken(s, i, n);
            }
        }
    }
    
    private void commentLinesAfter(final String s, final int n) {
        final int endOffset = this.rootElement.getElement(n).getEndOffset();
        final int index = this.indexOf(s, this.getEndDelimiter(), endOffset);
        if (index < 0) {
            return;
        }
        final int lastIndex = this.lastIndexOf(s, this.getStartDelimiter(), index);
        if (lastIndex < 0 || lastIndex <= endOffset) {
            this.doc.setCharacterAttributes(endOffset, index - endOffset + 1, this.comment, false);
        }
    }
    
    private boolean commentLinesBefore(final String s, final int n) {
        final int startOffset = this.rootElement.getElement(n).getStartOffset();
        final int lastIndex = this.lastIndexOf(s, this.getStartDelimiter(), startOffset - 2);
        if (lastIndex < 0) {
            return false;
        }
        final int index = this.indexOf(s, this.getEndDelimiter(), lastIndex);
        if (index < startOffset & index != -1) {
            return false;
        }
        this.doc.setCharacterAttributes(lastIndex, startOffset - lastIndex + 1, this.comment, false);
        return true;
    }
    
    private boolean endingMultiLineComment(final String s, final int n, final int n2) {
        final int index = this.indexOf(s, this.getEndDelimiter(), n);
        if (index < 0 || index > n2) {
            return false;
        }
        this.setMultiLineComment(false);
        return true;
    }
    
    private String getLine(final String s, final int n) {
        final Element element = this.rootElement.getElement(this.rootElement.getElementIndex(n));
        return s.substring(element.getStartOffset(), element.getEndOffset() - 1);
    }
    
    private int getOtherToken(final String s, final int n, final int n2) {
        int n3;
        for (n3 = n + 1; n3 <= n2 && !this.isDelimiter(s.substring(n3, n3 + 1)); ++n3) {}
        final String substring = s.substring(n, n3);
        if (this.isKeyword(substring)) {
            this.doc.setCharacterAttributes(n, n3 - n, this.keyword, false);
        }
        else if (this.isType(substring)) {
            this.doc.setCharacterAttributes(n, n3 - n, this.type, false);
        }
        else if (this.isConstant(substring)) {
            this.doc.setCharacterAttributes(n, n3 - n, this.constant, false);
        }
        else if (Convert.isDecString(substring)) {
            this.doc.setCharacterAttributes(n, n3 - n, this.number, false);
        }
        return n3 + 1;
    }
    
    private int getQuoteToken(final String s, final int n, final int n2) {
        final String substring = s.substring(n, n + 1);
        final String escapeString = this.getEscapeString(substring);
        int n3 = n;
        for (int n4 = s.indexOf(escapeString, n3 + 1); n4 > -1 && n4 < n2; n4 = s.indexOf(escapeString, n3)) {
            n3 = n4 + 1;
        }
        final int index = s.indexOf(substring, n3 + 1);
        int n5;
        if (index < 0 || index > n2) {
            n5 = n2;
        }
        else {
            n5 = index;
        }
        this.doc.setCharacterAttributes(n, n5 - n + 1, this.quote, false);
        return n5 + 1;
    }
    
    private void highlightLinesAfter(final String s, final int n) {
        final int endOffset = this.rootElement.getElement(n).getEndOffset();
        int n2 = this.indexOf(s, this.getStartDelimiter(), endOffset);
        int n3 = this.indexOf(s, this.getEndDelimiter(), endOffset);
        if (n2 < 0) {
            n2 = s.length();
        }
        if (n3 < 0) {
            n3 = s.length();
        }
        final int min = Math.min(n2, n3);
        if (min < endOffset) {
            return;
        }
        for (int elementIndex = this.rootElement.getElementIndex(min), i = n + 1; i < elementIndex; ++i) {
            if (this.doc.getCharacterElement(this.rootElement.getElement(i).getStartOffset()).getAttributes().isEqual(this.comment)) {
                this.applyHighlighting(s, i);
            }
        }
    }
    
    private int indexOf(final String s, final String s2, int n) {
        int index;
        while ((index = s.indexOf(s2, n)) != -1) {
            final String trim = this.getLine(s, index).trim();
            if (trim.startsWith(s2)) {
                break;
            }
            if (trim.endsWith(s2)) {
                break;
            }
            n = index + 1;
        }
        return index;
    }
    
    private boolean isMultiLineComment() {
        return this.multiLineComment;
    }
    
    private int lastIndexOf(final String s, final String s2, int n) {
        int lastIndex;
        while ((lastIndex = s.lastIndexOf(s2, n)) != -1) {
            final String trim = this.getLine(s, lastIndex).trim();
            if (trim.startsWith(s2)) {
                break;
            }
            if (trim.endsWith(s2)) {
                break;
            }
            n = lastIndex - 1;
        }
        return lastIndex;
    }
    
    private void setMultiLineComment(final boolean multiLineComment) {
        this.multiLineComment = multiLineComment;
    }
    
    private boolean startingMultiLineComment(final String s, final int n, final int n2) {
        final int index = this.indexOf(s, this.getStartDelimiter(), n);
        if (index < 0 || index > n2) {
            return false;
        }
        this.setMultiLineComment(true);
        return true;
    }
    
    protected String addMatchingBrace(final int n) {
        final StringBuffer sb = new StringBuffer();
        int startOffset = this.rootElement.getElement(this.rootElement.getElementIndex(n)).getStartOffset();
        while (true) {
            final String text = this.doc.getText(startOffset, 1);
            if (!text.equals(" ") && !text.equals("\t")) {
                break;
            }
            sb.append(text);
            ++startOffset;
        }
        final String value = String.valueOf(sb.toString());
        final String value2 = String.valueOf(sb.toString());
        return new StringBuilder(5 + String.valueOf(value).length() + String.valueOf(value2).length()).append("{\n").append(value).append("\t\n").append(value2).append("}").toString();
    }
    
    protected abstract String getEndDelimiter();
    
    protected abstract String getEscapeString(final String p0);
    
    protected abstract String getSingleLineDelimiter();
    
    protected abstract String getStartDelimiter();
    
    protected abstract HashSet getTabCompletionWords();
    
    protected abstract boolean isConstant(final String p0);
    
    protected abstract boolean isKeyword(final String p0);
    
    protected abstract boolean isQuoteDelimiter(final String p0);
    
    protected abstract boolean isType(final String p0);
    
    @Override
    public void insertString(final int n, String addMatchingBrace, final AttributeSet set) {
        if (this.m_addBraces && addMatchingBrace.equals("{")) {
            addMatchingBrace = this.addMatchingBrace(n);
        }
        super.insertString(n, addMatchingBrace, set);
        this.processChangedLines(n, addMatchingBrace.length());
    }
    
    public abstract boolean isDelimiter(final String p0);
    
    public void processChangedLines(final int n, final int n2) {
        final String text = this.doc.getText(0, this.doc.getLength());
        final int elementIndex = this.rootElement.getElementIndex(n);
        final int elementIndex2 = this.rootElement.getElementIndex(n + n2);
        this.setMultiLineComment(this.commentLinesBefore(text, elementIndex));
        for (int i = elementIndex; i <= elementIndex2; ++i) {
            this.applyHighlighting(text, i);
        }
        if (this.isMultiLineComment()) {
            this.commentLinesAfter(text, elementIndex2);
        }
        else {
            this.highlightLinesAfter(text, elementIndex2);
        }
    }
    
    @Override
    public void remove(final int n, final int n2) {
        super.remove(n, n2);
        this.processChangedLines(n, 0);
    }
}
