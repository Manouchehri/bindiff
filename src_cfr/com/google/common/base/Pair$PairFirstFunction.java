/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Pair;
import java.io.Serializable;

final class Pair$PairFirstFunction
implements Function,
Serializable {
    static final Pair$PairFirstFunction INSTANCE = new Pair$PairFirstFunction();

    private Pair$PairFirstFunction() {
    }

    public Object apply(Pair pair) {
        return pair.getFirst();
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

