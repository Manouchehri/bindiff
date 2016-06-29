/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.c.i;
import y.f.O;
import y.h.ch;
import y.h.dj;

public class LayoutMorpher
extends dj {
    private ch view;

    public LayoutMorpher(ch ch2, O o2) {
        super(ch2, o2);
    }

    @Override
    protected Rectangle2D calcBoundingBox(i i2, O o2, Rectangle2D rectangle2D) {
        super.calcBoundingBox(i2, o2, rectangle2D);
        Rectangle rectangle = this.view.getVisibleRect();
        double d2 = this.view.getZoom();
        this.view.fitRectangle(rectangle2D.getBounds());
        this.view.setZoom(this.view.getZoom() * 0.95);
        Rectangle rectangle2 = this.view.getVisibleRect();
        rectangle2D.setFrame(rectangle2.getX(), rectangle2.getY(), rectangle2.getWidth(), rectangle2.getHeight());
        this.view.fitRectangle(rectangle);
        this.view.setZoom(d2);
        return rectangle2D;
    }

    @Override
    protected void initialize(ch ch2, O o2) {
        super.initialize(ch2, o2);
        this.view = ch2;
    }
}

