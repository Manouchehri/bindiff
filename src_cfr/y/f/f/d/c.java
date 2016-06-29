/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import y.c.A;
import y.c.D;
import y.c.c;
import y.c.q;
import y.c.x;
import y.d.n;
import y.d.t;
import y.d.y;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.f.d.e;
import y.f.f.d.f;
import y.f.f.d.o;
import y.g.M;

public class C {
    private e a = null;
    private A b = null;

    /*
     * Unable to fully structure code
     */
    public void a(X var1_1, int var2_2) {
        var18_3 = o.p;
        this.a = new e(var1_1, var2_2);
        var3_4 = var1_1.c(U.b);
        this.b = M.a();
        if (var3_4 == null) return;
        var4_5 = var1_1.o();
        do lbl-1000: // 3 sources:
        {
            if (var4_5.f() == false) return;
            var5_6 = var4_5.e();
            var6_7 = var1_1.s(var5_6);
            var7_8 = (S[])var3_4.b(var4_5.e());
            if (var7_8 == null || var7_8.length <= 0) ** GOTO lbl19
            for (var8_9 = 0; var8_9 < var7_8.length; ++var8_9) {
                var9_11 = var7_8[var8_9];
                var10_13 = this.a(var9_11.a().h(), var1_1.l(var5_6));
                var6_7 = this.a(var6_7, var10_13);
                if (var18_3) ** GOTO lbl-1000
                if (!var18_3) continue;
            }
lbl19: // 3 sources:
            if (!(var8_10 = var1_1.s(var5_6)).equals(var6_7)) {
                var9_12 = var8_10.d() - var6_7.d();
                var11_14 = var6_7.d() + var6_7.b() - var8_10.d() - var8_10.b();
                var13_15 = var8_10.c() - var6_7.c();
                var15_16 = var6_7.c() + var6_7.a() - var8_10.c() - var8_10.a();
                var17_17 = this.a.a(var5_6, var9_12, var11_14, var13_15, var15_16);
                this.b.a((Object)var5_6, var17_17);
            }
            var4_5.g();
        } while (!var18_3);
    }

    /*
     * Unable to fully structure code
     */
    public D a(X var1_1, q var2_2) {
        var20_3 = o.p;
        var3_4 = new D();
        var4_5 = var1_1.c(U.b);
        var5_6 = var1_1.s(var2_2);
        v0 = var6_7 = this.b != null ? (f)this.b.b(var2_2) : null;
        if (var4_5 != null && var6_7 != null) ** GOTO lbl-1000
        var3_4.add(var5_6);
        if (var20_3) lbl-1000: // 2 sources:
        {
            var7_8 = var6_7.a();
            var9_9 = var6_7.b();
            var11_10 = var6_7.c();
            var13_11 = var6_7.d();
            var15_12 = new y(var5_6.c() + var11_10, var5_6.d() + var7_8, var5_6.a() - var11_10 - var13_11, var5_6.b() - var7_8 - var9_9);
            var3_4.add(var15_12);
            var16_13 = (S[])var4_5.b(var2_2);
            if (var16_13 != null && var16_13.length > 0) {
                for (var17_14 = 0; var17_14 < var16_13.length; ++var17_14) {
                    var18_15 = var16_13[var17_14];
                    var19_16 = this.a(var18_15.a().h(), this.a(var15_12));
                    v1 = var3_4;
                    if (var20_3 != false) return v1;
                    v1.add(var19_16);
                    if (!var20_3) continue;
                }
            }
        }
        v1 = var3_4;
        return v1;
    }

    private t a(y y2) {
        return new t(y2.c() + y2.a() * 0.5, y2.d() + y2.b() * 0.5);
    }

    private y a(y y2, t t2) {
        return new y(t2.a + y2.c, t2.b + y2.d, y2.a(), y2.b());
    }

    public void a() {
        if (this.a != null) {
            this.a.a();
        }
        this.a = null;
    }

    private y a(y y2, y y3) {
        double d2 = Math.min(y2.c(), y3.c());
        double d3 = Math.max(y2.c() + y2.a(), y3.c() + y3.a());
        double d4 = Math.min(y2.d(), y3.d());
        double d5 = Math.max(y2.d() + y2.b(), y3.d() + y3.b());
        return new y(d2, d4, d3 - d2, d5 - d4);
    }
}

