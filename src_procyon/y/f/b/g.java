package y.f.b;

import java.awt.geom.*;
import y.f.*;
import y.d.*;
import y.c.*;

public class g implements a
{
    private Object a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    
    public g() {
        this(y.f.b.f.e);
    }
    
    public g(final Object a) {
        this.a = a;
        final int n = 15;
        this.e = n;
        this.d = n;
        this.c = n;
        this.b = n;
    }
    
    public boolean a() {
        return this.f;
    }
    
    public Rectangle2D a(final X x, final q q, final y y) {
        return this.a(x, q, y, ae.a(x, x.o(), x.p(), this.a()));
    }
    
    protected Rectangle2D a(final X x, final q q, final y y, final Rectangle2D rectangle2D) {
        double a = this.b;
        double c = this.c;
        double d = this.e;
        double b = this.d;
        if (this.a != null) {
            final c c2 = x.c(this.a);
            if (c2 != null) {
                final r a2 = r.a(c2.b(q));
                if (a2 != null) {
                    a = a2.a;
                    c = a2.c;
                    b = a2.b;
                    d = a2.d;
                }
            }
        }
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        double1.setFrame(rectangle2D.getX() - b, rectangle2D.getY() - a, rectangle2D.getWidth() + b + d, rectangle2D.getHeight() + a + c);
        return double1;
    }
}
