/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Strings {
    private Strings() {
    }

    public static String nullToEmpty(@Nullable String string) {
        if (string == null) {
            return "";
        }
        String string2 = string;
        return string2;
    }

    @Nullable
    public static String emptyToNull(@Nullable String string) {
        if (Strings.isNullOrEmpty(string)) {
            return null;
        }
        String string2 = string;
        return string2;
    }

    public static boolean isNullOrEmpty(@Nullable String string) {
        if (string == null) return true;
        if (string.length() == 0) return true;
        return false;
    }

    public static String padStart(String string, int n2, char c2) {
        Preconditions.checkNotNull(string);
        if (string.length() >= n2) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(n2);
        int n3 = string.length();
        do {
            if (n3 >= n2) {
                stringBuilder.append(string);
                return stringBuilder.toString();
            }
            stringBuilder.append(c2);
            ++n3;
        } while (true);
    }

    public static String padEnd(String string, int n2, char c2) {
        Preconditions.checkNotNull(string);
        if (string.length() >= n2) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(n2);
        stringBuilder.append(string);
        int n3 = string.length();
        while (n3 < n2) {
            stringBuilder.append(c2);
            ++n3;
        }
        return stringBuilder.toString();
    }

    public static String repeat(String string, int n2) {
        Preconditions.checkNotNull(string);
        if (n2 <= 1) {
            Preconditions.checkArgument(n2 >= 0, "invalid count: %s", n2);
            if (n2 == 0) {
                return "";
            }
            String string2 = string;
            return string2;
        }
        int n3 = string.length();
        long l2 = (long)n3 * (long)n2;
        int n4 = (int)l2;
        if ((long)n4 != l2) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(51).append("Required array size too large: ").append(l2).toString());
        }
        char[] arrc = new char[n4];
        string.getChars(0, n3, arrc, 0);
        int n5 = n3;
        do {
            if (n5 >= n4 - n5) {
                System.arraycopy(arrc, 0, arrc, n5, n4 - n5);
                return new String(arrc);
            }
            System.arraycopy(arrc, 0, arrc, n5, n5);
            n5 <<= 1;
        } while (true);
    }

    public static String commonPrefix(CharSequence charSequence, CharSequence charSequence2) {
        int n2;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int n3 = Math.min(charSequence.length(), charSequence2.length());
        for (n2 = 0; n2 < n3 && charSequence.charAt(n2) == charSequence2.charAt(n2); ++n2) {
        }
        if (!Strings.validSurrogatePairAt(charSequence, n2 - 1)) {
            if (!Strings.validSurrogatePairAt(charSequence2, n2 - 1)) return charSequence.subSequence(0, n2).toString();
        }
        --n2;
        return charSequence.subSequence(0, n2).toString();
    }

    public static String commonSuffix(CharSequence charSequence, CharSequence charSequence2) {
        int n2;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int n3 = Math.min(charSequence.length(), charSequence2.length());
        for (n2 = 0; n2 < n3 && charSequence.charAt(charSequence.length() - n2 - 1) == charSequence2.charAt(charSequence2.length() - n2 - 1); ++n2) {
        }
        if (!Strings.validSurrogatePairAt(charSequence, charSequence.length() - n2 - 1)) {
            if (!Strings.validSurrogatePairAt(charSequence2, charSequence2.length() - n2 - 1)) return charSequence.subSequence(charSequence.length() - n2, charSequence.length()).toString();
        }
        --n2;
        return charSequence.subSequence(charSequence.length() - n2, charSequence.length()).toString();
    }

    @VisibleForTesting
    static boolean validSurrogatePairAt(CharSequence charSequence, int n2) {
        if (n2 < 0) return false;
        if (n2 > charSequence.length() - 2) return false;
        if (!Character.isHighSurrogate(charSequence.charAt(n2))) return false;
        if (!Character.isLowSurrogate(charSequence.charAt(n2 + 1))) return false;
        return true;
    }
}

