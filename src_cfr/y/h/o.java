/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.h.C;
import y.h.R;
import y.h.S;
import y.h.T;
import y.h.a.v;
import y.h.aB;
import y.h.bu;
import y.h.cg;
import y.h.fj;
import y.h.ft;
import y.h.hC;

public class O
implements ft {
    private final R d;
    private final R e;
    private int g = 10;
    private C f;

    public O() {
        this.d = new R(this);
        this.e = new R(this);
    }

    @Override
    public cg getPaintOrder() {
        return this.d;
    }

    @Override
    public cg getSloppyPaintOrder() {
        return this.e;
    }

    public boolean isLayeredPainting() {
        return this.d.a();
    }

    public void setLayeredPainting(boolean bl2) {
        this.d.a(bl2);
        this.e.a(bl2);
    }

    public void setNestedEdgeDrawingOrderEnabled(boolean bl2) {
        this.d.c(bl2);
    }

    public boolean isNestedEdgeDrawingOrderEnabled() {
        return this.d.c();
    }

    public C getBridgeCalculator() {
        return this.f;
    }

    public void setBridgeCalculator(C c2) {
        this.f = c2;
    }

    public void setDrawEdgesFirst(boolean bl2) {
        this.d.d(bl2);
        this.e.d(bl2);
    }

    public boolean getDrawEdgesFirst() {
        return this.d.d();
    }

    public void setDrawSelectionOnTop(boolean bl2) {
        this.d.e(bl2);
        this.e.e(bl2);
    }

    public boolean isDrawSelectionOnTop() {
        return this.d.e();
    }

    public void setClipEnlargementValue(int n2) {
        this.g = n2;
    }

    public int getClipEnlargementValue() {
        return this.g;
    }

    public void setHierarchicSloppyPaintOrderEnabled(boolean bl2) {
        this.e.b(bl2);
    }

    public boolean isHierarchicSloppyPaintOrderEnabled() {
        return this.e.b();
    }

    @Override
    public void paint(Graphics2D graphics2D, bu bu2) {
        Object object = null;
        Rectangle rectangle = graphics2D.getClipBounds();
        if (rectangle == null) {
            rectangle = bu2.a();
        }
        rectangle.x -= this.g;
        rectangle.y -= this.g;
        rectangle.width += 2 * this.g;
        rectangle.height += 2 * this.g;
        C c2 = this.f;
        if (c2 != null) {
            this.prepareBridgeCalculator(c2, bu2, rectangle);
            object = graphics2D.getRenderingHint(S.a);
            graphics2D.setRenderingHint(S.a, S.a(bu2, c2));
        }
        this.b(bu2, graphics2D, rectangle, false);
        if (c2 == null) return;
        graphics2D.setRenderingHint(S.a, object);
    }

    /*
     * Unable to fully structure code
     */
    private void b(bu var1_1, Graphics2D var2_2, Rectangle var3_3, boolean var4_4) {
        block18 : {
            var12_5 = fj.z;
            if (this.isLayeredPainting()) ** GOTO lbl28
            if (!var4_4) ** GOTO lbl16
            var6_6 = this.e.a(var1_1, 3);
            do lbl-1000: // 5 sources:
            {
                if (var6_6.hasNext() == false) return;
                var7_9 = var6_6.next();
                if (!(var7_9 instanceof d)) ** GOTO lbl13
                var8_15 = var1_1.i((d)var7_9);
                if (!this.intersects((aB)var8_15, (Rectangle2D)var3_3)) ** GOTO lbl-1000
                this.paintSloppy(var2_2, (aB)var8_15);
                if (!var12_5) ** GOTO lbl-1000
lbl13: // 2 sources:
                if (!(var7_9 instanceof q) || !this.intersects((fj)(var8_15 = var1_1.t((q)var7_9)), (Rectangle2D)var3_3)) ** GOTO lbl-1000
                this.paintSloppy(var2_2, (fj)var8_15);
            } while (!var12_5);
lbl16: // 2 sources:
            var6_6 = this.d.a(var1_1, 3);
            do lbl-1000: // 5 sources:
            {
                if (var6_6.hasNext() == false) return;
                var7_11 = var6_6.next();
                if (!(var7_11 instanceof d)) ** GOTO lbl25
                var8_15 = var1_1.i((d)var7_11);
                if (!this.intersects((aB)var8_15, (Rectangle2D)var3_3)) ** GOTO lbl-1000
                this.paint(var2_2, (aB)var8_15);
                if (!var12_5) ** GOTO lbl-1000
lbl25: // 2 sources:
                if (!(var7_11 instanceof q) || !this.intersects((fj)(var8_15 = var1_1.t((q)var7_11)), (Rectangle2D)var3_3)) ** GOTO lbl-1000
                this.paint(var2_2, (fj)var8_15);
            } while (!var12_5);
lbl28: // 2 sources:
            if (var4_4) {
                block17 : {
                    var6_7 = -1;
                    var7_12 = this.e.a(var1_1, 3);
                    while (var7_12.hasNext()) {
                        var8_15 = var7_12.next();
                        if (var8_15 instanceof d) {
                            var9_17 = (d)var8_15;
                            var10_22 = var1_1.i(var9_17);
                            if (!this.intersects((aB)var10_22, (Rectangle2D)var3_3)) continue;
                            var11_23 = this.getLayer(var1_1, var9_17);
                            if (var11_23 != var6_7) {
                                if (var6_7 > -1) {
                                    this.endLayerPainting(var2_2, var6_7, var4_4);
                                }
                                this.beginLayerPainting(var2_2, var11_23, var4_4);
                            }
                            this.paintSloppyLayered(var2_2, var11_23, (aB)var10_22);
                            var6_7 = var11_23;
                            if (!var12_5) continue;
                        }
                        if (!(var8_15 instanceof q)) continue;
                        var9_18 = (q)var8_15;
                        var10_22 = var1_1.t(var9_18);
                        v0 = (int)this.intersects((fj)var10_22, (Rectangle2D)var3_3) ? 1 : 0;
                        if (!var12_5) {
                            if (v0 == 0) continue;
                            var11_23 = this.getLayer(var1_1, var9_18);
                            if (var11_23 != var6_7) {
                                if (var6_7 > -1) {
                                    this.endLayerPainting(var2_2, var6_7, var4_4);
                                }
                                this.beginLayerPainting(var2_2, var11_23, var4_4);
                            }
                            this.paintSloppyLayered(var2_2, var11_23, (fj)var10_22);
                            var6_7 = var11_23;
                            if (!var12_5) continue;
                        }
                        break block17;
                    }
                    v0 = var6_7;
                }
                if (v0 <= -1) return;
                this.endLayerPainting(var2_2, var6_7, var4_4);
                if (var12_5 == false) return;
            }
            var6_8 = -1;
            var7_14 = this.d.a(var1_1, 3);
            while (var7_14.hasNext()) {
                var8_15 = var7_14.next();
                if (var8_15 instanceof d) {
                    var9_20 = (d)var8_15;
                    var10_22 = var1_1.i(var9_20);
                    if (!this.intersects((aB)var10_22, (Rectangle2D)var3_3)) continue;
                    var11_23 = this.getLayer(var1_1, var9_20);
                    if (var11_23 != var6_8) {
                        if (var6_8 > -1) {
                            this.endLayerPainting(var2_2, var6_8, var4_4);
                        }
                        this.beginLayerPainting(var2_2, var11_23, var4_4);
                    }
                    this.paintLayered(var2_2, var11_23, (aB)var10_22);
                    var6_8 = var11_23;
                    if (!var12_5) continue;
                }
                if (!(var8_15 instanceof q)) continue;
                var9_21 = (q)var8_15;
                var10_22 = var1_1.t(var9_21);
                v1 = (int)this.intersects((fj)var10_22, (Rectangle2D)var3_3) ? 1 : 0;
                if (!var12_5) {
                    if (v1 == 0) continue;
                    var11_23 = this.getLayer(var1_1, var9_21);
                    if (var11_23 != var6_8) {
                        if (var6_8 > -1) {
                            this.endLayerPainting(var2_2, var6_8, var4_4);
                        }
                        this.beginLayerPainting(var2_2, var11_23, var4_4);
                    }
                    this.paintLayered(var2_2, var11_23, (fj)var10_22);
                    var6_8 = var11_23;
                    if (!var12_5) continue;
                }
                break block18;
            }
            v1 = var6_8;
        }
        if (v1 <= -1) return;
        this.endLayerPainting(var2_2, var6_8, var4_4);
    }

    protected void beginLayerPainting(Graphics2D graphics2D, int n2, boolean bl2) {
    }

    protected void endLayerPainting(Graphics2D graphics2D, int n2, boolean bl2) {
    }

    protected void paintLayered(Graphics2D graphics2D, int n2, fj fj2) {
        this.paint(graphics2D, fj2);
    }

    protected void paintLayered(Graphics2D graphics2D, int n2, aB aB2) {
        this.paint(graphics2D, aB2);
    }

    protected void paintSloppyLayered(Graphics2D graphics2D, int n2, fj fj2) {
        this.paintSloppy(graphics2D, fj2);
    }

    protected void paintSloppyLayered(Graphics2D graphics2D, int n2, aB aB2) {
        this.paintSloppy(graphics2D, aB2);
    }

    protected int getLayer(bu bu2, d d2) {
        return Math.max(this.getLayer(bu2, d2.c()), this.getLayer(bu2, d2.d()));
    }

    protected int getLayer(bu bu2, q q2) {
        boolean bl2 = fj.z;
        v v2 = bu2.C();
        int n2 = 0;
        if (v2 == null) return n2;
        do {
            if (q2 == null) return n2;
            q q3 = v2.n(q2);
            if (q3 != null && q3.e() != q2.e()) {
                return n2;
            }
            q2 = q3;
            ++n2;
        } while (!bl2);
        return n2;
    }

    protected void prepareBridgeCalculator(C c2, bu bu2, Rectangle2D rectangle2D) {
        boolean bl2 = fj.z;
        c2.a();
        c2.a(rectangle2D.getMinX() - (double)this.g, rectangle2D.getMinY() - (double)this.g, rectangle2D.getMaxX() + (double)this.g, rectangle2D.getMaxY() + (double)this.g);
        if (c2.b() == 0) return;
        e e2 = bu2.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            aB aB2 = bu2.i(d2);
            if (this.intersects(aB2, rectangle2D)) {
                aB2.registerObstacles(c2);
            }
            e2.g();
        } while (!bl2);
    }

    public static C getBridgeCalculator(aB aB2, Graphics2D graphics2D) {
        if (aB2 == null) return null;
        if (aB2.getEdge() == null) return null;
        T t2 = (T)graphics2D.getRenderingHint(S.a);
        if (t2 == null) return null;
        if (t2.a() != aB2.getEdge().a()) return null;
        return t2.b();
    }

    public void setSloppyNestedEdgeDrawingOrderEnabled(boolean bl2) {
        this.e.c(bl2);
    }

    public boolean isSloppyNestedEdgeDrawingOrderEnabled() {
        return this.e.c();
    }

    protected boolean intersects(fj fj2, Rectangle2D rectangle2D) {
        Rectangle2D.Double double_ = hC.a().j;
        double_.height = -1.0;
        double_.width = -1.0;
        fj2.calcUnionRect(double_);
        return double_.intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    protected boolean intersects(aB aB2, Rectangle2D rectangle2D) {
        return aB2.intersects(rectangle2D);
    }

    @Override
    public void paintSloppy(Graphics2D graphics2D, bu bu2) {
        Rectangle rectangle = graphics2D.getClipBounds();
        if (rectangle == null) {
            rectangle = bu2.a();
        }
        rectangle.x -= this.g;
        rectangle.y -= this.g;
        rectangle.width += 2 * this.g;
        rectangle.height += 2 * this.g;
        this.b(bu2, graphics2D, rectangle, true);
    }

    protected void paint(Graphics2D graphics2D, fj fj2) {
        fj2.paint(graphics2D);
    }

    protected void paint(Graphics2D graphics2D, aB aB2) {
        aB2.paint(graphics2D);
    }

    protected void paintSloppy(Graphics2D graphics2D, fj fj2) {
        fj2.paintSloppy(graphics2D);
    }

    protected void paintSloppy(Graphics2D graphics2D, aB aB2) {
        aB2.paintSloppy(graphics2D);
    }
}

