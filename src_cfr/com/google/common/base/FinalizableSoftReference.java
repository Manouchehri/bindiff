/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.FinalizableReference;
import com.google.common.base.FinalizableReferenceQueue;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public abstract class FinalizableSoftReference
extends SoftReference
implements FinalizableReference {
    protected FinalizableSoftReference(Object object, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(object, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}

