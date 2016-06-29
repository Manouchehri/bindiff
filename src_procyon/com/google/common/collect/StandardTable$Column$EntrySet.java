package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

class StandardTable$Column$EntrySet extends Sets$ImprovedAbstractSet
{
    final /* synthetic */ StandardTable$Column this$1;
    
    private StandardTable$Column$EntrySet(final StandardTable$Column this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public Iterator iterator() {
        return new StandardTable$Column$EntrySetIterator(this.this$1, null);
    }
    
    @Override
    public int size() {
        int n = 0;
        final Iterator<Map> iterator = this.this$1.this$0.backingMap.values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().containsKey(this.this$1.columnKey)) {
                ++n;
            }
        }
        return n;
    }
    
    @Override
    public boolean isEmpty() {
        return !this.this$1.this$0.containsColumn(this.this$1.columnKey);
    }
    
    @Override
    public void clear() {
        this.this$1.removeFromColumnIf(Predicates.alwaysTrue());
    }
    
    @Override
    public boolean contains(final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            return this.this$1.this$0.containsMapping(entry.getKey(), this.this$1.columnKey, entry.getValue());
        }
        return false;
    }
    
    @Override
    public boolean remove(final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            return this.this$1.this$0.removeMapping(entry.getKey(), this.this$1.columnKey, entry.getValue());
        }
        return false;
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.this$1.removeFromColumnIf(Predicates.not(Predicates.in(collection)));
    }
}
