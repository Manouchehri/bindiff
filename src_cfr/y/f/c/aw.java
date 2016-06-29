/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import y.c.A;
import y.c.D;
import y.c.d;
import y.c.f;
import y.c.p;
import y.c.q;
import y.c.x;
import y.d.t;
import y.f.X;
import y.f.c.K;
import y.f.c.a;
import y.f.c.ao;

class aw
implements ao {
    @Override
    public void a(X x2, A a2, A a3) {
        boolean bl2 = a.i;
        p p2 = x2.E().l();
        do {
            if (p2 == null) return;
            this.a(x2, (d)p2.c(), a2, a3);
            p2 = p2.b();
        } while (!bl2);
    }

    public q a(X x2, d d2, A a2, A a3) {
        q q2;
        boolean bl2 = a.i;
        q q3 = d2.c();
        q q4 = d2.d();
        int n2 = a2.a(q4) - a2.a(q3);
        if (n2 <= 1) return null;
        A a4 = K.a(x2);
        q q5 = null;
        d d3 = null;
        q q6 = q3;
        while (n2 > 1) {
            q5 = x2.d();
            a4.a((Object)q5, K.q);
            x2.b(q5, 1.0, 1.0);
            x2.b(q5, t.c);
            d3 = x2.a(q6, q5);
            q2 = q6;
            if (bl2) return q2;
            if (q2 == q3) {
                x2.a(d3, x2.n(d2));
            }
            a2.a((Object)q5, a2.a(q6) + 1);
            a3.a((Object)q5, d2);
            q6 = q5;
            --n2;
            if (!bl2) continue;
        }
        d3 = x2.a(q5, q4);
        x2.b(d3, x2.o(d2));
        x2.d(d2);
        q2 = q5;
        return q2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void b(X var1_1, A var2_2, A var3_3) {
        var12_4 = a.i;
        var4_5 = var1_1.o();
        while (var4_5.f()) {
            var5_6 = var4_5.e();
            v0 = var6_7 = (d)var3_3.b(var5_6);
            if (!var12_4) {
                if (v0 != null && !var1_1.f(var6_7)) {
                    block12 : {
                        block11 : {
                            var7_8 = var5_6.g().c();
                            while (var3_3.b(var7_8) != null) {
                                var5_6 = var7_8;
                                var7_8 = var5_6.g().c();
                                if (!var12_4) {
                                    if (!var12_4) continue;
                                }
                                break block11;
                            }
                            var1_1.e(var6_7);
                        }
                        var8_9 = var5_6.g();
                        var9_10 = new D();
                        while (var3_3.b(var8_9.d()) != null) {
                            var10_11 = var1_1.p(var8_9);
                            var9_10.add(var10_11);
                            var9_10.a(var1_1.k(var8_9));
                            var11_12 = var1_1.q(var8_9);
                            v1 = var11_12.equals(var10_11);
                            if (!var12_4) {
                                if (!v1) {
                                    var9_10.add(var11_12);
                                }
                                var8_9 = var8_9.d().f();
                                if (!var12_4) continue;
                            }
                            break block12;
                        }
                        var10_11 = var1_1.p(var8_9);
                        var9_10.add(var10_11);
                        var9_10.a(var1_1.k(var8_9));
                        var11_12 = var1_1.q(var8_9);
                        v1 = var11_12.equals(var10_11);
                    }
                    if (!v1) {
                        var9_10.add(var11_12);
                    }
                    var1_1.a(var6_7, var9_10);
                }
                var4_5.g();
                if (!var12_4) continue;
            }
            ** GOTO lbl47
        }
        var4_5 = var1_1.o();
        do {
            if (var4_5.f() == false) return;
            v0 = var3_3.b(var4_5.e());
lbl47: // 2 sources:
            if (v0 != null) {
                var1_1.a(var4_5.e());
            }
            var4_5.g();
        } while (!var12_4);
    }
}

