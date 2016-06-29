/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.c.C;
import y.c.D;
import y.c.p;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.ab;
import y.f.i.a.ah;
import y.f.i.a.ai;
import y.f.i.a.bF;
import y.f.i.a.bM;
import y.f.i.a.bO;
import y.f.i.a.w;
import y.f.y;

class bN {
    final List a;
    final int b;
    final HashSet c;
    final boolean d;
    private final bF e;

    bN(bF bF2, List list, int n2) {
        this.e = bF2;
        this.c = new HashSet();
        this.a = list;
        this.b = n2;
        this.d = ((w)list.get(0)).a(n2).g();
    }

    /*
     * Unable to fully structure code
     */
    D a() {
        var9_1 = ab.a;
        var1_2 = new D();
        var2_3 = this.b();
        var3_4 = new HashMap<w, D>();
        for (var4_5 = var2_3.k(); var4_5 != null; var4_5 = var4_5.a()) {
            var5_6 = (bO)var4_5.c();
            bO.b(var5_6);
            v0 = var5_6.a.iterator();
            if (var9_1 != 0) ** GOTO lbl29
            var6_7 = v0;
            while (var6_7.hasNext()) {
                var7_8 = (w)var6_7.next();
                v1 = (int)var3_4.containsKey(var7_8) ? 1 : 0;
                if (var9_1 != 0) ** GOTO lbl25
                if (v1 == 0) ** GOTO lbl-1000
                var8_9 = (List)var3_4.get(var7_8);
                if (var9_1 != 0) lbl-1000: // 2 sources:
                {
                    var8_9 = new D();
                    var3_4.put(var7_8, (D)var8_9);
                }
                var8_9.add(var4_5);
                if (var9_1 == 0) continue;
            }
            if (var9_1 == 0) continue;
        }
        do lbl-1000: // 3 sources:
        {
            v1 = var2_3.size();
lbl25: // 2 sources:
            if (v1 <= 0) break;
            var4_5 = this.b(var2_3);
            var5_6 = (bO)var4_5.c();
            v0 = var2_3.h(var4_5);
lbl29: // 2 sources:
            if ((var6_7 = this.a(var5_6, var2_3, var3_4)) == null) ** GOTO lbl-1000
            v2 = var1_2;
            if (var9_1 != 0) return v2;
            v2.add(var6_7);
        } while (var9_1 == 0);
        v2 = var1_2;
        return v2;
    }

    /*
     * Unable to fully structure code
     */
    private bN a(bO var1_1, D var2_2, HashMap var3_3) {
        var15_4 = ab.a;
        var4_5 = new HashSet<p>();
        var5_6 = new D();
        var6_7 = new D();
        var7_8 = new D();
        var8_9 = new ah(var1_1.c, var7_8);
        var9_10 = var1_1.a.iterator();
        block0 : do {
            v0 = var9_10.hasNext();
            block1 : while (v0) {
                var10_11 = (w)var9_10.next();
                var11_12 = var10_11.a(this.b);
                if (var1_1.a.size() > 1) {
                    block10 : {
                        var7_8.add(var11_12);
                        var11_12.a(var8_9);
                        for (Object var13_14 : var10_11.d()) {
                            if (var13_14.i() != null && var13_14.d() == this.b) {
                                var13_14.a(var8_9);
                            }
                            if (var13_14.j() == null) continue;
                            v1 = var13_14.e();
                            v2 = this.b;
                            if (var15_4 == 0) {
                                if (v1 != v2) continue;
                                var13_14.b(var8_9);
                                if (var15_4 == 0) continue;
                            }
                            break block10;
                        }
                        v1 = var10_11.e();
                        v2 = this.b + 1;
                    }
                    if (v1 > v2) {
                        var6_7.add(var10_11);
                    }
                }
                var12_13 = (List)var3_3.get(var10_11);
                var13_14 = var12_13.iterator();
                do lbl-1000: // 4 sources:
                {
                    if (!var13_14.hasNext()) continue block0;
                    var14_15 = (p)var13_14.next();
                    v3 = var14_15.c();
                    if (var15_4 != 0) ** GOTO lbl-1000
                    if (v3 == var1_1) ** GOTO lbl-1000
                    v0 = var4_5.add(var14_15);
                    if (var15_4 != 0) continue block1;
                    if (!v0) ** GOTO lbl-1000
                    var5_6.add(var14_15);
                } while (var15_4 == 0);
            }
            break block0;
            break;
        } while (true);
        if (var8_9.b().size() > 0) {
            var8_9.d();
        }
        for (Object v3 : var5_6) lbl-1000: // 2 sources:
        {
            if (!(var11_12 = (bO)(var10_11 = (p)v3).c()).b(var1_1.a)) continue;
            var2_2.h((p)var10_11);
            if (var15_4 != 0) return null;
            if (var15_4 == 0) continue;
        }
        if (var6_7.size() <= 1) return null;
        v4 = new bN(this.e, var6_7, this.b + 1);
        return v4;
    }

    private D b() {
        Object object;
        Object object22;
        int n2 = ab.a;
        y y2 = null;
        D d2 = new D();
        D d3 = new D();
        for (Object object22 : this.a) {
            object = object22.a(this.b);
            y y3 = object.h();
            if (y2 == null) {
                y2 = y3;
            }
            if (y2 == y3) {
                d2.add(object22);
                if (n2 == 0) continue;
            }
            d3.add(object22);
            if (n2 == 0) continue;
        }
        bM bM2 = new bM(this);
        d2.sort(bM2);
        d3.sort(bM2);
        object22 = this.a(d2);
        object = this.a(d3);
        return this.a((D)object22, (D)object);
    }

    /*
     * Unable to fully structure code
     */
    private D a(D var1_1) {
        var12_2 = ab.a;
        var2_3 = new D();
        var3_4 = var1_1.m();
        block0 : do {
            v0 = var3_4.f();
            block1 : while (v0) {
                var4_5 = (w)var3_4.d();
                var5_6 = var4_5.a(this.b);
                var6_7 = var5_6.c();
                var7_8 = new bO(this, var4_5);
                v1 = var2_3;
                if (var12_2 != 0) return v1;
                var8_9 = v1.k();
                while (var8_9 != null) {
                    var9_10 = (bO)var8_9.c();
                    v0 = var9_10.c.d(var6_7);
                    if (var12_2 != 0) continue block1;
                    if (!v0) ** GOTO lbl22
                    var7_8 = null;
                    var9_10.a(var4_5);
                    ** GOTO lbl-1000
lbl22: // 1 sources:
                    if (var6_7.c(var9_10.c) && var7_8 != null) {
                        for (w var11_12 : var9_10.a) {
                            var7_8.a(var11_12);
                            if (var12_2 == 0) {
                                if (var12_2 == 0) continue;
                            }
                            break;
                        }
                    } else lbl-1000: // 4 sources:
                    {
                        var8_9 = var8_9.a();
                    }
                    if (var12_2 == 0) continue;
                }
                if (var7_8 != null) {
                    var2_3.b(var7_8);
                }
                var3_4.g();
                if (var12_2 == 0) continue block0;
            }
            break block0;
            break;
        } while (true);
        v1 = var2_3;
        return v1;
    }

    /*
     * Unable to fully structure code
     */
    private D a(D var1_1, D var2_2) {
        var12_3 = ab.a;
        var3_4 = new D();
        var4_5 = var2_2.l();
        while (var4_5 != null) {
            block7 : {
                var5_6 = (bO)var4_5.c();
                var6_7 = var5_6.c;
                v0 = var1_1;
                if (var12_3 != 0) return v0;
                var7_8 = v0.l();
                while (var7_8 != null) {
                    var8_9 = (bO)var7_8.c();
                    var9_10 = var8_9.c;
                    if (var9_10.d(var6_7)) {
                        var8_9.a(var5_6);
                        if (var12_3 == 0) break;
                    }
                    if (var6_7.c(var9_10)) {
                        var5_6.a(var8_9.a);
                        var3_4.add(var5_6);
                        if (var12_3 == 0) break;
                    }
                    if (!var9_10.c(var6_7)) ** GOTO lbl-1000
                    var8_9.a(var5_6.a);
                    if (var12_3 != 0) lbl-1000: // 2 sources:
                    {
                        if (var9_10.a(var6_7, 1.0E-6) && !this.c.contains(var10_11 = M.a(var9_10, var6_7))) {
                            var11_12 = new bO(this, var8_9, var5_6, var10_11);
                            var3_4.add(var11_12);
                        }
                    }
                    if ((var7_8 = var7_8.b()) != null) continue;
                    var3_4.add(var5_6);
                    if (var12_3 == 0) {
                        if (var12_3 == 0) continue;
                    }
                    break block7;
                }
                var4_5 = var4_5.b();
            }
            if (var12_3 == 0) continue;
        }
        var3_4.a(var1_1);
        v0 = var3_4;
        return v0;
    }

    private p b(D d2) {
        p p2;
        int n2 = ab.a;
        double d3 = Double.MAX_VALUE;
        p p3 = null;
        for (p p4 = d2.k(); p4 != null; p4 = p4.a()) {
            p2 = p4;
            if (n2 != 0) return p2;
            bO bO2 = (bO)p2.c();
            double d4 = bO2.a();
            if (d4 >= d3) continue;
            d3 = d4;
            p3 = p4;
            if (n2 == 0) continue;
        }
        p2 = p3;
        return p2;
    }

    static bF a(bN bN2) {
        return bN2.e;
    }
}

