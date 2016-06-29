package y.h;

import java.awt.*;

class cT extends Rectangle implements az
{
    public double a;
    private final cS b;
    
    cT(final cS b) {
        this.b = b;
    }
    
    public void a(final Graphics2D graphics2D) {
        cS.a(this.b).paintZoomIndicator(graphics2D, this.x, this.y, this.width, this.height, this.a, cS.a(this.b).lastMouseWheelEvent);
    }
}
