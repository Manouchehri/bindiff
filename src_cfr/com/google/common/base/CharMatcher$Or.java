/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

final class CharMatcher$Or
extends CharMatcher {
    final CharMatcher first;
    final CharMatcher second;

    CharMatcher$Or(CharMatcher charMatcher, CharMatcher charMatcher2) {
        this.first = (CharMatcher)Preconditions.checkNotNull(charMatcher);
        this.second = (CharMatcher)Preconditions.checkNotNull(charMatcher2);
    }

    @GwtIncompatible(value="java.util.BitSet")
    @Override
    void setBits(BitSet bitSet) {
        this.first.setBits(bitSet);
        this.second.setBits(bitSet);
    }

    @Override
    public boolean matches(char c2) {
        if (this.first.matches(c2)) return true;
        if (this.second.matches(c2)) return true;
        return false;
    }

    @Override
    public String toString() {
        String string = String.valueOf(this.first);
        String string2 = String.valueOf(this.second);
        return new StringBuilder(18 + String.valueOf(string).length() + String.valueOf(string2).length()).append("CharMatcher.or(").append(string).append(", ").append(string2).append(")").toString();
    }
}

