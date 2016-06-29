/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.a;

import y.c.C;
import y.c.D;
import y.c.i;
import y.c.p;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.a.g;
import y.f.f.a.a.h;
import y.f.f.a.a.m;
import y.f.f.a.a.o;

public class n {
    public static boolean a(e e2, e e3) {
        if (e2.e()) return false;
        if (e3.e()) {
            return false;
        }
        if (e2.c() != e3.c()) return false;
        return true;
    }

    public static e[] b(e e2, e e3) {
        e e4;
        boolean bl2;
        e e5;
        block5 : {
            bl2 = f.e;
            if (e2.e()) throw new RuntimeException("Node is Root Node !!");
            if (e3.e()) {
                throw new RuntimeException("Node is Root Node !!");
            }
            e5 = e2;
            e4 = e3;
            while (e5.b() > e4.b()) {
                e5 = e5.c();
                if (!bl2) {
                    if (!bl2) continue;
                    boolean bl3 = i.g = !i.g;
                    break;
                }
                break block5;
            }
            while (e5.b() < e4.b()) {
                e4 = e4.c();
                if (bl2) return new e[]{e5, e4};
                if (!bl2) continue;
            }
        }
        while (!n.a(e5, e4)) {
            e5 = e5.c();
            e4 = e4.c();
            if (!bl2) continue;
        }
        return new e[]{e5, e4};
    }

    public static e c(e e2, e e3) {
        e[] arre = n.b(e2, e3);
        return arre[0].c();
    }

    public static e d(e e2, e e3) {
        e e4;
        e e5;
        boolean bl2;
        block5 : {
            bl2 = f.e;
            if (e2.e()) throw new RuntimeException("Node is Root Node !!");
            if (e3.e()) {
                throw new RuntimeException("Node is Root Node !!");
            }
            e5 = e2;
            e4 = e3;
            while (e5.b() > e4.b()) {
                e5 = e5.c();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block5;
            }
            if (e5 == e4) {
                return e4;
            }
        }
        while (e5.b() < e4.b()) {
            e4 = e4.c();
            if (bl2) return null;
            if (!bl2) continue;
        }
        if (e5 != e4) return null;
        return e5;
    }

    public static e a(e e2) {
        boolean bl2 = f.e;
        e e3 = null;
        boolean bl3 = false;
        D d2 = new D();
        d2.b(e2);
        block0 : do {
            if (bl3) return e3;
            e3 = (e)d2.g();
            if (e3.d()) {
                bl3 = true;
                if (!bl2) return e3;
            }
            C c2 = e3.a();
            do {
                if (!c2.f()) continue block0;
                d2.b((e)c2.d());
                c2.g();
                if (bl2) return e3;
            } while (!bl2);
            break;
        } while (true);
        return e3;
    }

    public static String b(e e2) {
        o o2 = new o();
        m.a((h)o2, e2);
        return o2.toString();
    }

    public static String a(g g2) {
        return n.b(g2.a());
    }
}

