/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.StringUtil$1;
import com.google.common.base.StringUtil$CharEscaper;

class StringUtil$CharEscaperBuilder$CharArrayDecorator
extends StringUtil$CharEscaper {
    private final char[][] replacements;
    private final int replaceLength;

    StringUtil$CharEscaperBuilder$CharArrayDecorator(char[][] arrc) {
        super(null);
        this.replacements = arrc;
        this.replaceLength = arrc.length;
    }

    @Override
    public String escape(String string) {
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if (c2 < this.replacements.length && this.replacements[c2] != null) {
                return this.escapeSlow(string, n3);
            }
            ++n3;
        }
        return string;
    }

    @Override
    protected char[] escape(char c2) {
        if (c2 >= this.replaceLength) return null;
        char[] arrc = this.replacements[c2];
        return arrc;
    }
}

