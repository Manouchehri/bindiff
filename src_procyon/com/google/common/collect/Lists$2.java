package com.google.common.collect;

import java.util.*;

final class Lists$2 extends Lists$AbstractListWrapper
{
    private static final long serialVersionUID = 0L;
    
    Lists$2(final List list) {
        super(list);
    }
    
    @Override
    public ListIterator listIterator(final int n) {
        return this.backingList.listIterator(n);
    }
}
