package y.f.f.b;

import y.g.*;
import y.f.k.*;
import y.f.*;
import y.f.h.*;
import y.c.*;

public class k
{
    private h a;
    private f b;
    private I c;
    private double d;
    
    public k() {
        this.d = -1.0;
    }
    
    public void a(final double d) {
        this.d = d;
    }
    
    public void a(final h a) {
        this.a = a;
    }
    
    public void a(final i i) {
        final int a = h.a;
        final c c = i.c(L.a);
        this.b = new f();
        this.c = new I(i);
        final x o = i.o();
        while (o.f()) {
            final q e = o.e();
            if (c != null && c.d(e)) {
                Label_0112: {
                    if (e.b() > 0) {
                        this.b.add(e.g());
                        if (a == 0) {
                            break Label_0112;
                        }
                    }
                    this.b.add(e.f());
                }
                this.c.a(e);
            }
            o.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    public void a() {
        final int a = h.a;
        final X x = (X)this.a.a();
        final D d = (D)this.a.b();
        double n = 0.0;
        final e a2 = this.b.a();
    Label_0520_Outer:
        while (a2.f()) {
            final d a3 = a2.a();
            final q d2 = a3.d();
            final q c = a3.c();
            x.d(d2);
            final e l = c.l();
            while (true) {
                while (l.f()) {
                    final d a4 = l.a();
                    final o h = this.a.h(a4);
                    final int d3 = this.a.d(a4);
                    final double n3;
                    final int n2 = (int)(n3 = d3);
                    if (a == 0) {
                        if (n2 > 0) {
                            final d h2 = d.h(d.k(a4));
                            x.e(a3);
                            d.a(a3, h2, null);
                            x.a(a3, a4, null, 1, 1);
                            final d h3 = d.h(a3);
                            d.e(a3);
                            d.m(h3);
                            Label_0488: {
                                if (h.a(o.a)) {
                                    this.a.a(a3, "<^");
                                    this.a.a(a4, 1);
                                    this.a.a(a3, d3 - 1);
                                    this.a.a(h3, 4);
                                    n = x.p(d2) * 0.5;
                                    if (a == 0) {
                                        break Label_0488;
                                    }
                                }
                                if (h.a(o.c)) {
                                    this.a.a(a3, ">_");
                                    this.a.a(a4, 1);
                                    this.a.a(a3, d3 - 1);
                                    this.a.a(h3, 4);
                                    n = x.p(d2) * 0.5;
                                    if (a == 0) {
                                        break Label_0488;
                                    }
                                }
                                if (h.a(o.b)) {
                                    this.a.a(a3, "^>");
                                    this.a.a(a4, 1);
                                    this.a.a(a3, d3 - 1);
                                    this.a.a(h3, 4);
                                    n = x.q(d2) * 0.5;
                                    if (a == 0) {
                                        break Label_0488;
                                    }
                                }
                                if (h.a(o.d)) {
                                    this.a.a(a3, "_<");
                                    this.a.a(a4, 1);
                                    this.a.a(a3, d3 - 1);
                                    this.a.a(h3, 4);
                                    n = x.q(d2) * 0.5;
                                    if (a == 0) {
                                        break Label_0488;
                                    }
                                }
                                throw new IllegalStateException("Unknown direction!");
                            }
                            this.a.f(a3);
                            if (a == 0) {
                                break;
                            }
                        }
                        l.g();
                        if (a != 0) {
                            break;
                        }
                        continue Label_0520_Outer;
                    }
                    else {
                        if (n3 > 0) {
                            this.a.n(a3);
                            final d b = d2.f().d().b(c);
                            final int n4 = (int)Math.ceil(n / this.d);
                            this.a.b(b, n4);
                            this.a.b(d.h(b), n4);
                        }
                        a2.g();
                        if (a != 0) {
                            break Label_0520_Outer;
                        }
                        continue Label_0520_Outer;
                    }
                }
                double n3 = dcmpl(this.d, 0.0);
                continue;
            }
        }
    }
}
