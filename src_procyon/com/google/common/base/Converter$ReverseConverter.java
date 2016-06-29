package com.google.common.base;

import java.io.*;
import javax.annotation.*;

final class Converter$ReverseConverter extends Converter implements Serializable
{
    final Converter original;
    private static final long serialVersionUID = 0L;
    
    Converter$ReverseConverter(final Converter original) {
        this.original = original;
    }
    
    @Override
    protected Object doForward(final Object o) {
        throw new AssertionError();
    }
    
    @Override
    protected Object doBackward(final Object o) {
        throw new AssertionError();
    }
    
    @Nullable
    @Override
    Object correctedDoForward(@Nullable final Object o) {
        return this.original.correctedDoBackward(o);
    }
    
    @Nullable
    @Override
    Object correctedDoBackward(@Nullable final Object o) {
        return this.original.correctedDoForward(o);
    }
    
    @Override
    public Converter reverse() {
        return this.original;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Converter$ReverseConverter && this.original.equals(((Converter$ReverseConverter)o).original);
    }
    
    @Override
    public int hashCode() {
        return ~this.original.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.original);
        return new StringBuilder(10 + String.valueOf(value).length()).append(value).append(".reverse()").toString();
    }
}
