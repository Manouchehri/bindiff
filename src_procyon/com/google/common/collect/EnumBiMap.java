package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;
import java.util.*;
import javax.annotation.*;

@GwtCompatible(emulated = true)
public final class EnumBiMap extends AbstractBiMap
{
    private transient Class keyType;
    private transient Class valueType;
    @GwtIncompatible("not needed in emulated source.")
    private static final long serialVersionUID = 0L;
    
    public static EnumBiMap create(final Class clazz, final Class clazz2) {
        return new EnumBiMap(clazz, clazz2);
    }
    
    public static EnumBiMap create(final Map map) {
        final EnumBiMap create = create(inferKeyType(map), inferValueType(map));
        create.putAll(map);
        return create;
    }
    
    private EnumBiMap(final Class keyType, final Class valueType) {
        super(WellBehavedMap.wrap(new EnumMap(keyType)), WellBehavedMap.wrap(new EnumMap(valueType)));
        this.keyType = keyType;
        this.valueType = valueType;
    }
    
    static Class inferKeyType(final Map map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap)map).keyType();
        }
        if (map instanceof EnumHashBiMap) {
            return ((EnumHashBiMap)map).keyType();
        }
        Preconditions.checkArgument(!map.isEmpty());
        return map.keySet().iterator().next().getDeclaringClass();
    }
    
    private static Class inferValueType(final Map map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap)map).valueType;
        }
        Preconditions.checkArgument(!map.isEmpty());
        return map.values().iterator().next().getDeclaringClass();
    }
    
    public Class keyType() {
        return this.keyType;
    }
    
    public Class valueType() {
        return this.valueType;
    }
    
    Enum checkKey(final Enum enum1) {
        return (Enum)Preconditions.checkNotNull(enum1);
    }
    
    Enum checkValue(final Enum enum1) {
        return (Enum)Preconditions.checkNotNull(enum1);
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        objectOutputStream.writeObject(this.valueType);
        Serialization.writeMap(this, objectOutputStream);
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.keyType = (Class)objectInputStream.readObject();
        this.valueType = (Class)objectInputStream.readObject();
        this.setDelegates(WellBehavedMap.wrap(new EnumMap(this.keyType)), WellBehavedMap.wrap(new EnumMap(this.valueType)));
        Serialization.populateMap(this, objectInputStream);
    }
}
