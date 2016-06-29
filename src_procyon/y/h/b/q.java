package y.h.b;

import y.d.*;
import java.util.*;
import java.awt.geom.*;

abstract class q
{
    final Object a;
    final List b;
    final List c;
    private boolean d;
    private double e;
    private double f;
    private r g;
    
    q(final double n, final double e, final r r) {
        this.a = new Object();
        this.b = new ArrayList();
        this.c = Collections.unmodifiableList((List<?>)this.b);
        this.g = ((r == null) ? y.h.b.a.x() : r);
        this.e = e;
        this.f = Math.max(Math.max(n, e), this.b(this.g));
    }
    
    q(final q q) {
        this.a = q.a;
        this.b = new ArrayList(q.b.size());
        this.c = Collections.unmodifiableList((List<?>)this.b);
        this.e = q.e;
        this.f = q.f;
        this.d = q.d;
        this.g = q.g;
    }
    
    void c(final double n) {
        if (n > 0.0) {
            this.e = n;
            if (this.f < n) {
                this.f = n;
                y.h.b.a.d(this.r());
            }
        }
    }
    
    double p() {
        return this.e;
    }
    
    void d(final double n) {
        final double max = Math.max(n, Math.max(this.b(this.g), this.e));
        if (this.f != max) {
            this.f = max;
            y.h.b.a.d(this.r());
        }
    }
    
    double q() {
        return this.f;
    }
    
    public void a(final r g) {
        Label_0022: {
            if (g == null) {
                this.g = y.h.b.a.x();
                if (y.h.b.a.H == 0) {
                    break Label_0022;
                }
            }
            this.g = g;
        }
        if (this.f < this.b(g)) {
            this.f = this.b(g);
        }
    }
    
    public r i() {
        return this.g;
    }
    
    abstract double b(final r p0);
    
    public boolean e() {
        return this.d;
    }
    
    public void a(final boolean d) {
        this.d = d;
    }
    
    public abstract Rectangle2D h();
    
    abstract a r();
}
