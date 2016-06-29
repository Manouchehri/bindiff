/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.IRawNodeAccessible;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableNode;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IViewableNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.IYNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode$InternalListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.List;
import y.c.i;
import y.c.q;
import y.h.bu;
import y.h.fj;

public abstract class ZyGraphNode
implements IRawNodeAccessible,
ISelectableNode,
IViewableNode,
IYNode {
    private IViewNode m_rawNode;
    private final q m_node;
    private final IZyNodeRealizer m_realizer;
    private final ZyGraphNode$InternalListener m_listener;

    public ZyGraphNode(q q2, IZyNodeRealizer iZyNodeRealizer, IViewNode iViewNode) {
        this.m_node = (q)Preconditions.checkNotNull(q2, "Node argument cannot be null");
        this.m_realizer = (IZyNodeRealizer)Preconditions.checkNotNull(iZyNodeRealizer, "Node realizer argument cannot be null");
        this.m_rawNode = (IViewNode)Preconditions.checkNotNull(iViewNode, "Raw node argument cannot be null");
        this.m_realizer.setX(this.m_rawNode.getX());
        this.m_realizer.setY(this.m_rawNode.getY());
        this.m_realizer.setFillColor(this.m_rawNode.getColor());
        this.m_realizer.setLineColor(this.m_rawNode.getBorderColor());
        this.m_realizer.setSelected(this.m_rawNode.isSelected());
        this.getGraph().a(this.m_node, iZyNodeRealizer.getRealizer());
        this.m_listener = new ZyGraphNode$InternalListener(this, this.getGraph());
        iZyNodeRealizer.addListener(this.m_listener);
        iViewNode.addListener(this.m_listener);
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

    public void addNodeModifier(IZyNodeRealizerListener iZyNodeRealizerListener) {
        this.m_realizer.addListener(iZyNodeRealizerListener);
    }

    @Override
    public void calcUnionRect(Rectangle2D rectangle2D) {
        this.m_realizer.calcUnionRect(rectangle2D);
    }

    public void clearHighlighting(int n2, int n3) {
        ZyLineContent zyLineContent = this.m_realizer.getNodeContent().getLineContent(n3);
        if (!zyLineContent.clearHighlighting(n2)) return;
        this.updateViews();
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
        if (this.getGraph() == null) return false;
        return true;
    }

    public int outdegree() {
        return this.m_node.c();
    }

    public int positionToRow(double d2) {
        return this.m_realizer.positionToRow(d2);
    }

    public void removeNodeModifier(IZyNodeRealizerListener iZyNodeRealizerListener) {
        this.m_realizer.removeListener(iZyNodeRealizerListener);
    }

    public void setBackgroundColor(int n2, Color color) {
        ZyLineContent zyLineContent = this.m_realizer.getNodeContent().getLineContent(n2);
        zyLineContent.setBackgroundColor(color);
        this.updateViews();
    }

    public void setBackgroundColor(int n2, int n3, int n4, Color color) {
        this.m_realizer.getNodeContent().getLineContent(n2).setBackgroundColor(n3, n4, color);
        this.updateViews();
    }

    public void setColor(int n2, Color color) {
        ZyLineContent zyLineContent = this.m_realizer.getNodeContent().getLineContent(n2);
        zyLineContent.setTextColor(color);
        this.updateViews();
    }

    public void setColor(int n2, int n3, int n4, Color color) {
        ZyLineContent zyLineContent = this.m_realizer.getNodeContent().getLineContent(n2);
        zyLineContent.setTextColor(n3, n4, color);
        this.updateViews();
    }

    public void setHeight(double d2) {
        this.m_realizer.setHeight(d2);
        this.updateViews();
    }

    public void setHighlighting(int n2, int n3, Color color) {
        ZyLineContent zyLineContent = this.m_realizer.getNodeContent().getLineContent(n3);
        if (!zyLineContent.setHighlighting(n2, color)) return;
        this.updateViews();
    }

    public void setHighlighting(int n2, int n3, int n4, int n5, Color color) {
        ZyLineContent zyLineContent = this.m_realizer.getNodeContent().getLineContent(n3);
        zyLineContent.setHighlighting(n4, n5, n2, color);
        this.updateViews();
    }

    public void setRawNode(IViewNode iViewNode) {
        Preconditions.checkArgument(iViewNode.getClass().equals(this.m_rawNode.getClass()), "Error: Old node and new node have different types");
        this.m_rawNode.removeListener(this.m_listener);
        this.m_rawNode = iViewNode;
        this.m_rawNode.addListener(this.m_listener);
    }

    public void setWidth(double d2) {
        this.m_realizer.setWidth(d2);
        this.updateViews();
    }

    static /* synthetic */ q access$000(ZyGraphNode zyGraphNode) {
        return zyGraphNode.m_node;
    }

    static /* synthetic */ IZyNodeRealizer access$100(ZyGraphNode zyGraphNode) {
        return zyGraphNode.m_realizer;
    }

    static /* synthetic */ void access$200(ZyGraphNode zyGraphNode) {
        zyGraphNode.updateViews();
    }

    static /* synthetic */ IViewNode access$300(ZyGraphNode zyGraphNode) {
        return zyGraphNode.m_rawNode;
    }
}

