package y.h;

import y.d.*;
import java.awt.geom.*;
import java.awt.*;

class di extends gy
{
    di(final byte b, final t t, final double n, final double n2) {
        super(b, (byte)16, t, n, n2, null, 0.5);
    }
    
    public void a(final Graphics2D graphics2D) {
        final t b = this.b();
        final double a = b.a;
        final double b2 = b.b;
        final double e = this.e();
        final double f = this.f();
        Line2D.Double double1 = null;
        Label_0091: {
            if (this.c() == 1) {
                double1 = new Line2D.Double(a, e - 10.0, a, f + 10.0);
                if (!fj.z) {
                    break Label_0091;
                }
            }
            double1 = new Line2D.Double(e - 10.0, b2, f + 10.0, b2);
        }
        graphics2D.draw(double1);
        gy.a(graphics2D, a, b2);
    }
}
