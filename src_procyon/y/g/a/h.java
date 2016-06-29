package y.g.a;

import y.c.*;

public class h implements g
{
    A a;
    A b;
    i c;
    D d;
    int e;
    
    public h(final i c) {
        this.c = c;
        this.a = c.t();
        this.b = c.t();
        this.d = new D();
        this.e = 0;
    }
    
    public h(final i i, final c c, final int n, final int n2) {
        this(i, c, n, n2, null);
    }
    
    public h(final i i, final c c, final int n, final int n2, final c c2) {
        this(i);
        this.a(c, n, n2, c2);
    }
    
    void a(final c c, final int n, final int n2, final c c2) {
        final boolean a = y.g.a.d.a;
        final y[] array = new y[n2 - n + 1];
        int i = n;
        while (true) {
            while (i <= n2) {
                array[i] = new y.g.a.i(i);
                ++i;
                if (a) {
                Label_0231_Outer:
                    while (i < array.length) {
                        final y y = array[i];
                        final p b = this.d.b(y);
                        final x a2 = y.a();
                        while (true) {
                            while (a2.f()) {
                                this.b.a(a2.e(), b);
                                a2.g();
                                if (!a) {
                                    if (a) {
                                        break;
                                    }
                                    continue Label_0231_Outer;
                                }
                                else {
                                    if (a) {
                                        break Label_0231_Outer;
                                    }
                                    continue Label_0150;
                                }
                            }
                            ++i;
                            continue;
                        }
                    }
                    return;
                }
                if (a) {
                    break;
                }
            }
            final x o = this.c.o();
            while (o.f()) {
                final q e = o.e();
                if (c2 == null || c2.d(e)) {
                    this.a.a(e, array[c.a(e) - n].a(e));
                    ++this.e;
                }
                o.g();
                if (a) {
                    break;
                }
            }
            i = 0;
            continue;
        }
    }
    
    public void b() {
        this.c.a(this.b);
        this.c.a(this.a);
    }
    
    public boolean a() {
        return this.e == 0;
    }
    
    public boolean a(final q q) {
        return this.b.b(q) != null;
    }
    
    public void a(final q q, final int n) {
        final boolean a = y.g.a.d.a;
        ++this.e;
        if (this.d.isEmpty()) {
            final y.g.a.i i = new y.g.a.i(n);
            this.a(this.d.a((Object)i), i.b(q), q);
            return;
        }
        y.g.a.i j = (y.g.a.i)this.d.f();
        if (j.p() > n) {
            while (j.p() > n) {
                j = new y.g.a.i(j.p() - 1);
                this.d.a((Object)j);
                if (a) {
                    return;
                }
                if (a) {
                    break;
                }
            }
            this.a(this.d.k(), j.b(q), q);
            return;
        }
        y.g.a.i k = (y.g.a.i)this.d.i();
        if (k.p() < n) {
            while (k.p() < n) {
                k = new y.g.a.i(k.p() + 1);
                this.d.b(k);
                if (a) {
                    return;
                }
                if (a) {
                    break;
                }
            }
            this.a(this.d.l(), k.b(q), q);
            return;
        }
        p p2 = this.d.k();
        while (p2 != null) {
            k = (y.g.a.i)p2.c();
            if (a) {
                return;
            }
            if (k.p() == n) {
                break;
            }
            p2 = p2.a();
            if (a) {
                break;
            }
        }
        this.a(p2, k.b(q), q);
    }
    
    private void a(final p p3, final p p4, final q q) {
        this.b.a(q, p3);
        this.a.a(q, p4);
    }
    
    public void b(final q q, final int i) {
        final boolean a = y.g.a.d.a;
        final p p2 = (p)this.a.b(q);
        int p3 = ((y.g.a.i)((p)this.b.b(q)).c()).p();
        while (i < p3) {
            this.d(q);
            --p3;
            if (a) {
                break;
            }
        }
    }
    
    public int b(final q q) {
        return ((y.g.a.i)((p)this.b.b(q)).c()).p();
    }
    
    public void d() {
        this.d.clear();
        this.e = 0;
    }
    
    public q c() {
        return this.e();
    }
    
    public q e() {
        final boolean a = y.g.a.d.a;
        while (true) {
            while (((y)this.d.f()).isEmpty()) {
                this.d.g();
                if (a) {
                    final q d = ((y)this.d.f()).d();
                    this.b.a(d, null);
                    this.a.a(d, null);
                    return d;
                }
                if (a) {
                    break;
                }
            }
            --this.e;
            continue;
        }
    }
    
    public q f() {
        final boolean a = y.g.a.d.a;
        while (true) {
            while (((y)this.d.i()).isEmpty()) {
                this.d.j();
                if (a) {
                    final q d = ((y)this.d.i()).d();
                    this.b.a(d, null);
                    this.a.a(d, null);
                    return d;
                }
                if (a) {
                    break;
                }
            }
            --this.e;
            continue;
        }
    }
    
    public void c(final q q) {
        final p p = (p)this.a.b(q);
        final p p2 = (p)this.b.b(q);
        final y.g.a.i i = (y.g.a.i)p2.c();
        final p a = p2.a();
        y y;
        if (a != null) {
            y = (y)a.c();
            this.b.a(q, a);
        }
        else {
            y = new y.g.a.i(i.p() + 1);
            this.b.a(q, this.d.b(y));
        }
        i.h(p);
        this.a.a(q, y.a(q));
    }
    
    public void d(final q q) {
        final boolean a = y.g.a.d.a;
        final p p = (p)this.a.b(q);
        final p p2 = (p)this.b.b(q);
        final y.g.a.i i = (y.g.a.i)p2.c();
        final p b = p2.b();
        y y;
        if (b != null) {
            y = (y)b.c();
            this.b.a(q, b);
        }
        else {
            y = new y.g.a.i(i.p() - 1);
            this.b.a(q, this.d.a((Object)y));
        }
        i.h(p);
        this.a.a(q, y.a(q));
        if (y.c.i.g) {
            y.g.a.d.a = !a;
        }
    }
}
