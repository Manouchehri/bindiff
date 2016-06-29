/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import y.h.O;
import y.h.bu;
import y.h.bw;
import y.h.cd;
import y.h.ch;
import y.h.fE;
import y.h.fF;
import y.h.fG;
import y.h.fH;
import y.h.fI;
import y.h.fj;
import y.h.gU;
import y.h.gV;
import y.h.gX;
import y.h.hF;

public class fD
extends ch
implements PropertyChangeListener {
    ch tc;
    fF wc;
    boolean xc;
    private Rectangle2D vc;
    private final fH uc;
    private static boolean yc = false;

    public fD(ch ch2) {
        super(ch2.getGraph2D(), null);
        this.uc = new fH(this);
        this.addViewMode(new fG(this, this));
        this.getCanvasComponent().addKeyListener(new fE(this));
        new hF(this);
        cd cd2 = this.getGraph2DRenderer();
        if (cd2 instanceof O) {
            O o2 = (O)cd2;
            o2.setDrawEdgesFirst(true);
            o2.setSloppyNestedEdgeDrawingOrderEnabled(true);
        }
        this.tc = ch2;
        this.tc.r().addPropertyChangeListener(this);
        this.tc.addPropertyChangeListener(this);
        this.wc = new fF(null);
        this.setScrollBarPolicy(21, 31);
        this.setPaintDetailThreshold(Double.MAX_VALUE);
    }

    @Override
    bw u() {
        return new fI(this, this);
    }

    private static double c(double d2, double d3, double d4) {
        double d5;
        boolean bl2 = fj.z;
        double d6 = 0.0;
        double d7 = d4 - 0.5;
        while (d7 < d4 + 0.6) {
            block3 : {
                d5 = d3 - 0.5;
                if (bl2) return d5;
                for (double d8 = v2226426; d8 < d3 + 0.6; d6 += 1.0 / (6.283185307179586 * d2 * d2) * Math.pow((double)2.718281828459045, (double)((- d8 * d8 + d7 * d7) / (2.0 * d2 * d2))), d8 += 0.1) {
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block3;
                }
                d7 += 0.1;
            }
            if (!bl2) continue;
        }
        d5 = d6 /= 121.0;
        return d5;
    }

    private static float[] b(double d2, int n2) {
        float f2;
        float[] arrf;
        float[] arrf2;
        int n3;
        boolean bl2;
        block4 : {
            int n4;
            bl2 = fj.z;
            arrf = new float[n2 * n2];
            f2 = 0.0f;
            n3 = 0;
            while (n3 < n2) {
                block5 : {
                    float f3;
                    n4 = 0;
                    if (bl2) break block4;
                    for (int i2 = v2226475; i2 < n2; f2 += f3, ++i2) {
                        arrf[i2 + n3 * n2] = f3 = (float)fD.c(d2, (double)i2 - (double)n2 * 0.5, (double)n3 - (double)n2 * 0.5);
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block5;
                    }
                    ++n3;
                }
                if (!bl2) continue;
            }
            n4 = n3 = 0;
        }
        while (n3 < arrf.length) {
            arrf2 = arrf;
            if (bl2) return arrf2;
            int n5 = n3++;
            arrf2[n5] = arrf2[n5] / f2;
            if (!bl2) continue;
        }
        arrf2 = arrf;
        return arrf2;
    }

    protected void adjustWorldRect(ch ch2) {
        Rectangle rectangle = ch2.getGraph2D().a();
        ch2.setWorldRect(rectangle.x - 20, rectangle.y - 20, rectangle.width + 40, rectangle.height + 40);
    }

    @Override
    public void updateView() {
        if (this.tc == null) {
            return;
        }
        Rectangle rectangle = this.tc.getVisibleRect();
        if (this.wc != null) {
            this.wc.a(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        }
        this.xc = true;
        super.updateView();
    }

    void c(int n2, int n3, int n4, int n5) {
        if (this.tc == null) {
            return;
        }
        Rectangle rectangle = this.tc.getVisibleRect();
        if (this.wc != null) {
            this.wc.a(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        }
        this.xc = true;
        this.repaint(n2, n3, n4, n5);
    }

    @Override
    public void reshape(int n2, int n3, int n4, int n5) {
        super.reshape(n2, n3, n4, n5);
        this.updateView();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void propertyChange(PropertyChangeEvent var1_1) {
        var12_2 = fj.z;
        if ("Graph2D".equals(var1_1.getPropertyName())) {
            this.setGraph2D(this.tc.getGraph2D());
            if (var12_2 == false) return;
        }
        if (!"Zoom".equals(var1_1.getPropertyName())) ** GOTO lbl23
        var2_3 = this.xc;
        if (this.vc == null) ** GOTO lbl-1000
        var3_4 = this.tc.getVisibleRect();
        var4_5 = var3_4.createUnion(this.vc);
        var5_6 = Math.max((Double)var1_1.getOldValue(), (Double)var1_1.getNewValue());
        var7_8 = this.getViewPoint();
        var8_9 = (int)Math.floor((var4_5.getX() - var7_8.getX()) * var5_6);
        var9_10 = (int)Math.floor((var4_5.getY() - var7_8.getY()) * var5_6);
        var10_11 = (int)Math.ceil(var4_5.getWidth() * var5_6);
        var11_12 = (int)Math.ceil(var4_5.getHeight() * var5_6);
        this.c(var8_9 - 1, var9_10 - 1, var10_11 + 4, var11_12 + 4);
        this.vc = var3_4;
        if (var12_2) lbl-1000: // 2 sources:
        {
            this.updateView();
            this.vc = this.tc.getVisibleRect();
        }
        this.xc = var2_3;
        if (var12_2 == false) return;
lbl23: // 2 sources:
        if (!"ViewPoint".equals(var1_1.getPropertyName())) ** GOTO lbl41
        var2_3 = this.xc;
        if (this.vc == null) ** GOTO lbl-1000
        var3_4 = this.tc.getVisibleRect();
        var4_5 = var3_4.createUnion(this.vc);
        var5_7 = this.getViewPoint();
        var6_13 = this.getZoom();
        var8_9 = (int)Math.floor((var4_5.getX() - var5_7.getX()) * var6_13);
        var9_10 = (int)Math.floor((var4_5.getY() - var5_7.getY()) * var6_13);
        var10_11 = (int)Math.ceil(var4_5.getWidth() * var6_13);
        var11_12 = (int)Math.ceil(var4_5.getHeight() * var6_13);
        this.c(var8_9 - 1, var9_10 - 1, var10_11 + 4, var11_12 + 4);
        this.vc = var3_4;
        if (var12_2) lbl-1000: // 2 sources:
        {
            this.updateView();
            this.vc = this.tc.getVisibleRect();
        }
        this.xc = var2_3;
        if (var12_2 == false) return;
lbl41: // 2 sources:
        this.updateView();
    }

    void b(double d2, double d3, double d4) {
        if (d4 < 1.0 && Boolean.TRUE.equals(this.getClientProperty("Overview.AnimateScrollTo"))) {
            this.uc.a(d2, d3, d4);
            if (!fj.z) return;
        }
        this.tc.setCenter(d2, d3);
        this.tc.updateView();
    }

    static float[] access$100(double d2, int n2) {
        return fD.b(d2, n2);
    }

    static boolean access$200() {
        return yc;
    }

    static {
        try {
            String string = System.getProperty("os.name").toLowerCase();
            yc = string.startsWith("mac");
            return;
        }
        catch (SecurityException var0_1) {
            yc = false;
        }
    }
}

