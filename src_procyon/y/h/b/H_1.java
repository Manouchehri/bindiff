package y.h.b;

import java.awt.geom.*;
import y.d.*;
import java.util.*;
import y.h.*;
import y.c.*;

final class H implements C
{
    private final Rectangle2D a;
    private final B b;
    
    H(final Rectangle2D a, final B b) {
        this.a = a;
        this.b = b;
    }
    
    public double a(final Object o) {
        return ((c)o).g();
    }
    
    public double b(final Object o) {
        return ((c)o).f();
    }
    
    public r c(final Object o) {
        return ((c)o).i();
    }
    
    public int d(final Object o) {
        return ((c)o).k();
    }
    
    public Collection e(final Object o) {
        return ((c)o).l();
    }
    
    public r a(final double n, final double n2) {
        return new r(0.0, n, 0.0, n2);
    }
    
    public double a(final r r) {
        return r.a;
    }
    
    public double b(final r r) {
        return r.c;
    }
    
    public double c(final r r) {
        return r.b;
    }
    
    public double d(final r r) {
        return r.d;
    }
    
    public double a() {
        return this.a.getX();
    }
    
    public double b() {
        return this.a.getMaxX();
    }
    
    public double a(final bu bu, final q q) {
        return bu.j(q);
    }
    
    public Collection c() {
        return this.b.e;
    }
    
    public r f(final Object o) {
        return this.b.f.get(o);
    }
}
