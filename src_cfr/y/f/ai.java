/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.c.D;
import y.c.d;
import y.c.p;
import y.d.e;
import y.d.t;
import y.f.I;
import y.f.X;
import y.f.a;

public class aI
extends a {
    private double a = 2.0;
    private boolean b;

    /*
     * Unable to fully structure code
     */
    @Override
    public void c(X var1_1) {
        var14_2 = X.j;
        this.a(var1_1);
        var2_3 = var1_1.p();
        do {
            block7 : {
                block6 : {
                    if (var2_3.f() == false) return;
                    var3_4 = var2_3.a();
                    var4_5 = var1_1.g(var3_4);
                    if (var4_5.pointCount() < 1) ** GOTO lbl47
                    var5_6 = new D();
                    var5_6.add(var1_1.p(var3_4));
                    for (var6_7 = 0; var6_7 < var4_5.pointCount(); ++var6_7) {
                        var5_6.add(var4_5.getPoint(var6_7));
                        if (!var14_2) {
                            if (!var14_2) continue;
                        }
                        break block6;
                    }
                    var5_6.add(var1_1.q(var3_4));
                    var6_7 = var5_6.size();
                }
                var7_8 = var5_6.k();
                var8_9 = (t)var7_8.c();
                var9_10 = var7_8.a();
                var10_11 = (t)var9_10.c();
                var11_12 = var9_10.a();
                while (var11_12 != null) {
                    var12_13 = (t)var11_12.c();
                    var13_14 = var11_12.a();
                    v0 = (int)this.a(var8_9, var10_11, var12_13) ? 1 : 0;
                    if (var14_2) break block7;
                    if (v0 == 0) ** GOTO lbl32
                    var5_6.h(var9_10);
                    if (!var14_2) ** GOTO lbl37
lbl32: // 2 sources:
                    if (!this.a(this.a(var8_9), this.a(var10_11), this.a(var12_13))) ** GOTO lbl-1000
                    var5_6.h(var9_10);
                    if (var14_2) lbl-1000: // 2 sources:
                    {
                        var7_8 = var9_10;
                        var8_9 = var10_11;
                    }
lbl37: // 4 sources:
                    var9_10 = var11_12;
                    var10_11 = var12_13;
                    var11_12 = var13_14;
                    if (!var14_2) continue;
                }
                v0 = var6_7;
            }
            if (v0 != var5_6.size()) {
                var5_6.g();
                var5_6.j();
                var1_1.b(var3_4, var5_6);
            }
lbl47: // 4 sources:
            var2_3.g();
        } while (!var14_2);
    }

    private boolean a(t t2, t t3, t t4) {
        if (!e.d(t2, t3, t4)) return false;
        if (!this.b) return true;
        if (!this.b(t2, t3, t4)) return false;
        return true;
    }

    private boolean b(t t2, t t3, t t4) {
        if (t2.a > t3.a != t3.a > t4.a) return false;
        if (t2.b > t3.b != t3.b > t4.b) return false;
        return true;
    }

    private t a(t t2) {
        double d2 = Math.pow(10.0, this.a);
        double d3 = Math.rint(t2.a() * d2) / d2;
        double d4 = Math.rint(t2.b() * d2) / d2;
        return new t(d3, d4);
    }
}

