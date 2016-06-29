package y.f.i.a;

import y.d.*;
import y.f.b.*;
import y.c.*;
import java.util.*;

class ax extends ab
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
        this.b = aa.d().f().c();
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
        if (f.b() != null && this.a(f.b(), new D(this.a(f.b().a())), new D(this.a(f.a())))) {
            n += this.b;
        }
        return n;
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        if (!this.h) {
            this.b("punish node crossing", 0.0, false);
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
        this.b("punish node crossing", n, false);
        return array4;
    }
    
    private boolean a(final f f, final R r) {
        return this.a(f, this.a(f.a()), this.a(r));
    }
    
    private boolean a(final f f, final List list, final List list2) {
        final q a = this.a(list, list2);
        if (a != null && !this.a(a) && !this.b(a)) {
            return true;
        }
        final q b = this.b(list, list2);
        return b != null && (this.a(b) || this.b(b)) && this.d(f);
    }
    
    private boolean d(final f f) {
        final int i = ab.a;
        boolean b = true;
        boolean b2 = true;
        f b3 = f;
        do {
            if (!b) {
                final boolean b4 = b2;
                if (i != 0 || !b4) {
                    return !b4 && !b2;
                }
            }
            if (b3 == null) {
                goto Label_0072;
            }
            b &= this.b().b(b3.a());
            b2 &= this.b().d(b3.a());
            b3 = b3.b();
        } while (i == 0);
        goto Label_0072;
    }
    
    private boolean a(final q q) {
        return this.a(this.f, q);
    }
    
    private boolean b(final q q) {
        final int a = ab.a;
        final aU a2 = this.a().a(this.b().c());
        final List b = a2.b(false);
        boolean b2 = false;
        if (!b.isEmpty()) {
            final y s = this.a().a().s(q);
            final Iterator<y.f.ax> iterator = b.iterator();
            while (iterator.hasNext()) {
                if (s.a(a2.a(iterator.next(), false))) {
                    b2 = true;
                    if (a == 0) {
                        return b2;
                    }
                    break;
                }
            }
        }
        return b2;
    }
    
    private boolean a(final y y, final q q) {
        final y s = this.a().a().s(q);
        return new y(s.c() - 1.0E-6, s.d() - 1.0E-6, s.a() + 2.0E-6, s.b() + 2.0E-6).b(y);
    }
    
    private q a(final List list, final List list2) {
        for (final q q : list2) {
            if (!this.g.d(q)) {
                if (!list.contains(q)) {
                    return q;
                }
                if (list.contains(this.b().c().c())) {
                    return q;
                }
                continue;
            }
        }
        return null;
    }
    
    private q b(final List list, final List list2) {
        for (final q q : list) {
            if (!this.g.d(q) && !list2.contains(q)) {
                return q;
            }
        }
        return null;
    }
    
    private List a(final R r) {
        return (List)r.a(T.a);
    }
}
