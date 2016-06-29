package y.f.i.a;

import y.c.*;
import y.d.*;
import y.f.b.*;
import y.f.*;
import java.util.*;

class ay extends ab
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
        this.b = aa.d().f().g();
        this.h = (this.b > 0);
        if (this.h) {
            this.c = aa.c().c();
            this.d = aa.c().d();
            this.e = aa.f().g();
            this.f = aa.g().g();
        }
    }
    
    protected double a(final f f) {
        double n = 0.0;
        if (this.h && f.b() != null && this.a(f.b(), f.a())) {
            n += this.b;
        }
        return n;
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        double n = 0.0;
        if (this.h && this.a(f, r)) {
            n = this.b;
        }
        final double[] array4 = new double[array.length];
        if (n > 0.0) {
            Arrays.fill(array4, n);
        }
        this.b("punish minimal node to edge distance", n, false);
        return array4;
    }
    
    private boolean a(final f f, final R r) {
        final R a = f.a();
        final List b = this.b(a);
        final List a2 = this.a(a);
        final List a3 = this.a(r);
        final q a4 = this.a(a2, a3, b);
        if (a4 != null && !this.a(a4) && !this.b(a4)) {
            return true;
        }
        final q b2 = this.b(a2, a3, this.b(r));
        return b2 != null && (this.a(b2) || this.b(b2)) && this.d(f);
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
                goto Label_0125;
            }
            final R a = b3.a();
            b &= (this.b().b(a) || this.a(a).contains(this.c));
            b2 &= (this.b().d(a) || this.a(a).contains(this.d));
            b3 = b3.b();
        } while (i == 0);
        goto Label_0125;
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
            final Iterator<ax> iterator = b.iterator();
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
        final double l = this.a().c().l();
        final y s = this.a().a().s(q);
        return new y(s.c() - l, s.d() - l, s.a() + 2.0 * l, s.b() + 2.0 * l).b(y);
    }
    
    private q a(final List list, final List list2, final List list3) {
        for (final q q : list2) {
            if (!this.g.d(q) && !list.contains(q)) {
                if (!list3.contains(q)) {
                    return q;
                }
                if (list3.contains(this.c) && list2.size() > 1) {
                    return q;
                }
                continue;
            }
        }
        return null;
    }
    
    private q b(final List list, final List list2, final List list3) {
        for (final q q : list) {
            if (!this.g.d(q) && !list2.contains(q) && !list3.contains(q)) {
                return q;
            }
        }
        return null;
    }
    
    private List a(final R r) {
        return (List)r.a(T.b);
    }
    
    private List b(final R r) {
        return (List)r.a(T.a);
    }
}
