package y.f.e.a;

import java.awt.geom.*;
import y.c.*;

public class aj implements ax
{
    private double a;
    private boolean b;
    
    public void a(final boolean b) {
        this.b = b;
    }
    
    public void a(final double a) {
        this.a = a;
    }
    
    public aj() {
        this.a = 50.0;
        this.b = false;
    }
    
    public k a(final m m, final l l, final a a) {
        final boolean b = af.b;
        final q j = m.j();
        final w b2 = l.b();
        final k a2 = m.a();
        final double d = a2.d();
        final double e = a2.e();
        final double f = a2.f();
        final double n = this.a * 5.0;
        final Rectangle2D.Double double1 = new Rectangle2D.Double(d - n, e - n, 2.0 * n, 2.0 * n);
        double n2 = 0.0;
        double n3 = 0.0;
        double n4 = 0.0;
        final x o = l.b().f().o();
        while (o.f()) {
            final q e2 = o.e();
            if (b) {
                return a;
            }
            q q = null;
            q d2 = null;
        Label_0146:
            while (q != d2) {
                if (e2.f() == null) {
                    break;
                }
                final k a3 = b2.a(e2).a();
                final double d3;
                final double n5 = d - (d3 = a3.d());
                final double e3;
                final double n6 = e - (e3 = a3.e());
                final double f2;
                final double n7 = f - (f2 = a3.f());
                final double n8 = 1.0 / Math.max(Math.sqrt(n5 * n5 + n6 * n6 + n7 * n7), 0.001);
                d d4 = e2.f();
                while (d4 != null) {
                    q = j;
                    d2 = d4.d();
                    if (b) {
                        continue Label_0146;
                    }
                    if (q != d2) {
                        final double a4 = b2.a(d4).a();
                        final double n9 = this.a + m.h();
                        final double sqrt = Math.sqrt(n9 * n9 + a4 * a4);
                        final k a5 = b2.a(d4.d()).a();
                        if (!this.b || double1.intersectsLine(d3, e3, a5.d(), a5.e())) {
                            final double n10 = a5.d() - d3;
                            final double n11 = a5.e() - e3;
                            final double n12 = a5.f() - f2;
                            final double sqrt2 = Math.sqrt(n10 * n10 + n11 * n11 + n12 * n12);
                            if (sqrt2 >= 0.001) {
                                final double n13 = 1.0 / sqrt2;
                                final double n14 = (n5 * n10 + n6 * n11 + n7 * n12) * n13;
                                final double n15 = -n14 * n13;
                                final double n16 = n5 + n15 * n10;
                                final double n17 = n6 + n15 * n11;
                                final double n18 = n7 + n15 * n12;
                                double n19 = n16 * n16 + n17 * n17 + n18 * n18;
                                if (n19 < 0.001) {
                                    n19 = 0.001;
                                }
                                final double n20 = -n14;
                                final double n21 = n20 + sqrt2;
                                final double n22 = 1.0 / Math.sqrt(n21 * n21 + n19);
                                final double n23 = (n22 - n8) * n13 * sqrt;
                                final double n24 = (n21 * n22 - n20 * n8) * sqrt / n19;
                                n2 += n10 * n23 + n16 * n24;
                                n3 += n11 * n23 + n17 * n24;
                                n4 += n12 * n23 + n18 * n24;
                            }
                        }
                    }
                    d4 = d4.g();
                    if (b) {
                        break;
                    }
                }
                break;
            }
            o.g();
            if (b) {
                break;
            }
        }
        a.b(n2, n3, n4);
        return a;
    }
}
