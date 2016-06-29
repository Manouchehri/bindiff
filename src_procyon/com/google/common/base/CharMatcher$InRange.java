package com.google.common.base;

import java.util.*;
import com.google.common.annotations.*;

final class CharMatcher$InRange extends CharMatcher$FastMatcher
{
    private final char startInclusive;
    private final char endInclusive;
    
    CharMatcher$InRange(final char startInclusive, final char endInclusive) {
        Preconditions.checkArgument(endInclusive >= startInclusive);
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }
    
    @Override
    public boolean matches(final char c) {
        return this.startInclusive <= c && c <= this.endInclusive;
    }
    
    @GwtIncompatible("java.util.BitSet")
    @Override
    void setBits(final BitSet set) {
        set.set(this.startInclusive, this.endInclusive + '\u0001');
    }
    
    @Override
    public String toString() {
        final String access$100 = CharMatcher.access$100(this.startInclusive);
        final String access$101 = CharMatcher.access$100(this.endInclusive);
        return new StringBuilder(27 + String.valueOf(access$100).length() + String.valueOf(access$101).length()).append("CharMatcher.inRange('").append(access$100).append("', '").append(access$101).append("')").toString();
    }
}
