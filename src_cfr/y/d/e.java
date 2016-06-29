/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import java.awt.geom.Rectangle2D;
import y.c.D;
import y.d.A;
import y.d.t;
import y.d.z;

public final class e {
    public static int a(t t2, t t3, t t4) {
        return e.a(t2.a, t2.b, t3.a, t3.b, t4.a, t4.b);
    }

    public static int a(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = (d6 -= d2) * (d5 -= d3) - (d7 -= d3) * (d4 -= d2);
        if (d8 < 0.0) {
            return 1;
        }
        if (d8 <= 0.0) return 0;
        return -1;
    }

    public static boolean b(t t2, t t3, t t4) {
        if (e.a(t2, t3, t4) <= 0) return false;
        return true;
    }

    public static boolean c(t t2, t t3, t t4) {
        if (e.a(t2, t3, t4) >= 0) return false;
        return true;
    }

    public static boolean d(t t2, t t3, t t4) {
        if (e.a(t2, t3, t4) != 0) return false;
        return true;
    }

    public static D a(D d2) {
        return A.a(d2);
    }

    public static double a(double d2) {
        return d2 / 180.0 * 3.141592653589793;
    }

    public static double b(double d2) {
        return d2 * 180.0 / 3.141592653589793;
    }

    public static t a(t t2, z z2, t t3, z z3) {
        double d2 = t2.a();
        double d3 = t2.b();
        double d4 = t3.a();
        double d5 = t3.b();
        return e.a(d2, d3, d2 + z2.a(), d3 + z2.b(), d4, d5, d4 + z3.a(), d5 + z3.b());
    }

    public static t a(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d5 - d3;
        double d11 = d6 - d8;
        double d12 = d9 - d7;
        double d13 = d2 - d4;
        double d14 = d10 * d11 - d12 * d13;
        if (d14 == 0.0) {
            return null;
        }
        double d15 = d10 * d2 + d13 * d3;
        double d16 = d12 * d6 + d11 * d7;
        double d17 = (d11 * d15 - d13 * d16) / d14;
        double d18 = (d10 * d16 - d12 * d15) / d14;
        return new t(d17, d18);
    }

    public static t b(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d6 - d4;
        double d9 = d7 - d5;
        double d10 = d8 * d8 + d9 * d9;
        double d11 = 0.0;
        if (d10 == 0.0) return new t(d4 * (1.0 - d11) + d6 * d11, d5 * (1.0 - d11) + d7 * d11);
        d11 = ((d2 - d4) * d8 + (d3 - d5) * d9) / d10;
        d11 = Math.min(1.0, Math.max(0.0, d11));
        return new t(d4 * (1.0 - d11) + d6 * d11, d5 * (1.0 - d11) + d7 * d11);
    }

    public static Rectangle2D a(Rectangle2D rectangle2D, Rectangle2D rectangle2D2, Rectangle2D rectangle2D3) {
        boolean bl2 = t.d;
        if (rectangle2D3 == null) {
            rectangle2D3 = new Rectangle2D.Double();
        }
        if (rectangle2D3 != rectangle2D2) {
            rectangle2D3.setRect(rectangle2D);
            if (rectangle2D3.getWidth() < 0.0 || rectangle2D3.getHeight() < 0.0) {
                rectangle2D3.setRect(rectangle2D2);
                if (!bl2) return rectangle2D3;
            }
            if (rectangle2D2.getWidth() < 0.0) return rectangle2D3;
            if (rectangle2D2.getHeight() < 0.0) return rectangle2D3;
            rectangle2D3.add(rectangle2D2);
            if (!bl2) return rectangle2D3;
        }
        if (rectangle2D3.getWidth() < 0.0 || rectangle2D3.getHeight() < 0.0) {
            rectangle2D3.setRect(rectangle2D);
            if (!bl2) return rectangle2D3;
        }
        if (rectangle2D.getWidth() < 0.0) return rectangle2D3;
        if (rectangle2D.getHeight() < 0.0) return rectangle2D3;
        rectangle2D3.add(rectangle2D);
        return rectangle2D3;
    }

    public static Rectangle2D b(Rectangle2D rectangle2D, Rectangle2D rectangle2D2, Rectangle2D rectangle2D3) {
        if (rectangle2D3 == null) {
            rectangle2D3 = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        }
        double d2 = rectangle2D.getX();
        double d3 = rectangle2D2.getX();
        double d4 = rectangle2D.getY();
        double d5 = rectangle2D2.getY();
        double d6 = rectangle2D.getWidth();
        double d7 = rectangle2D2.getWidth();
        double d8 = rectangle2D.getHeight();
        double d9 = rectangle2D2.getHeight();
        if (d6 < 0.0 || d8 < 0.0 || d7 < 0.0 || d9 < 0.0) {
            rectangle2D3.setRect(0.0, 0.0, -1.0, -1.0);
            if (!t.d) return rectangle2D3;
        }
        double d10 = Math.max(d2, d3);
        double d11 = Math.max(d4, d5);
        double d12 = Math.min(d2 + d6, d3 + d7);
        double d13 = Math.min(d4 + d8, d5 + d9);
        rectangle2D3.setRect(d10, d11, d12 - d10, d13 - d11);
        return rectangle2D3;
    }
}

