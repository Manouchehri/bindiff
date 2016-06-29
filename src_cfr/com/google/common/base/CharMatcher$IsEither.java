/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import java.util.BitSet;

final class CharMatcher$IsEither
extends CharMatcher$FastMatcher {
    private final char match1;
    private final char match2;

    CharMatcher$IsEither(char c2, char c3) {
        this.match1 = c2;
        this.match2 = c3;
    }

    @Override
    public boolean matches(char c2) {
        if (c2 == this.match1) return true;
        if (c2 == this.match2) return true;
        return false;
    }

    @GwtIncompatible(value="java.util.BitSet")
    @Override
    void setBits(BitSet bitSet) {
        bitSet.set(this.match1);
        bitSet.set(this.match2);
    }

    @Override
    public String toString() {
        String string = CharMatcher.access$100(this.match1);
        String string2 = CharMatcher.access$100(this.match2);
        return new StringBuilder(21 + String.valueOf(string).length() + String.valueOf(string2).length()).append("CharMatcher.anyOf(\"").append(string).append(string2).append("\")").toString();
    }
}

