package com.google.protobuf;

import java.util.*;

class UnmodifiableLazyStringList$1 implements ListIterator
{
    ListIterator iter;
    final /* synthetic */ int val$index;
    final /* synthetic */ UnmodifiableLazyStringList this$0;
    
    UnmodifiableLazyStringList$1(final UnmodifiableLazyStringList this$0, final int val$index) {
        this.this$0 = this$0;
        this.val$index = val$index;
        this.iter = this.this$0.list.listIterator(this.val$index);
    }
    
    public boolean hasNext() {
        return this.iter.hasNext();
    }
    
    public String next() {
        return this.iter.next();
    }
    
    public boolean hasPrevious() {
        return this.iter.hasPrevious();
    }
    
    public String previous() {
        return this.iter.previous();
    }
    
    public int nextIndex() {
        return this.iter.nextIndex();
    }
    
    public int previousIndex() {
        return this.iter.previousIndex();
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    public void set(final String s) {
        throw new UnsupportedOperationException();
    }
    
    public void add(final String s) {
        throw new UnsupportedOperationException();
    }
}
