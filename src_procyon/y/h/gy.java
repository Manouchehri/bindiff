package y.h;

import y.d.*;
import java.awt.geom.*;
import java.awt.*;

public class gy implements az
{
    private final byte a;
    private final byte b;
    private final t c;
    private Object d;
    private double e;
    private double f;
    private double g;
    
    public gy(final byte a, final byte b, final t c, final Object d, final double g) {
        this.g = 1.0;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.g = g;
        if (a == 1) {
            this.e = c.b - 1000.0;
            this.f = c.b + 1000.0;
            if (!fj.z) {
                return;
            }
        }
        this.e = c.a - 1000.0;
        this.f = c.a + 1000.0;
    }
    
    public gy(final byte a, final byte b, final t c, final double e, final double f, final Object d, final double g) {
        this.g = 1.0;
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = e;
        this.f = f;
        this.d = d;
        this.g = g;
    }
    
    public double a() {
        return this.g;
    }
    
    public t b() {
        return this.c;
    }
    
    public byte c() {
        return this.a;
    }
    
    public byte d() {
        return this.b;
    }
    
    public double e() {
        return this.e;
    }
    
    public double f() {
        return this.f;
    }
    
    public void a(final double e) {
        this.e = e;
    }
    
    public void b(final double f) {
        this.f = f;
    }
    
    public Rectangle getBounds() {
        final t b = this.b();
        if (this.a == 1) {
            final Line2D.Double double1 = new Line2D.Double(b.a - 5.0, this.e - 10.0, b.a + 5.0, this.f + 10.0);
            if (!fj.z) {
                return double1.getBounds();
            }
        }
        final Line2D.Double double1 = new Line2D.Double(this.e - 10.0, b.b - 5.0, this.f + 10.0, b.b + 5.0);
        return double1.getBounds();
    }
    
    public void a(final Graphics2D graphics2D) {
        final t b = this.b();
        final double a = b.a;
        final double b2 = b.b;
        Line2D.Double double1 = null;
        Label_0127: {
            if (this.a == 1) {
                double1 = new Line2D.Double(a, this.e - 10.0, a, this.f + 10.0);
                a(graphics2D, a, this.e);
                a(graphics2D, a, this.f);
                if (!fj.z) {
                    break Label_0127;
                }
            }
            double1 = new Line2D.Double(this.e - 10.0, b2, this.f + 10.0, b2);
            a(graphics2D, this.e, b2);
            a(graphics2D, this.f, b2);
        }
        graphics2D.draw(double1);
        a(graphics2D, a, b2);
    }
    
    static void a(final Graphics2D graphics2D, final double n, final double n2) {
        graphics2D.draw(new Line2D.Double(n - 3.0, n2 - 3.0, n + 3.0, n2 + 3.0));
        graphics2D.draw(new Line2D.Double(n - 3.0, n2 + 3.0, n + 3.0, n2 - 3.0));
    }
    
    public Object g() {
        return this.d;
    }
}
