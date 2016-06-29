/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;

public interface IMouseStateChange {
    public IMouseState getNextState();

    public boolean notifyYFiles();
}

