package y.h;

import y.d.*;
import java.awt.geom.*;

class fw extends gz
{
    private final fu a;
    
    fw(final fu a, final double n) {
        super(n);
        this.a = a;
    }
    
    public byte a(final t t, final Point2D.Double double1, final byte b) {
        final double x = double1.x;
        final double y = double1.y;
        fu.b(this.a).a(double1);
        return (byte)(((x != double1.x) ? 1 : 0) | ((y != double1.y) ? 2 : 0) | b);
    }
    
    public boolean a(final t t, final t t2, final byte b) {
        return false;
    }
}
