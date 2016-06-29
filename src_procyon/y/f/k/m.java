package y.f.k;

import java.awt.geom.*;
import java.util.*;

public abstract class m
{
    public static final m a;
    public static final m b;
    public static final m c;
    public static final m d;
    public static final m e;
    public static final m f;
    public static final m g;
    public static final m[] h;
    
    final void a(final P p3, final List list, final double n) {
        this.a(p3, list, a(list), n);
    }
    
    protected abstract void a(final P p0, final List p1, final Rectangle2D p2, final double p3);
    
    protected static Rectangle2D a(final List list) {
        final int g = y.f.k.d.g;
        final Rectangle2D.Double double1 = new Rectangle2D.Double(Double.MAX_VALUE, Double.MAX_VALUE, 0.0, 0.0);
        Rectangle2D.Double double2 = null;
        for (final P p : list) {
            final double f = p.f();
            if (f < double1.x) {
                double1.x = f;
            }
            final double g2 = p.g();
            if (g2 < double1.y) {
                double1.y = g2;
            }
            final double e = p.e();
            if (e > double1.x + double1.width) {
                double1.width = e - double1.x;
            }
            final double d = p.d();
            if (d > double1.y + double1.height) {
                double2 = double1;
                if (g != 0) {
                    return double2;
                }
                double2.height = d - double1.y;
                if (g != 0) {
                    break;
                }
                continue;
            }
        }
        return double2;
    }
    
    static {
        a = new e();
        b = new f();
        c = new g();
        d = new h();
        e = new i();
        f = new j();
        g = new k();
        h = new m[] { m.a, m.g, m.c, m.e, m.f, m.d };
    }
}
