package com.google.common.base;

import com.google.common.annotations.*;
import java.util.*;

@GwtIncompatible("java.util.BitSet")
final class CharMatcher$BitSetMatcher extends CharMatcher$NamedFastMatcher
{
    private final BitSet table;
    
    private CharMatcher$BitSetMatcher(BitSet table, final String s) {
        super(s);
        if (table.length() + 64 < table.size()) {
            table = (BitSet)table.clone();
        }
        this.table = table;
    }
    
    @Override
    public boolean matches(final char c) {
        return this.table.get(c);
    }
    
    @Override
    void setBits(final BitSet set) {
        set.or(this.table);
    }
}
