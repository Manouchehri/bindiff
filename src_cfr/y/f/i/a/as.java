/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.D;
import y.c.d;
import y.d.m;
import y.d.t;
import y.d.y;
import y.f.i.a.R;
import y.f.i.a.aN;
import y.f.i.a.aT;
import y.f.i.a.ab;
import y.f.i.a.ai;
import y.f.i.a.w;

class aS
extends aT {
    private w g;
    private double h;
    private double i;
    private final boolean j;
    private double k;
    private double l;
    private Object m;
    private y n;
    private int o;
    private final aN p;

    /*
     * Unable to fully structure code
     */
    aS(aN var1_1, m var2_2, m var3_3, w var4_4, Object var5_5, int var6_6) {
        super(var4_4.c(), var2_2.b() != false ? var2_2 : var3_3, var2_2.a() != false ? var2_2 : var3_3);
        this.p = var1_1;
        this.o = var6_6;
        this.g = var4_4;
        var7_7 = var4_4.a(var6_6);
        var8_8 = var4_4.a(var6_6 + 1);
        if (!var8_8.g()) ** GOTO lbl-1000
        this.j = false;
        this.i = var7_7.e();
        this.h = var8_8.e();
        if (ab.a != 0) lbl-1000: // 2 sources:
        {
            this.j = true;
            this.i = var8_8.e();
            this.h = var7_7.e();
        }
        this.m = var5_5;
        this.k = var4_4.b() != false ? 0.0 : this.m();
        this.n = this.l();
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public Object f() {
        return this.m;
    }

    @Override
    public double b() {
        return this.h;
    }

    @Override
    public double c() {
        return this.i;
    }

    @Override
    public double d() {
        if (this.c == 3) return this.h - this.k;
        if (this.c != 1) return this.h + this.k;
        return this.h - this.k;
    }

    @Override
    public double e() {
        if (this.c == 0) return this.i - this.k;
        if (this.c != 1) return this.i + this.k;
        return this.i - this.k;
    }

    @Override
    public void a(double d2) {
        this.l = d2;
    }

    private y l() {
        if (this.c == 3) {
            return new y(this.h - this.k, this.i, this.k, this.k);
        }
        if (this.c == 2) {
            return new y(this.h, this.i, this.k, this.k);
        }
        if (this.c != 0) return new y(this.h - this.k, this.i - this.k, this.k, this.k);
        return new y(this.h, this.i - this.k, this.k, this.k);
    }

    @Override
    public y h() {
        return this.n;
    }

    /*
     * Unable to fully structure code
     */
    private double m() {
        block5 : {
            var17_1 = ab.a;
            var5_4 = aN.a(this.p) * ((var1_2 = this.a.g()) < (var3_3 = this.b.g()) ? var1_2 : var3_3);
            var7_5 = this.g.c[this.o];
            var8_6 = this.g.b[this.o];
            if (var7_5 == null) ** GOTO lbl20
            var9_7 = Math.abs(this.i - var7_5.i());
            var11_8 = Math.abs(this.i - var7_5.k());
            if (this.c != 3 && this.c != 2) ** GOTO lbl-1000
            var5_4 = Math.min(var5_4, var11_8);
            var13_9 = var9_7;
            if (var17_1 != 0) lbl-1000: // 2 sources:
            {
                var5_4 = Math.min(var5_4, var9_7);
                var13_9 = var11_8;
            }
            if (this.c == 1 || this.c == 3) {
                var15_10 = Math.abs(this.h - var7_5.h());
                if (var17_1 == 0) break block5;
            }
            var15_10 = Math.abs(this.h - var7_5.j());
        }
        var5_4 = Math.min(var5_4, var15_10 + var13_9);
lbl20: // 2 sources:
        if (var8_6 == null) return var5_4;
        var9_7 = Math.abs(this.h - var8_6.h());
        var11_8 = Math.abs(this.h - var8_6.j());
        if (this.c != 0 && this.c != 2) ** GOTO lbl-1000
        var5_4 = Math.min(var5_4, var11_8);
        var13_9 = var9_7;
        if (var17_1 != 0) lbl-1000: // 2 sources:
        {
            var5_4 = Math.min(var5_4, var9_7);
            var13_9 = var11_8;
        }
        if (this.c == 1 || this.c == 0) {
            var15_10 = Math.abs(this.i - var8_6.i());
            if (var17_1 == 0) return Math.min(var5_4, var15_10 + var13_9);
        }
        var15_10 = Math.abs(this.i - var8_6.k());
        return Math.min(var5_4, var15_10 + var13_9);
    }

    /*
     * Unable to fully structure code
     */
    public D g() {
        var10_1 = ab.a;
        var1_2 = new D();
        if (this.l < 1.0E-6) {
            var1_2.add(new t(this.h, this.i));
            return var1_2;
        }
        var2_3 = this.b.c().a;
        var8_4 = this.a.c().b;
        if (this.c != 2) ** GOTO lbl12
        var4_5 = Math.min(this.b.c().b, this.b.d().b) + this.l;
        var6_6 = Math.min(this.a.c().a, this.a.d().a) + this.l;
        if (var10_1 == 0) ** GOTO lbl22
lbl12: // 2 sources:
        if (this.c != 3) ** GOTO lbl16
        var4_5 = Math.min(this.b.c().b, this.b.d().b) + this.l;
        var6_6 = Math.max(this.a.c().a, this.a.d().a) - this.l;
        if (var10_1 == 0) ** GOTO lbl22
lbl16: // 2 sources:
        if (this.c != 1) ** GOTO lbl-1000
        var4_5 = Math.max(this.b.c().b, this.b.d().b) - this.l;
        var6_6 = Math.max(this.a.c().a, this.a.d().a) - this.l;
        if (var10_1 != 0) lbl-1000: // 2 sources:
        {
            var4_5 = Math.max(this.b.c().b, this.b.d().b) - this.l;
            var6_6 = Math.min(this.a.c().a, this.a.d().a) + this.l;
        }
lbl22: // 5 sources:
        if (this.j) {
            var1_2.add(new t(var2_3, var4_5));
            var1_2.add(new t(var6_6, var8_4));
            if (var10_1 == 0) return var1_2;
        }
        var1_2.add(new t(var6_6, var8_4));
        var1_2.add(new t(var2_3, var4_5));
        return var1_2;
    }
}

