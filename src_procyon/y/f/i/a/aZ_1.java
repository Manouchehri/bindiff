package y.f.i.a;

import java.util.*;
import y.f.*;

class aZ extends ab
{
    private ArrayList b;
    private R c;
    private L d;
    private int e;
    
    protected void c() {
        super.c();
        this.b = null;
        this.c = null;
        this.d = null;
    }
    
    protected void a(final Z z) {
        super.a(z);
        this.d = z.c().k();
    }
    
    protected void b(final aa aa) {
        final int a = ab.a;
        super.b(aa);
        this.e = aa.d().f().a();
        this.c = aa.g();
        final aU a2 = this.a().a(aa.c());
        List a3 = null;
        Label_0065: {
            if (a2 != null) {
                a3 = a2.a(false);
                if (a == 0) {
                    break Label_0065;
                }
            }
            a3 = null;
        }
        this.b = null;
        if (a3 != null) {
            while (true) {
                for (final ax ax : a3) {
                    if (!ax.b()) {
                        final int a4 = ax.a();
                        if (a == 0) {
                            if (a4 == 255) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (a4 == 0) {
                                this.b = new ArrayList(a3.size());
                                final Iterator<ax> iterator2 = a3.iterator();
                                while (iterator2.hasNext()) {
                                    this.b.add(new ba(this, iterator2.next(), a2));
                                    if (a != 0) {
                                        break;
                                    }
                                }
                            }
                            return;
                        }
                    }
                }
                continue;
            }
        }
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        if (this.e == 0) {
            this.b("bend penalty", 0.0, false);
            return new double[array.length];
        }
        final y d = f.d();
        if (d == null) {
            this.b("bend penalty", 0.0, false);
            return new double[array.length];
        }
        final y l = array2[0].l();
        if (d == l) {
            return super.a(f, r, array, array2, array3);
        }
        double n = 0.0;
        Label_0096: {
            if (d.c() == l) {
                n = 2.0;
                if (ab.a == 0) {
                    break Label_0096;
                }
            }
            n = 1.0;
        }
        final double n2 = n * this.e;
        this.b("bend penalty", n2, false);
        final double[] array4 = new double[array.length];
        if (n2 > 0.0) {
            Arrays.fill(array4, n2);
        }
        return array4;
    }
    
    protected double a(final f f, final R r, final P p5, final v v, final double n) {
        double n2 = 0.0;
        Label_0023: {
            if (v.c() == 1) {
                n2 = 2.0;
                if (ab.a == 0) {
                    break Label_0023;
                }
            }
            n2 = 0.0;
        }
        final double n3 = n2 * this.e;
        this.a("bend penalty", n3, false);
        return n3;
    }
    
    protected double b(final f f) {
        final int a = ab.a;
        if (this.e == 0 || this.b().d(f.a())) {
            this.a("HEUR bend penalty", 0.0, true);
            return 0.0;
        }
        final boolean a2 = a(f, this.c);
        final boolean b = b(f, this.c);
        int a3 = 0;
        Label_0175: {
            if (this.b != null) {
                a3 = this.a(f, a2 ? 2 : (b ? 0 : 1));
                if (a == 0) {
                    break Label_0175;
                }
            }
            if (a2) {
                a3 = ((this.d == null) ? 2 : this.c(f, this.c));
                if (a == 0) {
                    break Label_0175;
                }
            }
            if (b) {
                a3 = ((this.d == null) ? 0 : this.d(f, this.c));
                if (a == 0) {
                    break Label_0175;
                }
            }
            a3 = ((this.d == null) ? 1 : this.e(f, this.c));
        }
        this.a("HEUR bend penalty", a3 * this.e, true);
        return a3 * this.e;
    }
    
    private static boolean a(final f f, final R r) {
        final y d = f.d();
        final R a = f.a();
        if (d == y.b) {
            return r.j() <= a.h();
        }
        if (d == y.d) {
            return a.j() <= r.h();
        }
        if (d == y.a) {
            return a.k() <= r.i();
        }
        return r.k() <= a.i();
    }
    
    private static boolean b(final f f, final R r) {
        if (f.d().d()) {
            final P p2 = r.a(S.d);
            if (ab.a == 0) {
                return f.c().a(p2, 0.1);
            }
        }
        final P p2 = r.a(S.a);
        return f.c().a(p2, 0.1);
    }
    
    private int c(final f f, final R r) {
        final y d = f.d();
        final P b = this.b(r, d);
        final P c = this.c(r, d);
        if (!this.d.a(b) && this.d.a(c)) {
            return 3;
        }
        return 2;
    }
    
    private int d(final f f, final R r) {
        final y d = f.d();
        final P a = this.a(r, d);
        final P c = this.c(r, d);
        final P c2 = f.c();
        final P a2 = P.a(c2, a);
        final P p2 = new P(c2.f(), a.f(), 0.0, !c2.a());
        if (this.d.a(a2)) {
            return 0;
        }
        final boolean a3 = this.d.a(a);
        final boolean a4 = this.d.a(c);
        final boolean a5 = this.d.a(c2);
        final boolean a6 = this.d.a(p2);
        if (a5) {
            if (a4 || !a3) {
                return 1;
            }
            return 2;
        }
        else if (c2.c(a)) {
            if ((!a3 && !a4) || !a6) {
                return 0;
            }
            if (!a4) {
                return 2;
            }
            return 3;
        }
        else {
            if (a4) {
                return 1;
            }
            if (!a3 || !a6) {
                return 0;
            }
            return 2;
        }
    }
    
    private int e(final f f, final R r) {
        final y d = f.d();
        final P b = this.b(r, d);
        final P c = this.c(r, d);
        if (!this.d.a(new P(f.c().f(), (d == y.b || d == y.c) ? c.c() : c.b(), c.f(), c.a())) && this.d.a(b)) {
            return 2;
        }
        return 1;
    }
    
    private P a(final R r, final y y) {
        if (y == y.b) {
            return r.a(S.d);
        }
        if (y == y.d) {
            return r.a(S.c);
        }
        if (y == y.c) {
            return r.a(S.a);
        }
        if (y == y.a) {
            return r.a(S.b);
        }
        throw new IllegalArgumentException("Unknown direction: " + y);
    }
    
    private P b(final R r, final y y) {
        if (y == y.b) {
            return r.a(S.c);
        }
        if (y == y.d) {
            return r.a(S.d);
        }
        if (y == y.c) {
            return r.a(S.b);
        }
        if (y == y.a) {
            return r.a(S.a);
        }
        throw new IllegalArgumentException("Unknown direction: " + y);
    }
    
    private P c(final R r, final y y) {
        if (y == y.b || y == y.d) {
            return r.a(S.a);
        }
        if (y == y.c || y == y.a) {
            return r.a(S.d);
        }
        throw new IllegalArgumentException("Unknown direction: " + y);
    }
    
    private int a(final f f, final int n) {
        final int i = ab.a;
        int min = Integer.MAX_VALUE;
        if (this.b != null && !this.b.isEmpty()) {
        Label_0035:
            for (final ba ba : this.b) {
                int n2 = 0;
                do {
                    int length = 0;
                    Label_0060: {
                        length = ba.a.length;
                    }
                    int j = 0;
                    while (j < length) {
                        min = Math.min(min, this.a(f, ba.a[n2], ba.b[n2]));
                        final int n3;
                        j = (n3 = min);
                        if (i != 0) {
                            return n3;
                        }
                        length = n;
                        if (i != 0) {
                            continue;
                        }
                        if (j <= n) {
                            return min;
                        }
                        ++n2;
                        continue Label_0060;
                    }
                    continue Label_0035;
                } while (i == 0);
                break;
            }
            return min;
        }
        return n;
    }
    
    private int a(final f f, final P p3, final y y) {
        final P c = f.c();
        final y d = f.d();
        if (d == y) {
            if (!a(c.f(), p3.f(), d)) {
                return 4;
            }
            if (!c.a(p3, (p3.d() > 0.0) ? 0.1 : 0.0)) {
                return 2;
            }
            if (p3.d() > 0.0 && this.d != null && !this.d.a(P.a(c, p3)) && (this.d.a(c) || this.d.a(p3))) {
                return 2;
            }
            return 0;
        }
        else {
            if (d.c() != y) {
                final boolean b = (a(p3.f(), c.b(), y) && a(p3.f(), c.c(), y)) || (this.d != null && this.a(c, p3, y));
                final boolean b2 = (!a(c.f(), p3.b(), d) && !a(c.f(), p3.c(), d)) || (this.d != null && this.b(c, p3, d));
                return (b || b2) ? 3 : 1;
            }
            final P a = this.c.a(S.a(y));
            if (a(c.f(), a.f(), d) && c.c(a)) {
                return 4;
            }
            return 2;
        }
    }
    
    private boolean a(final P p3, final P p4, final y y) {
        if (!p3.e().a(p4.f())) {
            return false;
        }
        if (y == y.b || y == y.c) {
            final P p5 = new P(p3.b(), p4.f(), 0.0, p3.a());
            final P p6 = new P(p3.c(), p4.f(), 0.0, p3.a());
            if (ab.a == 0) {
                return !this.d.a(p5) && this.d.a(p6);
            }
        }
        final P p5 = new P(p3.c(), p4.f(), 0.0, p3.a());
        final P p6 = new P(p3.b(), p4.f(), 0.0, p3.a());
        return !this.d.a(p5) && this.d.a(p6);
    }
    
    private boolean b(final P p3, final P p4, final y y) {
        if (!p4.e().a(p3.f())) {
            return false;
        }
        if (y == y.b || y == y.c) {
            final P p5 = new P(p4.c(), p3.f(), 0.0, p4.a());
            final P p6 = new P(p4.b(), p3.f(), 0.0, p4.a());
            if (ab.a == 0) {
                return !this.d.a(p5) && this.d.a(p6);
            }
        }
        final P p5 = new P(p4.b(), p3.f(), 0.0, p4.a());
        final P p6 = new P(p4.c(), p3.f(), 0.0, p4.a());
        return !this.d.a(p5) && this.d.a(p6);
    }
    
    private static boolean a(final double n, final double n2, final y y) {
        if (y.b == y || y.c == y) {
            return n2 > n;
        }
        return n2 < n;
    }
    
    private static y b(final int n) {
        switch (n) {
            case 1: {
                return y.c;
            }
            case 2: {
                return y.a;
            }
            case 4: {
                return y.d;
            }
            case 8: {
                return y.b;
            }
            default: {
                return y.c;
            }
        }
    }
    
    static y a(final int n) {
        return b(n);
    }
    
    static R a(final aZ az) {
        return az.c;
    }
}
