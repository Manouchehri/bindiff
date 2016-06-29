package y.f.c;

import java.util.*;
import y.f.*;
import y.g.*;
import y.c.*;

final class L implements Q, R, Y
{
    aI a;
    aB b;
    HashMap c;
    c d;
    A e;
    c f;
    h g;
    R h;
    Q i;
    c j;
    c k;
    c l;
    D m;
    Object n;
    boolean[] o;
    
    L() {
        this.a = new aI();
        this.b = new aB();
        this.o = new boolean[5];
    }
    
    void a(final c j, final c k, final c l, final R h, final D m, final Q i, final c d, final A e, final c f, final h g) {
        this.l = l;
        this.m = m;
        this.k = k;
        this.j = j;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.i = i;
        this.h = h;
    }
    
    void a(final Object n) {
        this.n = n;
    }
    
    void b(final X x, final A a, final int n) {
        final boolean i = a.i;
        final Object[] array = this.m.toArray();
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            Label_0257: {
                if (this.d.b(e) == null) {
                    final Object b = this.j.b(e);
                    if (b == K.q) {
                        final d d = (d)this.l.b(e);
                        if (d == null) {
                            throw new IllegalStateException("Could not create id for " + e);
                        }
                        final Object b2 = this.f.b(d);
                        if (b2 == null) {
                            throw new IllegalStateException("No ID stored for " + d);
                        }
                        this.e.a(e, am.a("BendNode", b2, array[this.k.a(e)]));
                        if (!i) {
                            break Label_0257;
                        }
                    }
                    throw new IllegalStateException("Could not determine id of node " + e + " [" + b + "]");
                }
            }
            o.g();
            if (i) {
                break;
            }
        }
        final e p3 = x.p();
        while (p3.f()) {
            final d a2 = p3.a();
            if (this.f.b(a2) == null) {
                this.g.a(a2, am.a("DummyEdge", this.d.b(a2.c()), this.d.b(a2.d())));
            }
            p3.g();
            if (i) {
                break;
            }
        }
    }
    
    public Object a() {
        return new HashMap();
    }
    
    public Object b() {
        return this.c;
    }
    
    public boolean a(final byte b) {
        return this.o[b];
    }
    
    public void b(final Object o) {
        if (o == null || o instanceof HashMap) {
            this.c = (HashMap)o;
        }
    }
    
    public void a(final byte b, final boolean b2) {
        this.o[b] = b2;
    }
    
    public int a(final X x, final A a, final f f) {
        final boolean i = a.i;
        this.a.a(this.h, this.d, this.f, this.n);
        int n = 0;
        Label_0125: {
            if (this.a((byte)1)) {
                this.a.a(false);
                this.a.c(this.c);
                n = this.a.a(x, a, f);
                this.a.d(this.c);
                if (!i) {
                    break Label_0125;
                }
            }
            this.a.a(true);
            this.a.c(this.c);
            n = this.a.a(x, a, f);
            this.a.d(this.c);
        }
        final Object[] array = new Object[n];
        final x o = x.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final int a2 = a.a(e);
                if (i) {
                    int j = 0;
                    while (j < n) {
                        this.m.b(array[j]);
                        ++j;
                        if (i) {
                            break;
                        }
                    }
                    return n;
                }
                if (array[a2] == null) {
                    array[a2] = this.a.a(e);
                }
                o.g();
                if (i) {
                    break;
                }
            }
            this.m.clear();
            continue;
        }
    }
    
    public y[] a(final X x, final A a, final int n) {
        this.b(x, a, n);
        this.b.a(this.i, this.d);
        if (this.a((byte)2)) {
            this.b.a(false);
            this.b.a(this.c);
            final y[] array = this.b.a(x, a, n);
            this.b.b(this.c);
            if (!a.i) {
                return array;
            }
        }
        this.b.a(true);
        this.b.a(this.c);
        final y[] array = this.b.a(x, a, n);
        this.b.b(this.c);
        return array;
    }
    
    public void c() {
        this.f = null;
        this.l = null;
        this.j = null;
        this.g = null;
        this.d = null;
        this.e = null;
        this.h = null;
        this.i = null;
        this.a = null;
        this.b = null;
        this.c = null;
    }
}
