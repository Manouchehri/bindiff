/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1EntrySetImpl;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1KeySetImpl;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1ValuesImpl;
import com.google.common.collect.FilteredEntryMultimap$ValuePredicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredEntryMultimap$AsMap
extends Maps$ViewCachingAbstractMap {
    final /* synthetic */ FilteredEntryMultimap this$0;

    FilteredEntryMultimap$AsMap(FilteredEntryMultimap filteredEntryMultimap) {
        this.this$0 = filteredEntryMultimap;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        if (this.get(object) == null) return false;
        return true;
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public Collection get(@Nullable Object object) {
        Collection collection = (Collection)this.this$0.unfiltered.asMap().get(object);
        if (collection == null) {
            return null;
        }
        Object object2 = object;
        if ((collection = FilteredEntryMultimap.filterCollection(collection, new FilteredEntryMultimap$ValuePredicate(this.this$0, object2))).isEmpty()) {
            return null;
        }
        Collection collection2 = collection;
        return collection2;
    }

    @Override
    public Collection remove(@Nullable Object object) {
        Collection collection = (Collection)this.this$0.unfiltered.asMap().get(object);
        if (collection == null) {
            return null;
        }
        Object object2 = object;
        ArrayList arrayList = Lists.newArrayList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (!FilteredEntryMultimap.access$000(this.this$0, object2, e2)) continue;
            iterator.remove();
            arrayList.add(e2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (!(this.this$0.unfiltered instanceof SetMultimap)) return Collections.unmodifiableList(arrayList);
        return Collections.unmodifiableSet(Sets.newLinkedHashSet(arrayList));
    }

    @Override
    Set createKeySet() {
        return new FilteredEntryMultimap$AsMap$1KeySetImpl(this);
    }

    @Override
    Set createEntrySet() {
        return new FilteredEntryMultimap$AsMap$1EntrySetImpl(this);
    }

    @Override
    Collection createValues() {
        return new FilteredEntryMultimap$AsMap$1ValuesImpl(this);
    }
}

