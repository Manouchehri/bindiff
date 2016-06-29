/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

enum Funnels$UnencodedCharsFunnel implements Funnel
{
    INSTANCE;
    

    private Funnels$UnencodedCharsFunnel() {
    }

    public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
        primitiveSink.putUnencodedChars(charSequence);
    }

    public String toString() {
        return "Funnels.unencodedCharsFunnel()";
    }
}

