package y.a;

import java.util.*;
import y.g.a.*;
import y.g.*;
import y.c.*;

class ai
{
    i e;
    h f;
    A g;
    int h;
    ArrayList i;
    private final f a;
    private final h b;
    private final ag c;
    
    ai(final ag c, final i e) {
        this.c = c;
        this.e = e;
        this.f = e.u();
        this.b = e.u();
        this.a = new f(e.g(), this.b, this.b);
        this.g = M.a(new int[e.e()]);
        this.h = 0;
        this.i = new ArrayList();
    }
    
    void a() {
        this.a.d();
        this.e.a(this.f);
        this.e.a(this.b);
        this.e = null;
    }
    
    void b(final y y) {
        final boolean a = y.a.h.a;
        final x a2 = y.a();
        while (true) {
            while (a2.f()) {
                this.g.a(a2.e(), this.h);
                a2.g();
                if (a) {
                    Label_0173: {
                        if (y.size() > Math.max(ag.c(this.c), 1)) {
                            ag.a(this.c).a(this.e, y, this.f);
                            final x a3 = y.a();
                        Label_0168_Outer:
                            while (a3.f()) {
                                d d = a3.e().f();
                                while (true) {
                                    while (d != null) {
                                        this.a.a(d, -this.f.c(d));
                                        d = d.g();
                                        if (!a) {
                                            if (a) {
                                                break;
                                            }
                                            continue Label_0168_Outer;
                                        }
                                        else {
                                            if (a) {
                                                break Label_0173;
                                            }
                                            continue Label_0168_Outer;
                                        }
                                    }
                                    a3.g();
                                    continue;
                                }
                            }
                        }
                    }
                    ++this.h;
                    return;
                }
                if (a) {
                    break;
                }
            }
            this.i.add(y);
            continue;
        }
    }
    
    y[] a(final y y, final A a) {
        final boolean a2 = y.a.h.a;
        final int n = 2;
        final y[] array = new y[n];
        int i = 0;
        while (true) {
            while (i < n) {
                array[i] = new y();
                ++i;
                if (a2) {
                    final int h = this.h;
                    final x a3 = y.a();
                    while (true) {
                        while (a3.f()) {
                            final int a4 = a.a(a3.e());
                            if (a2) {
                                int j = a4;
                                while (j < n) {
                                    this.c(array[j]);
                                    ++j;
                                    if (a2) {
                                        break;
                                    }
                                }
                                return array;
                            }
                            Label_0180: {
                                if (a4 > 0) {
                                    array[1].b(a3.e());
                                    this.g.a(a3.e(), h);
                                    if (!a2) {
                                        break Label_0180;
                                    }
                                }
                                array[0].b(a3.e());
                                this.g.a(a3.e(), i);
                            }
                            a3.g();
                            if (a2) {
                                break;
                            }
                        }
                        this.i.add(new y());
                        ++this.h;
                        continue;
                    }
                }
                if (a2) {
                    break;
                }
            }
            i = this.g.a(y.b());
            continue;
        }
    }
    
    void c(final y y) {
        this.i.set(this.g.a(y.b()), y);
        if (y.size() > Math.max(ag.c(this.c), 1)) {
            this.a(y);
            if (!y.a.h.a) {
                return;
            }
        }
        this.d(y);
    }
    
    void a(final y y) {
        final boolean a = y.a.h.a;
        ag.a(this.c).a(this.e, y, this.f);
        final x a2 = y.a();
    Label_0078_Outer:
        while (a2.f()) {
            d d = a2.e().f();
            while (true) {
                while (d != null) {
                    this.a(d);
                    d = d.g();
                    if (!a) {
                        if (a) {
                            break;
                        }
                        continue Label_0078_Outer;
                    }
                    else {
                        if (a) {
                            break Label_0078_Outer;
                        }
                        continue Label_0078_Outer;
                    }
                }
                a2.g();
                continue;
            }
        }
    }
    
    void a(final d d) {
        if (ag.d(this.c) && this.c(d)) {
            this.a.c(d, Double.MAX_VALUE);
            if (!y.a.h.a) {
                return;
            }
        }
        this.a.c(d, -this.f.c(d));
    }
    
    void d(final y y) {
        final boolean a = y.a.h.a;
        final x a2 = y.a();
    Label_0062_Outer:
        while (a2.f()) {
            d d = a2.e().f();
            while (true) {
                while (d != null) {
                    this.a.b(d);
                    d = d.g();
                    if (!a) {
                        if (a) {
                            break;
                        }
                        continue Label_0062_Outer;
                    }
                    else {
                        if (a) {
                            break Label_0062_Outer;
                        }
                        continue Label_0062_Outer;
                    }
                }
                a2.g();
                continue;
            }
        }
    }
    
    void b(final d d) {
        final boolean a = y.a.h.a;
        if (!ag.d(this.c)) {
            return;
        }
        if (d.c().a() == 2) {
            final e j = d.c().j();
            while (true) {
                while (j.f()) {
                    final int n;
                    final boolean b = (n = (j.a().equals(d) ? 1 : 0)) != 0;
                    if (!a) {
                        if (!b) {
                            this.a.c(j.a(), Double.MAX_VALUE);
                        }
                        j.g();
                        if (a) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if (n == 2) {
                            final e i = d.d().j();
                            while (i.f()) {
                                if (!i.a().equals(d)) {
                                    this.a.c(i.a(), Double.MAX_VALUE);
                                }
                                i.g();
                                if (a) {
                                    break;
                                }
                            }
                        }
                        return;
                    }
                }
                int n = d.d().a();
                continue;
            }
        }
    }
    
    d b() {
        final boolean a = y.a.h.a;
        d d = (d)this.a.a();
        while (true) {
            while (ag.d(this.c)) {
                final ai ai = this;
                final d d2 = d;
                if (a) {
                    ai.b(d2);
                    return d;
                }
                if (!this.c(d2) || !this.c()) {
                    break;
                }
                this.a.a(d, Double.MAX_VALUE);
                d = (d)this.a.a();
                if (a) {
                    break;
                }
            }
            final ai ai = this;
            continue;
        }
    }
    
    boolean c() {
        return !this.a.c() && this.a.b() < 1.0;
    }
    
    boolean c(final d d) {
        return d.c().a() < 2 || d.d().a() < 2;
    }
    
    y a(final q q) {
        return this.i.get(this.g.a(q));
    }
    
    int d() {
        return this.h;
    }
    
    A e() {
        return this.g;
    }
}
