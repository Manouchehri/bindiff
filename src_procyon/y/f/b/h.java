package y.f.b;

import y.f.*;
import java.awt.geom.*;
import y.c.*;

public class h extends g
{
    private Object a;
    private double b;
    private double c;
    private double d;
    private double e;
    
    public h() {
        this(y.f.b.f.f);
    }
    
    public h(final Object a) {
        this.d = 0.5;
        this.e = 0.5;
        this.a = a;
    }
    
    public Rectangle2D a(final X x, final q q, final y y) {
        double n = this.b;
        double n2 = this.c;
        if (this.a != null) {
            final c c = x.c(this.a);
            if (c != null) {
                final y.d.q q2 = (y.d.q)c.b(q);
                if (q2 != null) {
                    n = q2.a;
                    n2 = q2.b;
                }
            }
        }
        final Rectangle2D a = super.a(x, q, y);
        double x2 = a.getX();
        double y2 = a.getY();
        double width = a.getWidth();
        double height = a.getHeight();
        if (width < n) {
            x2 -= this.d * (n - width);
            width = n;
        }
        if (height < n2) {
            y2 -= this.e * (n2 - height);
            height = n2;
        }
        a.setFrame(x2, y2, width, height);
        return a;
    }
}
