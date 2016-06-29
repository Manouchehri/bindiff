package y.f.f.a.b;

import y.f.h.*;
import java.util.*;
import y.c.*;

public class g extends s implements l
{
    private f n;
    private i o;
    
    public g() {
        this.n = new f();
    }
    
    public f a() {
        return this.n;
    }
    
    public void a(final a a) {
        final boolean c = a.c;
        this.o = a.d();
        final D d = new D(this.o);
        this.n.clear();
        this.d();
        this.e();
        this.g = new h(a.d(), a.b());
        this.a(d);
        final e p = this.o.p();
        while (true) {
            while (p.f()) {
                final d a2 = p.a();
                final boolean n = d.n(a2);
                if (c) {
                    d.e();
                    return;
                }
                if (n) {
                    a.a(a2, true);
                    d.a(a2, false);
                    a.a(a2, d.h(a2));
                }
                p.g();
                if (c) {
                    break;
                }
            }
            this.n.addAll(this.c_());
            continue;
        }
    }
    
    private void d() {
        final boolean c = y.f.f.a.b.a.c;
        final e p = this.o.p();
        while (p.f()) {
            if (p.a().e()) {
                this.n.c(p.a());
                this.o.d(p.a());
            }
            p.g();
            if (c) {
                break;
            }
        }
    }
    
    private void e() {
        final boolean c = y.f.f.a.b.a.c;
        final A t = this.o.t();
        final y.c.x o = this.o.o();
    Label_0160_Outer:
        while (o.f()) {
            final q e = o.e();
            if (!c) {
                e e2 = e.j();
                while (true) {
                    while (e2.f()) {
                        final d a = e2.a();
                        final q a2 = a.a(e);
                        final d d2;
                        final d d = d2 = (d)t.b(a2);
                        if (!c) {
                            Label_0142: {
                                if (d2 != a) {
                                    if (d == null) {
                                        t.a(a2, a);
                                        if (!c) {
                                            break Label_0142;
                                        }
                                    }
                                    this.n.c(a);
                                    this.o.d(a);
                                }
                            }
                            e2.g();
                            if (c) {
                                break;
                            }
                            continue Label_0160_Outer;
                        }
                        else {
                            while (true) {
                                t.a(d2.a(e), null);
                                e2.g();
                                if (!c) {
                                    if (!c) {
                                        if (e2.f()) {
                                            e2.a();
                                            continue Label_0160_Outer;
                                        }
                                    }
                                    o.g();
                                }
                                break;
                            }
                            if (c) {
                                break Label_0160_Outer;
                            }
                            continue Label_0160_Outer;
                        }
                    }
                    e2 = e.j();
                    continue;
                }
            }
            return;
        }
        this.o.a(t);
    }
}
