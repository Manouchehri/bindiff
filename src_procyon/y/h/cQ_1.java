package y.h;

import java.awt.event.*;
import y.b.*;
import java.awt.*;
import java.awt.geom.*;

public class cQ implements MouseWheelListener
{
    private boolean g;
    private boolean j;
    private double e;
    private double c;
    private boolean f;
    private boolean d;
    private Color h;
    protected MouseWheelEvent lastMouseWheelEvent;
    private cS k;
    private boolean b;
    private e i;
    
    public cQ() {
        this.d = false;
        this.b = false;
        this.g = false;
        this.j = true;
        this.e = Double.MIN_VALUE;
        this.c = Double.MAX_VALUE;
        this.f = false;
        this.setZoomIndicatorColor(new Color(60, 60, 60));
    }
    
    public void addToCanvas(final ch ch) {
        ch.getCanvasComponent().addMouseWheelListener(this);
    }
    
    public void removeFromCanvas(final ch ch) {
        ch.getCanvasComponent().removeMouseWheelListener(this);
    }
    
    public void setLimitMinimumZoomByContentSize(final boolean d) {
        this.d = d;
    }
    
    public boolean isLimitMinimumZoomByContentSize() {
        return this.d;
    }
    
    public void mouseWheelMoved(final MouseWheelEvent lastMouseWheelEvent) {
        final boolean z = fj.z;
        this.lastMouseWheelEvent = lastMouseWheelEvent;
        final Object source = lastMouseWheelEvent.getSource();
        if (source instanceof bw) {
            final bw bw = (bw)source;
            final ch ch = (ch)bw.getParent();
            final double c = bw.c(lastMouseWheelEvent.getX());
            final double d = bw.d(lastMouseWheelEvent.getY());
            final double h = bw.h();
            int n = 0;
            Label_0099: {
                if (lastMouseWheelEvent.getScrollType() == 1) {
                    n = lastMouseWheelEvent.getWheelRotation();
                    if (!z) {
                        break Label_0099;
                    }
                }
                if (lastMouseWheelEvent.getScrollType() == 0) {
                    n = lastMouseWheelEvent.getUnitsToScroll();
                }
            }
            if (n != 0) {
                final Point2D g = bw.g();
                double zoom = Math.max(Math.min(this.calcZoom(h, n), this.getMaximumZoom()), this.getMinimumZoom());
                if (this.isLimitMinimumZoomByContentSize()) {
                    final Rectangle a = ch.getGraph2D().a();
                    final Dimension viewSize = ch.getViewSize();
                    final double n2 = a.width * zoom;
                    final double n3 = a.height * zoom;
                    final double n4 = Math.max(10, viewSize.width - 10);
                    final double n5 = Math.max(10, viewSize.height - 10);
                    if (n > 0 && n4 > n2 && n5 > n3) {
                        zoom = Math.min(n4 / a.width, n5 / a.height);
                    }
                }
                if (zoom != h) {
                    ch.setZoom(zoom);
                    Label_0376: {
                        if (this.isCenterZoomEvent(lastMouseWheelEvent)) {
                            ch.setCenter(g.getX(), g.getY());
                            if (!z) {
                                break Label_0376;
                            }
                        }
                        ch.setCenter(g.getX() + c - bw.c(lastMouseWheelEvent.getX()), g.getY() + d - bw.d(lastMouseWheelEvent.getY()));
                    }
                    this.adjustWorldRect(ch);
                    ch.updateView();
                    if (this.isZoomIndicatorShowing()) {
                        this.b(n, h, zoom);
                    }
                }
            }
        }
    }
    
    protected double calcZoom(final double n, int n2) {
        if (n2 == 0) {
            return n;
        }
        if (this.g) {
            n2 *= -1;
        }
        return (n2 > 0) ? (n / 1.25) : (n * 1.25);
    }
    
    protected void adjustWorldRect(final ch ch) {
        final Rectangle a = ch.getGraph2D().a();
        ch.setWorldRect(a.x - 20, a.y - 20, a.width + 40, a.height + 40);
    }
    
    protected boolean isCenterZoomEvent(final MouseWheelEvent mouseWheelEvent) {
        return this.isCenterZooming() && (mouseWheelEvent.getModifiers() & 0x2) == 0x0;
    }
    
    public boolean isCenterZooming() {
        return this.j;
    }
    
    public void setCenterZooming(final boolean j) {
        this.j = j;
    }
    
    public double getMaximumZoom() {
        return this.c;
    }
    
    public void setMaximumZoom(final double c) {
        this.c = c;
    }
    
    public double getMinimumZoom() {
        return this.e;
    }
    
    public void setMinimumZoom(final double e) {
        this.e = e;
    }
    
    public boolean isDownInZooming() {
        return this.g;
    }
    
    public void setDownInZooming(final boolean g) {
        this.g = g;
    }
    
    void b(final double n, final double n2, final double n3) {
        if (this.lastMouseWheelEvent != null && this.lastMouseWheelEvent.getSource() instanceof bw) {
            final ch ch = (ch)((bw)this.lastMouseWheelEvent.getSource()).getParent();
            if (this.k == null) {
                this.k = new cS(this, ch, true);
                (this.i = new e(false)).a(new cR(this));
                this.i.a(ch);
            }
            if (!this.b) {
                this.k.d = (n > 0.0);
                this.k.a = this.lastMouseWheelEvent.getX();
                this.k.b = this.lastMouseWheelEvent.getY();
                this.i.a(this.k);
            }
        }
    }
    
    public void setZoomIndicatorShowing(final boolean f) {
        this.f = f;
    }
    
    public boolean isZoomIndicatorShowing() {
        return this.f;
    }
    
    protected void paintZoomIndicator(final Graphics2D graphics2D, final int n, final int n2, final int n3, final int n4, final double n5, final MouseWheelEvent mouseWheelEvent) {
        final Color color = new Color(this.getZoomIndicatorColor().getRed(), this.getZoomIndicatorColor().getGreen(), this.getZoomIndicatorColor().getBlue(), (int)(255.0 * (1.0 - 0.8 * n5)));
        graphics2D.setStroke(dr.b);
        graphics2D.setColor(color);
        final int n6 = 15;
        if (this.lastMouseWheelEvent.getWheelRotation() < 0) {
            final GeneralPath generalPath = new GeneralPath(0, 5);
            generalPath.moveTo(n, n2 + n6);
            generalPath.curveTo(n, n2, n, n2, n + n6, n2);
            graphics2D.draw(generalPath);
            final AffineTransform scaleInstance = AffineTransform.getScaleInstance(-1.0, 1.0);
            scaleInstance.translate(-2 * n - n3, 1.0);
            graphics2D.draw(scaleInstance.createTransformedShape(generalPath));
            final AffineTransform scaleInstance2 = AffineTransform.getScaleInstance(1.0, -1.0);
            scaleInstance2.translate(1.0, -2 * n2 - n4);
            graphics2D.draw(scaleInstance2.createTransformedShape(generalPath));
            final AffineTransform scaleInstance3 = AffineTransform.getScaleInstance(-1.0, -1.0);
            scaleInstance3.translate(-2 * n - n3, -2 * n2 - n4);
            graphics2D.draw(scaleInstance3.createTransformedShape(generalPath));
            if (!fj.z) {
                return;
            }
        }
        final GeneralPath generalPath2 = new GeneralPath(0, 5);
        generalPath2.moveTo(n, n2 + n6);
        generalPath2.curveTo(n + n6, n2 + n6, n + n6, n2 + n6, n + n6, n2);
        graphics2D.draw(generalPath2);
        final AffineTransform scaleInstance4 = AffineTransform.getScaleInstance(-1.0, 1.0);
        scaleInstance4.translate(-2 * n - n3, 1.0);
        graphics2D.draw(scaleInstance4.createTransformedShape(generalPath2));
        final AffineTransform scaleInstance5 = AffineTransform.getScaleInstance(1.0, -1.0);
        scaleInstance5.translate(1.0, -2 * n2 - n4);
        graphics2D.draw(scaleInstance5.createTransformedShape(generalPath2));
        final AffineTransform scaleInstance6 = AffineTransform.getScaleInstance(-1.0, -1.0);
        scaleInstance6.translate(-2 * n - n3, -2 * n2 - n4);
        graphics2D.draw(scaleInstance6.createTransformedShape(generalPath2));
    }
    
    public void setZoomIndicatorColor(final Color h) {
        this.h = h;
    }
    
    public Color getZoomIndicatorColor() {
        return this.h;
    }
    
    static boolean access$002(final cQ cq, final boolean b) {
        return cq.b = b;
    }
    
    static cS access$202(final cQ cq, final cS k) {
        return cq.k = k;
    }
}
