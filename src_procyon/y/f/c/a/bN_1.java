package y.f.c.a;

import y.c.*;
import y.d.*;
import y.f.*;

class bN implements z
{
    public double a(final X x, final aQ aq, final aV av, final q q, final q q2) {
        if (q == null || q2 == null) {
            double n = 0.0;
            if (q2 != null) {
                final aX a = av.a(q2);
                x.a((Object)q2);
                final c a2 = a.a(3);
                if (a.i() != null) {
                    n = Math.max(n, a.i().d());
                }
                if (a2 != null) {
                    n = Math.max(n, -a2.c());
                }
            }
            if (q != null) {
                final aX a3 = av.a(q);
                final am a4 = x.a((Object)q);
                final c a5 = a3.a(1);
                if (a3.i() != null) {
                    n = Math.max(n, a3.i().d());
                }
                if (a5 != null) {
                    n = Math.max(n, a5.d() - a4.getWidth());
                }
            }
            return n;
        }
        final aX a6 = av.a(q2);
        final am a7 = x.a((Object)q2);
        final aX a8 = av.a(q);
        final am a9 = x.a((Object)q);
        final c a10 = a6.a(3);
        final c a11 = a8.a(1);
        double n2 = 0.0;
        if (a10 != null) {
            final double y = a7.getY();
            final double x2 = a7.getX();
            n2 = Math.max(n2, -a10.c());
            if (a11 == null) {
                return n2;
            }
            a10.b(y);
            a10.a(x2);
            final double x3 = a9.getX();
            final double y2 = a9.getY();
            n2 = Math.max(n2, a11.d() - a9.getWidth());
            a11.b(y2);
            a11.a(x3);
            final double c = a11.c(a10);
            if (c != Double.MAX_VALUE) {
                n2 = Math.max(n2, a7.getX() - (a9.getX() + a9.getWidth()) - c);
            }
            a11.a(-x3);
            a11.b(-y2);
            a10.a(-x2);
            a10.b(-y);
            if (!N.x) {
                return n2;
            }
        }
        if (a11 != null) {
            n2 = Math.max(n2, a11.d() - a9.getWidth());
        }
        return n2;
    }
    
    public void b(final X x, final aU au, final aV av) {
    }
    
    public void a(final X x, final aU au, final aV av) {
    }
}
