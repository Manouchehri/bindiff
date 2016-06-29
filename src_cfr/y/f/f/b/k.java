/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.b;

import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.f.b.h;
import y.f.f.b.o;
import y.f.h.D;
import y.f.h.N;
import y.f.h.p;
import y.f.k.L;
import y.g.I;

public class k {
    private h a;
    private f b;
    private I c;
    private double d = -1.0;

    public void a(double d2) {
        this.d = d2;
    }

    public void a(h h2) {
        this.a = h2;
    }

    public void a(i i2) {
        int n2 = h.a;
        c c2 = i2.c(L.a);
        this.b = new f();
        this.c = new I(i2);
        x x2 = i2.o();
        do {
            if (!x2.f()) return;
            q q2 = x2.e();
            if (c2 != null && c2.d(q2)) {
                block4 : {
                    if (q2.b() > 0) {
                        this.b.add(q2.g());
                        if (n2 == 0) break block4;
                    }
                    this.b.add(q2.f());
                }
                this.c.a(q2);
            }
            x2.g();
        } while (n2 == 0);
    }

    /*
     * Unable to fully structure code
     */
    public void a() {
        var15_1 = h.a;
        var1_2 = (X)this.a.a();
        var2_3 = (D)this.a.b();
        var3_4 = 0.0;
        var5_5 = this.b.a();
        do {
            block5 : {
                if (var5_5.f() == false) return;
                var6_6 = var5_5.a();
                var7_7 = var6_6.d();
                var8_8 = var6_6.c();
                var1_2.d(var7_7);
                var9_9 = var8_8.l();
                while (var9_9.f()) {
                    var10_10 = var9_9.a();
                    var11_12 = this.a.h(var10_10);
                    var12_13 = this.a.d(var10_10);
                    v0 = var12_13;
                    if (var15_1 != 0) break block5;
                    if (v0 <= 0) ** GOTO lbl58
                    var13_14 = var2_3.h(var2_3.k(var10_10));
                    var1_2.e(var6_6);
                    var2_3.a(var6_6, var13_14, null);
                    var1_2.a(var6_6, var10_10, null, 1, 1);
                    var14_15 = var2_3.h(var6_6);
                    var2_3.e(var6_6);
                    var2_3.m(var14_15);
                    if (!var11_12.a(o.a)) ** GOTO lbl34
                    this.a.a(var6_6, "<^");
                    this.a.a(var10_10, 1);
                    this.a.a(var6_6, var12_13 - 1);
                    this.a.a(var14_15, 4);
                    var3_4 = var1_2.p(var7_7) * 0.5;
                    if (var15_1 == 0) ** GOTO lbl56
lbl34: // 2 sources:
                    if (!var11_12.a(o.c)) ** GOTO lbl41
                    this.a.a(var6_6, ">_");
                    this.a.a(var10_10, 1);
                    this.a.a(var6_6, var12_13 - 1);
                    this.a.a(var14_15, 4);
                    var3_4 = var1_2.p(var7_7) * 0.5;
                    if (var15_1 == 0) ** GOTO lbl56
lbl41: // 2 sources:
                    if (!var11_12.a(o.b)) ** GOTO lbl-1000
                    this.a.a(var6_6, "^>");
                    this.a.a(var10_10, 1);
                    this.a.a(var6_6, var12_13 - 1);
                    this.a.a(var14_15, 4);
                    var3_4 = var1_2.q(var7_7) * 0.5;
                    if (var15_1 != 0) lbl-1000: // 2 sources:
                    {
                        if (var11_12.a(o.d) == false) throw new IllegalStateException("Unknown direction!");
                        this.a.a(var6_6, "_<");
                        this.a.a(var10_10, 1);
                        this.a.a(var6_6, var12_13 - 1);
                        this.a.a(var14_15, 4);
                        var3_4 = var1_2.q(var7_7) * 0.5;
                        if (var15_1 != 0) {
                            throw new IllegalStateException("Unknown direction!");
                        }
                    }
lbl56: // 6 sources:
                    this.a.f(var6_6);
                    if (var15_1 == 0) break;
lbl58: // 2 sources:
                    var9_9.g();
                    if (var15_1 == 0) continue;
                }
                v0 = this.d DCMPL 0.0;
            }
            if (v0 > 0) {
                this.a.n(var6_6);
                var9_9 = var7_7.f().d().b(var8_8);
                var10_11 = (int)Math.ceil(var3_4 / this.d);
                this.a.b((d)var9_9, var10_11);
                this.a.b(var2_3.h((d)var9_9), var10_11);
            }
            var5_5.g();
        } while (var15_1 == 0);
    }
}

