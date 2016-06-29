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
import com.google.common.collect.EnumBiMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Serialization;
import com.google.common.collect.WellBehavedMap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class EnumHashBiMap
extends AbstractBiMap {
    private transient Class keyType;
    @GwtIncompatible(value="only needed in emulated source.")
    private static final long serialVersionUID = 0;

    public static EnumHashBiMap create(Class class_) {
        return new EnumHashBiMap(class_);
    }

    public static EnumHashBiMap create(Map map) {
        EnumHashBiMap enumHashBiMap = EnumHashBiMap.create(EnumBiMap.inferKeyType(map));
        enumHashBiMap.putAll(map);
        return enumHashBiMap;
    }

    private EnumHashBiMap(Class class_) {
        super((Map)WellBehavedMap.wrap(new EnumMap(class_)), Maps.newHashMapWithExpectedSize(((Enum[])class_.getEnumConstants()).length));
        this.keyType = class_;
    }

    Enum checkKey(Enum enum_) {
        return (Enum)Preconditions.checkNotNull(enum_);
    }

    public Object put(Enum enum_, @Nullable Object object) {
        return super.put(enum_, object);
    }

    public Object forcePut(Enum enum_, @Nullable Object object) {
        return super.forcePut(enum_, object);
    }

    public Class keyType() {
        return this.keyType;
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        Serialization.writeMap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.keyType = (Class)objectInputStream.readObject();
        this.setDelegates(WellBehavedMap.wrap(new EnumMap(this.keyType)), new HashMap(((Enum[])this.keyType.getEnumConstants()).length * 3 / 2));
        Serialization.populateMap(this, objectInputStream);
    }
}

