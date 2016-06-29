package y.f.g;

import y.f.b.*;
import y.g.*;
import y.a.*;
import y.c.*;
import java.awt.geom.*;
import y.f.c.a.*;
import y.d.*;
import y.f.*;
import java.util.*;

public class d extends a
{
    public static final Object a;
    public static final Object b;
    public static final Object c;
    private ah e;
    private y f;
    private y g;
    private f h;
    private f i;
    private f n;
    private y[] o;
    private A p;
    private A q;
    private double r;
    private boolean s;
    private y t;
    private long u;
    private byte v;
    private byte w;
    private byte x;
    private byte y;
    private A z;
    private Map A;
    private Map B;
    private A C;
    private Map D;
    private Map E;
    private Map F;
    private Map G;
    private Map H;
    private A I;
    private c J;
    private q K;
    private n L;
    private boolean M;
    private boolean N;
    private boolean O;
    private double P;
    private int Q;
    private ah R;
    private boolean S;
    private t T;
    private boolean U;
    private boolean V;
    private long W;
    private boolean X;
    private boolean Y;
    private y.f.g.A Z;
    private static final r aa;
    public static boolean d;
    
    public d() {
        this.r = 0.5;
        this.s = false;
        this.y = -1;
        this.T = null;
        this.W = 2147483647L;
        this.X = true;
        this.Y = false;
        this.Z = null;
        this.I = y.g.M.a();
        this.e = null;
        this.x = 2;
        this.w = 0;
        this.y = -1;
        this.Q = 15;
        this.P = this.Q + 5;
        this.L = new n();
        this.M = false;
        this.O = false;
        this.V = false;
        this.U = false;
        this.c((byte)1);
    }
    
    public void a(final ah e) {
        this.e = e;
    }
    
    public ah a() {
        return this.e;
    }
    
    public void a(final byte x) {
        this.x = x;
    }
    
    public boolean b() {
        return this.N;
    }
    
    public void a(final boolean n) {
        this.N = n;
    }
    
    public void b(final byte w) {
        this.w = w;
    }
    
    public void b(final ah r) {
        this.R = r;
        this.S = true;
    }
    
    public void c(final byte v) {
        this.v = v;
        this.S = false;
        this.e(this.v);
    }
    
    public byte c() {
        return this.y;
    }
    
    public void d(final byte y) {
        this.y = y;
        this.M = (y != -1);
    }
    
    public void b(final boolean v) {
        this.V = v;
    }
    
    public void c(final X x) {
        final boolean d = y.f.g.d.d;
        if (x != null && x.f() > 0) {
            if (x.c(y.f.g.d.a) != null || x.c(y.f.g.d.b) != null) {
                this.u = System.currentTimeMillis();
                final bk c = bk.c(x);
                Label_0180: {
                    if (c != null) {
                        C c2 = c.f().m();
                        while (true) {
                            while (c2.f()) {
                                final l l = (l)c2.d();
                                l.g(l.g());
                                l.d(l.f());
                                c2.g();
                                if (d) {
                                    while (c2.f()) {
                                        final bt bt = (bt)c2.d();
                                        bt.g(bt.f());
                                        bt.d(bt.g());
                                        c2.g();
                                        if (d) {
                                            return;
                                        }
                                        if (d) {
                                            break;
                                        }
                                    }
                                    break Label_0180;
                                }
                                if (d) {
                                    break;
                                }
                            }
                            c2 = c.e().m();
                            continue;
                        }
                    }
                }
                final t e = this.e(x);
                byte b = this.c();
                if (b == 5) {
                    b = ae.a(x, new e(this, x.c(y.f.g.d.a), x.c(y.f.g.d.b)));
                    this.M = (b != -1);
                }
                if (b == -1) {
                    b = 0;
                    this.M = false;
                }
                final y.f.g.f f = new y.f.g.f(this, this);
                f.a(b);
                f.a(0);
                f.c(x);
                this.a(x, e);
                if (!d) {
                    return;
                }
            }
            if (this.e != null) {
                this.e.c(x);
            }
        }
    }
    
    private void e(final byte b) {
        final boolean d = y.f.g.d.d;
        if (b == 4 || b == 0) {
            final y.f.i.a.y r = new y.f.i.a.y();
            r.a("y.layout.partial.PartialLayouter.ROUTE_EDGE_DPKEY");
            this.R = r;
            if (!d) {
                return;
            }
        }
        if (b == 1) {
            final y.f.g.i r2 = new y.f.g.i();
            r2.a("y.layout.partial.PartialLayouter.ROUTE_EDGE_DPKEY");
            this.R = r2;
            if (!d) {
                return;
            }
        }
        if (b == 2) {
            this.R = null;
            if (!d) {
                return;
            }
        }
        if (b == 3) {
            this.R = new y.f.i.q();
        }
    }
    
    private void c(final boolean b) {
        this.L.b(this.Q);
        this.L.c(this.N);
        this.L.b(true);
        this.L.a(this.X);
        this.L.d(true);
        this.L.c(Integer.MAX_VALUE);
        if (b) {
            this.L.a(200);
            if (!y.f.g.d.d) {
                return;
            }
        }
        this.L.a(500);
    }
    
    private t e(final X x) {
        final boolean d = y.f.g.d.d;
        final y.c.c c = x.c(y.f.g.d.a);
        final x o = x.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                if (!d) {
                    if (!c.d(e)) {
                        this.K = e;
                        if (!d) {
                            break;
                        }
                    }
                    o.g();
                    if (d) {
                        break;
                    }
                    continue;
                }
                else {
                    if (this.K != null) {
                        return x.l(this.K);
                    }
                    return null;
                }
            }
            if (this.K == null && x.k() != null) {
                this.K = x.k();
            }
            continue;
        }
    }
    
    public void b(final X x) {
        this.g(x);
        this.b(x, this.n);
        this.k(x);
        this.a(x, this.o);
        if (!this.Y) {
            this.a(x, this.h);
        }
        this.J.c();
    }
    
    private void f(final X x) {
        if (this.y != -1 && this.w == 0) {
            (this.Z = new y.f.g.A(this.Q)).a(x, this.J);
        }
    }
    
    private void g(final X x) {
        final boolean d = y.f.g.d.d;
        this.J = new c(x);
        this.h(x);
        this.f(x);
        this.i(x);
        this.a((i)x);
        this.c((i)x);
        this.b((i)x);
        this.j(x);
        final y.c.e a = this.h.a();
        while (a.f()) {
            final y.c.d a2 = a.a();
            ae.a(x, a2, false);
            if (!aE.b(x, a2)) {
                x.a(a2, y.d.t.c);
            }
            if (!aE.c(x, a2)) {
                x.b(a2, y.d.t.c);
            }
            a.g();
            if (d) {
                break;
            }
        }
    }
    
    private void h(final X x) {
        final boolean d = y.f.g.d.d;
        this.f = new y();
        this.g = new y();
        final y.c.c c = x.c(y.f.g.d.a);
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            Label_0134: {
                if (c.d(e)) {
                    this.f.add(e);
                    if (!this.J.d(e)) {
                        break Label_0134;
                    }
                    this.I.a(e, true);
                    if (!d) {
                        break Label_0134;
                    }
                }
                this.g.add(e);
                if (this.T == null) {
                    this.T = x.o(e);
                }
            }
            o.g();
            if (d) {
                break;
            }
        }
    }
    
    private void a(final i i) {
        final boolean d = y.f.g.d.d;
        this.h = new f();
        Label_0151: {
            if (this.f != null && !this.f.isEmpty()) {
                final x a = this.f.a();
            Label_0146_Outer:
                while (a.f()) {
                    final y.c.e j = a.e().j();
                    while (true) {
                        while (j.f()) {
                            final y.c.d a2 = j.a();
                            if (!d) {
                                if (this.z.b(a2.c()) != this.z.b(a2.d())) {
                                    this.h.add(a2);
                                }
                                j.g();
                                if (d) {
                                    break;
                                }
                                continue Label_0146_Outer;
                            }
                            else {
                                if (d) {
                                    break Label_0151;
                                }
                                continue Label_0146_Outer;
                            }
                        }
                        a.g();
                        continue;
                    }
                }
            }
        }
    }
    
    private void b(final i i) {
        final boolean d = y.f.g.d.d;
        this.n = new f();
        final y.c.c c = i.c(y.f.g.d.b);
        if (c != null) {
            final y.c.c c2 = i.c(y.f.g.d.a);
            final y.c.e p = i.p();
            while (p.f()) {
                final y.c.d a = p.a();
                if (c.d(a) && (c2 == null || (!c2.d(a.c()) && !c2.d(a.d())))) {
                    this.n.add(a);
                }
                p.g();
                if (d) {
                    break;
                }
            }
        }
    }
    
    private void c(final i i) {
        final boolean d = y.f.g.d.d;
        this.i = new f();
        final x a = this.f.a();
        do {
            Label_0024: {
                a.f();
            }
            boolean startsWith = false;
            Label_0030:
            while (startsWith) {
                final y.c.e l = a.e().l();
                while (l.f()) {
                    final y.c.d a2 = l.a();
                    final String s = (String)this.z.b(a2.c());
                    startsWith = ((String)this.z.b(a2.d())).startsWith("component");
                    if (d) {
                        continue Label_0030;
                    }
                    if (startsWith && s.startsWith("component")) {
                        this.i.add(a2);
                    }
                    l.g();
                    if (d) {
                        break;
                    }
                }
                a.g();
                continue Label_0024;
            }
            break;
        } while (!d);
    }
    
    private void i(final X x) {
        final boolean d = y.f.g.d.d;
        Label_0466: {
            Label_0459: {
                Label_0102: {
                    if (this.w == 0) {
                        final y[] o = new y[this.f.size()];
                        int n = 0;
                        final x a = this.f.a();
                        while (true) {
                            while (a.f()) {
                                (o[n] = new y()).add(a.e());
                                ++n;
                                a.g();
                                if (!d) {
                                    if (d) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (d) {
                                        break Label_0102;
                                    }
                                    break Label_0459;
                                }
                            }
                            this.o = o;
                            continue;
                        }
                    }
                }
                if (this.w == 1) {
                    final I i = new I(x);
                    this.b(x, i);
                    this.a(x, i);
                    i.a(this.g);
                    this.o = y.a.h.a(x);
                    i.f();
                    if (!d) {
                        break Label_0459;
                    }
                }
                if (this.w == 2) {
                    final I j = new I(x);
                    this.b(x, j);
                    this.a(x, j);
                    this.o = a((i)x, this.f);
                    j.f();
                    if (!d) {
                        break Label_0459;
                    }
                }
                final I k = new I(x);
                k.a(this.g);
                k.b();
                final y.c.c c = x.c(y.f.g.d.c);
                final f f = new f();
                final HashMap<j, q> hashMap = new HashMap<j, q>();
                final x o2 = x.o();
                while (true) {
                    while (o2.f()) {
                        final q e = o2.e();
                        final d d2 = this;
                        if (d) {
                            d2.o = y.a.h.a(x);
                            final y.c.e a2 = f.a();
                            while (a2.f()) {
                                x.a(a2.a());
                                a2.g();
                                if (d) {
                                    break Label_0466;
                                }
                                if (d) {
                                    break;
                                }
                            }
                            k.f();
                            break Label_0459;
                        }
                        Label_0390: {
                            if (!this.J.d(e)) {
                                final j l = new j(this, this.J.a(e), (c != null) ? c.b(e) : null, null);
                                if (hashMap.containsKey(l)) {
                                    f.add(x.a(hashMap.get(l), e));
                                    if (!d) {
                                        break Label_0390;
                                    }
                                }
                                hashMap.put(l, e);
                            }
                        }
                        o2.g();
                        if (d) {
                            break;
                        }
                    }
                    final d d2 = this;
                    continue;
                }
            }
            this.z = y.g.M.a();
        }
        final x o3 = x.o();
        while (true) {
        Label_0806_Outer:
            while (o3.f()) {
                final q e2 = o3.e();
                final d d3 = this;
                if (d) {
                    final int length = d3.o.length;
                    final String[] array = new String[length];
                    this.D = new HashMap();
                    this.C = y.g.M.a();
                    int n2 = 0;
                Label_0806:
                    while (true) {
                        while (n2 < length) {
                            array[n2] = "component" + String.valueOf(n2);
                            y y = this.o[n2];
                            Object o4;
                            final x x2 = (x)(o4 = y.a());
                            if (d) {
                            Label_1115_Outer:
                                while (true) {
                                    final String s = (String)o4;
                                    final y y2 = new y();
                                    final f f2 = new f();
                                    final f f3 = new f();
                                    final f f4 = new f();
                                    if (!d) {
                                        final x a3 = y.a();
                                    Label_1124:
                                        while (true) {
                                            do {
                                                Label_0888: {
                                                    a3.f();
                                                }
                                                boolean equals = false;
                                                Label_0895:
                                                while (equals) {
                                                    final q e3 = a3.e();
                                                    final y.c.e m = e3.j();
                                                    if (!d) {
                                                        final y.c.e e4 = m;
                                                        while (e4.f()) {
                                                            final y.c.d a4 = e4.a();
                                                            final q a5 = a4.a(e3);
                                                            final String s2 = (String)this.z.b(a5);
                                                            equals = s2.equals("remain");
                                                            if (d) {
                                                                continue Label_0895;
                                                            }
                                                            if (equals) {
                                                                y2.add(a5);
                                                                f2.add(a4);
                                                            }
                                                            Label_1036: {
                                                                if (!s2.equals(s)) {
                                                                    f3.add(a4);
                                                                    if (!d) {
                                                                        break Label_1036;
                                                                    }
                                                                }
                                                                if (a4.c() == e3) {
                                                                    f4.add(a4);
                                                                }
                                                            }
                                                            e4.g();
                                                            if (d) {
                                                                break;
                                                            }
                                                        }
                                                        a3.g();
                                                        continue Label_0888;
                                                    }
                                                    ++n2;
                                                    if (d) {
                                                        break Label_1124;
                                                    }
                                                    break Label_0806;
                                                }
                                                break;
                                            } while (!d);
                                            Label_1060: {
                                                break Label_1060;
                                                if (n2 < length) {
                                                    y = this.o[n2];
                                                    o4 = this.z.b(y.b());
                                                    continue Label_1115_Outer;
                                                }
                                                break Label_1124;
                                            }
                                            this.B.put(s, f2);
                                            this.A.put(s, y2);
                                            this.G.put(y, f3);
                                            this.H.put(y, f4);
                                            continue Label_0806_Outer;
                                        }
                                        this.n(x);
                                    }
                                    break;
                                }
                                return;
                            }
                            final x x3 = x2;
                            while (x3.f()) {
                                final q e5 = x3.e();
                                this.z.a(e5, array[n2]);
                                this.D.put(e5, y);
                                x3.g();
                                if (d) {
                                    continue Label_0806;
                                }
                                if (d) {
                                    break;
                                }
                            }
                            final q a6 = this.J.a(y.b());
                            Label_0751: {
                                if (a6 != null) {
                                    final D d4 = (D)this.C.b(a6);
                                    if (d4 != null) {
                                        d4.add(y);
                                        if (!d) {
                                            break Label_0751;
                                        }
                                    }
                                    final D d5 = new D();
                                    d5.add(y);
                                    this.C.a(a6, d5);
                                }
                            }
                            ++n2;
                            if (d) {
                                break;
                            }
                        }
                        this.A = new HashMap();
                        this.B = new HashMap();
                        this.G = new HashMap();
                        this.H = new HashMap();
                        n2 = 0;
                        continue Label_0806;
                    }
                }
                this.z.a(e2, "remain");
                o3.g();
                if (d) {
                    break;
                }
            }
            final d d3 = this;
            continue;
        }
    }
    
    private void j(final X x) {
        final boolean d = y.f.g.d.d;
        this.F = new HashMap();
        final int length = this.o.length;
        int i = 0;
        while (i < length) {
            final y y = this.o[i];
            this.F.put(y, this.c(x, y));
            ++i;
            if (d) {
                return;
            }
            if (d) {
                break;
            }
        }
        ae.a(x, this.g.a());
    }
    
    private void k(final X x) {
        final boolean d = y.f.g.d.d;
        if (this.a() != null && this.o != null) {
            if (this.e instanceof y.f.c.M) {
                ((y.f.c.M)this.e).a(this.P);
                ((y.f.c.M)this.e).b(this.Q);
            }
            if (this.e instanceof y.f.e.q) {
                ((y.f.e.q)this.e).d(this.Q);
            }
            if (this.e instanceof y.f.f.c) {
                ((y.f.f.c)this.e).a(this.Q);
            }
            final int length = this.o.length;
            final I i = new I(x);
            int j = 0;
            while (j < length) {
                final y y = this.o[j];
                final t a = this.a(x, y);
                i.a();
                i.a(y, true);
                this.d(x);
                final Rectangle2D c = this.c(x, y);
                final t t = new t(c.getX() + c.getWidth() / 2.0, c.getY() + c.getHeight() / 2.0);
                ae.a(x, y.a(), a.a - t.a, a.b - t.b);
                i.f();
                ++j;
                if (d) {
                    break;
                }
            }
        }
    }
    
    protected void d(final X x) {
        new b(this.e).c(x);
        this.o(x);
    }
    
    private t a(final X x, final y y) {
        final boolean d = y.f.g.d.d;
        double n = 0.0;
        double n2 = 0.0;
        final x a = y.a();
        while (a.f()) {
            final q e = a.e();
            n += x.j(e);
            n2 += x.k(e);
            a.g();
            if (d) {
                break;
            }
        }
        return new t(n / y.size(), n2 / y.size());
    }
    
    protected void a(final X x, final y[] array) {
        this.E = new HashMap();
        this.c(this.x == 3);
        if (this.x == 2) {
            this.a(x, array, false);
            this.l(x);
            if (!this.V) {
                return;
            }
            this.m(x);
            this.a(x, array, false);
            this.l(x);
            if (!y.f.g.d.d) {
                return;
            }
        }
        if (this.x == 3) {
            this.a(x, array, true);
        }
    }
    
    private y.d.q a(final q q, final y.d.y y, final double n, final double n2, final X x) {
        double max = n * (2.0 - this.r);
        double max2 = n2 * (2.0 - this.r);
        if (y != null) {
            max = Math.max(max, y.a);
            max2 = Math.max(max2, y.b);
        }
        final r a = this.a(q, (i)x);
        double max3 = max + (a.b + a.d);
        double max4 = max2 + (a.a + a.c);
        final y.c.c c = x.c(y.f.b.f.f);
        if (c != null) {
            final y.d.q q2 = (y.d.q)c.b(q);
            if (q2 != null) {
                max3 = Math.max(max3, q2.a);
                max4 = Math.max(max4, q2.b);
            }
        }
        return new y.d.q(max3, max4);
    }
    
    private y.d.y a(final D d) {
        final boolean d2 = d.d;
        if (d != null && !d.isEmpty()) {
            double min = Double.MAX_VALUE;
            double max = -1.7976931348623157E308;
            double min2 = Double.MAX_VALUE;
            double max2 = -1.7976931348623157E308;
            final C m = d.m();
            y.d.y y = null;
            while (m.f()) {
                y = (y.d.y)m.d();
                if (d2) {
                    return y;
                }
                final y.d.y y2 = y;
                min = Math.min(min, y2.c());
                max = Math.max(max, y2.c() + y2.a());
                min2 = Math.min(min2, y2.d());
                max2 = Math.max(max2, y2.d() + y2.b());
                m.g();
                if (d2) {
                    break;
                }
            }
            final y.d.y y3 = new y.d.y(min, min2, max - min, max2 - min2);
            return y;
        }
        return null;
    }
    
    private static y.d.y a(final y.d.y y, final y.d.y y2) {
        if (y == null) {
            return y2;
        }
        if (y2 == null) {
            return y;
        }
        final double max = Math.max(y.c(), y2.c());
        final double max2 = Math.max(y.d(), y2.d());
        return new y.d.y(max, max2, Math.min(y.c() + y.a(), y2.c() + y2.a()) - max, Math.min(y.d() + y.b(), y2.d() + y2.b()) - max2);
    }
    
    private void l(final X x) {
        final boolean d = y.f.g.d.d;
        final y c = this.J.c(this.J.b());
        c.n();
        final x a = c.a();
        while (a.f()) {
            final q e = a.e();
            if (this.I.d(e)) {
                this.a(e, x);
            }
            a.g();
            if (d) {
                break;
            }
        }
    }
    
    private void a(final q q, final X x) {
        final boolean d = y.f.g.d.d;
        double min = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        double min2 = Double.MAX_VALUE;
        double max2 = -1.7976931348623157E308;
        final y b = this.J.b(q);
        if (b.size() > 0) {
            final x a = b.a();
            while (a.f()) {
                final y.d.y s = x.s(a.e());
                min = Math.min(min, s.c());
                max = Math.max(max, s.c() + s.a());
                min2 = Math.min(min2, s.d());
                max2 = Math.max(max2, s.d() + s.b());
                a.g();
                if (d) {
                    return;
                }
                if (d) {
                    break;
                }
            }
            final y.c.c c = x.c(y.f.b.f.e);
            if (c != null) {
                final r a2 = y.d.r.a(c.b(q));
                if (a2 != null) {
                    min -= a2.b;
                    max += a2.d;
                    min2 -= a2.a;
                    max2 += a2.c;
                }
            }
            final y.c.c c2 = x.c(y.f.b.f.f);
            if (c2 != null) {
                final y.d.q q2 = (y.d.q)c2.b(q);
                if (q2 != null) {
                    final double n = q2.a - max + min;
                    final double n2 = q2.b - max2 + min2;
                    if (n > 0.0) {
                        min -= n * 0.5;
                        max += n * 0.5;
                    }
                    if (n2 > 0.0) {
                        min2 -= n2 * 0.5;
                        max2 += n2 * 0.5;
                    }
                }
            }
            x.b(q, max - min, max2 - min2);
            x.c(q, min, min2);
        }
    }
    
    private boolean a(final q q, final X x, final A a) {
        final boolean d = y.f.g.d.d;
        double min = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        double min2 = Double.MAX_VALUE;
        double max2 = -1.7976931348623157E308;
        final x a2 = this.J.b(q).a();
        while (true) {
            while (a2.f()) {
                final q e = a2.e();
                final y.c.c c = a;
                if (d) {
                    final y.c.c c2 = c;
                    if (c2 != null) {
                        final r a3 = y.d.r.a(c2.b(q));
                        if (a3 != null) {
                            min -= a3.b;
                            max += a3.d;
                            min2 -= a3.a;
                            max2 += a3.c;
                        }
                    }
                    final y.d.y s = x.s(q);
                    final double min3 = Math.min(min, s.c);
                    final double min4 = Math.min(min2, s.d);
                    x.b(q, Math.max(max, s.c + s.a) - min3, Math.max(max2, s.d + s.b) - min4);
                    x.c(q, min3, min4);
                    return !x.s(q).equals(s);
                }
                if (a.d(e) || (this.J.d(e) && !this.I.d(e))) {
                    final y.d.y s2 = x.s(a2.e());
                    min = Math.min(min, s2.c());
                    max = Math.max(max, s2.c() + s2.a());
                    min2 = Math.min(min2, s2.d());
                    max2 = Math.max(max2, s2.d() + s2.b());
                }
                a2.g();
                if (d) {
                    break;
                }
            }
            final y.c.c c = x.c(y.f.b.f.e);
            continue;
        }
    }
    
    private r a(final q q, final i i) {
        final y.c.c c = i.c(y.f.b.f.e);
        if (c != null) {
            final r a = y.d.r.a(c.b(q));
            if (a != null) {
                return a;
            }
        }
        return y.f.g.d.aa;
    }
    
    private y.f.g.y a(final y y, final X x, final A a, final y.d.y y2) {
        final boolean d = y.f.g.d.d;
        final y.f.g.y y3 = new y.f.g.y();
        final q b = y.b();
        final q a2 = this.J.a(b);
        if (a2 != null) {
            final y.d.y s = x.s(a2);
            final r a3 = this.a(a2, (i)x);
            y3.a = new y.d.y(s.c + a3.b, s.d + a3.a, s.a - a3.b - a3.d, s.b - a3.a - a3.c);
            y3.c = ((!this.I.d(a2) && this.s) || this.L.d());
        }
        if (y2 != null) {
            y3.a = a(y3.a, y2);
        }
        y.d.y y4 = null;
        Label_0518: {
            if (y3.c) {
                y4 = x.s(b);
                final x a4 = this.t.a();
                while (a4.f()) {
                    final q e = a4.e();
                    final y.d.y s2 = x.s(e);
                    if (d) {
                        break Label_0518;
                    }
                    if (e != a2 && !s2.b(y4) && !y4.b(s2)) {
                        y3.b.add(new y.d.y(s2.c - this.Q, s2.d - this.Q, s2.a() + 2 * this.Q, s2.b() + 2 * this.Q));
                    }
                    a4.g();
                    if (d) {
                        break;
                    }
                }
            }
            final x a5 = this.J.b(a2).a();
            while (true) {
                while (a5.f()) {
                    final q e2 = a5.e();
                    final d d2 = this;
                    if (d) {
                        y4 = d2.b(x, b);
                        break Label_0518;
                    }
                    if (this.J.d(e2) && (a.d(e2) || !this.I.d(e2))) {
                        final y.d.y s3 = x.s(e2);
                        y3.b.add(new y.d.y(s3.c - this.Q, s3.d - this.Q, s3.a() + 2 * this.Q, s3.b() + 2 * this.Q));
                    }
                    a5.g();
                    if (d) {
                        break;
                    }
                }
                final d d2 = this;
                continue;
            }
        }
        if (y4 != null) {
            y3.a = a(y3.a, y4);
        }
        if (this.Z != null && y3.a == null) {
            final y.d.y a6 = this.Z.a(b, x, a);
            if (a6 != null) {
                final y.d.y a7 = a(y3.a, a6);
                if (a7.a > 0.0 && a7.b > 0.0) {
                    y3.a = a7;
                }
            }
        }
        return y3;
    }
    
    private y.d.q a(final X x, final q q) {
        final boolean d = y.f.g.d.d;
        q q2 = this.J.a(q);
        while (q2 != null && this.I.d(q2)) {
            q2 = this.J.a(q2);
            if (d) {
                break;
            }
        }
        if (q2 != null) {
            return x.s(q2);
        }
        return new y.d.q(0.0, 0.0);
    }
    
    private double a(final l l) {
        if (this.y == 2) {
            return l.h() - l.e();
        }
        if (this.y == 1) {
            return l.h();
        }
        if (this.y == 3) {
            return l.h() - l.e();
        }
        return l.h();
    }
    
    private double a(final bt bt) {
        if (this.y == 2) {
            return bt.h() - bt.e();
        }
        if (this.y == 1) {
            return bt.h() - bt.e();
        }
        if (this.y == 3) {
            return bt.h();
        }
        return bt.h();
    }
    
    private y.d.y b(final X x, final q q) {
        final boolean d = y.f.g.d.d;
        final y.c.c c = x.c(bk.b);
        if (c == null || c.b(q) == null) {
            return null;
        }
        double min = Double.MAX_VALUE;
        double min2 = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        double max2 = -1.7976931348623157E308;
        for (final bj bj : ((bh)c.b(q)).a()) {
            final l b = bj.b();
            min = Math.min(min, this.a(b) + b.c());
            max = Math.max(max, this.a(b) + b.e() - b.d());
            final bt a = bj.a();
            min2 = Math.min(min2, this.a(a) + a.c());
            max2 = Math.max(max2, this.a(a) + a.e() - a.d());
            if (d) {
                return new y.d.y(min2, min, max2 - min2, max - min);
            }
            if (d) {
                break;
            }
        }
        if (this.y == 1 || this.y == 3) {
            return new y.d.y(min2, min, max2 - min2, max - min);
        }
        return new y.d.y(min, min2, max - min, max2 - min2);
    }
    
    private boolean a(final X x, final q q, final boolean b, final A a) {
        final boolean d = y.f.g.d.d;
        final double n = 5 + this.Q;
        final D d2 = new D();
        final y.d.q a2 = this.a(x, q);
        final y.d.y b2 = this.b(x, q);
        y.d.q q2 = null;
        Label_0088: {
            if (b2 != null) {
                q2 = new y.d.q(Math.min(a2.a, b2.a), Math.min(a2.b, b2.b));
                if (!d) {
                    break Label_0088;
                }
            }
            q2 = a2;
        }
        double n2 = 0.0;
        double n3 = 0.0;
        final x a3 = this.J.b(q).a();
        while (true) {
            while (a3.f()) {
                final q e = a3.e();
                final A c = a;
                final q q3 = e;
                if (!d) {
                    Label_0248: {
                        if (a.d(q3)) {
                            d2.add(x.s(e));
                            if (q2.b() - (n3 + x.q(e)) > q2.a() - (n2 + x.p(e))) {
                                n3 += x.q(e) + n;
                                n2 = Math.max(n2, x.p(e));
                                if (!d) {
                                    break Label_0248;
                                }
                            }
                            n3 = Math.max(n3, x.q(e));
                            n2 += x.p(e) + n;
                        }
                    }
                    a3.g();
                    if (d) {
                        break;
                    }
                    continue;
                }
                else {
                    final D d3 = (D)c.b(q3);
                    d d4 = null;
                    Label_0649: {
                        if (d3 != null) {
                            final C m = d3.m();
                            while (m.f()) {
                                final y y = (y)m.d();
                                final q b3 = y.b();
                                d4 = this;
                                if (d) {
                                    break Label_0649;
                                }
                                Label_0636: {
                                    if (this.J.d(b3)) {
                                        final y.d.q q4 = (y.d.q)this.p.b(b3);
                                        Label_0436: {
                                            if (q2.b() - (n3 + q4.b()) > q2.a() - (n2 + q4.a())) {
                                                n3 += q4.b() + n;
                                                n2 = Math.max(n2, q4.a());
                                                if (!d) {
                                                    break Label_0436;
                                                }
                                            }
                                            n3 = Math.max(n3, q4.b());
                                            n2 += q4.a() + n;
                                        }
                                        final y.d.y y2 = (y.d.y)this.q.b(b3);
                                        if (y2 == null) {
                                            break Label_0636;
                                        }
                                        final r a4 = this.a(b3, (i)x);
                                        d2.add(new y.d.y(y2.c - a4.b, y2.d - a4.a, y2.a + a4.b + a4.d, y2.b + a4.a + a4.c));
                                        if (!d) {
                                            break Label_0636;
                                        }
                                    }
                                    final Rectangle2D c2 = this.c(x, y);
                                    if (q2.b() - (n3 + c2.getHeight()) > q2.a() - (n2 + c2.getWidth())) {
                                        n3 += c2.getHeight() + n;
                                        n2 = Math.max(n2, c2.getWidth());
                                        if (!d) {
                                            break Label_0636;
                                        }
                                    }
                                    n3 = Math.max(n3, c2.getHeight());
                                    n2 += c2.getWidth() + n;
                                }
                                m.g();
                                if (d) {
                                    break;
                                }
                            }
                        }
                        d4 = this;
                    }
                    final y.d.y a5 = d4.a(d2);
                    this.q.a(q, a5);
                    if (b) {
                        this.p.a(q, x.s(q));
                        return false;
                    }
                    if (this.J.b(q).size() > 0) {
                        final y.d.q q5 = (y.d.q)this.p.b(q);
                        final y.d.q a6 = this.a(q, a5, n2, n3, x);
                        this.p.a(q, a6);
                        return q5 != null && !q5.equals(a6);
                    }
                    this.p.a(q, x.s(q));
                    return false;
                }
            }
            final A c = this.C;
            continue;
        }
    }
    
    private void a(final X x, final boolean b, final A a) {
        final boolean d = y.f.g.d.d;
        this.p = y.g.M.a();
        this.q = y.g.M.a();
        final y c = this.J.c(this.J.b());
        c.n();
        final x a2 = c.a();
        while (a2.f()) {
            final q e = a2.e();
            if (this.I.d(e)) {
                this.a(x, e, b, a);
            }
            a2.g();
            if (d) {
                break;
            }
        }
    }
    
    private void a(final X x, final y[] array, final boolean b) {
        final boolean d = y.f.g.d.d;
        final A a = y.g.M.a();
        final A a2 = y.g.M.a();
        final x a3 = this.g.a();
        while (a3.f()) {
            a.a(a3.e(), true);
            a2.a(a3.e(), true);
            a3.g();
            if (d) {
                break;
            }
        }
        final g g = new g(this, a);
        final y.c.h b2 = y.g.M.b();
        final y.c.e p3 = x.p();
        while (true) {
            while (p3.f()) {
                final y.c.d a4 = p3.a();
                if (d) {
                    if (this.U) {
                        this.a(x, b, a, a2, b2, g);
                    }
                    return;
                }
                b2.a(a4, this.z.b(a4.c()) == this.z.b(a4.d()));
                p3.g();
                if (d) {
                    break;
                }
            }
            this.a(x, b, a2);
            this.a(x, array, this.g, b, a, a2, b2, g);
            continue;
        }
    }
    
    private void a(final X x, final boolean b, final A a, final A a2, final y.c.h h, final y.c.c c) {
        final boolean d = y.f.g.d.d;
        int i = 0;
        while (i < this.o.length) {
            final y y = this.o[i];
            int n = 0;
            x x2 = y.a();
            Label_0491: {
                q q = null;
                y.c.e e2;
                y.c.e e = null;
                y.c.e e3;
                y.c.d a3;
                double n2;
                y.c.e k;
                y.c.d a4;
                double n3;
                boolean d2 = false;
                y.c.e e4;
                y.c.d a5;
                Label_0066_Outer:Label_0314_Outer:
                while (true) {
                Label_0314:
                    while (true) {
                    Label_0321:
                        while (true) {
                            while (true) {
                                Label_0338: {
                                    Label_0251: {
                                        if (!x2.f()) {
                                            break Label_0251;
                                        }
                                        q = x2.e();
                                        e = (e2 = q.l());
                                        if (d) {
                                            break Label_0338;
                                        }
                                        e3 = e2;
                                        while (true) {
                                            while (e3.f()) {
                                                a3 = e3.a();
                                                n2 = dcmpg(x.k(a3.d()), x.k(a3.c()));
                                                if (!d) {
                                                    if (n2 <= 0) {
                                                        n = 1;
                                                        if (!d) {
                                                            break;
                                                        }
                                                    }
                                                    e3.g();
                                                    if (d) {
                                                        break;
                                                    }
                                                    continue Label_0066_Outer;
                                                }
                                                else {
                                                    if (n2 != 0) {
                                                        break Label_0251;
                                                    }
                                                    k = q.k();
                                                    while (true) {
                                                        while (k.f()) {
                                                            a4 = k.a();
                                                            n3 = dcmpg(x.k(a4.d()), x.k(a4.c()));
                                                            if (!d) {
                                                                if (n3 <= 0) {
                                                                    n = 1;
                                                                    if (!d) {
                                                                        break;
                                                                    }
                                                                }
                                                                k.g();
                                                                if (d) {
                                                                    break;
                                                                }
                                                                continue Label_0066_Outer;
                                                            }
                                                            else {
                                                                if (n3 != 0) {
                                                                    break Label_0251;
                                                                }
                                                                x2.g();
                                                                if (d) {
                                                                    break Label_0251;
                                                                }
                                                                continue Label_0491;
                                                            }
                                                        }
                                                        continue Label_0314_Outer;
                                                    }
                                                }
                                            }
                                            continue Label_0314_Outer;
                                        }
                                    }
                                    if (n == 0) {
                                        break Label_0491;
                                    }
                                    x2 = y.a();
                                    while (x2.f()) {
                                        a.a(x2.e(), false);
                                        x2.g();
                                        if (d) {
                                            break Label_0314;
                                        }
                                        if (d) {
                                            break;
                                        }
                                    }
                                    x2 = x.o();
                                    x2.f();
                                    if (!d2) {
                                        break;
                                    }
                                    q = x2.e();
                                    e = (e2 = q.j());
                                }
                                if (d) {
                                    continue Label_0314_Outer;
                                }
                                break;
                            }
                            e4 = e;
                            while (e4.f()) {
                                a5 = e4.a();
                                d2 = a.d(a5.a(q));
                                if (d) {
                                    continue Label_0321;
                                }
                                if (d2 && this.z.b(a5.c()) != this.z.b(a5.d())) {
                                    h.a(a5, false);
                                }
                                e4.g();
                                if (d) {
                                    break;
                                }
                            }
                            break;
                        }
                        x2.g();
                        if (d) {
                            break;
                        }
                        continue Label_0314;
                    }
                }
                this.a(x, new y[] { y }, new y(), b, a, a2, h, c);
            }
            ++i;
            if (d) {
                break;
            }
        }
    }
    
    private void a(final X x, final y[] array, final y y, final boolean b, final A a, final A a2, final y.c.h h, final y.c.c c) {
        final boolean d = y.f.g.d.d;
        final y y2 = new y(y);
        int n = 0;
    Label_1150:
        do {
            int i = 0;
        Label_0190_Outer:
            while (i < array.length) {
                final y y3 = array[n];
                Label_1147: {
                    if (y3 != null && y3.size() > 0) {
                        Label_0763: {
                            Label_0533: {
                                if (this.I.d(y3.b())) {
                                    final q b2 = y3.b();
                                    final y y4 = this.A.get(this.z.b(b2));
                                    y.c.e e = this.J.f(b2).a();
                                    while (true) {
                                        while (e.f()) {
                                            final y.c.d a3 = e.a();
                                            final boolean d2 = a.d(a3.c());
                                            if (!d) {
                                                if (d2) {
                                                    y4.add(a3.c());
                                                }
                                                e.g();
                                                if (d) {
                                                    break;
                                                }
                                                continue Label_0190_Outer;
                                            }
                                            else {
                                                while (true) {
                                                    if (d2) {
                                                        final y.c.d a4 = e.a();
                                                        i = (a.d(a4.d()) ? 1 : 0);
                                                        if (d) {
                                                            continue Label_0190_Outer;
                                                        }
                                                        if (i != 0) {
                                                            y4.add(a4.d());
                                                        }
                                                        e.g();
                                                        if (!d) {
                                                            e.f();
                                                            continue Label_0190_Outer;
                                                        }
                                                    }
                                                    break;
                                                }
                                                final y.d.q q = (y.d.q)this.p.b(b2);
                                                x.a(b2, q);
                                                y.d.y y5 = null;
                                                final y.d.y y6 = (y.d.y)this.q.b(b2);
                                                if (y6 != null) {
                                                    final double n2 = q.a - y6.a;
                                                    final double n3 = q.b - y6.b;
                                                    y5 = new y.d.y(y6.c - n2, y6.d - n3, y6.a + 2.0 * n2, y6.b + 2.0 * n3);
                                                }
                                                final y.f.g.y a5 = this.a(y3, x, a, y5);
                                                x.a(b2, this.a(x, y2, a, y3, a5, !b, this.p));
                                                this.L.c(false);
                                                this.L.a((this.W == 2147483647L) ? 2147483647L : (this.W - System.currentTimeMillis() + this.u));
                                                this.L.a(x, new k(this, b2, c), h, y3, a5, this.E.get(y3), this.M);
                                                a.a(b2, true);
                                                if (d) {
                                                    break Label_0533;
                                                }
                                                break Label_0763;
                                            }
                                        }
                                        e = this.J.g(b2).a();
                                        continue;
                                    }
                                }
                            }
                            final y.f.g.y a6 = this.a(y3, x, a, null);
                            final t a7 = this.a(x, y2, a, y3, a6, !b, this.p);
                            final Rectangle2D c2 = this.c(x, y3);
                            ae.a(x, y3.a(), -(c2.getCenterX() - a7.a), -(c2.getCenterY() - a7.b));
                            this.L.c(this.b());
                            this.L.a((this.W == 2147483647L) ? 2147483647L : (this.W - System.currentTimeMillis() + this.u));
                            this.L.a(x, c, h, y3, a6, this.E.get(y3), this.M);
                            final x a8 = y3.a();
                            while (a8.f()) {
                                a.a(a8.e(), true);
                                a8.g();
                                if (d) {
                                    break Label_0763;
                                }
                                if (d) {
                                    break;
                                }
                            }
                            y2.addAll(y3);
                        }
                        final q a9 = this.J.a(y3.b());
                        if ((this.s || this.L.d()) && a9 != null) {
                            boolean b3;
                            if (this.I.d(a9)) {
                                b3 = this.a(x, a9, b, a2);
                            }
                            else {
                                b3 = this.a(a9, x, a);
                            }
                            this.J.a(a9);
                        Label_0849:
                            while (true) {
                                q q2 = null;
                                q a10 = q2;
                                while (b3) {
                                    q2 = a10;
                                    if (d) {
                                        continue Label_0849;
                                    }
                                    if (q2 == null) {
                                        break;
                                    }
                                    Label_0909: {
                                        if (this.I.d(a10)) {
                                            b3 = this.a(x, a10, b, a2);
                                            if (!d) {
                                                break Label_0909;
                                            }
                                        }
                                        b3 = this.a(a10, x, a);
                                    }
                                    a10 = this.J.a(a10);
                                    if (d) {
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if (this.Y) {
                            final f f = new f();
                            final x a11 = y3.a();
                            while (true) {
                                do {
                                    Label_0948: {
                                        a11.f();
                                    }
                                    boolean d3 = false;
                                    Label_0955:
                                    while (d3) {
                                        final q e2 = a11.e();
                                        final y.c.e j = e2.j();
                                        if (!d) {
                                            final y.c.e e3 = j;
                                            while (e3.f()) {
                                                final y.c.d a12 = e3.a();
                                                d3 = a.d(a12.a(e2));
                                                if (d) {
                                                    continue Label_0955;
                                                }
                                                if (d3 && this.z.b(a12.c()) != this.z.b(a12.d())) {
                                                    f.add(a12);
                                                }
                                                e3.g();
                                                if (d) {
                                                    break;
                                                }
                                            }
                                            a11.g();
                                            continue Label_0948;
                                        }
                                        final y.c.e e4 = j;
                                        while (e4.f()) {
                                            h.a(e4.a(), true);
                                            e4.g();
                                            if (d) {
                                                continue Label_1150;
                                            }
                                            if (d) {
                                                break;
                                            }
                                        }
                                        break Label_1147;
                                    }
                                    break;
                                } while (!d);
                                if (!f.isEmpty()) {
                                    this.a(x, f);
                                    f.a();
                                    continue;
                                }
                                break;
                            }
                        }
                    }
                }
                ++n;
            }
            break;
        } while (!d);
    }
    
    private void m(final X x) {
        final boolean d = y.f.g.d.d;
        int i = 0;
        while (i < this.o.length) {
            final y y = this.o[i];
            double b = this.b(x, y);
            int n = 0;
            this.a(x, y, true);
            final double b2 = this.b(x, y);
            if (b2 < b) {
                b = b2;
                n = 1;
            }
            Label_0150: {
                if (!this.M) {
                    this.a(x, y, false);
                    final double b3 = this.b(x, y);
                    if (b3 < b) {
                        b = b3;
                        n = 2;
                    }
                    this.a(x, y, true);
                    if (this.b(x, y) < b) {
                        n = 3;
                    }
                    this.a(x, y, false);
                    if (!d) {
                        break Label_0150;
                    }
                }
                this.a(x, y, true);
            }
            Label_0220: {
                switch (n) {
                    case 0: {
                        if (d) {
                            break Label_0220;
                        }
                        break;
                    }
                    case 1: {
                        this.a(x, y, true);
                        if (d) {
                            break Label_0220;
                        }
                        break;
                    }
                    case 2: {
                        this.a(x, y, true);
                        this.a(x, y, false);
                        if (d) {
                            break Label_0220;
                        }
                        break;
                    }
                    case 3: {
                        this.a(x, y, true);
                        this.a(x, y, false);
                        this.a(x, y, true);
                        break;
                    }
                }
            }
            ++i;
            if (d) {
                break;
            }
        }
    }
    
    private double b(final X x, final y y) {
        final boolean d = y.f.g.d.d;
        double n = 0.0;
        final y.c.e a = this.G.get(y).a();
        double n2 = 0.0;
        while (a.f()) {
            final y.c.d a2 = a.a();
            n2 = n + ae.a(x, a2.c(), a2.d());
            if (d) {
                return n2;
            }
            n = n2;
            a.g();
            if (d) {
                break;
            }
        }
        return n2;
    }
    
    private void a(final X x, final y y, final boolean b) {
        final boolean d = y.f.g.d.d;
        final f f = this.H.get(y);
        final Rectangle2D a = ae.a(x, y.a());
        ae.a(x, y.a(), 0.0 - a.getCenterX(), 0.0 - a.getCenterY());
        Label_0612: {
            Label_0338: {
                if (b) {
                    final x a2 = y.a();
                    while (a2.f()) {
                        final q e = a2.e();
                        x.a(e, -x.j(e), x.k(e));
                        a2.g();
                        if (d) {
                            break;
                        }
                    }
                    final y.c.e a3 = f.a();
                Label_0127:
                    while (a3.f()) {
                        final y.c.d a4 = a3.a();
                        final v j = x.j(a4);
                        final ArrayList<t> list = new ArrayList<t>();
                        if (d) {
                            return;
                        }
                        final u b2 = j.b();
                        while (b2.f()) {
                            final t a5 = b2.a();
                            list.add(new t(-a5.a(), a5.b()));
                            b2.g();
                            if (d) {
                                continue Label_0127;
                            }
                            if (d) {
                                break;
                            }
                        }
                        x.b(a4, new v(list));
                        final t n = x.n(a4);
                        x.a(a4, new t(-n.a(), n.b()));
                        final t o = x.o(a4);
                        x.b(a4, new t(-o.a(), o.b()));
                        a3.g();
                        if (d) {
                            break Label_0338;
                        }
                    }
                    break Label_0612;
                }
            }
            final x a6 = y.a();
            while (a6.f()) {
                final q e2 = a6.e();
                x.a(e2, x.j(e2), -x.k(e2));
                a6.g();
                if (d) {
                    break;
                }
            }
            final y.c.e a7 = f.a();
        Label_0401:
            while (a7.f()) {
                final y.c.d a8 = a7.a();
                final v i = x.j(a8);
                final ArrayList<t> list2 = new ArrayList<t>();
                if (d) {
                    return;
                }
                final u b3 = i.b();
                while (b3.f()) {
                    final t a9 = b3.a();
                    list2.add(new t(a9.a(), -a9.b()));
                    b3.g();
                    if (d) {
                        continue Label_0401;
                    }
                    if (d) {
                        break;
                    }
                }
                x.b(a8, new v(list2));
                final t n2 = x.n(a8);
                x.a(a8, new t(n2.a(), -n2.b()));
                final t o2 = x.o(a8);
                x.b(a8, new t(o2.a(), -o2.b()));
                a7.g();
                if (d) {
                    break;
                }
            }
        }
        ae.a(x, y.a(), a.getCenterX(), a.getCenterY());
    }
    
    private void a(final A a) {
        final boolean d = y.f.g.d.d;
        final A a2 = y.g.M.a();
        final x a3 = this.g.a();
        while (a3.f()) {
            a2.a(a3.e(), true);
            a3.g();
            if (d) {
                break;
            }
        }
        final y c = this.J.c(this.J.b());
        c.n();
        final x a4 = c.a();
        do {
            Label_0075: {
                a4.f();
            }
            boolean d2 = false;
            Label_0082:
            while (d2) {
                final q e = a4.e();
                if (this.J.d(e)) {
                    final x a5 = this.J.b(e).a();
                    while (a5.f()) {
                        final q e2 = a5.e();
                        d2 = a2.d(e2);
                        if (d) {
                            continue Label_0082;
                        }
                        if (d2 || a.d(e2)) {
                            a.a(e, true);
                            if (!d) {
                                break;
                            }
                        }
                        a5.g();
                        if (d) {
                            break;
                        }
                    }
                }
                a4.g();
                continue Label_0075;
            }
            break;
        } while (!d);
    }
    
    private i a(final X x, final A a, final y y) {
        final boolean d = y.f.g.d.d;
        final i i = new i();
        final A a2 = y.g.M.a();
        this.t = new y();
        final x o = x.o();
        while (true) {
            q e;
            q q;
            q d2;
            q d3;
            q q2;
            q d4;
            int j;
            q b;
            q a3;
            q q3;
            q d5 = null;
            x a4;
            boolean d6 = false;
            q e2;
            A a5 = null;
            Object b2 = null;
            q q4;
            q q5;
            q q6;
            D d7;
            q b3;
            A a6;
            int k;
            q b4;
            q q7;
            q a7;
            q q8;
            Label_0335_Outer:Label_0604_Outer:
            while (o.f()) {
                e = o.e();
                if (!d) {
                    q = e;
                    if (this.J.d(q)) {
                        d2 = i.d();
                        a.a(q, d2);
                        if (!this.I.d(q)) {
                            y.add(d2);
                            this.t.add(q);
                        }
                        d3 = i.d();
                        y.add(d3);
                        a2.a(q, d3);
                    }
                    o.g();
                    if (d) {
                        break;
                    }
                    continue;
                }
                else {
                    q2 = e;
                    y.add(q2);
                    d4 = i.d();
                    y.add(d4);
                    j = 0;
                    while (true) {
                        while (true) {
                            while (j < this.o.length) {
                                b = this.o[j].b();
                                a3 = this.J.a(b);
                                if (!d) {
                                    q3 = (q)((a3 != null) ? a.b(a3) : q2);
                                    Label_0300: {
                                        if (this.J.d(b)) {
                                            d5 = (q)a.b(b);
                                            if (!d) {
                                                break Label_0300;
                                            }
                                        }
                                        d5 = i.d();
                                        a.a(b, d5);
                                    }
                                    i.a(q3, d5);
                                    ++j;
                                    if (d) {
                                        break;
                                    }
                                    continue Label_0335_Outer;
                                }
                                else {
                                    a4 = this.t.a();
                                    Label_0607: {
                                        do {
                                            Label_0344: {
                                                a4.f();
                                            }
                                            Label_0351:
                                            while (d6) {
                                                e2 = a4.e();
                                                a5 = a;
                                                if (!d) {
                                                    a.b(e2);
                                                    Label_0376:
                                                    while (true) {
                                                        q4 = (q)b2;
                                                        q5 = this.J.a(e2);
                                                        while (q5 != null) {
                                                            d6 = this.I.d(q5);
                                                            if (d) {
                                                                continue Label_0351;
                                                            }
                                                            if (!d6) {
                                                                break;
                                                            }
                                                            q5 = this.J.a(q5);
                                                            if (d) {
                                                                break;
                                                            }
                                                        }
                                                        q6 = (q)((q5 != null) ? a.b(q5) : q2);
                                                        i.a(q4, q6);
                                                        d7 = (D)this.C.b(e2);
                                                        if (d7 != null) {
                                                            while (!d7.isEmpty()) {
                                                                b3 = ((y)d7.g()).b();
                                                                i.a((q)a.b(b3), q6);
                                                                if (this.I.d(b3)) {
                                                                    b2 = this.C.b(b3);
                                                                    if (d) {
                                                                        continue Label_0376;
                                                                    }
                                                                    if (b2 == null) {
                                                                        continue Label_0335_Outer;
                                                                    }
                                                                    d7.addAll((Collection)this.C.b(b3));
                                                                    if (d) {
                                                                        break;
                                                                    }
                                                                    continue Label_0335_Outer;
                                                                }
                                                            }
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                    a4.g();
                                                    continue Label_0344;
                                                }
                                                break Label_0607;
                                            }
                                            break;
                                        } while (!d);
                                        a5 = y.g.M.a();
                                    }
                                    a6 = a5;
                                    this.a(a6);
                                    k = 0;
                                    while (k < this.o.length) {
                                        b4 = this.o[k].b();
                                        q7 = (q)a.b(b4);
                                        a7 = this.J.a(b4);
                                        if (d) {
                                            return i;
                                        }
                                        q8 = (q)((a7 != null) ? a2.b(a7) : d4);
                                        Label_0734: {
                                            if (a6.d(b4)) {
                                                i.a(q7, q8);
                                                if (!d) {
                                                    break Label_0734;
                                                }
                                            }
                                            i.a(q8, q7);
                                        }
                                        ++k;
                                        if (d) {
                                            break;
                                        }
                                    }
                                    if (y.a.g.b(i)) {
                                        throw new RuntimeException("constraint graph is cyclic!");
                                    }
                                    return i;
                                }
                            }
                            if (this.s || this.L.d()) {
                                continue Label_0604_Outer;
                            }
                            break;
                        }
                        continue;
                    }
                }
            }
            i.d();
            continue;
        }
    }
    
    private void n(final X x) {
        final boolean d = y.f.g.d.d;
        final A a = y.g.M.a();
        final y y = new y();
        final y.f.g.l l = new y.f.g.l(this, x, this.a(x, a, y), a, y);
        final int length = this.o.length;
        int i = 0;
        while (i < length) {
            final y y2 = this.o[i];
            l.a(y2.b(), this.a(y2.b(), x, (y)this.A.get(this.z.b(y2.b()))));
            ++i;
            if (d) {
                break;
            }
        }
        final ArrayList<String> list = new ArrayList<String>();
        final y[] o = new y[length];
        int n = 0;
    Label_0460:
        while (!l.a()) {
            final q c = l.c();
            final y y3 = this.D.get(c);
            o[n] = y3;
            ++n;
            Object o2 = this.z.b(c);
        Label_0466:
            while (true) {
                list.add((String)o2);
                final x a2 = y3.a();
                do {
                    Label_0227: {
                        a2.f();
                    }
                    boolean equals = false;
                    Label_0234:
                    while (equals) {
                        final q e = a2.e();
                        if (d) {
                            break Label_0466;
                        }
                        final y.c.e e2 = (y.c.e)(o2 = e.j());
                        if (!d) {
                            final y.c.e e3 = e2;
                            while (e3.f()) {
                                final y.c.d a3 = e3.a();
                                final q a4 = a3.a(e);
                                final String s = (String)this.z.b(a4);
                                final y y4 = this.D.get(a4);
                                equals = s.equals("remain");
                                if (d) {
                                    continue Label_0234;
                                }
                                if (!equals && !list.contains(s) && l.a(y4.b())) {
                                    final y y5 = this.A.get(s);
                                    y5.add(e);
                                    ((f)this.B.get(s)).add(a3);
                                    l.b(y4.b(), this.a(y4.b(), x, y5));
                                }
                                e3.g();
                                if (d) {
                                    break;
                                }
                            }
                            a2.g();
                            continue Label_0227;
                        }
                        continue Label_0466;
                    }
                    continue Label_0460;
                } while (!d);
                break Label_0460;
            }
            return;
        }
        this.o = o;
    }
    
    private int a(final q q, final X x, final y y) {
        return ((this.Z == null) ? 1 : (this.Z.a(q) + 2)) * x.h() - y.size();
    }
    
    private t a(double n, double n2, final Rectangle2D rectangle2D, final y.d.y y) {
        final boolean d = y.f.g.d.d;
        final y.d.y y2 = new y.d.y(y.c() + rectangle2D.getWidth() / 2.0, y.d() + rectangle2D.getHeight() / 2.0, y.a() - rectangle2D.getWidth(), y.b() - rectangle2D.getHeight());
        final double c = y2.c();
        final double d2 = y2.d();
        final double a = y2.a();
        final double b = y2.b();
        if (!y2.a(n, n2)) {
            if (n <= c) {
                if (n2 <= d2) {
                    n = c;
                    n2 = d2;
                    if (!d) {
                        return new t(n, n2);
                    }
                }
                if (n2 <= d2 + b) {
                    n = c;
                    if (!d) {
                        return new t(n, n2);
                    }
                }
                if (n2 <= d2 + b) {
                    return new t(n, n2);
                }
                n = c;
                n2 = d2 + b;
                if (!d) {
                    return new t(n, n2);
                }
            }
            if (n <= c + a) {
                if (n2 <= d2) {
                    n2 = d2;
                    if (!d) {
                        return new t(n, n2);
                    }
                }
                if (n2 <= d2 + b) {
                    return new t(n, n2);
                }
                if (n2 <= d2 + b) {
                    return new t(n, n2);
                }
                n2 = d2 + b;
                if (!d) {
                    return new t(n, n2);
                }
            }
            if (n > c + a) {
                if (n2 <= d2) {
                    n = c + a;
                    n2 = d2;
                    if (!d) {
                        return new t(n, n2);
                    }
                }
                if (n2 <= d2 + b) {
                    n = c + a;
                    if (!d) {
                        return new t(n, n2);
                    }
                }
                if (n2 > d2 + b) {
                    n = c + a;
                    n2 = d2 + b;
                }
            }
        }
        return new t(n, n2);
    }
    
    private static y a(final X x, final y y, final A a) {
        final boolean d = y.f.g.d.d;
        final y y2 = new y();
        final y[] a2 = y.a.b.a(x, y);
        int n = 1;
        do {
            Label_0111: {
                int i = 0;
                while (i < a2.length) {
                    final y y3 = y2;
                    if (!d && y3.isEmpty()) {
                        final x a3 = a2[n].a();
                        while (a3.f()) {
                            final q e = a3.e();
                            i = (a.d(e) ? 1 : 0);
                            if (d) {
                                continue Label_0111;
                            }
                            if (i != 0) {
                                y2.add(e);
                            }
                            a3.g();
                            if (d) {
                                break;
                            }
                        }
                        break Label_0111;
                    }
                    return y3;
                }
                goto Label_0119;
            }
            ++n;
        } while (!d);
        goto Label_0119;
    }
    
    private static ax a(final y.c.d d, final boolean b, final X x) {
        final boolean d2 = d.d;
        final y.c.c c = b ? x.c(ax.a) : x.c(ax.b);
        if (c == null) {
            return null;
        }
        final Collection collection = (Collection)c.b(d);
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        final Iterator<ax> iterator = collection.iterator();
        ax ax = iterator.next();
        double f = ax.f();
        while (true) {
            while (iterator.hasNext()) {
                final ax ax2 = iterator.next();
                final double f2 = ax2.f();
                final double n = dcmpg(f2, f);
                if (!d2) {
                    if (n >= 0 && (f2 != f || ax.b() || ax2.b()) && (f2 != f || ax.a(255) || !ax2.a(255))) {
                        continue;
                    }
                    ax = ax2;
                    f = f2;
                    if (d2) {
                        break;
                    }
                    continue;
                }
                else {
                    if (n != 0 && !ax.b()) {
                        return null;
                    }
                    return ax;
                }
            }
            ax.a(255);
            continue;
        }
    }
    
    private static t b(final y.c.d d, final boolean b, final X x) {
        final q q = b ? d.c() : d.d();
        final aE ae = b ? aE.d(x, d) : aE.e(x, d);
        if (ae != null) {
            if (ae.a()) {
                return b ? x.p(d) : x.q(d);
            }
            if (!ae.g()) {
                final y.d.y s = x.s(q);
                if (ae.c()) {
                    return new t(s.c() + s.a() * 0.5, s.d());
                }
                if (ae.d()) {
                    return new t(s.c() + s.a() * 0.5, s.d() + s.b());
                }
                if (ae.f()) {
                    return new t(s.c(), s.d() + s.b() * 0.5);
                }
                if (ae.e()) {
                    return new t(s.c() + s.a(), s.d() + s.b() * 0.5);
                }
            }
        }
        final ax a = a(d, b, x);
        if (a != null) {
            if (a.b()) {
                final t l = x.l(q);
                return new t(l.a() + a.c(), l.b() + a.d());
            }
            if (!a.a(255)) {
                final y.d.y s2 = x.s(q);
                if (a.a() == 1) {
                    return new t(s2.c() + s2.a() * 0.5, s2.d());
                }
                if (a.a() == 2) {
                    return new t(s2.c() + s2.a() * 0.5, s2.d() + s2.b());
                }
                if (a.a() == 8) {
                    return new t(s2.c(), s2.d() + s2.b() * 0.5);
                }
                if (a.a() == 4) {
                    return new t(s2.c() + s2.a(), s2.d() + s2.b() * 0.5);
                }
            }
        }
        return x.l(q);
    }
    
    private t a(final y y, final f f, final t t, final X x) {
        final boolean d = y.f.g.d.d;
        final String s = (String)this.z.b(y.b());
        double n = 0.0;
        double n2 = 0.0;
        final y.c.e a = f.a();
        while (true) {
            while (a.f()) {
                final y.c.d a2 = a.a();
                final t b = b(a2, true, x);
                final t b2 = b(a2, false, x);
                final boolean equals = s.equals(this.z.b(a2.c()));
                final int size;
                final boolean b3 = (size = (equals ? 1 : 0)) != 0;
                if (d) {
                    final int n3 = size;
                    return new t(n / n3, n2 / n3);
                }
                final double n4 = b3 ? (b2.a - b.a) : (b.a - b2.a);
                final double n5 = equals ? (b2.b - b.b) : (b.b - b2.b);
                n += t.a() + n4;
                n2 += t.b() + n5;
                a.g();
                if (d) {
                    break;
                }
            }
            int size = f.size();
            continue;
        }
    }
    
    private t a(final X x, final y y, final A a, final y y2, final y.f.g.y y3, final boolean b, final A a2) {
        final boolean d = y.f.g.d.d;
        final String s = (String)this.z.b(y2.b());
        final y y4 = this.A.get(s);
        final Rectangle2D c = this.c(x, y2);
        final t t = new t(c.getCenterX(), c.getCenterY());
        double n = 0.0;
        double n2 = 0.0;
        Label_0416: {
            Label_0402: {
                if (b) {
                    if (y4.size() > 0) {
                        Label_0200: {
                            if (this.I.d(y2.b())) {
                                final x a3 = y4.a();
                                while (true) {
                                    while (a3.f()) {
                                        final q e = a3.e();
                                        n += x.j(e);
                                        n2 += x.k(e);
                                        a3.g();
                                        if (!d) {
                                            if (d) {
                                                break;
                                            }
                                            continue;
                                        }
                                        else {
                                            if (d) {
                                                break Label_0200;
                                            }
                                            break Label_0416;
                                        }
                                    }
                                    n /= y4.size();
                                    n2 /= y4.size();
                                    continue;
                                }
                            }
                        }
                        final t a4 = this.a(y2, this.B.get(s), t, x);
                        n = a4.a();
                        n2 = a4.b();
                        if (!d) {
                            break Label_0416;
                        }
                    }
                    final y a5 = a(x, y2, a);
                    if (a5.isEmpty()) {
                        n = ((this.T != null) ? this.T.a : 0.0);
                        n2 = ((this.T != null) ? this.T.b : 0.0);
                        if (!d) {
                            break Label_0416;
                        }
                    }
                    final x a6 = a5.a();
                    while (true) {
                        while (a6.f()) {
                            final q e2 = a6.e();
                            n += x.j(e2);
                            n2 += x.k(e2);
                            a6.g();
                            if (!d) {
                                if (d) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (d) {
                                    break Label_0402;
                                }
                                break Label_0416;
                            }
                        }
                        n /= a5.size();
                        n2 /= a5.size();
                        continue;
                    }
                }
            }
            n = c.getCenterX();
            n2 = c.getCenterY();
        }
        if (y3 != null && y3.a != null) {
            final t a7 = this.a(n, n2, c, y3.a);
            n = a7.a();
            n2 = a7.b();
        }
        if (this.M) {
            final y.f.g.a a8 = new y.f.g.a();
            a8.a(this.P);
            final SortedSet a9 = a8.a(x, y2, y, a, this.G, new t(n, n2), this.b(), y3, this.I, a2);
            this.E.put(y2, a9);
            if (a9.size() <= 0) {
                return this.T = new t(n, n2);
            }
            final m m = a9.iterator().next();
            if (m == null) {
                return this.T = new t(n, n2);
            }
            n2 = m.c().b();
            if (y3 == null || y3.a == null) {
                return this.T = new t(n, n2);
            }
            final double n3 = y3.a.d + c.getHeight() / 2.0;
            final double n4 = y3.a.d + y3.a.b - c.getHeight() / 2.0;
            if (n3 > n2) {
                n2 = n3;
                if (!d) {
                    return this.T = new t(n, n2);
                }
            }
            if (n4 >= n2) {
                return this.T = new t(n, n2);
            }
            n2 = n4;
            if (!d) {
                return this.T = new t(n, n2);
            }
        }
        if (this.b()) {
            final z z = new z();
            final t t2 = new t(n, n2);
            y.f.g.b b2;
            if (y3 == null || y3.a == null) {
                b2 = new y.f.g.b(-10000.0, -10000.0, 30000.0, 30000.0, t2);
            }
            else {
                b2 = new y.f.g.b(y3.a.c(), y3.a.d(), y3.a.a(), y3.a.b(), t2);
            }
            this.E.put(y2, z.a(x, y, y2, b2, t2, false));
        }
        return this.T = new t(n, n2);
    }
    
    private void o(final X x) {
        if (this.O) {
            this.a(x, x.p());
        }
    }
    
    private static double a(final y.c.d d, final X x) {
        final y.d.y s = x.s(d.c());
        final y.d.y s2 = x.s(d.d());
        if (s.d() + s.b() < s2.d()) {
            return s2.d() - s.d() + s.b();
        }
        if (s2.d() + s2.b() < s.d()) {
            return s.d() - s2.d() + s2.b();
        }
        return 0.0;
    }
    
    protected void a(final X x, final f f) {
        this.a(x, f.a());
    }
    
    protected void b(final X x, final f f) {
        this.a(x, f.a());
    }
    
    private void a(final X x, final y.c.e e) {
        final boolean d = y.f.g.d.d;
        final y.c.h u = x.u();
        while (e.f()) {
            u.a(e.a(), true);
            e.g();
            if (d) {
                break;
            }
        }
        final String s = "y.layout.partial.PartialLayouter.ROUTE_EDGE_DPKEY";
        final y.c.c c = x.c(s);
        x.a(s, u);
        Label_0148: {
            if (this.S) {
                this.p(x);
                if (!d) {
                    break Label_0148;
                }
            }
            if (this.v == 0) {
                this.b(x, u);
                if (!d) {
                    break Label_0148;
                }
            }
            if (this.v == 1) {
                this.q(x);
                if (!d) {
                    break Label_0148;
                }
            }
            if (this.v == 2) {
                this.a(x, u);
                if (!d) {
                    break Label_0148;
                }
            }
            if (this.v == 3) {
                this.b(x, (y.c.c)u);
            }
        }
        x.d_(s);
        if (c != null) {
            x.a(s, c);
        }
        x.a(u);
    }
    
    private static boolean a(final X x, final y.c.c c) {
        final boolean d = y.f.g.d.d;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        final y.c.e p2 = x.p();
        while (p2.f()) {
            final y.c.d a = p2.a();
            if (d) {
                return true;
            }
            if (c == null || c.d(a)) {
                ++n;
                final v l = x.l(a);
                if (l.h() == 2) {
                    ++n3;
                }
                final s j = l.j();
                double n4 = 0.0;
                Label_0189: {
                    while (j.f()) {
                        final m a2 = j.a();
                        final double abs = Math.abs(a2.j());
                        final double abs2 = Math.abs(a2.k());
                        n4 = dcmpl(abs, 0.001);
                        if (d || (n4 > 0 && abs2 > 0.001 && Math.abs(abs - abs2) > 0.001 && !d)) {
                            break Label_0189;
                        }
                        j.g();
                        if (d) {
                            goto Label_0187;
                        }
                    }
                    goto Label_0187;
                }
                if (n4 != 0) {
                    ++n2;
                }
            }
            p2.g();
            if (d) {
                break;
            }
        }
        if (n2 == n || (n2 > n3 && n2 > 0.5 * n)) {
            return true;
        }
        return false;
    }
    
    private void a(final X x, final y.c.h h) {
        final ah r = this.R;
        final y.f.g.h h2 = new y.f.g.h(this, x.c(y.f.g.d.a), x.c(y.f.g.d.b));
        final boolean b = ae.b(x, h2);
        Label_0135: {
            if (b || a(x, h2)) {
                final y.f.i.a.y r2 = new y.f.i.a.y();
                r2.a("y.layout.partial.PartialLayouter.ROUTE_EDGE_DPKEY");
                r2.a(!b);
                this.R = r2;
                this.b(x, h);
                if (!y.f.g.d.d) {
                    break Label_0135;
                }
            }
            final y.f.g.i r3 = new y.f.g.i();
            r3.a("y.layout.partial.PartialLayouter.ROUTE_EDGE_DPKEY");
            this.R = r3;
            this.q(x);
        }
        this.R = r;
    }
    
    private void b(final X x, final y.c.h h) {
        final boolean d = y.f.g.d.d;
        this.c(this.R);
        final y.c.c c = x.c(aF.a);
        final y.c.c c2 = x.c(aF.b);
        boolean d2 = false;
        Label_0263: {
            if (this.M) {
                final A a = y.g.M.a();
                final A a2 = y.g.M.a();
                x.a(aF.a, a);
                x.a(aF.b, a2);
                final y.c.e p2 = x.p();
                while (p2.f()) {
                    final y.c.d a3 = p2.a();
                    final y.f.i.a.x c3 = ((y.f.i.a.y)this.R).c();
                    final double n = c3.a() + c3.b() + 5.0;
                    d2 = h.d(a3);
                    if (d) {
                        break Label_0263;
                    }
                    Label_0226: {
                        if (d2 && a(a3, x) >= n) {
                            if (x.k(a3.c()) < x.k(a3.d())) {
                                a.a(a3, aE.a((byte)2));
                                a2.a(a3, aE.a((byte)1));
                                if (!d) {
                                    break Label_0226;
                                }
                            }
                            a.a(a3, aE.a((byte)1));
                            a2.a(a3, aE.a((byte)2));
                        }
                    }
                    p2.g();
                    if (d) {
                        break;
                    }
                }
            }
            ((y.f.i.a.y)this.R).a((byte)2);
            this.R.c(x);
            final boolean m = this.M;
        }
        if (d2) {
            x.d_(aF.a);
            if (c != null) {
                x.a(aF.a, c);
            }
            x.d_(aF.b);
            if (c2 != null) {
                x.a(aF.b, c2);
            }
        }
    }
    
    private void p(final X x) {
        this.c(this.R);
        this.R.c(x);
    }
    
    private void q(final X x) {
        this.c(this.R);
        this.R.c(x);
    }
    
    private void b(final X x, final y.c.c c) {
        final y.c.c c2 = x.c(y.f.i.q.a);
        x.a(y.f.i.q.a, c);
        this.c(this.R);
        this.R.c(x);
        x.d_(y.f.i.q.a);
        if (c2 != null) {
            x.a(y.f.i.q.a, c2);
        }
    }
    
    protected void c(final ah ah) {
        if (this.S) {
            return;
        }
        if (ah instanceof y.f.i.a.y) {
            final y.f.i.a.y y = (y.f.i.a.y)ah;
            y.a(4.0);
            y.a(this.v == 4);
            final y.f.i.a.x c = y.c();
            c.a(5.0);
            c.a((byte)(this.M ? 1 : 0));
        }
    }
    
    private Rectangle2D c(final X x, final y y) {
        return ae.a(x, y.a());
    }
    
    private void a(final X x, final I i) {
        final boolean d = y.f.g.d.d;
        final y.c.c c = x.c(bk.b);
        if (c != null) {
            final y.c.e p2 = x.p();
            while (p2.f()) {
                final y.c.d a = p2.a();
                final bh bh = (bh)c.b(a.c());
                final bh bh2 = (bh)c.b(a.d());
                if (bh != null && bh2 != null && !bh.equals(bh2)) {
                    i.a(a);
                }
                p2.g();
                if (d) {
                    break;
                }
            }
        }
    }
    
    private void b(final X x, final I i) {
        final boolean d = y.f.g.d.d;
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            if (this.J.d(e)) {
                y.c.e e2 = this.J.f(e).a();
                y.c.d d2 = null;
                i k = null;
                i a;
                i j;
                Label_0082_Outer:Label_0117_Outer:Label_0141_Outer:Label_0174_Outer:
                while (true) {
                    while (true) {
                        while (true) {
                            Label_0198: {
                            Label_0167:
                                while (true) {
                                    while (true) {
                                        Label_0103: {
                                            if (!e2.f()) {
                                                break Label_0103;
                                            }
                                            d2 = e2.a();
                                            j = (a = (k = d2.a()));
                                            if (d) {
                                                break Label_0198;
                                            }
                                            if (a != null) {
                                                i.a(d2);
                                            }
                                            e2.g();
                                            if (!d) {
                                                continue Label_0082_Outer;
                                            }
                                        }
                                        e2 = this.J.g(e).a();
                                        if (!e2.f()) {
                                            break Label_0167;
                                        }
                                        d2 = e2.a();
                                        j = (a = d2.a());
                                        if (d) {
                                            continue Label_0117_Outer;
                                        }
                                        break;
                                    }
                                    if (j != null) {
                                        i.a(d2);
                                    }
                                    e2.g();
                                    if (!d) {
                                        continue Label_0141_Outer;
                                    }
                                    break;
                                }
                                e2 = e.j();
                                if (!e2.f()) {
                                    break;
                                }
                                d2 = e2.a();
                                j = (a = (k = d2.a()));
                            }
                            if (d) {
                                continue Label_0174_Outer;
                            }
                            break;
                        }
                        if (k != null) {
                            i.a(d2);
                        }
                        e2.g();
                        if (d) {
                            break;
                        }
                        continue;
                    }
                }
            }
            o.g();
            if (d) {
                break;
            }
        }
    }
    
    private void a(final X x, final t t) {
        if (this.K != null && t != null) {
            final t l = x.l(this.K);
            if (l.a() != t.a() || l.b() != t.b()) {
                ae.a(x, x.o(), -(l.a() - t.a()), -(l.b() - t.b()));
            }
        }
    }
    
    private static y[] a(final i i, final y y) {
        final boolean d = y.f.g.d.d;
        if (y == null || y.isEmpty()) {
            return new y[0];
        }
        final A t = i.t();
        y.a.j.a(i, t, false, 1, i.f(), null);
        final q[] e = y.e();
        Arrays.sort(e, y.g.e.b(t));
        int a = t.a(e[0]);
        int n = 0;
        int j = 0;
        while (true) {
            while (j < e.length) {
                final q q = e[j];
                final int a2;
                final int n2 = a2 = t.a(q);
                final int n3 = a;
                if (d) {
                    final y[] array = new y[a2 + n3];
                    int k = 0;
                    while (true) {
                        while (k < array.length) {
                            array[k] = new y();
                            ++k;
                            if (d) {
                                while (k < e.length) {
                                    final q q2 = e[k];
                                    array[t.a(q2)].add(q2);
                                    ++k;
                                    if (d) {
                                        return array;
                                    }
                                    if (d) {
                                        break;
                                    }
                                }
                                i.a(t);
                                return array;
                            }
                            if (d) {
                                break;
                            }
                        }
                        k = 0;
                        continue;
                    }
                }
                if (a2 != n3) {
                    a = n2;
                    ++n;
                }
                t.a(q, n);
                ++j;
                if (d) {
                    break;
                }
            }
            continue;
        }
    }
    
    static c a(final d d) {
        return d.J;
    }
    
    static {
        a = "y.layout.partial.PartialLayouter.PARTIAL_NODES_DPKEY";
        b = "y.layout.partial.PartialLayouter.PARTIAL_EDGES_DPKEY";
        c = "y.layout.PartialLayouter.COMPONENT_ASSIGNMENT_DPKEY";
        aa = new r(0.0, 0.0, 0.0, 0.0);
    }
}
