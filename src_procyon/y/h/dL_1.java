package y.h;

import y.d.*;
import java.awt.geom.*;

class dL extends gz
{
    private final dI a;
    
    dL(final dI a, final double n) {
        super(n);
        this.a = a;
    }
    
    public boolean a(final t t, final t t2, final byte b) {
        final t a = dI.a(this.a, t.a, t.b, dI.b(this.a));
        return a != null && a.equals(t2);
    }
    
    public byte a(final t t, final Point2D.Double double1, final byte b) {
        final t a = dI.a(this.a, t.a, t.b, dI.b(this.a));
        if (a != null) {
            double1.x = a.a;
            double1.y = a.b;
            return 3;
        }
        return b;
    }
}
