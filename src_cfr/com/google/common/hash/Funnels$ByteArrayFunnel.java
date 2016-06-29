/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

enum Funnels$ByteArrayFunnel implements Funnel
{
    INSTANCE;
    

    private Funnels$ByteArrayFunnel() {
    }

    public void funnel(byte[] arrby, PrimitiveSink primitiveSink) {
        primitiveSink.putBytes(arrby);
    }

    public String toString() {
        return "Funnels.byteArrayFunnel()";
    }
}

