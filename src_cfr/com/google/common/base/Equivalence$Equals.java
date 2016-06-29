/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Equivalence;
import java.io.Serializable;

final class Equivalence$Equals
extends Equivalence
implements Serializable {
    static final Equivalence$Equals INSTANCE = new Equivalence$Equals();
    private static final long serialVersionUID = 1;

    Equivalence$Equals() {
    }

    @Override
    protected boolean doEquivalent(Object object, Object object2) {
        return object.equals(object2);
    }

    @Override
    protected int doHash(Object object) {
        return object.hashCode();
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

