/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NamedFastMatcher;
import com.google.common.base.Preconditions;

final class CharMatcher$None
extends CharMatcher$NamedFastMatcher {
    static final CharMatcher$None INSTANCE = new CharMatcher$None();

    private CharMatcher$None() {
        super("CharMatcher.none()");
    }

    @Override
    public boolean matches(char c2) {
        return false;
    }

    @Override
    public int indexIn(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return -1;
    }

    @Override
    public int indexIn(CharSequence charSequence, int n2) {
        int n3 = charSequence.length();
        Preconditions.checkPositionIndex(n2, n3);
        return -1;
    }

    @Override
    public int lastIndexIn(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return -1;
    }

    @Override
    public boolean matchesAllOf(CharSequence charSequence) {
        if (charSequence.length() != 0) return false;
        return true;
    }

    @Override
    public boolean matchesNoneOf(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return true;
    }

    @Override
    public String removeFrom(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public String replaceFrom(CharSequence charSequence, char c2) {
        return charSequence.toString();
    }

    @Override
    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence2);
        return charSequence.toString();
    }

    @Override
    public String collapseFrom(CharSequence charSequence, char c2) {
        return charSequence.toString();
    }

    @Override
    public String trimFrom(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public String trimLeadingFrom(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public String trimTrailingFrom(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public int countIn(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return 0;
    }

    @Override
    public CharMatcher and(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return this;
    }

    @Override
    public CharMatcher or(CharMatcher charMatcher) {
        return (CharMatcher)Preconditions.checkNotNull(charMatcher);
    }

    @Override
    public CharMatcher negate() {
        return CharMatcher$None.any();
    }
}

