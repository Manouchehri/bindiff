package com.google.common.collect;

import com.google.common.base.*;

final class MapMaker$NullComputingConcurrentMap extends MapMaker$NullConcurrentMap
{
    private static final long serialVersionUID = 0L;
    final Function computingFunction;
    
    MapMaker$NullComputingConcurrentMap(final MapMaker mapMaker, final Function function) {
        super(mapMaker);
        this.computingFunction = (Function)Preconditions.checkNotNull(function);
    }
    
    @Override
    public Object get(final Object o) {
        final Object compute = this.compute(o);
        Preconditions.checkNotNull(compute, "%s returned null for key %s.", this.computingFunction, o);
        this.notifyRemoval(o, compute);
        return compute;
    }
    
    private Object compute(final Object o) {
        Preconditions.checkNotNull(o);
        try {
            return this.computingFunction.apply(o);
        }
        catch (ComputationException ex) {
            throw ex;
        }
        catch (Throwable t) {
            throw new ComputationException(t);
        }
    }
}
