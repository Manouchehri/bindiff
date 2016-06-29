/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap$1EntrySet;
import com.google.common.collect.Maps;
import java.util.Map;

class ImmutableSortedMap$1EntrySet$1
extends ImmutableAsList {
    final /* synthetic */ ImmutableSortedMap$1EntrySet this$1;

    ImmutableSortedMap$1EntrySet$1(ImmutableSortedMap$1EntrySet entrySet) {
        this.this$1 = entrySet;
    }

    public Map.Entry get(int n2) {
        return Maps.immutableEntry(ImmutableSortedMap.access$200(this.this$1.this$0).asList().get(n2), ImmutableSortedMap.access$300(this.this$1.this$0).get(n2));
    }

    @Override
    ImmutableCollection delegateCollection() {
        return this.this$1;
    }
}

