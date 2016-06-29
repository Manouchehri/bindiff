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
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ConsumingQueueIterator;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators$1;
import com.google.common.collect.Iterators$10;
import com.google.common.collect.Iterators$11;
import com.google.common.collect.Iterators$12;
import com.google.common.collect.Iterators$13;
import com.google.common.collect.Iterators$14;
import com.google.common.collect.Iterators$15;
import com.google.common.collect.Iterators$2;
import com.google.common.collect.Iterators$3;
import com.google.common.collect.Iterators$4;
import com.google.common.collect.Iterators$5;
import com.google.common.collect.Iterators$6;
import com.google.common.collect.Iterators$7;
import com.google.common.collect.Iterators$8;
import com.google.common.collect.Iterators$9;
import com.google.common.collect.Iterators$MergingIterator;
import com.google.common.collect.Iterators$PeekingImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class Iterators {
    static final UnmodifiableListIterator EMPTY_LIST_ITERATOR = new Iterators$1();
    private static final Iterator EMPTY_MODIFIABLE_ITERATOR = new Iterators$2();

    private Iterators() {
    }

    @Deprecated
    static UnmodifiableIterator emptyIterator() {
        return Iterators.emptyListIterator();
    }

    static UnmodifiableListIterator emptyListIterator() {
        return EMPTY_LIST_ITERATOR;
    }

    static Iterator emptyModifiableIterator() {
        return EMPTY_MODIFIABLE_ITERATOR;
    }

    public static UnmodifiableIterator unmodifiableIterator(Iterator iterator) {
        Preconditions.checkNotNull(iterator);
        if (!(iterator instanceof UnmodifiableIterator)) return new Iterators$3(iterator);
        return (UnmodifiableIterator)iterator;
    }

    @Deprecated
    public static UnmodifiableIterator unmodifiableIterator(UnmodifiableIterator unmodifiableIterator) {
        return (UnmodifiableIterator)Preconditions.checkNotNull(unmodifiableIterator);
    }

    public static int size(Iterator iterator) {
        int n2 = 0;
        while (iterator.hasNext()) {
            iterator.next();
            ++n2;
        }
        return n2;
    }

    public static boolean contains(Iterator iterator, @Nullable Object object) {
        return Iterators.any(iterator, Predicates.equalTo(object));
    }

    public static boolean removeAll(Iterator iterator, Collection collection) {
        return Iterators.removeIf(iterator, Predicates.in(collection));
    }

    public static boolean removeIf(Iterator iterator, Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        boolean bl2 = false;
        while (iterator.hasNext()) {
            if (!predicate.apply(iterator.next())) continue;
            iterator.remove();
            bl2 = true;
        }
        return bl2;
    }

    public static boolean retainAll(Iterator iterator, Collection collection) {
        return Iterators.removeIf(iterator, Predicates.not(Predicates.in(collection)));
    }

    public static boolean elementsEqual(Iterator iterator, Iterator iterator2) {
        while (iterator.hasNext()) {
            Object e2;
            if (!iterator2.hasNext()) {
                return false;
            }
            Object e3 = iterator.next();
            if (Objects.equal(e3, e2 = iterator2.next())) continue;
            return false;
        }
        if (iterator2.hasNext()) return false;
        return true;
    }

    public static String toString(Iterator iterator) {
        return Collections2.STANDARD_JOINER.appendTo(new StringBuilder().append('['), iterator).append(']').toString();
    }

    public static Object getOnlyElement(Iterator iterator) {
        Object e2 = iterator.next();
        if (!iterator.hasNext()) {
            return e2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string = String.valueOf(e2);
        stringBuilder.append(new StringBuilder(31 + String.valueOf(string).length()).append("expected one element but was: <").append(string).toString());
        for (int i2 = 0; i2 < 4 && iterator.hasNext(); ++i2) {
            String string2 = String.valueOf(iterator.next());
            stringBuilder.append(new StringBuilder(2 + String.valueOf(string2).length()).append(", ").append(string2).toString());
        }
        if (iterator.hasNext()) {
            stringBuilder.append(", ...");
        }
        stringBuilder.append('>');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Nullable
    public static Object getOnlyElement(Iterator iterator, @Nullable Object object) {
        Object object2;
        if (iterator.hasNext()) {
            object2 = Iterators.getOnlyElement(iterator);
            return object2;
        }
        object2 = object;
        return object2;
    }

    @GwtIncompatible(value="Array.newInstance(Class, int)")
    public static Object[] toArray(Iterator iterator, Class class_) {
        ArrayList arrayList = Lists.newArrayList(iterator);
        return Iterables.toArray((Iterable)arrayList, class_);
    }

    public static boolean addAll(Collection collection, Iterator iterator) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(iterator);
        boolean bl2 = false;
        while (iterator.hasNext()) {
            bl2 |= collection.add(iterator.next());
        }
        return bl2;
    }

    public static int frequency(Iterator iterator, @Nullable Object object) {
        return Iterators.size(Iterators.filter(iterator, Predicates.equalTo(object)));
    }

    public static Iterator cycle(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterators$4(iterable);
    }

    public static /* varargs */ Iterator cycle(Object ... arrobject) {
        return Iterators.cycle(Lists.newArrayList(arrobject));
    }

    public static Iterator concat(Iterator iterator, Iterator iterator2) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(iterator2);
        return Iterators.concat((Iterator)new ConsumingQueueIterator(iterator, iterator2));
    }

    public static Iterator concat(Iterator iterator, Iterator iterator2, Iterator iterator3) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkNotNull(iterator3);
        return Iterators.concat((Iterator)new ConsumingQueueIterator(iterator, iterator2, iterator3));
    }

    public static Iterator concat(Iterator iterator, Iterator iterator2, Iterator iterator3, Iterator iterator4) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkNotNull(iterator3);
        Preconditions.checkNotNull(iterator4);
        return Iterators.concat((Iterator)new ConsumingQueueIterator(iterator, iterator2, iterator3, iterator4));
    }

    public static /* varargs */ Iterator concat(Iterator ... arriterator) {
        Iterator[] arriterator2 = (Iterator[])Preconditions.checkNotNull(arriterator);
        int n2 = arriterator2.length;
        int n3 = 0;
        while (n3 < n2) {
            Iterator iterator = arriterator2[n3];
            Preconditions.checkNotNull(iterator);
            ++n3;
        }
        return Iterators.concat((Iterator)new ConsumingQueueIterator(arriterator));
    }

    public static Iterator concat(Iterator iterator) {
        Preconditions.checkNotNull(iterator);
        return new Iterators$5(iterator);
    }

    public static UnmodifiableIterator partition(Iterator iterator, int n2) {
        return Iterators.partitionImpl(iterator, n2, false);
    }

    public static UnmodifiableIterator paddedPartition(Iterator iterator, int n2) {
        return Iterators.partitionImpl(iterator, n2, true);
    }

    private static UnmodifiableIterator partitionImpl(Iterator iterator, int n2, boolean bl2) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkArgument(n2 > 0);
        return new Iterators$6(iterator, n2, bl2);
    }

    @GoogleInternal
    public static Iterator pairUp(Iterator iterator, Iterator iterator2) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(iterator2);
        return new Iterators$7(iterator, iterator2);
    }

    @CheckReturnValue
    public static UnmodifiableIterator filter(Iterator iterator, Predicate predicate) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(predicate);
        return new Iterators$8(iterator, predicate);
    }

    @CheckReturnValue
    @GwtIncompatible(value="Class.isInstance")
    public static UnmodifiableIterator filter(Iterator iterator, Class class_) {
        return Iterators.filter(iterator, Predicates.instanceOf(class_));
    }

    public static boolean any(Iterator iterator, Predicate predicate) {
        if (Iterators.indexOf(iterator, predicate) == -1) return false;
        return true;
    }

    public static boolean all(Iterator iterator, Predicate predicate) {
        Object e2;
        Preconditions.checkNotNull(predicate);
        do {
            if (!iterator.hasNext()) return true;
        } while (predicate.apply(e2 = iterator.next()));
        return false;
    }

    public static Object find(Iterator iterator, Predicate predicate) {
        return Iterators.filter(iterator, predicate).next();
    }

    @Nullable
    public static Object find(Iterator iterator, Predicate predicate, @Nullable Object object) {
        return Iterators.getNext(Iterators.filter(iterator, predicate), object);
    }

    public static Optional tryFind(Iterator iterator, Predicate predicate) {
        Optional optional;
        UnmodifiableIterator unmodifiableIterator = Iterators.filter(iterator, predicate);
        if (unmodifiableIterator.hasNext()) {
            optional = Optional.of(unmodifiableIterator.next());
            return optional;
        }
        optional = Optional.absent();
        return optional;
    }

    public static int indexOf(Iterator iterator, Predicate predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int n2 = 0;
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (predicate.apply(e2)) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public static Iterator transform(Iterator iterator, Function function) {
        Preconditions.checkNotNull(function);
        return new Iterators$9(iterator, function);
    }

    public static Object get(Iterator iterator, int n2) {
        Iterators.checkNonnegative(n2);
        int n3 = Iterators.advance(iterator, n2);
        if (iterator.hasNext()) return iterator.next();
        throw new IndexOutOfBoundsException(new StringBuilder(91).append("position (").append(n2).append(") must be less than the number of elements that remained (").append(n3).append(")").toString());
    }

    static void checkNonnegative(int n2) {
        if (n2 >= 0) return;
        throw new IndexOutOfBoundsException(new StringBuilder(43).append("position (").append(n2).append(") must not be negative").toString());
    }

    @Nullable
    public static Object get(Iterator iterator, int n2, @Nullable Object object) {
        Iterators.checkNonnegative(n2);
        Iterators.advance(iterator, n2);
        return Iterators.getNext(iterator, object);
    }

    @Nullable
    public static Object getNext(Iterator iterator, @Nullable Object object) {
        Object object2;
        if (iterator.hasNext()) {
            object2 = iterator.next();
            return object2;
        }
        object2 = object;
        return object2;
    }

    public static Object getLast(Iterator iterator) {
        Object e2;
        do {
            e2 = iterator.next();
        } while (iterator.hasNext());
        return e2;
    }

    @Nullable
    public static Object getLast(Iterator iterator, @Nullable Object object) {
        Object object2;
        if (iterator.hasNext()) {
            object2 = Iterators.getLast(iterator);
            return object2;
        }
        object2 = object;
        return object2;
    }

    public static int advance(Iterator iterator, int n2) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkArgument(n2 >= 0, "numberToAdvance must be nonnegative");
        int n3 = 0;
        while (n3 < n2) {
            if (!iterator.hasNext()) return n3;
            iterator.next();
            ++n3;
        }
        return n3;
    }

    public static Iterator limit(Iterator iterator, int n2) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkArgument(n2 >= 0, "limit is negative");
        return new Iterators$10(n2, iterator);
    }

    public static Iterator consumingIterator(Iterator iterator) {
        Preconditions.checkNotNull(iterator);
        return new Iterators$11(iterator);
    }

    @Nullable
    static Object pollNext(Iterator iterator) {
        if (!iterator.hasNext()) return null;
        Object e2 = iterator.next();
        iterator.remove();
        return e2;
    }

    static void clear(Iterator iterator) {
        Preconditions.checkNotNull(iterator);
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    public static /* varargs */ UnmodifiableIterator forArray(Object ... arrobject) {
        return Iterators.forArray(arrobject, 0, arrobject.length, 0);
    }

    static UnmodifiableListIterator forArray(Object[] arrobject, int n2, int n3, int n4) {
        Preconditions.checkArgument(n3 >= 0);
        int n5 = n2 + n3;
        Preconditions.checkPositionIndexes(n2, n5, arrobject.length);
        Preconditions.checkPositionIndex(n4, n3);
        if (n3 != 0) return new Iterators$12(n3, n4, arrobject, n2);
        return Iterators.emptyListIterator();
    }

    public static UnmodifiableIterator singletonIterator(@Nullable Object object) {
        return new Iterators$13(object);
    }

    public static UnmodifiableIterator forEnumeration(Enumeration enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new Iterators$14(enumeration);
    }

    public static Enumeration asEnumeration(Iterator iterator) {
        Preconditions.checkNotNull(iterator);
        return new Iterators$15(iterator);
    }

    public static PeekingIterator peekingIterator(Iterator iterator) {
        if (!(iterator instanceof Iterators$PeekingImpl)) return new Iterators$PeekingImpl(iterator);
        return (Iterators$PeekingImpl)iterator;
    }

    @Deprecated
    public static PeekingIterator peekingIterator(PeekingIterator peekingIterator) {
        return (PeekingIterator)Preconditions.checkNotNull(peekingIterator);
    }

    @Beta
    public static UnmodifiableIterator mergeSorted(Iterable iterable, Comparator comparator) {
        Preconditions.checkNotNull(iterable, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new Iterators$MergingIterator(iterable, comparator);
    }

    static ListIterator cast(Iterator iterator) {
        return (ListIterator)iterator;
    }
}

