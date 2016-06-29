/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import y.d.b.z;
import y.g.e;

public class y
implements z {
    private static y a = new y(0.0);
    private static y b = new y(1.0);
    private double c;

    public y(double d2) {
        this.c = d2;
    }

    @Override
    public z a() {
        return a;
    }

    @Override
    public z b() {
        return b;
    }

    @Override
    public z a(z z2) {
        y y2 = (y)z2;
        return new y(this.c + y2.e());
    }

    @Override
    public z b(z z2) {
        y y2 = (y)z2;
        return new y(this.c - y2.e());
    }

    @Override
    public z c(z z2) {
        y y2 = (y)z2;
        return new y(this.c * y2.e());
    }

    @Override
    public z d(z z2) {
        y y2 = (y)z2;
        return new y(this.c / y2.e());
    }

    @Override
    public z d() {
        return new y(- this.c);
    }

    @Override
    public z e(z z2) {
        return b;
    }

    @Override
    public int c() {
        if (this.c < 0.0) {
            return -1;
        }
        if (this.c <= 0.0) return 0;
        return 1;
    }

    @Override
    public int f(z z2) {
        if (z2 != this) return e.a(this.c, ((y)z2).e());
        return 0;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof y)) {
            return false;
        }
        y y2 = (y)object;
        if (this.c != y2.e()) return false;
        return true;
    }

    @Override
    public double e() {
        return this.c;
    }

    public String toString() {
        return new StringBuffer().append("").append(this.c).toString();
    }
}

