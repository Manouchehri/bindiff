/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.FilteredKeySetMultimap$EntrySet;
import com.google.common.collect.FilteredSetMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import java.util.Collection;
import java.util.Set;

@GwtCompatible
final class FilteredKeySetMultimap
extends FilteredKeyMultimap
implements FilteredSetMultimap {
    FilteredKeySetMultimap(SetMultimap setMultimap, Predicate predicate) {
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
    public Set entries() {
        return (Set)super.entries();
    }

    @Override
    Set createEntries() {
        return new FilteredKeySetMultimap$EntrySet(this);
    }
}

