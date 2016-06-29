/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import y.d.m;
import y.d.s;
import y.d.t;
import y.d.v;
import y.d.z;
import y.f.d.a;

class w {
    /*
     * Unable to fully structure code
     */
    static double[] a(v var0, t var1_1) {
        block5 : {
            var32_2 = a.f;
            var2_3 = new double[6];
            var3_4 = 0.0;
            var5_5 = var0.j();
            if (!var5_5.f()) {
                return null;
            }
            var6_6 = var5_5.a().c();
            var7_7 = t.a(var1_1.a(), var1_1.b(), var6_6.a(), var6_6.b());
            var2_3[0] = var6_6.a();
            var2_3[1] = var6_6.b();
            var2_3[2] = var7_7;
            var2_3[3] = 0.0;
            var2_3[4] = 0.0;
            var2_3[5] = 0.0;
            var9_8 = 0;
            var10_9 = 0.0;
            while (var5_5.f()) {
                var12_10 = var5_5.a();
                var13_11 = var12_10.c();
                var14_12 = var12_10.d();
                var15_13 = new z(var14_12, var13_11);
                var16_14 = var15_13.d();
                var3_4 += var16_14;
                var15_13.c();
                var18_15 = new y.d.a(var13_11, var15_13);
                var19_16 = new y.d.a(var1_1, z.c(var15_13));
                var20_17 = y.d.a.a(var18_15, var19_16);
                var21_18 = new z(var20_17, var13_11);
                var22_19 = new z(var14_12, var13_11);
                var23_20 = z.c(var22_19, var15_13);
                var25_21 = z.c(var21_18, var15_13);
                v0 = var25_21 DCMPG 0.0;
                if (var32_2 != 0) break block5;
                if (v0 > 0) ** GOTO lbl39
                var27_22 = t.a(var1_1, var13_11);
                var31_24 = var13_11;
                var29_23 = 0.0;
                if (var32_2 == 0) ** GOTO lbl47
lbl39: // 2 sources:
                if (var25_21 < var23_20) ** GOTO lbl-1000
                var27_22 = t.a(var1_1, var14_12);
                var31_24 = var14_12;
                var29_23 = 1.0;
                if (var32_2 != 0) lbl-1000: // 2 sources:
                {
                    var27_22 = t.a(var1_1, var20_17);
                    var31_24 = var20_17;
                    var29_23 = var25_21 / var23_20;
                }
lbl47: // 4 sources:
                if (var27_22 < var7_7) {
                    var7_7 = var27_22;
                    var2_3[0] = var31_24.a();
                    var2_3[1] = var31_24.b();
                    var2_3[2] = var7_7;
                    var2_3[3] = var9_8;
                    var2_3[4] = var29_23;
                    var2_3[5] = var16_14 * var29_23 + var10_9;
                }
                ++var9_8;
                var10_9 = var3_4;
                var5_5.g();
                if (var32_2 == 0) continue;
            }
            v0 = var3_4 DCMPL 0.0;
        }
        if (v0 > 0) {
            var2_3[5] = var2_3[5] / var3_4;
            if (var32_2 == 0) return var2_3;
        }
        var2_3[5] = 0.0;
        return var2_3;
    }
}

