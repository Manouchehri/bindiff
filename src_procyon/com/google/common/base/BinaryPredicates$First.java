package com.google.common.base;

import java.io.*;
import javax.annotation.*;

final class BinaryPredicates$First implements BinaryPredicate, Serializable
{
    final Predicate predicate;
    private static final long serialVersionUID = 5389902773091803723L;
    
    BinaryPredicates$First(final Predicate predicate) {
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }
    
    @Override
    public boolean apply(@Nullable final Object o, @Nullable final Object o2) {
        return this.predicate.apply(o);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof BinaryPredicates$First && this.predicate.equals(((BinaryPredicates$First)o).predicate);
    }
    
    @Override
    public int hashCode() {
        return this.predicate.hashCode();
    }
}
