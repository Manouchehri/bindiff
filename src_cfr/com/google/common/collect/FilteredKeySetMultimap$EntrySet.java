/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.FilteredKeyMultimap$Entries;
import com.google.common.collect.FilteredKeySetMultimap;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredKeySetMultimap$EntrySet
extends FilteredKeyMultimap$Entries
implements Set {
    final /* synthetic */ FilteredKeySetMultimap this$0;

    FilteredKeySetMultimap$EntrySet(FilteredKeySetMultimap filteredKeySetMultimap) {
        this.this$0 = filteredKeySetMultimap;
        super(filteredKeySetMultimap);
    }

    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Sets.equalsImpl(this, object);
    }
}

