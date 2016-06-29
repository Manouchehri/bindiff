package y.c;

import y.g.*;
import java.util.*;

public class i implements n
{
    L c;
    L d;
    boolean e;
    boolean f;
    private K a;
    private K b;
    private HashMap h;
    private C i;
    private static final C j;
    private ArrayList k;
    public static boolean g;
    
    public C a_() {
        if (this.i == null) {
            this.i = this.b();
        }
        return this.i;
    }
    
    protected C b() {
        return y.c.i.j;
    }
    
    protected final boolean c() {
        return this.k != null && !this.k.isEmpty();
    }
    
    public i() {
        this.c = new L();
        this.d = new L();
        this.a = new K(3, 5);
        this.b = new K(3, 5);
        this.e = false;
        this.f = false;
        this.h = new HashMap(11);
    }
    
    public i(final i i, final y.c.C c) {
        final boolean e = D.e;
        this();
        this.a = i.a.c();
        this.b = i.b.c();
        final A t = i.t();
        while (true) {
            while (c.f()) {
                final q q = (q)c.d();
                final q a = q.a(this);
                t.a(q, a);
                final i j = this;
                if (e) {
                    final e p2 = j.p();
                    while (p2.f()) {
                        final d a2 = p2.a();
                        final q q2 = (q)t.b(a2.c());
                        final q q3 = (q)t.b(a2.d());
                        if (e) {
                            return;
                        }
                        if (q2 != null && q3 != null) {
                            this.b.a(a2, a2.a(this, q2, q3));
                        }
                        p2.g();
                        if (e) {
                            break;
                        }
                    }
                    if (i.k != null) {
                        this.k = (ArrayList)i.k.clone();
                    }
                    i.h = (HashMap)i.h.clone();
                    i.a(t);
                    return;
                }
                this.a.a(q, a);
                c.g();
                if (e) {
                    break;
                }
            }
            final i j = i;
            continue;
        }
    }
    
    public q d() {
        final q q = new q(this);
        if (this.k != null) {
            this.a(l.a(this, q));
        }
        return q;
    }
    
    public d a(final q q, final q q2) {
        return this.a(q, null, q2, null, 0, 0);
    }
    
    public d a(final q q, final d d, final q q2, final d d2, final int n, final int n2) {
        final d d3 = new d(this, q, d, q2, d2, n, n2);
        if (this.k != null) {
            this.a(l.a(this, d3));
        }
        return d3;
    }
    
    public void a(final q q) {
        this.h(q);
    }
    
    private void h(final q q) {
        final boolean e = D.e;
        if (q.e() != this) {
            throw new IllegalArgumentException("Node not in this graph.");
        }
        if (this.k != null) {
            this.r();
            this.a(l.b(this, q));
        }
    Label_0104:
        while (true) {
            d c;
            while ((c = q.c) != null) {
                this.a(c);
                if (e) {
                    if (this.k != null) {
                        this.a(l.c(this, q));
                        this.s();
                    }
                    return;
                }
                if (e) {
                    break;
                }
            }
            d b;
            while ((b = q.b) != null) {
                this.a(b);
                if (e) {
                    continue Label_0104;
                }
                if (e) {
                    break;
                }
            }
            this.c.c(q);
            q.a = null;
            this.e = true;
            continue Label_0104;
        }
    }
    
    public void a(final d d) {
        this.g(d);
    }
    
    private void g(final d d) {
        if (d.a() != this) {
            throw new IllegalArgumentException("edge is not in graph");
        }
        if (this.k != null) {
            this.a(l.b(this, d));
        }
        this.b(d, d.c(), d.d());
        this.d.c(d);
        d.a((i)null);
        this.f = true;
        if (this.k != null) {
            this.a(l.c(this, d));
        }
    }
    
    public void b(final q q) {
        if (q.e() != null) {
            throw new IllegalArgumentException("Node " + q + " already in a graph!!!");
        }
        q.h = this.c.a();
        q.b(this);
        q.p();
        if (q.k.length < this.a.a) {
            this.a.a(q, q.k.length, this.a.a);
        }
        this.c.b(q);
        this.e = true;
        if (this.k != null) {
            this.a(l.d(this, q));
        }
    }
    
    public void b(final d d) {
        final boolean e = D.e;
        if (d.a() != null) {
            throw new IllegalArgumentException("Edge " + d + " already in a graph!!!");
        }
        if (d.c().e() != this) {
            throw new IllegalArgumentException("Source of edge " + d + " not in graph");
        }
        if (d.d().e() != this) {
            throw new IllegalArgumentException("Target of edge " + d + " not in graph");
        }
        if (d.k.length < this.b.a) {
            this.b.a(d, d.k.length, this.b.a);
        }
        Label_0227: {
            if (d.q() == null || ((d)d.q()).a() != this) {
                this.d.b(d);
                if (!e) {
                    break Label_0227;
                }
                y.c.i.g = !y.c.i.g;
            }
            this.d.a(d, d.q(), 1);
        }
        d.a(this);
        d.f();
        this.b(d, d.c(), null, d.d(), null, 0, 0);
        this.f = true;
        if (this.k != null) {
            this.a(l.d(this, d));
        }
    }
    
    public void a(final d d, final d d2, final d d3, final int n, final int n2) {
        this.a(d, d.c(), d2, n, d.d(), d3, n2);
    }
    
    public void a(final d d, final q e, d d2, final int n, final q f, d d3, final int n2) {
        final boolean e2 = D.e;
        if (this.k != null) {
            this.a(new l(this, (byte)8, d));
        }
        final q c = d.c();
        final q d4 = d.d();
        if (d == d2) {
            d2 = ((n == 0) ? d2.i() : d2.g());
        }
        if (d == d3) {
            d3 = ((n2 == 0) ? d3.j() : d3.h());
        }
        this.b(d, c, d4);
        Label_0118: {
            if (d2 == null) {
                d.e = e;
                if (!e2) {
                    break Label_0118;
                }
            }
            d.e = d2.c();
        }
        Label_0143: {
            if (d3 == null) {
                d.f = f;
                if (!e2) {
                    break Label_0143;
                }
            }
            d.f = d3.d();
        }
        this.b(d, d.e, d2, d.f, d3, n, n2);
        if (this.k != null) {
            this.a(new l(this, (byte)9, d));
        }
    }
    
    public void a(final d d, final q q, final q q2) {
        if (this.k != null) {
            this.a(new l(this, (byte)8, d));
        }
        final q c = d.c();
        final q d2 = d.d();
        Label_0101: {
            if (d.a() == null) {
                d.e = q;
                d.f = q2;
                if (!D.e) {
                    break Label_0101;
                }
            }
            if (c != q) {
                c.f(d);
                (d.e = q).b(d);
            }
            if (d2 != q2) {
                d2.g(d);
                (d.f = q2).d(d);
            }
        }
        if (this.k != null) {
            this.a(new l(this, (byte)9, d));
        }
    }
    
    public void c(final d d) {
        this.a(d, d.d(), d.c());
    }
    
    public void d(final d d) {
        final ArrayList k = this.k;
        this.k = null;
        this.g(d);
        this.k = k;
    }
    
    public void e(final d d) {
        final ArrayList k = this.k;
        this.k = null;
        this.b(d);
        this.k = k;
    }
    
    public void c(final q q) {
        final ArrayList k = this.k;
        this.k = null;
        this.a(q);
        this.k = k;
    }
    
    public void d(final q q) {
        final ArrayList k = this.k;
        this.k = null;
        this.b(q);
        this.k = k;
    }
    
    public void e(final q q) {
        if (q.e() != this) {
            throw new IllegalArgumentException("Node not in this graph.");
        }
        this.c.c(q);
        this.c.a(q, this.c.d(), 1);
        this.e = true;
    }
    
    public int e() {
        return this.c.a();
    }
    
    public int f() {
        return this.c.a();
    }
    
    public int g() {
        return this.d.a();
    }
    
    public int h() {
        return this.d.a();
    }
    
    public boolean i() {
        return this.c.b();
    }
    
    public void j() {
        final boolean e = D.e;
        this.r();
        while (!this.c.b()) {
            this.a((q)this.c.c());
            if (e) {
                return;
            }
            if (e) {
                break;
            }
        }
        this.s();
    }
    
    public boolean f(final q q) {
        return q.e() == this;
    }
    
    public boolean f(final d d) {
        return d.a() == this;
    }
    
    public boolean b(final q q, final q q2) {
        if (q.e() != this) {
            throw new IllegalArgumentException("source not in this graph.");
        }
        return q.a(q2) != null;
    }
    
    public q k() {
        return (q)this.c.c();
    }
    
    public d l() {
        return (d)this.d.c();
    }
    
    public q[] m() {
        final boolean e = D.e;
        final q[] array = new q[this.f()];
        q q = (q)this.c.c();
        q[] array2 = null;
        while (q != null) {
            array2 = array;
            if (e) {
                return array2;
            }
            array2[q.d()] = q;
            q = (q)q.i;
            if (e) {
                break;
            }
        }
        return array2;
    }
    
    public d[] n() {
        final boolean e = D.e;
        final d[] array = new d[this.h()];
        d d = (d)this.d.c();
        d[] array2 = null;
        while (d != null) {
            array2 = array;
            if (e) {
                return array2;
            }
            array2[d.b()] = d;
            d = (d)d.i;
            if (e) {
                break;
            }
        }
        return array2;
    }
    
    public x o() {
        return this.c.f();
    }
    
    public e p() {
        return this.d.f();
    }
    
    public f a(final y y, final i i) {
        final boolean e = D.e;
        final x a = y.a();
        final f f = new f();
        final byte[] array = new byte[this.e()];
        while (true) {
        Label_0418_Outer:
            while (a.f()) {
                array[a.e().d()] = 1;
                a.g();
                if (!e) {
                    if (e) {
                        break;
                    }
                    continue;
                }
                else {
                    do {
                        a.f();
                        byte b = 0;
                    Label_0081:
                        while (b != 0) {
                            final q e2 = a.e();
                            final e j = e2.j();
                            while (j.f()) {
                                b = array[j.a().a(e2).d()];
                                if (e) {
                                    continue Label_0081;
                                }
                                if (b == 0) {
                                    f.a(j.a());
                                    this.a(j.a());
                                }
                                j.g();
                                if (e) {
                                    break;
                                }
                            }
                            a.g();
                            continue Label_0075;
                        }
                        break;
                    } while (!e);
                    a.i();
                Label_0191:
                    while (true) {
                    Label_0351_Outer:
                        while (a.f()) {
                            final q e3 = a.e();
                            if (!e) {
                                final e l = e3.l();
                                while (true) {
                                    while (l.f()) {
                                        final d a2 = l.a();
                                        this.d.c(a2);
                                        a2.a(i);
                                        final int length = a2.k.length;
                                        final int a3 = i.b.a;
                                        if (!e) {
                                            if (length < a3) {
                                                i.b.a(a2, a2.k.length, i.b.a);
                                            }
                                            i.d.b(l.a());
                                            l.g();
                                            if (e) {
                                                break;
                                            }
                                            continue Label_0351_Outer;
                                        }
                                        else {
                                            if (length < a3) {
                                                i.a.a(e3, e3.k.length, i.a.a);
                                            }
                                            i.c.b(e3);
                                            a.g();
                                            if (e) {
                                                break Label_0351_Outer;
                                            }
                                            continue Label_0191;
                                        }
                                    }
                                    this.c.c(e3);
                                    e3.b(i);
                                    final int length2 = e3.k.length;
                                    final int a4 = i.a.a;
                                    continue Label_0418_Outer;
                                }
                            }
                            if (i.k != null) {
                                i.a(new l(i, (byte)10, y));
                            }
                            this.f = true;
                            this.e = true;
                            i.e = true;
                            i.f = true;
                            return f;
                        }
                        if (this.k != null) {
                            this.a(new l(this, (byte)11, y));
                        }
                        continue;
                    }
                }
            }
            a.i();
            continue;
        }
    }
    
    public void a(final Comparator comparator) {
        final boolean e = D.e;
        if (comparator != null && !this.d.b()) {
            final d[] n = this.n();
            y.g.e.a(n, comparator);
            this.d.e();
            int i = 0;
            while (i < n.length) {
                final d d = n[i];
                this.d.b(d);
                d.g = i;
                ++i;
                if (e) {
                    return;
                }
                if (e) {
                    break;
                }
            }
            this.f = false;
        }
    }
    
    public void b(final Comparator comparator) {
        final boolean e = D.e;
        if (comparator != null && !this.c.b()) {
            final q[] m = this.m();
            y.g.e.a(m, comparator);
            this.c.e();
            int i = 0;
            while (i < m.length) {
                final q q = m[i];
                this.c.b(q);
                q.h = i;
                ++i;
                if (e) {
                    return;
                }
                if (e) {
                    break;
                }
            }
            this.e = false;
        }
    }
    
    public void a(final Comparator comparator, final Comparator comparator2) {
        final boolean e = D.e;
        if (comparator == null && comparator2 == null) {
            return;
        }
        final d[] array = new d[this.g()];
        Label_0076: {
            if (comparator != null && comparator2 != null) {
                q q = (q)this.c.c();
                while (q != null) {
                    q.b(comparator, array);
                    q.a(comparator2, array);
                    q = (q)q.i;
                    if (e) {
                        break Label_0076;
                    }
                }
                return;
            }
        }
        Label_0123: {
            if (comparator2 == null && comparator != null) {
                q q2 = (q)this.c.c();
                while (q2 != null) {
                    q2.b(comparator, array);
                    q2 = (q)q2.i;
                    if (e) {
                        break Label_0123;
                    }
                }
                return;
            }
        }
        if (comparator2 != null && comparator == null) {
            q q3 = (q)this.c.c();
            while (q3 != null) {
                q3.a(comparator2, array);
                q3 = (q)q3.i;
                if (e) {
                    break;
                }
            }
        }
    }
    
    public synchronized void a(final o o) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(o);
    }
    
    public synchronized void b(final o o) {
        if (this.k != null) {
            this.k.remove(o);
            if (this.k.size() == 0) {
                this.k = null;
            }
        }
    }
    
    public Iterator q() {
        if (this.k == null) {
            return new ArrayList(1).iterator();
        }
        return new ArrayList(this.k).iterator();
    }
    
    public void r() {
        if (this.k != null) {
            this.a(l.a(this));
        }
    }
    
    public void s() {
        if (this.k != null) {
            this.a(l.b(this));
        }
    }
    
    protected void a(final l l) {
        final boolean e = D.e;
        if (this.k != null) {
            final o[] array = new o[this.k.size()];
            this.k.toArray(array);
            int i = 0;
            while (i < array.length) {
                array[i].onGraphEvent(l);
                ++i;
                if (e) {
                    break;
                }
            }
        }
    }
    
    public A t() {
        return this.a.a(this.c, "ANONYMOUS");
    }
    
    public h u() {
        return this.b.b(this.d, "ANONYMOUS");
    }
    
    public void a(final A a) {
        this.a.a(a, this.c);
    }
    
    public void a(final h h) {
        this.b.a(h, this.d);
    }
    
    public A[] v() {
        return this.a.a();
    }
    
    public h[] w() {
        return this.b.b();
    }
    
    public Object b_(final Object o) {
        return ((d)o).c();
    }
    
    public Object c_(final Object o) {
        return ((d)o).d();
    }
    
    public Iterator x() {
        return y.g.l.a(this.o());
    }
    
    public Iterator y() {
        return y.g.l.a(this.p());
    }
    
    public c c(final Object o) {
        return this.h.get(o);
    }
    
    public void a(final Object o, final c c) {
        if (c == null) {
            throw new IllegalArgumentException("DataProvider must be non-null!");
        }
        this.h.put(o, c);
    }
    
    public void d_(final Object o) {
        this.h.remove(o);
    }
    
    public Object[] z() {
        return this.h.keySet().toArray();
    }
    
    private void b(final d d, final q q, final d d2, final q q2, final d d3, final int n, final int n2) {
        q.a(d, d2, n);
        q2.b(d, d3, n2);
    }
    
    private void b(final d d, final q q, final q q2) {
        q.f(d);
        q2.g(d);
    }
    
    void A() {
        final boolean e = D.e;
        int n = 0;
        q q = (q)this.c.c();
        while (q != null) {
            q.h = n++;
            q = (q)q.i;
            if (e) {
                return;
            }
            if (e) {
                break;
            }
        }
        this.e = false;
    }
    
    void B() {
        final boolean e = D.e;
        int n = 0;
        d d = (d)this.d.c();
        while (d != null) {
            d.g = n++;
            d = (d)d.i;
            if (e) {
                return;
            }
            if (e) {
                break;
            }
        }
        this.f = false;
    }
    
    void g(final q q) {
        q.a(this, this.a.a);
        q.h = this.c.a();
        this.c.b(q);
    }
    
    void a(final d d, final q q, final d d2, final q q2, final d d3, final int n, final int n2) {
        if (q.e() != this || q2.e() != this) {
            throw new IllegalArgumentException("Both endpoints must reside in this graph.");
        }
        if (d2 != null && d2.c() != q) {
            throw new IllegalArgumentException("v must be source of e1.");
        }
        if (d3 != null && d3.d() != q2) {
            throw new IllegalArgumentException("w must be target of e2.");
        }
        d.a(this, q, q2, this.b.a);
        d.g = this.d.a();
        this.d.b(d);
        this.b(d, d.c(), d2, d.d(), d3, n, n2);
    }
    
    public String toString() {
        final boolean e = D.e;
        final StringBuffer sb = new StringBuffer(128 + 4 * this.e() + 4 * this.g());
        sb.append("nodes #").append(this.f()).append(" [");
        final x o = this.o();
        while (true) {
        Label_0208_Outer:
            while (o.f()) {
                sb.append(o.e().toString());
                o.g();
                if (o.f()) {
                    sb.append(',');
                    sb.append(' ');
                    if (e) {
                        final e p = this.p();
                        while (true) {
                            while (p.f()) {
                                sb.append(p.a().toString());
                                p.g();
                                if (p.f()) {
                                    sb.append(',');
                                    sb.append(' ');
                                    if (e) {
                                        final String string = sb.toString();
                                        if (y.c.i.g) {
                                            D.e = !e;
                                        }
                                        return string;
                                    }
                                    if (e) {
                                        break;
                                    }
                                    continue Label_0208_Outer;
                                }
                            }
                            sb.append(']');
                            continue;
                        }
                    }
                    if (e) {
                        break;
                    }
                    continue;
                }
            }
            sb.append("]\nedges #").append(this.h()).append(" [");
            continue;
        }
    }
    
    static {
        j = new j();
        new y.g.o();
    }
}
