/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NegatedFastMatcher;

abstract class CharMatcher$FastMatcher
extends CharMatcher {
    CharMatcher$FastMatcher() {
    }

    @Override
    public final CharMatcher precomputed() {
        return this;
    }

    @Override
    public CharMatcher negate() {
        return new CharMatcher$NegatedFastMatcher(this);
    }
}

