/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredSetMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;

@GwtCompatible
final class FilteredEntrySetMultimap
extends FilteredEntryMultimap
implements FilteredSetMultimap {
    FilteredEntrySetMultimap(SetMultimap setMultimap, Predicate predicate) {
        super(setMultimap, predicate);
    }

    @Override
    public SetMultimap unfiltered() {
        return (SetMultimap)this.unfiltered;
    }

    @Override
    public Set get(Object object) {
        return (Set)super.get(object);
    }

    @Override
    public Set removeAll(Object object) {
        return (Set)super.removeAll(object);
    }

    @Override
    public Set replaceValues(Object object, Iterable iterable) {
        return (Set)super.replaceValues(object, iterable);
    }

    @Override
    Set createEntries() {
        return Sets.filter(this.unfiltered().entries(), this.entryPredicate());
    }

    @Override
    public Set entries() {
        return (Set)super.entries();
    }
}

