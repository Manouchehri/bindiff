/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$JavaLetterOrDigit
extends CharMatcher {
    static final CharMatcher$JavaLetterOrDigit INSTANCE = new CharMatcher$JavaLetterOrDigit();

    private CharMatcher$JavaLetterOrDigit() {
    }

    @Override
    public boolean matches(char c2) {
        return Character.isLetterOrDigit(c2);
    }

    @Override
    public String toString() {
        return "CharMatcher.javaLetterOrDigit()";
    }
}

