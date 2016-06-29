/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import java.awt.Color;

public class CProximityNode
extends CViewNode
implements IViewNode {
    private final IViewNode m_attachedNode;

    public CProximityNode(IViewNode iViewNode) {
        super(0, 0.0, 0.0, 0.0, 0.0, Color.WHITE, Color.BLACK, false, false);
        this.m_attachedNode = (IViewNode)Preconditions.checkNotNull(iViewNode, "Error: Attached node argument can not be null");
    }

    public IViewNode getAttachedNode() {
        return this.m_attachedNode;
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public int getId() {
        return -1;
    }

    @Override
    public IGroupNode getParentGroup() {
        return null;
    }

    @Override
    public double getX() {
        return 0.0;
    }

    @Override
    public double getY() {
        return 0.0;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public void setColor(Color color) {
        throw new UnsupportedOperationException("Error: Proximity browsing nodes can not change colors");
    }
}

