package y.h;

import y.d.*;
import java.awt.geom.*;

class gC extends gz
{
    private final boolean a;
    private final double c;
    
    public gC(final double n, final az az, final boolean a, final double c, final Object o) {
        super(n, az, o);
        this.a = a;
        this.c = c;
    }
    
    public byte a(final t t, final Point2D.Double double1, final byte b) {
        if (this.a) {
            double1.x = this.c;
            return (byte)(0x1 | b);
        }
        double1.y = this.c;
        return (byte)(0x2 | b);
    }
    
    public boolean a(final t t, final t t2, final byte b) {
        if (this.a) {
            return t2.a == this.c;
        }
        return t2.b == this.c;
    }
}
