package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.bindiff.enums.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.common.base.*;
import java.util.*;

public class SingleDiffNode extends ZyGraphNode implements IGraphNode
{
    private CombinedDiffNode combinedDiffNode;
    private SuperDiffNode superDiffNode;
    private SingleDiffNode otherSideDiffNode;
    private final ESide side;
    private final List parents;
    private final List children;
    
    public SingleDiffNode(final q q, final IZyNodeRealizer zyNodeRealizer, final SingleViewNode singleViewNode, final ESide eSide) {
        super(q, zyNodeRealizer, singleViewNode);
        this.parents = new ArrayList();
        this.children = new ArrayList();
        this.side = (ESide)Preconditions.checkNotNull(eSide);
    }
    
    public static void link(final SingleDiffNode singleDiffNode, final SingleDiffNode singleDiffNode2) {
        singleDiffNode.children.add(singleDiffNode2);
        singleDiffNode2.parents.add(singleDiffNode);
    }
    
    public static void unlink(final SingleDiffNode singleDiffNode, final SingleDiffNode singleDiffNode2) {
        singleDiffNode.children.remove(singleDiffNode2);
        singleDiffNode2.parents.remove(singleDiffNode);
    }
    
    @Override
    public List getChildren() {
        return new ArrayList(this.children);
    }
    
    public CombinedDiffNode getCombinedDiffNode() {
        return this.combinedDiffNode;
    }
    
    public CombinedViewNode getCombinedRawNode() {
        return this.combinedDiffNode.getRawNode();
    }
    
    public SingleDiffNode getOtherSideDiffNode() {
        return this.otherSideDiffNode;
    }
    
    public SingleViewNode getOtherSideRawNode() {
        return (this.otherSideDiffNode != null) ? this.otherSideDiffNode.getRawNode() : null;
    }
    
    @Override
    public List getParents() {
        return new ArrayList(this.parents);
    }
    
    @Override
    public SingleViewNode getRawNode() {
        return (SingleViewNode)super.getRawNode();
    }
    
    public ESide getSide() {
        return this.side;
    }
    
    public SuperDiffNode getSuperDiffNode() {
        return this.superDiffNode;
    }
    
    public SuperViewNode getSuperRawNode() {
        return this.superDiffNode.getRawNode();
    }
    
    public void setCombinedDiffNode(final CombinedDiffNode combinedDiffNode) {
        Preconditions.checkNotNull(combinedDiffNode);
        this.combinedDiffNode = combinedDiffNode;
        this.superDiffNode = combinedDiffNode.getSuperDiffNode();
        this.otherSideDiffNode = ((this.side == ESide.PRIMARY) ? combinedDiffNode.getSecondaryDiffNode() : combinedDiffNode.getPrimaryDiffNode());
    }
}
