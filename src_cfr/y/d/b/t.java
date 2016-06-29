/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import y.d.b.d;
import y.d.b.u;
import y.d.b.z;

public class t {
    protected u a;
    private z e;
    private z f;
    private z g;
    protected double b;
    protected double c;
    protected double d;
    private int h;

    public t(z z2, z z3, z z4, u u2) {
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.a = u2;
        this.b = this.e.e();
        this.c = this.f.e();
        this.d = this.g.e();
        this.h = (int)(this.b + this.c + this.d);
    }

    public t(z z2, z z3, z z4) {
        this(z2, z3, z4, d.a());
    }

    public z a() {
        return this.e;
    }

    public z b() {
        return this.f;
    }

    public z c() {
        return this.g;
    }

    public double a(t t2) {
        double d2 = Math.acos((this.b * t2.b + this.c * t2.c) / (Math.sqrt(this.b * this.b + this.c * this.c) * Math.sqrt(t2.b * t2.b + t2.c * t2.c)));
        if (this.b * t2.c + this.c * t2.b <= 0.0) return d2;
        return 6.283185307179586 - d2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof t)) {
            return false;
        }
        t t2 = (t)object;
        z z2 = this.e.c(t2.c()).b(t2.a().c(this.g));
        z z3 = this.f.c(t2.c()).b(t2.b().c(this.g));
        if (z2.c() != 0) return false;
        if (z3.c() != 0) return false;
        return true;
    }

    public int hashCode() {
        return this.h;
    }

    public String toString() {
        return new StringBuffer().append("(").append(this.e).append(",").append(this.f).append(",").append(this.g).append(")").toString();
    }
}

