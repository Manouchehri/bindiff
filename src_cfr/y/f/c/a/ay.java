/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

public class aY {
    private double[] a = new double[]{0.5, 0.5, 0.5, 0.5};
    private double b = 0.5;
    private double c = 0.0;
    private byte d = 2;
    private double e = 5.0;

    public double a(int n2) {
        return this.a[n2];
    }

    public void a(double d2) {
        if (d2 < 0.0) throw new IllegalArgumentException();
        if (d2 > 1.0) {
            throw new IllegalArgumentException();
        }
        this.b = d2;
    }

    public double a() {
        return this.b;
    }

    public byte b() {
        return this.d;
    }

    public double c() {
        return this.c;
    }

    public double d() {
        return this.e;
    }
}

