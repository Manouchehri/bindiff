/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.d.r;
import y.h.aZ;
import y.h.b.K;
import y.h.b.L;
import y.h.b.P;
import y.h.b.Q;
import y.h.b.R;
import y.h.b.Y;
import y.h.b.a;
import y.h.b.c;
import y.h.b.f;
import y.h.b.i;
import y.h.bo;
import y.h.dr;
import y.h.eR;
import y.h.fj;
import y.h.hk;

public class J
implements bo {
    public static final L a = new L(0, null);
    public static final L b = new L(1, null);
    public static final L c = new L(2, null);
    public static final L d = new L(3, null);
    public static final L e = new L(4, null);
    public static final L f = new L(5, null);
    private static final fj g = J.b();
    private final Map h = new HashMap();
    private int i;

    protected J() {
    }

    public static J a() {
        J j2 = new J();
        j2.h.put(b, new Q(false));
        j2.h.put(a, new Q(true));
        j2.h.put(d, new R(false, false));
        j2.h.put(c, new R(true, false));
        j2.h.put(f, new P(false, false));
        j2.h.put(e, new P(true, false));
        return j2;
    }

    public bo a(L l2) {
        return (bo)this.h.get(l2);
    }

    @Override
    public void a(fj fj2, Graphics2D graphics2D) {
        this.b(fj2, graphics2D, false);
    }

    protected void b(fj fj2, Graphics2D graphics2D) {
        if (!J.c(fj2, graphics2D)) return;
        fj2.paintHotSpots(graphics2D);
    }

    static boolean c(fj fj2, Graphics2D graphics2D) {
        if (!fj2.isSelected()) return false;
        if (!hk.b(graphics2D)) return false;
        return true;
    }

    static boolean a(Graphics2D graphics2D, boolean bl2) {
        Object object = graphics2D.getRenderingHint(hk.g);
        if (bl2) {
            return hk.i.equals(object);
        }
        if (hk.j.equals(object)) return false;
        return true;
    }

    static boolean b(Graphics2D graphics2D, boolean bl2) {
        Object object = graphics2D.getRenderingHint(hk.k);
        if (bl2) {
            return hk.m.equals(object);
        }
        if (hk.n.equals(object)) return false;
        return true;
    }

    protected void d(fj fj2, Graphics2D graphics2D) {
        fj2.paintPorts(graphics2D);
    }

    protected void f(fj fj2, Graphics2D graphics2D) {
        if (fj2.labelCount() <= 0) return;
        fj2.paintText(graphics2D);
    }

    @Override
    public void e(fj fj2, Graphics2D graphics2D) {
        this.b(fj2, graphics2D, true);
    }

    protected void a(fj fj2, Graphics2D graphics2D, boolean bl2) {
        if (!(fj2 instanceof a)) return;
        Graphics2D graphics2D2 = (Graphics2D)graphics2D.create();
        K k2 = new K(this, g);
        a a2 = (a)fj2;
        this.a((aZ)a2, k2);
        k2.setSelected(J.c(fj2, graphics2D));
        k2.a("y.view.tabular.TableNodePainter.BOUNDS", new Rectangle2D.Double());
        k2.a("y.view.tabular.TableNodePainter.CONTEXT", a2);
        k2.a("y.view.tabular.TableNodePainter.TABLE", a2.l());
        this.a((aZ)k2, graphics2D2, bl2, false);
        this.a((aZ)k2, graphics2D2, bl2, true);
        graphics2D2.dispose();
    }

    private void b(fj fj2, Graphics2D graphics2D, boolean bl2) {
        if (!bl2) {
            this.b(fj2, graphics2D);
        }
        this.a(fj2, graphics2D, bl2);
        if (J.b(graphics2D, bl2)) {
            this.d(fj2, graphics2D);
        }
        if (!J.a(graphics2D, bl2)) return;
        this.f(fj2, graphics2D);
    }

    /*
     * Unable to fully structure code
     */
    private void a(aZ var1_1, Graphics2D var2_2, boolean var3_3, boolean var4_4) {
        block5 : {
            var29_5 = a.H;
            var5_6 = J.a(var1_1);
            var6_7 = var5_6.l();
            var7_8 = var5_6.getX();
            var9_9 = var5_6.getY();
            var11_10 = var5_6.getWidth();
            var13_11 = var5_6.getHeight();
            var15_12 = this.a(var4_4 != false ? J.a : J.b);
            if (var15_12 == null) ** GOTO lbl15
            var1_1.setFrame(var7_8, var9_9, var11_10, var13_11);
            if (!var3_3) ** GOTO lbl-1000
            var15_12.e(var1_1, var2_2);
            if (var29_5 != 0) lbl-1000: // 2 sources:
            {
                var15_12.a(var1_1, var2_2);
            }
lbl15: // 4 sources:
            if ((var16_13 = this.a(var4_4 != false ? J.c : J.d)) != null) {
                var17_14 = var7_8 + var5_6.v();
                var19_16 = var9_9;
                var21_17 = var13_11;
                var23_18 = var6_7.d();
                var19_16 += var23_18.a;
                var21_17 -= var23_18.a + var23_18.c;
                for (Object var25_20 : var6_7.l()) {
                    var1_1.a("y.view.tabular.TableNodePainter.COLUMN", var25_20);
                    var26_21 = var25_20.g();
                    var1_1.setFrame(var17_14, var19_16, var26_21, var21_17);
                    this.a(var1_1, var2_2, var3_3, var16_13);
                    var17_14 += var26_21;
                    if (var29_5 == 0) {
                        if (var29_5 == 0) continue;
                    }
                    break block5;
                }
                var1_1.c("y.view.tabular.TableNodePainter.COLUMN");
            }
        }
        var17_15 = this.a(var4_4 != false ? J.e : J.f);
        if (var17_15 == null) return;
        var18_23 = var7_8;
        var20_24 = var9_9 + var5_6.t();
        var22_25 = var11_10;
        var24_19 = var6_7.d();
        var18_23 += var24_19.b;
        var22_25 -= var24_19.b + var24_19.d;
        for (f var26_22 : var6_7.o()) {
            var1_1.a("y.view.tabular.TableNodePainter.ROW", var26_22);
            var27_26 = var26_22.g();
            var1_1.setFrame(var18_23, var20_24, var22_25, var27_26);
            this.b(var1_1, var2_2, var3_3, var17_15);
            var20_24 += var27_26;
            if (var29_5 != 0) return;
            if (var29_5 == 0) continue;
        }
        var1_1.c("y.view.tabular.TableNodePainter.ROW");
    }

    /*
     * Unable to fully structure code
     */
    private void a(aZ var1_1, Graphics2D var2_2, boolean var3_3, bo var4_4) {
        block7 : {
            var22_5 = a.H;
            var5_6 = J.c(var1_1);
            var6_7 = var1_1.getX();
            var8_8 = var1_1.getY();
            var10_9 = var1_1.getHeight();
            var12_10 = this.a(var1_1, var5_6.i());
            if (this.b(1)) {
                var8_8 += var12_10.a;
                var10_9 -= var12_10.a;
            }
            if (this.b(4)) {
                var10_9 -= var12_10.c;
            }
            if (var3_3) {
                var4_4.e(var1_1, var2_2);
                if (var22_5 == 0) break block7;
            }
            var4_4.a(var1_1, var2_2);
        }
        var13_11 = var5_6.l();
        var14_12 = var13_11.iterator();
        do {
            if (var14_12.hasNext() == false) return;
            var15_13 = (c)var14_12.next();
            var1_1.a("y.view.tabular.TableNodePainter.COLUMN", var15_13);
            var16_14 = var15_13.g();
            var18_15 = 0.0;
            var20_16 = 0.0;
            if (var15_13.b() != 0) ** GOTO lbl32
            if (!this.a(2)) ** GOTO lbl-1000
            var16_14 += var12_10.b;
            var18_15 = var12_10.b;
            if (var22_5 != 0) lbl-1000: // 2 sources:
            {
                var6_7 += var12_10.b;
            }
lbl32: // 4 sources:
            if (var15_13.b() + 1 == var5_6.k() && this.a(8)) {
                var16_14 += var12_10.d;
                var20_16 = var12_10.d;
            }
            var1_1.setFrame(var6_7, var8_8, var16_14, var10_9);
            var1_1.a("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID", new r(var12_10.a, var18_15, var12_10.c, var20_16));
            this.a(var1_1, var2_2, var3_3, var4_4);
            var1_1.c("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID");
            var6_7 += var16_14;
        } while (var22_5 == 0);
    }

    /*
     * Unable to fully structure code
     */
    private void b(aZ var1_1, Graphics2D var2_2, boolean var3_3, bo var4_4) {
        block7 : {
            var22_5 = a.H;
            var5_6 = J.d(var1_1);
            var6_7 = var1_1.getX();
            var8_8 = var1_1.getY();
            var10_9 = var1_1.getWidth();
            var12_10 = this.b(var1_1, var5_6.i());
            if (this.b(32)) {
                var6_7 += var12_10.b;
                var10_9 -= var12_10.b;
            }
            if (this.b(128)) {
                var10_9 -= var12_10.d;
            }
            if (var3_3) {
                var4_4.e(var1_1, var2_2);
                if (var22_5 == 0) break block7;
            }
            var4_4.a(var1_1, var2_2);
        }
        var13_11 = var5_6.o();
        var14_12 = var13_11.iterator();
        do {
            if (var14_12.hasNext() == false) return;
            var15_13 = (f)var14_12.next();
            var1_1.a("y.view.tabular.TableNodePainter.ROW", var15_13);
            var16_14 = var15_13.g();
            var18_15 = 0.0;
            var20_16 = 0.0;
            if (var15_13.b() != 0) ** GOTO lbl32
            if (!this.a(16)) ** GOTO lbl-1000
            var16_14 += var12_10.a;
            var18_15 = var12_10.a;
            if (var22_5 != 0) lbl-1000: // 2 sources:
            {
                var8_8 += var12_10.a;
            }
lbl32: // 4 sources:
            if (var15_13.b() + 1 == var5_6.n() && this.a(64)) {
                var16_14 += var12_10.c;
                var20_16 = var12_10.c;
            }
            var1_1.setFrame(var6_7, var8_8, var10_9, var16_14);
            var1_1.a("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID", new r(var18_15, var12_10.b, var20_16, var12_10.d));
            this.b(var1_1, var2_2, var3_3, var4_4);
            var1_1.c("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID");
            var8_8 += var16_14;
        } while (var22_5 == 0);
    }

    private r a(aZ aZ2, r r2) {
        int[] arrn = new int[]{1, 2, 4, 8};
        return this.a(aZ2, r2, arrn);
    }

    private r b(aZ aZ2, r r2) {
        int[] arrn = new int[]{16, 32, 64, 128};
        return this.a(aZ2, r2, arrn);
    }

    private r a(aZ aZ2, r r2, int[] arrn) {
        Object object = aZ2.a("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID");
        if (!(object instanceof r)) return r2;
        double d2 = r2.a;
        if (this.a(arrn[0])) {
            d2 += ((r)object).a;
        }
        double d3 = r2.b;
        if (this.a(arrn[1])) {
            d3 += ((r)object).b;
        }
        double d4 = r2.c;
        if (this.a(arrn[2])) {
            d4 += ((r)object).c;
        }
        double d5 = r2.d;
        if (!this.a(arrn[3])) return new r(d2, d3, d4, d5);
        d5 += ((r)object).d;
        return new r(d2, d3, d4, d5);
    }

    private boolean a(int n2) {
        if ((this.i & n2) != n2) return false;
        return true;
    }

    private boolean b(int n2) {
        if (this.a(n2)) return false;
        return true;
    }

    private static fj b() {
        aZ aZ2 = new aZ();
        aZ2.setLocation(0.0, 0.0);
        aZ2.setFillColor(null);
        aZ2.setFillColor2(null);
        aZ2.setLineColor(null);
        while (aZ2.labelCount() > 0) {
            aZ2.removeLabel(aZ2.getLabel(0));
        }
        return aZ2;
    }

    private void a(aZ aZ2, aZ aZ3) {
        int n2 = a.H;
        aZ3.setFrame(aZ2.getX(), aZ2.getY(), aZ2.getWidth(), aZ2.getHeight());
        aZ3.setFillColor(aZ2.getFillColor());
        aZ3.setFillColor2(aZ2.getFillColor2());
        aZ3.setLineColor(aZ2.getLineColor());
        aZ3.setLineType(aZ2.getLineType());
        Iterator iterator = aZ2.e().iterator();
        do {
            if (!iterator.hasNext()) return;
            Map.Entry entry = (Map.Entry)iterator.next();
            aZ3.a((String)entry.getKey(), entry.getValue());
        } while (n2 == 0);
    }

    public static a a(fj fj2) {
        return (a)((aZ)fj2).a("y.view.tabular.TableNodePainter.CONTEXT");
    }

    public static i b(fj fj2) {
        return (i)((aZ)fj2).a("y.view.tabular.TableNodePainter.TABLE");
    }

    public static c c(fj fj2) {
        return (c)((aZ)fj2).a("y.view.tabular.TableNodePainter.COLUMN");
    }

    public static f d(fj fj2) {
        return (f)((aZ)fj2).a("y.view.tabular.TableNodePainter.ROW");
    }

    private static Rectangle2D f(fj fj2) {
        Rectangle2D rectangle2D = (Rectangle2D)((aZ)fj2).a("y.view.tabular.TableNodePainter.BOUNDS");
        rectangle2D.setFrame(fj2.getX(), fj2.getY(), fj2.getWidth(), fj2.getHeight());
        return rectangle2D;
    }

    private static Y b(fj fj2, String string) {
        return (Y)((aZ)fj2).a(string);
    }

    static Rectangle2D e(fj fj2) {
        return J.f(fj2);
    }

    static Y a(fj fj2, String string) {
        return J.b(fj2, string);
    }
}

