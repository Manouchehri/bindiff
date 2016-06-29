package com.google.common.collect;

import java.util.*;

class ForwardingNavigableMap$StandardDescendingMap$1 implements Iterator
{
    private Map.Entry toRemove;
    private Map.Entry nextOrNull;
    final /* synthetic */ ForwardingNavigableMap$StandardDescendingMap this$1;
    
    ForwardingNavigableMap$StandardDescendingMap$1(final ForwardingNavigableMap$StandardDescendingMap this$1) {
        this.this$1 = this$1;
        this.toRemove = null;
        this.nextOrNull = (Map.Entry)this.this$1.forward().lastEntry();
    }
    
    @Override
    public boolean hasNext() {
        return this.nextOrNull != null;
    }
    
    @Override
    public Map.Entry next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return this.nextOrNull;
        }
        finally {
            this.toRemove = this.nextOrNull;
            this.nextOrNull = (Map.Entry)this.this$1.forward().lowerEntry(this.nextOrNull.getKey());
        }
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.toRemove != null);
        this.this$1.forward().remove(this.toRemove.getKey());
        this.toRemove = null;
    }
}
