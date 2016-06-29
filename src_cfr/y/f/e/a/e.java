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

final class E
implements ax {
    private int a = 1;
    private int b = 1;
    private double c = 1.0;

    E() {
    }

    public void a(int n2) {
        this.a = n2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public k a(m var1_1, l var2_2, a var3_3) {
        var27_4 = af.b;
        var4_5 = var1_1.j();
        var5_6 = var1_1.a();
        var6_7 = var1_1.l();
        var3_3.a();
        var7_8 = var4_5.j();
        do {
            block11 : {
                if (var7_8.f() == false) return var3_3;
                var8_9 = var7_8.a();
                var9_10 = var8_9.a(var4_5);
                if (var9_10 == var4_5) ** GOTO lbl49
                var10_11 = var2_2.b();
                var11_12 = var10_11.a(var9_10);
                var12_13 = var10_11.a(var8_9).b();
                var14_14 = this.a;
                var15_15 = var11_12.l();
                v0 = var6_7;
                v1 = var15_15;
                block5 : while (v0 != v1) {
                    var12_13 *= this.c;
                    var14_14 = this.b;
                    if (!var1_1.k() && !var11_12.k()) break;
                    for (var16_16 = var11_12.l(); var16_16 != null; var16_16 = var16_16.l()) {
                        v0 = var16_16;
                        v1 = var1_1;
                        if (var27_4) continue block5;
                        if (v0 != v1) {
                            if (!var27_4) continue;
                        }
                        break block11;
                    }
                    for (var16_16 = var6_7; var16_16 != null; var16_16 = var16_16.l()) {
                        v0 = var16_16;
                        v1 = var11_12;
                        if (var27_4) continue block5;
                        if (v0 != v1) {
                            if (!var27_4) continue;
                        }
                        break block11;
                    }
                }
                if ((var23_20 = Math.sqrt((var17_17 = (var16_16 = var11_12.a()).d() - var5_6.d()) * var17_17 + (var19_18 = var16_16.e() - var5_6.e()) * var19_18 + (var21_19 = var16_16.f() - var5_6.f()) * var21_19)) < 0.001) ** GOTO lbl49
                if (var12_13 == 0.0) {
                    var12_13 = 0.001;
                }
                switch (var14_14) {
                    case 1: {
                        var25_21 = 1.0 / var12_13;
                        if (!var27_4) ** GOTO lbl48
                    }
                    case 2: {
                        var25_21 = var23_20 / (var12_13 * var12_13);
                        if (!var27_4) ** GOTO lbl48
                    }
                }
                var25_21 = c.a(var23_20 / var12_13, this.a) / var23_20;
lbl48: // 3 sources:
                var3_3.a(var17_17 * var25_21, var19_18 * var25_21, var21_19 * var25_21);
            }
            var7_8.g();
        } while (!var27_4);
        return var3_3;
    }
}

