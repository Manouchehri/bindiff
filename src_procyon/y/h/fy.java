package y.h;

import y.d.*;
import java.awt.geom.*;

class fy extends gz
{
    private final fA a;
    private final byte c;
    private final fu d;
    
    fy(final fu d, final double n, final fA a, final byte c) {
        super(n);
        this.d = d;
        this.a = a;
        this.c = c;
    }
    
    public boolean a(final t t, final t t2, final byte b) {
        return false;
    }
    
    public byte a(final t t, final Point2D.Double double1, final byte b) {
        final double x = double1.x;
        final double y = double1.y;
        final double n = x - fu.e(this.d).a;
        final double n2 = y - fu.e(this.d).b;
        final t c = this.a.c(n, n2);
        final fC fc = new fC(fu.e(this.d), x, y);
        final t b2 = this.a.b();
        Label_0147: {
            switch (this.c) {
                case 0: {
                    double1.setLocation(x, fc.b.a(c.b() - b2.b()));
                    if (fj.z) {
                        break Label_0147;
                    }
                    break;
                }
                case 1: {
                    double1.setLocation(fc.a.a(c.a() - b2.a()), y);
                    break;
                }
            }
        }
        if (n != c.a()) {
            if (n2 != c.b()) {
                return 3;
            }
            return 1;
        }
        else {
            if (n2 != c.b()) {
                return 2;
            }
            return 0;
        }
    }
}
