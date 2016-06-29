/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Equivalence;
import java.io.Serializable;

final class Equivalence$Identity
extends Equivalence
implements Serializable {
    static final Equivalence$Identity INSTANCE = new Equivalence$Identity();
    private static final long serialVersionUID = 1;

    Equivalence$Identity() {
    }

    @Override
    protected boolean doEquivalent(Object object, Object object2) {
        return false;
    }

    @Override
    protected int doHash(Object object) {
        return System.identityHashCode(object);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

