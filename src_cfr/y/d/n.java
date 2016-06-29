/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import y.c.i;
import y.d.m;
import y.d.o;
import y.d.q;
import y.d.r;
import y.d.t;
import y.d.y;
import y.d.z;

public class n
implements o {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public n(y y2) {
        this(y2.c, y2.d + y2.b, y2.a, y2.b);
    }

    public n(n n2) {
        this(n2.b(), n2.c(), n2.e(), n2.f());
        this.e = n2.g();
        this.f = n2.i();
    }

    public n(t t2, q q2) {
        this(t2.a, t2.b, q2.a, q2.b);
    }

    public n(t t2, q q2, z z2) {
        this(t2.a, t2.b, q2.a, q2.b, z2.a(), z2.b());
    }

    public n(double d2, double d3, double d4, double d5) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
        this.d = d5;
        this.e = 0.0;
        this.f = -1.0;
    }

    public n(double d2, double d3, double d4, double d5, double d6, double d7) {
        this(d2, d3, d4, d5);
        this.h(d6, d7);
    }

    public t a() {
        return new t(this.a, this.b);
    }

    public void a(t t2) {
        this.a(t2.a(), t2.b());
    }

    public void a(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    public double b() {
        return this.a;
    }

    public double c() {
        return this.b;
    }

    public q d() {
        return new q(this.c, this.d);
    }

    public void a(q q2) {
        this.b(q2.a, q2.b);
    }

    public void b(double d2, double d3) {
        this.c = d2;
        this.d = d3;
    }

    public double e() {
        return this.c;
    }

    public double f() {
        return this.d;
    }

    public void c(double d2, double d3) {
        this.h(d2, d3);
    }

    private void h(double d2, double d3) {
        if (d2 == 0.0) {
            if (d3 == 0.0) {
                throw new IllegalArgumentException("Invalid up vector: (0,0).");
            }
            this.e = 0.0;
            this.f = d3 > 0.0 ? 1.0 : -1.0;
            return;
        }
        if (d3 != 0.0) {
            double d4 = Math.sqrt(d2 * d2 + d3 * d3);
            this.e = d2 / d4;
            this.f = d3 / d4;
            return;
        }
        this.e = d2 > 0.0 ? 1.0 : -1.0;
        this.f = 0.0;
    }

    public double g() {
        return this.e;
    }

    public double i() {
        return this.f;
    }

    public double j() {
        return Math.atan2(- this.e, - this.f);
    }

    public void a(double d2) {
        this.e = - Math.sin(d2);
        this.f = - Math.cos(d2);
    }

    public void d(double d2, double d3) {
        this.a += d2;
        this.b += d3;
    }

    public t k() {
        double d2 = this.d * 0.5;
        double d3 = this.c * 0.5;
        double d4 = this.a + this.e * d2 - this.f * d3;
        double d5 = this.b + this.f * d2 + this.e * d3;
        return new t(d4, d5);
    }

    public void b(t t2) {
        this.e(t2.a(), t2.b());
    }

    public void e(double d2, double d3) {
        double d4 = this.d * 0.5;
        double d5 = this.c * 0.5;
        this.a = d2 - this.e * d4 + this.f * d5;
        this.b = d3 - this.f * d4 - this.e * d5;
    }

    @Override
    public y h() {
        t[] arrt = n.a(this);
        double d2 = Math.min(Math.min(arrt[0].a, arrt[1].a), Math.min(arrt[2].a, arrt[3].a));
        double d3 = Math.max(Math.max(arrt[0].a, arrt[1].a), Math.max(arrt[2].a, arrt[3].a));
        double d4 = Math.min(Math.min(arrt[0].b, arrt[1].b), Math.min(arrt[2].b, arrt[3].b));
        double d5 = Math.max(Math.max(arrt[0].b, arrt[1].b), Math.max(arrt[2].b, arrt[3].b));
        return new y(d2, d4, d3 - d2, d5 - d4);
    }

    public boolean a(double d2, double d3, boolean bl2) {
        return n.a(this, d2, d3, 0.0, bl2);
    }

    public static t[] a(n n2) {
        double d2 = n2.c;
        double d3 = n2.d;
        double d4 = n2.a;
        double d5 = n2.b;
        double d6 = n2.e;
        double d7 = n2.f;
        double d8 = d4 + d6 * d3;
        double d9 = d5 + d7 * d3;
        double d10 = d4 + d6 * d3 - d7 * d2;
        double d11 = d5 + d7 * d3 + d6 * d2;
        double d12 = d4 - d7 * d2;
        double d13 = d5 + d6 * d2;
        return new t[]{new t(d4, d5), new t(d8, d9), new t(d10, d11), new t(d12, d13)};
    }

    private static y a(y y2, double d2) {
        return new y(y2.c - d2, y2.d - d2, y2.a + 2.0 * d2, y2.b + 2.0 * d2);
    }

    private static boolean a(y y2, double d2, double d3, double d4) {
        y y3 = y2;
        if (d4 <= 0.0) return y3.a(d2, d3);
        y3 = n.a(y2, d4);
        return y3.a(d2, d3);
    }

    private static boolean a(double d2, double d3, double d4, double d5, y y2, double d6) {
        y y3 = y2;
        if (d6 > 0.0) {
            y3 = n.a(y2, d6);
        }
        m m2 = new m(new t(d2, d3), new t(d4, d5));
        return m2.a(y3);
    }

    public static boolean a(n n2, y y2, double d2) {
        if (y2.a < 0.0) return false;
        if (y2.b < 0.0) {
            return false;
        }
        double d3 = n2.a;
        double d4 = n2.b;
        double d5 = n2.c;
        double d6 = n2.d;
        if (d5 < 0.0) return false;
        if (d6 < 0.0) {
            return false;
        }
        if (n.a(y2, d3, d4, d2)) {
            return true;
        }
        if (n2.l()) {
            y y3 = new y(d3 - d2, d4 - d6 - d2, d5 + 2.0 * d2, d6 + 2.0 * d2);
            return y.a(y2, y3);
        }
        t[] arrt = n.a(n2);
        if (n.a(arrt[0].a, arrt[0].b, arrt[1].a, arrt[1].b, y2, d2)) {
            return true;
        }
        if (n.a(arrt[1].a, arrt[1].b, arrt[2].a, arrt[2].b, y2, d2)) {
            return true;
        }
        if (n.a(arrt[2].a, arrt[2].b, arrt[3].a, arrt[3].b, y2, d2)) {
            return true;
        }
        if (!n.a(arrt[3].a, arrt[3].b, arrt[0].a, arrt[0].b, y2, d2)) return false;
        return true;
    }

    private boolean l() {
        if (this.e != 0.0) return false;
        if (this.f != -1.0) return false;
        return true;
    }

    public static boolean a(n n2, t t2, double d2) {
        return n.a(n2, t2.a, t2.b, d2);
    }

    public static boolean a(n n2, double d2, double d3, double d4) {
        return n.a(n2, d2, d3, d4, false);
    }

    private static boolean a(n n2, double d2, double d3, double d4, boolean bl2) {
        double d5 = n2.e;
        double d6 = n2.f;
        if (n2.l()) {
            return y.a(n2.a - d4, n2.b - n2.d - d4, n2.c + 2.0 * d4, n2.d + 2.0 * d4, d2, d3, bl2);
        }
        double d7 = n2.a;
        double d8 = n2.b;
        double d9 = n2.c;
        double d10 = n2.d;
        if (d9 < 0.0) return false;
        if (d10 < 0.0) {
            return false;
        }
        double d11 = d2 - d7;
        double d12 = d3 - d8;
        double d13 = d9 + d10 + d4;
        if (d11 < - d13) return false;
        if (d11 > d13) return false;
        if (d12 < - d13) return false;
        if (d12 > d13) {
            return false;
        }
        double d14 = d11 * (- d6) + d12 * d5;
        double d15 = d11 * d5 + d12 * d6;
        return y.a(0.0 - d4, 0.0 - d4, d9 + 2.0 * d4, d10 + 2.0 * d4, d14, d15, bl2);
    }

    public static boolean a(n n2, n n3, double d2) {
        t[] arrt = n.a(n3);
        if (!n.a(n2, arrt[0], d2)) return false;
        if (!n.a(n2, arrt[1], d2)) return false;
        if (!n.a(n2, arrt[2], d2)) return false;
        if (!n.a(n2, arrt[3], d2)) return false;
        return true;
    }

    public static boolean a(n n2, m m2, double d2) {
        double d3 = n2.e;
        double d4 = n2.f;
        if (n2.l()) {
            y y2 = new y(n2.a - d2, n2.b - n2.d - d2, n2.c + 2.0 * d2, n2.d + 2.0 * d2);
            return m2.a(y2);
        }
        double d5 = n2.a;
        double d6 = n2.b;
        double d7 = n2.c;
        double d8 = n2.d;
        if (d7 < 0.0) return false;
        if (d8 < 0.0) {
            return false;
        }
        double d9 = m2.c().a;
        double d10 = m2.c().b;
        double d11 = m2.d().a;
        double d12 = m2.d().b;
        double d13 = (d9 -= d5) * (- d4) + (d10 -= d6) * d3;
        double d14 = d9 * d3 + d10 * d4;
        double d15 = (d11 -= d5) * (- d4) + (d12 -= d6) * d3;
        double d16 = d11 * d3 + d12 * d4;
        y y3 = new y(0.0 - d2, 0.0 - d2, d7 + 2.0 * d2, d8 + 2.0 * d2);
        m m3 = new m(new t(d13, d14), new t(d15, d16));
        return m3.a(y3);
    }

    public static t b(n n2, m m2, double d2) {
        t t2;
        double d3;
        double d4;
        double d5 = n2.e;
        double d6 = n2.f;
        double d7 = m2.c().a;
        double d8 = m2.c().b;
        double d9 = m2.d().a;
        double d10 = m2.d().b;
        if (n2.l()) {
            y y2 = new y(n2.a - d2, n2.b - n2.d - d2, n2.c + 2.0 * d2, n2.d + 2.0 * d2);
            return n.a(y2, d7, d8, d9, d10);
        }
        double d11 = n2.a;
        double d12 = n2.b;
        double d13 = n2.c;
        double d14 = n2.d;
        if (d13 < 0.0) return null;
        if (d14 < 0.0) {
            return null;
        }
        y y3 = new y(0.0 - d2, 0.0 - d2, d13 + 2.0 * d2, d14 + 2.0 * d2);
        double d15 = (d7 -= d11) * (- d6) + (d8 -= d12) * d5;
        double d16 = (d9 -= d11) * (- d6) + (d10 -= d12) * d5;
        if ((t2 = n.a(y3, d15, d4 = d7 * d5 + d8 * d6, d16, d3 = d9 * d5 + d10 * d6)) == null) return null;
        double d17 = d11 + t2.a * (- d6) + t2.b * d5;
        double d18 = d12 + t2.a * d5 + t2.b * d6;
        return new t(d17, d18);
    }

    private static boolean a(int n2, int n3) {
        if ((n2 & n3) == 0) return false;
        return true;
    }

    private static boolean b(int n2, int n3) {
        if ((n2 | n3) != 0) return false;
        return true;
    }

    private static boolean c(int n2, int n3) {
        if (n.a(n2, n3)) return true;
        if (n.b(n2, n3)) return true;
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private static final t a(y var0, double var1_1, double var3_2, double var5_3, double var7_4) {
        block6 : {
            var24_5 = t.d;
            var9_6 = var0.c();
            var11_7 = var0.d();
            var13_8 = var9_6 + var0.a();
            var15_9 = var11_7 + var0.b();
            var17_10 = n.a(var9_6, var11_7, var13_8, var15_9, var1_1, var3_2);
            var18_11 = n.a(var9_6, var11_7, var13_8, var15_9, var5_3, var7_4);
            var19_12 = false;
            var20_13 = false;
            var21_14 = 10;
            while (!n.c(var17_10, var18_11)) {
                v0 = var21_14--;
                if (var24_5) break block6;
                if (v0 <= 0) break;
                if (var17_10 == 0) ** GOTO lbl27
                if ((var17_10 & 3) == 0) ** GOTO lbl-1000
                var22_15 = (var17_10 & 2) != 0 ? var13_8 : var9_6;
                var3_2 += (var22_15 - var1_1) * (var7_4 - var3_2) / (var5_3 - var1_1);
                var1_1 = var22_15;
                if (var24_5) lbl-1000: // 2 sources:
                {
                    var22_15 = (var17_10 & 8) != 0 ? var15_9 : var11_7;
                    var1_1 += (var22_15 - var3_2) * (var5_3 - var1_1) / (var7_4 - var3_2);
                    var3_2 = var22_15;
                }
                var19_12 = true;
                var17_10 = n.a(var9_6, var11_7, var13_8, var15_9, var1_1, var3_2);
                if (!var24_5) continue;
lbl27: // 2 sources:
                if ((var18_11 & 3) == 0) ** GOTO lbl-1000
                var22_15 = (var18_11 & 2) != 0 ? var13_8 : var9_6;
                var7_4 += (var22_15 - var5_3) * (var7_4 - var3_2) / (var5_3 - var1_1);
                var5_3 = var22_15;
                if (var24_5) lbl-1000: // 2 sources:
                {
                    var22_15 = (var18_11 & 8) != 0 ? var15_9 : var11_7;
                    var5_3 += (var22_15 - var7_4) * (var5_3 - var1_1) / (var7_4 - var3_2);
                    var7_4 = var22_15;
                }
                var20_13 = true;
                var18_11 = n.a(var9_6, var11_7, var13_8, var15_9, var5_3, var7_4);
                if (!var24_5) continue;
            }
            v0 = var21_14;
        }
        if (v0 == 0) {
            return null;
        }
        if (n.a(var17_10, var18_11)) {
            return null;
        }
        if (!var19_12 && !var20_13) {
            return null;
        }
        if (var19_12 == false) return new t(var5_3, var7_4);
        return new t(var1_1, var3_2);
    }

    /*
     * Unable to fully structure code
     */
    private static byte a(double var0, double var2_1, double var4_2, double var6_3, double var8_4, double var10_5) {
        var13_6 = t.d;
        var12_7 = 0;
        if (var8_4 >= var0) ** GOTO lbl-1000
        var12_7 = 1;
        if (var13_6) lbl-1000: // 2 sources:
        {
            if (var8_4 > var4_2) {
                var12_7 = 2;
            }
        }
        if (var10_5 < var2_1) {
            var12_7 = (byte)(var12_7 | 4);
            if (var13_6 == false) return var12_7;
        }
        if (var10_5 <= var6_3) return var12_7;
        return (byte)(var12_7 | 8);
    }

    public String toString() {
        return new StringBuffer().append(this.getClass().getName()).append("[anchorX=").append(this.a).append(";anchorY=").append(this.b).append(";width=").append(this.c).append(";height=").append(this.d).append(";upX=").append(this.e).append(";upY=").append(this.f).append("]").toString();
    }

    private static int i(double d2, double d3) {
        return r.a(d2, d3);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        n n2 = (n)object;
        if (n.i(n2.a, this.a) != 0) {
            return false;
        }
        if (n.i(n2.b, this.b) != 0) {
            return false;
        }
        if (n.i(n2.d, this.d) != 0) {
            return false;
        }
        if (n.i(n2.c, this.c) != 0) {
            return false;
        }
        if (n.i(n2.e, this.e) != 0) {
            return false;
        }
        if (n.i(n2.f, this.f) == 0) return true;
        return false;
    }

    public int hashCode() {
        boolean bl2 = t.d;
        int n2 = super.hashCode();
        long l2 = this.a != 0.0 ? Double.doubleToLongBits(this.a) : 0;
        n2 = 31 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = this.b != 0.0 ? Double.doubleToLongBits(this.b) : 0;
        n2 = 31 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = this.e != 0.0 ? Double.doubleToLongBits(this.e) : 0;
        n2 = 31 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = this.f != 0.0 ? Double.doubleToLongBits(this.f) : 0;
        n2 = 31 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = this.c != 0.0 ? Double.doubleToLongBits(this.c) : 0;
        n2 = 31 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = this.d != 0.0 ? Double.doubleToLongBits(this.d) : 0;
        n2 = 31 * n2 + (int)(l2 ^ l2 >>> 32);
        if (!i.g) return n2;
        t.d = !bl2;
        return n2;
    }

    public n f(double d2, double d3) {
        return new n(this.a + d2, this.b + d3, this.c, this.d, this.e, this.f);
    }

    public n g(double d2, double d3) {
        return new n(this.a, this.b, d2, d3, this.e, this.f);
    }
}

