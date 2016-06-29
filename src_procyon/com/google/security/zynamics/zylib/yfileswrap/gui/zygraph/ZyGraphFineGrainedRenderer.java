package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import java.awt.*;
import y.h.*;

public class ZyGraphFineGrainedRenderer extends O
{
    protected IFineGrainedSloppyGraph2DView m_view;
    private boolean m_drawEdges;
    
    public ZyGraphFineGrainedRenderer(final IFineGrainedSloppyGraph2DView view) {
        this.m_drawEdges = true;
        this.m_view = view;
    }
    
    @Override
    protected void paint(final Graphics2D graphics2D, final aB ab) {
        if (!this.m_drawEdges) {
            return;
        }
        if (this.m_view.isEdgeSloppyPaintMode()) {
            ab.paintSloppy(graphics2D);
        }
        else {
            ab.paint(graphics2D);
        }
    }
    
    @Override
    protected void paint(final Graphics2D graphics2D, final fj fj) {
        if (this.m_view.isNodeSloppyPaintMode()) {
            fj.paintSloppy(graphics2D);
        }
        else {
            fj.paint(graphics2D);
        }
    }
    
    @Override
    protected void paintLayered(final Graphics2D graphics2D, final int n, final aB ab) {
        super.paintLayered(graphics2D, n, ab);
    }
    
    @Override
    protected void paintLayered(final Graphics2D graphics2D, final int n, final fj fj) {
        super.paintLayered(graphics2D, n, fj);
    }
    
    @Override
    protected void paintSloppy(final Graphics2D graphics2D, final aB ab) {
        assert false : "The sloppy paint methods should not be called";
    }
    
    @Override
    protected void paintSloppy(final Graphics2D graphics2D, final fj fj) {
        assert false : "The sloppy paint methods should not be called";
    }
    
    @Override
    protected void paintSloppyLayered(final Graphics2D graphics2D, final int n, final aB ab) {
        assert false : "The sloppy paint methods should not be called";
    }
    
    @Override
    protected void paintSloppyLayered(final Graphics2D graphics2D, final int n, final fj fj) {
        assert false : "The sloppy paint methods should not be called";
    }
    
    @Override
    public void paint(final Graphics2D graphics2D, final bu bu) {
        this.m_drawEdges = this.m_view.drawEdges();
        super.paint(graphics2D, bu);
    }
}
