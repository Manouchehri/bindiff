package com.google.common.base;

import java.util.*;
import com.google.common.annotations.*;

final class CharMatcher$IsEither extends CharMatcher$FastMatcher
{
    private final char match1;
    private final char match2;
    
    CharMatcher$IsEither(final char match1, final char match2) {
        this.match1 = match1;
        this.match2 = match2;
    }
    
    @Override
    public boolean matches(final char c) {
        return c == this.match1 || c == this.match2;
    }
    
    @GwtIncompatible("java.util.BitSet")
    @Override
    void setBits(final BitSet set) {
        set.set(this.match1);
        set.set(this.match2);
    }
    
    @Override
    public String toString() {
        final String access$100 = CharMatcher.access$100(this.match1);
        final String access$101 = CharMatcher.access$100(this.match2);
        return new StringBuilder(21 + String.valueOf(access$100).length() + String.valueOf(access$101).length()).append("CharMatcher.anyOf(\"").append(access$100).append(access$101).append("\")").toString();
    }
}
