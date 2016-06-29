package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.*;

public class ZyRegenerateableEdgeRealizer implements IZyRegenerateableRealizer
{
    private final IZyEdgeRealizer m_realizer;
    
    public ZyRegenerateableEdgeRealizer(final IZyEdgeRealizer realizer) {
        Preconditions.checkNotNull(realizer, (Object)"Error: Edge realizer can't be null.");
        this.m_realizer = realizer;
    }
    
    @Override
    public void regenerate() {
        this.m_realizer.regenerate();
    }
    
    @Override
    public void repaint() {
        this.m_realizer.repaint();
    }
}
