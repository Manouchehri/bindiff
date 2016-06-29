package y.g;

import y.c.*;

public class ap implements c
{
    private c a;
    private Object b;
    private i c;
    private c d;
    private b e;
    
    public ap(final c d, final i i, final Object o) {
        this.d = d;
        this.c(i, o);
        this.a(d);
    }
    
    public b a() {
        if (this.e == null) {
            throw new IllegalStateException("wrapper must be of type DataAcceptor");
        }
        return this.e;
    }
    
    private void a(final c c) {
        if (c instanceof a) {
            this.e = new aq(this);
        }
    }
    
    public static ap a(final i i, final Object o) {
        return new ap(i.u(), i, o);
    }
    
    public static ap b(final i i, final Object o) {
        return new ap(i.t(), i, o);
    }
    
    public void c(final i c, final Object b) {
        if (b == null) {
            throw new IllegalArgumentException("Key must be non-null!");
        }
        this.a = c.c(b);
        this.b = b;
        this.c = c;
        if (this.a != null) {
            c.d_(b);
            c.a(b, this);
            if (!p.c) {
                return;
            }
        }
        c.a(b, this.d);
    }
    
    public void b() {
        if (this.b == null) {
            throw new IllegalStateException("Provider must have been wrapped previously!");
        }
        if (this.c.c(this.b) != null) {
            this.c.d_(this.b);
        }
        if (this.a != null) {
            this.c.a(this.b, this.a);
        }
    }
    
    public Object b(final Object o) {
        final Object b = this.d.b(o);
        if (b != null) {
            return b;
        }
        if (this.a != null) {
            return this.a.b(o);
        }
        return null;
    }
    
    public boolean d(final Object o) {
        throw new UnsupportedOperationException("Object supported only!");
    }
    
    public double c(final Object o) {
        throw new UnsupportedOperationException("Object supported only!");
    }
    
    public int a(final Object o) {
        throw new UnsupportedOperationException("Object supported only!");
    }
    
    public c c() {
        return this.a;
    }
    
    public c d() {
        return this.d;
    }
    
    public void e() {
        this.b();
        if (this.d instanceof A) {
            this.c.a((A)this.d);
        }
        if (this.d instanceof h) {
            this.c.a((h)this.d);
        }
        this.d = null;
        this.a = null;
        this.c = null;
    }
    
    static c a(final ap ap) {
        return ap.a;
    }
    
    static c b(final ap ap) {
        return ap.d;
    }
}
