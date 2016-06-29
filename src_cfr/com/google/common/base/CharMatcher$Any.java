/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NamedFastMatcher;
import com.google.common.base.Preconditions;
import java.util.Arrays;

final class CharMatcher$Any
extends CharMatcher$NamedFastMatcher {
    static final CharMatcher$Any INSTANCE = new CharMatcher$Any();

    private CharMatcher$Any() {
        super("CharMatcher.any()");
    }

    @Override
    public boolean matches(char c2) {
        return true;
    }

    @Override
    public int indexIn(CharSequence charSequence) {
        if (charSequence.length() != 0) return 0;
        return -1;
    }

    @Override
    public int indexIn(CharSequence charSequence, int n2) {
        int n3 = charSequence.length();
        Preconditions.checkPositionIndex(n2, n3);
        if (n2 == n3) {
            return -1;
        }
        int n4 = n2;
        return n4;
    }

    @Override
    public int lastIndexIn(CharSequence charSequence) {
        return charSequence.length() - 1;
    }

    @Override
    public boolean matchesAllOf(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return true;
    }

    @Override
    public boolean matchesNoneOf(CharSequence charSequence) {
        if (charSequence.length() != 0) return false;
        return true;
    }

    @Override
    public String removeFrom(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return "";
    }

    @Override
    public String replaceFrom(CharSequence charSequence, char c2) {
        char[] arrc = new char[charSequence.length()];
        Arrays.fill(arrc, c2);
        return new String(arrc);
    }

    @Override
    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        StringBuilder stringBuilder = new StringBuilder(charSequence.length() * charSequence2.length());
        int n2 = 0;
        while (n2 < charSequence.length()) {
            stringBuilder.append(charSequence2);
            ++n2;
        }
        return stringBuilder.toString();
    }

    @Override
    public String collapseFrom(CharSequence charSequence, char c2) {
        if (charSequence.length() == 0) {
            return "";
        }
        String string = String.valueOf(c2);
        return string;
    }

    @Override
    public String trimFrom(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return "";
    }

    @Override
    public int countIn(CharSequence charSequence) {
        return charSequence.length();
    }

    @Override
    public CharMatcher and(CharMatcher charMatcher) {
        return (CharMatcher)Preconditions.checkNotNull(charMatcher);
    }

    @Override
    public CharMatcher or(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return this;
    }

    @Override
    public CharMatcher negate() {
        return CharMatcher$Any.none();
    }
}

