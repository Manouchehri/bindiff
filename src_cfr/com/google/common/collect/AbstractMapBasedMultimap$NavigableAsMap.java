/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$NavigableKeySet;
import com.google.common.collect.AbstractMapBasedMultimap$SortedAsMap;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtIncompatible(value="NavigableAsMap")
class AbstractMapBasedMultimap$NavigableAsMap
extends AbstractMapBasedMultimap$SortedAsMap
implements NavigableMap {
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$NavigableAsMap(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap navigableMap) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, navigableMap);
    }

    @Override
    NavigableMap sortedMap() {
        return (NavigableMap)super.sortedMap();
    }

    public Map.Entry lowerEntry(Object object) {
        Map.Entry entry = this.sortedMap().lowerEntry(object);
        if (entry == null) {
            return null;
        }
        Map.Entry entry2 = this.wrapEntry(entry);
        return entry2;
    }

    public Object lowerKey(Object object) {
        return this.sortedMap().lowerKey(object);
    }

    public Map.Entry floorEntry(Object object) {
        Map.Entry entry = this.sortedMap().floorEntry(object);
        if (entry == null) {
            return null;
        }
        Map.Entry entry2 = this.wrapEntry(entry);
        return entry2;
    }

    public Object floorKey(Object object) {
        return this.sortedMap().floorKey(object);
    }

    public Map.Entry ceilingEntry(Object object) {
        Map.Entry entry = this.sortedMap().ceilingEntry(object);
        if (entry == null) {
            return null;
        }
        Map.Entry entry2 = this.wrapEntry(entry);
        return entry2;
    }

    public Object ceilingKey(Object object) {
        return this.sortedMap().ceilingKey(object);
    }

    public Map.Entry higherEntry(Object object) {
        Map.Entry entry = this.sortedMap().higherEntry(object);
        if (entry == null) {
            return null;
        }
        Map.Entry entry2 = this.wrapEntry(entry);
        return entry2;
    }

    public Object higherKey(Object object) {
        return this.sortedMap().higherKey(object);
    }

    public Map.Entry firstEntry() {
        Map.Entry entry = this.sortedMap().firstEntry();
        if (entry == null) {
            return null;
        }
        Map.Entry entry2 = this.wrapEntry(entry);
        return entry2;
    }

    public Map.Entry lastEntry() {
        Map.Entry entry = this.sortedMap().lastEntry();
        if (entry == null) {
            return null;
        }
        Map.Entry entry2 = this.wrapEntry(entry);
        return entry2;
    }

    public Map.Entry pollFirstEntry() {
        return this.pollAsMapEntry(this.entrySet().iterator());
    }

    public Map.Entry pollLastEntry() {
        return this.pollAsMapEntry(this.descendingMap().entrySet().iterator());
    }

    Map.Entry pollAsMapEntry(Iterator iterator) {
        if (!iterator.hasNext()) {
            return null;
        }
        Map.Entry entry = (Map.Entry)iterator.next();
        Collection collection = this.this$0.createCollection();
        collection.addAll((Collection)entry.getValue());
        iterator.remove();
        return Maps.immutableEntry(entry.getKey(), this.this$0.unmodifiableCollectionSubclass(collection));
    }

    public NavigableMap descendingMap() {
        return new AbstractMapBasedMultimap$NavigableAsMap(this.this$0, this.sortedMap().descendingMap());
    }

    @Override
    public NavigableSet keySet() {
        return (NavigableSet)super.keySet();
    }

    @Override
    NavigableSet createKeySet() {
        return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap());
    }

    public NavigableSet navigableKeySet() {
        return this.keySet();
    }

    public NavigableSet descendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }

    @Override
    public NavigableMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    public NavigableMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        return new AbstractMapBasedMultimap$NavigableAsMap(this.this$0, this.sortedMap().subMap(object, bl2, object2, bl3));
    }

    @Override
    public NavigableMap headMap(Object object) {
        return this.headMap(object, false);
    }

    public NavigableMap headMap(Object object, boolean bl2) {
        return new AbstractMapBasedMultimap$NavigableAsMap(this.this$0, this.sortedMap().headMap(object, bl2));
    }

    @Override
    public NavigableMap tailMap(Object object) {
        return this.tailMap(object, true);
    }

    public NavigableMap tailMap(Object object, boolean bl2) {
        return new AbstractMapBasedMultimap$NavigableAsMap(this.this$0, this.sortedMap().tailMap(object, bl2));
    }
}

