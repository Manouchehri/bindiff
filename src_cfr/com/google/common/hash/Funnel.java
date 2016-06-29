/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.hash.PrimitiveSink;
import java.io.Serializable;

@Beta
public interface Funnel
extends Serializable {
    public void funnel(Object var1, PrimitiveSink var2);
}

