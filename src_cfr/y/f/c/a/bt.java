/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import y.a.a;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bK;
import y.f.c.a.bR;
import y.f.c.a.bU;
import y.f.c.a.bV;
import y.f.c.a.bW;
import y.f.c.a.bx;
import y.f.c.a.cF;
import y.f.c.a.cX;
import y.g.ar;
import y.g.e;

class bT
implements bx {
    private int e = 250;
    private boolean f = true;
    private Comparator g;
    private long h = 10000;
    private byte i = 0;
    private float[] j;
    private float[] k;
    private q[] l;
    private int[] m;
    private int[] n;
    private p[] o;
    private D p;
    private D q;
    private D r;
    private D s;
    private byte[] t;
    private byte[] u;
    private int[] v;
    private int[] w;
    private Comparator x;
    private Comparator y;
    private Comparator z;
    private Comparator A;
    private Comparator B;
    private Comparator C;
    private X D;
    private D[] E;
    private int[] F;
    private int[] G;
    private q[][] H;
    private q[][] I;
    private int J = 0;
    private int K = 0;
    private int L = 0;
    int[] a;
    int[] b;
    Comparator c;
    private bR M;
    private Comparator N;
    private E O;
    final int[] d = new int[4];

    bT() {
    }

    void a(Map map) {
        Object v2 = map.get("SubgraphLayerSequencer.weightHeuristic");
        if (v2 instanceof Number) {
            this.a(((Number)v2).byteValue());
        }
        if ((v2 = map.get("SubgraphLayerSequencer.maximalDuration")) instanceof Number) {
            this.a(((Number)v2).longValue());
        }
        if ((v2 = map.get("SubgraphLayerSequencer.transpositionEnabled")) instanceof Boolean) {
            this.a((Boolean)v2);
        }
        if (!((v2 = map.get("SubgraphLayerSequencer.randomizationRounds")) instanceof Number)) return;
        this.a(((Number)v2).intValue());
    }

    public void a(boolean bl2) {
        this.f = bl2;
    }

    public void a(byte by2) {
        if (by2 != 0 && by2 != 1) {
            throw new IllegalArgumentException();
        }
        this.i = by2;
    }

    public void a(int n2) {
        this.e = n2;
    }

    public void a(long l2) {
        this.h = l2;
    }

    private cF a(X x2, aU aU2, aV aV2, int[] arrn, int[] arrn2) {
        this.t = new byte[x2.h()];
        Arrays.fill(this.t, -2);
        this.v = new int[x2.h()];
        this.u = new byte[x2.h()];
        Arrays.fill(this.u, -2);
        this.w = new int[x2.h()];
        return cF.a(x2, aU2, aV2, arrn2, arrn, this.t, this.v, this.u, this.w, 1, 0);
    }

    private void a(i i2, ar ar2) {
        boolean bl2 = N.x;
        x x2 = i2.o();
        while (x2.f()) {
            this.j[x2.e().d()] = ar2.nextInt();
            x2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        i2.a(new bU(this), new bV(this));
    }

    private int a() {
        int n2;
        boolean bl2 = N.x;
        this.a((i)this.D, this.B, this.C);
        int n3 = 0;
        for (int i2 = this.E.length - 1; i2 > 0; --i2) {
            n2 = this.L;
            if (bl2) return n2;
            if (n2 != 0 && this.H[i2] == null && this.H[i2 - 1] == null) continue;
            n3 += this.a(this.E[i2 - 1], this.E[i2]);
            if (!bl2) continue;
        }
        n2 = n3;
        return n2;
    }

    /*
     * Unable to fully structure code
     */
    private int a(D var1_1, D var2_2) {
        block4 : {
            var6_3 = N.x;
            var4_5 = var2_2.k();
            this.p.clear();
            this.q.clear();
            this.r.clear();
            this.s.clear();
            var5_6 = 0;
            for (var3_4 = var1_1.k(); var3_4 != null; var5_6 += this.b((q)((q)var4_5.c()), (D)this.q, (D)this.s, (D)this.p), var3_4 = var3_4.a(), var4_5 = var4_5.a()) {
                v0 = var4_5;
                if (!var6_3) {
                    if (v0 == null) break;
                    var5_6 += this.a((q)var3_4.c(), this.p, this.r, this.q);
                    if (!var6_3) continue;
                }
                ** GOTO lbl17
            }
            do {
                v0 = var3_4;
lbl17: // 2 sources:
                if (v0 == null) break;
                var5_6 += this.a((q)var3_4.c(), this.p, this.r, this.q);
                var3_4 = var3_4.a();
                if (var6_3) break block4;
            } while (!var6_3);
            while (var4_5 != null) {
                v1 = var5_6 + this.b((q)var4_5.c(), this.q, this.s, this.p);
                if (var6_3 != false) return v1;
                var5_6 = v1;
                var4_5 = var4_5.a();
                if (!var6_3) continue;
            }
        }
        v1 = var5_6;
        return v1;
    }

    /*
     * Unable to fully structure code
     */
    private int a(q var1_1, D var2_2, D var3_3, D var4_4) {
        var14_5 = N.x;
        var5_6 = this.G[var1_1.d()];
        this.d[3] = 0;
        this.d[2] = 0;
        this.d[1] = 0;
        this.d[0] = 0;
        var6_7 = 0;
        var7_8 = var1_1.f();
        block5 : do {
            if (var7_8 == null) return var6_7;
            var8_9 = var7_8.b();
            var9_10 = this.o[var8_9];
            if (var9_10.c() != null) ** GOTO lbl27
            if (this.F[var7_8.d().d()] >= 0) ** GOTO lbl-1000
            var10_11 = var7_8.h() == null ? var7_8.j() : var7_8.h();
            var11_13 = this.o[var10_11.b()];
            var3_3.a(var11_13);
            var11_13.a(var10_11);
            if (var14_5) lbl-1000: // 2 sources:
            {
                var6_7 += var3_3.size();
                var4_4.a(var9_10);
                var9_10.a(var7_8);
            }
            v0 = this.d;
            v1 = this.t[var8_9] + 2;
            v0[v1] = v0[v1] + 1;
            if (!var14_5) ** GOTO lbl70
lbl27: // 2 sources:
            if (this.F[var7_8.d().d()] >= 0) ** GOTO lbl33
            var3_3.h(var9_10);
            var9_10.a(null);
            block6 : for (var10_11 = var9_10.a(); var10_11 != null; ++var6_7, var10_11 = var10_11.a()) {
                block14 : {
                    if (var14_5) continue block5;
                    if (!var14_5) continue;
lbl33: // 2 sources:
                    var2_2.h(var9_10);
                    var9_10.a(null);
                    var10_12 = this.v[var8_9];
                    if (var10_12 > 0) {
                        block13 : {
                            for (var11_13 = var9_10.b(); var11_13 != null; ++var6_7, var11_13 = var11_13.b()) {
                                if (!var14_5) {
                                    if (!var14_5) continue;
                                }
                                break block13;
                            }
                            var6_7 += var4_4.size();
                            var6_7 += var3_3.size();
                        }
                        if (!var14_5) break;
                    }
                    var11_14 = this.t[var8_9];
                    for (var12_15 = var9_10.b(); var12_15 != null; var12_15 = var12_15.b()) {
                        var13_16 = (d)var12_15.c();
                        v2 = this.G[var13_16.c().d()];
                        v3 = var5_6;
                        if (!var14_5) {
                            if (v2 <= v3 && (var11_14 == -2 || this.t[var13_16.b()] <= var11_14)) continue;
                            ++var6_7;
                            if (!var14_5) continue;
                        }
                        break block14;
                    }
                    v2 = var6_7;
                    v3 = var4_4.size() + var3_3.size();
                }
                var6_7 = v2 + v3;
                switch (var11_14) {
                    case -1: {
                        var6_7 -= this.d[1];
                        if (!var14_5) break block6;
                    }
                    case 0: {
                        var6_7 -= this.d[2];
                        if (!var14_5) break block6;
                    }
                    case 1: {
                        var6_7 -= this.d[3];
                    }
                    default: {
                        break block6;
                    }
                }
            }
lbl70: // 6 sources:
            var7_8 = var7_8.g();
        } while (!var14_5);
        return var6_7;
    }

    /*
     * Unable to fully structure code
     */
    private int b(q var1_1, D var2_2, D var3_3, D var4_4) {
        var14_5 = N.x;
        var5_6 = this.G[var1_1.d()];
        this.d[3] = 0;
        this.d[2] = 0;
        this.d[1] = 0;
        this.d[0] = 0;
        var6_7 = 0;
        var7_8 = var1_1.g();
        block5 : do {
            if (var7_8 == null) return var6_7;
            var8_9 = var7_8.b();
            var9_10 = this.o[var8_9];
            if (var9_10.c() != null) ** GOTO lbl27
            if (this.F[var7_8.c().d()] >= 0) ** GOTO lbl-1000
            var10_11 = var7_8.g() == null ? var7_8.i() : var7_8.g();
            var11_13 = this.o[var10_11.b()];
            var3_3.a(var11_13);
            var11_13.a(var10_11);
            if (var14_5) lbl-1000: // 2 sources:
            {
                var6_7 += var3_3.size();
                var4_4.a(var9_10);
                var9_10.a(var7_8);
            }
            v0 = this.d;
            v1 = this.u[var8_9] + 2;
            v0[v1] = v0[v1] + 1;
            if (!var14_5) ** GOTO lbl69
lbl27: // 2 sources:
            if (this.F[var7_8.c().d()] >= 0) ** GOTO lbl33
            var3_3.h(var9_10);
            var9_10.a(null);
            block6 : for (var10_11 = var9_10.a(); var10_11 != null; ++var6_7, var10_11 = var10_11.a()) {
                block14 : {
                    if (var14_5) continue block5;
                    if (!var14_5) continue;
lbl33: // 2 sources:
                    var2_2.h(var9_10);
                    var9_10.a(null);
                    var10_12 = this.w[var8_9];
                    if (var10_12 > 0) {
                        block13 : {
                            for (var11_13 = var9_10.b(); var11_13 != null; ++var6_7, var11_13 = var11_13.b()) {
                                if (!var14_5) {
                                    if (!var14_5) continue;
                                }
                                break block13;
                            }
                            var6_7 += var4_4.size() + var3_3.size();
                        }
                        if (!var14_5) break;
                    }
                    var11_14 = this.u[var8_9];
                    for (var12_15 = var9_10.b(); var12_15 != null; var12_15 = var12_15.b()) {
                        var13_16 = (d)var12_15.c();
                        v2 = this.G[var13_16.d().d()];
                        v3 = var5_6;
                        if (!var14_5) {
                            if (v2 <= v3 && (var11_14 == -2 || this.u[var13_16.b()] <= var11_14)) continue;
                            ++var6_7;
                            if (!var14_5) continue;
                        }
                        break block14;
                    }
                    v2 = var6_7;
                    v3 = var4_4.size() + var3_3.size();
                }
                var6_7 = v2 + v3;
                switch (var11_14) {
                    case -1: {
                        var6_7 -= this.d[1];
                        if (!var14_5) break block6;
                    }
                    case 0: {
                        var6_7 -= this.d[2];
                        if (!var14_5) break block6;
                    }
                    case 1: {
                        var6_7 -= this.d[3];
                    }
                    default: {
                        break block6;
                    }
                }
            }
lbl69: // 6 sources:
            var7_8 = var7_8.h();
        } while (!var14_5);
        return var6_7;
    }

    private byte a(int[] arrn) {
        return this.a(0, this.E.length - 1, arrn);
    }

    private byte a(int n2, int n3, int[] arrn) {
        byte by2;
        int n4;
        int n5;
        D d2;
        boolean bl2;
        boolean bl3 = N.x;
        byte by3 = 0;
        if (n2 <= n3) {
            bl2 = true;
            n5 = 20;
            block0 : do {
                if (!bl2) return by3;
                if (--n5 <= 0) return by3;
                bl2 = false;
                n4 = n2;
                do {
                    if (n4 > n3) continue block0;
                    if (this.H[n4] != null) {
                        d2 = this.E[n4];
                        this.a(d2, this.A, this.z);
                        by2 = this.a(n4, d2, true, true, arrn);
                        bl2 = (by2 & 4) != 0;
                        by3 = (byte)(by3 | by2);
                    }
                    ++n4;
                } while (!bl3);
                break;
            } while (true);
        }
        bl2 = true;
        n5 = 20;
        block2 : do {
            if (!bl2) return by3;
            if (--n5 <= 0) return by3;
            bl2 = false;
            n4 = n2;
            do {
                if (n4 < n3) continue block2;
                if (this.H[n4] != null) {
                    d2 = this.E[n4];
                    this.a(d2, this.A, this.z);
                    by2 = this.a(n4, d2, true, true, arrn);
                    bl2 = (by2 & 4) != 0;
                    by3 = (byte)(by3 | by2);
                }
                --n4;
            } while (!bl3);
            break;
        } while (true);
        return by3;
    }

    private byte a(int n2, D d2, boolean bl2, boolean bl3, int[] arrn) {
        if (this.L > 0 && this.H[n2] == null) {
            return 0;
        }
        byte by2 = this.a(d2, bl2, bl3, arrn);
        byte by3 = this.b(d2, bl2, bl3, arrn);
        return (byte)(by2 | by3);
    }

    private byte a(D d2, boolean bl2, boolean bl3, int[] arrn) {
        boolean bl4;
        boolean bl5;
        int n2;
        int n3;
        block11 : {
            boolean bl6 = N.x;
            int n4 = 0;
            bl5 = false;
            bl4 = false;
            p p2 = d2.k();
            for (int i2 = 0; i2 < d2.size() - 1; ++i2) {
                p p3 = p2;
                p2 = p3.a();
                q q2 = (q)p3.c();
                q q3 = (q)p2.c();
                n3 = this.L;
                if (!bl6) {
                    int n5;
                    int n6;
                    int n7;
                    if (n3 > 0 && !this.a(q2) && !this.a(q3)) continue;
                    if (this.M != null) {
                        if (this.M.a((i)this.D, q2, q3)) {
                            continue;
                        }
                    } else if (this.a != null) {
                        n5 = this.a[q2.d()];
                        n7 = this.a[q3.d()];
                        if (n5 >= 0 && n7 >= 0 && n5 != n7) continue;
                    }
                    n5 = 0;
                    n7 = 0;
                    if (bl2) {
                        n5 = this.d(q2, q3, arrn);
                        if (bl3 || n5 > 0) {
                            n7 = this.d(q3, q2, arrn);
                        }
                    }
                    if (bl3 && (bl2 || (n5 += this.c(q2, q3, arrn)) > 0)) {
                        n7 += this.c(q3, q2, arrn);
                    }
                    if (n5 < n7) continue;
                    if (n5 > n7) {
                        n4 = 1;
                        n6 = arrn[q2.d()];
                        arrn[q2.d()] = arrn[q3.d()];
                        arrn[q3.d()] = n6;
                        p2.a(q2);
                        p3.a(q3);
                        bl5 |= q2.c() > 0 || q3.c() > 0;
                        bl4 |= q2.b() > 0 || q3.b() > 0;
                        this.a(q2, bl2 ? this.A : null, bl3 ? this.z : null, true);
                        this.a(q3, bl2 ? this.A : null, bl3 ? this.z : null, false);
                        if (!bl6) continue;
                    }
                    n6 = this.a(q2, q3, true, true, arrn);
                    int n8 = this.a(q3, q2, true, true, arrn);
                    if (n8 >= n6) continue;
                    int n9 = arrn[q2.d()];
                    arrn[q2.d()] = arrn[q3.d()];
                    arrn[q3.d()] = n9;
                    p2.a(q2);
                    p3.a(q3);
                    bl5 |= q2.c() > 0 || q3.c() > 0;
                    bl4 |= q2.b() > 0 || q3.b() > 0;
                    this.a(q2, bl2 ? this.A : null, bl3 ? this.z : null, true);
                    this.a(q3, bl2 ? this.A : null, bl3 ? this.z : null, false);
                    if (!bl6) continue;
                }
                break block11;
            }
            n3 = n4;
        }
        int n10 = n3 != 0 ? 4 : 0;
        int n11 = bl4 ? 2 : 0;
        if (bl5) {
            n2 = 1;
            return (byte)(n10 | n11 | n2);
        }
        n2 = 0;
        return (byte)(n10 | n11 | n2);
    }

    private byte b(D d2, boolean bl2, boolean bl3, int[] arrn) {
        boolean bl4;
        boolean bl5;
        int n2;
        int n3;
        block11 : {
            boolean bl6 = N.x;
            int n4 = 0;
            bl5 = false;
            bl4 = false;
            p p2 = d2.l();
            for (int i2 = d2.size() - 2; i2 >= 0; --i2) {
                p p3 = p2;
                p2 = p2.b();
                q q2 = (q)p2.c();
                q q3 = (q)p3.c();
                n3 = this.L;
                if (!bl6) {
                    int n5;
                    int n6;
                    int n7;
                    if (n3 > 0 && !this.a(q2) && !this.a(q3)) continue;
                    if (this.M != null) {
                        if (this.M.a((i)this.D, q2, q3)) {
                            continue;
                        }
                    } else if (this.a != null) {
                        n5 = this.a[q2.d()];
                        n7 = this.a[q3.d()];
                        if (n5 >= 0 && n7 >= 0 && n5 != n7) continue;
                    }
                    n5 = 0;
                    n7 = 0;
                    if (bl2) {
                        n5 = this.d(q2, q3, arrn);
                        if (bl3 || n5 > 0) {
                            n7 = this.d(q3, q2, arrn);
                        }
                    }
                    if (bl3 && (bl2 || (n5 += this.c(q2, q3, arrn)) > 0)) {
                        n7 += this.c(q3, q2, arrn);
                    }
                    if (n5 < n7) continue;
                    if (n5 > n7) {
                        n4 = 1;
                        n6 = arrn[q2.d()];
                        arrn[q2.d()] = arrn[q3.d()];
                        arrn[q3.d()] = n6;
                        p3.a(q2);
                        p2.a(q3);
                        bl5 |= q2.c() > 0 || q3.c() > 0;
                        bl4 |= q2.b() > 0 || q3.b() > 0;
                        this.a(q2, bl2 ? this.A : null, bl3 ? this.z : null, true);
                        this.a(q3, bl2 ? this.A : null, bl3 ? this.z : null, false);
                        if (!bl6) continue;
                    }
                    n6 = this.a(q2, q3, true, true, arrn);
                    int n8 = this.a(q3, q2, true, true, arrn);
                    if (n8 >= n6 && (n8 != n6 || !bl2 || !bl3)) continue;
                    int n9 = arrn[q2.d()];
                    arrn[q2.d()] = arrn[q3.d()];
                    arrn[q3.d()] = n9;
                    p3.a(q2);
                    p2.a(q3);
                    bl5 |= q2.c() > 0 || q3.c() > 0;
                    bl4 |= q2.b() > 0 || q3.b() > 0;
                    this.a(q2, bl2 ? this.A : null, bl3 ? this.z : null, true);
                    this.a(q3, bl2 ? this.A : null, bl3 ? this.z : null, false);
                    if (!bl6) continue;
                }
                break block11;
            }
            n3 = n4;
        }
        int n10 = n3 != 0 ? 4 : 0;
        int n11 = bl4 ? 2 : 0;
        if (bl5) {
            n2 = 1;
            return (byte)(n10 | n11 | n2);
        }
        n2 = 0;
        return (byte)(n10 | n11 | n2);
    }

    private void a(q q2, Comparator comparator, Comparator comparator2, boolean bl2) {
        d d2;
        d d3;
        d d4;
        boolean bl3 = N.x;
        if (bl2) {
            d d5;
            if (comparator != null && q2.b() > 1) {
                d4 = q2.g();
                d2 = q2.i();
                while (comparator.compare(d4, d2) > 0) {
                    d5 = d2.g();
                    if (!bl3) {
                        block19 : {
                            if (d5 != null) {
                                this.D.a(d2, d2.g(), d4, 1, 1);
                                if (!bl3) break block19;
                            }
                            this.D.a(d2, d2.i(), d4, 0, 1);
                        }
                        d2 = q2.i();
                        if (!bl3) continue;
                    }
                    break;
                }
            } else {
                if (comparator2 == null) return;
                if (q2.c() <= 1) return;
                d4 = q2.f();
                d5 = q2.h();
            }
            d2 = d5;
            do {
                block20 : {
                    if (comparator2.compare(d4, d2) <= 0) return;
                    if (d2.h() != null) {
                        this.D.a(d2, d4, d2.h(), 1, 1);
                        if (!bl3) break block20;
                    }
                    this.D.a(d2, d4, d2.j(), 1, 0);
                }
                d2 = q2.h();
            } while (!bl3);
        }
        if (comparator != null && q2.b() > 1) {
            d4 = q2.i();
            d2 = q2.g();
            while (comparator.compare(d2, d4) > 0) {
                d3 = d2.g();
                if (!bl3) {
                    block21 : {
                        if (d3 != null) {
                            this.D.a(d2, d2.g(), d4, 1, 0);
                            if (!bl3) break block21;
                        }
                        this.D.a(d2, d2.i(), d4, 0, 0);
                    }
                    d2 = q2.g();
                    if (!bl3) continue;
                }
                break;
            }
        } else {
            if (comparator2 == null) return;
            if (q2.c() <= 1) return;
            d4 = q2.h();
            d3 = q2.f();
        }
        d2 = d3;
        do {
            block22 : {
                if (comparator2.compare(d2, d4) <= 0) return;
                if (d2.h() != null) {
                    this.D.a(d2, d4, d2.h(), 0, 1);
                    if (!bl3) break block22;
                }
                this.D.a(d2, d4, d2.j(), 0, 0);
            }
            d2 = q2.f();
        } while (!bl3);
    }

    private int a(q q2, q q3, boolean bl2, boolean bl3, int[] arrn) {
        int n2 = 0;
        if (bl2) {
            n2 = this.a(q2, q3, arrn);
        }
        if (!bl3) return n2;
        n2 += this.b(q2, q3, arrn);
        return n2;
    }

    private int a(q q2, q q3, int[] arrn) {
        int n2;
        boolean bl2 = N.x;
        int n3 = 0;
        int n4 = arrn[q2.d()];
        for (d d2 = q2.g(); d2 != null; d2 = d2.h()) {
            q q4;
            n2 = this.F[d2.c().d()];
            if (bl2) return n2;
            if (n2 >= 0) continue;
            q q5 = q4 = d2.g() == null ? d2.i().d() : d2.g().d();
            if (q4 == q3) continue;
            int n5 = arrn[q4.d()] - n4;
            n3 += n5 > 0 ? 1 : (n5 < 0 ? -1 : 0);
            if (!bl2) continue;
        }
        n2 = n3;
        return n2;
    }

    private int b(q q2, q q3, int[] arrn) {
        int n2;
        boolean bl2 = N.x;
        int n3 = 0;
        int n4 = arrn[q2.d()];
        for (d d2 = q2.f(); d2 != null; d2 = d2.g()) {
            q q4;
            n2 = this.F[d2.d().d()];
            if (bl2) return n2;
            if (n2 >= 0) continue;
            q q5 = q4 = d2.h() == null ? d2.j().c() : d2.h().c();
            if (q4 == q3) continue;
            int n5 = arrn[q4.d()] - n4;
            n3 += n5 > 0 ? 1 : (n5 < 0 ? -1 : 0);
            if (!bl2) continue;
        }
        n2 = n3;
        return n2;
    }

    /*
     * Exception decompiling
     */
    private int c(q var1_1, q var2_2, int[] var3_3) {
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
     * Exception decompiling
     */
    private int d(q var1_1, q var2_2, int[] var3_3) {
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

    private boolean a(X x2, aU aU2, c c2) {
        boolean bl2 = N.x;
        q[][] arrarrq = new q[aU2.b()][];
        q[][] arrarrq2 = new q[aU2.b()][];
        int n2 = Integer.MAX_VALUE;
        int n3 = 0;
        int n4 = 0;
        ArrayList<q> arrayList = new ArrayList<q>(120);
        ArrayList<q> arrayList2 = new ArrayList<q>(120);
        for (int i2 = 0; i2 < aU2.b(); ++i2) {
            q[] arrq;
            int n5;
            block7 : {
                arrayList.clear();
                arrayList2.clear();
                if (bl2) return true;
                for (arrq = aU2.a((int)i2).d().k(); arrq != null; arrq = arrq.a()) {
                    q q2 = (q)arrq.c();
                    n5 = (int)c2.d(q2) ? 1 : 0;
                    if (!bl2) {
                        if (n5 != 0) {
                            arrayList.add(q2);
                            x2.e(q2);
                            if (!bl2) continue;
                        }
                        arrayList2.add(q2);
                        if (!bl2) continue;
                    }
                    break block7;
                }
                n5 = arrayList.size();
            }
            if (n5 <= 0) continue;
            if (arrayList2.size() > 0) {
                arrarrq2[i2] = arrq = arrayList2.toArray(new q[arrayList2.size()]);
            }
            if (i2 < n2) {
                n2 = i2;
            }
            n3 = i2;
            arrarrq[i2] = arrq = arrayList.toArray(new q[arrayList.size()]);
            n4 += arrq.length;
            if (!bl2) continue;
        }
        if (n4 > 0) {
            this.H = arrarrq;
            this.L = n4;
            this.J = n2;
            this.K = n3;
            this.I = arrarrq2;
            return true;
        }
        this.L = 0;
        this.H = null;
        this.I = null;
        return true;
    }

    private final boolean a(q q2) {
        if (q2.d() >= this.L) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void a(X var1_1, aU var2_2, aV var3_3, aP var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [13[DOLOOP]], but top level block is 18[FORLOOP]
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

    boolean a(i i2, D[] arrd, aV aV2) {
        int[] arrn;
        boolean bl2;
        int n2;
        block7 : {
            bl2 = N.x;
            arrn = new int[i2.e()];
            for (n2 = 0; n2 < arrn.length; ++n2) {
                arrn[n2] = -1;
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block7;
            }
            n2 = 0;
        }
        int n3 = -1;
        int n4 = 0;
        while (n4 < arrd.length) {
            block8 : {
                D d2 = arrd[n4];
                if (bl2) return false;
                for (p p2 = d2.k(); p2 != null; p2 = p2.a()) {
                    q q2 = (q)p2.c();
                    bK bK2 = aV2.a(q2).h();
                    if (!bl2) {
                        int n5;
                        if (bK2 == null) continue;
                        ++n2;
                        arrn[q2.d()] = n5 = bK2.j();
                        n3 = Math.max(n3, n5);
                        if (!bl2) continue;
                    }
                    break block8;
                }
                ++n4;
            }
            if (!bl2) continue;
        }
        if (n2 > 0 && n3 > 0) {
            this.a = arrn;
            this.b = new int[arrd.length];
            for (n4 = 0; n4 < this.b.length; ++n4) {
                this.b[n4] = n3;
                if (bl2) return true;
                if (!bl2) continue;
            }
            if (this.O == null) return true;
            if (!this.O.k()) return true;
            this.O.a(arrd, arrn, this.b);
            return true;
        }
        this.a = null;
        this.b = null;
        return false;
    }

    void a(i i2, D[] arrd, int[] arrn, ar ar2) {
        int[] arrn2;
        boolean bl2;
        p[] arrp;
        Object object;
        block13 : {
            Object object2;
            Object object3;
            bl2 = N.x;
            object = null;
            arrp = new p[i2.e()];
            arrn2 = new int[i2.e()];
            int n2 = 0;
            while (n2 < arrd.length) {
                block14 : {
                    object2 = arrd[n2];
                    if (bl2) break block13;
                    if (object == null) {
                        object = (q)object2.f();
                    }
                    for (object3 = object2.k(); object3 != null; object3 = object3.a()) {
                        q q2 = (q)object3.c();
                        arrp[q2.d()] = object3;
                        arrn2[q2.d()] = n2 + 1;
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block14;
                    }
                    ++n2;
                }
                if (!bl2) continue;
            }
            if (ar2 != null) {
                block15 : {
                    n2 = ar2.nextInt(i2.e());
                    object2 = i2.o();
                    while (object2.f()) {
                        object3 = object2.e();
                        if (!bl2) {
                            if (n2 == 0) {
                                object = object3;
                                if (!bl2) break;
                            }
                            object2.g();
                            --n2;
                            if (!bl2) continue;
                        }
                        break block15;
                    }
                    this.a(i2, ar2);
                }
                Arrays.fill(arrn, 0);
            }
            i2.a(new cX(this.u), new cX(this.t));
        }
        bW bW2 = new bW(this, arrp, arrn2, arrd);
        bW2.a(false);
        bW2.b(true);
        bW2.a(i2, (q)object);
        if (this.M != null) {
            this.N = this.M.a(i2, arrd, arrn);
            int n3 = 0;
            do {
                if (n3 >= arrd.length) return;
                this.a(arrd[n3], arrn, this.N);
                ++n3;
            } while (!bl2);
        }
        if (this.c != null) {
            int n4 = 0;
            do {
                if (n4 >= arrd.length) return;
                this.a(arrd[n4], arrn, this.c);
                ++n4;
            } while (!bl2);
        }
        int n5 = 0;
        do {
            if (n5 >= arrd.length) return;
            this.a(arrd[n5], arrn);
            ++n5;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private int a(ar var1_1) {
        block2 : {
            var9_2 = N.x;
            a.a();
            var2_3 = false;
            var3_4 = Integer.MAX_VALUE;
            var4_5 = Integer.MAX_VALUE;
            var5_6 = new int[this.G.length];
            var6_7 = var1_1.nextBoolean();
            var7_8 = 0;
            var8_9 = 0;
            while (var8_9 < 2) {
                v0 = var7_8;
                v1 = 6;
                if (var9_2) break block2;
                if (v0 >= v1 || var3_4 <= 0) break;
                var4_5 = this.b(var6_7);
                if (var4_5 >= var3_4) ** GOTO lbl21
                var3_4 = var4_5;
                var2_3 = true;
                this.a(this.G, var5_6);
                if (!var9_2) ** GOTO lbl25
lbl21: // 2 sources:
                if (var4_5 <= var3_4) ** GOTO lbl-1000
                ++var8_9;
                if (var9_2) lbl-1000: // 2 sources:
                {
                    ++var7_8;
                }
lbl25: // 4 sources:
                v2 = var6_7 = var6_7 == false;
                if (!var9_2) continue;
            }
            if (var2_3 == false) return var3_4;
            v0 = var4_5;
            v1 = var3_4;
        }
        if (v0 <= v1) return var3_4;
        this.b(var5_6);
        return var3_4;
    }

    private void a(D d2, Comparator comparator, Comparator comparator2) {
        boolean bl2 = N.x;
        if (comparator == null) {
            if (comparator2 == null) return;
        }
        p p2 = d2.k();
        do {
            if (p2 == null) return;
            q q2 = (q)p2.c();
            if (comparator != null) {
                q2.a(comparator);
            }
            if (comparator2 != null) {
                q2.b(comparator2);
            }
            p2 = p2.a();
        } while (!bl2);
    }

    private void a(i i2, Comparator comparator, Comparator comparator2) {
        if (comparator == null) {
            if (comparator2 == null) return;
        }
        i2.a(comparator, comparator2);
    }

    /*
     * Unable to fully structure code
     */
    private int b(boolean var1_1) {
        block6 : {
            var3_2 = N.x;
            if (this.L <= 0) ** GOTO lbl20
            if (!var1_1) ** GOTO lbl12
            this.O.a(Math.max(1, this.J) - 1);
            for (var2_3 = Math.max((int)1, (int)this.J); var2_3 <= this.K; ++var2_3) {
                v0 = this;
                if (!var3_2) {
                    if (v0.H[var2_3] == null) continue;
                    this.a(true, false, var2_3, this.E[var2_3], this.E[var2_3 - 1], null, this.j, this.G);
                    if (!var3_2) continue;
                }
                break block6;
lbl12: // 2 sources:
                this.O.a(Math.min(this.E.length - 1, this.K));
                for (var2_3 = Math.min((int)(this.E.length - 1), (int)this.K) - 1; var2_3 >= this.J; --var2_3) {
                    v0 = this;
                    if (!var3_2) {
                        if (v0.H[var2_3] == null) continue;
                        this.a(false, true, var2_3, this.E[var2_3], null, this.E[var2_3 + 1], this.j, this.G);
                        if (!var3_2) continue;
                    }
                    break block6;
lbl20: // 2 sources:
                    if (!var1_1) ** GOTO lbl26
                    this.O.a(0);
                    for (var2_3 = 1; var2_3 < this.E.length; ++var2_3) {
                        this.a(this.E, var2_3, this.G);
                        if (var3_2 != false) return this.a();
                        if (!var3_2) continue;
lbl26: // 2 sources:
                        this.O.a(this.E.length - 1);
                        for (var2_3 = this.E.length - 2; var2_3 >= 0; --var2_3) {
                            this.b(this.E, var2_3, this.G);
                            if (var3_2 != false) return this.a();
                            if (!var3_2) continue;
                        }
                    }
                }
            }
            v0 = this;
        }
        if (v0.f == false) return this.a();
        if (this.O.k() != false) return this.a();
        this.a(this.G);
        return this.a();
    }

    /*
     * Unable to fully structure code
     */
    private void a(boolean var1_1, boolean var2_2, int var3_3, D var4_4, D var5_5, D var6_6, float[] var7_7, int[] var8_8) {
        block43 : {
            block42 : {
                block37 : {
                    block40 : {
                        block36 : {
                            var29_9 = N.x;
                            var9_10 = var4_4.size();
                            var10_11 = var9_10 * 2;
                            var11_12 = 1.0f;
                            var12_13 = 0;
                            for (var13_15 = var4_4.k(); var13_15 != null; var13_15 = var13_15.a(), var12_13 += 2) {
                                var14_16 = (q)var13_15.c();
                                var8_8[var14_16.d()] = var12_13 + 1;
                                var7_7[var14_16.d()] = var12_13;
                                v0 = (int)(var11_12 FCMPG var7_7[var14_16.d()]);
                                if (!var29_9) {
                                    if (v0 >= 0) continue;
                                    var11_12 = var7_7[var14_16.d()];
                                    if (!var29_9) continue;
                                }
                                break block36;
                            }
                            v0 = var2_2;
                        }
                        if (v0 != 0) {
                            this.a(var4_4, (Comparator)null, this.z);
                        }
                        if (var1_1) {
                            this.a(var4_4, this.A, null);
                        }
                        var12_14 = this.H[var3_3];
                        var13_15 = this.I[var3_3];
                        var14_17 = var1_1 != false ? var5_5.size() : 0;
                        var15_18 = var2_2 != 0 ? var6_6.size() : 0;
                        for (var16_19 = 0; var16_19 < var12_14.length; ++var16_19) {
                            block41 : {
                                block39 : {
                                    block38 : {
                                        var17_22 = var12_14[var16_19];
                                        var18_24 = var17_22.d();
                                        var19_25 = 0;
                                        var20_26 = 0.0f;
                                        v1 = var1_1;
                                        if (var29_9) break block37;
                                        if (v1 != 0) {
                                            for (var21_28 = var17_22.g(); var21_28 != null; var20_26 += this.a((boolean)true, (d)var21_28, (int)var9_10, (int)var10_11, (int[])this.G), var21_28 = var21_28.h(), ++var19_25) {
                                                if (!var29_9) {
                                                    if (!var29_9) continue;
                                                }
                                                break block38;
                                            }
                                            var20_26 /= (float)var14_17;
                                        }
                                    }
                                    if (var2_2 != 0) {
                                        var21_29 = 0.0f;
                                        for (var22_31 = var17_22.f(); var22_31 != null; var21_29 += this.a((boolean)false, (d)var22_31, (int)var9_10, (int)var10_11, (int[])this.G), var22_31 = var22_31.g(), ++var19_25) {
                                            if (!var29_9) {
                                                if (!var29_9) continue;
                                            }
                                            break block39;
                                        }
                                        var20_26 += var21_29 / (float)var15_18;
                                    }
                                }
                                if (var19_25 != 0) ** GOTO lbl-1000
                                var21_27 = this.G[var18_24];
                                if (var29_9) lbl-1000: // 2 sources:
                                {
                                    var20_26 = var20_26 * (float)var10_11 / (float)var19_25;
                                    var21_27 = var20_26 + (float)this.G[var18_24] / 200.0f;
                                }
                                var23_32 = var22_30 = 0;
                                var24_33 = -1;
                                if (var13_15 != null && var13_15.length > 0) {
                                    for (var25_34 = 0; var25_34 < var13_15.length; ++var25_34) {
                                        var26_35 = var13_15[var25_34];
                                        v2 = this.M;
                                        if (!var29_9) {
                                            if (v2 != null) {
                                                if (this.M.a(var17_22.e(), (q)var26_35, (q)var17_22)) {
                                                    var23_32 = var22_30;
                                                    var24_33 = this.G[var26_35.d()] + 1;
                                                    if (!var29_9) continue;
                                                }
                                                if (this.M.a(var17_22.e(), (q)var17_22, (q)var26_35)) {
                                                    break;
                                                }
                                            } else if (this.a != null && this.a[var18_24] >= 0 && this.a[var26_35.d()] >= 0) {
                                                if (this.a[var18_24] > this.a[var26_35.d()]) {
                                                    var23_32 = var22_30;
                                                    var24_33 = this.G[var26_35.d()] + 1;
                                                    if (!var29_9) continue;
                                                }
                                                if (this.a[var18_24] < this.a[var26_35.d()]) break;
                                            }
                                            var27_36 = this.G[var26_35.d()] - 1;
                                            var28_37 = 0;
                                            if (var1_1) {
                                                var8_8[var18_24] = var27_36;
                                                this.a((q)var17_22, this.A, null, true);
                                                var28_37 -= this.d((q)var17_22, (q)var26_35, this.G);
                                                v3 = var8_8;
                                                v4 = var18_24;
                                                v3[v4] = v3[v4] + 2;
                                                this.a((q)var17_22, this.A, null, true);
                                                var28_37 += this.d((q)var26_35, (q)var17_22, this.G);
                                            }
                                            if (var2_2 != 0) {
                                                var8_8[var18_24] = var27_36;
                                                this.a((q)var17_22, null, this.z, true);
                                                var28_37 -= this.c((q)var17_22, (q)var26_35, this.G);
                                                v5 = var8_8;
                                                v6 = var18_24;
                                                v5[v6] = v5[v6] + 2;
                                                this.a((q)var17_22, null, this.z, true);
                                                var28_37 += this.c((q)var26_35, (q)var17_22, this.G);
                                            }
                                            if ((var22_30 += var28_37) < var23_32) {
                                                var24_33 = var27_36;
                                                var23_32 = var22_30;
                                                if (!var29_9) continue;
                                            }
                                            if (var22_30 != var23_32 || Math.abs((float)var27_36 - var21_27) >= Math.abs((float)var24_33 - var21_27)) continue;
                                            var24_33 = var27_36;
                                            if (!var29_9) continue;
                                        }
                                        break block40;
                                    }
                                    var7_7[var18_24] = (float)var24_33 + var21_27 / (float)var10_11;
                                    if (!var29_9) break block41;
                                }
                                var7_7[var18_24] = var21_27;
                            }
                            if (var11_12 >= var7_7[var18_24]) continue;
                            var11_12 = var7_7[var18_24];
                            if (!var29_9) continue;
                        }
                        v2 = this.M;
                    }
                    if (v2 != null) {
                        for (var16_20 = var4_4.k(); var16_20 != null; var16_20 = var16_20.a()) {
                            var17_23 = ((q)var16_20.c()).d();
                            var7_7[var17_23] = var7_7[var17_23] / var11_12 * (float)this.m[var17_23] + (float)this.n[var17_23];
                            if (!var29_9) {
                                continue;
                            }
                            break block42;
                        }
                    } else if (this.a != null) {
                        var16_21 = var4_4.size() * 3;
                        for (var17_22 = var4_4.k(); var17_22 != null; var17_22 = var17_22.a()) {
                            var18_24 = ((q)var17_22.c()).d();
                            v1 = var19_25 = this.a[var18_24];
                            if (!var29_9) {
                                if (v1 >= 0) {
                                    var7_7[var18_24] = var7_7[var18_24] + (float)(var19_25 + 1) * var16_21;
                                    if (!var29_9) continue;
                                }
                                var7_7[var18_24] = var7_7[var18_24] / (float)(var10_11 + 1) * (float)(this.b[var3_3] + 1) * var16_21;
                                if (!var29_9) continue;
                            }
                            break block37;
                        }
                    }
                    v1 = this.O.k();
                }
                if (v1 != 0) {
                    this.O.a(var4_4, var3_3, this.j, this.G, true);
                    if (!var29_9) break block43;
                }
            }
            this.a(var4_4, this.G, this.g);
        }
        if (this.f == false) return;
        if (this.O.k() != false) return;
        if (var1_1) {
            this.a(var3_3, var4_4, true, false, this.G);
        }
        if (var2_2 == 0) return;
        this.a(var3_3, var4_4, false, true, this.G);
    }

    /*
     * Unable to fully structure code
     */
    void a(D[] var1_1, int var2_2, int[] var3_3) {
        block12 : {
            var13_4 = N.x;
            var4_5 = var1_1[var2_2 - 1];
            var5_6 = var1_1[var2_2];
            var6_7 = var4_5.size();
            var7_8 = var5_6.size();
            var8_9 = 1.0f;
            for (var9_10 = var5_6.k(); var9_10 != null; var9_10 = var9_10.a()) {
                var10_11 = (q)var9_10.c();
                var11_13 = var10_11.d();
                v0 = this.i;
                if (var13_4) ** GOTO lbl40
                switch (v0) {
                    case 0: {
                        this.j[var11_13] = this.b(var10_11, var7_8, false, var6_7, var3_3);
                        if (!var13_4) break;
                    }
                    case 1: {
                        this.j[var11_13] = this.a(var10_11, var7_8, false, var6_7, var3_3);
                    }
                }
                v1 = this.j;
                v2 = var11_13;
                v1[v2] = v1[v2] + (float)var3_3[var11_13] / (float)(var6_7 * 200);
                if (this.a == null) ** GOTO lbl29
                var12_14 = this.a[var11_13];
                if (var12_14 >= 0) ** GOTO lbl-1000
                this.j[var11_13] = 2.0f * this.j[var11_13] * (float)(this.b[var2_2] + 1);
                if (var13_4) lbl-1000: // 2 sources:
                {
                    v3 = this.j;
                    v4 = var11_13;
                    v3[v4] = v3[v4] + (float)((var12_14 + 1) * ((var6_7 + 1) * 2));
                }
lbl29: // 4 sources:
                if (var8_9 >= this.j[var11_13]) continue;
                var8_9 = this.j[var11_13];
                if (!var13_4) continue;
            }
            if (this.M != null) {
                for (var9_10 = var5_6.k(); var9_10 != null; var9_10 = var9_10.a()) {
                    var10_12 = ((q)var9_10.c()).d();
                    this.j[var10_12] = this.j[var10_12] / var8_9 * (float)this.m[var10_12] + (float)this.n[var10_12];
                    if (!var13_4) {
                        if (!var13_4) continue;
                    }
                    break;
                }
            } else {
                v0 = this.O.k();
lbl40: // 2 sources:
                if (v0 != 0) {
                    this.O.a(var5_6, var2_2, this.j, var3_3, true);
                    if (!var13_4) break block12;
                }
            }
            this.a(var5_6, var3_3, this.g);
        }
        if (this.f == false) return;
        if (this.O.k() != false) return;
        this.a(var5_6, this.A, null);
        this.a(var2_2, var5_6, true, false, var3_3);
        this.a(var4_5, (Comparator)null, this.y);
    }

    /*
     * Unable to fully structure code
     */
    void b(D[] var1_1, int var2_2, int[] var3_3) {
        block12 : {
            var13_4 = N.x;
            var4_5 = var1_1[var2_2 + 1];
            var5_6 = var1_1[var2_2];
            var6_7 = var4_5.size();
            var7_8 = var5_6.size();
            var8_9 = 1.0f;
            for (var9_10 = var5_6.k(); var9_10 != null; var9_10 = var9_10.a()) {
                var10_11 = (q)var9_10.c();
                var11_13 = var10_11.d();
                v0 = this.i;
                if (var13_4) ** GOTO lbl40
                switch (v0) {
                    case 0: {
                        this.j[var11_13] = this.b(var10_11, var7_8, true, var6_7, var3_3);
                        if (!var13_4) break;
                    }
                    case 1: {
                        this.j[var11_13] = this.a(var10_11, var7_8, true, var6_7, var3_3);
                    }
                }
                v1 = this.j;
                v2 = var11_13;
                v1[v2] = v1[v2] + (float)var3_3[var11_13] / (float)(var6_7 * 200);
                if (this.a == null) ** GOTO lbl29
                var12_14 = this.a[var11_13];
                if (var12_14 >= 0) ** GOTO lbl-1000
                this.j[var11_13] = 2.0f * this.j[var11_13] * (float)(this.b[var2_2] + 1);
                if (var13_4) lbl-1000: // 2 sources:
                {
                    v3 = this.j;
                    v4 = var11_13;
                    v3[v4] = v3[v4] + (float)((var12_14 + 1) * ((var6_7 + 1) * 2));
                }
lbl29: // 4 sources:
                if (var8_9 >= this.j[var11_13]) continue;
                var8_9 = this.j[var11_13];
                if (!var13_4) continue;
            }
            if (this.M != null) {
                for (var9_10 = var5_6.k(); var9_10 != null; var9_10 = var9_10.a()) {
                    var10_12 = ((q)var9_10.c()).d();
                    this.j[var10_12] = this.j[var10_12] / var8_9 * (float)this.m[var10_12] + (float)this.n[var10_12];
                    if (!var13_4) {
                        if (!var13_4) continue;
                    }
                    break;
                }
            } else {
                v0 = this.O.k();
lbl40: // 2 sources:
                if (v0 != 0) {
                    this.O.a(var5_6, var2_2, this.j, var3_3, false);
                    if (!var13_4) break block12;
                }
            }
            this.a(var5_6, var3_3, this.g);
        }
        if (this.f == false) return;
        if (this.O.k() != false) return;
        this.a(var5_6, (Comparator)null, this.y);
        this.a(var2_2, var5_6, false, true, var3_3);
        this.a(var4_5, this.x, null);
    }

    private float a(boolean bl2, d d2, int n2, int n3, int[] arrn) {
        float f2;
        int n4;
        q q2;
        int n5;
        d d3;
        boolean bl3 = N.x;
        if (bl2) {
            n5 = d2.c().d();
            if (this.F[n5] < 0) {
                d3 = d2.g() == null ? d2.i() : d2.g();
                q2 = d3.d();
                f2 = (float)((n3 - 1) * arrn[q2.d()]) / (float)(n2 - 1);
                if (this.u == null) return f2;
                n4 = d3.b();
                switch (this.u[n4]) {
                    case 1: {
                        f2 -= 0.3f;
                        if (!bl3) break;
                    }
                    case -1: {
                        f2 += 0.3f;
                    }
                }
                f2 -= (float)this.w[n4] * 0.01f;
                if (!bl3) return f2;
            }
            f2 = arrn[n5];
            if (this.t == null) return f2;
            int n6 = d2.b();
            switch (this.t[n6]) {
                case 1: {
                    f2 += 0.3f;
                    if (!bl3) break;
                }
                case -1: {
                    f2 -= 0.3f;
                }
            }
            f2 += (float)this.v[n6] * 0.01f;
            if (!bl3) return f2;
        }
        if (this.F[n5 = d2.d().d()] < 0) {
            d d4 = d2.h() == null ? d2.j() : d2.h();
            q2 = d4.c();
            f2 = (float)((n3 - 1) * arrn[q2.d()]) / (float)(n2 - 1);
            if (this.t == null) return f2;
            n4 = d4.b();
            switch (this.t[n4]) {
                case 1: {
                    f2 -= 0.3f;
                    if (!bl3) break;
                }
                case -1: {
                    f2 += 0.3f;
                }
            }
            f2 -= (float)this.v[n4] * 0.01f;
            if (!bl3) return f2;
        }
        f2 = arrn[n5];
        if (this.u == null) return f2;
        int n7 = d2.b();
        d3 = (d)n7;
        switch (this.u[n7]) {
            case 1: {
                f2 += 0.3f;
                if (!bl3) break;
            }
            case -1: {
                f2 -= 0.3f;
            }
        }
        f2 += (float)this.w[d3] * 0.01f;
        return f2;
    }

    /*
     * Unable to fully structure code
     */
    private float a(q var1_1, int var2_2, boolean var3_3, int var4_4, int[] var5_5) {
        block8 : {
            var10_6 = N.x;
            var6_7 = 0;
            if (!var3_3) ** GOTO lbl9
            for (var7_8 = var1_1.f(); var7_8 != null; var7_8 = var7_8.g(), ++var6_7) {
                this.k[var6_7] = this.a(false, var7_8, var2_2, var4_4, var5_5);
                if (!var10_6) {
                    if (!var10_6) continue;
                }
                break block8;
lbl9: // 3 sources:
                for (var7_8 = var1_1.g(); var7_8 != null; var7_8 = var7_8.h(), ++var6_7) {
                    this.k[var6_7] = this.a(true, var7_8, var2_2, var4_4, var5_5);
                    if (!var10_6) {
                        if (!var10_6) continue;
                    }
                    break block8;
                }
            }
            if (var6_7 == 0) {
                var7_9 = var5_5[var1_1.d()];
                if (var7_9 == 0) {
                    return -1.0f;
                }
                if (var7_9 < var2_2 - 1) return (float)((var4_4 - 1) * var5_5[var1_1.d()]) / (float)(var2_2 - 1);
                return var4_4;
            }
            Arrays.sort(this.k, 0, var6_7);
        }
        var7_10 = var6_7 >> 1;
        if (var6_7 % 2 == 1) {
            return this.k[var7_10];
        }
        if (var6_7 == 2) {
            return (this.k[0] + this.k[1]) * 0.5f;
        }
        var8_11 = this.k[var7_10 - 1] - this.k[0];
        var9_12 = this.k[var6_7 - 1] - this.k[var7_10];
        if (var8_11 != 0.0f) return (this.k[var7_10 - 1] * var9_12 + this.k[var7_10] * var8_11) / (var8_11 + var9_12);
        if (var9_12 == 0.0f) return (this.k[var7_10 - 1] + this.k[var7_10]) * 0.5f;
        return (this.k[var7_10 - 1] * var9_12 + this.k[var7_10] * var8_11) / (var8_11 + var9_12);
    }

    /*
     * Unable to fully structure code
     */
    private float b(q var1_1, int var2_2, boolean var3_3, int var4_4, int[] var5_5) {
        var9_6 = N.x;
        var6_7 = 0.0f;
        v0 = var7_8 = var3_3 != false ? var1_1.c() : var1_1.b();
        if (var7_8 == 0) {
            var8_9 = var5_5[var1_1.d()];
            if (var8_9 == 0) {
                return -1.0f;
            }
            if (var8_9 < var2_2 - 1) return (float)((var4_4 - 1) * var5_5[var1_1.d()]) / (float)(var2_2 - 1);
            return var4_4;
        }
        if (!var3_3) ** GOTO lbl14
        for (var8_10 = var1_1.f(); var8_10 != null; var6_7 += this.a((boolean)false, (d)var8_10, (int)var2_2, (int)var4_4, (int[])var5_5), var8_10 = var8_10.g()) {
            if (var9_6 != false) return var6_7;
            if (!var9_6) continue;
lbl14: // 3 sources:
            for (var8_10 = var1_1.g(); var8_10 != null; var6_7 += this.a((boolean)true, (d)var8_10, (int)var2_2, (int)var4_4, (int[])var5_5), var8_10 = var8_10.h()) {
                if (var9_6 != false) return var6_7;
                if (!var9_6) continue;
            }
        }
        var6_7 /= (float)var7_8;
        return var6_7;
    }

    private final void a(D d2, int[] arrn) {
        boolean bl2 = N.x;
        int n2 = 0;
        p p2 = d2.k();
        do {
            if (p2 == null) return;
            arrn[((q)p2.c()).d()] = n2++;
            p2 = p2.a();
        } while (!bl2);
    }

    private final void a(int[] arrn, int[] arrn2) {
        System.arraycopy(arrn, 0, arrn2, 0, arrn.length);
    }

    private final void b(int[] arrn) {
        boolean bl2 = N.x;
        this.a(arrn, this.G);
        int n2 = 0;
        do {
            if (n2 >= this.E.length) return;
            this.b(this.E[n2], this.G);
            ++n2;
        } while (!bl2);
    }

    private final void b(D d2, int[] arrn) {
        Object object;
        boolean bl2 = N.x;
        for (p p2 = d2.k(); p2 != null; p2 = p2.a()) {
            this.l[arrn[object.d()]] = object = (q)p2.c();
            if (!bl2) continue;
        }
        int n2 = 0;
        object = d2.k();
        do {
            if (object == null) return;
            object.a(this.l[n2]);
            object = object.a();
            ++n2;
        } while (!bl2);
    }

    private final void a(D d2, int[] arrn, Comparator comparator) {
        p p2;
        int n2;
        boolean bl2;
        block3 : {
            bl2 = N.x;
            n2 = 0;
            for (p2 = d2.k(); p2 != null; p2 = p2.a(), ++n2) {
                this.l[n2] = (q)p2.c();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            e.a(this.l, 0, d2.size(), comparator);
            n2 = 0;
        }
        p2 = d2.k();
        do {
            if (p2 == null) return;
            q q2 = this.l[n2];
            p2.a(q2);
            arrn[q2.d()] = n2++;
            p2 = p2.a();
        } while (!bl2);
    }

    static float[] a(bT bT2) {
        return bT2.j;
    }

    static boolean a(bT bT2, q q2) {
        return bT2.a(q2);
    }
}

