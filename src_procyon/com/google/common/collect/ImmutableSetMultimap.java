package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.io.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public class ImmutableSetMultimap extends ImmutableMultimap implements SetMultimap
{
    private final transient ImmutableSet emptySet;
    @LazyInit
    private transient ImmutableSetMultimap inverse;
    private transient ImmutableSet entries;
    @GwtIncompatible("not needed in emulated source.")
    private static final long serialVersionUID = 0L;
    
    public static ImmutableSetMultimap of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }
    
    public static ImmutableSetMultimap of(final Object o, final Object o2) {
        final ImmutableSetMultimap$Builder builder = builder();
        builder.put(o, o2);
        return builder.build();
    }
    
    public static ImmutableSetMultimap of(final Object o, final Object o2, final Object o3, final Object o4) {
        final ImmutableSetMultimap$Builder builder = builder();
        builder.put(o, o2);
        builder.put(o3, o4);
        return builder.build();
    }
    
    public static ImmutableSetMultimap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6) {
        final ImmutableSetMultimap$Builder builder = builder();
        builder.put(o, o2);
        builder.put(o3, o4);
        builder.put(o5, o6);
        return builder.build();
    }
    
    public static ImmutableSetMultimap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8) {
        final ImmutableSetMultimap$Builder builder = builder();
        builder.put(o, o2);
        builder.put(o3, o4);
        builder.put(o5, o6);
        builder.put(o7, o8);
        return builder.build();
    }
    
    public static ImmutableSetMultimap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8, final Object o9, final Object o10) {
        final ImmutableSetMultimap$Builder builder = builder();
        builder.put(o, o2);
        builder.put(o3, o4);
        builder.put(o5, o6);
        builder.put(o7, o8);
        builder.put(o9, o10);
        return builder.build();
    }
    
    public static ImmutableSetMultimap$Builder builder() {
        return new ImmutableSetMultimap$Builder();
    }
    
    public static ImmutableSetMultimap copyOf(final Multimap multimap) {
        return copyOf(multimap, null);
    }
    
    private static ImmutableSetMultimap copyOf(final Multimap multimap, final Comparator comparator) {
        Preconditions.checkNotNull(multimap);
        if (multimap.isEmpty() && comparator == null) {
            return of();
        }
        if (multimap instanceof ImmutableSetMultimap) {
            final ImmutableSetMultimap immutableSetMultimap = (ImmutableSetMultimap)multimap;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        final ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(multimap.asMap().size());
        int n = 0;
        for (final Map.Entry<Object, V> entry : multimap.asMap().entrySet()) {
            final Object key = entry.getKey();
            final ImmutableSet valueSet = valueSet(comparator, (Collection)entry.getValue());
            if (!valueSet.isEmpty()) {
                immutableMap$Builder.put(key, valueSet);
                n += valueSet.size();
            }
        }
        return new ImmutableSetMultimap(immutableMap$Builder.build(), n, comparator);
    }
    
    @Beta
    public static ImmutableSetMultimap copyOf(final Iterable iterable) {
        return new ImmutableSetMultimap$Builder().putAll(iterable).build();
    }
    
    ImmutableSetMultimap(final ImmutableMap immutableMap, final int n, @Nullable final Comparator comparator) {
        super(immutableMap, n);
        this.emptySet = emptySet(comparator);
    }
    
    @Override
    public ImmutableSet get(@Nullable final Object o) {
        return (ImmutableSet)MoreObjects.firstNonNull(this.map.get(o), this.emptySet);
    }
    
    @Override
    public ImmutableSetMultimap inverse() {
        final ImmutableSetMultimap inverse = this.inverse;
        return (inverse == null) ? (this.inverse = this.invert()) : inverse;
    }
    
    private ImmutableSetMultimap invert() {
        final ImmutableSetMultimap$Builder builder = builder();
        for (final Map.Entry<K, Object> entry : this.entries()) {
            builder.put(entry.getValue(), entry.getKey());
        }
        final ImmutableSetMultimap build = builder.build();
        build.inverse = this;
        return build;
    }
    
    @Deprecated
    @Override
    public ImmutableSet removeAll(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public ImmutableSet replaceValues(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ImmutableSet entries() {
        final ImmutableSet entries = this.entries;
        return (entries == null) ? (this.entries = new ImmutableSetMultimap$EntrySet(this)) : entries;
    }
    
    private static ImmutableSet valueSet(@Nullable final Comparator comparator, final Collection collection) {
        return (comparator == null) ? ImmutableSet.copyOf(collection) : ImmutableSortedSet.copyOf(comparator, collection);
    }
    
    private static ImmutableSet emptySet(@Nullable final Comparator comparator) {
        return (comparator == null) ? ImmutableSet.of() : ImmutableSortedSet.emptySet(comparator);
    }
    
    private static ImmutableSet$Builder valuesBuilder(@Nullable final Comparator comparator) {
        return (comparator == null) ? new ImmutableSet$Builder() : new ImmutableSortedSet$Builder(comparator);
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.valueComparator());
        Serialization.writeMultimap(this, objectOutputStream);
    }
    
    @Nullable
    Comparator valueComparator() {
        return (this.emptySet instanceof ImmutableSortedSet) ? ((ImmutableSortedSet)this.emptySet).comparator() : null;
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        final Comparator comparator = (Comparator)objectInputStream.readObject();
        final int int1 = objectInputStream.readInt();
        if (int1 < 0) {
            throw new InvalidObjectException(new StringBuilder(29).append("Invalid key count ").append(int1).toString());
        }
        final ImmutableMap$Builder builder = ImmutableMap.builder();
        int n = 0;
        for (int i = 0; i < int1; ++i) {
            final Object object = objectInputStream.readObject();
            final int int2 = objectInputStream.readInt();
            if (int2 <= 0) {
                throw new InvalidObjectException(new StringBuilder(31).append("Invalid value count ").append(int2).toString());
            }
            final ImmutableSet$Builder valuesBuilder = valuesBuilder(comparator);
            for (int j = 0; j < int2; ++j) {
                valuesBuilder.add(objectInputStream.readObject());
            }
            final ImmutableSet build = valuesBuilder.build();
            if (build.size() != int2) {
                final String value = String.valueOf(object);
                throw new InvalidObjectException(new StringBuilder(40 + String.valueOf(value).length()).append("Duplicate key-value pairs exist for key ").append(value).toString());
            }
            builder.put(object, build);
            n += int2;
        }
        ImmutableMap build2;
        try {
            build2 = builder.build();
        }
        catch (IllegalArgumentException ex) {
            throw (InvalidObjectException)new InvalidObjectException(ex.getMessage()).initCause(ex);
        }
        ImmutableMultimap$FieldSettersHolder.MAP_FIELD_SETTER.set(this, build2);
        ImmutableMultimap$FieldSettersHolder.SIZE_FIELD_SETTER.set(this, n);
        ImmutableMultimap$FieldSettersHolder.EMPTY_SET_FIELD_SETTER.set(this, emptySet(comparator));
    }
}
