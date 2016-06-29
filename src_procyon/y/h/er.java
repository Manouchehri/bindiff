package y.h;

import y.d.*;
import java.awt.geom.*;
import java.awt.*;

class er extends gy implements id
{
    protected final double a;
    protected final double b;
    
    public er(final byte b, final byte b2, final t t, final double n, final double n2, final Object o, final double n3, final double a, final double b3) {
        super(b, b2, t, n, n2, o, n3);
        this.a = a;
        this.b = b3;
    }
    
    public az a(final Rectangle2D rectangle2D) {
        return new dX(this, rectangle2D);
    }
    
    public Rectangle b(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        if (this.c() == 0) {
            double n = 0.0;
            double n2 = 0.0;
            Label_0108: {
                if (rectangle2D.getCenterX() < this.b().a) {
                    n = Math.min(rectangle2D.getX(), this.e()) - 8.0;
                    n2 = Math.max(rectangle2D.getX(), this.b().a);
                    if (!z) {
                        break Label_0108;
                    }
                }
                n2 = Math.min(rectangle2D.getX() + rectangle2D.getWidth(), this.b().a);
                n = Math.max(rectangle2D.getX() + rectangle2D.getWidth(), this.f()) + 8.0;
            }
            final double a = this.a;
            final double b = this.b;
            final double y = rectangle2D.getY();
            final double n3 = y + rectangle2D.getHeight();
            final Rectangle2D.Double double1 = new Rectangle2D.Double(Math.min(n, n2), Math.min(Math.min(y, n3), Math.min(a, b)), Math.abs(n2 - n), 0.0);
            double1.height = Math.max(Math.max(y, n3), Math.max(a, b)) - double1.y;
            final Rectangle bounds = double1.getBounds();
            bounds.grow(20, 20);
            return bounds;
        }
        final double a2 = this.a;
        final double b2 = this.b;
        final double x = rectangle2D.getX();
        final double n4 = rectangle2D.getX() + rectangle2D.getWidth();
        double n5 = 0.0;
        double n6 = 0.0;
        Label_0345: {
            if (rectangle2D.getCenterY() < this.b().b) {
                n5 = Math.min(rectangle2D.getY(), this.e()) - 8.0;
                n6 = Math.max(rectangle2D.getY(), this.b().b);
                if (!z) {
                    break Label_0345;
                }
            }
            n6 = Math.min(rectangle2D.getY() + rectangle2D.getHeight(), this.b().b);
            n5 = Math.max(rectangle2D.getY() + rectangle2D.getHeight(), this.f()) + 8.0;
        }
        final Rectangle2D.Double double2 = new Rectangle2D.Double(Math.min(Math.min(x, n4), Math.min(a2, b2)), Math.min(n5, n6), 0.0, Math.abs(n6 - n5));
        double2.width = Math.max(Math.max(x, n4), Math.max(a2, b2)) - double2.x;
        final Rectangle bounds2 = double2.getBounds();
        bounds2.grow(20, 20);
        return bounds2;
    }
    
    public void a(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        double n4 = 0.0;
        double n5 = 0.0;
        double n6 = 0.0;
        Label_0263: {
            if (this.c() == 0) {
                Label_0108: {
                    if (rectangle2D.getCenterX() < this.b().a) {
                        n = Math.min(rectangle2D.getX(), this.e()) - 8.0;
                        n2 = Math.max(rectangle2D.getX(), this.b().a);
                        if (!z) {
                            break Label_0108;
                        }
                    }
                    n2 = Math.min(rectangle2D.getX() + rectangle2D.getWidth(), this.b().a);
                    n = Math.max(rectangle2D.getX() + rectangle2D.getWidth(), this.f()) + 8.0;
                }
                n3 = this.a;
                n4 = this.b;
                n5 = rectangle2D.getY();
                n6 = n5 + rectangle2D.getHeight();
                if (!z) {
                    break Label_0263;
                }
            }
            n3 = this.a;
            n4 = this.b;
            n5 = rectangle2D.getX();
            n6 = rectangle2D.getX() + rectangle2D.getWidth();
            if (rectangle2D.getCenterY() < this.b().b) {
                n = Math.min(rectangle2D.getY(), this.e()) - 8.0;
                n2 = Math.max(rectangle2D.getY(), this.b().b);
                if (!z) {
                    break Label_0263;
                }
            }
            n2 = Math.min(rectangle2D.getY() + rectangle2D.getHeight(), this.b().b);
            n = Math.max(rectangle2D.getY() + rectangle2D.getHeight(), this.f()) + 8.0;
        }
        if (this.c() == 0) {
            graphics2D.draw(new Line2D.Double(n, n3, n2, n3));
            graphics2D.draw(new Line2D.Double(n, n4, n2, n4));
            graphics2D.draw(new Line2D.Double(n, n5, n2, n5));
            graphics2D.draw(new Line2D.Double(n, n6, n2, n6));
            y.h.e.a(graphics2D, n, n3, n, n5);
            y.h.e.a(graphics2D, n, n6, n, n4);
            if (!z) {
                return;
            }
        }
        graphics2D.draw(new Line2D.Double(n3, n, n3, n2));
        graphics2D.draw(new Line2D.Double(n4, n, n4, n2));
        graphics2D.draw(new Line2D.Double(n5, n, n5, n2));
        graphics2D.draw(new Line2D.Double(n6, n, n6, n2));
        y.h.e.a(graphics2D, n3, n, n5, n);
        y.h.e.a(graphics2D, n4, n, n6, n);
    }
}
