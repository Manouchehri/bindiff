package com.google.common.base;

import java.util.*;

enum Pair$SecondComparator implements Comparator
{
    SECOND_COMPARATOR("SECOND_COMPARATOR", 0);
    
    private Pair$SecondComparator(final String s, final int n) {
    }
    
    public int compare(final Pair pair, final Pair pair2) {
        return ((Comparable)pair.getSecond()).compareTo(pair2.getSecond());
    }
}
