package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;
import java.io.*;

class LinkedHashMultimap$1 implements Iterator
{
    LinkedHashMultimap$ValueEntry nextEntry;
    LinkedHashMultimap$ValueEntry toRemove;
    final /* synthetic */ LinkedHashMultimap this$0;
    
    LinkedHashMultimap$1(final LinkedHashMultimap this$0) {
        this.this$0 = this$0;
        this.nextEntry = this.this$0.multimapHeaderEntry.successorInMultimap;
    }
    
    @Override
    public boolean hasNext() {
        return this.nextEntry != this.this$0.multimapHeaderEntry;
    }
    
    @Override
    public Map.Entry next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final LinkedHashMultimap$ValueEntry nextEntry = this.nextEntry;
        this.toRemove = nextEntry;
        this.nextEntry = this.nextEntry.successorInMultimap;
        return nextEntry;
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.toRemove != null);
        this.this$0.remove(this.toRemove.getKey(), this.toRemove.getValue());
        this.toRemove = null;
    }
}
