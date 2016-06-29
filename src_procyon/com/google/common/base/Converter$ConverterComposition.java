package com.google.common.base;

import java.io.*;
import javax.annotation.*;

final class Converter$ConverterComposition extends Converter implements Serializable
{
    final Converter first;
    final Converter second;
    private static final long serialVersionUID = 0L;
    
    Converter$ConverterComposition(final Converter first, final Converter second) {
        this.first = first;
        this.second = second;
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
        return this.second.correctedDoForward(this.first.correctedDoForward(o));
    }
    
    @Nullable
    @Override
    Object correctedDoBackward(@Nullable final Object o) {
        return this.first.correctedDoBackward(this.second.correctedDoBackward(o));
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Converter$ConverterComposition) {
            final Converter$ConverterComposition converter$ConverterComposition = (Converter$ConverterComposition)o;
            return this.first.equals(converter$ConverterComposition.first) && this.second.equals(converter$ConverterComposition.second);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.first.hashCode() + this.second.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.first);
        final String value2 = String.valueOf(this.second);
        return new StringBuilder(10 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(".andThen(").append(value2).append(")").toString();
    }
}
