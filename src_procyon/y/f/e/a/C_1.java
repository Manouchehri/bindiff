package y.f.e.a;

import y.f.b.*;
import y.f.*;
import y.c.*;

final class C implements am
{
    private final z a;
    
    C(final z a) {
        this.a = a;
    }
    
    public void a(final l l, final af af) {
        final boolean b = af.b;
        this.a.a = null;
        this.a.b = null;
        final X f = af.f();
        if (!c.b(f)) {
            return;
        }
        final c a = new c(f);
        this.a.a = a;
        final x o = f.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final ag c = af.c(e);
                if (b) {
                    final double n = l.h() * 0.5 + l.g() * 0.5;
                    p p2 = this.a.b.l();
                    while (p2 != null) {
                        final q q = (q)p2.c();
                        Label_0598: {
                            if (a.d(q) && !af.a(q).n()) {
                                double n2 = 0.0;
                                final y b2 = a.b(q);
                                double min = Double.MAX_VALUE;
                                double min2 = Double.MAX_VALUE;
                                double min3 = Double.MAX_VALUE;
                                double max = -1.7976931348623157E308;
                                double max2 = -1.7976931348623157E308;
                                double max3 = -1.7976931348623157E308;
                                p p3 = b2.k();
                                while (p3 != null) {
                                    final m a2 = af.a((q)p3.c());
                                    final double h = a2.h();
                                    n2 += h * h * 3.0;
                                    final double b3 = a2.b();
                                    final double c2 = a2.c();
                                    final double d = a2.d();
                                    final double h2 = a2.h();
                                    min = Math.min(min, b3 - h2);
                                    max = Math.max(max, b3 + h2);
                                    min2 = Math.min(min2, c2 - h2);
                                    max2 = Math.max(max2, c2 + h2);
                                    min3 = Math.min(min3, d - h2);
                                    max3 = Math.max(max3, d + h2);
                                    p3 = p3.a();
                                    if (b) {
                                        break Label_0598;
                                    }
                                    if (b) {
                                        break;
                                    }
                                }
                                final double n3 = Math.sqrt(n2 / (b2.size() + 1)) + n * 0.9;
                                final double n4 = Math.sqrt(n3 * n3 * b2.size()) * 0.5 + n;
                                final ag c3 = af.c(q);
                                c3.e(n4 * 0.9);
                                c3.f(Math.max(50.0, Math.max(Math.max((max - min) / 2.0, (max2 - min2) / 2.0), (max3 - min3) / 2.0)));
                            }
                            p2 = p2.b();
                        }
                        if (b) {
                            break;
                        }
                    }
                    return;
                }
                if (a.d(e)) {
                    c.b(true);
                }
                if (a.a(e) != a.b()) {
                    c.a(af.a(a.a(e)));
                }
                o.g();
                if (b) {
                    break;
                }
            }
            this.a.b = a.c(a.b());
            continue;
        }
    }
}
