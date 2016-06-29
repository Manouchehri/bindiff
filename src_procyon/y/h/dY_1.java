package y.h;

import java.awt.geom.*;
import java.awt.*;

class dY implements az
{
    private final Rectangle2D a;
    private final et b;
    
    dY(final et b, final Rectangle2D a) {
        this.b = b;
        this.a = a;
    }
    
    public void a(final Graphics2D graphics2D) {
        this.b.a(graphics2D, this.a);
    }
    
    public Rectangle getBounds() {
        return this.b.b(this.a);
    }
}
