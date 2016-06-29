package y.f.h;

import y.a.*;
import y.g.*;
import java.util.*;
import y.c.*;

public class a implements x
{
    private x a;
    private D b;
    private i c;
    private f d;
    private boolean e;
    
    public a(final x a) {
        this.a = null;
        this.a = a;
        this.d = new f();
        this.e = false;
    }
    
    public void a(final D b) {
        final boolean d = N.d;
        final y y = new y();
        this.b = b;
        this.c = b.g();
        final A t = this.c.t();
        final f[] d2 = h.d(b.g());
        final f a = this.a(this.c);
        int n = 0;
        e a2 = null;
        Label_0445: {
        Label_0441:
            while (true) {
                int i = 0;
            Label_0135_Outer:
                while (i < d2.length) {
                    a2 = d2[n].a();
                    if (!d) {
                        final e e = a2;
                        while (true) {
                        Label_0313_Outer:
                            while (e.f()) {
                                this.c.e(e.a());
                                e.g();
                                if (d) {
                                    y.c.x x = this.c.o();
                                Label_0363_Outer:
                                    while (true) {
                                    Label_0363:
                                        while (true) {
                                            while (x.f()) {
                                                final q e2 = x.e();
                                                final int a3 = e2.a();
                                                if (!d) {
                                                    if (a3 == 0) {
                                                        y.add(e2);
                                                        this.c.c(x.e());
                                                    }
                                                    x.g();
                                                    if (d) {
                                                        break;
                                                    }
                                                    continue Label_0135_Outer;
                                                }
                                                else {
                                                    while (true) {
                                                        if (a3 != 0) {
                                                            this.c.d(x.e());
                                                            x.g();
                                                            if (d) {
                                                                continue Label_0445;
                                                            }
                                                            if (!d) {
                                                                x.f();
                                                                continue Label_0313_Outer;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    final e e3 = this.c.p();
                                                    while (e3.f()) {
                                                        i = (this.b.n(e3.a()) ? 1 : 0);
                                                        if (d) {
                                                            continue Label_0445;
                                                        }
                                                        if (i != 0) {
                                                            a.add(e3.a());
                                                        }
                                                        this.c.d(e3.a());
                                                        e3.g();
                                                        if (d) {
                                                            break;
                                                        }
                                                    }
                                                    ++n;
                                                    if (d) {
                                                        break Label_0441;
                                                    }
                                                    continue Label_0445;
                                                }
                                            }
                                            o.a(this, 0, "Compute Planar Subgraph for biconnected component...");
                                            this.a.a(this.b);
                                            o.a(this, 0, "Save planarization...");
                                            this.a(t);
                                            o.a(this, 0, "Store hidden edges...");
                                            final e e3 = this.a.c_().a();
                                            while (e3.f()) {
                                                this.d.add(e3.a());
                                                e3.g();
                                                if (d) {
                                                    continue Label_0363;
                                                }
                                                if (d) {
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        x = y.a();
                                        continue Label_0363_Outer;
                                    }
                                }
                                if (d) {
                                    break;
                                }
                            }
                            y.clear();
                            continue;
                        }
                    }
                    break Label_0445;
                }
                break;
            }
            a.a();
        }
        e a4 = a2;
        while (true) {
            while (a4.f()) {
                this.c.e(a4.a());
                a4.g();
                if (d) {
                    while (a4.f()) {
                        this.c.d(a4.a());
                        a4.g();
                        if (d) {
                            return;
                        }
                        if (d) {
                            break;
                        }
                    }
                    this.b(t);
                    this.b.l();
                    this.c.a(t);
                    this.e = true;
                    this.b();
                    return;
                }
                if (d) {
                    break;
                }
            }
            a4 = this.d.a();
            continue;
        }
    }
    
    public f c_() {
        if (this.e) {
            return this.d;
        }
        throw new RuntimeException("Invalid Execution Order: call 'createPlanarization' first!");
    }
    
    protected void a(final A a) {
        final boolean d = N.d;
        final y.c.x o = this.c.o();
    Label_0116_Outer:
        while (o.f()) {
            final q e = o.e();
            f f = (f)a.b(e);
            if (f == null) {
                f = new f();
                a.a(e, f);
            }
            final e l = e.l();
            while (true) {
                while (l.f()) {
                    f.add(l.a());
                    l.g();
                    if (!d) {
                        if (d) {
                            break;
                        }
                        continue Label_0116_Outer;
                    }
                    else {
                        if (d) {
                            break Label_0116_Outer;
                        }
                        continue Label_0116_Outer;
                    }
                }
                o.g();
                continue;
            }
        }
    }
    
    private void b(final A a) {
        final boolean d = N.d;
        final y.c.x o = this.c.o();
        while (o.f()) {
            final q e = o.e();
            e.b(new b(this, (f)a.b(e)));
            o.g();
            if (d) {
                break;
            }
        }
    }
    
    private f a(final i i) {
        final boolean d = N.d;
        final f f = new f();
        final e p = i.p();
        f f2 = null;
        while (p.f()) {
            final d a = p.a();
            f2 = f;
            if (d) {
                return f2;
            }
            f2.add(a);
            i.d(a);
            p.g();
            if (d) {
                break;
            }
        }
        return f2;
    }
    
    public void b() {
    }
}
