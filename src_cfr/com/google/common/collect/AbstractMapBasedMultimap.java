/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap$1;
import com.google.common.collect.AbstractMapBasedMultimap$2;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import com.google.common.collect.AbstractMapBasedMultimap$KeySet;
import com.google.common.collect.AbstractMapBasedMultimap$RandomAccessWrappedList;
import com.google.common.collect.AbstractMapBasedMultimap$SortedAsMap;
import com.google.common.collect.AbstractMapBasedMultimap$SortedKeySet;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedSet;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedSortedSet;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
abstract class AbstractMapBasedMultimap
extends AbstractMultimap
implements Serializable {
    private transient Map map;
    private transient int totalSize;
    private static final long serialVersionUID = 2447537837011683357L;

    protected AbstractMapBasedMultimap(Map map) {
        Preconditions.checkArgument(map.isEmpty());
        this.map = map;
    }

    final void setMap(Map map) {
        this.map = map;
        this.totalSize = 0;
        Iterator iterator = map.values().iterator();
        while (iterator.hasNext()) {
            Collection collection = (Collection)iterator.next();
            Preconditions.checkArgument(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    Collection createUnmodifiableEmptyCollection() {
        return this.unmodifiableCollectionSubclass(this.createCollection());
    }

    abstract Collection createCollection();

    Collection createCollection(@Nullable Object object) {
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
    public boolean containsKey(@Nullable Object object) {
        return this.map.containsKey(object);
    }

    @Override
    public boolean put(@Nullable Object object, @Nullable Object object2) {
        Collection collection = (Collection)this.map.get(object);
        if (collection == null) {
            collection = this.createCollection(object);
            if (!collection.add(object2)) throw new AssertionError((Object)"New Collection violated the Collection spec");
            ++this.totalSize;
            this.map.put(object, collection);
            return true;
        }
        if (!collection.add(object2)) return false;
        ++this.totalSize;
        return true;
    }

    private Collection getOrCreateCollection(@Nullable Object object) {
        Collection collection = (Collection)this.map.get(object);
        if (collection != null) return collection;
        collection = this.createCollection(object);
        this.map.put(object, collection);
        return collection;
    }

    @Override
    public Collection replaceValues(@Nullable Object object, Iterable iterable) {
        Iterator<T> iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return this.removeAll(object);
        }
        Collection collection = this.getOrCreateCollection(object);
        Collection collection2 = this.createCollection();
        collection2.addAll(collection);
        this.totalSize -= collection.size();
        collection.clear();
        while (iterator.hasNext()) {
            if (!collection.add(iterator.next())) continue;
            ++this.totalSize;
        }
        return this.unmodifiableCollectionSubclass(collection2);
    }

    @Override
    public Collection removeAll(@Nullable Object object) {
        Collection collection = (Collection)this.map.remove(object);
        if (collection == null) {
            return this.createUnmodifiableEmptyCollection();
        }
        Collection collection2 = this.createCollection();
        collection2.addAll(collection);
        this.totalSize -= collection.size();
        collection.clear();
        return this.unmodifiableCollectionSubclass(collection2);
    }

    Collection unmodifiableCollectionSubclass(Collection collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet)collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set)collection);
        }
        if (!(collection instanceof List)) return Collections.unmodifiableCollection(collection);
        return Collections.unmodifiableList((List)collection);
    }

    @Override
    public void clear() {
        Iterator<V> iterator = this.map.values().iterator();
        do {
            if (!iterator.hasNext()) {
                this.map.clear();
                this.totalSize = 0;
                return;
            }
            Collection collection = (Collection)iterator.next();
            collection.clear();
        } while (true);
    }

    @Override
    public Collection get(@Nullable Object object) {
        Collection collection = (Collection)this.map.get(object);
        if (collection != null) return this.wrapCollection(object, collection);
        collection = this.createCollection(object);
        return this.wrapCollection(object, collection);
    }

    Collection wrapCollection(@Nullable Object object, Collection collection) {
        if (collection instanceof SortedSet) {
            return new AbstractMapBasedMultimap$WrappedSortedSet(this, object, (SortedSet)collection, null);
        }
        if (collection instanceof Set) {
            return new AbstractMapBasedMultimap$WrappedSet(this, object, (Set)collection);
        }
        if (!(collection instanceof List)) return new AbstractMapBasedMultimap$WrappedCollection(this, object, collection, null);
        return this.wrapList(object, (List)collection, null);
    }

    private List wrapList(@Nullable Object object, List list, @Nullable AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        AbstractMapBasedMultimap$RandomAccessWrappedList abstractMapBasedMultimap$RandomAccessWrappedList /* !! */ ;
        if (list instanceof RandomAccess) {
            abstractMapBasedMultimap$RandomAccessWrappedList /* !! */  = new AbstractMapBasedMultimap$RandomAccessWrappedList(this, object, list, abstractMapBasedMultimap$WrappedCollection);
            return abstractMapBasedMultimap$RandomAccessWrappedList /* !! */ ;
        }
        abstractMapBasedMultimap$RandomAccessWrappedList /* !! */  = new AbstractMapBasedMultimap$WrappedList(this, object, list, abstractMapBasedMultimap$WrappedCollection);
        return abstractMapBasedMultimap$RandomAccessWrappedList /* !! */ ;
    }

    private Iterator iteratorOrListIterator(Collection collection) {
        Iterator<E> iterator;
        if (collection instanceof List) {
            iterator = ((List)collection).listIterator();
            return iterator;
        }
        iterator = collection.iterator();
        return iterator;
    }

    @Override
    Set createKeySet() {
        AbstractMapBasedMultimap$SortedKeySet abstractMapBasedMultimap$SortedKeySet /* !! */ ;
        if (this.map instanceof SortedMap) {
            abstractMapBasedMultimap$SortedKeySet /* !! */  = new AbstractMapBasedMultimap$SortedKeySet(this, (SortedMap)this.map);
            return abstractMapBasedMultimap$SortedKeySet /* !! */ ;
        }
        abstractMapBasedMultimap$SortedKeySet /* !! */  = new AbstractMapBasedMultimap$KeySet(this, this.map);
        return abstractMapBasedMultimap$SortedKeySet /* !! */ ;
    }

    private int removeValuesForKey(Object object) {
        Collection collection = (Collection)Maps.safeRemove(this.map, object);
        int n2 = 0;
        if (collection == null) return n2;
        n2 = collection.size();
        collection.clear();
        this.totalSize -= n2;
        return n2;
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
        AbstractMapBasedMultimap$SortedAsMap abstractMapBasedMultimap$SortedAsMap /* !! */ ;
        if (this.map instanceof SortedMap) {
            abstractMapBasedMultimap$SortedAsMap /* !! */  = new AbstractMapBasedMultimap$SortedAsMap(this, (SortedMap)this.map);
            return abstractMapBasedMultimap$SortedAsMap /* !! */ ;
        }
        abstractMapBasedMultimap$SortedAsMap /* !! */  = new AbstractMapBasedMultimap$AsMap(this, this.map);
        return abstractMapBasedMultimap$SortedAsMap /* !! */ ;
    }

    static /* synthetic */ Map access$000(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        return abstractMapBasedMultimap.map;
    }

    static /* synthetic */ Iterator access$100(AbstractMapBasedMultimap abstractMapBasedMultimap, Collection collection) {
        return abstractMapBasedMultimap.iteratorOrListIterator(collection);
    }

    static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        return abstractMapBasedMultimap.totalSize--;
    }

    static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        return abstractMapBasedMultimap.totalSize++;
    }

    static /* synthetic */ int access$200(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        return abstractMapBasedMultimap.totalSize;
    }

    static /* synthetic */ int access$202(AbstractMapBasedMultimap abstractMapBasedMultimap, int n2) {
        abstractMapBasedMultimap.totalSize = n2;
        return abstractMapBasedMultimap.totalSize;
    }

    static /* synthetic */ List access$300(AbstractMapBasedMultimap abstractMapBasedMultimap, Object object, List list, AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        return abstractMapBasedMultimap.wrapList(object, list, abstractMapBasedMultimap$WrappedCollection);
    }

    static /* synthetic */ int access$400(AbstractMapBasedMultimap abstractMapBasedMultimap, Object object) {
        return abstractMapBasedMultimap.removeValuesForKey(object);
    }
}

