package com.google.common.base;

import java.io.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

final class BinaryPredicates$And implements BinaryPredicate, Serializable
{
    final Iterable predicates;
    private static final long serialVersionUID = 4814831122225615776L;
    
    BinaryPredicates$And(final Iterable iterable) {
        this.predicates = Preconditions.checkContentsNotNull(iterable);
    }
    
    @Override
    public boolean apply(@Nullable final Object o, @Nullable final Object o2) {
        final Iterator<BinaryPredicate> iterator = this.predicates.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().apply(o, o2)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof BinaryPredicates$And && iterableElementsEqual(this.predicates, ((BinaryPredicates$And)o).predicates);
    }
    
    @Override
    public int hashCode() {
        return iterableAsListHashCode(this.predicates);
    }
}
