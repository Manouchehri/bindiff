package com.google.common.collect;

import java.util.*;

class StandardTable$Column$EntrySetIterator extends AbstractIterator
{
    final Iterator iterator;
    final /* synthetic */ StandardTable$Column this$1;
    
    private StandardTable$Column$EntrySetIterator(final StandardTable$Column this$1) {
        this.this$1 = this$1;
        this.iterator = this.this$1.this$0.backingMap.entrySet().iterator();
    }
    
    @Override
    protected Map.Entry computeNext() {
        while (this.iterator.hasNext()) {
            final Map.Entry<K, Map> entry = this.iterator.next();
            if (entry.getValue().containsKey(this.this$1.columnKey)) {
                return new StandardTable$Column$EntrySetIterator$1EntryImpl(this, (Map.Entry)entry);
            }
        }
        return (Map.Entry)this.endOfData();
    }
}
