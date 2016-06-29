/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

final class CharMatcher$And
extends CharMatcher {
    final CharMatcher first;
    final CharMatcher second;

    CharMatcher$And(CharMatcher charMatcher, CharMatcher charMatcher2) {
        this.first = (CharMatcher)Preconditions.checkNotNull(charMatcher);
        this.second = (CharMatcher)Preconditions.checkNotNull(charMatcher2);
    }

    @Override
    public boolean matches(char c2) {
        if (!this.first.matches(c2)) return false;
        if (!this.second.matches(c2)) return false;
        return true;
    }

    @GwtIncompatible(value="java.util.BitSet")
    @Override
    void setBits(BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        this.first.setBits(bitSet2);
        BitSet bitSet3 = new BitSet();
        this.second.setBits(bitSet3);
        bitSet2.and(bitSet3);
        bitSet.or(bitSet2);
    }

    @Override
    public String toString() {
        String string = String.valueOf(this.first);
        String string2 = String.valueOf(this.second);
        return new StringBuilder(19 + String.valueOf(string).length() + String.valueOf(string2).length()).append("CharMatcher.and(").append(string).append(", ").append(string2).append(")").toString();
    }
}

