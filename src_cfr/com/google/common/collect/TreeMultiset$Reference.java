/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.TreeMultiset$1;
import java.util.ConcurrentModificationException;
import javax.annotation.Nullable;

final class TreeMultiset$Reference {
    @Nullable
    private Object value;

    private TreeMultiset$Reference() {
    }

    @Nullable
    public Object get() {
        return this.value;
    }

    public void checkAndSet(@Nullable Object object, Object object2) {
        if (this.value != object) {
            throw new ConcurrentModificationException();
        }
        this.value = object2;
    }

    /* synthetic */ TreeMultiset$Reference(TreeMultiset$1 treeMultiset$1) {
        this();
    }
}

