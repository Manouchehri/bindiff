/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class ImmutableMultimap$Keys
extends ImmutableMultiset {
    final /* synthetic */ ImmutableMultimap this$0;

    ImmutableMultimap$Keys(ImmutableMultimap immutableMultimap) {
        this.this$0 = immutableMultimap;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.this$0.containsKey(object);
    }

    @Override
    public int count(@Nullable Object object) {
        Collection collection = (Collection)this.this$0.map.get(object);
        if (collection == null) {
            return 0;
        }
        int n2 = collection.size();
        return n2;
    }

    @Override
    public Set elementSet() {
        return this.this$0.keySet();
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    Multiset$Entry getEntry(int n2) {
        Map.Entry entry = (Map.Entry)this.this$0.map.entrySet().asList().get(n2);
        return Multisets.immutableEntry(entry.getKey(), ((Collection)entry.getValue()).size());
    }

    @Override
    boolean isPartialView() {
        return true;
    }
}

