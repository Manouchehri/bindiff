package y.f.i.a;

import y.d.*;
import y.c.*;
import y.f.*;
import java.util.*;

public class w
{
    private final d d;
    private final Z e;
    private final boolean f;
    private ai[] g;
    private final List h;
    private final Map i;
    R[] a;
    R[] b;
    R[] c;
    private t j;
    private t k;
    
    w(final d d, final Z e) {
        final int a = ab.a;
        this.i = new HashMap();
        this.e = e;
        this.d = d;
        this.f = true;
        this.h = Collections.EMPTY_LIST;
        final X a2 = e.a();
        Label_0113: {
            if (y.b(d, a2)) {
                final m[] c = y.c(d, a2);
                this.g = new ai[c.length];
                int i = 0;
                while (i < c.length) {
                    this.g[i] = new ai(d, i, c[i]);
                    ++i;
                    if (a != 0) {
                        break Label_0113;
                    }
                }
                return;
            }
        }
        final ArrayList list = new ArrayList<Object>();
        final v l = a2.l(d);
        final int n = l.h() - 1;
        int j = 0;
        while (true) {
            while (j < n) {
                final m a3 = l.a(j);
                final int a4;
                final int n2 = a4 = (this.a(a3) ? 1 : 0);
                if (a != 0) {
                    int k = a4;
                    while (k < list.size()) {
                        this.g[k] = new ai(d, k, (m)list.get(k));
                        ++k;
                        if (a != 0) {
                            break;
                        }
                    }
                    return;
                }
                if (n2 != 0) {
                    list.add(a3);
                }
                ++j;
                if (a != 0) {
                    break;
                }
            }
            this.g = new ai[list.size()];
            int a4 = 0;
            continue;
        }
    }
    
    void a() {
        final int a = ab.a;
        final HashSet<ah> set = new HashSet<ah>();
        int i = 0;
        while (true) {
            while (i < this.g.length) {
                final w w = this;
                if (a != 0) {
                    final Iterator iterator = w.d().iterator();
                    while (iterator.hasNext()) {
                        iterator.next().a(this);
                        if (a != 0) {
                            break;
                        }
                    }
                    return;
                }
                final ai ai = this.g[i];
                final double e = ai.e();
                final M m = new M(e, e);
                ai.b(m);
                final ah k = ai.k();
                if (k != null && set.add(k)) {
                    k.a(m);
                    k.c().b(m);
                }
                ++i;
                if (a != 0) {
                    break;
                }
            }
            final w w = this;
            continue;
        }
    }
    
    private boolean a(final m m) {
        return m.b() || m.a();
    }
    
    public w(final U u, final Z e) {
        this.i = new HashMap();
        this.e = e;
        this.d = u.a();
        this.f = false;
        this.h = this.a(u);
        this.b(this.a(this.h));
        this.a(this.g);
    }
    
    w(final d d, final List list, final Z e) {
        this.i = new HashMap();
        this.e = e;
        this.d = d;
        this.f = false;
        this.h = null;
        this.b(list);
    }
    
    public boolean b() {
        return this.f;
    }
    
    private void a(final ai[] array) {
        if (array.length > 1) {
            final x a = this.e.c().a(this.d);
            this.a(array[1], this.e.a().s(this.d.c()), a.a());
            this.a(array[array.length - 2], this.e.a().s(this.d.d()), a.b());
        }
    }
    
    private void a(final ai ai, final y.d.y y, final double n) {
        final M m = ai.g() ? new M(y.c(), y.c() + y.a()) : new M(y.d(), y.d() + y.b());
        final M i = new M(m.a() - n, m.b() + n);
        final M c = ai.c();
        if (i.a(c, 1.0E-6)) {
            if (c.a() < m.a() + 1.0E-6) {
                ai.b(new M(c.a(), Math.max(c.a(), i.a())));
                if (ab.a == 0) {
                    return;
                }
            }
            ai.b(new M(Math.min(i.b(), c.b()), c.b()));
        }
    }
    
    private List a(final U u) {
        final int a = ab.a;
        if (u.b() == 0) {
            return Collections.EMPTY_LIST;
        }
        final D d = new D();
        f f = null;
        P p = null;
        int i = u.b() - 1;
        while (i >= 0) {
            final f a2 = u.a(i);
            final R a3 = a2.a();
            P p2 = a2.c();
            Label_0402: {
                if (i == 0) {
                    final y.f.i.a.v v = new y.f.i.a.v(this.d, a3, null, p, null, f.d(), 0);
                    d.add(0, v);
                    this.i.put(a2, v);
                    if (a == 0) {
                        break Label_0402;
                    }
                }
                if (f != null) {
                    final P p3 = p;
                    final y.f.y d2 = a2.d();
                    final y.f.y d3 = f.d();
                    if (d2 == d3 && p2.b(p3)) {
                        p2 = P.a(p, a2.c());
                    }
                    final y.f.i.a.v v2 = new y.f.i.a.v(this.d, a3, p2, p3, d2, d3, 0);
                    d.add(0, v2);
                    this.i.put(a2, v2);
                    if (a == 0) {
                        break Label_0402;
                    }
                }
                final aU a4 = this.e.a(this.d);
                if (a4 != null) {
                    final List a5 = a4.a(a4.a(u, false));
                    if (!a5.isEmpty()) {
                        final boolean e = a2.d().e();
                        final t a6 = a4.a(a5.get(0), false);
                        final double n = e ? a6.a() : a6.b();
                        p2 = new P(n, n, p2.f(), !e);
                    }
                }
                final y.f.i.a.v v3 = new y.f.i.a.v(this.d, a3, p2, null, a2.d(), null, 0);
                d.add(0, v3);
                this.i.put(a2, v3);
            }
            p = p2;
            f = a2;
            --i;
            if (a != 0) {
                break;
            }
        }
        return d;
    }
    
    private D a(final List list) {
        final int a = ab.a;
        int e = 0;
        final D d = new D();
        D d2 = null;
        for (final y.f.i.a.v v : list) {
            v.a(e);
            final D m = v.m();
            d2 = d;
            if (a != 0) {
                return d2;
            }
            d2.addAll(m);
            e = v.e();
            if (a != 0) {
                break;
            }
        }
        return d2;
    }
    
    private void b(final List list) {
        final int a = ab.a;
        final ai[] g = new ai[list.get(list.size() - 1).j() + 1];
        this.a = new R[g.length - 1];
        this.b = new R[g.length - 1];
        this.c = new R[g.length - 1];
        y.f.y h = null;
        int n = -1;
        g g2 = null;
        M a2 = null;
        M m = null;
        ArrayList<g> list2 = new ArrayList<g>();
        while (true) {
            for (final g g3 : list) {
                final int n2 = n;
                if (a != 0) {
                    int i = n2;
                    while (i < g.length - 1) {
                        final ai ai = g[i];
                        final ai ai2 = g[i + 1];
                        this.a[i] = ai2.b(0).l();
                        if (a != 0) {
                            return;
                        }
                        Label_0486: {
                            if (ai.l() > 1) {
                                final g b = ai.b(ai.l() - 2);
                                if (b.g()) {
                                    this.c[i] = b.l();
                                    if (a == 0) {
                                        break Label_0486;
                                    }
                                }
                                this.b[i] = b.l();
                            }
                        }
                        Label_0540: {
                            if (ai2.l() > 1) {
                                final g b2 = ai2.b(1);
                                if (b2.g()) {
                                    this.c[i] = b2.l();
                                    if (a == 0) {
                                        break Label_0540;
                                    }
                                }
                                this.b[i] = b2.l();
                            }
                        }
                        ++i;
                        if (a != 0) {
                            break;
                        }
                    }
                    this.g = g;
                    return;
                }
                Label_0317: {
                    if (n2 != g3.j()) {
                        if (g2 != null) {
                            final y.f.y h2 = g3.h();
                            final ai ai3 = new ai(g2.i(), n, g2.h(), g2.c(), a2, m, list2);
                            list2 = new ArrayList<g>();
                            g[n] = ai3;
                            Label_0235: {
                                if (h != null && h2.c() == h) {
                                    if (y.f.y.c == h || y.f.y.b == h) {
                                        ai3.a((byte)(-1));
                                        if (a == 0) {
                                            break Label_0235;
                                        }
                                    }
                                    ai3.a((byte)1);
                                }
                            }
                            h = g2.h();
                        }
                        g2 = g3;
                        m = g3.b();
                        a2 = g3.a();
                        ++n;
                        if (a == 0) {
                            break Label_0317;
                        }
                    }
                    a2 = ((g3.a() == null) ? a2 : ((a2 == null) ? g3.a() : M.b(a2, g3.a())));
                    m = M.b(m, g3.b());
                }
                list2.add(g3);
                if (a != 0) {
                    break;
                }
            }
            if (g2 != null) {
                g[g.length - 1] = new ai(g2.i(), g.length - 1, g2.h(), g2.c(), a2, m, list2);
            }
            continue;
        }
    }
    
    public d c() {
        return this.d;
    }
    
    public List d() {
        return this.h;
    }
    
    public y.f.i.a.v a(final f f) {
        return this.i.get(f);
    }
    
    public ai a(final int n) {
        if (n >= this.g.length) {
            return null;
        }
        return this.g[n];
    }
    
    public ai a(final ai ai) {
        return (ai.j() > 0) ? this.a(ai.j() - 1) : null;
    }
    
    public ai b(final ai ai) {
        return this.a(ai.j() + 1);
    }
    
    public int e() {
        return this.g.length;
    }
    
    public String toString() {
        final int a = ab.a;
        final StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < this.g.length) {
            final StringBuffer append = sb.append(this.g[i].h().toString());
            if (a != 0) {
                return append.toString();
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
        final StringBuffer append = sb;
        return append.toString();
    }
    
    public void a(final t j) {
        this.j = j;
        final ai ai = this.g[0];
        ai.a(true);
        if (ai.f()) {
            if ((ai.g() && Math.abs(ai.e() - j.a) > 1.0E-6) || (!ai.g() && Math.abs(ai.e() - j.b) > 1.0E-6)) {
                throw new IllegalArgumentException("Port location (" + j.a() + ", " + j.b() + ") contradict the fixed location " + ai.e() + " of the first segment");
            }
        }
        else {
            ai.a(ai.g() ? j.a : j.b);
        }
    }
    
    public void b(final t k) {
        this.k = k;
        final ai ai = this.g[this.e() - 1];
        ai.a(true);
        if (ai.f()) {
            if ((ai.g() && Math.abs(ai.e() - k.a) > 1.0E-6) || (!ai.g() && Math.abs(ai.e() - k.b) > 1.0E-6)) {
                throw new IllegalArgumentException("Port location (" + k.a() + ", " + k.b() + ") contradict the fixed location " + ai.e() + " of the first segment");
            }
        }
        else {
            ai.a(ai.g() ? k.a : k.b);
        }
    }
    
    private t h() {
        if (this.j != null) {
            return this.j;
        }
        final y.d.y s = this.e.a().s(this.d.c());
        final ai ai = this.g[0];
        if (y.f.y.c == ai.h()) {
            return new t(ai.e(), s.d() + s.b());
        }
        if (y.f.y.a == ai.h()) {
            return new t(ai.e(), s.d());
        }
        if (y.f.y.d == ai.h()) {
            return new t(s.c(), ai.e());
        }
        return new t(s.c() + s.a(), ai.e());
    }
    
    private t i() {
        if (this.k != null) {
            return this.k;
        }
        final y.d.y s = this.e.a().s(this.d.d());
        final ai ai = this.g[this.g.length - 1];
        if (y.f.y.c == ai.h()) {
            return new t(ai.e(), s.d());
        }
        if (y.f.y.a == ai.h()) {
            return new t(ai.e(), s.d() + s.b());
        }
        if (y.f.y.d == ai.h()) {
            return new t(s.c() + s.a(), ai.e());
        }
        return new t(s.c(), ai.e());
    }
    
    public m[] f() {
        final int a = ab.a;
        final m[] array = new m[this.e()];
        t t = null;
        int n = 0;
        for (final t t2 : this.g()) {
            if (t != null) {
                array[n++] = new m(t, t2);
            }
            t = t2;
            if (a != 0) {
                break;
            }
        }
        return array;
    }
    
    public D g() {
        final D d = new D();
        d.add(this.h());
        d.a(this.j());
        d.add(this.i());
        return d;
    }
    
    private D j() {
        final int a = ab.a;
        final D d = new D();
        if (this.g.length <= 1) {
            return d;
        }
        if (!this.k()) {
            throw new RuntimeException("found segments without fixed locations!");
        }
        final ai ai = this.g[0];
        double n = ai.e();
        double n2 = ai.e();
        int i = 1;
        while (i < this.g.length) {
            final ai ai2 = this.g[i];
            Label_0108: {
                if (ai2.g()) {
                    n = ai2.e();
                    if (a == 0) {
                        break Label_0108;
                    }
                }
                n2 = ai2.e();
            }
            d.add(new t(n, n2));
            ++i;
            if (a != 0) {
                break;
            }
        }
        return d;
    }
    
    private boolean k() {
        final int a = ab.a;
        int i = 0;
        boolean f = false;
        while (i < this.g.length) {
            f = this.g[i].f();
            if (a != 0) {
                return f;
            }
            if (!f) {
                return false;
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
        return f;
    }
    
    void a(final ai ai, final ai ai2) {
        final int a = ab.a;
        final boolean b = ai.j() < ai2.j();
        final int n = b ? ai.j() : ai2.j();
        final ai[] g = new ai[this.g.length + 2];
        int i = 0;
        while (true) {
            while (i < n) {
                g[i] = this.g[i];
                ++i;
                if (a != 0) {
                    g[n + 1] = (b ? ai2 : ai);
                    int j = n;
                    while (j < this.g.length) {
                        final ai ai3 = this.g[j];
                        ai3.a(j + 2);
                        g[j + 2] = ai3;
                        ++j;
                        if (a != 0) {
                            return;
                        }
                        if (a != 0) {
                            break;
                        }
                    }
                    this.g = g;
                    return;
                }
                if (a != 0) {
                    break;
                }
            }
            g[n] = (b ? ai : ai2);
            continue;
        }
    }
}
