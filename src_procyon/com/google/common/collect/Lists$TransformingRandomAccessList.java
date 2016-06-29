package com.google.common.collect;

import java.io.*;
import com.google.common.base.*;
import java.util.*;

class Lists$TransformingRandomAccessList extends AbstractList implements Serializable, RandomAccess
{
    final List fromList;
    final Function function;
    private static final long serialVersionUID = 0L;
    
    Lists$TransformingRandomAccessList(final List list, final Function function) {
        this.fromList = (List)Preconditions.checkNotNull(list);
        this.function = (Function)Preconditions.checkNotNull(function);
    }
    
    @Override
    public void clear() {
        this.fromList.clear();
    }
    
    @Override
    public Object get(final int n) {
        return this.function.apply(this.fromList.get(n));
    }
    
    @Override
    public Iterator iterator() {
        return this.listIterator();
    }
    
    @Override
    public ListIterator listIterator(final int n) {
        return new Lists$TransformingRandomAccessList$1(this, this.fromList.listIterator(n));
    }
    
    @Override
    public boolean isEmpty() {
        return this.fromList.isEmpty();
    }
    
    @Override
    public Object remove(final int n) {
        return this.function.apply(this.fromList.remove(n));
    }
    
    @Override
    public int size() {
        return this.fromList.size();
    }
}
