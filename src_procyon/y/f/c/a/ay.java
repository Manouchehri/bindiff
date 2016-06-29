package y.f.c.a;

import y.c.*;
import y.f.*;
import y.d.*;

final class ay implements C
{
    public void a(final X x, final aV av) {
        final boolean x2 = N.x;
        final e p2 = x.p();
        while (p2.f()) {
            final d a = p2.a();
            if (av.a(a.c()).j() > av.a(a.d()).j()) {
                this.a(x, av, a);
            }
            p2.g();
            if (x2) {
                break;
            }
        }
    }
    
    public void a(final X x, final aV av, final d d) {
        final boolean x2 = N.x;
        final I b = x.b((Object)d);
        final t sourcePoint = b.getSourcePoint();
        b.setSourcePoint(b.getTargetPoint());
        b.setTargetPoint(sourcePoint);
        Label_0160: {
            if (b.pointCount() > 0) {
                int i = 0;
                int n = b.pointCount() - 1;
                while (i < n) {
                    final t point = b.getPoint(i);
                    final t point2 = b.getPoint(n);
                    b.setPoint(i, point2.a, point2.b);
                    b.setPoint(n, point.a, point.b);
                    ++i;
                    --n;
                    if (x2) {
                        break Label_0160;
                    }
                    if (x2) {
                        break;
                    }
                }
            }
            x.c(d);
        }
        final ai ai = (ai)av.a(d);
        ai.b(!ai.i());
    }
    
    public void b(final X x, final aV av) {
        final boolean x2 = N.x;
        final e p2 = x.p();
        while (p2.f()) {
            final d a = p2.a();
            if (av.a(a).i()) {
                this.a(x, av, a);
            }
            p2.g();
            if (x2) {
                break;
            }
        }
    }
}
