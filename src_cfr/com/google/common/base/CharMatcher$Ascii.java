/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher$NamedFastMatcher;

final class CharMatcher$Ascii
extends CharMatcher$NamedFastMatcher {
    static final CharMatcher$Ascii INSTANCE = new CharMatcher$Ascii();

    CharMatcher$Ascii() {
        super("CharMatcher.ascii()");
    }

    @Override
    public boolean matches(char c2) {
        if (c2 > '') return false;
        return true;
    }
}

