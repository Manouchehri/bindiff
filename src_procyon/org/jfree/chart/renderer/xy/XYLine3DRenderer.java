package org.jfree.chart.renderer.xy;

import java.io.*;
import org.jfree.chart.*;
import org.jfree.chart.event.*;
import java.awt.*;

public class XYLine3DRenderer extends XYLineAndShapeRenderer implements Serializable, Effect3D
{
    private static final long serialVersionUID = 588933208243446087L;
    public static final double DEFAULT_X_OFFSET = 12.0;
    public static final double DEFAULT_Y_OFFSET = 8.0;
    public static final Paint DEFAULT_WALL_PAINT;
    private double xOffset;
    private double yOffset;
    private transient Paint wallPaint;
    
    public XYLine3DRenderer() {
        this.wallPaint = XYLine3DRenderer.DEFAULT_WALL_PAINT;
        this.xOffset = 12.0;
        this.yOffset = 8.0;
    }
    
    public double getXOffset() {
        return this.xOffset;
    }
    
    public double getYOffset() {
        return this.yOffset;
    }
    
    public void setXOffset(final double xOffset) {
        this.xOffset = xOffset;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void setYOffset(final double yOffset) {
        this.yOffset = yOffset;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Paint getWallPaint() {
        return this.wallPaint;
    }
    
    public void setWallPaint(final Paint wallPaint) {
        this.wallPaint = wallPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public int getPassCount() {
        return 3;
    }
    
    protected boolean isLinePass(final int n) {
        return n == 0 || n == 1;
    }
    
    protected boolean isItemPass(final int n) {
        return n == 2;
    }
    
    protected boolean isShadowPass(final int n) {
        return n == 0;
    }
    
    protected void drawFirstPassShape(final Graphics2D graphics2D, final int n, final int n2, final int n3, final Shape shape) {
        if (this.isShadowPass(n)) {
            if (this.getWallPaint() != null) {
                graphics2D.setStroke(this.getItemStroke(n2, n3));
                graphics2D.setPaint(this.getWallPaint());
                graphics2D.translate(this.getXOffset(), this.getYOffset());
                graphics2D.draw(shape);
                graphics2D.translate(-this.getXOffset(), -this.getYOffset());
            }
        }
        else {
            super.drawFirstPassShape(graphics2D, n, n2, n3, shape);
        }
    }
    
    static {
        DEFAULT_WALL_PAINT = new Color(221, 221, 221);
    }
}
