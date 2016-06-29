/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import java.io.Serializable;

class ImmutableMultiset$EntrySetSerializedForm
implements Serializable {
    final ImmutableMultiset multiset;

    ImmutableMultiset$EntrySetSerializedForm(ImmutableMultiset immutableMultiset) {
        this.multiset = immutableMultiset;
    }

    Object readResolve() {
        return this.multiset.entrySet();
    }
}

