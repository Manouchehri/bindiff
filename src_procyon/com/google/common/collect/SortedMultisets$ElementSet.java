package com.google.common.collect;

import com.google.j2objc.annotations.*;
import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;

class SortedMultisets$ElementSet extends Multisets$ElementSet implements SortedSet
{
    @Weak
    private final SortedMultiset multiset;
    
    SortedMultisets$ElementSet(final SortedMultiset multiset) {
        this.multiset = multiset;
    }
    
    @Override
    final SortedMultiset multiset() {
        return this.multiset;
    }
    
    @Override
    public Comparator comparator() {
        return this.multiset().comparator();
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        return this.multiset().subMultiset(o, BoundType.CLOSED, o2, BoundType.OPEN).elementSet();
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        return this.multiset().headMultiset(o, BoundType.OPEN).elementSet();
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        return this.multiset().tailMultiset(o, BoundType.CLOSED).elementSet();
    }
    
    @Override
    public Object first() {
        return getElementOrThrow(this.multiset().firstEntry());
    }
    
    @Override
    public Object last() {
        return getElementOrThrow(this.multiset().lastEntry());
    }
}
