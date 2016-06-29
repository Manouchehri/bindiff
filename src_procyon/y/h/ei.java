package y.h;

import y.d.*;
import java.awt.geom.*;
import java.awt.*;

class ei implements az
{
    private final t a;
    private final dU b;
    
    ei(final dU b, final t a) {
        this.b = b;
        this.a = a;
    }
    
    public void a(final Graphics2D graphics2D) {
        graphics2D.draw(new Line2D.Double(Math.min(this.b.k().a, this.a.a) - 60.0, this.b.k().b, Math.max(this.b.k().a, this.a.a) + 60.0, this.b.k().b));
        gy.a(graphics2D, this.b.k().a, this.b.k().b);
    }
    
    public Rectangle getBounds() {
        final double min = Math.min(this.b.k().a, this.a.a);
        return new Rectangle((int)(min - 60.0 - 10.0), (int)(this.b.k().b - 20.0), (int)(Math.max(this.b.k().a, this.a.a) - min + 130.0), 40);
    }
}
