/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NegatedFastMatcher;

class CharMatcher$1
extends CharMatcher$NegatedFastMatcher {
    final /* synthetic */ String val$description;
    final /* synthetic */ CharMatcher this$0;

    CharMatcher$1(CharMatcher charMatcher, CharMatcher charMatcher2, String string) {
        this.this$0 = charMatcher;
        this.val$description = string;
        super(charMatcher2);
    }

    @Override
    public String toString() {
        return this.val$description;
    }
}

