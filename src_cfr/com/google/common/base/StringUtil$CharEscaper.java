/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.StringUtil$1;
import com.google.common.base.StringUtil$CharEscaper$1;

abstract class StringUtil$CharEscaper {
    private static final int DEST_PAD = 32;
    private static final ThreadLocal destinationThreadLocalBuffer = new StringUtil$CharEscaper$1();

    private StringUtil$CharEscaper() {
    }

    public String escape(String string) {
        Preconditions.checkNotNull(string);
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            if (this.escape(string.charAt(n3)) != null) {
                return this.escapeSlow(string, n3);
            }
            ++n3;
        }
        return string;
    }

    protected String escapeSlow(String string, int n2) {
        int n3;
        int n4 = string.length();
        char[] arrc = (char[])destinationThreadLocalBuffer.get();
        int n5 = arrc.length;
        int n6 = 0;
        int n7 = 0;
        while (n2 < n4) {
            char[] arrc2 = this.escape(string.charAt(n2));
            if (arrc2 != null) {
                int n8 = n2 - n7;
                n3 = arrc2.length;
                int n9 = n6 + n8 + n3;
                if (n5 < n9) {
                    n5 = n9 + (n4 - n2) + 32;
                    arrc = StringUtil$CharEscaper.growBuffer(arrc, n6, n5);
                }
                if (n8 > 0) {
                    string.getChars(n7, n2, arrc, n6);
                    n6 += n8;
                }
                if (n3 > 0) {
                    System.arraycopy(arrc2, 0, arrc, n6, n3);
                    n6 += n3;
                }
                n7 = n2 + 1;
            }
            ++n2;
        }
        int n10 = n4 - n7;
        if (n10 <= 0) return new String(arrc, 0, n6);
        n3 = n6 + n10;
        if (n5 < n3) {
            arrc = StringUtil$CharEscaper.growBuffer(arrc, n6, n3);
        }
        string.getChars(n7, n4, arrc, n6);
        n6 = n3;
        return new String(arrc, 0, n6);
    }

    protected abstract char[] escape(char var1);

    private static char[] growBuffer(char[] arrc, int n2, int n3) {
        char[] arrc2 = new char[n3];
        if (n2 <= 0) return arrc2;
        System.arraycopy(arrc, 0, arrc2, 0, n2);
        return arrc2;
    }

    /* synthetic */ StringUtil$CharEscaper(StringUtil$1 stringUtil$1) {
        this();
    }
}

