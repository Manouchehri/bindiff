/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.CartesianList;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists$1;
import com.google.common.collect.Lists$2;
import com.google.common.collect.Lists$AbstractListWrapper;
import com.google.common.collect.Lists$CharSequenceAsList;
import com.google.common.collect.Lists$OnePlusArrayList;
import com.google.common.collect.Lists$Partition;
import com.google.common.collect.Lists$RandomAccessPartition;
import com.google.common.collect.Lists$RandomAccessReverseList;
import com.google.common.collect.Lists$ReverseList;
import com.google.common.collect.Lists$StringAsImmutableList;
import com.google.common.collect.Lists$TransformingRandomAccessList;
import com.google.common.collect.Lists$TransformingSequentialList;
import com.google.common.collect.Lists$TwoPlusArrayList;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class Lists {
    private Lists() {
    }

    @GwtCompatible(serializable=1)
    public static ArrayList newArrayList() {
        return new ArrayList();
    }

    @GwtCompatible(serializable=1)
    public static /* varargs */ ArrayList newArrayList(Object ... arrobject) {
        Preconditions.checkNotNull(arrobject);
        int n2 = Lists.computeArrayListCapacity(arrobject.length);
        ArrayList arrayList = new ArrayList(n2);
        Collections.addAll(arrayList, arrobject);
        return arrayList;
    }

    @VisibleForTesting
    static int computeArrayListCapacity(int n2) {
        CollectPreconditions.checkNonnegative(n2, "arraySize");
        return Ints.saturatedCast(5 + (long)n2 + (long)(n2 / 10));
    }

    @GwtCompatible(serializable=1)
    public static ArrayList newArrayList(Iterable iterable) {
        ArrayList arrayList;
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            arrayList = new ArrayList(Collections2.cast(iterable));
            return arrayList;
        }
        arrayList = Lists.newArrayList(iterable.iterator());
        return arrayList;
    }

    @GwtCompatible(serializable=1)
    public static ArrayList newArrayList(Iterator iterator) {
        ArrayList arrayList = Lists.newArrayList();
        Iterators.addAll(arrayList, iterator);
        return arrayList;
    }

    @GwtCompatible(serializable=1)
    public static ArrayList newArrayListWithCapacity(int n2) {
        CollectPreconditions.checkNonnegative(n2, "initialArraySize");
        return new ArrayList(n2);
    }

    @GwtCompatible(serializable=1)
    public static ArrayList newArrayListWithExpectedSize(int n2) {
        return new ArrayList(Lists.computeArrayListCapacity(n2));
    }

    @GwtCompatible(serializable=1)
    public static LinkedList newLinkedList() {
        return new LinkedList();
    }

    @GwtCompatible(serializable=1)
    @GoogleInternal
    public static /* varargs */ LinkedList newLinkedList(Object ... arrobject) {
        LinkedList linkedList = Lists.newLinkedList();
        Collections.addAll(linkedList, arrobject);
        return linkedList;
    }

    @GwtCompatible(serializable=1)
    public static LinkedList newLinkedList(Iterable iterable) {
        LinkedList linkedList = Lists.newLinkedList();
        Iterables.addAll(linkedList, iterable);
        return linkedList;
    }

    @GwtCompatible(serializable=1)
    @GoogleInternal
    public static LinkedList newLinkedList(Iterator iterator) {
        LinkedList linkedList = Lists.newLinkedList();
        Iterators.addAll(linkedList, iterator);
        return linkedList;
    }

    @GwtIncompatible(value="CopyOnWriteArrayList")
    public static CopyOnWriteArrayList newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList();
    }

    @GwtIncompatible(value="CopyOnWriteArrayList")
    public static CopyOnWriteArrayList newCopyOnWriteArrayList(Iterable iterable) {
        Collection collection = iterable instanceof Collection ? Collections2.cast(iterable) : Lists.newArrayList(iterable);
        return new CopyOnWriteArrayList(collection);
    }

    public static List asList(@Nullable Object object, Object[] arrobject) {
        return new Lists$OnePlusArrayList(object, arrobject);
    }

    public static List asList(@Nullable Object object, @Nullable Object object2, Object[] arrobject) {
        return new Lists$TwoPlusArrayList(object, object2, arrobject);
    }

    public static List cartesianProduct(List list) {
        return CartesianList.create(list);
    }

    public static /* varargs */ List cartesianProduct(List ... arrlist) {
        return Lists.cartesianProduct(Arrays.asList(arrlist));
    }

    @CheckReturnValue
    public static List transform(List list, Function function) {
        Lists$TransformingRandomAccessList lists$TransformingRandomAccessList /* !! */ ;
        if (list instanceof RandomAccess) {
            lists$TransformingRandomAccessList /* !! */  = new Lists$TransformingRandomAccessList(list, function);
            return lists$TransformingRandomAccessList /* !! */ ;
        }
        lists$TransformingRandomAccessList /* !! */  = new Lists$TransformingSequentialList(list, function);
        return lists$TransformingRandomAccessList /* !! */ ;
    }

    public static List partition(List list, int n2) {
        Lists$RandomAccessPartition lists$RandomAccessPartition /* !! */ ;
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(n2 > 0);
        if (list instanceof RandomAccess) {
            lists$RandomAccessPartition /* !! */  = new Lists$RandomAccessPartition(list, n2);
            return lists$RandomAccessPartition /* !! */ ;
        }
        lists$RandomAccessPartition /* !! */  = new Lists$Partition(list, n2);
        return lists$RandomAccessPartition /* !! */ ;
    }

    @Beta
    public static ImmutableList charactersOf(String string) {
        return new Lists$StringAsImmutableList((String)Preconditions.checkNotNull(string));
    }

    @Beta
    public static List charactersOf(CharSequence charSequence) {
        return new Lists$CharSequenceAsList((CharSequence)Preconditions.checkNotNull(charSequence));
    }

    @CheckReturnValue
    public static List reverse(List list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList)list).reverse();
        }
        if (list instanceof Lists$ReverseList) {
            return ((Lists$ReverseList)list).getForwardList();
        }
        if (!(list instanceof RandomAccess)) return new Lists$ReverseList(list);
        return new Lists$RandomAccessReverseList(list);
    }

    static int hashCodeImpl(List list) {
        int n2 = 1;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            n2 = 31 * n2 + (e2 == null ? 0 : e2.hashCode());
            n2 = ~ (~ n2);
        }
        return n2;
    }

    static boolean equalsImpl(List list, @Nullable Object object) {
        if (object == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(object instanceof List)) {
            return false;
        }
        List list2 = (List)object;
        int n2 = list.size();
        if (n2 != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess)) return Iterators.elementsEqual(list.iterator(), list2.iterator());
        if (!(list2 instanceof RandomAccess)) return Iterators.elementsEqual(list.iterator(), list2.iterator());
        int n3 = 0;
        while (n3 < n2) {
            if (!Objects.equal(list.get(n3), list2.get(n3))) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    static boolean addAllImpl(List list, int n2, Iterable iterable) {
        boolean bl2 = false;
        ListIterator listIterator = list.listIterator(n2);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            listIterator.add(t2);
            bl2 = true;
        }
        return bl2;
    }

    static int indexOfImpl(List list, @Nullable Object object) {
        if (list instanceof RandomAccess) {
            return Lists.indexOfRandomAccess(list, object);
        }
        ListIterator listIterator = list.listIterator();
        do {
            if (!listIterator.hasNext()) return -1;
        } while (!Objects.equal(object, listIterator.next()));
        return listIterator.previousIndex();
    }

    private static int indexOfRandomAccess(List list, @Nullable Object object) {
        int n2 = list.size();
        if (object == null) {
            int n3 = 0;
            while (n3 < n2) {
                if (list.get(n3) == null) {
                    return n3;
                }
                ++n3;
            }
            return -1;
        }
        int n4 = 0;
        while (n4 < n2) {
            if (object.equals(list.get(n4))) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    static int lastIndexOfImpl(List list, @Nullable Object object) {
        if (list instanceof RandomAccess) {
            return Lists.lastIndexOfRandomAccess(list, object);
        }
        ListIterator listIterator = list.listIterator(list.size());
        do {
            if (!listIterator.hasPrevious()) return -1;
        } while (!Objects.equal(object, listIterator.previous()));
        return listIterator.nextIndex();
    }

    private static int lastIndexOfRandomAccess(List list, @Nullable Object object) {
        if (object == null) {
            int n2 = list.size() - 1;
            while (n2 >= 0) {
                if (list.get(n2) == null) {
                    return n2;
                }
                --n2;
            }
            return -1;
        }
        int n3 = list.size() - 1;
        while (n3 >= 0) {
            if (object.equals(list.get(n3))) {
                return n3;
            }
            --n3;
        }
        return -1;
    }

    static ListIterator listIteratorImpl(List list, int n2) {
        return new Lists$AbstractListWrapper(list).listIterator(n2);
    }

    static List subListImpl(List list, int n2, int n3) {
        List list2;
        if (list instanceof RandomAccess) {
            list2 = new Lists$1(list);
            return list2.subList(n2, n3);
        }
        list2 = new Lists$2(list);
        return list2.subList(n2, n3);
    }

    static List cast(Iterable iterable) {
        return (List)iterable;
    }
}

