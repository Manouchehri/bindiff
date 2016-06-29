package com.google.common.collect;

import java.util.*;

final class Sets$1 extends Sets$SetView
{
    final /* synthetic */ Set val$set1;
    final /* synthetic */ Set val$set2minus1;
    final /* synthetic */ Set val$set2;
    
    Sets$1(final Set val$set1, final Set val$set2minus1, final Set val$set2) {
        this.val$set1 = val$set1;
        this.val$set2minus1 = val$set2minus1;
        this.val$set2 = val$set2;
        super(null);
    }
    
    @Override
    public int size() {
        return this.val$set1.size() + this.val$set2minus1.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.val$set1.isEmpty() && this.val$set2.isEmpty();
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.unmodifiableIterator(Iterators.concat(this.val$set1.iterator(), this.val$set2minus1.iterator()));
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.val$set1.contains(o) || this.val$set2.contains(o);
    }
    
    @Override
    public Set copyInto(final Set set) {
        set.addAll(this.val$set1);
        set.addAll(this.val$set2);
        return set;
    }
    
    @Override
    public ImmutableSet immutableCopy() {
        return new ImmutableSet$Builder().addAll(this.val$set1).addAll(this.val$set2).build();
    }
}
