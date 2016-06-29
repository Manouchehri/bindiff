package y.h;

import y.d.*;
import java.awt.geom.*;
import java.awt.*;

class ex extends eo
{
    private final double a;
    
    ex(final byte b, final byte b2, final t t, final double n, final double n2, final Object o, final double n3, final double a) {
        super(b, b2, t, n, n2, o, n3);
        this.a = a;
    }
    
    protected Rectangle b(final Rectangle2D rectangle2D) {
        final Rectangle b = super.b(rectangle2D);
        b.grow((int)this.a, (int)this.a);
        return b;
    }
    
    protected void a(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        final t b = this.b();
        Label_0399: {
            switch (this.d()) {
                case 1: {
                    final double max = Math.max(this.e(), rectangle2D.getX());
                    final double min = Math.min(this.f(), rectangle2D.getX() + rectangle2D.getWidth());
                    y.h.e.a(graphics2D, (max + min) * 0.5, b.b, (max + min) * 0.5, b.b - this.a);
                    graphics2D.draw(new Line2D.Double(b.a, b.b - this.a, (max + min) * 0.5, b.b - this.a));
                    if (z) {
                        break Label_0399;
                    }
                    break;
                }
                case 2: {
                    final double max2 = Math.max(this.e(), rectangle2D.getX());
                    final double min2 = Math.min(this.f(), rectangle2D.getX() + rectangle2D.getWidth());
                    y.h.e.a(graphics2D, (max2 + min2) * 0.5, b.b, (max2 + min2) * 0.5, b.b + this.a);
                    graphics2D.draw(new Line2D.Double(b.a, b.b + this.a, (max2 + min2) * 0.5, b.b + this.a));
                    if (z) {
                        break Label_0399;
                    }
                    break;
                }
                case 4: {
                    final double max3 = Math.max(this.e(), rectangle2D.getY());
                    final double min3 = Math.min(this.f(), rectangle2D.getY() + rectangle2D.getHeight());
                    y.h.e.a(graphics2D, b.a, (max3 + min3) * 0.5, b.a - this.a, (max3 + min3) * 0.5);
                    graphics2D.draw(new Line2D.Double(b.a - this.a, b.b, b.a - this.a, (max3 + min3) * 0.5));
                    if (z) {
                        break Label_0399;
                    }
                    break;
                }
                case 8: {
                    final double max4 = Math.max(this.e(), rectangle2D.getY());
                    final double min4 = Math.min(this.f(), rectangle2D.getY() + rectangle2D.getHeight());
                    y.h.e.a(graphics2D, b.a, (max4 + min4) * 0.5, b.a + this.a, (max4 + min4) * 0.5);
                    graphics2D.draw(new Line2D.Double(b.a + this.a, b.b, b.a + this.a, (max4 + min4) * 0.5));
                    break;
                }
            }
        }
    }
}
