package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class StandardTable$ColumnMap$ColumnMapValues extends Maps$Values
{
    final /* synthetic */ StandardTable$ColumnMap this$1;
    
    StandardTable$ColumnMap$ColumnMapValues(final StandardTable$ColumnMap this$1) {
        this.this$1 = this$1;
        super(this$1);
    }
    
    @Override
    public boolean remove(final Object o) {
        for (final Map.Entry<K, Map> entry : this.this$1.entrySet()) {
            if (entry.getValue().equals(o)) {
                this.this$1.this$0.removeColumn(entry.getKey());
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean b = false;
        for (final Object next : Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator())) {
            if (collection.contains(this.this$1.this$0.column(next))) {
                this.this$1.this$0.removeColumn(next);
                b = true;
            }
        }
        return b;
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean b = false;
        for (final Object next : Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator())) {
            if (!collection.contains(this.this$1.this$0.column(next))) {
                this.this$1.this$0.removeColumn(next);
                b = true;
            }
        }
        return b;
    }
}
