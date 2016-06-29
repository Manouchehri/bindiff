package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public class TreeMultimap extends AbstractSortedKeySortedSetMultimap
{
    private transient Comparator keyComparator;
    private transient Comparator valueComparator;
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    
    public static TreeMultimap create() {
        return new TreeMultimap(Ordering.natural(), Ordering.natural());
    }
    
    public static TreeMultimap create(final Comparator comparator, final Comparator comparator2) {
        return new TreeMultimap((Comparator)Preconditions.checkNotNull(comparator), (Comparator)Preconditions.checkNotNull(comparator2));
    }
    
    public static TreeMultimap create(final Multimap multimap) {
        return new TreeMultimap(Ordering.natural(), Ordering.natural(), multimap);
    }
    
    TreeMultimap(final Comparator keyComparator, final Comparator valueComparator) {
        super(new TreeMap(keyComparator));
        this.keyComparator = keyComparator;
        this.valueComparator = valueComparator;
    }
    
    private TreeMultimap(final Comparator comparator, final Comparator comparator2, final Multimap multimap) {
        this(comparator, comparator2);
        this.putAll(multimap);
    }
    
    @Override
    SortedSet createCollection() {
        return new TreeSet(this.valueComparator);
    }
    
    @Override
    Collection createCollection(@Nullable final Object o) {
        if (o == null) {
            this.keyComparator().compare(o, o);
        }
        return super.createCollection(o);
    }
    
    public Comparator keyComparator() {
        return this.keyComparator;
    }
    
    @Override
    public Comparator valueComparator() {
        return this.valueComparator;
    }
    
    @GwtIncompatible("NavigableMap")
    @Override
    NavigableMap backingMap() {
        return (NavigableMap)super.backingMap();
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    public NavigableSet get(@Nullable final Object o) {
        return (NavigableSet)super.get(o);
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    Collection unmodifiableCollectionSubclass(final Collection collection) {
        return Sets.unmodifiableNavigableSet((NavigableSet)collection);
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    Collection wrapCollection(final Object o, final Collection collection) {
        return new AbstractMapBasedMultimap$WrappedNavigableSet(this, o, (NavigableSet)collection, null);
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    public NavigableSet keySet() {
        return (NavigableSet)super.keySet();
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    NavigableSet createKeySet() {
        return new AbstractMapBasedMultimap$NavigableKeySet(this, this.backingMap());
    }
    
    @GwtIncompatible("NavigableMap")
    @Override
    public NavigableMap asMap() {
        return (NavigableMap)super.asMap();
    }
    
    @GwtIncompatible("NavigableMap")
    @Override
    NavigableMap createAsMap() {
        return new AbstractMapBasedMultimap$NavigableAsMap(this, this.backingMap());
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyComparator());
        objectOutputStream.writeObject(this.valueComparator());
        Serialization.writeMultimap(this, objectOutputStream);
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.keyComparator = (Comparator)Preconditions.checkNotNull(objectInputStream.readObject());
        this.valueComparator = (Comparator)Preconditions.checkNotNull(objectInputStream.readObject());
        this.setMap(new TreeMap(this.keyComparator));
        Serialization.populateMultimap(this, objectInputStream);
    }
}
