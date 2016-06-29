package com.google.common.base;

import java.io.*;
import javax.annotation.*;

final class BinaryPredicates$Not implements BinaryPredicate, Serializable
{
    final BinaryPredicate predicate;
    private static final long serialVersionUID = 7318841078083112007L;
    
    BinaryPredicates$Not(final BinaryPredicate binaryPredicate) {
        this.predicate = (BinaryPredicate)Preconditions.checkNotNull(binaryPredicate);
    }
    
    @Override
    public boolean apply(@Nullable final Object o, @Nullable final Object o2) {
        return !this.predicate.apply(o, o2);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof BinaryPredicates$Not && this.predicate.equals(((BinaryPredicates$Not)o).predicate);
    }
    
    @Override
    public int hashCode() {
        return this.predicate.hashCode();
    }
}
