/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$TransformedEntriesSortedMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtIncompatible(value="NavigableMap")
class Maps$TransformedEntriesNavigableMap
extends Maps$TransformedEntriesSortedMap
implements NavigableMap {
    Maps$TransformedEntriesNavigableMap(NavigableMap navigableMap, Maps$EntryTransformer maps$EntryTransformer) {
        super(navigableMap, maps$EntryTransformer);
    }

    public Map.Entry ceilingEntry(Object object) {
        return this.transformEntry(this.fromMap().ceilingEntry(object));
    }

    public Object ceilingKey(Object object) {
        return this.fromMap().ceilingKey(object);
    }

    public NavigableSet descendingKeySet() {
        return this.fromMap().descendingKeySet();
    }

    public NavigableMap descendingMap() {
        return Maps.transformEntries(this.fromMap().descendingMap(), this.transformer);
    }

    public Map.Entry firstEntry() {
        return this.transformEntry(this.fromMap().firstEntry());
    }

    public Map.Entry floorEntry(Object object) {
        return this.transformEntry(this.fromMap().floorEntry(object));
    }

    public Object floorKey(Object object) {
        return this.fromMap().floorKey(object);
    }

    @Override
    public NavigableMap headMap(Object object) {
        return this.headMap(object, false);
    }

    public NavigableMap headMap(Object object, boolean bl2) {
        return Maps.transformEntries(this.fromMap().headMap(object, bl2), this.transformer);
    }

    public Map.Entry higherEntry(Object object) {
        return this.transformEntry(this.fromMap().higherEntry(object));
    }

    public Object higherKey(Object object) {
        return this.fromMap().higherKey(object);
    }

    public Map.Entry lastEntry() {
        return this.transformEntry(this.fromMap().lastEntry());
    }

    public Map.Entry lowerEntry(Object object) {
        return this.transformEntry(this.fromMap().lowerEntry(object));
    }

    public Object lowerKey(Object object) {
        return this.fromMap().lowerKey(object);
    }

    public NavigableSet navigableKeySet() {
        return this.fromMap().navigableKeySet();
    }

    public Map.Entry pollFirstEntry() {
        return this.transformEntry(this.fromMap().pollFirstEntry());
    }

    public Map.Entry pollLastEntry() {
        return this.transformEntry(this.fromMap().pollLastEntry());
    }

    public NavigableMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        return Maps.transformEntries(this.fromMap().subMap(object, bl2, object2, bl3), this.transformer);
    }

    @Override
    public NavigableMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    @Override
    public NavigableMap tailMap(Object object) {
        return this.tailMap(object, true);
    }

    public NavigableMap tailMap(Object object, boolean bl2) {
        return Maps.transformEntries(this.fromMap().tailMap(object, bl2), this.transformer);
    }

    @Nullable
    private Map.Entry transformEntry(@Nullable Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        Map.Entry entry2 = Maps.transformEntry(this.transformer, entry);
        return entry2;
    }

    @Override
    protected NavigableMap fromMap() {
        return (NavigableMap)super.fromMap();
    }
}

