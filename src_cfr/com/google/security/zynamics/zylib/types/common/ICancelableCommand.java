/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.common;

import com.google.security.zynamics.zylib.types.common.ICommand;

public interface ICancelableCommand
extends ICommand {
    public void cancel();

    public boolean wasCanceled();
}

