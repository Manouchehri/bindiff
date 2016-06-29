/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.f.S;
import y.f.aG;
import y.f.c.a.N;

final class cC
implements Comparator {
    boolean a;

    cC(boolean bl2) {
        this.a = bl2;
    }

    /*
     * Unable to fully structure code
     */
    public int compare(Object var1_1, Object var2_2) {
        if (!this.a) ** GOTO lbl-1000
        var4_3 = ((S)var1_1).f();
        var3_4 = ((S)var2_2).f();
        if (N.x) lbl-1000: // 2 sources:
        {
            var3_4 = ((S)var1_1).f();
            var4_3 = ((S)var2_2).f();
        }
        var5_5 = var3_4.b();
        var6_6 = var4_3.b();
        var7_7 = var3_4.a();
        if (var7_7 == (var8_8 = var4_3.a())) {
            if (var5_5 == var6_6) {
                return 0;
            }
            if (var5_5 == 16) {
                return -1;
            }
            if (var6_6 == 16) {
                return 1;
            }
            if (var5_5 == 32) {
                return -1;
            }
            if (var6_6 != 32) return 0;
            return 1;
        }
        if (var7_7 == 1) {
            return -1;
        }
        if (var7_7 == 2) {
            return 1;
        }
        if (var8_8 == 1) {
            return 1;
        }
        if (var8_8 != 2) return 0;
        return -1;
    }
}

