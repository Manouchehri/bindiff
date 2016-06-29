package com.google.common.base;

import java.util.*;
import com.google.common.annotations.*;

final class CharMatcher$And extends CharMatcher
{
    final CharMatcher first;
    final CharMatcher second;
    
    CharMatcher$And(final CharMatcher charMatcher, final CharMatcher charMatcher2) {
        this.first = (CharMatcher)Preconditions.checkNotNull(charMatcher);
        this.second = (CharMatcher)Preconditions.checkNotNull(charMatcher2);
    }
    
    @Override
    public boolean matches(final char c) {
        return this.first.matches(c) && this.second.matches(c);
    }
    
    @GwtIncompatible("java.util.BitSet")
    @Override
    void setBits(final BitSet set) {
        final BitSet bits = new BitSet();
        this.first.setBits(bits);
        final BitSet bits2 = new BitSet();
        this.second.setBits(bits2);
        bits.and(bits2);
        set.or(bits);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.first);
        final String value2 = String.valueOf(this.second);
        return new StringBuilder(19 + String.valueOf(value).length() + String.valueOf(value2).length()).append("CharMatcher.and(").append(value).append(", ").append(value2).append(")").toString();
    }
}
