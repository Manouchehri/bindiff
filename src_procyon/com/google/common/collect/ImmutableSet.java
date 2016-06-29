package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;

@GwtCompatible(serializable = true, emulated = true)
public abstract class ImmutableSet extends ImmutableCollection implements Set
{
    static final int MAX_TABLE_SIZE = 1073741824;
    private static final double DESIRED_LOAD_FACTOR = 0.7;
    private static final int CUTOFF = 751619276;
    
    public static ImmutableSet of() {
        return RegularImmutableSet.EMPTY;
    }
    
    public static ImmutableSet of(final Object o) {
        return new SingletonImmutableSet(o);
    }
    
    public static ImmutableSet of(final Object o, final Object o2) {
        return construct(2, o, o2);
    }
    
    public static ImmutableSet of(final Object o, final Object o2, final Object o3) {
        return construct(3, o, o2, o3);
    }
    
    public static ImmutableSet of(final Object o, final Object o2, final Object o3, final Object o4) {
        return construct(4, o, o2, o3, o4);
    }
    
    public static ImmutableSet of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5) {
        return construct(5, o, o2, o3, o4, o5);
    }
    
    public static ImmutableSet of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object... array) {
        final Object[] array2 = new Object[6 + array.length];
        array2[0] = o;
        array2[1] = o2;
        array2[2] = o3;
        array2[3] = o4;
        array2[4] = o5;
        array2[5] = o6;
        System.arraycopy(array, 0, array2, 6, array.length);
        return construct(array2.length, array2);
    }
    
    private static ImmutableSet construct(final int n, final Object... array) {
        switch (n) {
            case 0: {
                return of();
            }
            case 1: {
                return of(array[0]);
            }
            default: {
                final int chooseTableSize = chooseTableSize(n);
                final Object[] array2 = new Object[chooseTableSize];
                final int n2 = chooseTableSize - 1;
                int n3 = 0;
                int n4 = 0;
                for (int i = 0; i < n; ++i) {
                    final Object checkElementNotNull = ObjectArrays.checkElementNotNull(array[i], i);
                    final int hashCode = checkElementNotNull.hashCode();
                    int smear = Hashing.smear(hashCode);
                    while (true) {
                        final int n5 = smear & n2;
                        final Object o = array2[n5];
                        if (o == null) {
                            array2[n5] = (array[n4++] = checkElementNotNull);
                            n3 += hashCode;
                            break;
                        }
                        if (o.equals(checkElementNotNull)) {
                            break;
                        }
                        ++smear;
                    }
                }
                Arrays.fill(array, n4, n, null);
                if (n4 == 1) {
                    return new SingletonImmutableSet(array[0], n3);
                }
                if (chooseTableSize != chooseTableSize(n4)) {
                    return construct(n4, array);
                }
                return new RegularImmutableSet((n4 < array.length) ? ObjectArrays.arraysCopyOf(array, n4) : array, n3, array2, n2);
            }
        }
    }
    
    @VisibleForTesting
    static int chooseTableSize(final int n) {
        if (n < 751619276) {
            int n2;
            for (n2 = Integer.highestOneBit(n - 1) << 1; n2 * 0.7 < n; n2 <<= 1) {}
            return n2;
        }
        Preconditions.checkArgument(n < 1073741824, (Object)"collection too large");
        return 1073741824;
    }
    
    public static ImmutableSet copyOf(final Collection collection) {
        if (collection instanceof ImmutableSet && !(collection instanceof ImmutableSortedSet)) {
            final ImmutableSet set = (ImmutableSet)collection;
            if (!set.isPartialView()) {
                return set;
            }
        }
        else if (collection instanceof EnumSet) {
            return copyOfEnumSet((EnumSet)collection);
        }
        final Object[] array = collection.toArray();
        return construct(array.length, array);
    }
    
    public static ImmutableSet copyOf(final Iterable iterable) {
        return (iterable instanceof Collection) ? copyOf((Collection)iterable) : copyOf(iterable.iterator());
    }
    
    public static ImmutableSet copyOf(final Iterator iterator) {
        if (!iterator.hasNext()) {
            return of();
        }
        final Object next = iterator.next();
        if (!iterator.hasNext()) {
            return of(next);
        }
        return new ImmutableSet$Builder().add(next).addAll(iterator).build();
    }
    
    public static ImmutableSet copyOf(final Object[] array) {
        switch (array.length) {
            case 0: {
                return of();
            }
            case 1: {
                return of(array[0]);
            }
            default: {
                return construct(array.length, (Object[])array.clone());
            }
        }
    }
    
    private static ImmutableSet copyOfEnumSet(final EnumSet set) {
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf((EnumSet<Enum>)set));
    }
    
    boolean isHashCodeFast() {
        return false;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o == this || ((!(o instanceof ImmutableSet) || !this.isHashCodeFast() || !((ImmutableSet)o).isHashCodeFast() || this.hashCode() == o.hashCode()) && Sets.equalsImpl(this, o));
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
}
