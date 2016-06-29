package com.google.common.collect;

import com.google.j2objc.annotations.*;
import javax.annotation.*;
import java.io.*;
import com.google.common.annotations.*;
import java.util.*;

final class ImmutableSetMultimap$EntrySet extends ImmutableSet
{
    @Weak
    private final transient ImmutableSetMultimap multimap;
    
    ImmutableSetMultimap$EntrySet(final ImmutableSetMultimap multimap) {
        this.multimap = multimap;
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }
        return false;
    }
    
    @Override
    public int size() {
        return this.multimap.size();
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return this.multimap.entryIterator();
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
}
