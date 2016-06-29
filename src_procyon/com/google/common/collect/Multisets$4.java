package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

final class Multisets$4 extends AbstractMultiset
{
    final /* synthetic */ Multiset val$multiset1;
    final /* synthetic */ Multiset val$multiset2;
    
    Multisets$4(final Multiset val$multiset1, final Multiset val$multiset2) {
        this.val$multiset1 = val$multiset1;
        this.val$multiset2 = val$multiset2;
    }
    
    @Override
    public int count(@Nullable final Object o) {
        final int count = this.val$multiset1.count(o);
        return (count == 0) ? 0 : Math.max(0, count - this.val$multiset2.count(o));
    }
    
    @Override
    Iterator entryIterator() {
        return new Multisets$4$1(this, this.val$multiset1.entrySet().iterator());
    }
    
    @Override
    int distinctElements() {
        return Iterators.size(this.entryIterator());
    }
}
