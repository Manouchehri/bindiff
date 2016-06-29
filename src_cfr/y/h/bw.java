/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.HashMap;
import java.util.Map;
import y.h.bZ;
import y.h.bu;
import y.h.cV;
import y.h.ca;
import y.h.cb;
import y.h.cc;
import y.h.cd;
import y.h.ch;
import y.h.fj;
import y.h.hk;
import y.h.w;

public class bW
implements Printable {
    private ch e;
    private int f = 1;
    private int g = 1;
    private byte h = 1;
    private boolean i = false;
    private double j = 1.0;
    private byte k = 0;
    private RenderingHints l;
    private boolean m = true;
    cc a;
    ca b;
    byte c;
    Rectangle2D d;

    public bW(ch ch2) {
        this.e = ch2;
        this.a = new bZ();
        this.l = new RenderingHints(new HashMap());
        this.l.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        this.c = 0;
    }

    public void a(boolean bl2) {
        this.i = bl2;
    }

    public boolean a() {
        return this.i;
    }

    public void a(int n2) {
        this.f = n2;
    }

    public void b(int n2) {
        this.g = n2;
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.g;
    }

    public void a(byte by2) {
        this.h = by2;
    }

    public byte d() {
        return this.h;
    }

    public byte e() {
        return this.c;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public int print(Graphics var1_1, PageFormat var2_2, int var3_3) {
        var49_4 = fj.z;
        var4_5 = (Graphics2D)var1_1.create();
        var4_5.addRenderingHints(this.l);
        try {
            block22 : {
                var5_6 = var4_5.getTransform();
                var6_7 = var4_5.getClip();
                if (var6_7 == null) {
                    throw new IllegalArgumentException("Graphics.getClip() must be non-null!");
                }
                var7_8 = var2_2.getImageableX();
                var9_9 = var2_2.getImageableY();
                var11_10 = var2_2.getImageableWidth();
                var13_11 = var2_2.getImageableHeight();
                var15_12 = this.f();
                var16_13 = var15_12.getWidth();
                var18_14 = var15_12.getHeight();
                var20_15 = var15_12.getX();
                var22_16 = var15_12.getY();
                var24_17 = 0.0;
                var26_18 = 0.0;
                if (this.a != null) {
                    var28_19 = new cb();
                    var28_19.b = var4_5;
                    var28_19.c = var3_3;
                    var28_19.a = var2_2;
                    var28_19.g = this.g;
                    var28_19.f = this.f;
                    var28_19.d = var3_3 % this.g;
                    var28_19.e = var3_3 / this.g;
                    this.a.a(var28_19);
                    var24_17 = this.a.getBounds().getHeight();
                }
                if (this.b != null) {
                    var28_19 = new cb();
                    var28_19.b = var4_5;
                    var28_19.c = var3_3;
                    var28_19.a = var2_2;
                    var28_19.g = this.g;
                    var28_19.f = this.f;
                    var28_19.d = var3_3 % this.g;
                    var28_19.e = var3_3 / this.g;
                    this.b.a(var28_19);
                    var26_18 = this.b.getBounds().getHeight();
                }
                switch (this.k) {
                    case 1: {
                        var32_21 = var16_13 * this.j;
                        var34_22 = var18_14 * this.j;
                        var31_23 = (int)Math.ceil(var32_21 / var11_10 - 0.01);
                        var30_24 = (int)Math.ceil(var34_22 / var13_11 - 0.01);
                        var28_20 = this.j;
                        var32_21 = var11_10 * (double)var31_23;
                        if (this.e() != 1) ** GOTO lbl53
                        var34_22 = var13_11 * (double)var30_24 - var24_17 * (double)var30_24 - var26_18 * (double)var30_24;
                        if (!var49_4) ** GOTO lbl70
lbl53: // 2 sources:
                        var34_22 = var13_11 * (double)var30_24 - var24_17 - var26_18;
                        if (!var49_4) ** GOTO lbl70
                    }
                    case 0: {
                        block21 : {
                            var31_23 = this.g;
                            var30_24 = this.f;
                            var32_21 = var11_10 * (double)var31_23;
                            if (this.e() == 1) {
                                var34_22 = var13_11 * (double)var30_24 - var24_17 * (double)var30_24 - var26_18 * (double)var30_24;
                                if (!var49_4) break block21;
                            }
                            var34_22 = var13_11 * (double)var30_24 - var24_17 - var26_18;
                        }
                        if (var32_21 / var34_22 <= var16_13 / var18_14) ** GOTO lbl67
                        var28_20 = var34_22 / var18_14;
                        if (!var49_4) ** GOTO lbl70
lbl67: // 2 sources:
                        var28_20 = var32_21 / var16_13;
                        if (!var49_4) ** GOTO lbl70
                    }
                }
                throw new RuntimeException(new StringBuffer().append("Undefined ScalingType: ").append(this.k).toString());
lbl70: // 4 sources:
                if (var3_3 >= var30_24 * var31_23) {
                    var36_25 = 1;
                    return var36_25;
                }
                var36_26 = var3_3 % var31_23;
                var37_27 = var3_3 / var31_23;
                var38_28 = 0.0;
                var40_29 = 0.0;
                if (this.m) {
                    var38_28 = Math.max(0.0, (var32_21 - var16_13 * var28_20) / 2.0);
                    var40_29 = Math.max(0.0, (var34_22 - var18_14 * var28_20) / 2.0);
                }
                if (this.e() == 1) {
                    var42_30 = (int)Math.ceil(var7_8);
                    var43_32 = (int)Math.ceil(var9_9 + var24_17);
                    var44_34 = (int)Math.floor(var7_8 + var11_10);
                    var45_36 = (int)Math.floor(var9_9 + var13_11 - var26_18);
                    var4_5.clipRect(var42_30, var43_32, var44_34 - var42_30, var45_36 - var43_32);
                    var4_5.translate(var7_8 + var38_28 - var20_15 * var28_20 - var11_10 * (double)var36_26, var9_9 + var40_29 - var22_16 * var28_20 - var13_11 * (double)var37_27 + var24_17 * (double)(var37_27 + 1) + var26_18 * (double)var37_27);
                    if (!var49_4) break block22;
                }
                var4_5.translate(var7_8 + var38_28 - var20_15 * var28_20 - var11_10 * (double)var36_26, var9_9 + var40_29 - var22_16 * var28_20 - var13_11 * (double)var37_27 + var24_17);
            }
            var4_5.scale(var28_20, var28_20);
            var42_31 = new Rectangle(var15_12);
            var43_33 = var4_5.getClipBounds();
            var44_35 = var43_33.intersection(var42_31);
            var4_5.clip(var44_35);
            var45_37 = this.a(this.e, var4_5);
            if (var45_37 != null) {
                var4_5.setRenderingHint(hk.z, var45_37);
            }
            this.e.getBackgroundRenderer().paint(var4_5, var44_35.x, var44_35.y, var44_35.width, var44_35.height);
            this.e.k(var4_5);
            var46_38 = this.e.getGraph2DRenderer();
            var46_38.paint(var4_5, this.e.getGraph2D());
            this.e.j(var4_5);
            var4_5.setTransform(var5_6);
            var4_5.setClip(var6_7);
            var4_5.setColor(Color.black);
            if (this.a()) {
                var47_39 = new cb();
                var47_39.b = var4_5;
                var47_39.c = var3_3;
                var47_39.a = var2_2;
                var47_39.g = var31_23;
                var47_39.f = var30_24;
                var47_39.d = var3_3 % var31_23;
                var47_39.e = var3_3 / var31_23;
                this.a(var4_5, var47_39);
            }
            if (this.a != null) {
                this.a.a(var4_5);
            }
            if (this.b != null) {
                this.b.a(var4_5);
            }
            var47_40 = 0;
            return var47_40;
        }
        finally {
            var4_5.dispose();
        }
    }

    protected void a(Graphics2D graphics2D, cb cb2) {
        Color color = graphics2D.getColor();
        Font font = graphics2D.getFont();
        this.b(graphics2D, cb2);
        PageFormat pageFormat = cb2.c();
        int n2 = (int)pageFormat.getImageableX() + 15;
        int n3 = (int)pageFormat.getImageableY() + 15;
        int n4 = cb2.a() + 1;
        int n5 = cb2.b() + 1;
        TextLayout textLayout = new TextLayout(new StringBuffer().append("[").append(n4).append(',').append(n5).append("]").toString(), graphics2D.getFont(), graphics2D.getFontRenderContext());
        graphics2D.setColor(Color.white);
        Rectangle2D rectangle2D = textLayout.getBounds();
        rectangle2D.setRect(rectangle2D.getX() + (double)n2 - 2.0, rectangle2D.getY() + (double)n3 - 2.0, rectangle2D.getWidth() + 4.0, rectangle2D.getHeight() + 4.0);
        graphics2D.fill(rectangle2D);
        graphics2D.setColor(Color.black);
        textLayout.draw(graphics2D, n2, n3);
        graphics2D.setFont(font);
        graphics2D.setColor(color);
    }

    protected void b(Graphics2D graphics2D, cb cb2) {
        Font font = graphics2D.getFont();
        if (font.getSize() == 11) return;
        graphics2D.setFont(font.deriveFont(11.0f));
    }

    Rectangle f() {
        Rectangle rectangle = null;
        switch (this.d()) {
            case 0: {
                return this.e.getVisibleRect();
            }
            case 2: {
                if (this.d != null) return this.d.getBounds();
                throw new IllegalArgumentException("custom clip not set");
            }
        }
        rectangle = this.e.getGraph2D().a();
        rectangle.setFrame(rectangle.x - 2, rectangle.y - 2, rectangle.width + 4, rectangle.height + 4);
        return rectangle;
    }

    protected cV a(ch ch2, Graphics2D graphics2D) {
        if (graphics2D.getRenderingHint(hk.z) != null) return null;
        cV cV2 = new cV();
        cV2.a(true);
        cV2.a(ch2);
        Point2D point2D = ch2.getViewPoint2D();
        AffineTransform affineTransform = graphics2D.getTransform();
        affineTransform.translate(point2D.getX(), point2D.getY());
        double d2 = 1.0 / ch2.getZoom();
        affineTransform.scale(d2, d2);
        cV2.a(affineTransform);
        return cV2;
    }

    public void a(cc cc2) {
        this.a = cc2;
    }
}

