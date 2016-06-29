/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import y.d.t;

public class z {
    private double a;
    private double b;

    public z(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    public z(z z2) {
        this.a = z2.a();
        this.b = z2.b();
    }

    public z(t t2, t t3) {
        this.a = t2.a() - t3.a();
        this.b = t2.b() - t3.b();
    }

    public z(t t2) {
        this.a = t2.a();
        this.b = t2.b();
    }

    public z(double d2, double d3, double d4, double d5) {
        this.a = d2 - d4;
        this.b = d3 - d5;
    }

    public double a() {
        return this.a;
    }

    public double b() {
        return this.b;
    }

    public void c() {
        if (this.a == 0.0 && this.b == 0.0) {
            return;
        }
        double d2 = this.d();
        this.a /= d2;
        this.b /= d2;
    }

    public z a(double d2) {
        double d3 = Math.cos(d2) * this.a - Math.sin(d2) * this.b;
        double d4 = Math.sin(d2) * this.a + Math.cos(d2) * this.b;
        return new z(d3, d4);
    }

    public void a(z z2) {
        this.a += z2.a();
        this.b += z2.b();
    }

    public static z a(z z2, z z3) {
        z z4 = new z(z2);
        z4.a(z3);
        return z4;
    }

    public static t a(t t2, z z2) {
        return new t(t2.a() + z2.a(), t2.b() + z2.b());
    }

    public void b(double d2) {
        this.a *= d2;
        this.b *= d2;
    }

    public double d() {
        return Math.sqrt(this.a * this.a + this.b * this.b);
    }

    public static boolean b(z z2, z z3) {
        if (z2.a() * z3.b() - z2.b() * z3.a() <= 0.0) return false;
        return true;
    }

    public static z b(z z2) {
        z z3 = new z(z2.a(), z2.b());
        z3.c();
        return z3;
    }

    public static z c(z z2) {
        double d2 = z2.d();
        return new z((- z2.b()) / d2, z2.a() / d2);
    }

    public static double c(z z2, z z3) {
        return z2.a() * z3.a() + z2.b() * z3.b();
    }

    /*
     * Unable to fully structure code
     */
    public static double d(z var0, z var1_1) {
        var6_2 = t.d;
        var2_3 = z.c(var0, var1_1) / (var0.d() * var1_1.d());
        if (var2_3 <= 1.0) ** GOTO lbl6
        var4_4 = Math.acos(1.0);
        if (!var6_2) ** GOTO lbl10
lbl6: // 2 sources:
        if (var2_3 >= -1.0) ** GOTO lbl-1000
        var4_4 = Math.acos(-1.0);
        if (var6_2) lbl-1000: // 2 sources:
        {
            var4_4 = Math.acos(Math.min(1.0, var2_3));
        }
lbl10: // 4 sources:
        if (z.b(var0, var1_1) != false) return var4_4;
        return 6.283185307179586 - var4_4;
    }

    public String toString() {
        return new StringBuffer().append("X: ").append(this.a()).append(" Y: ").append(this.b()).toString();
    }
}

