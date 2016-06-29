package com.google.security.zynamics.zylib.gui;

public abstract class DefaultWrapper
{
    private final Object m_object;
    
    protected DefaultWrapper(final Object object) {
        this.m_object = object;
    }
    
    public Object getObject() {
        return this.m_object;
    }
    
    @Override
    public abstract String toString();
}
