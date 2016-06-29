package com.google.common.base;

import java.io.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

final class BinaryPredicates$Or implements BinaryPredicate, Serializable
{
    final Iterable predicates;
    private static final long serialVersionUID = -1352468805830701672L;
    
    BinaryPredicates$Or(final Iterable iterable) {
        this.predicates = Preconditions.checkContentsNotNull(iterable);
    }
    
    @Override
    public boolean apply(@Nullable final Object o, @Nullable final Object o2) {
        final Iterator<BinaryPredicate> iterator = this.predicates.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().apply(o, o2)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof BinaryPredicates$Or && iterableElementsEqual(this.predicates, ((BinaryPredicates$Or)o).predicates);
    }
    
    @Override
    public int hashCode() {
        return iterableAsListHashCode(this.predicates);
    }
}
