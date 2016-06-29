/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.util.Arrays;
import y.d.n;
import y.d.t;
import y.d.y;
import y.f.d.D;
import y.f.d.E;
import y.f.d.a;
import y.f.d.m;

class C {
    private static y a(n n2) {
        double d2;
        double d3;
        double d4;
        double d5;
        int n3 = a.f;
        if (n2.g() == 0.0 && n2.i() == -1.0) {
            d3 = n2.b();
            d5 = n2.c() - n2.f();
            d4 = n2.f();
            d2 = n2.e();
            if (n3 == 0) return new y(d3, d5, d2, d4);
        }
        if (n2.g() == 0.0 && n2.i() == 1.0) {
            d3 = n2.b() - n2.e();
            d5 = n2.c();
            d4 = n2.f();
            d2 = n2.e();
            if (n3 == 0) return new y(d3, d5, d2, d4);
        }
        if (n2.g() == 1.0 && n2.i() == 0.0) {
            d3 = n2.b();
            d5 = n2.c();
            d4 = n2.e();
            d2 = n2.f();
            if (n3 == 0) return new y(d3, d5, d2, d4);
        }
        if (n2.g() != -1.0) return null;
        if (n2.i() != 0.0) return null;
        d3 = n2.b() - n2.e();
        d5 = n2.c() - n2.f();
        d4 = n2.e();
        d2 = n2.f();
        if (n3 == 0) return new y(d3, d5, d2, d4);
        return null;
    }

    private static boolean b(n n2) {
        if (n2.g() == 0.0) {
            if (n2.i() == -1.0) return true;
        }
        if (n2.g() == 0.0) {
            if (n2.i() == 1.0) return true;
        }
        if (n2.g() == -1.0) {
            if (n2.i() == 0.0) return true;
        }
        if (n2.g() != 1.0) return false;
        if (n2.i() != 0.0) return false;
        return true;
    }

    static double a(n n2, n n3) {
        double d2;
        block4 : {
            int n4 = a.f;
            if (C.b(n2) && C.b(n3)) {
                return C.a(C.a(n2), C.a(n3));
            }
            if (n.a(n2, n3, 0.001)) return 1.0;
            if (n.a(n3, n2, 0.001)) return 1.0;
            if (n3.equals(n2)) {
                return 1.0;
            }
            t[] arrt = C.b(n2, n3);
            if (arrt == null) return 0.0;
            d2 = 0.0;
            for (int i2 = 0; i2 < arrt.length; d2 += (arrt[i2].a + arrt[n5].a) * (arrt[n5].b - arrt[i2].b), ++i2) {
                int n5 = (i2 + 1) % arrt.length;
                if (n4 == 0) {
                    if (n4 == 0) continue;
                }
                break block4;
            }
            d2 = Math.abs(d2 * 0.5);
        }
        double d3 = d2 / (n2.e() * n2.f());
        double d4 = d2 / (n3.e() * n3.f());
        return Math.max(d3, d4);
    }

    static double a(n n2, y y2) {
        return C.a(n2, new n(y2));
    }

    private static double a(y y2, y y3) {
        if (y2.b(y3)) return 1.0;
        if (y3.b(y2)) return 1.0;
        if (y3.equals(y2)) {
            return 1.0;
        }
        if (!y.a(y2, y3)) return 0.0;
        y y4 = C.b(y2, y3);
        double d2 = y4.a * y4.b;
        double d3 = d2 / (y2.a * y2.b);
        double d4 = d2 / (y3.a * y3.b);
        return Math.max(d3, d4);
    }

    private static y b(y y2, y y3) {
        double d2 = Math.max(y2.c, y3.c);
        double d3 = Math.max(y2.d, y3.d);
        double d4 = Math.min(y2.c + y2.a, y3.c + y3.a) - d2;
        double d5 = Math.min(y2.d + y2.b, y3.d + y3.b) - d3;
        return new y(d2, d3, d4, d5);
    }

    private static t[] b(n n2, n n3) {
        int n4;
        y.c.D d2;
        boolean bl2;
        block11 : {
            int n5;
            t[] arrt;
            t[] arrt2;
            block9 : {
                int n6;
                n4 = a.f;
                arrt = n.a(n2);
                arrt2 = n.a(n3);
                d2 = new y.c.D();
                n5 = 0;
                while (n5 < 4) {
                    block10 : {
                        y.d.m m2 = new y.d.m(arrt[n5], arrt[(n5 + 1) % 4]);
                        n6 = 0;
                        if (n4 != 0) break block9;
                        for (int i2 = v1430417; i2 < 4; ++i2) {
                            y.d.m m3 = new y.d.m(arrt2[i2], arrt2[(i2 + 1) % 4]);
                            t t2 = y.d.m.a(m2, m3);
                            if (n4 == 0) {
                                if (t2 == null) continue;
                                d2.add(t2);
                                if (n4 == 0) continue;
                            }
                            break block10;
                        }
                        ++n5;
                    }
                    if (n4 == 0) continue;
                }
                n6 = n5 = 0;
            }
            while (n5 < 4) {
                bl2 = n.a(n2, arrt2[n5], 0.001);
                if (n4 == 0) {
                    if (bl2) {
                        d2.add(arrt2[n5]);
                    }
                    if (n.a(n3, arrt[n5], 0.001)) {
                        d2.add(arrt[n5]);
                    }
                    ++n5;
                    if (n4 == 0) continue;
                }
                break block11;
            }
            bl2 = d2.isEmpty();
        }
        if (bl2) {
            return null;
        }
        t[] arrt = new t[d2.size()];
        int n7 = 0;
        y.c.C c2 = d2.m();
        while (c2.f()) {
            arrt[n7++] = (t)c2.d();
            c2.g();
            if (n4 != 0) return arrt;
            if (n4 == 0) continue;
        }
        Arrays.sort(arrt, new E(arrt, null));
        return arrt;
    }

    /*
     * Unable to fully structure code
     */
    static double a(n var0, y.d.m var1_1) {
        var13_2 = a.f;
        if (C.b(var0)) {
            return C.a(C.a(var0), var1_1);
        }
        if (!n.a(var0, var1_1, 0.001)) {
            return 0.0;
        }
        var2_3 = var0.k();
        var3_4 = new y.d.m(var2_3, var0.a()).g();
        var5_5 = Math.sqrt(var0.e() * var0.e() + var0.f() * var0.f());
        var8_6 = C.b(var0, var1_1);
        if (var8_6 != null) ** GOTO lbl13
        var7_7 = var1_1;
        if (var13_2 == 0) ** GOTO lbl18
lbl13: // 2 sources:
        if (var8_6.length != 1) ** GOTO lbl-1000
        var9_8 = n.a(var0, var1_1.c(), 0.001) != false ? var1_1.c() : var1_1.d();
        var7_7 = new y.d.m(var9_8, var8_6[0]);
        if (var13_2 != 0) lbl-1000: // 2 sources:
        {
            var7_7 = new y.d.m(var8_6[0], var8_6[1]);
        }
lbl18: // 4 sources:
        var9_9 = var7_7.g() / var5_5;
        var11_10 = 1.0 - m.a(var7_7, var2_3) / var3_4;
        return (3.0 * var11_10 + 1.0 * var9_9) / 4.0;
    }

    private static t[] b(n n2, y.d.m m2) {
        t[] arrt;
        Object object;
        y.c.D d2;
        int n3;
        block5 : {
            n3 = a.f;
            t[] arrt2 = n.a(n2);
            d2 = new y.c.D();
            for (int i2 = 0; i2 < arrt2.length; ++i2) {
                y.d.m m3 = new y.d.m(arrt2[i2], arrt2[(i2 + 1) % arrt2.length]);
                object = y.d.m.a(m3, m2);
                if (n3 == 0) {
                    if (object != null) {
                        d2.add(object);
                        if (n3 == 0) continue;
                    }
                    if (!m2.b(arrt2[i2])) continue;
                    d2.add(arrt2[i2]);
                    if (n3 == 0) continue;
                }
                break block5;
            }
            if (d2.isEmpty()) {
                return null;
            }
        }
        t[] arrt3 = new t[d2.size()];
        int n4 = 0;
        object = d2.m();
        while (object.f()) {
            arrt = arrt3;
            if (n3 != 0) return arrt;
            arrt[n4++] = (t)object.d();
            object.g();
            if (n3 == 0) continue;
        }
        arrt = arrt3;
        return arrt;
    }

    /*
     * Unable to fully structure code
     */
    private static double a(y var0, y.d.m var1_1) {
        var13_2 = a.f;
        if (!var1_1.a(var0)) {
            return 0.0;
        }
        var2_3 = new t(var0.c + var0.a * 0.5, var0.d + var0.b * 0.5);
        var3_4 = new y.d.m(var2_3, var0.e()).g();
        var5_5 = Math.sqrt(var0.a * var0.a + var0.b * var0.b);
        var8_6 = C.b(var0, var1_1);
        if (var8_6 != null) ** GOTO lbl11
        var7_7 = var1_1;
        if (var13_2 == 0) ** GOTO lbl16
lbl11: // 2 sources:
        if (var8_6.length != 1) ** GOTO lbl-1000
        var9_8 = var0.a(var1_1.c()) != false ? var1_1.c() : var1_1.d();
        var7_7 = new y.d.m(var9_8, var8_6[0]);
        if (var13_2 != 0) lbl-1000: // 2 sources:
        {
            var7_7 = new y.d.m(var8_6[0], var8_6[1]);
        }
lbl16: // 4 sources:
        var9_9 = var7_7.g() / var5_5;
        var11_10 = 1.0 - m.a(var7_7, var2_3) / var3_4;
        return (3.0 * var11_10 + 1.0 * var9_9) / 4.0;
    }

    private static t[] b(y y2, y.d.m m2) {
        y.d.m m3;
        y.d.m m4;
        t[] arrt;
        y.d.m m5;
        int n2 = a.f;
        t t2 = y2.e();
        t t3 = new t(t2.a, t2.b + y2.b());
        t t4 = new t(t3.a + y2.a(), t3.b);
        t t5 = new t(t4.a, t2.b);
        y.c.D d2 = new y.c.D();
        y.d.m m6 = new y.d.m(t2, t3);
        t t6 = y.d.m.a(m6, m2);
        if (t6 != null) {
            d2.add(t6);
        }
        if ((t6 = y.d.m.a(m4 = new y.d.m(t5, t4), m2)) != null) {
            d2.add(t6);
        }
        if ((t6 = y.d.m.a(m3 = new y.d.m(t2, t5), m2)) != null) {
            d2.add(t6);
        }
        if ((t6 = y.d.m.a(m5 = new y.d.m(t3, t4), m2)) != null) {
            d2.add(t6);
        }
        if (m2.b(t2)) {
            d2.add(t2);
        }
        if (m2.b(t5)) {
            d2.add(t5);
        }
        if (m2.b(t3)) {
            d2.add(t3);
        }
        if (m2.b(t4)) {
            d2.add(t4);
        }
        if (d2.isEmpty()) {
            return null;
        }
        t[] arrt2 = new t[d2.size()];
        int n3 = 0;
        y.c.C c2 = d2.m();
        while (c2.f()) {
            arrt = arrt2;
            if (n2 != 0) return arrt;
            arrt[n3++] = (t)c2.d();
            c2.g();
            if (n2 == 0) continue;
        }
        arrt = arrt2;
        return arrt;
    }
}

