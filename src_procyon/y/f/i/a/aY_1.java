package y.f.i.a;

import y.c.*;
import y.d.*;
import y.f.b.*;
import java.util.*;

class aY extends ab
{
    private int b;
    private q c;
    private q d;
    private y e;
    private y f;
    private c g;
    private boolean h;
    
    protected void c() {
        super.c();
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }
    
    protected void a(final Z z) {
        super.a(z);
        this.g = z.b();
    }
    
    protected void b(final aa aa) {
        super.b(aa);
        this.b = aa.d().f().d();
        this.h = (this.b > 0);
        if (this.h) {
            this.c = aa.c().c();
            this.d = aa.c().d();
            this.e = aa.f().g();
            this.f = aa.g().g();
        }
    }
    
    protected double a(final f f) {
        if (!this.h) {
            return 0.0;
        }
        double n = 0.0;
        if (f.b() != null) {
            final R a = f.a();
            final R a2 = f.b().a();
            final boolean a3 = this.a(a);
            final boolean a4 = this.a(a2);
            if (a3 || a4) {
                n += this.b;
            }
        }
        return n;
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        if (!this.h) {
            this.b("punish group node crossing", 0.0, false);
            return new double[array.length];
        }
        double n = 0.0;
        if (this.a(f, r)) {
            n = this.b;
        }
        final double[] array4 = new double[array.length];
        if (n > 0.0) {
            Arrays.fill(array4, n);
        }
        this.b("punish group node crossing", n, false);
        return array4;
    }
    
    private boolean a(final R r) {
        final int a = ab.a;
        boolean c = false;
        for (final q q : this.b(r)) {
            if (this.g.d(q)) {
                c = this.c(q);
                if (a != 0) {
                    return c;
                }
                if (!c) {
                    return true;
                }
                continue;
            }
        }
        return c;
    }
    
    private boolean a(final f f, final R r) {
        final List b = this.b(f.a());
        final List b2 = this.b(r);
        final q a = this.a(b, b2);
        if (a != null && !this.a(a)) {
            return true;
        }
        final q b3 = this.b(b, b2);
        if (b3 != null) {
            final boolean b4 = this.b(b3);
            final boolean a2 = this.a(b3);
            if (a2 && (!a2 || b3 != this.c) && (!b4 || b3 != this.d)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean a(final q q) {
        return this.a(this.f, q);
    }
    
    private boolean b(final q q) {
        return this.a(this.e, q);
    }
    
    private boolean a(final y y, final q q) {
        final y s = this.a().a().s(q);
        return new y(s.c() - 1.0E-6, s.d() - 1.0E-6, s.a() + 2.0E-6, s.b() + 2.0E-6).b(y);
    }
    
    private q a(final List list, final List list2) {
        for (final q q : list2) {
            if (this.g.d(q) && !list.contains(q)) {
                return q;
            }
        }
        return null;
    }
    
    private q b(final List list, final List list2) {
        for (final q q : list) {
            if (this.g.d(q) && !list2.contains(q)) {
                return q;
            }
        }
        return null;
    }
    
    private boolean c(final q q) {
        return this.a(q, this.b().c().c());
    }
    
    private boolean a(final q q, final q q2) {
        final int a = ab.a;
        q a2 = q2;
        while (a2 != this.g.b()) {
            if (a2 == q) {
                return true;
            }
            a2 = this.g.a(a2);
            if (a != 0) {
                break;
            }
        }
        return false;
    }
    
    private List b(final R r) {
        return (List)r.a(T.a);
    }
}
