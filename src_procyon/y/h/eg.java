package y.h;

import y.d.*;
import java.awt.geom.*;
import java.awt.*;

class eg implements az
{
    private final t a;
    private final dU b;
    
    eg(final dU b, final t a) {
        this.b = b;
        this.a = a;
    }
    
    public void a(final Graphics2D graphics2D) {
        graphics2D.draw(new Line2D.Double(this.b.k().a, Math.min(this.b.k().b, this.a.b) - 60.0, this.b.k().a, Math.max(this.b.k().b, this.a.b) + 60.0));
        gy.a(graphics2D, this.b.k().a, this.b.k().b);
    }
    
    public Rectangle getBounds() {
        final double min = Math.min(this.b.k().b, this.a.b);
        return new Rectangle((int)(this.b.k().a - 10.0), (int)(min - 60.0 - 10.0), 20, (int)(Math.max(this.b.k().b, this.a.b) - min + 140.0));
    }
}
