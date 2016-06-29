/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.p;
import y.c.q;
import y.d.t;
import y.f.I;
import y.f.X;
import y.f.aE;
import y.f.aF;
import y.f.c.a;
import y.f.c.an;
import y.f.c.x;
import y.f.c.y;
import y.f.c.z;

class am {
    private X a;
    private f b;
    private Map c;
    private x d;
    private double e;
    private Comparator f;
    private static final double[] g = new double[]{0.0, 1.0, 0.0, -1.0};
    private static final double[] h = new double[]{-1.0, 0.0, 1.0, 0.0};
    private double i;

    public am(X x2, x x3) {
        boolean bl2 = a.i;
        this.e = 20.0;
        this.f = new an(this);
        this.d = x3;
        this.a = x2;
        this.b = new f();
        this.c = new HashMap();
        e e2 = x2.p();
        do {
            if (!e2.f()) return;
            if (e2.a().e()) {
                this.b.c(e2.a());
            }
            e2.g();
        } while (!bl2);
    }

    public void a(double d2) {
        this.e = d2;
    }

    public void a() {
        boolean bl2 = a.i;
        p p2 = this.b.k();
        do {
            if (p2 == null) return;
            this.a.d((d)p2.c());
            p2 = p2.a();
        } while (!bl2);
    }

    public void b() {
        boolean bl2 = a.i;
        p p2 = this.b.k();
        do {
            if (p2 == null) return;
            this.a.e((d)p2.c());
            this.a.b(p2.c()).clearPoints();
            p2 = p2.a();
        } while (!bl2);
    }

    public void c() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public y a(q q2) {
        y y2 = (y)this.c.get(q2);
        if (y2 != null) return y2;
        y2 = new y(this.a.a(q2));
        this.c.put(q2, y2);
        return y2;
    }

    public boolean b(q q2) {
        return this.c.containsKey(q2);
    }

    public void d() {
        boolean bl2 = a.i;
        p p2 = this.b.k();
        do {
            if (p2 == null) return;
            d d2 = (d)p2.c();
            y y2 = this.a(d2.c());
            y2.b.add(d2);
            aE aE2 = this.a(d2);
            aE aE3 = this.b(d2);
            boolean bl3 = !aE2.a();
            boolean bl4 = !aE3.a();
            int n2 = x.a(aE2.b(), 2);
            int n3 = x.a(aE3.b(), 0);
            int n4 = 4 + n3 - n2 & 3;
            if (bl3 || bl4) {
                if (bl3) {
                    switch (n4) {
                        case 0: {
                            y2.c((int)n2).l.add(d2);
                            if (!bl2) break;
                        }
                        case 3: {
                            y2.a((int)n2).l.add(d2);
                            if (!bl2) break;
                        }
                        case 1: 
                        case 2: {
                            y2.b((int)n2).l.add(d2);
                        }
                    }
                }
                if (bl4) {
                    switch (n4) {
                        case 0: {
                            y2.c((int)n3).l.add(d2);
                            if (!bl2) break;
                        }
                        case 1: 
                        case 2: {
                            y2.a((int)n3).l.add(d2);
                            if (!bl2) break;
                        }
                        case 3: {
                            y2.b((int)n3).l.add(d2);
                        }
                    }
                }
            }
            y2.b.sort(this.f);
            p2 = p2.a();
        } while (!bl2);
    }

    public void c(q q2) {
        boolean bl2 = a.i;
        y y2 = this.a(q2);
        p p2 = y2.b.k();
        do {
            if (p2 == null) return;
            d d2 = (d)p2.c();
            aE aE2 = this.a(d2);
            aE aE3 = this.b(d2);
            int n2 = x.a(aE2.b(), 2);
            int n3 = x.a(aE3.b(), 0);
            int n4 = 4 + n3 - n2 & 3;
            switch (n4) {
                case 0: {
                    y2.c(n2).b();
                    if (!bl2) break;
                }
                case 1: {
                    y2.b(n2).b();
                    y2.a(n3).b();
                    if (!bl2) break;
                }
                case 2: {
                    y2.b(n2).b();
                    y2.g(n2 + 1 & 3);
                    y2.a(n3).b();
                    if (!bl2) break;
                }
                case 3: {
                    y2.a(n2).b();
                    y2.b(n3).b();
                }
            }
            p2 = p2.a();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    public void e() {
        var25_1 = a.i;
        var1_2 = this.a.o();
        do {
            v0 = var1_2.f();
            block17 : do {
                if (v0 == false) return;
                var2_3 = var1_2.e();
                if (!this.b(var2_3)) break;
                var3_4 = this.a(var2_3);
                var3_4.a(this.a.a(var2_3));
                var3_4.a();
                var4_5 = new D();
                var5_6 = var3_4.b.k();
                while (var5_6 != null) {
                    block26 : {
                        var6_7 = (d)var5_6.c();
                        var4_5.clear();
                        var7_8 = this.a(var6_7);
                        var8_9 = this.b(var6_7);
                        var9_10 = x.a(var7_8.b(), 2);
                        var10_11 = x.a(var8_9.b(), 0);
                        var11_12 = null;
                        var12_13 = null;
                        var13_14 = null;
                        var14_15 = null;
                        var15_16 = 4 + var10_11 - var9_10 & 3;
                        v0 = var7_8.a();
                        if (var25_1) continue block17;
                        if (v0) ** GOTO lbl43
                        switch (var15_16) {
                            case 1: 
                            case 2: {
                                var16_17 = var3_4.b(var9_10);
                                var11_12 = var16_17.c(var16_17.a(), 0.0);
                                break;
                            }
                            case 0: {
                                var16_17 = var3_4.c(var9_10);
                                var11_12 = var16_17.c(var16_17.a(), 0.0);
                                break;
                            }
                            case 3: {
                                var16_17 = var3_4.a(var9_10);
                                var11_12 = var16_17.c(var16_17.a(), 0.0);
                            }
                        }
                        this.a.c(var6_7, var11_12);
                        ** GOTO lbl48
lbl43: // 1 sources:
                        var11_12 = this.a.p(var6_7);
                        if ((var9_10 & 1) != 1) ** GOTO lbl-1000
                        var11_12 = new t(var3_4.c((int)var9_10).d, var11_12.b);
                        if (var25_1) lbl-1000: // 2 sources:
                        {
                            var11_12 = new t(var11_12.a, var3_4.c((int)var9_10).c);
                        }
lbl48: // 4 sources:
                        if (var8_9.a()) ** GOTO lbl63
                        switch (var15_16) {
                            case 0: {
                                var16_17 = var3_4.c(var10_11);
                                var12_13 = var16_17.c(var16_17.a(), 0.0);
                                break;
                            }
                            case 1: 
                            case 2: {
                                var16_17 = var3_4.a(var10_11);
                                var12_13 = var16_17.c(var16_17.a(), 0.0);
                                break;
                            }
                            case 3: {
                                var16_17 = var3_4.b(var10_11);
                                var12_13 = var16_17.c(var16_17.a(), 0.0);
                            }
                        }
                        this.a.d(var6_7, var12_13);
                        ** GOTO lbl68
lbl63: // 1 sources:
                        var12_13 = this.a.q(var6_7);
                        if ((var10_11 & 1) != 1) ** GOTO lbl-1000
                        var12_13 = new t(var3_4.c((int)var10_11).d, var12_13.b);
                        if (var25_1) lbl-1000: // 2 sources:
                        {
                            var12_13 = new t(var12_13.a, var3_4.c((int)var10_11).c);
                        }
lbl68: // 4 sources:
                        switch (var15_16) {
                            case 0: {
                                var16_17 = var3_4.c(var9_10);
                                var17_20 = var16_17.b();
                                var16_17.b(var17_20);
                                var13_14 = new t(var11_12.a + am.g[var9_10] * var17_20, var11_12.b + am.h[var9_10] * var17_20);
                                var14_15 = new t(var12_13.a + am.g[var10_11] * var17_20, var12_13.b + am.h[var10_11] * var17_20);
                                break;
                            }
                            case 1: {
                                var16_17 = var3_4.b(var9_10);
                                var17_21 = var16_17.b();
                                var13_14 = new t(var11_12.a + am.g[var9_10] * var17_21, var11_12.b + am.h[var9_10] * var17_21);
                                var16_17 = var3_4.a(var10_11);
                                var17_21 = var16_17.b();
                                var14_15 = new t(var12_13.a + am.g[var10_11] * var17_21, var12_13.b + am.h[var10_11] * var17_21);
                                if ((var9_10 & 1) == 0) {
                                    var4_5.add(new t(var14_15.a, var13_14.b));
                                    if (!var25_1) break;
                                }
                                var4_5.add(new t(var13_14.a, var14_15.b));
                                break;
                            }
                            case 2: {
                                var16_18 = var9_10 + 1 & 3;
                                var17_19 = var3_4.b(var9_10);
                                var18_23 = var17_19.b();
                                var13_14 = new t(var11_12.a + am.g[var9_10] * var18_23, var11_12.b + am.h[var9_10] * var18_23);
                                var17_19 = var3_4.a(var10_11);
                                var18_23 = var17_19.b();
                                var14_15 = new t(var12_13.a + am.g[var10_11] * var18_23, var12_13.b + am.h[var10_11] * var18_23);
                                var20_25 = var3_4.a(var16_18);
                                var21_26 = var3_4.g(var16_18);
                                if ((var16_18 & 1) == 0) {
                                    var23_27 = var20_25.e(0.0, var21_26);
                                    var4_5.add(new t(var13_14.a, var23_27));
                                    var4_5.add(new t(var14_15.a, var23_27));
                                    if (!var25_1) break;
                                }
                                var23_27 = var20_25.f(0.0, var21_26);
                                var4_5.add(new t(var23_27, var13_14.b));
                                var4_5.add(new t(var23_27, var14_15.b));
                                break;
                            }
                            case 3: {
                                var16_17 = var3_4.a(var9_10);
                                var17_22 = var16_17.b();
                                var13_14 = new t(var11_12.a + am.g[var9_10] * var17_22, var11_12.b + am.h[var9_10] * var17_22);
                                var16_17 = var3_4.b(var10_11);
                                var17_22 = var16_17.b();
                                var14_15 = new t(var12_13.a + am.g[var10_11] * var17_22, var12_13.b + am.h[var10_11] * var17_22);
                                if ((var9_10 & 1) == 0) {
                                    var4_5.add(new t(var14_15.a, var13_14.b));
                                    if (!var25_1) break;
                                }
                                var4_5.add(new t(var13_14.a, var14_15.b));
                            }
                        }
                        var4_5.a(var13_14);
                        var4_5.b(var14_15);
                        var16_17 = this.a.b(var6_7);
                        for (var17_19 = var4_5.k(); var17_19 != null; var17_19 = var17_19.a()) {
                            var18_24 = (t)var17_19.c();
                            var16_17.addPoint(var18_24.a, var18_24.b);
                            if (!var25_1) {
                                if (!var25_1) continue;
                            }
                            break block26;
                        }
                        var5_6 = var5_6.a();
                    }
                    if (!var25_1) continue;
                }
                break block17;
                break;
            } while (true);
            var1_2.g();
        } while (!var25_1);
    }

    aE a(d d2) {
        c c2;
        c c3 = this.a.c(aF.a);
        aE aE2 = null;
        if (c3 != null && (aE2 = (aE)c3.b(d2)) != null) {
            if (!aE2.g()) return aE2;
        }
        if ((c2 = this.a.c(aF.b)) == null) {
            return aE.a(1);
        }
        aE aE3 = (aE)c2.b(d2);
        if (aE3 == null) return aE.a(1);
        if (aE3.g()) {
            return aE.a(1);
        }
        if (aE3.c()) {
            return aE.a(8);
        }
        if (aE3.f()) {
            return aE.a(1);
        }
        if (aE3.d()) {
            return aE.a(4);
        }
        if (!aE3.e()) return aE2;
        return aE.a(2);
    }

    aE b(d d2) {
        c c2;
        c c3 = this.a.c(aF.b);
        aE aE2 = null;
        if (c3 != null && (aE2 = (aE)c3.b(d2)) != null) {
            if (!aE2.g()) return aE2;
        }
        if ((c2 = this.a.c(aF.a)) == null) {
            return aE.a(8);
        }
        aE aE3 = (aE)c2.b(d2);
        if (aE3 == null) return aE.a(8);
        if (aE3.g()) {
            return aE.a(8);
        }
        if (aE3.c()) {
            return aE.a(8);
        }
        if (aE3.f()) {
            return aE.a(1);
        }
        if (aE3.d()) {
            return aE.a(4);
        }
        if (!aE3.e()) return aE2;
        return aE.a(2);
    }

    public void b(double d2) {
        this.i = d2;
    }
}

