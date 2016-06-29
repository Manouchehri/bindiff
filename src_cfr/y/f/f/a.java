/*
 * Decompiled with CFR 0_115.
 */
package y.f.f;

public class a {
    private double b = 15.0;
    private double c = 15.0;
    private double d = 15.0;
    public static boolean a;

    public void a(double d2) {
        this.b = d2;
    }

    public double a() {
        return this.b;
    }

    public void b(double d2) {
        this.c = d2;
    }

    public double b() {
        return this.c;
    }

    public void c(double d2) {
        this.d = d2;
    }

    public double c() {
        return this.d;
    }

    public a d() {
        a a2 = new a();
        a2.a(this.a());
        a2.b(this.b());
        a2.c(this.c());
        return a2;
    }
}

