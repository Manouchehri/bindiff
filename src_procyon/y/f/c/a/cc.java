package y.f.c.a;

import y.f.*;
import y.g.*;
import y.c.*;

class cc implements z
{
    double a;
    private A b;
    
    public void a(final double a) {
        this.a = a;
    }
    
    public void a(final X x, final aU au, final aV av) {
        this.a(x, au, av, this.b = M.a(new double[x.e()]));
    }
    
    public void b(final X x, final aU au, final aV av) {
        this.b = null;
    }
    
    private void a(final X x, final aU au, final aV av, final A a) {
        final boolean x2 = N.x;
        final d[] array = new d[x.g()];
        final d[] array2 = new d[x.g()];
        final e p4 = x.p();
        while (p4.f()) {
            array[p4.a().b()] = p4.a();
            array2[p4.a().b()] = p4.a();
            p4.g();
            if (x2) {
                break;
            }
        }
        int n = 0;
        while (true) {
            do {
                int i = 0;
                Label_0094: {
                    i = n;
                }
                int b = au.b();
                Label_0102:
            Label_0388_Outer:
                while (i < b) {
                    final p k = au.a(n).d().k();
                Label_0388:
                    while (true) {
                        Label_0763: {
                            p a2 = null;
                            q d3 = null;
                            Label_0428: {
                                if (!x2) {
                                    a2 = k;
                                Label_0274_Outer:
                                    while (a2 != null) {
                                        final q q = (q)a2.c();
                                        a.a(q, -1.0);
                                        final byte b2 = (byte)(i = av.a(q).b());
                                        final int n2 = b = 1;
                                        if (x2) {
                                            continue Label_0102;
                                        }
                                        Label_0363: {
                                            if (b2 != n2) {
                                                d d = q.g();
                                                Label_0188:
                                                while (true) {
                                                    Label_0272: {
                                                    Label_0267_Outer:
                                                        while (d != null) {
                                                            final q c = d.c();
                                                            if (!x2) {
                                                                q c2 = c;
                                                                while (true) {
                                                                    while (av.a(c2).b() == 1) {
                                                                        final d g = c2.g();
                                                                        array2[g.b()] = d;
                                                                        c2 = g.c();
                                                                        if (!x2) {
                                                                            if (x2) {
                                                                                break;
                                                                            }
                                                                            continue Label_0267_Outer;
                                                                        }
                                                                        else {
                                                                            if (x2) {
                                                                                break Label_0272;
                                                                            }
                                                                            continue Label_0188;
                                                                        }
                                                                    }
                                                                    d = d.h();
                                                                    continue Label_0274_Outer;
                                                                }
                                                            }
                                                            d d2 = c.f();
                                                            Label_0279:
                                                            while (d2 != null) {
                                                                d3 = d2.d();
                                                                if (!x2) {
                                                                    q d4 = d3;
                                                                    while (true) {
                                                                        while (av.a(d4).b() == 1) {
                                                                            final d f = d4.f();
                                                                            array[f.b()] = d2;
                                                                            d4 = f.d();
                                                                            if (!x2) {
                                                                                if (x2) {
                                                                                    break;
                                                                                }
                                                                                continue Label_0274_Outer;
                                                                            }
                                                                            else {
                                                                                if (x2) {
                                                                                    break Label_0363;
                                                                                }
                                                                                continue Label_0279;
                                                                            }
                                                                        }
                                                                        d2 = d2.g();
                                                                        continue Label_0388_Outer;
                                                                    }
                                                                }
                                                                break Label_0428;
                                                            }
                                                            break Label_0363;
                                                        }
                                                    }
                                                    continue Label_0388_Outer;
                                                }
                                            }
                                        }
                                        a2 = a2.a();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    ++n;
                                    continue Label_0094;
                                }
                                Label_0413: {
                                    break Label_0413;
                                    final int a3;
                                    if (a3 >= au.b()) {
                                        return;
                                    }
                                    au.a(n).d().k();
                                }
                                a2 = k;
                                if (a2 == null) {
                                    break Label_0763;
                                }
                                final q q2 = (q)a2.c();
                            }
                            q q3 = d3;
                            aX a4 = av.a(q3);
                            p p5 = a2.a();
                            while (p5 != null) {
                                final q q4 = (q)p5.c();
                                final aX a5 = av.a(q4);
                                final int a3 = this.a(a5, a4) ? 1 : 0;
                                if (x2) {
                                    continue Label_0388;
                                }
                                Label_0743: {
                                    if (a3 != 0) {
                                        boolean b3 = false;
                                        if (q4.b() == 1 && q3.b() == 1) {
                                            final d g2 = q3.g();
                                            final d g3 = q4.g();
                                            final d d5 = array[g2.b()];
                                            final d d6 = array[g3.b()];
                                            if (d5.c() == d6.c()) {
                                                a.a(q3, Math.abs(x.n(d5).a - x.n(d6).a));
                                                b3 = true;
                                            }
                                        }
                                        if (q4.c() == 1 && q3.c() == 1) {
                                            final d f2 = q3.f();
                                            final d f3 = q4.f();
                                            final d d7 = array2[f2.b()];
                                            final d d8 = array2[f3.b()];
                                            if (d7.d() == d8.d()) {
                                                double n3 = Math.abs(x.o(d7).a - x.o(d8).a);
                                                if (b3) {
                                                    final double c3 = a.c(q3);
                                                    n3 = Math.max(n3, c3);
                                                    if (n3 >= c3) {
                                                        break Label_0743;
                                                    }
                                                    a.a(q3, n3);
                                                    if (!x2) {
                                                        break Label_0743;
                                                    }
                                                }
                                                a.a(q3, n3);
                                            }
                                        }
                                    }
                                }
                                q3 = q4;
                                a4 = a5;
                                p5 = p5.a();
                                if (x2) {
                                    break;
                                }
                            }
                        }
                        ++n;
                        if (!x2) {
                            continue Label_0388;
                        }
                        break;
                    }
                    return;
                }
                break;
            } while (!x2);
            n = 0;
            continue;
        }
    }
    
    private boolean a(final aX ax, final aX ax2) {
        switch (ax.b()) {
            default: {
                return false;
            }
            case 1:
            case 2:
            case 3:
            case 8:
            case 9: {
                switch (ax2.b()) {
                    default: {
                        return false;
                    }
                    case 1:
                    case 2:
                    case 3:
                    case 8:
                    case 9: {
                        return true;
                    }
                }
                break;
            }
        }
    }
    
    public double a(final X x, final aQ aq, final aV av, final q q, final q q2) {
        if (q == null || q2 == null) {
            return 0.0;
        }
        return this.b.c(q);
    }
}
