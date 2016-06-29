package org.jfree.ui;

import javax.swing.text.*;

public class LengthLimitingDocument extends PlainDocument
{
    private int maxlen;
    
    public LengthLimitingDocument() {
        this(-1);
    }
    
    public LengthLimitingDocument(final int maxlen) {
        this.maxlen = maxlen;
    }
    
    public void setMaxLength(final int maxlen) {
        this.maxlen = maxlen;
    }
    
    public int getMaxLength() {
        return this.maxlen;
    }
    
    public void insertString(final int n, final String s, final AttributeSet set) {
        if (s == null) {
            return;
        }
        if (this.maxlen < 0) {
            super.insertString(n, s, set);
        }
        final char[] charArray = s.toCharArray();
        final StringBuffer sb = new StringBuffer();
        sb.append(charArray, 0, Math.min(this.maxlen, charArray.length));
        super.insertString(n, sb.toString(), set);
    }
}
