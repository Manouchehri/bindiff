/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

final class CharMatcher$InRange
extends CharMatcher$FastMatcher {
    private final char startInclusive;
    private final char endInclusive;

    CharMatcher$InRange(char c2, char c3) {
        Preconditions.checkArgument(c3 >= c2);
        this.startInclusive = c2;
        this.endInclusive = c3;
    }

    @Override
    public boolean matches(char c2) {
        if (this.startInclusive > c2) return false;
        if (c2 > this.endInclusive) return false;
        return true;
    }

    @GwtIncompatible(value="java.util.BitSet")
    @Override
    void setBits(BitSet bitSet) {
        bitSet.set((int)this.startInclusive, this.endInclusive + '\u0001');
    }

    @Override
    public String toString() {
        String string = CharMatcher.access$100(this.startInclusive);
        String string2 = CharMatcher.access$100(this.endInclusive);
        return new StringBuilder(27 + String.valueOf(string).length() + String.valueOf(string2).length()).append("CharMatcher.inRange('").append(string).append("', '").append(string2).append("')").toString();
    }
}

