package com.google.common.base;

import java.io.*;

final class Equivalence$Equals extends Equivalence implements Serializable
{
    static final Equivalence$Equals INSTANCE;
    private static final long serialVersionUID = 1L;
    
    @Override
    protected boolean doEquivalent(final Object o, final Object o2) {
        return o.equals(o2);
    }
    
    @Override
    protected int doHash(final Object o) {
        return o.hashCode();
    }
    
    private Object readResolve() {
        return Equivalence$Equals.INSTANCE;
    }
    
    static {
        INSTANCE = new Equivalence$Equals();
    }
}
