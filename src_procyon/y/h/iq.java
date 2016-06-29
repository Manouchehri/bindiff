package y.h;

import y.d.*;
import java.awt.geom.*;

class iq extends gz
{
    private final gv a;
    private final t c;
    
    iq(final gv a, final t c, final ir ir) {
        super(1.0, ir);
        this.a = a;
        this.c = c;
    }
    
    public byte a(final t t, final Point2D.Double double1, final byte b) {
        double1.x = this.c.a();
        double1.y = this.c.b();
        return 3;
    }
    
    public boolean a(final t t, final t t2, final byte b) {
        return t2.a == this.c.a() && t2.b == this.c.b();
    }
    
    gv c() {
        return this.a;
    }
}
