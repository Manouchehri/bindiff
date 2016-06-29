package com.google.common.primitives;

import com.google.common.base.*;
import java.io.*;

final class Shorts$ShortConverter extends Converter implements Serializable
{
    static final Shorts$ShortConverter INSTANCE;
    private static final long serialVersionUID = 1L;
    
    protected Short doForward(final String s) {
        return Short.decode(s);
    }
    
    protected String doBackward(final Short n) {
        return n.toString();
    }
    
    @Override
    public String toString() {
        return "Shorts.stringConverter()";
    }
    
    private Object readResolve() {
        return Shorts$ShortConverter.INSTANCE;
    }
    
    static {
        INSTANCE = new Shorts$ShortConverter();
    }
}
