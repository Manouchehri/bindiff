package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;

@GwtCompatible(serializable = true)
final class ExplicitOrdering extends Ordering implements Serializable
{
    final ImmutableMap rankMap;
    private static final long serialVersionUID = 0L;
    
    ExplicitOrdering(final List list) {
        this(Maps.indexMap(list));
    }
    
    ExplicitOrdering(final ImmutableMap rankMap) {
        this.rankMap = rankMap;
    }
    
    @Override
    public int compare(final Object o, final Object o2) {
        return this.rank(o) - this.rank(o2);
    }
    
    private int rank(final Object o) {
        final Integer n = (Integer)this.rankMap.get(o);
        if (n == null) {
            throw new Ordering$IncomparableValueException(o);
        }
        return n;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof ExplicitOrdering && this.rankMap.equals(((ExplicitOrdering)o).rankMap);
    }
    
    @Override
    public int hashCode() {
        return this.rankMap.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.rankMap.keySet());
        return new StringBuilder(19 + String.valueOf(value).length()).append("Ordering.explicit(").append(value).append(")").toString();
    }
}
