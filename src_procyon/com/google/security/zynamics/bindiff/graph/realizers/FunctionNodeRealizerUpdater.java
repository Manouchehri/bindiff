package com.google.security.zynamics.bindiff.graph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class FunctionNodeRealizerUpdater implements IRealizerUpdater
{
    @Override
    public void dispose() {
    }
    
    @Override
    public void generateContent(final IZyNodeRealizer zyNodeRealizer, ZyLabelContent nodeContent) {
        nodeContent = zyNodeRealizer.getNodeContent();
    }
    
    @Override
    public void setRealizer(final IZyNodeRealizer zyNodeRealizer) {
    }
}
