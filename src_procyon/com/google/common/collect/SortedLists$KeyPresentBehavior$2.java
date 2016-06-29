package com.google.common.collect;

import java.util.*;

enum SortedLists$KeyPresentBehavior$2
{
    SortedLists$KeyPresentBehavior$2(final String s, final int n) {
    }
    
    @Override
    int resultIndex(final Comparator comparator, final Object o, final List list, final int n) {
        int i = n;
        int n2 = list.size() - 1;
        while (i < n2) {
            final int n3 = i + n2 + 1 >>> 1;
            if (comparator.compare(list.get(n3), o) > 0) {
                n2 = n3 - 1;
            }
            else {
                i = n3;
            }
        }
        return i;
    }
}
