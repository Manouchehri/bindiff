package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible(emulated = true)
public final class Iterators
{
    static final UnmodifiableListIterator EMPTY_LIST_ITERATOR;
    private static final Iterator EMPTY_MODIFIABLE_ITERATOR;
    
    @Deprecated
    static UnmodifiableIterator emptyIterator() {
        return emptyListIterator();
    }
    
    static UnmodifiableListIterator emptyListIterator() {
        return Iterators.EMPTY_LIST_ITERATOR;
    }
    
    static Iterator emptyModifiableIterator() {
        return Iterators.EMPTY_MODIFIABLE_ITERATOR;
    }
    
    public static UnmodifiableIterator unmodifiableIterator(final Iterator iterator) {
        Preconditions.checkNotNull(iterator);
        if (iterator instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator)iterator;
        }
        return new Iterators$3(iterator);
    }
    
    @Deprecated
    public static UnmodifiableIterator unmodifiableIterator(final UnmodifiableIterator unmodifiableIterator) {
        return (UnmodifiableIterator)Preconditions.checkNotNull(unmodifiableIterator);
    }
    
    public static int size(final Iterator iterator) {
        int n = 0;
        while (iterator.hasNext()) {
            iterator.next();
            ++n;
        }
        return n;
    }
    
    public static boolean contains(final Iterator iterator, @Nullable final Object o) {
        return any(iterator, Predicates.equalTo(o));
    }
    
    public static boolean removeAll(final Iterator iterator, final Collection collection) {
        return removeIf(iterator, Predicates.in(collection));
    }
    
    public static boolean removeIf(final Iterator iterator, final Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        boolean b = false;
        while (iterator.hasNext()) {
            if (predicate.apply(iterator.next())) {
                iterator.remove();
                b = true;
            }
        }
        return b;
    }
    
    public static boolean retainAll(final Iterator iterator, final Collection collection) {
        return removeIf(iterator, Predicates.not(Predicates.in(collection)));
    }
    
    public static boolean elementsEqual(final Iterator iterator, final Iterator iterator2) {
        while (iterator.hasNext()) {
            if (!iterator2.hasNext()) {
                return false;
            }
            if (!Objects.equal(iterator.next(), iterator2.next())) {
                return false;
            }
        }
        return !iterator2.hasNext();
    }
    
    public static String toString(final Iterator iterator) {
        return Collections2.STANDARD_JOINER.appendTo(new StringBuilder().append('['), iterator).append(']').toString();
    }
    
    public static Object getOnlyElement(final Iterator iterator) {
        final Object next = iterator.next();
        if (!iterator.hasNext()) {
            return next;
        }
        final StringBuilder sb2;
        final StringBuilder sb = sb2 = new StringBuilder();
        final String value = String.valueOf(next);
        sb2.append(new StringBuilder(31 + String.valueOf(value).length()).append("expected one element but was: <").append(value).toString());
        for (int n = 0; n < 4 && iterator.hasNext(); ++n) {
            final StringBuilder sb3 = sb;
            final String value2 = String.valueOf(iterator.next());
            sb3.append(new StringBuilder(2 + String.valueOf(value2).length()).append(", ").append(value2).toString());
        }
        if (iterator.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }
    
    @Nullable
    public static Object getOnlyElement(final Iterator iterator, @Nullable final Object o) {
        return iterator.hasNext() ? getOnlyElement(iterator) : o;
    }
    
    @GwtIncompatible("Array.newInstance(Class, int)")
    public static Object[] toArray(final Iterator iterator, final Class clazz) {
        return Iterables.toArray(Lists.newArrayList(iterator), clazz);
    }
    
    public static boolean addAll(final Collection collection, final Iterator iterator) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(iterator);
        boolean b = false;
        while (iterator.hasNext()) {
            b |= collection.add(iterator.next());
        }
        return b;
    }
    
    public static int frequency(final Iterator iterator, @Nullable final Object o) {
        return size(filter(iterator, Predicates.equalTo(o)));
    }
    
    public static Iterator cycle(final Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterators$4(iterable);
    }
    
    public static Iterator cycle(final Object... array) {
        return cycle(Lists.newArrayList(array));
    }
    
    public static Iterator concat(final Iterator iterator, final Iterator iterator2) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(iterator2);
        return concat(new ConsumingQueueIterator((Object[])new Iterator[] { iterator, iterator2 }));
    }
    
    public static Iterator concat(final Iterator iterator, final Iterator iterator2, final Iterator iterator3) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkNotNull(iterator3);
        return concat(new ConsumingQueueIterator((Object[])new Iterator[] { iterator, iterator2, iterator3 }));
    }
    
    public static Iterator concat(final Iterator iterator, final Iterator iterator2, final Iterator iterator3, final Iterator iterator4) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkNotNull(iterator3);
        Preconditions.checkNotNull(iterator4);
        return concat(new ConsumingQueueIterator((Object[])new Iterator[] { iterator, iterator2, iterator3, iterator4 }));
    }
    
    public static Iterator concat(final Iterator... array) {
        final Iterator[] array2 = (Iterator[])Preconditions.checkNotNull(array);
        for (int length = array2.length, i = 0; i < length; ++i) {
            Preconditions.checkNotNull(array2[i]);
        }
        return concat(new ConsumingQueueIterator((Object[])array));
    }
    
    public static Iterator concat(final Iterator iterator) {
        Preconditions.checkNotNull(iterator);
        return new Iterators$5(iterator);
    }
    
    public static UnmodifiableIterator partition(final Iterator iterator, final int n) {
        return partitionImpl(iterator, n, false);
    }
    
    public static UnmodifiableIterator paddedPartition(final Iterator iterator, final int n) {
        return partitionImpl(iterator, n, true);
    }
    
    private static UnmodifiableIterator partitionImpl(final Iterator iterator, final int n, final boolean b) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkArgument(n > 0);
        return new Iterators$6(iterator, n, b);
    }
    
    @GoogleInternal
    public static Iterator pairUp(final Iterator iterator, final Iterator iterator2) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(iterator2);
        return new Iterators$7(iterator, iterator2);
    }
    
    @CheckReturnValue
    public static UnmodifiableIterator filter(final Iterator iterator, final Predicate predicate) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(predicate);
        return new Iterators$8(iterator, predicate);
    }
    
    @CheckReturnValue
    @GwtIncompatible("Class.isInstance")
    public static UnmodifiableIterator filter(final Iterator iterator, final Class clazz) {
        return filter(iterator, Predicates.instanceOf(clazz));
    }
    
    public static boolean any(final Iterator iterator, final Predicate predicate) {
        return indexOf(iterator, predicate) != -1;
    }
    
    public static boolean all(final Iterator iterator, final Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.apply(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    public static Object find(final Iterator iterator, final Predicate predicate) {
        return filter(iterator, predicate).next();
    }
    
    @Nullable
    public static Object find(final Iterator iterator, final Predicate predicate, @Nullable final Object o) {
        return getNext(filter(iterator, predicate), o);
    }
    
    public static Optional tryFind(final Iterator iterator, final Predicate predicate) {
        final UnmodifiableIterator filter = filter(iterator, predicate);
        return filter.hasNext() ? Optional.of(filter.next()) : Optional.absent();
    }
    
    public static int indexOf(final Iterator iterator, final Predicate predicate) {
        Preconditions.checkNotNull(predicate, (Object)"predicate");
        int n = 0;
        while (iterator.hasNext()) {
            if (predicate.apply(iterator.next())) {
                return n;
            }
            ++n;
        }
        return -1;
    }
    
    public static Iterator transform(final Iterator iterator, final Function function) {
        Preconditions.checkNotNull(function);
        return new Iterators$9(iterator, function);
    }
    
    public static Object get(final Iterator iterator, final int n) {
        checkNonnegative(n);
        final int advance = advance(iterator, n);
        if (!iterator.hasNext()) {
            throw new IndexOutOfBoundsException(new StringBuilder(91).append("position (").append(n).append(") must be less than the number of elements that remained (").append(advance).append(")").toString());
        }
        return iterator.next();
    }
    
    static void checkNonnegative(final int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(43).append("position (").append(n).append(") must not be negative").toString());
        }
    }
    
    @Nullable
    public static Object get(final Iterator iterator, final int n, @Nullable final Object o) {
        checkNonnegative(n);
        advance(iterator, n);
        return getNext(iterator, o);
    }
    
    @Nullable
    public static Object getNext(final Iterator iterator, @Nullable final Object o) {
        return iterator.hasNext() ? iterator.next() : o;
    }
    
    public static Object getLast(final Iterator iterator) {
        Object next;
        do {
            next = iterator.next();
        } while (iterator.hasNext());
        return next;
    }
    
    @Nullable
    public static Object getLast(final Iterator iterator, @Nullable final Object o) {
        return iterator.hasNext() ? getLast(iterator) : o;
    }
    
    public static int advance(final Iterator iterator, final int n) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkArgument(n >= 0, (Object)"numberToAdvance must be nonnegative");
        int n2;
        for (n2 = 0; n2 < n && iterator.hasNext(); ++n2) {
            iterator.next();
        }
        return n2;
    }
    
    public static Iterator limit(final Iterator iterator, final int n) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkArgument(n >= 0, (Object)"limit is negative");
        return new Iterators$10(n, iterator);
    }
    
    public static Iterator consumingIterator(final Iterator iterator) {
        Preconditions.checkNotNull(iterator);
        return new Iterators$11(iterator);
    }
    
    @Nullable
    static Object pollNext(final Iterator iterator) {
        if (iterator.hasNext()) {
            final Object next = iterator.next();
            iterator.remove();
            return next;
        }
        return null;
    }
    
    static void clear(final Iterator iterator) {
        Preconditions.checkNotNull(iterator);
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }
    
    public static UnmodifiableIterator forArray(final Object... array) {
        return forArray(array, 0, array.length, 0);
    }
    
    static UnmodifiableListIterator forArray(final Object[] array, final int n, final int n2, final int n3) {
        Preconditions.checkArgument(n2 >= 0);
        Preconditions.checkPositionIndexes(n, n + n2, array.length);
        Preconditions.checkPositionIndex(n3, n2);
        if (n2 == 0) {
            return emptyListIterator();
        }
        return new Iterators$12(n2, n3, array, n);
    }
    
    public static UnmodifiableIterator singletonIterator(@Nullable final Object o) {
        return new Iterators$13(o);
    }
    
    public static UnmodifiableIterator forEnumeration(final Enumeration enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new Iterators$14(enumeration);
    }
    
    public static Enumeration asEnumeration(final Iterator iterator) {
        Preconditions.checkNotNull(iterator);
        return new Iterators$15(iterator);
    }
    
    public static PeekingIterator peekingIterator(final Iterator iterator) {
        if (iterator instanceof Iterators$PeekingImpl) {
            return (Iterators$PeekingImpl)iterator;
        }
        return new Iterators$PeekingImpl(iterator);
    }
    
    @Deprecated
    public static PeekingIterator peekingIterator(final PeekingIterator peekingIterator) {
        return (PeekingIterator)Preconditions.checkNotNull(peekingIterator);
    }
    
    @Beta
    public static UnmodifiableIterator mergeSorted(final Iterable iterable, final Comparator comparator) {
        Preconditions.checkNotNull(iterable, (Object)"iterators");
        Preconditions.checkNotNull(comparator, (Object)"comparator");
        return new Iterators$MergingIterator(iterable, comparator);
    }
    
    static ListIterator cast(final Iterator iterator) {
        return (ListIterator)iterator;
    }
    
    static {
        EMPTY_LIST_ITERATOR = new Iterators$1();
        EMPTY_MODIFIABLE_ITERATOR = new Iterators$2();
    }
}
