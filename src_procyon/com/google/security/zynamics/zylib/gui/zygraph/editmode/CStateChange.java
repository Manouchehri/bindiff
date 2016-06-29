package com.google.security.zynamics.zylib.gui.zygraph.editmode;

public final class CStateChange implements IMouseStateChange
{
    private final IMouseState m_nextState;
    private final boolean m_yfiles;
    
    public CStateChange(final IMouseState nextState, final boolean yfiles) {
        this.m_nextState = nextState;
        this.m_yfiles = yfiles;
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
