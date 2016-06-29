package com.google.common.primitives;

import com.google.common.base.*;
import java.io.*;

final class Longs$LongConverter extends Converter implements Serializable
{
    static final Longs$LongConverter INSTANCE;
    private static final long serialVersionUID = 1L;
    
    protected Long doForward(final String s) {
        return Long.decode(s);
    }
    
    protected String doBackward(final Long n) {
        return n.toString();
    }
    
    @Override
    public String toString() {
        return "Longs.stringConverter()";
    }
    
    private Object readResolve() {
        return Longs$LongConverter.INSTANCE;
    }
    
    static {
        INSTANCE = new Longs$LongConverter();
    }
}
