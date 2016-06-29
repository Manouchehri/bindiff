/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.IFineGrainedSloppyGraph2DView;
import y.h.bu;
import y.h.ch;
import y.h.fD;

public class ZyOverview
extends fD
implements IFineGrainedSloppyGraph2DView {
    private int _minEdgesForSloppyEdgeHiding;

    public ZyOverview(ch ch2) {
        super(ch2);
        this.setPaintDetailThreshold(0.0);
        this.setMinEdgesForSloppyEdgeHiding(1000);
    }

    @Override
    public boolean drawEdges() {
        if (this.getGraph2D().g() >= this._minEdgesForSloppyEdgeHiding) return false;
        return true;
    }

    @Override
    public boolean isEdgeSloppyPaintMode() {
        return true;
    }

    @Override
    public boolean isNodeSloppyPaintMode() {
        return true;
    }

    @Override
    public void setEdgeSloppyThreshold(double d2) {
    }

    @Override
    public void setMinEdgesForSloppyEdgeHiding(int n2) {
        this._minEdgesForSloppyEdgeHiding = n2;
    }

    @Override
    public void setNodeSloppyThreshold(double d2) {
    }

    @Override
    public void setSloppyEdgeHidingThreshold(double d2) {
    }
}

