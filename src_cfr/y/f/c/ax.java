/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import y.c.A;
import y.c.c;
import y.c.d;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.X;
import y.f.c.a;

class ax {
    double a;
    double b;

    public void a(double d2) {
        this.a = d2;
    }

    public void b(double d2) {
        this.b = d2;
    }

    /*
     * Unable to fully structure code
     */
    public void a(X var1_1, y[] var2_2, A var3_3) {
        var12_4 = a.i;
        var4_5 = 0;
        do {
            v0 = var4_5;
            block1 : do {
                if (v0 >= var2_2.length) return;
                var5_6 = var2_2[var4_5].a();
                if (!var5_6.f()) break;
                var6_7 = var5_6.e();
                var7_8 = var1_1.q(var6_7);
                var5_6.g();
                while (var5_6.f()) {
                    var9_9 = var5_6.e();
                    var10_10 = var1_1.q(var9_9);
                    v0 = (int)(var10_10 DCMPL 1.0);
                    if (var12_4) continue block1;
                    if (v0 <= 0 || var7_8 <= 1.0) ** GOTO lbl20
                    var3_3.a((Object)var6_7, this.a);
                    if (!var12_4) ** GOTO lbl30
lbl20: // 2 sources:
                    if (var10_10 >= 1.0 || var7_8 >= 1.0) ** GOTO lbl23
                    var3_3.a((Object)var6_7, this.b);
                    if (!var12_4) ** GOTO lbl30
lbl23: // 2 sources:
                    if (var7_8 >= 1.0 || var6_7.a() != 0) ** GOTO lbl26
                    var3_3.a((Object)var6_7, 0.0);
                    if (!var12_4) ** GOTO lbl30
lbl26: // 2 sources:
                    if (var10_10 >= 1.0 || var9_9.a() != 0) ** GOTO lbl-1000
                    var3_3.a((Object)var6_7, 0.0);
                    if (var12_4) lbl-1000: // 2 sources:
                    {
                        var3_3.a((Object)var6_7, this.b);
                    }
lbl30: // 6 sources:
                    var6_7 = var9_9;
                    var7_8 = var10_10;
                    var5_6.g();
                    if (!var12_4) continue;
                }
                break block1;
                break;
            } while (true);
            ++var4_5;
        } while (!var12_4);
    }

    public void a(X x2, y[] arry, c c2, A a2) {
        Object object;
        boolean bl2 = a.i;
        this.a(x2, arry, a2);
        d[] arrd = new d[x2.g()];
        d[] arrd2 = new d[x2.g()];
        x x3 = x2.o();
        while (x3.f()) {
            object = x3.e();
            Object object2 = c2.b(object);
            block1 : while (object2 == null) {
                Object object3;
                d d2;
                Object object4;
                block21 : {
                    void var9_13;
                    d d3 = object.g();
                    while (var9_13 != null) {
                        block22 : {
                            d2 = var9_13;
                            object4 = d2.c();
                            if (bl2) break block21;
                            object3 = object4;
                            while (c2.b(object3) != null) {
                                arrd2[d2.b()] = var9_13;
                                d2 = object3.g();
                                object3 = d2.c();
                                if (!bl2) {
                                    if (!bl2) continue;
                                }
                                break block22;
                            }
                            d d4 = var9_13.h();
                        }
                        if (!bl2) continue;
                    }
                    object4 = object;
                }
                d d5 = object4.f();
                void d22;
                while (d22 != null) {
                    block23 : {
                        d2 = d22;
                        object2 = d2.d();
                        if (bl2) continue block1;
                        object3 = object2;
                        while (c2.b(object3) != null) {
                            arrd[d2.b()] = d22;
                            d2 = object3.f();
                            object3 = d2.d();
                            if (!bl2) {
                                if (!bl2) continue;
                            }
                            break block23;
                        }
                        d d6 = d22.g();
                    }
                    if (!bl2) continue;
                }
                break block1;
            }
            x3.g();
            if (!bl2) continue;
        }
        int n2 = 0;
        do {
            int n3 = n2;
            block7 : do {
                if (n3 >= arry.length) return;
                object = arry[n2].a();
                if (!object.f()) break;
                q q2 = object.e();
                double d7 = x2.p(q2);
                object.g();
                while (object.f()) {
                    q q3 = object.e();
                    double d8 = x2.p(q3);
                    n3 = (int)(d8 DCMPG 1.0);
                    if (bl2) continue block7;
                    if (n3 <= 0 && d7 <= 1.0) {
                        d d9;
                        void var9_19;
                        double d10;
                        d d11;
                        boolean bl3 = false;
                        if (q3.b() == 1 && var9_19.b() == 1) {
                            d11 = var9_19.g();
                            d9 = q3.g();
                            if (c2.b(q3) != null && c2.b(var9_19) != null) {
                                d11 = arrd[d11.b()];
                                d9 = arrd[d9.b()];
                            }
                            if (d11.c() == d9.c()) {
                                d10 = Math.abs(x2.n((d)d11).a - x2.n((d)d9).a) - 0.5 * (d8 + d7);
                                if (a2.c(var9_19) > d10) {
                                    a2.a((Object)var9_19, d10);
                                }
                                bl3 = true;
                            }
                        }
                        if (q3.c() == 1 && var9_19.c() == 1) {
                            d11 = var9_19.f();
                            d9 = q3.f();
                            if (c2.b(q3) != null && c2.b(var9_19) != null) {
                                d11 = arrd2[d11.b()];
                                d9 = arrd2[d9.b()];
                            }
                            if (d11.d() == d9.d()) {
                                d10 = Math.abs(x2.o((d)d11).a - x2.o((d)d9).a) - 0.5 * (d8 + d7);
                                double d12 = a2.c(var9_19);
                                if (bl3) {
                                    d10 = Math.max(d10, d12);
                                }
                                if (d10 < d12) {
                                    a2.a((Object)var9_19, d10);
                                }
                            }
                        }
                    }
                    q q4 = q3;
                    d7 = d8;
                    object.g();
                    if (!bl2) continue;
                }
                break block7;
                break;
            } while (true);
            ++n2;
        } while (!bl2);
    }
}

