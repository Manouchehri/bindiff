/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Platform;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class ObjectArrays {
    static final Object[] EMPTY_ARRAY = new Object[0];

    private ObjectArrays() {
    }

    @GwtIncompatible(value="Array.newInstance(Class, int)")
    public static Object[] newArray(Class class_, int n2) {
        return (Object[])Array.newInstance(class_, n2);
    }

    public static Object[] newArray(Object[] arrobject, int n2) {
        return Platform.newArray(arrobject, n2);
    }

    @GwtIncompatible(value="Array.newInstance(Class, int)")
    public static Object[] concat(Object[] arrobject, Object[] arrobject2, Class class_) {
        Object[] arrobject3 = ObjectArrays.newArray(class_, arrobject.length + arrobject2.length);
        System.arraycopy(arrobject, 0, arrobject3, 0, arrobject.length);
        System.arraycopy(arrobject2, 0, arrobject3, arrobject.length, arrobject2.length);
        return arrobject3;
    }

    public static Object[] concat(@Nullable Object object, Object[] arrobject) {
        Object[] arrobject2 = ObjectArrays.newArray(arrobject, arrobject.length + 1);
        arrobject2[0] = object;
        System.arraycopy(arrobject, 0, arrobject2, 1, arrobject.length);
        return arrobject2;
    }

    public static Object[] concat(Object[] arrobject, @Nullable Object object) {
        Object[] arrobject2 = ObjectArrays.arraysCopyOf(arrobject, arrobject.length + 1);
        arrobject2[arrobject.length] = object;
        return arrobject2;
    }

    static Object[] arraysCopyOf(Object[] arrobject, int n2) {
        Object[] arrobject2 = ObjectArrays.newArray(arrobject, n2);
        System.arraycopy(arrobject, 0, arrobject2, 0, Math.min(arrobject.length, n2));
        return arrobject2;
    }

    static Object[] toArrayImpl(Collection collection, Object[] arrobject) {
        int n2 = collection.size();
        if (arrobject.length < n2) {
            arrobject = ObjectArrays.newArray(arrobject, n2);
        }
        ObjectArrays.fillArray(collection, arrobject);
        if (arrobject.length <= n2) return arrobject;
        arrobject[n2] = null;
        return arrobject;
    }

    static Object[] toArrayImpl(Object[] arrobject, int n2, int n3, Object[] arrobject2) {
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrobject.length);
        if (arrobject2.length < n3) {
            arrobject2 = ObjectArrays.newArray(arrobject2, n3);
        } else if (arrobject2.length > n3) {
            arrobject2[n3] = null;
        }
        System.arraycopy(arrobject, n2, arrobject2, 0, n3);
        return arrobject2;
    }

    static Object[] toArrayImpl(Collection collection) {
        return ObjectArrays.fillArray(collection, new Object[collection.size()]);
    }

    static Object[] copyAsObjectArray(Object[] arrobject, int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrobject.length);
        if (n3 == 0) {
            return EMPTY_ARRAY;
        }
        Object[] arrobject2 = new Object[n3];
        System.arraycopy(arrobject, n2, arrobject2, 0, n3);
        return arrobject2;
    }

    private static Object[] fillArray(Iterable iterable, Object[] arrobject) {
        int n2 = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            arrobject[n2++] = t2;
        }
        return arrobject;
    }

    static void swap(Object[] arrobject, int n2, int n3) {
        Object object = arrobject[n2];
        arrobject[n2] = arrobject[n3];
        arrobject[n3] = object;
    }

    static /* varargs */ Object[] checkElementsNotNull(Object ... arrobject) {
        return ObjectArrays.checkElementsNotNull(arrobject, arrobject.length);
    }

    static Object[] checkElementsNotNull(Object[] arrobject, int n2) {
        int n3 = 0;
        while (n3 < n2) {
            ObjectArrays.checkElementNotNull(arrobject[n3], n3);
            ++n3;
        }
        return arrobject;
    }

    static Object checkElementNotNull(Object object, int n2) {
        if (object != null) return object;
        throw new NullPointerException(new StringBuilder(20).append("at index ").append(n2).toString());
    }
}

