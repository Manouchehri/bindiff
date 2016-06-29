package y.f.e;

import y.c.*;
import y.f.b.*;
import java.util.*;
import y.g.*;
import y.a.*;
import y.f.e.a.*;
import y.f.*;

public class q extends c
{
    private long t;
    private double u;
    private long v;
    public static final Object n;
    public static final Object o;
    public static final Object p;
    public static final Object q;
    public static final Object r;
    public static final Object s;
    private byte w;
    private double x;
    private double y;
    private double z;
    private double A;
    private boolean B;
    private boolean C;
    private double D;
    private boolean E;
    private a F;
    private i G;
    private boolean H;
    private short I;
    private boolean J;
    private double K;
    private boolean L;
    private double M;
    private boolean N;
    private boolean O;
    private A P;
    
    public double a() {
        return this.y;
    }
    
    public boolean n() {
        return this.N;
    }
    
    public q() {
        this.u = 0.6;
        this.v = 30000L;
        this.w = 0;
        this.x = 0.5;
        this.y = 0.4;
        this.z = 40.0;
        this.A = this.z;
        this.F = new h();
        this.G = y.f.e.i.a;
        this.I = 1;
        this.L = false;
        this.M = 0.5;
        this.N = true;
        this.d(false);
        ((aN)this.c()).a((byte)1);
    }
    
    public a o() {
        return this.F;
    }
    
    protected void a(final X x, final e e) {
        Label_0096: {
            if (this.J) {
                if (this.w != 0) {
                    e.a((byte)(32 + (this.E ? 0 : 64)));
                    if (!this.E) {
                        e.b(this.r());
                    }
                    final y.c.c c = x.c(y.f.e.q.n);
                    if (c == null) {
                        break Label_0096;
                    }
                    x.a(e.b, new r(this, c));
                    if (!y.f.e.i.b) {
                        break Label_0096;
                    }
                }
                e.a((byte)(e.f() & 0xFFFFFFDF));
            }
        }
        this.K = e.d();
        e.b(Math.max(this.K, this.D));
    }
    
    public void c(final X x) {
        final y.c.h u = x.u();
        final A t = x.t();
        a(x, u, t, this.p());
        y.c.q q = null;
        y.d.t l = null;
        final x o = x.o();
        while (o.f()) {
            final y.c.q e = o.e();
            if (!t.d(e)) {
                q = e;
                l = x.l(e);
                break;
            }
            o.g();
        }
        y y = null;
        if (this.L) {
            y = new y(this, x);
            y.a(t);
        }
        e e2 = null;
        if (this.e() instanceof e) {
            e2 = (e)this.e();
            this.a(x, e2);
        }
        y.c.h h = null;
        if (this.l() && this.d() instanceof as) {
            final as as = (as)this.d();
            if (x.c(y.f.as.a) == null) {
                x.a(y.f.as.a, h = u);
            }
        }
        y.c.c c = null;
        if (this.j() && this.c() instanceof aN) {
            final aN an = (aN)this.c();
            if (x.c(aN.a) == null) {
                c = new t(this, t);
                x.a(aN.a, c);
            }
        }
        try {
            super.c(x);
        }
        finally {
            if (e2 != null) {
                this.b(x, e2);
            }
            if (h != null) {
                x.d_(as.a);
            }
            if (c != null) {
                x.d_(aN.a);
            }
            x.a(u);
            x.a(t);
            if (this.L) {
                y.a();
            }
            if (q != null) {
                final double n = l.a - x.j(q);
                final double n2 = l.b - x.k(q);
                if (n != 0.0 || n2 != 0.0) {
                    ae.a(x, x.o(), n, n2);
                }
            }
        }
    }
    
    protected void b(final X x, final e e) {
        if (this.J) {
            x.d_(e.b);
        }
        e.b(this.K);
    }
    
    protected boolean b(final X x) {
        return x != null;
    }
    
    private void d(final X x) {
        final boolean b = y.f.e.i.b;
        Label_0238: {
            if (this.O) {
                this.P = x.t();
                final x o = x.o();
            Label_0116_Outer:
                while (o.f()) {
                    final y.c.q e = o.e();
                    y.d.y y = x.s(e);
                    final aj[] a_ = x.a_(e);
                    int i = 0;
                    while (true) {
                        while (i < a_.length) {
                            y = this.a(y, a_[i].getBox());
                            ++i;
                            if (!b) {
                                if (b) {
                                    break;
                                }
                                continue Label_0116_Outer;
                            }
                            else {
                                final y.d.t l = x.l(e);
                                x.b(e, 2.0 * Math.floor(Math.max(l.a() - y.c(), y.c() + y.a() - l.a()) + 1.0E-5), 2.0 * Math.floor(Math.max(l.b() - y.d(), y.d() + y.b() - l.b()) + 1.0E-5));
                                x.a(e, l);
                                o.g();
                                if (b) {
                                    break Label_0238;
                                }
                                continue Label_0116_Outer;
                            }
                        }
                        this.P.a(e, x.r(e));
                        continue;
                    }
                }
            }
        }
    }
    
    private void e(final X x) {
        final boolean b = y.f.e.i.b;
        if (this.O) {
            final x o = x.o();
            while (o.f()) {
                final y.c.q e = o.e();
                final y.d.t l = x.l(e);
                x.a(e, (y.d.q)this.P.b(e));
                x.a(e, l);
                o.g();
                if (b) {
                    return;
                }
                if (b) {
                    break;
                }
            }
            x.a(this.P);
        }
    }
    
    private y.d.y a(final y.d.y y, final y.d.y y2) {
        if (y == null || y2 == null) {
            return (y == null) ? y2 : y;
        }
        final double min = Math.min(y.c(), y2.c());
        final double max = Math.max(y.c() + y.a(), y2.c() + y2.a());
        final double min2 = Math.min(y.d(), y2.d());
        return new y.d.y(min, min2, max - min, Math.max(y.d() + y.b(), y2.d() + y2.b()) - min2);
    }
    
    private y.c.c a(final X x, final y.c.c c) {
        final boolean b = y.f.e.i.b;
        final y.f.b.c c2 = new y.f.b.c(x);
        final A a = y.g.M.a();
        final A a2 = y.g.M.a();
        final x o = x.o();
        while (true) {
            while (o.f()) {
                final y.c.q e = o.e();
                final y.c.c c3;
                final A a3 = (A)(c3 = a2);
                if (b) {
                    final y.c.c c4 = c3;
                    final x o2 = x.o();
                    while (true) {
                        while (o2.f()) {
                            final y.c.q e2 = o2.e();
                            final y.f.b.c c5 = c2;
                            if (b) {
                                c5.c();
                                return a2;
                            }
                            Label_0232: {
                                if (c5.d(e2) && this.a(e2, c4) && !a.d(e2)) {
                                    final x a4 = c2.c(e2).a();
                                    while (a4.f()) {
                                        final y.c.q e3 = a4.e();
                                        a2.a(e3, false);
                                        a.a(e3, true);
                                        a4.g();
                                        if (b) {
                                            break Label_0232;
                                        }
                                        if (b) {
                                            break;
                                        }
                                    }
                                }
                                o2.g();
                            }
                            if (b) {
                                break;
                            }
                        }
                        continue;
                    }
                }
                a3.a(e, c.d(e));
                o.g();
                if (b) {
                    break;
                }
            }
            y.c.c c3 = x.c(y.f.e.q.o);
            continue;
        }
    }
    
    private boolean a(final y.c.q q, final y.c.c c) {
        return this.I == 2 || (c != null && c.b(q) == q.r);
    }
    
    private boolean a(final y.c.q q, final y.c.c c, final X x) {
        if (this.I == 3) {
            final y.c.c c2 = x.c(y.f.e.a.as.a);
            return c2 == null || c2.d(q);
        }
        return c != null && c.b(q) == q.q;
    }
    
    protected void a(final X x) {
        final boolean b = y.f.e.i.b;
        this.g(x);
        this.d(x);
        this.u();
        final boolean c = y.f.b.c.c(x);
        final y.c.c c2 = x.c(y.f.e.q.n);
        Label_0072: {
            if (c2 != null) {
                if (this.w == 0) {
                    x.d_(y.f.e.q.n);
                    if (!b) {
                        break Label_0072;
                    }
                }
                if (!c) {
                    x.a(y.f.e.q.n, this.a(x, c2));
                }
            }
        }
        final y.f.e.a w = this.w();
        if (w != null && (c || this.I == 1)) {
            this.a(w);
            w.c(x);
            if (!c) {
                new j(null, new y.f.e.A(new z(this.o(), new B(this, x)))).c(x);
            }
        }
        Label_0498: {
            if (!this.v() && this.u > 0.1) {
                if (this.s()) {
                    final ay h = this.h(x);
                    if (h == null) {
                        break Label_0498;
                    }
                    this.G.a(h, x);
                    h.g(false);
                    final y.c.c c3 = x.c(as.a);
                    short n = 0;
                    Label_0286: {
                        if (c3 != null) {
                            final y.c.e p = x.p();
                            while (p.f()) {
                                final boolean b2 = (n = (short)(c3.d(p.a()) ? 1 : 0)) != 0;
                                if (b) {
                                    break Label_0286;
                                }
                                if (b2) {
                                    ae.a(x, p.a());
                                }
                                p.g();
                                if (b) {
                                    break;
                                }
                            }
                        }
                        n = this.I;
                    }
                    Label_0400: {
                        if (n == 2 && !y.f.b.c.c(x)) {
                            final y.f.b.c c4 = new y.f.b.c(x);
                            final HashSet set = new HashSet(c4.b(c4.b()));
                            c4.c();
                            final ac ac = new ac();
                            x.a(y.f.ac.a, new u(this, set, h));
                            final j j = new j(ac);
                            j.a(new v(this));
                            j.c(x);
                            if (!b) {
                                break Label_0400;
                            }
                        }
                        h.c(x);
                    }
                    if (!c) {
                        new j(null, new y.f.e.A(new z(this.o(), new B(this, x)))).c(x);
                    }
                    this.G.b(h, x);
                    if (!b) {
                        break Label_0498;
                    }
                }
                final d x2 = this.x();
                if (x2 != null) {
                    this.a(x2, new B(this, x));
                    x2.c(x);
                }
            }
        }
        if (!this.E) {
            if (this.w != 0) {
                final y.c.c c5 = x.c(y.f.e.q.n);
                if (c5 != null) {
                    x.a(l.b, new w(this, c5));
                }
            }
            Label_0743: {
                if (!c) {
                    final l l = new l();
                    if (this.w != 0) {
                        l.b(false);
                    }
                    l.a((byte)2);
                    l.a(this.D);
                    l.a(false);
                    new j(l, new y.f.e.A(new z(this.o(), new B(this, x)))).c(x);
                    if (!b) {
                        break Label_0743;
                    }
                }
                if (this.w == 0) {
                    new k(this.C ? new ar(42L) : new ar(), this.D).c(x);
                    if (!b) {
                        break Label_0743;
                    }
                }
                final l i = new l();
                i.b(false);
                i.a((byte)2);
                i.a(this.D);
                i.a(false);
                i.c(x);
            }
            if (this.w != 0) {
                x.d_(l.b);
            }
        }
        if (c2 != null) {
            x.a(y.f.e.q.n, c2);
        }
        this.f(x);
        this.e(x);
    }
    
    private void f(final X x) {
        final boolean b = y.f.e.i.b;
        Label_0051: {
            switch (this.I) {
                default: {
                    if (b) {
                        break Label_0051;
                    }
                    break;
                }
                case 3: {
                    x.d_(y.f.e.a.as.a);
                    if (b) {
                        break Label_0051;
                    }
                    break;
                }
                case 2: {
                    x.d_(d.o);
                    break;
                }
            }
        }
        this.I = 1;
    }
    
    private static void a(final X x, final y.c.a a, final y.c.a a2, final int n) {
        final boolean b = i.b;
        final y.c.c c = x.c(y.f.e.q.n);
        final y.c.c c2 = x.c(y.f.e.q.o);
        Label_0745: {
            if (c2 != null || c != null) {
                final int[] array = new int[x.e()];
                Label_0561: {
                    Label_0249: {
                        if (c != null && n != 0) {
                            Label_0177: {
                                if (n == 1) {
                                    final int[] array2 = new int[x.e()];
                                    y.a.b.a(x, c, M.a(array2));
                                    final x o = x.o();
                                    while (o.f()) {
                                        final boolean d = c.d(o.e());
                                        final int n2 = array2[o.e().d()];
                                        if (b) {
                                            break Label_0561;
                                        }
                                        array[o.e().d()] = ((!d && (n2 < 0 || n2 >= 5)) ? 1 : 0);
                                        o.g();
                                        if (b) {
                                            break Label_0177;
                                        }
                                    }
                                    break Label_0249;
                                }
                            }
                            final x o2 = x.o();
                            while (o2.f()) {
                                final boolean d2 = c.d(o2.e());
                                if (b) {
                                    break Label_0561;
                                }
                                array[o2.e().d()] = (d2 ? 0 : 1);
                                o2.g();
                                if (b) {
                                    break;
                                }
                            }
                        }
                    }
                    if (y.f.b.c.b(x)) {
                        final y.f.b.c c3 = new y.f.b.c(x);
                        try {
                            int n3 = 0;
                            final x o3 = x.o();
                            while (true) {
                                while (o3.f()) {
                                    final y.c.q e = o3.e();
                                    final int d3 = c3.d(e) ? 1 : 0;
                                    if (b) {
                                        if (d3 > 0) {
                                            final x o4 = x.o();
                                            while (o4.f()) {
                                                final y.c.q e2 = o4.e();
                                                y.c.q q = c3.a(e2);
                                                if (b) {
                                                    break;
                                                }
                                                y.c.q q2 = null;
                                                while (q != c3.b()) {
                                                    if (c2.b(q) == y.f.e.q.r) {
                                                        q2 = q;
                                                    }
                                                    q = c3.a(q);
                                                    if (b) {
                                                        break;
                                                    }
                                                }
                                                if (q2 != null) {
                                                    array[e2.d()] = q2.d() + 2;
                                                }
                                                o4.g();
                                                if (b) {
                                                    break;
                                                }
                                            }
                                        }
                                        break Label_0561;
                                    }
                                    if (d3 != 0) {
                                        final boolean b2 = n == 0 || c == null || c.d(e);
                                        Object p4 = (c2 != null) ? c2.b(e) : null;
                                        if (p4 == null) {
                                            p4 = y.f.e.q.p;
                                        }
                                        if (p4 == y.f.e.q.r && b2) {
                                            ++n3;
                                        }
                                        if (p4 == y.f.e.q.q) {
                                            array[e.d()] = (b2 ? 0 : 1);
                                        }
                                    }
                                    o3.g();
                                    if (b) {
                                        break;
                                    }
                                }
                                continue;
                            }
                        }
                        finally {
                            c3.c();
                        }
                    }
                }
                final y.c.e p5 = x.p();
                while (p5.f()) {
                    final y.c.d a3 = p5.a();
                    final int n4 = array[a3.c().d()];
                    final int n5 = array[a3.d().d()];
                    if (b) {
                        return;
                    }
                    Label_0671: {
                        if (n4 == 0 || n5 == 0) {
                            a.a(a3, true);
                            if (!b) {
                                break Label_0671;
                            }
                        }
                        if (n4 != n5) {
                            a.a(a3, true);
                            if (!b) {
                                break Label_0671;
                            }
                        }
                        a.a(a3, false);
                    }
                    p5.g();
                    if (b) {
                        break;
                    }
                }
                final x o5 = x.o();
                while (o5.f()) {
                    a2.a(o5.e(), array[o5.e().d()] == 0);
                    o5.g();
                    if (b) {
                        break Label_0745;
                    }
                }
                return;
            }
        }
        final y.c.e p6 = x.p();
        while (p6.f()) {
            a.a(p6.a(), true);
            p6.g();
            if (b) {
                return;
            }
            if (b) {
                break;
            }
        }
        final x o6 = x.o();
        while (o6.f()) {
            a2.a(o6.e(), true);
            o6.g();
            if (b) {
                break;
            }
        }
    }
    
    private void g(final X x) {
        final boolean b = y.f.e.i.b;
        this.I = 1;
        final y.c.c c = x.c(y.f.e.q.n);
        final y.c.c c2 = x.c(y.f.e.q.o);
        if ((c2 != null || c != null) && y.f.b.c.b(x)) {
            final y.f.b.c c3 = new y.f.b.c(x);
            try {
                int n = 0;
                int n2 = 0;
                final x o = x.o();
                while (true) {
                    while (o.f()) {
                        final y.c.q e = o.e();
                        final int d = c3.d(e) ? 1 : 0;
                        if (b) {
                            if (d > 0) {
                                final A a = y.g.M.a();
                                this.I = 3;
                                final x o2 = x.o();
                                while (o2.f()) {
                                    final y.c.q e2 = o2.e();
                                    final y.f.b.c c4 = c3;
                                    if (b) {
                                        return;
                                    }
                                    if (c4.d(e2) && c2.b(e2) == y.f.e.q.q) {
                                        a.a(e2, true);
                                    }
                                    o2.g();
                                    if (b) {
                                        break;
                                    }
                                }
                                x.a(y.f.e.a.as.a, a);
                            }
                            else if (n > 0) {
                                this.I = 2;
                                final A a2 = y.g.M.a();
                                final x o3 = x.o();
                                while (o3.f()) {
                                    final y.c.q e3 = o3.e();
                                    final y.f.b.c c5 = c3;
                                    if (b) {
                                        return;
                                    }
                                    if (c5.d(e3) && (this.w == 0 || c == null || c.d(e3)) && c2.b(e3) == y.f.e.q.r) {
                                        a2.a(e3, true);
                                    }
                                    o3.g();
                                    if (b) {
                                        break;
                                    }
                                }
                                x.a(y.f.e.d.o, a2);
                            }
                            return;
                        }
                        if (d != 0) {
                            final boolean b2 = this.w == 0 || c == null || c.d(e);
                            Object p = (c2 != null) ? c2.b(e) : null;
                            if (p == null) {
                                p = y.f.e.q.p;
                            }
                            if (p == y.f.e.q.r && b2) {
                                ++n;
                            }
                            if (p == y.f.e.q.q) {
                                ++n2;
                            }
                        }
                        o.g();
                        if (b) {
                            break;
                        }
                    }
                    continue;
                }
            }
            finally {
                c3.c();
            }
        }
    }
    
    private boolean s() {
        return this.G != y.f.e.i.a || this.I == 3 || (this.I != 2 && this.H);
    }
    
    private J t() {
        final y.f.e.a.aj aj = new y.f.e.a.aj();
        aj.a(true);
        aj.a(this.A);
        final J j = new J(aj, y.f.e.a.J.a, 0.0, 50.0);
        j.a(y.f.e.a.J.a);
        j.c(0.0);
        return j;
    }
    
    private ay h(final X x) {
        final boolean b = y.f.e.i.b;
        final ay ay = new ay(false);
        ay.m();
        if (this.w != 0) {
            ay.e(new y.f.e.x(this));
        }
        y.f.e.a.h h = null;
        Label_0086: {
            if (y.f.b.c.c(x)) {
                h = new y.f.e.a.h();
                if (!b) {
                    break Label_0086;
                }
            }
            h = new y.f.e.a.x();
            if (this.I == 3) {
                ay.a(new y.f.e.a.as());
            }
        }
        h.d(this.x);
        ay.a(h);
        ay.a(this.q());
        ay.b(this.q());
        ay.h(this.C);
        final o o = (o)ay.z();
        o.a((long)(this.v * this.u * 0.8));
        final double u = this.u;
        Label_0242: {
            if (this.H) {
                o.a(0.6 - 0.57 * u);
                o.b(0.3 - 0.29 * u);
                h.c(h.f() * 10.0);
                if (!b) {
                    break Label_0242;
                }
            }
            o.a(0.6 - 0.585 * u);
            o.b(0.3 - 0.295 * u);
        }
        this.G.a(ay);
        if (this.H) {
            final J t = this.t();
            t.c(h.e());
            ay.a(t);
        }
        return ay;
    }
    
    private void u() {
        this.t = System.currentTimeMillis();
    }
    
    private boolean v() {
        return System.currentTimeMillis() - this.t > this.v;
    }
    
    private y.f.e.a w() {
        if (this.w != 0) {
            return null;
        }
        final y.f.e.a a = new y.f.e.a();
        a.h(this.C);
        return a;
    }
    
    private d x() {
        return new d();
    }
    
    private void a(final y.f.e.a a) {
        a.m();
        if (!this.k()) {
            a.e(true);
        }
        a.a(new y.f.b.i());
        a.g(this.u > 0.0);
        a.c((int)this.z);
        a.h(this.C);
        a.i(this.B);
        if (this.u > 0.1) {
            a.b(2 + (int)(this.u * 8.0));
            a.a(8 + (int)(this.u * 22.0));
            a.d(15);
            if (!y.f.e.i.b) {
                return;
            }
        }
        a.b(2 + (int)(28.0 * this.u / 0.1));
        a.a(25 + (int)(92.0 * this.u / 0.1));
        a.d(15);
    }
    
    private void a(final d d, final y.c.c c) {
        final boolean b = y.f.e.i.b;
        d.m();
        d.c((int)this.z);
        d.c((byte)2);
        d.b((byte)0);
        d.h(false);
        d.g(this.C);
        d.b(this.w);
        Label_0397: {
            if (this.x == 0.0) {
                d.c(0.0);
                d.b(0);
                d.a(0);
                d.a(0.0);
                if (!b) {
                    break Label_0397;
                }
            }
            if (this.x < 0.2) {
                d.c(0.0);
                d.b(1);
                d.a(0);
                d.a(0.1);
                if (!b) {
                    break Label_0397;
                }
            }
            if (this.x < 0.4) {
                d.c(0.0);
                d.b(1);
                d.a(1);
                d.a(0.2);
                if (!b) {
                    break Label_0397;
                }
            }
            if (this.x < 0.5) {
                d.c(0.0);
                d.b(1);
                d.a(1);
                d.a(0.3);
                if (!b) {
                    break Label_0397;
                }
            }
            if (this.x < 0.6) {
                d.c(0.0);
                d.b(2);
                d.a(1);
                d.a(0.4);
                if (!b) {
                    break Label_0397;
                }
            }
            if (this.x < 0.7) {
                d.c(0.0);
                d.b(2);
                d.a(2);
                d.a(0.8);
                if (!b) {
                    break Label_0397;
                }
            }
            if (this.x < 0.8) {
                d.c(0.1);
                d.b(2);
                d.a(2);
                d.a(1.0);
                if (!b) {
                    break Label_0397;
                }
            }
            if (this.x < 0.9) {
                d.c(0.3);
                d.b(2);
                d.a(2);
                d.a(1.0);
                if (!b) {
                    break Label_0397;
                }
            }
            if (this.x < 1.0) {
                d.c(0.6);
                d.b(2);
                d.a(2);
                d.a(1.0);
                if (!b) {
                    break Label_0397;
                }
            }
            d.c(4.0);
            d.b(2);
            d.a(2);
            d.a(1.0);
        }
        if (!this.n()) {
            d.a(this.a());
        }
        d.i(this.B || this.O);
        d.a((long)(this.v * this.u * 0.8));
        d.b(2.0 - this.u);
        d.d(1.0 + this.u * this.u * 100.0);
        d.a(new y.f.e.A(new z(this.o(), c)));
    }
    
    public void a(final double u) {
        if (u < 0.0 || u > 1.0) {
            throw new IllegalArgumentException("Ratio must lie within [0,1]");
        }
        this.u = u;
    }
    
    public byte p() {
        return this.w;
    }
    
    public void b(final double x) {
        if (x < 0.0 || x > 1.0) {
            throw new IllegalArgumentException("Compactness must lie within [0,1]");
        }
        this.x = x;
    }
    
    public double q() {
        return this.z;
    }
    
    public void c(final double z) {
        this.z = z;
    }
    
    public void g(final boolean b) {
        this.B = b;
    }
    
    public void h(final boolean c) {
        this.C = c;
    }
    
    public double r() {
        return this.D;
    }
    
    public void d(final double d) {
        this.D = d;
    }
    
    static double a(final q q) {
        return q.M;
    }
    
    static boolean a(final q q, final y.c.q q2, final y.c.c c, final X x) {
        return q.a(q2, c, x);
    }
    
    static boolean a(final q q, final y.c.q q2, final y.c.c c) {
        return q.a(q2, c);
    }
    
    static {
        n = d.n;
        o = "y.layout.organic.SmartOrganicLayouter.GROUP_NODE_MODE_DATA";
        p = "GROUP_NODE_MODE_NORMAL";
        q = "GROUP_NODE_MODE_FIX_BOUNDS";
        r = "GROUP_NODE_MODE_FIX_CONTENTS";
        s = d.p;
    }
}
