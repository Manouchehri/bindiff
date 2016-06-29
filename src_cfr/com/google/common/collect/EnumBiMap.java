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
import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.BiMap;
import com.google.common.collect.EnumHashBiMap;
import com.google.common.collect.Serialization;
import com.google.common.collect.WellBehavedMap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class EnumBiMap
extends AbstractBiMap {
    private transient Class keyType;
    private transient Class valueType;
    @GwtIncompatible(value="not needed in emulated source.")
    private static final long serialVersionUID = 0;

    public static EnumBiMap create(Class class_, Class class_2) {
        return new EnumBiMap(class_, class_2);
    }

    public static EnumBiMap create(Map map) {
        EnumBiMap enumBiMap = EnumBiMap.create(EnumBiMap.inferKeyType(map), EnumBiMap.inferValueType(map));
        enumBiMap.putAll(map);
        return enumBiMap;
    }

    private EnumBiMap(Class class_, Class class_2) {
        super((Map)WellBehavedMap.wrap(new EnumMap(class_)), WellBehavedMap.wrap(new EnumMap(class_2)));
        this.keyType = class_;
        this.valueType = class_2;
    }

    static Class inferKeyType(Map map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap)map).keyType();
        }
        if (map instanceof EnumHashBiMap) {
            return ((EnumHashBiMap)map).keyType();
        }
        Preconditions.checkArgument(!map.isEmpty());
        return ((Enum)map.keySet().iterator().next()).getDeclaringClass();
    }

    private static Class inferValueType(Map map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap)map).valueType;
        }
        Preconditions.checkArgument(!map.isEmpty());
        return ((Enum)map.values().iterator().next()).getDeclaringClass();
    }

    public Class keyType() {
        return this.keyType;
    }

    public Class valueType() {
        return this.valueType;
    }

    Enum checkKey(Enum enum_) {
        return (Enum)Preconditions.checkNotNull(enum_);
    }

    Enum checkValue(Enum enum_) {
        return (Enum)Preconditions.checkNotNull(enum_);
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        objectOutputStream.writeObject(this.valueType);
        Serialization.writeMap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.keyType = (Class)objectInputStream.readObject();
        this.valueType = (Class)objectInputStream.readObject();
        this.setDelegates(WellBehavedMap.wrap(new EnumMap(this.keyType)), WellBehavedMap.wrap(new EnumMap(this.valueType)));
        Serialization.populateMap(this, objectInputStream);
    }
}

