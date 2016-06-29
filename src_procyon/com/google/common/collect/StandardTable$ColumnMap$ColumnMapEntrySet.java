package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class StandardTable$ColumnMap$ColumnMapEntrySet extends StandardTable$TableSet
{
    final /* synthetic */ StandardTable$ColumnMap this$1;
    
    StandardTable$ColumnMap$ColumnMapEntrySet(final StandardTable$ColumnMap this$1) {
        this.this$1 = this$1;
        super(this$1.this$0, null);
    }
    
    @Override
    public Iterator iterator() {
        return Maps.asMapEntryIterator(this.this$1.this$0.columnKeySet(), new StandardTable$ColumnMap$ColumnMapEntrySet$1(this));
    }
    
    @Override
    public int size() {
        return this.this$1.this$0.columnKeySet().size();
    }
    
    @Override
    public boolean contains(final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            if (this.this$1.this$0.containsColumn(entry.getKey())) {
                return this.this$1.get(entry.getKey()).equals(entry.getValue());
            }
        }
        return false;
    }
    
    @Override
    public boolean remove(final Object o) {
        if (this.contains(o)) {
            this.this$1.this$0.removeColumn(((Map.Entry)o).getKey());
            return true;
        }
        return false;
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        Preconditions.checkNotNull(collection);
        return Sets.removeAllImpl(this, collection.iterator());
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean b = false;
        for (final Object next : Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator())) {
            if (!collection.contains(Maps.immutableEntry(next, this.this$1.this$0.column(next)))) {
                this.this$1.this$0.removeColumn(next);
                b = true;
            }
        }
        return b;
    }
}
