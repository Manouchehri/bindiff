/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.IFineGrainedSloppyGraph2DView;
import java.awt.Graphics2D;
import y.h.O;
import y.h.aB;
import y.h.bu;
import y.h.fj;

public class ZyGraphFineGrainedRenderer
extends O {
    protected IFineGrainedSloppyGraph2DView m_view;
    private boolean m_drawEdges = true;

    public ZyGraphFineGrainedRenderer(IFineGrainedSloppyGraph2DView iFineGrainedSloppyGraph2DView) {
        this.m_view = iFineGrainedSloppyGraph2DView;
    }

    @Override
    protected void paint(Graphics2D graphics2D, aB aB2) {
        if (!this.m_drawEdges) {
            return;
        }
        if (this.m_view.isEdgeSloppyPaintMode()) {
            aB2.paintSloppy(graphics2D);
            return;
        }
        aB2.paint(graphics2D);
    }

    @Override
    protected void paint(Graphics2D graphics2D, fj fj2) {
        if (this.m_view.isNodeSloppyPaintMode()) {
            fj2.paintSloppy(graphics2D);
            return;
        }
        fj2.paint(graphics2D);
    }

    @Override
    protected void paintLayered(Graphics2D graphics2D, int n2, aB aB2) {
        super.paintLayered(graphics2D, n2, aB2);
    }

    @Override
    protected void paintLayered(Graphics2D graphics2D, int n2, fj fj2) {
        super.paintLayered(graphics2D, n2, fj2);
    }

    @Override
    protected void paintSloppy(Graphics2D graphics2D, aB aB2) {
        assert (false);
        return;
    }

    @Override
    protected void paintSloppy(Graphics2D graphics2D, fj fj2) {
        assert (false);
        return;
    }

    @Override
    protected void paintSloppyLayered(Graphics2D graphics2D, int n2, aB aB2) {
        assert (false);
        return;
    }

    @Override
    protected void paintSloppyLayered(Graphics2D graphics2D, int n2, fj fj2) {
        assert (false);
        return;
    }

    @Override
    public void paint(Graphics2D graphics2D, bu bu2) {
        this.m_drawEdges = this.m_view.drawEdges();
        super.paint(graphics2D, bu2);
    }
}

