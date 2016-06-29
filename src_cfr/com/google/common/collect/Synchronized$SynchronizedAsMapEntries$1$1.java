/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries$1;
import java.util.Collection;
import java.util.Map;

class Synchronized$SynchronizedAsMapEntries$1$1
extends ForwardingMapEntry {
    final /* synthetic */ Map.Entry val$entry;
    final /* synthetic */ Synchronized$SynchronizedAsMapEntries$1 this$1;

    Synchronized$SynchronizedAsMapEntries$1$1(Synchronized$SynchronizedAsMapEntries$1 var1_1, Map.Entry entry) {
        this.this$1 = var1_1;
        this.val$entry = entry;
    }

    @Override
    protected Map.Entry delegate() {
        return this.val$entry;
    }

    @Override
    public Collection getValue() {
        return Synchronized.access$400((Collection)this.val$entry.getValue(), this.this$1.this$0.mutex);
    }
}

