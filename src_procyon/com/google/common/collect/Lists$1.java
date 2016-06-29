package com.google.common.collect;

import java.util.*;

final class Lists$1 extends Lists$RandomAccessListWrapper
{
    private static final long serialVersionUID = 0L;
    
    Lists$1(final List list) {
        super(list);
    }
    
    @Override
    public ListIterator listIterator(final int n) {
        return this.backingList.listIterator(n);
    }
}
