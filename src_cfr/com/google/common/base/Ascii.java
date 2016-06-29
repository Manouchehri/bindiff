/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
public final class Ascii {
    public static final byte NUL = 0;
    public static final byte SOH = 1;
    public static final byte STX = 2;
    public static final byte ETX = 3;
    public static final byte EOT = 4;
    public static final byte ENQ = 5;
    public static final byte ACK = 6;
    public static final byte BEL = 7;
    public static final byte BS = 8;
    public static final byte HT = 9;
    public static final byte LF = 10;
    public static final byte NL = 10;
    public static final byte VT = 11;
    public static final byte FF = 12;
    public static final byte CR = 13;
    public static final byte SO = 14;
    public static final byte SI = 15;
    public static final byte DLE = 16;
    public static final byte DC1 = 17;
    public static final byte XON = 17;
    public static final byte DC2 = 18;
    public static final byte DC3 = 19;
    public static final byte XOFF = 19;
    public static final byte DC4 = 20;
    public static final byte NAK = 21;
    public static final byte SYN = 22;
    public static final byte ETB = 23;
    public static final byte CAN = 24;
    public static final byte EM = 25;
    public static final byte SUB = 26;
    public static final byte ESC = 27;
    public static final byte FS = 28;
    public static final byte GS = 29;
    public static final byte RS = 30;
    public static final byte US = 31;
    public static final byte SP = 32;
    public static final byte SPACE = 32;
    public static final byte DEL = 127;
    public static final char MIN = '\u0000';
    public static final char MAX = '';

    private Ascii() {
    }

    public static String toLowerCase(String string) {
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            if (Ascii.isUpperCase(string.charAt(n3))) {
                char[] arrc = string.toCharArray();
                while (n3 < n2) {
                    char c2 = arrc[n3];
                    if (Ascii.isUpperCase(c2)) {
                        arrc[n3] = (char)(c2 ^ 32);
                    }
                    ++n3;
                }
                return String.valueOf(arrc);
            }
            ++n3;
        }
        return string;
    }

    public static String toLowerCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return Ascii.toLowerCase((String)charSequence);
        }
        int n2 = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(n2);
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append(Ascii.toLowerCase(charSequence.charAt(n3)));
            ++n3;
        }
        return stringBuilder.toString();
    }

    public static char toLowerCase(char c2) {
        char c3;
        if (Ascii.isUpperCase(c2)) {
            c3 = (char)(c2 ^ 32);
            return c3;
        }
        c3 = c2;
        return c3;
    }

    public static String toUpperCase(String string) {
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            if (Ascii.isLowerCase(string.charAt(n3))) {
                char[] arrc = string.toCharArray();
                while (n3 < n2) {
                    char c2 = arrc[n3];
                    if (Ascii.isLowerCase(c2)) {
                        arrc[n3] = (char)(c2 & 95);
                    }
                    ++n3;
                }
                return String.valueOf(arrc);
            }
            ++n3;
        }
        return string;
    }

    public static String toUpperCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return Ascii.toUpperCase((String)charSequence);
        }
        int n2 = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(n2);
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append(Ascii.toUpperCase(charSequence.charAt(n3)));
            ++n3;
        }
        return stringBuilder.toString();
    }

    public static char toUpperCase(char c2) {
        char c3;
        if (Ascii.isLowerCase(c2)) {
            c3 = (char)(c2 & 95);
            return c3;
        }
        c3 = c2;
        return c3;
    }

    public static boolean isLowerCase(char c2) {
        if (c2 < 'a') return false;
        if (c2 > 'z') return false;
        return true;
    }

    public static boolean isUpperCase(char c2) {
        if (c2 < 'A') return false;
        if (c2 > 'Z') return false;
        return true;
    }

    @Beta
    public static String truncate(CharSequence charSequence, int n2, String string) {
        Preconditions.checkNotNull(charSequence);
        int n3 = n2 - string.length();
        Preconditions.checkArgument(n3 >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", n2, string.length());
        if (charSequence.length() > n2) return new StringBuilder(n2).append(charSequence, 0, n3).append(string).toString();
        String string2 = charSequence.toString();
        if (string2.length() <= n2) {
            return string2;
        }
        charSequence = string2;
        return new StringBuilder(n2).append(charSequence, 0, n3).append(string).toString();
    }

    @Beta
    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        int n2 = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (n2 != charSequence2.length()) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            char c2;
            char c3 = charSequence.charAt(n3);
            if (c3 != (c2 = charSequence2.charAt(n3))) {
                int n4 = Ascii.getAlphaIndex(c3);
                if (n4 >= 26) return false;
                if (n4 != Ascii.getAlphaIndex(c2)) return false;
            }
            ++n3;
        }
        return true;
    }

    private static int getAlphaIndex(char c2) {
        return (char)((c2 | 32) - 97);
    }
}

