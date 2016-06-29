/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.c.q;
import y.c.x;
import y.f.X;
import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

public class ai
implements am,
ax {
    private double a = 0.5;
    private double b = 50.0;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;

    public void a(double d2, double d3, double d4, double d5) {
        this.e = d2;
        this.f = d3;
        this.c = d4;
        this.d = d5;
        this.g = this.e + this.c / 2.0;
        this.h = this.f + this.d / 2.0;
    }

    public ai() {
        this.g = this.e + this.c / 2.0;
        this.h = this.f + this.d / 2.0;
    }

    public ai(double d2, double d3, double d4, double d5, double d6) {
        this.g = this.e + this.c / 2.0;
        this.h = this.f + this.d / 2.0;
        this.a(d2, d3, d4, d5);
        this.b = d6;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public k a(m var1_1, l var2_2, a var3_3) {
        var13_4 = af.b;
        if (this.c <= 0.0) return var3_3;
        if (this.d <= 0.0) {
            return var3_3;
        }
        var4_5 = var1_1.a();
        var5_6 = (this.c - 2.0 * this.b) / 2.0;
        var7_7 = (this.d - 2.0 * this.b) / 2.0;
        var9_8 = this.g - var4_5.d();
        var11_9 = this.h - var4_5.e();
        if (- var9_8 > var5_6 && - var11_9 > var7_7) {
            this.a(var4_5.d() - (this.g + var5_6), var4_5.e() - (this.h + var7_7), var3_3);
            return var3_3;
        }
        if (var9_8 > var5_6 && - var11_9 > var7_7) {
            this.a(- var4_5.d() + (this.g - var5_6), var4_5.e() - (this.h + var7_7), var3_3);
            var3_3.a(- var3_3.d());
            return var3_3;
        }
        if (var9_8 > var5_6 && var11_9 > var7_7) {
            this.a(- var4_5.d() + (this.g - var5_6), - var4_5.e() + (this.h - var7_7), var3_3);
            var3_3.a(- var3_3.d());
            var3_3.b(- var3_3.e());
            return var3_3;
        }
        if (- var9_8 > var5_6 && var11_9 > var7_7) {
            this.a(var4_5.d() - (this.g + var5_6), - var4_5.e() + (this.h - var7_7), var3_3);
            var3_3.b(- var3_3.e());
            return var3_3;
        }
        if (var9_8 <= 0.0) ** GOTO lbl-1000
        if (var9_8 > var5_6) {
            var3_3.a((var9_8 - var5_6) / this.b);
            return var3_3;
        }
        var3_3.a(0.0);
        if (var13_4) lbl-1000: // 2 sources:
        {
            if (- var9_8 > var5_6) {
                var3_3.a((var9_8 + var5_6) / this.b);
                return var3_3;
            }
            var3_3.a(0.0);
        }
        if (var11_9 > 0.0) {
            if (var11_9 > var7_7) {
                var3_3.b((var11_9 - var7_7) / this.b);
                return var3_3;
            }
            var3_3.b(0.0);
            if (var13_4 == false) return var3_3;
        }
        if (- var11_9 > var7_7) {
            var3_3.b((var11_9 + var7_7) / this.b);
            return var3_3;
        }
        var3_3.b(0.0);
        return var3_3;
    }

    /*
     * Unable to fully structure code
     */
    private void a(double var1_1, double var3_2, a var5_3) {
        var18_4 = af.b;
        var6_5 = 0.0;
        var8_6 = 0.0;
        var10_7 = this.b * this.a;
        if (var1_1 - var10_7 < var3_2) ** GOTO lbl8
        var6_5 = (- var1_1) / this.b;
        if (!var18_4) ** GOTO lbl20
lbl8: // 2 sources:
        if (var3_2 - var10_7 < var1_1) ** GOTO lbl11
        var8_6 = (- var3_2) / this.b;
        if (!var18_4) ** GOTO lbl20
lbl11: // 2 sources:
        if (var1_1 >= var10_7 || var3_2 >= var10_7 || Math.sqrt(var1_1 * var1_1 + var3_2 * var3_2) > var10_7) ** GOTO lbl-1000
        var6_5 = (- var1_1) / this.b;
        var8_6 = (- var3_2) / this.b;
        if (var18_4) lbl-1000: // 2 sources:
        {
            var12_8 = Math.sqrt(var10_7 * var10_7 - (var1_1 - var3_2) * (var1_1 - var3_2) / 2.0);
            var14_9 = (var1_1 + var3_2) / 2.0 - var12_8 * 0.7071067811865476;
            var16_10 = (var14_9 + var10_7) / (this.b * var10_7);
            var6_5 = (var14_9 - var1_1) * var16_10;
            var8_6 = (var14_9 - var3_2) * var16_10;
        }
lbl20: // 5 sources:
        var5_3.a(var6_5);
        var5_3.b(var8_6);
    }

    @Override
    public void a(l l2, af af2) {
        boolean bl2 = af.b;
        double d2 = this.g - af2.h();
        double d3 = this.h - af2.i();
        x x2 = af2.f().o();
        do {
            if (!x2.f()) return;
            ag ag2 = af2.c(x2.e());
            ag2.a(ag2.b() + d2);
            ag2.b(ag2.c() + d3);
            x2.g();
        } while (!bl2);
    }
}

