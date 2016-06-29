/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

public interface IStandardProgressListener {
    public void changedDescription(String var1);

    public void changedMaximum(int var1);

    public void finished();

    public void next();

    public void reset();
}

