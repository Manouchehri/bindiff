package y.f;

import y.c.*;

class q implements c
{
    c a;
    private final l b;
    
    q(final l b, final c a) {
        this.b = b;
        this.a = a;
    }
    
    public Object b(final Object o) {
        final Object e = this.e(o);
        if (e != null) {
            return this.a.b(e);
        }
        return null;
    }
    
    public int a(final Object o) {
        final Object e = this.e(o);
        if (e != null) {
            return this.a.a(e);
        }
        return 0;
    }
    
    public double c(final Object o) {
        final Object e = this.e(o);
        if (e != null) {
            return this.a.c(e);
        }
        return 0.0;
    }
    
    public boolean d(final Object o) {
        final Object e = this.e(o);
        return e != null && this.a.d(e);
    }
    
    Object e(final Object o) {
        if (o instanceof y.c.q) {
            return l.a(this.b).b(o);
        }
        if (o instanceof d) {
            return l.b(this.b).b(o);
        }
        if (o instanceof aj) {
            return l.c(this.b).get(o);
        }
        if (o instanceof C) {
            return l.d(this.b).get(o);
        }
        return o;
    }
}
