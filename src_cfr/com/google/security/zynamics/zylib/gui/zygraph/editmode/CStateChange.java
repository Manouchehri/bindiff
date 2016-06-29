/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;

public final class CStateChange
implements IMouseStateChange {
    private final IMouseState m_nextState;
    private final boolean m_yfiles;

    public CStateChange(IMouseState iMouseState, boolean bl2) {
        this.m_nextState = iMouseState;
        this.m_yfiles = bl2;
    }

    @Override
    public IMouseState getNextState() {
        return this.m_nextState;
    }

    @Override
    public boolean notifyYFiles() {
        return this.m_yfiles;
    }
}

