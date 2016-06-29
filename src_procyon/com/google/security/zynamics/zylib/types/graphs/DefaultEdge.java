package com.google.security.zynamics.zylib.types.graphs;

import com.google.common.base.*;

public class DefaultEdge implements IGraphEdge
{
    private final Object m_source;
    private final Object m_target;
    
    public DefaultEdge(final Object o, final Object o2) {
        this.m_source = Preconditions.checkNotNull(o, (Object)"Error: Source argument can not be null");
        this.m_target = Preconditions.checkNotNull(o2, (Object)"Error: Target argument can not be null");
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
