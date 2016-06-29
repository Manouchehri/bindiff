/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode$InternalListener$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import y.c.q;
import y.h.a.v;
import y.h.bu;

class ZyGraphNode$InternalListener
implements IViewNodeListener,
IZyNodeRealizerListener {
    private final bu m_graph;
    private q m_pnode;
    final /* synthetic */ ZyGraphNode this$0;

    public ZyGraphNode$InternalListener(ZyGraphNode zyGraphNode, bu bu2) {
        this.this$0 = zyGraphNode;
        this.m_graph = bu2;
    }

    private void showNode(IViewNode iViewNode, boolean bl2) {
        Object object;
        if (bl2) {
            this.m_graph.b(ZyGraphNode.access$000(this.this$0));
            if (iViewNode.getParentGroup() != null && !iViewNode.getParentGroup().isVisible()) {
                iViewNode.getParentGroup().setVisible(true);
            }
            if (iViewNode instanceof IGroupNode) {
                object = (IGroupNode)iViewNode;
                if (object.isCollapsed()) {
                    this.m_graph.C().d(ZyGraphNode.access$000(this.this$0));
                } else {
                    this.m_graph.C().c(ZyGraphNode.access$000(this.this$0));
                }
                if (object.isCollapsed()) {
                    for (IViewNode iViewNode2 : object.getElements()) {
                        iViewNode2.setVisible(true);
                    }
                }
            }
            if (this.m_pnode != null) {
                this.m_graph.C().c(ZyGraphNode.access$000(this.this$0), this.m_pnode);
            }
        } else {
            this.m_pnode = this.m_graph.C().n(ZyGraphNode.access$000(this.this$0));
            if (this.m_pnode == null && iViewNode.getParentGroup() != null) {
                throw new IllegalStateException("Error");
            }
            if (iViewNode instanceof IGroupNode && (object = (IGroupNode)iViewNode).isCollapsed()) {
                for (IViewNode iViewNode2 : object.getElements()) {
                    iViewNode2.setVisible(false);
                }
            }
            if (iViewNode.getParentGroup() == null || !iViewNode.getParentGroup().isCollapsed()) {
                this.m_graph.a(ZyGraphNode.access$000(this.this$0));
            }
        }
        for (Object object22 : iViewNode.getIncomingEdges()) {
            if (iViewNode.getParentGroup() == null) {
                object22.setVisible(((IViewNode)object22.getSource()).isVisible() && ((IViewNode)object22.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)object22.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)object22.getSource()).isVisible());
                continue;
            }
            if (iViewNode.getParentGroup().isCollapsed()) {
                object22.setVisible(iViewNode.getParentGroup().isVisible() && ((IViewNode)object22.getSource()).isVisible());
                continue;
            }
            object22.setVisible(((IViewNode)object22.getSource()).isVisible() && ((IViewNode)object22.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)object22.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)object22.getSource()).isVisible());
        }
        object = iViewNode.getOutgoingEdges().iterator();
        while (object.hasNext()) {
            Object object22;
            object22 = (IViewEdge)object.next();
            if (iViewNode.getParentGroup() == null) {
                object22.setVisible(((IViewNode)object22.getSource()).isVisible() && ((IViewNode)object22.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)object22.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)object22.getSource()).isVisible());
                continue;
            }
            if (iViewNode.getParentGroup().isCollapsed()) {
                object22.setVisible(iViewNode.getParentGroup().isVisible() && ((IViewNode)object22.getTarget()).isVisible());
                continue;
            }
            object22.setVisible(((IViewNode)object22.getSource()).isVisible() && ((IViewNode)object22.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)object22.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)object22.getSource()).isVisible());
        }
    }

    @Override
    public void changedBorderColor(IViewNode iViewNode, Color color) {
        ZyGraphNode.access$100(this.this$0).setLineColor(color);
        ZyGraphNode.access$200(this.this$0);
    }

    @Override
    public void changedColor(IViewNode iViewNode, Color color) {
        ZyGraphNode.access$100(this.this$0).setFillColor(color);
        ZyGraphNode.access$200(this.this$0);
    }

    @Override
    public void changedLocation(IZyNodeRealizer iZyNodeRealizer, double d2, double d3) {
        ZyGraphNode.access$300(this.this$0).setX(d2);
        ZyGraphNode.access$300(this.this$0).setY(d3);
    }

    @Override
    public void changedSelection(IViewNode iViewNode, boolean bl2) {
        ZyGraphNode.access$100(this.this$0).setSelected(bl2);
        this.this$0.onSelectionChanged();
        ZyGraphNode.access$200(this.this$0);
    }

    @Override
    public void changedSelection(IZyNodeRealizer iZyNodeRealizer) {
        ZyGraphNode.access$300(this.this$0).setSelected(iZyNodeRealizer.isSelected());
    }

    @Override
    public void changedSize(IZyNodeRealizer iZyNodeRealizer, double d2, double d3) {
        ZyGraphNode.access$300(this.this$0).setWidth(d2);
        ZyGraphNode.access$300(this.this$0).setHeight(d3);
    }

    @Override
    public void changedVisibility(IViewNode iViewNode, boolean bl2) {
        new ZyGraphNode$InternalListener$1(this, iViewNode, bl2).invokeAndWait();
    }

    @Override
    public void changedVisibility(IZyNodeRealizer iZyNodeRealizer) {
        ZyGraphNode.access$300(this.this$0).setVisible(iZyNodeRealizer.isVisible());
    }

    @Override
    public void heightChanged(IViewNode iViewNode, double d2) {
        if (ZyGraphNode.access$100(this.this$0).getHeight() == d2) return;
        if (d2 == 0.0) return;
        ZyGraphNode.access$100(this.this$0).setHeight(d2);
        ZyGraphNode.access$200(this.this$0);
    }

    @Override
    public void regenerated(IZyNodeRealizer iZyNodeRealizer) {
    }

    @Override
    public void widthChanged(IViewNode iViewNode, double d2) {
        if (ZyGraphNode.access$100(this.this$0).getWidth() == d2) return;
        if (d2 == 0.0) return;
        ZyGraphNode.access$100(this.this$0).setWidth(d2);
        ZyGraphNode.access$200(this.this$0);
    }

    @Override
    public void xposChanged(IViewNode iViewNode, double d2) {
        if (ZyGraphNode.access$100(this.this$0).getX() == d2) return;
        ZyGraphNode.access$100(this.this$0).setX(d2);
        ZyGraphNode.access$200(this.this$0);
    }

    @Override
    public void yposChanged(IViewNode iViewNode, double d2) {
        if (ZyGraphNode.access$100(this.this$0).getY() == d2) return;
        ZyGraphNode.access$100(this.this$0).setY(d2);
        ZyGraphNode.access$200(this.this$0);
    }

    static /* synthetic */ void access$400(ZyGraphNode$InternalListener zyGraphNode$InternalListener, IViewNode iViewNode, boolean bl2) {
        zyGraphNode$InternalListener.showNode(iViewNode, bl2);
    }
}

