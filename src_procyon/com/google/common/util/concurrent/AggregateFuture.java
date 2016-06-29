package com.google.common.util.concurrent;

import com.google.common.collect.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;
import java.util.logging.*;
import java.util.concurrent.*;
import javax.annotation.*;

@GwtCompatible
abstract class AggregateFuture extends AbstractFuture$TrustedFuture
{
    private static final Logger logger;
    private AggregateFuture$RunningState runningState;
    
    @Override
    final void done() {
        super.done();
        this.runningState = null;
    }
    
    @Override
    public final boolean cancel(final boolean b) {
        final AggregateFuture$RunningState runningState = this.runningState;
        final ImmutableCollection collection = (runningState != null) ? runningState.futures : null;
        final boolean cancel = super.cancel(b);
        if (cancel & collection != null) {
            final UnmodifiableIterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                iterator.next().cancel(b);
            }
        }
        return cancel;
    }
    
    @GwtIncompatible("Interruption not supported")
    @Override
    protected final void interruptTask() {
        final AggregateFuture$RunningState runningState = this.runningState;
        if (runningState != null) {
            runningState.interruptTask();
        }
    }
    
    final void init(final AggregateFuture$RunningState runningState) {
        (this.runningState = runningState).init();
    }
    
    private static boolean addCausalChain(final Set set, Throwable cause) {
        while (cause != null) {
            if (!set.add(cause)) {
                return false;
            }
            cause = cause.getCause();
        }
        return true;
    }
    
    static {
        logger = Logger.getLogger(AggregateFuture.class.getName());
    }
}
