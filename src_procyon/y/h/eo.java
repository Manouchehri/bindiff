package y.h;

import y.d.*;
import java.awt.geom.*;
import java.awt.*;

class eo extends gy implements id
{
    eo(final byte b, final byte b2, final t t, final double n, final double n2, final Object o, final double n3) {
        super(b, b2, t, n, n2, o, n3);
    }
    
    eo(final byte b, final byte b2, final t t, final Object o, final double n) {
        super(b, b2, t, o, n);
    }
    
    public az a(final Rectangle2D rectangle2D) {
        return new dW(this, rectangle2D);
    }
    
    protected Rectangle b(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        final double a;
        double n = a = this.b().a;
        final double b;
        double n2 = b = this.b().b;
        Label_0124: {
            switch (this.d()) {
                default: {
                    if (this.c() == 0) {
                        n = rectangle2D.getCenterX();
                        if (!z) {
                            break;
                        }
                    }
                    n2 = rectangle2D.getCenterY();
                    if (z) {
                        break Label_0124;
                    }
                    break;
                }
                case 4:
                case 8: {
                    n2 = rectangle2D.getCenterY();
                    if (z) {
                        break Label_0124;
                    }
                    break;
                }
                case 1:
                case 2: {
                    n = rectangle2D.getCenterX();
                    break;
                }
            }
        }
        final Rectangle rectangle = new Rectangle((int)a, (int)b, 0, 0);
        rectangle.add(n, n2);
        rectangle.grow(22, 22);
        return rectangle;
    }
    
    protected void a(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        final double a;
        double n = a = this.b().a;
        final double b;
        double n2 = b = this.b().b;
        boolean b2 = false;
        Label_0133: {
            switch (this.d()) {
                default: {
                    if (this.c() == 0) {
                        n = rectangle2D.getCenterX();
                        b2 = true;
                        if (!z) {
                            break;
                        }
                    }
                    n2 = rectangle2D.getCenterY();
                    b2 = false;
                    if (z) {
                        break Label_0133;
                    }
                    break;
                }
                case 4:
                case 8: {
                    n2 = rectangle2D.getCenterY();
                    b2 = false;
                    if (z) {
                        break Label_0133;
                    }
                    break;
                }
                case 1:
                case 2: {
                    b2 = true;
                    n = rectangle2D.getCenterX();
                    break;
                }
            }
        }
        Label_0223: {
            if (b2) {
                graphics2D.draw(new Line2D.Double(Math.min(a, n) - 20.0, b, Math.max(a, n) + 20.0, n2));
                if (!z) {
                    break Label_0223;
                }
            }
            graphics2D.draw(new Line2D.Double(a, Math.min(b, n2) - 20.0, n, Math.max(b, n2) + 20.0));
        }
        gy.a(graphics2D, a, b);
        gy.a(graphics2D, n, n2);
    }
}
