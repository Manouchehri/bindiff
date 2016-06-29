package com.google.common.collect;

import java.io.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.base.*;

class Lists$OnePlusArrayList extends AbstractList implements Serializable, RandomAccess
{
    final Object first;
    final Object[] rest;
    private static final long serialVersionUID = 0L;
    
    Lists$OnePlusArrayList(@Nullable final Object first, final Object[] array) {
        this.first = first;
        this.rest = (Object[])Preconditions.checkNotNull(array);
    }
    
    @Override
    public int size() {
        return this.rest.length + 1;
    }
    
    @Override
    public Object get(final int n) {
        Preconditions.checkElementIndex(n, this.size());
        return (n == 0) ? this.first : this.rest[n - 1];
    }
}
