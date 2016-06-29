package com.google.common.collect;

import com.google.j2objc.annotations.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

final class ImmutableMultimap$Values extends ImmutableCollection
{
    @Weak
    private final transient ImmutableMultimap multimap;
    private static final long serialVersionUID = 0L;
    
    ImmutableMultimap$Values(final ImmutableMultimap multimap) {
        this.multimap = multimap;
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.multimap.containsValue(o);
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return this.multimap.valueIterator();
    }
    
    @GwtIncompatible("not present in emulated superclass")
    @Override
    int copyIntoArray(final Object[] array, int copyIntoArray) {
        final UnmodifiableIterator iterator = this.multimap.map.values().iterator();
        while (iterator.hasNext()) {
            copyIntoArray = iterator.next().copyIntoArray(array, copyIntoArray);
        }
        return copyIntoArray;
    }
    
    @Override
    public int size() {
        return this.multimap.size();
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
}
