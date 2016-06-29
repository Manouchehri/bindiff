package y.h;

import y.d.*;
import java.awt.geom.*;

class dT extends gz
{
    private final dP a;
    
    dT(final dP a, final double n) {
        super(n);
        this.a = a;
    }
    
    public byte a(final t t, final Point2D.Double double1, final byte b) {
        if (this.a.isGridMode()) {
            final double a = t.a;
            final double b2 = t.b;
            final double gridX = this.a.getGridX(a);
            final double gridY = this.a.getGridY(b2);
            double1.x = gridX;
            double1.y = gridY;
            return 3;
        }
        return b;
    }
    
    public boolean a(final t t, final t t2, final byte b) {
        return this.a.isGridMode();
    }
}
