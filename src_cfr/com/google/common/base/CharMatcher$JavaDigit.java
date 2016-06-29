/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$JavaDigit
extends CharMatcher {
    static final CharMatcher$JavaDigit INSTANCE = new CharMatcher$JavaDigit();

    private CharMatcher$JavaDigit() {
    }

    @Override
    public boolean matches(char c2) {
        return Character.isDigit(c2);
    }

    @Override
    public String toString() {
        return "CharMatcher.javaDigit()";
    }
}

