package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
public abstract class Ordering implements Comparator
{
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;
    
    @GwtCompatible(serializable = true)
    public static Ordering natural() {
        return NaturalOrdering.INSTANCE;
    }
    
    @GwtCompatible(serializable = true)
    public static Ordering from(final Comparator comparator) {
        return (comparator instanceof Ordering) ? ((Ordering)comparator) : new ComparatorOrdering(comparator);
    }
    
    @Deprecated
    @GwtCompatible(serializable = true)
    public static Ordering from(final Ordering ordering) {
        return (Ordering)Preconditions.checkNotNull(ordering);
    }
    
    @GwtCompatible(serializable = true)
    public static Ordering explicit(final List list) {
        return new ExplicitOrdering(list);
    }
    
    @GwtCompatible(serializable = true)
    public static Ordering explicit(final Object o, final Object... array) {
        return explicit(Lists.asList(o, array));
    }
    
    @GwtCompatible(serializable = true)
    public static Ordering allEqual() {
        return AllEqualOrdering.INSTANCE;
    }
    
    @GwtCompatible(serializable = true)
    public static Ordering usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }
    
    public static Ordering arbitrary() {
        return Ordering$ArbitraryOrderingHolder.ARBITRARY_ORDERING;
    }
    
    @GwtCompatible(serializable = true)
    public Ordering reverse() {
        return new ReverseOrdering(this);
    }
    
    @GwtCompatible(serializable = true)
    public Ordering nullsFirst() {
        return new NullsFirstOrdering(this);
    }
    
    @GwtCompatible(serializable = true)
    public Ordering nullsLast() {
        return new NullsLastOrdering(this);
    }
    
    @GwtCompatible(serializable = true)
    public Ordering onResultOf(final Function function) {
        return new ByFunctionOrdering(function, this);
    }
    
    Ordering onKeys() {
        return this.onResultOf(Maps.keyFunction());
    }
    
    @GwtCompatible(serializable = true)
    public Ordering compound(final Comparator comparator) {
        return new CompoundOrdering(this, (Comparator)Preconditions.checkNotNull(comparator));
    }
    
    @GwtCompatible(serializable = true)
    public static Ordering compound(final Iterable iterable) {
        return new CompoundOrdering(iterable);
    }
    
    @GwtCompatible(serializable = true)
    public Ordering lexicographical() {
        return new LexicographicalOrdering(this);
    }
    
    @Override
    public abstract int compare(@Nullable final Object p0, @Nullable final Object p1);
    
    public Object min(final Iterator iterator) {
        Object o = iterator.next();
        while (iterator.hasNext()) {
            o = this.min(o, iterator.next());
        }
        return o;
    }
    
    public Object min(final Iterable iterable) {
        return this.min(iterable.iterator());
    }
    
    public Object min(@Nullable final Object o, @Nullable final Object o2) {
        return (this.compare(o, o2) <= 0) ? o : o2;
    }
    
    public Object min(@Nullable final Object o, @Nullable final Object o2, @Nullable final Object o3, final Object... array) {
        Object o4 = this.min(this.min(o, o2), o3);
        for (int length = array.length, i = 0; i < length; ++i) {
            o4 = this.min(o4, array[i]);
        }
        return o4;
    }
    
    public Object max(final Iterator iterator) {
        Object o = iterator.next();
        while (iterator.hasNext()) {
            o = this.max(o, iterator.next());
        }
        return o;
    }
    
    public Object max(final Iterable iterable) {
        return this.max(iterable.iterator());
    }
    
    public Object max(@Nullable final Object o, @Nullable final Object o2) {
        return (this.compare(o, o2) >= 0) ? o : o2;
    }
    
    public Object max(@Nullable final Object o, @Nullable final Object o2, @Nullable final Object o3, final Object... array) {
        Object o4 = this.max(this.max(o, o2), o3);
        for (int length = array.length, i = 0; i < length; ++i) {
            o4 = this.max(o4, array[i]);
        }
        return o4;
    }
    
    public List leastOf(final Iterable iterable, final int n) {
        if (iterable instanceof Collection) {
            final Collection collection = (Collection)iterable;
            if (collection.size() <= 2L * n) {
                Object[] arraysCopy = collection.toArray();
                Arrays.sort(arraysCopy, this);
                if (arraysCopy.length > n) {
                    arraysCopy = ObjectArrays.arraysCopyOf(arraysCopy, n);
                }
                return Collections.unmodifiableList((List<?>)Arrays.asList((T[])arraysCopy));
            }
        }
        return this.leastOf(iterable.iterator(), n);
    }
    
    public List leastOf(final Iterator iterator, final int n) {
        Preconditions.checkNotNull(iterator);
        CollectPreconditions.checkNonnegative(n, "k");
        if (n == 0 || !iterator.hasNext()) {
            return ImmutableList.of();
        }
        if (n >= 1073741823) {
            final ArrayList arrayList = Lists.newArrayList(iterator);
            Collections.sort((List<Object>)arrayList, this);
            if (arrayList.size() > n) {
                arrayList.subList(n, arrayList.size()).clear();
            }
            arrayList.trimToSize();
            return Collections.unmodifiableList((List<?>)arrayList);
        }
        final int n2 = n * 2;
        final Object[] array = new Object[n2];
        Object o = iterator.next();
        array[0] = o;
        int n3;
        Object next;
        for (n3 = 1; n3 < n && iterator.hasNext(); array[n3++] = next, o = this.max(o, next)) {
            next = iterator.next();
        }
        while (iterator.hasNext()) {
            final Object next2 = iterator.next();
            if (this.compare(next2, o) >= 0) {
                continue;
            }
            array[n3++] = next2;
            if (n3 != n2) {
                continue;
            }
            int i = 0;
            int n4 = n2 - 1;
            int n5 = 0;
            while (i < n4) {
                final int partition = this.partition(array, i, n4, i + n4 + 1 >>> 1);
                if (partition > n) {
                    n4 = partition - 1;
                }
                else {
                    if (partition >= n) {
                        break;
                    }
                    i = Math.max(partition, i + 1);
                    n5 = partition;
                }
            }
            n3 = n;
            o = array[n5];
            for (int j = n5 + 1; j < n3; ++j) {
                o = this.max(o, array[j]);
            }
        }
        Arrays.sort(array, 0, n3, this);
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])ObjectArrays.arraysCopyOf(array, Math.min(n3, n))));
    }
    
    private int partition(final Object[] array, final int n, final int n2, final int n3) {
        final Object o = array[n3];
        array[n3] = array[n2];
        array[n2] = o;
        int n4 = n;
        for (int i = n; i < n2; ++i) {
            if (this.compare(array[i], o) < 0) {
                ObjectArrays.swap(array, n4, i);
                ++n4;
            }
        }
        ObjectArrays.swap(array, n2, n4);
        return n4;
    }
    
    public List greatestOf(final Iterable iterable, final int n) {
        return this.reverse().leastOf(iterable, n);
    }
    
    public List greatestOf(final Iterator iterator, final int n) {
        return this.reverse().leastOf(iterator, n);
    }
    
    public List sortedCopy(final Iterable iterable) {
        final Object[] array = Iterables.toArray(iterable);
        Arrays.sort(array, this);
        return Lists.newArrayList(Arrays.asList(array));
    }
    
    public ImmutableList immutableSortedCopy(final Iterable iterable) {
        final Object[] array2;
        final Object[] array = array2 = Iterables.toArray(iterable);
        for (int length = array2.length, i = 0; i < length; ++i) {
            Preconditions.checkNotNull(array2[i]);
        }
        Arrays.sort(array, this);
        return ImmutableList.asImmutableList(array);
    }
    
    public boolean isOrdered(final Iterable iterable) {
        final Iterator<Object> iterator = iterable.iterator();
        if (iterator.hasNext()) {
            Object next = iterator.next();
            while (iterator.hasNext()) {
                final Object next2 = iterator.next();
                if (this.compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
        }
        return true;
    }
    
    public boolean isStrictlyOrdered(final Iterable iterable) {
        final Iterator<Object> iterator = iterable.iterator();
        if (iterator.hasNext()) {
            Object next = iterator.next();
            while (iterator.hasNext()) {
                final Object next2 = iterator.next();
                if (this.compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
        }
        return true;
    }
    
    public int binarySearch(final List list, @Nullable final Object o) {
        return Collections.binarySearch(list, o, this);
    }
}
