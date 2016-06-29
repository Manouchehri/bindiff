/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;

class FilteredKeyMultimap$Entries
extends ForwardingCollection {
    final /* synthetic */ FilteredKeyMultimap this$0;

    FilteredKeyMultimap$Entries(FilteredKeyMultimap filteredKeyMultimap) {
        this.this$0 = filteredKeyMultimap;
    }

    @Override
    protected Collection delegate() {
        return Collections2.filter(this.this$0.unfiltered.entries(), this.this$0.entryPredicate());
    }

    @Override
    public boolean remove(@Nullable Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        if (!this.this$0.unfiltered.containsKey(entry.getKey())) return false;
        if (!this.this$0.keyPredicate.apply(entry.getKey())) return false;
        return this.this$0.unfiltered.remove(entry.getKey(), entry.getValue());
    }
}

