/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableEnumSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.ImmutableSet$SerializedForm;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.SingletonImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public abstract class ImmutableSet
extends ImmutableCollection
implements Set {
    static final int MAX_TABLE_SIZE = 1073741824;
    private static final double DESIRED_LOAD_FACTOR = 0.7;
    private static final int CUTOFF = 751619276;

    public static ImmutableSet of() {
        return RegularImmutableSet.EMPTY;
    }

    public static ImmutableSet of(Object object) {
        return new SingletonImmutableSet(object);
    }

    public static ImmutableSet of(Object object, Object object2) {
        return ImmutableSet.construct(2, object, object2);
    }

    public static ImmutableSet of(Object object, Object object2, Object object3) {
        return ImmutableSet.construct(3, object, object2, object3);
    }

    public static ImmutableSet of(Object object, Object object2, Object object3, Object object4) {
        return ImmutableSet.construct(4, object, object2, object3, object4);
    }

    public static ImmutableSet of(Object object, Object object2, Object object3, Object object4, Object object5) {
        return ImmutableSet.construct(5, object, object2, object3, object4, object5);
    }

    public static /* varargs */ ImmutableSet of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object ... arrobject) {
        Object[] arrobject2 = new Object[6 + arrobject.length];
        arrobject2[0] = object;
        arrobject2[1] = object2;
        arrobject2[2] = object3;
        arrobject2[3] = object4;
        arrobject2[4] = object5;
        arrobject2[5] = object6;
        System.arraycopy(arrobject, 0, arrobject2, 6, arrobject.length);
        return ImmutableSet.construct(arrobject2.length, arrobject2);
    }

    private static /* varargs */ ImmutableSet construct(int n2, Object ... arrobject) {
        switch (n2) {
            case 0: {
                return ImmutableSet.of();
            }
            case 1: {
                Object object = arrobject[0];
                return ImmutableSet.of(object);
            }
        }
        int n3 = ImmutableSet.chooseTableSize(n2);
        Object[] arrobject2 = new Object[n3];
        int n4 = n3 - 1;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        do {
            if (n7 >= n2) {
                Arrays.fill(arrobject, n6, n2, null);
                if (n6 == 1) {
                    Object object = arrobject[0];
                    return new SingletonImmutableSet(object, n5);
                }
                if (n3 != ImmutableSet.chooseTableSize(n6)) {
                    return ImmutableSet.construct(n6, arrobject);
                }
                Object[] arrobject3 = n6 < arrobject.length ? ObjectArrays.arraysCopyOf(arrobject, n6) : arrobject;
                return new RegularImmutableSet(arrobject3, n5, arrobject2, n4);
            }
            Object object = ObjectArrays.checkElementNotNull(arrobject[n7], n7);
            int n8 = object.hashCode();
            int n9 = Hashing.smear(n8);
            do {
                Object object2;
                int n10;
                if ((object2 = arrobject2[n10 = n9 & n4]) == null) {
                    arrobject[n6++] = object;
                    arrobject2[n10] = object;
                    n5 += n8;
                    break;
                }
                if (object2.equals(object)) break;
                ++n9;
            } while (true);
            ++n7;
        } while (true);
    }

    @VisibleForTesting
    static int chooseTableSize(int n2) {
        if (n2 < 751619276) {
            int n3 = Integer.highestOneBit(n2 - 1) << 1;
            while ((double)n3 * 0.7 < (double)n2) {
                n3 <<= 1;
            }
            return n3;
        }
        Preconditions.checkArgument(n2 < 1073741824, "collection too large");
        return 1073741824;
    }

    public static ImmutableSet copyOf(Collection collection) {
        Object[] arrobject;
        if (collection instanceof ImmutableSet && !(collection instanceof ImmutableSortedSet)) {
            arrobject = (Object[])collection;
            if (!arrobject.isPartialView()) {
                return arrobject;
            }
        } else if (collection instanceof EnumSet) {
            return ImmutableSet.copyOfEnumSet((EnumSet)collection);
        }
        arrobject = collection.toArray();
        return ImmutableSet.construct(arrobject.length, arrobject);
    }

    public static ImmutableSet copyOf(Iterable iterable) {
        ImmutableSet immutableSet;
        if (iterable instanceof Collection) {
            immutableSet = ImmutableSet.copyOf((Collection)iterable);
            return immutableSet;
        }
        immutableSet = ImmutableSet.copyOf(iterable.iterator());
        return immutableSet;
    }

    public static ImmutableSet copyOf(Iterator iterator) {
        if (!iterator.hasNext()) {
            return ImmutableSet.of();
        }
        Object e2 = iterator.next();
        if (iterator.hasNext()) return new ImmutableSet$Builder().add(e2).addAll(iterator).build();
        return ImmutableSet.of(e2);
    }

    public static ImmutableSet copyOf(Object[] arrobject) {
        switch (arrobject.length) {
            case 0: {
                return ImmutableSet.of();
            }
            case 1: {
                return ImmutableSet.of(arrobject[0]);
            }
        }
        return ImmutableSet.construct(arrobject.length, (Object[])arrobject.clone());
    }

    private static ImmutableSet copyOfEnumSet(EnumSet enumSet) {
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(enumSet));
    }

    ImmutableSet() {
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ImmutableSet)) return Sets.equalsImpl(this, object);
        if (!this.isHashCodeFast()) return Sets.equalsImpl(this, object);
        if (!((ImmutableSet)object).isHashCodeFast()) return Sets.equalsImpl(this, object);
        if (this.hashCode() == object.hashCode()) return Sets.equalsImpl(this, object);
        return false;
    }

    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override
    public abstract UnmodifiableIterator iterator();

    @Override
    Object writeReplace() {
        return new ImmutableSet$SerializedForm(this.toArray());
    }

    public static ImmutableSet$Builder builder() {
        return new ImmutableSet$Builder();
    }

    static /* synthetic */ ImmutableSet access$000(int n2, Object[] arrobject) {
        return ImmutableSet.construct(n2, arrobject);
    }
}

