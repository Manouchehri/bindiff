/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet$1;
import java.util.Map;

class Maps$FilteredEntryMap$EntrySet$1$1
extends ForwardingMapEntry {
    final /* synthetic */ Map.Entry val$entry;
    final /* synthetic */ Maps$FilteredEntryMap$EntrySet$1 this$2;

    Maps$FilteredEntryMap$EntrySet$1$1(Maps$FilteredEntryMap$EntrySet$1 var1_1, Map.Entry entry) {
        this.this$2 = var1_1;
        this.val$entry = entry;
    }

    @Override
    protected Map.Entry delegate() {
        return this.val$entry;
    }

    @Override
    public Object setValue(Object object) {
        Preconditions.checkArgument(this.this$2.this$1.this$0.apply(this.getKey(), object));
        return super.setValue(object);
    }
}

