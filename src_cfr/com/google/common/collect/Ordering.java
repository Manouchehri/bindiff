/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AllEqualOrdering;
import com.google.common.collect.ByFunctionOrdering;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ComparatorOrdering;
import com.google.common.collect.CompoundOrdering;
import com.google.common.collect.ExplicitOrdering;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.LexicographicalOrdering;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.NullsFirstOrdering;
import com.google.common.collect.NullsLastOrdering;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Ordering$ArbitraryOrderingHolder;
import com.google.common.collect.ReverseOrdering;
import com.google.common.collect.UsingToStringOrdering;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Ordering
implements Comparator {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    @GwtCompatible(serializable=1)
    public static Ordering natural() {
        return NaturalOrdering.INSTANCE;
    }

    @GwtCompatible(serializable=1)
    public static Ordering from(Comparator comparator) {
        Ordering ordering;
        if (comparator instanceof Ordering) {
            ordering = (Ordering)comparator;
            return ordering;
        }
        ordering = new ComparatorOrdering(comparator);
        return ordering;
    }

    @Deprecated
    @GwtCompatible(serializable=1)
    public static Ordering from(Ordering ordering) {
        return (Ordering)Preconditions.checkNotNull(ordering);
    }

    @GwtCompatible(serializable=1)
    public static Ordering explicit(List list) {
        return new ExplicitOrdering(list);
    }

    @GwtCompatible(serializable=1)
    public static /* varargs */ Ordering explicit(Object object, Object ... arrobject) {
        return Ordering.explicit(Lists.asList(object, arrobject));
    }

    @GwtCompatible(serializable=1)
    public static Ordering allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    @GwtCompatible(serializable=1)
    public static Ordering usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    public static Ordering arbitrary() {
        return Ordering$ArbitraryOrderingHolder.ARBITRARY_ORDERING;
    }

    protected Ordering() {
    }

    @GwtCompatible(serializable=1)
    public Ordering reverse() {
        return new ReverseOrdering(this);
    }

    @GwtCompatible(serializable=1)
    public Ordering nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    @GwtCompatible(serializable=1)
    public Ordering nullsLast() {
        return new NullsLastOrdering(this);
    }

    @GwtCompatible(serializable=1)
    public Ordering onResultOf(Function function) {
        return new ByFunctionOrdering(function, this);
    }

    Ordering onKeys() {
        return this.onResultOf(Maps.keyFunction());
    }

    @GwtCompatible(serializable=1)
    public Ordering compound(Comparator comparator) {
        return new CompoundOrdering(this, (Comparator)Preconditions.checkNotNull(comparator));
    }

    @GwtCompatible(serializable=1)
    public static Ordering compound(Iterable iterable) {
        return new CompoundOrdering(iterable);
    }

    @GwtCompatible(serializable=1)
    public Ordering lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public abstract int compare(@Nullable Object var1, @Nullable Object var2);

    public Object min(Iterator iterator) {
        Object object = iterator.next();
        while (iterator.hasNext()) {
            object = this.min(object, iterator.next());
        }
        return object;
    }

    public Object min(Iterable iterable) {
        return this.min(iterable.iterator());
    }

    public Object min(@Nullable Object object, @Nullable Object object2) {
        Object object3;
        if (this.compare(object, object2) <= 0) {
            object3 = object;
            return object3;
        }
        object3 = object2;
        return object3;
    }

    public /* varargs */ Object min(@Nullable Object object, @Nullable Object object2, @Nullable Object object3, Object ... arrobject) {
        Object object4 = this.min(this.min(object, object2), object3);
        Object[] arrobject2 = arrobject;
        int n2 = arrobject2.length;
        int n3 = 0;
        while (n3 < n2) {
            Object object5 = arrobject2[n3];
            object4 = this.min(object4, object5);
            ++n3;
        }
        return object4;
    }

    public Object max(Iterator iterator) {
        Object object = iterator.next();
        while (iterator.hasNext()) {
            object = this.max(object, iterator.next());
        }
        return object;
    }

    public Object max(Iterable iterable) {
        return this.max(iterable.iterator());
    }

    public Object max(@Nullable Object object, @Nullable Object object2) {
        Object object3;
        if (this.compare(object, object2) >= 0) {
            object3 = object;
            return object3;
        }
        object3 = object2;
        return object3;
    }

    public /* varargs */ Object max(@Nullable Object object, @Nullable Object object2, @Nullable Object object3, Object ... arrobject) {
        Object object4 = this.max(this.max(object, object2), object3);
        Object[] arrobject2 = arrobject;
        int n2 = arrobject2.length;
        int n3 = 0;
        while (n3 < n2) {
            Object object5 = arrobject2[n3];
            object4 = this.max(object4, object5);
            ++n3;
        }
        return object4;
    }

    public List leastOf(Iterable iterable, int n2) {
        if (!(iterable instanceof Collection)) return this.leastOf(iterable.iterator(), n2);
        Collection collection = (Collection)iterable;
        if ((long)collection.size() > 2 * (long)n2) return this.leastOf(iterable.iterator(), n2);
        Object[] arrobject = collection.toArray();
        Arrays.sort(arrobject, this);
        if (arrobject.length <= n2) return Collections.unmodifiableList(Arrays.asList(arrobject));
        arrobject = ObjectArrays.arraysCopyOf(arrobject, n2);
        return Collections.unmodifiableList(Arrays.asList(arrobject));
    }

    /*
     * Unable to fully structure code
     */
    public List leastOf(Iterator var1_1, int var2_2) {
        Preconditions.checkNotNull(var1_1);
        CollectPreconditions.checkNonnegative(var2_2, "k");
        if (var2_2 == 0) return ImmutableList.of();
        if (!var1_1.hasNext()) {
            return ImmutableList.of();
        }
        if (var2_2 >= 1073741823) {
            var3_3 = Lists.newArrayList(var1_1);
            Collections.sort(var3_3, this);
            if (var3_3.size() > var2_2) {
                var3_3.subList(var2_2, var3_3.size()).clear();
            }
            var3_3.trimToSize();
            return Collections.unmodifiableList(var3_3);
        }
        var3_4 = var2_2 * 2;
        var4_5 = new Object[var3_4];
        var4_5[0] = var5_6 = var1_1.next();
        var6_7 = 1;
        while (var6_7 < var2_2 && var1_1.hasNext()) {
            var7_8 = var1_1.next();
            var4_5[var6_7++] = var7_8;
            var5_6 = this.max(var5_6, var7_8);
        }
        block1 : do lbl-1000: // 4 sources:
        {
            if (!var1_1.hasNext()) {
                Arrays.sort(var4_5, 0, var6_7, this);
                var6_7 = Math.min(var6_7, var2_2);
                return Collections.unmodifiableList(Arrays.asList(ObjectArrays.arraysCopyOf(var4_5, var6_7)));
            }
            var7_8 = var1_1.next();
            if (this.compare(var7_8, var5_6) >= 0) ** GOTO lbl-1000
            var4_5[var6_7++] = var7_8;
            if (var6_7 != var3_4) ** GOTO lbl-1000
            var8_9 = 0;
            var9_10 = var3_4 - 1;
            var10_11 = 0;
            while (var8_9 < var9_10) {
                var11_12 = var8_9 + var9_10 + 1 >>> 1;
                var12_13 = this.partition(var4_5, var8_9, var9_10, var11_12);
                if (var12_13 > var2_2) {
                    var9_10 = var12_13 - 1;
                    continue;
                }
                if (var12_13 >= var2_2) break;
                var8_9 = Math.max(var12_13, var8_9 + 1);
                var10_11 = var12_13;
            }
            var6_7 = var2_2;
            var5_6 = var4_5[var10_11];
            var11_12 = var10_11 + 1;
            do {
                if (var11_12 >= var6_7) continue block1;
                var5_6 = this.max(var5_6, var4_5[var11_12]);
                ++var11_12;
            } while (true);
            break;
        } while (true);
    }

    private int partition(Object[] arrobject, int n2, int n3, int n4) {
        Object object = arrobject[n4];
        arrobject[n4] = arrobject[n3];
        arrobject[n3] = object;
        int n5 = n2;
        int n6 = n2;
        do {
            if (n6 >= n3) {
                ObjectArrays.swap(arrobject, n3, n5);
                return n5;
            }
            if (this.compare(arrobject[n6], object) < 0) {
                ObjectArrays.swap(arrobject, n5, n6);
                ++n5;
            }
            ++n6;
        } while (true);
    }

    public List greatestOf(Iterable iterable, int n2) {
        return this.reverse().leastOf(iterable, n2);
    }

    public List greatestOf(Iterator iterator, int n2) {
        return this.reverse().leastOf(iterator, n2);
    }

    public List sortedCopy(Iterable iterable) {
        Object[] arrobject = Iterables.toArray(iterable);
        Arrays.sort(arrobject, this);
        return Lists.newArrayList(Arrays.asList(arrobject));
    }

    public ImmutableList immutableSortedCopy(Iterable iterable) {
        Object[] arrobject;
        Object[] arrobject2 = arrobject = Iterables.toArray(iterable);
        int n2 = arrobject2.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                Arrays.sort(arrobject, this);
                return ImmutableList.asImmutableList(arrobject);
            }
            Object object = arrobject2[n3];
            Preconditions.checkNotNull(object);
            ++n3;
        } while (true);
    }

    public boolean isOrdered(Iterable iterable) {
        Iterator<T> iterator = iterable.iterator();
        if (!iterator.hasNext()) return true;
        T t2 = iterator.next();
        while (iterator.hasNext()) {
            T t3 = iterator.next();
            if (this.compare(t2, t3) > 0) {
                return false;
            }
            t2 = t3;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable iterable) {
        Iterator<T> iterator = iterable.iterator();
        if (!iterator.hasNext()) return true;
        T t2 = iterator.next();
        while (iterator.hasNext()) {
            T t3 = iterator.next();
            if (this.compare(t2, t3) >= 0) {
                return false;
            }
            t2 = t3;
        }
        return true;
    }

    public int binarySearch(List list, @Nullable Object object) {
        return Collections.binarySearch(list, object, this);
    }
}

