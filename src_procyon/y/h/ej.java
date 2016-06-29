package y.h;

import y.d.*;
import java.awt.geom.*;

class ej extends gz
{
    boolean a;
    private final dU c;
    
    ej(final dU c, final double n, final az az) {
        super(n, az);
        this.c = c;
    }
    
    public boolean a(final t t, final t t2, final byte b) {
        return this.a && t2.a != this.c.k().a && t2.b == this.c.k().b;
    }
    
    public byte a(final t t, final Point2D.Double double1, final byte b) {
        this.a = ((b & 0x2) == 0x0);
        double1.y = this.c.k().b;
        return (byte)(0x2 | b);
    }
}
