package y.h;

import java.awt.geom.*;
import java.awt.event.*;
import java.beans.*;
import java.awt.*;

public class fD extends ch implements PropertyChangeListener
{
    ch tc;
    fF wc;
    boolean xc;
    private Rectangle2D vc;
    private final fH uc;
    private static boolean yc;
    
    public fD(final ch tc) {
        super(tc.getGraph2D(), null);
        this.uc = new fH(this);
        this.addViewMode(new fG(this, this));
        this.getCanvasComponent().addKeyListener(new fE(this));
        new hF(this);
        final cd graph2DRenderer = this.getGraph2DRenderer();
        if (graph2DRenderer instanceof O) {
            final O o = (O)graph2DRenderer;
            o.setDrawEdgesFirst(true);
            o.setSloppyNestedEdgeDrawingOrderEnabled(true);
        }
        this.tc = tc;
        this.tc.r().addPropertyChangeListener(this);
        this.tc.addPropertyChangeListener(this);
        this.wc = new fF(null);
        this.setScrollBarPolicy(21, 31);
        this.setPaintDetailThreshold(Double.MAX_VALUE);
    }
    
    bw u() {
        return new fI(this, this);
    }
    
    private static double c(final double n, final double n2, final double n3) {
        final boolean z = fj.z;
        double n4 = 0.0;
        double n5 = n3 - 0.5;
        double n6 = 0.0;
    Label_0118_Outer:
        while (n5 < n3 + 0.6) {
            n6 = n2 - 0.5;
            if (!z) {
                double n7 = n6;
                while (true) {
                    while (n7 < n2 + 0.6) {
                        n4 += 1.0 / (6.283185307179586 * n * n) * Math.pow(2.718281828459045, -(n7 * n7 + n5 * n5) / (2.0 * n * n));
                        n7 += 0.1;
                        if (!z) {
                            if (z) {
                                break;
                            }
                            continue Label_0118_Outer;
                        }
                        else {
                            if (z) {
                                break Label_0118_Outer;
                            }
                            continue Label_0118_Outer;
                        }
                    }
                    n5 += 0.1;
                    continue;
                }
            }
            return n6;
        }
        return n6;
    }
    
    private static float[] b(final double n, final int n2) {
        final boolean z = fj.z;
        final float[] array = new float[n2 * n2];
        float n3 = 0.0f;
        int i = 0;
    Label_0017:
        while (true) {
        Label_0098_Outer:
            while (i < n2) {
                final int n4 = 0;
                if (!z) {
                    int j = n4;
                    while (true) {
                        while (j < n2) {
                            final float n5 = (float)c(n, j - n2 * 0.5, i - n2 * 0.5);
                            array[j + i * n2] = n5;
                            n3 += n5;
                            ++j;
                            if (!z) {
                                if (z) {
                                    break;
                                }
                                continue Label_0098_Outer;
                            }
                            else {
                                if (z) {
                                    break Label_0098_Outer;
                                }
                                continue Label_0017;
                            }
                        }
                        ++i;
                        continue;
                    }
                }
                int k = n4;
                while (k < array.length) {
                    final float[] array3;
                    final float[] array2 = array3 = array;
                    if (z) {
                        return array3;
                    }
                    final int n6 = k;
                    array2[n6] /= n3;
                    ++k;
                    if (z) {
                        break;
                    }
                }
                return array;
            }
            continue;
        }
    }
    
    protected void adjustWorldRect(final ch ch) {
        final Rectangle a = ch.getGraph2D().a();
        ch.setWorldRect(a.x - 20, a.y - 20, a.width + 40, a.height + 40);
    }
    
    public void updateView() {
        if (this.tc == null) {
            return;
        }
        final Rectangle visibleRect = this.tc.getVisibleRect();
        if (this.wc != null) {
            this.wc.a(visibleRect.getX(), visibleRect.getY(), visibleRect.getWidth(), visibleRect.getHeight());
        }
        this.xc = true;
        super.updateView();
    }
    
    void c(final int n, final int n2, final int n3, final int n4) {
        if (this.tc == null) {
            return;
        }
        final Rectangle visibleRect = this.tc.getVisibleRect();
        if (this.wc != null) {
            this.wc.a(visibleRect.getX(), visibleRect.getY(), visibleRect.getWidth(), visibleRect.getHeight());
        }
        this.xc = true;
        this.repaint(n, n2, n3, n4);
    }
    
    public void reshape(final int n, final int n2, final int n3, final int n4) {
        super.reshape(n, n2, n3, n4);
        this.updateView();
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        final boolean z = fj.z;
        if ("Graph2D".equals(propertyChangeEvent.getPropertyName())) {
            this.setGraph2D(this.tc.getGraph2D());
            if (!z) {
                return;
            }
        }
        if ("Zoom".equals(propertyChangeEvent.getPropertyName())) {
            final boolean xc = this.xc;
            Label_0219: {
                if (this.vc != null) {
                    final Rectangle visibleRect = this.tc.getVisibleRect();
                    final Rectangle2D union = visibleRect.createUnion(this.vc);
                    final double max = Math.max((double)propertyChangeEvent.getOldValue(), (double)propertyChangeEvent.getNewValue());
                    final Point viewPoint = this.getViewPoint();
                    this.c((int)Math.floor((union.getX() - viewPoint.getX()) * max) - 1, (int)Math.floor((union.getY() - viewPoint.getY()) * max) - 1, (int)Math.ceil(union.getWidth() * max) + 4, (int)Math.ceil(union.getHeight() * max) + 4);
                    this.vc = visibleRect;
                    if (!z) {
                        break Label_0219;
                    }
                }
                this.updateView();
                this.vc = this.tc.getVisibleRect();
            }
            this.xc = xc;
            if (!z) {
                return;
            }
        }
        if ("ViewPoint".equals(propertyChangeEvent.getPropertyName())) {
            final boolean xc2 = this.xc;
            Label_0397: {
                if (this.vc != null) {
                    final Rectangle visibleRect2 = this.tc.getVisibleRect();
                    final Rectangle2D union2 = visibleRect2.createUnion(this.vc);
                    final Point viewPoint2 = this.getViewPoint();
                    final double zoom = this.getZoom();
                    this.c((int)Math.floor((union2.getX() - viewPoint2.getX()) * zoom) - 1, (int)Math.floor((union2.getY() - viewPoint2.getY()) * zoom) - 1, (int)Math.ceil(union2.getWidth() * zoom) + 4, (int)Math.ceil(union2.getHeight() * zoom) + 4);
                    this.vc = visibleRect2;
                    if (!z) {
                        break Label_0397;
                    }
                }
                this.updateView();
                this.vc = this.tc.getVisibleRect();
            }
            this.xc = xc2;
            if (!z) {
                return;
            }
        }
        this.updateView();
    }
    
    void b(final double n, final double n2, final double n3) {
        if (n3 < 1.0 && Boolean.TRUE.equals(this.getClientProperty("Overview.AnimateScrollTo"))) {
            this.uc.a(n, n2, n3);
            if (!fj.z) {
                return;
            }
        }
        this.tc.setCenter(n, n2);
        this.tc.updateView();
    }
    
    static float[] access$100(final double n, final int n2) {
        return b(n, n2);
    }
    
    static boolean access$200() {
        return fD.yc;
    }
    
    static {
        fD.yc = false;
        try {
            fD.yc = System.getProperty("os.name").toLowerCase().startsWith("mac");
        }
        catch (SecurityException ex) {
            fD.yc = false;
        }
    }
}
