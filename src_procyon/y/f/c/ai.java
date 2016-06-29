package y.f.c;

import y.f.k.*;
import java.awt.geom.*;
import y.c.*;

public class ai extends c
{
    private final double b;
    
    public ai(final double b) {
        this.b = b;
    }
    
    protected byte a(final q q) {
        return -2;
    }
    
    protected A a(final q q, final byte b) {
        final boolean i = y.f.c.a.i;
        if (q.c() == 0) {
            final A a = this.c(q);
            if (!i) {
                return a;
            }
        }
        A a2 = null;
        final A a = this.c(q);
        final Rectangle2D a3 = a.a();
        double min = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        y.d.c a4 = null;
        double n = 0.0;
        int n2 = 0;
        d d = q.f();
        while (true) {
            while (d != null) {
                final A b2 = this.b(d.d());
                b2.a(b2.b(), b2.c(), b2.b(), 0.0);
                if (i) {
                    a.a(a2);
                    return a;
                }
                Label_0157: {
                    if (a4 == null) {
                        a4 = b2.a(1);
                        if (!i) {
                            break Label_0157;
                        }
                    }
                    b2.b(-a4.c(b2.a(3)) + this.b, 0.0);
                    a4.a(b2.a(1));
                }
                min = Math.min(min, b2.b());
                max = Math.max(max, b2.b());
                Label_0202: {
                    if (a2 == null) {
                        a2 = b2;
                        if (!i) {
                            break Label_0202;
                        }
                    }
                    a2.a(b2);
                }
                final boolean b3 = q.c() % 2 == 0;
                final int n3 = (q.c() % 2 == 1) ? ((q.c() - 1) / 2) : (q.c() / 2 - 1);
                Label_0319: {
                    if (b3) {
                        if (n2 == n3) {
                            n = b2.b();
                            if (!i) {
                                break Label_0319;
                            }
                        }
                        if (n2 != n3 + 1) {
                            break Label_0319;
                        }
                        n = (n + b2.b()) * 0.5;
                        if (!i) {
                            break Label_0319;
                        }
                    }
                    if (n2 == n3) {
                        n = b2.b();
                    }
                }
                d = d.g();
                ++n2;
                if (i) {
                    break;
                }
            }
            a.b(n - a3.getCenterX(), 0.0);
            continue;
        }
    }
}
