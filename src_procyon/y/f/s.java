package y.f;

import y.c.*;

class s extends q implements a
{
    a b;
    private final l c;
    
    s(final l c, final c c2) {
        super(c, c2);
        this.c = c;
        this.b = (a)c2;
    }
    
    public void a(final Object o, final Object o2) {
        final Object e = this.e(o);
        if (e != null) {
            this.b.a(e, o2);
        }
    }
    
    public void a(final Object o, final int n) {
        final Object e = this.e(o);
        if (e != null) {
            this.b.a(e, n);
        }
    }
    
    public void a(final Object o, final double n) {
        final Object e = this.e(o);
        if (e != null) {
            this.b.a(e, n);
        }
    }
    
    public void a(final Object o, final boolean b) {
        final Object e = this.e(o);
        if (e != null) {
            this.b.a(e, b);
        }
    }
}
