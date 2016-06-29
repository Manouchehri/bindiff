package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public abstract class ImmutableList extends ImmutableCollection implements List, RandomAccess
{
    public static ImmutableList of() {
        return RegularImmutableList.EMPTY;
    }
    
    public static ImmutableList of(final Object o) {
        return new SingletonImmutableList(o);
    }
    
    public static ImmutableList of(final Object o, final Object o2) {
        return construct(o, o2);
    }
    
    public static ImmutableList of(final Object o, final Object o2, final Object o3) {
        return construct(o, o2, o3);
    }
    
    public static ImmutableList of(final Object o, final Object o2, final Object o3, final Object o4) {
        return construct(o, o2, o3, o4);
    }
    
    public static ImmutableList of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5) {
        return construct(o, o2, o3, o4, o5);
    }
    
    public static ImmutableList of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6) {
        return construct(o, o2, o3, o4, o5, o6);
    }
    
    public static ImmutableList of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7) {
        return construct(o, o2, o3, o4, o5, o6, o7);
    }
    
    public static ImmutableList of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8) {
        return construct(o, o2, o3, o4, o5, o6, o7, o8);
    }
    
    public static ImmutableList of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8, final Object o9) {
        return construct(o, o2, o3, o4, o5, o6, o7, o8, o9);
    }
    
    public static ImmutableList of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8, final Object o9, final Object o10) {
        return construct(o, o2, o3, o4, o5, o6, o7, o8, o9, o10);
    }
    
    public static ImmutableList of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8, final Object o9, final Object o10, final Object o11) {
        return construct(o, o2, o3, o4, o5, o6, o7, o8, o9, o10, o11);
    }
    
    public static ImmutableList of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8, final Object o9, final Object o10, final Object o11, final Object o12, final Object... array) {
        final Object[] array2 = new Object[12 + array.length];
        array2[0] = o;
        array2[1] = o2;
        array2[2] = o3;
        array2[3] = o4;
        array2[4] = o5;
        array2[5] = o6;
        array2[6] = o7;
        array2[7] = o8;
        array2[8] = o9;
        array2[9] = o10;
        array2[10] = o11;
        array2[11] = o12;
        System.arraycopy(array, 0, array2, 12, array.length);
        return construct(array2);
    }
    
    public static ImmutableList copyOf(final Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        return (iterable instanceof Collection) ? copyOf((Collection)iterable) : copyOf(iterable.iterator());
    }
    
    public static ImmutableList copyOf(final Collection collection) {
        if (collection instanceof ImmutableCollection) {
            final ImmutableList list = ((ImmutableCollection)collection).asList();
            return list.isPartialView() ? asImmutableList(list.toArray()) : list;
        }
        return construct(collection.toArray());
    }
    
    public static ImmutableList copyOf(final Iterator iterator) {
        if (!iterator.hasNext()) {
            return of();
        }
        final Object next = iterator.next();
        if (!iterator.hasNext()) {
            return of(next);
        }
        return new ImmutableList$Builder().add(next).addAll(iterator).build();
    }
    
    public static ImmutableList copyOf(final Object[] array) {
        switch (array.length) {
            case 0: {
                return of();
            }
            case 1: {
                return new SingletonImmutableList(array[0]);
            }
            default: {
                return new RegularImmutableList(ObjectArrays.checkElementsNotNull((Object[])array.clone()));
            }
        }
    }
    
    private static ImmutableList construct(final Object... array) {
        return asImmutableList(ObjectArrays.checkElementsNotNull(array));
    }
    
    static ImmutableList asImmutableList(final Object[] array) {
        return asImmutableList(array, array.length);
    }
    
    static ImmutableList asImmutableList(Object[] arraysCopy, final int n) {
        switch (n) {
            case 0: {
                return of();
            }
            case 1: {
                return new SingletonImmutableList(arraysCopy[0]);
            }
            default: {
                if (n < arraysCopy.length) {
                    arraysCopy = ObjectArrays.arraysCopyOf(arraysCopy, n);
                }
                return new RegularImmutableList(arraysCopy);
            }
        }
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return this.listIterator();
    }
    
    @Override
    public UnmodifiableListIterator listIterator() {
        return this.listIterator(0);
    }
    
    @Override
    public UnmodifiableListIterator listIterator(final int n) {
        return new ImmutableList$1(this, this.size(), n);
    }
    
    @Override
    public int indexOf(@Nullable final Object o) {
        return (o == null) ? -1 : Lists.indexOfImpl(this, o);
    }
    
    @Override
    public int lastIndexOf(@Nullable final Object o) {
        return (o == null) ? -1 : Lists.lastIndexOfImpl(this, o);
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.indexOf(o) >= 0;
    }
    
    @Override
    public ImmutableList subList(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, this.size());
        final int n3 = n2 - n;
        if (n3 == this.size()) {
            return this;
        }
        switch (n3) {
            case 0: {
                return of();
            }
            case 1: {
                return of(this.get(n));
            }
            default: {
                return this.subListUnchecked(n, n2);
            }
        }
    }
    
    ImmutableList subListUnchecked(final int n, final int n2) {
        return new ImmutableList$SubList(this, n, n2 - n);
    }
    
    @Deprecated
    @Override
    public final boolean addAll(final int n, final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final Object set(final int n, final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final void add(final int n, final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final Object remove(final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final ImmutableList asList() {
        return this;
    }
    
    @Override
    int copyIntoArray(final Object[] array, final int n) {
        final int size = this.size();
        for (int i = 0; i < size; ++i) {
            array[n + i] = this.get(i);
        }
        return n + size;
    }
    
    public ImmutableList reverse() {
        return (this.size() <= 1) ? this : new ImmutableList$ReverseImmutableList(this);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return Lists.equalsImpl(this, o);
    }
    
    @Override
    public int hashCode() {
        int n = 1;
        for (int size = this.size(), i = 0; i < size; ++i) {
            n = ~(~(31 * n + this.get(i).hashCode()));
        }
        return n;
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }
    
    @Override
    Object writeReplace() {
        return new ImmutableList$SerializedForm(this.toArray());
    }
    
    public static ImmutableList$Builder builder() {
        return new ImmutableList$Builder();
    }
}
