/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FilteredEntryMultimap;
import javax.annotation.Nullable;

final class FilteredEntryMultimap$ValuePredicate
implements Predicate {
    private final Object key;
    final /* synthetic */ FilteredEntryMultimap this$0;

    FilteredEntryMultimap$ValuePredicate(FilteredEntryMultimap filteredEntryMultimap, Object object) {
        this.this$0 = filteredEntryMultimap;
        this.key = object;
    }

    @Override
    public boolean apply(@Nullable Object object) {
        return FilteredEntryMultimap.access$000(this.this$0, this.key, object);
    }
}

