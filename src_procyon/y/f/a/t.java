package y.f.a;

import y.d.*;

class t
{
    static y a(final y y, final y y2) {
        if (y == null || y2 == null) {
            return (y == null) ? y2 : y;
        }
        final double min = Math.min(y.c(), y2.c());
        final double max = Math.max(y.c() + y.a(), y2.c() + y2.a());
        final double min2 = Math.min(y.d(), y2.d());
        return new y(min, min2, max - min, Math.max(y.d() + y.b(), y2.d() + y2.b()) - min2);
    }
    
    static double b(final y y, final y y2) {
        if (y.a(y, y2)) {
            return 0.0;
        }
        final double a = a(y, y2, false);
        final double a2 = a(y, y2, true);
        return Math.sqrt(a * a + a2 * a2);
    }
    
    private static double a(final y y, final y y2, final boolean b) {
        return a(b ? y.c() : y.d(), b ? (y.c() + y.a()) : (y.d() + y.b()), b ? y2.c() : y2.d(), b ? (y2.c() + y2.a()) : (y2.d() + y2.b()));
    }
    
    private static double a(final double n, final double n2, final double n3, final double n4) {
        if (n4 < n) {
            return n4 - n;
        }
        if (n2 < n3) {
            return n3 - n2;
        }
        return 0.0;
    }
}
