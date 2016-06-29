/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
@Beta
public final class SortedLists {
    private SortedLists() {
    }

    public static int binarySearch(List list, Comparable comparable, SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        Preconditions.checkNotNull(comparable);
        return SortedLists.binarySearch(list, comparable, Ordering.natural(), sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
    }

    public static int binarySearch(List list, Function function, @Nullable Comparable comparable, SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        return SortedLists.binarySearch(list, function, comparable, Ordering.natural(), sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
    }

    public static int binarySearch(List list, Function function, @Nullable Object object, Comparator comparator, SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        return SortedLists.binarySearch(Lists.transform(list, function), object, comparator, sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
    }

    public static int binarySearch(List list, @Nullable Object object, Comparator comparator, SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull((Object)sortedLists$KeyPresentBehavior);
        Preconditions.checkNotNull((Object)sortedLists$KeyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.newArrayList(list);
        }
        int n2 = 0;
        int n3 = list.size() - 1;
        while (n2 <= n3) {
            int n4 = n2 + n3 >>> 1;
            int n5 = comparator.compare(object, list.get(n4));
            if (n5 < 0) {
                n3 = n4 - 1;
                continue;
            }
            if (n5 <= 0) return n2 + sortedLists$KeyPresentBehavior.resultIndex(comparator, object, list.subList(n2, n3 + 1), n4 - n2);
            n2 = n4 + 1;
        }
        return sortedLists$KeyAbsentBehavior.resultIndex(n2);
    }
}

