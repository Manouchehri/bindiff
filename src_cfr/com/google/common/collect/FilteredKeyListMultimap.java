/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
final class FilteredKeyListMultimap
extends FilteredKeyMultimap
implements ListMultimap {
    FilteredKeyListMultimap(ListMultimap listMultimap, Predicate predicate) {
        super(listMultimap, predicate);
    }

    @Override
    public ListMultimap unfiltered() {
        return (ListMultimap)super.unfiltered();
    }

    @Override
    public List get(Object object) {
        return (List)super.get(object);
    }

    @Override
    public List removeAll(@Nullable Object object) {
        return (List)super.removeAll(object);
    }

    @Override
    public List replaceValues(Object object, Iterable iterable) {
        return (List)super.replaceValues(object, iterable);
    }
}

