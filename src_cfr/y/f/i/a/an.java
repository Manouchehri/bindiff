/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Comparator;
import java.util.HashMap;
import y.a.u;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.h;
import y.c.i;
import y.c.q;
import y.d.e;
import y.d.f;
import y.d.m;
import y.d.s;
import y.d.v;
import y.f.X;
import y.f.i.a.Z;
import y.f.i.a.aO;
import y.f.i.a.aP;
import y.f.i.a.aQ;
import y.f.i.a.aR;
import y.f.i.a.aS;
import y.f.i.a.aT;
import y.f.i.a.ab;
import y.f.i.a.ac;
import y.f.i.a.w;
import y.f.i.a.x;
import y.f.i.a.y;
import y.g.M;

class aN {
    private static final double a = Math.sqrt(2.0);
    private static final Object b = "y.layout.router.polyline.Polyliner.MIN_EDGE_LENGTH_DPKEY";
    private static final Object c = "y.layout.router.polyline.Polyliner.EDGE_WEIGHT_DPKEY";
    private double d;
    private double e;
    private Z f;

    aN() {
    }

    public void a(double d2) {
        this.d = d2;
    }

    public void b(double d2) {
        this.e = d2;
    }

    /*
     * Unable to fully structure code
     */
    public void a(y.c.f var1_1, ac var2_2, Z var3_3) {
        var15_4 = ab.a;
        this.f = var3_3;
        var4_5 = var3_3.a();
        var5_6 = M.b();
        var6_7 = new D();
        var7_8 = new D();
        var8_9 = var1_1.a();
        block0 : do {
            v0 = var8_9.f();
            block1 : while (v0) {
                var9_10 = var8_9.a();
                v1 = var10_11 = var2_2.a(var9_10);
                if (var15_4 != 0) ** GOTO lbl61
                if (v1 != null) {
                    var11_12 = new aR(this, (w)var10_11);
                    var5_6.a((Object)var9_10, var11_12);
                    var12_13 = var11_12.a();
                    for (var13_14 = 0; var13_14 < var12_13.length; ++var13_14) {
                        v0 = var12_13[var13_14].k();
                        if (var15_4 != 0) continue block1;
                        if (v0) {
                            var6_7.add(var12_13[var13_14]);
                            if (var15_4 == 0) continue;
                        }
                        var7_8.add(var12_13[var13_14]);
                        if (var15_4 == 0) continue;
                    }
                }
                var8_9.g();
                if (var15_4 == 0) continue block0;
            }
            break block0;
            break;
        } while (true);
        var8_9 = var4_5.p();
        block3 : do {
            v2 = var8_9.f();
            block4 : while (v2) {
                var9_10 = var8_9.a();
                v1 = var5_6.b(var9_10);
                if (var15_4 != 0) ** GOTO lbl61
                if (v1 != null || !y.b(var9_10, var4_5)) ** GOTO lbl53
                var10_11 = var4_5.l(var9_10);
                var11_12 = null;
                var12_13 = var10_11.j();
                while (var12_13.f()) {
                    var13_16 = var12_13.a();
                    v2 = var13_16.b();
                    if (var15_4 != 0) continue block4;
                    if (!v2 && !var13_16.a()) ** GOTO lbl51
                    if (var11_12 == null || var11_12.a() == var13_16.a()) ** GOTO lbl50
                    var14_17 = new aQ(this, (m)var11_12, var13_16, var9_10);
                    if (!var14_17.k()) ** GOTO lbl-1000
                    var6_7.add(var14_17);
                    if (var15_4 != 0) lbl-1000: // 2 sources:
                    {
                        var7_8.add(var14_17);
                    }
lbl50: // 4 sources:
                    var11_12 = var13_16;
lbl51: // 2 sources:
                    var12_13.g();
                    if (var15_4 == 0) continue;
                }
lbl53: // 3 sources:
                var8_9.g();
                if (var15_4 == 0) continue block3;
            }
            break block3;
            break;
        } while (true);
        this.a(var4_5, var6_7, -45);
        this.a(var4_5, var7_8, 45);
        var8_9 = var1_1.a();
        while (var8_9.f()) {
            var9_10 = var8_9.a();
            v1 = var5_6.b(var9_10);
lbl61: // 3 sources:
            var10_11 = (aR)v1;
            if (var15_4 != 0) return;
            if (var10_11 != null) {
                var4_5.b(var9_10, var10_11.b());
            }
            var8_9.g();
            if (var15_4 == 0) continue;
        }
        this.f = null;
    }

    private void a(X x2, D d2, int n2) {
        int n3 = ab.a;
        if (d2 == null) return;
        if (d2.isEmpty()) {
            return;
        }
        Rectangle rectangle = x2.a();
        AffineTransform affineTransform = new AffineTransform();
        double d3 = rectangle.x + rectangle.width / 2;
        double d4 = rectangle.y + rectangle.height / 2;
        affineTransform.translate(d3, d4);
        affineTransform.rotate(e.a(n2));
        affineTransform.translate(- d3, - d4);
        i i2 = this.a(d2, affineTransform);
        A a2 = M.a();
        h h2 = (h)i2.c(b);
        h h3 = (h)i2.c(c);
        u.a(i2, a2, h3, h2);
        C c2 = d2.m();
        do {
            if (!c2.f()) return;
            aT aT2 = (aT)c2.d();
            if (!aT2.a()) {
                q q2 = aT2.f;
                q q3 = aT2.e;
                int n4 = Math.abs(a2.a(q2) - a2.a(q3));
                double d5 = (double)n4 * a;
                aT2.a(d5);
            }
            c2.g();
        } while (n3 == 0);
    }

    /*
     * Unable to fully structure code
     */
    private i a(D var1_1, AffineTransform var2_2) {
        var30_3 = ab.a;
        var3_4 = new i();
        var4_5 = M.b();
        var3_4.a(aN.b, var4_5);
        var5_6 = M.b();
        var3_4.a(aN.c, var5_6);
        var6_7 = new y.c.y();
        var7_8 = M.a();
        var8_9 = new HashMap<Integer, q>();
        var9_10 = new Point2D.Double();
        var10_11 = M.a();
        var11_12 = var1_1.m();
        while (var11_12.f()) {
            block10 : {
                block9 : {
                    var12_13 = (aT)var11_12.d();
                    var13_14 = var12_13.b();
                    var15_15 = var12_13.c();
                    var9_10.setLocation(var13_14, var15_15);
                    var2_2.transform(var9_10, var9_10);
                    if (var30_3 != 0) return var3_4;
                    if (var12_13.i() == 1 || var12_13.i() == 3) {
                        var17_16 = new Integer((int)Math.floor(var9_10.getX()));
                        if (var30_3 == 0) break block9;
                    }
                    var17_16 = new Integer((int)Math.ceil(var9_10.getX()));
                }
                if (!var12_13.a()) {
                    var18_18 = (q)var8_9.get(var17_16);
                    if (var18_18 == null) {
                        var18_18 = var3_4.d();
                        var8_9.put(var17_16, var18_18);
                        var7_8.a((Object)var18_18, var17_16);
                        var6_7.add(var18_18);
                    }
                    var12_13.e = var18_18;
                }
                var18_17 = var12_13.d();
                var20_19 = var12_13.e();
                var9_10.setLocation((var13_14 + var18_17) / 2.0, (var15_15 + var20_19) / 2.0);
                var2_2.transform(var9_10, var9_10);
                if (var12_13.i() == 1 || var12_13.i() == 3) {
                    var22_20 = new Integer((int)Math.ceil(var9_10.getX()));
                    if (var30_3 == 0) break block10;
                }
                var22_20 = new Integer((int)Math.floor(var9_10.getX()));
            }
            if ((var23_21 = (q)var8_9.get(var22_20)) == null) {
                var23_21 = var3_4.d();
                var8_9.put(var22_20, var23_21);
                var7_8.a((Object)var23_21, var22_20);
                var6_7.add(var23_21);
            }
            var24_22 = var3_4.d();
            var10_11.a((Object)var24_22, var22_20);
            var12_13.f = var24_22;
            if (!var12_13.a()) ** GOTO lbl54
            var25_24 = var3_4.a(var23_21, var24_22);
            var5_6.a((Object)var25_24, 100000);
            if (var30_3 == 0) ** GOTO lbl74
lbl54: // 2 sources:
            if (var17_16 - var22_20 != 0) ** GOTO lbl58
            var25_25 = var3_4.a(var12_13.e, var24_22);
            var5_6.a((Object)var25_25, 100000);
            if (var30_3 == 0) ** GOTO lbl74
lbl58: // 2 sources:
            var25_26 = var3_4.d();
            var28_29 = var17_16 - var22_20;
            if (var28_29 <= 0) ** GOTO lbl-1000
            var3_4.a(var24_22, var12_13.e);
            var3_4.a(var23_21, var25_26);
            var26_27 = var3_4.a(var25_26, var24_22);
            var27_28 = var3_4.a(var25_26, var12_13.e);
            if (var30_3 != 0) lbl-1000: // 2 sources:
            {
                var3_4.a(var12_13.e, var24_22);
                var3_4.a(var25_26, var23_21);
                var26_27 = var3_4.a(var24_22, var25_26);
                var27_28 = var3_4.a(var12_13.e, var25_26);
            }
            var5_6.a((Object)var26_27, 1);
            var29_30 = Math.min((int)Math.ceil(this.e / 2.0), Math.abs(var28_29));
            var4_5.a((Object)var27_28, var29_30);
            var5_6.a((Object)var27_28, 1);
lbl74: // 3 sources:
            var11_12.g();
            if (var30_3 == 0) continue;
        }
        this.a(var3_4, var6_7, var7_8);
        this.a(var1_1, var3_4, var4_5, var5_6, var10_11);
        return var3_4;
    }

    private void a(i i2, y.c.y y2, A a2) {
        int n2 = ab.a;
        y2.sort(new aO(this, a2));
        h h2 = (h)i2.c(b);
        h h3 = (h)i2.c(c);
        q q2 = null;
        y.c.x x2 = y2.a();
        do {
            if (!x2.f()) return;
            q q3 = x2.e();
            if (q2 != null) {
                d d2 = i2.a(q2, q3);
                h3.a((Object)d2, 100000);
                int n3 = a2.a(q3);
                int n4 = a2.a(q2);
                int n5 = n3 - n4;
                h2.a((Object)d2, n5);
            }
            q2 = q3;
            x2.g();
        } while (n2 == 0);
    }

    private void a(D d2, i i2, h h2, h h3, c c2) {
        f.a(d2, new aP(this, i2, h2, h3, c2));
    }

    private double a(aT aT2, aT aT3) {
        x x2 = this.f.c().a(aT2.j());
        x x3 = this.f.c().a(aT3.j());
        return Math.max(x2.c(), x3.c());
    }

    static double a(aN aN2, aT aT2, aT aT3) {
        return aN2.a(aT2, aT3);
    }

    static double a(aN aN2) {
        return aN2.d;
    }
}

