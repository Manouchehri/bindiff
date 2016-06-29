package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Sets$3 extends Sets$SetView
{
    final /* synthetic */ Set val$set1;
    final /* synthetic */ Predicate val$notInSet2;
    final /* synthetic */ Set val$set2;
    
    Sets$3(final Set val$set1, final Predicate val$notInSet2, final Set val$set2) {
        this.val$set1 = val$set1;
        this.val$notInSet2 = val$notInSet2;
        this.val$set2 = val$set2;
        super(null);
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.filter(this.val$set1.iterator(), this.val$notInSet2);
    }
    
    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }
    
    @Override
    public boolean isEmpty() {
        return this.val$set2.containsAll(this.val$set1);
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.val$set1.contains(o) && !this.val$set2.contains(o);
    }
}
