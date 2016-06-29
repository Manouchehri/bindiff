package y.g;

import y.c.*;

class aq implements b
{
    private final ap a;
    
    aq(final ap a) {
        this.a = a;
    }
    
    public Object b(final Object o) {
        final c a = ap.a(this.a);
        if (a != null) {
            final Object b = a.b(o);
            if (b != null) {
                return b;
            }
        }
        return ap.b(this.a).b(o);
    }
    
    public int a(final Object o) {
        throw new IllegalStateException("Only get(Object) may be used");
    }
    
    public double c(final Object o) {
        throw new IllegalStateException("Only get(Object) may be used");
    }
    
    public boolean d(final Object o) {
        throw new IllegalStateException("Only get(Object) may be used");
    }
    
    public void a(final Object o, final Object o2) {
        ((a)ap.b(this.a)).a(o, o2);
    }
    
    public void a(final Object o, final int n) {
        throw new IllegalStateException("Only set(Object) may be used");
    }
    
    public void a(final Object o, final double n) {
        throw new IllegalStateException("Only set(Object) may be used");
    }
    
    public void a(final Object o, final boolean b) {
        throw new IllegalStateException("Only set(Object) may be used");
    }
}
