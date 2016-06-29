package com.google.common.base;

import java.io.*;
import javax.annotation.*;

final class Converter$FunctionBasedConverter extends Converter implements Serializable
{
    private final Function forwardFunction;
    private final Function backwardFunction;
    
    private Converter$FunctionBasedConverter(final Function function, final Function function2) {
        this.forwardFunction = (Function)Preconditions.checkNotNull(function);
        this.backwardFunction = (Function)Preconditions.checkNotNull(function2);
    }
    
    @Override
    protected Object doForward(final Object o) {
        return this.forwardFunction.apply(o);
    }
    
    @Override
    protected Object doBackward(final Object o) {
        return this.backwardFunction.apply(o);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Converter$FunctionBasedConverter) {
            final Converter$FunctionBasedConverter converter$FunctionBasedConverter = (Converter$FunctionBasedConverter)o;
            return this.forwardFunction.equals(converter$FunctionBasedConverter.forwardFunction) && this.backwardFunction.equals(converter$FunctionBasedConverter.backwardFunction);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.forwardFunction.hashCode() * 31 + this.backwardFunction.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.forwardFunction);
        final String value2 = String.valueOf(this.backwardFunction);
        return new StringBuilder(18 + String.valueOf(value).length() + String.valueOf(value2).length()).append("Converter.from(").append(value).append(", ").append(value2).append(")").toString();
    }
}
