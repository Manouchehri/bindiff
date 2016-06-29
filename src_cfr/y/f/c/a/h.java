/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.q;
import y.f.c.a.E;
import y.f.c.a.K;
import y.f.c.a.N;
import y.f.c.a.dg;
import y.g.e;

class H
implements K {
    private final int[] a;
    private final int[] b;
    private final int[] c;
    private final E d;

    H(E e2, int[] arrn, int[] arrn2, int[] arrn3) {
        this.d = e2;
        this.a = arrn;
        this.b = arrn2;
        this.c = arrn3;
    }

    /*
     * Unable to fully structure code
     */
    public int compare(Object var1_1, Object var2_2) {
        var10_3 = N.x;
        if (!(var1_1 instanceof q)) ** GOTO lbl-1000
        var3_5 = var4_4 = this.a[((q)var1_1).d()];
        var7_6 = false;
        if (var10_3) lbl-1000: // 2 sources:
        {
            var9_7 = (dg)var1_1;
            var3_5 = this.b[var9_7.u];
            var4_4 = this.c[var9_7.u];
            v0 = var7_6 = var3_5 != var4_4;
        }
        if (!(var2_2 instanceof q)) ** GOTO lbl-1000
        var5_9 = var6_8 = this.a[((q)var2_2).d()];
        var8_10 = false;
        if (var10_3) lbl-1000: // 2 sources:
        {
            var9_7 = (dg)var2_2;
            var5_9 = this.b[var9_7.u];
            var6_8 = this.c[var9_7.u];
            v1 = var8_10 = var5_9 != var6_8;
        }
        if (!var7_6 && !var8_10) {
            return e.a(var4_4, var6_8);
        }
        if (var4_4 < var5_9) {
            return -1;
        }
        if (var6_8 < var3_5) {
            return 1;
        }
        if (var7_6 && var8_10) {
            if (var4_4 <= var5_9) {
                return -1;
            }
            if (var6_8 > var3_5) return 0;
            return 1;
        }
        if (var7_6) {
            if (var5_9 >= var4_4) {
                return -1;
            }
            if (var6_8 > var3_5) return 0;
            return 1;
        }
        if (var3_5 >= var6_8) {
            return 1;
        }
        if (var4_4 > var5_9) return 0;
        return -1;
    }
}

