/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ax;
import y.f.e.a.c;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

final class F
implements ax {
    F() {
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public k a(m var1_1, l var2_2, a var3_3) {
        var22_4 = af.b;
        var4_5 = var1_1.l();
        if (var4_5 == null) return var3_3;
        if (var4_5.n() != false) return var3_3;
        var5_6 = var1_1.a();
        var6_7 = var4_5.a();
        var7_8 = var6_7.d() - var5_6.d();
        var13_11 = Math.sqrt(var7_8 * var7_8 + (var9_9 = var6_7.e() - var5_6.e()) * var9_9 + (var11_10 = var6_7.f() - var5_6.f()) * var11_10);
        var15_12 = var13_11 - var4_5.i() * 0.5;
        if (var15_12 < 0.001) {
            return var3_3;
        }
        var17_13 = var4_5.i() * 0.5;
        var19_14 = 1;
        if (var17_13 == 0.0) {
            var17_13 = 0.001;
        }
        switch (var19_14) {
            case 1: {
                var20_15 = var15_12 / (var17_13 * var13_11);
                if (!var22_4) ** GOTO lbl24
            }
            case 2: {
                var20_15 = var15_12 * var15_12 / (var17_13 * var17_13 * var13_11);
                if (!var22_4) ** GOTO lbl24
            }
        }
        var20_15 = c.a(var15_12 / var17_13, var19_14) / var13_11;
lbl24: // 3 sources:
        if (var4_5.h() > var4_5.i()) {
            var20_15 *= Math.sqrt(var4_5.h() / var4_5.i());
        }
        var3_3.b(var7_8 * var20_15, var9_9 * var20_15, var11_10 * var20_15);
        return var3_3;
    }
}

