/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import java.util.BitSet;

final class CharMatcher$IsNot
extends CharMatcher$FastMatcher {
    private final char match;

    CharMatcher$IsNot(char c2) {
        this.match = c2;
    }

    @Override
    public boolean matches(char c2) {
        if (c2 == this.match) return false;
        return true;
    }

    @Override
    public CharMatcher and(CharMatcher charMatcher) {
        CharMatcher charMatcher2;
        if (charMatcher.matches(this.match)) {
            charMatcher2 = super.and(charMatcher);
            return charMatcher2;
        }
        charMatcher2 = charMatcher;
        return charMatcher2;
    }

    @Override
    public CharMatcher or(CharMatcher charMatcher) {
        CharMatcher charMatcher2;
        if (charMatcher.matches(this.match)) {
            charMatcher2 = CharMatcher$IsNot.any();
            return charMatcher2;
        }
        charMatcher2 = this;
        return charMatcher2;
    }

    @GwtIncompatible(value="java.util.BitSet")
    @Override
    void setBits(BitSet bitSet) {
        bitSet.set(0, this.match);
        bitSet.set(this.match + '\u0001', 65536);
    }

    @Override
    public CharMatcher negate() {
        return CharMatcher$IsNot.is(this.match);
    }

    @Override
    public String toString() {
        String string = CharMatcher.access$100(this.match);
        return new StringBuilder(21 + String.valueOf(string).length()).append("CharMatcher.isNot('").append(string).append("')").toString();
    }
}

