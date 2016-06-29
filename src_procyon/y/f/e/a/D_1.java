package y.f.e.a;

import y.c.*;

final class D implements ax
{
    private int a;
    
    D() {
        this.a = 2;
    }
    
    public void a(final int a) {
        this.a = a;
    }
    
    public k a(final m m, final l l, final a a) {
        final boolean b = af.b;
        final q j = m.j();
        final k a2 = m.a();
        final w b2 = l.b();
        final double h = m.h();
        final x o = b2.f().o();
        q e;
        m a3;
        m i = null;
        m k = null;
        m m2 = null;
        m m3;
        m m4;
        k a4;
        double n;
        double n2;
        double n3;
        double sqrt;
        double max;
        double g;
        double n4 = 0.0;
        Label_0178_Outer:Label_0221_Outer:
        while (o.f()) {
            e = o.e();
            Label_0482: {
                if (e != j) {
                    a3 = b2.a(e);
                    if (!a3.n()) {
                        Label_0255: {
                            while (true) {
                                Label_0235: {
                                    while (true) {
                                        Label_0203: {
                                            if (!m.k()) {
                                                break Label_0203;
                                            }
                                            i = a3.l();
                                            while (i != null) {
                                                k = i;
                                                m2 = m;
                                                if (b) {
                                                    break Label_0235;
                                                }
                                                if (k == m) {
                                                    break Label_0482;
                                                }
                                                i = i.l();
                                                if (b) {
                                                    break;
                                                }
                                            }
                                            if (!a3.k()) {
                                                break Label_0255;
                                            }
                                            i = m.l();
                                            while (true) {
                                                if (i == null) {
                                                    break Label_0255;
                                                }
                                                m3 = i;
                                                m2 = (m4 = a3);
                                                if (b) {
                                                    break Label_0235;
                                                }
                                                if (m3 == m4) {
                                                    break Label_0482;
                                                }
                                                i = i.l();
                                                if (!b) {
                                                    continue Label_0178_Outer;
                                                }
                                                break;
                                            }
                                        }
                                        if (!a3.k()) {
                                            break Label_0255;
                                        }
                                        i = m.l();
                                        if (i == null) {
                                            break Label_0255;
                                        }
                                        m3 = i;
                                        m2 = (m4 = a3);
                                        if (b) {
                                            continue Label_0221_Outer;
                                        }
                                        break;
                                    }
                                }
                                if (k == m2) {
                                    break Label_0482;
                                }
                                i = i.l();
                                if (!b) {
                                    continue;
                                }
                                break;
                            }
                        }
                        a4 = a3.a();
                        n = a2.d() - a4.d();
                        n2 = a2.e() - a4.e();
                        n3 = a2.f() - a4.f();
                        sqrt = Math.sqrt(n * n + n2 * n2 + n3 * n3);
                        if (sqrt != 0.0) {
                            max = Math.max(sqrt - (h + a3.h()), 0.001);
                            g = l.g();
                            Label_0461: {
                                Label_0423: {
                                    switch (this.a) {
                                        case 1: {
                                            n4 = g / (max * sqrt);
                                            if (b) {
                                                break Label_0423;
                                            }
                                            break Label_0461;
                                        }
                                        case 2: {
                                            n4 = g * g / (max * max * sqrt);
                                            if (b) {
                                                break;
                                            }
                                            break Label_0461;
                                        }
                                    }
                                }
                                n4 = c.a(g / max, this.a) / sqrt;
                            }
                            a.a(n * n4, n2 * n4, n3 * n4);
                        }
                    }
                }
            }
            o.g();
            if (b) {
                break;
            }
        }
        return a;
    }
}
