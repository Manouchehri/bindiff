/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import y.c.p;
import y.c.q;
import y.f.X;
import y.f.a;
import y.f.ah;
import y.f.b.b;
import y.f.b.c;
import y.f.e.A;
import y.f.e.d;
import y.f.e.e;
import y.f.e.i;

final class f
extends a {
    private final d a;

    private f(d d2) {
        this.a = d2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void c(X var1_1) {
        var7_2 = i.b;
        if (this.a() == null) return;
        if (!c.b(var1_1)) ** GOTO lbl33
        var2_3 = null;
        switch (this.a.o()) {
            default: {
                this.a().c(var1_1);
                if (var7_2 == false) return;
            }
            case 1: {
                var3_4 = null;
                if (var1_1.c(d.o) != null) ** GOTO lbl22
                var3_4 = var1_1.t();
                var1_1.a(d.o, var3_4);
                var4_5 = new c(var1_1);
                for (var5_6 = var4_5.b((q)var4_5.b()).k(); var5_6 != null; var5_6 = var5_6.a()) {
                    var6_7 = (q)var5_6.c();
                    var3_4.a((Object)var6_7, var4_5.d(var6_7));
                    if (!var7_2) {
                        if (!var7_2) continue;
                    }
                    ** GOTO lbl23
                }
                var4_5.c();
lbl22: // 2 sources:
                this.a().c(var1_1);
lbl23: // 2 sources:
                if (var3_4 == null) return;
                var1_1.d_(d.o);
                var1_1.a(var3_4);
                var3_4 = null;
                if (var7_2 == false) return;
            }
            case 2: 
        }
        var4_5 = new b(this.a());
        var4_5.a(new A(this.a.a()));
        var4_5.c(var1_1);
        if (var7_2 == false) return;
lbl33: // 2 sources:
        this.a().c(var1_1);
    }

    f(d d2, e e2) {
        this(d2);
    }
}

