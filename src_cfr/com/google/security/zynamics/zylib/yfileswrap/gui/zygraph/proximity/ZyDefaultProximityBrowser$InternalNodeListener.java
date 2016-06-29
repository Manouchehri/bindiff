/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;

class ZyDefaultProximityBrowser$InternalNodeListener
implements IViewNodeListener {
    private double m_x;
    private double m_y;
    private final ZyProximityNode m_infoNode;
    final /* synthetic */ ZyDefaultProximityBrowser this$0;

    public ZyDefaultProximityBrowser$InternalNodeListener(ZyDefaultProximityBrowser zyDefaultProximityBrowser, double d2, double d3, ZyProximityNode zyProximityNode) {
        this.this$0 = zyDefaultProximityBrowser;
        this.m_x = d2;
        this.m_y = d3;
        this.m_infoNode = zyProximityNode;
    }

    @Override
    public void changedBorderColor(IViewNode iViewNode, Color color) {
    }

    @Override
    public void changedColor(IViewNode iViewNode, Color color) {
    }

    @Override
    public void changedSelection(IViewNode iViewNode, boolean bl2) {
    }

    @Override
    public void changedVisibility(IViewNode iViewNode, boolean bl2) {
    }

    @Override
    public void heightChanged(IViewNode iViewNode, double d2) {
    }

    @Override
    public void widthChanged(IViewNode iViewNode, double d2) {
    }

    @Override
    public void xposChanged(IViewNode iViewNode, double d2) {
        this.m_infoNode.getRealizer().setX(this.m_infoNode.getX() + d2 - this.m_x);
        this.m_x = d2;
    }

    @Override
    public void yposChanged(IViewNode iViewNode, double d2) {
        this.m_infoNode.getRealizer().setY(this.m_infoNode.getY() + d2 - this.m_y);
        this.m_y = d2;
    }
}

