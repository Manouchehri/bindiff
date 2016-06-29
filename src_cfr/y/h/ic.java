/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.h.aB;
import y.h.ch;
import y.h.fL;
import y.h.fj;
import y.h.x;

class ic {
    static void a(ch ch2, aB aB2, boolean bl2) {
        ic.a(ch2, aB2, bl2, 3);
    }

    static byte a(ch ch2, aB aB2, boolean bl2, byte by2) {
        fL fL2 = bl2 ? aB2.getSourcePort() : aB2.getTargetPort();
        fj fj2 = bl2 ? aB2.getSourceRealizer() : aB2.getTargetRealizer();
        return ic.a(ch2, aB2, fL2.a(fj2), fL2.b(fj2), bl2, by2);
    }

    static void a(ch ch2, aB aB2, double d2, double d3, boolean bl2) {
        ic.a(ch2, aB2, d2, d3, bl2, 3);
    }

    /*
     * Unable to fully structure code
     */
    static byte a(ch var0, aB var1_1, double var2_2, double var4_3, boolean var6_4, byte var7_5) {
        if (var1_1.bendCount() <= 0) ** GOTO lbl21
        v0 = var8_6 = var6_4 != false ? var1_1.firstBend() : var1_1.lastBend();
        if (var1_1.bendCount() <= 1) ** GOTO lbl-1000
        var13_8 = var1_1.getBend(var6_4 != false ? 1 : var1_1.bendCount() - 2);
        var9_10 = var13_8.b();
        var11_12 = var13_8.c();
        if (fj.z) lbl-1000: // 2 sources:
        {
            var13_8 = var6_4 != false ? var1_1.getTargetPort() : var1_1.getSourcePort();
            var14_13 = var6_4 != false ? var1_1.getTargetRealizer() : var1_1.getSourceRealizer();
            var9_10 = var13_8.a(var14_13);
            var11_12 = var13_8.b(var14_13);
        }
        var13_9 = var8_6.b();
        var15_15 = var8_6.c();
        if (1 == var7_5 || 2 != var7_5 && Math.abs(var13_9 - var9_10) > Math.abs(var15_15 - var11_12)) {
            if (0 == var7_5) return 1;
            var8_6.a(var2_2, var11_12);
            return 1;
        }
        if (0 == var7_5) return 2;
        var8_6.a(var9_10, var4_3);
        return 2;
lbl21: // 1 sources:
        var8_7 = var6_4 != false ? var1_1.getTargetPort() : var1_1.getSourcePort();
        var9_11 = var6_4 != false ? var1_1.getTargetRealizer() : var1_1.getSourceRealizer();
        var10_16 = var8_7.a(var9_11);
        var12_17 = var8_7.b(var9_11);
        var14_14 = var10_16 - var2_2;
        var16_18 = var12_17 - var4_3;
        if (1 == var7_5 || 2 != var7_5 && Math.abs(var14_14) > Math.abs(var16_18)) {
            if (0 == var7_5) return 1;
            if (var4_3 == var12_17) return 1;
            var18_19 = ic.a(var0, var2_2 + var14_14 * 0.5);
            var1_1.addPoint(var18_19, var6_4 != false ? var4_3 : var12_17);
            var1_1.addPoint(var18_19, var6_4 != false ? var12_17 : var4_3);
            return 1;
        }
        if (0 == var7_5) return 2;
        if (var2_2 == var10_16) return 2;
        var18_20 = ic.b(var0, var4_3 + var16_18 * 0.5);
        var1_1.addPoint(var6_4 != false ? var2_2 : var10_16, var18_20);
        var1_1.addPoint(var6_4 != false ? var10_16 : var2_2, var18_20);
        return 2;
    }

    protected static double a(ch ch2, double d2) {
        if (ch2 == null) return d2;
        if (!ch2.getGridMode()) {
            return d2;
        }
        double d3 = ch2.getGridResolution();
        return Math.floor(d2 / d3 + 0.5) * d3;
    }

    protected static double b(ch ch2, double d2) {
        if (ch2 == null) return d2;
        if (!ch2.getGridMode()) {
            return d2;
        }
        double d3 = ch2.getGridResolution();
        return Math.floor(d2 / d3 + 0.5) * d3;
    }
}

