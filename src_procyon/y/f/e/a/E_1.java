package y.f.e.a;

import y.c.*;

final class E implements ax
{
    private int a;
    private int b;
    private double c;
    
    E() {
        this.a = 1;
        this.b = 1;
        this.c = 1.0;
    }
    
    public void a(final int a) {
        this.a = a;
    }
    
    public k a(final m m, final l l, final a a) {
        final boolean b = af.b;
        final q j = m.j();
        final k a2 = m.a();
        final m i = m.l();
        a.a();
        final e k = j.j();
        while (k.f()) {
            final d a3 = k.a();
            final q a4 = a3.a(j);
            Label_0448: {
                if (a4 != j) {
                    final w b2 = l.b();
                    final m a5 = b2.a(a4);
                    double b3 = b2.a(a3).b();
                    int n = this.a;
                    a5.l();
                    m m2 = null;
                    m m3 = null;
                Label_0132:
                    while (m2 != m3) {
                        b3 *= this.c;
                        n = this.b;
                        if (m.k() || a5.k()) {
                            m m4 = a5.l();
                            while (m4 != null) {
                                m2 = m4;
                                if (b) {
                                    continue Label_0132;
                                }
                                if (m2 == m) {
                                    break Label_0448;
                                }
                                m4 = m4.l();
                                if (b) {
                                    break;
                                }
                            }
                            m l2 = i;
                            while (l2 != null) {
                                final m m5 = l2;
                                m3 = a5;
                                if (b) {
                                    continue Label_0132;
                                }
                                if (m5 == m3) {
                                    break Label_0448;
                                }
                                l2 = l2.l();
                                if (b) {
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    final k a6 = a5.a();
                    final double n2 = a6.d() - a2.d();
                    final double n3 = a6.e() - a2.e();
                    final double n4 = a6.f() - a2.f();
                    final double sqrt = Math.sqrt(n2 * n2 + n3 * n3 + n4 * n4);
                    if (sqrt >= 0.001) {
                        if (b3 == 0.0) {
                            b3 = 0.001;
                        }
                        double n5 = 0.0;
                        Label_0427: {
                            Label_0395: {
                                switch (n) {
                                    case 1: {
                                        n5 = 1.0 / b3;
                                        if (b) {
                                            break Label_0395;
                                        }
                                        break Label_0427;
                                    }
                                    case 2: {
                                        n5 = sqrt / (b3 * b3);
                                        if (b) {
                                            break;
                                        }
                                        break Label_0427;
                                    }
                                }
                            }
                            n5 = y.f.e.a.c.a(sqrt / b3, this.a) / sqrt;
                        }
                        a.a(n2 * n5, n3 * n5, n4 * n5);
                    }
                }
            }
            k.g();
            if (b) {
                break;
            }
        }
        return a;
    }
}
