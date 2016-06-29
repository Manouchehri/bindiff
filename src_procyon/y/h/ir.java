package y.h;

import java.awt.*;
import java.awt.geom.*;
import y.d.*;
import java.util.*;

class ir implements az
{
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private dh e;
    private boolean f;
    private final List g;
    
    ir(final double a, final double b, final double c, final double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.g = new ArrayList(3);
        this.f = true;
    }
    
    ir() {
        this.a = 0.0;
        this.b = 0.0;
        this.c = 0.0;
        this.d = 0.0;
        this.g = new ArrayList(1);
        this.f = false;
    }
    
    public void a(final Graphics2D graphics2D) {
        final Color color = graphics2D.getColor();
        final Stroke stroke = graphics2D.getStroke();
        graphics2D.setColor(this.a());
        graphics2D.setStroke(new BasicStroke());
        this.a(new io(this, graphics2D));
        graphics2D.setColor(color);
        graphics2D.setStroke(stroke);
    }
    
    public Rectangle getBounds() {
        final Rectangle2D.Double double1 = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        this.a(new ip(this, double1));
        if (double1.getWidth() >= 0.0 && double1.getHeight() >= 0.0) {
            double1.setFrame(double1.getX() - 2.0, double1.getY() - 2.0, double1.getWidth() + 4.0, double1.getHeight() + 4.0);
        }
        return double1.getBounds();
    }
    
    void a(final t t) {
        this.g.add(t);
    }
    
    void a(final dh e) {
        this.e = e;
    }
    
    Color a() {
        if (this.e == null) {
            return Color.LIGHT_GRAY;
        }
        return this.e.a();
    }
    
    void a(final is is) {
        final boolean z = fj.z;
        final Line2D.Double double1 = new Line2D.Double();
        z z2 = null;
        Label_0126: {
            if (this.f) {
                z2 = new z(this.c - this.a, this.d - this.b);
                z2.c();
                final double n = 10.0 * z2.a();
                final double n2 = 10.0 * z2.b();
                double1.setLine(this.a - n, this.b - n2, this.c + n, this.d + n2);
                is.a(double1);
                if (!z) {
                    break Label_0126;
                }
            }
            z2 = new z(0.0, -1.0);
        }
        final double a = z2.a();
        final double b = z2.b();
        if (!this.g.isEmpty()) {
            for (final t t : this.g) {
                final double n3 = t.a() - 3.0 * (a - b);
                final double n4 = t.b() - 3.0 * (a + b);
                final double n5 = n3 + a * 6.0;
                final double n6 = n4 + b * 6.0;
                final double n7 = n3 + a * 6.0 - b * 6.0;
                final double n8 = n4 + b * 6.0 + a * 6.0;
                final double n9 = n3 - b * 6.0;
                final double n10 = n4 + a * 6.0;
                double1.setLine(n3, n4, n7, n8);
                is.a(double1);
                double1.setLine(n5, n6, n9, n10);
                is.a(double1);
                if (z) {
                    break;
                }
            }
        }
    }
}
