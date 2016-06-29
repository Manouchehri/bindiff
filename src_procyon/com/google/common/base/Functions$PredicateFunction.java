package com.google.common.base;

import java.io.*;
import javax.annotation.*;

class Functions$PredicateFunction implements Function, Serializable
{
    private final Predicate predicate;
    private static final long serialVersionUID = 0L;
    
    private Functions$PredicateFunction(final Predicate predicate) {
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }
    
    @Override
    public Boolean apply(@Nullable final Object o) {
        return this.predicate.apply(o);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Functions$PredicateFunction && this.predicate.equals(((Functions$PredicateFunction)o).predicate);
    }
    
    @Override
    public int hashCode() {
        return this.predicate.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.predicate);
        return new StringBuilder(24 + String.valueOf(value).length()).append("Functions.forPredicate(").append(value).append(")").toString();
    }
}
