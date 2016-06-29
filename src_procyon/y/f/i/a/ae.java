package y.f.i.a;

import y.g.*;
import y.f.b.*;
import y.f.*;
import y.d.*;
import y.c.*;
import java.util.*;

public class ae extends a
{
    private static final y a;
    private Object b;
    private Object c;
    private byte d;
    private double e;
    private double f;
    private double g;
    
    public ae(final ah ah) {
        super(ah);
        this.b = ah.h_;
        this.c = ah.g_;
        this.e = 10.0;
        this.f = 0.5;
        this.g = 50.0;
    }
    
    public ae() {
        this.b = ah.h_;
        this.c = ah.g_;
        this.e = 10.0;
        this.f = 0.5;
        this.g = 50.0;
    }
    
    private static y h() {
        final y y = new y();
        y.a((byte)2);
        return y;
    }
    
    public Object b() {
        return this.c;
    }
    
    public void a(final Object c) {
        if (c == null) {
            throw new IllegalArgumentException("null");
        }
        this.c = c;
    }
    
    public Object c() {
        return this.b;
    }
    
    public void b(final Object b) {
        if (b == null) {
            throw new IllegalArgumentException("null");
        }
        this.b = b;
    }
    
    public void a(final byte d) {
        switch (d) {
            case 0:
            case 2:
            case 4: {
                this.d = d;
                if (ab.a != 0) {
                    break;
                }
                return;
            }
        }
        throw new IllegalArgumentException("Argument '" + d + "' not allowed.");
    }
    
    public byte d() {
        return this.d;
    }
    
    public double e() {
        return this.e;
    }
    
    public void a(final double e) {
        if (e < 0.0) {
            throw new IllegalArgumentException("The distance must not be less than 0!");
        }
        this.e = e;
    }
    
    public double f() {
        return this.f;
    }
    
    public void b(final double f) {
        if (f < 0.0 || f > 0.5) {
            throw new IllegalArgumentException("The ratio must be between 0 and 0.5!");
        }
        this.f = f;
    }
    
    public double g() {
        return this.g;
    }
    
    public void c(final double g) {
        if (g < 0.0) {
            throw new IllegalArgumentException("The length must not be less than 0!");
        }
        this.g = g;
    }
    
    public void c(final X x) {
        int a = ab.a;
        this.a(x);
        final f f = new f();
        final I i = new I(x);
        final e p = x.p();
        while (true) {
            while (p.f()) {
                final d a2 = p.a();
                if (a != 0) {
                    final ag ag = new ag(new n(), null);
                    ag.a(new aC());
                    ag.a(new az());
                    final c c = new c(x);
                    final Z z = new Z(x, c, ae.a);
                    ag.a(z);
                    final ac a3 = this.a(x, ag, z);
                    final aN an = new aN();
                    an.a(this.f());
                    an.b(this.g());
                    an.a(f, a3, z);
                    ag.a();
                    new aI().c(x);
                    c.c();
                    i.f();
                    if (y.c.i.g) {
                        ab.a = ++a;
                    }
                    return;
                }
                Label_0094: {
                    if (!y.a(a2, x)) {
                        i.a(a2);
                        if (a == 0) {
                            break Label_0094;
                        }
                    }
                    if (this.a(a2, x)) {
                        f.add(a2);
                    }
                }
                p.g();
                if (a != 0) {
                    break;
                }
            }
            ae.a.a(this.e());
            continue;
        }
    }
    
    private boolean a(final d d, final i i) {
        if (this.d() == 0) {
            return true;
        }
        if (this.d() == 2) {
            final y.c.c c = i.c(this.c());
            return c != null && c.d(d);
        }
        if (this.d() == 4) {
            final y.c.c c2 = i.c(this.b());
            return c2 != null && (c2.d(d.c()) || c2.d(d.d()));
        }
        return false;
    }
    
    private ac a(final X x, final y.f.i.a.I i, final Z z) {
        final int a = ab.a;
        final ac ac = new ac(z);
        final e p3 = x.p();
        while (p3.f()) {
            final d d = (d)p3.d();
            ac.a(d, this.a(d, x, i, z));
            p3.g();
            if (a != 0) {
                return ac;
            }
            if (a != 0) {
                break;
            }
        }
        this.a(x, ac);
        return ac;
    }
    
    private void a(final X x, final ac ac) {
        final int i = ab.a;
        final HashMap<t, ai> hashMap = new HashMap<t, ai>();
        final e p2 = x.p();
        do {
            Label_0019: {
                p2.f();
            }
            boolean hasNext = false;
            Label_0026:
            while (hasNext) {
                final w a = ac.a(p2.a());
                if (a != null) {
                    final Iterator iterator = a.g().iterator();
                    iterator.next();
                    int j = 1;
                    while (j < a.e()) {
                        hasNext = iterator.hasNext();
                        if (i != 0) {
                            continue Label_0026;
                        }
                        if (!hasNext) {
                            break;
                        }
                        final t t = iterator.next();
                        final ai a2 = a.a(j);
                        Label_0244: {
                            if (hashMap.containsKey(t)) {
                                final ai ai = hashMap.get(t);
                                y.f.i.a.ah k = ai.k();
                                if (k == null) {
                                    final D d = new D();
                                    d.add(ai);
                                    d.add(a2);
                                    k = new y.f.i.a.ah(ai.c(), d);
                                    ai.a(k);
                                    a2.a(k);
                                    if (i == 0) {
                                        break Label_0244;
                                    }
                                }
                                k.b().add(a2);
                                a2.a(k);
                                if (i == 0) {
                                    break Label_0244;
                                }
                            }
                            hashMap.put(t, a2);
                        }
                        ++j;
                        if (i != 0) {
                            break;
                        }
                    }
                }
                p2.g();
                continue Label_0019;
            }
            break;
        } while (i == 0);
        final D d2 = new D(hashMap.keySet());
        d2.sort(new af(this));
        t t2 = null;
        y.f.i.a.ah l = null;
        for (final t t3 : d2) {
            Label_0627: {
                Label_0623: {
                    if (t2 != null && Math.abs(t2.a() - t3.a()) < 1.0E-6 && Math.abs(t2.b() - t3.b()) < 1.0E-6) {
                        if (l != null) {
                            final ai ai2 = hashMap.get(t3);
                            Label_0467: {
                                if (ai2.k() != null) {
                                    for (final ai ai3 : ai2.k().b()) {
                                        ai3.a(l);
                                        l.b().add(ai3);
                                        if (i != 0) {
                                            break Label_0627;
                                        }
                                        if (i != 0) {
                                            break Label_0467;
                                        }
                                    }
                                    break Label_0623;
                                }
                            }
                            ai2.a(l);
                            l.b().add(ai2);
                            if (i == 0) {
                                break Label_0623;
                            }
                        }
                        final ai ai4 = hashMap.get(t2);
                        final ai ai5 = hashMap.get(t3);
                        if (ai5.k() != null) {
                            l = ai5.k();
                            l.b().add(ai4);
                            ai4.a(l);
                            if (i == 0) {
                                break Label_0623;
                            }
                        }
                        l = new y.f.i.a.ah(ai4.c(), new D());
                        l.b().add(ai4);
                        l.b().add(ai5);
                        ai4.a(l);
                        ai5.a(l);
                        if (i == 0) {
                            break Label_0623;
                        }
                    }
                    l = null;
                }
                t2 = t3;
            }
            if (i != 0) {
                break;
            }
        }
    }
    
    private w a(final d d, final X x, final y.f.i.a.I i, final Z z) {
        final int j = ab.a;
        if (!y.b(d, x)) {
            return null;
        }
        final D d2 = new D();
        final y.d.m[] c = y.c(d, x);
        if (c.length == 0) {
            return null;
        }
        int n = 0;
        do {
            int k = 0;
        Label_0042:
            while (k < c.length) {
                R a = null;
                y.d.m m = c[n];
                final y.f.y b = b(m);
                while (m != null) {
                    a = this.a(m, i, a);
                    final y.d.m[] a2 = this.a(m, a, b);
                    k = (m.b() ? 1 : 0);
                    if (j != 0) {
                        continue Label_0042;
                    }
                    double n2 = 0.0;
                    M l = null;
                    Label_0189: {
                        if (k != 0) {
                            n2 = m.c().b();
                            l = new M(a2[0].c().a(), a2[0].d().a());
                            if (j == 0) {
                                break Label_0189;
                            }
                        }
                        n2 = m.c().a();
                        l = new M(a2[0].c().b(), a2[0].d().b());
                    }
                    if (l.d() > 0.0) {
                        final g g = new g(d, n, b, new M(n2, n2), l, l, a);
                        g.a(n2);
                        d2.add(g);
                    }
                    m = a2[1];
                    if (j != 0) {
                        break;
                    }
                }
                ++n;
            }
            break;
        } while (j == 0);
        final w w = new w(d, d2, z);
        int n3 = 0;
        w w2 = null;
        while (n3 < w.e()) {
            w2 = w;
            if (j != 0) {
                return w2;
            }
            final ai a3 = w2.a(n3);
            a3.a(a3.b(0).e());
            ++n3;
            if (j != 0) {
                break;
            }
        }
        return w2;
    }
    
    private R a(final y.d.m m, final y.f.i.a.I i, final R r) {
        final int a = ab.a;
        final double a2 = this.a(m);
        double a3 = 0.0;
        double b = 0.0;
        Label_0116: {
            if (a2 > 3.0E-6) {
                a3 = m.c().a() + (m.d().a() - m.c().a()) / a2 * 1.0E-6 * 2.0;
                b = m.c().b() + (m.d().b() - m.c().b()) / a2 * 1.0E-6 * 2.0;
                if (a == 0) {
                    break Label_0116;
                }
            }
            a3 = m.d().a();
            b = m.d().b();
        }
        if (r != null) {
            final y.d.y g = r.g();
            if (y.d.y.a(g.c() - 1.0E-6, g.d() - 1.0E-6, g.a() + 2.0E-6, g.b() + 2.0E-6, a3, b, true)) {
                return r;
            }
        }
        final y.d.y y = new y.d.y(a3 - 1.0E-6, b - 1.0E-6, 2.0E-6, 2.0E-6);
        List a4 = null;
        Label_0340: {
            if (r == null) {
                a4 = i.a(y);
                if (a == 0) {
                    break Label_0340;
                }
            }
            a4 = new D();
            for (final R r2 : i.c(r)) {
                final y.d.y g2 = r2.g();
                if (y.d.y.a(g2.c() - 1.0E-6, g2.d() - 1.0E-6, g2.a() + 2.0E-6, g2.b() + 2.0E-6, a3, b, true)) {
                    a4.add(r2);
                    if (a != 0) {
                        return a4.get(0);
                    }
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
            }
        }
        if (a4.isEmpty()) {
            return null;
        }
        return a4.get(0);
    }
    
    private double a(final y.d.m m) {
        if (m.b()) {
            return Math.abs(m.c().a() - m.d().a());
        }
        if (m.a()) {
            return Math.abs(m.c().b() - m.d().b());
        }
        return m.g();
    }
    
    private static y.f.y b(final y.d.m m) {
        final t c = m.c();
        final t d = m.d();
        if (c.a() < d.a() && Math.abs(c.b() - d.b()) < 1.0E-6) {
            return y.f.y.b;
        }
        if (c.b() < d.b() && Math.abs(c.a() - d.a()) < 1.0E-6) {
            return y.f.y.c;
        }
        if (d.a() < c.a() && Math.abs(c.b() - d.b()) < 1.0E-6) {
            return y.f.y.d;
        }
        if (d.b() < c.b() && Math.abs(c.a() - d.a()) < 1.0E-6) {
            return y.f.y.a;
        }
        throw new IllegalArgumentException("Segment isn't orthogonal");
    }
    
    private y.d.m[] a(final y.d.m m, final R r, final y.f.y y) {
        final y.d.y g = r.g();
        final t c = m.c();
        final t d = m.d();
        final double a = this.a(m);
        double a2 = 0.0;
        double b = 0.0;
        Label_0114: {
            if (a > 3.0E-6) {
                a2 = c.a() + (d.a() - c.a()) / a * 1.0E-6 * 2.0;
                b = c.b() + (d.b() - c.b()) / a * 1.0E-6 * 2.0;
                if (ab.a == 0) {
                    break Label_0114;
                }
            }
            a2 = d.a();
            b = d.b();
        }
        final double c2 = g.c();
        final double a3 = g.a();
        final double d2 = g.d();
        final double b2 = g.b();
        if (!y.d.y.a(c2 - 1.0E-6, d2 - 1.0E-6, a3 + 2.0E-6, b2 + 2.0E-6, a2, b, true)) {
            throw new IllegalArgumentException("LineSegment doesn't start in passed cell");
        }
        if ((y.d() && a(c2, c2 + a3, d.a())) || (!y.d() && a(d2, d2 + b2, d.b()))) {
            return new y.d.m[] { m, null };
        }
        t t;
        if (y.f.y.b.equals(y)) {
            t = new t(r.j(), c.b());
        }
        else if (y.f.y.d.equals(y)) {
            t = new t(r.h(), c.b());
        }
        else if (y.f.y.c.equals(y)) {
            t = new t(c.a(), r.k());
        }
        else {
            t = new t(c.a(), r.i());
        }
        return new y.d.m[] { new y.d.m(c, t), new y.d.m(t, d) };
    }
    
    private static boolean a(final double n, final double n2, final double n3) {
        return n3 + 1.0E-6 >= n && n3 - 1.0E-6 <= n2;
    }
    
    static {
        a = h();
    }
}
