/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.IFineGrainedSloppyGraph2DView;
import java.awt.Cursor;
import y.h.bu;
import y.h.ch;

public class ZyGraph2DView
extends ch
implements IFineGrainedSloppyGraph2DView {
    private static final long serialVersionUID = 9194672642118308276L;
    private double m_nodeSloppyThreshold;
    private double m_edgeSloppyThreshold;
    private int m_minEdgesForSloppyEdgeHiding;
    private double m_sloppyEdgeHidingThreshold;

    public ZyGraph2DView() {
        this.initDefaults();
    }

    public ZyGraph2DView(bu bu2) {
        super(bu2);
        this.initDefaults();
    }

    private void initDefaults() {
        this.m_nodeSloppyThreshold = this.getPaintDetailThreshold();
        this.m_edgeSloppyThreshold = 0.2;
        this.m_minEdgesForSloppyEdgeHiding = 3000;
        this.m_sloppyEdgeHidingThreshold = 0.1;
        this.setPaintDetailThreshold(0.0);
    }

    @Override
    public boolean drawEdges() {
        if (this.m_minEdgesForSloppyEdgeHiding >= this.getGraph2D().g()) {
            return true;
        }
        if (this.m_sloppyEdgeHidingThreshold > this.getZoom()) return false;
        return true;
    }

    @Override
    public boolean isEdgeSloppyPaintMode() {
        if (this.getZoom() >= this.m_edgeSloppyThreshold) return false;
        return true;
    }

    @Override
    public boolean isNodeSloppyPaintMode() {
        if (this.getZoom() >= this.m_nodeSloppyThreshold) return false;
        return true;
    }

    public void setCrossCursor(boolean bl2) {
        if (bl2) {
            super.setViewCursor(Cursor.getPredefinedCursor(13));
            return;
        }
        super.setViewCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void setEdgeSloppyThreshold(double d2) {
        this.m_edgeSloppyThreshold = d2;
    }

    @Override
    public void setMinEdgesForSloppyEdgeHiding(int n2) {
        this.m_minEdgesForSloppyEdgeHiding = n2;
    }

    @Override
    public void setNodeSloppyThreshold(double d2) {
        this.m_nodeSloppyThreshold = d2;
    }

    @Override
    public void setSloppyEdgeHidingThreshold(double d2) {
        this.m_sloppyEdgeHidingThreshold = d2;
    }

    @Override
    public void setViewCursor(Cursor cursor) {
    }
}

