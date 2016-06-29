package y.f.e.a;

import y.c.*;

class ae implements ax
{
    private int a;
    
    ae() {
        this.a = 1;
    }
    
    public void a(final int a) {
        this.a = a;
    }
    
    public k a(final m m, final l l, final a a) {
        final boolean b = af.b;
        final q j = m.j();
        final k a2 = m.a();
        a.a();
        final e i = j.j();
        while (i.f()) {
            final d a3 = i.a();
            final q a4 = a3.a(j);
            if (a4 != j) {
                final w b2 = l.b();
                final m a5 = b2.a(a4);
                double b3 = b2.a(a3).b();
                final k a6 = a5.a();
                final double n = a6.d() - a2.d();
                final double n2 = a6.e() - a2.e();
                final double n3 = a6.f() - a2.f();
                final double sqrt = Math.sqrt(n * n + n2 * n2 + n3 * n3);
                if (sqrt >= 0.001) {
                    if (b3 == 0.0) {
                        b3 = 0.001;
                    }
                    double n4 = 0.0;
                    Label_0283: {
                        Label_0251: {
                            switch (this.a) {
                                case 1: {
                                    n4 = 1.0 / b3;
                                    if (b) {
                                        break Label_0251;
                                    }
                                    break Label_0283;
                                }
                                case 2: {
                                    n4 = sqrt / (b3 * b3);
                                    if (b) {
                                        break;
                                    }
                                    break Label_0283;
                                }
                            }
                        }
                        n4 = c.a(sqrt / b3, this.a) / sqrt;
                    }
                    a.a(n * n4, n2 * n4, n3 * n4);
                }
            }
            i.g();
            if (b) {
                break;
            }
        }
        return a;
    }
}
