package y.f.h;

import y.c.*;

public class k
{
    private D a;
    private i b;
    
    public k(final D a) {
        this.a = a;
        this.b = a.g();
    }
    
    public f a(final f f, final d d) {
        return this.a(f, null, null, d);
    }
    
    public f a(final f f, final d d, final d d2, final d d3) {
        final boolean d4 = N.d;
        if (d3.c() == d3.d()) {
            this.b.e(d3);
            this.a.a((d)null, d3);
            this.a.k();
            final f f2 = new f();
            f2.add(d3);
            return f2;
        }
        if (f == null) {
            return this.a(d, d2, d3);
        }
        if (f.size() == 0) {
            return this.b(d, d2, d3);
        }
        final q c = d3.c();
        final q d5 = d3.d();
        d d6 = d;
        d d7 = d2;
        final f f3 = new f();
        q q = c;
        p p4;
        if (d != null) {
            p4 = this.a.i(d);
        }
        else {
            final d b = f.b();
            if (this.a.i(b).a(q)) {
                p4 = this.a.i(b);
            }
            else {
                p4 = this.a.i(this.a.h(b));
            }
        }
        final e a = f.a();
        while (true) {
            while (a.f()) {
                d d8 = a.a();
                final int n = this.a.n(d8) ? 1 : 0;
                if (d4) {
                    this.a.a(d3, (d[])f3.toArray(new d[n]));
                    this.a.a(d3, f3, 0);
                    return f3;
                }
                if (n != 0) {
                    d8 = this.a.h(d8);
                }
                final q b2 = this.a.b(d8);
                final f f4 = new f(b2.k());
                final f f5 = new f(b2.l());
            Label_0300:
                while (true) {
                    Label_0336: {
                        final d a2;
                        final d a3;
                        if (a2 == a3) {
                            d6 = f5.b();
                            if (!d4) {
                                break Label_0336;
                            }
                        }
                        if (this.a.h(d8) == d6) {
                            d6 = f5.c();
                        }
                    }
                    Label_0376: {
                        if (d8 == d7) {
                            d7 = f5.b();
                            if (!d4) {
                                break Label_0376;
                            }
                        }
                        if (this.a.h(d8) == d7) {
                            d7 = f5.c();
                        }
                    }
                    final d a4 = this.b.a(q, b2);
                    f3.add(a4);
                    this.a.a(p4, a4, d6, null);
                    d6 = null;
                    p4 = null;
                    final e a5 = f4.a();
                    while (a5.f() && p4 == null) {
                        final p i = this.a.i(a5.a());
                        final e a6 = i.a();
                        while (a6.f()) {
                            final d a2 = a6.a();
                            final d a3 = a5.a();
                            if (d4) {
                                continue Label_0300;
                            }
                            if (a2 == a3) {
                                break;
                            }
                            a6.g();
                            if (d4) {
                                break;
                            }
                        }
                        a6.b();
                        if (f5.contains(a6.a())) {
                            d6 = a5.a();
                            p4 = i;
                        }
                        a5.g();
                        if (d4) {
                            break;
                        }
                    }
                    break;
                }
                q = b2;
                a.g();
                if (d4) {
                    break;
                }
            }
            final d a7 = this.b.a(q, d5);
            f3.add(a7);
            this.a.a(p4, a7, d6, d7);
            f3.size();
            continue;
        }
    }
    
    protected f a(final d d, final d d2, final d d3) {
        final f f = new f();
        this.b.e(d3);
        this.a.a(d3, d, d2);
        f.add(d3);
        return f;
    }
    
    protected f b(final d d, final d d2, final d d3) {
        final boolean d4 = N.d;
        final f f = new f();
        final q c = d3.c();
        final q d5 = d3.d();
        this.b.e(d3);
        final y.c.D d6 = new y.c.D();
        p p3 = null;
        p p4 = null;
        Label_0292: {
            if (d == null && d2 == null) {
                q q = d5;
                q q2 = c;
                if (c.c() < d5.c()) {
                    q = c;
                    q2 = d5;
                }
                final e l = q.l();
                while (true) {
                    while (l.f()) {
                        final C m;
                        final e e = (e)(m = l);
                        if (d4) {
                            final C c2 = m;
                            while (c2.f()) {
                                Object o = c2.d();
                            Label_0205:
                                while (true) {
                                    p4 = (p)o;
                                    if (!d4) {
                                        final e a = p4.a();
                                        while (a.f()) {
                                            final q q3 = (q)(o = a.a().d());
                                            if (d4) {
                                                continue Label_0205;
                                            }
                                            if (q3 == q2) {
                                                p3 = this.a.i(a.a());
                                            }
                                            a.g();
                                            if (d4) {
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    break Label_0292;
                                }
                                c2.g();
                                if (d4) {
                                    break;
                                }
                            }
                            break Label_0292;
                        }
                        if (e.a() != d3) {
                            d6.add(this.a.i(l.a()));
                        }
                        l.g();
                        if (d4) {
                            break;
                        }
                    }
                    C m = d6.m();
                    continue;
                }
            }
            if (d != null) {
                p3 = this.a.i(d);
            }
            else {
                p3 = this.a.i(d2);
            }
        }
        if (p4 == null) {
            this.b.d(d3);
            throw new RuntimeException("No common face found !");
        }
        this.a.a(p3, d3, d, d2);
        f.add(d3);
        return f;
    }
}
