package y.f.f.c;

import y.g.*;
import y.c.*;

public class h implements l
{
    public void a(final y.f.f.b.h h, final p p3, final p p4) {
        o.a(this, 3, "Flow Compaction");
        this.a(p3);
        this.a(p4);
    }
    
    public void a(final p p) {
        final int a = g.a;
        final y.c.i f = p.f();
        final int[] array = new int[f.f()];
        final y.c.h u = f.u();
        final f f2 = new f();
        int n = 0;
        final e p2 = f.p();
        while (true) {
            while (p2.f()) {
                final d a2 = p2.a();
                u.a(a2, (int)p.b(a2));
                final int c = p.c(a2);
                final int[] array2 = array;
                final int d = a2.c().d();
                array2[d] -= c;
                final int[] array3 = array;
                final int d2 = a2.d().d();
                array3[d2] += c;
                n += c;
                p2.g();
                if (a != 0) {
                    final int n2 = n + 1;
                    x x = f.o();
                    while (true) {
                        while (x.f()) {
                            final q e = x.e();
                            final int[] array4 = array;
                            final int d3 = e.d();
                            array4[d3] += n2 * e.c() - n2 * e.b();
                            x.g();
                            if (a != 0) {
                                while (x.f()) {
                                    final g b = p.b(x.e());
                                    final y.f.f.c.o a3 = p.a(b);
                                    if (a3 != null) {
                                        if (a3.a() == b) {
                                            final d a4 = f.a(a3.b().a(), a3.a().a());
                                            u.a(a4, (int)a3.c());
                                            f2.add(a4);
                                        }
                                    }
                                    x.g();
                                    if (a != 0) {
                                        break;
                                    }
                                }
                                final i i = new i(this, n2);
                                final j j = new j(this);
                                final A a5 = M.a(array);
                                final y.c.h u2 = f.u();
                                final A t = f.t();
                                y.a.l.a(f, j, i, u, a5, u2, t);
                                final x o = f.o();
                                while (o.f()) {
                                    p.b(o.e()).a(t.a(o.e()));
                                    o.g();
                                    if (a != 0) {
                                        break;
                                    }
                                }
                                final e a6 = f2.a();
                                while (a6.f()) {
                                    f.a(a6.a());
                                    a6.g();
                                    if (a != 0) {
                                        return;
                                    }
                                    if (a != 0) {
                                        break;
                                    }
                                }
                                f.a(u);
                                f.a(u2);
                                f.a(t);
                                return;
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
                    y.c.i.g = !y.c.i.g;
                    break;
                }
            }
            o.a(this, "Total weight: " + n);
            continue;
        }
    }
}
