package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

class LinkedHashMultimap$ValueSet$1 implements Iterator
{
    LinkedHashMultimap$ValueSetLink nextEntry;
    LinkedHashMultimap$ValueEntry toRemove;
    int expectedModCount;
    final /* synthetic */ LinkedHashMultimap$ValueSet this$1;
    
    LinkedHashMultimap$ValueSet$1(final LinkedHashMultimap$ValueSet this$1) {
        this.this$1 = this$1;
        this.nextEntry = this.this$1.firstEntry;
        this.expectedModCount = this.this$1.modCount;
    }
    
    private void checkForComodification() {
        if (this.this$1.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
    
    @Override
    public boolean hasNext() {
        this.checkForComodification();
        return this.nextEntry != this.this$1;
    }
    
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final LinkedHashMultimap$ValueEntry toRemove = (LinkedHashMultimap$ValueEntry)this.nextEntry;
        final Object value = toRemove.getValue();
        this.toRemove = toRemove;
        this.nextEntry = toRemove.getSuccessorInValueSet();
        return value;
    }
    
    @Override
    public void remove() {
        this.checkForComodification();
        CollectPreconditions.checkRemove(this.toRemove != null);
        this.this$1.remove(this.toRemove.getValue());
        this.expectedModCount = this.this$1.modCount;
        this.toRemove = null;
    }
}
