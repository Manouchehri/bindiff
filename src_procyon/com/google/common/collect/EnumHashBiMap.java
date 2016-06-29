package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

@GwtCompatible(emulated = true)
public final class EnumHashBiMap extends AbstractBiMap
{
    private transient Class keyType;
    @GwtIncompatible("only needed in emulated source.")
    private static final long serialVersionUID = 0L;
    
    public static EnumHashBiMap create(final Class clazz) {
        return new EnumHashBiMap(clazz);
    }
    
    public static EnumHashBiMap create(final Map map) {
        final EnumHashBiMap create = create(EnumBiMap.inferKeyType(map));
        create.putAll(map);
        return create;
    }
    
    private EnumHashBiMap(final Class keyType) {
        super(WellBehavedMap.wrap(new EnumMap(keyType)), Maps.newHashMapWithExpectedSize(((Enum[])keyType.getEnumConstants()).length));
        this.keyType = keyType;
    }
    
    Enum checkKey(final Enum enum1) {
        return (Enum)Preconditions.checkNotNull(enum1);
    }
    
    public Object put(final Enum enum1, @Nullable final Object o) {
        return super.put(enum1, o);
    }
    
    public Object forcePut(final Enum enum1, @Nullable final Object o) {
        return super.forcePut(enum1, o);
    }
    
    public Class keyType() {
        return this.keyType;
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        Serialization.writeMap(this, objectOutputStream);
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.keyType = (Class)objectInputStream.readObject();
        this.setDelegates(WellBehavedMap.wrap(new EnumMap(this.keyType)), new HashMap(((Enum[])this.keyType.getEnumConstants()).length * 3 / 2));
        Serialization.populateMap(this, objectInputStream);
    }
}
