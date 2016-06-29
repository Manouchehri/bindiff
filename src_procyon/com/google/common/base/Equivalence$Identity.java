package com.google.common.base;

import java.io.*;

final class Equivalence$Identity extends Equivalence implements Serializable
{
    static final Equivalence$Identity INSTANCE;
    private static final long serialVersionUID = 1L;
    
    @Override
    protected boolean doEquivalent(final Object o, final Object o2) {
        return false;
    }
    
    @Override
    protected int doHash(final Object o) {
        return System.identityHashCode(o);
    }
    
    private Object readResolve() {
        return Equivalence$Identity.INSTANCE;
    }
    
    static {
        INSTANCE = new Equivalence$Identity();
    }
}
