/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.EmptyImmutableListMultimap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableListMultimap$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$FieldSettersHolder;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Serialization;
import com.google.common.collect.Serialization$FieldSetter;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public class ImmutableListMultimap
extends ImmutableMultimap
implements ListMultimap {
    @LazyInit
    private transient ImmutableListMultimap inverse;
    @GwtIncompatible(value="Not needed in emulated source")
    private static final long serialVersionUID = 0;

    public static ImmutableListMultimap of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    public static ImmutableListMultimap of(Object object, Object object2) {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        immutableListMultimap$Builder.put(object, object2);
        return immutableListMultimap$Builder.build();
    }

    public static ImmutableListMultimap of(Object object, Object object2, Object object3, Object object4) {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        immutableListMultimap$Builder.put(object, object2);
        immutableListMultimap$Builder.put(object3, object4);
        return immutableListMultimap$Builder.build();
    }

    public static ImmutableListMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        immutableListMultimap$Builder.put(object, object2);
        immutableListMultimap$Builder.put(object3, object4);
        immutableListMultimap$Builder.put(object5, object6);
        return immutableListMultimap$Builder.build();
    }

    public static ImmutableListMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        immutableListMultimap$Builder.put(object, object2);
        immutableListMultimap$Builder.put(object3, object4);
        immutableListMultimap$Builder.put(object5, object6);
        immutableListMultimap$Builder.put(object7, object8);
        return immutableListMultimap$Builder.build();
    }

    public static ImmutableListMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        immutableListMultimap$Builder.put(object, object2);
        immutableListMultimap$Builder.put(object3, object4);
        immutableListMultimap$Builder.put(object5, object6);
        immutableListMultimap$Builder.put(object7, object8);
        immutableListMultimap$Builder.put(object9, object10);
        return immutableListMultimap$Builder.build();
    }

    public static ImmutableListMultimap$Builder builder() {
        return new ImmutableListMultimap$Builder();
    }

    public static ImmutableListMultimap copyOf(Multimap multimap) {
        Object object;
        if (multimap.isEmpty()) {
            return ImmutableListMultimap.of();
        }
        if (multimap instanceof ImmutableListMultimap && !(object = (ImmutableListMultimap)multimap).isPartialView()) {
            return object;
        }
        object = new ImmutableMap$Builder(multimap.asMap().size());
        int n2 = 0;
        Iterator iterator = multimap.asMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            ImmutableList immutableList = ImmutableList.copyOf((Collection)entry.getValue());
            if (immutableList.isEmpty()) continue;
            object.put(entry.getKey(), immutableList);
            n2 += immutableList.size();
        }
        return new ImmutableListMultimap(object.build(), n2);
    }

    @Beta
    public static ImmutableListMultimap copyOf(Iterable iterable) {
        return new ImmutableListMultimap$Builder().putAll(iterable).build();
    }

    ImmutableListMultimap(ImmutableMap immutableMap, int n2) {
        super(immutableMap, n2);
    }

    @Override
    public ImmutableList get(@Nullable Object object) {
        ImmutableList immutableList;
        ImmutableList immutableList2 = (ImmutableList)this.map.get(object);
        if (immutableList2 == null) {
            immutableList = ImmutableList.of();
            return immutableList;
        }
        immutableList = immutableList2;
        return immutableList;
    }

    @Override
    public ImmutableListMultimap inverse() {
        ImmutableListMultimap immutableListMultimap;
        ImmutableListMultimap immutableListMultimap2 = this.inverse;
        if (immutableListMultimap2 == null) {
            immutableListMultimap = this.inverse = this.invert();
            return immutableListMultimap;
        }
        immutableListMultimap = immutableListMultimap2;
        return immutableListMultimap;
    }

    private ImmutableListMultimap invert() {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        Object object = this.entries().iterator();
        do {
            if (!object.hasNext()) {
                object = immutableListMultimap$Builder.build();
                object.inverse = this;
                return object;
            }
            Map.Entry entry = (Map.Entry)object.next();
            immutableListMultimap$Builder.put(entry.getValue(), entry.getKey());
        } while (true);
    }

    @Deprecated
    @Override
    public ImmutableList removeAll(Object object) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public ImmutableList replaceValues(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        int n2;
        ImmutableMap immutableMap;
        objectInputStream.defaultReadObject();
        int n3 = objectInputStream.readInt();
        if (n3 < 0) {
            throw new InvalidObjectException(new StringBuilder(29).append("Invalid key count ").append(n3).toString());
        }
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        int n4 = 0;
        for (int i2 = 0; i2 < n3; n4 += n2, ++i2) {
            Object object = objectInputStream.readObject();
            n2 = objectInputStream.readInt();
            if (n2 <= 0) {
                throw new InvalidObjectException(new StringBuilder(31).append("Invalid value count ").append(n2).toString());
            }
            ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
            for (int i3 = 0; i3 < n2; ++i3) {
                immutableList$Builder.add(objectInputStream.readObject());
            }
            immutableMap$Builder.put(object, immutableList$Builder.build());
        }
        try {
            immutableMap = immutableMap$Builder.build();
        }
        catch (IllegalArgumentException var6_8) {
            throw (InvalidObjectException)new InvalidObjectException(var6_8.getMessage()).initCause(var6_8);
        }
        ImmutableMultimap$FieldSettersHolder.MAP_FIELD_SETTER.set((Object)this, immutableMap);
        ImmutableMultimap$FieldSettersHolder.SIZE_FIELD_SETTER.set((Object)this, n4);
    }
}

