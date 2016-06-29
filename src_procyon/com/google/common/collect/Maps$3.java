package com.google.common.collect;

import java.util.concurrent.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;

final class Maps$3 extends ForwardingSortedSet
{
    final /* synthetic */ SortedSet val$set;
    
    Maps$3(final SortedSet val$set) {
        this.val$set = val$set;
    }
    
    @Override
    protected SortedSet delegate() {
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
}
