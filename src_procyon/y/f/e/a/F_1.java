package y.f.e.a;

final class F implements ax
{
    public k a(final m m, final l l, final a a) {
        final boolean b = af.b;
        final m i = m.l();
        if (i != null && !i.n()) {
            final k a2 = m.a();
            final k a3 = i.a();
            final double n = a3.d() - a2.d();
            final double n2 = a3.e() - a2.e();
            final double n3 = a3.f() - a2.f();
            final double sqrt = Math.sqrt(n * n + n2 * n2 + n3 * n3);
            final double n4 = sqrt - i.i() * 0.5;
            if (n4 < 0.001) {
                return a;
            }
            double n5 = i.i() * 0.5;
            final int n6 = 1;
            if (n5 == 0.0) {
                n5 = 0.001;
            }
            double n7 = 0.0;
            Label_0251: {
                Label_0215: {
                    switch (n6) {
                        case 1: {
                            n7 = n4 / (n5 * sqrt);
                            if (b) {
                                break Label_0215;
                            }
                            break Label_0251;
                        }
                        case 2: {
                            n7 = n4 * n4 / (n5 * n5 * sqrt);
                            if (b) {
                                break;
                            }
                            break Label_0251;
                        }
                    }
                }
                n7 = c.a(n4 / n5, n6) / sqrt;
            }
            if (i.h() > i.i()) {
                n7 *= Math.sqrt(i.h() / i.i());
            }
            a.b(n * n7, n2 * n7, n3 * n7);
        }
        return a;
    }
}
