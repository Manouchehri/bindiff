/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Platform;
import com.google.common.base.Ticker;

final class Ticker$1
extends Ticker {
    Ticker$1() {
    }

    @Override
    public long read() {
        return Platform.systemNanoTime();
    }
}

