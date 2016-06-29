/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$NavigableAsMap;
import com.google.common.collect.AbstractMapBasedMultimap$NavigableKeySet;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedNavigableSet;
import com.google.common.collect.AbstractSortedKeySortedSetMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.Serialization;
import com.google.common.collect.Sets;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public class TreeMultimap
extends AbstractSortedKeySortedSetMultimap {
    private transient Comparator keyComparator;
    private transient Comparator valueComparator;
    @GwtIncompatible(value="not needed in emulated source")
    private static final long serialVersionUID = 0;

    public static TreeMultimap create() {
        return new TreeMultimap(Ordering.natural(), Ordering.natural());
    }

    public static TreeMultimap create(Comparator comparator, Comparator comparator2) {
        return new TreeMultimap((Comparator)Preconditions.checkNotNull(comparator), (Comparator)Preconditions.checkNotNull(comparator2));
    }

    public static TreeMultimap create(Multimap multimap) {
        return new TreeMultimap(Ordering.natural(), Ordering.natural(), multimap);
    }

    TreeMultimap(Comparator comparator, Comparator comparator2) {
        super(new TreeMap(comparator));
        this.keyComparator = comparator;
        this.valueComparator = comparator2;
    }

    private TreeMultimap(Comparator comparator, Comparator comparator2, Multimap multimap) {
        this(comparator, comparator2);
        this.putAll(multimap);
    }

    @Override
    SortedSet createCollection() {
        return new TreeSet(this.valueComparator);
    }

    @Override
    Collection createCollection(@Nullable Object object) {
        if (object != null) return super.createCollection(object);
        this.keyComparator().compare(object, object);
        return super.createCollection(object);
    }

    public Comparator keyComparator() {
        return this.keyComparator;
    }

    @Override
    public Comparator valueComparator() {
        return this.valueComparator;
    }

    @GwtIncompatible(value="NavigableMap")
    @Override
    NavigableMap backingMap() {
        return (NavigableMap)super.backingMap();
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    public NavigableSet get(@Nullable Object object) {
        return (NavigableSet)super.get(object);
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    Collection unmodifiableCollectionSubclass(Collection collection) {
        return Sets.unmodifiableNavigableSet((NavigableSet)collection);
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    Collection wrapCollection(Object object, Collection collection) {
        return new AbstractMapBasedMultimap$WrappedNavigableSet(this, object, (NavigableSet)collection, null);
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    public NavigableSet keySet() {
        return (NavigableSet)super.keySet();
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    NavigableSet createKeySet() {
        return new AbstractMapBasedMultimap$NavigableKeySet(this, this.backingMap());
    }

    @GwtIncompatible(value="NavigableMap")
    @Override
    public NavigableMap asMap() {
        return (NavigableMap)super.asMap();
    }

    @GwtIncompatible(value="NavigableMap")
    @Override
    NavigableMap createAsMap() {
        return new AbstractMapBasedMultimap$NavigableAsMap(this, this.backingMap());
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyComparator());
        objectOutputStream.writeObject(this.valueComparator());
        Serialization.writeMultimap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.keyComparator = (Comparator)Preconditions.checkNotNull((Comparator)objectInputStream.readObject());
        this.valueComparator = (Comparator)Preconditions.checkNotNull((Comparator)objectInputStream.readObject());
        this.setMap(new TreeMap(this.keyComparator));
        Serialization.populateMultimap(this, objectInputStream);
    }
}

