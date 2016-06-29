package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.primitives.*;
import java.io.*;
import java.util.*;
import com.google.common.base.*;

class TreeMultiset$2 implements Iterator
{
    TreeMultiset$AvlNode current;
    Multiset$Entry prevEntry;
    final /* synthetic */ TreeMultiset this$0;
    
    TreeMultiset$2(final TreeMultiset this$0) {
        this.this$0 = this$0;
        this.current = this.this$0.firstNode();
    }
    
    @Override
    public boolean hasNext() {
        if (this.current == null) {
            return false;
        }
        if (this.this$0.range.tooHigh(this.current.getElement())) {
            this.current = null;
            return false;
        }
        return true;
    }
    
    @Override
    public Multiset$Entry next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final Multiset$Entry access$1400 = this.this$0.wrapEntry(this.current);
        this.prevEntry = access$1400;
        if (this.current.succ == this.this$0.header) {
            this.current = null;
        }
        else {
            this.current = this.current.succ;
        }
        return access$1400;
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.prevEntry != null);
        this.this$0.setCount(this.prevEntry.getElement(), 0);
        this.prevEntry = null;
    }
}
