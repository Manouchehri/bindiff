/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$JavaLowerCase
extends CharMatcher {
    static final CharMatcher$JavaLowerCase INSTANCE = new CharMatcher$JavaLowerCase();

    private CharMatcher$JavaLowerCase() {
    }

    @Override
    public boolean matches(char c2) {
        return Character.isLowerCase(c2);
    }

    @Override
    public String toString() {
        return "CharMatcher.javaLowerCase()";
    }
}

