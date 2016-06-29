package com.google.common.collect;

import com.google.common.primitives.*;
import java.util.concurrent.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible(emulated = true)
public final class Lists
{
    @GwtCompatible(serializable = true)
    public static ArrayList newArrayList() {
        return new ArrayList();
    }
    
    @GwtCompatible(serializable = true)
    public static ArrayList newArrayList(final Object... array) {
        Preconditions.checkNotNull(array);
        final ArrayList<Object> list = new ArrayList<Object>(computeArrayListCapacity(array.length));
        Collections.addAll(list, array);
        return list;
    }
    
    @VisibleForTesting
    static int computeArrayListCapacity(final int n) {
        CollectPreconditions.checkNonnegative(n, "arraySize");
        return Ints.saturatedCast(5L + n + n / 10);
    }
    
    @GwtCompatible(serializable = true)
    public static ArrayList newArrayList(final Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        return (iterable instanceof Collection) ? new ArrayList(Collections2.cast(iterable)) : newArrayList(iterable.iterator());
    }
    
    @GwtCompatible(serializable = true)
    public static ArrayList newArrayList(final Iterator iterator) {
        final ArrayList arrayList = newArrayList();
        Iterators.addAll(arrayList, iterator);
        return arrayList;
    }
    
    @GwtCompatible(serializable = true)
    public static ArrayList newArrayListWithCapacity(final int n) {
        CollectPreconditions.checkNonnegative(n, "initialArraySize");
        return new ArrayList(n);
    }
    
    @GwtCompatible(serializable = true)
    public static ArrayList newArrayListWithExpectedSize(final int n) {
        return new ArrayList(computeArrayListCapacity(n));
    }
    
    @GwtCompatible(serializable = true)
    public static LinkedList newLinkedList() {
        return new LinkedList();
    }
    
    @GwtCompatible(serializable = true)
    @GoogleInternal
    public static LinkedList newLinkedList(final Object... array) {
        final LinkedList linkedList = newLinkedList();
        Collections.addAll(linkedList, array);
        return linkedList;
    }
    
    @GwtCompatible(serializable = true)
    public static LinkedList newLinkedList(final Iterable iterable) {
        final LinkedList linkedList = newLinkedList();
        Iterables.addAll(linkedList, iterable);
        return linkedList;
    }
    
    @GwtCompatible(serializable = true)
    @GoogleInternal
    public static LinkedList newLinkedList(final Iterator iterator) {
        final LinkedList linkedList = newLinkedList();
        Iterators.addAll(linkedList, iterator);
        return linkedList;
    }
    
    @GwtIncompatible("CopyOnWriteArrayList")
    public static CopyOnWriteArrayList newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList();
    }
    
    @GwtIncompatible("CopyOnWriteArrayList")
    public static CopyOnWriteArrayList newCopyOnWriteArrayList(final Iterable iterable) {
        return new CopyOnWriteArrayList((iterable instanceof Collection) ? Collections2.cast(iterable) : newArrayList(iterable));
    }
    
    public static List asList(@Nullable final Object o, final Object[] array) {
        return new Lists$OnePlusArrayList(o, array);
    }
    
    public static List asList(@Nullable final Object o, @Nullable final Object o2, final Object[] array) {
        return new Lists$TwoPlusArrayList(o, o2, array);
    }
    
    public static List cartesianProduct(final List list) {
        return CartesianList.create(list);
    }
    
    public static List cartesianProduct(final List... array) {
        return cartesianProduct((List)Arrays.asList((List[])array));
    }
    
    @CheckReturnValue
    public static List transform(final List list, final Function function) {
        return (list instanceof RandomAccess) ? new Lists$TransformingRandomAccessList(list, function) : new Lists$TransformingSequentialList(list, function);
    }
    
    public static List partition(final List list, final int n) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(n > 0);
        return (list instanceof RandomAccess) ? new Lists$RandomAccessPartition(list, n) : new Lists$Partition(list, n);
    }
    
    @Beta
    public static ImmutableList charactersOf(final String s) {
        return new Lists$StringAsImmutableList((String)Preconditions.checkNotNull(s));
    }
    
    @Beta
    public static List charactersOf(final CharSequence charSequence) {
        return new Lists$CharSequenceAsList((CharSequence)Preconditions.checkNotNull(charSequence));
    }
    
    @CheckReturnValue
    public static List reverse(final List list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList)list).reverse();
        }
        if (list instanceof Lists$ReverseList) {
            return ((Lists$ReverseList)list).getForwardList();
        }
        if (list instanceof RandomAccess) {
            return new Lists$RandomAccessReverseList(list);
        }
        return new Lists$ReverseList(list);
    }
    
    static int hashCodeImpl(final List list) {
        int n = 1;
        for (final Object next : list) {
            n = ~(~(31 * n + ((next == null) ? 0 : next.hashCode())));
        }
        return n;
    }
    
    static boolean equalsImpl(final List list, @Nullable final Object o) {
        if (o == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(o instanceof List)) {
            return false;
        }
        final List list2 = (List)o;
        final int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (list instanceof RandomAccess && list2 instanceof RandomAccess) {
            for (int i = 0; i < size; ++i) {
                if (!Objects.equal(list.get(i), list2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return Iterators.elementsEqual(list.iterator(), list2.iterator());
    }
    
    static boolean addAllImpl(final List list, final int n, final Iterable iterable) {
        boolean b = false;
        final ListIterator<Object> listIterator = list.listIterator(n);
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            listIterator.add(iterator.next());
            b = true;
        }
        return b;
    }
    
    static int indexOfImpl(final List list, @Nullable final Object o) {
        if (list instanceof RandomAccess) {
            return indexOfRandomAccess(list, o);
        }
        final ListIterator<Object> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(o, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }
    
    private static int indexOfRandomAccess(final List list, @Nullable final Object o) {
        final int size = list.size();
        if (o == null) {
            for (int i = 0; i < size; ++i) {
                if (list.get(i) == null) {
                    return i;
                }
            }
        }
        else {
            for (int j = 0; j < size; ++j) {
                if (o.equals(list.get(j))) {
                    return j;
                }
            }
        }
        return -1;
    }
    
    static int lastIndexOfImpl(final List list, @Nullable final Object o) {
        if (list instanceof RandomAccess) {
            return lastIndexOfRandomAccess(list, o);
        }
        final ListIterator<Object> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.equal(o, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
    
    private static int lastIndexOfRandomAccess(final List list, @Nullable final Object o) {
        if (o == null) {
            for (int i = list.size() - 1; i >= 0; --i) {
                if (list.get(i) == null) {
                    return i;
                }
            }
        }
        else {
            for (int j = list.size() - 1; j >= 0; --j) {
                if (o.equals(list.get(j))) {
                    return j;
                }
            }
        }
        return -1;
    }
    
    static ListIterator listIteratorImpl(final List list, final int n) {
        return new Lists$AbstractListWrapper(list).listIterator(n);
    }
    
    static List subListImpl(final List list, final int n, final int n2) {
        Lists$AbstractListWrapper lists$AbstractListWrapper;
        if (list instanceof RandomAccess) {
            lists$AbstractListWrapper = new Lists$1(list);
        }
        else {
            lists$AbstractListWrapper = new Lists$2(list);
        }
        return lists$AbstractListWrapper.subList(n, n2);
    }
    
    static List cast(final Iterable iterable) {
        return (List)iterable;
    }
}
