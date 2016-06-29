/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.c.d;
import y.c.e;
import y.c.q;
import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.aq;
import y.f.e.a.ax;
import y.f.e.a.c;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.w;

class ae
implements ax {
    private int a = 1;

    ae() {
    }

    public void a(int n2) {
        this.a = n2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public k a(m var1_1, l var2_2, a var3_3) {
        var24_4 = af.b;
        var4_5 = var1_1.j();
        var5_6 = var1_1.a();
        var3_3.a();
        var6_7 = var4_5.j();
        do {
            if (var6_7.f() == false) return var3_3;
            var7_8 = var6_7.a();
            var8_9 = var7_8.a(var4_5);
            if (var8_9 == var4_5) ** GOTO lbl29
            var9_10 = var2_2.b();
            var10_11 = var9_10.a(var8_9);
            var11_12 = var9_10.a(var7_8).b();
            var13_13 = var10_11.a();
            var14_14 = var13_13.d() - var5_6.d();
            var20_17 = Math.sqrt(var14_14 * var14_14 + (var16_15 = var13_13.e() - var5_6.e()) * var16_15 + (var18_16 = var13_13.f() - var5_6.f()) * var18_16);
            if (var20_17 < 0.001) ** GOTO lbl29
            if (var11_12 == 0.0) {
                var11_12 = 0.001;
            }
            switch (this.a) {
                case 1: {
                    var22_18 = 1.0 / var11_12;
                    if (!var24_4) ** GOTO lbl28
                }
                case 2: {
                    var22_18 = var20_17 / (var11_12 * var11_12);
                    if (!var24_4) ** GOTO lbl28
                }
            }
            var22_18 = c.a(var20_17 / var11_12, this.a) / var20_17;
lbl28: // 3 sources:
            var3_3.a(var14_14 * var22_18, var16_15 * var22_18, var18_16 * var22_18);
lbl29: // 3 sources:
            var6_7.g();
        } while (!var24_4);
        return var3_3;
    }
}

