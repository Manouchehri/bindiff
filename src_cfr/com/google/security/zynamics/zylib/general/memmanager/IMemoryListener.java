/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.memmanager;

public interface IMemoryListener {
    public void memoryChanged(long var1, int var3);

    public void memoryCleared();
}

