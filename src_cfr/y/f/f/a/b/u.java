/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import java.util.Comparator;
import y.c.d;
import y.c.i;
import y.c.p;
import y.c.q;
import y.f.f.a.a.b;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.b.a;
import y.f.f.a.b.v;
import y.f.f.a.b.y;

public class u {
    private a a;
    private i b;
    private y.f.f.a.a.p c;
    private d d = null;

    public u(a a2) {
        this.a = a2;
        this.b = this.a.d();
        this.c = this.a.b();
    }

    public void a(y.c.f f2) {
        boolean bl2 = a.c;
        this.c(f2);
        y.c.e e2 = f2.a();
        do {
            y.c.f f3;
            boolean bl3;
            if (!e2.f()) return;
            this.d = e2.a();
            if (!this.a.t(this.d) && this.a.A(this.d) >= 1 && (f3 = this.a.d(this.d)) != null && (bl3 = y.b(this.a, this.d))) {
                this.b(f3);
                y.a(this.a, this.d);
            }
            e2.g();
        } while (!bl2);
    }

    public void b(y.c.f f2) {
        boolean bl2 = a.c;
        y.c.e e2 = f2.a();
        do {
            if (!e2.f()) return;
            this.a(e2.a());
            e2.g();
        } while (!bl2);
    }

    public void a(d d2) {
        b b2;
        boolean bl2 = a.c;
        d d3 = this.a.c(d2);
        d d4 = this.a.g(d2);
        d d5 = this.a.h(d2);
        q q2 = d2.c();
        q q3 = d2.d();
        b b3 = this.c.a(q2);
        if (b3 == (b2 = this.c.a(q3)).c()) {
            this.a.b(q2, d2);
            this.a.a(q3, d3);
            this.b.a(d2);
            this.b.a(d3);
            if (!this.a.d(q3)) return;
            this.a(q3);
            if (!bl2) return;
        }
        if (b2 == b3.c()) {
            this.a.b(q3, d3);
            this.a.a(q2, d2);
            this.b.a(d2);
            this.b.a(d3);
            if (!this.a.d(q2)) return;
            this.a(q2);
            if (!bl2) return;
        }
        this.a.a(q3, d3);
        this.a.a(q2, d2);
        this.b.a(d2);
        this.b.a(d3);
        if (this.a.d(q2)) {
            this.a(q2);
        }
        if (!this.a.d(q3)) return;
        this.a(q3);
    }

    /*
     * Unable to fully structure code
     */
    private void a(q var1_1) {
        block11 : {
            var15_2 = a.c;
            if (var1_1.c() != 2) return;
            var3_3 = this.a.a(var1_1).b();
            if (!this.a.a(var3_3)) ** GOTO lbl-1000
            var2_4 = this.a.c(var3_3);
            var4_5 = var3_3;
            var3_3 = this.a.h(var2_4);
            var5_6 = this.a.c(var3_3);
            if (var15_2) lbl-1000: // 2 sources:
            {
                var5_6 = this.a.c(var3_3);
                var2_4 = this.a.g(var3_3);
                var4_5 = this.a.c(var2_4);
            }
            var8_7 = this.a.e(var2_4);
            var9_8 = this.a.f(var2_4);
            this.a.z(var8_7);
            if (var9_8.size() != 2) ** GOTO lbl-1000
            var6_9 = var8_7;
            var7_10 = this.a.c(var6_9);
            this.b.e(var6_9);
            if (var7_10 != null) {
                this.b.e(var7_10);
                if (!var15_2) break block11;
            }
            var7_10 = this.a.k(var6_9);
        }
        this.a.b(var6_9, false);
        if (var15_2) lbl-1000: // 2 sources:
        {
            var10_11 = this.a.g(var2_4);
            var11_13 = this.a.h(var3_3);
            var6_9 = this.b.a(var2_4.c(), var3_3.d());
            var7_10 = this.a.k(var6_9);
            var12_15 = var9_8.a(var6_9, this.a.j(var2_4));
            this.a.a(var6_9, (p)var12_15);
            var9_8.remove(var2_4);
            var9_8.remove(var3_3);
            if (var10_11 != null) {
                if (this.a.i(var2_4) == var10_11) {
                    this.a.c(var6_9, var10_11);
                }
                if (this.a.i(var10_11) == var2_4) {
                    this.a.c(var10_11, var6_9);
                }
            }
            if (var11_13 != null) {
                if (this.a.i(var3_3) == var11_13) {
                    this.a.c(var6_9, var11_13);
                }
                if (this.a.i(var11_13) == var3_3) {
                    this.a.c(var11_13, var6_9);
                }
            }
            this.a.b(var6_9, var8_7);
        }
        var10_12 = var6_9.c();
        var11_14 = var6_9.d();
        var12_15 = this.c.a(var10_12);
        var13_16 = this.c.a(var11_14);
        if (var13_16 != var12_15.c()) ** GOTO lbl54
        this.a.c(var10_12, var2_4, var6_9);
        this.a.e(var11_14, var5_6, var7_10);
        if (!var15_2) ** GOTO lbl60
lbl54: // 2 sources:
        if (var12_15 != var13_16.c()) ** GOTO lbl-1000
        this.a.e(var10_12, var2_4, var6_9);
        this.a.c(var11_14, var5_6, var7_10);
        if (var15_2) lbl-1000: // 2 sources:
        {
            this.a.c(var10_12, var2_4, var6_9);
            this.a.c(var11_14, var5_6, var7_10);
        }
lbl60: // 4 sources:
        this.a.z(this.d);
        var14_17 = this.c.a(var1_1);
        this.c.a(var14_17);
        this.b.a(var1_1);
    }

    private void c(y.c.f f2) {
        f2.sort(new v(this));
    }

    static a a(u u2) {
        return u2.a;
    }
}

