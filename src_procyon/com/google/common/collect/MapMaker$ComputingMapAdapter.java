package com.google.common.collect;

import java.io.*;
import com.google.common.base.*;
import java.util.concurrent.*;

final class MapMaker$ComputingMapAdapter extends ComputingConcurrentHashMap implements Serializable
{
    private static final long serialVersionUID = 0L;
    
    MapMaker$ComputingMapAdapter(final MapMaker mapMaker, final Function function) {
        super(mapMaker, function);
    }
    
    @Override
    public Object get(final Object o) {
        Object orCompute;
        try {
            orCompute = this.getOrCompute(o);
        }
        catch (ExecutionException ex) {
            final Throwable cause = ex.getCause();
            Throwables.propagateIfInstanceOf(cause, ComputationException.class);
            throw new ComputationException(cause);
        }
        if (orCompute == null) {
            final String value = String.valueOf(this.computingFunction);
            final String value2 = String.valueOf(o);
            throw new NullPointerException(new StringBuilder(24 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(" returned null for key ").append(value2).append(".").toString());
        }
        return orCompute;
    }
}
