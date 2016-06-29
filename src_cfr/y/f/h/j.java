/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import java.util.Arrays;
import java.util.Comparator;
import y.a.v;
import y.c.A;
import y.c.C;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.h;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.h.D;
import y.f.h.K;
import y.f.h.L;
import y.f.h.M;
import y.f.h.N;
import y.f.h.i;
import y.f.h.k;
import y.f.h.p;
import y.g.o;

public class J {
    private D c;
    private k d;
    L a;
    M[] b;
    private int[] e;
    private int[] f;
    private d[] g;
    private h h = null;

    public J(D d2) {
        this.c = d2;
        int n2 = 2 * this.c.g().e();
        this.d = new k(d2);
        this.e = new int[2 * this.c.g().g()];
        this.f = new int[n2];
        this.g = new d[n2];
        this.a = new L(n2);
        this.b = new M[n2];
    }

    public void a(f f2) {
        boolean bl2 = N.d;
        i i2 = new i(this.c, f2);
        i2.a();
        e e2 = f2.a();
        while (e2.f()) {
            d d2 = e2.a();
            f f3 = this.a(d2, 1, i2, null);
            this.d.a(f3, d2);
            if (bl2) return;
            if (o.b(this) && !this.c.n()) {
                throw new RuntimeException("Combinatorial Embedder failed !");
            }
            e2.g();
            if (!bl2) continue;
        }
        i2.b();
        i2.e();
    }

    public int b(f f2) {
        boolean bl2 = N.d;
        int n2 = 0;
        i i2 = new i(this.c, f2);
        i2.a();
        e e2 = f2.a();
        while (e2.f()) {
            d d2 = e2.a();
            f f3 = this.a(d2, 0, i2, null);
            if (bl2) return n2;
            if (f3 != null) {
                n2 += f3.size();
            }
            e2.g();
            if (!bl2) continue;
        }
        i2.b();
        i2.e();
        return n2;
    }

    /*
     * Unable to fully structure code
     */
    protected f a(d var1_1, short var2_2, i var3_3, d[] var4_4) {
        block31 : {
            block30 : {
                block29 : {
                    block28 : {
                        var11_5 = N.d;
                        var5_6 = var3_3.g();
                        var6_7 = var5_6.d();
                        var7_8 = var5_6.d();
                        var8_9 = var1_1.c().l();
                        while (var8_9.f()) {
                            var9_11 = var8_9.a();
                            var10_12 = var3_3.a(this.c.i((d)var9_11));
                            var5_6.a(var6_7, var10_12);
                            var8_9.g();
                            if (!var11_5) {
                                if (!var11_5) continue;
                            }
                            break block28;
                        }
                        var8_9 = var1_1.d().l();
                    }
                    while (var8_9.f()) {
                        var9_11 = var8_9.a();
                        var10_14 = var3_3.a(this.c.i((d)var9_11));
                        var5_6.a(var10_14, var7_8);
                        var8_9.g();
                        if (!var11_5) {
                            if (!var11_5) continue;
                        }
                        break block29;
                    }
                    while (this.g.length < var5_6.e()) {
                        this.g = new d[2 * this.g.length];
                        if (!var11_5) {
                            if (!var11_5) continue;
                        }
                        break block30;
                    }
                }
                while (this.e.length < var5_6.g()) {
                    this.e = new int[2 * this.e.length];
                    if (!var11_5) {
                        if (!var11_5) continue;
                    }
                    break block31;
                }
            }
            while (this.f.length < var5_6.e()) {
                this.f = new int[2 * this.f.length];
                if (!var11_5) {
                    if (!var11_5) continue;
                }
                break block31;
            }
            Arrays.fill(this.e, 1);
        }
        if (this.h != null) {
            var8_9 = this.c.g().p();
            while (var8_9.f()) {
                var9_11 = var8_9.a();
                var10_16 = var3_3.b((d)var9_11);
                this.e[var10_16.b()] = this.a((d)var9_11);
                var8_9.g();
                if (!var11_5) {
                    if (!var11_5) continue;
                }
                break;
            }
        } else if (var4_4 != null) {
            for (var8_10 = 0; var8_10 < var4_4.length; ++var8_10) {
                this.e[var4_4[var8_10].b()] = 0;
                if (!var11_5) {
                    if (!var11_5) continue;
                }
                break;
            }
        } else {
            this.a(var5_6, var6_7, var7_8, true, this.e, this.f, this.g);
        }
        var8_9 = v.a(var6_7, var7_8, this.g);
        if (this.f[var7_8.d()] == Integer.MAX_VALUE) {
            var8_9 = null;
        }
        if (var8_9 == null) {
            if (o.b(this)) {
                var9_11 = var5_6.t();
                y.a.h.a(var5_6, (A)var9_11);
                var10_17 = var9_11.a(var6_7) == var9_11.a(var7_8);
                var5_6.a((A)var9_11);
                if (var10_17) {
                    throw new RuntimeException("Error computing shortest dual path");
                } else {
                    ** GOTO lbl-1000
                }
            }
        } else if (var8_9 != null) {
            var8_9.d();
            var8_9.remove(var8_9.i());
        }
        var5_6.a(var6_7);
        var5_6.a(var7_8);
        switch (var2_2) {
            case 0: {
                return var8_9;
            }
            case 1: {
                return this.a(var3_3, (f)var8_9);
            }
        }
        throw new RuntimeException("Unknown return type style in EdgeRouter.routeEdge()");
    }

    private int a(d d2) {
        if (!this.c.n(d2)) return this.h.a(d2);
        return this.h.a(this.c.h(d2));
    }

    private f a(i i2, f f2) {
        f f3;
        boolean bl2 = N.d;
        f f4 = new f();
        if (f2 == null) {
            return null;
        }
        if (f2.isEmpty()) {
            return f4;
        }
        d d2 = null;
        d d3 = null;
        e e2 = f2.a();
        e2.j();
        while (e2.f()) {
            d2 = e2.a();
            d3 = i2.a(d2);
            f3 = f4;
            if (bl2) return f3;
            f3.a(d3);
            e2.h();
            if (!bl2) continue;
        }
        f3 = f4;
        return f3;
    }

    /*
     * Unable to fully structure code
     */
    public void a(int var1_1, f var2_2) {
        block12 : {
            var18_3 = N.d;
            var3_4 = false;
            var4_5 = 0;
            var8_6 = 0;
            var10_7 = new i(this.c);
            var10_7.a();
            block0 : while (!var3_4) {
                var11_12 = new f(var2_2.a());
                if (var18_3) break block12;
                v0 = var12_13 = var11_12.a();
                block1 : do lbl-1000: // 3 sources:
                {
                    if (!var12_13.f()) ** GOTO lbl22
                    var13_14 = var12_13.a();
                    var14_15 = this.c.c(var13_14);
                    v1 = var14_15.k();
                    v2 = 1;
                    if (var18_3) ** GOTO lbl25
                    if (v1 == v2) {
                        var11_12.remove(var13_14);
                    }
                    var12_13.g();
                    if (!var18_3) ** GOTO lbl-1000
lbl22: // 2 sources:
                    if (var11_12.size() == 0) break block0;
                    v1 = var1_1;
                    v2 = -1;
lbl25: // 2 sources:
                    if (v1 != v2 && var4_5 >= var1_1) break block0;
                    ++var4_5;
                    var11_12.sort(new K(this));
                    var12_13 = var11_12.a();
                    block2 : while (var12_13.f()) {
                        var13_14 = var12_13.a();
                        var14_15 = new d[2 * this.c.c(var13_14).k()];
                        var15_16 = 0;
                        v0 = this.c.c(var13_14);
                        if (var18_3) continue block1;
                        var16_17 = v0;
                        while (var16_17.f()) {
                            var17_18 = var10_7.b(var16_17.a());
                            var14_15[var15_16++] = var17_18;
                            var14_15[var15_16++] = var10_7.h(var17_18);
                            var16_17.g();
                            if (var18_3) continue block2;
                            if (!var18_3) continue;
                        }
                        var5_8 = this.a(var13_14, 0, var10_7, var14_15);
                        var7_10 = 0;
                        if (var5_8.size() != 0) {
                            var16_17 = var5_8.a();
                            while (var16_17.f()) {
                                v3 = this.e[var16_17.a().b()];
                                if (!var18_3) {
                                    if (v3 > 0) {
                                        ++var7_10;
                                    }
                                    var16_17.g();
                                    if (!var18_3) continue;
                                }
                                break;
                            }
                        } else {
                            v3 = this.c.c(var13_14).k() - 1;
                        }
                        v4 = var9_11 = (var6_9 = v3) > var7_10;
                        if (var9_11) {
                            var8_6 += var6_9 - var7_10;
                            this.b(var13_14);
                            var5_8 = this.a(var13_14, 1, var10_7, null);
                            this.d.a(var5_8, var13_14);
                            if (!var18_3) continue block0;
                        }
                        var12_13.g();
                        if (!var18_3) continue;
                    }
                    break block1;
                    break;
                } while (true);
                var3_4 = true;
                if (!var18_3) break;
            }
            var10_7.b();
            var10_7.e();
        }
        if (var8_6 == 0) {
            o.a(this, 0, "  no improvement gained by rerouting edges");
            if (var18_3 == false) return;
        }
        o.a(this, 0, new StringBuffer().append("  improvement: ").append(var8_6).append(" crossing(s) less").toString());
    }

    private void b(d d2) {
        boolean bl2 = N.d;
        y y2 = new y();
        C c2 = this.c.c(d2);
        while (c2.f()) {
            d d3 = c2.a();
            if (d3.d() != d2.d()) {
                y2.add(d3.d());
            }
            this.c.a(d3);
            c2.g();
            if (!bl2) continue;
        }
        c2 = y2.a();
        do {
            if (!c2.f()) return;
            this.c.h(c2.e());
            c2.g();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    public void a(y.c.i var1_1, q var2_2, q var3_3, boolean var4_4, int[] var5_5, int[] var6_6, d[] var7_7) {
        block8 : {
            var18_8 = N.d;
            var8_9 = var1_1.e();
            while (this.b.length < var8_9) {
                this.b = new M[2 * this.b.length];
                if (!var18_8) continue;
            }
            for (var9_10 = 0; var9_10 < var8_9; ++var9_10) {
                var7_7[var9_10] = null;
                var6_6[var9_10] = Integer.MAX_VALUE;
                if (!var18_8) {
                    if (!var18_8) continue;
                }
                break block8;
            }
            var9_10 = var2_2.d();
            var6_6[var9_10] = 0;
            this.a.a();
        }
        this.b[var9_10] = this.a.a(0, var2_2, this.b[var9_10], var9_10);
        block2 : do {
            if (this.a.c() != false) return;
            var10_11 = this.a.b();
            this.a.a(var10_11);
            var11_12 = var10_11.b;
            if (var11_12 == var3_3) {
                return;
            }
            var12_13 = var10_11.c;
            var13_14 = var6_6[var12_13];
            v0 = var14_15 = var11_12.f();
            do lbl-1000: // 3 sources:
            {
                block9 : {
                    if (var14_15 == null) continue block2;
                    var15_16 = var14_15.d();
                    var16_17 = var15_16.d();
                    var17_18 = var13_14 + var5_5[var14_15.b()];
                    v0 = var7_7[var16_17];
                    if (var18_8) ** GOTO lbl-1000
                    if (v0 != null || var15_16 == var2_2) ** GOTO lbl-1000
                    var6_6[var16_17] = var17_18;
                    this.b[var16_17] = this.a.a(var17_18, var15_16, this.b[var16_17], var16_17);
                    if (var18_8) lbl-1000: // 2 sources:
                    {
                        if (var17_18 >= var6_6[var16_17]) break block9;
                        var6_6[var16_17] = var17_18;
                        this.a.a(this.b[var16_17], var17_18);
                    }
                    var7_7[var16_17] = var14_15;
                }
                var14_15 = var14_15.g();
            } while (!var18_8);
            break;
        } while (true);
    }

    static D a(J j2) {
        return j2.c;
    }
}

