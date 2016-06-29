/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$JavaLetter
extends CharMatcher {
    static final CharMatcher$JavaLetter INSTANCE = new CharMatcher$JavaLetter();

    private CharMatcher$JavaLetter() {
    }

    @Override
    public boolean matches(char c2) {
        return Character.isLetter(c2);
    }

    @Override
    public String toString() {
        return "CharMatcher.javaLetter()";
    }
}

