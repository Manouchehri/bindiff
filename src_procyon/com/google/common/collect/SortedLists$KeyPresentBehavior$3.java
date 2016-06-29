package com.google.common.collect;

import java.util.*;

enum SortedLists$KeyPresentBehavior$3
{
    SortedLists$KeyPresentBehavior$3(final String s, final int n) {
    }
    
    @Override
    int resultIndex(final Comparator comparator, final Object o, final List list, final int n) {
        int i = 0;
        int n2 = n;
        while (i < n2) {
            final int n3 = i + n2 >>> 1;
            if (comparator.compare(list.get(n3), o) < 0) {
                i = n3 + 1;
            }
            else {
                n2 = n3;
            }
        }
        return i;
    }
}
