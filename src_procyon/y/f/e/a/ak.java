package y.f.e.a;

import java.util.*;

class ak implements s
{
    double a;
    double b;
    double c;
    double d;
    private Map e;
    
    ak() {
        this(0.01, 0.04, 0.01, 0.04);
    }
    
    ak(final double b, final double a, final double d, final double c) {
        this.e = new HashMap();
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double a(final m m, final l l) {
        if (m.g() == 1.0) {
            return 0.0;
        }
        return Math.max(0.0, Math.min(m.e() + this.a(m), 1.0));
    }
    
    double a(final m m) {
        final al b = this.b(m);
        b.a(m.f());
        final double a = b.a();
        if (b.b() * a >= 0.0) {
            if (a > 0.0) {
                return this.a * a;
            }
            return this.c * a;
        }
        else {
            if (a > 0.0) {
                return this.b * a;
            }
            return this.d * a;
        }
    }
    
    al b(final m m) {
        al al = this.e.get(m);
        if (al == null) {
            al = new al();
            this.e.put(m, al);
        }
        return al;
    }
}
