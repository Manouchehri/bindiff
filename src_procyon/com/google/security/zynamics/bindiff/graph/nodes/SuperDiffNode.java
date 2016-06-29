package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.common.base.*;
import java.util.*;

public class SuperDiffNode extends ZyGraphNode implements IGraphNode
{
    private final SingleDiffNode primaryDiffNode;
    private final SingleDiffNode secondaryDiffNode;
    private CombinedDiffNode combinedDiffNode;
    private final List parents;
    private final List children;
    
    public SuperDiffNode(final q q, final IZyNodeRealizer zyNodeRealizer, final SuperViewNode superViewNode, final SingleDiffNode primaryDiffNode, final SingleDiffNode secondaryDiffNode) {
        super(q, zyNodeRealizer, superViewNode);
        this.parents = new ArrayList();
        this.children = new ArrayList();
        Preconditions.checkArgument(primaryDiffNode != null || secondaryDiffNode != null, (Object)"Primary diff node and secondary diff node cannot be both be null.");
        this.primaryDiffNode = primaryDiffNode;
        this.secondaryDiffNode = secondaryDiffNode;
    }
    
    public static void link(final SuperDiffNode superDiffNode, final SuperDiffNode superDiffNode2) {
        superDiffNode.children.add(superDiffNode2);
        superDiffNode2.parents.add(superDiffNode);
    }
    
    public static void unlink(final SuperDiffNode superDiffNode, final SuperDiffNode superDiffNode2) {
        superDiffNode.children.remove(superDiffNode2);
        superDiffNode2.parents.remove(superDiffNode);
    }
    
    @Override
    public SuperViewNode getRawNode() {
        return (SuperViewNode)super.getRawNode();
    }
    
    @Override
    public List getChildren() {
        return new ArrayList(this.children);
    }
    
    public CombinedDiffNode getCombinedDiffNode() {
        return this.combinedDiffNode;
    }
    
    public CombinedViewNode getCombinedRawNode() {
        return (this.combinedDiffNode != null) ? this.combinedDiffNode.getRawNode() : null;
    }
    
    @Override
    public List getParents() {
        return new ArrayList(this.parents);
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
    
    public void setCombinedDiffNode(final CombinedDiffNode combinedDiffNode) {
        Preconditions.checkNotNull(combinedDiffNode);
        this.combinedDiffNode = combinedDiffNode;
    }
}
