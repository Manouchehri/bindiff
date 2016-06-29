/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.FinalizableReference;
import com.google.common.base.FinalizableReferenceQueue;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class FinalizableWeakReference
extends WeakReference
implements FinalizableReference {
    protected FinalizableWeakReference(Object object, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(object, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}

