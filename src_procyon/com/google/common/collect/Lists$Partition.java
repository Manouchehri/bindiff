package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;
import java.math.*;
import com.google.common.math.*;

class Lists$Partition extends AbstractList
{
    final List list;
    final int size;
    
    Lists$Partition(final List list, final int size) {
        this.list = list;
        this.size = size;
    }
    
    @Override
    public List get(final int n) {
        Preconditions.checkElementIndex(n, this.size());
        final int n2 = n * this.size;
        return this.list.subList(n2, Math.min(n2 + this.size, this.list.size()));
    }
    
    @Override
    public int size() {
        return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
    }
    
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
