package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(emulated = true)
public abstract class ImmutableCollection extends AbstractCollection implements Serializable
{
    @LazyInit
    private transient ImmutableList asList;
    
    @Override
    public abstract UnmodifiableIterator iterator();
    
    @Override
    public final Object[] toArray() {
        final int size = this.size();
        if (size == 0) {
            return ObjectArrays.EMPTY_ARRAY;
        }
        final Object[] array = new Object[size];
        this.copyIntoArray(array, 0);
        return array;
    }
    
    @Override
    public final Object[] toArray(Object[] array) {
        Preconditions.checkNotNull(array);
        final int size = this.size();
        if (array.length < size) {
            array = ObjectArrays.newArray(array, size);
        }
        else if (array.length > size) {
            array[size] = null;
        }
        this.copyIntoArray(array, 0);
        return array;
    }
    
    @Override
    public abstract boolean contains(@Nullable final Object p0);
    
    @Deprecated
    @Override
    public final boolean add(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final boolean addAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final boolean removeAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final boolean retainAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }
    
    public ImmutableList asList() {
        final ImmutableList asList = this.asList;
        return (asList == null) ? (this.asList = this.createAsList()) : asList;
    }
    
    ImmutableList createAsList() {
        switch (this.size()) {
            case 0: {
                return ImmutableList.of();
            }
            case 1: {
                return ImmutableList.of(this.iterator().next());
            }
            default: {
                return new RegularImmutableAsList(this, this.toArray());
            }
        }
    }
    
    abstract boolean isPartialView();
    
    int copyIntoArray(final Object[] array, int n) {
        final UnmodifiableIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            array[n++] = iterator.next();
        }
        return n;
    }
    
    Object writeReplace() {
        return new ImmutableList$SerializedForm(this.toArray());
    }
}
