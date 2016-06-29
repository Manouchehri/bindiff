/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import y.d.o;
import y.d.t;
import y.d.y;
import y.d.z;

public class m
implements o {
    private t a;
    private t b;
    private double c;
    private double d;
    private static double e = 1.0E-8;

    public m(t t2, t t3) {
        boolean bl2 = t.d;
        this.a = t2;
        this.b = t3;
        if (t3.a == t2.a) {
            if (t2.b < t3.b) {
                this.c = Double.MAX_VALUE;
                this.d = Double.NaN;
                if (!bl2) return;
            }
            this.c = -1.7976931348623157E308;
            this.d = Double.NaN;
            if (!bl2) return;
        }
        this.c = (t3.b - t2.b) / (t3.a - t2.a);
        this.d = t2.b - t2.a * this.c;
    }

    public boolean a() {
        if (Math.abs(this.c().a - this.d().a) >= e) return false;
        return true;
    }

    public boolean b() {
        if (Math.abs(this.c().b - this.d().b) >= e) return false;
        return true;
    }

    public t c() {
        return this.a;
    }

    public t d() {
        return this.b;
    }

    public boolean a(double d2) {
        if (this.a.b < this.b.b) {
            if (d2 <= this.a.b + e) return false;
            if (d2 >= this.b.b - e) return false;
            return true;
        }
        if (d2 <= this.b.b + e) return false;
        if (d2 >= this.a.b - e) return false;
        return true;
    }

    public boolean b(double d2) {
        if (this.a.a < this.b.a) {
            if (d2 <= this.a.a + e) return false;
            if (d2 >= this.b.a - e) return false;
            return true;
        }
        if (d2 <= this.b.a + e) return false;
        if (d2 >= this.a.a - e) return false;
        return true;
    }

    public double e() {
        return this.d;
    }

    public double f() {
        return this.c;
    }

    public double g() {
        return this.i().d();
    }

    @Override
    public y h() {
        double d2 = this.a.a < this.b.a ? this.a.a : this.b.a;
        double d3 = this.a.a > this.b.a ? this.a.a : this.b.a;
        double d4 = this.a.b < this.b.b ? this.a.b : this.b.b;
        double d5 = this.a.b > this.b.b ? this.a.b : this.b.b;
        return new y(d2, d4, d3 - d2, d5 - d4);
    }

    public boolean a(y y2) {
        return m.a(y2, this.a.a, this.a.b, this.b.a, this.b.b);
    }

    public boolean a(t t2) {
        y y2 = new y(t2.a - e, t2.b - e, 2.0 * e, 2.0 * e);
        return m.a(y2, this.a.a, this.a.b, this.b.a, this.b.b);
    }

    public boolean b(t t2) {
        y y2 = new y(t2.a - 0.01, t2.b - 0.01, 0.02, 0.02);
        return m.a(y2, this.a.a, this.a.b, this.b.a, this.b.b);
    }

    /*
     * Unable to fully structure code
     */
    public static final boolean a(y var0, double var1_1, double var3_2, double var5_3, double var7_4) {
        var21_5 = t.d;
        var9_6 = var0.c();
        var17_10 = m.a(var9_6, var11_7 = var0.d(), var13_8 = var9_6 + var0.a(), var15_9 = var11_7 + var0.b(), var1_1, var3_2);
        if (var17_10 == 0) {
            return true;
        }
        var18_11 = m.a(var9_6, var11_7, var13_8, var15_9, var5_3, var7_4);
        if (var18_11 == 0) {
            return true;
        }
        do {
            if (var17_10 == 0) return (boolean)1;
            v0 = var17_10 & var18_11;
            if (var21_5 != false) return (boolean)v0;
            if (v0 != 0) {
                return false;
            }
            if ((var17_10 & 3) == 0) ** GOTO lbl-1000
            var19_12 = var9_6;
            if ((var17_10 & 2) != 0) {
                var19_12 = var13_8;
            }
            var3_2 += (var19_12 - var1_1) * (var7_4 - var3_2) / (var5_3 - var1_1);
            var1_1 = var19_12;
            if (var21_5) lbl-1000: // 2 sources:
            {
                var19_12 = var11_7;
                if ((var17_10 & 8) != 0) {
                    var19_12 = var15_9;
                }
                var1_1 += (var19_12 - var3_2) * (var5_3 - var1_1) / (var7_4 - var3_2);
                var3_2 = var19_12;
            }
            var17_10 = m.a(var9_6, var11_7, var13_8, var15_9, var1_1, var3_2);
        } while (!var21_5);
        return (boolean)1;
    }

    /*
     * Unable to fully structure code
     */
    private static byte a(double var0, double var2_1, double var4_2, double var6_3, double var8_4, double var10_5) {
        var13_6 = t.d;
        var12_7 = 0;
        if (var8_4 >= var0) ** GOTO lbl-1000
        var12_7 = 1;
        if (var13_6) lbl-1000: // 2 sources:
        {
            if (var8_4 > var4_2) {
                var12_7 = 2;
            }
        }
        if (var10_5 < var2_1) {
            var12_7 = (byte)(var12_7 | 4);
            if (var13_6 == false) return var12_7;
        }
        if (var10_5 <= var6_3) return var12_7;
        return (byte)(var12_7 | 8);
    }

    public static t a(m m2, m m3) {
        double d2;
        if (m3.a()) {
            m m4 = m2;
            m2 = m3;
            m3 = m4;
        }
        if (m2.a()) {
            if (!m3.b(m2.c().a)) {
                return null;
            }
            double d3 = m3.f();
            if (Double.isInfinite(d3)) return null;
            if (Double.isNaN(d3)) {
                return null;
            }
            double d4 = m3.e();
            if (Double.isInfinite(d4)) return null;
            if (Double.isNaN(d4)) {
                return null;
            }
            double d5 = m3.e() + m3.f() * m2.c().a;
            if (m2.a(d5)) return new t(m2.c().a, d5);
            return null;
        }
        double d6 = m2.f();
        if (d6 == (d2 = m3.f())) {
            return null;
        }
        double d7 = (m3.e() - m2.e()) / (d6 - d2);
        if (!m2.b(d7)) return null;
        if (!m3.b(d7)) return null;
        return new t(d7, d7 * d6 + m2.e());
    }

    public z i() {
        return new z(this.b, this.a);
    }

    public double j() {
        return this.b.a - this.a.a;
    }

    public double k() {
        return this.b.b - this.a.b;
    }

    public String toString() {
        return new StringBuffer().append("SP: ").append(this.a.toString()).append(" TP: ").append(this.b.toString()).toString();
    }
}

