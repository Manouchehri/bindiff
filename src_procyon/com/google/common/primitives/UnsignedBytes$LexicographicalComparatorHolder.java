package com.google.common.primitives;

import com.google.common.annotations.*;
import java.util.*;

@VisibleForTesting
class UnsignedBytes$LexicographicalComparatorHolder
{
    static final String UNSAFE_COMPARATOR_NAME;
    static final Comparator BEST_COMPARATOR;
    
    static Comparator getBestComparator() {
        try {
            return (Comparator)Class.forName(UnsignedBytes$LexicographicalComparatorHolder.UNSAFE_COMPARATOR_NAME).getEnumConstants()[0];
        }
        catch (Throwable t) {
            return UnsignedBytes.lexicographicalComparatorJavaImpl();
        }
    }
    
    static {
        UNSAFE_COMPARATOR_NAME = String.valueOf(UnsignedBytes$LexicographicalComparatorHolder.class.getName()).concat("$UnsafeComparator");
        BEST_COMPARATOR = getBestComparator();
    }
}
