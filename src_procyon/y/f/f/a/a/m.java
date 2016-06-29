package y.f.f.a.a;

import y.c.*;

public class m
{
    public static void a(final h h, final e e) {
        final boolean e2 = f.e;
        final D d = new D();
        d.b(e);
    Label_0091:
        while (!d.isEmpty()) {
            final e e3 = (e)d.g();
            h.a(e3);
            final C a = e3.a();
            while (a.f()) {
                d.b(a.d());
                a.g();
                if (e2 || e2) {
                    break Label_0091;
                }
            }
        }
    }
    
    public static void a(final h h, final g g) {
        b(h, g.a());
    }
    
    public static void b(final h h, final e e) {
        final boolean e2 = f.e;
        final D d = new D();
        d.a(e);
    Label_0091:
        while (!d.isEmpty()) {
            final e e3 = (e)d.g();
            h.a(e3);
            final C a = e3.a();
            while (a.f()) {
                d.a(a.d());
                a.g();
                if (e2 || e2) {
                    break Label_0091;
                }
            }
        }
    }
    
    public static void c(final h h, final e e) {
        final boolean e2 = f.e;
        final C a = e.a();
        while (a.f()) {
            c(h, (e)a.d());
            a.g();
            if (e2) {
                return;
            }
            if (e2) {
                break;
            }
        }
        h.a(e);
    }
    
    public static void b(final h h, final g g) {
        c(h, g.a());
    }
}
