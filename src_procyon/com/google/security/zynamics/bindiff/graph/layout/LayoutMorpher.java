package com.google.security.zynamics.bindiff.graph.layout;

import y.h.*;
import y.f.*;
import y.c.*;
import java.awt.geom.*;
import java.awt.*;

public class LayoutMorpher extends dj
{
    private ch view;
    
    public LayoutMorpher(final ch ch, final O o) {
        super(ch, o);
    }
    
    @Override
    protected Rectangle2D calcBoundingBox(final i i, final O o, final Rectangle2D rectangle2D) {
        super.calcBoundingBox(i, o, rectangle2D);
        final Rectangle visibleRect = this.view.getVisibleRect();
        final double zoom = this.view.getZoom();
        this.view.fitRectangle(rectangle2D.getBounds());
        this.view.setZoom(this.view.getZoom() * 0.95);
        final Rectangle visibleRect2 = this.view.getVisibleRect();
        rectangle2D.setFrame(visibleRect2.getX(), visibleRect2.getY(), visibleRect2.getWidth(), visibleRect2.getHeight());
        this.view.fitRectangle(visibleRect);
        this.view.setZoom(zoom);
        return rectangle2D;
    }
    
    @Override
    protected void initialize(final ch view, final O o) {
        super.initialize(view, o);
        this.view = view;
    }
}
