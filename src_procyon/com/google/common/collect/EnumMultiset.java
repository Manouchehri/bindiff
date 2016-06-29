package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(emulated = true)
public final class EnumMultiset extends AbstractMapBasedMultiset
{
    private transient Class type;
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0L;
    
    public static EnumMultiset create(final Class clazz) {
        return new EnumMultiset(clazz);
    }
    
    public static EnumMultiset create(final Iterable iterable) {
        final Iterator<Enum> iterator = iterable.iterator();
        Preconditions.checkArgument(iterator.hasNext(), (Object)"EnumMultiset constructor passed empty Iterable");
        final EnumMultiset enumMultiset = new EnumMultiset(iterator.next().getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }
    
    public static EnumMultiset create(final Iterable iterable, final Class clazz) {
        final EnumMultiset create = create(clazz);
        Iterables.addAll(create, iterable);
        return create;
    }
    
    private EnumMultiset(final Class type) {
        super(WellBehavedMap.wrap(new EnumMap(type)));
        this.type = type;
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        Serialization.writeMultiset(this, objectOutputStream);
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.type = (Class)objectInputStream.readObject();
        this.setBackingMap(WellBehavedMap.wrap(new EnumMap(this.type)));
        Serialization.populateMultiset(this, objectInputStream);
    }
}
