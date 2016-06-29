/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$Negated;

class CharMatcher$NegatedFastMatcher
extends CharMatcher$Negated {
    CharMatcher$NegatedFastMatcher(CharMatcher charMatcher) {
        super(charMatcher);
    }

    @Override
    public final CharMatcher precomputed() {
        return this;
    }
}

