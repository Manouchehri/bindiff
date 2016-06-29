package y.f.c;

import y.f.*;
import y.g.*;
import y.a.*;
import y.c.*;

class J implements Q, R, v
{
    R c;
    Q d;
    v e;
    y f;
    y g;
    private final E a;
    
    J(final E a) {
        this.a = a;
    }
    
    void a(final y f) {
        this.f = f;
    }
    
    void b(final y g) {
        this.g = g;
    }
    
    public int a(final X x, final A a, final f f) {
        final boolean i = a.i;
        final I j = new I(x);
        boolean b = false;
        int n = 0;
        int f2 = 0;
        Label_0189: {
            if (this.f != null && this.f.size() > 0) {
                p p3 = this.f.k();
                while (p3 != null) {
                    final q q = (q)p3.c();
                    f2 = (x.f(q) ? 1 : 0);
                    if (i) {
                        break Label_0189;
                    }
                    if (f2 != 0) {
                        a.a(q, 0);
                        j.a(q);
                        b = true;
                    }
                    p3 = p3.a();
                    if (i) {
                        break;
                    }
                }
            }
            if (this.g != null && this.g.size() > 0) {
                p p4 = this.g.k();
                while (p4 != null) {
                    final q q2 = (q)p4.c();
                    final boolean f3 = x.f(q2);
                    if (i) {
                        break;
                    }
                    if (f3) {
                        j.a(q2);
                        n = 1;
                    }
                    p4 = p4.a();
                    if (i) {
                        break;
                    }
                }
            }
        }
        final int n2 = f2 + n;
        int a2 = 0;
        Label_0241: {
            if (this.c instanceof e) {
                a2 = 1;
                if (!i) {
                    break Label_0241;
                }
            }
            a2 = h.a(x, this.a.n);
        }
        int n3 = 0;
        Label_0460: {
            Label_0455: {
                x o = null;
                Label_0399: {
                    Label_0390: {
                        Label_0376: {
                            if (a2 > 1) {
                                n3 = 0;
                                final I k = new I(x);
                                int l = a2 - 1;
                            Label_0358_Outer:
                                while (l >= 0) {
                                    o = x.o();
                                    if (!i) {
                                        final x x2 = o;
                                        while (true) {
                                            while (x2.f()) {
                                                final q e = x2.e();
                                                final int a3 = this.a.n.a(e);
                                                final int n4 = l;
                                                if (!i) {
                                                    if (a3 != n4) {
                                                        k.a(e);
                                                    }
                                                    x2.g();
                                                    if (i) {
                                                        break;
                                                    }
                                                    continue Label_0358_Outer;
                                                }
                                                else {
                                                    n3 = Math.max(a3, n4);
                                                    k.f();
                                                    --l;
                                                    if (i) {
                                                        break Label_0376;
                                                    }
                                                    continue Label_0358_Outer;
                                                }
                                            }
                                            this.c.a(x, a, f);
                                            continue;
                                        }
                                    }
                                    break Label_0399;
                                }
                                break Label_0390;
                            }
                        }
                        n3 = this.c.a(x, a, f);
                    }
                    if (!b) {
                        break Label_0455;
                    }
                    x.o();
                }
                final x x3 = o;
                while (x3.f()) {
                    final q e2 = x3.e();
                    a.a(e2, a.a(e2) + 1);
                    x3.g();
                    if (i) {
                        break Label_0460;
                    }
                    if (i) {
                        break;
                    }
                }
            }
            j.f();
        }
        boolean f4 = false;
        if (b) {
            p p5 = this.f.k();
            while (p5 != null) {
                final q q3 = (q)p5.c();
                f4 = x.f(q3);
                if (i) {
                    break;
                }
                if (f4) {
                    a.a(q3, 0);
                }
                p5 = p5.a();
                if (i) {
                    break;
                }
            }
        }
        if (f4) {
            p p6 = this.g.k();
            while (p6 != null) {
                final q q4 = (q)p6.c();
                final int f5;
                final boolean b2 = (f5 = (x.f(q4) ? 1 : 0)) != 0;
                if (i) {
                    return f5;
                }
                if (b2) {
                    a.a(q4, n3 + n2 - 1);
                }
                p6 = p6.a();
                if (i) {
                    break;
                }
            }
        }
        return n3 + n2;
    }
    
    public y[] a(final X x, final A a, final int n) {
        return this.d.a(x, a, n);
    }
    
    public void a(final X x, final y[] array, final c c) {
        this.e.a(x, array, c);
    }
    
    public void a(final A a) {
        this.e.a(a);
    }
    
    public void a(final double n) {
        this.e.a(n);
    }
    
    public void d(final double n) {
        this.e.d(n);
    }
    
    public void b(final double n) {
        this.e.b(n);
    }
    
    public void c(final double n) {
        this.e.c(n);
    }
}
