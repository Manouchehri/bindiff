/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.FinalizableReference;
import com.google.common.base.FinalizableReferenceQueue$DecoupledLoader;
import com.google.common.base.FinalizableReferenceQueue$DirectLoader;
import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;
import com.google.common.base.FinalizableReferenceQueue$SystemLoader;
import java.io.Closeable;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalizableReferenceQueue
implements Closeable {
    private static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
    private static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
    private static final Method startFinalizer;
    final ReferenceQueue queue = new ReferenceQueue();
    final PhantomReference frqRef;
    final boolean threadStarted;

    public FinalizableReferenceQueue() {
        this.frqRef = new PhantomReference<FinalizableReferenceQueue>(this, this.queue);
        boolean bl2 = false;
        try {
            startFinalizer.invoke(null, FinalizableReference.class, this.queue, this.frqRef);
            bl2 = true;
        }
        catch (IllegalAccessException var2_2) {
            throw new AssertionError(var2_2);
        }
        catch (Throwable var2_3) {
            logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", var2_3);
        }
        this.threadStarted = bl2;
    }

    @Override
    public void close() {
        this.frqRef.enqueue();
        this.cleanUp();
    }

    void cleanUp() {
        Reference reference;
        if (this.threadStarted) {
            return;
        }
        while ((reference = this.queue.poll()) != null) {
            reference.clear();
            try {
                ((FinalizableReference)((Object)reference)).finalizeReferent();
            }
            catch (Throwable var2_2) {
                logger.log(Level.SEVERE, "Error cleaning up after reference.", var2_2);
                continue;
            }
        }
    }

    private static /* varargs */ Class loadFinalizer(FinalizableReferenceQueue$FinalizerLoader ... arrfinalizableReferenceQueue$FinalizerLoader) {
        FinalizableReferenceQueue$FinalizerLoader[] arrfinalizableReferenceQueue$FinalizerLoader2 = arrfinalizableReferenceQueue$FinalizerLoader;
        int n2 = arrfinalizableReferenceQueue$FinalizerLoader2.length;
        int n3 = 0;
        while (n3 < n2) {
            FinalizableReferenceQueue$FinalizerLoader finalizableReferenceQueue$FinalizerLoader = arrfinalizableReferenceQueue$FinalizerLoader2[n3];
            Class class_ = finalizableReferenceQueue$FinalizerLoader.loadFinalizer();
            if (class_ != null) {
                return class_;
            }
            ++n3;
        }
        throw new AssertionError();
    }

    static Method getStartFinalizer(Class class_) {
        try {
            return class_.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        }
        catch (NoSuchMethodException var1_1) {
            throw new AssertionError(var1_1);
        }
    }

    static /* synthetic */ Logger access$000() {
        return logger;
    }

    static {
        Class class_ = FinalizableReferenceQueue.loadFinalizer(new FinalizableReferenceQueue$SystemLoader(), new FinalizableReferenceQueue$DecoupledLoader(), new FinalizableReferenceQueue$DirectLoader());
        startFinalizer = FinalizableReferenceQueue.getStartFinalizer(class_);
    }
}

