/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher$NamedFastMatcher;

final class CharMatcher$JavaIsoControl
extends CharMatcher$NamedFastMatcher {
    static final CharMatcher$JavaIsoControl INSTANCE = new CharMatcher$JavaIsoControl();

    private CharMatcher$JavaIsoControl() {
        super("CharMatcher.javaIsoControl()");
    }

    @Override
    public boolean matches(char c2) {
        if (c2 <= '\u001f') return true;
        if (c2 < '') return false;
        if (c2 > '\u009f') return false;
        return true;
    }
}

