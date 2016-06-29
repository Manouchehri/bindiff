package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.awt.*;
import java.util.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;

public abstract class SingleViewNode extends CViewNode implements IGraphNode
{
    private final IAddress address;
    private final List children;
    private final List parents;
    
    public SingleViewNode(final IAddress address, final int n, final double n2, final double n3, final Color color, final Color color2, final boolean b, final boolean b2) {
        super(n, n2, n3, 0.0, 0.0, color, color2, b, b2);
        this.children = new ArrayList();
        this.parents = new ArrayList();
        Preconditions.checkNotNull(address);
        this.address = address;
    }
    
    public static void link(final SingleViewNode singleViewNode, final SingleViewNode singleViewNode2) {
        singleViewNode.getChildren().add(singleViewNode2);
        singleViewNode2.getParents().add(singleViewNode);
    }
    
    public static void unlink(final SingleViewNode singleViewNode, final SingleViewNode singleViewNode2) {
        singleViewNode.getChildren().remove(singleViewNode2);
        singleViewNode2.getParents().remove(singleViewNode);
    }
    
    public IAddress getAddress() {
        return this.address;
    }
    
    @Override
    public List getChildren() {
        return this.children;
    }
    
    @Override
    public List getIncomingEdges() {
        return super.getIncomingEdges();
    }
    
    public abstract EMatchState getMatchState();
    
    @Override
    public List getOutgoingEdges() {
        return super.getOutgoingEdges();
    }
    
    @Override
    public IGroupNode getParentGroup() {
        return null;
    }
    
    @Override
    public List getParents() {
        return this.parents;
    }
    
    public abstract ESide getSide();
}
