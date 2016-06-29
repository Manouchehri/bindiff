package com.google.common.primitives;

import java.util.*;

enum UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator implements Comparator
{
    INSTANCE("INSTANCE", 0);
    
    private UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator(final String s, final int n) {
    }
    
    public int compare(final byte[] array, final byte[] array2) {
        for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
            final int compare = UnsignedBytes.compare(array[i], array2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return array.length - array2.length;
    }
}
