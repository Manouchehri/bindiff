package y.f.i;

import java.awt.geom.*;
import y.d.*;
import java.util.*;
import y.f.*;
import y.c.*;

class aK extends a
{
    private X p;
    private aH q;
    private A r;
    private h s;
    private A t;
    private i u;
    private h v;
    private h w;
    private D x;
    private D y;
    private c z;
    private c A;
    private c B;
    private aF C;
    private A D;
    private A E;
    private D F;
    boolean a;
    boolean b;
    boolean c;
    t d;
    int e;
    int f;
    double g;
    byte h;
    Object i;
    Object n;
    Set o;
    
    aK() {
        this.i = ah.g_;
        this.n = ah.h_;
    }
    
    public void c(final X p) {
        final int f = y.f.i.v.f;
        if (this.h == 2) {
            final Object n = this.n;
            if (p.c(n) == null) {
                throw new IllegalStateException("No DataProvider " + n + " registered with graph!");
            }
        }
        else if (this.h == 4) {
            final Object i = this.i;
            if (p.c(i) == null) {
                throw new IllegalStateException("No DataProvider " + i + " registered with graph!");
            }
        }
        final ah a = this.a();
        if (a != null) {
            a.c(p);
        }
        if (p.h() == 0) {
            return;
        }
        this.p = p;
        this.w = p.u();
        final e p2 = p.p();
        while (true) {
            while (p2.f()) {
                this.w.a(p2.a(), new ae(p2.a()));
                p2.g();
                if (f != 0) {
                    Label_0354: {
                        Label_0341: {
                            switch (this.h) {
                                case 4: {
                                    this.e();
                                    if (f != 0) {
                                        break Label_0341;
                                    }
                                    break Label_0354;
                                }
                                case 2: {
                                    this.f();
                                    if (f != 0) {
                                        break;
                                    }
                                    break Label_0354;
                                }
                            }
                        }
                        this.c();
                    }
                    this.d();
                    p.a(this.v);
                    p.a(this.w);
                    this.C = null;
                    this.A = null;
                    this.z = null;
                    this.B = null;
                    this.A = null;
                    this.y = null;
                    this.x = null;
                    this.D = null;
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            this.g();
            this.u = new i();
            this.t = this.u.t();
            this.r = this.u.t();
            this.s = this.u.u();
            this.q = new aH();
            this.v = p.u();
            this.b(p);
            this.i();
            this.h();
            this.b();
            continue;
        }
    }
    
    private void g() {
        final int f = y.f.i.v.f;
        final e p = this.p.p();
        while (p.f()) {
            final d a = p.a();
            final ae ae = (ae)this.w.b(a);
            final aE d = aE.d(this.p, a);
            final aE e = aE.e(this.p, a);
            if (d != null && d.a()) {
                ae.b(true, true);
            }
            if (e != null && e.a()) {
                ae.b(false, true);
            }
            final boolean b = this.p.k(a).size() == 0;
            Label_0193: {
                if (b && ae.b(true) && !ae.b(false)) {
                    ae.c(false, true);
                    if (f == 0) {
                        break Label_0193;
                    }
                }
                if (b && !ae.b(true) && ae.b(false)) {
                    ae.c(true, true);
                }
            }
            p.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void h() {
        final int i = y.f.i.v.f;
        final i j = new i();
        if (this.D != null) {
            j.a(this.D);
        }
        this.D = j.t();
        this.C = new aF();
        int n = 0;
        final C m = this.y.m();
        while (true) {
            while (m.f()) {
                ++n;
                final ao ao = (ao)m.d();
                final double n2 = dcmpl(ao.t(), ao.u());
                if (i != 0) {
                    int n3 = (int)n2;
                    final C k = this.x.m();
                    do {
                        double f = 0.0;
                        Label_0153: {
                            f = (k.f() ? 1 : 0);
                        }
                        Label_0159:
                        while (f != 0) {
                            ++n3;
                            final ao ao2 = (ao)k.d();
                            if (ao2.t() != ao2.u()) {
                                final q d = j.d();
                                this.C.a(ao2, d);
                                this.D.a(d, ao2);
                                final Rectangle2D.Double double1 = new Rectangle2D.Double(ao2.k.a, ao2.k.b, ao2.l.a - ao2.k.a, ao2.l.b - ao2.k.b);
                                final C l = ((D)this.B.b(ao2)).m();
                                while (l.f()) {
                                    final ao ao3 = (ao)l.d();
                                    final double n4 = f = dcmpl(ao3.t(), ao3.u());
                                    if (i != 0) {
                                        continue Label_0159;
                                    }
                                    if (n4 != 0) {
                                        final Rectangle2D.Double double2 = new Rectangle2D.Double(ao3.k.a, ao3.k.b, ao3.l.a - ao3.k.a, ao3.l.b - ao3.k.b);
                                        if (this.C.b(ao3) != null && double1.intersects(double2)) {
                                            j.a(d, (q)this.C.b(ao3));
                                        }
                                    }
                                    l.g();
                                    if (i != 0) {
                                        break;
                                    }
                                }
                            }
                            k.g();
                            continue Label_0153;
                        }
                        break;
                    } while (i == 0);
                    return;
                }
                if (n2 != 0) {
                    final q d2 = j.d();
                    this.C.a(ao, d2);
                    this.D.a(d2, ao);
                }
                m.g();
                if (i != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    private void i() {
        final av av = new av(this.p, new f());
        Label_0058: {
            if (this.c) {
                av.a(5 * this.e);
                av.b(0.5);
                if (y.f.i.v.f == 0) {
                    break Label_0058;
                }
            }
            av.b(this.g);
        }
        av.b(true);
        av.a((byte)8);
        av.g();
        this.x = av.a();
        this.y = av.b();
        this.z = av.c();
        this.A = av.d();
        this.B = av.e();
    }
    
    void b() {
        final int f = y.f.i.v.f;
        final e p = this.p.p();
        while (p.f()) {
            final d a = p.a();
            if (!this.v.d(a)) {
                this.a(a);
            }
            p.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final d d) {
        final int f = y.f.i.v.f;
        final q c = d.c();
        ae ae = (ae)this.w.b(d);
        if (ae == null) {
            ae = new ae(d);
            this.w.a(d, ae);
        }
        final s j = this.p.l(d).j();
        final m a = j.a();
        final t c2 = a.c();
        final t d2 = a.d();
        if (this.p.s(c).a(c2) && this.p.s(c).a(d2)) {
            this.v.a(d, true);
            return;
        }
        ai a2 = this.a(d, c2, d2, c);
        if (a2 == null) {
            this.v.a(d, true);
            return;
        }
        Label_0220: {
            if (a2.x()) {
                a2.a(d, c2.a, c2.b, d2.b);
                if (f == 0) {
                    break Label_0220;
                }
            }
            a2.a(d, c2.b, c2.a, d2.a);
        }
        this.q.a(a, a2);
        ae.a(a);
        j.g();
        while (j.f()) {
            final m a3 = j.a();
            final t c3 = a3.c();
            final t d3 = a3.d();
            final ai a4 = this.a(d, c3, d3, a2);
            if (a4 == null) {
                this.v.a(d, true);
                return;
            }
            Label_0353: {
                if (a4.x()) {
                    a4.a(d, c3.a, c3.b, d3.b);
                    if (f == 0) {
                        break Label_0353;
                    }
                }
                a4.a(d, c3.b, c3.a, d3.a);
            }
            this.q.a(a3, a4);
            ae.a(a3);
            a2 = a4;
            j.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private ai a(final d d, final t t, final t t2, final q q) {
        final int f = y.f.i.v.f;
        final byte[] array = { 1, 2, 8, 4 };
        ai ai = null;
        final aJ aj = (aJ)this.A.b(q);
        final int a = this.a(q, t, t2);
        if (a == -9) {
            return null;
        }
        D d2 = null;
        double n = 0.0;
        switch (array[a]) {
            case 1: {
                d2 = aj.a;
                n = t.a;
                break;
            }
            case 2: {
                d2 = aj.c;
                n = t.a;
                break;
            }
            case 8: {
                d2 = aj.e;
                n = t.b;
                break;
            }
            case 4: {
                d2 = aj.g;
                n = t.b;
                break;
            }
        }
        int n2 = 0;
        final C m = d2.m();
        while (m.f() && n2 == 0) {
            final ai ai2 = (ai)m.d();
            if (n >= ai2.t() && n < ai2.u()) {
                n2 = 1;
                ai = ai2;
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
        return ai;
    }
    
    private ai a(final d d, final t t, final t t2, final ai ai) {
        final int f = y.f.i.v.f;
        ai ai2 = null;
        final q q = (q)this.C.b(ai);
        final double n = ai.x() ? t.b : t.a;
        int n2 = 0;
        final e j = q.j();
        while (j.f() && n2 == 0) {
            final ai ai3 = (ai)this.D.b(j.a().a(q));
            if (n >= ai3.t() && n < ai3.u()) {
                n2 = 1;
                ai2 = ai3;
            }
            j.g();
            if (f != 0) {
                break;
            }
        }
        return ai2;
    }
    
    private int a(final q q, final t t, final t t2) {
        final int f = y.f.i.v.f;
        if (Math.abs(t.a - t2.a) < 0.01) {
            final int n = (t2.b > this.p.n(q) + this.p.q(q) / 2.0) ? 1 : 0;
            if (f == 0) {
                return n;
            }
        }
        if (Math.abs(t.b - t2.b) < 0.01) {
            final int n = (t2.a <= this.p.m(q) + this.p.p(q) / 2.0) ? 2 : 3;
            if (f == 0) {
                return n;
            }
        }
        return -9;
    }
    
    void c() {
        final int f = y.f.i.v.f;
        final y.g.a.d d = new y.g.a.d(this.p);
        this.E = this.p.t();
        final x o = this.p.o();
        while (true) {
        Label_0550_Outer:
            while (o.f()) {
                final q e = o.e();
                final aO ao = new aO(this, e, null);
                this.E.a(e, ao);
                final int size;
                final int n = size = ao.c().size();
                if (f != 0) {
                    final boolean b2;
                    Label_0222: {
                        if (size == 0) {
                            final q b = d.b();
                            final aO ao2 = (aO)this.E.b(b);
                            this.a(b, ao2.c());
                            this.u.j();
                            b2 = ao2.b();
                            if (f != 0) {
                                break Label_0222;
                            }
                            if (b2) {
                                final int size2 = ao2.c().size();
                                if (size2 > 0) {
                                    d.c(b, -size2);
                                    if (f == 0) {
                                        break;
                                    }
                                }
                                d.c();
                                if (f == 0) {
                                    break;
                                }
                            }
                            d.c();
                            if (f == 0) {
                                break;
                            }
                        }
                        final boolean b3 = this.b;
                    }
                    Label_0630: {
                        if (b2) {
                            final x o2 = this.p.o();
                        Label_0234:
                            while (true) {
                            Label_0333_Outer:
                                while (o2.f()) {
                                    final q q = o2.e();
                                    final aJ aj = (aJ)this.A.b(q);
                                    final Object o3;
                                    final C c = (C)(o3 = aj.a.m());
                                    if (f == 0) {
                                        C c2 = c;
                                        while (true) {
                                            while (c2.f()) {
                                                ((ai)c2.d()).c(false);
                                                c2.g();
                                                if (f != 0) {
                                                    while (true) {
                                                        while (c2.f()) {
                                                            ((ai)c2.d()).c(true);
                                                            c2.g();
                                                            if (f != 0) {
                                                                while (true) {
                                                                    while (c2.f()) {
                                                                        ((ai)c2.d()).c(false);
                                                                        c2.g();
                                                                        if (f == 0) {
                                                                            if (f != 0) {
                                                                                break;
                                                                            }
                                                                            continue Label_0333_Outer;
                                                                        }
                                                                        else {
                                                                            while (c2.f()) {
                                                                                ((ai)c2.d()).c(true);
                                                                                c2.g();
                                                                                if (f != 0) {
                                                                                    continue Label_0234;
                                                                                }
                                                                                if (f != 0) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            final aO ao3 = (aO)this.E.b(q);
                                                                            ao3.a();
                                                                            final int size3 = ao3.c().size();
                                                                            if (size3 > 0) {
                                                                                d.a(q, -size3);
                                                                            }
                                                                            o2.g();
                                                                            if (f != 0) {
                                                                                break Label_0333_Outer;
                                                                            }
                                                                            continue Label_0234;
                                                                        }
                                                                    }
                                                                    c2 = aj.g.m();
                                                                    continue Label_0550_Outer;
                                                                }
                                                            }
                                                            if (f != 0) {
                                                                break;
                                                            }
                                                        }
                                                        c2 = aj.e.m();
                                                        continue Label_0550_Outer;
                                                    }
                                                }
                                                if (f != 0) {
                                                    break;
                                                }
                                            }
                                            c2 = aj.c.m();
                                            continue Label_0550_Outer;
                                        }
                                    }
                                    final aO ao4 = (aO)o3;
                                    this.a(q, ao4.c());
                                    this.u.j();
                                    if (f != 0) {
                                        return;
                                    }
                                    if (ao4.b()) {
                                        final int size4 = ao4.c().size();
                                        if (size4 > 0) {
                                            d.c(q, -size4);
                                            if (f == 0) {
                                                break;
                                            }
                                        }
                                        d.c();
                                        if (f == 0) {
                                            break;
                                        }
                                    }
                                    d.c();
                                    if (f != 0) {
                                        break Label_0630;
                                    }
                                    break;
                                }
                                if (!d.a()) {
                                    final q q = d.b();
                                    final Object o3 = this.E.b(q);
                                    continue;
                                }
                                break;
                            }
                        }
                    }
                    this.p.a(this.E);
                    d.f();
                    return;
                }
                if (size > 0) {
                    d.a(e, -n);
                }
                o.g();
                if (f != 0) {
                    break;
                }
            }
            d.a();
            continue;
        }
    }
    
    void b(final X x) {
        final int f = y.f.i.v.f;
        this.o = new HashSet();
        final e p = x.p();
        while (p.f()) {
            final d a = p.a();
            if (a.e()) {
                final D m = x.m(a);
                if (m.size() >= 5) {
                    final D d = new D();
                    d.add(m.g());
                    d.add(m.g());
                    d.add(m.f());
                    final q d2 = x.d();
                    x.b(d2, 1.0, 1.0);
                    x.a(d2, (t)m.f());
                    final d a2 = x.a(a.c(), d2);
                    final ae ae = new ae(a2);
                    if (((ae)this.w.b(a)).b(true)) {
                        ae.b(true, true);
                    }
                    if (((ae)this.w.b(a)).b(false)) {
                        ae.b(false, true);
                    }
                    this.w.a(a2, ae);
                    x.a(a2, d);
                    x.a(a, d2, a.d());
                    x.a(a, m);
                    this.o.add(d2);
                }
            }
            p.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    void d() {
        final int f = y.f.i.v.f;
        for (final q q : this.o) {
            final d f2 = q.f();
            final d g = q.g();
            final D m = this.p.m(f2);
            final D i = this.p.m(g);
            i.j();
            i.a(m);
            this.p.a(g);
            this.p.a(f2, g.c(), f2.d());
            this.p.a(q);
            this.p.a(f2, i);
            if (f != 0) {
                return;
            }
            if (f != 0) {
                break;
            }
        }
        this.o = null;
    }
    
    void e() {
        final int f = y.f.i.v.f;
        final y.g.a.d d = new y.g.a.d(this.p);
        this.E = this.p.t();
        final c c = this.p.c(this.i);
        final x o = this.p.o();
        while (true) {
        Label_0567_Outer:
            while (o.f()) {
                final q e = o.e();
                final boolean d2 = c.d(e);
                if (f != 0) {
                    final boolean b2;
                    Label_0246: {
                        if (!d2) {
                            final q b = d.b();
                            final aO ao = (aO)this.E.b(b);
                            this.a(b, ao.c());
                            this.u.j();
                            b2 = ao.b();
                            if (f != 0) {
                                break Label_0246;
                            }
                            if (b2) {
                                final int size = ao.c().size();
                                if (size > 0) {
                                    d.c(b, -size);
                                    if (f == 0) {
                                        break;
                                    }
                                }
                                d.c();
                                if (f == 0) {
                                    break;
                                }
                            }
                            d.c();
                            if (f == 0) {
                                break;
                            }
                        }
                        final boolean b3 = this.b;
                    }
                    Label_0665: {
                        if (b2) {
                            final x o2 = this.p.o();
                            while (true) {
                            Label_0368_Outer:
                                while (o2.f()) {
                                    final q e2 = o2.e();
                                    final boolean d3 = c.d(e2);
                                    if (f == 0) {
                                        Label_0558: {
                                            Label_0551: {
                                                if (d3) {
                                                    final aJ aj = (aJ)this.A.b(e2);
                                                    C c2 = aj.a.m();
                                                    while (true) {
                                                        while (c2.f()) {
                                                            ((ai)c2.d()).c(false);
                                                            c2.g();
                                                            if (f != 0) {
                                                                while (true) {
                                                                    while (c2.f()) {
                                                                        ((ai)c2.d()).c(true);
                                                                        c2.g();
                                                                        if (f != 0) {
                                                                            while (true) {
                                                                                while (c2.f()) {
                                                                                    ((ai)c2.d()).c(false);
                                                                                    c2.g();
                                                                                    if (f == 0) {
                                                                                        if (f != 0) {
                                                                                            break;
                                                                                        }
                                                                                        continue Label_0368_Outer;
                                                                                    }
                                                                                    else {
                                                                                        while (c2.f()) {
                                                                                            ((ai)c2.d()).c(true);
                                                                                            c2.g();
                                                                                            if (f != 0) {
                                                                                                break Label_0558;
                                                                                            }
                                                                                            if (f != 0) {
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        final aO ao2 = (aO)this.E.b(e2);
                                                                                        ao2.a();
                                                                                        final int size2 = ao2.c().size();
                                                                                        if (size2 > 0) {
                                                                                            d.a(e2, -size2);
                                                                                        }
                                                                                        break Label_0551;
                                                                                    }
                                                                                }
                                                                                c2 = aj.g.m();
                                                                                continue Label_0567_Outer;
                                                                            }
                                                                        }
                                                                        if (f != 0) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    c2 = aj.e.m();
                                                                    continue Label_0567_Outer;
                                                                }
                                                            }
                                                            if (f != 0) {
                                                                break;
                                                            }
                                                        }
                                                        c2 = aj.c.m();
                                                        continue Label_0567_Outer;
                                                    }
                                                }
                                            }
                                            o2.g();
                                        }
                                        if (f != 0) {
                                            break;
                                        }
                                        continue Label_0567_Outer;
                                    }
                                    else {
                                        if (d3) {
                                            break Label_0665;
                                        }
                                        final q b4 = d.b();
                                        final aO ao3 = (aO)this.E.b(b4);
                                        this.a(b4, ao3.c());
                                        this.u.j();
                                        if (f != 0) {
                                            return;
                                        }
                                        if (ao3.b()) {
                                            final int size3 = ao3.c().size();
                                            if (size3 > 0) {
                                                d.c(b4, -size3);
                                                if (f == 0) {
                                                    break;
                                                }
                                            }
                                            d.c();
                                            if (f == 0) {
                                                break;
                                            }
                                        }
                                        d.c();
                                        if (f != 0) {
                                            break Label_0665;
                                        }
                                        break;
                                    }
                                }
                                d.a();
                                continue;
                            }
                        }
                    }
                    this.p.a(this.E);
                    d.f();
                    return;
                }
                if (d2) {
                    final aO ao4 = new aO(this, e, null);
                    this.E.a(e, ao4);
                    final int size4 = ao4.c().size();
                    if (size4 > 0) {
                        d.a(e, -size4);
                    }
                }
                o.g();
                if (f != 0) {
                    break;
                }
            }
            d.a();
            continue;
        }
    }
    
    void f() {
        final int i = y.f.i.v.f;
        final y y = new y();
        final c c = this.p.c(this.n);
        final A t = this.p.t();
        final x o = this.p.o();
        while (true) {
            do {
                Label_0042: {
                    o.f();
                }
                boolean d = false;
                Label_0049:
            Label_0308_Outer:
                while (d) {
                    final q e = o.e();
                    if (i == 0) {
                        final e j = e.j();
                        while (j.f()) {
                            final d a = j.a();
                            d = this.v.d(a);
                            if (i != 0) {
                                continue Label_0049;
                            }
                            if (!d && c.d(a) && !t.d(e)) {
                                y.add(e);
                                t.a(e, true);
                                if (i == 0) {
                                    break;
                                }
                            }
                            j.g();
                            if (i != 0) {
                                break;
                            }
                        }
                        o.g();
                        continue Label_0042;
                    }
                    final y.g.a.d d2 = new y.g.a.d(this.p);
                    this.E = this.p.t();
                    final x a2 = y.a();
                    while (true) {
                    Label_0758_Outer:
                        while (a2.f()) {
                            final q e2 = a2.e();
                            final aO ao = new aO(this, e2, c);
                            this.E.a(e2, ao);
                            final int size;
                            final int n = size = ao.c().size();
                            if (i != 0) {
                                final boolean b2;
                                Label_0421: {
                                    if (size == 0) {
                                        final q b = d2.b();
                                        final aO ao2 = (aO)this.E.b(b);
                                        this.a(b, ao2.c());
                                        this.u.j();
                                        b2 = ao2.b();
                                        if (i != 0) {
                                            break Label_0421;
                                        }
                                        if (b2) {
                                            final int size2 = ao2.c().size();
                                            if (size2 > 0) {
                                                d2.c(b, -size2);
                                                if (i == 0) {
                                                    break;
                                                }
                                            }
                                            d2.c();
                                            if (i == 0) {
                                                break;
                                            }
                                        }
                                        d2.c();
                                        if (i == 0) {
                                            break;
                                        }
                                    }
                                    final boolean b3 = this.b;
                                }
                                Label_0846: {
                                    if (b2) {
                                        final x a3 = y.a();
                                        Label_0430:
                                        while (true) {
                                        Label_0732:
                                            while (a3.f()) {
                                                final q q = a3.e();
                                                final aJ aj = (aJ)this.A.b(q);
                                                final Object o2;
                                                final C c2 = (C)(o2 = aj.a.m());
                                                if (i == 0) {
                                                    C c3 = c2;
                                                    while (true) {
                                                        while (c3.f()) {
                                                            ((ai)c3.d()).c(false);
                                                            c3.g();
                                                            if (i != 0) {
                                                                while (true) {
                                                                    while (c3.f()) {
                                                                        ((ai)c3.d()).c(true);
                                                                        c3.g();
                                                                        if (i != 0) {
                                                                            while (true) {
                                                                                while (c3.f()) {
                                                                                    ((ai)c3.d()).c(false);
                                                                                    c3.g();
                                                                                    if (i == 0) {
                                                                                        if (i != 0) {
                                                                                            break;
                                                                                        }
                                                                                        continue Label_0308_Outer;
                                                                                    }
                                                                                    else {
                                                                                        while (c3.f()) {
                                                                                            ((ai)c3.d()).c(true);
                                                                                            c3.g();
                                                                                            if (i != 0) {
                                                                                                continue Label_0430;
                                                                                            }
                                                                                            if (i != 0) {
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        final aO ao3 = (aO)this.E.b(q);
                                                                                        ao3.a();
                                                                                        final int size3 = ao3.c().size();
                                                                                        if (size3 > 0) {
                                                                                            d2.a(q, -size3);
                                                                                        }
                                                                                        a3.g();
                                                                                        if (i != 0) {
                                                                                            break Label_0732;
                                                                                        }
                                                                                        continue Label_0430;
                                                                                    }
                                                                                }
                                                                                c3 = aj.g.m();
                                                                                continue Label_0758_Outer;
                                                                            }
                                                                        }
                                                                        if (i != 0) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    c3 = aj.e.m();
                                                                    continue Label_0758_Outer;
                                                                }
                                                            }
                                                            if (i != 0) {
                                                                break;
                                                            }
                                                        }
                                                        c3 = aj.c.m();
                                                        continue Label_0758_Outer;
                                                    }
                                                }
                                                final aO ao4 = (aO)o2;
                                                this.a(q, ao4.c());
                                                this.u.j();
                                                if (i != 0) {
                                                    return;
                                                }
                                                if (ao4.b()) {
                                                    final int size4 = ao4.c().size();
                                                    if (size4 > 0) {
                                                        d2.c(q, -size4);
                                                        if (i == 0) {
                                                            break;
                                                        }
                                                    }
                                                    d2.c();
                                                    if (i == 0) {
                                                        break;
                                                    }
                                                }
                                                d2.c();
                                                if (i != 0) {
                                                    break Label_0846;
                                                }
                                                break;
                                            }
                                            if (!d2.a()) {
                                                final q q = d2.b();
                                                final Object o2 = this.E.b(q);
                                                continue;
                                            }
                                            break;
                                        }
                                    }
                                }
                                this.p.a(this.E);
                                d2.f();
                                return;
                            }
                            if (size > 0) {
                                d2.a(e2, -n);
                            }
                            a2.g();
                            if (i != 0) {
                                break;
                            }
                        }
                        d2.a();
                        continue;
                    }
                }
                break;
            } while (i == 0);
            this.p.a(t);
            continue;
        }
    }
    
    private void a(final q q, final f f) {
        final int f2 = y.f.i.v.f;
        if (f.size() < 2) {
            return;
        }
        f.sort(new aq(this.p, q));
        final aO ao = (aO)this.E.b(q);
        final byte[] array = { 1, 2, 8, 4 };
        final aJ aj = (aJ)this.A.b(q);
        D d = null;
        boolean b = false;
        switch (array[ao.d()]) {
            case 1: {
                d = aj.a;
                b = false;
                break;
            }
            case 2: {
                d = aj.c;
                b = true;
                break;
            }
            case 8: {
                d = aj.e;
                b = false;
                break;
            }
            case 4: {
                d = aj.g;
                b = true;
                break;
            }
        }
        d.sort(new aD(this.p.o(q)));
        this.a(d, b);
        final aF af = new aF();
        Object o = null;
        final C m = d.m();
        while (m.f()) {
            m.d();
        Label_0264:
            while (true) {
                Object o2 = null;
                final ai ai = (ai)o2;
                final D a = ai.a(b);
                if (a != null) {
                    final C i = a.m();
                    while (i.f()) {
                        final ak ak = (ak)i.d();
                        final q d2 = this.u.d();
                        ak.c = d2;
                        o2 = o;
                        if (f2 != 0) {
                            continue Label_0264;
                        }
                        if (o2 != null) {
                            ((aM)o).b(d2);
                        }
                        final aM am = new aM();
                        am.a = true;
                        am.a(new aP(ai, ak.a));
                        am.a(ak.b);
                        this.t.a(d2, am);
                        if (o == null) {
                            af.a(ai, d2);
                        }
                        o = am;
                        i.g();
                        if (f2 != 0) {
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            m.g();
            if (f2 != 0) {
                break;
            }
        }
        aM am2 = null;
        final e a2 = f.a();
        while (a2.f()) {
            final d a3 = a2.a();
            final boolean b2 = a3.c() == q;
            final ae ae = (ae)this.w.b(a3);
            if (!ae.b(b2) && !ae.d(b2) && !ae.c() && !this.v.d(a3)) {
                final q d3 = this.u.d();
                ae.a(d3);
                if (am2 != null) {
                    am2.b(d3);
                }
                final aM am3 = am2 = new aM();
                am3.a = false;
                am3.a(a3);
                this.t.a(d3, am3);
                final C b3 = ae.b();
                Label_0644: {
                    if (b2) {
                        b3.i();
                        if (f2 == 0) {
                            break Label_0644;
                        }
                    }
                    b3.j();
                }
                final m j = (m)b3.d();
                final ai ai2 = (ai)this.q.b(j);
                final double n = b ? ai2.v() : ai2.w();
                double n2 = 0.0;
                double n3 = 0.0;
                double n4 = 0.0;
                Label_0807: {
                    if (ai2.x()) {
                        n2 = Math.min(j.c().b, j.d().b);
                        n3 = Math.max(j.c().b, j.d().b);
                        n4 = j.c().a;
                        if (f2 == 0) {
                            break Label_0807;
                        }
                    }
                    n2 = Math.min(j.c().a, j.d().a);
                    n3 = Math.max(j.c().a, j.d().a);
                    n4 = j.c().b;
                }
                Label_0825: {
                    if (b) {
                        n2 = n;
                        if (f2 == 0) {
                            break Label_0825;
                        }
                    }
                    n3 = n;
                }
                Label_0863: {
                    if (b3.k() == 1) {
                        aM.a(am3, ai2.q());
                        if (f2 == 0) {
                            break Label_0863;
                        }
                    }
                    aM.a(am3, n3 - n2);
                }
                this.a(d3, ai2, aM.a(am3), b, n4);
            }
            a2.g();
            if (f2 != 0) {
                break;
            }
        }
        final x o3 = this.u.o();
        while (true) {
            while (o3.f()) {
                final q e = o3.e();
                final aM am4 = (aM)this.t.b(e);
                final boolean a4 = am4.a;
                if (f2 != 0) {
                    if (!a4) {
                        this.a(q, f, b);
                    }
                    return;
                }
                Label_1073: {
                    if (!a4) {
                        final d d4 = (d)am4.a();
                        D d5 = null;
                        Label_1005: {
                            if (this.p.m(d4).size() == 2) {
                                d5 = this.a(q, d4, d);
                                if (f2 == 0) {
                                    break Label_1005;
                                }
                            }
                            d5 = this.b(q, d4, d);
                        }
                        final C k = d5.m();
                        while (k.f()) {
                            this.a(e, (ai)k.d(), aM.a(am4), b);
                            k.g();
                            if (f2 != 0) {
                                break Label_1073;
                            }
                            if (f2 != 0) {
                                break;
                            }
                        }
                    }
                    o3.g();
                }
                if (f2 != 0) {
                    break;
                }
            }
            this.u.i();
            continue;
        }
    }
    
    private void a(final q q, final f f, final boolean b) {
        final int f2 = y.f.i.v.f;
        this.F = new D();
        final x o = this.u.o();
        final aM am = (aM)this.t.b(o.e());
        if (!am.a) {
            return;
        }
        final double b2 = ((aP)am.a()).b;
        while (o.f() && ((aM)this.t.b(o.d())).a) {
            o.g();
        }
        while (true) {
        Label_1130_Outer:
            while (o.f()) {
                this.a(this.F, ((aM)this.t.b(o.e())).c());
                o.g();
                if (f2 != 0) {
                    int n = 0;
                Label_0191:
                    while (true) {
                        o.f();
                        boolean d = false;
                    Label_0198:
                        while (d && n == 0) {
                            final q e = o.e();
                            final aM am2 = (aM)this.t.b(e);
                            if (am2.a) {
                                this.b(this.F, am2.c());
                                int n2 = 0;
                                final e j = e.j();
                                int n3 = 0;
                                Label_0384: {
                                    while (j.f()) {
                                        n3 = n2;
                                        if (f2 != 0 || n3 != 0) {
                                            break Label_0384;
                                        }
                                        final d a = j.a();
                                        final q a2 = a.a(e);
                                        if (a2.a() == 1) {
                                            this.a(this.F, am2.c(), ((aM)this.t.b(a2)).c());
                                            this.s.a(a, true);
                                            this.r.a(a2, true);
                                            n2 = 1;
                                        }
                                        j.g();
                                        if (f2 != 0) {
                                            goto Label_0382;
                                        }
                                    }
                                    goto Label_0382;
                                }
                                if (n3 != 0) {
                                    final e i = e.j();
                                    while (i.f()) {
                                        final d a3 = i.a();
                                        d = this.s.d(a3);
                                        if (f2 != 0) {
                                            continue Label_0198;
                                        }
                                        if (!d) {
                                            this.u.a(a3);
                                        }
                                        i.g();
                                        if (f2 != 0) {
                                            break;
                                        }
                                    }
                                    this.r.a(e, true);
                                }
                                o.g();
                                if (f2 == 0) {
                                    continue Label_0191;
                                }
                            }
                            n = 1;
                            if (f2 != 0) {
                                break;
                            }
                            continue Label_0191;
                        }
                        break;
                    }
                    double n4 = b2;
                    final y y = new y();
                    q q2 = null;
                    aM am3 = null;
                    d d2 = null;
                    while (true) {
                        q q3;
                        aM am4;
                        boolean d3;
                        f f3;
                        y.f.i.aE ae;
                        f f4;
                        int b3;
                        int n5;
                        aL al;
                        e a4;
                        int n6;
                        d a5;
                        double b4;
                        int n7 = 0;
                        boolean b5;
                        e k;
                        d a6;
                        Object b6 = null;
                        d d4;
                        q a7;
                        aM am5;
                        d d5;
                        ai a8;
                        double b7;
                        int n8;
                        e l;
                        int n9 = 0;
                        d a9;
                        d d6;
                        ae ae2;
                        C b8;
                        boolean b9;
                        ai ai;
                        aj a10;
                        C b10;
                        m m;
                        ai ai2;
                        Label_0798_Outer:Label_1137_Outer:
                        while (o.f()) {
                            q3 = o.e();
                            am4 = (aM)this.t.b(q3);
                            d3 = this.r.d(q3);
                            while (true) {
                                Label_1160: {
                                    if (f2 == 0) {
                                        Label_1111: {
                                            Label_1060: {
                                                if (!d3) {
                                                    f3 = new f();
                                                    ae = new y.f.i.aE(q3, this.t);
                                                    f4 = new f(q3.j());
                                                    f4.sort(ae);
                                                    b3 = (false ? 1 : 0);
                                                    n5 = 0;
                                                    al = new aL(this);
                                                    al.a(q3);
                                                    a4 = f4.a();
                                                    while (true) {
                                                        while (a4.f()) {
                                                            n6 = n5;
                                                            if (f2 == 0) {
                                                                if (n6 != 0) {
                                                                    break;
                                                                }
                                                                a5 = a4.a();
                                                                q2 = a5.a(q3);
                                                                am3 = (aM)this.t.b(q2);
                                                                b4 = ((aP)am3.a()).b;
                                                                if (!this.r.d(q3) && this.b(this.F, am3.c(), am4.c())) {
                                                                    f3.add(a5);
                                                                }
                                                                n5 = ((b4 >= n4) ? 1 : 0);
                                                                if (n5 != 0 && f3.isEmpty()) {
                                                                    n5 = 0;
                                                                }
                                                                a4.g();
                                                                if (f2 != 0) {
                                                                    break;
                                                                }
                                                                continue Label_0798_Outer;
                                                            }
                                                            else {
                                                                Label_0897: {
                                                                    while (true) {
                                                                        if (n6 == 0) {
                                                                            n7 = b3;
                                                                            if (f2 != 0) {
                                                                                break Label_0897;
                                                                            }
                                                                            if (n7 == 0) {
                                                                                d2 = (d)f3.j();
                                                                                q2 = d2.a(q3);
                                                                                b3 = (al.b(q2) ? 1 : 0);
                                                                                am3 = (aM)this.t.b(q2);
                                                                                n4 = Math.max(n4, ((aP)am3.a()).b);
                                                                                if (f2 == 0) {
                                                                                    f3.isEmpty();
                                                                                    continue Label_0798_Outer;
                                                                                }
                                                                            }
                                                                        }
                                                                        break;
                                                                    }
                                                                    b5 = (d2 != null);
                                                                }
                                                                if (n7 == 0) {
                                                                    return;
                                                                }
                                                                this.a(this.F, am3.c(), am4.c());
                                                                this.s.a(d2, true);
                                                                this.r.a(q3, true);
                                                                this.r.a(q2, true);
                                                                k = q2.j();
                                                                while (k.f()) {
                                                                    a6 = k.a();
                                                                    d4 = (d)(b6 = a6);
                                                                    if (f2 != 0) {
                                                                        break Label_1160;
                                                                    }
                                                                    if (d4 != d2) {
                                                                        a7 = a6.a(q2);
                                                                        this.u.a(a6);
                                                                        if (!this.r.d(a7) && a7.a() == 1) {
                                                                            y.add(a7);
                                                                            this.a(y);
                                                                        }
                                                                    }
                                                                    k.g();
                                                                    if (f2 != 0) {
                                                                        break Label_1060;
                                                                    }
                                                                }
                                                                break Label_1111;
                                                            }
                                                        }
                                                        d2 = null;
                                                        continue Label_1137_Outer;
                                                    }
                                                }
                                            }
                                            q2 = q3.j().a().a(q3);
                                            am3 = (aM)this.t.b(q2);
                                            n4 = Math.max(n4, ((aP)am3.a()).b);
                                        }
                                        o.g();
                                        if (f2 != 0) {
                                            break;
                                        }
                                        continue Label_1137_Outer;
                                    }
                                    if (!d3) {
                                        return;
                                    }
                                    q3 = o.e();
                                    b6 = this.t.b(q3);
                                }
                                am5 = (aM)b6;
                                d5 = null;
                                Label_1625: {
                                    if (am5.a) {
                                        a8 = ((aP)am5.a()).a;
                                        b7 = ((aP)am5.a()).b;
                                        n8 = 0;
                                        l = q3.j();
                                        Label_1276: {
                                            while (l.f()) {
                                                n9 = n8;
                                                if (f2 != 0 || n9 != 0) {
                                                    break Label_1276;
                                                }
                                                a9 = l.a();
                                                if (this.s.d(a9)) {
                                                    d5 = a9;
                                                    n8 = 1;
                                                }
                                                l.g();
                                                if (f2 != 0) {
                                                    goto Label_1274;
                                                }
                                            }
                                            goto Label_1274;
                                        }
                                        if (n9 != 0) {
                                            d6 = (d)((aM)this.t.b(d5.a(q3))).a();
                                            ae2 = (ae)this.w.b(d6);
                                            b8 = ae2.b();
                                            b9 = (q == d6.c());
                                            Label_1377: {
                                                if (b9) {
                                                    b8.i();
                                                    if (f2 == 0) {
                                                        break Label_1377;
                                                    }
                                                }
                                                b8.j();
                                            }
                                            ai = (ai)this.q.b(b8.d());
                                            a10 = ai.a(d6, b);
                                            Label_1500: {
                                                if (a8 != ai && a10 != null) {
                                                    ai.a(a10);
                                                    a8.a(d6, b7, a10.c, a10.d);
                                                    this.a(d6, b9, b7, a8);
                                                    if (f2 == 0) {
                                                        break Label_1500;
                                                    }
                                                }
                                                if (a10 != null) {
                                                    if (b7 != a10.b) {
                                                        a8.a(a10, b7);
                                                        this.a(d6, b9, b7, null);
                                                    }
                                                }
                                            }
                                            if (b8.k() == 1) {
                                                ae2.f(true);
                                                if (f2 == 0) {
                                                    break Label_1625;
                                                }
                                            }
                                            this.b(d6);
                                            b10 = ae2.b();
                                            Label_1573: {
                                                if (b9) {
                                                    b10.i();
                                                    b10.g();
                                                    if (f2 == 0) {
                                                        break Label_1573;
                                                    }
                                                }
                                                b10.j();
                                                b10.h();
                                            }
                                            m = (m)b10.d();
                                            ai2 = (ai)this.q.b(m);
                                            ai2.a(ai2.a(d6), m.c(), m.d());
                                        }
                                    }
                                }
                                o.g();
                                if (f2 == 0) {
                                    o.f();
                                    continue Label_1130_Outer;
                                }
                                break;
                            }
                            return;
                        }
                        o.i();
                        continue;
                    }
                }
                if (f2 != 0) {
                    break;
                }
            }
            o.i();
            continue;
        }
    }
    
    private void b(final d d) {
        final int f = y.f.i.v.f;
        final ae ae = (ae)this.w.b(d);
        final s j = this.p.l(d).j();
        final C b = ae.b();
        final D d2 = new D();
        while (b.f()) {
            final m m = (m)b.d();
            final m i = (m)j.d();
            final ai ai = (ai)this.q.b(m);
            this.q.a(m, null);
            this.q.a(i, ai);
            d2.add(i);
            b.g();
            j.g();
            if (f != 0) {
                return;
            }
            if (f != 0) {
                break;
            }
        }
        ae.a(d2);
    }
    
    private void a(final d d, final boolean b, final double n, final ai ai) {
        final ae ae = (ae)this.w.b(d);
        final C b2 = ae.b();
        Label_0046: {
            if (b) {
                b2.i();
                if (y.f.i.v.f == 0) {
                    break Label_0046;
                }
            }
            b2.j();
        }
        final m m = (m)b2.d();
        final ai ai2 = (ai)this.q.b(m);
        final I g = this.p.g(d);
        t t;
        t t2;
        if (b) {
            if (ai2.x()) {
                t = new t(n, this.p.p(d).b);
                this.p.c(d, t);
                if (g.pointCount() > 0) {
                    t2 = new t(n, g.getPoint(0).b);
                    g.setPoint(0, t2.a, t2.b);
                }
                else {
                    t2 = new t(n, this.p.q(d).b);
                    this.p.d(d, t2);
                }
            }
            else {
                t = new t(this.p.p(d).a, n);
                this.p.c(d, t);
                if (g.pointCount() > 0) {
                    t2 = new t(g.getPoint(0).a, n);
                    g.setPoint(0, t2.a, t2.b);
                }
                else {
                    t2 = new t(this.p.q(d).a, n);
                    this.p.d(d, t2);
                }
            }
        }
        else if (ai2.x()) {
            t = new t(n, this.p.q(d).b);
            this.p.d(d, t);
            if (g.pointCount() > 0) {
                t2 = new t(n, g.getPoint(g.pointCount() - 1).b);
                g.setPoint(g.pointCount() - 1, t2.a, t2.b);
            }
            else {
                t2 = new t(n, this.p.p(d).b);
                this.p.c(d, t2);
            }
        }
        else {
            t = new t(this.p.q(d).a, n);
            this.p.d(d, t);
            if (g.pointCount() > 0) {
                t2 = new t(g.getPoint(g.pointCount() - 1).a, n);
                g.setPoint(g.pointCount() - 1, t2.a, t2.b);
            }
            else {
                t2 = new t(this.p.p(d).a, n);
                this.p.c(d, t2);
            }
        }
        final m i = new m(t, t2);
        this.q.a(m, null);
        this.q.a(i, (ai != null) ? ai : ai2);
        ae.a(b, i);
    }
    
    private D a(final q q, final d d, final D d2) {
        final int f = y.f.i.v.f;
        final D d3 = new D();
        final C b = ((ae)this.w.b(d)).b();
        b.i();
        final ao ao = (ao)this.q.b(b.d());
        final double q2 = ao.q();
        final aJ aj = (aJ)this.z.b(ao);
        final D d4 = ao.x() ? aj.a : aj.e;
        final D d5 = ao.x() ? aj.c : aj.g;
        if (d4.isEmpty() || d5.isEmpty()) {
            return d3;
        }
        final q q3 = (q)d4.f();
        final q q4 = (q)d5.f();
        final C m = d2.m();
        while (m.f()) {
            final ao ao2 = (ao)m.d();
            if (ao2 != ao && ao2.q() == q2) {
                final aJ aj2 = (aJ)this.z.b(ao2);
                q q5 = null;
                q q6 = null;
                Label_0303: {
                    if (ao.x()) {
                        q5 = (q)aj2.a.f();
                        q6 = (q)aj2.c.f();
                        if (f == 0) {
                            break Label_0303;
                        }
                    }
                    q5 = (q)aj2.e.f();
                    q6 = (q)aj2.g.f();
                }
                if (q3 == q5 && q4 == q6) {
                    d3.add(ao2);
                }
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
        return d3;
    }
    
    private D b(final q q, final d d, final D d2) {
        final int f = y.f.i.v.f;
        final D d3 = new D();
        final C b = ((ae)this.w.b(d)).b();
        ao ao = null;
        m m = null;
        Label_0151: {
            if (q == d.c()) {
                b.i();
                ao = (ao)this.q.b(b.d());
                b.g();
                m = (m)b.d();
                if (f == 0) {
                    break Label_0151;
                }
            }
            b.j();
            ao = (ao)this.q.b(b.d());
            b.h();
            m = (m)b.d();
        }
        final q q2 = (q)this.C.b(this.q.b(m));
        final C i = d2.m();
        while (i.f()) {
            Object o = i.d();
        Label_0202:
            while (true) {
                final ao ao2 = (ao)o;
                if (ao2 != ao) {
                    final x j = ((q)this.C.b(ao2)).m();
                    while (j.f()) {
                        final q q3 = (q)(o = j.e());
                        if (f != 0) {
                            continue Label_0202;
                        }
                        if (q3 == q2) {
                            d3.add(ao2);
                        }
                        j.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            i.g();
            if (f != 0) {
                break;
            }
        }
        return d3;
    }
    
    private void a(final D d, final boolean b) {
        final int f = y.f.i.v.f;
        if (d.isEmpty()) {
            return;
        }
        final C m = d.m();
        while (m.f()) {
            final ai ai = (ai)m.d();
            this.a(ai, b);
            this.a(ai);
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final ai ai) {
        final int i = y.f.i.v.f;
        ai.e();
        final x m = ((q)this.C.b(ai)).m();
        do {
            double f = 0.0;
            Label_0026: {
                f = (m.f() ? 1 : 0);
            }
            Label_0032:
            while (f != 0) {
                final ai ai2 = (ai)this.D.b(m.e());
                if (ai2 != null) {
                    final C a = ai2.a();
                    if (a != null) {
                        while (a.f()) {
                            final aj aj = (aj)a.d();
                            final double n = f = dcmpg(aj.d, ai.t());
                            if (i != 0) {
                                continue Label_0032;
                            }
                            if (n > 0) {
                                if (aj.c < ai.u()) {
                                    ai.b(aj);
                                }
                            }
                            a.g();
                            if (i != 0) {
                                break;
                            }
                        }
                    }
                }
                m.g();
                continue Label_0026;
            }
            break;
        } while (i == 0);
    }
    
    private void a(final ai ai, final boolean b) {
        final int f = y.f.i.v.f;
        final aJ aj = (aJ)this.z.b(ai);
        D d = null;
        Label_0065: {
            if (ai.x()) {
                d = (b ? aj.a : aj.c);
                if (f == 0) {
                    break Label_0065;
                }
            }
            d = (b ? aj.e : aj.g);
        }
        if (!d.isEmpty()) {
            final q q = (q)d.f();
            final C a = ai.a();
            Label_1228: {
                if (a != null && a.k() > 0) {
                    ai.d();
                    ai.b(true);
                    final double b2 = ((aj)a.d()).b;
                    Label_0434: {
                        if (this.a) {
                            Label_0235: {
                                if (this.c) {
                                    final D a2 = this.a(ai.t(), b2 - 1.0, ai.x());
                                    if (a2 != null) {
                                        final C m = a2.m();
                                        while (m.f()) {
                                            ai.a((double)m.d(), ai.q(), b);
                                            m.g();
                                            if (f != 0) {
                                                return;
                                            }
                                            if (f != 0) {
                                                break Label_0235;
                                            }
                                        }
                                    }
                                    break Label_0434;
                                }
                            }
                            final D b3 = ai.b;
                            final double n = ai.t() - this.g;
                            double max = n - 1.0;
                            final C i = b3.m();
                            while (true) {
                                while (i.f()) {
                                    final double b4 = ((ai)i.d()).b();
                                    final double naN;
                                    final int n2 = (int)(naN = (Double.isNaN(b4) ? 1 : 0));
                                    if (f == 0) {
                                        if (n2 == 0) {
                                            max = Math.max(n, b4);
                                        }
                                        i.g();
                                        if (f != 0) {
                                            break;
                                        }
                                        continue;
                                    }
                                    else {
                                        double n3;
                                        if (naN > 0) {
                                            n3 = max + 2.0 * this.g;
                                        }
                                        else {
                                            n3 = ai.t() + this.g;
                                        }
                                        final int n4 = (int)Math.floor((b2 - n3) / (2.0 * this.g));
                                        if (n4 > 0) {
                                            int j = 1;
                                            while (j <= n4) {
                                                ai.a(b2 - j * 2 * this.g, ai.q(), b);
                                                ++j;
                                                if (f != 0) {
                                                    return;
                                                }
                                                if (f != 0) {
                                                    break;
                                                }
                                            }
                                        }
                                        break Label_0434;
                                    }
                                }
                                double naN = dcmpl(max, n);
                                continue;
                            }
                        }
                    }
                    aj aj2 = null;
                    double b5 = b2 - 1.0;
                    double n5 = 0.0;
                    double n6 = 0.0;
                    int n7 = 0;
                    int n8 = 1;
                    while (true) {
                    Label_1126_Outer:
                        while (a.f()) {
                            aj2 = (aj)a.d();
                            final double n9 = dcmpl(aj2.b, b5);
                            if (f == 0) {
                                if (n9 > 0) {
                                    if (n8 == 0 && n7 == 0) {
                                        ai.a(b5, n6 - n5, b).d = true;
                                    }
                                    b5 = aj2.b;
                                    n5 = ai.v();
                                    n6 = ai.w();
                                    n7 = 0;
                                    n8 = 0;
                                }
                                Label_0895: {
                                    if (n7 == 0) {
                                        if (b) {
                                            if (aj2.c == ai.v()) {
                                                final ae ae = (ae)this.w.b(aj2.a);
                                                final boolean b6 = aj2.a.c() == q;
                                                n7 = (((ae.b(b6) || ae.d(b6)) | (aj2.d == ai.w() && ae.c())) ? 1 : 0);
                                                if (f == 0) {
                                                    break Label_0895;
                                                }
                                            }
                                            n6 = Math.min(n6, aj2.c - (this.c ? this.e : (2.0 * this.g)));
                                            n7 = 1;
                                            if (f == 0) {
                                                break Label_0895;
                                            }
                                        }
                                        if (aj2.d == ai.w()) {
                                            final ae ae2 = (ae)this.w.b(aj2.a);
                                            final boolean b7 = aj2.a.c() == q;
                                            n7 = (((ae2.b(b7) || ae2.d(b7)) | (aj2.c == ai.v() && ae2.c())) ? 1 : 0);
                                            if (f == 0) {
                                                break Label_0895;
                                            }
                                        }
                                        n5 = Math.max(n5, aj2.d + (this.c ? this.e : (2.0 * this.g)));
                                        n7 = 1;
                                    }
                                }
                                a.g();
                                if (f != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (n9 == 0) {
                                    ai.a(b5, n6 - n5, b).d = true;
                                }
                                if (this.a) {
                                    Label_1028: {
                                        if (this.c) {
                                            final D a3 = this.a(aj2.b + 1.0, ai.u(), ai.x());
                                            if (a3 != null) {
                                                final C k = a3.m();
                                                while (k.f()) {
                                                    ai.a((double)k.d(), ai.q(), b);
                                                    k.g();
                                                    if (f != 0) {
                                                        break Label_1028;
                                                    }
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    final D c = ai.c;
                                    final double n10 = ai.u() + this.g;
                                    double min = n10 + 1.0;
                                    final C l = c.m();
                                    while (true) {
                                        while (l.f()) {
                                            final double c2 = ((ai)l.d()).c();
                                            final double naN2;
                                            final int n11 = (int)(naN2 = (Double.isNaN(c2) ? 1 : 0));
                                            if (f == 0) {
                                                if (n11 == 0) {
                                                    min = Math.min(n10, c2);
                                                }
                                                l.g();
                                                if (f != 0) {
                                                    break;
                                                }
                                                continue Label_1126_Outer;
                                            }
                                            else {
                                                double n12;
                                                if (naN2 < 0) {
                                                    n12 = min - 2.0 * this.g;
                                                }
                                                else {
                                                    n12 = ai.u() - this.g;
                                                }
                                                final int n13 = (int)Math.floor((n12 - aj2.b) / (2.0 * this.g));
                                                if (n13 > 0) {
                                                    int n14 = 1;
                                                    while (n14 <= n13) {
                                                        ai.a(aj2.b + n14 * 2 * this.g, ai.q(), b);
                                                        ++n14;
                                                        if (f != 0) {
                                                            break Label_1228;
                                                        }
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        double naN2 = dcmpg(min, n10);
                                        continue;
                                    }
                                }
                                return;
                            }
                        }
                        continue;
                    }
                }
            }
            if (this.a) {
                Label_1310: {
                    if (this.c) {
                        final D a4 = this.a((ao)ai);
                        if (a4 != null) {
                            final C m2 = a4.m();
                            while (m2.f()) {
                                ai.a((double)m2.d(), ai.q(), b);
                                m2.g();
                                if (f != 0) {
                                    break Label_1310;
                                }
                            }
                        }
                        return;
                    }
                }
                final D b8 = ai.b;
                final double n15 = ai.t() - this.g;
                double max2 = n15 - 1.0;
                final C m3 = b8.m();
                while (true) {
                Label_1536_Outer:
                    while (m3.f()) {
                        final double b9 = ((ai)m3.d()).b();
                        final double naN3;
                        final int n16 = (int)(naN3 = (Double.isNaN(b9) ? 1 : 0));
                        if (f != 0) {
                            double n17;
                            if (naN3 > 0) {
                                n17 = max2 + 2.0 * this.g;
                            }
                            else {
                                n17 = ai.t() + this.g;
                            }
                            final D c3 = ai.c;
                            final double n18 = ai.u() + this.g;
                            double min2 = n18 + 1.0;
                            final C m4 = c3.m();
                            while (true) {
                                while (m4.f()) {
                                    final double c4 = ((ai)m4.d()).c();
                                    final double naN4;
                                    final int n19 = (int)(naN4 = (Double.isNaN(c4) ? 1 : 0));
                                    if (f == 0) {
                                        if (n19 == 0) {
                                            min2 = Math.min(n18, c4);
                                        }
                                        m4.g();
                                        if (f != 0) {
                                            break;
                                        }
                                        continue Label_1536_Outer;
                                    }
                                    else {
                                        double n20;
                                        if (naN4 < 0) {
                                            n20 = min2 - 2.0 * this.g;
                                        }
                                        else {
                                            n20 = ai.u() - this.g;
                                        }
                                        final int n21 = (int)Math.floor((n20 - n17) / (2.0 * this.g));
                                        if (n21 > 0) {
                                            int n22 = 0;
                                            while (n22 < n21) {
                                                ai.a(n17 + n22 * 2 * this.g, ai.q(), b);
                                                ++n22;
                                                if (f != 0) {
                                                    break;
                                                }
                                            }
                                        }
                                        return;
                                    }
                                }
                                double naN4 = dcmpg(min2, n18);
                                continue;
                            }
                        }
                        if (n16 == 0) {
                            max2 = Math.max(n15, b9);
                        }
                        m3.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    double naN3 = dcmpl(max2, n15);
                    continue;
                }
            }
        }
    }
    
    private D a(final double n, final double n2, final boolean b) {
        final int f = y.f.i.v.f;
        D d = null;
        final double n3 = b ? this.d.a : this.d.b;
        double n4 = (int)Math.floor((n - n3) / this.f) * this.f + n3;
        if (n4 < n) {
            n4 += this.f;
        }
        double n5 = (int)Math.floor((n2 - n3) / this.f) * this.f + n3;
        if (n5 >= n2) {
            n5 -= this.f;
        }
        D d2 = null;
        if (n4 >= n && n5 < n2) {
            d = new D();
            double n6 = n4;
            while (n6 <= n5) {
                d2 = d;
                if (f != 0) {
                    break;
                }
                d2.add(new Double(n6));
                n6 += this.f;
                if (f != 0) {
                    break;
                }
            }
        }
        return d2;
    }
    
    private D a(final ao ao) {
        return this.a(ao.t(), ao.u(), ao.x());
    }
    
    private void a(final q q, final ai ai, final double n, final boolean b, final double n2) {
        final int f = y.f.i.v.f;
        final D a = ai.a(b);
        if (a == null) {
            return;
        }
        final C m = a.m();
        while (m.f()) {
            final ak ak = (ak)m.d();
            Label_0193: {
                if (ak.a == n2 && q.e() == this.u && ak.c.e() == this.u) {
                    this.u.a(q, ak.c);
                    if (f == 0) {
                        break Label_0193;
                    }
                }
                if (ak.b >= n) {
                    final double n3 = b ? (ai.v() + n) : (ai.w() - n);
                    final aM am = (aM)this.t.b(q);
                    if (q.e() == this.u && ak.c.e() == this.u) {
                        this.u.a(q, ak.c);
                    }
                }
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final q q, final ai ai, final double n, final boolean b) {
        final int f = y.f.i.v.f;
        final D a = ai.a(b);
        if (a == null) {
            return;
        }
        final C m = a.m();
        while (m.f()) {
            final ak ak = (ak)m.d();
            if (ak.b >= n && !ai.a(ak.a, b ? (ai.v() + n) : (ai.w() - n), (d)((aM)this.t.b(q)).a()) && q.e() == this.u && ak.c.e() == this.u) {
                this.u.a(q, ak.c);
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final D d, final double n) {
        final int f = y.f.i.v.f;
        int n2 = 0;
        p p2 = d.k();
        int n3 = 0;
        Label_0124: {
            while (p2 != null) {
                n3 = n2;
                if (f != 0 || n3 != 0) {
                    break Label_0124;
                }
                final aN an = (aN)p2.c();
                final double a = an.a;
                if (a < n) {
                    p2 = d.c(p2);
                    if (f == 0) {
                        continue;
                    }
                }
                if (a == n) {
                    final aN an2 = an;
                    ++an2.c;
                    n2 = 1;
                    if (f == 0) {
                        continue;
                    }
                }
                p2 = d.a(new aN(n, 0, 1), p2);
                n2 = 1;
                if (f != 0) {
                    goto Label_0122;
                }
            }
            goto Label_0122;
        }
        if (n3 == 0) {
            d.add(new aN(n, 0, 1));
        }
    }
    
    private void b(final D d, final double n) {
        final int f = y.f.i.v.f;
        int n2 = 0;
        p p2 = d.k();
        while (p2 != null && n2 == 0) {
            final aN an = (aN)p2.c();
            if (an.a <= n) {
                final aN an2 = an;
                ++an2.b;
                p2 = d.c(p2);
                if (f == 0) {
                    continue;
                }
            }
            n2 = 1;
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final D d, final double n, final double n2) {
        final int f = y.f.i.v.f;
        boolean b = false;
        final C m = d.m();
        while (m.f() && !b) {
            final aN an = (aN)m.d();
            if (an.a <= n) {
                final aN an2 = an;
                --an2.b;
            }
            if (an.a == n2) {
                final aN an3 = an;
                --an3.c;
            }
            if (an.c == 0) {
                d.b(m);
            }
            b = (an.a > n);
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private boolean b(final D d, final double n, final double n2) {
        final int f = y.f.i.v.f;
        boolean b = true;
        int n3 = 0;
        final C m = d.m();
        m.j();
        while (m.f()) {
            final boolean b2 = b;
            if (f != 0 || !b2) {
                return b2;
            }
            final aN an = (aN)m.d();
            int b3 = an.b;
            int c = an.c;
            if (an.a <= n) {
                --b3;
            }
            if (an.a == n2) {
                --c;
            }
            n3 += c;
            if (c > 0 && b3 < n3) {
                b = false;
            }
            if (b3 < c) {
                b = false;
            }
            m.h();
            if (f != 0) {
                goto Label_0141;
            }
        }
        goto Label_0141;
    }
    
    private void a(final y y) {
        final int i = y.f.i.v.f;
        final x a = y.a();
        do {
            Label_0010: {
                a.f();
            }
            boolean d = false;
            Label_0016:
            while (d) {
                final q e = a.e();
                final aM am = (aM)this.t.b(e);
                final d a2 = e.j().a();
                final q a3 = a2.a(e);
                this.a(this.F, ((aM)this.t.b(a3)).c(), am.c());
                this.s.a(a2, true);
                this.r.a(e, true);
                this.r.a(a3, true);
                y.b(a);
                final e j = a3.j();
                while (j.f()) {
                    final d a4 = j.a();
                    d = this.s.d(a4);
                    if (i != 0) {
                        continue Label_0016;
                    }
                    if (!d) {
                        final q a5 = a2.a(a3);
                        this.u.a(a4);
                        if (!this.r.d(a5) && a5.a() == 1) {
                            y.add(a5);
                        }
                    }
                    j.g();
                    if (i != 0) {
                        break;
                    }
                }
                a.g();
                continue Label_0010;
            }
            break;
        } while (i == 0);
    }
    
    static h a(final aK ak) {
        return ak.v;
    }
    
    static A b(final aK ak) {
        return ak.t;
    }
    
    static A c(final aK ak) {
        return ak.r;
    }
    
    static void a(final aK ak, final D d, final double n) {
        ak.a(d, n);
    }
    
    static void b(final aK ak, final D d, final double n) {
        ak.b(d, n);
    }
}
