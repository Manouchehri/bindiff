/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList$1;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableList$ReverseImmutableList;
import com.google.common.collect.ImmutableList$SerializedForm;
import com.google.common.collect.ImmutableList$SubList;
import com.google.common.collect.Lists;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.SingletonImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public abstract class ImmutableList
extends ImmutableCollection
implements List,
RandomAccess {
    public static ImmutableList of() {
        return RegularImmutableList.EMPTY;
    }

    public static ImmutableList of(Object object) {
        return new SingletonImmutableList(object);
    }

    public static ImmutableList of(Object object, Object object2) {
        return ImmutableList.construct(object, object2);
    }

    public static ImmutableList of(Object object, Object object2, Object object3) {
        return ImmutableList.construct(object, object2, object3);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4) {
        return ImmutableList.construct(object, object2, object3, object4);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5) {
        return ImmutableList.construct(object, object2, object3, object4, object5);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        return ImmutableList.construct(object, object2, object3, object4, object5, object6);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        return ImmutableList.construct(object, object2, object3, object4, object5, object6, object7);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        return ImmutableList.construct(object, object2, object3, object4, object5, object6, object7, object8);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
        return ImmutableList.construct(object, object2, object3, object4, object5, object6, object7, object8, object9);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        return ImmutableList.construct(object, object2, object3, object4, object5, object6, object7, object8, object9, object10);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11) {
        return ImmutableList.construct(object, object2, object3, object4, object5, object6, object7, object8, object9, object10, object11);
    }

    public static /* varargs */ ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object ... arrobject) {
        Object[] arrobject2 = new Object[12 + arrobject.length];
        arrobject2[0] = object;
        arrobject2[1] = object2;
        arrobject2[2] = object3;
        arrobject2[3] = object4;
        arrobject2[4] = object5;
        arrobject2[5] = object6;
        arrobject2[6] = object7;
        arrobject2[7] = object8;
        arrobject2[8] = object9;
        arrobject2[9] = object10;
        arrobject2[10] = object11;
        arrobject2[11] = object12;
        System.arraycopy(arrobject, 0, arrobject2, 12, arrobject.length);
        return ImmutableList.construct(arrobject2);
    }

    public static ImmutableList copyOf(Iterable iterable) {
        ImmutableList immutableList;
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            immutableList = ImmutableList.copyOf((Collection)iterable);
            return immutableList;
        }
        immutableList = ImmutableList.copyOf(iterable.iterator());
        return immutableList;
    }

    public static ImmutableList copyOf(Collection collection) {
        ImmutableList immutableList;
        if (!(collection instanceof ImmutableCollection)) return ImmutableList.construct(collection.toArray());
        ImmutableList immutableList2 = ((ImmutableCollection)collection).asList();
        if (immutableList2.isPartialView()) {
            immutableList = ImmutableList.asImmutableList(immutableList2.toArray());
            return immutableList;
        }
        immutableList = immutableList2;
        return immutableList;
    }

    public static ImmutableList copyOf(Iterator iterator) {
        if (!iterator.hasNext()) {
            return ImmutableList.of();
        }
        Object e2 = iterator.next();
        if (iterator.hasNext()) return new ImmutableList$Builder().add(e2).addAll(iterator).build();
        return ImmutableList.of(e2);
    }

    public static ImmutableList copyOf(Object[] arrobject) {
        switch (arrobject.length) {
            case 0: {
                return ImmutableList.of();
            }
            case 1: {
                return new SingletonImmutableList(arrobject[0]);
            }
        }
        return new RegularImmutableList(ObjectArrays.checkElementsNotNull((Object[])arrobject.clone()));
    }

    private static /* varargs */ ImmutableList construct(Object ... arrobject) {
        return ImmutableList.asImmutableList(ObjectArrays.checkElementsNotNull(arrobject));
    }

    static ImmutableList asImmutableList(Object[] arrobject) {
        return ImmutableList.asImmutableList(arrobject, arrobject.length);
    }

    static ImmutableList asImmutableList(Object[] arrobject, int n2) {
        switch (n2) {
            case 0: {
                return ImmutableList.of();
            }
            case 1: {
                return new SingletonImmutableList(arrobject[0]);
            }
        }
        if (n2 >= arrobject.length) return new RegularImmutableList(arrobject);
        arrobject = ObjectArrays.arraysCopyOf(arrobject, n2);
        return new RegularImmutableList(arrobject);
    }

    ImmutableList() {
    }

    @Override
    public UnmodifiableIterator iterator() {
        return this.listIterator();
    }

    public UnmodifiableListIterator listIterator() {
        return this.listIterator(0);
    }

    public UnmodifiableListIterator listIterator(int n2) {
        return new ImmutableList$1(this, this.size(), n2);
    }

    @Override
    public int indexOf(@Nullable Object object) {
        if (object == null) {
            return -1;
        }
        int n2 = Lists.indexOfImpl(this, object);
        return n2;
    }

    @Override
    public int lastIndexOf(@Nullable Object object) {
        if (object == null) {
            return -1;
        }
        int n2 = Lists.lastIndexOfImpl(this, object);
        return n2;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (this.indexOf(object) < 0) return false;
        return true;
    }

    public ImmutableList subList(int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n3, this.size());
        int n4 = n3 - n2;
        if (n4 == this.size()) {
            return this;
        }
        switch (n4) {
            case 0: {
                return ImmutableList.of();
            }
            case 1: {
                return ImmutableList.of(this.get(n2));
            }
        }
        return this.subListUnchecked(n2, n3);
    }

    ImmutableList subListUnchecked(int n2, int n3) {
        return new ImmutableList$SubList(this, n2, n3 - n2);
    }

    @Deprecated
    public final boolean addAll(int n2, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object set(int n2, Object object) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int n2, Object object) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object remove(int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final ImmutableList asList() {
        return this;
    }

    @Override
    int copyIntoArray(Object[] arrobject, int n2) {
        int n3 = this.size();
        int n4 = 0;
        while (n4 < n3) {
            arrobject[n2 + n4] = this.get(n4);
            ++n4;
        }
        return n2 + n3;
    }

    public ImmutableList reverse() {
        ImmutableList immutableList;
        if (this.size() <= 1) {
            immutableList = this;
            return immutableList;
        }
        immutableList = new ImmutableList$ReverseImmutableList(this);
        return immutableList;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Lists.equalsImpl(this, object);
    }

    @Override
    public int hashCode() {
        int n2 = 1;
        int n3 = this.size();
        int n4 = 0;
        while (n4 < n3) {
            n2 = 31 * n2 + this.get(n4).hashCode();
            n2 = ~ (~ n2);
            ++n4;
        }
        return n2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override
    Object writeReplace() {
        return new ImmutableList$SerializedForm(this.toArray());
    }

    public static ImmutableList$Builder builder() {
        return new ImmutableList$Builder();
    }
}

