package y.f.f.a.b;

import y.a.*;
import java.util.*;
import y.c.*;
import y.f.f.a.a.*;
import y.f.h.*;

public class A extends D
{
    private q e;
    private q f;
    private f g;
    private h h;
    
    public A(final a a) {
        super(a);
        this.h = this.c.u();
        this.b();
        this.e = this.c.d();
        this.f = this.c.d();
        this.g = new f();
    }
    
    public void a() {
        this.c();
        this.c.a(this.e);
        this.c.a(this.f);
        this.c.a(this.h);
        super.a();
    }
    
    public f a(final q q, final q q2) {
        this.c();
        this.b(q, q2);
        return v.a(this.c, this.e, this.f, true, v.a(this.c));
    }
    
    public double a(final d d, final f f) {
        final boolean c = y.f.f.a.b.a.c;
        final f d2 = this.a.d(d);
        this.c();
        this.b(d.c(), d.d());
        final double[] a = v.a(this.c);
        final e a2 = d2.a();
        while (true) {
            while (a2.f()) {
                final d a3 = a2.a();
                final A a4 = this;
                if (c) {
                    final d[] array = new d[a4.c.e()];
                    final double a5 = v.a(this.c, this.e, this.f, true, a, array);
                    f.addAll(v.a(this.e, this.f, array));
                    return a5;
                }
                a[this.e(a3).b()] = 0.0;
                a2.g();
                if (c) {
                    break;
                }
            }
            final A a4 = this;
            continue;
        }
    }
    
    private void b(final q q, final q q2) {
        final boolean c = y.f.f.a.b.a.c;
        e e = this.a.a(q).a();
        while (true) {
            while (e.f()) {
                final d a = this.c.a(this.e, this.a(this.a.b(e.a())));
                this.a(a, 0);
                this.f(a);
                e.g();
                if (c) {
                    while (true) {
                        while (e.f()) {
                            final d a2 = this.c.a(this.a(this.a.b(e.a())), this.f);
                            this.a(a2, 1);
                            final A a3 = this;
                            if (c) {
                                final b a4 = a3.d.a(q);
                                y.f.f.a.a.e e2 = this.d.a(q2);
                                final y.f.f.a.a.e c2 = n.c(a4, e2);
                                y.f.f.a.a.e e3 = a4.c();
                                while (true) {
                                    while (e3 != c2) {
                                        this.a(((b)e3).b_(), 3);
                                        e3 = e3.c();
                                        if (c) {
                                            while (e2 != c2) {
                                                this.a(((b)e2).b_(), 4);
                                                e2 = e2.c();
                                                if (c) {
                                                    break;
                                                }
                                            }
                                            return;
                                        }
                                        if (c) {
                                            break;
                                        }
                                    }
                                    e2 = e2.c();
                                    continue;
                                }
                            }
                            this.f(a2);
                            e.g();
                            if (c) {
                                break;
                            }
                        }
                        final A a3 = this;
                        continue;
                    }
                }
                if (c) {
                    break;
                }
            }
            e = this.a.a(q2).a();
            continue;
        }
    }
    
    public void a(final q q, final int n) {
        final boolean c = y.f.f.a.b.a.c;
        final e a = this.a.b(q).a();
        while (a.f()) {
            final d a2 = a.a();
            final q a3 = this.a(this.a.b(a2));
            d d = this.a.i(a2);
            if (d.c() == q) {
                d = this.a.c(d);
            }
            final q a4 = this.a(this.a.b(d));
            Label_0184: {
                if (n == 3) {
                    final d a5 = this.c.a(a3, a4);
                    this.a(a5, q);
                    this.a(a5, 3);
                    this.f(a5);
                    if (!c) {
                        break Label_0184;
                    }
                }
                final d a6 = this.c.a(a4, a3);
                this.a(a6, q);
                this.a(a6, 4);
                this.f(a6);
            }
            a.g();
            if (c) {
                break;
            }
        }
    }
    
    private void c() {
        final boolean c = y.f.f.a.b.a.c;
        final e a = this.g.a();
        while (true) {
            while (a.f()) {
                final A a2 = this;
                if (c) {
                    a2.g.clear();
                    return;
                }
                if (this.c.f(a.a())) {
                    this.c.a(a.a());
                }
                a.g();
                if (c) {
                    break;
                }
            }
            final A a2 = this;
            continue;
        }
    }
    
    private void f(final d d) {
        this.g.add(d);
    }
    
    public void a(final p p2, final p[] array) {
        final boolean c = y.f.f.a.b.a.c;
        final q a = this.a(p2);
        final e a2 = p2.a();
        while (true) {
            while (a2.f()) {
                final d a3 = a2.a();
                final d c2 = this.a.c(a3);
                final d e = this.e(a3);
                final d e2 = this.e(c2);
                final int f;
                final int n = f = (this.c.f(e) ? 1 : 0);
                if (c) {
                    int i = f;
                    while (true) {
                        while (i < array.length) {
                            final p p3 = array[i];
                            final q d = this.c.d();
                            final A a4 = this;
                            if (c) {
                                final boolean[] array2 = new boolean[a4.b.g()];
                                int n2 = 0;
                                do {
                                    int j = 0;
                                Label_0192:
                                    while (j < array.length) {
                                        final p p4 = array[n2];
                                        final q a5 = this.a(p4);
                                        final e a6 = p4.a();
                                        while (a6.f()) {
                                            final d a7 = a6.a();
                                            final d c3 = this.a.c(a7);
                                            final q a8 = this.a(this.a.b(c3));
                                            j = (array2[a7.b()] ? 1 : 0);
                                            if (c) {
                                                continue Label_0192;
                                            }
                                            if (j == 0) {
                                                this.a(a7, this.c.a(a5, a8));
                                                array2[a7.b()] = true;
                                                this.a(c3, this.c.a(a8, a5));
                                                array2[c3.b()] = true;
                                            }
                                            a6.g();
                                            if (c) {
                                                break;
                                            }
                                        }
                                        ++n2;
                                    }
                                    break;
                                } while (!c);
                                return;
                            }
                            this.a(p3, d);
                            ++i;
                            if (c) {
                                break;
                            }
                        }
                        final A a4 = this;
                        continue;
                    }
                }
                if (n != 0) {
                    this.c.a(e);
                }
                if (this.c.f(e2)) {
                    this.c.a(e2);
                }
                a2.g();
                if (c) {
                    break;
                }
            }
            this.c.a(a);
            int f = 0;
            continue;
        }
    }
    
    public void a(final d d, final int a) {
        this.g(d).a = a;
    }
    
    public int a(final d d) {
        if (this.d(d) != null) {
            return 2;
        }
        return this.g(d).a;
    }
    
    public void a(final d d, final q b) {
        this.g(d).b = b;
    }
    
    public q b(final d d) {
        return this.g(d).b;
    }
    
    public d c(final d d) {
        return this.d(d);
    }
    
    private C g(final d d) {
        C d2 = (C)this.h.b(d);
        if (d2 == null) {
            d2 = this.d();
            this.h.a(d, d2);
        }
        return d2;
    }
    
    private C d() {
        return new C(null);
    }
}
