/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import y.c.A;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.h;
import y.c.p;
import y.c.q;
import y.c.y;
import y.d.n;
import y.d.t;
import y.f.I;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.aE;
import y.f.aF;
import y.f.am;
import y.f.c.C;
import y.f.c.K;
import y.f.c.a;
import y.f.c.aq;
import y.f.c.ar;
import y.f.c.as;
import y.f.c.x;
import y.f.c.z;
import y.f.i.b;
import y.g.M;

class ap {
    private Map b = new HashMap();
    private f c;
    private y d;
    private X e;
    private A f;
    private A g;
    private A h;
    private A i;
    private A j;
    private Map k;
    private as l;
    private D m;
    double a = 20.0;
    private A n;
    private h o;
    private c p;
    private c q;
    private double r;
    private h s;
    private h t;
    private boolean u = false;

    ap(X x2, A a2, A a3, D d2, A a4, h h2, h h3, h h4) {
        this.j = a2;
        this.e = x2;
        this.m = d2;
        this.f = a3;
        this.g = a4;
        this.s = h3;
        this.t = h4;
    }

    public void a(boolean bl2) {
        this.u = bl2;
    }

    public void a(A a2, c c2, h h2, c c3) {
        this.n = a2;
        this.o = h2;
        this.p = c2;
        this.q = c3;
    }

    public void a(double d2) {
        this.a = d2;
    }

    public boolean a() {
        if (this.c == null) return false;
        if (this.c.size() <= 0) return false;
        return true;
    }

    public void b() {
        boolean bl2 = a.i;
        this.c = new f();
        e e2 = this.e.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            if (this.f.a(d2.c()) == this.f.a(d2.d())) {
                this.c.c(d2);
                this.e.d(d2);
            }
            e2.g();
        } while (!bl2);
    }

    public void c() {
        boolean bl2 = a.i;
        if (!this.a()) {
            return;
        }
        p p2 = this.c.k();
        do {
            if (p2 == null) return;
            this.e.e((d)p2.c());
            this.e.b(p2.c()).clearPoints();
            p2 = p2.a();
        } while (!bl2);
    }

    public f d() {
        return this.c;
    }

    public int a(int n2) {
        int n3;
        boolean bl2;
        block12 : {
            block11 : {
                Object object;
                bl2 = a.i;
                if (!this.a()) {
                    return n2;
                }
                this.d = new y();
                int n4 = 0;
                int n5 = n2 - 1;
                for (object = this.c.k(); object != null; object = object.a()) {
                    d d2 = (d)object.c();
                    aE aE2 = this.a(d2);
                    aE aE3 = this.b(d2);
                    q q2 = d2.c();
                    q q3 = d2.d();
                    boolean bl3 = this.a(aE2, aE3);
                    q q4 = this.e.d();
                    if (!bl2) {
                        if (this.n != null) {
                            this.n.a((Object)q4, y.g.am.a("LowerSameLayerEdgeSupport", this.q.b(d2)));
                        }
                        this.j.a((Object)q4, K.t);
                        this.e.b(q4, 1.0, 1.0);
                        int n6 = this.f.a(q2);
                        this.f.a((Object)q4, n6 + 1);
                        d d3 = this.e.a(q2, q4);
                        d d4 = this.e.a(q3, q4);
                        this.d.add(q4);
                        q q5 = this.e.d();
                        this.j.a((Object)q5, K.t);
                        if (this.n != null) {
                            this.n.a((Object)q5, y.g.am.a("UpperSameLayerEdgeSupport", this.q.b(d2)));
                        }
                        this.e.b(q5, 1.0, 1.0);
                        this.f.a((Object)q5, n6 - 1);
                        this.e.a(q5, q2);
                        this.e.a(q5, q3);
                        this.d.add(q5);
                        n4 = Math.min(n4, n6 - 1);
                        n5 = Math.max(n5, n6 + 1);
                        if (!bl2) continue;
                    }
                    break block11;
                }
                if (n4 < 0) {
                    for (n3 = -1; n3 >= n4; --n3) {
                        this.m.a(y.g.am.a("UpperSameLayerEdgeLayer", new Integer(- n3)));
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block12;
                    }
                    object = this.e.o();
                    while (object.f()) {
                        int n7 = this.f.a(object.e()) - n4;
                        this.f.a((Object)object.e(), n7);
                        object.g();
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block11;
                    }
                    n5 -= n4;
                }
                n2 = n5 + 1;
            }
            n3 = 1;
        }
        do {
            if (this.m.size() >= n2) return n2;
            this.m.b(y.g.am.a("LowerSameLayerEdgeLayer", new Integer(n3++)));
        } while (!bl2);
        return n2;
    }

    private boolean a(aE aE2, aE aE3) {
        if (aE2.d()) return true;
        if (!aE2.e() && !aE2.f()) {
            if (!aE2.g()) return false;
        }
        if (!aE3.d()) return false;
        return true;
    }

    aE a(d d2) {
        aE aE2;
        if (this.s != null) {
            aE aE3;
            aE aE4 = (aE)this.s.b(d2);
            if (aE4 == null) {
                aE3 = aE.a(0, false);
                return aE3;
            }
            aE3 = aE4;
            return aE3;
        }
        c c2 = this.e.c(aF.a);
        if (c2 == null) {
            return aE.a(0, false);
        }
        aE aE5 = (aE)c2.b(d2);
        if (aE5 == null) {
            aE2 = aE.a(0, false);
            return aE2;
        }
        aE2 = aE5;
        return aE2;
    }

    aE b(d d2) {
        aE aE2;
        if (this.t != null) {
            aE aE3;
            aE aE4 = (aE)this.t.b(d2);
            if (aE4 == null) {
                aE3 = aE.a(0, false);
                return aE3;
            }
            aE3 = aE4;
            return aE3;
        }
        c c2 = this.e.c(aF.b);
        if (c2 == null) {
            return aE.a(0, false);
        }
        aE aE5 = (aE)c2.b(d2);
        if (aE5 == null) {
            aE2 = aE.a(0, false);
            return aE2;
        }
        aE2 = aE5;
        return aE2;
    }

    public void a(D d2) {
        Object object;
        Object object2;
        boolean bl2;
        boolean bl3;
        block11 : {
            Object object3;
            block10 : {
                p p2;
                block9 : {
                    bl2 = a.i;
                    if (!this.a()) {
                        return;
                    }
                    if (this.d == null) return;
                    if (this.d.isEmpty()) return;
                    for (p2 = this.d.k(); p2 != null; p2 = p2.a()) {
                        this.e.a((q)p2.c());
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block9;
                    }
                    p2 = d2.k();
                }
                while (p2 != null) {
                    object2 = (y)p2.c();
                    object3 = object2.k();
                    if (bl2) break block10;
                    for (object = v1013206; object != null; object = object.a()) {
                        bl3 = this.e.f((q)object.c());
                        if (!bl2) {
                            if (bl3) continue;
                            object2.h((p)object);
                            if (!bl2) continue;
                        }
                        break block11;
                    }
                    p2 = p2.a();
                    if (!bl2) continue;
                }
                object3 = d2.i();
            }
            bl3 = ((D)object3).isEmpty();
        }
        if (bl3) {
            d2.h(d2.l());
            this.m.h(this.m.l());
        }
        if (!((D)d2.f()).isEmpty()) return;
        d2.h(d2.k());
        this.m.h(this.m.k());
        int n2 = 0;
        object2 = d2.k();
        block3 : do {
            if (object2 == null) return;
            object = (y)object2.c();
            Integer n3 = new Integer(n2);
            for (p p3 = object.k(); p3 != null; p3 = p3.a()) {
                this.f.a(p3.c(), n3);
                if (bl2) continue block3;
                if (!bl2) continue;
            }
            object2 = object2.a();
            ++n2;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    void b(D var1_1) {
        block38 : {
            block39 : {
                block36 : {
                    var20_2 = a.i;
                    if (!this.a()) {
                        return;
                    }
                    this.i = this.e.t();
                    var2_3 = M.a(new q[this.e.e()]);
                    var3_4 = M.a(new int[this.e.e()]);
                    var4_5 = var1_1.k();
                    while (var4_5 != null) {
                        block37 : {
                            var5_7 = (y)var4_5.c();
                            var6_8 = 0;
                            v0 = var5_7.k();
                            if (var20_2) break block36;
                            for (var7_12 = v1016548; var7_12 != null; var7_12 = var7_12.a(), ++var6_8) {
                                var3_4.a(var7_12.c(), var6_8);
                                if (!var20_2) {
                                    if (!var20_2) continue;
                                }
                                break block37;
                            }
                            var4_5 = var4_5.a();
                        }
                        if (!var20_2) continue;
                    }
                    v0 = var4_5 = var1_1.k();
                }
                while (var4_5 != null) {
                    var5_7 = (y)var4_5.c();
                    var6_8 = 0;
                    var7_12 = var5_7.a();
                    v1 = var7_12.f();
                    if (var20_2) break block38;
                    if (v1 == 0) ** GOTO lbl52
                    var8_13 = var7_12.e();
                    while (var7_12.f()) {
                        var8_13 = var7_12.e();
                        v2 = this.g.b(var8_13);
                        if (!var20_2) {
                            if (v2 == null) break;
                            var7_12.g();
                            if (!var20_2) continue;
                        }
                        ** GOTO lbl56
                    }
                    if (var7_12.f()) {
                        var7_12.g();
                        while (var7_12.f()) {
                            var9_17 = var7_12.e();
                            v2 = this.g.b(var9_17);
                            if (!var20_2) {
                                if (v2 == null) {
                                    var2_3.a(var9_17, var8_13);
                                    var8_13 = var9_17;
                                }
                                var7_12.g();
                                if (!var20_2) continue;
                            } else {
                                ** GOTO lbl51
                            }
                        }
                    }
                    ** GOTO lbl52
lbl51: // 2 sources:
                    ** GOTO lbl56
lbl52: // 4 sources:
                    var4_5 = var4_5.a();
                    if (!var20_2) continue;
                }
                for (var4_5 = this.c.k(); var4_5 != null; var4_5 = var4_5.a()) {
                    block43 : {
                        block42 : {
                            block41 : {
                                block40 : {
                                    v2 = var4_5.c();
lbl56: // 3 sources:
                                    var5_7 = (d)v2;
                                    var6_10 = this.a((d)var5_7);
                                    var7_12 = this.b((d)var5_7);
                                    var8_15 = this.a(var6_10, (aE)var7_12);
                                    var9_17 = (ar)this.i.b(var5_7.c());
                                    if (var20_2) break block39;
                                    if (var9_17 == null) {
                                        var9_17 = new ar(this.e.a(var5_7.c()));
                                        this.i.a((Object)var5_7.c(), var9_17);
                                    }
                                    if ((var10_18 = (ar)this.i.b(var5_7.d())) == null) {
                                        var10_18 = new ar(this.e.a(var5_7.d()));
                                        this.i.a((Object)var5_7.d(), var10_18);
                                    }
                                    var11_19 = var2_3.b(var5_7.c()) == var5_7.d() || var2_3.b(var5_7.d()) == var5_7.c();
                                    v3 = var12_21 = var3_4.a(var5_7.c()) < var3_4.a(var5_7.d());
                                    if (var12_21) {
                                        v4 = var13_23 = !(var11_19 == false || var6_10.b() != 0 && var6_10.b() != 4 || var7_12.b() != 0 && var7_12.b() != 8);
                                        if (!var20_2) break block40;
                                    }
                                    v5 = var13_23 = !(var11_19 == false || var6_10.b() != 0 && var6_10.b() != 8 || var7_12.b() != 0 && var7_12.b() != 4);
                                }
                                if ((!this.u || var11_19 || this.s == null || this.t == null || var6_10.b() != 0 && var7_12.b() != 0) && (var6_10.b() != 4 && var6_10.b() != 8 || var7_12.b() != 4 && var7_12.b() != 8)) ** GOTO lbl-1000
                                var16_28 = 0;
                                var17_29 = 0;
                                if (!var12_21) ** GOTO lbl89
                                if (var7_12.b() == 4) {
                                    var18_30 = var5_7.d();
                                    if (!var20_2) break block41;
                                }
                                var18_30 = (q)var2_3.b(var5_7.d());
                            }
                            if (var6_10.b() != 8) ** GOTO lbl87
                            var19_31 = (q)var2_3.b(var5_7.c());
                            if (!var20_2) ** GOTO lbl98
lbl87: // 2 sources:
                            var19_31 = var5_7.c();
                            if (!var20_2) ** GOTO lbl98
lbl89: // 2 sources:
                            if (var6_10.b() == 4) {
                                var18_30 = var5_7.c();
                                if (!var20_2) break block42;
                            }
                            var18_30 = (q)var2_3.b(var5_7.c());
                        }
                        if (var7_12.b() != 8) ** GOTO lbl-1000
                        var19_31 = (q)var2_3.b(var5_7.d());
                        if (var20_2) lbl-1000: // 2 sources:
                        {
                            var19_31 = var5_7.d();
                        }
lbl98: // 6 sources:
                        while (var18_30 != var19_31) {
                            var16_28 += var18_30.b();
                            var17_29 += var18_30.c();
                            var18_30 = (q)var2_3.b(var18_30);
                            if (!var20_2) {
                                if (!var20_2) continue;
                            }
                            ** GOTO lbl-1000
                        }
                        if (var17_29 < var16_28) {
                            v6 = true;
                        } else lbl-1000: // 2 sources:
                        {
                            v6 = var8_15 = false;
                        }
                        if (var6_10.b() == 0) {
                            if (var17_29 == var16_28) {
                                var8_15 = var7_12.b() == 2;
                            }
                            var14_26 = var8_15 != false ? 2 : 0;
                            this.s.a(var5_7, aE.a(var8_15 != false ? 2 : 1));
                            if (!var20_2) break block43;
                        }
                        {
                            var14_26 = x.a(var6_10.b(), var13_23 ? (var12_21 ? 1 : 3) : (var8_15 != false ? 2 : 0));
                        }
                    }
                    if (var7_12.b() != 0) ** GOTO lbl-1000
                    if (var6_10.b() != 1) ** GOTO lbl-1000
                    var8_15 = false;
                    if (var20_2) lbl-1000: // 2 sources:
                    {
                        if (var6_10.b() == 2) {
                            var8_15 = true;
                        }
                    }
                    var15_27 = var8_15 != false ? 2 : 0;
                    this.t.a(var5_7, aE.a(var8_15 != false ? 2 : 1));
                    if (var20_2) lbl-1000: // 2 sources:
                    {
                        var15_27 = x.a(var7_12.b(), var13_23 ? (var12_21 ? 3 : 1) : (var8_15 != false ? 2 : 0));
                        ** if (!var20_2) goto lbl131
                    }
                    ** GOTO lbl131
lbl-1000: // 2 sources:
                    {
                        var14_26 = x.a(var6_10.b(), var13_23 ? (var12_21 ? 1 : 3) : (var8_15 != false ? 2 : 0));
                        var15_27 = x.a(var7_12.b(), var13_23 ? (var12_21 ? 3 : 1) : (var8_15 != false ? 2 : 0));
                    }
lbl131: // 3 sources:
                    v7 = var16_28 = (var14_26 ^ var15_27) == 2 && (var14_26 | var15_27) == 2 ? 1 : 0;
                    if (var16_28 == 0) ** GOTO lbl145
                    if (!var12_21) ** GOTO lbl-1000
                    v8 = var10_18.c;
                    v8[1] = v8[1] + 1;
                    v9 = var10_18.d;
                    v10 = var15_27 == 0 ? 0 : 3;
                    v9[v10] = v9[v10] + 1;
                    if (var20_2) lbl-1000: // 2 sources:
                    {
                        v11 = var10_18.c;
                        v11[0] = v11[0] + 1;
                        v12 = var10_18.d;
                        v13 = var15_27 == 0 ? 1 : 2;
                        v12[v13] = v12[v13] + 1;
                    }
lbl145: // 4 sources:
                    this.a((ar)var9_17, (d)var5_7, var14_26, var13_23 != false && (var14_26 & 1) == 1, var8_15, var12_21 == false);
                    this.a(var10_18, (d)var5_7, var15_27, var13_23 != false && (var15_27 & 1) == 1, var8_15, var12_21);
                    if (!var20_2) continue;
                }
                this.l = new as(this, var3_4);
                this.h = this.e.t();
            }
            v1 = 0;
        }
        var4_6 = v1;
        var5_7 = var1_1.k();
        do {
            if (var5_7 == null) return;
            v14 = var5_7.c();
            block8 : do {
                var6_11 = (y)v14;
                for (var7_12 = var6_11.k().a(); var7_12 != null; var7_12 = var7_12.a()) {
                    var8_16 = (q)var7_12.c();
                    var9_17 = (q)var7_12.b().c();
                    var10_18 = this.b(var8_16);
                    var11_20 = this.b((q)var9_17);
                    v14 = var10_18;
                    if (var20_2) continue block8;
                    if (v14 == null || (var12_22 = var10_18.c((int)3).l).size() <= 0) continue;
                    var10_18.e[1] = var13_25 = this.e.d();
                    var14_26 = var12_22.size();
                    this.f.a((Object)var13_25, var4_6);
                    var6_11.a(var13_25, (p)var7_12);
                    this.e.b(var13_25, 2.0 * this.a + this.a * (double)(var14_26 - 1) + this.a(var12_22), 0.5);
                    this.h.a((Object)var13_25, true);
                    if (!var20_2) continue;
                }
                break;
            } while (true);
            var5_7 = var5_7.a();
            ++var4_6;
        } while (!var20_2);
    }

    void a(q q2, ar ar2) {
        this.l.a(q2, 0);
        ar2.a((int)0).l.sort(this.l);
        this.l.a(q2, 2);
        ar2.b((int)0).l.sort(this.l);
        this.l.a(q2, 3);
        ar2.a((int)1).l.sort(this.l);
        this.l.a(q2, 5);
        ar2.b((int)1).l.sort(this.l);
        this.l.a(q2, 6);
        ar2.a((int)2).l.sort(this.l);
        this.l.a(q2, 8);
        ar2.b((int)2).l.sort(this.l);
        this.l.a(q2, 9);
        ar2.a((int)3).l.sort(this.l);
        this.l.a(q2, 11);
        ar2.b((int)3).l.sort(this.l);
        ar2.c((int)3).l.n();
    }

    private void a(ar ar2, d d2, int n2, boolean bl2, boolean bl3, boolean bl4) {
        boolean bl5 = a.i;
        if (bl2) {
            ar2.c((int)n2).l.add(d2);
            if (!bl5) return;
        }
        switch (n2) {
            case 0: {
                if (bl4) {
                    ar2.a((int)0).l.add(d2);
                    if (!bl5) return;
                }
                ar2.b((int)0).l.add(d2);
                if (!bl5) return;
            }
            case 1: {
                if (bl3) {
                    ar2.b((int)1).l.add(d2);
                    if (!bl5) return;
                }
                ar2.a((int)1).l.add(d2);
                if (!bl5) return;
            }
            case 2: {
                if (bl4) {
                    ar2.b((int)2).l.add(d2);
                    if (!bl5) return;
                }
                ar2.a((int)2).l.add(d2);
                if (!bl5) return;
            }
            case 3: {
                if (bl3) {
                    ar2.a((int)3).l.add(d2);
                    if (!bl5) return;
                }
                ar2.b((int)3).l.add(d2);
            }
        }
    }

    private double a(f f2) {
        double d2;
        boolean bl2 = a.i;
        double d3 = 0.0;
        e e2 = f2.a();
        while (e2.f()) {
            d2 = Math.max(d3, this.c(e2.a()));
            if (bl2) return d2;
            d3 = d2;
            e2.g();
            if (!bl2) continue;
        }
        d2 = d3;
        return d2;
    }

    private double c(d d2) {
        boolean bl2 = a.i;
        S[] arrs = this.d(d2);
        if (arrs == null) return 0.0;
        if (arrs.length == 0) {
            return 0.0;
        }
        double d3 = 0.0;
        for (int i2 = 0; i2 < arrs.length; d3 += arrs[i2].a().e(), ++i2) {
            if (bl2) return d3;
            if (!bl2) continue;
        }
        d3 += (double)(10 * (arrs.length - 1));
        return d3;
    }

    private S[] d(d d2) {
        c c2 = this.e.c(U.a);
        if (c2 != null) return (S[])c2.b(d2);
        return null;
    }

    boolean a(q q2) {
        if (this.i == null) return false;
        if (this.i.b(q2) == null) return false;
        return true;
    }

    ar b(q q2) {
        if (this.i == null) return null;
        ar ar2 = (ar)this.i.b(q2);
        return ar2;
    }

    private aq e(d d2) {
        aq aq2 = (aq)this.k.get(d2);
        if (aq2 != null) return aq2;
        aq2 = new aq();
        this.k.put(d2, aq2);
        return aq2;
    }

    /*
     * Unable to fully structure code
     */
    public void c(D var1_1) {
        var12_2 = a.i;
        if (!this.a()) {
            return;
        }
        this.k = new HashMap<K, V>();
        var2_3 = new b(0.0, 0.0);
        var3_4 = new b(0.0, 0.0);
        var4_5 = var1_1.k();
        block0 : do {
            block10 : {
                if (var4_5 == null) return;
                v0 = var4_5.c();
                block1 : do lbl-1000: // 3 sources:
                {
                    var5_6 = (C)v0;
                    var6_7 = var5_6.a;
                    var2_3.a(var5_6.b - 100000.0, var5_6.b - 90000.0, 1);
                    var3_4.a(var5_6.c + 90000.0, var5_6.c + 100000.0, 1);
                    var7_8 = new HashMap<K, V>();
                    for (var8_9 = var6_7.k(); var8_9 != null; var8_9 = var8_9.a()) {
                        var9_11 = (q)var8_9.c();
                        v0 = var10_15 = this.b(var9_11);
                        if (var12_2) ** GOTO lbl-1000
                        if (v0 == null) continue;
                        var10_15.a(this.e.a(var9_11));
                        this.b(var9_11, var10_15.a(1), var7_8);
                        this.b(var9_11, var10_15.b(1), var7_8);
                        this.b(var9_11, var10_15.a(3), var7_8);
                        this.b(var9_11, var10_15.b(3), var7_8);
                        this.a(var9_11, var10_15.a(0), var7_8);
                        this.a(var9_11, var10_15.c(0), var7_8);
                        this.a(var9_11, var10_15.b(0), var7_8);
                        this.a(var9_11, var10_15.a(2), var7_8);
                        this.a(var9_11, var10_15.c(2), var7_8);
                        this.a(var9_11, var10_15.b(2), var7_8);
                        if (!var12_2) continue;
                    }
                    for (var8_9 = var6_7.k(); var8_9 != null; var8_9 = var8_9.a()) {
                        var9_12 = (q)var8_9.c();
                        v0 = var10_15 = this.b(var9_12);
                        if (var12_2) continue block1;
                        if (v0 == null) continue;
                        var11_16 = this.e.a(var9_12);
                        this.a(var9_12, var10_15.a(1), var7_8, var2_3);
                        this.a(var9_12, var10_15.b(1), var7_8, var3_4);
                        this.a(var9_12, var10_15.a(3), var7_8, var3_4);
                        this.a(var9_12, var10_15.b(3), var7_8, var2_3);
                        this.a(var9_12, (ar)var10_15, var10_15.a(0), var7_8, var2_3, var3_4, 2, 3, var11_16);
                        this.a(var9_12, (ar)var10_15, var10_15.c(0), var7_8, var2_3, var3_4, 2, 1, var11_16);
                        this.a(var9_12, (ar)var10_15, var10_15.b(0), var7_8, var2_3, var3_4, 2, 1, var11_16);
                        this.a(var9_12, (ar)var10_15, var10_15.a(2), var7_8, var3_4, var2_3, 1, 1, var11_16);
                        this.a(var9_12, (ar)var10_15, var10_15.c(2), var7_8, var3_4, var2_3, 1, 1, var11_16);
                        this.a(var9_12, (ar)var10_15, var10_15.b(2), var7_8, var3_4, var2_3, 1, 3, var11_16);
                        if (!var12_2) continue;
                    }
                    break;
                } while (true);
                var2_3.b();
                var3_4.b();
                if (var2_3.c() > 0) {
                    var5_6.d = this.a * (double)var2_3.c();
                }
                if (var3_4.c() > 0) {
                    var5_6.e = this.a * (double)var3_4.c();
                }
                var8_9 = var2_3.a();
                while (var8_9.hasNext()) {
                    var9_13 = (d)var8_9.next();
                    var10_15 = (aq)this.k.get(var9_13);
                    var10_15.a[0] = var2_3.c(var9_13);
                    if (!var12_2) {
                        if (!var12_2) continue;
                    }
                    break block10;
                }
                var8_9 = var3_4.a();
            }
            while (var8_9.hasNext()) {
                var9_14 = (d)var8_9.next();
                var10_15 = (aq)this.k.get(var9_14);
                var10_15.a[1] = var3_4.c(var9_14);
                if (var12_2) continue block0;
                if (!var12_2) continue;
            }
            var4_5 = var4_5.a();
        } while (!var12_2);
    }

    private void a(q q2, z z2, Map map) {
        boolean bl2 = a.i;
        p p2 = z2.l.k();
        do {
            if (p2 == null) return;
            d d2 = (d)p2.c();
            aq aq2 = this.e(d2);
            if (q2 != d2.d()) {
                map.put(d2, this.e.p(d2));
            }
            p2 = p2.a();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private void b(q var1_1, z var2_2, Map var3_3) {
        var10_4 = a.i;
        var4_5 = var2_2.l.k();
        do {
            if (var4_5 == null) return;
            var5_6 = (d)var4_5.c();
            var6_7 = this.e(var5_6);
            if (var1_1 != var5_6.d()) ** GOTO lbl-1000
            var6_7.c = var2_2.b();
            if (var10_4) lbl-1000: // 2 sources:
            {
                var6_7.b = var2_2.b();
                var7_8 = var2_2.f(0.0, var6_7.b);
                var9_9 = this.e.p(var5_6);
                var3_3.put(var5_6, new t(var7_8, var9_9.b));
            }
            var4_5 = var4_5.a();
        } while (!var10_4);
    }

    private void a(q q2, z z2, Map map, b b2) {
        boolean bl2 = a.i;
        p p2 = z2.l.k();
        do {
            if (p2 == null) return;
            d d2 = (d)p2.c();
            if (q2 != d2.c()) {
                aq aq2 = (aq)this.k.get(d2);
                t t2 = this.e.q(d2);
                t t3 = (t)map.get(d2);
                aE aE2 = this.a(d2);
                am am2 = this.e.a(d2.d());
                t t4 = new t(z2.f(0.0, aq2.c), am2.getY());
                b2.a(d2, t3, t4);
            }
            p2 = p2.a();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(q var1_1, ar var2_2, z var3_3, Map var4_4, b var5_5, b var6_6, byte var7_7, int var8_8, am var9_9) {
        var17_10 = a.i;
        var10_11 = var3_3.l.k();
        do {
            if (var10_11 == null) return;
            var11_12 = (d)var10_11.c();
            if (var1_1 == var11_12.c()) ** GOTO lbl18
            var12_13 = (aq)this.k.get(var11_12);
            var13_14 = this.e.q(var11_12);
            var14_15 = (t)var4_4.get(var11_12);
            var15_16 = this.a(var11_12);
            if (var15_16.b() != var7_7) ** GOTO lbl-1000
            var16_17 = new t(var2_2.c(var8_8).f(0.0, var2_2.g(var8_8)), var9_9.getY());
            var12_13.d = var16_17.a - var9_9.getX();
            var12_13.c = var3_3.b();
            var6_6.a(var11_12, var14_15, var16_17);
            if (var17_10) lbl-1000: // 2 sources:
            {
                var5_5.a(var11_12, var14_15, var13_14);
            }
lbl18: // 4 sources:
            var10_11 = var10_11.a();
        } while (!var17_10);
    }

    private D f(d d2) {
        D d3 = (D)this.b.get(d2);
        if (d3 != null) return d3;
        d3 = new D();
        this.b.put(d2, d3);
        return d3;
    }

    /*
     * Exception decompiling
     */
    void d(D var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[FORLOOP]], but top level block is 8[FORLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     */
    private void a(q var1_1, z var2_2, byte var3_3, double var4_4, int var6_5) {
        var16_6 = a.i;
        var7_7 = var2_2.l.k();
        do {
            if (var7_7 == null) return;
            var8_8 = (d)var7_7.c();
            var9_9 = (aq)this.k.get(var8_8);
            var10_10 = this.f(var8_8);
            var11_11 = var4_4 + (double)var9_9.a[var6_5] * this.a;
            if (var8_8.c() != var1_1) ** GOTO lbl-1000
            var13_12 = this.e.p(var8_8);
            if (!Double.isNaN(var9_9.d)) {
                var14_13 = this.e.a(var8_8.d()).getX() + var9_9.d;
                var10_10.a(new t(var14_13, var11_11));
            }
            var10_10.a(new t(var13_12.a, var11_11));
            if (var16_6) lbl-1000: // 2 sources:
            {
                var13_12 = this.e.q(var8_8);
                if (!Double.isNaN(var9_9.d)) {
                    var14_13 = this.e.a(var8_8.d()).getX() + var9_9.d;
                    var11_11 = var2_2.e(0.0, var9_9.c);
                    var10_10.add(new t(var14_13, var11_11));
                }
                var10_10.add(new t(var13_12.a, var11_11));
            }
            var7_7 = var7_7.a();
        } while (!var16_6);
    }

    /*
     * Unable to fully structure code
     */
    private void a(q var1_1, z var2_2, double var3_3, int var5_4) {
        var15_5 = a.i;
        var6_6 = var2_2.l.k();
        do {
            if (var6_6 == null) return;
            var7_7 = (d)var6_6.c();
            var8_8 = (aq)this.k.get(var7_7);
            var9_9 = this.f(var7_7);
            var10_10 = var3_3 + (double)var8_8.a[var5_4] * this.a;
            if (var7_7.c() != var1_1) ** GOTO lbl-1000
            var12_11 = var2_2.f(0.0, var8_8.b);
            var14_12 = this.e.p(var7_7);
            var9_9.a(new t(var12_11, var10_10));
            var9_9.a(new t(var12_11, var14_12.b));
            if (var15_5) lbl-1000: // 2 sources:
            {
                var12_11 = var2_2.f(0.0, var8_8.c);
                var14_12 = this.e.q(var7_7);
                var9_9.b(new t(var12_11, var10_10));
                var9_9.b(new t(var12_11, var14_12.b));
            }
            var6_6 = var6_6.a();
        } while (!var15_5);
    }

    void e() {
        this.l = null;
        this.k = null;
        this.q = null;
        this.p = null;
        this.n = null;
        this.o = null;
        this.s = null;
        this.t = null;
        if (this.i != null) {
            this.e.a(this.i);
            this.i = null;
        }
        if (this.h == null) return;
        this.e.a(this.h);
        this.h = null;
    }

    public void b(double d2) {
        this.r = d2;
    }

    static X a(ap ap2) {
        return ap2.e;
    }
}

