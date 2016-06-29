/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.c.p;
import y.c.q;
import y.c.y;
import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ax;
import y.f.e.a.c;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.w;
import y.f.e.a.z;

final class A
implements ax {
    private final z a;

    A(z z2) {
        this.a = z2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public k a(m var1_1, l var2_2, a var3_3) {
        var25_4 = af.b;
        var4_5 = this.a.a;
        var5_6 = var1_1.j();
        if (var4_5 == null) return var3_3;
        if (var4_5.d(var5_6) == false) return var3_3;
        var6_7 = var1_1.a();
        var7_8 = var2_2.b();
        var8_9 = var1_1.h();
        var10_10 = var4_5.b(var5_6).k();
        do {
            if (var10_10 == null) return var3_3;
            var11_11 = (q)var10_10.c();
            var12_12 = var7_8.a(var11_11);
            var13_13 = var12_12.a();
            var14_14 = var13_13.d() - var6_7.d();
            var20_17 = Math.sqrt(var14_14 * var14_14 + (var16_15 = var13_13.e() - var6_7.e()) * var16_15 + (var18_16 = var13_13.f() - var6_7.f()) * var18_16);
            if (var20_17 < 0.001) ** GOTO lbl30
            var22_18 = 1;
            if (var8_9 == 0.0) {
                var8_9 = 0.001;
            }
            switch (var22_18) {
                case 1: {
                    var23_19 = 1.0 / var8_9;
                    if (!var25_4) ** GOTO lbl29
                }
                case 2: {
                    var23_19 = var20_17 / (var8_9 * var8_9);
                    if (!var25_4) ** GOTO lbl29
                }
            }
            var23_19 = c.a(var20_17 / var8_9, var22_18) / var20_17;
lbl29: // 3 sources:
            var3_3.a(var14_14 * var23_19, var16_15 * var23_19, var18_16 * var23_19);
lbl30: // 2 sources:
            var10_10 = var10_10.a();
        } while (!var25_4);
        return var3_3;
    }
}

