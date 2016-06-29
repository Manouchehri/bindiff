/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import y.b.c;
import y.b.d;
import y.b.e;
import y.h.bu;
import y.h.bw;
import y.h.cR;
import y.h.cS;
import y.h.ch;
import y.h.dr;
import y.h.fj;

public class cQ
implements MouseWheelListener {
    private boolean g = false;
    private boolean j = true;
    private double e = Double.MIN_VALUE;
    private double c = Double.MAX_VALUE;
    private boolean f = false;
    private boolean d = false;
    private Color h;
    protected MouseWheelEvent lastMouseWheelEvent;
    private cS k;
    private boolean b = false;
    private e i;

    public cQ() {
        this.setZoomIndicatorColor(new Color(60, 60, 60));
    }

    public void addToCanvas(ch ch2) {
        ch2.getCanvasComponent().addMouseWheelListener(this);
    }

    public void removeFromCanvas(ch ch2) {
        ch2.getCanvasComponent().removeMouseWheelListener(this);
    }

    public void setLimitMinimumZoomByContentSize(boolean bl2) {
        this.d = bl2;
    }

    public boolean isLimitMinimumZoomByContentSize() {
        return this.d;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent var1_1) {
        var29_2 = fj.z;
        this.lastMouseWheelEvent = var1_1;
        var2_3 = var1_1.getSource();
        if (var2_3 instanceof bw == false) return;
        var3_4 = (bw)var2_3;
        var4_5 = (ch)var3_4.getParent();
        var5_6 = var3_4.c(var1_1.getX());
        var7_7 = var3_4.d(var1_1.getY());
        var9_8 = var3_4.h();
        var11_9 = 0;
        if (var1_1.getScrollType() != 1) ** GOTO lbl-1000
        var11_9 = var1_1.getWheelRotation();
        if (var29_2) lbl-1000: // 2 sources:
        {
            if (var1_1.getScrollType() == 0) {
                var11_9 = var1_1.getUnitsToScroll();
            }
        }
        if (var11_9 == 0) return;
        var12_10 = var3_4.g();
        var13_11 = this.calcZoom(var9_8, var11_9);
        var13_11 = Math.min(var13_11, this.getMaximumZoom());
        var13_11 = Math.max(var13_11, this.getMinimumZoom());
        if (this.isLimitMinimumZoomByContentSize()) {
            var15_12 = var4_5.getGraph2D().a();
            var16_14 = var4_5.getViewSize();
            var17_15 = (double)var15_12.width * var13_11;
            var19_16 = (double)var15_12.height * var13_11;
            var21_17 = Math.max(10, var16_14.width - 10);
            var23_18 = Math.max(10, var16_14.height - 10);
            if (var11_9 > 0 && var21_17 > var17_15 && var23_18 > var19_16) {
                var13_11 = var9_8;
                var25_19 = var21_17 / (double)var15_12.width;
                var27_20 = var23_18 / (double)var15_12.height;
                var13_11 = Math.min(var25_19, var27_20);
            }
        }
        if (var13_11 == var9_8) return;
        var4_5.setZoom(var13_11);
        if (!this.isCenterZoomEvent(var1_1)) ** GOTO lbl-1000
        var4_5.setCenter(var12_10.getX(), var12_10.getY());
        if (var29_2) lbl-1000: // 2 sources:
        {
            var15_13 = var3_4.c(var1_1.getX());
            var17_15 = var3_4.d(var1_1.getY());
            var5_6 = var12_10.getX() + var5_6 - var15_13;
            var7_7 = var12_10.getY() + var7_7 - var17_15;
            var4_5.setCenter(var5_6, var7_7);
        }
        this.adjustWorldRect(var4_5);
        var4_5.updateView();
        if (this.isZoomIndicatorShowing() == false) return;
        this.b(var11_9, var9_8, var13_11);
    }

    protected double calcZoom(double d2, int n2) {
        double d3;
        if (n2 == 0) {
            return d2;
        }
        if (this.g) {
            n2 *= -1;
        }
        if (n2 > 0) {
            d3 = d2 / 1.25;
            return d3;
        }
        d3 = d2 * 1.25;
        return d3;
    }

    protected void adjustWorldRect(ch ch2) {
        Rectangle rectangle = ch2.getGraph2D().a();
        ch2.setWorldRect(rectangle.x - 20, rectangle.y - 20, rectangle.width + 40, rectangle.height + 40);
    }

    protected boolean isCenterZoomEvent(MouseWheelEvent mouseWheelEvent) {
        if (!this.isCenterZooming()) return false;
        if ((mouseWheelEvent.getModifiers() & 2) != 0) return false;
        return true;
    }

    public boolean isCenterZooming() {
        return this.j;
    }

    public void setCenterZooming(boolean bl2) {
        this.j = bl2;
    }

    public double getMaximumZoom() {
        return this.c;
    }

    public void setMaximumZoom(double d2) {
        this.c = d2;
    }

    public double getMinimumZoom() {
        return this.e;
    }

    public void setMinimumZoom(double d2) {
        this.e = d2;
    }

    public boolean isDownInZooming() {
        return this.g;
    }

    public void setDownInZooming(boolean bl2) {
        this.g = bl2;
    }

    void b(double d2, double d3, double d4) {
        if (this.lastMouseWheelEvent == null) return;
        if (!(this.lastMouseWheelEvent.getSource() instanceof bw)) return;
        ch ch2 = (ch)((bw)this.lastMouseWheelEvent.getSource()).getParent();
        if (this.k == null) {
            this.k = new cS(this, ch2, true);
            this.i = new e(false);
            this.i.a(new cR(this));
            this.i.a(ch2);
        }
        if (this.b) return;
        this.k.d = d2 > 0.0;
        this.k.a = this.lastMouseWheelEvent.getX();
        this.k.b = this.lastMouseWheelEvent.getY();
        this.i.a(this.k);
    }

    public void setZoomIndicatorShowing(boolean bl2) {
        this.f = bl2;
    }

    public boolean isZoomIndicatorShowing() {
        return this.f;
    }

    protected void paintZoomIndicator(Graphics2D graphics2D, int n2, int n3, int n4, int n5, double d2, MouseWheelEvent mouseWheelEvent) {
        AffineTransform affineTransform;
        GeneralPath generalPath;
        int n6 = (int)(255.0 * (1.0 - 0.8 * d2));
        Color color = new Color(this.getZoomIndicatorColor().getRed(), this.getZoomIndicatorColor().getGreen(), this.getZoomIndicatorColor().getBlue(), n6);
        graphics2D.setStroke(dr.b);
        graphics2D.setColor(color);
        int n7 = 15;
        if (this.lastMouseWheelEvent.getWheelRotation() < 0) {
            generalPath = new GeneralPath(0, 5);
            generalPath.moveTo(n2, n3 + n7);
            generalPath.curveTo(n2, n3, n2, n3, n2 + n7, n3);
            graphics2D.draw(generalPath);
            affineTransform = AffineTransform.getScaleInstance(-1.0, 1.0);
            affineTransform.translate(-2 * n2 - n4, 1.0);
            graphics2D.draw(affineTransform.createTransformedShape(generalPath));
            affineTransform = AffineTransform.getScaleInstance(1.0, -1.0);
            affineTransform.translate(1.0, -2 * n3 - n5);
            graphics2D.draw(affineTransform.createTransformedShape(generalPath));
            affineTransform = AffineTransform.getScaleInstance(-1.0, -1.0);
            affineTransform.translate(-2 * n2 - n4, -2 * n3 - n5);
            graphics2D.draw(affineTransform.createTransformedShape(generalPath));
            if (!fj.z) return;
        }
        generalPath = new GeneralPath(0, 5);
        generalPath.moveTo(n2, n3 + n7);
        generalPath.curveTo(n2 + n7, n3 + n7, n2 + n7, n3 + n7, n2 + n7, n3);
        graphics2D.draw(generalPath);
        affineTransform = AffineTransform.getScaleInstance(-1.0, 1.0);
        affineTransform.translate(-2 * n2 - n4, 1.0);
        graphics2D.draw(affineTransform.createTransformedShape(generalPath));
        affineTransform = AffineTransform.getScaleInstance(1.0, -1.0);
        affineTransform.translate(1.0, -2 * n3 - n5);
        graphics2D.draw(affineTransform.createTransformedShape(generalPath));
        affineTransform = AffineTransform.getScaleInstance(-1.0, -1.0);
        affineTransform.translate(-2 * n2 - n4, -2 * n3 - n5);
        graphics2D.draw(affineTransform.createTransformedShape(generalPath));
    }

    public void setZoomIndicatorColor(Color color) {
        this.h = color;
    }

    public Color getZoomIndicatorColor() {
        return this.h;
    }

    static boolean access$002(cQ cQ2, boolean bl2) {
        cQ2.b = bl2;
        return cQ2.b;
    }

    static cS access$202(cQ cQ2, cS cS2) {
        cQ2.k = cS2;
        return cQ2.k;
    }
}

