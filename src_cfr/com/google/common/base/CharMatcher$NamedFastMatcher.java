/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher$FastMatcher;
import com.google.common.base.Preconditions;

abstract class CharMatcher$NamedFastMatcher
extends CharMatcher$FastMatcher {
    private final String description;

    CharMatcher$NamedFastMatcher(String string) {
        this.description = (String)Preconditions.checkNotNull(string);
    }

    @Override
    public final String toString() {
        return this.description;
    }
}

