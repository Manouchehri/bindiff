package y.f.f.a.a;

import y.c.*;

public class n
{
    public static boolean a(final e e, final e e2) {
        return !e.e() && !e2.e() && e.c() == e2.c();
    }
    
    public static e[] b(final e e, final e e2) {
        final boolean e3 = f.e;
        if (e.e() || e2.e()) {
            throw new RuntimeException("Node is Root Node !!");
        }
        e e4 = e;
        e e5 = e2;
        while (true) {
            while (e4.b() > e5.b()) {
                e4 = e4.c();
                if (e3) {
                    while (!a(e4, e5)) {
                        e4 = e4.c();
                        e5 = e5.c();
                        if (e3) {
                            break;
                        }
                    }
                    return new e[] { e4, e5 };
                }
                if (e3) {
                    i.g = !i.g;
                    break;
                }
            }
            while (e4.b() < e5.b()) {
                e5 = e5.c();
                if (e3) {
                    return new e[] { e4, e5 };
                }
                if (e3) {
                    break;
                }
            }
            continue;
        }
    }
    
    public static e c(final e e, final e e2) {
        return b(e, e2)[0].c();
    }
    
    public static e d(final e e, final e e2) {
        final boolean e3 = f.e;
        if (e.e() || e2.e()) {
            throw new RuntimeException("Node is Root Node !!");
        }
        e c = e;
        e c2 = e2;
        while (true) {
            while (c.b() > c2.b()) {
                c = c.c();
                if (!e3) {
                    if (e3) {
                        break;
                    }
                    continue;
                }
                else {
                    while (c.b() < c2.b()) {
                        c2 = c2.c();
                        if (e3) {
                            return null;
                        }
                        if (e3) {
                            break;
                        }
                    }
                    if (c == c2) {
                        return c;
                    }
                    return null;
                }
            }
            if (c == c2) {
                return c2;
            }
            continue;
        }
    }
    
    public static e a(final e e) {
        final boolean e2 = f.e;
        e e3 = null;
        int i = 0;
        final D d = new D();
        d.b(e);
    Label_0101:
        while (i == 0) {
            e3 = (e)d.g();
            if (e3.d()) {
                i = 1;
                if (!e2) {
                    continue;
                }
            }
            final C a = e3.a();
            while (a.f()) {
                d.b(a.d());
                a.g();
                if (e2 || e2) {
                    break Label_0101;
                }
            }
        }
        return e3;
    }
    
    public static String b(final e e) {
        final o o = new o();
        m.a(o, e);
        return o.toString();
    }
    
    public static String a(final g g) {
        return b(g.a());
    }
}
