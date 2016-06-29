/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.Arrays;

class CharMatcher$RangesMatcher
extends CharMatcher {
    private final String description;
    private final char[] rangeStarts;
    private final char[] rangeEnds;

    CharMatcher$RangesMatcher(String string, char[] arrc, char[] arrc2) {
        this.description = string;
        this.rangeStarts = arrc;
        this.rangeEnds = arrc2;
        Preconditions.checkArgument(arrc.length == arrc2.length);
        int n2 = 0;
        while (n2 < arrc.length) {
            Preconditions.checkArgument(arrc[n2] <= arrc2[n2]);
            if (n2 + 1 < arrc.length) {
                Preconditions.checkArgument(arrc2[n2] < arrc[n2 + 1]);
            }
            ++n2;
        }
    }

    @Override
    public boolean matches(char c2) {
        int n2 = Arrays.binarySearch(this.rangeStarts, c2);
        if (n2 >= 0) {
            return true;
        }
        if ((n2 = ~ n2 - 1) < 0) return false;
        if (c2 > this.rangeEnds[n2]) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.description;
    }
}

