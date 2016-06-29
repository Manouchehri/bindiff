package y.f.e.a;

import y.c.*;

class ar implements ax
{
    private int a;
    
    ar() {
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
        while (o.f()) {
            final q e = o.e();
            if (e != j) {
                final m a3 = b2.a(e);
                if (!a3.n()) {
                    final k a4 = a3.a();
                    final double n = a2.d() - a4.d();
                    final double n2 = a2.e() - a4.e();
                    final double n3 = a2.f() - a4.f();
                    final double sqrt = Math.sqrt(n * n + n2 * n2 + n3 * n3);
                    if (sqrt != 0.0) {
                        final double max = Math.max(sqrt - (h + a3.h()), 0.001);
                        final double g = l.g();
                        double n4 = 0.0;
                        Label_0305: {
                            Label_0267: {
                                switch (this.a) {
                                    case 1: {
                                        n4 = g / (max * sqrt);
                                        if (b) {
                                            break Label_0267;
                                        }
                                        break Label_0305;
                                    }
                                    case 2: {
                                        n4 = g * g / (max * max * sqrt);
                                        if (b) {
                                            break;
                                        }
                                        break Label_0305;
                                    }
                                }
                            }
                            n4 = c.a(g / max, this.a) / sqrt;
                        }
                        a.a(n * n4, n2 * n4, n3 * n4);
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
