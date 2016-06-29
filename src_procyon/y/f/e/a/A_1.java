package y.f.e.a;

import y.c.*;

final class A implements ax
{
    private final z a;
    
    A(final z a) {
        this.a = a;
    }
    
    public k a(final m m, final l l, final a a) {
        final boolean b = af.b;
        final y.f.b.c a2 = this.a.a;
        final q j = m.j();
        if (a2 != null && a2.d(j)) {
            final k a3 = m.a();
            final w b2 = l.b();
            double h = m.h();
            p p3 = a2.b(j).k();
            while (p3 != null) {
                final k a4 = b2.a((q)p3.c()).a();
                final double n = a4.d() - a3.d();
                final double n2 = a4.e() - a3.e();
                final double n3 = a4.f() - a3.f();
                final double sqrt = Math.sqrt(n * n + n2 * n2 + n3 * n3);
                if (sqrt >= 0.001) {
                    final int n4 = 1;
                    if (h == 0.0) {
                        h = 0.001;
                    }
                    double n5 = 0.0;
                    Label_0277: {
                        Label_0247: {
                            switch (n4) {
                                case 1: {
                                    n5 = 1.0 / h;
                                    if (b) {
                                        break Label_0247;
                                    }
                                    break Label_0277;
                                }
                                case 2: {
                                    n5 = sqrt / (h * h);
                                    if (b) {
                                        break;
                                    }
                                    break Label_0277;
                                }
                            }
                        }
                        n5 = c.a(sqrt / h, n4) / sqrt;
                    }
                    a.a(n * n5, n2 * n5, n3 * n5);
                }
                p3 = p3.a();
                if (b) {
                    break;
                }
            }
        }
        return a;
    }
}
