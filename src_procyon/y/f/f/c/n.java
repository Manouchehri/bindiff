package y.f.f.c;

import y.f.f.b.*;
import y.g.*;
import y.a.*;
import y.c.*;

public class n implements l
{
    private boolean a;
    
    public n() {
        this.a = false;
    }
    
    public void a(final h h, final p p3, final p p4) {
        o.a(this, 3, "Simplex Compaction");
        this.a(p3);
        this.a(p4);
    }
    
    public void a(final boolean a) {
        this.a = a;
    }
    
    public void a(final p p) {
        int a = g.a;
        final i f = p.f();
        final y.c.h u = f.u();
        final y.c.h u2 = f.u();
        final A t = f.t();
        final A t2 = f.t();
        final x o = f.o();
    Label_0192:
        while (true) {
            while (o.f()) {
                t2.a(o.e(), new f());
                o.g();
                if (a != 0) {
                    x x = f.o();
                    while (true) {
                        while (x.f()) {
                            t.a(x.e(), p.b(x.e()).i());
                            x.g();
                            if (a != 0) {
                                while (true) {
                                    while (x.f()) {
                                        final q e = x.e();
                                        final g b = p.b(e);
                                        final y.f.f.c.o a2 = p.a(b);
                                        if (a != 0) {
                                            final x o2 = f.o();
                                            while (true) {
                                                while (o2.f()) {
                                                    p.b(o2.e()).a(t.a(o2.e()));
                                                    o2.g();
                                                    if (a != 0) {
                                                        if (i.g) {
                                                            g.a = ++a;
                                                        }
                                                        return;
                                                    }
                                                    if (a != 0) {
                                                        break;
                                                    }
                                                }
                                                f.a(t);
                                                f.a(t2);
                                                f.a(u);
                                                f.a(u2);
                                                continue;
                                            }
                                        }
                                        if (a2 != null) {
                                            if (a2.a == b) {
                                                u.a(e.a(a2.b.a()), 20000);
                                            }
                                        }
                                        x.g();
                                        if (a != 0) {
                                            break;
                                        }
                                    }
                                    y.a.u.a(f, t, u, u2);
                                    continue;
                                }
                            }
                            if (a != 0) {
                                break;
                            }
                        }
                        x = f.o();
                        continue;
                    }
                }
                if (a != 0) {
                    break;
                }
            }
            final e p2 = f.p();
            while (p2.f()) {
                u2.a(p2.a(), (int)p.b(p2.a()));
                u.a(p2.a(), p.c(p2.a()));
                p2.g();
                if (a != 0) {
                    continue Label_0192;
                }
                if (a != 0) {
                    break;
                }
            }
            if (!this.a) {
                new k().a(p);
            }
            continue Label_0192;
        }
    }
}
