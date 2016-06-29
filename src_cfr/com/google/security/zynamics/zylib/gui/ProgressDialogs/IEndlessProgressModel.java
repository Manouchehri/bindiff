/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressListener;

public interface IEndlessProgressModel {
    public void addProgressListener(IEndlessProgressListener var1);

    public void closeRequested();

    public void removeProgressListener(IEndlessProgressListener var1);
}

