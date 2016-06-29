package y.f.b;

import java.awt.geom.*;
import y.g.*;
import java.util.*;
import y.c.*;
import y.d.*;
import y.f.*;

public class j extends a
{
    public static final Object a;
    public static final ah b;
    private X c;
    private A d;
    private h e;
    private A f;
    private boolean g;
    private c h;
    private boolean i;
    private boolean n;
    private y.f.b.a o;
    private c p;
    private c q;
    private c r;
    private A s;
    private Map t;
    private Map u;
    private Map v;
    private Map w;
    private c x;
    private c y;
    private c z;
    private c A;
    private h B;
    private h C;
    private h D;
    private h E;
    private A F;
    private A G;
    private A H;
    
    public j() {
        this(null, new y.f.b.h());
    }
    
    public j(final ah ah) {
        this(ah, new y.f.b.h());
    }
    
    public j(final ah ah, final y.f.b.a o) {
        this.g = false;
        this.i = false;
        this.n = true;
        this.a(ah);
        this.o = o;
    }
    
    public boolean b() {
        return this.n;
    }
    
    public void a(final boolean n) {
        this.n = n;
    }
    
    private boolean a(final q q) {
        return this.h == null || this.h.b(q) != null;
    }
    
    private void a(final q q, final y.f.b.c c) {
        final int a = c.a;
        final y y = new y(c.b(q));
        while (!y.isEmpty()) {
            final q d = y.d();
            if (this.b(d, c) && !this.a(d)) {
                y.addAll(c.b(d));
            }
            final t t = (t)this.s.b(d);
            if (t != null) {
                this.c.a(d, t);
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
    }
    
    private boolean b(final q q, final y.f.b.c c) {
        return c.d(q) && (this.b() || c.e(q));
    }
    
    private void a(final q q, final Object o, final A a, final y.f.b.c c) {
        final int a2 = c.a;
        final x a3 = c.b(q).a();
        while (a3.f()) {
            final q e = a3.e();
            a.a(e, o);
            Label_0094: {
                if (this.b(e, c)) {
                    if (this.a(e)) {
                        this.a(e, e, a, c);
                        if (a2 == 0) {
                            break Label_0094;
                        }
                    }
                    this.a(e, o, a, c);
                }
            }
            a3.g();
            if (a2 != 0) {
                break;
            }
        }
    }
    
    private ah b(final q q) {
        if (this.h == null || q == null) {
            return this.a();
        }
        return (ah)this.h.b(q);
    }
    
    private void c() {
        final int a = y.f.b.c.a;
        this.B = this.c.u();
        this.C = this.c.u();
        this.D = this.c.u();
        this.E = this.c.u();
        final e p = this.c.p();
        while (true) {
            while (p.f()) {
                final d a2 = p.a();
                Collection a3 = y.f.b.p.a(this.c, a2, y.f.b.p.a(this.c, a2, true), true);
                Collection a4 = y.f.b.p.a(this.c, a2, y.f.b.p.a(this.c, a2, false), false);
                if (a != 0) {
                    if (this.x != null) {
                        this.c.d_(aF.a);
                    }
                    if (this.y != null) {
                        this.c.d_(aF.b);
                    }
                    return;
                }
                if (a2.e()) {
                    if (a3 == null || a3.isEmpty()) {
                        a3 = new ArrayList(1);
                    }
                    if (a4 == null || a4.isEmpty()) {
                        a4 = new ArrayList(1);
                    }
                    y.f.b.p.a(this.c, a2, a3, a4);
                }
                this.D.a(a2, a3);
                this.E.a(a2, a4);
                if (a3 != null) {
                    this.B.a(a2, new D(a3));
                }
                if (a4 != null) {
                    this.C.a(a2, new D(a4));
                }
                p.g();
                if (a != 0) {
                    break;
                }
            }
            this.c.a(ax.a, this.D);
            this.c.a(ax.b, this.E);
            continue;
        }
    }
    
    private void d() {
        final int a = y.f.b.c.a;
        Label_0039: {
            if (this.z != null) {
                this.c.a(ax.a, this.z);
                if (a == 0) {
                    break Label_0039;
                }
            }
            this.c.d_(ax.a);
        }
        this.c.a(this.D);
        Label_0085: {
            if (this.A != null) {
                this.c.a(ax.b, this.A);
                if (a == 0) {
                    break Label_0085;
                }
            }
            this.c.d_(ax.b);
        }
        this.c.a(this.E);
        if (this.x != null) {
            this.c.a(aF.a, this.x);
        }
        if (this.y != null) {
            this.c.a(aF.b, this.y);
        }
        this.c.a(this.B);
        this.c.a(this.C);
    }
    
    public void c(final X c) {
        final int a = c.a;
        this.c = c;
        Label_0796: {
            if (c.b(c)) {
                this.h = c.c(j.a);
                if (this.h != null) {
                    c.d_(j.a);
                }
                this.f = c.t();
                final x o = c.o();
                while (o.f()) {
                    this.f.a(o.e(), new m());
                    o.g();
                    if (a != 0) {
                        return;
                    }
                    if (a != 0) {
                        break;
                    }
                }
                final y.f.b.c c2 = new y.f.b.c(c);
                this.k();
                this.d = c.t();
                final A t = c.t();
                this.a(c2.b(), new Object(), t, c2);
                final l l = new l(this, c, c2);
                this.s = c.t();
                if (this.i) {
                    this.e();
                }
                this.f();
                this.i();
                this.c();
                this.F = c.t();
                this.G = c.t();
                final x o2 = c.o();
                while (true) {
                Label_0580_Outer:
                    while (o2.f()) {
                        final q e = o2.e();
                        this.F.a(e, e.a());
                        this.G.a(e, new n());
                        o2.g();
                        if (a != 0) {
                            final c c3 = c.c(ay.a);
                            if (c3 == null) {
                                c.a(ay.a, this.H);
                            }
                            this.e = c.u();
                            y.c.p p = c2.c(c2.b()).l();
                            while (true) {
                                while (p != null) {
                                    final q q = (q)p.c();
                                    final ah b = this;
                                    if (a == 0) {
                                        if (this.b(q, c2) && this.a(q)) {
                                            final ah b2 = this.b(q);
                                            l.a(q);
                                            if (b2 != null) {
                                                this.b(c2);
                                                if (this.i) {
                                                    this.a(q, c2);
                                                }
                                                this.a(c2);
                                                b2.c(c);
                                                this.g();
                                            }
                                            Label_0513: {
                                                if (this.o != null) {
                                                    final Rectangle2D a2 = this.o.a(c, q, c2.b(q));
                                                    c.d(q);
                                                    c.b(q, a2.getWidth(), a2.getHeight());
                                                    c.c(q, a2.getX(), a2.getY());
                                                    if (a == 0) {
                                                        break Label_0513;
                                                    }
                                                }
                                                c.d(q);
                                            }
                                            if (b2 != null) {
                                                final am a3 = c.a((Object)q);
                                                this.d.a(q, new Point2D.Double(a3.getX(), a3.getY()));
                                                this.c(c2);
                                            }
                                        }
                                        p = p.b();
                                        if (a != 0) {
                                            break;
                                        }
                                        continue Label_0580_Outer;
                                    }
                                    else {
                                        final ah ah = b;
                                        l.a(c2.b());
                                        if (ah != null) {
                                            this.b(c2);
                                            if (this.i) {
                                                this.a(c2.b(), c2);
                                            }
                                            this.a(c2);
                                            ah.c(c);
                                            this.g();
                                            this.c(c2);
                                        }
                                        l.a();
                                        if (ah != null) {
                                            this.a(c2, c2.b(), 0.0, 0.0);
                                        }
                                        c.a(this.e);
                                        this.e = null;
                                        this.d();
                                        this.j();
                                        this.h();
                                        this.a(c, this.a(t));
                                        if (c3 == null) {
                                            c.d_(ay.a);
                                        }
                                        if (this.h != null) {
                                            c.a(j.a, this.h);
                                        }
                                        c.a(this.s);
                                        c.a(this.F);
                                        c.a(this.G);
                                        c.a(this.H);
                                        c.a(t);
                                        c.a(this.f);
                                        c.a(this.d);
                                        this.d = null;
                                        c2.c();
                                        if (a != 0) {
                                            break Label_0796;
                                        }
                                        return;
                                    }
                                }
                                final ah b = this.b((q)null);
                                continue;
                            }
                        }
                        if (a != 0) {
                            break;
                        }
                    }
                    this.H = c.t();
                    continue;
                }
            }
        }
        final ah a4 = this.a();
        if (a4 != null) {
            a4.c(c);
        }
    }
    
    private f a(final c c) {
        final int a = c.a;
        final f f = new f();
        final e p = this.c.p();
        while (p.f()) {
            final d a2 = p.a();
            if (c.b(a2.c()) != c.b(a2.d())) {
                f.add(a2);
            }
            p.g();
            if (a != 0) {
                break;
            }
        }
        return f;
    }
    
    protected void a(final X x, final f f) {
        final int a = y.f.b.c.a;
        final e a2 = f.a();
        while (a2.f()) {
            final d a3 = a2.a();
            final am a4 = x.a((Object)a3.c());
            final am a5 = x.a((Object)a3.d());
            if (!a(a4, x.p(a3)) || !a(a5, x.q(a3))) {
                ae.a(x, a3);
            }
            a2.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private static boolean a(final am am, final t t) {
        return am.getX() - 0.1 < t.a && am.getX() + am.getWidth() + 0.1 > t.a && am.getY() - 0.1 < t.b && am.getY() + am.getHeight() + 0.1 > t.b;
    }
    
    private void a(final y.f.b.c c, final q q, final double n, final double n2) {
        final int a = c.a;
        y.c.p p4 = c.b(q).k();
        while (p4 != null) {
            final q q2 = (q)p4.c();
            final am a2 = this.c.a((Object)q2);
            a2.setLocation(a2.getX() + n, a2.getY() + n2);
            e e = q2.j();
            Label_0522: {
            Label_0441:
                while (true) {
                    e.f();
                Label_0326_Outer:
                    while (true) {
                        final boolean d2;
                        Label_0186: {
                            final boolean d;
                            if (d) {
                                final d a3 = e.a();
                                d2 = this.e.d(a3);
                                if (a != 0) {
                                    break Label_0186;
                                }
                                if (!d2) {
                                    final q a4 = a3.a(q2);
                                    if (c.a(a4) == q || c.a(a4, c.a(q2)) != null) {
                                        this.a(a3, n, n2);
                                        this.e.a(a3, true);
                                    }
                                }
                                e.g();
                                if (a == 0) {
                                    break;
                                }
                            }
                            this.b(q2, c);
                        }
                        if (d2) {
                            e = c.f(q2).a();
                            while (true) {
                                while (e.f()) {
                                    final d a5 = e.a();
                                    final boolean d3 = this.e.d(a5);
                                    if (a == 0) {
                                        if (!d3) {
                                            final q c2 = a5.c();
                                            final q d4 = a5.d();
                                            if (c.a(c2, c.a(d4)) == null && c.a(d4, c.a(c2)) == null) {
                                                this.a(a5, n, n2);
                                                this.e.a(a5, true);
                                            }
                                        }
                                        e.g();
                                        if (a != 0) {
                                            break;
                                        }
                                        continue Label_0326_Outer;
                                    }
                                    else {
                                        while (true) {
                                            if (!d3) {
                                                break Label_0441;
                                            }
                                            final d a6 = e.a();
                                            final boolean d = this.e.d(a6);
                                            if (a != 0) {
                                                continue Label_0326_Outer;
                                            }
                                            if (!d) {
                                                final q c3 = a6.c();
                                                final q d5 = a6.d();
                                                if (c.a(c3, c.a(d5)) == null && c.a(d5, c.a(c3)) == null) {
                                                    this.a(a6, n, n2);
                                                    this.e.a(a6, true);
                                                }
                                            }
                                            e.g();
                                            if (a != 0) {
                                                break Label_0441;
                                            }
                                            e.f();
                                            continue Label_0326_Outer;
                                        }
                                    }
                                }
                                e = c.g(q2).a();
                                continue;
                            }
                        }
                        break Label_0522;
                    }
                }
                final Point2D.Double double1 = (Point2D.Double)this.d.b(q2);
                Label_0510: {
                    if (double1 == null) {
                        this.a(c, q2, n, n2);
                        if (a == 0) {
                            break Label_0510;
                        }
                    }
                    this.a(c, q2, a2.getX() - double1.x, a2.getY() - double1.y);
                }
                this.d.a(q2, null);
            }
            p4 = p4.a();
            if (a != 0) {
                break;
            }
        }
    }
    
    private void a(final d d, final double n, final double n2) {
        final int a = y.f.b.c.a;
        final I b = this.c.b((Object)d);
        int i = 0;
        while (i < b.pointCount()) {
            final t point = b.getPoint(i);
            b.setPoint(i, point.a + n, point.b + n2);
            ++i;
            if (a != 0) {
                break;
            }
        }
    }
    
    public void a(final y.f.b.a o) {
        this.o = o;
    }
    
    private void e() {
        final int a = y.f.b.c.a;
        final x o = this.c.o();
        while (o.f()) {
            final q e = o.e();
            this.s.a(e, this.c.l(e));
            o.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private void f() {
        this.r = this.c.c(y.f.b.f.d);
        this.p = this.c.c(y.f.b.f.b);
        this.q = this.c.c(y.f.b.f.c);
        this.c.d_(y.f.b.f.d);
        this.c.d_(y.f.b.f.b);
        this.c.d_(y.f.b.f.c);
    }
    
    private void g() {
        if (this.c.c(y.f.b.f.d) != null) {
            this.c.d_(y.f.b.f.d);
            this.c.d_(y.f.b.f.b);
            this.c.d_(y.f.b.f.c);
        }
    }
    
    private void a(final y.f.b.c c) {
        final int a = c.a;
        final A a2 = M.a();
        final A a3 = M.a();
        final x o = this.c.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final boolean b = this.b(e, c);
                if (a != 0) {
                    if (b) {
                        this.c.a(y.f.b.f.d, a2);
                        this.c.a(y.f.b.f.c, a3);
                        this.c.a(y.f.b.f.b, new k(this));
                    }
                    return;
                }
                Label_0153: {
                    if (b && !this.a(e)) {
                        a2.a(e, true);
                        final x a4 = c.b(e).a();
                        while (a4.f()) {
                            a3.a(a4.e(), this.p.b(e));
                            a4.g();
                            if (a != 0) {
                                break Label_0153;
                            }
                            if (a != 0) {
                                break;
                            }
                        }
                    }
                    o.g();
                }
                if (a != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    private void h() {
        this.c.a(y.f.b.f.d, this.r);
        this.c.a(y.f.b.f.b, this.p);
        this.c.a(y.f.b.f.c, this.q);
    }
    
    private void i() {
        final int a = y.f.b.c.a;
        final e p = this.c.p();
        while (p.f()) {
            final d a2 = p.a();
            if (this.x != null && this.a(a2, this.x)) {
                this.v.put(a2, this.c.n(a2));
            }
            if (this.y != null && this.a(a2, this.y)) {
                this.w.put(a2, this.c.o(a2));
            }
            p.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private void j() {
        final int a = y.f.b.c.a;
        final e p = this.c.p();
        while (p.f()) {
            final d a2 = p.a();
            final t t = this.v.get(a2);
            if (t != null && this.c.n(a2).compareTo(t) != 0) {
                this.c.a(a2, t);
            }
            final t t2 = this.w.get(a2);
            if (t2 != null && this.c.o(a2).compareTo(t2) != 0) {
                this.c.b(a2, t2);
            }
            p.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private void k() {
        this.t = new HashMap();
        this.u = new HashMap();
        this.v = new HashMap();
        this.w = new HashMap();
        this.x = this.c.c(aF.a);
        this.y = this.c.c(aF.b);
        this.z = this.c.c(ax.a);
        this.A = this.c.c(ax.b);
    }
    
    private D a(final ax ax, final t t, final d d, final boolean b) {
        final D d2 = new D();
        if (ax.b()) {
            d2.add(ax.a(ax.c() + t.a, ax.d() + t.b, ax.a(), ax.f()));
            if (y.f.b.c.a == 0) {
                return d2;
            }
        }
        final m m = (m)this.f.b(b ? d.c() : d.d());
        if (ax.a(1)) {
            d2.addAll(this.a(d, b, t, ax.f(), m.a));
        }
        if (ax.a(2)) {
            d2.addAll(this.b(d, b, t, ax.f(), m.b));
        }
        if (ax.a(8)) {
            d2.addAll(this.c(d, b, t, ax.f(), m.c));
        }
        if (ax.a(4)) {
            d2.addAll(this.d(d, b, t, ax.f(), m.d));
        }
        return d2;
    }
    
    private D a(final q q, final d d, final t t) {
        final int a = y.f.b.c.a;
        if (d.d() == q) {
            final D d2 = (D)this.C.b(d);
            if (d2 != null && !d2.isEmpty()) {
                final D d3 = new D();
                final C m = d2.m();
                D d4 = null;
                while (m.f()) {
                    final ax ax = (ax)m.d();
                    d4 = d3;
                    if (a != 0) {
                        return d4;
                    }
                    d4.a(this.a(ax, t, d, false));
                    m.g();
                    if (a != 0) {
                        break;
                    }
                }
                return d4;
            }
            if (this.g) {
                return this.a(d, false, t, 1.0);
            }
            return null;
        }
        else {
            if (d.c() != q) {
                return null;
            }
            final D d5 = (D)this.B.b(d);
            if (d5 != null && !d5.isEmpty()) {
                final D d6 = new D();
                final C i = d5.m();
                D d7 = null;
                while (i.f()) {
                    final ax ax2 = (ax)i.d();
                    d7 = d6;
                    if (a != 0) {
                        return d7;
                    }
                    d7.a(this.a(ax2, t, d, true));
                    i.g();
                    if (a != 0) {
                        break;
                    }
                }
                return d7;
            }
            if (this.g) {
                return this.a(d, true, t, 1.0);
            }
            return null;
        }
    }
    
    private static t a(final t t, final t t2) {
        return new t(t.a() - t2.a(), t.b() - t2.b());
    }
    
    private void a(final y.d.y y, final v v, final m m) {
        final int a = y.f.b.c.a;
        int n = 0;
        y.d.m i = v.a(n);
        while (n < v.h() - 1 && y.a(i.c()) && y.a(i.d())) {
            i = v.a(++n);
            if (a != 0) {
                break;
            }
        }
        if (i == null) {
            return;
        }
        final t c = i.c();
        final t e = y.e();
        final t t = new t(e.a() + y.a() * 0.5, e.b() + y.b() * 0.5);
        if (y.a(c)) {
            final t a2 = y.d.m.a(i, new y.d.m(e, new t(e.a + y.a(), e.b)));
            if (a2 != null) {
                m.a.add(a(a2, t));
                return;
            }
            final t a3 = y.d.m.a(i, new y.d.m(new t(e.a, e.b + y.b()), new t(e.a + y.a(), e.b + y.b())));
            if (a3 != null) {
                m.b.add(a(a3, t));
                return;
            }
            final t a4 = y.d.m.a(i, new y.d.m(new t(e.a, e.b), new t(e.a, e.b + y.b())));
            if (a4 != null) {
                m.c.add(a(a4, t));
                return;
            }
            final t a5 = y.d.m.a(i, new y.d.m(new t(e.a + y.a(), e.b), new t(e.a + y.a(), e.b + y.b())));
            if (a5 != null) {
                m.d.add(a(a5, t));
                return;
            }
        }
        if (c.b() <= e.b()) {
            m.a.add(a(c, t));
            if (a == 0) {
                return;
            }
        }
        if (c.b() >= e.b() + y.b()) {
            m.b.add(a(c, t));
            if (a == 0) {
                return;
            }
        }
        if (c.a() <= e.a()) {
            m.c.add(a(c, t));
            if (a == 0) {
                return;
            }
        }
        if (c.a() >= e.a() + y.a()) {
            m.d.add(a(c, t));
        }
    }
    
    private void a(final d d, final boolean b, v g) {
        final q q = b ? d.c() : d.d();
        final m m = (m)this.f.b(q);
        final y.d.y s = this.c.s(q);
        if (!b) {
            g = g.g();
        }
        this.a(s, g, m);
    }
    
    private boolean a(final double n, final double n2) {
        return n + 2.0 > n2 && n - 2.0 < n2;
    }
    
    private D a(final d d, final boolean b, final t t, final double n, final D d2) {
        final int i = y.f.b.c.a;
        final n n2 = (n)(b ? this.G.b(d.c()) : this.G.b(d.d()));
        final D a = new D();
        int n3 = 0;
        Label_0127: {
            if (b) {
                final int a2 = this.F.a(d.c());
                n3 = ((a2 % 2 == 0) ? (a2 + 1) : a2);
                if (i == 0) {
                    break Label_0127;
                }
            }
            final int a3 = this.F.a(d.d());
            n3 = ((a3 % 2 == 0) ? (a3 + 1) : a3);
        }
        final y.d.q q = b ? this.c.r(d.c()) : this.c.r(d.d());
        final C m = d2.m();
        double n4 = m.f() ? ((t)m.d()).a() : Double.MAX_VALUE;
        final double n5 = q.b() / 2.0;
        final double n6 = q.a() / 2.0;
        final double n7 = q.a() / (n3 + 1);
        final int n8 = (n3 - 1) / 2;
        int n9 = 0;
        do {
            int j = 0;
        Label_0244:
            while (j < n3) {
                final double n10 = -n6 + n7 * (n9 + 1);
                while (n10 > n4 + 2.0) {
                    m.g();
                    j = (m.f() ? 1 : 0);
                    if (i != 0) {
                        continue Label_0244;
                    }
                    n4 = ((j != 0) ? ((t)m.d()).a() : Double.MAX_VALUE);
                    if (i != 0) {
                        break;
                    }
                }
                double n11 = n;
                if (n9 != n8) {
                    ++n11;
                }
                if (this.a(n10, n4)) {
                    n11 += 10.0;
                }
                a.add(ax.a(n10 + t.a, -n5 + t.b, 1, n11));
                ++n9;
            }
            break;
        } while (i == 0);
        if (n2 != null) {
            n2.a = a;
        }
        return a;
    }
    
    private D b(final d d, final boolean b, final t t, final double n, final D d2) {
        final int i = y.f.b.c.a;
        final n n2 = (n)(b ? this.G.b(d.c()) : this.G.b(d.d()));
        final D b2 = new D();
        int n3 = 0;
        Label_0127: {
            if (b) {
                final int a = this.F.a(d.c());
                n3 = ((a % 2 == 0) ? (a + 1) : a);
                if (i == 0) {
                    break Label_0127;
                }
            }
            final int a2 = this.F.a(d.d());
            n3 = ((a2 % 2 == 0) ? (a2 + 1) : a2);
        }
        final y.d.q q = b ? this.c.r(d.c()) : this.c.r(d.d());
        final C m = d2.m();
        double n4 = m.f() ? ((t)m.d()).a() : Double.MAX_VALUE;
        final double n5 = q.b() / 2.0;
        final double n6 = q.a() / 2.0;
        final double n7 = q.a() / (n3 + 1);
        final int n8 = (n3 - 1) / 2;
        int n9 = 0;
        do {
            int j = 0;
        Label_0244:
            while (j < n3) {
                final double n10 = -n6 + n7 * (n9 + 1);
                while (n10 > n4 + 2.0) {
                    m.g();
                    j = (m.f() ? 1 : 0);
                    if (i != 0) {
                        continue Label_0244;
                    }
                    n4 = ((j != 0) ? ((t)m.d()).a() : Double.MAX_VALUE);
                    if (i != 0) {
                        break;
                    }
                }
                double n11 = n;
                if (n9 != n8) {
                    ++n11;
                }
                if (this.a(n10, n4)) {
                    n11 += 10.0;
                }
                b2.add(ax.a(n10 + t.a, n5 + t.b, 2, n11));
                ++n9;
            }
            break;
        } while (i == 0);
        if (n2 != null) {
            n2.b = b2;
        }
        return b2;
    }
    
    private D c(final d d, final boolean b, final t t, final double n, final D d2) {
        final int i = y.f.b.c.a;
        final n n2 = (n)(b ? this.G.b(d.c()) : this.G.b(d.d()));
        final D c = new D();
        int n3 = 0;
        Label_0127: {
            if (b) {
                final int a = this.F.a(d.c());
                n3 = ((a % 2 == 0) ? (a + 1) : a);
                if (i == 0) {
                    break Label_0127;
                }
            }
            final int a2 = this.F.a(d.d());
            n3 = ((a2 % 2 == 0) ? (a2 + 1) : a2);
        }
        final y.d.q q = b ? this.c.r(d.c()) : this.c.r(d.d());
        final C m = d2.m();
        double n4 = m.f() ? ((t)m.d()).b() : Double.MAX_VALUE;
        final double n5 = q.b() / 2.0;
        final double n6 = q.a() / 2.0;
        final double n7 = q.b() / (n3 + 1);
        final int n8 = (n3 - 1) / 2;
        int n9 = 0;
        do {
            int j = 0;
        Label_0244:
            while (j < n3) {
                final double n10 = -n5 + n7 * (n9 + 1);
                while (n10 > n4 + 2.0) {
                    m.g();
                    j = (m.f() ? 1 : 0);
                    if (i != 0) {
                        continue Label_0244;
                    }
                    n4 = ((j != 0) ? ((t)m.d()).b() : Double.MAX_VALUE);
                    if (i != 0) {
                        break;
                    }
                }
                double n11 = n;
                if (n9 != n8) {
                    ++n11;
                }
                if (this.a(n10, n4)) {
                    n11 += 10.0;
                }
                c.add(ax.a(-n6 + t.a, n10 + t.b, 8, n11));
                ++n9;
            }
            break;
        } while (i == 0);
        if (n2 != null) {
            n2.c = c;
        }
        return c;
    }
    
    private D d(final d d, final boolean b, final t t, final double n, final D d2) {
        final int i = y.f.b.c.a;
        final n n2 = (n)(b ? this.G.b(d.c()) : this.G.b(d.d()));
        final D d3 = new D();
        int n3 = 0;
        Label_0127: {
            if (b) {
                final int a = this.F.a(d.c());
                n3 = ((a % 2 == 0) ? (a + 1) : a);
                if (i == 0) {
                    break Label_0127;
                }
            }
            final int a2 = this.F.a(d.d());
            n3 = ((a2 % 2 == 0) ? (a2 + 1) : a2);
        }
        final y.d.q q = b ? this.c.r(d.c()) : this.c.r(d.d());
        final C m = d2.m();
        double n4 = m.f() ? ((t)m.d()).b() : Double.MAX_VALUE;
        final double n5 = q.b() / 2.0;
        final double n6 = q.a() / 2.0;
        final double n7 = q.b() / (n3 + 1);
        final int n8 = (n3 - 1) / 2;
        int n9 = 0;
        do {
            int j = 0;
        Label_0244:
            while (j < n3) {
                final double n10 = -n5 + n7 * (n9 + 1);
                while (n10 > n4 + 2.0) {
                    m.g();
                    j = (m.f() ? 1 : 0);
                    if (i != 0) {
                        continue Label_0244;
                    }
                    n4 = ((j != 0) ? ((t)m.d()).b() : Double.MAX_VALUE);
                    if (i != 0) {
                        break;
                    }
                }
                double n11 = n;
                if (n9 != n8) {
                    ++n11;
                }
                if (this.a(n10, n4)) {
                    n11 += 10.0;
                }
                d3.add(ax.a(n6 + t.a, n10 + t.b, 4, n11));
                ++n9;
            }
            break;
        } while (i == 0);
        if (n2 != null) {
            return n2.d = d3;
        }
        return d3;
    }
    
    private D a(final d d, final boolean b, final t t, final double n) {
        final m m = (m)this.f.b(b ? d.c() : d.d());
        this.a(d, b, t, n, m.a);
        this.b(d, b, t, n, m.b);
        this.c(d, b, t, n, m.c);
        this.d(d, b, t, n, m.d);
        final n n2 = (n)(b ? this.G.b(d.c()) : this.G.b(d.d()));
        if (n2 != null) {
            return n2.a();
        }
        return null;
    }
    
    private ay a(final q q, final int n) {
        final int a = y.f.b.c.a;
        final ay ay = new ay();
        if (n == 0) {
            return ay;
        }
        final y.d.q r = this.c.r(q);
        final int n2 = (n % 2 == 0) ? (n + 1) : n;
        final double n3 = r.b() / 2.0;
        final double n4 = r.a() / 2.0;
        double n5 = r.a() / (n2 + 1);
        int i = 0;
        while (true) {
            while (i < n2) {
                final double n6 = -n4 + n5 * (i + 1);
                ay.a(ax.a(n6, -n3, 1));
                ay.a(ax.a(n6, n3, 2));
                ++i;
                if (a != 0) {
                    int j = 0;
                    ay ay2 = null;
                    while (j < n2) {
                        final double n7 = -n3 + n5 * (j + 1);
                        ay.a(ax.a(-n4, n7, 8));
                        ay2 = ay;
                        if (a != 0) {
                            return ay2;
                        }
                        ay2.a(ax.a(n4, n7, 4));
                        ++j;
                        if (a != 0) {
                            break;
                        }
                    }
                    return ay2;
                }
                if (a != 0) {
                    break;
                }
            }
            n5 = r.b() / (n2 + 1);
            continue;
        }
    }
    
    private void b(final y.f.b.c c) {
        final int a = c.a;
        final x o = this.c.o();
        while (o.f()) {
            final q e = o.e();
            final D d = new D();
            Label_1056: {
                if (this.b(e, c) && this.a(e)) {
                    final t l = this.c.l(e);
                    int n = 0;
                    e e2 = c.f(e).a();
                    d d2 = null;
                    q q2;
                    q q = null;
                    q q4;
                    q q3 = null;
                    t i;
                    t t;
                    t q5;
                    t a2;
                    D a3;
                    q a4;
                    t q6;
                    t a5;
                    D a6;
                    t j;
                    t t2;
                    t p;
                    t a7;
                    D a8;
                    q a9;
                    t p2;
                    t a10;
                    D a11;
                    Label_0103_Outer:Label_0530_Outer:
                    while (true) {
                        while (true) {
                        Label_0560:
                            while (true) {
                                Label_0520: {
                                    if (!e2.f()) {
                                        break Label_0520;
                                    }
                                    d2 = e2.a();
                                    q = (q2 = d2.d());
                                    q3 = (q4 = e);
                                    if (a != 0) {
                                        break Label_0560;
                                    }
                                    Label_0508: {
                                        if (q2 != q4) {
                                            i = this.c.l(d2.d());
                                            t = new t(i.a - l.a, i.b - l.b);
                                            if (d2.c().e() != null) {
                                                this.u.put(d2, d2.d());
                                                q5 = this.c.q(d2);
                                                a2 = this.a(c, d2.d(), e);
                                                a3 = this.a(d2.d(), d2, y.d.t.b(a2, t));
                                                Label_0262: {
                                                    if (a3 != null) {
                                                        this.E.a(d2, a3);
                                                        d.addAll(a3);
                                                        if (a == 0) {
                                                            break Label_0262;
                                                        }
                                                    }
                                                    ++n;
                                                }
                                                this.a(d2, d2.c(), e);
                                                this.c.d(d2, new t(q5.a + a2.a, q5.b + a2.b));
                                                if (d2.a() != null) {
                                                    break Label_0508;
                                                }
                                                this.c.e(d2);
                                                if (a == 0) {
                                                    break Label_0508;
                                                }
                                            }
                                            a4 = c.a(d2.c(), c.a(e));
                                            if (a4 != null && a4.e() != null) {
                                                this.u.put(d2, d2.d());
                                                q6 = this.c.q(d2);
                                                a5 = this.a(c, d2.d(), e);
                                                a6 = this.a(d2.d(), d2, y.d.t.b(a5, t));
                                                Label_0458: {
                                                    if (a6 != null) {
                                                        this.E.a(d2, a6);
                                                        d.addAll(a6);
                                                        if (a == 0) {
                                                            break Label_0458;
                                                        }
                                                    }
                                                    ++n;
                                                }
                                                this.a(d2, d2.c(), e);
                                                this.c.d(d2, new t(q6.a + a5.a, q6.b + a5.b));
                                            }
                                        }
                                    }
                                    e2.g();
                                    if (a == 0) {
                                        continue Label_0103_Outer;
                                    }
                                }
                                e2 = c.g(e).a();
                                if (!e2.f()) {
                                    break;
                                }
                                d2 = e2.a();
                                q = (q2 = d2.c());
                                q3 = (q4 = e);
                                if (a != 0) {
                                    continue Label_0530_Outer;
                                }
                                break;
                            }
                            Label_0960: {
                                if (q != q3) {
                                    j = this.c.l(d2.c());
                                    t2 = new t(j.a - l.a, j.b - l.b);
                                    if (d2.d().e() != null) {
                                        this.t.put(d2, d2.c());
                                        p = this.c.p(d2);
                                        a7 = this.a(c, d2.c(), e);
                                        a8 = this.a(d2.c(), d2, y.d.t.b(a7, t2));
                                        Label_0714: {
                                            if (a8 != null) {
                                                this.D.a(d2, a8);
                                                d.addAll(a8);
                                                if (a == 0) {
                                                    break Label_0714;
                                                }
                                            }
                                            ++n;
                                        }
                                        this.a(d2, e, d2.d());
                                        this.c.c(d2, new t(p.a + a7.a, p.b + a7.b));
                                        if (d2.a() != null) {
                                            break Label_0960;
                                        }
                                        this.c.e(d2);
                                        if (a == 0) {
                                            break Label_0960;
                                        }
                                    }
                                    a9 = c.a(d2.d(), c.a(e));
                                    if (a9 != null && a9.e() != null) {
                                        this.t.put(d2, d2.c());
                                        p2 = this.c.p(d2);
                                        a10 = this.a(c, d2.c(), e);
                                        a11 = this.a(d2.c(), d2, y.d.t.b(a10, t2));
                                        Label_0910: {
                                            if (a11 != null) {
                                                this.D.a(d2, a11);
                                                d.addAll(a11);
                                                if (a == 0) {
                                                    break Label_0910;
                                                }
                                            }
                                            ++n;
                                        }
                                        this.a(d2, e, d2.d());
                                        this.c.c(d2, new t(p2.a + a10.a, p2.b + a10.b));
                                    }
                                }
                            }
                            e2.g();
                            if (a != 0) {
                                break;
                            }
                            continue;
                        }
                    }
                    if (!d.isEmpty()) {
                        final ay a12 = this.a(e, n);
                        final C m = d.m();
                        while (m.f()) {
                            a12.a((ax)m.d());
                            m.g();
                            if (a != 0) {
                                break Label_1056;
                            }
                            if (a != 0) {
                                break;
                            }
                        }
                        this.H.a(e, a12);
                    }
                }
                o.g();
            }
            if (a != 0) {
                break;
            }
        }
    }
    
    private void a(final d d, final q q, final q q2) {
        boolean b = false;
        final q c = d.c();
        if (c.e() == null) {
            this.c.d(c);
            b = true;
        }
        boolean b2 = false;
        final q d2 = d.d();
        if (d2.e() == null) {
            this.c.d(d2);
            b2 = true;
        }
        boolean b3 = false;
        if (d.a() == null) {
            this.c.e(d);
            b3 = true;
        }
        this.c.a(d, q, q2);
        if (b3) {
            this.c.d(d);
        }
        if (b) {
            this.c.c(c);
        }
        if (b2) {
            this.c.c(d2);
        }
    }
    
    private static v a(final v v, t t) {
        final int a = y.f.b.c.a;
        if (t == null) {
            t = new t(0.0, 0.0);
        }
        final t[] array = new t[v.h()];
        int n = 0;
        final u b = v.b();
        while (b.f()) {
            final t a2 = b.a();
            array[n++] = new t(a2.a - t.a, a2.b - t.b);
            b.g();
            if (a != 0) {
                break;
            }
        }
        return new v(array);
    }
    
    private void c(final y.f.b.c c) {
        final int a = c.a;
        final f f = new f(this.c.p());
        e e = f.a();
        while (true) {
            while (e.f()) {
                d d = e.a();
                final q q2;
                q q = q2 = this.t.get(d);
                if (a != 0) {
                    while (true) {
                        Label_0416: {
                            if (q2 != null) {
                                final t q3 = this.c.q(d);
                                final t a2 = this.a(c, q, c.a(d.d()));
                                final v a3 = a(this.c.l(d), a2);
                                this.a(d, d.c(), q);
                                this.c.d(d, new t(q3.a - a2.a, q3.b - a2.b));
                                this.a(d, false, a3);
                                if (d.a() == null) {
                                    break Label_0416;
                                }
                                this.c.d(d);
                                if (a == 0) {
                                    break Label_0416;
                                }
                            }
                            this.a(d, false, a(this.c.l(d), null));
                        }
                        e.g();
                        if (a == 0) {
                            if (e.f()) {
                                d = e.a();
                                final q q4;
                                q = (q4 = this.u.get(d));
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                Label_0215: {
                    if (q2 != null) {
                        final t p = this.c.p(d);
                        final t a4 = this.a(c, q, c.a(d.c()));
                        final v a5 = a(this.c.l(d), a4);
                        this.a(d, q, d.d());
                        this.c.c(d, new t(p.a - a4.a, p.b - a4.b));
                        this.a(d, true, a5);
                        if (d.a() == null) {
                            break Label_0215;
                        }
                        this.c.d(d);
                        if (a == 0) {
                            break Label_0215;
                        }
                    }
                    this.a(d, true, a(this.c.l(d), null));
                }
                e.g();
                if (a != 0) {
                    break;
                }
            }
            e = f.a();
            continue;
        }
    }
    
    private boolean a(final d d, final c c) {
        final aE ae = (aE)c.b(d);
        return ae != null && ae.a();
    }
    
    private t c(final q q) {
        t t = null;
        final am a = this.c.a((Object)q);
        if (this.d != null) {
            final Point2D.Double double1 = (Point2D.Double)this.d.b(q);
            if (double1 != null) {
                t = new t(a.getX() - double1.x, a.getY() - double1.y);
            }
        }
        return (t != null) ? t : new t();
    }
    
    private t a(final y.f.b.c c, final q q, final q q2) {
        final int a = c.a;
        t b = new t();
        if (this.d != null) {
            q q3 = c.a(q);
            while (q3 != null && q3 != q2) {
                b = y.d.t.b(b, this.c(q3));
                q3 = c.a(q3);
                if (a != 0) {
                    break;
                }
            }
        }
        return b;
    }
    
    static boolean a(final j j, final q q) {
        return j.a(q);
    }
    
    static boolean a(final j j, final q q, final y.f.b.c c) {
        return j.b(q, c);
    }
    
    static c a(final j j) {
        return j.p;
    }
    
    static {
        a = "y.layout.grouping.RecursiveGroupLayouter.GROUP_NODE_LAYOUTER_DPKEY";
        b = new o(null);
    }
}
