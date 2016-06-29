/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import y.a.m;
import y.c.A;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;
import y.f.f.b.h;
import y.f.f.c.g;
import y.f.f.c.l;
import y.f.f.c.o;
import y.f.f.c.p;

public class k
implements l {
    @Override
    public void a(h h2, p p2, p p3) {
        y.g.o.a(this, 3, "SSP Compaction");
        y.g.o.a(this, 3, "Vertical: ");
        this.a(p2);
        y.g.o.a(this, 3, "Horizontal: ");
        this.a(p3);
    }

    /*
     * Unable to fully structure code
     */
    public void a(p var1_1) {
        var16_2 = g.a;
        var2_3 = var1_1.f();
        var3_4 = var2_3.t();
        var4_5 = new int[var2_3.e()];
        m.a(var2_3, var4_5);
        var5_6 = new q[var2_3.f()];
        var6_7 = var2_3.o();
        while (var6_7.f()) {
            var7_9 = var6_7.e();
            var3_4.a((Object)var7_9, 0.0);
            var5_6[var4_5[var7_9.d()]] = var7_9;
            var6_7.g();
            if (var16_2 == 0) continue;
        }
        var6_8 = 0;
        block1 : do lbl-1000: // 3 sources:
        {
            v0 = var6_8;
            block2 : while (v0 < var5_6.length) {
                var7_9 = var5_6[var6_8];
                var8_10 = var3_4.c(var7_9);
                var1_1.b(var7_9).a((int)var8_10);
                if (var16_2 != 0) return;
                if (var8_10 > 100000.0) {
                    throw new RuntimeException("Compaction did not terminate ...");
                }
                var10_11 = var1_1.b(var7_9);
                var11_12 = var1_1.a(var10_11);
                if (var11_12 == null || var11_12.b() != var10_11 || var3_4.c(var12_13 = var11_12.a().a()) >= var8_10 - var11_12.c()) ** GOTO lbl30
                var3_4.a(var12_13, var8_10 - var11_12.c());
                var6_8 = var4_5[var12_13.d()];
                if (var16_2 == 0) ** GOTO lbl-1000
lbl30: // 2 sources:
                var12_13 = var7_9.l();
                while (var12_13.f()) {
                    var13_14 = var12_13.a();
                    var14_15 = var1_1.b(var13_14);
                    v0 = (int)(var8_10 + var14_15 DCMPL var3_4.c(var13_14.d()));
                    if (var16_2 != 0) continue block2;
                    if (v0 > 0) {
                        var3_4.a((Object)var13_14.d(), var8_10 + var14_15);
                    }
                    var12_13.g();
                    if (var16_2 == 0) continue;
                }
                ++var6_8;
                if (var16_2 == 0) continue block1;
            }
            break block1;
            break;
        } while (true);
        var2_3.a(var3_4);
    }
}

