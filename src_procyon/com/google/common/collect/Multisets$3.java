package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

final class Multisets$3 extends AbstractMultiset
{
    final /* synthetic */ Multiset val$multiset1;
    final /* synthetic */ Multiset val$multiset2;
    
    Multisets$3(final Multiset val$multiset1, final Multiset val$multiset2) {
        this.val$multiset1 = val$multiset1;
        this.val$multiset2 = val$multiset2;
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.val$multiset1.contains(o) || this.val$multiset2.contains(o);
    }
    
    @Override
    public boolean isEmpty() {
        return this.val$multiset1.isEmpty() && this.val$multiset2.isEmpty();
    }
    
    @Override
    public int size() {
        return this.val$multiset1.size() + this.val$multiset2.size();
    }
    
    @Override
    public int count(final Object o) {
        return this.val$multiset1.count(o) + this.val$multiset2.count(o);
    }
    
    @Override
    Set createElementSet() {
        return Sets.union(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
    }
    
    @Override
    Iterator entryIterator() {
        return new Multisets$3$1(this, this.val$multiset1.entrySet().iterator(), this.val$multiset2.entrySet().iterator());
    }
    
    @Override
    int distinctElements() {
        return this.elementSet().size();
    }
}
