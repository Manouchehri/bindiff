package y.h;

import java.awt.geom.*;

class ip implements is
{
    private final Rectangle2D a;
    private final ir b;
    
    ip(final ir b, final Rectangle2D a) {
        this.b = b;
        this.a = a;
    }
    
    public void a(final Line2D line2D) {
        if (this.a.getWidth() < 0.0 || this.a.getHeight() < 0.0) {
            this.a.setFrameFromDiagonal(line2D.getX1(), line2D.getY1(), line2D.getX2(), line2D.getY2());
            if (!fj.z) {
                return;
            }
        }
        this.a.add(line2D.getX1(), line2D.getY1());
        this.a.add(line2D.getX2(), line2D.getY2());
    }
}
