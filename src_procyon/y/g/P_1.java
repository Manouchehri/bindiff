package y.g;

import y.c.*;

public final class P implements A, h
{
    private int a;
    private final a b;
    private final c c;
    private int d;
    private Integer e;
    
    public P(final b b, final int n) {
        this(b, b, n);
    }
    
    public P(final c c, final a b, final int n) {
        this.c = c;
        this.b = b;
        this.a(n);
    }
    
    public void a(final int d) {
        this.d = d;
        this.e = new Integer(d);
        ++this.a;
    }
    
    public Object b(final Object o) {
        final Q q = (Q)this.c.b(o);
        if (q == null) {
            return this.e;
        }
        if (q.a != this.a) {
            return this.e;
        }
        return new Integer(q.b);
    }
    
    public void a(final Object o, final Object o2) {
        this.a(o, ((Number)o2).intValue());
    }
    
    public boolean d(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    public double c(final Object o) {
        return this.a(o);
    }
    
    public int a(final Object o) {
        final Q q = (Q)this.c.b(o);
        if (q == null) {
            return this.d;
        }
        if (q.a != this.a) {
            return this.d;
        }
        return q.b;
    }
    
    public void a(final Object o, final boolean b) {
        throw new UnsupportedOperationException();
    }
    
    public void a(final Object o, final double n) {
        throw new UnsupportedOperationException();
    }
    
    public void a(final Object o, final int n) {
        final Q q = (Q)this.c.b(o);
        if (q == null) {
            final Q q2 = new Q();
            q2.b = n;
            q2.a = this.a;
            this.b.a(o, q2);
            if (!p.c) {
                return;
            }
        }
        q.b = n;
        q.a = this.a;
    }
}
