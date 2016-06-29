package com.google.common.collect;

import com.google.common.annotations.*;
import java.io.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public final class LinkedHashMultiset extends AbstractMapBasedMultiset
{
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    
    public static LinkedHashMultiset create() {
        return new LinkedHashMultiset();
    }
    
    public static LinkedHashMultiset create(final int n) {
        return new LinkedHashMultiset(n);
    }
    
    public static LinkedHashMultiset create(final Iterable iterable) {
        final LinkedHashMultiset create = create(Multisets.inferDistinctElements(iterable));
        Iterables.addAll(create, iterable);
        return create;
    }
    
    private LinkedHashMultiset() {
        super(new LinkedHashMap());
    }
    
    private LinkedHashMultiset(final int n) {
        super(Maps.newLinkedHashMapWithExpectedSize(n));
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        final int count = Serialization.readCount(objectInputStream);
        this.setBackingMap(new LinkedHashMap());
        Serialization.populateMultiset(this, objectInputStream, count);
    }
}
