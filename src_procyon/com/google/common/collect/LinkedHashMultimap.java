package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;
import java.io.*;

@GwtCompatible(serializable = true, emulated = true)
public final class LinkedHashMultimap extends AbstractSetMultimap
{
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    @VisibleForTesting
    static final double VALUE_SET_LOAD_FACTOR = 1.0;
    @VisibleForTesting
    transient int valueSetCapacity;
    private transient LinkedHashMultimap$ValueEntry multimapHeaderEntry;
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 1L;
    
    public static LinkedHashMultimap create() {
        return new LinkedHashMultimap(16, 2);
    }
    
    public static LinkedHashMultimap create(final int n, final int n2) {
        return new LinkedHashMultimap(Maps.capacity(n), Maps.capacity(n2));
    }
    
    public static LinkedHashMultimap create(final Multimap multimap) {
        final LinkedHashMultimap create = create(multimap.keySet().size(), 2);
        create.putAll(multimap);
        return create;
    }
    
    private static void succeedsInValueSet(final LinkedHashMultimap$ValueSetLink predecessorInValueSet, final LinkedHashMultimap$ValueSetLink successorInValueSet) {
        predecessorInValueSet.setSuccessorInValueSet(successorInValueSet);
        successorInValueSet.setPredecessorInValueSet(predecessorInValueSet);
    }
    
    private static void succeedsInMultimap(final LinkedHashMultimap$ValueEntry predecessorInMultimap, final LinkedHashMultimap$ValueEntry successorInMultimap) {
        predecessorInMultimap.setSuccessorInMultimap(successorInMultimap);
        successorInMultimap.setPredecessorInMultimap(predecessorInMultimap);
    }
    
    private static void deleteFromValueSet(final LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        succeedsInValueSet(linkedHashMultimap$ValueSetLink.getPredecessorInValueSet(), linkedHashMultimap$ValueSetLink.getSuccessorInValueSet());
    }
    
    private static void deleteFromMultimap(final LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry) {
        succeedsInMultimap(linkedHashMultimap$ValueEntry.getPredecessorInMultimap(), linkedHashMultimap$ValueEntry.getSuccessorInMultimap());
    }
    
    private LinkedHashMultimap(final int n, final int valueSetCapacity) {
        super(new LinkedHashMap(n));
        this.valueSetCapacity = 2;
        CollectPreconditions.checkNonnegative(valueSetCapacity, "expectedValuesPerKey");
        this.valueSetCapacity = valueSetCapacity;
        succeedsInMultimap(this.multimapHeaderEntry = new LinkedHashMultimap$ValueEntry(null, null, 0, null), this.multimapHeaderEntry);
    }
    
    @Override
    Set createCollection() {
        return new LinkedHashSet(this.valueSetCapacity);
    }
    
    @Override
    Collection createCollection(final Object o) {
        return new LinkedHashMultimap$ValueSet(this, o, this.valueSetCapacity);
    }
    
    @Override
    public Set replaceValues(@Nullable final Object o, final Iterable iterable) {
        return super.replaceValues(o, iterable);
    }
    
    @Override
    public Set entries() {
        return super.entries();
    }
    
    @Override
    public Collection values() {
        return super.values();
    }
    
    @Override
    Iterator entryIterator() {
        return new LinkedHashMultimap$1(this);
    }
    
    @Override
    Iterator valueIterator() {
        return Maps.valueIterator(this.entryIterator());
    }
    
    @Override
    public void clear() {
        super.clear();
        succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.keySet().size());
        final Iterator<Object> iterator = this.keySet().iterator();
        while (iterator.hasNext()) {
            objectOutputStream.writeObject(iterator.next());
        }
        objectOutputStream.writeInt(this.size());
        for (final Map.Entry<Object, V> entry : this.entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        succeedsInMultimap(this.multimapHeaderEntry = new LinkedHashMultimap$ValueEntry(null, null, 0, null), this.multimapHeaderEntry);
        this.valueSetCapacity = 2;
        final int int1 = objectInputStream.readInt();
        final LinkedHashMap<Object, Collection> map = new LinkedHashMap<Object, Collection>();
        for (int i = 0; i < int1; ++i) {
            final Object object = objectInputStream.readObject();
            map.put(object, this.createCollection(object));
        }
        for (int int2 = objectInputStream.readInt(), j = 0; j < int2; ++j) {
            ((Collection<Object>)map.get(objectInputStream.readObject())).add(objectInputStream.readObject());
        }
        this.setMap(map);
    }
}
