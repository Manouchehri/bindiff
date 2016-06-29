package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class StandardTable$Column$EntrySetIterator$1EntryImpl extends AbstractMapEntry
{
    final /* synthetic */ Entry val$entry;
    final /* synthetic */ StandardTable$Column$EntrySetIterator this$2;
    
    StandardTable$Column$EntrySetIterator$1EntryImpl(final StandardTable$Column$EntrySetIterator this$2, final Entry val$entry) {
        this.this$2 = this$2;
        this.val$entry = val$entry;
    }
    
    @Override
    public Object getKey() {
        return this.val$entry.getKey();
    }
    
    @Override
    public Object getValue() {
        return this.val$entry.getValue().get(this.this$2.this$1.columnKey);
    }
    
    @Override
    public Object setValue(final Object o) {
        return this.val$entry.getValue().put(this.this$2.this$1.columnKey, Preconditions.checkNotNull(o));
    }
}
