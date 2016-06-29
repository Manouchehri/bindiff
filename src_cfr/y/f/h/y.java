/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import y.c.A;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.h;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.f.h.D;
import y.f.h.N;

public class y {
    private f a = new f();
    private h b;
    private i c;

    /*
     * Unable to fully structure code
     */
    public void a(i var1_1) {
        var10_2 = N.d;
        this.c = var1_1;
        this.b = this.c.u();
        var2_3 = this.c.t();
        var3_4 = this.c.o();
        while (var3_4.f()) {
            block6 : {
                var4_5 = var3_4.e();
                if (var10_2 != false) return;
                var5_6 = var4_5.j();
                while (var5_6.f()) {
                    var6_7 = var5_6.a();
                    var7_8 = var6_7.a(var4_5);
                    v0 = var8_9 = (d)var2_3.b(var7_8);
                    if (var10_2) ** GOTO lbl30
                    if (v0 == var6_7) ** GOTO lbl25
                    if (var8_9 != null) ** GOTO lbl-1000
                    var2_3.a((Object)var7_8, var6_7);
                    if (var10_2) lbl-1000: // 2 sources:
                    {
                        if (this.b.b(var8_9) == null) {
                            this.b.a((Object)var8_9, new f());
                        }
                        var9_10 = (f)this.b.b(var8_9);
                        var9_10.add(var6_7);
                        this.a.c(var6_7);
                        this.c.d(var6_7);
                    }
lbl25: // 4 sources:
                    var5_6.g();
                    if (!var10_2) continue;
                }
                var5_6 = var4_5.j();
                while (var5_6.f()) {
                    v0 = var6_7 = var5_6.a();
lbl30: // 2 sources:
                    var7_8 = v0.a(var4_5);
                    var2_3.a((Object)var7_8, null);
                    var5_6.g();
                    if (!var10_2) {
                        if (!var10_2) continue;
                    }
                    break block6;
                }
                var3_4.g();
            }
            if (!var10_2) continue;
        }
        this.c.a(var2_3);
    }

    public void a(D d2, f f2) {
        boolean bl2 = N.d;
        e e2 = this.a.a();
        do {
            if (!e2.f()) return;
            f2.add(e2.a());
            e2.g();
        } while (!bl2);
    }

    public void a() {
        this.c.a(this.b);
    }
}

