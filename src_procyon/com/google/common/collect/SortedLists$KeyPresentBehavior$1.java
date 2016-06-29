package com.google.common.collect;

import java.util.*;

enum SortedLists$KeyPresentBehavior$1
{
    SortedLists$KeyPresentBehavior$1(final String s, final int n) {
    }
    
    @Override
    int resultIndex(final Comparator comparator, final Object o, final List list, final int n) {
        return n;
    }
}
