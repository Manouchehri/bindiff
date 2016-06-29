package y.f.g;

import y.f.*;
import y.f.b.*;
import y.c.*;
import java.util.*;
import java.awt.geom.*;
import y.d.*;

class n
{
    private X a;
    private double b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private c h;
    private D i;
    private boolean j;
    private boolean k;
    private boolean l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    
    n() {
        this.b = 10.0;
        this.c = Integer.MAX_VALUE;
        this.d = 10;
        this.e = 15;
        this.f = 200;
        this.g = false;
        this.j = true;
        this.k = false;
        this.l = false;
        this.m = 1000L;
        this.o = true;
        this.p = false;
        this.q = true;
        this.r = true;
    }
    
    public void a(final boolean r) {
        this.r = r;
    }
    
    public void b(final boolean q) {
        this.q = q;
    }
    
    public void c(final boolean p) {
        this.p = p;
    }
    
    public void a(final int f) {
        this.f = f;
    }
    
    public void d(final boolean o) {
        this.o = o;
    }
    
    public boolean a() {
        return this.j;
    }
    
    public void a(final long m) {
        this.m = m;
    }
    
    public boolean b() {
        return this.k;
    }
    
    public boolean c() {
        return this.l;
    }
    
    public void b(final int e) {
        this.e = e;
    }
    
    public boolean d() {
        return this.g;
    }
    
    public void c(final int c) {
        this.c = c;
    }
    
    private int a(final y y) {
        int min = (this.c == Integer.MAX_VALUE) ? Integer.MAX_VALUE : ((int)Math.floor(this.c / this.b));
        if (y != null) {
            min = Math.min(min, y.c());
        }
        return min;
    }
    
    public void a(final X a, final y.c.c c, final y.c.c c2, final y.c.y y, final y y2, final SortedSet set, final boolean b) {
        final boolean d = y.f.g.d.d;
        this.n = System.currentTimeMillis();
        this.a = a;
        if (a.c(y.f.b.f.d) != null) {
            this.h = new c(a);
        }
        (this.i = new D()).add(new w(this, y, y, false, c2));
        final y.c.y y3 = new y.c.y();
        final x o = a.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final boolean d2 = c.d(e);
                if (d) {
                    if (!d2 || !this.a() || !this.b()) {
                        final C m = this.i.m();
                        while (m.f()) {
                            final w w = (w)m.d();
                            if (d) {
                                return;
                            }
                            if (!w.b() && this.e()) {
                                Label_0318: {
                                    if (set != null && !set.isEmpty()) {
                                        final y.f.g.q a2 = this.a(w, y2, set, b);
                                        if (a2 != null) {
                                            if (!this.o || a2 == null) {
                                                break Label_0318;
                                            }
                                            this.a(w, a2);
                                            if (!d) {
                                                break Label_0318;
                                            }
                                        }
                                        this.b(w, y2);
                                        if (!d) {
                                            break Label_0318;
                                        }
                                    }
                                    this.b(w, y2);
                                }
                                if (this.o && !this.g) {
                                    this.a(w, y2);
                                }
                            }
                            m.g();
                            if (d) {
                                break;
                            }
                        }
                    }
                    if (this.h != null) {
                        this.h.c();
                        this.h = null;
                    }
                    return;
                }
                if (d2) {
                    y3.add(e);
                }
                o.g();
                if (d) {
                    break;
                }
            }
            this.i.add(new w(this, y3, y3, true, c2));
            this.c();
            continue;
        }
    }
    
    private void a(final w w, final y.f.g.q q) {
        final boolean d = y.f.g.d.d;
        final y.d.y a = w.a();
        final t t = new t(a.c + 0.5 * a.a, a.d + 0.5 * a.b);
        if (!q.d.isEmpty()) {
            final C m = q.d.m();
            while (m.f()) {
                final m i = ((u)m.d()).m();
                Label_0156: {
                    if (i.c().a() == i.d().a()) {
                        w.a(i.c().a() - t.a(), 0.0);
                        if (!d) {
                            break Label_0156;
                        }
                    }
                    w.a(0.0, i.c().b() - t.b());
                }
                m.g();
                if (d) {
                    break;
                }
            }
        }
    }
    
    private void a(final w w, final y y) {
        final boolean d = y.f.g.d.d;
        if (y == null || y.a == null || y.c) {
            return;
        }
        final y.d.y a = y.a;
        final t t = new t(a.c + 0.5 * a.a, a.d + 0.5 * a.b);
        final y.d.y a2 = w.a();
        final t t2 = new t(a2.c + 0.5 * a2.a, a2.d + 0.5 * a2.b);
        if (!a.b(a2)) {
            Label_0235: {
                if (a.a() < a2.a()) {
                    w.a(t.a - t2.a, 0.0);
                    if (!d) {
                        break Label_0235;
                    }
                }
                if (a.c > a2.c) {
                    w.a(a.c - a2.c, 0.0);
                    if (!d) {
                        break Label_0235;
                    }
                }
                if (a.c + a.a < a2.c + a2.a) {
                    w.a(a.c + a.a - a2.c - a2.a, 0.0);
                }
            }
            if (a.b() < a2.b()) {
                w.a(0.0, t.b - t2.b);
                if (!d) {
                    return;
                }
            }
            if (a.d > a2.d) {
                w.a(0.0, a.d - a2.d);
                if (!d) {
                    return;
                }
            }
            if (a.d + a.b < a2.d + a2.b) {
                w.a(0.0, a.d + a.b - a2.d - a2.b);
            }
        }
    }
    
    private boolean e() {
        return System.currentTimeMillis() - this.n < this.m;
    }
    
    private y.f.g.q a(final w w, final y y, final SortedSet set, final boolean b) {
        final y.d.y a = w.a();
        final double b2 = this.b;
        if (this.q) {
            this.b = (int)Math.ceil(Math.sqrt((a.b() + 2 * this.e) * (a.a() + 2 * this.e) / 150.0));
        }
        if (y != null) {
            y.a(a, this.b);
            if (!this.g && (y == null || !y.c) && y.b()) {
                return null;
            }
        }
        final t t = new t(a.c + 0.5 * a.a, a.d + 0.5 * a.b);
        final r a2 = this.a(this.a(null, w), false);
        final r a3 = this.a(this.a(w), true);
        final int n = (int)Math.floor(t.a / this.b);
        final int n2 = (int)Math.floor(t.b / this.b);
        final int n3 = (int)Math.max(1.0, Math.ceil(this.d / this.b));
        final int a4 = this.a(y);
        final D[] a5 = this.a(a4, set, n, n2);
        final y.f.g.q a6 = a3.a(a2, n, n2, n3, a4, !this.g && (y == null || !y.c) && (a3.a * a3.b < 150 || this.q), y, a5[0], this.a(a5[1]), b);
        if (a6 != null) {
            w.a(a3.a() * this.b, a3.b() * this.b);
        }
        if (this.q) {
            this.b = b2;
        }
        return a6;
    }
    
    private D[] a(final int n, final SortedSet set, final int n2, final int n3) {
        final boolean d = y.f.g.d.d;
        final D[] array = { new D(), new D() };
        int n4 = 0;
        int n5 = 0;
        for (final m m : set) {
            boolean b = false;
            Label_0167: {
                if (m.c().a() == m.d().a()) {
                    b = (++n5 < 100);
                    if (!d) {
                        break Label_0167;
                    }
                }
                if (m.c().b() == m.d().b()) {
                    b = (++n4 < 100);
                    if (!d) {
                        break Label_0167;
                    }
                }
                throw new RuntimeException("found non horizontal/vertical line segment!");
            }
            if (b) {
                final u a = a(m, this.b);
                final double min = Math.min(a.c().a, a.d().a);
                final double max = Math.max(a.c().a, a.d().a);
                final double min2 = Math.min(a.c().b, a.d().b);
                final double max2 = Math.max(a.c().b, a.d().b);
                Label_0352: {
                    if (n < Integer.MAX_VALUE) {
                        if (n2 - n > max || n2 + n < min || n3 - n > max2 || n3 + n < min2) {
                            break Label_0352;
                        }
                        array[0].add(a);
                        if (!d) {
                            break Label_0352;
                        }
                    }
                    array[0].add(a);
                }
                final double floor = Math.floor(this.f / this.b);
                if (n2 - floor > max || n2 + floor < min || n3 - floor > max2 || n3 + floor < min2) {
                    continue;
                }
                array[1].add(a);
                if (d) {
                    break;
                }
                continue;
            }
        }
        return array;
    }
    
    private D a(final D d) {
        final p p = new p(this);
        y.d.f.a(d, p);
        return p.a();
    }
    
    private boolean b(final w w, final y y) {
        final double b = this.b;
        final y.d.y a = w.a();
        if (this.q) {
            this.b = (int)Math.ceil(Math.sqrt((a.b() + 2 * this.e) * (a.a() + 2 * this.e) / 150.0));
        }
        if (y != null) {
            y.a(a, this.b);
            if (!this.g && (y == null || !y.c) && y.b()) {
                return false;
            }
        }
        final t t = new t(a.c + 0.5 * a.a, a.d + 0.5 * a.b);
        final r a2 = this.a(this.a(y, w), false);
        final r a3 = this.a(this.a(w), true);
        final int n = (int)Math.floor(t.a / this.b);
        final int n2 = (int)Math.floor(t.b / this.b);
        final int n3 = (int)Math.max(1.0, Math.ceil(this.d / this.b));
        boolean b2 = a3.a(a2, n, n2, n3, this.a(y), y, !this.g && (y == null || !y.c) && (a3.a * a3.b < 150 || this.q));
        Label_0441: {
            if (b2) {
                w.a(a3.a() * this.b, a3.b() * this.b);
                if (!y.f.g.d.d) {
                    break Label_0441;
                }
            }
            if (y != null && (this.g || y.c)) {
                final int a4 = this.a((y)null);
                final r a5 = this.a(this.a(null, w), false);
                y.a(false);
                b2 = a3.a(a5, n, n2, n3, a4, y, false);
                y.a(true);
                if (b2) {
                    w.a(a3.a() * this.b, a3.b() * this.b);
                }
            }
        }
        if (this.q) {
            this.b = b;
        }
        return b2;
    }
    
    static u a(final m m, final double n) {
        final int n2 = (m instanceof u) ? ((u)m).l() : 100;
        final t c = m.c();
        final t d = m.d();
        return new u(new t((int)Math.floor(c.a / n), (int)Math.floor(c.b / n)), new t((int)Math.floor(d.a / n), (int)Math.floor(d.b / n)), n2, m);
    }
    
    private D a(final y y, final w w) {
        final boolean d = y.f.g.d.d;
        final D d2 = new D();
        final y.d.y y2 = (y == null) ? null : y.a;
        final C m = this.i.m();
        do {
            Label_0036: {
                m.f();
            }
            boolean a = false;
            Label_0043:
            while (a) {
                final w w2 = (w)m.d();
                if (w2 != w) {
                    final C i = w2.c().m();
                    while (i.f()) {
                        final y.f.g.t t = (y.f.g.t)i.d();
                        a = this.a();
                        if (d) {
                            continue Label_0043;
                        }
                        Label_0223: {
                            if (!a && t.a()) {
                                if (y2 != null && !t.a(y2)) {
                                    break Label_0223;
                                }
                                d2.add(t);
                                if (!d) {
                                    break Label_0223;
                                }
                            }
                            if (!this.c() && t.c == 1) {
                                if (y2 != null && !t.a(y2)) {
                                    break Label_0223;
                                }
                                d2.add(t);
                                if (!d) {
                                    break Label_0223;
                                }
                            }
                            if (!this.b() && t.c == 0 && (y2 == null || t.a(y2))) {
                                d2.add(t);
                            }
                        }
                        i.g();
                        if (d) {
                            break;
                        }
                    }
                }
                m.g();
                continue Label_0036;
            }
            break;
        } while (!d);
        return d2;
    }
    
    private D a(final w w) {
        final boolean d = y.f.g.d.d;
        final D d2 = new D();
        final C m = w.c().m();
        while (m.f()) {
            final y.f.g.t t = (y.f.g.t)m.d();
            Label_0118: {
                if (!this.a() && t.a()) {
                    d2.add(t);
                    if (!d) {
                        break Label_0118;
                    }
                }
                if (!this.c() && t.c == 1) {
                    d2.add(t);
                    if (!d) {
                        break Label_0118;
                    }
                }
                if (!this.b() && t.c == 0) {
                    d2.add(t);
                }
            }
            m.g();
            if (d) {
                break;
            }
        }
        return d2;
    }
    
    private r a(final D d, final boolean b) {
        final boolean d2 = d.d;
        int n = Integer.MAX_VALUE;
        int n2 = Integer.MIN_VALUE;
        int n3 = Integer.MAX_VALUE;
        int n4 = Integer.MIN_VALUE;
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        final C m = d.m();
        while (true) {
            while (m.f()) {
                final y.f.g.t t = (y.f.g.t)m.d();
                if (d2) {
                    final r r = new r(this, n, n3, n2 - n, n4 - n3);
                    final C i = d.m();
                    while (true) {
                        while (i.f()) {
                            final y.f.g.t t2 = (y.f.g.t)i.d();
                            final byte c = t2.c;
                            if (d2) {
                                if (c == 0) {
                                    r.c();
                                }
                                return r;
                            }
                            Label_1077: {
                                Label_1070: {
                                    Label_0807: {
                                        if (c == 1) {
                                            final s j = this.a.l((y.c.d)t2.a).j();
                                            while (j.f()) {
                                                final m a = j.a();
                                                a(r, a.c().a, a.c().b, a.d().a, a.d().b, this.b);
                                                j.g();
                                                if (d2) {
                                                    break Label_1077;
                                                }
                                                if (d2) {
                                                    break Label_0807;
                                                }
                                            }
                                            break Label_1070;
                                        }
                                    }
                                    if (b && t2.c == 0) {
                                        final y.d.y h = t2.h();
                                        double1.setFrame(h.c() - this.e, h.d() - this.e, h.a() + 2 * this.e, h.b() + 2 * this.e);
                                        r.a((int)Math.floor(double1.x / this.b), (int)Math.floor(double1.y / this.b), 1 + (int)Math.floor((double1.x + double1.width) / this.b), 1 + (int)Math.floor((double1.y + double1.height) / this.b));
                                        if (!d2) {
                                            break Label_1070;
                                        }
                                    }
                                    final y.d.y h2 = t2.h();
                                    double1.setFrame(h2.c(), h2.d(), h2.a(), h2.b());
                                    r.a((int)Math.floor(double1.x / this.b), (int)Math.floor(double1.y / this.b), 1 + (int)Math.floor((double1.x + double1.width) / this.b), 1 + (int)Math.floor((double1.y + double1.height) / this.b));
                                }
                                i.g();
                            }
                            if (d2) {
                                break;
                            }
                        }
                        final boolean r2 = this.r;
                        continue;
                    }
                }
                Label_0625: {
                    Label_0618: {
                        Label_0321: {
                            if (t.c == 1) {
                                final s k = this.a.l((y.c.d)t.a).j();
                                while (k.f()) {
                                    final m a2 = k.a();
                                    final int min = Math.min(n, (int)Math.floor(a2.c().a / this.b));
                                    final int max = Math.max(n2, (int)Math.floor(a2.c().a / this.b));
                                    final int min2 = Math.min(n3, (int)Math.floor(a2.c().b / this.b));
                                    final int max2 = Math.max(n4, (int)Math.floor(a2.c().b / this.b));
                                    n = Math.min(min, (int)Math.floor(a2.d().a / this.b));
                                    n2 = Math.max(max, (int)Math.floor(a2.d().a / this.b));
                                    n3 = Math.min(min2, (int)Math.floor(a2.d().b / this.b));
                                    n4 = Math.max(max2, (int)Math.floor(a2.d().b / this.b));
                                    k.g();
                                    if (d2) {
                                        break Label_0625;
                                    }
                                    if (d2) {
                                        break Label_0321;
                                    }
                                }
                                break Label_0618;
                            }
                        }
                        if (b && t.c == 0) {
                            final y.d.y h3 = t.h();
                            double1.setFrame(h3.c() - this.e, h3.d() - this.e, h3.a() + 2 * this.e, h3.b() + 2 * this.e);
                            n = Math.min((int)Math.floor(double1.x / this.b), n);
                            n3 = Math.min((int)Math.floor(double1.y / this.b), n3);
                            n2 = Math.max((int)Math.floor((double1.x + double1.width) / this.b), n2);
                            n4 = Math.max((int)Math.floor((double1.y + double1.height) / this.b), n4);
                            if (!d2) {
                                break Label_0618;
                            }
                        }
                        final y.d.y h4 = t.h();
                        double1.setFrame(h4.c(), h4.d(), h4.a(), h4.b());
                        n = Math.min((int)Math.floor(double1.x / this.b), n);
                        n3 = Math.min((int)Math.floor(double1.y / this.b), n3);
                        n2 = Math.max((int)Math.floor((double1.x + double1.width) / this.b), n2);
                        n4 = Math.max((int)Math.floor((double1.y + double1.height) / this.b), n4);
                    }
                    m.g();
                }
                if (d2) {
                    break;
                }
            }
            n -= 2;
            n3 -= 2;
            n2 += 2;
            n4 += 2;
            continue;
        }
    }
    
    static void a(final r r, final double n, final double n2, final double n3, final double n4, final double n5) {
        final boolean d = y.f.g.d.d;
        final double n6 = n3 - n;
        final double n7 = n4 - n2;
        double min = 0.1;
        Label_0079: {
            if (n5 > 1.0) {
                int i = 1 + (int)Math.rint(n5);
                while (i > 0) {
                    min /= 10.0;
                    i /= 10;
                    if (d) {
                        break Label_0079;
                    }
                    if (d) {
                        break;
                    }
                }
            }
            min = Math.min(min, 1.0E-5);
        }
        double min2 = 0.1;
        int j = 0;
        Label_0151: {
            if (n5 > 1.0) {
                j = 1 + (int)Math.rint(n5);
                while (j > 0) {
                    min2 /= 10.0;
                    j /= 10;
                    if (d) {
                        break Label_0151;
                    }
                    if (d) {
                        break;
                    }
                }
            }
            min2 = Math.min(min2, 1.0E-5);
            j = (int)Math.floor(n / n5);
        }
        final int n8 = (int)Math.floor(n2 / n5);
        final int n9 = (int)Math.floor(n3 / n5);
        final int n10 = (int)Math.floor(n4 / n5);
        final int n11 = n9 - j;
        final int n12 = n10 - n8;
        if (n11 == 0 || Math.abs(n6) < min) {
            r.a(j, Math.min(n8, n10), j + 1, Math.max(n8, n10) + 1);
            if (!d) {
                return;
            }
        }
        if (n12 == 0 || Math.abs(n7) < min2) {
            r.a(Math.min(j, n9), n8, Math.max(j, n9) + 1, n8 + 1);
            if (!d) {
                return;
            }
        }
        Label_0642: {
            if (Math.abs(n6) > Math.abs(n7)) {
                Label_0482: {
                    if (j > n9) {
                        final double n13 = n7 / n6;
                        double n14 = n4;
                        double n15 = (Math.floor(n3 / n5) + 1.0 - n9) * n13 + n4;
                        final double n16 = n5 * n13;
                        int k = n9;
                        while (true) {
                            while (k < j) {
                                final int n17 = (int)Math.floor(n14 / n5);
                                final int n18 = (int)Math.floor(n15 / n5);
                                r.a(k, n17, true);
                                final int n19 = n17;
                                final int n20 = n18;
                                if (!d) {
                                    if (n19 != n20 && k < j) {
                                        r.a(k, n18, true);
                                    }
                                    n14 = n15;
                                    n15 += n16;
                                    ++k;
                                    if (d) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (n19 == n20) {
                                        return;
                                    }
                                    r.a(j, n8, true);
                                    if (d) {
                                        break Label_0482;
                                    }
                                    return;
                                }
                            }
                            r.a(j, (int)Math.floor(n14 / n5), true);
                            continue;
                        }
                    }
                }
                final double n21 = n7 / n6;
                double n22 = n2;
                double n23 = (Math.floor(n / n5) + 1.0 - j) * n21 + n2;
                final double n24 = n5 * n21;
                int l = j;
                while (true) {
                    while (l < n9) {
                        final int n25 = (int)Math.floor(n22 / n5);
                        final int n26 = (int)Math.floor(n23 / n5);
                        r.a(l, n25, true);
                        final int n27 = n25;
                        final int n28 = n26;
                        if (!d) {
                            if (n27 != n28) {
                                r.a(l, n26, true);
                            }
                            n22 = n23;
                            n23 += n24;
                            ++l;
                            if (d) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (n27 == n28) {
                                return;
                            }
                            r.a(n9, n10, true);
                            if (d) {
                                break Label_0642;
                            }
                            return;
                        }
                    }
                    r.a(n9, (int)Math.floor(n22 / n5), true);
                    continue;
                }
            }
        }
        Label_0812: {
            if (n8 > n10) {
                final double n29 = n6 / n7;
                double n30 = n3;
                double n31 = (Math.floor(n4 / n5) + 1.0 - n10) * n29 + n3;
                final double n32 = n5 * n29;
                int n33 = n10;
                while (true) {
                    while (n33 < n8) {
                        final int n34 = (int)Math.floor(n30 / n5);
                        final int n35 = (int)Math.floor(n31 / n5);
                        r.a(n34, n33, true);
                        final int n36 = n34;
                        final int n37 = n35;
                        if (!d) {
                            if (n36 != n37) {
                                r.a(n35, n33, true);
                            }
                            n30 = n31;
                            n31 += n32;
                            ++n33;
                            if (d) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (n36 == n37) {
                                return;
                            }
                            r.a(j, n8, true);
                            if (d) {
                                break Label_0812;
                            }
                            return;
                        }
                    }
                    r.a((int)Math.floor(n30 / n5), n8, true);
                    continue;
                }
            }
        }
        final double n38 = n6 / n7;
        double n39 = n;
        double n40 = (Math.floor(n2 / n5) + 1.0 - n8) * n38 + n;
        final double n41 = n5 * n38;
        int n42 = n8;
        while (true) {
            while (n42 < n10) {
                final int n43 = (int)Math.floor(n39 / n5);
                final int n44 = (int)Math.floor(n40 / n5);
                r.a(n43, n42, true);
                final int n45 = n43;
                final int n46 = n44;
                if (!d) {
                    if (n45 != n46) {
                        r.a(n44, n42, true);
                    }
                    n39 = n40;
                    n40 += n41;
                    ++n42;
                    if (d) {
                        break;
                    }
                    continue;
                }
                else {
                    if (n45 != n46) {
                        r.a(n9, n10, true);
                    }
                    return;
                }
            }
            r.a((int)Math.floor(n39 / n5), n10, true);
            continue;
        }
    }
    
    static double a(final n n) {
        return n.b;
    }
    
    static X b(final n n) {
        return n.a;
    }
    
    static boolean c(final n n) {
        return n.e();
    }
    
    static int d(final n n) {
        return n.f;
    }
}
