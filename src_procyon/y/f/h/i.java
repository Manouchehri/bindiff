package y.f.h;

import y.g.*;
import java.util.*;
import y.c.*;

public class i extends N implements Q
{
    private y.c.i e;
    private h f;
    private h g;
    private Map h;
    private A i;
    private boolean j;
    private N k;
    
    public i(final N n) {
        this(n, null);
    }
    
    public i(final N k, final f f) {
        final boolean d = N.d;
        super(new y.c.i());
        this.k = k;
        this.e = this.k.g();
        Label_0119: {
            if (f != null) {
                final e a = f.a();
                while (a.f()) {
                    this.e.e(a.a());
                    a.g();
                    if (d) {
                        break Label_0119;
                    }
                    if (d) {
                        break;
                    }
                }
            }
            this.h = new HashMap();
            this.f = super.g().u();
            this.g = M.b();
            this.i = super.g().t();
        }
        if (f != null) {
            final e a2 = f.a();
            while (a2.f()) {
                this.e.d(a2.a());
                a2.g();
                if (d) {
                    return;
                }
                if (d) {
                    break;
                }
            }
        }
        this.c();
    }
    
    public void a() {
        if (this.k instanceof D) {
            ((D)this.k).a(this);
        }
    }
    
    public void b() {
        if (this.k instanceof D) {
            ((D)this.k).b(this);
        }
    }
    
    public q a(final p p) {
        if (!this.j) {
            throw new RuntimeException("Wrong execution order: call computeDualGraph() first!");
        }
        return this.h.get(p);
    }
    
    public d a(final d d) {
        if (this.j) {
            return (d)this.f.b(d);
        }
        throw new RuntimeException("Wrong execution order: call computeDualGraph() first!");
    }
    
    public d b(final d d) {
        if (!this.j) {
            throw new RuntimeException("Wrong execution order: call computeDualGraph() first!");
        }
        return (d)this.g.b(d);
    }
    
    public void c() {
        final boolean d = N.d;
        final y.c.i g = this.g();
        g.j();
        this.h.clear();
        y.f.h.q q = this.k.h();
        while (true) {
        Label_0340_Outer:
            while (q.f()) {
                this.a(q.a(), g.d());
                q.g();
                if (!d) {
                    if (d) {
                        break;
                    }
                    continue;
                }
                else {
                Label_0340:
                    while (true) {
                        while (true) {
                            while (q.f()) {
                                final p a = q.a();
                                Object value = this.h.get(a);
                            Label_0110:
                                while (true) {
                                    final q q2 = (q)value;
                                    final e a2 = a.a();
                                    if (!d) {
                                        a2.j();
                                        while (a2.f()) {
                                            final d a3 = a2.a();
                                            final d h = this.k.h(a3);
                                            final d d2 = (d)this.g.b(h);
                                            final d a4 = g.a(q2, this.h.get(this.k.i(h)));
                                            final q q3 = (q)(value = d2);
                                            if (d) {
                                                continue Label_0110;
                                            }
                                            if (q3 != null) {
                                                this.b(d2, a4);
                                                if (d2.c() != a4.d() && d2.d() != a4.c()) {
                                                    throw new RuntimeException(" ***** Error setting reverse edge *****");
                                                }
                                            }
                                            this.a(a3, a4);
                                            a2.h();
                                            if (d) {
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    break Label_0340;
                                }
                                q.g();
                                if (d) {
                                    break;
                                }
                                continue Label_0340_Outer;
                                final boolean b = false;
                                if (!b) {
                                    throw new RuntimeException("Error computing dual graph!");
                                }
                                this.j = true;
                                return;
                            }
                            if (g.h() == this.e.h() && this.k.b.size() == this.h.size()) {
                                final boolean b = true;
                                continue;
                            }
                            break;
                        }
                        continue Label_0340;
                    }
                }
            }
            q = this.k.h();
            continue;
        }
    }
    
    public void d() {
        final boolean d = N.d;
        final h b = M.b(new int[this.e.g()]);
        this.l();
        final y.f.h.q h = this.h();
    Label_0126_Outer:
        while (h.f()) {
            final e a = h.a().a();
            int n = 0;
            while (true) {
                while (a.f()) {
                    b.a(this.k.h((d)this.f.b(a.a())), n++);
                    a.g();
                    if (!d) {
                        if (d) {
                            break;
                        }
                        continue Label_0126_Outer;
                    }
                    else {
                        if (d) {
                            break Label_0126_Outer;
                        }
                        continue Label_0126_Outer;
                    }
                }
                h.g();
                continue;
            }
        }
        final x o = this.e.o();
        while (o.f()) {
            o.e().b(new j(this, b));
            o.g();
            if (d) {
                break;
            }
        }
    }
    
    public void a(final d d, final d[] array) {
        final boolean d2 = N.d;
        final d b = this.b(d);
        if (b == null) {
            return;
        }
        final d h = this.k.h(d);
        final q a = this.a(this.k.i(d));
        final q a2 = this.a(this.k.i(h));
        final d b2 = this.b(h);
        d d3 = b;
        final d d4 = b2;
        int i = 0;
        while (i < array.length) {
            final d d5 = array[i];
            final d h2 = this.k.h(d5);
            final d a3 = this.a.a(a, d3, a2, null, 0, 0);
            final d a4 = this.a.a(a2, d4, a, null, 1, 1);
            this.b(a3, a4);
            this.a(d5, a3);
            this.a(h2, a4);
            d3 = a3;
            ++i;
            if (d2) {
                return;
            }
            if (d2) {
                break;
            }
        }
        this.g.a(d, null);
        this.g.a(h, null);
        this.a.a(b);
        this.a.a(b2);
        this.f();
    }
    
    public void a(final d[] array, final d d) {
        final boolean d2 = N.d;
        final d h = this.k.h(d);
        final q a = this.a(this.k.i(d));
        final q a2 = this.a(this.k.i(h));
        final d a3 = this.a.a(a, a2);
        final d a4 = this.a.a(a2, a);
        this.b(a3, a4);
        this.a(d, a3);
        this.a(h, a4);
        int i = 0;
        while (i < array.length) {
            final d d3 = array[i];
            final d h2 = this.k.h(d3);
            final d b = this.b(d3);
            final d b2 = this.b(h2);
            this.g.a(d3, null);
            this.g.a(h2, null);
            this.a.a(b);
            this.a.a(b2);
            ++i;
            if (d2) {
                return;
            }
            if (d2) {
                break;
            }
        }
        this.f();
    }
    
    public void a(final d d, final p[] array, final p[] array2) {
        final boolean d2 = N.d;
        final d h = this.k.h(d);
        final q[] array3 = new q[array.length];
        int i = 0;
        while (true) {
        Label_0354_Outer:
            while (i < array.length) {
                final q[] array4 = array3;
                if (d2) {
                    final q[] array5 = array4;
                    int j = 0;
                    while (j < array2.length) {
                        array5[j] = this.a.d();
                        this.a(array2[j], array5[j]);
                        ++j;
                        if (d2) {
                            break;
                        }
                    }
                    d a = null;
                    d a2 = null;
                    int k = 0;
                Label_0125:
                    while (true) {
                    Label_0326_Outer:
                        while (k < array2.length) {
                            final q q = array5[k];
                            if (!d2) {
                                final e a3 = array2[k].a();
                                while (true) {
                                    while (a3.f()) {
                                        final d a4 = a3.a();
                                        if (!d2) {
                                            Label_0311: {
                                                if (a4 == d) {
                                                    a = this.a.a(q, this.a(this.k.i(h)));
                                                    if (!d2) {
                                                        break Label_0311;
                                                    }
                                                }
                                                if (a4 == h) {
                                                    a2 = this.a.a(q, this.a(this.k.i(d)));
                                                    if (!d2) {
                                                        break Label_0311;
                                                    }
                                                }
                                                final d h2 = this.k.h(a3.a());
                                                final d b = this.b(a4);
                                                final d b2 = this.b(h2);
                                                this.a.a(b, q, b.d());
                                                this.a.a(b2, b2.c(), q);
                                            }
                                            a3.g();
                                            if (d2) {
                                                break;
                                            }
                                            continue Label_0326_Outer;
                                        }
                                        else {
                                            if (d2) {
                                                break Label_0326_Outer;
                                            }
                                            continue Label_0125;
                                        }
                                    }
                                    ++k;
                                    continue Label_0354_Outer;
                                }
                            }
                            int l = 0;
                            while (l < array3.length) {
                                this.a.a(array3[l]);
                                ++l;
                                if (d2) {
                                    return;
                                }
                                if (d2) {
                                    break;
                                }
                            }
                            this.f();
                            return;
                        }
                        this.b(a, a2);
                        this.a(d, a);
                        this.a(h, a2);
                        continue;
                    }
                }
                array4[i] = this.h.get(array[i]);
                ++i;
                if (d2) {
                    break;
                }
            }
            final q[] array6 = new q[array2.length];
            continue;
        }
    }
    
    public void b(final d d, final p[] array, final p[] array2) {
        final boolean d2 = N.d;
        final q[] array3 = new q[array.length];
        int i = 0;
        while (true) {
        Label_0114_Outer:
            while (i < array.length) {
                final q[] array4 = array3;
                if (d2) {
                    final q[] array5 = array4;
                    int j = 0;
                    while (true) {
                    Label_0253_Outer:
                        while (j < array2.length) {
                            array5[j] = this.a.d();
                            this.a(array2[j], array5[j]);
                            ++j;
                            if (d2) {
                                while (true) {
                                Label_0250:
                                    while (j < array2.length) {
                                        final q q = array5[j];
                                        if (!d2) {
                                            final e a = array2[j].a();
                                            while (true) {
                                                while (a.f()) {
                                                    final d a2 = a.a();
                                                    final d h = this.k.h(a.a());
                                                    final d b = this.b(a2);
                                                    final d b2 = this.b(h);
                                                    this.a.a(b, q, b.d());
                                                    this.a.a(b2, b2.c(), q);
                                                    a.g();
                                                    if (!d2) {
                                                        if (d2) {
                                                            break;
                                                        }
                                                        continue Label_0114_Outer;
                                                    }
                                                    else {
                                                        if (d2) {
                                                            break Label_0250;
                                                        }
                                                        continue Label_0114;
                                                    }
                                                }
                                                ++j;
                                                continue Label_0253_Outer;
                                            }
                                        }
                                        while (j < array3.length) {
                                            this.a.a(array3[j]);
                                            ++j;
                                            if (d2) {
                                                return;
                                            }
                                            if (d2) {
                                                break;
                                            }
                                        }
                                        this.f();
                                        return;
                                    }
                                    j = 0;
                                    continue;
                                }
                            }
                            if (d2) {
                                break;
                            }
                        }
                        j = 0;
                        continue;
                    }
                }
                array4[i] = this.h.get(array[i]);
                ++i;
                if (d2) {
                    break;
                }
            }
            final q[] array6 = new q[array2.length];
            continue;
        }
    }
    
    public void e() {
        super.e();
        final y.c.i g = this.g();
        g.a(this.f);
        g.a(this.i);
        this.h.clear();
    }
    
    private void a(final p p2, final q q) {
        this.h.put(p2, q);
        this.i.a(q, p2);
    }
    
    private void a(final d d, final d d2) {
        this.f.a(d2, d);
        this.g.a(d, d2);
    }
    
    protected void f() {
    }
}
