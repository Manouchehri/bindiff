package com.google.common.base;

import java.io.*;
import java.lang.reflect.*;
import java.util.logging.*;
import java.lang.ref.*;

public class FinalizableReferenceQueue implements Closeable
{
    private static final Logger logger;
    private static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
    private static final Method startFinalizer;
    final ReferenceQueue queue;
    final PhantomReference frqRef;
    final boolean threadStarted;
    
    public FinalizableReferenceQueue() {
        this.queue = new ReferenceQueue();
        this.frqRef = new PhantomReference((T)this, this.queue);
        boolean threadStarted = false;
        try {
            FinalizableReferenceQueue.startFinalizer.invoke(null, FinalizableReference.class, this.queue, this.frqRef);
            threadStarted = true;
        }
        catch (IllegalAccessException ex) {
            throw new AssertionError((Object)ex);
        }
        catch (Throwable t) {
            FinalizableReferenceQueue.logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", t);
        }
        this.threadStarted = threadStarted;
    }
    
    @Override
    public void close() {
        this.frqRef.enqueue();
        this.cleanUp();
    }
    
    void cleanUp() {
        if (this.threadStarted) {
            return;
        }
        Reference poll;
        while ((poll = this.queue.poll()) != null) {
            poll.clear();
            try {
                ((FinalizableReference)poll).finalizeReferent();
            }
            catch (Throwable t) {
                FinalizableReferenceQueue.logger.log(Level.SEVERE, "Error cleaning up after reference.", t);
            }
        }
    }
    
    private static Class loadFinalizer(final FinalizableReferenceQueue$FinalizerLoader... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final Class loadFinalizer = array[i].loadFinalizer();
            if (loadFinalizer != null) {
                return loadFinalizer;
            }
        }
        throw new AssertionError();
    }
    
    static Method getStartFinalizer(final Class clazz) {
        try {
            return clazz.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        }
        catch (NoSuchMethodException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    static {
        logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
        startFinalizer = getStartFinalizer(loadFinalizer(new FinalizableReferenceQueue$SystemLoader(), new FinalizableReferenceQueue$DecoupledLoader(), new FinalizableReferenceQueue$DirectLoader()));
    }
}
