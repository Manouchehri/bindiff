/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import y.c.i;
import y.c.q;
import y.d.c;
import y.d.t;
import y.d.y;
import y.f.I;
import y.f.X;
import y.f.am;
import y.f.k.d;
import y.f.k.l;
import y.f.k.n;
import y.f.x;

public final class A {
    private c[] c;
    double a;
    double b;
    private double d;
    private double e;
    private List f;
    private double g;
    private double h;
    private byte i;
    private q j;
    private am k;

    /*
     * Unable to fully structure code
     */
    A(q var1_1, am var2_2) {
        var9_3 = d.g;
        super();
        this.c = new c[4];
        this.j = var1_1;
        this.k = var2_2;
        this.d = var2_2.getX();
        this.e = var2_2.getY();
        var3_4 = var2_2.getWidth();
        if (var3_4 <= 0.0) {
            var3_4 = 1.0;
            this.d -= 0.5;
        }
        if ((var5_5 = var2_2.getHeight()) <= 0.0) {
            var5_5 = 1.0;
            this.e -= 0.5;
        }
        this.c[0] = new c(0.0, var3_4, 0.0);
        this.c[0].b(this.d);
        this.c[0].a(this.e);
        this.c[2] = new c(0.0, var3_4, 0.0);
        this.c[2].b(this.d);
        this.c[2].a(this.e + var5_5);
        this.c[1] = new c(0.0, var5_5, 0.0);
        this.c[1].b(this.e);
        this.c[1].a(this.d + var3_4);
        this.c[3] = new c(0.0, var5_5, 0.0);
        this.c[3].b(this.e);
        this.c[3].a(this.d);
        if (var1_1.b() <= 0) ** GOTO lbl34
        var7_6 = (X)var1_1.e();
        var8_7 = var7_6.o(var1_1.g());
        this.g = var8_7.a + var3_4 * 0.5;
        this.h = var8_7.b + var5_5 * 0.5;
        if (var9_3 != 0) {
            i.g = i.g == false;
lbl34: // 2 sources:
            this.g = 0.0;
            this.h = 0.0;
        }
        this.i = 1;
    }

    public Rectangle2D a() {
        double d2 = this.e();
        double d3 = this.f();
        return new Rectangle2D.Double(d2, d3, this.g() - d2, this.h() - d3);
    }

    public double b() {
        if (this.f != null) return ((t)this.f.get((int)(this.f.size() - 1))).a + this.d;
        return this.g + this.d;
    }

    public double c() {
        if (this.f != null) return ((t)this.f.get((int)(this.f.size() - 1))).b + this.e;
        return this.h + this.e;
    }

    public void d() {
        int n2 = d.g;
        if (this.f == null) return;
        double d2 = this.g + this.d;
        double d3 = this.h + this.e;
        int n3 = 0;
        do {
            if (n3 >= this.f.size()) return;
            t t2 = (t)this.f.get(n3);
            this.a(d2, d3, t2.a + this.d, t2.b + this.e);
            d2 = t2.a + this.d;
            d3 = t2.b + this.e;
            ++n3;
        } while (n2 == 0);
    }

    public void a(double d2, double d3) {
        if (this.f == null) {
            this.f = new ArrayList(8);
        }
        this.f.add(new t(d2 - this.d, d3 - this.e));
    }

    public void a(X x2, y.c.d d2) {
        double d3;
        t t2;
        double d4;
        block2 : {
            int n2 = d.g;
            I i2 = x2.b(d2);
            t t3 = x2.p(d2);
            d3 = t3.a;
            d4 = t3.b;
            for (int i3 = 0; i3 < i2.pointCount(); ++i3) {
                t t4 = i2.getPoint(i3);
                this.a(d3, d4, t4.a, t4.b);
                d3 = t4.a;
                t2 = t4;
                if (n2 == 0) {
                    d4 = t2.b;
                    if (n2 == 0) continue;
                }
                break block2;
            }
            t2 = x2.q(d2);
        }
        t t5 = t2;
        this.a(d3, d4, t5.a, t5.b);
    }

    public void a(I i2) {
        int n2 = d.g;
        if (this.f == null) return;
        int n3 = this.f.size() - 1;
        do {
            if (n3 < 0) return;
            t t2 = (t)this.f.get(n3);
            i2.addPoint(t2.a + this.d, t2.b + this.e);
            --n3;
        } while (n2 == 0);
    }

    /*
     * Unable to fully structure code
     */
    public void a(double var1_1, double var3_2, double var5_3, double var7_4) {
        var25_5 = d.g;
        var9_6 = var1_1 < var5_3 ? var1_1 : var5_3;
        var11_7 = var1_1 < var5_3 ? var5_3 : var1_1;
        var13_8 = var1_1 < var5_3 ? var3_2 : var7_4;
        var15_9 = var1_1 < var5_3 ? var7_4 : var3_2;
        var17_10 = var3_2 < var7_4 ? var3_2 : var7_4;
        var19_11 = var3_2 < var7_4 ? var7_4 : var3_2;
        var21_12 = var3_2 < var7_4 ? var1_1 : var5_3;
        v0 = var23_13 = var3_2 < var7_4 ? var5_3 : var1_1;
        if (Math.abs(var1_1 - var5_3) <= 1.0) ** GOTO lbl22
        if (Math.abs(var3_2 - var7_4) <= 1.0) ** GOTO lbl17
        this.c[0].b(new c(var9_6, var11_7, var13_8, var15_9));
        this.c[1].a(new c(var17_10, var19_11, var21_12, var23_13));
        this.c[2].a(new c(var9_6, var11_7, var13_8, var15_9));
        this.c[3].b(new c(var17_10, var19_11, var21_12, var23_13));
        if (var25_5 == 0) ** GOTO lbl32
lbl17: // 2 sources:
        this.c[0].a(var9_6, var11_7, var17_10);
        this.c[1].b(var17_10 - 0.5, var19_11 + 0.5, var11_7);
        this.c[2].b(var9_6, var11_7, var19_11);
        this.c[3].a(var17_10 - 0.5, var19_11 + 0.5, var9_6);
        if (var25_5 == 0) ** GOTO lbl32
lbl22: // 2 sources:
        if (Math.abs(var3_2 - var7_4) <= 1.0) ** GOTO lbl-1000
        this.c[0].a(var9_6 - 0.5, var11_7 + 0.5, var17_10);
        this.c[1].b(var17_10, var19_11, var11_7);
        this.c[2].b(var9_6 - 0.5, var11_7 + 0.5, var19_11);
        this.c[3].a(var17_10, var19_11, var9_6);
        if (var25_5 != 0) lbl-1000: // 2 sources:
        {
            this.c[0].a(var9_6 - 0.5, var11_7 + 0.5, var17_10);
            this.c[1].b(var17_10 - 0.5, var19_11 + 0.5, var11_7);
            this.c[2].b(var9_6 - 0.5, var11_7 + 0.5, var19_11);
            this.c[3].a(var17_10 - 0.5, var19_11 + 0.5, var9_6);
        }
lbl32: // 5 sources:
        if (i.g == false) return;
        d.g = ++var25_5;
    }

    public void b(double d2, double d3, double d4, double d5) {
        c c2 = this.a(0);
        c c3 = this.a(1);
        c c4 = this.a(2);
        c c5 = this.a(3);
        if (d4 > 0.0) {
            c2.a(d2, d2 + d4, d3);
            c4.b(d2, d2 + d4, d3 + d5);
        }
        if (d5 <= 0.0) return;
        c3.b(d3, d3 + d5, d2 + d4);
        c5.a(d3, d3 + d5, d2);
    }

    void a(y.d.n n2) {
        t[] arrt;
        int n3 = d.g;
        if (A.b(n2)) {
            arrt = n2.h();
            this.b(arrt.c(), arrt.d(), arrt.a(), arrt.b());
            if (n3 == 0) return;
        }
        arrt = y.d.n.a(n2);
        int n4 = 0;
        do {
            if (n4 >= arrt.length) return;
            t t2 = arrt[n4];
            t t3 = arrt[(n4 + 1) % arrt.length];
            this.a(t2.a, t2.b, t3.a, t3.b);
            ++n4;
        } while (n3 == 0);
    }

    private static boolean b(y.d.n n2) {
        if (Math.abs(n2.g()) < 1.0E-4) return true;
        if (Math.abs(n2.i()) < 1.0E-4) return true;
        return false;
    }

    public void a(A a2) {
        this.c[0].b(a2.c[0]);
        this.c[1].a(a2.c[1]);
        this.c[2].a(a2.c[2]);
        this.c[3].b(a2.c[3]);
    }

    public double e() {
        return Math.min(this.c[0].a(), Math.min(this.c[2].a(), this.c[3].c()));
    }

    public double f() {
        return Math.min(this.c[0].c(), Math.min(this.c[1].a(), this.c[3].a()));
    }

    public double g() {
        return Math.max(this.c[0].b(), Math.max(this.c[2].b(), this.c[1].d()));
    }

    public double h() {
        return Math.max(this.c[1].b(), Math.max(this.c[2].d(), this.c[3].b()));
    }

    public c a(int n2) {
        if (n2 < 0) throw new IllegalArgumentException(new StringBuffer().append("Unknown border line index").append(n2).toString());
        if (n2 <= 3) return this.c[n2];
        throw new IllegalArgumentException(new StringBuffer().append("Unknown border line index").append(n2).toString());
    }

    public void b(double d2, double d3) {
        this.c[0].b(d2);
        this.c[0].a(d3);
        this.c[1].b(d3);
        this.c[1].a(d2);
        this.c[2].b(d2);
        this.c[2].a(d3);
        this.c[3].b(d3);
        this.c[3].a(d2);
        this.d += d2;
        this.e += d3;
        this.k.setLocation(this.k.getX() + d2, this.k.getY() + d3);
    }

    public double i() {
        return this.d;
    }

    public double j() {
        return this.e;
    }

    public A a(l l2) {
        A a2 = new A(this.j, new x());
        a2.i = this.i;
        this.a(a2, l2);
        return a2;
    }

    /*
     * Unable to fully structure code
     */
    public void a(A var1_1, l var2_2) {
        block3 : {
            var16_3 = d.g;
            var3_4 = n.a(this.k.getWidth(), this.k.getHeight());
            var4_5 = var3_4.a(var2_2);
            var1_1.k.setSize(var4_5.a(0), var4_5.a(1));
            var5_6 = n.a(this.d, this.e);
            var6_7 = var5_6.a(var2_2);
            var1_1.d = var6_7.a(0);
            var1_1.e = var6_7.a(1);
            var1_1.k.setLocation(var6_7.a(0), var6_7.a(1));
            var7_8 = n.a(this.g, this.h);
            var8_9 = var7_8.a(var2_2);
            var1_1.g = var8_9.a(0);
            var1_1.h = var8_9.a(1);
            var9_10 = new c[4];
            for (var10_11 = 0; var10_11 < this.c.length; ++var10_11) {
                var11_13 = this.c[var10_11];
                var12_14 = var2_2.a();
                if (var16_3 != 0) break block3;
                if (var10_11 != 0 && var10_11 != 2) ** GOTO lbl-1000
                var14_17 = var12_14.a(0);
                var15_19 = var12_14.a(1);
                var13_15 = var11_13.a(var15_19.a() < 0.0, var14_17.a() < 0.0);
                if (var16_3 != 0) lbl-1000: // 2 sources:
                {
                    var14_17 = var12_14.a(0);
                    var15_19 = var12_14.a(1);
                    var13_15 = var11_13.a(var14_17.a() < 0.0, var15_19.a() < 0.0);
                }
                var14_16 = n.b(var10_11).a(var2_2).b();
                var9_10[var14_16] = var13_15;
                if (var16_3 == 0) continue;
            }
            var1_1.c = var9_10;
        }
        if (this.f == null) return;
        var10_12 = new ArrayList<t>();
        for (Object var12_14 : this.f) {
            var13_15 = n.a((t)var12_14);
            var14_18 = var13_15.a(var2_2);
            var10_12.add(new t(var14_18.a(0), var14_18.a(1)));
            if (var16_3 != 0) return;
            if (var16_3 == 0) continue;
        }
        var1_1.f = var10_12;
    }

    q k() {
        return this.j;
    }

    public String toString() {
        List<c> list;
        if (this.c == null) {
            list = null;
            return new StringBuffer().append("SubtreeShape{x=").append(this.d).append(", y=").append(this.e).append(", dx=").append(this.a).append(", dy=").append(this.b).append(", borderLines=").append(list).append("}").toString();
        }
        list = Arrays.asList(this.c);
        return new StringBuffer().append("SubtreeShape{x=").append(this.d).append(", y=").append(this.e).append(", dx=").append(this.a).append(", dy=").append(this.b).append(", borderLines=").append(list).append("}").toString();
    }
}

