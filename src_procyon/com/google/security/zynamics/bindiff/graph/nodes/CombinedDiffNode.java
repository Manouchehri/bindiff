package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.common.base.*;
import java.util.*;

public class CombinedDiffNode extends ZyGraphNode implements IGraphNode
{
    private final SuperDiffNode superDiffNode;
    private final SingleDiffNode primaryDiffNode;
    private final SingleDiffNode secondaryDiffNode;
    private final List parents;
    private final List children;
    
    public CombinedDiffNode(final q q, final IZyNodeRealizer zyNodeRealizer, final CombinedViewNode combinedViewNode, final SuperDiffNode superDiffNode) {
        super(q, zyNodeRealizer, combinedViewNode);
        this.parents = new ArrayList();
        this.children = new ArrayList();
        Preconditions.checkNotNull(superDiffNode);
        this.superDiffNode = superDiffNode;
        this.primaryDiffNode = superDiffNode.getPrimaryDiffNode();
        this.secondaryDiffNode = superDiffNode.getSecondaryDiffNode();
    }
    
    public static void link(final CombinedDiffNode combinedDiffNode, final CombinedDiffNode combinedDiffNode2) {
        combinedDiffNode.children.add(combinedDiffNode2);
        combinedDiffNode2.parents.add(combinedDiffNode);
    }
    
    public static void unlink(final CombinedDiffNode combinedDiffNode, final CombinedDiffNode combinedDiffNode2) {
        combinedDiffNode.children.remove(combinedDiffNode2);
        combinedDiffNode2.parents.remove(combinedDiffNode);
    }
    
    @Override
    public List getChildren() {
        return new ArrayList(this.children);
    }
    
    @Override
    public List getParents() {
        return new ArrayList(this.parents);
    }
    
    @Override
    public CombinedViewNode getRawNode() {
        return (CombinedViewNode)super.getRawNode();
    }
    
    public SingleDiffNode getPrimaryDiffNode() {
        return this.primaryDiffNode;
    }
    
    public SingleViewNode getPrimaryRawNode() {
        return (this.primaryDiffNode != null) ? this.primaryDiffNode.getRawNode() : null;
    }
    
    public SingleDiffNode getSecondaryDiffNode() {
        return this.secondaryDiffNode;
    }
    
    public SingleViewNode getSecondaryRawNode() {
        return (this.secondaryDiffNode != null) ? this.secondaryDiffNode.getRawNode() : null;
    }
    
    public SuperDiffNode getSuperDiffNode() {
        return this.superDiffNode;
    }
    
    public SuperViewNode getSuperRawNode() {
        return this.superDiffNode.getRawNode();
    }
}
