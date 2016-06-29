package com.google.common.base;

import java.util.*;
import com.google.common.annotations.*;

final class CharMatcher$Or extends CharMatcher
{
    final CharMatcher first;
    final CharMatcher second;
    
    CharMatcher$Or(final CharMatcher charMatcher, final CharMatcher charMatcher2) {
        this.first = (CharMatcher)Preconditions.checkNotNull(charMatcher);
        this.second = (CharMatcher)Preconditions.checkNotNull(charMatcher2);
    }
    
    @GwtIncompatible("java.util.BitSet")
    @Override
    void setBits(final BitSet set) {
        this.first.setBits(set);
        this.second.setBits(set);
    }
    
    @Override
    public boolean matches(final char c) {
        return this.first.matches(c) || this.second.matches(c);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.first);
        final String value2 = String.valueOf(this.second);
        return new StringBuilder(18 + String.valueOf(value).length() + String.valueOf(value2).length()).append("CharMatcher.or(").append(value).append(", ").append(value2).append(")").toString();
    }
}
