package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import y.c.*;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import java.util.*;

public class ZyProximityNode extends ZyGraphNode
{
    private static final int DEFAULT_DISTANCE = 50;
    private final boolean m_isIncoming;
    
    public ZyProximityNode(final q q, final ZyProximityNodeRealizer zyProximityNodeRealizer, final ZyGraphNode zyGraphNode, final boolean isIncoming) {
        super(q, zyProximityNodeRealizer, new CProximityNode(getRawNode(zyGraphNode)));
        this.m_isIncoming = isIncoming;
        final IZyNodeRealizer realizer = zyGraphNode.getRealizer();
        final double centerX = realizer.getCenterX();
        double n;
        if (isIncoming) {
            n = realizer.getCenterY() + realizer.getHeight() / 2.0 + 50.0;
        }
        else {
            n = realizer.getCenterY() - realizer.getHeight() / 2.0 - 50.0;
        }
        zyProximityNodeRealizer.moveBy(centerX - zyProximityNodeRealizer.getWidth() / 2.0, n - zyProximityNodeRealizer.getHeight() / 2.0);
    }
    
    private static IViewNode getRawNode(final ZyGraphNode zyGraphNode) {
        return zyGraphNode.getRawNode();
    }
    
    @Override
    public List getChildren() {
        throw new IllegalStateException("Not yet implemented");
    }
    
    @Override
    public List getParents() {
        throw new IllegalStateException("Not yet implemented");
    }
    
    @Override
    public CProximityNode getRawNode() {
        return (CProximityNode)super.getRawNode();
    }
    
    public boolean isIncoming() {
        return this.m_isIncoming;
    }
}
