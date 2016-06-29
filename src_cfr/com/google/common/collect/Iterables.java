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
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables$1;
import com.google.common.collect.Iterables$10;
import com.google.common.collect.Iterables$11;
import com.google.common.collect.Iterables$12;
import com.google.common.collect.Iterables$13;
import com.google.common.collect.Iterables$14;
import com.google.common.collect.Iterables$15;
import com.google.common.collect.Iterables$16;
import com.google.common.collect.Iterables$2;
import com.google.common.collect.Iterables$3;
import com.google.common.collect.Iterables$4;
import com.google.common.collect.Iterables$5;
import com.google.common.collect.Iterables$6;
import com.google.common.collect.Iterables$7;
import com.google.common.collect.Iterables$8;
import com.google.common.collect.Iterables$9;
import com.google.common.collect.Iterables$UnmodifiableIterable;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.ObjectArrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class Iterables {
    private Iterables() {
    }

    public static Iterable unmodifiableIterable(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Iterables$UnmodifiableIterable) return iterable;
        if (!(iterable instanceof ImmutableCollection)) return new Iterables$UnmodifiableIterable(iterable, null);
        return iterable;
    }

    @Deprecated
    public static Iterable unmodifiableIterable(ImmutableCollection immutableCollection) {
        return (Iterable)Preconditions.checkNotNull(immutableCollection);
    }

    public static int size(Iterable iterable) {
        int n2;
        if (iterable instanceof Collection) {
            n2 = ((Collection)iterable).size();
            return n2;
        }
        n2 = Iterators.size(iterable.iterator());
        return n2;
    }

    public static boolean contains(Iterable iterable, @Nullable Object object) {
        if (!(iterable instanceof Collection)) return Iterators.contains(iterable.iterator(), object);
        Collection collection = (Collection)iterable;
        return Collections2.safeContains(collection, object);
    }

    public static boolean removeAll(Iterable iterable, Collection collection) {
        boolean bl2;
        if (iterable instanceof Collection) {
            bl2 = ((Collection)iterable).removeAll((Collection)Preconditions.checkNotNull(collection));
            return bl2;
        }
        bl2 = Iterators.removeAll(iterable.iterator(), collection);
        return bl2;
    }

    public static boolean retainAll(Iterable iterable, Collection collection) {
        boolean bl2;
        if (iterable instanceof Collection) {
            bl2 = ((Collection)iterable).retainAll((Collection)Preconditions.checkNotNull(collection));
            return bl2;
        }
        bl2 = Iterators.retainAll(iterable.iterator(), collection);
        return bl2;
    }

    public static boolean removeIf(Iterable iterable, Predicate predicate) {
        if (!(iterable instanceof RandomAccess)) return Iterators.removeIf(iterable.iterator(), predicate);
        if (!(iterable instanceof List)) return Iterators.removeIf(iterable.iterator(), predicate);
        return Iterables.removeIfFromRandomAccessList((List)iterable, (Predicate)Preconditions.checkNotNull(predicate));
    }

    private static boolean removeIfFromRandomAccessList(List list, Predicate predicate) {
        int n2;
        int n3 = 0;
        for (n2 = 0; n2 < list.size(); ++n2) {
            Object e2 = list.get(n2);
            if (predicate.apply(e2)) continue;
            if (n2 > n3) {
                try {
                    list.set(n3, e2);
                }
                catch (UnsupportedOperationException var5_5) {
                    Iterables.slowRemoveIfForRemainingElements(list, predicate, n3, n2);
                    return true;
                }
            }
            ++n3;
        }
        list.subList(n3, list.size()).clear();
        if (n2 == n3) return false;
        return true;
    }

    private static void slowRemoveIfForRemainingElements(List list, Predicate predicate, int n2, int n3) {
        int n4;
        for (n4 = list.size() - 1; n4 > n3; --n4) {
            if (!predicate.apply(list.get(n4))) continue;
            list.remove(n4);
        }
        n4 = n3 - 1;
        while (n4 >= n2) {
            list.remove(n4);
            --n4;
        }
    }

    @Nullable
    static Object removeFirstMatching(Iterable iterable, Predicate predicate) {
        Object t2;
        Preconditions.checkNotNull(predicate);
        Iterator iterator = iterable.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!predicate.apply(t2 = iterator.next()));
        iterator.remove();
        return t2;
    }

    @CheckReturnValue
    public static boolean elementsEqual(Iterable iterable, Iterable iterable2) {
        if (!(iterable instanceof Collection)) return Iterators.elementsEqual(iterable.iterator(), iterable2.iterator());
        if (!(iterable2 instanceof Collection)) return Iterators.elementsEqual(iterable.iterator(), iterable2.iterator());
        Collection collection = (Collection)iterable;
        Collection collection2 = (Collection)iterable2;
        if (collection.size() == collection2.size()) return Iterators.elementsEqual(iterable.iterator(), iterable2.iterator());
        return false;
    }

    public static String toString(Iterable iterable) {
        return Iterators.toString(iterable.iterator());
    }

    public static Object getOnlyElement(Iterable iterable) {
        return Iterators.getOnlyElement(iterable.iterator());
    }

    @Nullable
    public static Object getOnlyElement(Iterable iterable, @Nullable Object object) {
        return Iterators.getOnlyElement(iterable.iterator(), object);
    }

    @GwtIncompatible(value="Array.newInstance(Class, int)")
    public static Object[] toArray(Iterable iterable, Class class_) {
        Collection collection = Iterables.toCollection(iterable);
        Object[] arrobject = ObjectArrays.newArray(class_, collection.size());
        return collection.toArray(arrobject);
    }

    static Object[] toArray(Iterable iterable, Object[] arrobject) {
        Collection collection = Iterables.toCollection(iterable);
        return collection.toArray(arrobject);
    }

    static Object[] toArray(Iterable iterable) {
        return Iterables.toCollection(iterable).toArray();
    }

    private static Collection toCollection(Iterable iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection)iterable;
            return collection;
        }
        collection = Lists.newArrayList(iterable.iterator());
        return collection;
    }

    public static boolean addAll(Collection collection, Iterable iterable) {
        if (!(iterable instanceof Collection)) return Iterators.addAll(collection, ((Iterable)Preconditions.checkNotNull(iterable)).iterator());
        Collection collection2 = Collections2.cast(iterable);
        return collection.addAll(collection2);
    }

    public static int frequency(Iterable iterable, @Nullable Object object) {
        if (iterable instanceof Multiset) {
            return ((Multiset)iterable).count(object);
        }
        if (!(iterable instanceof Set)) return Iterators.frequency(iterable.iterator(), object);
        if (!((Set)iterable).contains(object)) return 0;
        return 1;
    }

    public static Iterable cycle(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterables$1(iterable);
    }

    public static /* varargs */ Iterable cycle(Object ... arrobject) {
        return Iterables.cycle(Lists.newArrayList(arrobject));
    }

    public static Iterable concat(Iterable iterable, Iterable iterable2) {
        return Iterables.concat((Iterable)ImmutableList.of(iterable, iterable2));
    }

    public static Iterable concat(Iterable iterable, Iterable iterable2, Iterable iterable3) {
        return Iterables.concat((Iterable)ImmutableList.of(iterable, iterable2, iterable3));
    }

    public static Iterable concat(Iterable iterable, Iterable iterable2, Iterable iterable3, Iterable iterable4) {
        return Iterables.concat((Iterable)ImmutableList.of(iterable, iterable2, iterable3, iterable4));
    }

    public static /* varargs */ Iterable concat(Iterable ... arriterable) {
        return Iterables.concat((Iterable)ImmutableList.copyOf(arriterable));
    }

    public static Iterable concat(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterables$2(iterable);
    }

    private static Iterator iterators(Iterable iterable) {
        return new Iterables$3(iterable.iterator());
    }

    public static Iterable partition(Iterable iterable, int n2) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(n2 > 0);
        return new Iterables$4(iterable, n2);
    }

    public static Iterable paddedPartition(Iterable iterable, int n2) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(n2 > 0);
        return new Iterables$5(iterable, n2);
    }

    @GoogleInternal
    public static Iterable pairUp(Iterable iterable, Iterable iterable2) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(iterable2);
        return new Iterables$6(iterable, iterable2);
    }

    @CheckReturnValue
    public static Iterable filter(Iterable iterable, Predicate predicate) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(predicate);
        return new Iterables$7(iterable, predicate);
    }

    @CheckReturnValue
    @GwtIncompatible(value="Class.isInstance")
    public static Iterable filter(Iterable iterable, Class class_) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(class_);
        return new Iterables$8(iterable, class_);
    }

    public static boolean any(Iterable iterable, Predicate predicate) {
        return Iterators.any(iterable.iterator(), predicate);
    }

    public static boolean all(Iterable iterable, Predicate predicate) {
        return Iterators.all(iterable.iterator(), predicate);
    }

    public static Object find(Iterable iterable, Predicate predicate) {
        return Iterators.find(iterable.iterator(), predicate);
    }

    @Nullable
    public static Object find(Iterable iterable, Predicate predicate, @Nullable Object object) {
        return Iterators.find(iterable.iterator(), predicate, object);
    }

    public static Optional tryFind(Iterable iterable, Predicate predicate) {
        return Iterators.tryFind(iterable.iterator(), predicate);
    }

    public static int indexOf(Iterable iterable, Predicate predicate) {
        return Iterators.indexOf(iterable.iterator(), predicate);
    }

    @CheckReturnValue
    public static Iterable transform(Iterable iterable, Function function) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(function);
        return new Iterables$9(iterable, function);
    }

    public static Object get(Iterable iterable, int n2) {
        Object object;
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof List) {
            object = ((List)iterable).get(n2);
            return object;
        }
        object = Iterators.get(iterable.iterator(), n2);
        return object;
    }

    @Nullable
    public static Object get(Iterable iterable, int n2, @Nullable Object object) {
        Object object2;
        Preconditions.checkNotNull(iterable);
        Iterators.checkNonnegative(n2);
        if (!(iterable instanceof List)) {
            Iterator iterator = iterable.iterator();
            Iterators.advance(iterator, n2);
            return Iterators.getNext(iterator, object);
        }
        List list = Lists.cast(iterable);
        if (n2 < list.size()) {
            object2 = list.get(n2);
            return object2;
        }
        object2 = object;
        return object2;
    }

    @Nullable
    public static Object getFirst(Iterable iterable, @Nullable Object object) {
        return Iterators.getNext(iterable.iterator(), object);
    }

    public static Object getLast(Iterable iterable) {
        if (!(iterable instanceof List)) return Iterators.getLast(iterable.iterator());
        List list = (List)iterable;
        if (!list.isEmpty()) return Iterables.getLastInNonemptyList(list);
        throw new NoSuchElementException();
    }

    @Nullable
    public static Object getLast(Iterable iterable, @Nullable Object object) {
        if (!(iterable instanceof Collection)) return Iterators.getLast(iterable.iterator(), object);
        Collection collection = Collections2.cast(iterable);
        if (collection.isEmpty()) {
            return object;
        }
        if (!(iterable instanceof List)) return Iterators.getLast(iterable.iterator(), object);
        return Iterables.getLastInNonemptyList(Lists.cast(iterable));
    }

    private static Object getLastInNonemptyList(List list) {
        return list.get(list.size() - 1);
    }

    public static Iterable skip(Iterable iterable, int n2) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(n2 >= 0, "number to skip cannot be negative");
        if (!(iterable instanceof List)) return new Iterables$11(iterable, n2);
        List list = (List)iterable;
        return new Iterables$10(list, n2);
    }

    public static Iterable limit(Iterable iterable, int n2) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(n2 >= 0, "limit is negative");
        return new Iterables$12(iterable, n2);
    }

    public static Iterable consumingIterable(Iterable iterable) {
        if (iterable instanceof Queue) {
            return new Iterables$13(iterable);
        }
        Preconditions.checkNotNull(iterable);
        return new Iterables$14(iterable);
    }

    public static boolean isEmpty(Iterable iterable) {
        if (iterable instanceof Collection) {
            return ((Collection)iterable).isEmpty();
        }
        if (iterable.iterator().hasNext()) return false;
        return true;
    }

    @Beta
    public static Iterable mergeSorted(Iterable iterable, Comparator comparator) {
        Preconditions.checkNotNull(iterable, "iterables");
        Preconditions.checkNotNull(comparator, "comparator");
        Iterables$15 iterables$15 = new Iterables$15(iterable, comparator);
        return new Iterables$UnmodifiableIterable(iterables$15, null);
    }

    private static Function toIterator() {
        return new Iterables$16();
    }

    static /* synthetic */ Iterator access$100(Iterable iterable) {
        return Iterables.iterators(iterable);
    }

    static /* synthetic */ Function access$200() {
        return Iterables.toIterator();
    }
}

