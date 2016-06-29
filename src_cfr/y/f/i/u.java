/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.f.i.v;

class U {
    private final Object b;
    private final double c;
    private final double d;
    private double e;
    final double a;
    private final double f;
    private double g;
    private double h;
    private final byte i;
    private boolean j;

    private U(Object object, double d2, double d3, double d4, double d5, byte by2, double d6, double d7) {
        int n2 = v.f;
        this.b(d6);
        this.c(d7);
        this.a = d2 * 0.5;
        this.f = d3;
        this.b = object;
        this.a(Double.NaN);
        this.i = by2;
        this.c = d4;
        this.d = d5;
        switch (by2) {
            case 0: 
            case 3: {
                this.b(false);
                if (n2 == 0) return;
            }
            case 1: 
            case 2: {
                this.b(true);
                if (n2 == 0) return;
            }
        }
        this.b(true);
    }

    public byte a() {
        return this.i;
    }

    static U a(Object object, double d2, double d3, double d4, boolean bl2, double d5, boolean bl3) {
        return U.a(object, d2, d3, d4, bl2, d5, bl3, -1.7976931348623157E308, Double.MAX_VALUE);
    }

    static U a(Object object, double d2, double d3, double d4, boolean bl2, double d5, boolean bl3, double d6, double d7) {
        byte by2;
        if (d4 > d5) {
            byte by3;
            if (bl3) {
                if (bl2) {
                    by3 = 0;
                    return new U(object, d2, d3, d5, d4, by3, d6, d7);
                }
                by3 = 2;
                return new U(object, d2, d3, d5, d4, by3, d6, d7);
            }
            if (bl2) {
                by3 = 1;
                return new U(object, d2, d3, d5, d4, by3, d6, d7);
            }
            by3 = 3;
            return new U(object, d2, d3, d5, d4, by3, d6, d7);
        }
        if (bl2) {
            if (bl3) {
                by2 = 0;
                return new U(object, d2, d3, d4, d5, by2, d6, d7);
            }
            by2 = 2;
            return new U(object, d2, d3, d4, d5, by2, d6, d7);
        }
        if (bl3) {
            by2 = 1;
            return new U(object, d2, d3, d4, d5, by2, d6, d7);
        }
        by2 = 3;
        return new U(object, d2, d3, d4, d5, by2, d6, d7);
    }

    public void a(boolean bl2) {
        this.b(bl2);
    }

    public boolean b() {
        return this.j;
    }

    public Object c() {
        return this.b;
    }

    public double d() {
        return this.e;
    }

    public void a(double d2) {
        this.e = d2;
    }

    public double e() {
        return this.g;
    }

    public void b(double d2) {
        this.g = d2;
    }

    public double f() {
        return this.h;
    }

    public void c(double d2) {
        this.h = d2;
    }

    public void b(boolean bl2) {
        this.j = bl2;
    }

    static byte a(U u2) {
        return u2.i;
    }

    static double b(U u2) {
        return u2.d;
    }

    static double c(U u2) {
        return u2.c;
    }

    static double d(U u2) {
        return u2.e;
    }

    static double e(U u2) {
        return u2.f;
    }
}

