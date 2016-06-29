/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$JavaUpperCase
extends CharMatcher {
    static final CharMatcher$JavaUpperCase INSTANCE = new CharMatcher$JavaUpperCase();

    private CharMatcher$JavaUpperCase() {
    }

    @Override
    public boolean matches(char c2) {
        return Character.isUpperCase(c2);
    }

    @Override
    public String toString() {
        return "CharMatcher.javaUpperCase()";
    }
}

