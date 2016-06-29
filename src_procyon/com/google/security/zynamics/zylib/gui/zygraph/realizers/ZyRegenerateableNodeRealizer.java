package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.common.base.*;

public class ZyRegenerateableNodeRealizer implements IZyRegenerateableRealizer
{
    private final IZyNodeRealizer realizer;
    
    public ZyRegenerateableNodeRealizer(final IZyNodeRealizer zyNodeRealizer) {
        this.realizer = (IZyNodeRealizer)Preconditions.checkNotNull(zyNodeRealizer, (Object)"Error: Node realizer can't be null.");
    }
    
    @Override
    public void regenerate() {
        this.realizer.regenerate();
    }
    
    @Override
    public void repaint() {
        this.realizer.repaint();
    }
}
