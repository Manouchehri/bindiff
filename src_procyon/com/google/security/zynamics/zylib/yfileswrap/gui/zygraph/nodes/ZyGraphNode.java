package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import y.h.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.*;

public abstract class ZyGraphNode implements IRawNodeAccessible, ISelectableNode, IViewableNode, IYNode
{
    private IViewNode m_rawNode;
    private final q m_node;
    private final IZyNodeRealizer m_realizer;
    private final ZyGraphNode$InternalListener m_listener;
    
    public ZyGraphNode(final q q, final IZyNodeRealizer zyNodeRealizer, final IViewNode viewNode) {
        this.m_node = (q)Preconditions.checkNotNull(q, (Object)"Node argument cannot be null");
        this.m_realizer = (IZyNodeRealizer)Preconditions.checkNotNull(zyNodeRealizer, (Object)"Node realizer argument cannot be null");
        this.m_rawNode = (IViewNode)Preconditions.checkNotNull(viewNode, (Object)"Raw node argument cannot be null");
        this.m_realizer.setX(this.m_rawNode.getX());
        this.m_realizer.setY(this.m_rawNode.getY());
        this.m_realizer.setFillColor(this.m_rawNode.getColor());
        this.m_realizer.setLineColor(this.m_rawNode.getBorderColor());
        this.m_realizer.setSelected(this.m_rawNode.isSelected());
        this.getGraph().a(this.m_node, zyNodeRealizer.getRealizer());
        zyNodeRealizer.addListener(this.m_listener = new ZyGraphNode$InternalListener(this, this.getGraph()));
        viewNode.addListener(this.m_listener);
    }
    
    private bu getGraph() {
        return (bu)this.m_node.e();
    }
    
    private void updateViews() {
        if (this.getGraph() == null) {
            return;
        }
        this.getGraph().T();
    }
    
    protected void onSelectionChanged() {
    }
    
    public void addNodeModifier(final IZyNodeRealizerListener zyNodeRealizerListener) {
        this.m_realizer.addListener(zyNodeRealizerListener);
    }
    
    @Override
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        this.m_realizer.calcUnionRect(rectangle2D);
    }
    
    public void clearHighlighting(final int n, final int n2) {
        if (this.m_realizer.getNodeContent().getLineContent(n2).clearHighlighting(n)) {
            this.updateViews();
        }
    }
    
    @Override
    public Rectangle2D.Double getBoundingBox() {
        return this.m_realizer.getBoundingBox();
    }
    
    public abstract List getChildren();
    
    @Override
    public q getNode() {
        return this.m_node;
    }
    
    public abstract List getParents();
    
    @Override
    public IViewNode getRawNode() {
        return this.m_rawNode;
    }
    
    public IZyNodeRealizer getRealizer() {
        return this.m_realizer;
    }
    
    public double getX() {
        return this.m_realizer.getX();
    }
    
    public double getY() {
        return this.m_realizer.getY();
    }
    
    public int indegree() {
        return this.m_node.b();
    }
    
    @Override
    public boolean isSelected() {
        return this.m_realizer.isSelected();
    }
    
    public boolean isVisible() {
        return this.getGraph() != null;
    }
    
    public int outdegree() {
        return this.m_node.c();
    }
    
    public int positionToRow(final double n) {
        return this.m_realizer.positionToRow(n);
    }
    
    public void removeNodeModifier(final IZyNodeRealizerListener zyNodeRealizerListener) {
        this.m_realizer.removeListener(zyNodeRealizerListener);
    }
    
    public void setBackgroundColor(final int n, final Color backgroundColor) {
        this.m_realizer.getNodeContent().getLineContent(n).setBackgroundColor(backgroundColor);
        this.updateViews();
    }
    
    public void setBackgroundColor(final int n, final int n2, final int n3, final Color color) {
        this.m_realizer.getNodeContent().getLineContent(n).setBackgroundColor(n2, n3, color);
        this.updateViews();
    }
    
    public void setColor(final int n, final Color textColor) {
        this.m_realizer.getNodeContent().getLineContent(n).setTextColor(textColor);
        this.updateViews();
    }
    
    public void setColor(final int n, final int n2, final int n3, final Color color) {
        this.m_realizer.getNodeContent().getLineContent(n).setTextColor(n2, n3, color);
        this.updateViews();
    }
    
    public void setHeight(final double height) {
        this.m_realizer.setHeight(height);
        this.updateViews();
    }
    
    public void setHighlighting(final int n, final int n2, final Color color) {
        if (this.m_realizer.getNodeContent().getLineContent(n2).setHighlighting(n, color)) {
            this.updateViews();
        }
    }
    
    public void setHighlighting(final int n, final int n2, final int n3, final int n4, final Color color) {
        this.m_realizer.getNodeContent().getLineContent(n2).setHighlighting(n3, n4, n, color);
        this.updateViews();
    }
    
    public void setRawNode(final IViewNode rawNode) {
        Preconditions.checkArgument(rawNode.getClass().equals(this.m_rawNode.getClass()), (Object)"Error: Old node and new node have different types");
        this.m_rawNode.removeListener(this.m_listener);
        (this.m_rawNode = rawNode).addListener(this.m_listener);
    }
    
    public void setWidth(final double width) {
        this.m_realizer.setWidth(width);
        this.updateViews();
    }
}
