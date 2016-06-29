package y.f.a;

import y.f.b.*;
import y.f.k.*;
import y.g.*;
import y.d.*;
import y.f.*;
import y.c.*;
import java.awt.geom.*;
import java.awt.*;
import java.util.*;

public class a extends c
{
    public static final Object n;
    public static final Object o;
    private byte p;
    private X q;
    private f r;
    private x s;
    private byte t;
    private boolean u;
    private boolean v;
    private boolean w;
    private A x;
    
    public a() {
        final int u = y.f.a.f.u;
        this.p = 0;
        this.t = 0;
        this.u = false;
        this.v = true;
        this.w = false;
        Label_0119: {
            if (this.t == 0) {
                this.r = new f();
                if (u == 0) {
                    break Label_0119;
                }
            }
            if (this.t == 1) {
                this.r = new j();
                ((j)this.r).i(false);
                if (u == 0) {
                    break Label_0119;
                }
            }
            if (this.t == 2) {
                this.r = new j();
                ((j)this.r).i(true);
            }
        }
        this.s = new x();
        ((aN)this.c()).a((byte)1);
        final ad f = this.f();
        if (f instanceof b) {
            ((b)f).a(false);
        }
    }
    
    public void b(final byte p) {
        this.p = p;
    }
    
    public byte a() {
        return this.p;
    }
    
    public f n() {
        return this.r;
    }
    
    public o o() {
        return this.s;
    }
    
    public void c(final byte t) {
        final int u = y.f.a.f.u;
        this.t = t;
        if (t == 0) {
            this.r = new f();
            if (u == 0) {
                return;
            }
        }
        if (t == 1) {
            this.r = new j();
            ((j)this.r).i(false);
            if (u == 0) {
                return;
            }
        }
        if (t == 2) {
            this.r = new j();
            ((j)this.r).i(true);
        }
    }
    
    public boolean b(final X x) {
        return true;
    }
    
    private void a(final X x, final s s) {
        final int i = y.f.a.f.u;
        final y.c.c c = x.c(a.n);
        if (c != null) {
            final boolean b = c instanceof y.c.a;
            int n = 0;
            Label_0195: {
                if (s != null) {
                    s.P();
                    final y.c.x o = s.o();
                    while (true) {
                        do {
                            Label_0040: {
                                o.f();
                            }
                            boolean b2 = false;
                            Label_0047:
                            while (b2) {
                                final q e = o.e();
                                s.v(e);
                                if (i == 0) {
                                    final y.c.x o2 = x.o();
                                    while (o2.f()) {
                                        final q e2 = o2.e();
                                        b2 = b;
                                        if (i != 0) {
                                            continue Label_0047;
                                        }
                                        Label_0153: {
                                            if (b2) {
                                                ((y.c.a)c).a(e2, n);
                                                if (i == 0) {
                                                    break Label_0153;
                                                }
                                            }
                                            final Object b3 = c.b(e2);
                                            if (b3 instanceof L) {
                                                ((L)b3).a(n);
                                            }
                                        }
                                        o2.g();
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                    ++n;
                                    s.w(e);
                                    o.g();
                                    continue Label_0040;
                                }
                                if (i != 0) {
                                    break Label_0195;
                                }
                                return;
                            }
                            break;
                        } while (i == 0);
                        s.Q();
                        continue;
                    }
                }
            }
            final y.c.x o3 = x.o();
            while (o3.f()) {
                final q e3 = o3.e();
                Label_0273: {
                    if (b) {
                        ((y.c.a)c).a(e3, n);
                        if (i == 0) {
                            break Label_0273;
                        }
                    }
                    final Object b4 = c.b(e3);
                    if (b4 instanceof L) {
                        ((L)b4).a(n);
                    }
                }
                o3.g();
                if (i != 0) {
                    break;
                }
            }
        }
    }
    
    public void a(final X q) {
        if (q.f() < 2) {
            return;
        }
        this.q = q;
        this.r.g(this.u);
        this.s.g(this.u);
        this.x = q.t();
        Label_0151: {
            if (this.a() == 3) {
                A q2 = null;
                if (this.w) {
                    q2 = this.q();
                    this.a(q2);
                }
                this.r.a(q);
                if (this.w) {
                    this.r();
                    y p = new y(q.o());
                    if (this.r instanceof j) {
                        p = ((j)this.r).p();
                    }
                    this.a(p, p, q2);
                }
                this.a(q, null);
                if (y.f.a.f.u == 0) {
                    break Label_0151;
                }
            }
            this.p();
        }
        q.a(this.x);
    }
    
    private A q() {
        final int i = y.f.a.f.u;
        final A a = M.a();
        final y.c.x o = this.q.o();
        do {
            Label_0017: {
                o.f();
            }
            boolean b = false;
            Label_0023:
            while (b) {
                final q e = o.e();
                final y.d.y s = this.q.s(e);
                final aj[] a_ = this.q.a_(e);
                final D d = new D();
                int j = 0;
                while (j < a_.length) {
                    final y.d.y box = a_[j].getBox();
                    b = s.b(box);
                    if (i != 0) {
                        continue Label_0023;
                    }
                    if (!b) {
                        d.add(new y.f.a.c(this, null, e, box));
                    }
                    ++j;
                    if (i != 0) {
                        break;
                    }
                }
                a.a(e, d);
                o.g();
                continue Label_0017;
            }
            break;
        } while (i == 0);
        return a;
    }
    
    private void a(final y y, final y y2, final A a) {
        final int u = y.f.a.f.u;
        if (y.size() < 2) {
            return;
        }
        final A a2 = M.a();
        final y.c.x a3 = y.a();
        while (true) {
            while (a3.f()) {
                a2.a(a3.e(), true);
                final y.c.x x = a3;
                if (u != 0) {
                    final t a4 = a(x, this.q);
                    final double a5 = y.d.t.a(a4, this.q.l(y.b()));
                    final A a6 = M.a();
                    int i = 0;
                    while (true) {
                        while (i < 20) {
                            final a a7 = this;
                            final y y3 = y2;
                            final A a8 = a2;
                            if (u != 0) {
                                a7.a(y3, a8);
                                final double n = 1.0 - 5.0 / a5;
                                int j = 0;
                                while (true) {
                                    while (j < 10) {
                                        final a a9 = this;
                                        final y y4 = y2;
                                        final A a10 = a2;
                                        if (u != 0) {
                                            a9.a(y4, a10);
                                            return;
                                        }
                                        if (this.a(y2, a10, a, a4, n, a6)) {
                                            break;
                                        }
                                        ++j;
                                        if (u != 0) {
                                            break;
                                        }
                                    }
                                    final a a9 = this;
                                    final y y4 = y;
                                    continue;
                                }
                            }
                            if (this.a(y2, a8, a, a4, 0.9, a6)) {
                                break;
                            }
                            ++i;
                            if (u != 0) {
                                break;
                            }
                        }
                        final a a7 = this;
                        final y y3 = y;
                        continue;
                    }
                }
                x.g();
                if (u != 0) {
                    break;
                }
            }
            y.a();
            continue;
        }
    }
    
    private void a(final y y, final A a) {
        final int u = y.f.a.f.u;
        final y.c.x a2 = y.a();
        while (a2.f()) {
            final q e = a2.e();
            this.q.a(e, (t)a.b(e));
            a2.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    private static y.d.y a(final y.d.y y, final double n) {
        return new y.d.y(y.c() - n, y.d() - n, y.a() + 2.0 * n, y.b() + 2.0 * n);
    }
    
    private boolean a(final y y, final A a, final A a2, final t t, final double n, final A a3) {
        final int u = y.f.a.f.u;
        final double n2 = this.r.a();
        final double min = Math.min(n2, 2.0);
        final D d = new D();
        final y.c.x a4 = y.a();
        while (a4.f()) {
            final q e = a4.e();
            if (a.d(e)) {
                final t l = this.q.l(e);
                a3.a(e, l);
                this.q.a(e, new t((l.a() - t.a()) * n, (l.b() - t.b()) * n));
            }
            final y.d.y s = this.q.s(e);
            d.add(new e(a(s, n2 * 0.5), s, e, (byte)0));
            final D d2 = (D)a2.b(e);
            Label_0283: {
                if (d2 != null) {
                    final C m = d2.m();
                    while (m.f()) {
                        final y.d.y a5 = ((y.f.a.c)m.d()).a();
                        d.add(new e(a(a5, min * 0.5), a5, e, (byte)1));
                        m.g();
                        if (u != 0) {
                            break Label_0283;
                        }
                        if (u != 0) {
                            break;
                        }
                    }
                }
                a4.g();
            }
            if (u != 0) {
                break;
            }
        }
        final d d3 = new d(n2, min, a);
        y.d.f.a(d, d3);
        return d3.a();
    }
    
    private static t a(final y.c.x x, final X x2) {
        if (x.k() < 2) {
            return null;
        }
        if (x.k() == 2) {
            final t l = x2.l(x.e());
            x.g();
            return t.c(l, x2.l(x.e()));
        }
        final t i = x2.l(x.e());
        x.g();
        final t j = x2.l(x.e());
        x.g();
        final t k = x2.l(x.e());
        return y.d.a.a(new y.d.a(t.c(i, j), z.c(new z(i, j))), new y.d.a(t.c(j, k), z.c(new z(j, k))));
    }
    
    void p() {
        final int u = y.f.a.f.u;
        ae.a(this.q);
        ae.c(this.q);
        final s s = new s(this.q);
        s.a(this.p);
        this.a(this.q, s);
        A q = null;
        if (this.w) {
            q = this.q();
            this.a(q);
        }
        final q n = s.N();
        final h u2 = s.u();
        if (this.u) {
            this.a(s, u2);
        }
        final A t = s.t();
        s.P();
        final y.c.x o = s.o();
        while (true) {
        Label_0658_Outer:
            while (o.f()) {
                final q e = o.e();
                s.v(e);
                if (u != 0) {
                    final A t2 = s.t();
                    final h u3 = s.u();
                    this.a(s, u3, t2);
                    this.a(s, u3, u2, n);
                    final double a = this.a(s, n, u3, u2);
                    this.s.a(u3, t2);
                    if (this.u) {
                        this.s.a(u2);
                    }
                    this.s.a(s);
                    this.a(s, n, t2);
                    s s2 = null;
                    Label_1874: {
                    Label_0658:
                        while (true) {
                            y.c.x x = null;
                            int size = 0;
                            Label_0665: {
                                if (this.w) {
                                    this.r();
                                    x = s.o();
                                    while (x.f()) {
                                        final q e2 = x.e();
                                        final y t3 = s.t(e2);
                                        size = t3.size();
                                        if (u != 0) {
                                            break Label_0665;
                                        }
                                        if (size > 1) {
                                            this.a((t.b(e2) != null) ? ((y)t.b(e2)) : t3, t3, q);
                                        }
                                        x.g();
                                        if (u != 0) {
                                            break;
                                        }
                                    }
                                    this.a(s);
                                }
                                s.a(t);
                                x = s.o();
                                x.f();
                            }
                            if (size != 0) {
                                final q e3 = x.e();
                                final t l = s.l(e3);
                                s2 = s;
                                if (u == 0) {
                                    final y.c.x a2 = s2.t(e3).a();
                                    while (true) {
                                        while (a2.f()) {
                                            final q e4 = a2.e();
                                            this.q.a(e4, l.a() + this.q.j(e4), l.b() + this.q.k(e4));
                                            a2.g();
                                            if (u == 0) {
                                                if (u != 0) {
                                                    break;
                                                }
                                                continue Label_0658_Outer;
                                            }
                                            else {
                                                if (u != 0) {
                                                    break Label_0658;
                                                }
                                                continue Label_0658;
                                            }
                                        }
                                        x.g();
                                        continue;
                                    }
                                }
                                break Label_1874;
                            }
                            break;
                        }
                        if (this.u && a != 0.0) {
                            final Rectangle2D a3 = ae.a(this.q, s.t(n).a());
                            final double centerX = a3.getCenterX();
                            final double centerY = a3.getCenterY();
                            final y.f.j.a a4 = new y.f.j.a();
                            y.f.j.a.c(this.q, -centerX, -centerY);
                            y.f.j.a.c(s, -centerX, -centerY);
                            a4.a(2);
                            a4.a(-a);
                            a4.a(this.q);
                            a4.a(s);
                            y.f.j.a.c(this.q, centerX, centerY);
                            y.f.j.a.c(s, centerX, centerY);
                        }
                        if (!this.v) {
                            final A t4 = s.t();
                            final y.c.x o2 = s.o();
                            while (o2.f()) {
                                final q e5 = o2.e();
                                t4.a(e5, s.l(e5));
                                o2.g();
                                if (u != 0) {
                                    return;
                                }
                                if (u != 0) {
                                    break;
                                }
                            }
                            final A t5 = s.t();
                            s.a("NODE_SHAPE_DP", t5);
                            final A t6 = s.t();
                            s.a("NODE_TO_LABEL_BOXES", t6);
                            final y.c.x o3 = s.o();
                            while (true) {
                                while (o3.f()) {
                                    final q e6 = o3.e();
                                    final s s3 = s;
                                    if (u != 0) {
                                        final h u4 = s3.u();
                                        s.a("EDGE_TO_MULTI_EDGES", u4);
                                        final y.c.e p = s.p();
                                    Label_1699_Outer:
                                        while (true) {
                                        Label_1699:
                                            while (true) {
                                                while (p.f()) {
                                                    final y.c.d a5 = p.a();
                                                    final y.c.f i = s.i(a5);
                                                    if (u != 0) {
                                                        final y.c.x x2 = s.o();
                                                        s s4 = null;
                                                        Label_1869: {
                                                        Label_1671:
                                                            while (true) {
                                                                if (x2.f()) {
                                                                    final q q2 = x2.e();
                                                                    final Object b = t4.b(q2);
                                                                    final t t7 = (t)b;
                                                                    final double n2 = s.j(q2) - t7.a();
                                                                    final double n3 = s.k(q2) - t7.b();
                                                                    s4 = s;
                                                                    if (u == 0) {
                                                                        final y.c.x a6 = s4.t(q2).a();
                                                                        while (true) {
                                                                            while (a6.f()) {
                                                                                final q e7 = a6.e();
                                                                                this.q.a(e7, n2 + this.q.j(e7), n3 + this.q.k(e7));
                                                                                a6.g();
                                                                                if (u == 0) {
                                                                                    if (u != 0) {
                                                                                        break;
                                                                                    }
                                                                                    continue Label_0658_Outer;
                                                                                }
                                                                                else {
                                                                                    if (u != 0) {
                                                                                        break Label_1671;
                                                                                    }
                                                                                    continue Label_1671;
                                                                                }
                                                                            }
                                                                            x2.g();
                                                                            continue;
                                                                        }
                                                                    }
                                                                    break Label_1869;
                                                                }
                                                                break;
                                                            }
                                                            s.a(t4);
                                                            s.d_("NODE_SHAPE_DP");
                                                            s.a(t5);
                                                            s.d_("NODE_TO_LABEL_BOXES");
                                                            s.a(t6);
                                                            s.d_("EDGE_TO_MULTI_EDGES");
                                                        }
                                                        s4.a(u4);
                                                        break Label_1874;
                                                    }
                                                    if (i != null && !i.isEmpty()) {
                                                        final y.c.d d = i.d();
                                                        a5.c();
                                                        s.x(d.c());
                                                        D d2 = null;
                                                    Label_1206:
                                                        while (true) {
                                                            q c = null;
                                                            q x3 = null;
                                                            final q q3 = (c == x3) ? d.c() : d.d();
                                                            final q q4 = (a5.d() == s.x(d.d())) ? d.d() : d.c();
                                                            s.c(a5, this.q.l(q3));
                                                            s.d(a5, this.q.l(q4));
                                                            d2 = new D();
                                                            final y.c.e a7 = i.a();
                                                            while (a7.f()) {
                                                                final y.c.d a8 = a7.a();
                                                                c = a5.c();
                                                                x3 = s.x(a8.c());
                                                                if (u != 0) {
                                                                    continue Label_1206;
                                                                }
                                                                d2.add(new y.f.a.C(a5, this.q.l((c == x3) ? a8.c() : a8.d()), this.q.l((a5.d() == s.x(a8.d())) ? a8.d() : a8.c())));
                                                                a7.g();
                                                                if (u != 0) {
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        }
                                                        u4.a(a5, d2);
                                                    }
                                                    p.g();
                                                    if (u != 0) {
                                                        break;
                                                    }
                                                }
                                                if (this.w) {
                                                    final y.c.x x2 = this.q.o();
                                                    while (x2.f()) {
                                                        final q q2 = x2.e();
                                                        final D d3 = (D)q.b(q2);
                                                        final Object b;
                                                        final t t8 = (t)(b = d3);
                                                        if (u != 0) {
                                                            continue Label_1699;
                                                        }
                                                        Label_1651: {
                                                            if (t8 != null) {
                                                                final q x4 = s.x(q2);
                                                                final t j = s.l(x4);
                                                                final C m = d3.m();
                                                                while (m.f()) {
                                                                    final y.d.y a9 = ((y.f.a.c)m.d()).a();
                                                                    ((D)t6.b(x4)).add(new y.d.y(a9.c() - j.a(), a9.d() - j.b(), a9.a(), a9.b()));
                                                                    m.g();
                                                                    if (u != 0) {
                                                                        break Label_1651;
                                                                    }
                                                                    if (u != 0) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            x2.g();
                                                        }
                                                        if (u != 0) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                break;
                                            }
                                            this.a(s, this.s);
                                            continue Label_1699_Outer;
                                        }
                                    }
                                    Label_1091: {
                                        if (s3.t(e6).size() > 1) {
                                            a(e6, s, this.q);
                                            t5.a(e6, 1);
                                            if (u == 0) {
                                                break Label_1091;
                                            }
                                        }
                                        t5.a(e6, 0);
                                    }
                                    t6.a(e6, new D());
                                    o3.g();
                                    if (u != 0) {
                                        break;
                                    }
                                }
                                continue;
                            }
                        }
                    }
                    s2.L();
                    return;
                }
                Label_0423: {
                    if (this.q.e() > 1) {
                        if (this.r instanceof j) {
                            ((j)this.r).a(s.u(e));
                        }
                        Label_0269: {
                            if (this.u) {
                                if (e == n) {
                                    this.r.b(0.0);
                                    if (u == 0) {
                                        break Label_0269;
                                    }
                                    y.c.i.g = !y.c.i.g;
                                }
                                double a10 = a(u2.c(e.g()));
                                Label_0260: {
                                    if (a10 > 0.0) {
                                        a10 = 3.141592653589793 - a10;
                                        if (u == 0) {
                                            break Label_0260;
                                        }
                                    }
                                    a10 = -3.141592653589793 - a10;
                                }
                                this.r.b(a10);
                            }
                        }
                        this.r.a(3.141592653589793 / this.q.e());
                        this.r.a(this.q);
                        final Rectangle a11 = this.q.a();
                        s.b(e, a11.width, a11.height);
                        if (!(this.r instanceof j)) {
                            break Label_0423;
                        }
                        t.a(e, ((j)this.r).p());
                        if (u == 0) {
                            break Label_0423;
                        }
                    }
                    if (this.q.e() == 1) {
                        final q k = this.q.k();
                        s.a(e, this.q.r(k));
                        this.q.a(k, 0.0, 0.0);
                        if (u == 0) {
                            break Label_0423;
                        }
                    }
                    s.b(e, 1.0, 1.0);
                }
                s.w(e);
                o.g();
                if (u != 0) {
                    break;
                }
            }
            s.Q();
            continue;
        }
    }
    
    private static void a(final q q, final s s, final X x) {
        final int u = f.u;
        final t l = s.l(q);
        double max = 0.0;
        final y.c.x a = s.t(q).a();
        while (a.f()) {
            max = Math.max(max, a(x.s(a.e()), l));
            a.g();
            if (u != 0) {
                return;
            }
            if (u != 0) {
                break;
            }
        }
        s.b(q, Math.max(s.p(q), 2.0 * max), Math.max(s.q(q), 2.0 * max));
        s.a(q, l);
    }
    
    private static double a(final y.d.y y, final t t) {
        return Math.max(Math.max(Math.max(t.a(t, y.e()), t.a(t, new t(y.c() + y.a(), y.d() + y.b()))), t.a(t, new t(y.c(), y.d() + y.b()))), t.a(t, new t(y.c() + y.a(), y.d())));
    }
    
    private void a(final A a) {
        final int u = y.f.a.f.u;
        final y.c.x o = this.q.o();
    Label_0120_Outer:
        while (o.f()) {
            final q e = o.e();
            y.d.y y = this.q.s(e);
            final Iterator iterator = ((D)a.b(e)).iterator();
            while (true) {
                while (iterator.hasNext()) {
                    y = y.f.a.t.a(y, iterator.next().a());
                    if (u == 0) {
                        if (u != 0) {
                            break;
                        }
                        continue Label_0120_Outer;
                    }
                    else {
                        final t l = this.q.l(e);
                        this.q.b(e, 2.0 * Math.floor(Math.max(l.a() - y.c(), y.c() + y.a() - l.a()) + 1.0E-5), 2.0 * Math.floor(Math.max(l.b() - y.d(), y.d() + y.b() - l.b()) + 1.0E-5));
                        this.q.a(e, l);
                        o.g();
                        if (u != 0) {
                            break Label_0120_Outer;
                        }
                        continue Label_0120_Outer;
                    }
                }
                this.x.a(e, this.q.r(e));
                continue;
            }
        }
    }
    
    private void r() {
        final int u = y.f.a.f.u;
        final y.c.x o = this.q.o();
        while (o.f()) {
            final q e = o.e();
            final t l = this.q.l(e);
            this.q.a(e, (y.d.q)this.x.b(e));
            this.q.a(e, l);
            o.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    private void a(final s s) {
        final int u = y.f.a.f.u;
        final y.c.x o = s.o();
    Label_0122_Outer:
        while (o.f()) {
            final q e = o.e();
            final t l = s.l(e);
            final y t = s.t(e);
            y.d.y a = null;
            final y.c.x a2 = t.a();
            while (true) {
                while (a2.f()) {
                    a = y.f.a.t.a(a, this.a(a2.e(), l));
                    a2.g();
                    if (u != 0) {
                        final double n = l.a() - s.j(e);
                        final double n2 = l.b() - s.k(e);
                        final y.c.x a3 = t.a();
                        while (true) {
                            while (a3.f()) {
                                final q e2 = a3.e();
                                final t i = this.q.l(e2);
                                this.q.a(e2, i.a() + n, i.b() + n2);
                                a3.g();
                                if (u == 0) {
                                    if (u != 0) {
                                        break;
                                    }
                                    continue Label_0122_Outer;
                                }
                                else {
                                    if (u != 0) {
                                        break Label_0122_Outer;
                                    }
                                    continue Label_0122_Outer;
                                }
                            }
                            o.g();
                            continue;
                        }
                    }
                    if (u != 0) {
                        break;
                    }
                }
                s.a(e, a);
                s.b(e, a.e());
                continue;
            }
        }
    }
    
    private y.d.y a(final q q, final t t) {
        final y.d.y s = this.q.s(q);
        return new y.d.y(t.a() + s.c(), t.b() + s.d(), s.a(), s.b());
    }
    
    private void a(final s s, final x x) {
        final y.f.a.z z = new y.f.a.z();
        z.a(x.r());
        z.b(x.a());
        z.c(s);
        z.c(s);
    }
    
    private void a(final s s, final h h) {
        final int u = y.f.a.f.u;
        final t[] array = new t[s.e()];
        y.c.x x = s.o();
    Label_0260:
        while (true) {
            q q;
            y t;
            t t2;
            int n;
            double n2;
            double n3;
            y.c.e j;
            q a;
            t t3;
            double a2;
            double b;
            y.c.d d;
            y.c.f i;
            y y;
            y.c.e a3;
            y.c.d a4;
            q c;
            q d2;
            q x2;
            t t4;
            double n4;
            double atan2;
            t t5;
            Label_0286_Outer:Label_0577_Outer:
            while (x.f()) {
                q = x.e();
                t = s.t(q);
                t2 = array[q.d()];
                while (true) {
                    Label_0570: {
                    Label_0286:
                        while (true) {
                            if (u == 0) {
                                Label_0242: {
                                    if (t2 == null) {
                                        if (t.size() > 0) {
                                            array[q.d()] = this.a(t);
                                            if (u == 0) {
                                                break Label_0242;
                                            }
                                        }
                                        n = 0;
                                        n2 = 0.0;
                                        n3 = 0.0;
                                        j = q.j();
                                        while (j.f()) {
                                            a = j.a().a(q);
                                            t3 = array[a.d()];
                                            if (u != 0) {
                                                break Label_0286;
                                            }
                                            if (t3 != null) {
                                                array[a.d()] = this.a(s.t(a));
                                            }
                                            n2 += array[a.d()].a();
                                            n3 += array[a.d()].b();
                                            j.g();
                                            ++n;
                                            if (u != 0) {
                                                break;
                                            }
                                        }
                                        array[q.d()] = new t(n2 / n, n3 / n);
                                    }
                                }
                                x.g();
                                if (u != 0) {
                                    break;
                                }
                                continue Label_0286_Outer;
                            }
                            a2 = t2.a();
                            b = array[q.d()].b();
                            d = q.f();
                        Label_0310:
                            while (d != null) {
                                i = s.i(d);
                                y = new y();
                                if (u == 0) {
                                    a3 = i.a();
                                    while (true) {
                                        while (a3.f()) {
                                            a4 = a3.a();
                                            c = a4.c();
                                            d2 = a4.d();
                                            x2 = s.x(c);
                                            if (u == 0) {
                                                Label_0414: {
                                                    if (x2 == q) {
                                                        y.add(c);
                                                        if (u == 0) {
                                                            break Label_0414;
                                                        }
                                                    }
                                                    y.add(d2);
                                                }
                                                a3.g();
                                                if (u != 0) {
                                                    break;
                                                }
                                                continue Label_0286_Outer;
                                            }
                                            else {
                                                t4 = ((x2.b() > 0) ? array[q.g().c().d()] : null);
                                                n4 = ((t4 == null) ? 3.141592653589793 : Math.atan2(t4.b() - b, -(t4.a() - a2)));
                                                atan2 = Math.atan2(array[d.d().d()].b() - b, -(array[d.d().d()].a() - a2));
                                                if (atan2 < n4) {
                                                    atan2 += 6.283185307179586;
                                                }
                                                h.a(d, atan2);
                                                d = d.g();
                                                if (u != 0) {
                                                    break Label_0570;
                                                }
                                                continue Label_0310;
                                            }
                                        }
                                        continue Label_0577_Outer;
                                    }
                                }
                                if (u != 0) {
                                    return;
                                }
                                break Label_0260;
                            }
                            break Label_0570;
                            if (x.f()) {
                                q = x.e();
                                t5 = array[q.d()];
                                continue Label_0286;
                            }
                            break;
                        }
                        return;
                    }
                    x.g();
                    continue;
                }
            }
            x = s.o();
            continue Label_0260;
        }
    }
    
    void a(final i i, final h h, final h h2, final q q) {
        final int u = y.f.a.f.u;
        final y.f.a.b b = new y.f.a.b(this, h, h2, q);
        final y.c.x o = i.o();
        while (o.f()) {
            o.e().b(b);
            o.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    double a(final s s, final q q, final h h, final h h2) {
        final int u = y.f.a.f.u;
        if (s.t(q).size() > 1) {
            double n = 0.0;
            double n2 = 0.0;
            double n3 = 0.0;
            final y.c.e l = q.l();
            while (true) {
                while (l.f()) {
                    final double c = h.c(l.a());
                    final double n4 = dcmpl(c - n, n2);
                    if (u != 0) {
                        if (n4 > 0) {
                            n3 = (360.0 + n) / 2.0;
                        }
                        this.a(s, q, n3);
                        final y.c.e i = q.l();
                        double n5 = 0.0;
                    Label_0225_Outer:
                        while (i.f()) {
                            final y.c.d a = i.a();
                            n5 = h.c(a) - n3;
                            if (u == 0) {
                                double n6 = n5;
                                while (true) {
                                    while (n6 < 0.0) {
                                        n6 += 360.0;
                                        if (u == 0) {
                                            if (u != 0) {
                                                break;
                                            }
                                            continue Label_0225_Outer;
                                        }
                                        else {
                                            if (this.u) {
                                                h2.a(a, h2.c(a) - n3);
                                            }
                                            i.g();
                                            if (u != 0) {
                                                break Label_0225_Outer;
                                            }
                                            continue Label_0225_Outer;
                                        }
                                    }
                                    h.a(a, n6);
                                    continue;
                                }
                            }
                            return n5;
                        }
                        q.b(new y.f.a.b(this, h, h2, q));
                        return n5;
                    }
                    if (n4 > 0) {
                        n2 = c - n;
                        n3 = (n + c) / 2.0;
                    }
                    n = c;
                    l.g();
                    if (u != 0) {
                        break;
                    }
                }
                final double n7 = dcmpl(360.0 - n, n2);
                continue;
            }
        }
        return 0.0;
    }
    
    void a(final s s, final q q, final A a) {
        final int u = y.f.a.f.u;
        final t l = s.l(q);
        final y.c.e i = q.l();
        while (i.f()) {
            final q d = i.a().d();
            final t j = s.l(d);
            double b = y.d.e.b(Math.atan2(j.b() - l.b(), j.a() - l.a()));
            if (a.b(d) != null) {
                b += a.c(d);
            }
            this.a(s, d, b);
            this.a(s, d, a);
            i.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    void a(final s s, final q q, double a) {
        final int u = y.f.a.f.u;
        a = y.d.e.a(a);
        final y t = s.t(q);
        if (t.size() <= 1) {
            return;
        }
        final y.c.x a2 = t.a();
        while (a2.f()) {
            final q e = a2.e();
            final double j = this.q.j(e);
            final double k = this.q.k(e);
            final double cos = Math.cos(a);
            final double sin = Math.sin(a);
            this.q.a(e, j * cos - sin * k, j * sin + cos * k);
            a2.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    void a(final s s, final h h, final A a) {
        final int u = y.f.a.f.u;
        final int[] array = new int[this.q.f()];
        final y.c.x o = s.o();
    Label_0022:
        while (true) {
        Label_0117_Outer:
            while (o.f()) {
                final q e = o.e();
                final s s2 = s;
                if (u == 0) {
                    final y.c.x a2 = s.t(e).a();
                    while (true) {
                        while (a2.f()) {
                            array[a2.e().d()] = e.d();
                            a2.g();
                            if (u == 0) {
                                if (u != 0) {
                                    break;
                                }
                                continue Label_0117_Outer;
                            }
                            else {
                                if (u != 0) {
                                    break Label_0117_Outer;
                                }
                                continue Label_0022;
                            }
                        }
                        o.g();
                        continue;
                    }
                }
                this.a(s, s2.N(), array, h, a);
                return;
            }
            final s s2 = s;
            continue;
        }
    }
    
    void a(final s s, final q q, final int[] array, final h h, final A a) {
        final int u = y.f.a.f.u;
        final int d = q.d();
        final double c = a.c(q);
        final y.c.e l = q.l();
        while (l.f()) {
            final y.c.d a2 = l.a();
            final y.c.f i = s.i(a2);
            final int size = s.t(a2.d()).size();
            double n2 = 0.0;
            double n3 = 0.0;
            double n4 = 0.0;
            double n5 = 0.0;
        Label_0071:
            while (true) {
                int n = 0;
                if (size > n && i.size() == size) {
                    i.remove(0);
                }
                n2 = 0.0;
                n3 = 0.0;
                n4 = 0.0;
                n5 = 0.0;
                final y.c.e a3 = i.a();
                while (a3.f()) {
                    final y.c.d a4 = a3.a();
                    final int n6 = array[a4.c().d()];
                    n = d;
                    if (u != 0) {
                        continue Label_0071;
                    }
                    q q2;
                    q q3;
                    if (n6 == n) {
                        q2 = a4.c();
                        q3 = a4.d();
                    }
                    else {
                        q2 = a4.d();
                        q3 = a4.c();
                    }
                    n4 -= this.q.j(q2);
                    n5 += this.q.k(q2);
                    n2 -= this.q.j(q3);
                    n3 += this.q.k(q3);
                    a3.g();
                    if (u != 0) {
                        break;
                    }
                }
                break;
            }
            Label_0319: {
                if (n4 != 0.0 || n5 != 0.0) {
                    double n7 = y.d.e.b(Math.atan2(n5, n4)) - c;
                    while (n7 < 0.0) {
                        n7 += 360.0;
                        if (u != 0) {
                            break Label_0319;
                        }
                        if (u != 0) {
                            break;
                        }
                    }
                    h.a(a2, n7);
                }
            }
            if (n2 != 0.0 && n3 != 0.0) {
                double b = y.d.e.b(Math.atan2(n3, n2));
                if (b < 0.0) {
                    b += 360.0;
                }
                a.a(a2.d(), b);
            }
            this.a(s, a2.d(), array, h, a);
            l.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    public void c(final X x) {
        if (this.u && this.k()) {
            ((y.f.e)this.e()).a((byte)96);
        }
        if (this.k() && this.p == 2) {
            final ad e = this.e();
            final boolean k = this.r.k();
            final y.f.a.h h = new y.f.a.h(e);
            h.a(true);
            this.d(h);
            this.r.e(false);
            super.c(x);
            this.r.e(k);
            this.d(e);
            if (y.f.a.f.u == 0) {
                return;
            }
        }
        super.c(x);
    }
    
    t a(final y y) {
        final int u = y.f.a.f.u;
        double n = 0.0;
        double n2 = 0.0;
        if (y.size() > 0) {
            final y.c.x a = y.a();
            while (true) {
                while (a.f()) {
                    final q e = a.e();
                    n += this.q.j(e);
                    n2 += this.q.k(e);
                    a.g();
                    if (u != 0) {
                        n2 /= y.size();
                        return new t(n, n2);
                    }
                    if (u != 0) {
                        break;
                    }
                }
                n /= y.size();
                continue;
            }
        }
        return new t(n, n2);
    }
    
    static double a(double n) {
        final int u = f.u;
        double n2 = 0.0;
        Label_0030: {
            if (n < 0.0) {
                while (n < 0.0) {
                    n2 = n + 6.283185307179586;
                    if (u != 0) {
                        break;
                    }
                    n = n2;
                    if (u != 0) {
                        break Label_0030;
                    }
                }
                return n2;
            }
        }
        if (n >= 6.283185307179586) {
            while (n >= 6.283185307179586) {
                final double n3 = n - 6.283185307179586;
                if (u != 0) {
                    break;
                }
                n = n3;
                if (u != 0) {
                    break;
                }
            }
        }
        return n2;
    }
    
    static X a(final a a) {
        return a.q;
    }
    
    static boolean b(final a a) {
        return a.u;
    }
    
    static {
        n = "y.layout.circular.CircularLayouter.CIRCLE_ID_HOLDER_DPKEY";
        o = s.k;
    }
}
