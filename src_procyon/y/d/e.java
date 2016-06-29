package y.d;

import y.c.*;
import java.awt.geom.*;

public final class e
{
    public static int a(final t t, final t t2, final t t3) {
        return a(t.a, t.b, t2.a, t2.b, t3.a, t3.b);
    }
    
    public static int a(final double n, final double n2, double n3, double n4, double n5, double n6) {
        n3 -= n;
        n4 -= n2;
        n5 -= n;
        n6 -= n2;
        final double n7 = n5 * n4 - n6 * n3;
        return (n7 < 0.0) ? 1 : ((n7 > 0.0) ? -1 : 0);
    }
    
    public static boolean b(final t t, final t t2, final t t3) {
        return a(t, t2, t3) > 0;
    }
    
    public static boolean c(final t t, final t t2, final t t3) {
        return a(t, t2, t3) < 0;
    }
    
    public static boolean d(final t t, final t t2, final t t3) {
        return a(t, t2, t3) == 0;
    }
    
    public static D a(final D d) {
        return A.a(d);
    }
    
    public static double a(final double n) {
        return n / 180.0 * 3.141592653589793;
    }
    
    public static double b(final double n) {
        return n * 180.0 / 3.141592653589793;
    }
    
    public static t a(final t t, final z z, final t t2, final z z2) {
        final double a = t.a();
        final double b = t.b();
        final double a2 = t2.a();
        final double b2 = t2.b();
        return a(a, b, a + z.a(), b + z.b(), a2, b2, a2 + z2.a(), b2 + z2.b());
    }
    
    public static t a(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final double n7, final double n8) {
        final double n9 = n4 - n2;
        final double n10 = n - n3;
        final double n11 = n8 - n6;
        final double n12 = n5 - n7;
        final double n13 = n9 * n12 - n11 * n10;
        if (n13 == 0.0) {
            return null;
        }
        final double n14 = n9 * n + n10 * n2;
        final double n15 = n11 * n5 + n12 * n6;
        return new t((n12 * n14 - n10 * n15) / n13, (n9 * n15 - n11 * n14) / n13);
    }
    
    public static t b(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final double n7 = n5 - n3;
        final double n8 = n6 - n4;
        final double n9 = n7 * n7 + n8 * n8;
        double min = 0.0;
        if (n9 != 0.0) {
            min = Math.min(1.0, Math.max(0.0, ((n - n3) * n7 + (n2 - n4) * n8) / n9));
        }
        return new t(n3 * (1.0 - min) + n5 * min, n4 * (1.0 - min) + n6 * min);
    }
    
    public static Rectangle2D a(final Rectangle2D rectangle2D, final Rectangle2D rect, Rectangle2D rectangle2D2) {
        final boolean d = t.d;
        if (rectangle2D2 == null) {
            rectangle2D2 = new Rectangle2D.Double();
        }
        if (rectangle2D2 != rect) {
            rectangle2D2.setRect(rectangle2D);
            if (rectangle2D2.getWidth() < 0.0 || rectangle2D2.getHeight() < 0.0) {
                rectangle2D2.setRect(rect);
                if (!d) {
                    return rectangle2D2;
                }
            }
            if (rect.getWidth() < 0.0 || rect.getHeight() < 0.0) {
                return rectangle2D2;
            }
            rectangle2D2.add(rect);
            if (!d) {
                return rectangle2D2;
            }
        }
        if (rectangle2D2.getWidth() < 0.0 || rectangle2D2.getHeight() < 0.0) {
            rectangle2D2.setRect(rectangle2D);
            if (!d) {
                return rectangle2D2;
            }
        }
        if (rectangle2D.getWidth() >= 0.0 && rectangle2D.getHeight() >= 0.0) {
            rectangle2D2.add(rectangle2D);
        }
        return rectangle2D2;
    }
    
    public static Rectangle2D b(final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, Rectangle2D rectangle2D3) {
        if (rectangle2D3 == null) {
            rectangle2D3 = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        }
        final double x = rectangle2D.getX();
        final double x2 = rectangle2D2.getX();
        final double y = rectangle2D.getY();
        final double y2 = rectangle2D2.getY();
        final double width = rectangle2D.getWidth();
        final double width2 = rectangle2D2.getWidth();
        final double height = rectangle2D.getHeight();
        final double height2 = rectangle2D2.getHeight();
        if (width < 0.0 || height < 0.0 || width2 < 0.0 || height2 < 0.0) {
            rectangle2D3.setRect(0.0, 0.0, -1.0, -1.0);
            if (!t.d) {
                return rectangle2D3;
            }
        }
        final double max = Math.max(x, x2);
        final double max2 = Math.max(y, y2);
        rectangle2D3.setRect(max, max2, Math.min(x + width, x2 + width2) - max, Math.min(y + height, y2 + height2) - max2);
        return rectangle2D3;
    }
}
