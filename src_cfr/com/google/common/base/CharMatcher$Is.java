/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import java.util.BitSet;

final class CharMatcher$Is
extends CharMatcher$FastMatcher {
    private final char match;

    CharMatcher$Is(char c2) {
        this.match = c2;
    }

    @Override
    public boolean matches(char c2) {
        if (c2 != this.match) return false;
        return true;
    }

    @Override
    public String replaceFrom(CharSequence charSequence, char c2) {
        return charSequence.toString().replace(this.match, c2);
    }

    @Override
    public CharMatcher and(CharMatcher charMatcher) {
        CharMatcher$Is charMatcher$Is /* !! */ ;
        if (charMatcher.matches(this.match)) {
            charMatcher$Is /* !! */  = this;
            return charMatcher$Is /* !! */ ;
        }
        charMatcher$Is /* !! */  = CharMatcher$Is.none();
        return charMatcher$Is /* !! */ ;
    }

    @Override
    public CharMatcher or(CharMatcher charMatcher) {
        CharMatcher charMatcher2;
        if (charMatcher.matches(this.match)) {
            charMatcher2 = charMatcher;
            return charMatcher2;
        }
        charMatcher2 = super.or(charMatcher);
        return charMatcher2;
    }

    @Override
    public CharMatcher negate() {
        return CharMatcher$Is.isNot(this.match);
    }

    @GwtIncompatible(value="java.util.BitSet")
    @Override
    void setBits(BitSet bitSet) {
        bitSet.set(this.match);
    }

    @Override
    public String toString() {
        String string = CharMatcher.access$100(this.match);
        return new StringBuilder(18 + String.valueOf(string).length()).append("CharMatcher.is('").append(string).append("')").toString();
    }
}

