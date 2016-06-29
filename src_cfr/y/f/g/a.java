/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.c.h;
import y.c.i;
import y.c.x;
import y.d.q;
import y.d.y;
import y.f.X;
import y.f.am;
import y.f.b.c;
import y.f.c.a.N;
import y.f.c.a.Z;
import y.f.c.a.aQ;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aY;
import y.f.c.a.bK;
import y.f.c.a.m;
import y.f.c.aj;
import y.f.c.e;
import y.f.g.B;
import y.f.g.D;
import y.f.g.F;
import y.f.g.d;
import y.g.I;
import y.g.M;

class A {
    private y.c.A a;
    private double[] b;
    private double[] c;
    private double[] d;
    private boolean[] e;
    private double[] f;
    private double g;

    A(double d2) {
        this.g = d2;
    }

    /*
     * Unable to fully structure code
     */
    public void a(X var1_1, c var2_2) {
        block13 : {
            var18_3 = d.d;
            this.a = M.a();
            var3_4 = var1_1.a();
            var4_5 = M.a();
            var5_6 = M.b();
            var6_7 = new D(var4_5, var5_6);
            var7_8 = var1_1.o();
            while (var7_8.f()) {
                var8_9 = var7_8.e();
                this.a.a((Object)var7_8.e(), -1);
                var9_10 = new B(null, null, null);
                var4_5.a(var8_9, var9_10);
                var7_8.g();
                if (!var18_3) continue;
                i.g = i.g == false;
                break;
            }
            var7_8 = new F(var6_7);
            var8_9 = var1_1.c(d.a);
            var9_10 = new I(var1_1);
            var10_11 = new y.c.y();
            var11_12 = var1_1.o();
            while (var11_12.f()) {
                var12_13 = var11_12.e();
                if (!var2_2.d((y.c.q)var12_13)) ** GOTO lbl-1000
                var9_10.a((y.c.q)var12_13);
                if (var18_3) lbl-1000: // 2 sources:
                {
                    if (var8_9.d(var12_13)) {
                        var10_11.add(var12_13);
                        var9_10.a((y.c.q)var12_13);
                    }
                }
                var11_12.g();
                if (!var18_3) continue;
            }
            var11_12 = var1_1.p();
            while (var11_12.f()) {
                var12_13 = var11_12.a();
                if (var12_13.e()) {
                    var9_10.a((y.c.d)var12_13);
                }
                var11_12.g();
                if (!var18_3) continue;
            }
            var11_12 = new e();
            var11_12.a(30.0);
            var11_12.a(var1_1, (aU)var7_8, var6_7);
            var9_10.a(var10_11, true);
            var12_13 = var1_1.p();
            while (var12_13.f()) {
                var13_14 = var12_13.a();
                if (!var18_3) {
                    if (var13_14.e()) {
                        var9_10.a(var13_14);
                    }
                    var12_13.g();
                    if (!var18_3) continue;
                }
                break block13;
            }
            var1_1.a(N.t, (y.c.c)var8_9);
        }
        var12_13 = new m(new aj());
        var12_13.a(var1_1, (aU)var7_8, var6_7);
        var1_1.d_(N.t);
        this.b = new double[var7_8.b()];
        this.c = new double[var7_8.b()];
        this.f = new double[var7_8.b()];
        this.d = new double[var7_8.b()];
        this.e = new boolean[var7_8.b()];
        for (var13_15 = 0; var13_15 < var7_8.b(); ++var13_15) {
            block14 : {
                var14_16 = var7_8.a(var13_15);
                this.b[var13_15] = var3_4.getMaxY();
                this.c[var13_15] = var3_4.getMinY();
                var15_17 = 0;
                if (var18_3 != false) return;
                var16_18 = var14_16.d().a();
                while (var16_18.f()) {
                    var17_19 = var16_18.e();
                    this.f[var13_15] = Math.max(this.f[var13_15], var1_1.q(var17_19));
                    this.a.a((Object)var17_19, var13_15);
                    v0 = (int)var8_9.d(var17_19) ? 1 : 0;
                    if (!var18_3) {
                        if (v0 == 0) {
                            ++var15_17;
                            v1 = this.d;
                            v2 = var13_15;
                            v1[v2] = v1[v2] + var1_1.k(var17_19);
                            this.b[var13_15] = Math.min(this.b[var13_15], var1_1.n(var17_19));
                            this.c[var13_15] = Math.max(this.c[var13_15], var1_1.n(var17_19) + var1_1.q(var17_19));
                            this.f[var13_15] = Math.max(this.f[var13_15], this.c[var13_15] - this.b[var13_15]);
                        }
                        var16_18.g();
                        if (!var18_3) continue;
                    }
                    break block14;
                }
                v0 = var15_17;
            }
            if (v0 <= 0) continue;
            this.e[var13_15] = true;
            v3 = this.d;
            v4 = var13_15;
            v3[v4] = v3[v4] / (double)var15_17;
            if (!var18_3) continue;
        }
        var9_10.f();
    }

    public int a(y.c.q q2) {
        return this.a.a(q2);
    }

    public y a(y.c.q q2, X x2, y.c.A a2) {
        Rectangle2D rectangle2D;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        boolean bl2;
        block6 : {
            boolean bl3 = d.d;
            int n2 = this.a.a(q2);
            if (n2 < 0) {
                return null;
            }
            rectangle2D = this.a(x2, q2, (y.c.c)a2);
            d4 = rectangle2D.getMinY();
            d2 = rectangle2D.getMinY();
            boolean bl4 = false;
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                if (!this.e[i2]) continue;
                d4 = this.c[i2] + this.g;
                d2 = this.d[i2];
                bl4 = true;
                if (!bl3) break;
                if (!bl3) continue;
            }
            d5 = rectangle2D.getMaxY();
            d3 = rectangle2D.getMaxY();
            d6 = 0.0;
            for (int i3 = n2 + 1; i3 < this.e.length; d6 += this.f[i3] + this.g, ++i3) {
                bl2 = this.e[i3];
                if (!bl3) {
                    if (!bl2) continue;
                    d5 = this.b[i3] - this.g;
                    d3 = this.d[i3];
                    if (!bl3) break;
                    if (!bl3) continue;
                }
                break block6;
            }
            bl2 = bl4;
        }
        if (!bl2) {
            d4 -= d6;
            d2 -= d6;
            d5 -= d6;
            d3 -= d6;
        }
        if (d5 - d4 > x2.q(q2)) return new y(rectangle2D.getX(), d4, rectangle2D.getWidth(), d5 - d4);
        if (d3 - d2 > x2.q(q2)) {
            return new y(rectangle2D.getX(), d2, rectangle2D.getWidth(), d3 - d2);
        }
        double d7 = (d2 - d3 + x2.q(q2)) * 0.5;
        return new y(rectangle2D.getX(), d2 - d7, rectangle2D.getWidth(), x2.q(q2));
    }

    private Rectangle2D a(X x2, y.c.q q2, y.c.c c2) {
        boolean bl2 = d.d;
        q q3 = x2.r(q2);
        boolean bl3 = false;
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        double d4 = -1.7976931348623157E308;
        double d5 = -1.7976931348623157E308;
        x x3 = x2.o();
        while (x3.f()) {
            if (c2 == null || c2.d(x3.e())) {
                am am2 = x2.h(x3.e());
                d2 = Math.min(d2, am2.getX());
                d3 = Math.min(d3, am2.getY());
                d4 = Math.max(d4, am2.getX() + am2.getWidth());
                d5 = Math.max(d5, am2.getY() + am2.getHeight());
                bl3 = true;
            }
            x3.g();
            if (!bl2) continue;
        }
        if (!bl3) return new Rectangle2D.Double(0.0, 0.0, q3.a(), q3.b());
        return new Rectangle2D.Double(d2 - this.g - q3.a() - 100.0, d3 - this.g - q3.b() - 100.0, d4 - d2 + 2.0 * (this.g + 100.0 + q3.a()), d5 - d3 + 2.0 * (this.g + 100.0 + q3.b()));
    }
}

