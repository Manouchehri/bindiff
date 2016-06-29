package com.google.common.base;

import java.io.*;
import javax.annotation.*;

class Predicates$IsEqualToPredicate implements Predicate, Serializable
{
    private final Object target;
    private static final long serialVersionUID = 0L;
    
    private Predicates$IsEqualToPredicate(final Object target) {
        this.target = target;
    }
    
    @Override
    public boolean apply(final Object o) {
        return this.target.equals(o);
    }
    
    @Override
    public int hashCode() {
        return this.target.hashCode();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Predicates$IsEqualToPredicate && this.target.equals(((Predicates$IsEqualToPredicate)o).target);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.target);
        return new StringBuilder(20 + String.valueOf(value).length()).append("Predicates.equalTo(").append(value).append(")").toString();
    }
}
