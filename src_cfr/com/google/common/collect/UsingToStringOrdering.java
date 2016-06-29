/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import java.io.Serializable;

@GwtCompatible(serializable=1)
final class UsingToStringOrdering
extends Ordering
implements Serializable {
    static final UsingToStringOrdering INSTANCE = new UsingToStringOrdering();
    private static final long serialVersionUID = 0;

    @Override
    public int compare(Object object, Object object2) {
        return object.toString().compareTo(object2.toString());
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "Ordering.usingToString()";
    }

    private UsingToStringOrdering() {
    }
}

