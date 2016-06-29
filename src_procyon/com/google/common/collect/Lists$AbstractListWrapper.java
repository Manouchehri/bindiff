package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class Lists$AbstractListWrapper extends AbstractList
{
    final List backingList;
    
    Lists$AbstractListWrapper(final List list) {
        this.backingList = (List)Preconditions.checkNotNull(list);
    }
    
    @Override
    public void add(final int n, final Object o) {
        this.backingList.add(n, o);
    }
    
    @Override
    public boolean addAll(final int n, final Collection collection) {
        return this.backingList.addAll(n, collection);
    }
    
    @Override
    public Object get(final int n) {
        return this.backingList.get(n);
    }
    
    @Override
    public Object remove(final int n) {
        return this.backingList.remove(n);
    }
    
    @Override
    public Object set(final int n, final Object o) {
        return this.backingList.set(n, o);
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.backingList.contains(o);
    }
    
    @Override
    public int size() {
        return this.backingList.size();
    }
}
