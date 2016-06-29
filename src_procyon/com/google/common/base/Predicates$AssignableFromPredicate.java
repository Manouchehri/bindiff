package com.google.common.base;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;

@GwtIncompatible("Class.isAssignableFrom")
class Predicates$AssignableFromPredicate implements Predicate, Serializable
{
    private final Class clazz;
    private static final long serialVersionUID = 0L;
    
    private Predicates$AssignableFromPredicate(final Class clazz) {
        this.clazz = (Class)Preconditions.checkNotNull(clazz);
    }
    
    public boolean apply(final Class clazz) {
        return this.clazz.isAssignableFrom(clazz);
    }
    
    @Override
    public int hashCode() {
        return this.clazz.hashCode();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Predicates$AssignableFromPredicate && this.clazz == ((Predicates$AssignableFromPredicate)o).clazz;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.clazz.getName());
        return new StringBuilder(27 + String.valueOf(value).length()).append("Predicates.assignableFrom(").append(value).append(")").toString();
    }
}
