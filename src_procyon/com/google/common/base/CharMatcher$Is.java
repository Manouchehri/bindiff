package com.google.common.base;

import java.util.*;
import com.google.common.annotations.*;

final class CharMatcher$Is extends CharMatcher$FastMatcher
{
    private final char match;
    
    CharMatcher$Is(final char match) {
        this.match = match;
    }
    
    @Override
    public boolean matches(final char c) {
        return c == this.match;
    }
    
    @Override
    public String replaceFrom(final CharSequence charSequence, final char c) {
        return charSequence.toString().replace(this.match, c);
    }
    
    @Override
    public CharMatcher and(final CharMatcher charMatcher) {
        return charMatcher.matches(this.match) ? this : CharMatcher.none();
    }
    
    @Override
    public CharMatcher or(final CharMatcher charMatcher) {
        return charMatcher.matches(this.match) ? charMatcher : super.or(charMatcher);
    }
    
    @Override
    public CharMatcher negate() {
        return CharMatcher.isNot(this.match);
    }
    
    @GwtIncompatible("java.util.BitSet")
    @Override
    void setBits(final BitSet set) {
        set.set(this.match);
    }
    
    @Override
    public String toString() {
        final String access$100 = CharMatcher.access$100(this.match);
        return new StringBuilder(18 + String.valueOf(access$100).length()).append("CharMatcher.is('").append(access$100).append("')").toString();
    }
}
