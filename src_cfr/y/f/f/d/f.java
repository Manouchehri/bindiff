/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import java.util.ArrayList;
import java.util.Collection;
import y.c.d;
import y.c.e;
import y.c.h;
import y.f.X;
import y.f.f.d.o;
import y.f.h.D;

public class F
extends y.f.f.b.e {
    @Override
    public void b() {
        this.d();
        super.b();
        this.i = false;
    }

    /*
     * Unable to fully structure code
     */
    protected void d() {
        var7_1 = o.p;
        var1_2 = this.b.p();
        var2_3 = this.d.p();
        do {
            if (var2_3.f() == false) return;
            var3_4 = var2_3.a();
            if (!var1_2[var3_4.b()]) ** GOTO lbl29
            var4_5 = this.c.j(this.b.a(var3_4));
            if (this.b.c(var4_5)) {
                var4_5 = this.b.a(var4_5);
            }
            if (this.b.c(var3_4)) {
                var3_4 = this.b.a(var3_4);
            }
            var5_6 = (ArrayList)this.e.b(var3_4);
            var6_7 = (ArrayList)this.e.b(var4_5);
            this.e.a((Object)var3_4, null);
            if (var6_7 == null || var5_6 == null) ** GOTO lbl24
            if (!this.b.c(var2_3.a())) ** GOTO lbl21
            var6_7.addAll(var5_6);
            this.e.a((Object)var4_5, var6_7);
            if (!var7_1) ** GOTO lbl29
lbl21: // 2 sources:
            var5_6.addAll(var6_7);
            this.e.a((Object)var4_5, var5_6);
            if (!var7_1) ** GOTO lbl29
lbl24: // 2 sources:
            if (var6_7 == null) ** GOTO lbl-1000
            this.e.a((Object)var4_5, var6_7);
            if (var7_1) lbl-1000: // 2 sources:
            {
                if (var5_6 != null) {
                    this.e.a((Object)var4_5, var5_6);
                }
            }
lbl29: // 8 sources:
            var2_3.g();
        } while (!var7_1);
    }
}

