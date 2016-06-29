package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible(serializable = true)
final class CompoundOrdering extends Ordering implements Serializable
{
    final ImmutableList comparators;
    private static final long serialVersionUID = 0L;
    
    CompoundOrdering(final Comparator comparator, final Comparator comparator2) {
        this.comparators = ImmutableList.of(comparator, comparator2);
    }
    
    CompoundOrdering(final Iterable iterable) {
        this.comparators = ImmutableList.copyOf(iterable);
    }
    
    @Override
    public int compare(final Object o, final Object o2) {
        for (int size = this.comparators.size(), i = 0; i < size; ++i) {
            final int compare = this.comparators.get(i).compare(o, o2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this || (o instanceof CompoundOrdering && this.comparators.equals(((CompoundOrdering)o).comparators));
    }
    
    @Override
    public int hashCode() {
        return this.comparators.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.comparators);
        return new StringBuilder(19 + String.valueOf(value).length()).append("Ordering.compound(").append(value).append(")").toString();
    }
}
