package com.google.common.base;

abstract class StringUtil$CharEscaper
{
    private static final int DEST_PAD = 32;
    private static final ThreadLocal destinationThreadLocalBuffer;
    
    public String escape(final String s) {
        Preconditions.checkNotNull(s);
        for (int length = s.length(), i = 0; i < length; ++i) {
            if (this.escape(s.charAt(i)) != null) {
                return this.escapeSlow(s, i);
            }
        }
        return s;
    }
    
    protected String escapeSlow(final String s, int i) {
        final int length = s.length();
        char[] array = StringUtil$CharEscaper.destinationThreadLocalBuffer.get();
        int length2 = array.length;
        int n = 0;
        int n2 = 0;
        while (i < length) {
            final char[] escape = this.escape(s.charAt(i));
            if (escape != null) {
                final int length3 = escape.length;
                final int n3 = i - n2;
                final int n4 = n + n3 + length3;
                if (length2 < n4) {
                    length2 = n4 + (length - i) + 32;
                    array = growBuffer(array, n, length2);
                }
                if (n3 > 0) {
                    s.getChars(n2, i, array, n);
                    n += n3;
                }
                if (length3 > 0) {
                    System.arraycopy(escape, 0, array, n, length3);
                    n += length3;
                }
                n2 = i + 1;
            }
            ++i;
        }
        final int n5 = length - n2;
        if (n5 > 0) {
            final int n6 = n + n5;
            if (length2 < n6) {
                array = growBuffer(array, n, n6);
            }
            s.getChars(n2, length, array, n);
            n = n6;
        }
        return new String(array, 0, n);
    }
    
    protected abstract char[] escape(final char p0);
    
    private static char[] growBuffer(final char[] array, final int n, final int n2) {
        final char[] array2 = new char[n2];
        if (n > 0) {
            System.arraycopy(array, 0, array2, 0, n);
        }
        return array2;
    }
    
    static {
        destinationThreadLocalBuffer = new StringUtil$CharEscaper$1();
    }
}
