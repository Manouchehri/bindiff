package y.h;

import y.c.*;
import y.d.*;
import java.awt.*;
import java.awt.geom.*;

public class x
{
    private aB c;
    double a;
    double b;
    private boolean d;
    
    public d a() {
        return this.c.getEdge();
    }
    
    public void a(final double a, final double b) {
        final double a2 = this.a;
        final double b2 = this.b;
        this.a = a;
        this.b = b;
        this.c.bendChanged(this, a2, b2);
        this.c.setDirty();
    }
    
    public void b(final double n, final double n2) {
        this.a += n;
        this.b += n2;
        this.c.bendChanged(this, this.a - n, this.b - n2);
        this.c.setDirty();
    }
    
    public double b() {
        return this.a;
    }
    
    public double c() {
        return this.b;
    }
    
    public boolean d() {
        return this.d;
    }
    
    t e() {
        return new t(this.b(), this.c());
    }
    
    public void a(final boolean d) {
        if (d != this.d) {
            this.d = d;
            final bu i = this.c.i();
            if (i != null) {
                i.e(this);
            }
        }
    }
    
    public boolean c(final double n, final double n2) {
        return (this.a - n) * (this.a - n) + (n2 - this.b) * (n2 - this.b) < 25.0;
    }
    
    public boolean a(final double n, final double n2, final double n3, final double n4) {
        return this.a <= n + n3 && this.a >= n && this.b <= n2 + n4 && this.b >= n2;
    }
    
    public void a(final Graphics2D graphics2D) {
        a(graphics2D, this.a, this.b, Color.black);
    }
    
    public static void a(final Graphics2D graphics2D, final double n, final double n2, final Color color) {
        final Color color2 = graphics2D.getColor();
        final Rectangle2D.Double k;
        final Rectangle2D.Double double2;
        final Rectangle2D.Double double1 = double2 = (k = hC.a().k);
        final double n3 = 4.0;
        double2.height = n3;
        k.width = n3;
        final Stroke stroke = graphics2D.getStroke();
        graphics2D.setStroke(dr.a);
        graphics2D.setColor(color);
        double1.x = n - 5.0;
        double1.y = n2 - 5.0;
        graphics2D.fill(double1);
        double1.x = n + 1.0;
        double1.y = n2 + 1.0;
        graphics2D.fill(double1);
        double1.x = n - 5.0;
        double1.y = n2 + 1.0;
        graphics2D.fill(double1);
        double1.x = n + 1.0;
        double1.y = n2 - 5.0;
        graphics2D.fill(double1);
        graphics2D.setColor(color2);
        graphics2D.setStroke(stroke);
    }
    
    protected x(final aB c, final double a, final double b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public String toString() {
        return "(" + this.a + ' ' + this.b + ')';
    }
}
