package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

@GwtCompatible(serializable = true, emulated = true)
final class ImmutableEnumMap extends ImmutableMap$IteratorBasedImmutableMap
{
    private final transient EnumMap delegate;
    
    static ImmutableMap asImmutable(final EnumMap enumMap) {
        switch (enumMap.size()) {
            case 0: {
                return ImmutableMap.of();
            }
            case 1: {
                final Entry entry = (Entry)Iterables.getOnlyElement(enumMap.entrySet());
                return ImmutableMap.of(entry.getKey(), entry.getValue());
            }
            default: {
                return new ImmutableEnumMap(enumMap);
            }
        }
    }
    
    private ImmutableEnumMap(final EnumMap delegate) {
        this.delegate = delegate;
        Preconditions.checkArgument(!delegate.isEmpty());
    }
    
    @Override
    UnmodifiableIterator keyIterator() {
        return Iterators.unmodifiableIterator(this.delegate.keySet().iterator());
    }
    
    @Override
    public int size() {
        return this.delegate.size();
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.delegate.containsKey(o);
    }
    
    @Override
    public Object get(final Object o) {
        return this.delegate.get(o);
    }
    
    @Override
    public boolean equals(Object delegate) {
        if (delegate == this) {
            return true;
        }
        if (delegate instanceof ImmutableEnumMap) {
            delegate = ((ImmutableEnumMap)delegate).delegate;
        }
        return this.delegate.equals(delegate);
    }
    
    @Override
    UnmodifiableIterator entryIterator() {
        return Maps.unmodifiableEntryIterator(this.delegate.entrySet().iterator());
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    Object writeReplace() {
        return new ImmutableEnumMap$EnumSerializedForm(this.delegate);
    }
}
