package com.google.common.base;

import java.util.*;
import com.google.common.annotations.*;

class CharMatcher$Negated extends CharMatcher
{
    final CharMatcher original;
    
    CharMatcher$Negated(final CharMatcher charMatcher) {
        this.original = (CharMatcher)Preconditions.checkNotNull(charMatcher);
    }
    
    @Override
    public boolean matches(final char c) {
        return !this.original.matches(c);
    }
    
    @Override
    public boolean matchesAllOf(final CharSequence charSequence) {
        return this.original.matchesNoneOf(charSequence);
    }
    
    @Override
    public boolean matchesNoneOf(final CharSequence charSequence) {
        return this.original.matchesAllOf(charSequence);
    }
    
    @Override
    public int countIn(final CharSequence charSequence) {
        return charSequence.length() - this.original.countIn(charSequence);
    }
    
    @GwtIncompatible("java.util.BitSet")
    @Override
    void setBits(final BitSet set) {
        final BitSet bits = new BitSet();
        this.original.setBits(bits);
        bits.flip(0, 65536);
        set.or(bits);
    }
    
    @Override
    public CharMatcher negate() {
        return this.original;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.original);
        return new StringBuilder(9 + String.valueOf(value).length()).append(value).append(".negate()").toString();
    }
}
