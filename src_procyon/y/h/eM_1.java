package y.h;

import java.awt.geom.*;

abstract class eM implements eI
{
    eM g;
    eM h;
    
    abstract int a(final double[] p0, final AffineTransform p1);
    
    abstract int a(final float[] p0, final AffineTransform p1);
    
    public eI b() {
        return this.g;
    }
}
