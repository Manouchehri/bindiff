/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.diff;

public interface ICountsChangeListener {
    public void basicblocksCountChanged();

    public void callsCountChanged();

    public void functionsCountChanged();

    public void instructionsCountsChanged();

    public void jumpsCountChanged();
}

