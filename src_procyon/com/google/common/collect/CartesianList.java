package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.math.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
final class CartesianList extends AbstractList implements RandomAccess
{
    private final transient ImmutableList axes;
    private final transient int[] axesSizeProduct;
    
    static List create(final List list) {
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder(list.size());
        final Iterator<List> iterator = list.iterator();
        while (iterator.hasNext()) {
            final ImmutableList copy = ImmutableList.copyOf(iterator.next());
            if (copy.isEmpty()) {
                return ImmutableList.of();
            }
            immutableList$Builder.add(copy);
        }
        return new CartesianList(immutableList$Builder.build());
    }
    
    CartesianList(final ImmutableList axes) {
        this.axes = axes;
        final int[] axesSizeProduct = new int[axes.size() + 1];
        axesSizeProduct[axes.size()] = 1;
        try {
            for (int i = axes.size() - 1; i >= 0; --i) {
                axesSizeProduct[i] = IntMath.checkedMultiply(axesSizeProduct[i + 1], ((List)axes.get(i)).size());
            }
        }
        catch (ArithmeticException ex) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
        this.axesSizeProduct = axesSizeProduct;
    }
    
    private int getAxisIndexForProductIndex(final int n, final int n2) {
        return n / this.axesSizeProduct[n2 + 1] % this.axes.get(n2).size();
    }
    
    @Override
    public ImmutableList get(final int n) {
        Preconditions.checkElementIndex(n, this.size());
        return new CartesianList$1(this, n);
    }
    
    @Override
    public int size() {
        return this.axesSizeProduct[0];
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        if (!(o instanceof List)) {
            return false;
        }
        final List list = (List)o;
        if (list.size() != this.axes.size()) {
            return false;
        }
        final ListIterator<Object> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (!((List)this.axes.get(listIterator.nextIndex())).contains(listIterator.next())) {
                return false;
            }
        }
        return true;
    }
}
