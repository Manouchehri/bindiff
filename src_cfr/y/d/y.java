/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import y.d.o;
import y.d.q;
import y.d.t;

public class y
extends q
implements o {
    public final double c;
    public final double d;
    private t e;

    public y() {
        super(0.0, 0.0);
        this.d = 0.0;
        this.c = 0.0;
    }

    public y(t t2, q q2) {
        super(q2.a, q2.b);
        this.c = t2.a;
        this.d = t2.b;
        this.e = t2;
    }

    public y(double d2, double d3, double d4, double d5) {
        super(d4, d5);
        this.c = d2;
        this.d = d3;
    }

    /*
     * Unable to fully structure code
     */
    public double a(y var1_1) {
        var8_2 = t.d;
        var2_3 = 0.0;
        var4_4 = new t(this.c(), this.d());
        var5_5 = new t(this.c() + this.a(), this.d() + this.b());
        var6_6 = new t(var1_1.c(), var1_1.d());
        var7_7 = new t(var1_1.c() + var1_1.a(), var1_1.d() + var1_1.b());
        if (var5_5.a() >= var6_6.a()) ** GOTO lbl-1000
        var2_3 += Math.abs(var6_6.a() - var5_5.a());
        if (var8_2) lbl-1000: // 2 sources:
        {
            if (var4_4.a() > var7_7.a()) {
                var2_3 += Math.abs(var7_7.a() - var4_4.a());
            }
        }
        if (var5_5.b() < var6_6.b()) {
            if (var8_2 == false) return var2_3 += Math.abs(var6_6.b() - var5_5.b());
        }
        if (var4_4.b() <= var7_7.b()) return var2_3 += Math.abs(var6_6.b() - var5_5.b());
        var2_3 += Math.abs(var7_7.b() - var4_4.b());
        return var2_3 += Math.abs(var6_6.b() - var5_5.b());
    }

    public final double c() {
        return this.c;
    }

    public final double d() {
        return this.d;
    }

    public final t e() {
        if (this.e != null) return this.e;
        this.e = new t(this.c, this.d);
        return this.e;
    }

    @Override
    public y h() {
        return this;
    }

    public boolean a(double d2, double d3) {
        return y.a(this.c, this.d, this.a, this.b, d2, d3, false);
    }

    public static boolean a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return y.a(d2, d3, d4, d5, d6, d7, false);
    }

    public static boolean a(double d2, double d3, double d4, double d5, double d6, double d7, boolean bl2) {
        if (bl2) {
            if (d6 < d2) return false;
            if (d6 - d2 > d4) return false;
            if (d7 < d3) return false;
            if (d7 - d3 > d5) return false;
            return true;
        }
        if (d6 < d2) return false;
        if (d6 - d2 >= d4) return false;
        if (d7 < d3) return false;
        if (d7 - d3 >= d5) return false;
        return true;
    }

    public boolean a(t t2) {
        return this.a(t2.a, t2.b);
    }

    public boolean b(y y2) {
        return this.a(y2.c, y2.d, y2.a, y2.b);
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        if (!this.a(d2, d3)) return false;
        if (!this.a(d2 + d4, d3 + d5)) return false;
        return true;
    }

    public static boolean a(y y2, y y3) {
        if (y2.c + y2.a <= y3.c) return false;
        if (y2.d + y2.b <= y3.d) return false;
        if (y2.c >= y3.c + y3.a) return false;
        if (y2.d >= y3.d + y3.b) return false;
        return true;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("[").append(this.c).append(',').append(this.d).append(',').append(this.a).append(',').append(this.b).append(']').toString();
    }

    @Override
    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.c) >> 1 ^ Double.doubleToLongBits(this.d);
        return super.hashCode() << 1 ^ (int)(l2 ^ l2 >> 32);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof y)) {
            return false;
        }
        y y2 = (y)object;
        if (y2.c != this.c) return false;
        if (y2.d != this.d) return false;
        if (y2.a != this.a) return false;
        if (y2.b != this.b) return false;
        return true;
    }

    @Override
    public int compareTo(Object object) {
        y y2 = (y)object;
        if (this.c < y2.c) {
            return -1;
        }
        if (this.c > y2.c) {
            return 1;
        }
        if (this.d < y2.d) {
            return -1;
        }
        if (this.d <= y2.d) return super.compareTo(object);
        return 1;
    }
}

