package y.f.e.a;

import y.f.b.*;
import y.c.*;

final class B implements am
{
    private final z a;
    
    B(final z a) {
        this.a = a;
    }
    
    public void a(final l l, final af af) {
        final boolean b = af.b;
        final c a = this.a.a;
        if (a != null) {
            p p2 = this.a.b.l();
            while (p2 != null) {
                final q q = (q)p2.c();
                Label_0349: {
                    if (a.d(q) && !af.a(q).n()) {
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
                            final double b3 = a2.b();
                            final double c = a2.c();
                            final double d = a2.d();
                            final double h = a2.h();
                            min = Math.min(min, b3 - h);
                            max = Math.max(max, b3 + h);
                            min2 = Math.min(min2, c - h);
                            max2 = Math.max(max2, c + h);
                            min3 = Math.min(min3, d - h);
                            max3 = Math.max(max3, d + h);
                            p3 = p3.a();
                            if (b) {
                                break Label_0349;
                            }
                            if (b) {
                                break;
                            }
                        }
                        final ag c2 = af.c(q);
                        c2.f(c2.h() * 0.4 + Math.max(50.0, Math.max(Math.max((max - min) / 2.0, (max2 - min2) / 2.0), (max3 - min3) / 2.0)) * 0.6);
                    }
                    p2 = p2.b();
                }
                if (b) {
                    break;
                }
            }
        }
    }
}
