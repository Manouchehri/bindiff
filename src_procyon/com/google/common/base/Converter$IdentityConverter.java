package com.google.common.base;

import java.io.*;

final class Converter$IdentityConverter extends Converter implements Serializable
{
    static final Converter$IdentityConverter INSTANCE;
    private static final long serialVersionUID = 0L;
    
    @Override
    protected Object doForward(final Object o) {
        return o;
    }
    
    @Override
    protected Object doBackward(final Object o) {
        return o;
    }
    
    @Override
    public Converter$IdentityConverter reverse() {
        return this;
    }
    
    @Override
    Converter doAndThen(final Converter converter) {
        return (Converter)Preconditions.checkNotNull(converter, (Object)"otherConverter");
    }
    
    @Override
    public String toString() {
        return "Converter.identity()";
    }
    
    private Object readResolve() {
        return Converter$IdentityConverter.INSTANCE;
    }
    
    static {
        INSTANCE = new Converter$IdentityConverter();
    }
}
