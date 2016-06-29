/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressListener;

public interface IStandardProgressModel {
    public void addProgressListener(IStandardProgressListener var1);

    public void closeRequested();

    public void removeProgressListener(IStandardProgressListener var1);
}

