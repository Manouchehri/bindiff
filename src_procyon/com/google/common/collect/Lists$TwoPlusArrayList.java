package com.google.common.collect;

import java.io.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.base.*;

class Lists$TwoPlusArrayList extends AbstractList implements Serializable, RandomAccess
{
    final Object first;
    final Object second;
    final Object[] rest;
    private static final long serialVersionUID = 0L;
    
    Lists$TwoPlusArrayList(@Nullable final Object first, @Nullable final Object second, final Object[] array) {
        this.first = first;
        this.second = second;
        this.rest = (Object[])Preconditions.checkNotNull(array);
    }
    
    @Override
    public int size() {
        return this.rest.length + 2;
    }
    
    @Override
    public Object get(final int n) {
        switch (n) {
            case 0: {
                return this.first;
            }
            case 1: {
                return this.second;
            }
            default: {
                Preconditions.checkElementIndex(n, this.size());
                return this.rest[n - 2];
            }
        }
    }
}
