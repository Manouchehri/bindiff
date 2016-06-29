/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class Striped$SmallLazyStriped$ArrayReference
extends WeakReference {
    final int index;

    Striped$SmallLazyStriped$ArrayReference(Object object, int n2, ReferenceQueue referenceQueue) {
        super(object, referenceQueue);
        this.index = n2;
    }
}

