package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(emulated = true)
abstract class AbstractMapBasedMultimap extends AbstractMultimap implements Serializable
{
    private transient Map map;
    private transient int totalSize;
    private static final long serialVersionUID = 2447537837011683357L;
    
    protected AbstractMapBasedMultimap(final Map map) {
        Preconditions.checkArgument(map.isEmpty());
        this.map = map;
    }
    
    final void setMap(final Map map) {
        this.map = map;
        this.totalSize = 0;
        for (final Collection collection : map.values()) {
            Preconditions.checkArgument(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }
    
    Collection createUnmodifiableEmptyCollection() {
        return this.unmodifiableCollectionSubclass(this.createCollection());
    }
    
    abstract Collection createCollection();
    
    Collection createCollection(@Nullable final Object o) {
        return this.createCollection();
    }
    
    Map backingMap() {
        return this.map;
    }
    
    @Override
    public int size() {
        return this.totalSize;
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.map.containsKey(o);
    }
    
    @Override
    public boolean put(@Nullable final Object o, @Nullable final Object o2) {
        final Collection<Object> collection = this.map.get(o);
        if (collection == null) {
            final Collection collection2 = this.createCollection(o);
            if (collection2.add(o2)) {
                ++this.totalSize;
                this.map.put(o, collection2);
                return true;
            }
            throw new AssertionError((Object)"New Collection violated the Collection spec");
        }
        else {
            if (collection.add(o2)) {
                ++this.totalSize;
                return true;
            }
            return false;
        }
    }
    
    private Collection getOrCreateCollection(@Nullable final Object o) {
        Collection collection = this.map.get(o);
        if (collection == null) {
            collection = this.createCollection(o);
            this.map.put(o, collection);
        }
        return collection;
    }
    
    @Override
    public Collection replaceValues(@Nullable final Object o, final Iterable iterable) {
        final Iterator<Object> iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return this.removeAll(o);
        }
        final Collection orCreateCollection = this.getOrCreateCollection(o);
        final Collection collection = this.createCollection();
        collection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (iterator.hasNext()) {
            if (orCreateCollection.add(iterator.next())) {
                ++this.totalSize;
            }
        }
        return this.unmodifiableCollectionSubclass(collection);
    }
    
    @Override
    public Collection removeAll(@Nullable final Object o) {
        final Collection collection = this.map.remove(o);
        if (collection == null) {
            return this.createUnmodifiableEmptyCollection();
        }
        final Collection collection2 = this.createCollection();
        collection2.addAll(collection);
        this.totalSize -= collection.size();
        collection.clear();
        return this.unmodifiableCollectionSubclass(collection2);
    }
    
    Collection unmodifiableCollectionSubclass(final Collection collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet<Object>)collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set<?>)(SortedSet<? extends T>)collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List<?>)(List<? extends T>)collection);
        }
        return Collections.unmodifiableCollection((Collection<?>)collection);
    }
    
    @Override
    public void clear() {
        final Iterator<Collection> iterator = this.map.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }
    
    @Override
    public Collection get(@Nullable final Object o) {
        Collection collection = this.map.get(o);
        if (collection == null) {
            collection = this.createCollection(o);
        }
        return this.wrapCollection(o, collection);
    }
    
    Collection wrapCollection(@Nullable final Object o, final Collection collection) {
        if (collection instanceof SortedSet) {
            return new AbstractMapBasedMultimap$WrappedSortedSet(this, o, (SortedSet)collection, null);
        }
        if (collection instanceof Set) {
            return new AbstractMapBasedMultimap$WrappedSet(this, o, (Set)collection);
        }
        if (collection instanceof List) {
            return this.wrapList(o, (List)collection, null);
        }
        return new AbstractMapBasedMultimap$WrappedCollection(this, o, collection, null);
    }
    
    private List wrapList(@Nullable final Object o, final List list, @Nullable final AbstractMapBasedMultimap$WrappedCollection collection) {
        return (list instanceof RandomAccess) ? new AbstractMapBasedMultimap$RandomAccessWrappedList(this, o, list, collection) : new AbstractMapBasedMultimap$WrappedList(this, o, list, collection);
    }
    
    private Iterator iteratorOrListIterator(final Collection collection) {
        return (collection instanceof List) ? ((List)collection).listIterator() : collection.iterator();
    }
    
    @Override
    Set createKeySet() {
        return (this.map instanceof SortedMap) ? new AbstractMapBasedMultimap$SortedKeySet(this, (SortedMap)this.map) : new AbstractMapBasedMultimap$KeySet(this, this.map);
    }
    
    private int removeValuesForKey(final Object o) {
        final Collection collection = (Collection)Maps.safeRemove(this.map, o);
        int size = 0;
        if (collection != null) {
            size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
        return size;
    }
    
    @Override
    public Collection values() {
        return super.values();
    }
    
    @Override
    Iterator valueIterator() {
        return new AbstractMapBasedMultimap$1(this);
    }
    
    @Override
    public Collection entries() {
        return super.entries();
    }
    
    @Override
    Iterator entryIterator() {
        return new AbstractMapBasedMultimap$2(this);
    }
    
    @Override
    Map createAsMap() {
        return (this.map instanceof SortedMap) ? new AbstractMapBasedMultimap$SortedAsMap(this, (SortedMap)this.map) : new AbstractMapBasedMultimap$AsMap(this, this.map);
    }
}
