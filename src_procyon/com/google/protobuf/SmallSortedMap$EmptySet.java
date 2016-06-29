package com.google.protobuf;

import java.util.*;

class SmallSortedMap$EmptySet
{
    private static final Iterator ITERATOR;
    private static final Iterable ITERABLE;
    
    static Iterable iterable() {
        return SmallSortedMap$EmptySet.ITERABLE;
    }
    
    static {
        ITERATOR = new SmallSortedMap$EmptySet$1();
        ITERABLE = new SmallSortedMap$EmptySet$2();
    }
}
