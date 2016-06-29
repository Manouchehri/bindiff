package com.google.common.collect;

import java.util.*;

enum SortedLists$KeyPresentBehavior$4
{
    SortedLists$KeyPresentBehavior$4(final String s, final int n) {
    }
    
    public int resultIndex(final Comparator comparator, final Object o, final List list, final int n) {
        return SortedLists$KeyPresentBehavior$4.LAST_PRESENT.resultIndex(comparator, o, list, n) + 1;
    }
}
