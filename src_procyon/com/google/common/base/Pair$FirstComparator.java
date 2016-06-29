package com.google.common.base;

import java.util.*;

enum Pair$FirstComparator implements Comparator
{
    FIRST_COMPARATOR("FIRST_COMPARATOR", 0);
    
    private Pair$FirstComparator(final String s, final int n) {
    }
    
    public int compare(final Pair pair, final Pair pair2) {
        return ((Comparable)pair.getFirst()).compareTo(pair2.getFirst());
    }
}
