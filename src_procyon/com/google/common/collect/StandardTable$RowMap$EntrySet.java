package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class StandardTable$RowMap$EntrySet extends StandardTable$TableSet
{
    final /* synthetic */ StandardTable$RowMap this$1;
    
    StandardTable$RowMap$EntrySet(final StandardTable$RowMap this$1) {
        this.this$1 = this$1;
        super(this$1.this$0, null);
    }
    
    @Override
    public Iterator iterator() {
        return Maps.asMapEntryIterator(this.this$1.this$0.backingMap.keySet(), new StandardTable$RowMap$EntrySet$1(this));
    }
    
    @Override
    public int size() {
        return this.this$1.this$0.backingMap.size();
    }
    
    @Override
    public boolean contains(final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            return entry.getKey() != null && entry.getValue() instanceof Map && Collections2.safeContains(this.this$1.this$0.backingMap.entrySet(), entry);
        }
        return false;
    }
    
    @Override
    public boolean remove(final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            return entry.getKey() != null && entry.getValue() instanceof Map && this.this$1.this$0.backingMap.entrySet().remove(entry);
        }
        return false;
    }
}
