package y.a;

import y.c.*;

public final class g
{
    public static boolean a(final i i) {
        return m.a(i, new int[i.f()]);
    }
    
    public static boolean b(final i i) {
        return !a(i);
    }
    
    public static boolean c(final i i) {
        return h.c(i);
    }
    
    public static boolean d(final i i) {
        return A.b(i);
    }
    
    public static boolean e(final i i) {
        final boolean a = h.a;
        final e p = i.p();
        boolean e = false;
        while (p.f()) {
            e = p.a().e();
            if (a) {
                return e;
            }
            if (e) {
                return false;
            }
            p.g();
            if (a) {
                break;
            }
        }
        return e;
    }
}
