package y.f.i;

import java.awt.geom.*;
import y.g.*;
import y.d.*;
import y.f.b.*;
import y.f.*;
import java.util.*;
import java.awt.*;
import y.c.*;

public class q implements ad
{
    private ah b;
    private X c;
    private Rectangle2D.Double d;
    private double e;
    private ArrayList[][] f;
    private D g;
    private D h;
    private double i;
    private double n;
    private double o;
    private double p;
    private int q;
    private int r;
    private int s;
    private ar t;
    private double u;
    private double v;
    private double w;
    private double x;
    private int y;
    private int z;
    public static final Object a;
    private double A;
    private boolean B;
    private boolean C;
    private boolean D;
    private ArrayList E;
    
    public q() {
        this(10.0);
    }
    
    public q(final double a) {
        this.D = true;
        this.A = a;
    }
    
    public void c(final X x) {
        final int f = y.f.i.v.f;
        boolean b = false;
        if (x.c("y.layout.router.ORGANIC_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY") == null) {
            this.a(x);
            x.a("y.layout.router.ORGANIC_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY", y.g.q.a(Boolean.TRUE));
            b = true;
        }
        if (this.b != null) {
            this.b.c(x);
        }
        final I i = new I(x);
        final h u = x.u();
        y a = null;
        if (this.D) {
            a = this.a(x, u, i);
        }
        this.E = new ArrayList(x.f());
        c c = null;
        Label_0223: {
            if (this.b(x)) {
                c = x.c(y.f.i.q.a);
                final e p = x.p();
                while (p.f()) {
                    final d a2 = p.a();
                    if (f != 0) {
                        break Label_0223;
                    }
                    if (c == null || c.d(a2)) {
                        if (!this.B) {
                            ae.a(x, a2);
                        }
                        this.a(a2);
                        if (this.a(x.l(a2))) {
                            ae.a(x, a2);
                        }
                    }
                    p.g();
                    if (f != 0) {
                        break;
                    }
                }
                this.c();
            }
        }
        if (this.D) {
            this.a(a, x, u, i);
        }
        x.a(u);
        final aN an = new aN();
        an.a((byte)1);
        if (c != null) {
            x.a(aN.a, y.g.q.a(c));
        }
        an.c(x);
        if (c != null) {
            x.d_(aN.a);
        }
        if (b) {
            x.d_("y.layout.router.ORGANIC_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY");
        }
    }
    
    private boolean a(final y.d.v v) {
        final int f = v.f;
        final t[] f2 = v.f();
        if (f2.length > 2) {
            int i = 0;
            while (i < f2.length - 2) {
                final t t = f2[i];
                final t t2 = f2[i + 1];
                final double n = y.d.z.d(new z(t, t2), new z(t2, f2[i + 2])) * 180.0 / 3.141592653589793;
                final double n2 = dcmpl(n, 90.0);
                if (f != 0 || (n2 > 0 && n < 270.0 && f == 0)) {
                    return n2 != 0.0;
                }
                ++i;
                if (f != 0) {
                    goto Label_0137;
                }
            }
            goto Label_0137;
        }
        goto Label_0137;
    }
    
    private void a(final X x) {
        this.a(x, x);
    }
    
    private void a(final n n, final O o) {
        final int f = y.f.i.v.f;
        c c = n.c(y.f.b.f.d);
        if (c == null) {
            c = y.g.q.a(Boolean.FALSE);
        }
        final Iterator x = n.x();
        while (x.hasNext()) {
            final Object next = x.next();
            if (!c.d(next)) {
                this.a(o, next);
                if (f == 0) {
                    continue;
                }
            }
            this.b(o, next);
            if (f != 0) {
                break;
            }
        }
    }
    
    protected void a(final O o, final Object o2) {
        final am a = o.a(o2);
        if (a.getWidth() == 0.0 || a.getHeight() == 0.0) {
            throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        }
    }
    
    protected void b(final O o, final Object o2) {
        final am a = o.a(o2);
        if (a.getWidth() == 0.0 || a.getHeight() == 0.0) {
            throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        }
    }
    
    private void a(final y y, final X x, final h h, final I i) {
        final int f = y.f.i.v.f;
        if (y == null) {
            return;
        }
        i.f();
        final x a = y.a();
    Label_0125_Outer:
        while (a.f()) {
            final y.c.q e = a.e();
            final e j = e.j();
            while (true) {
                while (j.f()) {
                    final d a2 = j.a();
                    x.a((d)h.b(a2), x.l(a2));
                    j.g();
                    if (f == 0) {
                        if (f != 0) {
                            break;
                        }
                        continue Label_0125_Outer;
                    }
                    else {
                        if (f != 0) {
                            break Label_0125_Outer;
                        }
                        continue Label_0125_Outer;
                    }
                }
                x.a(e);
                a.g();
                continue;
            }
        }
    }
    
    private y.c.q b(final y y, final X x, final h h, final I i) {
        final int f = y.f.i.v.f;
        if (y.size() < 2) {
            return null;
        }
        final y.c.q d = x.d();
        double max = 0.0;
        double max2 = 0.0;
        final x a = y.a();
        while (true) {
            while (a.f()) {
                final y.c.q e = a.e();
                max = Math.max(max, x.p(e));
                max2 = Math.max(max2, x.q(e));
                a.g();
                if (f != 0) {
                    final x a2 = y.a();
                    y.c.q e2 = null;
                    while (a2.f()) {
                        final y.c.q q = e2 = a2.e();
                        Label_0283: {
                            if (f == 0) {
                                final e j = e2.j();
                                while (j.f()) {
                                    final d a3 = j.a();
                                    final y.d.v l = x.l(a3);
                                    final y.c.q c = a3.c();
                                    if (f != 0) {
                                        break Label_0283;
                                    }
                                    final d d2 = (c == q) ? x.a(d, a3.d()) : x.a(a3.c(), d);
                                    x.a(d2, l);
                                    h.a(d2, a3);
                                    i.a(a3);
                                    j.g();
                                    if (f != 0) {
                                        break;
                                    }
                                }
                                i.a(q);
                                a2.g();
                                if (f == 0) {
                                    continue;
                                }
                            }
                        }
                        return e2;
                    }
                    return e2;
                }
                if (f != 0) {
                    break;
                }
            }
            x.b(d, max, max2);
            x.a(d, x.l(y.b()));
            continue;
        }
    }
    
    private y a(final X x, final h h, final I i) {
        final int f = y.f.i.v.f;
        final y y = new y();
        if (x.f() < 2) {
            return y;
        }
        final y.c.q[] m = x.m();
        y.g.e.a(m, new y.f.i.t(x));
        t l = x.l(m[0]);
        final y y2 = new y(m[0]);
        int j = 1;
        while (j < m.length) {
            final y.c.q q = m[j];
            final t k = x.l(q);
            Label_0161: {
                if (l.equals(k)) {
                    y2.add(q);
                    if (f == 0) {
                        break Label_0161;
                    }
                }
                if (y2.size() > 1) {
                    y.add(this.b(y2, x, h, i));
                }
                l = k;
                y2.clear();
                y2.add(q);
            }
            ++j;
            if (f != 0) {
                break;
            }
        }
        return y;
    }
    
    private boolean b(final X c) {
        final int f = y.f.i.v.f;
        this.c = c;
        this.g = new D();
        this.h = new D();
        this.d = new Rectangle2D.Double();
        final Rectangle a = c.a();
        this.d.setFrame(a.x, a.y, a.width, a.height);
        this.t = new ar(42L);
        final int n = 1 + c.e();
        this.q = Math.max(1, (int)Math.ceil(Math.sqrt(n) * this.d.width / this.d.height));
        this.r = Math.max(1, (int)Math.ceil(n / this.q));
        this.o = this.d.width / this.q;
        this.p = this.d.height / this.r;
        this.f = new ArrayList[this.r][this.q];
        final int n2 = 5 + c.e() / (4 * this.r * this.q);
        int i = this.r - 1;
    Label_0284_Outer:
        while (i >= 0) {
            final ArrayList[] array = this.f[i];
            int j = this.q - 1;
            while (true) {
                while (j >= 0) {
                    array[j] = new ArrayList(n2);
                    --j;
                    if (f == 0) {
                        if (f != 0) {
                            break;
                        }
                        continue Label_0284_Outer;
                    }
                    else {
                        if (f != 0) {
                            break Label_0284_Outer;
                        }
                        continue Label_0284_Outer;
                    }
                }
                --i;
                continue;
            }
        }
        final x o = c.o();
        while (o.f()) {
            final y.c.q e = o.e();
            final am a2 = c.a((Object)e);
            this.a(e.d(), a2.getX(), a2.getY(), a2.getWidth(), a2.getHeight(), this.A);
            o.g();
            if (f != 0) {
                return c != null;
            }
            if (f != 0) {
                break;
            }
        }
        if (this.D) {
            this.b();
        }
        this.a(this.A);
        this.s = 0;
        return c != null;
    }
    
    private void b() {
        final int i = y.f.i.v.f;
        int n = 0;
        do {
            double n2 = 0.0;
            Label_0007: {
                n2 = n;
            }
            Label_0008:
            while (n2 < this.E.size()) {
                final u u = this.E.get(n);
                int j = n + 1;
                while (j < this.E.size()) {
                    final u u2 = this.E.get(j);
                    final double a = y.d.t.a(u.a, u.b, u2.a, u2.b);
                    final double n3 = u.e + u2.e + 3.0;
                    final double n4 = n2 = dcmpg(a, n3);
                    if (i != 0) {
                        continue Label_0008;
                    }
                    if (n4 < 0) {
                        final double n5 = a / n3;
                        final double n6 = u.e * n5;
                        final double n7 = u2.e * n5;
                        u.d = Math.min(u.d, n6);
                        u2.d = Math.min(u2.d, n7);
                    }
                    ++j;
                    if (i != 0) {
                        break;
                    }
                }
                ++n;
                continue Label_0007;
            }
            break;
        } while (i == 0);
    }
    
    private void a(final int n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final u u = new u(n, n2 + n4 / 2.0, n3 + n5 / 2.0, Math.sqrt(n4 * n4 + n5 * n5) * 0.5 + n6, 2.0);
        this.E.add(u);
        this.a(u);
    }
    
    private void a(final u u) {
        final int f = y.f.i.v.f;
        final int max = Math.max(0, (int)((u.a - u.d - this.d.x) / this.o));
        final int max2 = Math.max(0, (int)((u.b - u.d - this.d.y) / this.p));
        final int min = Math.min(this.q - 1, (int)((u.a + u.d - this.d.x) / this.o));
        final int min2 = Math.min(this.r - 1, (int)((u.b + u.d - this.d.y) / this.p));
        int i = max2;
    Label_0184_Outer:
        while (i <= min2) {
            final ArrayList[] array = this.f[i];
            int j = max;
            while (true) {
                while (j <= min) {
                    array[j].add(u);
                    ++j;
                    if (f == 0) {
                        if (f != 0) {
                            break;
                        }
                        continue Label_0184_Outer;
                    }
                    else {
                        if (f != 0) {
                            break Label_0184_Outer;
                        }
                        continue Label_0184_Outer;
                    }
                }
                ++i;
                continue;
            }
        }
    }
    
    private boolean a(final double n, final double n2, final double n3, final double n4, final int n5, final int n6) {
        final int i = y.f.i.v.f;
        final double n7 = n3 - n;
        final double n8 = n4 - n2;
        final double sqrt = Math.sqrt(n7 * n7 + n8 * n8);
        final int n9 = (int)Math.floor((Math.min(n, n3) - this.d.x - this.x) / this.o);
        final int n10 = (int)Math.floor((Math.min(n2, n4) - this.d.y - this.x) / this.p);
        final int n11 = (int)Math.floor((Math.max(n, n3) - this.d.x + this.x) / this.o) + 1;
        final int n12 = (int)Math.floor((Math.max(n2, n4) - this.d.y + this.x) / this.p) + 1;
        final int max = Math.max(0, n9);
        final int max2 = Math.max(0, n10);
        Math.min(n11, this.f[0].length);
        final int min = Math.min(n12, this.f.length);
        ++this.s;
        int n13 = max2;
        int n14 = 0;
        do {
            int j = 0;
        Label_0215:
            while (j < min) {
                final ArrayList[] array = this.f[n13];
                n14 = max;
                if (i != 0) {
                    return n14 != 0;
                }
                int n15 = n14;
                do {
                    int k = 0;
                    int s = 0;
                Label_0242:
                    while (k < s) {
                        final ArrayList list = array[n15];
                        j = list.size() - 1;
                        if (i != 0) {
                            continue Label_0215;
                        }
                        int l = j;
                        while (l >= 0) {
                            final u u = list.get(l);
                            k = u.c;
                            s = this.s;
                            if (i != 0) {
                                continue Label_0242;
                            }
                            if (k != s) {
                                u.c = this.s;
                                if (u.g != n5) {
                                    if (u.g != n6) {
                                        final double n16 = u.a - n;
                                        final double n17 = u.b - n2;
                                        final double n18 = (n16 * n7 + n17 * n8) / sqrt;
                                        final double n19 = -n18 / sqrt;
                                        final double n20 = n16 + n19 * n7;
                                        final double n21 = n17 + n19 * n8;
                                        final double sqrt2 = Math.sqrt(n20 * n20 + n21 * n21);
                                        if (sqrt2 <= u.d) {
                                            if (Math.sqrt(n16 * n16 + n17 * n17) < u.d) {
                                                return true;
                                            }
                                            final double n22 = u.a - n3;
                                            final double n23 = u.b - n4;
                                            if (Math.sqrt(n22 * n22 + n23 * n23) < u.d) {
                                                return true;
                                            }
                                            if (n18 >= 0.0 && n18 < sqrt && sqrt2 < u.d) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                            --l;
                            if (i != 0) {
                                break;
                            }
                        }
                        ++n15;
                    }
                    break;
                } while (i == 0);
                ++n13;
            }
            break;
        } while (i == 0);
        return n14 != 0;
    }
    
    private void a(final double a) {
        this.u = 1.5 + a * 0.05;
        this.A = a;
        this.v = a * 0.6;
        this.w = 0.1;
        this.n = 2.0 * a;
        this.n *= this.n;
        this.i = 0.5 * a;
        this.i *= this.i;
        this.x = 2.0 * a + 100.0;
    }
    
    private void c() {
        this.c = null;
        this.g = null;
        this.f = null;
        this.h = null;
    }
    
    private void a(final d d) {
        final int f = y.f.i.v.f;
        final y.c.q c = d.c();
        final y.c.q d2 = d.d();
        this.y = c.d();
        this.z = d2.d();
        final y.f.I b = this.c.b((Object)d);
        this.g.clear();
        final t targetPoint = b.getTargetPoint();
        final am a = this.c.a((Object)d2);
        final t t = new t(a.getX() + a.getWidth() * 0.5 + targetPoint.a, a.getY() + a.getHeight() * 0.5 + targetPoint.b);
        final t sourcePoint = b.getSourcePoint();
        final am a2 = this.c.a((Object)c);
        final t t2 = new t(a2.getX() + a2.getWidth() * 0.5 + sourcePoint.a, a2.getY() + a2.getHeight() * 0.5 + sourcePoint.b);
        int n = 6;
        final double a3 = this.A;
        this.a(this.A = a3 * (1 << n));
        this.e = 0.0;
        final s a4 = this.a(t.a, t.b);
        a4.i = this.g.b(a4);
        Label_0427: {
            if (b.pointCount() > 0) {
                t t3 = new t(t.a, t.b);
                int i = b.pointCount() - 1;
                while (i >= 0) {
                    final t point = b.getPoint(i);
                    final boolean d3 = this.D;
                    if (f != 0) {
                        break Label_0427;
                    }
                    if (!d3 || y.d.t.a(t3, point) >= a3 + 20.0) {
                        final s a5 = this.a(point.a, point.b);
                        a5.i = this.g.a(a5);
                        t3 = point;
                    }
                    --i;
                    if (f != 0) {
                        break;
                    }
                }
            }
            final s a6 = this.a(t2.a, t2.b);
            a6.i = this.g.a(a6);
        }
        boolean a7 = false;
        if (!this.C || f != 0) {
            final p l = this.g.l();
            p p = this.g.k();
            while (p != l) {
                final s s = (s)p.c();
                final s s2 = (s)p.a().c();
                a7 = this.a(s.b, s.c, s2.b, s2.c, this.y, this.z);
                if (f != 0) {
                    break;
                }
                if (a7) {
                    break;
                }
                p = p.a();
                if (f != 0) {
                    break;
                }
            }
        }
        int n2 = 0;
        Label_1047: {
            Label_1033: {
                if (a7) {
                    while (this.g.size() < 8) {
                        n2 = n;
                        if (f != 0) {
                            break Label_1047;
                        }
                        if (n2 <= 0) {
                            break;
                        }
                        --n;
                        this.a(this.A = a3 * (1 << n));
                        this.c(this.A);
                        if (f != 0) {
                            break;
                        }
                    }
                    final r r = new r();
                    this.b(this.u);
                    int max = Math.max(n, 1);
                    int n3 = 1;
                    while (a3 * (1 << max) > Math.max(10.0, a3 * 0.2) && max >= 0) {
                        if (n3 == 0) {
                            this.a(this.A = a3 * (1 << max));
                            this.c(this.A);
                            this.b(this.u);
                        }
                        n3 = 0;
                        --max;
                        int n4 = 150 - max * 20;
                        int n5 = 30;
                    Label_0737:
                        while (true) {
                            if (n5-- <= 0) {
                                if (n4-- <= 0) {
                                    break;
                                }
                                final double n7;
                                final double n6 = n7 = dcmpl(this.e / this.g.size(), 1.2 * (max + 2));
                                if (f != 0) {
                                    break Label_1047;
                                }
                                if (n6 < 0) {
                                    break;
                                }
                            }
                            Label_1009: {
                                if (this.g.size() > 2) {
                                    final p j = this.g.l();
                                    final s s4;
                                    final s s3 = s4 = (s)this.g.k().c();
                                    final double k = 0.0;
                                    s3.n = k;
                                    s3.m = k;
                                    s4.l = k;
                                    p p2 = this.g.k().a();
                                    while (true) {
                                        while (p2 != null) {
                                            this.b((s)p2.c());
                                            p2 = p2.a();
                                            if (f != 0) {
                                                while (true) {
                                                    while (p2 != j) {
                                                        final s s5 = (s)p2.c();
                                                        this.a(s5, r, this.a(s5, r));
                                                        p2 = p2.a();
                                                        if (f != 0) {
                                                            while (p2 != j) {
                                                                this.c((s)p2.c());
                                                                p2 = p2.a();
                                                                if (f != 0) {
                                                                    continue Label_0737;
                                                                }
                                                                if (f != 0) {
                                                                    break;
                                                                }
                                                            }
                                                            break Label_1009;
                                                        }
                                                        if (f != 0) {
                                                            break;
                                                        }
                                                    }
                                                    p2 = this.g.k().a();
                                                    continue;
                                                }
                                            }
                                            if (f != 0) {
                                                break;
                                            }
                                        }
                                        p2 = this.g.k().a();
                                        continue;
                                    }
                                }
                            }
                            while (this.g.size() < 3) {
                                n4 = 0;
                                if (f == 0) {
                                    if (f != 0) {
                                        break Label_1033;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            b.clearPoints();
            this.g.size();
        }
        if (n2 > 2) {
            this.d();
            final p m = this.g.l();
            p p3 = this.g.k().a();
            while (p3 != m) {
                final s s6 = (s)p3.c();
                b.addPoint(s6.b, s6.c);
                p3 = p3.a();
                if (f != 0) {
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
        }
        this.e();
        this.A = a3;
    }
    
    private void d() {
        final int f = y.f.i.v.f;
        if (this.g.size() < 3) {
            return;
        }
        final p k = this.g.k();
        final s s = (s)k.c();
        double b = s.b;
        double c = s.c;
        final p a = k.a();
        final s s2 = (s)a.c();
        double b2 = s2.b;
        double c2 = s2.c;
        p p = a.a();
        while (p != null) {
            final s s3 = (s)p.c();
            final double n = b2 - b;
            final double n2 = c2 - c;
            final double b3 = s3.b;
            final double c3 = s3.c;
            final double n3 = b3 - b;
            final double n4 = c3 - c;
            final double n5 = -(n3 * n + n4 * n2) / (n * n + n2 * n2);
            final double n6 = n3 + n5 * n;
            final double n7 = n4 + n5 * n2;
            Label_0247: {
                if (n6 * n6 + n7 * n7 < 0.25) {
                    this.a((s)this.g.h(p.b()));
                    b2 = b3;
                    c2 = c3;
                    if (f == 0) {
                        break Label_0247;
                    }
                }
                b = b2;
                c = c2;
                b2 = b3;
                c2 = c3;
            }
            p = p.a();
            if (f != 0) {
                break;
            }
        }
    }
    
    private s a(final double b, final double c) {
        if (this.h.size() > 0) {
            final s s = (s)this.h.g();
            s.a();
            s.b = b;
            s.c = c;
            return s;
        }
        return new s(b, c);
    }
    
    private void a(final s s) {
        this.h.c(s);
    }
    
    private void e() {
        this.h.a(this.g);
    }
    
    private void b(final double a) {
        final int f = y.f.i.v.f;
        final p l = this.g.l();
        p p = this.g.k().a();
        while (p != l) {
            final s s = (s)p.c();
            s.a();
            s.a = a;
            p = p.a();
            if (f != 0) {
                return;
            }
            if (f != 0) {
                break;
            }
        }
        this.e = 2.4 + (this.g.size() - 2) * (a * a);
    }
    
    private void c(final double n) {
        final int f = y.f.i.v.f;
        p p = this.g.k().a();
        while (p != null) {
            this.a((s)p.b().c(), (s)p.c(), n);
            p = p.a();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final s s, final s s2, final double n) {
        final int f = y.f.i.v.f;
        final double n2 = s2.b - s.b;
        final double n3 = s2.c - s.c;
        final double sqrt = Math.sqrt(n2 * n2 + n3 * n3);
        if (sqrt > n) {
            final int min = Math.min(10, (int)Math.ceil(sqrt / n) - 1);
            final double n4 = n2 / (min + 1);
            final double n5 = n3 / (min + 1);
            double n6 = s.b + n4;
            double n7 = s.c + n5;
            int i = 0;
            while (i < min) {
                final s a = this.a(n6, n7);
                a.i = this.g.a(a, s2.i);
                n6 += n4;
                n7 += n5;
                ++i;
                if (f != 0) {
                    break;
                }
            }
        }
    }
    
    private void b(final s s) {
        final int i = y.f.i.v.f;
        ++this.s;
        final s s2 = (s)s.i.b().c();
        double l;
        double m = l = 0.0;
        final double n = s.b - s2.b;
        final double n2 = s.c - s2.c;
        final double sqrt = Math.sqrt(n * n + n2 * n2);
        Label_1055: {
            if (sqrt > 1.0E-6) {
                final double n3 = 1.0 / sqrt;
                final double n4 = n * n3;
                final double n5 = n2 * n3;
                final int n6 = (int)Math.floor((Math.min(s.b, s2.b) - this.d.x - this.x) / this.o);
                final int n7 = (int)Math.floor((Math.min(s.c, s2.c) - this.d.y - this.x) / this.p);
                final int n8 = (int)Math.floor((Math.max(s.b, s2.b) - this.d.x + this.x) / this.o) + 1;
                final int n9 = (int)Math.floor((Math.max(s.c, s2.c) - this.d.y + this.x) / this.p) + 1;
                final int max = Math.max(0, n6);
                final int max2 = Math.max(0, n7);
                Math.min(n8, this.f[0].length);
                final int min = Math.min(n9, this.f.length);
                int n10 = max2;
                while (true) {
                    do {
                        int j = 0;
                    Label_0293:
                        while (j < min) {
                            final ArrayList[] array = this.f[n10];
                            if (i != 0) {
                                final s s3 = s2;
                                s3.m += m;
                                break Label_1055;
                            }
                            int n11 = max;
                            do {
                                int k = 0;
                                int s4 = 0;
                            Label_0320:
                                while (k < s4) {
                                    final ArrayList list = array[n11];
                                    j = list.size() - 1;
                                    if (i != 0) {
                                        continue Label_0293;
                                    }
                                    int n12 = j;
                                    while (n12 >= 0) {
                                        final u u = list.get(n12);
                                        k = u.c;
                                        s4 = this.s;
                                        if (i != 0) {
                                            continue Label_0320;
                                        }
                                        if (k != s4) {
                                            u.c = this.s;
                                            if (u.g != this.y) {
                                                if (u.g != this.z) {
                                                    final double n13 = u.a - s2.b;
                                                    final double n14 = u.b - s2.c;
                                                    final double sqrt2 = Math.sqrt(n13 * n13 + n14 * n14);
                                                    final double n15 = u.a - s.b;
                                                    final double n16 = u.b - s.c;
                                                    final double sqrt3 = Math.sqrt(n15 * n15 + n16 * n16);
                                                    if (sqrt >= this.x || sqrt2 <= this.x + u.d || sqrt3 <= this.x + u.d) {
                                                        final double n17 = (n13 * n + n14 * n2) / sqrt;
                                                        final double n18 = -n17 / sqrt;
                                                        final double n19 = n13 + n18 * n;
                                                        final double n20 = n14 + n18 * n2;
                                                        double sqrt4 = Math.sqrt(n19 * n19 + n20 * n20);
                                                        double n21 = 0.0;
                                                        double n22 = 0.0;
                                                        Label_0650: {
                                                            if (sqrt4 == 0.0) {
                                                                n21 = n5;
                                                                n22 = -n4;
                                                                sqrt4 = 1.0E-5;
                                                                if (i == 0) {
                                                                    break Label_0650;
                                                                }
                                                            }
                                                            final double n23 = -1.0 / sqrt4;
                                                            n21 = n19 * n23;
                                                            n22 = n20 * n23;
                                                        }
                                                        double n24 = 0.0;
                                                        Label_0887: {
                                                            if (sqrt4 > 0.0) {
                                                                if (n17 < 0.0) {
                                                                    if (u.d < sqrt2) {
                                                                        n24 = -n17 + n17 * u.d / sqrt2;
                                                                        sqrt4 *= 1.0 - u.d / sqrt2;
                                                                        if (i == 0) {
                                                                            break Label_0887;
                                                                        }
                                                                    }
                                                                    n24 = -n17 + n17 * 0.999999;
                                                                    sqrt4 *= 1.0000000000287557E-6;
                                                                    if (i == 0) {
                                                                        break Label_0887;
                                                                    }
                                                                }
                                                                if (n17 > sqrt) {
                                                                    if (u.d < sqrt3) {
                                                                        n24 = -n17 + (n17 - sqrt) * u.d / sqrt3;
                                                                        sqrt4 *= 1.0 - u.d / sqrt3;
                                                                        if (i == 0) {
                                                                            break Label_0887;
                                                                        }
                                                                    }
                                                                    n24 = -n17 + (n17 - sqrt) * 0.999999;
                                                                    sqrt4 *= 1.0000000000287557E-6;
                                                                    if (i == 0) {
                                                                        break Label_0887;
                                                                    }
                                                                }
                                                                n24 = -n17;
                                                                if (u.d < sqrt4) {
                                                                    sqrt4 -= u.d;
                                                                    if (i == 0) {
                                                                        break Label_0887;
                                                                    }
                                                                }
                                                                sqrt4 *= 1.0000000000287557E-6;
                                                                if (i == 0) {
                                                                    break Label_0887;
                                                                }
                                                            }
                                                            sqrt4 = 1.0E-7 * (sqrt4 + u.d);
                                                            n24 = -n17;
                                                        }
                                                        final double n25 = n24 + sqrt;
                                                        final double n26 = sqrt4 * sqrt4;
                                                        final double n27 = n24 * n24;
                                                        final double n28 = n25 * n25;
                                                        final double sqrt5 = Math.sqrt(n27 + n26);
                                                        final double sqrt6 = Math.sqrt(n28 + n26);
                                                        final double n29 = u.f * (1.0 / sqrt5 - 1.0 / sqrt6);
                                                        final double n30 = u.f * (sqrt4 * (n25 / (n26 * sqrt6) - n24 / (n26 * sqrt5)));
                                                        l += n4 * n29 + n21 * n30;
                                                        m += n5 * n29 + n22 * n30;
                                                    }
                                                }
                                            }
                                        }
                                        --n12;
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                    ++n11;
                                }
                                break;
                            } while (i == 0);
                            ++n10;
                        }
                        break;
                    } while (i == 0);
                    final s s5 = s2;
                    s5.l += l;
                    continue;
                }
            }
        }
        s.l = l;
        s.m = m;
    }
    
    private double a(final s s, final r r) {
        final s s2 = (s)s.i.b().c();
        final double n = s2.b - s.b;
        final double n2 = s2.c - s.c;
        final double n3 = n * 3.0;
        final double n4 = n2 * 3.0;
        final s s3 = (s)s.i.a().c();
        final double n5 = s3.b - s.b;
        final double n6 = s3.c - s.c;
        final double n7 = n3 + n5 * 3.0;
        final double n8 = n4 + n6 * 3.0;
        final double n9 = n7 + s.l;
        final double n10 = n8 + s.m;
        final double a = n9 + this.t.a(-0.5, 0.5);
        final double b = n10 + this.t.a(-0.5, 0.5);
        r.a = a;
        r.b = b;
        return Math.sqrt(a * a + b * b);
    }
    
    private void a(final s s, final r r, final double f) {
        final int f2 = y.f.i.v.f;
        if (f > 1.0E-5) {
            s.g = s.f;
            s.j = s.d;
            s.k = s.e;
            s.d = r.a;
            s.e = r.b;
            s.f = f;
            final double h = (s.d * s.j + s.e * s.k) / (s.f * s.g);
            this.e -= s.a * s.a;
            Label_0158: {
                if (s.h * h > 0.0) {
                    s.a += h * 0.45;
                    if (f2 == 0) {
                        break Label_0158;
                    }
                }
                s.a += h * 0.15;
            }
            Label_0203: {
                if (s.a > this.v) {
                    s.a = this.v;
                    if (f2 == 0) {
                        break Label_0203;
                    }
                }
                if (s.a < this.w) {
                    s.a = this.w;
                }
            }
            this.e += s.a * s.a;
            s.h = h;
        }
    }
    
    private void c(final s s) {
        if (s.f > 0.0) {
            final double n = s.a / s.f;
            if (n > 0.0) {
                s.b += n * s.d;
                s.c += n * s.e;
            }
        }
    }
    
    public ah a() {
        return this.b;
    }
    
    public void a(final ah b) {
        this.b = b;
    }
    
    static {
        a = "y.layout.router.OrganicEdgeRouter.ROUTE_EDGE_DPKEY";
    }
}
