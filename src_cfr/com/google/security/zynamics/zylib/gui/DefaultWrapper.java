/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

public abstract class DefaultWrapper {
    private final Object m_object;

    protected DefaultWrapper(Object object) {
        this.m_object = object;
    }

    public Object getObject() {
        return this.m_object;
    }

    public abstract String toString();
}

