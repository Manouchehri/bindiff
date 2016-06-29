package y.f.k;

import y.d.*;

class Y
{
    private t a;
    private t b;
    private double c;
    
    Y() {
    }
    
    Y(final Y y, final double c) {
        this.c = c;
        this.a = y.a;
        this.b = y.b;
    }
    
    Y(final t a) {
        this.a = a;
    }
    
    void a(final t t) {
        if (this.a == null) {
            this.a = t;
            return;
        }
        if (this.a.equals(t)) {
            return;
        }
        if (this.b != null) {
            throw new IllegalStateException("RoutingBound still has two points assigned");
        }
        this.b = t;
    }
    
    Y a(final double n) {
        return new Y(this, n);
    }
    
    boolean a() {
        return this.a != null;
    }
    
    double b() {
        return this.c() - this.d();
    }
    
    double c() {
        if (this.b == null) {
            return this.a.a() + this.c;
        }
        return Math.max(this.a.a() + this.c, this.b.a() + this.c);
    }
    
    double d() {
        if (this.b == null) {
            return this.a.a() - this.c;
        }
        return Math.min(this.a.a() - this.c, this.b.a() - this.c);
    }
    
    double e() {
        return this.f() - this.g();
    }
    
    double f() {
        if (this.b == null) {
            return this.a.b() + this.c;
        }
        return Math.max(this.a.b() + this.c, this.b.b() + this.c);
    }
    
    double g() {
        if (this.b == null) {
            return this.a.b() - this.c;
        }
        return Math.min(this.a.b() - this.c, this.b.b() - this.c);
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Y y = (Y)o;
        Label_0062: {
            if (this.a != null) {
                if (this.a.equals(y.a)) {
                    break Label_0062;
                }
            }
            else if (y.a == null) {
                break Label_0062;
            }
            return false;
        }
        if (this.b != null) {
            if (this.b.equals(y.b)) {
                return true;
            }
        }
        else if (y.b == null) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        return 29 * ((this.a != null) ? this.a.hashCode() : 0) + ((this.b != null) ? this.b.hashCode() : 0);
    }
    
    public String toString() {
        return "RoutingBound{point0=" + this.a + ", point1=" + this.b + " | width=" + this.b() + ", height=" + this.e() + "}";
    }
}
