package com.google.common.base;

import java.io.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

@CheckReturnValue
@GwtCompatible(serializable = true)
public abstract class Optional implements Serializable
{
    private static final long serialVersionUID = 0L;
    
    public static Optional absent() {
        return Absent.withType();
    }
    
    public static Optional of(final Object o) {
        return new Present(Preconditions.checkNotNull(o));
    }
    
    public static Optional fromNullable(@Nullable final Object o) {
        return (o == null) ? absent() : new Present(o);
    }
    
    public abstract boolean isPresent();
    
    public abstract Object get();
    
    public abstract Object or(final Object p0);
    
    public abstract Optional or(final Optional p0);
    
    @Beta
    public abstract Object or(final Supplier p0);
    
    @Nullable
    public abstract Object orNull();
    
    public abstract Set asSet();
    
    public abstract Optional transform(final Function p0);
    
    @Override
    public abstract boolean equals(@Nullable final Object p0);
    
    @Override
    public abstract int hashCode();
    
    @Override
    public abstract String toString();
    
    @Beta
    public static Iterable presentInstances(final Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        return new Optional$1(iterable);
    }
}
