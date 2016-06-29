package com.google.security.zynamics.bindiff.graph.layout;

import y.h.*;
import y.f.*;
import y.c.*;
import java.awt.geom.*;
import java.awt.*;
import java.beans.*;

public class SuperLayoutMorpher extends dj
{
    private final bu superGraph;
    private ch view;
    
    public SuperLayoutMorpher(final ch ch, final O o, final bu superGraph) {
        super(ch, o);
        this.superGraph = superGraph;
    }
    
    @Override
    protected Rectangle2D calcBoundingBox(final i i, final O o, final Rectangle2D rectangle2D) {
        super.calcBoundingBox(this.superGraph, o, rectangle2D);
        final Rectangle visibleRect = this.view.getVisibleRect();
        final double zoom = this.view.getZoom();
        final PropertyChangeListener[] propertyChangeListeners;
        final PropertyChangeListener[] array = propertyChangeListeners = this.view.getPropertyChangeListeners();
        for (int length = propertyChangeListeners.length, j = 0; j < length; ++j) {
            this.view.removePropertyChangeListener(propertyChangeListeners[j]);
        }
        this.view.fitRectangle(rectangle2D.getBounds());
        this.view.setZoom(this.view.getZoom() * 0.95);
        final Rectangle visibleRect2 = this.view.getVisibleRect();
        rectangle2D.setFrame(visibleRect2.getX(), visibleRect2.getY(), visibleRect2.getWidth(), visibleRect2.getHeight());
        this.view.fitRectangle(visibleRect);
        this.view.setZoom(zoom);
        final PropertyChangeListener[] array2 = array;
        for (int length2 = array2.length, k = 0; k < length2; ++k) {
            this.view.addPropertyChangeListener(array2[k]);
        }
        return rectangle2D;
    }
    
    @Override
    protected void initialize(final ch view, final O o) {
        super.initialize(view, o);
        this.view = view;
    }
}
