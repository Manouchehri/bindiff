package y.h;

import y.d.*;
import java.awt.geom.*;

class dK extends gz
{
    private final t a;
    private final el c;
    private final dI d;
    
    dK(final dI d, final double n, final az az, final t a, final el c) {
        super(n, az);
        this.d = d;
        this.a = a;
        this.c = c;
    }
    
    public byte a(final t t, final Point2D.Double double1, final byte b) {
        final t a = dI.a(this.d, double1.x, double1.y, dI.b(this.d) / this.d.view.getZoom(), this.d.f, this.c.b(double1.x - this.a.a, double1.y - this.a.b));
        byte b2 = 0;
        if (double1.x != a.a || double1.y != a.b) {
            b2 = 3;
            double1.x = a.a;
            double1.y = a.b;
        }
        return b2;
    }
    
    public boolean a(final t t, final t t2, final byte b) {
        return dI.a(this.d, t2.a, t2.b, dI.b(this.d) / this.d.view.getZoom(), this.d.f, this.c.b(t2.a - this.a.a, t2.b - this.a.b)).equals(t2);
    }
}
