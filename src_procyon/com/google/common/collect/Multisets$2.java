package com.google.common.collect;

import java.util.*;

final class Multisets$2 extends AbstractMultiset
{
    final /* synthetic */ Multiset val$multiset1;
    final /* synthetic */ Multiset val$multiset2;
    
    Multisets$2(final Multiset val$multiset1, final Multiset val$multiset2) {
        this.val$multiset1 = val$multiset1;
        this.val$multiset2 = val$multiset2;
    }
    
    @Override
    public int count(final Object o) {
        final int count = this.val$multiset1.count(o);
        return (count == 0) ? 0 : Math.min(count, this.val$multiset2.count(o));
    }
    
    @Override
    Set createElementSet() {
        return Sets.intersection(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
    }
    
    @Override
    Iterator entryIterator() {
        return new Multisets$2$1(this, this.val$multiset1.entrySet().iterator());
    }
    
    @Override
    int distinctElements() {
        return this.elementSet().size();
    }
}
