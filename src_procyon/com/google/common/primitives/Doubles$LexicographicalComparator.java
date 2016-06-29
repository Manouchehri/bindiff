package com.google.common.primitives;

import java.util.*;

enum Doubles$LexicographicalComparator implements Comparator
{
    INSTANCE("INSTANCE", 0);
    
    private Doubles$LexicographicalComparator(final String s, final int n) {
    }
    
    public int compare(final double[] array, final double[] array2) {
        for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
            final int compare = Double.compare(array[i], array2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return array.length - array2.length;
    }
}
