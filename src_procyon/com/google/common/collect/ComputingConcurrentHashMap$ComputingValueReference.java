package com.google.common.collect;

import com.google.common.base.*;
import javax.annotation.concurrent.*;
import java.lang.ref.*;
import javax.annotation.*;
import java.util.concurrent.*;

final class ComputingConcurrentHashMap$ComputingValueReference implements MapMakerInternalMap$ValueReference
{
    final Function computingFunction;
    @GuardedBy("this")
    volatile MapMakerInternalMap$ValueReference computedReference;
    
    public ComputingConcurrentHashMap$ComputingValueReference(final Function computingFunction) {
        this.computedReference = MapMakerInternalMap.unset();
        this.computingFunction = computingFunction;
    }
    
    @Override
    public Object get() {
        return null;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getEntry() {
        return null;
    }
    
    @Override
    public MapMakerInternalMap$ValueReference copyFor(final ReferenceQueue referenceQueue, @Nullable final Object o, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this;
    }
    
    @Override
    public boolean isComputingReference() {
        return true;
    }
    
    @Override
    public Object waitForValue() {
        if (this.computedReference == MapMakerInternalMap.UNSET) {
            boolean b = false;
            try {
                synchronized (this) {
                    while (this.computedReference == MapMakerInternalMap.UNSET) {
                        try {
                            this.wait();
                        }
                        catch (InterruptedException ex) {
                            b = true;
                        }
                    }
                }
            }
            finally {
                if (b) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return this.computedReference.waitForValue();
    }
    
    @Override
    public void clear(final MapMakerInternalMap$ValueReference valueReference) {
        this.setValueReference(valueReference);
    }
    
    Object compute(final Object o, final int n) {
        Object apply;
        try {
            apply = this.computingFunction.apply(o);
        }
        catch (Throwable t) {
            this.setValueReference(new ComputingConcurrentHashMap$ComputationExceptionReference(t));
            throw new ExecutionException(t);
        }
        this.setValueReference(new ComputingConcurrentHashMap$ComputedReference(apply));
        return apply;
    }
    
    void setValueReference(final MapMakerInternalMap$ValueReference computedReference) {
        synchronized (this) {
            if (this.computedReference == MapMakerInternalMap.UNSET) {
                this.computedReference = computedReference;
                this.notifyAll();
            }
        }
    }
}
