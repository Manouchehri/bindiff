/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import y.d.t;

class Y {
    private t a;
    private t b;
    private double c;

    Y() {
    }

    Y(Y y2, double d2) {
        this.c = d2;
        this.a = y2.a;
        this.b = y2.b;
    }

    Y(t t2) {
        this.a = t2;
    }

    void a(t t2) {
        if (this.a == null) {
            this.a = t2;
            return;
        }
        if (this.a.equals(t2)) {
            return;
        }
        if (this.b != null) {
            throw new IllegalStateException("RoutingBound still has two points assigned");
        }
        this.b = t2;
    }

    Y a(double d2) {
        return new Y(this, d2);
    }

    boolean a() {
        if (this.a == null) return false;
        return true;
    }

    double b() {
        return this.c() - this.d();
    }

    double c() {
        if (this.b != null) return Math.max(this.a.a() + this.c, this.b.a() + this.c);
        return this.a.a() + this.c;
    }

    double d() {
        if (this.b != null) return Math.min(this.a.a() - this.c, this.b.a() - this.c);
        return this.a.a() - this.c;
    }

    double e() {
        return this.f() - this.g();
    }

    double f() {
        if (this.b != null) return Math.max(this.a.b() + this.c, this.b.b() + this.c);
        return this.a.b() + this.c;
    }

    double g() {
        if (this.b != null) return Math.min(this.a.b() - this.c, this.b.b() - this.c);
        return this.a.b() - this.c;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Y y2 = (Y)object;
        if (this.a != null ? !this.a.equals(y2.a) : y2.a != null) {
            return false;
        }
        if (this.b != null) {
            if (this.b.equals(y2.b)) return true;
            return false;
        }
        if (y2.b == null) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        return 29 * n2 + (this.b != null ? this.b.hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer().append("RoutingBound{point0=").append(this.a).append(", point1=").append(this.b).append(" | width=").append(this.b()).append(", height=").append(this.e()).append("}").toString();
    }
}

