package com.google.common.primitives;

import com.google.common.base.*;
import java.io.*;

final class Doubles$DoubleConverter extends Converter implements Serializable
{
    static final Doubles$DoubleConverter INSTANCE;
    private static final long serialVersionUID = 1L;
    
    protected Double doForward(final String s) {
        return Double.valueOf(s);
    }
    
    protected String doBackward(final Double n) {
        return n.toString();
    }
    
    @Override
    public String toString() {
        return "Doubles.stringConverter()";
    }
    
    private Object readResolve() {
        return Doubles$DoubleConverter.INSTANCE;
    }
    
    static {
        INSTANCE = new Doubles$DoubleConverter();
    }
}
