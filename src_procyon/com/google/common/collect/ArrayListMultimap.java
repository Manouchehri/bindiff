package com.google.common.collect;

import com.google.common.annotations.*;
import java.io.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public final class ArrayListMultimap extends AbstractListMultimap
{
    private static final int DEFAULT_VALUES_PER_KEY = 3;
    @VisibleForTesting
    transient int expectedValuesPerKey;
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0L;
    
    public static ArrayListMultimap create() {
        return new ArrayListMultimap();
    }
    
    public static ArrayListMultimap create(final int n, final int n2) {
        return new ArrayListMultimap(n, n2);
    }
    
    public static ArrayListMultimap create(final Multimap multimap) {
        return new ArrayListMultimap(multimap);
    }
    
    private ArrayListMultimap() {
        super(new HashMap());
        this.expectedValuesPerKey = 3;
    }
    
    private ArrayListMultimap(final int n, final int expectedValuesPerKey) {
        super(Maps.newHashMapWithExpectedSize(n));
        CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
        this.expectedValuesPerKey = expectedValuesPerKey;
    }
    
    private ArrayListMultimap(final Multimap multimap) {
        this(multimap.keySet().size(), (multimap instanceof ArrayListMultimap) ? ((ArrayListMultimap)multimap).expectedValuesPerKey : 3);
        this.putAll(multimap);
    }
    
    @Override
    List createCollection() {
        return new ArrayList(this.expectedValuesPerKey);
    }
    
    public void trimToSize() {
        final Iterator<Collection> iterator = this.backingMap().values().iterator();
        while (iterator.hasNext()) {
            ((ArrayList)iterator.next()).trimToSize();
        }
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 3;
        final int count = Serialization.readCount(objectInputStream);
        this.setMap(Maps.newHashMap());
        Serialization.populateMultimap(this, objectInputStream, count);
    }
}
