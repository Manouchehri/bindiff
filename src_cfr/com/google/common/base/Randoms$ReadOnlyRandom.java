/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Randoms$1;
import java.util.Random;

class Randoms$ReadOnlyRandom
extends Random {
    private static final long serialVersionUID = 898001275432099254L;
    private boolean initializationComplete = true;

    private Randoms$ReadOnlyRandom() {
    }

    @Override
    public void setSeed(long l2) {
        if (this.initializationComplete) {
            throw new UnsupportedOperationException("Setting the seed on the shared Random object is not permitted");
        }
        super.setSeed(l2);
    }

    /* synthetic */ Randoms$ReadOnlyRandom(Randoms$1 randoms$1) {
        this();
    }
}

