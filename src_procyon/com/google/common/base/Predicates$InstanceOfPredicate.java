package com.google.common.base;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;

@GwtIncompatible("Class.isInstance")
class Predicates$InstanceOfPredicate implements Predicate, Serializable
{
    private final Class clazz;
    private static final long serialVersionUID = 0L;
    
    private Predicates$InstanceOfPredicate(final Class clazz) {
        this.clazz = (Class)Preconditions.checkNotNull(clazz);
    }
    
    @Override
    public boolean apply(@Nullable final Object o) {
        return this.clazz.isInstance(o);
    }
    
    @Override
    public int hashCode() {
        return this.clazz.hashCode();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Predicates$InstanceOfPredicate && this.clazz == ((Predicates$InstanceOfPredicate)o).clazz;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.clazz.getName());
        return new StringBuilder(23 + String.valueOf(value).length()).append("Predicates.instanceOf(").append(value).append(")").toString();
    }
}
