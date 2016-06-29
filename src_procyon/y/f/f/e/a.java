package y.f.f.e;

import y.f.f.b.*;
import y.f.*;
import y.g.*;
import java.awt.*;
import y.f.h.*;
import java.awt.geom.*;
import y.d.*;
import y.c.*;
import java.util.*;

public class a implements d
{
    private X b;
    private N c;
    private X d;
    private D e;
    private short f;
    private int g;
    private A h;
    private h i;
    private h j;
    private h k;
    private int l;
    private A m;
    public static int a;
    
    public a() {
        this.l = 4;
    }
    
    public void a(final D c) {
        this.b = (X)c.g();
        this.c = c;
    }
    
    public void a(final short f) {
        this.f = f;
    }
    
    public void a(final int g) {
        this.g = g;
    }
    
    public D b() {
        return this.e;
    }
    
    public void a() {
        final int i = y.f.f.e.a.a;
        final y.c.d a = this.c.i().a().a();
        this.d = new w();
        this.e = new D(this.d);
        this.h = M.a(new Object[this.b.e()]);
        this.i = M.b(new Object[this.b.g()]);
        final x o = this.b.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                if (i != 0) {
                    final x o2 = this.b.o();
                    do {
                        Label_0217: {
                            o2.f();
                        }
                        int j = 0;
                        Label_0223:
                        while (j != 0) {
                            final q e2 = o2.e();
                            if (e2.c() != 0) {
                                final e l = e2.l();
                                final y.c.d a2 = l.a();
                                q q = (q)this.j.b(a2);
                                l.b();
                                while (l.f()) {
                                    final y.c.d a3 = l.a();
                                    final q q2 = (q)this.j.b(a3);
                                    final q q3 = (q)this.k.b(a3);
                                    final y.c.d a4 = this.a(q, q2);
                                    j = e2.c();
                                    if (i != 0) {
                                        continue Label_0223;
                                    }
                                    if (j > this.l) {
                                        this.h.a(e2, a4);
                                    }
                                    q = (q)this.j.b(a3);
                                    this.i.a(a3, this.d.a(q2, q3));
                                    if (a3 == a2) {
                                        break;
                                    }
                                    l.b();
                                    if (i != 0) {
                                        break;
                                    }
                                }
                            }
                            o2.g();
                            continue Label_0217;
                        }
                        break;
                    } while (i == 0);
                    final e p = this.b.p();
                    while (true) {
                        while (p.f()) {
                            final y.c.d a5 = p.a();
                            final a a6 = this;
                            if (i != 0) {
                                final r m = a6.e.m();
                                this.d.a("y.layout.orthogonal.general.NodeSplitter.NODE_FACES", m);
                                final r k = this.e.m();
                                this.d.a("y.layout.orthogonal.ring.FixedSizeNodeSplitter#NODE_SIZE", k);
                                this.m = this.e.g().t();
                                this.d.a("y.layout.orthogonal.ring.FixedSizeNodeSplitter#NODE_SIZE", new y.f.f.e.c(k, this.m));
                                Label_1004: {
                                    try {
                                        this.e.l();
                                        this.e.b(this.e.i((y.c.d)this.i.b(a)));
                                        final y.f.h.q h = this.e.h();
                                        while (h.f()) {
                                            m.a(h.a(), false);
                                            h.g();
                                            if (i != 0) {
                                                break Label_1004;
                                            }
                                            if (i != 0) {
                                                break;
                                            }
                                        }
                                        final x o3 = this.b.o();
                                        while (o3.f()) {
                                            final q e3 = o3.e();
                                            if (i != 0) {
                                                break;
                                            }
                                            Label_0971: {
                                                if (e3.c() > this.l) {
                                                    final p i2 = this.e.i((y.c.d)this.h.b(e3));
                                                    this.h.a(e3, i2);
                                                    m.a(i2, true);
                                                    k.a(i2, new Dimension((int)this.b.p(e3), (int)this.b.q(e3)));
                                                    if (i == 0) {
                                                        break Label_0971;
                                                    }
                                                }
                                                final y.d.q r = this.b.r(e3);
                                                if (r.a > 0.0 || r.b > 0.0) {
                                                    this.m.a(this.h.b(e3), this.b.r(e3));
                                                }
                                            }
                                            o3.g();
                                            if (i != 0) {
                                                break;
                                            }
                                        }
                                    }
                                    catch (Exception ex) {
                                        System.err.println("Internal Error in Face calculation !");
                                        ex.printStackTrace(System.err);
                                    }
                                }
                                final y.f.h.q h2 = this.e.h();
                                while (h2.f()) {
                                    final p p2 = (p)h2.d();
                                    Label_1122: {
                                        if (m.d(p2)) {
                                            final e a7 = p2.a();
                                            while (a7.f()) {
                                                final y.c.d a8 = a7.a();
                                                this.e.m(this.e.h(a8));
                                                this.e.e(a8);
                                                a7.g();
                                                if (i != 0) {
                                                    break Label_1122;
                                                }
                                                if (i != 0) {
                                                    break;
                                                }
                                            }
                                        }
                                        h2.g();
                                    }
                                    if (i != 0) {
                                        break;
                                    }
                                }
                                return;
                            }
                            Label_0533: {
                                if (this.c.n(a5)) {
                                    this.e.m((y.c.d)this.i.b(a5));
                                    if (i == 0) {
                                        break Label_0533;
                                    }
                                }
                                this.e.e((y.c.d)this.i.b(a5));
                            }
                            this.e.b((y.c.d)this.i.b(a5), (y.c.d)this.i.b(this.c.h(a5)));
                            p.g();
                            if (i != 0) {
                                break;
                            }
                        }
                        final a a6 = this;
                        continue;
                    }
                }
                if (e.c() <= this.l) {
                    this.h.a(e, this.d.d());
                }
                o.g();
                if (i != 0) {
                    break;
                }
            }
            this.j = M.b(new Object[this.b.g()]);
            this.k = M.b(new Object[this.b.g()]);
            this.a(this.j, this.k);
            continue;
        }
    }
    
    private y.c.d a(final q q, final q q2) {
        if (q.equals(q2)) {
            return null;
        }
        final y.c.d a = this.d.a(q, q2);
        final e l = q2.l();
        y.c.d d = null;
        Label_0085: {
            if (!l.f()) {
                d = this.d.a(q2, q);
                if (y.f.f.e.a.a == 0) {
                    break Label_0085;
                }
            }
            l.g();
            d = this.d.a(q2, l.a(), q, null, 1, 0);
        }
        this.e.b(a, d);
        return d;
    }
    
    private void a(final h h, final h h2) {
        final int a = y.f.f.e.a.a;
        final x o = this.b.o();
    Label_0013:
        while (true) {
        Label_0102_Outer:
            while (o.f()) {
                final e l = o.e().l();
                if (a == 0) {
                    final e e = l;
                    while (true) {
                        while (e.f()) {
                            final y.c.d a2 = e.a();
                            h.a(a2, this.a(a2));
                            e.g();
                            if (a == 0) {
                                if (a != 0) {
                                    break;
                                }
                                continue Label_0102_Outer;
                            }
                            else {
                                if (a != 0) {
                                    break Label_0102_Outer;
                                }
                                continue Label_0013;
                            }
                        }
                        o.g();
                        continue;
                    }
                }
                final e e2 = l;
                while (e2.f()) {
                    final y.c.d a3 = e2.a();
                    final y.c.d h3 = this.c.h(a3);
                    h2.a(a3, h.b(h3));
                    h2.a(h3, h.b(a3));
                    e2.g();
                    if (a != 0) {
                        break;
                    }
                }
                return;
            }
            this.b.p();
            continue;
        }
    }
    
    private q a(final y.c.d d) {
        if (d.c().c() <= this.l) {
            final q q = (q)this.h.b(d.c());
            if (y.f.f.e.a.a == 0) {
                return q;
            }
        }
        return this.d.d();
    }
    
    public void c() {
        final int i = y.f.f.e.a.a;
        final x o = this.d.o();
        while (true) {
            t l;
            X d;
            A t;
            x o2;
            q e;
            y.c.D d2;
            int c;
            int j;
            Rectangle2D.Double double1;
            e p;
            y.c.d a;
            q c2;
            y.c.D k;
            t m;
            t p2;
            q d3;
            t l2;
            t q;
            Rectangle2D.Double double2;
            e p3;
            y.c.d a2;
            y.c.D m2;
            a a3 = null;
            y.f.f.e.d d4;
            x o3;
            q e2;
            double m3;
            double n;
            double n2;
            double n3;
            f[][] array;
            int b;
            int n4;
            int n5;
            int n6 = 0;
            int n7;
            int n8;
            int n9 = 0;
            e a4;
            e e3;
            y.c.d a5;
            y.c.D m4;
            t t2;
            e e4;
            y.c.d a6;
            y.c.D m5;
            t t3;
            t t4;
            double n10;
            int n11;
            int n12;
            f f;
            f f2;
            double n13;
            double n14;
            double n15;
            y.c.d d5;
            y.c.D m6;
            f f3;
            double n16;
            double n17;
            double n18;
            y.c.d d6;
            y.c.D m7;
            f f4;
            double n19;
            double n20;
            double n21;
            y.c.d d7;
            y.c.D m8;
            f f5;
            double n22;
            double n23;
            double n24;
            y.c.d d8;
            y.c.D m9;
            f f6;
            double n25;
            double n26;
            double n27;
            y.c.d d9;
            y.c.D m10;
            f f7;
            double n28;
            double n29;
            double n30;
            y.c.d d10;
            y.c.D m11;
            f f8;
            double n31;
            double n32;
            double n33;
            y.c.d d11;
            y.c.D m12;
            f f9;
            double n34;
            double n35;
            double n36;
            y.c.d d12;
            y.c.D m13;
            e a7;
            x o4;
            q e5;
            int n37;
            int n38;
            int n39;
            int n40;
            y.c.D d13;
            C m14;
            t t5;
            double n41;
            y.d.q r;
            y.c.D d14;
            y.c.D d15;
            y.c.D d16;
            y.c.D d17;
            e a8;
            t l3;
            double n42;
            short f10;
            short f11;
            Label_0898_Outer:Label_0893_Outer:
            while (o.f()) {
                l = this.d.l(o.e());
                this.d.b(o.e(), 10.0, 10.0);
                d = this.d;
                if (i != 0) {
                    t = d.t();
                    o2 = this.b.o();
                    while (true) {
                    Label_0898:
                        while (true) {
                            while (o2.f()) {
                                e = o2.e();
                                d2 = new y.c.D();
                                c = e.c();
                                j = this.l;
                                if (i != 0) {
                                    Label_3729: {
                                        Label_3728: {
                                            if (c == j) {
                                                double1 = new Rectangle2D.Double();
                                                p = this.b.p();
                                                while (p.f()) {
                                                    a = p.a();
                                                    c2 = a.c();
                                                    k = this.d.k((y.c.d)this.i.b(a));
                                                    if (i != 0) {
                                                        break Label_3728;
                                                    }
                                                    Label_1136: {
                                                        if (c2.c() > this.l) {
                                                            m = this.d.l((q)this.j.b(a));
                                                            double1.setFrame(this.b.m(c2) - 1.0, this.b.n(c2) - 1.0, this.b.p(c2) + 2.0, this.b.q(c2) + 2.0);
                                                            if (!double1.contains(m.a, m.b)) {
                                                                p2 = this.b.p(a);
                                                                if (p2.a() == m.a() || p2.b() == m.b()) {
                                                                    break Label_1136;
                                                                }
                                                                k.a(m);
                                                                if (i == 0) {
                                                                    break Label_1136;
                                                                }
                                                            }
                                                            this.b.c(a, m);
                                                        }
                                                    }
                                                    d3 = a.d();
                                                    Label_1310: {
                                                        if (d3.c() > this.l) {
                                                            l2 = this.d.l((q)this.k.b(a));
                                                            double1.setFrame(this.b.m(d3) - 1.0, this.b.n(d3) - 1.0, this.b.p(d3) + 2.0, this.b.q(d3) + 2.0);
                                                            if (!double1.contains(l2.a, l2.b)) {
                                                                q = this.b.q(a);
                                                                if (q.a() == l2.a() || q.b() == l2.b()) {
                                                                    break Label_1310;
                                                                }
                                                                k.b(l2);
                                                                if (i == 0) {
                                                                    break Label_1310;
                                                                }
                                                            }
                                                            this.b.d(a, l2);
                                                        }
                                                    }
                                                    this.b.b(a, k);
                                                    p.g();
                                                }
                                            }
                                            else if (this.f == 3) {
                                                double2 = new Rectangle2D.Double();
                                                p3 = this.b.p();
                                                while (p3.f()) {
                                                    a2 = p3.a();
                                                    m2 = this.d.m((y.c.d)this.i.b(a2));
                                                    a3 = this;
                                                    if (i != 0) {
                                                        break Label_3729;
                                                    }
                                                    if (!this.c.n(a2)) {
                                                        this.a(a2, m2);
                                                    }
                                                    p3.g();
                                                    if (i != 0) {
                                                        break;
                                                    }
                                                }
                                                d4 = new y.f.f.e.d(this);
                                                d4.a = this.b;
                                                o3 = this.b.o();
                                                while (o3.f()) {
                                                    e2 = o3.e();
                                                    m3 = this.b.m(e2);
                                                    n = this.b.n(e2);
                                                    n2 = m3 + this.b.p(e2);
                                                    n3 = n + this.b.q(e2);
                                                    if (i != 0) {
                                                        break Label_3728;
                                                    }
                                                    Label_3715: {
                                                        Label_3708: {
                                                            if (e2.c() > this.l) {
                                                                array = new f[4][3];
                                                                b = 0;
                                                            Label_1624:
                                                                while (true) {
                                                                    Label_1619:Label_1880_Outer:Label_1878_Outer:
                                                                    while (b < array.length) {
                                                                        n4 = 0;
                                                                        if (i == 0) {
                                                                            n5 = n4;
                                                                            while (true) {
                                                                                while (n5 < array[b].length) {
                                                                                    array[b][n5] = new f();
                                                                                    ++n5;
                                                                                    if (i == 0) {
                                                                                        if (i != 0) {
                                                                                            break;
                                                                                        }
                                                                                        continue Label_0898_Outer;
                                                                                    }
                                                                                    else {
                                                                                        if (i != 0) {
                                                                                            break Label_1619;
                                                                                        }
                                                                                        continue Label_1624;
                                                                                    }
                                                                                }
                                                                                ++b;
                                                                                continue Label_1880_Outer;
                                                                            }
                                                                        }
                                                                        Label_2167: {
                                                                            while (true) {
                                                                            Label_1878:
                                                                                while (true) {
                                                                                Label_1944:
                                                                                    while (true) {
                                                                                        if (n4 >= array.length) {
                                                                                            break Label_1944;
                                                                                        }
                                                                                        n6 = 0;
                                                                                        if (i == 0) {
                                                                                            n7 = n6;
                                                                                            while (true) {
                                                                                                while (n7 < array[b].length) {
                                                                                                    d4.b = b;
                                                                                                    array[b][n7].sort(d4);
                                                                                                    ++n7;
                                                                                                    if (i == 0) {
                                                                                                        if (i != 0) {
                                                                                                            break;
                                                                                                        }
                                                                                                        continue Label_0898_Outer;
                                                                                                    }
                                                                                                    else {
                                                                                                        if (i != 0) {
                                                                                                            break Label_1944;
                                                                                                        }
                                                                                                        break Label_1878;
                                                                                                    }
                                                                                                }
                                                                                                ++b;
                                                                                                continue Label_1878_Outer;
                                                                                            }
                                                                                        }
                                                                                        break Label_1944;
                                                                                        continue Label_1878_Outer;
                                                                                    }
                                                                                    n8 = n6;
                                                                                    do {
                                                                                    Label_1949:
                                                                                        while (n9 < array.length) {
                                                                                            a4 = array[n8][1].a();
                                                                                            if (i != 0) {
                                                                                                break Label_1624;
                                                                                            }
                                                                                            e3 = a4;
                                                                                            while (e3.f()) {
                                                                                                a5 = e3.a();
                                                                                                m4 = this.b.m(a5);
                                                                                                t2 = (t)m4.g();
                                                                                                n9 = n8;
                                                                                                if (i != 0) {
                                                                                                    continue Label_1949;
                                                                                                }
                                                                                                Label_2139: {
                                                                                                    if (n9 == 0) {
                                                                                                        m4.c(new t(t2.a, n));
                                                                                                        if (i == 0) {
                                                                                                            break Label_2139;
                                                                                                        }
                                                                                                    }
                                                                                                    if (n8 == 1) {
                                                                                                        m4.c(new t(m3, t2.b));
                                                                                                        if (i == 0) {
                                                                                                            break Label_2139;
                                                                                                        }
                                                                                                    }
                                                                                                    if (n8 == 2) {
                                                                                                        m4.c(new t(t2.a, n3));
                                                                                                        if (i == 0) {
                                                                                                            break Label_2139;
                                                                                                        }
                                                                                                    }
                                                                                                    if (n8 == 3) {
                                                                                                        m4.c(new t(n2, t2.b));
                                                                                                    }
                                                                                                }
                                                                                                this.a(a5, m4);
                                                                                                e3.g();
                                                                                                if (i != 0) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            ++n8;
                                                                                        }
                                                                                        break;
                                                                                    } while (i == 0);
                                                                                    break Label_2167;
                                                                                    e4 = a4;
                                                                                    while (e4.f()) {
                                                                                        a6 = e4.a();
                                                                                        m5 = this.b.m(a6);
                                                                                        t3 = (t)m5.g();
                                                                                        t4 = (t)m5.g();
                                                                                        n10 = dcmpg(Math.abs(t3.a - t4.a), 0.1);
                                                                                        if (i != 0) {
                                                                                            b = (int)n10;
                                                                                            continue Label_1878;
                                                                                        }
                                                                                        Label_1863: {
                                                                                            if (n10 < 0) {
                                                                                                n11 = ((t3.a < m3) ? 0 : ((t3.a > n2) ? 2 : 1));
                                                                                                if (t3.b > t4.b) {
                                                                                                    array[0][n11].add(a6);
                                                                                                    if (i == 0) {
                                                                                                        break Label_1863;
                                                                                                    }
                                                                                                }
                                                                                                array[2][n11].add(a6);
                                                                                                if (i == 0) {
                                                                                                    break Label_1863;
                                                                                                }
                                                                                            }
                                                                                            n12 = ((t3.b < n) ? 0 : ((t3.b > n3) ? 2 : 1));
                                                                                            if (t3.a > t4.a) {
                                                                                                array[1][n12].add(a6);
                                                                                                if (i == 0) {
                                                                                                    break Label_1863;
                                                                                                }
                                                                                            }
                                                                                            array[3][n12].add(a6);
                                                                                        }
                                                                                        e4.g();
                                                                                        if (i != 0) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                continue Label_0893_Outer;
                                                                            }
                                                                        }
                                                                        f = array[0][0];
                                                                        Label_2365: {
                                                                            if (!f.isEmpty()) {
                                                                                f2 = array[1][1];
                                                                                n13 = n3 - n;
                                                                                if (!f2.isEmpty()) {
                                                                                    n13 = this.b.p(f2.c()).b - n;
                                                                                }
                                                                                n14 = n13 / f.size();
                                                                                n15 = n + n13 - 0.5 * n14;
                                                                                while (!f.isEmpty()) {
                                                                                    d5 = f.d();
                                                                                    m6 = this.b.m(d5);
                                                                                    m6.c(new t(((t)m6.g()).a, n15));
                                                                                    m6.c(new t(m3, n15));
                                                                                    this.a(d5, m6);
                                                                                    f2.b(d5);
                                                                                    n15 -= n14;
                                                                                    if (i != 0) {
                                                                                        break Label_2365;
                                                                                    }
                                                                                    if (i != 0) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            }
                                                                            f = array[0][2];
                                                                        }
                                                                        Label_2558: {
                                                                            if (!f.isEmpty()) {
                                                                                f3 = array[3][1];
                                                                                n16 = n3 - n;
                                                                                if (!f3.isEmpty()) {
                                                                                    n16 = this.b.p(f3.b()).b - n;
                                                                                }
                                                                                n17 = n16 / f.size();
                                                                                n18 = n + n16 - 0.5 * n17;
                                                                                while (!f.isEmpty()) {
                                                                                    d6 = (y.c.d)f.j();
                                                                                    m7 = this.b.m(d6);
                                                                                    m7.c(new t(((t)m7.g()).a, n18));
                                                                                    m7.c(new t(n2, n18));
                                                                                    this.a(d6, m7);
                                                                                    f3.a(d6);
                                                                                    n18 -= n17;
                                                                                    if (i != 0) {
                                                                                        break Label_2558;
                                                                                    }
                                                                                    if (i != 0) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            }
                                                                            f = array[1][0];
                                                                        }
                                                                        Label_2751: {
                                                                            if (!f.isEmpty()) {
                                                                                f4 = array[0][1];
                                                                                n19 = n2 - m3;
                                                                                if (!f4.isEmpty()) {
                                                                                    n19 = this.b.p(f4.b()).a - m3;
                                                                                }
                                                                                n20 = n19 / f.size();
                                                                                n21 = m3 + n19 - 0.5 * n20;
                                                                                while (!f.isEmpty()) {
                                                                                    d7 = (y.c.d)f.j();
                                                                                    m8 = this.b.m(d7);
                                                                                    m8.c(new t(n21, ((t)m8.g()).b));
                                                                                    m8.c(new t(n21, n));
                                                                                    this.a(d7, m8);
                                                                                    f4.a(d7);
                                                                                    n21 -= n20;
                                                                                    if (i != 0) {
                                                                                        break Label_2751;
                                                                                    }
                                                                                    if (i != 0) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            }
                                                                            f = array[1][2];
                                                                        }
                                                                        Label_2944: {
                                                                            if (!f.isEmpty()) {
                                                                                f5 = array[2][1];
                                                                                n22 = n2 - m3;
                                                                                if (!f5.isEmpty()) {
                                                                                    n22 = this.b.p(f5.c()).a - m3;
                                                                                }
                                                                                n23 = n22 / f.size();
                                                                                n24 = m3 + n22 - 0.5 * n23;
                                                                                while (!f.isEmpty()) {
                                                                                    d8 = (y.c.d)f.g();
                                                                                    m9 = this.b.m(d8);
                                                                                    m9.c(new t(n24, ((t)m9.g()).b));
                                                                                    m9.c(new t(n24, n3));
                                                                                    this.a(d8, m9);
                                                                                    f5.b(d8);
                                                                                    n24 -= n23;
                                                                                    if (i != 0) {
                                                                                        break Label_2944;
                                                                                    }
                                                                                    if (i != 0) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            }
                                                                            f = array[3][0];
                                                                        }
                                                                        Label_3137: {
                                                                            if (!f.isEmpty()) {
                                                                                f6 = array[0][1];
                                                                                n25 = n2 - m3;
                                                                                if (!f6.isEmpty()) {
                                                                                    n25 = n2 - this.b.p(f6.c()).a;
                                                                                }
                                                                                n26 = n25 / f.size();
                                                                                n27 = n2 - n25 + 0.5 * n26;
                                                                                while (!f.isEmpty()) {
                                                                                    d9 = (y.c.d)f.g();
                                                                                    m10 = this.b.m(d9);
                                                                                    m10.c(new t(n27, ((t)m10.g()).b));
                                                                                    m10.c(new t(n27, n));
                                                                                    this.a(d9, m10);
                                                                                    f6.b(d9);
                                                                                    n27 += n26;
                                                                                    if (i != 0) {
                                                                                        break Label_3137;
                                                                                    }
                                                                                    if (i != 0) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            }
                                                                            f = array[3][2];
                                                                        }
                                                                        Label_3330: {
                                                                            if (!f.isEmpty()) {
                                                                                f7 = array[2][1];
                                                                                n28 = n2 - m3;
                                                                                if (!f7.isEmpty()) {
                                                                                    n28 = n2 - this.b.p(f7.b()).a;
                                                                                }
                                                                                n29 = n28 / f.size();
                                                                                n30 = n2 - n28 + 0.5 * n29;
                                                                                while (!f.isEmpty()) {
                                                                                    d10 = (y.c.d)f.j();
                                                                                    m11 = this.b.m(d10);
                                                                                    m11.c(new t(n30, ((t)m11.g()).b));
                                                                                    m11.c(new t(n30, n3));
                                                                                    this.a(d10, m11);
                                                                                    f7.b(d10);
                                                                                    n30 += n29;
                                                                                    if (i != 0) {
                                                                                        break Label_3330;
                                                                                    }
                                                                                    if (i != 0) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            }
                                                                            f = array[2][0];
                                                                        }
                                                                        Label_3523: {
                                                                            if (!f.isEmpty()) {
                                                                                f8 = array[1][1];
                                                                                n31 = n3 - n;
                                                                                if (!f8.isEmpty()) {
                                                                                    n31 = n3 - this.b.p(f8.b()).b;
                                                                                }
                                                                                n32 = n31 / f.size();
                                                                                n33 = n3 - n31 + 0.5 * n32;
                                                                                while (!f.isEmpty()) {
                                                                                    d11 = (y.c.d)f.j();
                                                                                    m12 = this.b.m(d11);
                                                                                    m12.c(new t(((t)m12.g()).a, n33));
                                                                                    m12.c(new t(m3, n33));
                                                                                    this.a(d11, m12);
                                                                                    f8.b(d11);
                                                                                    n33 += n32;
                                                                                    if (i != 0) {
                                                                                        break Label_3523;
                                                                                    }
                                                                                    if (i != 0) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            }
                                                                            f = array[2][2];
                                                                        }
                                                                        if (!f.isEmpty()) {
                                                                            f9 = array[3][1];
                                                                            n34 = n3 - n;
                                                                            if (!f9.isEmpty()) {
                                                                                n34 = n3 - this.b.p(f9.c()).b;
                                                                            }
                                                                            n35 = n34 / f.size();
                                                                            n36 = n3 - n34 + 0.5 * n35;
                                                                            while (!f.isEmpty()) {
                                                                                d12 = (y.c.d)f.g();
                                                                                m13 = this.b.m(d12);
                                                                                m13.c(new t(((t)m13.g()).a, n36));
                                                                                m13.c(new t(n2, n36));
                                                                                this.a(d12, m13);
                                                                                f9.b(d12);
                                                                                n36 += n35;
                                                                                if (i != 0) {
                                                                                    break Label_3715;
                                                                                }
                                                                                if (i != 0) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                        break Label_3708;
                                                                    }
                                                                    e2.l();
                                                                    continue Label_1624;
                                                                }
                                                            }
                                                        }
                                                        o3.g();
                                                    }
                                                    if (i != 0) {
                                                        break;
                                                    }
                                                }
                                            }
                                            this.b.a(t);
                                        }
                                        a3 = this;
                                    }
                                    if (a3.m != null) {
                                        this.e.g().a(this.m);
                                        this.m = null;
                                    }
                                    return;
                                }
                                Label_0263: {
                                    Label_0248: {
                                        Label_0218: {
                                            if (c > j) {
                                                a7 = ((p)this.h.b(e)).a();
                                                while (a7.f()) {
                                                    d2.add(this.d.l(a7.a().c()));
                                                    a7.g();
                                                    if (i != 0) {
                                                        break Label_0263;
                                                    }
                                                    if (i != 0) {
                                                        break Label_0218;
                                                    }
                                                }
                                                break Label_0248;
                                            }
                                        }
                                        d2.add(this.d.l((q)this.h.b(e)));
                                    }
                                    t.a(e, d2);
                                    o2.g();
                                }
                                if (i != 0) {
                                    break;
                                }
                            }
                            o4 = this.b.o();
                        Label_0276:
                            while (o4.f()) {
                                e5 = o4.e();
                                n37 = Integer.MAX_VALUE;
                                n38 = Integer.MIN_VALUE;
                                n39 = Integer.MAX_VALUE;
                                n40 = Integer.MIN_VALUE;
                                d13 = (y.c.D)t.b(e5);
                                if (i == 0) {
                                    m14 = d13.m();
                                    while (true) {
                                        while (m14.f()) {
                                            t5 = (t)m14.d();
                                            n41 = dcmpg(t5.a(), (double)n37);
                                            if (i == 0) {
                                                if (n41 < 0) {
                                                    n37 = (int)t5.a();
                                                }
                                                if (t5.b() < n39) {
                                                    n39 = (int)t5.b();
                                                }
                                                if (t5.a() > n38) {
                                                    n38 = (int)t5.a();
                                                }
                                                if (t5.b() > n40) {
                                                    n40 = (int)t5.b();
                                                }
                                                m14.g();
                                                if (i != 0) {
                                                    break;
                                                }
                                                continue Label_0898_Outer;
                                            }
                                            else {
                                                Label_0875: {
                                                    if (n41 == 3 || this.f == 2) {
                                                        this.b.p(e5);
                                                        this.b.q(e5);
                                                        r = this.b.r(e5);
                                                        d14 = new y.c.D();
                                                        d15 = new y.c.D();
                                                        d16 = new y.c.D();
                                                        d17 = new y.c.D();
                                                        Label_0851: {
                                                            if (e5.c() > this.l) {
                                                                a8 = ((p)this.h.b(e5)).a();
                                                                while (true) {
                                                                    while (a8.f()) {
                                                                        l3 = this.d.l(a8.a().c());
                                                                        n42 = dcmpl(l3.a(), (double)n37);
                                                                        if (i == 0) {
                                                                            if (n42 >= 0 && l3.a() <= n38) {
                                                                                if (l3.b() == n39) {
                                                                                    d14.add(new Integer((int)l3.a()));
                                                                                }
                                                                                if (l3.b() == n40) {
                                                                                    d15.add(new Integer((int)l3.a()));
                                                                                }
                                                                            }
                                                                            if (l3.b() >= n39 && l3.b() <= n40) {
                                                                                if (l3.a() == n37) {
                                                                                    d16.add(new Integer((int)l3.b()));
                                                                                }
                                                                                if (l3.a() == n38) {
                                                                                    d17.add(new Integer((int)l3.b()));
                                                                                }
                                                                            }
                                                                            a8.g();
                                                                            if (i != 0) {
                                                                                break;
                                                                            }
                                                                            continue Label_0898_Outer;
                                                                        }
                                                                        else {
                                                                            this.b.a(e5, n42, this.a(d16, d17, n39, n40, (int)r.b));
                                                                            if (i != 0) {
                                                                                break Label_0851;
                                                                            }
                                                                            break Label_0875;
                                                                        }
                                                                    }
                                                                    this.a(d14, d15, n37, n38, (int)r.a);
                                                                    continue Label_0893_Outer;
                                                                }
                                                            }
                                                        }
                                                        this.b.a(e5, (n37 + n38) / 2, (n39 + n40) / 2);
                                                    }
                                                }
                                                o4.g();
                                                if (i != 0) {
                                                    break Label_0898;
                                                }
                                                continue Label_0276;
                                            }
                                        }
                                        f10 = this.f;
                                        continue Label_0893_Outer;
                                    }
                                }
                                f11 = this.f;
                                continue Label_0898;
                            }
                            break;
                        }
                        this.e.b();
                        continue;
                    }
                }
                d.a(o.e(), l);
                o.g();
                if (i != 0) {
                    break;
                }
            }
            final X b2 = this.b;
            continue;
        }
    }
    
    void a(y.c.d h, final y.c.D d) {
        this.b.a(h, d);
        h = this.c.h(h);
        d.n();
        this.b.a(h, d);
    }
    
    private int a(final y.c.D d, final y.c.D d2, final int n, final int n2) {
        final y.c.D d3 = new y.c.D();
        d3.addAll(d);
        d3.addAll(d2);
        if (d3.size() == 0) {
            return (n2 + n) / 2;
        }
        d3.o();
        return this.a(d3);
    }
    
    private int a(final y.c.D d, final y.c.D d2, final int n, final int n2, final int n3) {
        if (n3 >= n2 - n) {
            return n + n3 / 2;
        }
        int a = this.a(d, d2, n, n2);
        if (a - n3 / 2 < n) {
            a = n + n3 / 2;
            if (y.f.f.e.a.a == 0) {
                return a;
            }
        }
        if (a + n3 / 2 > n2) {
            a = n2 - n3 / 2;
        }
        return a;
    }
    
    private int a(final y.c.D d) {
        final int a = y.f.f.e.a.a;
        d.sort(new b(this));
        final C m = d.m();
        int i = 0;
        while (i < d.size() / 2) {
            final Object d2;
            final C c = (C)(d2 = m);
            if (a != 0) {
                return (int)d2;
            }
            c.g();
            ++i;
            if (a != 0) {
                break;
            }
        }
        Object d2 = m.d();
        return (int)d2;
    }
    
    static X a(final a a) {
        return a.b;
    }
}
