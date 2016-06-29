package y.f.c.a;

import java.awt.geom.*;
import y.f.*;
import y.g.*;
import y.a.*;
import y.c.*;
import y.f.b.*;
import y.d.*;
import java.util.*;

class dg
{
    q f;
    private D a;
    aQ g;
    aQ h;
    float i;
    float j;
    int k;
    int l;
    float m;
    float n;
    int o;
    int p;
    da[] q;
    private float b;
    int r;
    BitSet s;
    int t;
    int u;
    boolean v;
    Rectangle2D w;
    double x;
    double y;
    public y z;
    public aQ A;
    public aQ B;
    E C;
    HashSet D;
    double E;
    double F;
    HashMap G;
    
    dg(final E c, final q f) {
        this.G = new HashMap();
        this.C = c;
        if (f != null) {
            this.f = f;
            final am a = ((X)f.e()).a((Object)f);
            this.z = new y(a.getX(), a.getY(), a.getWidth(), a.getHeight());
        }
        this.a = new D();
        this.D = new HashSet();
    }
    
    void b(final Object o) {
        if (!this.D.contains(o)) {
            this.a.b(o);
            this.D.add(o);
        }
    }
    
    public void a(final aU au, final int n, final aV av) {
        final boolean x = N.x;
        if (this.g != null && this.h != null && this.g.c() <= n && this.h.c() >= n) {
            int n2 = 0;
            final da b = this.b(n);
            D d = null;
            D d2 = null;
            final int k = av.a((q)b.f()).k();
            final int i = av.a((q)b.i()).k();
            p p3 = b.k();
            while (true) {
                while (p3 != null) {
                    final int n3;
                    final boolean b2 = (n3 = ((p3.c() instanceof q) ? 1 : 0)) != 0;
                    if (!x) {
                        Label_0411: {
                            Label_0404: {
                                if (b2) {
                                    final q q = (q)p3.c();
                                    final aX a = av.a(q);
                                    if (a.b() != 15) {
                                        break Label_0404;
                                    }
                                    if (n2 == 0) {
                                        this.G.clear();
                                        d = new y.c.y();
                                        d2 = new y.c.y();
                                    }
                                    n2 = 1;
                                    if (a.e() <= 0) {
                                        break Label_0404;
                                    }
                                    double n4 = 0.0;
                                    p p4 = a.d();
                                    while (p4 != null) {
                                        n4 += av.a(((d)p4.c()).a(q)).k();
                                        p4 = p4.a();
                                        if (x) {
                                            break Label_0411;
                                        }
                                        if (x) {
                                            break;
                                        }
                                    }
                                    final double n5 = n4 / a.e();
                                    Label_0373: {
                                        if (Math.abs(n5 - k) < Math.abs(i - n5)) {
                                            d.add(q);
                                            this.G.put(q, new Double(n5));
                                            if (!x) {
                                                break Label_0373;
                                            }
                                        }
                                        d2.add(q);
                                        this.G.put(q, new Double(-n5));
                                    }
                                    b.h(p3);
                                    if (!x) {
                                        break Label_0404;
                                    }
                                }
                                ((dg)p3.c()).a(au, n, av);
                            }
                            p3 = p3.a();
                        }
                        if (x) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if (n3 != 0) {
                            final Comparator c = e.c(M.a(this.G));
                            d.sort(c);
                            d2.sort(c);
                            while (!d.isEmpty()) {
                                b.b(d.g(), b.k());
                                if (x) {
                                    return;
                                }
                                if (x) {
                                    break;
                                }
                            }
                            while (!d2.isEmpty()) {
                                b.a(d2.g(), b.l());
                                if (x) {
                                    break;
                                }
                            }
                        }
                        return;
                    }
                }
                int n3 = n2;
                continue;
            }
        }
    }
    
    void a(final aQ aq, final X x) {
        final boolean x2 = N.x;
        final int c = aq.c();
        final da b = this.b(c);
        b.f = 0.0;
        p p2 = b.k();
        while (p2 != null) {
            Label_0187: {
                if (p2.c() instanceof q) {
                    b.f = Math.max(b.f, x.a(p2.c()).getHeight());
                    if (!x2) {
                        break Label_0187;
                    }
                }
                final dg dg = (dg)p2.c();
                dg.a(aq, x);
                final da b2 = dg.b(c);
                final am a = x.a(b2.f());
                a.setSize(a.getWidth(), b2.f);
                final am a2 = x.a(b2.i());
                a2.setSize(a2.getWidth(), b2.f);
                b.f = Math.max(b.f, b2.f);
            }
            p2 = p2.a();
            if (x2) {
                break;
            }
        }
    }
    
    void a(final int n) {
        final boolean x = N.x;
        Label_0098: {
            if (this.g.c() <= n && this.h.c() >= n) {
                final da b = this.b(n);
                int n2 = 0;
                p p = b.k();
                while (p != null) {
                    if (p.c() instanceof dg) {
                        final dg dg = (dg)p.c();
                        dg.r = n2++;
                        dg.a(n);
                    }
                    p = p.a();
                    if (x) {
                        break Label_0098;
                    }
                }
                return;
            }
        }
        this.r = -1;
    }
    
    void b() {
        final boolean x = N.x;
        final i i = new i();
        final A t = i.t();
        if (this.g != null && this.h != null) {
            final int c = this.g.c();
            final int c2 = this.h.c();
            final HashMap<dg, q> hashMap = new HashMap<dg, q>();
            int n = c;
            do {
                int j = 0;
            Label_0067:
                while (j <= c2) {
                    final da b = this.b(n);
                    q q = null;
                    Object o = null;
                    if (x) {
                        return;
                    }
                    p p = b.k();
                    while (p != null) {
                        final Object c3 = p.c();
                        j = ((c3 instanceof dg) ? 1 : 0);
                        if (x) {
                            continue Label_0067;
                        }
                        if (j != 0) {
                            final dg dg = (dg)c3;
                            q d = hashMap.get(dg);
                            if (d == null) {
                                d = i.d();
                                hashMap.put(dg, d);
                                t.a(d, dg);
                            }
                            if (q != null && q.a(d) == null) {
                                if (d.a(q) != null) {
                                    throw new IllegalStateException("grouping inconsistent " + o + " <-- " + dg);
                                }
                                i.a(q, d);
                            }
                            q = d;
                            o = dg;
                        }
                        p = p.a();
                        if (x) {
                            break;
                        }
                    }
                    ++n;
                }
                break;
            } while (!x);
            if (y.a.g.b(i)) {
                throw new IllegalStateException("grouping inconsistent");
            }
        }
    }
    
    p a(final int n, p p2) {
        final boolean x = N.x;
        p p3 = this.b(n).k();
        p p4 = null;
        while (p3 != null) {
            p4 = p3;
            if (x) {
                return p4;
            }
            final Object c = p4.c();
            Label_0075: {
                if (c instanceof dg) {
                    p2 = ((dg)c).a(n, p2);
                    if (!x) {
                        break Label_0075;
                    }
                }
                final q q = (q)c;
                p2.a(c);
                p2 = p2.a();
            }
            p3 = p3.a();
            if (x) {
                break;
            }
        }
        return p4;
    }
    
    void c() {
        final boolean x = N.x;
        if (this.g == null || this.h == null) {
            return;
        }
        final i i = new i();
        final A t = i.t();
        final int c = this.g.c();
        final int c2 = this.h.c();
        int n = 0;
        final HashMap<dg, q> hashMap = new HashMap<dg, q>();
        int n2 = c;
        while (true) {
            do {
                int j = 0;
            Label_0071:
                while (j <= c2) {
                    final da b = this.b(n2);
                    q q = null;
                    if (x) {
                        final x o = i.o();
                    Label_0365_Outer:
                        while (o.f()) {
                            final q e = o.e();
                            final dg dg = (dg)t.b(e);
                            dg.s = new BitSet(i.e());
                            d d = e.f();
                            while (true) {
                                while (d != null) {
                                    dg.s.set(((dg)t.b(d.d())).t);
                                    d = d.g();
                                    if (!x) {
                                        if (x) {
                                            break;
                                        }
                                        continue Label_0365_Outer;
                                    }
                                    else {
                                        if (x) {
                                            break Label_0365_Outer;
                                        }
                                        continue Label_0365_Outer;
                                    }
                                }
                                dg.c();
                                o.g();
                                continue;
                            }
                        }
                        return;
                    }
                    p p = b.k();
                    while (p != null) {
                        final Object c3 = p.c();
                        j = ((c3 instanceof dg) ? 1 : 0);
                        if (x) {
                            continue Label_0071;
                        }
                        if (j != 0) {
                            final dg dg2 = (dg)c3;
                            q d2 = hashMap.get(dg2);
                            if (d2 == null) {
                                d2 = i.d();
                                hashMap.put(dg2, d2);
                                t.a(d2, dg2);
                                dg2.t = n++;
                            }
                            if (q != null && q.a(d2) == null) {
                                i.a(q, d2);
                            }
                            q = d2;
                        }
                        p = p.a();
                        if (x) {
                            break;
                        }
                    }
                    ++n2;
                }
                break;
            } while (!x);
            y.a.z.a(i);
            continue;
        }
    }
    
    void a(final int n, final boolean b, final c c) {
        final boolean x = N.x;
        final da b2 = this.b(n);
        p p3 = b2.k();
    Label_0631:
        while (true) {
            while (p3 != null) {
                final Object c2 = p3.c();
                final int n2 = (c2 instanceof dg) ? 1 : 0;
                if (x) {
                    int n3 = n2;
                    p p4 = b2.k();
                    while (p4 != null) {
                        final Object c3 = p4.c();
                        if (c3 instanceof dg) {
                            final dg dg = (dg)c3;
                            dg.r = n3++;
                            dg.a(n, b, c);
                        }
                        p4 = p4.a();
                        if (x) {
                            break;
                        }
                    }
                    return;
                }
                if (n2 != 0) {
                    final dg dg2 = (dg)c2;
                    dg2.v = (dg2.l > 0);
                }
                p3 = p3.a();
                if (x) {
                    break;
                }
            }
            p p5 = b2.k();
            while (p5 != null) {
                final Object c4 = p5.c();
                final boolean b3 = c4 instanceof dg;
                if (x) {
                    break;
                }
                if (b3) {
                    final dg dg3 = (dg)c4;
                    final boolean b4 = (b && dg3.g.c() < n) || (!b && dg3.h.c() > n);
                    if (!dg3.v) {
                        p p6 = null;
                        p p7 = p5.b();
                        while (p7 != null) {
                            final boolean b5 = p7.c() instanceof dg;
                            if (x) {
                                continue Label_0631;
                            }
                            if (b5) {
                                final dg dg4 = (dg)p7.c();
                                final boolean b6 = (b && dg4.g.c() < n) || (!b && dg4.h.c() > n);
                                final int n4 = dg4.v ? dg3.a(dg4, b4 && b6) : 0;
                                if (n4 == 0) {
                                    p7 = p7.b();
                                    if (!x) {
                                        continue;
                                    }
                                }
                                if (n4 < 0) {
                                    p6 = p7;
                                    p7 = p7.b();
                                    if (!x) {
                                        continue;
                                    }
                                }
                                if (n4 > 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                p7 = p7.b();
                                if (x) {
                                    break;
                                }
                                continue;
                            }
                        }
                        if (p6 != null) {
                            final p a = p5.a();
                            b2.h(p5);
                            b2.a(p5, p6);
                            p5 = a;
                            dg3.v = true;
                            if (!x) {
                                continue;
                            }
                        }
                        p p8 = p5.a();
                        while (p8 != null) {
                            final boolean b7 = p8.c() instanceof dg;
                            if (x) {
                                continue Label_0631;
                            }
                            if (b7) {
                                final dg dg5 = (dg)p8.c();
                                final boolean b8 = (b && dg5.g.c() < n) || (!b && dg5.h.c() > n);
                                final int n5 = dg5.v ? dg3.a(dg5, b4 && b8) : 0;
                                if (n5 == 0) {
                                    p8 = p8.a();
                                    if (!x) {
                                        continue;
                                    }
                                }
                                if (n5 > 0) {
                                    p6 = p8;
                                    p8 = p8.a();
                                    if (!x) {
                                        continue;
                                    }
                                }
                                if (n5 < 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                p8 = p8.a();
                                if (x) {
                                    break;
                                }
                                continue;
                            }
                        }
                        if (p6 != null) {
                            final p a2 = p5.a();
                            b2.h(p5);
                            b2.b(p5, p6);
                            p5 = a2;
                            dg3.v = true;
                            if (!x) {
                                continue;
                            }
                        }
                        dg3.v = true;
                    }
                }
                p5 = p5.a();
                if (x) {
                    break;
                }
            }
            continue Label_0631;
        }
    }
    
    int a(final dg dg, final boolean b) {
        if (b && this.r >= 0 && dg.r >= 0) {
            return this.r - dg.r;
        }
        if (this.s != null && dg.s != null) {
            if (this.s.get(dg.t)) {
                return -1;
            }
            if (dg.s.get(this.t)) {
                return 1;
            }
        }
        return 0;
    }
    
    void d() {
        final boolean x = N.x;
        for (final dg next : this.a) {
            if (next instanceof dg) {
                final dg dg = next;
                dg.d();
                if (dg.g != null && (this.g == null || dg.g.c() < this.g.c())) {
                    this.g = dg.g;
                }
                if (dg.A != null && (this.A == null || dg.A.c() < this.A.c())) {
                    this.A = dg.A;
                }
                if (dg.h != null && (this.h == null || dg.h.c() > this.h.c())) {
                    this.h = dg.h;
                }
                if (dg.B == null || (this.B != null && dg.B.c() <= this.B.c())) {
                    continue;
                }
                this.B = dg.B;
                if (x) {
                    break;
                }
                continue;
            }
        }
    }
    
    void e() {
        final boolean x = N.x;
        final int c = this.g.c();
        final int c2 = this.h.c();
        this.q = new da[c2 - c + 1];
        int i = c;
        while (i <= c2) {
            this.q[i - c] = new da();
            ++i;
            if (x) {
                break;
            }
        }
    }
    
    void a(final aU au, final aV av, final dd dd) {
        final boolean x = N.x;
        if (this.g == null || this.h == null) {
            return;
        }
        final int c = this.g.c();
        final int c2 = this.h.c();
        this.q = new da[c2 - c + 1];
        int i = c;
        while (true) {
            while (i <= c2) {
                final dg dg = this;
                if (x) {
                Label_0309:
                    for (final q next : dg.a) {
                        if (next instanceof q) {
                            final q q = next;
                            if (q.e() == null || dd.a((Object)q) != this) {
                                continue;
                            }
                            final int j = av.a(q).j();
                            if (this.g.c() > j || this.h.c() < j) {
                                continue;
                            }
                            this.b(j).add(q);
                            if (!x) {
                                continue;
                            }
                        }
                        final dg dg2 = (dg)next;
                        if (dg2.g != null && dg2.h != null) {
                            dg2.a(au, av, dd);
                            final int c3 = dg2.g.c();
                            final int c4 = dg2.h.c();
                            int k = c3;
                            while (k <= c4) {
                                this.b(k).add(dg2);
                                ++k;
                                if (x || x) {
                                    break Label_0309;
                                }
                            }
                        }
                    }
                    return;
                }
                this.q[i - c] = new da();
                ++i;
                if (x) {
                    break;
                }
            }
            final dg dg = this;
            continue;
        }
    }
    
    void a(final int n, final float[] array, final c c, final aV av, final boolean b) {
        this.a(n, array, c, b);
        this.a(n, new dh(this, array), av);
    }
    
    private void a(final int n, final Comparator comparator, final aV av) {
        final boolean x = N.x;
        final da b = this.b(n);
        b.sort(comparator);
        p p3 = null;
        p p4 = null;
        p p5 = b.k();
        while (true) {
            while (p5 != null) {
                final Object c = p5.c();
                if (x) {
                    b.b(p4, b.l());
                    return;
                }
                Label_0123: {
                    if (c instanceof dg) {
                        ((dg)p5.c()).a(n, comparator, av);
                        if (!x) {
                            break Label_0123;
                        }
                    }
                    final byte b2 = av.a((q)p5.c()).b();
                    if (b2 == 12) {
                        p3 = p5;
                        if (!x) {
                            break Label_0123;
                        }
                    }
                    if (b2 == 13) {
                        p4 = p5;
                    }
                }
                p5 = p5.a();
                if (x) {
                    break;
                }
            }
            if (p3 != null && p3 != b.k()) {
                b.h(p3);
                b.a(p3, b.k());
            }
            if (p4 != null && p4 != b.l()) {
                b.h(p4);
                continue;
            }
            break;
        }
    }
    
    da b(final int n) {
        return this.q[n - this.g.c()];
    }
    
    private void a(final int n, final float[] array, final c c, final boolean b) {
        final boolean x = N.x;
        final float n2 = 0.0f;
        this.n = n2;
        this.m = n2;
        this.j = n2;
        this.i = n2;
        final boolean b2 = false;
        this.p = (b2 ? 1 : 0);
        this.o = (b2 ? 1 : 0);
        this.l = (b2 ? 1 : 0);
        this.k = (b2 ? 1 : 0);
        while (true) {
            for (final dg next : this.b(n)) {
                final int n3 = (next instanceof dg) ? 1 : 0;
                if (x) {
                    if (n3 > 0) {
                        this.b = this.j / this.l;
                        if (!x) {
                            return;
                        }
                    }
                    if (this.k > 0) {
                        this.b = this.i / this.k;
                        if (!x) {
                            return;
                        }
                    }
                    if (this.p > 0) {
                        this.b = this.n / this.p;
                        if (!x) {
                            return;
                        }
                    }
                    if (this.o > 0) {
                        this.b = this.m / this.o;
                        if (!x) {
                            return;
                        }
                    }
                    this.b = 0.0f;
                    return;
                }
                if (n3 != 0) {
                    final dg dg = next;
                    dg.a(n, array, c, b);
                    this.i += dg.i;
                    this.k += dg.k;
                    this.j += dg.j;
                    this.l += dg.l;
                    this.m += dg.m;
                    this.o += dg.o;
                    this.n += dg.n;
                    this.p += dg.p;
                    if (!x) {
                        continue;
                    }
                }
                final q q = (q)next;
                final boolean b3 = (b && q.b() > 0) || (!b && q.c() > 0);
                if (c != null && !c.d(q)) {
                    if (b3) {
                        ++this.l;
                        this.j += array[q.d()];
                    }
                    ++this.p;
                    this.n += array[q.d()];
                    if (!x) {
                        continue;
                    }
                }
                if (b3) {
                    ++this.k;
                    this.i += array[q.d()];
                }
                ++this.o;
                this.m += array[q.d()];
                if (x) {
                    break;
                }
            }
            final int l = this.l;
            continue;
        }
    }
    
    p a(final aQ aq, p p4, final aP ap, final dd dd) {
        final boolean x = N.x;
        if (this.g == null || this.g.c() > aq.c() || this.h == null || this.h.c() < aq.c()) {
            return p4;
        }
        final y.c.y d = aq.d();
        final da b = this.b(aq.c());
        boolean b2 = true;
        if (b.size() > 1 && b.f() instanceof q && b.i() instanceof q) {
            final aX a = dd.b.a((q)b.f());
            final aX a2 = dd.b.a((q)b.i());
            if (a.b() == 12 && a2.b() == 13) {
                b2 = false;
            }
        }
        p p5 = b.k();
        p p6 = null;
        while (p5 != null) {
            p6 = p5;
            if (x) {
                return p6;
            }
            final Object c = p6.c();
            Label_0378: {
                if (c instanceof dg) {
                    final dg dg = (dg)c;
                    if (b2) {
                        final q a3 = ap.a(dg.f, aq, (byte)12);
                        d.a(a3, p4);
                        p4 = dg.a(aq, p4, ap, dd);
                        final q a4 = ap.a(dg.f, aq, (byte)13);
                        Label_0300: {
                            if (p4 != null) {
                                d.a(a4, p4);
                                if (!x) {
                                    break Label_0300;
                                }
                            }
                            d.b(a4);
                        }
                        dg.b(aq.c()).a(a3);
                        dg.b(aq.c()).b(a4);
                        dd.a(a3, dg);
                        dd.a(a4, dg);
                        if (!x) {
                            break Label_0378;
                        }
                    }
                    p4 = dg.a(aq, p4, ap, dd);
                    if (!x) {
                        break Label_0378;
                    }
                }
                p4 = p4.a();
            }
            p5 = p5.a();
            if (x) {
                break;
            }
        }
        return p6;
    }
    
    public void b(final aV av) {
        final boolean x = N.x;
        final Iterator iterator = this.a.iterator();
        while (true) {
            while (iterator.hasNext()) {
                final q next = iterator.next();
                final int n2;
                final int n = n2 = ((next instanceof q) ? 1 : 0);
                if (x) {
                    int n3 = n2;
                    do {
                        int i = 0;
                    Label_0128:
                        while (i < this.q.length) {
                            final da da = this.q[n3];
                            p p = da.k();
                            while (p != null) {
                                i = ((p.c() instanceof q) ? 1 : 0);
                                if (x) {
                                    continue Label_0128;
                                }
                                if (i != 0) {
                                    final aX a = av.a((q)p.c());
                                    if (a.b() == 12 || a.b() == 13) {
                                        da.h(p);
                                    }
                                }
                                p = p.a();
                                if (x) {
                                    break;
                                }
                            }
                            ++n3;
                        }
                        break;
                    } while (!x);
                    return;
                }
                if (n != 0) {
                    final aX a2 = av.a(next);
                    if (a2.b() != 12 && a2.b() != 13) {
                        continue;
                    }
                    iterator.remove();
                    this.D.remove(next);
                    if (!x) {
                        continue;
                    }
                }
                ((dg)next).b(av);
                if (x) {
                    break;
                }
            }
            if (this.q != null) {
                final int n2 = 0;
                continue;
            }
            break;
        }
    }
    
    public void a(final cr cr, final aQ aq, final boolean b, final double n) {
        final boolean x = N.x;
        final aV c = this.C.c;
        final X b2 = this.C.b;
        final da b3 = this.b(aq.c());
        q q = null;
        p p4 = b3.k();
        while (p4 != null) {
            final Object c2 = p4.c();
            Label_0749: {
                Label_0742: {
                    if (c2 instanceof dg) {
                        final dg dg = (dg)c2;
                        dg.a(cr, aq, b, n);
                        if (b && this.A == aq) {
                            cr.a(this, dg, 2);
                            if (!x) {
                                break Label_0742;
                            }
                        }
                        if (b || this.B != aq) {
                            break Label_0742;
                        }
                        cr.a(dg, this, 2);
                        if (!x) {
                            break Label_0742;
                        }
                    }
                    final q q2 = (q)c2;
                    final aX a = c.a(q2);
                    Label_0419: {
                        if (b && this.A == aq) {
                            if (a.b() == 12) {
                                q = q2;
                                if (!x) {
                                    break Label_0742;
                                }
                            }
                            if (a.b() == 13) {
                                final double n2 = b2.m(q) + b2.p(q);
                                final double m = b2.m(q2);
                                final q f = a.f();
                                final r c3 = this.C.c(f);
                                final aY i = c.a(f).i();
                                cr.a(this, 0.0, Math.max((i != null) ? i.d() : 0.0, this.C.h()), c3.a, n2, !b, m, !b).l = Math.min(b2.k(q), b2.k(q2)) + n;
                                if (!x) {
                                    break Label_0742;
                                }
                            }
                            if (a.b() == 15) {
                                p p5 = a.d();
                                while (p5 != null) {
                                    cr.a(p5.c(), this, 1);
                                    p5 = p5.a();
                                    if (x) {
                                        break Label_0749;
                                    }
                                    if (x) {
                                        break Label_0419;
                                    }
                                }
                            }
                            break Label_0742;
                        }
                    }
                    if (!b && this.B == aq) {
                        if (a.b() == 12) {
                            q = q2;
                            if (!x) {
                                break Label_0742;
                            }
                        }
                        if (a.b() == 13) {
                            final double n3 = b2.m(q) + b2.p(q);
                            final double j = b2.m(q2);
                            final q f2 = a.f();
                            final r c4 = this.C.c(f2);
                            final aY k = c.a(f2).i();
                            final cy a2 = cr.a(this, 0.0, c4.c, Math.max((k != null) ? k.d() : 0.0, this.C.h()), n3, !b, j, !b);
                            final c c5 = b2.c(y.f.b.f.f);
                            if (c5 != null) {
                                final y.d.q q3 = (y.d.q)c5.b(this.f);
                                if (q3 != null) {
                                    a2.k = this.E + q3.b;
                                    if (!x) {
                                        break Label_0742;
                                    }
                                }
                                a2.k = this.E;
                                if (!x) {
                                    break Label_0742;
                                }
                            }
                            a2.k = this.E;
                            if (!x) {
                                break Label_0742;
                            }
                        }
                        if (a.b() == 15) {
                            p p6 = a.d();
                            while (p6 != null) {
                                cr.a(this, p6.c(), 1);
                                p6 = p6.a();
                                if (x) {
                                    break Label_0749;
                                }
                                if (x) {
                                    break;
                                }
                            }
                        }
                    }
                }
                p4 = p4.a();
            }
            if (x) {
                break;
            }
        }
    }
    
    public Collection f() {
        return this.a;
    }
    
    static float a(final dg dg) {
        return dg.b;
    }
}
