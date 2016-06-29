/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multisets$ImmutableEntry;

final class RegularImmutableMultiset$NonTerminalEntry
extends Multisets$ImmutableEntry {
    private final Multisets$ImmutableEntry nextInBucket;

    RegularImmutableMultiset$NonTerminalEntry(Object object, int n2, Multisets$ImmutableEntry multisets$ImmutableEntry) {
        super(object, n2);
        this.nextInBucket = multisets$ImmutableEntry;
    }

    @Override
    public Multisets$ImmutableEntry nextInBucket() {
        return this.nextInBucket;
    }
}

