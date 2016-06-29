package y.f.i.a;

import y.d.*;
import java.util.*;
import y.c.*;

class bc
{
    private final R a;
    private final L b;
    private final D c;
    private final D d;
    private final D e;
    private final HashMap f;
    private double g;
    private D h;
    private D i;
    private double[] j;
    private double[] k;
    private boolean[] l;
    private List[] m;
    
    bc(final R a, final double n, final L b) {
        this.a = a;
        this.b = b;
        this.g = ((b != null) ? (b.c() * Math.ceil(n / b.c())) : n);
        this.c = new D();
        this.d = new D();
        this.e = new D();
        this.f = new HashMap();
        this.j = new double[] { -1.7976931348623157E308, -1.7976931348623157E308, Double.MAX_VALUE, Double.MAX_VALUE };
        this.k = new double[] { a.h(), a.i(), a.j(), a.k() };
        this.l = new boolean[4];
    }
    
    private int a(final int n) {
        return (n + 2) % 4;
    }
    
    private boolean b(final int n) {
        return n <= 1;
    }
    
    private boolean c(final int n) {
        return n == 0 || n == 2;
    }
    
    private List[] b() {
        final int a = ab.a;
        if (this.m == null) {
            this.m = new List[4];
            for (final R r : this.a.d().a(new y(this.a.h() - this.g, this.a.i() - this.g, this.a.l() + 2.0 * this.g, this.a.m() + 2.0 * this.g))) {
                if (this.a != r) {
                    final bc bc = this;
                    if (a != 0) {
                        return bc.m;
                    }
                    if (this.a.h() >= r.j()) {
                        this.a(r, 0);
                    }
                    if (this.a.j() <= r.h()) {
                        this.a(r, 2);
                    }
                    if (this.a.i() >= r.k()) {
                        this.a(r, 1);
                    }
                    if (this.a.k() > r.i()) {
                        continue;
                    }
                    this.a(r, 3);
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
            }
        }
        final bc bc = this;
        return bc.m;
    }
    
    private void a(final R r, final int n) {
        List list = this.m[n];
        if (list == null) {
            list = (this.m[n] = new D());
        }
        list.add(r);
    }
    
    private double b(final R r, final int n) {
        switch (n) {
            case 0: {
                return r.h();
            }
            case 1: {
                return r.i();
            }
            case 2: {
                return r.j();
            }
            default: {
                return r.k();
            }
        }
    }
    
    public D a() {
        return this.c;
    }
    
    public boolean[] a(final P[] array, final boolean[] array2) {
        final int a = ab.a;
        final boolean[] array3 = new boolean[array.length];
        int i = 0;
        while (i < array.length) {
            final P p2 = array[i];
            final boolean b = !p2.a();
            this.a(b);
            Label_0124: {
                if (b && this.h == null) {
                    this.a(new M(this.k[0], this.k[2]), true);
                    if (a == 0) {
                        break Label_0124;
                    }
                }
                if (!b && this.i == null) {
                    this.a(new M(this.k[1], this.k[3]), false);
                }
            }
            array3[i] = this.a(p2, b ? this.h : this.i, array2[i]);
            ++i;
            if (a != 0) {
                break;
            }
        }
        return array3;
    }
    
    public boolean[] a(final P[] array, final List list) {
        final int a = ab.a;
        final D d = new D(this.d);
        final D d2 = new D(this.e);
        while (true) {
            for (final P p2 : list) {
                final bc bc = this;
                if (a != 0) {
                    final D a2 = bc.a(new M(this.k[0], this.k[2]), d2, true);
                    this.a(false);
                    final D a3 = this.a(new M(this.k[1], this.k[3]), d, false);
                    final boolean[] array2 = new boolean[array.length];
                    int i = 0;
                    boolean[] array3 = null;
                    while (i < array.length) {
                        final P p3 = array[i];
                        array3 = array2;
                        if (a != 0) {
                            return array3;
                        }
                        array3[i] = this.a(p3, p3.a() ? a3 : a2, false);
                        ++i;
                        if (a != 0) {
                            break;
                        }
                    }
                    return array3;
                }
                this.a(new bd(this, p2), p2.a() ? d : d2);
                if (a != 0) {
                    break;
                }
            }
            this.a(true);
            final bc bc = this;
            continue;
        }
    }
    
    private boolean a(final P p3, final D d, final boolean b) {
        final int a = ab.a;
        final boolean b2 = !p3.a();
        final M m = (this.b != null && !b) ? this.b.b(p3.e(), b2) : p3.e();
        if (m == null) {
            return false;
        }
        final double max = Math.max(m.a(), b2 ? this.k[0] : this.k[1]);
        final double min = Math.min(m.b(), b2 ? this.k[2] : this.k[3]);
        if (max > min) {
            return false;
        }
        double n = 0.0;
        for (final M i : d) {
            if (i.b() > max) {
                n = dcmpg(i.a(), max);
                if (a == 0) {
                    return n >= 0 || i.b() <= min;
                }
                return n != 0.0;
            }
        }
        return n != 0.0;
    }
    
    private void a(final boolean b) {
        if (b) {
            if (!this.d(0) && !this.d(2)) {
                return;
            }
            this.h = null;
            if (ab.a == 0) {
                return;
            }
        }
        if (this.d(1) || this.d(3)) {
            this.i = null;
        }
    }
    
    private boolean d(final int n) {
        final int a = ab.a;
        if (this.l[n]) {
            double n2 = this.b(this.a, n);
            final List list = this.b()[n];
            double b2 = 0.0;
            Label_0125: {
                if (list != null) {
                    final Iterator<R> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        final double n3 = iterator.next().b().j[n];
                        final boolean b = (b2 = (this.b(n) ? 1 : 0)) != 0.0;
                        if (a != 0) {
                            break Label_0125;
                        }
                        if (b) {
                            n2 = Math.max(n2, n3);
                            if (a == 0) {
                                continue;
                            }
                        }
                        n2 = Math.min(n2, n3);
                        if (a != 0) {
                            break;
                        }
                    }
                }
                b2 = dcmpl(this.k[n], n2);
            }
            if (b2 != 0) {
                this.k[n] = n2;
                this.l[n] = false;
                return true;
            }
        }
        return false;
    }
    
    public void a(final v v) {
        final be be = new be(this, v);
        be.a();
        a(be, v.g());
    }
    
    private static void a(final be be, final d d) {
        final h h = (h)d.a().c(y.f.i.a.y.b);
        D d2 = (D)h.b(d);
        if (d2 == null) {
            d2 = new D();
            h.a(d, d2);
        }
        d2.add(be);
    }
    
    private p a(final bd bd, final D d) {
        final int a = ab.a;
        final M b = bd.b;
        final double a2 = b.a();
        final double b2 = b.b();
        p p2 = d.k();
        M m = (p2 != null) ? ((bd)p2.c()).b : null;
        while (m != null && (m.b() < b2 || (m.b() == b2 && m.a() <= a2))) {
            p2 = p2.a();
            m = ((p2 != null) ? ((bd)p2.c()).b : null);
            if (a != 0) {
                break;
            }
        }
        if (p2 != null) {
            final p p3 = d.a(bd, p2);
            if (a == 0) {
                return p3;
            }
        }
        return d.b(bd);
    }
    
    private double e(final int n) {
        final int a = ab.a;
        final boolean c = this.c(n);
        final boolean b = this.b(n);
        double n2 = b ? Double.MAX_VALUE : -1.7976931348623157E308;
        for (final bd bd : c ? this.d : this.e) {
            if (b) {
                n2 = Math.min(n2, bd.b.a());
                if (a == 0) {
                    continue;
                }
            }
            n2 = Math.max(n2, bd.b.b());
            if (a != 0) {
                break;
            }
        }
        return n2;
    }
    
    private void a(final int n, final double n2, final boolean b) {
        final double n3 = this.j[n];
        if ((b && n2 != n3) || (!b && (this.b(n) ? (n2 > n3) : (n2 < n3)))) {
            this.j[n] = n2;
            final double b2 = this.b(this.a, this.a(n));
            final int n4 = this.b(n) ? 1 : -1;
            if (n4 * b2 < n4 * n3 || n4 * b2 < n4 * n2) {
                this.f(n);
            }
        }
    }
    
    private void f(final int n) {
        final int a = ab.a;
        final List list = this.b()[this.a(n)];
        if (list != null) {
            final Iterator<R> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next().b().l[n] = true;
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    private void a(final M m, final boolean b) {
        final D a = this.a(m, b ? this.e : this.d, b);
        if (b) {
            this.h = a;
            if (ab.a == 0) {
                return;
            }
        }
        this.i = a;
    }
    
    private D a(final M m, final D d, final boolean b) {
        final int a = ab.a;
        final D d2 = new D();
        if (d.size() == 0) {
            return d2;
        }
        if (!this.a(d, m, b)) {
            d2.add(new M(m.a() - this.g, m.b() + this.g));
            return d2;
        }
        final Iterator iterator = d.iterator();
        D d3 = null;
    Label_0074:
        while (true) {
            double hasNext = iterator.hasNext() ? 1 : 0;
        Label_0081:
            while (hasNext != 0) {
                final bd bd = iterator.next();
                if (bd.d - bd.c >= 2.0 * this.g) {
                    continue Label_0074;
                }
                double min = bd.d - this.g;
                double max = bd.c + this.g;
                p p3 = null;
                d3 = d2;
                if (a != 0) {
                    break;
                }
                p p4 = d3.k();
                while (p4 != null) {
                    final M i = (M)p4.c();
                    final double n = hasNext = dcmpl(i.a(), max);
                    if (a != 0) {
                        continue Label_0081;
                    }
                    if (n >= 0) {
                        p3 = p4;
                        break;
                    }
                    if (i.b() <= min) {
                        p4 = p4.a();
                        if (a == 0) {
                            continue;
                        }
                    }
                    min = Math.min(min, i.a());
                    max = Math.max(max, i.b());
                    final p p5 = p4;
                    p4 = p4.a();
                    d2.h(p5);
                }
                final M j = new M(min, max);
                if (p3 != null) {
                    d2.a(j, p3);
                    if (a == 0) {
                        continue Label_0074;
                    }
                }
                d2.b(j);
                if (a != 0) {
                    break;
                }
                continue Label_0074;
            }
            break;
        }
        return d3;
    }
    
    private boolean a(final D d, final M m, final boolean b) {
        final int a = ab.a;
        final M i = (this.b != null) ? this.b.b(m, b) : m;
        if (i == null) {
            return false;
        }
        D d2 = new D(d);
        double n = i.a();
        while (true) {
            while (d2.size() > 0) {
                final bd a2 = this.a(d2, n);
                final double max = Math.max(n, a2.b.a());
                a2.c = max;
                n = this.a(max + this.g, b);
                if (a != 0) {
                    double n2 = i.b();
                    while (d2.size() > 0) {
                        final bd b2 = this.b(d2, n2);
                        final double min = Math.min(n2, b2.b.b());
                        b2.d = min;
                        n2 = this.b(min - this.g, b);
                        if (a != 0) {
                            break;
                        }
                    }
                    return true;
                }
                if (a != 0) {
                    break;
                }
            }
            d2 = new D(d);
            continue;
        }
    }
    
    private bd a(final D d, final double n) {
        final int a = ab.a;
        double a2 = Double.MAX_VALUE;
        p p2 = null;
        p p3 = d.k();
        while (p3 != null) {
            final bd bd = (bd)p3.c();
            final Object o;
            final M m = (M)(o = bd.b);
            if (a != 0) {
                return (bd)o;
            }
            if (m.a() < a2) {
                p2 = p3;
                a2 = bd.b.a();
            }
            if (a2 <= n) {
                break;
            }
            p3 = p3.a();
            if (a != 0) {
                break;
            }
        }
        Object o = d.h(p2);
        return (bd)o;
    }
    
    private bd b(final D d, final double n) {
        final int a = ab.a;
        double b = -1.7976931348623157E308;
        p p2 = null;
        p p3 = d.l();
        while (p3 != null) {
            final bd bd = (bd)p3.c();
            final Object o;
            final M m = (M)(o = bd.b);
            if (a != 0) {
                return (bd)o;
            }
            if (m.b() > b) {
                p2 = p3;
                b = bd.b.b();
            }
            if (b >= n) {
                break;
            }
            p3 = p3.b();
            if (a != 0) {
                break;
            }
        }
        Object o = d.h(p2);
        return (bd)o;
    }
    
    private double a(final double n, final boolean b) {
        if (this.b != null) {
            final double n2 = b ? this.b.a() : this.b.b();
            return Math.ceil((n - n2) / this.b.c() * this.b.c()) + n2;
        }
        return n;
    }
    
    private double b(final double n, final boolean b) {
        if (this.b != null) {
            final double n2 = b ? this.b.a() : this.b.b();
            return Math.floor((n - n2) / this.b.c() * this.b.c()) + n2;
        }
        return n;
    }
    
    static D a(final bc bc) {
        return bc.c;
    }
    
    static D b(final bc bc) {
        return bc.e;
    }
    
    static D c(final bc bc) {
        return bc.d;
    }
    
    static double d(final bc bc) {
        return bc.g;
    }
    
    static void a(final bc bc, final int n, final double n2, final boolean b) {
        bc.a(n, n2, b);
    }
    
    static D a(final bc bc, final D h) {
        return bc.h = h;
    }
    
    static D b(final bc bc, final D i) {
        return bc.i = i;
    }
    
    static HashMap e(final bc bc) {
        return bc.f;
    }
    
    static p a(final bc bc, final bd bd, final D d) {
        return bc.a(bd, d);
    }
    
    static double a(final bc bc, final int n) {
        return bc.e(n);
    }
    
    static L f(final bc bc) {
        return bc.b;
    }
}
