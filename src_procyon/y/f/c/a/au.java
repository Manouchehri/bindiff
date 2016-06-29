package y.f.c.a;

import y.g.*;
import y.d.*;
import y.c.*;
import java.util.*;
import y.f.*;
import java.awt.geom.*;

final class au implements aP
{
    private final X c;
    private final aV d;
    private C e;
    private final aU f;
    private final A g;
    private final h h;
    private cq i;
    private dC j;
    private dp k;
    private bP l;
    private cd m;
    private E n;
    private final c o;
    private final c p;
    private final c q;
    private final c r;
    private final c s;
    private final c t;
    private final c u;
    private final c v;
    private final c w;
    private final c x;
    private final h y;
    private final ap z;
    private final Map A;
    private final Map B;
    Comparator a;
    Comparator b;
    
    public au(final X c, final aU f, final aV d, final C e, final A g, final h h, final c v, final c u, final c w, final c x, final h y, final ap z) {
        this.A = new HashMap();
        this.B = new HashMap();
        this.c = c;
        this.f = f;
        this.d = d;
        this.e = e;
        this.h = h;
        this.g = g;
        this.o = c.c(aF.a);
        this.p = c.c(aF.b);
        this.q = c.c(ax.a);
        this.r = c.c(ax.b);
        this.s = c.c(aF.c);
        this.t = c.c(aF.d);
        this.x = x;
        this.v = v;
        this.u = u;
        this.w = w;
        this.y = y;
        this.z = z;
    }
    
    void a(final cq i) {
        this.i = i;
    }
    
    void a(final dC j) {
        this.j = j;
    }
    
    void a(final E n) {
        this.n = n;
    }
    
    void a(final bP l) {
        this.l = l;
    }
    
    void a(final cd m) {
        this.m = m;
    }
    
    void a(final dp k) {
        this.k = k;
    }
    
    public q a(final aQ aq, final q q, final d d) {
        return this.a(aq, q, d, null);
    }
    
    public q a(final aQ aq, final q q, final d d, final bK bk) {
        final q d2 = this.c.d();
        this.c.b(d2, 0.0, 0.0);
        final boolean b = q == d.c();
        final t t = b ? this.c.p(d) : this.c.q(d);
        this.c.c(d2, t.a, t.b);
        this.b(d2, b ? d.c() : d.d(), d, bk);
        aq.a(d2);
        return d2;
    }
    
    public void a(final q q) {
        final boolean x = N.x;
        final aX a = this.d.a(q);
        final aQ a2 = this.f.a(a.j());
        final q f = a.f();
        final d g = a.g();
        final I b = this.c.b((Object)g);
        Label_0200: {
            Label_0173: {
                if (g.c() == f) {
                    b.addPoint(0.0, 0.0);
                    int i = b.pointCount() - 1;
                    while (true) {
                        while (i >= 1) {
                            final t point = b.getPoint(i - 1);
                            b.setPoint(i, point.a, point.b);
                            --i;
                            if (!x) {
                                if (x) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (x) {
                                    break Label_0173;
                                }
                                break Label_0200;
                            }
                        }
                        b.setPoint(0, this.c.j(q), this.c.p(g).b());
                        continue;
                    }
                }
            }
            b.addPoint(this.c.j(q), this.c.q(g).b());
        }
        a2.b(q);
        this.c.a(q);
    }
    
    public q a(final d d, final boolean b) {
        return this.a(d, b, (bK)null);
    }
    
    public q a(final d d, final boolean b, final bK bk) {
        final int j = this.d.a(b ? d.c() : d.d()).j();
        final q d2 = this.c.d();
        this.c.b(d2, 0.0, 0.0);
        final t t = b ? this.c.p(d) : this.c.q(d);
        this.c.c(d2, t.a, t.b);
        this.a(d2, b ? d.c() : d.d(), d, bk);
        this.f.a(j).a(d2);
        if (b) {
            this.A.put(d, this.c.n(d));
            this.c.a(d, y.d.t.c);
            this.c.a(d, d2, d.d());
            if (!N.x) {
                return d2;
            }
        }
        this.B.put(d, this.c.o(d));
        this.c.b(d, y.d.t.c);
        this.c.a(d, d.c(), d2);
        return d2;
    }
    
    public d b(final q q) {
        final boolean x = N.x;
        final aX a = this.d.a(q);
        final aQ a2 = this.f.a(a.j());
        d d = null;
        Label_0770: {
            Label_0485: {
                if (q.c() > 0) {
                    this.c.a(d = q.f(), a.f(), q.f().d());
                    this.c.a(d, (t)this.A.get(d));
                    final I b = this.c.b((Object)d);
                    final B k = this.d.a(d).k();
                    final double n = k.i() / Math.abs(2);
                    Label_0247: {
                        if (k.h().c() != 1) {
                            b.addPoint(0.0, 0.0);
                            int i = b.pointCount() - 1;
                            while (true) {
                                while (i >= 1) {
                                    final t point = b.getPoint(i - 1);
                                    b.setPoint(i, point.a, point.b);
                                    --i;
                                    if (!x) {
                                        if (x) {
                                            break;
                                        }
                                        continue;
                                    }
                                    else {
                                        if (x) {
                                            break Label_0247;
                                        }
                                        break Label_0770;
                                    }
                                }
                                b.setPoint(0, this.c.j(q), this.c.p(d).b());
                                continue;
                            }
                        }
                    }
                    b.addPoint(0.0, 0.0);
                    b.addPoint(0.0, 0.0);
                    int j = b.pointCount() - 1;
                    while (true) {
                        while (j >= 2) {
                            final t point2 = b.getPoint(j - 2);
                            b.setPoint(j, point2.a, point2.b);
                            --j;
                            if (!x) {
                                if (x) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (x) {
                                    break Label_0485;
                                }
                                break Label_0770;
                            }
                        }
                        if (this.c.j(q) < this.c.p(d).a()) {
                            b.setPoint(0, this.c.j(q) + n, this.c.p(d).b());
                            b.setPoint(1, this.c.j(q), this.c.p(d).b() + n);
                            if (!x) {
                                break Label_0770;
                            }
                        }
                        b.setPoint(0, this.c.j(q) - n, this.c.p(d).b());
                        b.setPoint(1, this.c.j(q), this.c.p(d).b() + n);
                        continue;
                    }
                }
            }
            this.c.a(d = q.g(), q.g().c(), a.f());
            this.c.b(d, (t)this.B.get(d));
            final I b2 = this.c.b((Object)d);
            final B l = this.d.a(d).k();
            final double n2 = l.i() / Math.abs(2);
            if (l.h().c() != 1) {
                b2.addPoint(this.c.j(q), this.c.q(d).b());
                if (!x) {
                    break Label_0770;
                }
            }
            if (this.c.j(q) < this.c.q(d).a()) {
                b2.addPoint(this.c.j(q), this.c.q(d).b() - n2);
                b2.addPoint(this.c.j(q) + n2, this.c.q(d).b());
                if (!x) {
                    break Label_0770;
                }
            }
            b2.addPoint(this.c.j(q), this.c.q(d).b() - n2);
            b2.addPoint(this.c.j(q) - n2, this.c.q(d).b());
        }
        a2.b(q);
        this.c.a(q);
        return d;
    }
    
    public q a(final aQ aq, final d d) {
        return this.a(aq, d, (bK)null);
    }
    
    public q a(final aQ aq, final d d, final bK bk) {
        final q d2 = this.c.d();
        this.c.b(d2, 0.0, 0.0);
        Label_0047: {
            if (bk == null) {
                this.a(d2, d);
                if (!N.x) {
                    break Label_0047;
                }
            }
            this.a(d2, d, bk);
        }
        aq.a(d2);
        return d2;
    }
    
    public aQ a(final boolean b, final int n) {
        if (b) {
            final aQ a = this.f.a((byte)1, n);
            this.a(this.f.a(n - 1), true, a);
            return a;
        }
        final aQ a2 = this.f.a((byte)1, n);
        this.a(this.f.a(n + 2), false, a2);
        return a2;
    }
    
    private void a(final aQ aq, final boolean b, final aQ aq2) {
        final boolean x = N.x;
        Label_0138: {
            if (b) {
                if (this.a == null) {
                    this.a = new cG(this.c, this.f, this.d);
                }
                p p3 = aq.d().k();
            Label_0133_Outer:
                while (p3 != null) {
                    final q q = (q)p3.c();
                    q.b(this.a);
                    final d[] e = new f(q.l()).e();
                    int i = 0;
                    while (true) {
                        while (i < e.length) {
                            this.a(e[i], aq2, b);
                            ++i;
                            if (!x) {
                                if (x) {
                                    break;
                                }
                                continue Label_0133_Outer;
                            }
                            else {
                                if (x) {
                                    break Label_0138;
                                }
                                continue Label_0133_Outer;
                            }
                        }
                        p3 = p3.a();
                        continue;
                    }
                }
                return;
            }
        }
        if (this.b == null) {
            this.b = new cR(this.c, this.f, this.d);
        }
        p p4 = aq.d().k();
    Label_0262_Outer:
        while (p4 != null) {
            final q q2 = (q)p4.c();
            q2.a(this.b);
            final d[] e2 = new f(q2.k()).e();
            int j = 0;
            while (true) {
                while (j < e2.length) {
                    this.a(e2[j], aq2, b);
                    ++j;
                    if (!x) {
                        if (x) {
                            break;
                        }
                        continue Label_0262_Outer;
                    }
                    else {
                        if (x) {
                            break Label_0262_Outer;
                        }
                        continue Label_0262_Outer;
                    }
                }
                p4 = p4.a();
                continue;
            }
        }
    }
    
    private q c(final aQ aq, final d d) {
        final aX ax = (aX)this.g.b(d.c());
        if (ax.b() == 12 || ax.b() == 13) {
            final q l = ax.l();
            return this.a(aq, d, (ax.b() == 12) ? this.n.a(l) : this.n.b(l));
        }
        return this.a(aq, d);
    }
    
    private void a(final d d, final aQ aq, final boolean b) {
        final boolean x = N.x;
        final aX ax = (aX)this.g.b(d.c());
        final aX ax2 = (aX)this.g.b(d.d());
        final boolean b2 = ax.b() == 1;
        final boolean b3 = ax2.b() == 1;
        if (b2 && b3) {
            final q c = this.c(aq, ax.g());
            final q d2 = d.d();
            final d i = d.i();
            Label_0163: {
                if (i == null) {
                    this.c.a(d, d.c(), d.g(), 1, c, null, 0);
                    if (!x) {
                        break Label_0163;
                    }
                }
                this.c.a(d, d.c(), i, 0, c, null, 0);
            }
            this.a(c, d2, d, false, false);
            if (!x) {
                return;
            }
        }
        if (b2 && !b3) {
            final q c2 = this.c(aq, ax.g());
            final q c3 = d.c();
            Label_0268: {
                if (d.j() == null) {
                    this.c.a(d, c2, null, 0, d.d(), d.h(), 1);
                    if (!x) {
                        break Label_0268;
                    }
                }
                this.c.a(d, c2, null, 0, d.d(), d.j(), 0);
            }
            this.a(c3, c2, d, false, false);
            if (!x) {
                return;
            }
        }
        if (b3 && !b2) {
            final q c4 = this.c(aq, ax2.g());
            final q d3 = d.d();
            final d j = d.i();
            Label_0371: {
                if (j == null) {
                    this.c.a(d, d.c(), d.g(), 1, c4, null, 0);
                    if (!x) {
                        break Label_0371;
                    }
                }
                this.c.a(d, d.c(), j, 0, c4, null, 0);
            }
            this.a(c4, d3, d, false, false);
            if (!x) {
                return;
            }
        }
        if (((y.f.c.a.A)this.h.b(d)).a() == 6) {
            final q a = this.a(ax.l(), aq, ax.b());
            aq.a(a);
            this.a(d.c(), a);
            this.a(a, d.d());
        }
        else {
            final q c5 = this.c(aq, d);
            final d a2 = this.a(d.c(), c5, d, true, false);
            this.c.a(a2, a2.c(), d, 0, a2.d(), null, 1);
            this.a(c5, d.d(), d, false, true);
        }
        this.c.a(d);
    }
    
    public aX a(final q q, final d d) {
        return this.a(q, d, this.d.a(this.d.a(d).i() ? d.c() : d.d()).h());
    }
    
    public aX a(final q q, final d d, final bK bk) {
        final aA aa = new aA(q, d, bk);
        this.g.a(q, aa);
        return aa;
    }
    
    public y.f.c.a.A a(final d d) {
        aE ae = null;
        aE ae2 = null;
        Collection<? extends E> collection = null;
        Collection<?> collection2 = null;
        Object b = null;
        Object b2 = null;
        B b3 = null;
        if (this.o != null) {
            ae = (aE)this.o.b(d);
        }
        if (this.p != null) {
            ae2 = (aE)this.p.b(d);
        }
        if (this.q != null) {
            collection = (Collection<? extends E>)this.q.b(d);
            if (collection != null) {
                collection = (Collection<? extends E>)new ArrayList<Object>(collection);
            }
        }
        if (this.r != null) {
            collection2 = (Collection<?>)this.r.b(d);
            if (collection2 != null) {
                collection2 = new ArrayList<Object>(collection2);
            }
        }
        if (this.s != null) {
            b = this.s.b(d);
        }
        if (this.t != null) {
            b2 = this.t.b(d);
        }
        final c c = this.c.c(y.f.b.f.d);
        if (c != null) {
            if (c.d(d.c())) {
                collection = null;
                b = null;
            }
            if (c.d(d.d())) {
                collection2 = null;
                b2 = null;
            }
        }
        if (this.u != null) {
            final Object b4 = this.u.b(d);
            if (b4 instanceof B) {
                b3 = (B)b4;
            }
        }
        ao ao;
        if (ae != null || ae2 != null || collection != null || collection2 != null) {
            if (b != null || b2 != null) {
                ao = new aK(d, b3, b, b2, ae, collection, ae2, collection2);
            }
            else {
                ao = new ak(d, b3, ae, collection, ae2, collection2, b, b2);
            }
        }
        else if (b != null || b2 != null) {
            ao = new aj(b3, b, b2);
        }
        else {
            ao = new ao(b3);
        }
        this.h.a(d, ao);
        return ao;
    }
    
    public aX c(final q q) {
        aY ay = null;
        if (this.v != null) {
            final Object b = this.v.b(q);
            if (b instanceof aY) {
                ay = (aY)b;
            }
        }
        bK bk = null;
        if (this.w != null) {
            final Object b2 = this.w.b(q);
            if (b2 instanceof bK) {
                bk = (bK)b2;
            }
        }
        Z z = null;
        if (this.x != null) {
            final Object b3 = this.x.b(q);
            if (b3 instanceof Z) {
                z = (Z)b3;
            }
        }
        final ae ae = new ae(ay, bk, z);
        this.g.a(q, ae);
        return ae;
    }
    
    public aX a(final q q, final double n, final double n2, final d[] array) {
        final an an = new an(n, n2, array, null);
        this.g.a(q, an);
        return an;
    }
    
    public aX a(final q q, final q q2, final d d, final bK bk) {
        final af af = new af(q2, d, bk);
        this.g.a(q, af);
        return af;
    }
    
    public aX b(final q q, final q q2, final d d, final bK bk) {
        final aI ai = new aI(q2, d, bk);
        this.g.a(q, ai);
        return ai;
    }
    
    public aX a(final boolean b, final q q, final d d, final q q2, final d d2) {
        as as = null;
        Label_0074: {
            if (b) {
                as = new aq(d, d2, q2, this.d.a(d.d()).h());
                if (!N.x) {
                    break Label_0074;
                }
            }
            as = new y.f.c.a.aE(d, d2, q2, this.d.a(d.c()).h());
        }
        this.g.a(q, as);
        return as;
    }
    
    public q a(final q q, final aQ aq, final byte b) {
        final q d = this.c.d();
        this.c.b(d, 1.0, 1.0);
        bK bk = null;
        switch (b) {
            case 12: {
                bk = this.n.a(q);
                break;
            }
            case 13: {
                bk = this.n.b(q);
                break;
            }
        }
        this.g.a(d, new aC(bk, q, aq, b));
        this.n.f(q).b(d);
        return d;
    }
    
    public q a(final aQ aq, final Object o) {
        final q d = this.c.d();
        this.c.b(d, 0.0, 0.0);
        this.a(d, o, aq.e() == 2);
        aq.a(d);
        return d;
    }
    
    public aX a(final q q, final Object o, final boolean b) {
        aM am = null;
        Label_0034: {
            if (b) {
                am = new aG(q, o, null);
                if (!N.x) {
                    break Label_0034;
                }
            }
            am = new ab(q, o, null);
        }
        this.g.a(q, am);
        return am;
    }
    
    public aX b(final q q, final d d) {
        final aN an = new aN(d, this.d.a(d.c()).h());
        this.g.a(q, an);
        return an;
    }
    
    public d a(final q q, final q q2) {
        final d a = this.c.a(q, q2);
        this.h.a(a, new at());
        return a;
    }
    
    public q a(final q q, final Object o, final aQ aq, final d d) {
        final q a = d.a(q);
        bK h = null;
        if (this.g.b(a) instanceof aX) {
            h = ((aX)this.g.b(a)).h();
        }
        else if (this.w.b(a) instanceof bK) {
            h = (bK)this.w.b(a);
        }
        final bK a2 = this.n.a(q);
        final bK b = this.n.b(q);
        Label_0164: {
            if (a2 == null || b == null) {
                h = null;
            }
            else {
                if (h != null) {
                    if (a2.compareTo(h) > 0) {
                        h = a2;
                    }
                    if (b.compareTo(h) >= 0) {
                        break Label_0164;
                    }
                    h = b;
                    if (!N.x) {
                        break Label_0164;
                    }
                }
                h = a2;
            }
        }
        final q d2 = this.c.d();
        this.c.b(d2, 0.0, 0.0);
        this.g.a(d2, new ar(h, q, aq, d));
        aq.a(d2);
        return d2;
    }
    
    public d a(final q q, final q q2, final d d, final boolean b, final boolean b2) {
        final boolean x = N.x;
        final d a = this.c.a(q, q2);
        final y.f.c.a.A a2 = this.d.a(d);
        aL al = null;
        Label_0118: {
            if (b) {
                al = new av(d, a2);
                this.c.a(a, this.c.n(d));
                if (!x) {
                    break Label_0118;
                }
            }
            if (b2) {
                al = new am(d, a2);
                this.c.b(a, this.c.o(d));
                if (!x) {
                    break Label_0118;
                }
            }
            al = new aL(d, a2);
        }
        this.h.a(a, al);
        return a;
    }
    
    public d b(final q q, final q q2, final d d, final boolean b, final boolean b2) {
        final boolean x = N.x;
        final d a = this.c.a(q, q2);
        final y.f.c.a.A a2 = this.d.a(d);
        aL al = null;
        Label_0128: {
            if (b) {
                al = new aw(d, a2);
                this.c.a(a, this.c.o(d));
                if (!x) {
                    break Label_0128;
                }
            }
            if (b2) {
                al = new aa(d, a2);
                this.c.b(a, this.c.n(d));
                if (!x) {
                    break Label_0128;
                }
            }
            final aL al2 = new aL(d, a2);
            al2.b(true);
            al = al2;
        }
        this.h.a(a, al);
        return a;
    }
    
    public d a(final q q, final q q2, final d d) {
        final d a = this.c.a(q, q2);
        this.h.a(a, new y.f.c.a.ap(((aX)this.g.b(q)).a(), ((aX)this.g.b(q2)).a(), d, (d != null) ? this.d.a(d).k() : null));
        return a;
    }
    
    public void b(final d d) {
        ((as)this.g.b(d.c())).a(d);
        final as as = (as)this.g.b(d.d());
        as.a(d);
        this.f.a(as.j()).a(d);
    }
    
    public d a(final aQ aq, final d d, final q q) {
        final boolean b = d.c() == q;
        final q d2 = this.c.d();
        this.c.b(d2, 0.0, 0.0);
        d d3 = null;
        aL al = null;
        Label_0194: {
            if (b) {
                d3 = this.c.a(q, d2);
                this.c.a(d3, this.c.n(d));
                this.c.a(d, y.d.t.c);
                this.c.a(d, d2, d.d());
                al = new av(d, this.d.a(d));
                if (!N.x) {
                    break Label_0194;
                }
            }
            d3 = this.c.a(d2, q);
            this.c.b(d3, this.c.o(d));
            this.c.b(d, y.d.t.c);
            this.c.a(d, d.c(), d2);
            al = new am(d, this.d.a(d));
        }
        this.h.a(d3, al);
        this.a(b, d2, d, q, d3);
        aq.a(d2);
        return d3;
    }
    
    public d c(d d) {
        final boolean x = N.x;
        final I b = this.c.b((Object)d);
        Label_0327: {
            if (this.d.a(d).b().c() == d.d()) {
                final q d2 = d.d();
                final q c = d.c();
                final I b2 = this.c.b((Object)d2.f());
                final t q = this.c.q(d);
                b.addPoint(q.a, q.b);
                this.c.a(d2.f(), this.c.n(d));
                int i = 0;
                while (true) {
                Label_0236_Outer:
                    while (i < b.pointCount()) {
                        b2.addPoint(0.0, 0.0);
                        ++i;
                        if (x) {
                            while (true) {
                                while (i >= b.pointCount()) {
                                    final t point = b2.getPoint(i - b.pointCount());
                                    b2.setPoint(i, point.a, point.b);
                                    --i;
                                    if (x) {
                                        while (true) {
                                            while (i < b.pointCount()) {
                                                final t point2 = b.getPoint(i);
                                                b2.setPoint(i, point2.a, point2.b);
                                                ++i;
                                                if (!x) {
                                                    if (x) {
                                                        break;
                                                    }
                                                    continue Label_0236_Outer;
                                                }
                                                else {
                                                    if (x) {
                                                        break Label_0327;
                                                    }
                                                    return d;
                                                }
                                            }
                                            this.c.a(d = d2.f(), c, d2.f().d());
                                            this.c.a(d2);
                                            continue;
                                        }
                                    }
                                    if (x) {
                                        break;
                                    }
                                }
                                i = 0;
                                continue;
                            }
                        }
                        if (x) {
                            break;
                        }
                    }
                    i = b2.pointCount() - 1;
                    continue;
                }
            }
        }
        final q c2 = d.c();
        final q d3 = d.d();
        final I b3 = this.c.b((Object)c2.g());
        final t p = this.c.p(d);
        b3.addPoint(p.a, p.b);
        this.c.b(c2.g(), this.c.o(d));
        int j = 0;
        while (true) {
            while (j < b.pointCount()) {
                final t point3 = b.getPoint(j);
                b3.addPoint(point3.a, point3.b);
                ++j;
                if (x) {
                    this.c.a(c2);
                    return d;
                }
                if (x) {
                    break;
                }
            }
            this.c.a(d = c2.g(), c2.g().c(), d3);
            continue;
        }
    }
    
    public q b(final aQ aq, final d d) {
        final boolean x = N.x;
        final q d2 = this.c.d();
        this.c.b(d2, 0.0, 0.0);
        final ArrayList list = new ArrayList<S>();
        final ArrayList list2 = new ArrayList<S>();
        if (this.z != null) {
            final S[] array = (S[])this.z.b(d);
            if (array != null) {
                int i = 0;
                while (i < array.length) {
                    final S s = array[i];
                    Label_0120: {
                        if (s.f().k()) {
                            list2.add(s);
                            if (!x) {
                                break Label_0120;
                            }
                        }
                        list.add(s);
                    }
                    ++i;
                    if (x) {
                        break;
                    }
                }
            }
        }
        final d a = this.c.a(d.c(), d2);
        this.c.a(a, this.c.n(d));
        final av av = new av(d, this.d.a(d));
        if (this.y != null) {
            this.y.a(a, list.toArray(new S[list.size()]));
        }
        this.h.a(a, av);
        final d a2 = this.c.a(d2, d.d());
        this.c.b(a2, this.c.o(d));
        final am am = new am(d, this.d.a(d));
        if (this.y != null) {
            this.y.a(a2, list2.toArray(new S[list2.size()]));
        }
        this.h.a(a2, am);
        this.b(d2, d);
        aq.a(d2);
        this.c.a(d);
        return d2;
    }
    
    public d d(final q q) {
        final boolean x = N.x;
        final d g = this.d.a(q).g();
        if (g.c().e() == null) {
            this.c.b(g.c());
            this.c.a(g.c(), this.c.l(q.g().c()));
        }
        if (g.d().e() == null) {
            this.c.b(g.d());
            this.c.a(g.d(), this.c.l(q.f().d()));
        }
        this.c.b(g);
        final I b = this.c.b((Object)g);
        b.clearPoints();
        final d g2 = q.g();
        this.c.a(g, this.c.n(g2));
        final I b2 = this.c.b((Object)g2);
        int i = 0;
        while (true) {
            while (i < b2.pointCount()) {
                final t point = b2.getPoint(i);
                if (x) {
                    final t t = point;
                    b.addPoint(t.a, t.b);
                    final d f = q.f();
                    final I b3 = this.c.b((Object)f);
                    int j = 0;
                    while (j < b3.pointCount()) {
                        final t point2 = b3.getPoint(j);
                        b.addPoint(point2.a, point2.b);
                        ++j;
                        if (x) {
                            return f;
                        }
                        if (x) {
                            break;
                        }
                    }
                    this.c.b(g, this.c.o(f));
                    this.c.a(q);
                    return f;
                }
                final t t2 = point;
                b.addPoint(t2.a, t2.b);
                ++i;
                if (x) {
                    break;
                }
            }
            this.c.l(q);
            continue;
        }
    }
    
    public y.f.c.a.A a(final d d, final boolean b, final aE ae) {
        final boolean x = N.x;
        y.f.c.a.A a = (y.f.c.a.A)this.h.b(d);
        Label_0261: {
            if (a instanceof ai) {
                a = ((ai)a).a(b, ae);
                if (!x) {
                    break Label_0261;
                }
            }
            System.err.println("warning : unidentified edge type " + a + " for " + d);
            if (a != null) {
                a = new aK(d, a.k(), a.g(), a.h(), a.c(), a.d(), a.e(), a.f());
                if (!x) {
                    break Label_0261;
                }
            }
            if (this.u != null && this.u.b(d) instanceof B) {
                a = new ak(d, (B)this.u.b(d), b ? ae : null, null, b ? null : ae, null);
                if (!x) {
                    break Label_0261;
                }
            }
            a = new ak(d, new B(), b ? ae : null, null, b ? null : ae, null);
        }
        this.h.a(d, a);
        return a;
    }
    
    public y.f.c.a.A a(final d d, final Object o, final Object o2) {
        final y.f.c.a.A a = (y.f.c.a.A)this.h.b(d);
        final aK ak = new aK(d, a.k(), o, o2, a.c(), a.d(), a.e(), a.f());
        this.h.a(d, ak);
        return ak;
    }
    
    public q a(final aQ aq, final Rectangle2D.Double double1, final d[] array) {
        final q d = this.c.d();
        this.c.b(d, double1.width, double1.height);
        this.c.c(d, double1.x, double1.y);
        this.a(d, double1.x, double1.y, array);
        aq.a(d);
        return d;
    }
    
    public void e(final q q) {
        final boolean x = N.x;
        final an an = (an)this.g.b(q);
        final aQ a = this.f.a(an.j());
        final y.f.am a2 = this.c.a((Object)q);
        final double n = a2.getX() - an.c;
        final double n2 = a2.getY() - an.b;
        int i = 0;
    Label_0176_Outer:
        while (i < an.a.length) {
            final I b = this.c.b((Object)an.a[i]);
            if (!x) {
                int j = 0;
                while (true) {
                    while (j < b.pointCount()) {
                        final t point = b.getPoint(j);
                        b.setPoint(j, point.a + n, point.b + n2);
                        ++j;
                        if (!x) {
                            if (x) {
                                break;
                            }
                            continue Label_0176_Outer;
                        }
                        else {
                            if (x) {
                                break Label_0176_Outer;
                            }
                            continue Label_0176_Outer;
                        }
                    }
                    ++i;
                    continue;
                }
            }
            return;
        }
        a.b(q);
        this.c.a(q);
    }
    
    public void d(final d d) {
        this.h.a(d, new ag((ai)this.h.b(d)));
    }
}
