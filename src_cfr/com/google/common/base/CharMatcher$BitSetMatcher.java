/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher$1;
import com.google.common.base.CharMatcher$NamedFastMatcher;
import java.util.BitSet;

@GwtIncompatible(value="java.util.BitSet")
final class CharMatcher$BitSetMatcher
extends CharMatcher$NamedFastMatcher {
    private final BitSet table;

    private CharMatcher$BitSetMatcher(BitSet bitSet, String string) {
        super(string);
        if (bitSet.length() + 64 < bitSet.size()) {
            bitSet = (BitSet)bitSet.clone();
        }
        this.table = bitSet;
    }

    @Override
    public boolean matches(char c2) {
        return this.table.get(c2);
    }

    @Override
    void setBits(BitSet bitSet) {
        bitSet.or(this.table);
    }

    /* synthetic */ CharMatcher$BitSetMatcher(BitSet bitSet, String string, CharMatcher$1 charMatcher$1) {
        this(bitSet, string);
    }
}

