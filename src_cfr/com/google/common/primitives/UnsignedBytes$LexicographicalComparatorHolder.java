/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

@VisibleForTesting
class UnsignedBytes$LexicographicalComparatorHolder {
    static final String UNSAFE_COMPARATOR_NAME = String.valueOf(UnsignedBytes$LexicographicalComparatorHolder.class.getName()).concat("$UnsafeComparator");
    static final Comparator BEST_COMPARATOR = UnsignedBytes$LexicographicalComparatorHolder.getBestComparator();

    UnsignedBytes$LexicographicalComparatorHolder() {
    }

    static Comparator getBestComparator() {
        try {
            Class class_ = Class.forName(UNSAFE_COMPARATOR_NAME);
            return (Comparator)class_.getEnumConstants()[0];
        }
        catch (Throwable var0_1) {
            return UnsignedBytes.lexicographicalComparatorJavaImpl();
        }
    }
}

