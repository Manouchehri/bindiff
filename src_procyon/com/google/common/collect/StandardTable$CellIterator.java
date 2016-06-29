package com.google.common.collect;

import java.util.*;

class StandardTable$CellIterator implements Iterator
{
    final Iterator rowIterator;
    Map.Entry rowEntry;
    Iterator columnIterator;
    final /* synthetic */ StandardTable this$0;
    
    private StandardTable$CellIterator(final StandardTable this$0) {
        this.this$0 = this$0;
        this.rowIterator = this.this$0.backingMap.entrySet().iterator();
        this.columnIterator = Iterators.emptyModifiableIterator();
    }
    
    @Override
    public boolean hasNext() {
        return this.rowIterator.hasNext() || this.columnIterator.hasNext();
    }
    
    @Override
    public Table$Cell next() {
        if (!this.columnIterator.hasNext()) {
            this.rowEntry = (Map.Entry)this.rowIterator.next();
            this.columnIterator = this.rowEntry.getValue().entrySet().iterator();
        }
        final Map.Entry<Object, V> entry = this.columnIterator.next();
        return Tables.immutableCell(this.rowEntry.getKey(), entry.getKey(), entry.getValue());
    }
    
    @Override
    public void remove() {
        this.columnIterator.remove();
        if (this.rowEntry.getValue().isEmpty()) {
            this.rowIterator.remove();
        }
    }
}
