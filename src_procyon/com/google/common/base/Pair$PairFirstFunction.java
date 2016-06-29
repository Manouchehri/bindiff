package com.google.common.base;

import java.io.*;

final class Pair$PairFirstFunction implements Function, Serializable
{
    static final Pair$PairFirstFunction INSTANCE;
    
    public Object apply(final Pair pair) {
        return pair.getFirst();
    }
    
    private Object readResolve() {
        return Pair$PairFirstFunction.INSTANCE;
    }
    
    static {
        INSTANCE = new Pair$PairFirstFunction();
    }
}
