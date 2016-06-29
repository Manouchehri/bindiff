/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;

@Beta
public interface ByteProcessor {
    public boolean processBytes(byte[] var1, int var2, int var3);

    public Object getResult();
}

