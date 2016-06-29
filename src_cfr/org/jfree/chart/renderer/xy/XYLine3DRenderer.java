/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.Serializable;
import org.jfree.chart.Effect3D;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class XYLine3DRenderer
extends XYLineAndShapeRenderer
implements Serializable,
Effect3D {
    private static final long serialVersionUID = 588933208243446087L;
    public static final double DEFAULT_X_OFFSET = 12.0;
    public static final double DEFAULT_Y_OFFSET = 8.0;
    public static final Paint DEFAULT_WALL_PAINT = new Color(221, 221, 221);
    private double xOffset = 12.0;
    private double yOffset = 8.0;
    private transient Paint wallPaint = DEFAULT_WALL_PAINT;

    @Override
    public double getXOffset() {
        return this.xOffset;
    }

    @Override
    public double getYOffset() {
        return this.yOffset;
    }

    public void setXOffset(double d2) {
        this.xOffset = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public void setYOffset(double d2) {
        this.yOffset = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getWallPaint() {
        return this.wallPaint;
    }

    public void setWallPaint(Paint paint) {
        this.wallPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public int getPassCount() {
        return 3;
    }

    @Override
    protected boolean isLinePass(int n2) {
        if (n2 == 0) return true;
        if (n2 == 1) return true;
        return false;
    }

    @Override
    protected boolean isItemPass(int n2) {
        if (n2 != 2) return false;
        return true;
    }

    protected boolean isShadowPass(int n2) {
        if (n2 != 0) return false;
        return true;
    }

    @Override
    protected void drawFirstPassShape(Graphics2D graphics2D, int n2, int n3, int n4, Shape shape) {
        if (this.isShadowPass(n2)) {
            if (this.getWallPaint() == null) return;
            graphics2D.setStroke(this.getItemStroke(n3, n4));
            graphics2D.setPaint(this.getWallPaint());
            graphics2D.translate(this.getXOffset(), this.getYOffset());
            graphics2D.draw(shape);
            graphics2D.translate(- this.getXOffset(), - this.getYOffset());
            return;
        }
        super.drawFirstPassShape(graphics2D, n2, n3, n4, shape);
    }
}

