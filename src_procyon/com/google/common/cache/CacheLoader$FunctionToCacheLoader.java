package com.google.common.cache;

import java.io.*;
import com.google.common.base.*;

final class CacheLoader$FunctionToCacheLoader extends CacheLoader implements Serializable
{
    private final Function computingFunction;
    private static final long serialVersionUID = 0L;
    
    public CacheLoader$FunctionToCacheLoader(final Function function) {
        this.computingFunction = (Function)Preconditions.checkNotNull(function);
    }
    
    @Override
    public Object load(final Object o) {
        return this.computingFunction.apply(Preconditions.checkNotNull(o));
    }
}
