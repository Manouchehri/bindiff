package com.google.common.primitives;

import com.google.common.base.*;
import java.io.*;

final class Floats$FloatConverter extends Converter implements Serializable
{
    static final Floats$FloatConverter INSTANCE;
    private static final long serialVersionUID = 1L;
    
    protected Float doForward(final String s) {
        return Float.valueOf(s);
    }
    
    protected String doBackward(final Float n) {
        return n.toString();
    }
    
    @Override
    public String toString() {
        return "Floats.stringConverter()";
    }
    
    private Object readResolve() {
        return Floats$FloatConverter.INSTANCE;
    }
    
    static {
        INSTANCE = new Floats$FloatConverter();
    }
}
