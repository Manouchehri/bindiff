package com.google.common.collect;

import java.util.*;

class StandardTable$ColumnKeyIterator extends AbstractIterator
{
    final Map seen;
    final Iterator mapIterator;
    Iterator entryIterator;
    final /* synthetic */ StandardTable this$0;
    
    private StandardTable$ColumnKeyIterator(final StandardTable this$0) {
        this.this$0 = this$0;
        this.seen = (Map)this.this$0.factory.get();
        this.mapIterator = this.this$0.backingMap.values().iterator();
        this.entryIterator = Iterators.emptyIterator();
    }
    
    @Override
    protected Object computeNext() {
        while (true) {
            if (this.entryIterator.hasNext()) {
                final Map.Entry<Object, V> entry = this.entryIterator.next();
                if (!this.seen.containsKey(entry.getKey())) {
                    this.seen.put(entry.getKey(), entry.getValue());
                    return entry.getKey();
                }
                continue;
            }
            else {
                if (!this.mapIterator.hasNext()) {
                    return this.endOfData();
                }
                this.entryIterator = this.mapIterator.next().entrySet().iterator();
            }
        }
    }
}
