/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import y.c.A;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.I;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.aE;
import y.f.aF;
import y.f.aG;
import y.f.ah;
import y.f.am;
import y.f.b.c;
import y.f.b.h;
import y.f.c.F;
import y.f.c.G;
import y.f.c.H;
import y.f.c.J;
import y.f.c.K;
import y.f.c.Q;
import y.f.c.R;
import y.f.c.Y;
import y.f.c.a;
import y.f.c.aD;
import y.f.c.aJ;
import y.f.c.at;
import y.f.c.v;
import y.g.ap;

public class E
extends K {
    private c u;
    private J v;
    private y.g.I w;
    private X x;
    private y.c.h y;
    private A z;
    private A A;
    A n;
    private y.c.h B;
    private y.c.h C;
    private y.c.h D;
    private y.c.h E;
    private y.c.c F;
    private y.c.c G;
    private y.c.c H;
    private y.c.c I;
    private A J;
    private A K;
    private y.c.h L;
    private y.c.c M;
    private y.c.c N;
    private y.c.h O;
    private static final aE P = aE.a(1, true);
    private static final aE Q = aE.a(2, true);
    private y.f.b.a R;
    private ah S;
    private boolean T;
    private boolean U;

    public E() {
        this.S = new H(this);
        this.T = true;
        this.d(false);
        this.U = true;
        this.v = new J(this);
        this.R = new h();
        this.v.c = super.a();
        this.v.d = super.n();
        this.v.e = super.o();
        super.a(this.v);
        super.a(this.v);
        super.a(this.v);
    }

    @Override
    public boolean b(X x2) {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void a(X var1_1) {
        block51 : {
            block50 : {
                block47 : {
                    var25_2 = a.i;
                    if (!this.u() && c.c(var1_1)) {
                        try {
                            super.a(this.v.d);
                            super.a(this.v.c);
                            super.a(this.v.e);
                            super.a(var1_1);
                            var3_3 = null;
                            super.a(this.v);
                            super.a(this.v);
                            super.a(this.v);
                            return;
                        }
                        catch (Throwable var2_6) {
                            var3_4 = null;
                            super.a(this.v);
                            super.a(this.v);
                            super.a(this.v);
                            throw var2_6;
                        }
                    }
                    this.u = new c(var1_1);
                    this.y = var1_1.u();
                    this.z = var1_1.t();
                    this.A = var1_1.t();
                    this.n = var1_1.t();
                    this.J = var1_1.t();
                    this.x = var1_1;
                    this.w = new y.g.I(var1_1);
                    var2_7 = this.x.o();
                    while (var2_7.f()) {
                        this.J.a((Object)var2_7.e(), K.p);
                        var2_7.g();
                        if (!var25_2) {
                            if (!var25_2) continue;
                        }
                        break block47;
                    }
                    var1_1.a(K.o, this.J);
                }
                if ((var3_5 = var1_1.c(U.a)) != null) {
                    this.O = var1_1.u();
                    var2_7 = new ap(this.O, var1_1, U.a);
                } else {
                    var2_7 = null;
                }
                this.B = var1_1.u();
                var4_8 = new ap(this.B, var1_1, aF.a);
                this.F = var4_8.c();
                this.C = var1_1.u();
                var5_9 = new ap(this.C, var1_1, aF.b);
                this.G = var5_9.c();
                this.H = var1_1.c(aF.c);
                if (this.H != null) {
                    this.D = var1_1.u();
                    var6_10 = new ap(this.D, var1_1, aF.c);
                    this.I = var1_1.c(aF.d);
                    if (this.I == null) throw new IllegalStateException(new StringBuffer().append("No DataProvider ").append(aF.d).append(" bound to graph!").toString());
                    this.E = var1_1.u();
                    var7_11 = new ap(this.E, var1_1, aF.d);
                    if (var25_2) {
                        throw new IllegalStateException(new StringBuffer().append("No DataProvider ").append(aF.d).append(" bound to graph!").toString());
                    }
                } else {
                    if (var1_1.c(aF.d) != null) {
                        throw new IllegalStateException(new StringBuffer().append("No DataProvider ").append(aF.c).append(" bound to graph!").toString());
                    }
                    var7_11 = null;
                    var6_10 = null;
                }
                this.M = var1_1.c(ah.f_);
                this.N = var1_1.c(ah.k);
                if (this.M == null && this.N == null && this.p()) {
                    block49 : {
                        block48 : {
                            this.M = var1_1.t();
                            var9_12 = var1_1.o();
                            while (var9_12.f()) {
                                ((A)this.M).a((Object)var9_12.e(), var9_12.e());
                                var9_12.g();
                                if (!var25_2) {
                                    if (!var25_2) continue;
                                }
                                break block48;
                            }
                            this.N = var1_1.u();
                        }
                        var9_12 = var1_1.p();
                        while (var9_12.f()) {
                            ((y.c.h)this.N).a((Object)var9_12.a(), var9_12.a());
                            var9_12.g();
                            if (!var25_2) {
                                if (!var25_2) continue;
                            }
                            break block49;
                        }
                        var1_1.a(ah.f_, this.M);
                        var1_1.a(ah.k, this.N);
                    }
                    var8_13 = true;
                    if (!var25_2) break block50;
                }
                var8_13 = false;
            }
            if (this.M != null && (var8_13 || this.u() || this.p())) {
                this.K = var1_1.t();
                var9_12 = new ap(this.K, var1_1, ah.f_);
                if (!var25_2) break block51;
            }
            var9_12 = null;
        }
        if (this.N == null || !var8_13 && !this.u() && !this.p()) ** GOTO lbl-1000
        if (var9_12 == null) {
            throw new IllegalStateException(new StringBuffer().append("No DataProvider ").append(ah.f_).append(" bound to graph!").toString());
        }
        this.L = var1_1.u();
        var10_14 = new ap(this.L, var1_1, ah.k);
        if (var25_2) lbl-1000: // 2 sources:
        {
            var10_14 = null;
            if (var9_12 != null) {
                throw new IllegalStateException(new StringBuffer().append("No DataProvider ").append(ah.k).append(" bound to graph!").toString());
            }
        }
        var11_15 = var1_1.o();
        while (var11_15.f()) {
            block52 : {
                var12_17 = var11_15.e();
                var13_19 = new G();
                this.z.a((Object)var12_17, var13_19);
                if (var25_2 != false) return;
                for (var14_21 = var12_17.f(); var14_21 != null; var14_21 = var14_21.g()) {
                    var15_22 = new y.f.c.I();
                    this.a((d)var14_21, (y.f.c.I)var15_22);
                    this.y.a(var14_21, var15_22);
                    if (!var25_2) {
                        if (!var25_2) continue;
                    }
                    break block52;
                }
                var11_15.g();
            }
            if (!var25_2) continue;
        }
        try {
            var15_22 = null;
            if (this.U) {
                var16_23 = this.u() == false;
                var15_22 = this.t();
                var14_21 = var15_22.b();
                var12_18 = var15_22.a(1);
                var13_20 = var15_22.a(2);
                var11_16 = var13_20 == false;
            } else {
                var16_23 = false;
                var11_16 = false;
                var14_21 = null;
                var13_20 = false;
                var12_18 = false;
            }
            if (!var11_16) ** GOTO lbl165
            var17_24 = var15_22.a();
            var15_22.b(var17_24);
            var15_22.a(1, false);
            var15_22.a(2, false);
            var18_25 = this.x();
            var19_26 = new aD();
            var19_26.a = var18_25;
            ((Map)var17_24).put("y.layout.hierarchic.MementoSequencer.SequencerMemento", var19_26);
            if (var14_21 == null) ** GOTO lbl163
            if (var13_20) ** GOTO lbl154
            var20_27 = (Map)var14_21;
            var21_28 = (aD)var20_27.get("y.layout.hierarchic.MementoSequencer.SequencerMemento");
            if (var21_28 == null) ** GOTO lbl-1000
            var21_28.a.putAll(var19_26.a);
            if (var25_2) lbl-1000: // 2 sources:
            {
                ((Map)var14_21).put("y.layout.hierarchic.MementoSequencer.SequencerMemento", var19_26);
            }
lbl154: // 4 sources:
            if (var12_18) ** GOTO lbl163
            var20_27 = (Map)var14_21;
            var21_29 = (aJ)var20_27.get("y.layout.hierarchic.MementoLayerer.LayerMemento");
            var22_30 = (aJ)((Map)var17_24).get("y.layout.hierarchic.MementoLayerer.LayerMemento");
            if (var21_29 == null) ** GOTO lbl-1000
            var21_29.a = Math.max(var21_29.a, var22_30.a);
            var21_29.b.putAll(var22_30.b);
            if (var25_2) lbl-1000: // 2 sources:
            {
                ((Map)var14_21).put("y.layout.hierarchic.MementoLayerer.LayerMemento", var22_30);
            }
lbl163: // 5 sources:
            var15_22.a(1, true);
            var15_22.a(2, true);
lbl165: // 2 sources:
            this.a(this.u.b(), this.u.b(this.u.b()), false);
            if (var11_16) {
                var15_22.a(1, var12_18);
                var15_22.a(2, var13_20);
                var15_22.b(var14_21);
            }
            if (var16_23) {
                this.v();
            }
            this.a(this.u.b(), 0.0, 0.0);
            this.w();
            var24_31 = null;
            if (var9_12 != null) {
                var9_12.b();
                var1_1.a(this.K);
                this.K = null;
            }
            if (var10_14 != null) {
                var10_14.b();
                var1_1.a(this.L);
                this.L = null;
            }
            var1_1.a(this.y);
            var1_1.a(this.z);
            var1_1.a(this.A);
            var1_1.a(this.n);
            if (var8_13) {
                var1_1.d_(ah.f_);
                var1_1.d_(ah.k);
                var1_1.a(this.K);
                var1_1.a(this.L);
            }
            var1_1.d_(K.o);
            var1_1.a(this.J);
            this.J = null;
            if (var2_7 != null) {
                var2_7.b();
                var1_1.a(this.O);
                this.O = null;
            }
            var4_8.b();
            this.x.a(this.B);
            this.B = null;
            var5_9.b();
            this.x.a(this.C);
            this.C = null;
            if (var6_10 != null) {
                var6_10.b();
                this.x.a(this.D);
                this.D = null;
            }
            if (var7_11 != null) {
                var7_11.b();
                this.x.a(this.E);
                this.E = null;
            }
            this.H = null;
            this.I = null;
            this.F = null;
            this.G = null;
            this.A = null;
            this.n = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            if (this.u != null) {
                this.u.c();
            }
            this.u = null;
            return;
        }
        catch (Throwable var23_33) {
            var24_32 = null;
            if (var9_12 != null) {
                var9_12.b();
                var1_1.a(this.K);
                this.K = null;
            }
            if (var10_14 != null) {
                var10_14.b();
                var1_1.a(this.L);
                this.L = null;
            }
            var1_1.a(this.y);
            var1_1.a(this.z);
            var1_1.a(this.A);
            var1_1.a(this.n);
            if (var8_13) {
                var1_1.d_(ah.f_);
                var1_1.d_(ah.k);
                var1_1.a(this.K);
                var1_1.a(this.L);
            }
            var1_1.d_(K.o);
            var1_1.a(this.J);
            this.J = null;
            if (var2_7 != null) {
                var2_7.b();
                var1_1.a(this.O);
                this.O = null;
            }
            var4_8.b();
            this.x.a(this.B);
            this.B = null;
            var5_9.b();
            this.x.a(this.C);
            this.C = null;
            if (var6_10 != null) {
                var6_10.b();
                this.x.a(this.D);
                this.D = null;
            }
            if (var7_11 != null) {
                var7_11.b();
                this.x.a(this.E);
                this.E = null;
            }
            this.H = null;
            this.I = null;
            this.F = null;
            this.G = null;
            this.A = null;
            this.n = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            if (this.u != null) {
                this.u.c();
            }
            this.u = null;
            throw var23_33;
        }
    }

    private void a(d d2, y.f.c.I i2) {
        ArrayList<S> arrayList;
        ArrayList<S> arrayList2;
        ArrayList<S> arrayList3;
        int n2;
        block8 : {
            boolean bl2 = a.i;
            if (this.u.a(d2)) {
                return;
            }
            y.c.c c2 = this.x.c(U.a);
            if (c2 == null) return;
            S[] arrs = (S[])c2.b(d2);
            if (arrs == null) {
                return;
            }
            arrayList3 = new ArrayList<S>(4);
            arrayList2 = new ArrayList<S>(4);
            arrayList = new ArrayList<S>(4);
            for (int i3 = 0; i3 < arrs.length; ++i3) {
                S s2 = arrs[i3];
                aG aG2 = s2.f();
                n2 = (int)aG2.i() ? 1 : 0;
                if (!bl2) {
                    if (n2 != 0) {
                        arrayList3.add(s2);
                        if (!bl2) continue;
                    }
                    if (aG2.k()) {
                        arrayList2.add(s2);
                        if (!bl2) continue;
                    }
                    arrayList.add(s2);
                    if (!bl2) continue;
                }
                break block8;
            }
            n2 = arrayList3.size();
        }
        if (n2 > 0) {
            i2.g = arrayList3.toArray(new S[arrayList3.size()]);
        }
        if (arrayList2.size() > 0) {
            i2.h = arrayList2.toArray(new S[arrayList2.size()]);
        }
        if (arrayList.size() <= 0) return;
        i2.i = arrayList.toArray(new S[arrayList.size()]);
    }

    private S[] a(S[] arrs, S[] arrs2) {
        if (arrs == null) return arrs2;
        if (arrs.length == 0) {
            return arrs2;
        }
        if (arrs2 == null) return arrs;
        if (arrs2.length == 0) {
            return arrs;
        }
        S[] arrs3 = new S[arrs.length + arrs2.length];
        System.arraycopy(arrs, 0, arrs3, 0, arrs.length);
        System.arraycopy(arrs2, 0, arrs3, arrs.length, arrs2.length);
        return arrs3;
    }

    /*
     * Unable to fully structure code
     */
    private void a(q var1_1, double var2_2, double var4_3) {
        block9 : {
            block10 : {
                var14_4 = a.i;
                for (var6_5 = this.u.b((q)var1_1).k(); var6_5 != null; var6_5 = var6_5.a()) {
                    var7_6 = (q)var6_5.c();
                    this.x.d((q)var7_6, var2_2, var4_3);
                    var8_7 = (G)this.z.b(var7_6);
                    v0 = this.u;
                    if (var14_4) break block9;
                    if (!v0.d((q)var7_6)) ** GOTO lbl16
                    var9_9 = this.x.a(var7_6);
                    if (var8_7.a == null) ** GOTO lbl-1000
                    var10_10 = var9_9.getX() - var8_7.a.getX();
                    var12_13 = var9_9.getY() - var8_7.a.getY();
                    this.a((q)var7_6, var10_10, var12_13);
                    if (var14_4) lbl-1000: // 2 sources:
                    {
                        this.a((q)var7_6, var2_2, var4_3);
                    }
lbl16: // 4 sources:
                    var9_9 = var7_6.f();
                    while (var9_9 != null) {
                        var10_11 = var9_9.d();
                        v1 = this.u.a(var10_11);
                        if (!var14_4) {
                            if (v1 == var1_1) {
                                var11_12 = this.x.b(var9_9);
                                for (var12_14 = var11_12.pointCount() - 1; var12_14 >= 0; --var12_14) {
                                    var13_15 = var11_12.getPoint(var12_14);
                                    var11_12.setPoint(var12_14, var13_15.a + var2_2, var13_15.b + var4_3);
                                    if (!var14_4) {
                                        if (!var14_4) continue;
                                    }
                                    break;
                                }
                            } else {
                                var9_9 = var9_9.g();
                            }
                            if (!var14_4) continue;
                        }
                        break block10;
                    }
                    if (!var14_4) continue;
                }
                v1 = var1_1;
            }
            if (v1 == null) return;
            v0 = this.z.b(var1_1);
        }
        var6_5 = (G)v0;
        var7_6 = var6_5.b;
        if (var7_6 == null) return;
        var8_8 = var7_6.size() - 1;
        do {
            if (var8_8 < 0) return;
            var9_9 = (S)var7_6.get(var8_8);
            var9_9.a(var9_9.d() + var2_2, var9_9.e() + var4_3);
            --var8_8;
        } while (!var14_4);
    }

    /*
     * Unable to fully structure code
     */
    private void w() {
        var27_1 = a.i;
        var1_2 = new D();
        var2_3 = new D();
        var3_4 = new D();
        var4_5 = this.x.o();
        block0 : do {
            v0 = var4_5.f();
            block1 : do {
                if (v0 == 0) return;
                var5_6 = var4_5.e();
                var6_7 = this.x.a(var5_6);
                var7_8 = var5_6.f();
                while (var7_8 != null) {
                    block16 : {
                        var8_9 = (y.f.c.I)this.y.b(var7_8);
                        var9_10 = var8_9.a;
                        var10_11 = var8_9.b;
                        if (var27_1) continue block0;
                        if (!(var9_10 != null && var9_10.size() >= 1 || var10_11 != null && var10_11.size() >= 1)) ** GOTO lbl85
                        var11_12 = var7_8.d();
                        var12_13 = this.x.a(var11_12);
                        var13_14 = this.x.b(var7_8);
                        var13_14.clearPoints();
                        var3_4.clear();
                        if (var9_10 != null && var9_10.size() > 0) {
                            var14_15 = (Point2D.Double)var9_10.get(0);
                            var13_14.setSourcePoint(new t(var14_15.x, var14_15.y));
                            var14_15.x += var6_7.getX() + var6_7.getWidth() * 0.5;
                            var14_15.y += var6_7.getY() + var6_7.getHeight() * 0.5;
                            for (var15_16 = 1; var15_16 < var9_10.size(); ++var15_16) {
                                var16_19 = (Point2D.Double)var9_10.get(var15_16);
                                var16_19.x = var14_15.x += var16_19.x;
                                var16_19.y = var14_15.y += var16_19.y;
                                var3_4.add(var16_19);
                                if (!var27_1) {
                                    if (!var27_1) continue;
                                }
                                break block16;
                            }
                        }
                        var14_15 = var3_4.l();
                        if (var10_11 != null && var10_11.size() > 0) {
                            var15_17 = (Point2D.Double)var10_11.get(0);
                            var13_14.setTargetPoint(new t(var15_17.x, var15_17.y));
                            var15_17.x += var12_13.getX() + var12_13.getWidth() * 0.5;
                            var15_17.y += var12_13.getY() + var12_13.getHeight() * 0.5;
                            for (var16_20 = 1; var16_20 < var10_11.size(); ++var16_20) {
                                var17_21 = (Point2D.Double)var10_11.get(var16_20);
                                var17_21.x = var15_17.x += var17_21.x;
                                var17_21.y = var15_17.y += var17_21.y;
                                var3_4.b(var17_21, (p)var14_15);
                                if (!var27_1) {
                                    if (!var27_1) continue;
                                }
                                break block16;
                            }
                        }
                        var19_23 = this.x.p(var7_8);
                        var15_18 = var19_23.a;
                        var17_22 = var19_23.b;
                        var20_24 = false;
                        var21_25 = false;
                        var24_26 = this.x.q(var7_8);
                        var3_4.add(new Point2D.Double(var24_26.a, var24_26.b));
                        for (var25_27 = var3_4.k(); var25_27 != null; var25_27 = var25_27.a()) {
                            var26_28 = (Point2D.Double)var25_27.c();
                            v0 = Math.abs(var26_28.x - var15_18) DCMPG 0.001;
                            if (var27_1) continue block1;
                            if (v0 < 0 && Math.abs(var26_28.y - var17_22) < 0.001) {
                                if (var25_27.b() != null) {
                                    var3_4.h(var25_27.b());
                                    if (!var27_1) continue;
                                }
                                var3_4.h(var25_27);
                                if (!var27_1) continue;
                            }
                            if (!var20_24 || Math.abs(var17_22 - var26_28.y) >= 0.001) ** GOTO lbl-1000
                            var3_4.h(var25_27.b());
                            if (var27_1) lbl-1000: // 2 sources:
                            {
                                if (var21_25 && Math.abs(var15_18 - var26_28.x) < 0.001) {
                                    var3_4.h(var25_27.b());
                                }
                            }
                            var20_24 = Math.abs(var17_22 - var26_28.y) < 0.001;
                            var21_25 = Math.abs(var15_18 - var26_28.x) < 0.001;
                            var15_18 = var26_28.x;
                            var17_22 = var26_28.y;
                            if (!var27_1) continue;
                        }
                        var3_4.h(var3_4.l());
                        for (var25_27 = var3_4.k(); var25_27 != null; var25_27 = var25_27.a()) {
                            var26_28 = (Point2D.Double)var25_27.c();
                            var13_14.addPoint(var26_28.x, var26_28.y);
                            if (!var27_1) {
                                if (!var27_1) continue;
                            }
                            break block16;
                        }
lbl85: // 3 sources:
                        var7_8 = var7_8.g();
                    }
                    if (!var27_1) continue;
                }
                break block1;
                break;
            } while (true);
            var4_5.g();
        } while (!var27_1);
    }

    /*
     * Exception decompiling
     */
    protected Rectangle2D a(q var1_1, y var2_2, boolean var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:420)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:219)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:619)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:45)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:681)
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
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Map x() {
        boolean bl2 = a.i;
        at at2 = new at(this.n());
        ah ah2 = this.S;
        J j2 = this.v;
        v v2 = this.o();
        try {
            Object object;
            E e2;
            block4 : {
                F f2 = new F(this, at2);
                f2.e = j2.e;
                f2.d = j2.d;
                f2.c = j2.c;
                this.v = f2;
                super.a(this.v);
                super.a(this.v);
                super.a(this.v);
                this.S = f2;
                y y2 = this.u.c(this.u.b());
                for (object = y2.l(); object != null; object = object.b()) {
                    q q2 = (q)object.c();
                    e2 = this;
                    if (!bl2) {
                        y y3;
                        if (!e2.u.d(q2) || (y3 = this.u.b(q2)).size() <= 0) continue;
                        f2.b = this.M.b(q2);
                        this.a(q2, y3, true);
                        if (!bl2) continue;
                    }
                    break block4;
                }
                f2.b = null;
                e2 = this;
            }
            e2.a(this.u.b(), this.u.b(this.u.b()), true);
            at2.a((Object)null);
            object = at2.a();
            Object var11_11 = null;
            this.S = ah2;
            this.v = j2;
            super.a(this.v);
            super.a(this.v);
            super.a(this.v);
            this.a(v2);
            return object;
        }
        catch (Throwable var10_13) {
            Object var11_12 = null;
            this.S = ah2;
            this.v = j2;
            super.a(this.v);
            super.a(this.v);
            super.a(this.v);
            this.a(v2);
            throw var10_13;
        }
    }

    private static final void a(y.c.h h2, Object object, Object object2, y.c.c c2, Object object3) {
        if (h2 == null) return;
        if (c2 == null) return;
        Object object4 = c2.b(object3);
        if (object4 == null) return;
        h2.a(object, y.g.am.a(object2, object4));
    }

    private static final void a(y.c.h h2, Object object, y.c.c c2, Object object2) {
        if (h2 == null) return;
        if (c2 == null) return;
        Object object3 = c2.b(object2);
        if (object3 == null) return;
        h2.a(object, object3);
    }

    @Override
    public void c(X x2) {
        super.c(x2);
    }

    private void a(d d2, double d3, double d4) {
        y.f.c.I i2 = (y.f.c.I)this.y.b(d2);
        i2.c.x = d3;
        i2.c.y = d4;
    }

    private void b(d d2, double d3, double d4) {
        y.f.c.I i2 = (y.f.c.I)this.y.b(d2);
        i2.d.x = d3;
        i2.d.y = d4;
    }

    private List a(d d2) {
        y.f.c.I i2 = (y.f.c.I)this.y.b(d2);
        if (i2.a != null) return i2.a;
        i2.a = new ArrayList();
        return i2.a;
    }

    private List b(d d2) {
        y.f.c.I i2 = (y.f.c.I)this.y.b(d2);
        if (i2.b != null) return i2.b;
        i2.b = new ArrayList();
        return i2.b;
    }

    @Override
    public void a(Q q2) {
        this.v.d = q2;
        super.a(this.v);
    }

    @Override
    public void a(R r2) {
        this.v.c = r2;
        super.a(this.v);
    }

    @Override
    public R a() {
        return this.v.c;
    }

    @Override
    public Q n() {
        return this.v.d;
    }

    @Override
    public void a(v v2) {
        this.v.e = v2;
        super.a(this.v);
    }

    @Override
    public v o() {
        return this.v.e;
    }

    @Override
    public void b(byte by2) {
        super.b(by2);
        if (this.v == null) return;
        this.a(super.o());
    }

    @Override
    public void c(byte by2) {
        super.c(by2);
        if (this.v == null) return;
        this.a(super.a());
    }

    void d(X x2) {
        super.a(x2);
    }

    @Override
    protected y[] a(X x2, A a2, int n2) {
        E e2;
        boolean bl2 = a.i;
        if (this.z != null) {
            x x3 = x2.o();
            while (x3.f()) {
                Rectangle2D rectangle2D;
                q q2 = x3.e();
                e2 = this;
                if (bl2) return super.a(x2, a2, n2);
                G g2 = (G)e2.z.b(q2);
                if (g2 != null && (rectangle2D = g2.a) != null) {
                    this.x.b(q2, rectangle2D.getWidth(), rectangle2D.getHeight());
                }
                x3.g();
                if (!bl2) continue;
            }
        }
        e2 = this;
        return super.a(x2, a2, n2);
    }

    public boolean p() {
        return this.U;
    }

    static X a(E e2) {
        return e2.x;
    }
}

