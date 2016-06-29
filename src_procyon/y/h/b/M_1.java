package y.h.b;

import y.h.*;
import java.awt.*;
import java.awt.geom.*;
import y.d.*;

abstract class M extends b
{
    private final boolean a;
    
    M(final boolean a) {
        this.a = a;
    }
    
    public void a(final fj fj, final Graphics2D graphics2D) {
        if (fj.isVisible()) {
            this.a(graphics2D);
            try {
                this.a(fj, graphics2D, false);
            }
            finally {
                this.b(graphics2D);
            }
        }
    }
    
    protected void a(final fj fj, final Graphics2D graphics2D, final boolean b) {
        final int h = y.h.b.a.H;
        final Rectangle2D e = J.e(fj);
        final double x = e.getX();
        final double y = e.getY();
        final double width = e.getWidth();
        final double height = e.getHeight();
        final a a = J.a(fj);
        final Y b2 = this.b(fj);
        final r a2 = this.a(fj);
        if ((a2.a > 0.0 || a2.b > 0.0 || a2.c > 0.0 || a2.d > 0.0) && (b2.c(a) != null || (b2.a(a) != null && b2.b(a) != null))) {
            final double n = x + a2.b;
            final double n2 = y + a2.a;
            final double n3 = width - a2.b - a2.d;
            final double n4 = height - a2.a - a2.c;
            Label_0337: {
                if (this.a) {
                    if (b2.a(a) == null || b2.b(a) == null) {
                        break Label_0337;
                    }
                    e.setFrame(x, y, width, height);
                    graphics2D.setStroke(b2.a(a));
                    graphics2D.setColor(b2.b(a));
                    graphics2D.draw(e);
                    if (h == 0) {
                        break Label_0337;
                    }
                }
                if (b2.c(a) != null) {
                    final Area area = new Area(e);
                    e.setFrame(n, n2, n3, n4);
                    area.subtract(new Area(e));
                    graphics2D.setColor(b2.c(a));
                    graphics2D.fill(area);
                }
            }
            e.setFrame(n, n2, n3, n4);
        }
        if (this.a) {
            if (b2.d(a) == null || b2.e(a) == null) {
                return;
            }
            graphics2D.setStroke(b2.d(a));
            graphics2D.setColor(b2.e(a));
            graphics2D.draw(e);
            if (h == 0) {
                return;
            }
        }
        if (b2.f(a) != null) {
            graphics2D.setColor(b2.f(a));
            graphics2D.fill(e);
        }
    }
    
    abstract r a(final fj p0);
    
    abstract Y b(final fj p0);
}
