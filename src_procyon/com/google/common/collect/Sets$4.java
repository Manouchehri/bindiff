package com.google.common.collect;

import java.util.*;

final class Sets$4 extends Sets$SetView
{
    final /* synthetic */ Set val$set1;
    final /* synthetic */ Set val$set2;
    
    Sets$4(final Set val$set1, final Set val$set2) {
        this.val$set1 = val$set1;
        this.val$set2 = val$set2;
        super(null);
    }
    
    @Override
    public Iterator iterator() {
        return new Sets$4$1(this, this.val$set1.iterator(), this.val$set2.iterator());
    }
    
    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }
    
    @Override
    public boolean isEmpty() {
        return this.val$set1.equals(this.val$set2);
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.val$set1.contains(o) ^ this.val$set2.contains(o);
    }
}
