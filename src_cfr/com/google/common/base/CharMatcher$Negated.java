/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

class CharMatcher$Negated
extends CharMatcher {
    final CharMatcher original;

    CharMatcher$Negated(CharMatcher charMatcher) {
        this.original = (CharMatcher)Preconditions.checkNotNull(charMatcher);
    }

    @Override
    public boolean matches(char c2) {
        if (this.original.matches(c2)) return false;
        return true;
    }

    @Override
    public boolean matchesAllOf(CharSequence charSequence) {
        return this.original.matchesNoneOf(charSequence);
    }

    @Override
    public boolean matchesNoneOf(CharSequence charSequence) {
        return this.original.matchesAllOf(charSequence);
    }

    @Override
    public int countIn(CharSequence charSequence) {
        return charSequence.length() - this.original.countIn(charSequence);
    }

    @GwtIncompatible(value="java.util.BitSet")
    @Override
    void setBits(BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        this.original.setBits(bitSet2);
        bitSet2.flip(0, 65536);
        bitSet.or(bitSet2);
    }

    @Override
    public CharMatcher negate() {
        return this.original;
    }

    @Override
    public String toString() {
        String string = String.valueOf(this.original);
        return new StringBuilder(9 + String.valueOf(string).length()).append(string).append(".negate()").toString();
    }
}

