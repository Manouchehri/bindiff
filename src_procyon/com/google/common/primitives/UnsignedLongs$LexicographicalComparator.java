package com.google.common.primitives;

import java.util.*;

enum UnsignedLongs$LexicographicalComparator implements Comparator
{
    INSTANCE("INSTANCE", 0);
    
    private UnsignedLongs$LexicographicalComparator(final String s, final int n) {
    }
    
    public int compare(final long[] array, final long[] array2) {
        for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
            if (array[i] != array2[i]) {
                return UnsignedLongs.compare(array[i], array2[i]);
            }
        }
        return array.length - array2.length;
    }
}
