package com.google.common.collect;

import java.util.concurrent.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;

final class Maps$4 extends ForwardingNavigableSet
{
    final /* synthetic */ NavigableSet val$set;
    
    Maps$4(final NavigableSet val$set) {
        this.val$set = val$set;
    }
    
    @Override
    protected NavigableSet delegate() {
        return this.val$set;
    }
    
    @Override
    public boolean add(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        return removeOnlySortedSet(super.headSet(o));
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        return removeOnlySortedSet(super.subSet(o, o2));
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        return removeOnlySortedSet(super.tailSet(o));
    }
    
    @Override
    public NavigableSet headSet(final Object o, final boolean b) {
        return removeOnlyNavigableSet(super.headSet(o, b));
    }
    
    @Override
    public NavigableSet tailSet(final Object o, final boolean b) {
        return removeOnlyNavigableSet(super.tailSet(o, b));
    }
    
    @Override
    public NavigableSet subSet(final Object o, final boolean b, final Object o2, final boolean b2) {
        return removeOnlyNavigableSet(super.subSet(o, b, o2, b2));
    }
    
    @Override
    public NavigableSet descendingSet() {
        return removeOnlyNavigableSet(super.descendingSet());
    }
}
