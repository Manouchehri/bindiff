package com.google.common.primitives;

import java.util.*;

enum Ints$LexicographicalComparator implements Comparator
{
    INSTANCE("INSTANCE", 0);
    
    private Ints$LexicographicalComparator(final String s, final int n) {
    }
    
    public int compare(final int[] array, final int[] array2) {
        for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
            final int compare = Ints.compare(array[i], array2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return array.length - array2.length;
    }
}
