package com.google.common.collect;

import com.google.j2objc.annotations.*;
import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

class ImmutableMultimap$EntryCollection extends ImmutableCollection
{
    @Weak
    final ImmutableMultimap multimap;
    private static final long serialVersionUID = 0L;
    
    ImmutableMultimap$EntryCollection(final ImmutableMultimap multimap) {
        this.multimap = multimap;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return this.multimap.entryIterator();
    }
    
    @Override
    boolean isPartialView() {
        return this.multimap.isPartialView();
    }
    
    @Override
    public int size() {
        return this.multimap.size();
    }
    
    @Override
    public boolean contains(final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }
        return false;
    }
}
