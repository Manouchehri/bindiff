/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import y.a.h;
import y.c.A;
import y.c.c;
import y.c.f;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.c.E;
import y.f.c.Q;
import y.f.c.R;
import y.f.c.a;
import y.f.c.e;
import y.f.c.v;
import y.g.I;

class J
implements Q,
R,
v {
    R c;
    Q d;
    v e;
    y f;
    y g;
    private final E a;

    J(E e2) {
        this.a = e2;
    }

    void a(y y2) {
        this.f = y2;
    }

    void b(y y2) {
        this.g = y2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int a(X var1_1, A var2_2, f var3_3) {
        block25 : {
            var14_4 = a.i;
            var4_5 = new I(var1_1);
            var5_6 = false;
            var6_7 = false;
            var7_8 = 0;
            if (this.f != null && this.f.size() > 0) {
                for (var8_9 = this.f.k(); var8_9 != null; var8_9 = var8_9.a()) {
                    var9_11 = (q)var8_9.c();
                    v0 = var1_1.f(var9_11);
                    if (!var14_4) {
                        if (!v0) continue;
                        var2_2.a((Object)var9_11, 0);
                        var4_5.a(var9_11);
                        var5_6 = true;
                        if (!var14_4) continue;
                    }
                    break;
                }
            } else if (this.g != null && this.g.size() > 0) {
                for (var8_9 = this.g.k(); var8_9 != null; var8_9 = var8_9.a()) {
                    var9_11 = (q)var8_9.c();
                    v0 = var1_1.f(var9_11);
                    if (!var14_4) {
                        if (!v0) continue;
                        var4_5.a(var9_11);
                        var6_7 = true;
                        if (!var14_4) continue;
                    }
                    break;
                }
            } else {
                v0 = var5_6;
            }
            var7_8 = (v0 != false ? 1 : 0) + (var6_7 != false ? 1 : 0);
            if (this.c instanceof e) {
                var9_12 = 1;
                if (!var14_4) break block25;
            }
            var9_12 = h.a((i)var1_1, this.a.n);
        }
        if (var9_12 <= 1) ** GOTO lbl58
        var8_10 = 0;
        var10_13 = new I(var1_1);
        for (var11_14 = var9_12 - 1; var11_14 >= 0; --var11_14) {
            v1 = var1_1.o();
            if (!var14_4) {
                block26 : {
                    var12_18 = v1;
                    while (var12_18.f()) {
                        var13_19 = var12_18.e();
                        v2 = this.a.n.a(var13_19);
                        v3 = var11_14;
                        if (!var14_4) {
                            if (v2 != v3) {
                                var10_13.a(var13_19);
                            }
                            var12_18.g();
                            if (!var14_4) continue;
                        }
                        break block26;
                    }
                    v2 = var8_10;
                    v3 = this.c.a(var1_1, var2_2, var3_3);
                }
                var8_10 = Math.max(v2, v3);
                var10_13.f();
                if (!var14_4) continue;
            }
            ** GOTO lbl62
lbl58: // 2 sources:
            var8_10 = this.c.a(var1_1, var2_2, var3_3);
            break;
        }
        if (var5_6) {
            v1 = var10_13 = var1_1.o();
lbl62: // 3 sources:
            while (var10_13.f()) {
                var11_15 = var10_13.e();
                var2_2.a((Object)var11_15, var2_2.a(var11_15) + 1);
                var10_13.g();
                if (!var14_4) {
                    if (!var14_4) continue;
                }
                break;
            }
        } else {
            var4_5.f();
        }
        if (var5_6) {
            for (var10_13 = this.f.k(); var10_13 != null; var10_13 = var10_13.a()) {
                var11_16 = (q)var10_13.c();
                v4 = var1_1.f(var11_16);
                if (!var14_4) {
                    if (!v4) continue;
                    var2_2.a((Object)var11_16, 0);
                    if (!var14_4) continue;
                }
                break;
            }
        } else {
            v4 = var6_7;
        }
        if (v4) {
            for (var10_13 = this.g.k(); var10_13 != null; var10_13 = var10_13.a()) {
                var11_17 = (q)var10_13.c();
                v5 = (int)var1_1.f(var11_17) ? 1 : 0;
                if (var14_4 != false) return v5;
                if (v5 == 0) continue;
                var2_2.a((Object)var11_17, var8_10 + var7_8 - 1);
                if (!var14_4) continue;
            }
        }
        v5 = var8_10 + var7_8;
        return v5;
    }

    @Override
    public y[] a(X x2, A a2, int n2) {
        return this.d.a(x2, a2, n2);
    }

    @Override
    public void a(X x2, y[] arry, c c2) {
        c c3 = c2;
        this.e.a(x2, arry, c3);
    }

    @Override
    public void a(A a2) {
        this.e.a(a2);
    }

    @Override
    public void a(double d2) {
        this.e.a(d2);
    }

    @Override
    public void d(double d2) {
        this.e.d(d2);
    }

    @Override
    public void b(double d2) {
        this.e.b(d2);
    }

    @Override
    public void c(double d2) {
        this.e.c(d2);
    }
}

