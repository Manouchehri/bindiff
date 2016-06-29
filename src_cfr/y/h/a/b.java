/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import y.c.d;
import y.c.i;
import y.c.l;
import y.c.o;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.a.t;
import y.h.a.v;

class B
implements o {
    private final v a;

    B(v v2) {
        this.a = v2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void onGraphEvent(l var1_1) {
        var13_2 = v.a;
        switch (var1_1.a()) {
            case 12: {
                this.a.a(new t(this.a, 10, null, (Object)null));
                if (var13_2 == 0) return;
            }
            case 13: {
                this.a.a(new t(this.a, 11, null, (Object)null));
                if (var13_2 == 0) return;
            }
            case 2: {
                var2_3 = (q)var1_1.b();
                if (this.a.k((q)var2_3)) {
                    this.a.b(new y(this.a.p((q)var2_3)));
                    this.a.g((q)var2_3);
                }
                if (this.a.k((q)(var3_4 = this.a.n((q)var2_3)))) {
                    this.a.c(new y((q)var2_3), this.a.e(var1_1.c()));
                }
                var4_5 = v.a(this.a, var1_1.c());
                var4_5.b((q)var1_1.b());
                this.a.a(new t(this.a, 1, var1_1.c(), var1_1.b()));
                if (var13_2 == 0) return;
            }
            case 3: {
                var2_3 = (q)var1_1.b();
                var3_4 = (q)v.b(this.a).get(var2_3);
                v.c(this.a).a((q)var3_4);
                v.b(this.a).remove(var2_3);
                if (var13_2 == 0) return;
            }
            case 0: 
            case 6: {
                var2_3 = (q)var1_1.b();
                var3_4 = var1_1.c();
                var4_5 = (q)v.d(this.a).get(var3_4);
                var5_6 = v.c(this.a).d();
                v.b(this.a).put(var2_3, var5_6);
                v.e(this.a).a((Object)var5_6, var2_3);
                v.c(this.a).a(var5_6, (q)var4_5);
                this.a.a(new t(this.a, 0, var1_1.c(), var1_1.b()));
                if (var13_2 == 0) return;
            }
            case 11: {
                var2_3 = (y)var1_1.b();
                if (var2_3.size() <= 0) return;
                var3_4 = var2_3.b().e();
                var4_5 = var1_1.c();
                var5_6 = this.a.e((i)var3_4);
                var6_7 = this.a.e((i)var4_5);
                if (!this.a.b(var6_7, var5_6)) ** GOTO lbl64
                var7_8 = v.a(this.a, var5_6);
                var8_9 = v.a(this.a, (y)var2_3);
                var9_10 = var8_9.a();
                while (var9_10.f()) {
                    var10_11 = var9_10.e();
                    var11_12 = v.a(this.a, var10_11);
                    var12_13 = var11_12.f();
                    v0 = this.a;
                    if (var13_2 == 0) {
                        block18 : {
                            if (v0.j(var10_11)) {
                                v.c(this.a).a(var12_13, var11_12, (d)null, 1, var7_8, var7_8.g(), 1);
                                if (var13_2 == 0) break block18;
                            }
                            v.c(this.a).a(var12_13, var11_12, (d)null, 1, var7_8, var7_8.i(), 0);
                        }
                        var9_10.g();
                        if (var13_2 == 0) continue;
                    }
                    ** GOTO lbl62
                }
                v0 = this.a;
lbl62: // 2 sources:
                v0.a(new t(this.a, 3, v.c(this.a, v.b(this.a, var7_8)), (Object)var8_9));
                if (var13_2 == 0) return;
lbl64: // 2 sources:
                var7_8 = v.a(this.a, this.a.n(var6_7));
                var8_9 = v.a(this.a, (y)var2_3);
                var9_10 = var8_9.a();
                while (var9_10.f()) {
                    var10_11 = var9_10.e();
                    var11_12 = v.a(this.a, var10_11);
                    var12_13 = var11_12.f();
                    v1 = this.a;
                    if (var13_2 == 0) {
                        block19 : {
                            if (v1.j(var10_11) || this.a.k(var10_11)) {
                                v.c(this.a).a(var12_13, var11_12, (d)null, 1, var7_8, var7_8.g(), 1);
                                if (var13_2 == 0) break block19;
                            }
                            v.c(this.a).a(var12_13, var11_12, (d)null, 1, var7_8, var7_8.i(), 0);
                        }
                        var9_10.g();
                        if (var13_2 == 0) continue;
                    }
                    ** GOTO lbl82
                }
                v1 = this.a;
lbl82: // 2 sources:
                v1.a(new t(this.a, 3, (i)var4_5, (Object)var8_9));
            }
        }
    }
}

