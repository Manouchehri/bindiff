/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.util.Collection;
import y.c.C;
import y.c.D;
import y.d.n;
import y.d.q;
import y.d.t;
import y.d.y;
import y.f.M;
import y.f.X;
import y.f.ai;
import y.f.aj;
import y.f.ak;
import y.f.al;
import y.f.am;
import y.f.d.a;
import y.f.x;

class s {
    private static final am a = new x(0.0, 0.0, 30.0, 30.0);
    private static final n[] b = new n[]{new n(15.0, 5.0, 30.0, 10.0, 1.0, 0.0), new n(-15.0, -15.0, 100.0, 30.0, 0.5, 0.5), new n(50.0, 90.0, 40.0, 15.0, 0.0, -1.0)};

    /*
     * Unable to fully structure code
     */
    static D a(X var0, y.c.q var1_1, aj var2_2, al var3_3, boolean var4_4) {
        var15_5 = a.f;
        var5_6 = new D();
        var6_7 = var0.a(var1_1);
        var7_8 = var2_2.a();
        var8_9 = var2_2.getModelParameter() == null ? var7_8.c() : var2_2.getModelParameter();
        v0 = var9_10 = var7_8 == null ? var2_2.getOrientedBox() : var7_8.a(var2_2.getOrientedBox().d(), var6_7, var8_9);
        if (!var4_4) ** GOTO lbl10
        var5_6.add(new ai(var9_10, var8_9, var2_2, false));
        if (var15_5 == 0) ** GOTO lbl24
lbl10: // 2 sources:
        if (var3_3 == null || var3_3 == var7_8) ** GOTO lbl22
        var10_11 = var3_3.a(var9_10, var6_7);
        var11_12 = s.a(var2_2.getOrientedBox(), var3_3, var10_11);
        var12_13 = s.a(var0, var1_1, var11_12, var3_3);
        var13_14 = var12_13.m();
        while (var13_14.f()) {
            var14_15 = (ai)var13_14.d();
            v1 = var5_6;
            if (var15_5 != 0) return v1;
            v1.add(s.a(var14_15, var2_2, var7_8, var6_7));
            var13_14.g();
            if (var15_5 == 0) continue;
lbl22: // 2 sources:
            var5_6.addAll(s.a(var0, var1_1, var2_2, var7_8));
            break;
        }
lbl24: // 3 sources:
        v1 = var5_6;
        return v1;
    }

    private static D a(X x2, y.c.q q2, aj aj2) {
        return s.a(x2, q2, aj2, 4.0);
    }

    private static D a(X x2, y.c.q q2, aj aj2, al al2) {
        am am2 = x2.a(q2);
        if (al2 == null) return s.a(x2, q2, aj2);
        if (!s.a(al2)) return al2.a(aj2, am2);
        return s.a(x2, q2, aj2);
    }

    private static D a(X x2, y.c.q q2, aj aj2, double d2) {
        al al2;
        double d3;
        n n2;
        int n3;
        int n4;
        D d4;
        y y2;
        am am2;
        y y3;
        D d5;
        block3 : {
            n3 = a.f;
            d5 = new D();
            n2 = aj2.getOrientedBox();
            y3 = aj2.getBox();
            al2 = aj2.a();
            am2 = x2.a(q2);
            y2 = x2.s(q2);
            int n5 = s.a(x2);
            n4 = (int)Math.max(3.0, y2.b / y3.b);
            n4 = Math.min(n4, n5);
            d3 = (y2.b - y3.b) / (double)(n4 - 1);
            double d6 = y2.c() - d2 - y3.a;
            double d7 = y2.c() + y2.a + d2;
            double d8 = y2.d();
            for (int i2 = 0; i2 < n4; d8 += d3, ++i2) {
                t t2 = new t(d6, d8);
                n n6 = new n(n2);
                n6.e(t2.a() + y3.a() * 0.5, t2.b() + y3.b() * 0.5);
                Object object = al2.a(n6, am2);
                ai ai2 = new ai(n6, object, aj2, false);
                d5.add(ai2);
                t t3 = new t(d7, d8);
                n n7 = new n(n2);
                n7.e(t3.a() + y3.a() * 0.5, t3.b() + y3.b() * 0.5);
                object = al2.a(n7, am2);
                ai2 = new ai(n7, object, aj2, false);
                d5.add(ai2);
                if (n3 == 0) {
                    if (n3 == 0) continue;
                }
                break block3;
            }
            n4 = (int)Math.max(3.0, y2.a / y3.a + 2.0);
            n4 = Math.min(n4, 15);
            d3 = (y2.a + y3.a) / (double)(n4 - 1);
        }
        double d9 = y2.d() - d2 - y3.b;
        double d10 = y2.d() + y2.b + d2;
        double d11 = y2.c() - y3.a;
        for (int i3 = 0; i3 < n4; d11 += d3, ++i3) {
            t t4 = new t(d11, d9);
            n n8 = new n(n2);
            n8.e(t4.a() + y3.a() * 0.5, t4.b() + y3.b() * 0.5);
            Object object = al2.a(n8, am2);
            ai ai3 = new ai(n8, object, aj2, false);
            d5.add(ai3);
            t t5 = new t(d11, d10);
            n n9 = new n(n2);
            n9.e(t5.a() + y3.a() * 0.5, t5.b() + y3.b() * 0.5);
            object = al2.a(n9, am2);
            ai3 = new ai(n9, object, aj2, false);
            d4 = d5;
            if (n3 != 0) return d4;
            d4.add(ai3);
            if (n3 == 0) continue;
        }
        d4 = d5;
        return d4;
    }

    private static ai a(ai ai2, aj aj2, al al2, am am2) {
        Object object = al2.a(ai2.d(), am2);
        n n2 = al2.a(ai2.d().d(), am2, object);
        return new ai(n2, object, aj2, false);
    }

    private static aj a(n n2, al al2, Object object) {
        ak ak2 = new ak();
        ak2.a(al2);
        ak2.setModelParameter(object);
        ak2.a(n2);
        return ak2;
    }

    private static boolean a(al al2) {
        int n2 = a.f;
        if (al2 instanceof M) {
            return true;
        }
        int n3 = 0;
        do {
            if (n3 >= b.length) return true;
            Object object = al2.a(b[n3], a);
            n n4 = al2.a(b[n3].d(), a, object);
            boolean bl2 = n.a(b[n3], n4, 1.0);
            if (n2 != 0) return bl2;
            if (!bl2) {
                return false;
            }
            ++n3;
        } while (n2 == 0);
        return true;
    }

    private static int a(X x2) {
        int n2 = 15;
        if (x2.f() > 100) {
            n2 = 10;
            if (a.f == 0) return n2;
        }
        if (x2.f() <= 500) return n2;
        return 5;
    }
}

