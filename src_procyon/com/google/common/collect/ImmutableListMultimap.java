package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public class ImmutableListMultimap extends ImmutableMultimap implements ListMultimap
{
    @LazyInit
    private transient ImmutableListMultimap inverse;
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0L;
    
    public static ImmutableListMultimap of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }
    
    public static ImmutableListMultimap of(final Object o, final Object o2) {
        final ImmutableListMultimap$Builder builder = builder();
        builder.put(o, o2);
        return builder.build();
    }
    
    public static ImmutableListMultimap of(final Object o, final Object o2, final Object o3, final Object o4) {
        final ImmutableListMultimap$Builder builder = builder();
        builder.put(o, o2);
        builder.put(o3, o4);
        return builder.build();
    }
    
    public static ImmutableListMultimap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6) {
        final ImmutableListMultimap$Builder builder = builder();
        builder.put(o, o2);
        builder.put(o3, o4);
        builder.put(o5, o6);
        return builder.build();
    }
    
    public static ImmutableListMultimap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8) {
        final ImmutableListMultimap$Builder builder = builder();
        builder.put(o, o2);
        builder.put(o3, o4);
        builder.put(o5, o6);
        builder.put(o7, o8);
        return builder.build();
    }
    
    public static ImmutableListMultimap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8, final Object o9, final Object o10) {
        final ImmutableListMultimap$Builder builder = builder();
        builder.put(o, o2);
        builder.put(o3, o4);
        builder.put(o5, o6);
        builder.put(o7, o8);
        builder.put(o9, o10);
        return builder.build();
    }
    
    public static ImmutableListMultimap$Builder builder() {
        return new ImmutableListMultimap$Builder();
    }
    
    public static ImmutableListMultimap copyOf(final Multimap multimap) {
        if (multimap.isEmpty()) {
            return of();
        }
        if (multimap instanceof ImmutableListMultimap) {
            final ImmutableListMultimap immutableListMultimap = (ImmutableListMultimap)multimap;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        final ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(multimap.asMap().size());
        int n = 0;
        for (final Map.Entry<K, Collection> entry : multimap.asMap().entrySet()) {
            final ImmutableList copy = ImmutableList.copyOf(entry.getValue());
            if (!copy.isEmpty()) {
                immutableMap$Builder.put(entry.getKey(), copy);
                n += copy.size();
            }
        }
        return new ImmutableListMultimap(immutableMap$Builder.build(), n);
    }
    
    @Beta
    public static ImmutableListMultimap copyOf(final Iterable iterable) {
        return new ImmutableListMultimap$Builder().putAll(iterable).build();
    }
    
    ImmutableListMultimap(final ImmutableMap immutableMap, final int n) {
        super(immutableMap, n);
    }
    
    @Override
    public ImmutableList get(@Nullable final Object o) {
        final ImmutableList list = (ImmutableList)this.map.get(o);
        return (list == null) ? ImmutableList.of() : list;
    }
    
    @Override
    public ImmutableListMultimap inverse() {
        final ImmutableListMultimap inverse = this.inverse;
        return (inverse == null) ? (this.inverse = this.invert()) : inverse;
    }
    
    private ImmutableListMultimap invert() {
        final ImmutableListMultimap$Builder builder = builder();
        for (final Map.Entry<K, Object> entry : this.entries()) {
            builder.put(entry.getValue(), entry.getKey());
        }
        final ImmutableListMultimap build = builder.build();
        build.inverse = this;
        return build;
    }
    
    @Deprecated
    @Override
    public ImmutableList removeAll(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public ImmutableList replaceValues(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
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
            final ImmutableList$Builder builder2 = ImmutableList.builder();
            for (int j = 0; j < int2; ++j) {
                builder2.add(objectInputStream.readObject());
            }
            builder.put(object, builder2.build());
            n += int2;
        }
        ImmutableMap build;
        try {
            build = builder.build();
        }
        catch (IllegalArgumentException ex) {
            throw (InvalidObjectException)new InvalidObjectException(ex.getMessage()).initCause(ex);
        }
        ImmutableMultimap$FieldSettersHolder.MAP_FIELD_SETTER.set(this, build);
        ImmutableMultimap$FieldSettersHolder.SIZE_FIELD_SETTER.set(this, n);
    }
}
