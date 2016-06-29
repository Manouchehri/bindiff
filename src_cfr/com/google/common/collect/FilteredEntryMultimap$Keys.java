/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$Keys$1;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$Keys;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredEntryMultimap$Keys
extends Multimaps$Keys {
    final /* synthetic */ FilteredEntryMultimap this$0;

    FilteredEntryMultimap$Keys(FilteredEntryMultimap filteredEntryMultimap) {
        this.this$0 = filteredEntryMultimap;
        super(filteredEntryMultimap);
    }

    @Override
    public int remove(@Nullable Object object, int n2) {
        CollectPreconditions.checkNonnegative(n2, "occurrences");
        if (n2 == 0) {
            return this.count(object);
        }
        Collection collection = (Collection)this.this$0.unfiltered.asMap().get(object);
        if (collection == null) {
            return 0;
        }
        Object object2 = object;
        int n3 = 0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (!FilteredEntryMultimap.access$000(this.this$0, object2, e2) || ++n3 > n2) continue;
            iterator.remove();
        }
        return n3;
    }

    @Override
    public Set entrySet() {
        return new FilteredEntryMultimap$Keys$1(this);
    }
}

