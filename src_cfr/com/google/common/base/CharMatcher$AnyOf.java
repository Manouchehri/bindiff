/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import java.util.Arrays;
import java.util.BitSet;

final class CharMatcher$AnyOf
extends CharMatcher {
    private final char[] chars;

    public CharMatcher$AnyOf(CharSequence charSequence) {
        this.chars = charSequence.toString().toCharArray();
        Arrays.sort(this.chars);
    }

    @Override
    public boolean matches(char c2) {
        if (Arrays.binarySearch(this.chars, c2) < 0) return false;
        return true;
    }

    @GwtIncompatible(value="java.util.BitSet")
    @Override
    void setBits(BitSet bitSet) {
        char[] arrc = this.chars;
        int n2 = arrc.length;
        int n3 = 0;
        while (n3 < n2) {
            char c2 = arrc[n3];
            bitSet.set(c2);
            ++n3;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
        char[] arrc = this.chars;
        int n2 = arrc.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                stringBuilder.append("\")");
                return stringBuilder.toString();
            }
            char c2 = arrc[n3];
            stringBuilder.append(CharMatcher.access$100(c2));
            ++n3;
        } while (true);
    }
}

