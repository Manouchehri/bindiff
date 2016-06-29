package y.f.a;

import y.f.*;
import y.a.*;
import y.c.*;
import java.util.*;
import y.g.*;

class s extends w
{
    static final Object k;
    private A m;
    private A n;
    private A o;
    private A p;
    private A q;
    private h r;
    private i s;
    private Map t;
    byte l;
    private q u;
    private I v;
    private J w;
    private f x;
    
    public s(final i s) {
        this.s = s;
        this.m = this.t();
        this.r = this.u();
    }
    
    y t(final q q) {
        return (y)this.m.b(q);
    }
    
    y u(final q q) {
        return (y)this.p.b(q);
    }
    
    public void F() {
        final int i = y.f.a.f.u;
        if (this.n == null) {
            this.n = this.t();
        }
        final int[] array = new int[this.s.f() + 1];
        int n = 1;
        final x o = this.o();
    Label_0277:
        while (o.f()) {
            final y t = this.t(o.e());
            final x a = t.a();
            while (a.f()) {
                array[a.e().d()] = n;
                a.g();
                if (i != 0) {
                    continue Label_0277;
                }
                if (i != 0) {
                    break;
                }
            }
            final f f = new f();
            final x a2 = t.a();
            while (true) {
                do {
                    Label_0127: {
                        a2.f();
                    }
                    int j = 0;
                    Label_0134:
                    while (j != 0) {
                        final q e = a2.e();
                        final int n2 = array[e.d()];
                        if (i == 0) {
                            final e l = e.l();
                            while (l.f()) {
                                final d a3 = l.a();
                                j = array[a3.d().d()];
                                if (i != 0) {
                                    continue Label_0134;
                                }
                                if (j == n2) {
                                    f.c(a3);
                                }
                                l.g();
                                if (i != 0) {
                                    break;
                                }
                            }
                            a2.g();
                            continue Label_0127;
                        }
                        if (i != 0) {
                            break Label_0277;
                        }
                        continue Label_0277;
                    }
                    break;
                } while (i == 0);
                this.n.a(o.e(), f);
                o.g();
                ++n;
                continue;
            }
        }
    }
    
    void G() {
        final int i = y.f.a.f.u;
        this.p = this.t();
        this.q = this.s.t();
        final x o = this.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final s s = this;
                if (i != 0) {
                    final e p = s.p();
                    do {
                        Label_0083: {
                            p.f();
                        }
                        boolean d = false;
                        Label_0089:
                        while (d) {
                            final e a = this.i(p.a()).a();
                            while (a.f()) {
                                final d a2 = a.a();
                                final q c = a2.c();
                                final q d2 = a2.d();
                                d = this.q.d(c);
                                if (i != 0) {
                                    continue Label_0089;
                                }
                                if (!d) {
                                    this.u((q)this.o.b(c)).add(c);
                                    this.q.a(c, true);
                                }
                                if (!this.q.d(d2)) {
                                    this.u((q)this.o.b(d2)).add(d2);
                                    this.q.a(d2, true);
                                }
                                a.g();
                                if (i != 0) {
                                    break;
                                }
                            }
                            p.g();
                            continue Label_0083;
                        }
                        break;
                    } while (i == 0);
                    return;
                }
                this.p.a(e, new y());
                o.g();
                if (i != 0) {
                    break;
                }
            }
            final s s = this;
            continue;
        }
    }
    
    f i(final d d) {
        return (f)this.r.b(d);
    }
    
    void a(final d d, final f f) {
        this.r.a(d, f);
    }
    
    public void a(final byte l) {
        final int u = y.f.a.f.u;
        this.l = l;
        this.o = this.s.t();
        Label_0100: {
            switch (l) {
                case 2: {
                    this.a(this.s.c(y.f.a.s.k));
                    if (u != 0) {
                        break Label_0100;
                    }
                    break;
                }
                case 0: {
                    final A t = this.s.t();
                    y.a.j.a(this.s, t);
                    this.a((c)t);
                    this.s.a(t);
                    if (u != 0) {
                        break Label_0100;
                    }
                    break;
                }
                case 1: {
                    this.I();
                    break;
                }
            }
        }
        this.w = new J(this.s, this.o);
        this.G();
        this.J();
        this.F();
        this.O();
    }
    
    protected void a(final c c) {
        this.b(c);
        this.H();
    }
    
    void b(final c c) {
        final int u = y.f.a.f.u;
        final HashMap hashMap = new HashMap<Object, q>();
        final x o = this.s.o();
        while (o.f()) {
            final q e = o.e();
            final Object b = c.b(e);
            Label_0219: {
                if (b != null) {
                    if (!hashMap.containsKey(b)) {
                        final q d = this.d();
                        hashMap.put(b, d);
                        final y y = new y();
                        this.m.a(d, y);
                        y.add(e);
                        this.o.a(e, d);
                        if (u == 0) {
                            break Label_0219;
                        }
                    }
                    final q value = hashMap.get(b);
                    ((y)this.m.b(value)).add(e);
                    this.o.a(e, value);
                    if (u == 0) {
                        break Label_0219;
                    }
                }
                final q d2 = this.d();
                final y y2 = new y();
                this.m.a(d2, y2);
                y2.add(e);
                this.o.a(e, d2);
            }
            o.g();
            if (u != 0) {
                break;
            }
        }
        final e p = this.s.p();
        while (p.f()) {
            final d a = p.a();
            final q q = (q)this.o.b(a.c());
            final q q2 = (q)this.o.b(a.d());
            Label_0370: {
                if (q != q2) {
                    d d3 = q.c(q2);
                    if (d3 == null) {
                        d3 = this.a(q, q2);
                        final f f = new f();
                        f.add(a);
                        this.a(d3, f);
                        if (u == 0) {
                            break Label_0370;
                        }
                    }
                    this.i(d3).add(a);
                }
            }
            p.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    protected void H() {
        final int u = y.f.a.f.u;
        final h u2 = this.u();
        final e p = this.p();
        while (true) {
            while (p.f()) {
                final d a = p.a();
                final f i = this.i(a);
                if (u != 0) {
                    final f f = i;
                    final boolean[] array = new boolean[this.g()];
                    this.x = new f();
                    e e = f.a();
                    while (true) {
                        while (e.f()) {
                            array[e.a().b()] = true;
                            e.g();
                            if (u != 0) {
                                while (e.f()) {
                                    final d a2 = e.a();
                                    if (u != 0) {
                                        return;
                                    }
                                    if (!array[a2.b()]) {
                                        this.x.add(a2);
                                    }
                                    e.g();
                                    if (u != 0) {
                                        break;
                                    }
                                }
                                (this.v = new I(this)).a(this.x);
                                this.a(u2);
                                return;
                            }
                            if (u != 0) {
                                break;
                            }
                        }
                        e = this.p();
                        continue;
                    }
                }
                final int size = i.size();
                u2.a(a, 1.0 / (size * size));
                p.g();
                if (u != 0) {
                    break;
                }
            }
            y.a.y.a(this, u2);
            continue;
        }
    }
    
    void I() {
        final int i = y.f.a.f.u;
        final A t = this.s.t();
        final h b = M.b(new int[this.s.g()]);
        final f[] a = y.a.h.a(this.s, b, y.a.h.a(this.s, b, t));
        final HashMap<q, q> hashMap = new HashMap<q, q>();
        final boolean[] array = new boolean[this.s.f()];
        final x o = this.s.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final int d;
                final int n = d = (t.d(e) ? 1 : 0);
                if (i != 0) {
                    int n2 = d;
                    while (true) {
                        do {
                            int j = 0;
                        Label_0187:
                            while (j < a.length) {
                                final f f = a[n2];
                                final int size = f.size();
                                if (i != 0) {
                                    final f[] array2 = new f[size];
                                    final q[] array3 = new q[2];
                                    int n3 = 0;
                                    do {
                                        int k = 0;
                                    Label_0541:
                                        while (k < a.length) {
                                            final f f2 = a[n3];
                                            final q q = hashMap.get(f2);
                                            if (i != 0) {
                                                return;
                                            }
                                            Label_0863: {
                                                if (q != null) {
                                                    e e2 = f2.a();
                                                    while (true) {
                                                        while (e2.f()) {
                                                            array2[e2.a().b()] = f2;
                                                            e2.g();
                                                            if (i != 0) {
                                                                do {
                                                                    e2.f();
                                                                    boolean d2 = false;
                                                                Label_0642:
                                                                    while (d2) {
                                                                        array3[0] = e2.a().c();
                                                                        array3[1] = e2.a().d();
                                                                        k = 0;
                                                                        if (i == 0) {
                                                                            int n4 = k;
                                                                            do {
                                                                                int l = 0;
                                                                            Label_0683:
                                                                                while (l < 2) {
                                                                                    final q q2 = array3[n4];
                                                                                    final q q3 = hashMap.get(q2);
                                                                                    d2 = t.d(q2);
                                                                                    if (i != 0) {
                                                                                        continue Label_0642;
                                                                                    }
                                                                                    if (d2 && q3.c(q) == null) {
                                                                                        final f f3 = new f();
                                                                                        final e m = q2.j();
                                                                                        while (m.f()) {
                                                                                            final d a2 = m.a();
                                                                                            l = (t.d(a2.a(q2)) ? 1 : 0);
                                                                                            if (i != 0) {
                                                                                                continue Label_0683;
                                                                                            }
                                                                                            if (l == 0 && array2[a2.b()] == f2) {
                                                                                                f3.add(a2);
                                                                                            }
                                                                                            m.g();
                                                                                            if (i != 0) {
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        this.a(this.a(q, q3), f3);
                                                                                    }
                                                                                    ++n4;
                                                                                }
                                                                                break;
                                                                            } while (i == 0);
                                                                            e2.g();
                                                                            continue Label_0635;
                                                                        }
                                                                        continue Label_0541;
                                                                    }
                                                                    break;
                                                                } while (i == 0);
                                                                break Label_0863;
                                                            }
                                                            if (i != 0) {
                                                                break;
                                                            }
                                                        }
                                                        e2 = f2.a();
                                                        continue;
                                                    }
                                                }
                                            }
                                            ++n3;
                                        }
                                        break;
                                    } while (i == 0);
                                    this.s.a(t);
                                    return;
                                }
                                Label_0510: {
                                    if (size == 1) {
                                        final d b2 = f.b();
                                        if (t.d(b2.c()) && t.d(b2.d())) {
                                            final d a3 = this.a(hashMap.get(b2.c()), hashMap.get(b2.d()));
                                            final f f4 = new f();
                                            f4.add(b2);
                                            this.a(a3, f4);
                                            if (i == 0) {
                                                break Label_0510;
                                            }
                                        }
                                    }
                                    final q d3 = this.d();
                                    final y y = new y();
                                    final e a4 = f.a();
                                    while (a4.f()) {
                                        final d a5 = a4.a();
                                        final q c = a5.c();
                                        j = (array[c.d()] ? 1 : 0);
                                        if (i != 0) {
                                            continue Label_0187;
                                        }
                                        if (j == 0 && !t.d(c)) {
                                            y.add(c);
                                            array[c.d()] = true;
                                            this.o.a(c, d3);
                                        }
                                        final q d4 = a5.d();
                                        if (!array[d4.d()] && !t.d(d4)) {
                                            y.add(d4);
                                            array[d4.d()] = true;
                                            this.o.a(d4, d3);
                                        }
                                        a4.g();
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                    this.m.a(d3, y);
                                    hashMap.put((q)f, d3);
                                }
                                ++n2;
                            }
                            break;
                        } while (i == 0);
                        this.s.h();
                        continue;
                    }
                }
                if (n != 0) {
                    final q d5 = this.d();
                    final y y2 = new y();
                    y2.add(e);
                    this.m.a(d5, y2);
                    hashMap.put(e, d5);
                    this.o.a(e, d5);
                }
                o.g();
                if (i != 0) {
                    break;
                }
            }
            int d = 0;
            continue;
        }
    }
    
    void J() {
        final int u = y.f.a.f.u;
        this.t = new HashMap();
        if (this.l == 1) {
            final e p = this.p();
            while (p.f()) {
                p.a();
            Label_0044:
                while (true) {
                    d c = null;
                    final d d = c;
                    final f i = this.i(d);
                    if (u != 0) {
                        return;
                    }
                    if (i.size() > 1) {
                        final e a = i.a();
                        final q b = this.t(d.d()).b();
                        q a2 = a.a().a(b);
                        a.g();
                        while (a.f()) {
                            final q a3 = a.a().a(b);
                            c = a2.c(a3);
                            if (u != 0) {
                                continue Label_0044;
                            }
                            if (c == null) {
                                this.t.put(this.s.a(a2, a3), Boolean.TRUE);
                            }
                            a2 = a3;
                            a.g();
                            if (u != 0) {
                                break;
                            }
                        }
                        break;
                    }
                    break;
                }
                p.g();
                if (u != 0) {
                    break;
                }
            }
        }
        this.w.a(this.o);
    }
    
    void K() {
        final int u = y.f.a.f.u;
        final e p = this.s.p();
        while (p.f()) {
            if (this.t.containsKey(p.a())) {
                this.s.a(p.a());
            }
            p.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    void L() {
        this.K();
        this.s.a(this.o);
        this.s.a(this.q);
    }
    
    protected void M() {
        final int u = y.f.a.f.u;
        int size = -1;
        final x o = this.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final s s = this;
                final q u2 = e;
                if (u != 0) {
                    s.u = u2;
                    return;
                }
                if (this.t(u2).size() > size) {
                    size = this.t(e).size();
                }
                o.g();
                if (u != 0) {
                    break;
                }
            }
            final s s = this;
            continue;
        }
    }
    
    public q N() {
        return this.u;
    }
    
    void O() {
        this.M();
        y.a.A.a(this, this.u);
    }
    
    public void P() {
        this.w.a();
    }
    
    public void Q() {
        this.w.b();
    }
    
    public void v(final q q) {
        this.w.b((Object)q);
    }
    
    public void w(final q q) {
        this.w.a((Object)q);
    }
    
    public q x(final q q) {
        return (q)this.o.b(q);
    }
    
    static {
        k = "y.layout.circular.CircularLayouter.CIRCULAR_CUSTOM_GROUPS_DPKEY";
    }
}
