/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.FinalizableReference;
import com.google.common.base.FinalizableReferenceQueue;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public abstract class FinalizablePhantomReference
extends PhantomReference
implements FinalizableReference {
    protected FinalizablePhantomReference(Object object, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(object, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}

