package com.google.common.collect;

import java.io.*;
import com.google.common.base.*;
import java.util.*;

class Lists$TransformingSequentialList extends AbstractSequentialList implements Serializable
{
    final List fromList;
    final Function function;
    private static final long serialVersionUID = 0L;
    
    Lists$TransformingSequentialList(final List list, final Function function) {
        this.fromList = (List)Preconditions.checkNotNull(list);
        this.function = (Function)Preconditions.checkNotNull(function);
    }
    
    @Override
    public void clear() {
        this.fromList.clear();
    }
    
    @Override
    public int size() {
        return this.fromList.size();
    }
    
    @Override
    public ListIterator listIterator(final int n) {
        return new Lists$TransformingSequentialList$1(this, this.fromList.listIterator(n));
    }
}
