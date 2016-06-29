/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeListener;
import y.c.i;
import y.f.O;
import y.h.bu;
import y.h.ch;
import y.h.dj;

public class SuperLayoutMorpher
extends dj {
    private final bu superGraph;
    private ch view;

    public SuperLayoutMorpher(ch ch2, O o2, bu bu2) {
        super(ch2, o2);
        this.superGraph = bu2;
    }

    @Override
    protected Rectangle2D calcBoundingBox(i i2, O o2, Rectangle2D rectangle2D) {
        PropertyChangeListener[] arrpropertyChangeListener;
        super.calcBoundingBox(this.superGraph, o2, rectangle2D);
        Rectangle rectangle = this.view.getVisibleRect();
        double d2 = this.view.getZoom();
        for (PropertyChangeListener propertyChangeListener : arrpropertyChangeListener = this.view.getPropertyChangeListeners()) {
            this.view.removePropertyChangeListener(propertyChangeListener);
        }
        this.view.fitRectangle(rectangle2D.getBounds());
        this.view.setZoom(this.view.getZoom() * 0.95);
        PropertyChangeListener[] arrpropertyChangeListener2 = this.view.getVisibleRect();
        rectangle2D.setFrame(arrpropertyChangeListener2.getX(), arrpropertyChangeListener2.getY(), arrpropertyChangeListener2.getWidth(), arrpropertyChangeListener2.getHeight());
        this.view.fitRectangle(rectangle);
        this.view.setZoom(d2);
        PropertyChangeListener[] arrpropertyChangeListener3 = arrpropertyChangeListener;
        int n2 = arrpropertyChangeListener3.length;
        int n3 = 0;
        while (n3 < n2) {
            PropertyChangeListener propertyChangeListener2 = arrpropertyChangeListener3[n3];
            this.view.addPropertyChangeListener(propertyChangeListener2);
            ++n3;
        }
        return rectangle2D;
    }

    @Override
    protected void initialize(ch ch2, O o2) {
        super.initialize(ch2, o2);
        this.view = ch2;
    }
}

