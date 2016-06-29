/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.c.p;
import y.c.q;
import y.d.t;
import y.f.X;
import y.f.aE;
import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.g.e;

final class cY
implements Comparator {
    private final float[] a;

    /*
     * Unable to fully structure code
     */
    public cY(X var1_1, aU var2_2, aV var3_3) {
        var13_4 = N.x;
        super();
        this.a = new float[var1_1.h()];
        var4_5 = 0;
        block4 : do {
            if (var4_5 >= var2_2.b()) return;
            var5_6 = var2_2.a(var4_5);
            var6_7 = 0;
            for (var7_8 = var5_6.d().k(); var7_8 != null; var7_8 = var7_8.a(), ++var6_7) {
                v0 = var7_8.c();
                block6 : do {
                    var8_9 = (q)v0;
                    if (var13_4) continue block4;
                    for (var9_10 = var8_9.f(); var9_10 != null; var9_10 = var9_10.g()) {
                        var10_11 = var3_3.a(var9_10).c();
                        var12_13 = var1_1.n(var9_10);
                        v0 = var10_11;
                        if (var13_4) continue block6;
                        if (v0 != null && !var10_11.g()) ** GOTO lbl22
                        var11_12 = (float)(var12_13.a / 10000.0);
                        if (!var13_4) ** GOTO lbl30
lbl22: // 2 sources:
                        switch (var10_11.b()) {
                            case 4: {
                                var11_12 = 0.3f - (float)(var12_13.b / 10000.0);
                                if (!var13_4) ** GOTO lbl30
                            }
                            case 8: {
                                var11_12 = -0.3f + (float)(var12_13.b / 10000.0);
                                if (!var13_4) ** GOTO lbl30
                            }
                        }
                        var11_12 = (float)(var12_13.a / 10000.0);
lbl30: // 4 sources:
                        this.a[var9_10.b()] = (float)var6_7 + var11_12;
                        if (!var13_4) continue;
                    }
                    break;
                } while (true);
                if (!var13_4) continue;
            }
            ++var4_5;
        } while (!var13_4);
    }

    public int compare(Object object, Object object2) {
        return e.a(this.a[((d)object).b()], this.a[((d)object2).b()]);
    }
}

