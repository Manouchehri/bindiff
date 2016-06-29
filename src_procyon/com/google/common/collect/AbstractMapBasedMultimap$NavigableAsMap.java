package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GwtIncompatible("NavigableAsMap")
class AbstractMapBasedMultimap$NavigableAsMap extends AbstractMapBasedMultimap$SortedAsMap implements NavigableMap
{
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$NavigableAsMap(final AbstractMapBasedMultimap this$0, final NavigableMap navigableMap) {
        this.this$0 = this$0;
        super(this$0, navigableMap);
    }
    
    @Override
    NavigableMap sortedMap() {
        return (NavigableMap)super.sortedMap();
    }
    
    @Override
    public Entry lowerEntry(final Object o) {
        final Map.Entry<Object, Object> lowerEntry = this.sortedMap().lowerEntry(o);
        return (lowerEntry == null) ? null : this.wrapEntry((Entry)lowerEntry);
    }
    
    @Override
    public Object lowerKey(final Object o) {
        return this.sortedMap().lowerKey(o);
    }
    
    @Override
    public Entry floorEntry(final Object o) {
        final Map.Entry<Object, Object> floorEntry = this.sortedMap().floorEntry(o);
        return (floorEntry == null) ? null : this.wrapEntry((Entry)floorEntry);
    }
    
    @Override
    public Object floorKey(final Object o) {
        return this.sortedMap().floorKey(o);
    }
    
    @Override
    public Entry ceilingEntry(final Object o) {
        final Map.Entry<Object, Object> ceilingEntry = this.sortedMap().ceilingEntry(o);
        return (ceilingEntry == null) ? null : this.wrapEntry((Entry)ceilingEntry);
    }
    
    @Override
    public Object ceilingKey(final Object o) {
        return this.sortedMap().ceilingKey(o);
    }
    
    @Override
    public Entry higherEntry(final Object o) {
        final Map.Entry<Object, Object> higherEntry = this.sortedMap().higherEntry(o);
        return (higherEntry == null) ? null : this.wrapEntry((Entry)higherEntry);
    }
    
    @Override
    public Object higherKey(final Object o) {
        return this.sortedMap().higherKey(o);
    }
    
    @Override
    public Entry firstEntry() {
        final Map.Entry firstEntry = this.sortedMap().firstEntry();
        return (firstEntry == null) ? null : this.wrapEntry((Entry)firstEntry);
    }
    
    @Override
    public Entry lastEntry() {
        final Map.Entry lastEntry = this.sortedMap().lastEntry();
        return (lastEntry == null) ? null : this.wrapEntry((Entry)lastEntry);
    }
    
    @Override
    public Entry pollFirstEntry() {
        return this.pollAsMapEntry(this.entrySet().iterator());
    }
    
    @Override
    public Entry pollLastEntry() {
        return this.pollAsMapEntry(this.descendingMap().entrySet().iterator());
    }
    
    Entry pollAsMapEntry(final Iterator iterator) {
        if (!iterator.hasNext()) {
            return null;
        }
        final Map.Entry<K, Collection> entry = iterator.next();
        final Collection collection = this.this$0.createCollection();
        collection.addAll(entry.getValue());
        iterator.remove();
        return Maps.immutableEntry(entry.getKey(), this.this$0.unmodifiableCollectionSubclass(collection));
    }
    
    @Override
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
    
    @Override
    public NavigableSet navigableKeySet() {
        return this.keySet();
    }
    
    @Override
    public NavigableSet descendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }
    
    @Override
    public NavigableMap subMap(final Object o, final Object o2) {
        return this.subMap(o, true, o2, false);
    }
    
    @Override
    public NavigableMap subMap(final Object o, final boolean b, final Object o2, final boolean b2) {
        return new AbstractMapBasedMultimap$NavigableAsMap(this.this$0, this.sortedMap().subMap(o, b, o2, b2));
    }
    
    @Override
    public NavigableMap headMap(final Object o) {
        return this.headMap(o, false);
    }
    
    @Override
    public NavigableMap headMap(final Object o, final boolean b) {
        return new AbstractMapBasedMultimap$NavigableAsMap(this.this$0, this.sortedMap().headMap(o, b));
    }
    
    @Override
    public NavigableMap tailMap(final Object o) {
        return this.tailMap(o, true);
    }
    
    @Override
    public NavigableMap tailMap(final Object o, final boolean b) {
        return new AbstractMapBasedMultimap$NavigableAsMap(this.this$0, this.sortedMap().tailMap(o, b));
    }
}
