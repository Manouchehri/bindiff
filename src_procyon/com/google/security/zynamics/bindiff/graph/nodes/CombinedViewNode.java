package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.security.zynamics.zylib.types.graphs.*;
import java.awt.*;
import java.util.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;

public abstract class CombinedViewNode extends CViewNode implements IGraphNode
{
    private final List children;
    private final List parents;
    
    public CombinedViewNode() {
        super(-1, 0.0, 0.0, 0.0, 0.0, Color.WHITE, Color.BLACK, false, true);
        this.children = new ArrayList();
        this.parents = new ArrayList();
    }
    
    public static void link(final CombinedViewNode combinedViewNode, final CombinedViewNode combinedViewNode2) {
        combinedViewNode.getChildren().add(combinedViewNode2);
        combinedViewNode2.getParents().add(combinedViewNode);
    }
    
    public static void unlink(final CombinedViewNode combinedViewNode, final CombinedViewNode combinedViewNode2) {
        combinedViewNode.getChildren().remove(combinedViewNode2);
        combinedViewNode2.getParents().remove(combinedViewNode);
    }
    
    public abstract IAddress getAddress(final ESide p0);
    
    @Override
    public List getChildren() {
        return this.children;
    }
    
    @Override
    public List getIncomingEdges() {
        return super.getIncomingEdges();
    }
    
    public EMatchState getMatchState() {
        if (this.getRawNode(ESide.PRIMARY) == null) {
            return EMatchState.SECONDRAY_UNMATCHED;
        }
        if (this.getRawNode(ESide.SECONDARY) == null) {
            return EMatchState.PRIMARY_UNMATCHED;
        }
        return EMatchState.MATCHED;
    }
    
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
    
    public abstract SingleViewNode getRawNode(final ESide p0);
}
