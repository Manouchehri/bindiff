/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import y.c.C;
import y.c.D;
import y.c.p;
import y.d.e;
import y.d.t;

class A {
    /*
     * Unable to fully structure code
     */
    public static D a(D var0) {
        block10 : {
            var9_1 = t.d;
            var1_2 = new D(var0.m());
            var2_3 = new D();
            var1_2.o();
            if (var1_2.isEmpty()) {
                return var2_3;
            }
            var3_4 = (t)var1_2.g();
            var2_3.b(var3_4);
            while (!var1_2.isEmpty()) {
                v0 = var3_4.equals(var1_2.f());
                if (!var9_1) {
                    if (!v0) break;
                    var1_2.g();
                    if (!var9_1) continue;
                }
                break block10;
            }
            v0 = var1_2.isEmpty();
        }
        if (v0) {
            return var2_3;
        }
        var3_4 = (t)var1_2.g();
        var4_5 = var2_3.b(var3_4);
        var6_6 = var1_2.m();
        block1 : do {
            if (var6_6.f() == false) return var2_3;
            var5_7 = (t)var6_6.d();
            if (var5_7.equals(var3_4)) ** GOTO lbl48
            var3_4 = var5_7;
            if (var2_3.size() != 2 || !e.d((t)var2_3.f(), (t)var2_3.i(), var5_7)) ** GOTO lbl-1000
            var4_5.a(var5_7);
            if (var9_1) lbl-1000: // 2 sources:
            {
                block11 : {
                    var7_8 = var4_5;
                    while (!e.c((t)var2_3.f(var7_8).c(), (t)var7_8.c(), var5_7)) {
                        var7_8 = var2_3.f(var7_8);
                        if (var9_1) continue block1;
                        if (!var9_1) continue;
                    }
                    var8_9 = var4_5;
                    while (!e.b((t)var2_3.e(var8_9).c(), (t)var8_9.c(), var5_7)) {
                        var8_9 = var2_3.e(var8_9);
                        if (!var9_1) {
                            if (!var9_1) continue;
                        }
                        break block11;
                    }
                    while (var8_9 != var2_3.e(var7_8)) {
                        var2_3.h(var2_3.e(var7_8));
                        if (var9_1) continue block1;
                        if (!var9_1) continue;
                    }
                }
                var4_5 = var2_3.b(var5_7, var7_8);
            }
lbl48: // 4 sources:
            var6_6.g();
        } while (!var9_1);
        return var2_3;
    }
}

