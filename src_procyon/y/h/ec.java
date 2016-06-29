package y.h;

import java.awt.*;
import java.awt.geom.*;

class ec implements az
{
    private final double a;
    private final double b;
    private final dV c;
    
    ec(final dV c, final double a, final double b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public void a(final Graphics2D graphics2D) {
        final double a = ev.a(dV.a(this.c)).a(this.a);
        final double b = ev.a(dV.a(this.c)).b(this.b);
        graphics2D.setStroke(dr.c);
        graphics2D.draw(new Line2D.Double(ev.b(dV.a(this.c)).a(this.a), ev.b(dV.a(this.c)).b(this.b), a, b));
        graphics2D.setStroke(dr.a);
    }
    
    public Rectangle getBounds() {
        final Rectangle2D.Double double1 = new Rectangle2D.Double(ev.a(dV.a(this.c)).a(this.a), ev.a(dV.a(this.c)).b(this.b), 0.0, 0.0);
        double1.add(ev.b(dV.a(this.c)).a(this.a), ev.b(dV.a(this.c)).b(this.b));
        final Rectangle bounds = double1.getBounds();
        bounds.grow(5, 5);
        return bounds;
    }
}
