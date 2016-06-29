package y.h;

import y.d.*;
import java.awt.geom.*;
import java.awt.*;

class et extends er
{
    private final double c;
    
    public et(final byte b, final byte b2, final t t, final double n, final double n2, final Object o, final double n3, final double n4, final double n5, final double c) {
        super(b, b2, t, n, n2, o, n3, n4, n5);
        this.c = c;
    }
    
    public az a(final Rectangle2D rectangle2D) {
        return new dY(this, rectangle2D);
    }
    
    public Rectangle b(final Rectangle2D rectangle2D) {
        if (this.c() == 0) {
            final double n = Math.min(rectangle2D.getX(), this.e()) - 8.0;
            final double max = Math.max(rectangle2D.getX(), this.b().a);
            final double n2 = (this.d() == 1) ? rectangle2D.getY() : (rectangle2D.getY() + rectangle2D.getHeight());
            final Rectangle2D.Double double1 = new Rectangle2D.Double(Math.min(n, max), Math.min(Math.min(this.c, n2), Math.min(this.a, this.b)), Math.abs(max - n), 0.0);
            double1.height = Math.max(Math.max(this.c, n2), Math.max(this.a, this.b)) - double1.y;
            final Rectangle bounds = double1.getBounds();
            bounds.grow(20, 20);
            return bounds;
        }
        final double n3 = (this.d() == 4) ? rectangle2D.getX() : (rectangle2D.getX() + rectangle2D.getWidth());
        final double n4 = Math.min(rectangle2D.getY(), this.e()) - 8.0;
        final double max2 = Math.max(rectangle2D.getY(), this.b().b);
        final Rectangle2D.Double double2 = new Rectangle2D.Double(Math.min(Math.min(this.c, n3), Math.min(this.a, this.b)), Math.min(n4, max2), 0.0, Math.abs(max2 - n4));
        double2.width = Math.max(Math.max(this.c, n3), Math.max(this.a, this.b)) - double2.x;
        final Rectangle bounds2 = double2.getBounds();
        bounds2.grow(20, 20);
        return bounds2;
    }
    
    public void a(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        Label_0133: {
            if (this.c() == 0) {
                n = Math.min(rectangle2D.getX(), this.e()) - 8.0;
                n2 = Math.max(rectangle2D.getX(), this.b().a);
                n3 = ((this.d() == 1) ? rectangle2D.getY() : (rectangle2D.getY() + rectangle2D.getHeight()));
                if (!z) {
                    break Label_0133;
                }
            }
            n3 = ((this.d() == 4) ? rectangle2D.getX() : (rectangle2D.getX() + rectangle2D.getWidth()));
            n = Math.min(rectangle2D.getY(), this.e()) - 8.0;
            n2 = Math.max(rectangle2D.getY(), this.b().b);
        }
        if (this.c() == 0) {
            graphics2D.draw(new Line2D.Double(n, this.a, n2, this.a));
            graphics2D.draw(new Line2D.Double(n, this.b, n2, this.b));
            graphics2D.draw(new Line2D.Double(n, this.c, n2, this.c));
            graphics2D.draw(new Line2D.Double(n, n3, n2, n3));
            y.h.e.a(graphics2D, n, this.a, n, this.b);
            y.h.e.a(graphics2D, n, this.c, n, n3);
            if (!z) {
                return;
            }
        }
        graphics2D.draw(new Line2D.Double(this.a, n, this.a, n2));
        graphics2D.draw(new Line2D.Double(this.b, n, this.b, n2));
        graphics2D.draw(new Line2D.Double(this.c, n, this.c, n2));
        graphics2D.draw(new Line2D.Double(n3, n, n3, n2));
        y.h.e.a(graphics2D, this.a, n, this.b, n);
        y.h.e.a(graphics2D, this.c, n, n3, n);
    }
}
