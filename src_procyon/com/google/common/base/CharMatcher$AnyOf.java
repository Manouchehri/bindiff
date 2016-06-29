package com.google.common.base;

import java.util.*;
import com.google.common.annotations.*;

final class CharMatcher$AnyOf extends CharMatcher
{
    private final char[] chars;
    
    public CharMatcher$AnyOf(final CharSequence charSequence) {
        Arrays.sort(this.chars = charSequence.toString().toCharArray());
    }
    
    @Override
    public boolean matches(final char c) {
        return Arrays.binarySearch(this.chars, c) >= 0;
    }
    
    @GwtIncompatible("java.util.BitSet")
    @Override
    void setBits(final BitSet set) {
        final char[] chars = this.chars;
        for (int length = chars.length, i = 0; i < length; ++i) {
            set.set(chars[i]);
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
        final char[] chars = this.chars;
        for (int length = chars.length, i = 0; i < length; ++i) {
            sb.append(CharMatcher.access$100(chars[i]));
        }
        sb.append("\")");
        return sb.toString();
    }
}
