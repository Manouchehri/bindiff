package y.f.c;

import y.f.*;
import java.util.*;
import y.g.*;
import y.a.*;
import y.c.*;
import y.f.c.a.*;

public class r implements R, aT
{
    private q a;
    private q b;
    private y c;
    private R d;
    private c e;
    private HashMap f;
    private X g;
    private boolean h;
    private h i;
    private h j;
    private A k;
    private A l;
    private A m;
    private c n;
    private int o;
    private f p;
    private f q;
    private boolean r;
    
    public r(final R d) {
        this.d = new af();
        this.h = true;
        this.d = d;
    }
    
    public r() {
        this(new af());
        ((af)this.d).a((byte)2);
    }
    
    public void a(final boolean r) {
        this.r = r;
    }
    
    public int a(final X x, final A a, final f f) {
        final boolean i = a.i;
        this.g = new w();
        final c c = x.c(s.a);
        Label_0057: {
            if (c != null) {
                this.e = (c)c.b(s.a);
                if (!i) {
                    break Label_0057;
                }
            }
            this.e = null;
        }
        final c c2 = x.c(ah.f_);
        this.f = new HashMap();
        this.n = x.c("y.layout.hierarchic.ConstraintLayerer.EDGE_WEIGHTS_DPKEY");
        this.m = x.t();
        this.k = this.g.t();
        this.o = 0;
        Label_0240: {
            Label_0235: {
                Label_0181: {
                    if (c2 != null) {
                        final x o = x.o();
                        while (o.f()) {
                            final q e = o.e();
                            this.f.put(c2.b(e), e);
                            o.g();
                            if (i) {
                                break Label_0240;
                            }
                            if (i) {
                                break Label_0181;
                            }
                        }
                        break Label_0235;
                    }
                }
                final x o2 = x.o();
                while (o2.f()) {
                    final q e2 = o2.e();
                    this.f.put(e2, e2);
                    o2.g();
                    if (i) {
                        break Label_0240;
                    }
                    if (i) {
                        break;
                    }
                }
            }
            this.b(x);
        }
        if (this.h && this.n == null) {
            x.a(this.m);
            return this.c(x, a, f);
        }
        this.a();
        this.b((i)x);
        this.a(x);
        int n = this.b(x, a);
        if (!this.r) {
            this.a(x, a);
            n = this.b(x, a);
        }
        this.b(x, a, f);
        x.a(this.m);
        this.f.clear();
        return n;
    }
    
    private void a(final X x, final A a) {
        final boolean i = a.i;
        final y y = new y();
        int n = 0;
        final HashMap<q, q> hashMap = new HashMap<q, q>();
        final HashMap<q, q> hashMap2 = new HashMap<q, q>();
        x x2 = this.c.a();
        while (true) {
            while (x2.f()) {
                final q e = x2.e();
                final x m = e.m();
                final q e2 = m.e();
                m.g();
                final q e3 = m.e();
                hashMap.put(e, e2);
                hashMap2.put(e, e3);
                x2.g();
                if (i) {
                    while (true) {
                        while (x2.f()) {
                            this.g.a(x2.e());
                            x2.g();
                            if (i) {
                                while (true) {
                                    while (x2.f()) {
                                        final q e4 = x2.e();
                                        final q q = hashMap.get(e4);
                                        final q q2 = hashMap2.get(e4);
                                        final int a2 = a.a(((y)this.k.b(q)).b());
                                        final A t = a;
                                        if (i) {
                                            final A a3 = t;
                                            y.a.m.a(y.a.m.a(this.g), a3);
                                            final x a4 = y.a();
                                            while (a4.f()) {
                                                final q e5 = a4.e();
                                                final q q3 = hashMap.get(e5);
                                                final int a5 = a3.a(q3);
                                                final q q4 = hashMap2.get(e5);
                                                final int a6 = a3.a(q4);
                                                if (i) {
                                                    return;
                                                }
                                                Label_0664: {
                                                    if (a5 <= a6) {
                                                        if (q3.a(q4) != null) {
                                                            break Label_0664;
                                                        }
                                                        final d a7 = this.g.a(q3, q4);
                                                        this.j.a(a7, 1);
                                                        this.i.a(a7, 100);
                                                        ++n;
                                                        if (!i) {
                                                            break Label_0664;
                                                        }
                                                    }
                                                    if (q3.b(q4) == null) {
                                                        final d a8 = this.g.a(q4, q3);
                                                        this.j.a(a8, 1);
                                                        this.i.a(a8, 100);
                                                        ++n;
                                                    }
                                                }
                                                a4.g();
                                                if (i) {
                                                    break;
                                                }
                                            }
                                            this.g.a(a3);
                                            return;
                                        }
                                        final int a9 = a.a(((y)this.k.b(q2)).b());
                                        Label_0441: {
                                            if (q != q2) {
                                                if (a2 == a9) {
                                                    y.add(e4);
                                                    if (!i) {
                                                        break Label_0441;
                                                    }
                                                }
                                                if (a2 < a9) {
                                                    if (q.a(q2) != null) {
                                                        break Label_0441;
                                                    }
                                                    final d a10 = this.g.a(q, q2);
                                                    this.j.a(a10, a9 - a2);
                                                    this.i.a(a10, 1);
                                                    ++n;
                                                    if (!i) {
                                                        break Label_0441;
                                                    }
                                                }
                                                if (q.b(q2) == null) {
                                                    final d a11 = this.g.a(q2, q);
                                                    this.j.a(a11, a2 - a9);
                                                    this.i.a(a11, 1);
                                                    ++n;
                                                }
                                            }
                                        }
                                        x2.g();
                                        if (i) {
                                            break;
                                        }
                                    }
                                    final A t = this.g.t();
                                    continue;
                                }
                            }
                            if (i) {
                                break;
                            }
                        }
                        x2 = this.c.a();
                        continue;
                    }
                }
                if (i) {
                    break;
                }
            }
            x2 = this.c.a();
            continue;
        }
    }
    
    private void b(final X x, final A a, final f f) {
        f.addAll(y.f.c.w.a(x, a));
    }
    
    private void a(final X x) {
        final boolean i = y.f.c.a.i;
        this.c = new y();
        this.o += x.g() + 10;
        e e = this.q.a();
        while (true) {
            while (e.f()) {
                final d a = e.a();
                this.a((q)this.m.b(a.c()), (q)this.m.b(a.d()), a, false);
                e.g();
                if (i) {
                    while (e.f()) {
                        final d a2 = e.a();
                        this.a((q)this.m.b(a2.c()), (q)this.m.b(a2.d()), a2, true);
                        e.g();
                        if (i) {
                            break;
                        }
                    }
                    return;
                }
                if (i) {
                    break;
                }
            }
            e = this.p.a();
            continue;
        }
    }
    
    private void a(final q q, final q q2, final d d, final boolean b) {
        final boolean i = y.f.c.a.i;
        final int a = this.l.a(q);
        final int a2 = this.l.a(q2);
        final d c = q.c(q2);
        if (c != null) {
            this.i.a(c, Math.max((this.n == null) ? 1 : this.n.a(d), this.i.a(c)));
            return;
        }
        if (q == q2) {
            return;
        }
        if (a < a2) {
            this.a(q, q2, d, false, false);
            if (!i) {
                return;
            }
        }
        if (a == a2) {
            this.a(q, q2, d, true, true);
            if (!i) {
                return;
            }
        }
        this.a(q2, q, d, false, true);
    }
    
    private void a(final q q, final q q2, final d d, final boolean b, final boolean b2) {
        final q d2 = this.g.d();
        this.c.add(d2);
        final d a = this.g.a(d2, q);
        final int n = (this.n == null) ? 1 : this.n.a(d);
        this.i.a(a, this.o);
        this.j.a(a, 0);
        final d a2 = this.g.a(d2, q2);
        this.i.a(a2, b ? this.o : n);
        this.j.a(a2, b ? 0 : 1);
    }
    
    private void b(final i i) {
        final boolean j = y.f.c.a.i;
        this.l = this.g.t();
        this.p = new f();
        this.q = new f();
        final f f = new f();
        final f f2 = new f();
        final I k = new I(this.g);
        if (this.a != null) {
            k.a(this.a.j());
        }
        if (this.b != null) {
            k.a(this.b.j());
        }
        final A t = this.g.t();
        y.a.h.a(this.g, t);
        final e p = i.p();
        while (true) {
            while (p.f()) {
                final d a = p.a();
                final q q = (q)this.m.b(a.c());
                final q q2 = (q)this.m.b(a.d());
                if (j) {
                    final int a2 = this.d.a(this.g, this.l, f);
                    e e = f.a();
                    while (true) {
                        while (e.f()) {
                            this.g.c(e.a());
                            e.g();
                            if (j) {
                                while (true) {
                                    while (e.f()) {
                                        this.g.a(e.a());
                                        e.g();
                                        if (j) {
                                            if (this.a != null) {
                                                this.l.a(this.a, -1);
                                            }
                                            if (this.b != null) {
                                                this.l.a(this.b, a2 + 1);
                                            }
                                            this.g.a(t);
                                            return;
                                        }
                                        if (j) {
                                            break;
                                        }
                                    }
                                    k.f();
                                    continue;
                                }
                            }
                            if (j) {
                                break;
                            }
                        }
                        e = f2.a();
                        continue;
                    }
                }
                Label_0273: {
                    if (q != q2) {
                        final int a3 = t.a(q);
                        final int a4 = t.a(q2);
                        f2.add(this.g.a(q, q2));
                        if (a3 != a4) {
                            this.p.add(a);
                            if (!j) {
                                break Label_0273;
                            }
                        }
                        this.q.add(a);
                    }
                }
                p.g();
                if (j) {
                    break;
                }
            }
            f2.addAll(y.a.h.b(this.g));
            continue;
        }
    }
    
    private int b(final X x, final A a) {
        final boolean i = a.i;
        final A t = this.g.t();
        final A t2 = x.t();
        final A t3 = this.g.t();
        final int a2 = y.a.h.a(this.g, t3);
        final J j = new J(this.g, t3);
        int k = 0;
    Label_0057:
        while (true) {
        Label_0233_Outer:
            while (k < a2) {
                j.c(new Integer(k));
                u.a(this.g, t, this.i, this.j);
                final X g = this.g;
                if (!i) {
                    final x o = g.o();
                    while (true) {
                        while (o.f()) {
                            final q e = o.e();
                            final int a3 = t.a(e);
                            final y y = (y)this.k.b(e);
                            if (!i) {
                                Label_0225: {
                                    if (y != null) {
                                        final x a4 = y.a();
                                        while (a4.f()) {
                                            t2.a(a4.e(), a3);
                                            a4.g();
                                            if (i) {
                                                break Label_0225;
                                            }
                                            if (i) {
                                                break;
                                            }
                                        }
                                    }
                                    o.g();
                                }
                                if (i) {
                                    break;
                                }
                                continue Label_0233_Outer;
                            }
                            else {
                                if (i) {
                                    break Label_0233_Outer;
                                }
                                continue Label_0057;
                            }
                        }
                        ++k;
                        continue;
                    }
                }
                g.a(t3);
                j.b();
                return k;
            }
            k = new D().a(x, t2, a);
            x.a(t2);
            this.g.a(t);
            final X g2 = this.g;
            continue;
        }
    }
    
    private int c(final X x, final A a, final f f) {
        final boolean i = a.i;
        final A t = x.t();
        final int a2 = y.a.h.a(x, t);
        final J j = new J(x, t);
        int max = 0;
        int k = 0;
        while (k < a2) {
            j.c(new Integer(k));
            max = Math.max(max, this.d.a(x, a, f));
            ++k;
            if (i) {
                return max;
            }
            if (i) {
                break;
            }
        }
        j.b();
        x.a(t);
        return max;
    }
    
    protected void a() {
        if (!y.a.g.a(this.g)) {
            throw new IllegalArgumentException("Circular constraints detected");
        }
    }
    
    private void b(final X x) {
        final boolean i = y.f.c.a.i;
        final h u = this.g.u();
        this.i = this.g.u();
        this.j = this.g.u();
        final c c = x.c(ah.f_);
        final f f = new f();
        final A t = this.g.t();
        final A t2 = this.g.t();
        final A t3 = this.g.t();
        this.a = null;
        this.b = null;
        final x o = x.o();
        while (true) {
            do {
                Label_0095: {
                    o.f();
                }
                boolean b = false;
                Label_0102:
                while (b) {
                    final q e = o.e();
                    final q a = this.a(e);
                    final r r = this;
                    if (!i) {
                        if (this.e != null) {
                            final y.c.D d = (y.c.D)this.e.b((c != null) ? c.b(e) : e);
                            if (d != null) {
                                this.h = false;
                                final C m = d.m();
                                while (m.f()) {
                                    final Object d2 = m.d();
                                    b = (d2 instanceof y.f.c.u);
                                    if (i) {
                                        continue Label_0102;
                                    }
                                    if (b) {
                                        final y.f.c.u u2 = (y.f.c.u)d2;
                                        final q a2 = this.a(this.f.get(u2.c()));
                                        Label_0345: {
                                            Label_0415: {
                                                Label_0489: {
                                                    Label_0559: {
                                                        switch (u2.b()) {
                                                            case 0: {
                                                                if (a == null || a2 == null) {
                                                                    break;
                                                                }
                                                                final d a3 = this.g.a(a, a2);
                                                                f.add(a3);
                                                                u.a(a3, true);
                                                                if (i) {
                                                                    break Label_0345;
                                                                }
                                                                break;
                                                            }
                                                            case -1: {
                                                                if (a == null || a2 == null) {
                                                                    break;
                                                                }
                                                                final int d3 = u2.d();
                                                                final d a4 = this.g.a(a, a2);
                                                                this.j.a(a4, d3);
                                                                this.i.a(a4, 0);
                                                                ++this.o;
                                                                if (i) {
                                                                    break Label_0415;
                                                                }
                                                                break;
                                                            }
                                                            case 1: {
                                                                if (a == null || a2 == null) {
                                                                    break;
                                                                }
                                                                final int d4 = u2.d();
                                                                final d a5 = this.g.a(a2, a);
                                                                this.j.a(a5, d4);
                                                                this.i.a(a5, u2.a());
                                                                ++this.o;
                                                                if (i) {
                                                                    break Label_0489;
                                                                }
                                                                break;
                                                            }
                                                            case 2: {
                                                                if (a == null) {
                                                                    break;
                                                                }
                                                                Label_0544: {
                                                                    if (this.a == null) {
                                                                        this.a = a;
                                                                        if (!i) {
                                                                            break Label_0544;
                                                                        }
                                                                    }
                                                                    final d a6 = this.g.a(a, this.a);
                                                                    f.add(a6);
                                                                    u.a(a6, true);
                                                                }
                                                                t2.a(a, true);
                                                                if (i) {
                                                                    break Label_0559;
                                                                }
                                                                break;
                                                            }
                                                            case -2: {
                                                                if (a != null) {
                                                                    Label_0614: {
                                                                        if (this.b == null) {
                                                                            this.b = a;
                                                                            if (!i) {
                                                                                break Label_0614;
                                                                            }
                                                                        }
                                                                        final d a7 = this.g.a(a, this.b);
                                                                        f.add(a7);
                                                                        u.a(a7, true);
                                                                    }
                                                                    t.a(a, true);
                                                                    break;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    m.g();
                                    if (i) {
                                        break;
                                    }
                                }
                            }
                        }
                        o.g();
                        continue Label_0095;
                    }
                    Label_0873: {
                        while (true) {
                            x x2 = null;
                            boolean d5 = false;
                            Label_0786: {
                                if (r.a != null) {
                                    x2 = this.g.o();
                                    while (x2.f()) {
                                        final q e2 = x2.e();
                                        d5 = t2.d(e2);
                                        if (i) {
                                            break Label_0786;
                                        }
                                        if (!d5 && !t3.d(e2)) {
                                            final d a8 = this.g.a(this.a, e2);
                                            this.j.a(a8, 1);
                                            this.i.a(a8, 0);
                                        }
                                        x2.g();
                                        if (i) {
                                            break;
                                        }
                                    }
                                }
                                if (this.b == null) {
                                    break Label_0873;
                                }
                                x2 = this.g.o();
                                x2.f();
                            }
                            if (d5) {
                                final q e3 = x2.e();
                                if (!t.d(e3) && !t3.d(e3)) {
                                    final d a9 = this.g.a(e3, this.b);
                                    this.j.a(a9, 1);
                                    this.i.a(a9, 0);
                                }
                                x2.g();
                                if (!i) {
                                    continue;
                                }
                            }
                            break;
                        }
                    }
                    final e a10 = f.a();
                    while (a10.f()) {
                        final d a11 = a10.a();
                        final q c2 = a11.c();
                        final q d6 = a11.d();
                        this.g.a(a11);
                        if (i) {
                            return;
                        }
                        Label_1241: {
                            Label_1234: {
                                if (c2 != d6 || !u.d(a11)) {
                                    f f2 = new f(d6.l());
                                    final e a12 = f2.a();
                                    while (true) {
                                        while (a12.f()) {
                                            final d a13 = a12.a();
                                            this.g.a(a13, c2, a13.d());
                                            a12.g();
                                            if (i) {
                                                final e a14 = f2.a();
                                                while (a14.f()) {
                                                    final d a15 = a14.a();
                                                    this.g.a(a15, a15.c(), c2);
                                                    a14.g();
                                                    if (i) {
                                                        break Label_1241;
                                                    }
                                                    if (i) {
                                                        break;
                                                    }
                                                }
                                                final y y = (y)this.k.b(d6);
                                                final y y2 = (y)this.k.b(c2);
                                                Label_1210: {
                                                    if (y != null) {
                                                        final x a16 = y.a();
                                                        while (a16.f()) {
                                                            final q e4 = a16.e();
                                                            y2.add(e4);
                                                            this.m.a(e4, c2);
                                                            a16.g();
                                                            if (i) {
                                                                break Label_1210;
                                                            }
                                                            if (i) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    if (d6 == this.b) {
                                                        this.b = c2;
                                                    }
                                                }
                                                if (d6 == this.a) {
                                                    this.a = c2;
                                                }
                                                this.g.a(d6);
                                                break Label_1234;
                                            }
                                            if (i) {
                                                break;
                                            }
                                        }
                                        f2 = new f(d6.k());
                                        continue;
                                    }
                                }
                            }
                            a10.g();
                        }
                        if (i) {
                            break;
                        }
                    }
                    this.g.a(u);
                    this.g.a(t);
                    this.g.a(t3);
                    this.g.a(t2);
                    return;
                }
                break;
            } while (!i);
            final r r = this;
            continue;
        }
    }
    
    private q a(final q q) {
        if (q == null) {
            return null;
        }
        q d = (q)this.m.b(q);
        if (d == null) {
            d = this.g.d();
            this.m.a(q, d);
            final y y = new y();
            y.add(q);
            this.k.a(d, y);
        }
        return d;
    }
    
    public void a(final X x, final aU au, final aV av) {
        new ba(this).a(x, au, av);
    }
    
    public static s a(final i i) {
        return new t(i);
    }
}
