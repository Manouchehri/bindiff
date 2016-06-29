package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.security.zynamics.zylib.types.graphs.*;
import java.awt.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import java.util.*;

public class SuperViewNode extends CViewNode implements IGraphNode
{
    private final List children;
    private final List parents;
    private final CombinedViewNode combinedNode;
    
    public SuperViewNode(final CombinedViewNode combinedNode) {
        super(-1, 0.0, 0.0, 0.0, 0.0, Color.WHITE, Color.BLACK, false, true);
        this.children = new ArrayList();
        this.parents = new ArrayList();
        Preconditions.checkNotNull(combinedNode);
        this.combinedNode = combinedNode;
    }
    
    public static void link(final SuperViewNode superViewNode, final SuperViewNode superViewNode2) {
        superViewNode.getChildren().add(superViewNode2);
        superViewNode2.getParents().add(superViewNode);
    }
    
    public static void unlink(final SuperViewNode superViewNode, final SuperViewNode superViewNode2) {
        superViewNode.getChildren().remove(superViewNode2);
        superViewNode2.getParents().remove(superViewNode);
    }
    
    @Override
    public List getChildren() {
        return this.children;
    }
    
    public CombinedViewNode getCombinedNode() {
        return this.combinedNode;
    }
    
    @Override
    public IGroupNode getParentGroup() {
        return null;
    }
    
    @Override
    public List getParents() {
        return this.parents;
    }
    
    public void removeNode() {
        for (final SuperViewEdge superViewEdge : this.getIncomingEdges()) {
            unlink((SuperViewNode)superViewEdge.getSource(), (SuperViewNode)superViewEdge.getTarget());
            ((SuperViewNode)superViewEdge.getSource()).removeOutgoingEdge(superViewEdge);
            ((SuperViewNode)superViewEdge.getTarget()).removeIncomingEdge(superViewEdge);
        }
        for (final SuperViewEdge superViewEdge2 : this.getOutgoingEdges()) {
            unlink((SuperViewNode)superViewEdge2.getSource(), (SuperViewNode)superViewEdge2.getTarget());
            ((SuperViewNode)superViewEdge2.getSource()).removeOutgoingEdge(superViewEdge2);
            ((SuperViewNode)superViewEdge2.getTarget()).removeIncomingEdge(superViewEdge2);
        }
    }
}
