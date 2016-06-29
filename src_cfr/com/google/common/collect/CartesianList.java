/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.CartesianList$1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
final class CartesianList
extends AbstractList
implements RandomAccess {
    private final transient ImmutableList axes;
    private final transient int[] axesSizeProduct;

    static List create(List list) {
        ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            List list2 = (List)iterator.next();
            ImmutableList immutableList = ImmutableList.copyOf(list2);
            if (immutableList.isEmpty()) {
                return ImmutableList.of();
            }
            immutableList$Builder.add((Object)immutableList);
        }
        return new CartesianList(immutableList$Builder.build());
    }

    CartesianList(ImmutableList immutableList) {
        this.axes = immutableList;
        int[] arrn = new int[immutableList.size() + 1];
        arrn[immutableList.size()] = 1;
        try {
            for (int i2 = immutableList.size() - 1; i2 >= 0; --i2) {
                arrn[i2] = IntMath.checkedMultiply(arrn[i2 + 1], ((List)immutableList.get(i2)).size());
            }
        }
        catch (ArithmeticException var3_4) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
        this.axesSizeProduct = arrn;
    }

    private int getAxisIndexForProductIndex(int n2, int n3) {
        return n2 / this.axesSizeProduct[n3 + 1] % ((List)this.axes.get(n3)).size();
    }

    @Override
    public ImmutableList get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        return new CartesianList$1(this, n2);
    }

    @Override
    public int size() {
        return this.axesSizeProduct[0];
    }

    @Override
    public boolean contains(@Nullable Object object) {
        int n2;
        if (!(object instanceof List)) {
            return false;
        }
        List list = (List)object;
        if (list.size() != this.axes.size()) {
            return false;
        }
        ListIterator listIterator = list.listIterator();
        do {
            if (!listIterator.hasNext()) return true;
        } while (((List)this.axes.get(n2 = listIterator.nextIndex())).contains(listIterator.next()));
        return false;
    }

    static /* synthetic */ ImmutableList access$000(CartesianList cartesianList) {
        return cartesianList.axes;
    }

    static /* synthetic */ int access$100(CartesianList cartesianList, int n2, int n3) {
        return cartesianList.getAxisIndexForProductIndex(n2, n3);
    }
}

