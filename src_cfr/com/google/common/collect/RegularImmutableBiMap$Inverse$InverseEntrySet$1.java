/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableBiMap$Inverse;
import com.google.common.collect.RegularImmutableBiMap$Inverse$InverseEntrySet;
import java.util.Map;

class RegularImmutableBiMap$Inverse$InverseEntrySet$1
extends ImmutableAsList {
    final /* synthetic */ RegularImmutableBiMap$Inverse$InverseEntrySet this$2;

    RegularImmutableBiMap$Inverse$InverseEntrySet$1(RegularImmutableBiMap$Inverse$InverseEntrySet inverseEntrySet) {
        this.this$2 = inverseEntrySet;
    }

    public Map.Entry get(int n2) {
        Map.Entry entry = RegularImmutableBiMap.access$400(this.this$2.this$1.this$0)[n2];
        return Maps.immutableEntry(entry.getValue(), entry.getKey());
    }

    @Override
    ImmutableCollection delegateCollection() {
        return this.this$2;
    }
}

