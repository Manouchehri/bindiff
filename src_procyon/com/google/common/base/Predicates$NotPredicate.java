package com.google.common.base;

import java.io.*;
import javax.annotation.*;

class Predicates$NotPredicate implements Predicate, Serializable
{
    final Predicate predicate;
    private static final long serialVersionUID = 0L;
    
    Predicates$NotPredicate(final Predicate predicate) {
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }
    
    @Override
    public boolean apply(@Nullable final Object o) {
        return !this.predicate.apply(o);
    }
    
    @Override
    public int hashCode() {
        return ~this.predicate.hashCode();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Predicates$NotPredicate && this.predicate.equals(((Predicates$NotPredicate)o).predicate);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.predicate);
        return new StringBuilder(16 + String.valueOf(value).length()).append("Predicates.not(").append(value).append(")").toString();
    }
}
