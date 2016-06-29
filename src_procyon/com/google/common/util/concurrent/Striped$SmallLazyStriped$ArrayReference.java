package com.google.common.util.concurrent;

import java.lang.ref.*;

final class Striped$SmallLazyStriped$ArrayReference extends WeakReference
{
    final int index;
    
    Striped$SmallLazyStriped$ArrayReference(final Object o, final int index, final ReferenceQueue referenceQueue) {
        super(o, referenceQueue);
        this.index = index;
    }
}
