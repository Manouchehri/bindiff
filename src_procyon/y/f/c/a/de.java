package y.f.c.a;

import y.f.*;
import y.c.*;

class de
{
    public void a(final X x, final aV av, final byte b, final boolean b2) {
        final boolean x2 = N.x;
        final x o = x.o();
        while (o.f()) {
            final aY i = av.a(o.e()).i();
            if ((i != null && i.b() == b) || (i == null && b2)) {
                this.a(x, o.e(), av);
            }
            o.g();
            if (x2) {
                break;
            }
        }
    }
    
    public void a(final X x, final q q, final aV av) {
        final boolean x2 = N.x;
        final aX a = av.a(q);
        if (a.b() == 0) {
            final S[] a2 = this.a(x, q);
            if (a2 != null && a2.length > 0) {
                final am a3 = x.a((Object)q);
                final double x3 = a3.getX();
                final double y = a3.getY();
                a3.setLocation(0.0, 0.0);
                int i = 0;
                while (i < a2.length) {
                    final S s = a2[i];
                    this.a(a, a3, s.d() + a3.getWidth() * 0.5, s.e() + a3.getHeight() * 0.5, s.b(), s.c(), true);
                    ++i;
                    if (x2) {
                        return;
                    }
                    if (x2) {
                        break;
                    }
                }
                a3.setLocation(x3, y);
            }
        }
    }
    
    protected S[] a(final X x, final q q) {
        final c c = x.c(U.b);
        if (c != null) {
            return (S[])c.b(q);
        }
        return null;
    }
    
    public void a(final aX ax, final am am, final double n, final double n2, final double n3, final double n4, final boolean b) {
        final y.d.c c = b ? ax.a(0, am) : ax.a(0);
        if (c != null) {
            c.a(n, n + n3, n2);
        }
        final y.d.c c2 = b ? ax.a(1, am) : ax.a(1);
        if (c2 != null) {
            c2.b(n2, n2 + n4, n + n3);
        }
        final y.d.c c3 = b ? ax.a(2, am) : ax.a(2);
        if (c3 != null) {
            c3.b(n, n + n3, n2 + n4);
        }
        final y.d.c c4 = b ? ax.a(3, am) : ax.a(3);
        if (c4 != null) {
            c4.a(n2, n2 + n4, n);
        }
    }
}
