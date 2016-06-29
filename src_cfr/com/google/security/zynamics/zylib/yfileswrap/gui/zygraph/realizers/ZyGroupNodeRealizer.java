/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.a.a;
import y.h.a.p;
import y.h.a.v;
import y.h.bu;
import y.h.dr;
import y.h.fj;

public class ZyGroupNodeRealizer
extends p
implements IZyNodeRealizer {
    private static final byte SHADOW_SIZE = 8;
    private static final Color SHADOW_COLOR = Color.GRAY;
    private final ZyLabelContent m_content;
    private ZyNodeData m_userData;
    private IRealizerUpdater m_updater;
    private final ListenerProvider m_listeners = new ListenerProvider();

    public ZyGroupNodeRealizer(ZyLabelContent zyLabelContent, boolean bl2) {
        this.setShapeType(1);
        this.setLineType(dr.b);
        this.setDropShadowOffsetX(8);
        this.setDropShadowOffsetY(8);
        this.setDropShadowColor(SHADOW_COLOR);
        this.m_content = zyLabelContent;
        Rectangle2D rectangle2D = this.getNodeContent().getBounds();
        this.setSize(rectangle2D.getWidth(), rectangle2D.getHeight());
        this.setGroupClosed(bl2);
    }

    private void addChildren(v v2, q q2, y y2) {
        x x2 = v2.p(q2);
        while (x2.f()) {
            q q3 = x2.e();
            if (v2.k(q3)) {
                this.addChildren(v2, q3, y2);
            } else {
                y2.add(q3);
            }
            x2.g();
        }
    }

    private void moveContent(double d2, double d3) {
        bu bu2 = (bu)this.m_userData.getNode().getNode().e();
        v v2 = bu2.C();
        y y2 = new y();
        this.addChildren(v2, this.getNode(), y2);
        this.moveNodes(bu2, y2.a(), d2, d3);
    }

    private void moveNodes(bu bu2, x x2, double d2, double d3) {
        while (x2.f()) {
            fj fj2 = bu2.t(x2.e());
            if (fj2.getAutoBoundsFeature() == null || !fj2.getAutoBoundsFeature().isAutoBoundsEnabled()) {
                fj2.moveBy(d2, d3);
            }
            x2.g();
        }
    }

    private void notifyLocationChanged(double d2, double d3) {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyNodeRealizerListener iZyNodeRealizerListener = (IZyNodeRealizerListener)iterator.next();
            try {
                iZyNodeRealizerListener.changedLocation(this, d2, d3);
            }
            catch (Exception var7_5) {}
        }
    }

    @Override
    public void addListener(IZyNodeRealizerListener iZyNodeRealizerListener) {
        this.m_listeners.addListener(iZyNodeRealizerListener);
    }

    @Override
    public ZyLabelContent getNodeContent() {
        return this.m_content;
    }

    @Override
    public fj getRealizer() {
        return this;
    }

    @Override
    public IRealizerUpdater getUpdater() {
        return this.m_updater;
    }

    @Override
    public ZyNodeData getUserData() {
        return this.m_userData;
    }

    @Override
    public void moveBy(double d2, double d3) {
        this.moveContent(d2, d3);
        super.moveBy(d2, d3);
        this.notifyLocationChanged(this.getX(), this.getY());
    }

    @Override
    public void paintHotSpots(Graphics2D graphics2D) {
    }

    @Override
    public void paintNode(Graphics2D graphics2D) {
        super.paintNode(graphics2D);
        IGroupNode iGroupNode = (IGroupNode)this.m_userData.getNode().getRawNode();
        if (!iGroupNode.isCollapsed()) return;
        this.getNodeContent().draw(graphics2D, this.getX(), this.getY() + 8.0);
    }

    @Override
    public int positionToRow(double d2) {
        return 0;
    }

    @Override
    public void regenerate() {
        this.m_updater.generateContent(this, this.m_content);
        Rectangle2D rectangle2D = this.m_content.getBounds();
        double d2 = this.getX();
        double d3 = this.getY();
        this.setSize(rectangle2D.getWidth(), rectangle2D.getHeight());
        this.setX(d2);
        this.setY(d3);
        Iterator iterator = this.m_listeners.iterator();
        do {
            if (!iterator.hasNext()) {
                this.repaint();
                return;
            }
            IZyNodeRealizerListener iZyNodeRealizerListener = (IZyNodeRealizerListener)iterator.next();
            try {
                iZyNodeRealizerListener.regenerated(this);
            }
            catch (Exception var8_6) {
            }
        } while (true);
    }

    @Override
    public void removeListener(IZyNodeRealizerListener iZyNodeRealizerListener) {
        this.m_listeners.removeListener(iZyNodeRealizerListener);
    }

    @Override
    public double rowToPosition(int n2) {
        return (double)this.m_content.getPaddingTop() + (double)n2 * this.m_content.getLineHeight();
    }

    @Override
    public void setCenter(double d2, double d3) {
        super.setCenter(d2, d3);
        this.notifyLocationChanged(d2, d3);
    }

    @Override
    public void setCenterX(double d2) {
        super.setCenterX(d2);
        this.notifyLocationChanged(d2, this.y);
    }

    @Override
    public void setFillColor(Color color) {
        super.setFillColor(color);
        this.updateContentSelectionColor();
    }

    @Override
    public void setGroupClosed(boolean bl2) {
        super.setGroupClosed(bl2);
        if (!bl2) return;
        Rectangle2D rectangle2D = this.m_content.getBounds();
        this.setSize(rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    @Override
    public void setLocation(double d2, double d3) {
        super.setLocation(d2, d3);
        this.notifyLocationChanged(d2, d3);
    }

    @Override
    public void setSelected(boolean bl2) {
        super.setSelected(bl2);
        this.updateContentSelectionColor();
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyNodeRealizerListener iZyNodeRealizerListener = (IZyNodeRealizerListener)iterator.next();
            try {
                iZyNodeRealizerListener.changedSelection(this);
            }
            catch (Exception var4_4) {}
        }
    }

    @Override
    public void setUpdater(IRealizerUpdater iRealizerUpdater) {
        this.m_updater = iRealizerUpdater;
        if (iRealizerUpdater == null) return;
        iRealizerUpdater.setRealizer(this);
    }

    @Override
    public void setUserData(ZyNodeData zyNodeData) {
        Preconditions.checkNotNull(zyNodeData, "Error: Invalid node data");
        Preconditions.checkArgument(zyNodeData.getNode().getRawNode() instanceof IGroupNode, "Error: User data does not contain a group node");
        this.m_userData = zyNodeData;
    }

    @Override
    public void setVisible(boolean bl2) {
        super.setVisible(bl2);
        this.updateContentSelectionColor();
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyNodeRealizerListener iZyNodeRealizerListener = (IZyNodeRealizerListener)iterator.next();
            try {
                iZyNodeRealizerListener.changedVisibility(this);
            }
            catch (Exception var4_4) {}
        }
    }

    @Override
    public void updateContentSelectionColor() {
        if (!this.m_content.isSelectable()) return;
        this.m_content.updateContentSelectionColor(this.getFillColor(), this.isSelected());
    }
}

