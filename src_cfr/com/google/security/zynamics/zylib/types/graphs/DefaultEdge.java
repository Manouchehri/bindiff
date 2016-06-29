/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.graphs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;

public class DefaultEdge
implements IGraphEdge {
    private final Object m_source;
    private final Object m_target;

    public DefaultEdge(Object object, Object object2) {
        this.m_source = Preconditions.checkNotNull(object, "Error: Source argument can not be null");
        this.m_target = Preconditions.checkNotNull(object2, "Error: Target argument can not be null");
    }

    @Override
    public Object getSource() {
        return this.m_source;
    }

    @Override
    public Object getTarget() {
        return this.m_target;
    }
}

