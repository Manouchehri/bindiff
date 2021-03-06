package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;

@GwtCompatible(serializable = true)
final class NullsFirstOrdering extends Ordering implements Serializable
{
    final Ordering ordering;
    private static final long serialVersionUID = 0L;
    
    NullsFirstOrdering(final Ordering ordering) {
        this.ordering = ordering;
    }
    
    @Override
    public int compare(@Nullable final Object o, @Nullable final Object o2) {
        if (o == o2) {
            return 0;
        }
        if (o == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return this.ordering.compare(o, o2);
    }
    
    @Override
    public Ordering reverse() {
        return this.ordering.reverse().nullsLast();
    }
    
    @Override
    public Ordering nullsFirst() {
        return this;
    }
    
    @Override
    public Ordering nullsLast() {
        return this.ordering.nullsLast();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o == this || (o instanceof NullsFirstOrdering && this.ordering.equals(((NullsFirstOrdering)o).ordering));
    }
    
    @Override
    public int hashCode() {
        return this.ordering.hashCode() ^ 0x39153A74;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.ordering);
        return new StringBuilder(13 + String.valueOf(value).length()).append(value).append(".nullsFirst()").toString();
    }
}
