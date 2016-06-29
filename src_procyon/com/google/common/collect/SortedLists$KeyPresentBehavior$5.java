package com.google.common.collect;

import java.util.*;

enum SortedLists$KeyPresentBehavior$5
{
    SortedLists$KeyPresentBehavior$5(final String s, final int n) {
    }
    
    public int resultIndex(final Comparator comparator, final Object o, final List list, final int n) {
        return SortedLists$KeyPresentBehavior$5.FIRST_PRESENT.resultIndex(comparator, o, list, n) - 1;
    }
}
