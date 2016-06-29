package y.g;

import y.c.*;

public final class N implements A, h
{
    private int a;
    private final c b;
    private final a c;
    private double d;
    private Double e;
    
    public N(final b b, final double n) {
        this(b, b, n);
    }
    
    public N(final c b, final a c, final double n) {
        this.b = b;
        this.c = c;
        this.a(n);
    }
    
    public void a(final double d) {
        this.d = d;
        this.e = new Double(d);
        ++this.a;
    }
    
    public Object b(final Object o) {
        final O o2 = (O)this.b.b(o);
        if (o2 == null) {
            return this.e;
        }
        if (o2.a != this.a) {
            return this.e;
        }
        return new Double(o2.b);
    }
    
    public void a(final Object o, final Object o2) {
        this.a(o, ((Number)o2).doubleValue());
    }
    
    public boolean d(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    public double c(final Object o) {
        final O o2 = (O)this.b.b(o);
        if (o2 == null) {
            return this.d;
        }
        if (o2.a != this.a) {
            return this.d;
        }
        return o2.b;
    }
    
    public int a(final Object o) {
        return (int)Math.rint(this.c(o));
    }
    
    public void a(final Object o, final boolean b) {
        throw new UnsupportedOperationException();
    }
    
    public void a(final Object o, final double n) {
        final O o2 = (O)this.b.b(o);
        if (o2 == null) {
            final O o3 = new O();
            o3.b = n;
            o3.a = this.a;
            this.c.a(o, o3);
            if (!p.c) {
                return;
            }
        }
        o2.b = n;
        o2.a = this.a;
    }
    
    public void a(final Object o, final int n) {
        this.a(o, (double)n);
    }
}
