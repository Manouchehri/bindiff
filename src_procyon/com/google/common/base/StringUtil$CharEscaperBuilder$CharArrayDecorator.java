package com.google.common.base;

class StringUtil$CharEscaperBuilder$CharArrayDecorator extends StringUtil$CharEscaper
{
    private final char[][] replacements;
    private final int replaceLength;
    
    StringUtil$CharEscaperBuilder$CharArrayDecorator(final char[][] replacements) {
        super(null);
        this.replacements = replacements;
        this.replaceLength = replacements.length;
    }
    
    @Override
    public String escape(final String s) {
        for (int length = s.length(), i = 0; i < length; ++i) {
            final char char1 = s.charAt(i);
            if (char1 < this.replacements.length && this.replacements[char1] != null) {
                return this.escapeSlow(s, i);
            }
        }
        return s;
    }
    
    @Override
    protected char[] escape(final char c) {
        return (char[])((c < this.replaceLength) ? this.replacements[c] : null);
    }
}
