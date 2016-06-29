package com.google.common.base;

import java.io.*;
import javax.annotation.*;

final class BinaryPredicates$Second implements BinaryPredicate, Serializable
{
    final Predicate predicate;
    private static final long serialVersionUID = -7134579481937611424L;
    
    BinaryPredicates$Second(final Predicate predicate) {
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }
    
    @Override
    public boolean apply(@Nullable final Object o, @Nullable final Object o2) {
        return this.predicate.apply(o2);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof BinaryPredicates$Second && this.predicate.equals(((BinaryPredicates$Second)o).predicate);
    }
    
    @Override
    public int hashCode() {
        return this.predicate.hashCode();
    }
}
