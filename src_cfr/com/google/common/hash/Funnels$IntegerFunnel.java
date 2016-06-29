/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

enum Funnels$IntegerFunnel implements Funnel
{
    INSTANCE;
    

    private Funnels$IntegerFunnel() {
    }

    public void funnel(Integer n2, PrimitiveSink primitiveSink) {
        primitiveSink.putInt(n2);
    }

    public String toString() {
        return "Funnels.integerFunnel()";
    }
}

