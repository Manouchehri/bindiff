package com.google.common.primitives;

import com.google.common.base.*;
import java.io.*;

final class Ints$IntConverter extends Converter implements Serializable
{
    static final Ints$IntConverter INSTANCE;
    private static final long serialVersionUID = 1L;
    
    protected Integer doForward(final String s) {
        return Integer.decode(s);
    }
    
    protected String doBackward(final Integer n) {
        return n.toString();
    }
    
    @Override
    public String toString() {
        return "Ints.stringConverter()";
    }
    
    private Object readResolve() {
        return Ints$IntConverter.INSTANCE;
    }
    
    static {
        INSTANCE = new Ints$IntConverter();
    }
}
