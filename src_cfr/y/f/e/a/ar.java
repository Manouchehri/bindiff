/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.c.q;
import y.c.x;
import y.f.X;
import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ax;
import y.f.e.a.c;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.w;

class ar
implements ax {
    private int a = 2;

    ar() {
    }

    public void a(int n2) {
        this.a = n2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public k a(m var1_1, l var2_2, a var3_3) {
        var29_4 = af.b;
        var4_5 = var1_1.j();
        var5_6 = var1_1.a();
        var6_7 = var2_2.b();
        var7_8 = var1_1.h();
        var9_9 = var6_7.f().o();
        do {
            if (var9_9.f() == false) return var3_3;
            var10_10 = var9_9.e();
            if (var10_10 == var4_5 || (var11_11 = var6_7.a(var10_10)).n()) ** GOTO lbl27
            var12_12 = var11_11.a();
            var13_13 = var5_6.d() - var12_12.d();
            var19_16 = Math.sqrt(var13_13 * var13_13 + (var15_14 = var5_6.e() - var12_12.e()) * var15_14 + (var17_15 = var5_6.f() - var12_12.f()) * var17_15);
            if (var19_16 == 0.0) ** GOTO lbl27
            var21_17 = var11_11.h();
            var23_18 = Math.max(var19_16 - (var7_8 + var21_17), 0.001);
            var25_19 = var2_2.g();
            switch (this.a) {
                case 1: {
                    var27_20 = var25_19 / (var23_18 * var19_16);
                    if (!var29_4) ** GOTO lbl26
                }
                case 2: {
                    var27_20 = var25_19 * var25_19 / (var23_18 * var23_18 * var19_16);
                    if (!var29_4) ** GOTO lbl26
                }
            }
            var27_20 = c.a(var25_19 / var23_18, this.a) / var19_16;
lbl26: // 3 sources:
            var3_3.a(var13_13 * var27_20, var15_14 * var27_20, var17_15 * var27_20);
lbl27: // 3 sources:
            var9_9.g();
        } while (!var29_4);
        return var3_3;
    }
}

