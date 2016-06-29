/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableBiMap$Inverse;
import com.google.common.collect.RegularImmutableBiMap$Inverse$InverseEntrySet$1;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

final class RegularImmutableBiMap$Inverse$InverseEntrySet
extends ImmutableMapEntrySet {
    final /* synthetic */ RegularImmutableBiMap$Inverse this$1;

    RegularImmutableBiMap$Inverse$InverseEntrySet(RegularImmutableBiMap$Inverse regularImmutableBiMap$Inverse) {
        this.this$1 = regularImmutableBiMap$Inverse;
    }

    @Override
    ImmutableMap map() {
        return this.this$1;
    }

    @Override
    boolean isHashCodeFast() {
        return true;
    }

    @Override
    public int hashCode() {
        return RegularImmutableBiMap.access$300(this.this$1.this$0);
    }

    @Override
    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }

    @Override
    ImmutableList createAsList() {
        return new RegularImmutableBiMap$Inverse$InverseEntrySet$1(this);
    }
}

