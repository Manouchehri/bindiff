/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.ArrayList;
import y.c.D;
import y.d.m;
import y.f.i.a.aN;
import y.f.i.a.aS;
import y.f.i.a.ab;
import y.f.i.a.ah;
import y.f.i.a.ai;
import y.f.i.a.w;

class aR {
    private final aS[] a;
    private final aN b;

    /*
     * Unable to fully structure code
     */
    aR(aN var1_1, w var2_2) {
        var9_3 = ab.a;
        super();
        this.b = var1_1;
        var3_4 = var2_2.f();
        var4_5 = new ArrayList<aS>();
        for (var5_6 = 0; var5_6 < var3_4.length - 1; ++var5_6) {
            var6_7 = var3_4[var5_6];
            var7_8 = var3_4[var5_6 + 1];
            v0 = (int)var6_7.b() ? 1 : 0;
            v1 = (int)var7_8.b() ? 1 : 0;
            if (var9_3 == 0) {
                if (v0 == v1) continue;
                var8_9 = var2_2.a(var5_6 + 1).k();
                var4_5.add(new aS(var1_1, var6_7, var7_8, var2_2, var8_9, var5_6));
                if (var9_3 == 0) continue;
            }
            ** GOTO lbl22
        }
        this.a = new aS[var4_5.size()];
        var5_6 = 0;
        do {
            v0 = var5_6;
            v1 = this.a.length;
lbl22: // 2 sources:
            if (v0 >= v1) return;
            this.a[var5_6] = (aS)var4_5.get(var5_6);
            ++var5_6;
        } while (var9_3 == 0);
    }

    public aS[] a() {
        return this.a;
    }

    public D b() {
        D d2;
        int n2 = ab.a;
        D d3 = new D();
        if (this.a == null) return d3;
        if (this.a.length < 1) {
            return d3;
        }
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            d2 = d3;
            if (n2 != 0) return d2;
            d2.a(this.a[i2].g());
            if (n2 == 0) continue;
        }
        d2 = d3;
        return d2;
    }
}

