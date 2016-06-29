package com.google.security.zynamics.zylib.gui.zygraph.edges;

public class ZyEdgeData
{
    private final Object m_zyEdge;
    
    public ZyEdgeData(final Object zyEdge) {
        this.m_zyEdge = zyEdge;
    }
    
    public Object getEdge() {
        return this.m_zyEdge;
    }
}
