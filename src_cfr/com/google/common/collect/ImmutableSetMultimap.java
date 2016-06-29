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
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.EmptyImmutableSetMultimap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$FieldSettersHolder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.ImmutableSetMultimap$Builder;
import com.google.common.collect.ImmutableSetMultimap$EntrySet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet$Builder;
import com.google.common.collect.Multimap;
import com.google.common.collect.Serialization;
import com.google.common.collect.Serialization$FieldSetter;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public class ImmutableSetMultimap
extends ImmutableMultimap
implements SetMultimap {
    private final transient ImmutableSet emptySet;
    @LazyInit
    private transient ImmutableSetMultimap inverse;
    private transient ImmutableSet entries;
    @GwtIncompatible(value="not needed in emulated source.")
    private static final long serialVersionUID = 0;

    public static ImmutableSetMultimap of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    public static ImmutableSetMultimap of(Object object, Object object2) {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        immutableSetMultimap$Builder.put(object, object2);
        return immutableSetMultimap$Builder.build();
    }

    public static ImmutableSetMultimap of(Object object, Object object2, Object object3, Object object4) {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        immutableSetMultimap$Builder.put(object, object2);
        immutableSetMultimap$Builder.put(object3, object4);
        return immutableSetMultimap$Builder.build();
    }

    public static ImmutableSetMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        immutableSetMultimap$Builder.put(object, object2);
        immutableSetMultimap$Builder.put(object3, object4);
        immutableSetMultimap$Builder.put(object5, object6);
        return immutableSetMultimap$Builder.build();
    }

    public static ImmutableSetMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        immutableSetMultimap$Builder.put(object, object2);
        immutableSetMultimap$Builder.put(object3, object4);
        immutableSetMultimap$Builder.put(object5, object6);
        immutableSetMultimap$Builder.put(object7, object8);
        return immutableSetMultimap$Builder.build();
    }

    public static ImmutableSetMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        immutableSetMultimap$Builder.put(object, object2);
        immutableSetMultimap$Builder.put(object3, object4);
        immutableSetMultimap$Builder.put(object5, object6);
        immutableSetMultimap$Builder.put(object7, object8);
        immutableSetMultimap$Builder.put(object9, object10);
        return immutableSetMultimap$Builder.build();
    }

    public static ImmutableSetMultimap$Builder builder() {
        return new ImmutableSetMultimap$Builder();
    }

    public static ImmutableSetMultimap copyOf(Multimap multimap) {
        return ImmutableSetMultimap.copyOf(multimap, null);
    }

    private static ImmutableSetMultimap copyOf(Multimap multimap, Comparator comparator) {
        Object object;
        Preconditions.checkNotNull(multimap);
        if (multimap.isEmpty() && comparator == null) {
            return ImmutableSetMultimap.of();
        }
        if (multimap instanceof ImmutableSetMultimap && !(object = (ImmutableSetMultimap)multimap).isPartialView()) {
            return object;
        }
        object = new ImmutableMap$Builder(multimap.asMap().size());
        int n2 = 0;
        Iterator iterator = multimap.asMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            Object k2 = entry.getKey();
            Collection collection = (Collection)entry.getValue();
            ImmutableSet immutableSet = ImmutableSetMultimap.valueSet(comparator, collection);
            if (immutableSet.isEmpty()) continue;
            object.put(k2, immutableSet);
            n2 += immutableSet.size();
        }
        return new ImmutableSetMultimap(object.build(), n2, comparator);
    }

    @Beta
    public static ImmutableSetMultimap copyOf(Iterable iterable) {
        return new ImmutableSetMultimap$Builder().putAll(iterable).build();
    }

    ImmutableSetMultimap(ImmutableMap immutableMap, int n2, @Nullable Comparator comparator) {
        super(immutableMap, n2);
        this.emptySet = ImmutableSetMultimap.emptySet(comparator);
    }

    @Override
    public ImmutableSet get(@Nullable Object object) {
        ImmutableSet immutableSet = (ImmutableSet)this.map.get(object);
        return (ImmutableSet)MoreObjects.firstNonNull(immutableSet, this.emptySet);
    }

    @Override
    public ImmutableSetMultimap inverse() {
        ImmutableSetMultimap immutableSetMultimap;
        ImmutableSetMultimap immutableSetMultimap2 = this.inverse;
        if (immutableSetMultimap2 == null) {
            immutableSetMultimap = this.inverse = this.invert();
            return immutableSetMultimap;
        }
        immutableSetMultimap = immutableSetMultimap2;
        return immutableSetMultimap;
    }

    private ImmutableSetMultimap invert() {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        Object object = this.entries().iterator();
        do {
            if (!object.hasNext()) {
                object = immutableSetMultimap$Builder.build();
                object.inverse = this;
                return object;
            }
            Map.Entry entry = (Map.Entry)object.next();
            immutableSetMultimap$Builder.put(entry.getValue(), entry.getKey());
        } while (true);
    }

    @Deprecated
    @Override
    public ImmutableSet removeAll(Object object) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public ImmutableSet replaceValues(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImmutableSet entries() {
        ImmutableSet immutableSet;
        ImmutableSet immutableSet2 = this.entries;
        if (immutableSet2 == null) {
            immutableSet = this.entries = new ImmutableSetMultimap$EntrySet(this);
            return immutableSet;
        }
        immutableSet = immutableSet2;
        return immutableSet;
    }

    private static ImmutableSet valueSet(@Nullable Comparator comparator, Collection collection) {
        ImmutableSet immutableSet;
        if (comparator == null) {
            immutableSet = ImmutableSet.copyOf(collection);
            return immutableSet;
        }
        immutableSet = ImmutableSortedSet.copyOf(comparator, collection);
        return immutableSet;
    }

    private static ImmutableSet emptySet(@Nullable Comparator comparator) {
        ImmutableSet immutableSet;
        if (comparator == null) {
            immutableSet = ImmutableSet.of();
            return immutableSet;
        }
        immutableSet = ImmutableSortedSet.emptySet(comparator);
        return immutableSet;
    }

    private static ImmutableSet$Builder valuesBuilder(@Nullable Comparator comparator) {
        ImmutableSet$Builder immutableSet$Builder;
        if (comparator == null) {
            immutableSet$Builder = new ImmutableSet$Builder();
            return immutableSet$Builder;
        }
        immutableSet$Builder = new ImmutableSortedSet$Builder(comparator);
        return immutableSet$Builder;
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.valueComparator());
        Serialization.writeMultimap(this, objectOutputStream);
    }

    @Nullable
    Comparator valueComparator() {
        if (!(this.emptySet instanceof ImmutableSortedSet)) return null;
        Comparator comparator = ((ImmutableSortedSet)this.emptySet).comparator();
        return comparator;
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        ImmutableMap immutableMap;
        int n2;
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator)objectInputStream.readObject();
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
            ImmutableSet$Builder immutableSet$Builder = ImmutableSetMultimap.valuesBuilder(comparator);
            for (int i3 = 0; i3 < n2; ++i3) {
                immutableSet$Builder.add(objectInputStream.readObject());
            }
            ImmutableSet immutableSet = immutableSet$Builder.build();
            if (immutableSet.size() != n2) {
                String string = String.valueOf(object);
                throw new InvalidObjectException(new StringBuilder(40 + String.valueOf(string).length()).append("Duplicate key-value pairs exist for key ").append(string).toString());
            }
            immutableMap$Builder.put(object, immutableSet);
        }
        try {
            immutableMap = immutableMap$Builder.build();
        }
        catch (IllegalArgumentException var7_9) {
            throw (InvalidObjectException)new InvalidObjectException(var7_9.getMessage()).initCause(var7_9);
        }
        ImmutableMultimap$FieldSettersHolder.MAP_FIELD_SETTER.set((Object)this, immutableMap);
        ImmutableMultimap$FieldSettersHolder.SIZE_FIELD_SETTER.set((Object)this, n4);
        ImmutableMultimap$FieldSettersHolder.EMPTY_SET_FIELD_SETTER.set((Object)this, ImmutableSetMultimap.emptySet(comparator));
    }

    static /* synthetic */ ImmutableSetMultimap access$000(Multimap multimap, Comparator comparator) {
        return ImmutableSetMultimap.copyOf(multimap, comparator);
    }
}

