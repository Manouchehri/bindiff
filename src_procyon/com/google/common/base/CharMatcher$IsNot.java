package com.google.common.base;

import java.util.*;
import com.google.common.annotations.*;

final class CharMatcher$IsNot extends CharMatcher$FastMatcher
{
    private final char match;
    
    CharMatcher$IsNot(final char match) {
        this.match = match;
    }
    
    @Override
    public boolean matches(final char c) {
        return c != this.match;
    }
    
    @Override
    public CharMatcher and(final CharMatcher charMatcher) {
        return charMatcher.matches(this.match) ? super.and(charMatcher) : charMatcher;
    }
    
    @Override
    public CharMatcher or(final CharMatcher charMatcher) {
        return charMatcher.matches(this.match) ? CharMatcher.any() : this;
    }
    
    @GwtIncompatible("java.util.BitSet")
    @Override
    void setBits(final BitSet set) {
        set.set(0, this.match);
        set.set(this.match + '\u0001', 65536);
    }
    
    @Override
    public CharMatcher negate() {
        return CharMatcher.is(this.match);
    }
    
    @Override
    public String toString() {
        final String access$100 = CharMatcher.access$100(this.match);
        return new StringBuilder(21 + String.valueOf(access$100).length()).append("CharMatcher.isNot('").append(access$100).append("')").toString();
    }
}
