package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.errorprone.annotations.concurrent.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
final class ImmutableEnumSet extends ImmutableSet
{
    private final transient EnumSet delegate;
    @LazyInit
    private transient int hashCode;
    
    static ImmutableSet asImmutable(final EnumSet set) {
        switch (set.size()) {
            case 0: {
                return ImmutableSet.of();
            }
            case 1: {
                return ImmutableSet.of(Iterables.getOnlyElement(set));
            }
            default: {
                return new ImmutableEnumSet(set);
            }
        }
    }
    
    private ImmutableEnumSet(final EnumSet delegate) {
        this.delegate = delegate;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return Iterators.unmodifiableIterator(this.delegate.iterator());
    }
    
    @Override
    public int size() {
        return this.delegate.size();
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.delegate.contains(o);
    }
    
    @Override
    public boolean containsAll(Collection delegate) {
        if (delegate instanceof ImmutableEnumSet) {
            delegate = ((ImmutableEnumSet)delegate).delegate;
        }
        return this.delegate.containsAll(delegate);
    }
    
    @Override
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }
    
    @Override
    public boolean equals(Object delegate) {
        if (delegate == this) {
            return true;
        }
        if (delegate instanceof ImmutableEnumSet) {
            delegate = ((ImmutableEnumSet)delegate).delegate;
        }
        return this.delegate.equals(delegate);
    }
    
    @Override
    boolean isHashCodeFast() {
        return true;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.hashCode;
        return (hashCode == 0) ? (this.hashCode = this.delegate.hashCode()) : hashCode;
    }
    
    @Override
    public String toString() {
        return this.delegate.toString();
    }
    
    @Override
    Object writeReplace() {
        return new ImmutableEnumSet$EnumSerializedForm(this.delegate);
    }
}
