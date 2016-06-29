/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

enum Funnels$LongFunnel implements Funnel
{
    INSTANCE;
    

    private Funnels$LongFunnel() {
    }

    public void funnel(Long l2, PrimitiveSink primitiveSink) {
        primitiveSink.putLong(l2);
    }

    public String toString() {
        return "Funnels.longFunnel()";
    }
}

