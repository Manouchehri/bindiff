/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import y.c.A;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.I;
import y.f.X;
import y.f.c.W;
import y.f.c.a;
import y.f.c.aH;
import y.f.c.ad;
import y.g.M;

public class V
extends a {
    private int[] o;
    private int[] p;
    private int[] q;
    private boolean[] r;
    private int[] s;
    private int[] t;
    private double[][] u;
    private double[] v;
    private int[] w;
    private boolean[] x;
    private double[] y;
    private double[] z;
    private double[] A;
    private double[] B;

    @Override
    protected void a(y[] arry, c c2) {
        X x2 = this.g;
        this.a(x2, arry);
        this.a((i)x2, arry);
        V.a(arry, M.b(this.r), this.e, this.o);
        this.a((i)x2, this.u[0]);
        this.b(x2, arry);
        this.a(x2, this.u[0], arry);
        this.b(arry);
        this.a((i)x2, this.u[1]);
        this.b(x2, arry);
        this.a(x2, this.u[1], arry);
        this.b(arry);
        this.a(this.u[1]);
        this.c(arry);
        this.a((i)x2, this.u[2]);
        this.b(x2, arry);
        this.a(x2, this.u[2], arry);
        this.b(arry);
        this.a((i)x2, this.u[3]);
        this.b(x2, arry);
        this.a(x2, this.u[3], arry);
        this.b(arry);
        this.a(this.u[3]);
        this.c(arry);
        this.a(x2);
    }

    void a(double[] arrd) {
        boolean bl2 = a.i;
        int n2 = 0;
        do {
            if (n2 >= arrd.length) return;
            arrd[n2] = - arrd[n2];
            ++n2;
        } while (!bl2);
    }

    void b(y[] arry) {
        Object object;
        boolean bl2;
        Object object2;
        block16 : {
            int n2;
            V v2;
            block15 : {
                bl2 = a.i;
                for (n2 = 0; n2 < arry.length; ++n2) {
                    y y2 = arry[n2];
                    y2.n();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block15;
                }
                n2 = 0;
            }
            while (n2 < arry.length) {
                int n3 = 0;
                object2 = null;
                object = arry[n2].a();
                while (object.f()) {
                    q q2 = object.e();
                    int n4 = q2.d();
                    this.o[n4] = n3++;
                    v2 = this;
                    if (!bl2) {
                        d d2;
                        d d3;
                        d d4;
                        v2.p[n4] = object2 != null ? object2.d() : -1;
                        this.q[n4] = -1;
                        if (object2 != null) {
                            this.q[object2.d()] = n4;
                            this.B[object2.d()] = this.B[n4];
                        }
                        object2 = q2;
                        int n5 = q2.b();
                        if (n5 > 1) {
                            d3 = q2.i();
                            d2 = q2.g();
                            while (n5 > 1) {
                                d4 = d2;
                                d2 = d2.h();
                                this.g.a(d4, d4.g(), d3, 1, 0);
                                --n5;
                                if (!bl2) {
                                    if (!bl2) continue;
                                }
                                break;
                            }
                        } else {
                            n5 = q2.c();
                        }
                        if (n5 > 1) {
                            d3 = q2.h();
                            d2 = q2.f();
                            while (n5 > 1) {
                                d4 = d2;
                                d2 = d2.g();
                                this.g.a(d4, d3, d4.h(), 0, 1);
                                --n5;
                                if (!bl2) {
                                    if (!bl2) continue;
                                }
                                break;
                            }
                        } else {
                            object.g();
                        }
                        if (!bl2) continue;
                    }
                    break block16;
                }
                ++n2;
                if (!bl2) continue;
            }
            v2 = this;
        }
        e e2 = v2.g.p();
        do {
            if (!e2.f()) return;
            d d5 = e2.a();
            object2 = this.g.n(d5);
            this.g.a(d5, new t(- object2.a(), object2.b()));
            object = this.g.o(d5);
            this.g.b(d5, new t(- object.a(), object.b()));
            e2.g();
        } while (!bl2);
    }

    void c(y[] arry) {
        Object object;
        boolean bl2 = a.i;
        Object object2 = this.g.p();
        while (object2.f()) {
            d d2 = object2.a();
            this.g.c(d2);
            object = this.g.n(d2);
            t t2 = this.g.o(d2);
            this.g.b(d2, (t)object);
            this.g.a(d2, t2);
            object2.g();
            if (!bl2) continue;
        }
        object2 = new D(arry);
        for (int i2 = 0; i2 < arry.length; ++i2) {
            arry[i2] = (y)object2.j();
            if (!bl2) continue;
        }
        aH aH2 = new aH(this.o, 6);
        object = new aH(this.o, 5);
        this.g.a(aH2, (Comparator)object);
    }

    protected void a(i i2, y[] arry) {
        boolean bl2 = a.i;
        int n2 = i2.f();
        int n3 = i2.h();
        this.o = new int[n2];
        this.p = new int[n2];
        this.q = new int[n2];
        this.s = new int[n2];
        this.t = new int[n2];
        this.w = new int[n2];
        this.A = new double[n2];
        this.B = new double[n2];
        this.u = new double[4][n2];
        this.v = new double[n2];
        this.y = new double[n2];
        this.z = new double[n2];
        this.x = new boolean[n2];
        this.r = new boolean[n3];
        int n4 = 0;
        while (n4 < arry.length) {
            block4 : {
                int n5 = 0;
                q q2 = null;
                x x2 = arry[n4].a();
                while (x2.f()) {
                    q q3 = x2.e();
                    int n6 = q3.d();
                    this.o[n6] = n5++;
                    if (!bl2) {
                        this.p[n6] = q2 != null ? q2.d() : -1;
                        this.q[n6] = -1;
                        if (q2 != null) {
                            this.q[q2.d()] = n6;
                            this.B[q2.d()] = this.g(q2);
                        }
                        this.A[n6] = this.g.p(q3);
                        q2 = q3;
                        x2.g();
                        if (!bl2) continue;
                    }
                    break block4;
                }
                ++n4;
            }
            if (!bl2) continue;
        }
        ad ad2 = new ad(this.o, true);
        ad ad3 = new ad(this.o, false);
        i2.a(ad2, ad3);
    }

    protected void a(i i2, double[] arrd) {
        boolean bl2 = a.i;
        x x2 = i2.o();
        do {
            int n2;
            if (!x2.f()) return;
            q q2 = x2.e();
            this.s[n2] = n2 = q2.d();
            this.t[n2] = n2;
            arrd[n2] = Double.MAX_VALUE;
            this.w[n2] = n2;
            this.v[n2] = Double.MAX_VALUE;
            this.x[n2] = false;
            this.y[n2] = 0.0;
            this.z[n2] = 0.0;
            x2.g();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    public static void a(y[] var0, h var1_1, A var2_2, int[] var3_3) {
        var19_4 = a.i;
        var4_5 = var0.length;
        var5_6 = 2;
        do {
            v0 = var5_6;
            v1 = var4_5 - 1;
            block1 : do {
                if (v0 >= v1) return;
                var6_7 = -1;
                var7_8 = 0;
                var8_9 = 0;
                var9_10 = var0[var5_6].a();
                var10_11 = var0[var5_6].a();
                while (var10_11.f()) {
                    block12 : {
                        var11_12 = var10_11.e();
                        var12_13 = null;
                        var13_14 = false;
                        v0 = var11_12.b();
                        v1 = 1;
                        if (var19_4) continue block1;
                        if (v0 != v1) ** GOTO lbl27
                        var12_13 = var11_12.g().c();
                        v2 = var2_2.b(var12_13);
                        block3 : do {
                            if (v2 != null && var2_2.b(var11_12) != null) {
                                var13_14 = true;
                            }
lbl27: // 4 sources:
                            if (var8_9 == var0[var5_6].size() - 1) ** GOTO lbl-1000
                            if (var13_14) {
                                ** if (!var13_14) goto lbl-1000
                            }
                            break block12;
lbl-1000: // 2 sources:
                            {
                                v3 = var3_3[var12_13.d()];
                                ** GOTO lbl34
                            }
lbl-1000: // 1 sources:
                            {
                                v3 = var0[var5_6 - 1].size();
                            }
lbl34: // 2 sources:
                            var14_15 = v3;
                            block4 : do {
                                v4 = var7_8;
                                v5 = var8_9;
                                block5 : while (v4 <= v5) {
                                    var15_16 = var9_10.e();
                                    v2 = var15_16.k();
                                    if (var19_4) continue block3;
                                    var16_17 = v2;
                                    while (var16_17.f()) {
                                        var17_18 = var16_17.a();
                                        v4 = var18_19 = var3_3[var17_18.c().d()];
                                        v5 = var6_7;
                                        if (var19_4) continue block5;
                                        if (v4 < v5 || var18_19 > var14_15) {
                                            var1_1.a((Object)var16_17.a(), true);
                                        }
                                        var16_17.g();
                                        if (!var19_4) continue;
                                    }
                                    var9_10.g();
                                    ++var7_8;
                                    if (!var19_4) continue block4;
                                }
                                break block3;
                                break;
                            } while (true);
                            break;
                        } while (true);
                        var6_7 = var14_15;
                    }
                    ++var8_9;
                    var10_11.g();
                    if (!var19_4) continue;
                }
                break block1;
                break;
            } while (true);
            ++var5_6;
        } while (!var19_4);
    }

    /*
     * Unable to fully structure code
     */
    public void b(X var1_1, y[] var2_2) {
        var17_3 = a.i;
        var3_4 = 1;
        do {
            v0 = var3_4;
            block1 : do lbl-1000: // 3 sources:
            {
                if (v0 >= var2_2.length) return;
                var4_5 = -1;
                var5_6 = var2_2[var3_4].k();
                while (var5_6 != null) {
                    block8 : {
                        var6_7 = (q)var5_6.c();
                        var7_8 = var6_7.d();
                        v0 = var8_9 = var6_7.b();
                        if (var17_3) ** GOTO lbl-1000
                        if (v0 != 0) {
                            var9_10 = (int)Math.floor(((double)var8_9 + 1.0) / 2.0);
                            var10_11 = (int)Math.ceil(((double)var8_9 + 1.0) / 2.0);
                            var12_13 = var6_7.g();
                            for (var11_12 = 1; var11_12 < var9_10; ++var11_12, var12_13 = var12_13.h()) {
                                if (!var17_3) {
                                    if (!var17_3) continue;
                                }
                                break block8;
                            }
                            var13_14 = 0;
                            while (var11_12 <= var10_11) {
                                v0 = var13_14;
                                if (var17_3) continue block1;
                                if (v0 != 0) break;
                                var14_15 = this.g.g(var12_13);
                                var15_16 = var12_13.c();
                                var16_17 = var15_16.d();
                                if (this.t[var7_8] == var6_7.d() && !this.r[var12_13.b()] && var4_5 < this.o[var16_17]) {
                                    var4_5 = this.o[var16_17];
                                    this.t[var16_17] = var6_7.d();
                                    this.s[var7_8] = this.s[var16_17];
                                    this.t[var7_8] = this.s[var7_8];
                                    var13_14 = 1;
                                    this.z[var16_17] = var14_15.getSourcePoint().a();
                                    this.y[var7_8] = var14_15.getTargetPoint().a();
                                }
                                var12_13 = var12_13.h();
                                ++var11_12;
                                if (!var17_3) continue;
                            }
                        }
                        var5_6 = var5_6.a();
                    }
                    if (!var17_3) continue;
                }
                break block1;
                break;
            } while (true);
            ++var3_4;
        } while (!var17_3);
    }

    /*
     * Unable to fully structure code
     */
    protected void a(X var1_1, double[] var2_2, y[] var3_3) {
        block7 : {
            var9_4 = a.i;
            for (var4_5 = var3_3.length - 1; var4_5 >= 0; --var4_5) {
                v0 = var5_7 = var3_3[var4_5];
                if (var9_4) ** GOTO lbl21
                for (var6_8 = (v989889).k(); var6_8 != null; var6_8 = var6_8.a()) {
                    var7_11 = ((q)var6_8.c()).d();
                    v1 = this.s[var7_11];
                    v2 = var7_11;
                    if (!var9_4) {
                        if (v1 != v2 || var2_2[var7_11] != Double.MAX_VALUE) continue;
                        this.a(var7_11, var2_2);
                        if (!var9_4) continue;
                    }
                    ** GOTO lbl19
                }
                if (!var9_4) continue;
            }
            var4_5 = 0;
            do {
                v1 = var4_5;
                v2 = var3_3.length;
lbl19: // 2 sources:
                if (v1 >= v2) break;
                v0 = var3_3[var4_5];
lbl21: // 2 sources:
                v3 = var5_7 = v0.a();
                if (var9_4) break block7;
                if (v3.f() && this.w[this.s[var7_11 = (var6_8 = var3_3[var4_5].a().e()).d()]] == var7_11 && !this.x[var7_11]) {
                    this.x[var7_11] = true;
                    this.b(var7_11, var2_2);
                }
                ++var4_5;
            } while (!var9_4);
            v3 = var1_1.o();
        }
        var4_6 = v3;
        do {
            if (var4_6.f() == false) return;
            var5_7 = var4_6.e();
            var6_10 = var5_7.d();
            var7_12 = this.v[this.w[this.s[var6_10]]];
            if (var7_12 < Double.MAX_VALUE) {
                v4 = var2_2;
                v5 = var6_10;
                v4[v5] = v4[v5] + var7_12;
            }
            var4_6.g();
        } while (!var9_4);
    }

    /*
     * Unable to fully structure code
     */
    private void a(int var1_1, double[] var2_2) {
        var10_3 = a.i;
        var3_4 = new ArrayList<Object>(50);
        var3_4.add(new y.f.c.X(var1_1));
        do lbl-1000: // 6 sources:
        {
            if (var3_4.isEmpty() != false) return;
            var4_5 = (y.f.c.X)var3_4.get(var3_4.size() - 1);
            switch (var4_5.b) {
                default: {
                    var3_4.remove(var3_4.size() - 1);
                    if (!var10_3) ** GOTO lbl-1000
                }
                case 0: {
                    var2_2[var4_5.a] = 0.0;
                    var4_5.d = 0.0;
                    var4_5.e = true;
                    var4_5.c = var4_5.a;
                    var4_5.b = 1;
                }
                case 1: {
                    if (var4_5.c != var4_5.a) {
                        var4_5.d -= this.y[var4_5.c];
                    }
                    if (this.o[var4_5.c] <= 0) ** GOTO lbl23
                    var4_5.b = 2;
                    if (!var10_3) ** GOTO lbl25
lbl23: // 2 sources:
                    var4_5.b = 4;
                    if (!var10_3) ** GOTO lbl-1000
                }
lbl25: // 3 sources:
                case 2: {
                    var4_5.f = this.p[var4_5.c];
                    var4_5.g = this.s[var4_5.f];
                    if (var2_2[var4_5.g] != Double.MAX_VALUE) ** GOTO lbl33
                    var5_6 = new y.f.c.X(var4_5.g);
                    var3_4.add(var5_6);
                    var4_5.b = 3;
                    if (!var10_3) ** GOTO lbl-1000
lbl33: // 2 sources:
                    var4_5.b = 3;
                }
                case 3: {
                    var5_7 = var4_5.g;
                    var6_8 = var4_5.a;
                    var7_10 = var4_5.f;
                    if (this.w[var6_8] == var6_8) {
                        this.w[var6_8] = this.w[var5_7];
                    }
                    if (this.w[var6_8] != this.w[var5_7]) ** GOTO lbl47
                    var8_11 = var2_2[var7_10] + 0.5 * (this.A[var7_10] + this.A[var4_5.c]) + this.B[var7_10] - var4_5.d;
                    if (!var4_5.e) ** GOTO lbl-1000
                    var2_2[var6_8] = var8_11;
                    var4_5.e = false;
                    if (var10_3) lbl-1000: // 2 sources:
                    {
                        var2_2[var6_8] = Math.max(var2_2[var6_8], var8_11);
                    }
lbl47: // 4 sources:
                    var4_5.b = 4;
                }
                case 4: {
                    var4_5.d += this.z[var4_5.c];
                    var4_5.c = this.t[var4_5.c];
                    if (var4_5.c == var4_5.a) ** GOTO lbl54
                    var4_5.b = 1;
                    if (!var10_3) ** GOTO lbl-1000
lbl54: // 2 sources:
                    var4_5.b = 5;
                }
                case 5: 
            }
            var5_6 = var4_5.a;
            var6_9 = 0.0;
            var8_12 = var5_6;
            block9 : do {
                if (var8_12 != var5_6) {
                    var6_9 -= this.y[var8_12];
                }
                var2_2[var8_12] = var2_2[var5_6] + var6_9;
                var6_9 += this.z[var8_12];
                var8_12 = this.t[var8_12];
                do {
                    if (var8_12 != var5_6) continue block9;
                    var4_5.b = -1;
                    var3_4.remove(var3_4.size() - 1);
                } while (var10_3);
                break;
            } while (true);
        } while (!var10_3);
    }

    /*
     * Unable to fully structure code
     */
    private void b(int var1_1, double[] var2_2) {
        var11_3 = a.i;
        var3_4 = new ArrayList<W>();
        var3_4.add(new W(var1_1));
        do lbl-1000: // 5 sources:
        {
            if (var3_4.size() <= 0) return;
            var4_5 = (W)var3_4.get(var3_4.size() - 1);
            var5_6 = var4_5.b;
            var6_7 = var4_5.a;
            var4_5.b = this.t[var5_6];
            if (var4_5.b == var6_7) {
                var3_4.remove(var3_4.size() - 1);
            }
            if ((var7_8 = this.q[var5_6]) < 0) ** GOTO lbl-1000
            var8_9 = this.w[this.s[var7_8]];
            if (var8_9 == this.w[var6_7]) ** GOTO lbl20
            var9_10 = var2_2[var7_8] - var2_2[var6_7] - this.B[var5_6] - 0.5 * (this.A[var5_6] + this.A[var7_8]);
            if (this.v[var8_9] != Double.MAX_VALUE) {
                var9_10 += this.v[var8_9];
            }
            this.v[this.w[var6_7]] = Math.min(this.v[this.w[var6_7]], var9_10);
            if (!var11_3) ** GOTO lbl-1000
lbl20: // 2 sources:
            if (this.x[var9_11 = this.s[var7_8]]) ** GOTO lbl-1000
            this.x[var9_11] = true;
            var10_12 = new W(var9_11);
            var3_4.add(var10_12);
        } while (!var11_3);
    }

    protected void a(X x2) {
        boolean bl2;
        double[] arrd;
        double[] arrd2;
        int n2;
        q q2;
        x x3;
        block3 : {
            bl2 = a.i;
            arrd = new double[4];
            arrd2 = new double[4];
            x3 = x2.o();
            while (x3.f()) {
                q2 = x3.e();
                n2 = q2.d();
                double[] arrd3 = arrd2;
                arrd3[0] = arrd3[0] + this.u[0][n2];
                double[] arrd4 = arrd2;
                arrd4[1] = arrd4[1] + this.u[1][n2];
                double[] arrd5 = arrd2;
                arrd5[2] = arrd5[2] + this.u[2][n2];
                double[] arrd6 = arrd2;
                arrd6[3] = arrd6[3] + this.u[3][n2];
                x3.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            double[] arrd7 = arrd2;
            arrd7[0] = arrd7[0] / (double)x2.e();
            double[] arrd8 = arrd2;
            arrd8[1] = arrd8[1] / (double)x2.e();
            double[] arrd9 = arrd2;
            arrd9[2] = arrd9[2] / (double)x2.e();
            double[] arrd10 = arrd2;
            arrd10[3] = arrd10[3] / (double)x2.e();
        }
        x3 = x2.o();
        do {
            if (!x3.f()) return;
            q2 = x3.e();
            n2 = q2.d();
            t t2 = x2.l(q2);
            arrd[0] = this.u[0][n2] - arrd2[0];
            arrd[1] = this.u[1][n2] - arrd2[1];
            arrd[2] = this.u[2][n2] - arrd2[2];
            arrd[3] = this.u[3][n2] - arrd2[3];
            Arrays.sort(arrd);
            double d2 = (arrd[1] + arrd[2]) / 2.0;
            x2.a(q2, new t(d2, t2.b()));
            x3.g();
        } while (!bl2);
    }

    @Override
    protected void e() {
        super.e();
        this.o = null;
        this.p = null;
        this.A = null;
        this.B = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.y = null;
    }
}

