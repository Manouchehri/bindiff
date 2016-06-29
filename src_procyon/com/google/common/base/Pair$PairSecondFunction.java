package com.google.common.base;

import java.io.*;

final class Pair$PairSecondFunction implements Function, Serializable
{
    static final Pair$PairSecondFunction INSTANCE;
    
    public Object apply(final Pair pair) {
        return pair.getSecond();
    }
    
    private Object readResolve() {
        return Pair$PairSecondFunction.INSTANCE;
    }
    
    static {
        INSTANCE = new Pair$PairSecondFunction();
    }
}
