/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$Keys;
import com.google.common.collect.FilteredEntryMultimap$Keys$1;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Map;

class FilteredEntryMultimap$Keys$1$1
implements Predicate {
    final /* synthetic */ Predicate val$predicate;
    final /* synthetic */ FilteredEntryMultimap.Keys.1 this$2;

    FilteredEntryMultimap$Keys$1$1(FilteredEntryMultimap.Keys.1 var1_1, Predicate predicate) {
        this.this$2 = var1_1;
        this.val$predicate = predicate;
    }

    public boolean apply(Map.Entry entry) {
        return this.val$predicate.apply(Multisets.immutableEntry(entry.getKey(), ((Collection)entry.getValue()).size()));
    }
}

