package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import y.h.*;
import y.c.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import com.google.common.base.*;
import java.awt.geom.*;
import java.util.*;

class ZyGraphNode$InternalListener implements IViewNodeListener, IZyNodeRealizerListener
{
    private final bu m_graph;
    private q m_pnode;
    final /* synthetic */ ZyGraphNode this$0;
    
    public ZyGraphNode$InternalListener(final ZyGraphNode this$0, final bu graph) {
        this.this$0 = this$0;
        this.m_graph = graph;
    }
    
    private void showNode(final IViewNode viewNode, final boolean b) {
        if (b) {
            this.m_graph.b(this.this$0.m_node);
            if (viewNode.getParentGroup() != null && !viewNode.getParentGroup().isVisible()) {
                viewNode.getParentGroup().setVisible(true);
            }
            if (viewNode instanceof IGroupNode) {
                final IGroupNode groupNode = (IGroupNode)viewNode;
                if (groupNode.isCollapsed()) {
                    this.m_graph.C().d(this.this$0.m_node);
                }
                else {
                    this.m_graph.C().c(this.this$0.m_node);
                }
                if (groupNode.isCollapsed()) {
                    final Iterator iterator = groupNode.getElements().iterator();
                    while (iterator.hasNext()) {
                        iterator.next().setVisible(true);
                    }
                }
            }
            if (this.m_pnode != null) {
                this.m_graph.C().c(this.this$0.m_node, this.m_pnode);
            }
        }
        else {
            this.m_pnode = this.m_graph.C().n(this.this$0.m_node);
            if (this.m_pnode == null && viewNode.getParentGroup() != null) {
                throw new IllegalStateException("Error");
            }
            if (viewNode instanceof IGroupNode) {
                final IGroupNode groupNode2 = (IGroupNode)viewNode;
                if (groupNode2.isCollapsed()) {
                    final Iterator iterator2 = groupNode2.getElements().iterator();
                    while (iterator2.hasNext()) {
                        iterator2.next().setVisible(false);
                    }
                }
            }
            if (viewNode.getParentGroup() == null || !viewNode.getParentGroup().isCollapsed()) {
                this.m_graph.a(this.this$0.m_node);
            }
        }
        for (final IViewEdge viewEdge : viewNode.getIncomingEdges()) {
            if (viewNode.getParentGroup() == null) {
                viewEdge.setVisible(((IViewNode)viewEdge.getSource()).isVisible() && ((IViewNode)viewEdge.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)viewEdge.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)viewEdge.getSource()).isVisible());
            }
            else if (viewNode.getParentGroup().isCollapsed()) {
                viewEdge.setVisible(viewNode.getParentGroup().isVisible() && ((IViewNode)viewEdge.getSource()).isVisible());
            }
            else {
                viewEdge.setVisible(((IViewNode)viewEdge.getSource()).isVisible() && ((IViewNode)viewEdge.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)viewEdge.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)viewEdge.getSource()).isVisible());
            }
        }
        for (final IViewEdge viewEdge2 : viewNode.getOutgoingEdges()) {
            if (viewNode.getParentGroup() == null) {
                viewEdge2.setVisible(((IViewNode)viewEdge2.getSource()).isVisible() && ((IViewNode)viewEdge2.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)viewEdge2.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)viewEdge2.getSource()).isVisible());
            }
            else if (viewNode.getParentGroup().isCollapsed()) {
                viewEdge2.setVisible(viewNode.getParentGroup().isVisible() && ((IViewNode)viewEdge2.getTarget()).isVisible());
            }
            else {
                viewEdge2.setVisible(((IViewNode)viewEdge2.getSource()).isVisible() && ((IViewNode)viewEdge2.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)viewEdge2.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)viewEdge2.getSource()).isVisible());
            }
        }
    }
    
    @Override
    public void changedBorderColor(final IViewNode viewNode, final Color lineColor) {
        this.this$0.m_realizer.setLineColor(lineColor);
        this.this$0.updateViews();
    }
    
    @Override
    public void changedColor(final IViewNode viewNode, final Color fillColor) {
        this.this$0.m_realizer.setFillColor(fillColor);
        this.this$0.updateViews();
    }
    
    @Override
    public void changedLocation(final IZyNodeRealizer zyNodeRealizer, final double x, final double y) {
        this.this$0.m_rawNode.setX(x);
        this.this$0.m_rawNode.setY(y);
    }
    
    @Override
    public void changedSelection(final IViewNode viewNode, final boolean selected) {
        this.this$0.m_realizer.setSelected(selected);
        this.this$0.onSelectionChanged();
        this.this$0.updateViews();
    }
    
    @Override
    public void changedSelection(final IZyNodeRealizer zyNodeRealizer) {
        this.this$0.m_rawNode.setSelected(zyNodeRealizer.isSelected());
    }
    
    @Override
    public void changedSize(final IZyNodeRealizer zyNodeRealizer, final double width, final double height) {
        this.this$0.m_rawNode.setWidth(width);
        this.this$0.m_rawNode.setHeight(height);
    }
    
    @Override
    public void changedVisibility(final IViewNode viewNode, final boolean b) {
        new ZyGraphNode$InternalListener$1(this, viewNode, b).invokeAndWait();
    }
    
    @Override
    public void changedVisibility(final IZyNodeRealizer zyNodeRealizer) {
        this.this$0.m_rawNode.setVisible(zyNodeRealizer.isVisible());
    }
    
    @Override
    public void heightChanged(final IViewNode viewNode, final double height) {
        if (this.this$0.m_realizer.getHeight() != height && height != 0.0) {
            this.this$0.m_realizer.setHeight(height);
            this.this$0.updateViews();
        }
    }
    
    @Override
    public void regenerated(final IZyNodeRealizer zyNodeRealizer) {
    }
    
    @Override
    public void widthChanged(final IViewNode viewNode, final double width) {
        if (this.this$0.m_realizer.getWidth() != width && width != 0.0) {
            this.this$0.m_realizer.setWidth(width);
            this.this$0.updateViews();
        }
    }
    
    @Override
    public void xposChanged(final IViewNode viewNode, final double x) {
        if (this.this$0.m_realizer.getX() != x) {
            this.this$0.m_realizer.setX(x);
            this.this$0.updateViews();
        }
    }
    
    @Override
    public void yposChanged(final IViewNode viewNode, final double y) {
        if (this.this$0.m_realizer.getY() != y) {
            this.this$0.m_realizer.setY(y);
            this.this$0.updateViews();
        }
    }
}
