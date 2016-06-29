/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.T;
import y.a.U;
import y.a.Y;
import y.a.h;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.q;
import y.c.x;

abstract class S {
    S() {
    }

    abstract double a(d[] var1, c var2, int var3);

    static S a() {
        return new Y(0.2, 0.4, 0.4);
    }

    static S b() {
        return new U(null);
    }

    private static int[] b(i i2, c c2, int n2) {
        int[] arrn;
        boolean bl2 = h.a;
        int[] arrn2 = new int[n2];
        x x2 = i2.o();
        while (x2.f()) {
            arrn = arrn2;
            if (bl2) return arrn;
            int n3 = c2.a(x2.e());
            arrn[n3] = arrn[n3] + 1;
            x2.g();
            if (!bl2) continue;
        }
        arrn = arrn2;
        return arrn;
    }

    /*
     * Unable to fully structure code
     */
    private static double[][] c(d[] var0, c var1_1, int var2_2) {
        var6_3 = h.a;
        var3_4 = new double[2][var2_2];
        var4_5 = 0;
        do {
            if (var4_5 >= var0.length) return var3_4;
            var5_6 = var0[var4_5];
            if (var1_1.a(var5_6.c()) != var1_1.a(var5_6.d())) ** GOTO lbl-1000
            v0 = var3_4[0];
            v1 = var1_1.a(var5_6.c());
            v0[v1] = v0[v1] + 1.0;
            if (var6_3) lbl-1000: // 2 sources:
            {
                v2 = var3_4[1];
                v3 = var1_1.a(var5_6.c());
                v2[v3] = v2[v3] + 1.0;
                v4 = var3_4[1];
                v5 = var1_1.a(var5_6.d());
                v4[v5] = v4[v5] + 1.0;
            }
            ++var4_5;
        } while (!var6_3);
        return var3_4;
    }

    static double[][] b(d[] arrd, c c2, int n2) {
        return S.c(arrd, c2, n2);
    }

    static int[] a(i i2, c c2, int n2) {
        return S.b(i2, c2, n2);
    }
}

