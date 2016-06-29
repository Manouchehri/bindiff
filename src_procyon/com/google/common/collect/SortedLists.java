package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
@Beta
public final class SortedLists
{
    public static int binarySearch(final List list, final Comparable comparable, final SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, final SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        Preconditions.checkNotNull(comparable);
        return binarySearch(list, comparable, Ordering.natural(), sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
    }
    
    public static int binarySearch(final List list, final Function function, @Nullable final Comparable comparable, final SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, final SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        return binarySearch(list, function, comparable, Ordering.natural(), sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
    }
    
    public static int binarySearch(final List list, final Function function, @Nullable final Object o, final Comparator comparator, final SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, final SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        return binarySearch(Lists.transform(list, function), o, comparator, sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
    }
    
    public static int binarySearch(List arrayList, @Nullable final Object o, final Comparator comparator, final SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, final SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(arrayList);
        Preconditions.checkNotNull(sortedLists$KeyPresentBehavior);
        Preconditions.checkNotNull(sortedLists$KeyAbsentBehavior);
        if (!(arrayList instanceof RandomAccess)) {
            arrayList = Lists.newArrayList(arrayList);
        }
        int i = 0;
        int n = arrayList.size() - 1;
        while (i <= n) {
            final int n2 = i + n >>> 1;
            final int compare = comparator.compare(o, arrayList.get(n2));
            if (compare < 0) {
                n = n2 - 1;
            }
            else {
                if (compare <= 0) {
                    return i + sortedLists$KeyPresentBehavior.resultIndex(comparator, o, arrayList.subList(i, n + 1), n2 - i);
                }
                i = n2 + 1;
            }
        }
        return sortedLists$KeyAbsentBehavior.resultIndex(i);
    }
}
