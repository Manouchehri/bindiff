/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import y.c.b;
import y.c.c;
import y.c.i;
import y.d.q;
import y.d.r;
import y.d.t;
import y.d.y;
import y.f.X;
import y.f.am;
import y.f.k.A;
import y.f.k.I;
import y.f.k.K;
import y.f.k.d;
import y.f.k.x;

class O
implements I {
    private I a;
    private r b;
    private y.c.q c;
    private y.c.y d;
    private y.c.A e;
    private y.c.A f;
    private I g;

    public O(I i2, y.c.q q2, y.c.y y2, y.c.A a2, y.c.A a3, r r2) {
        int n2;
        block3 : {
            n2 = d.g;
            this.a = i2;
            this.c = q2;
            this.e = a2;
            this.d = y2;
            this.f = a3;
            if (i2 instanceof O) {
                this.g = ((O)i2).a();
                if (n2 == 0) break block3;
            }
            this.g = i2;
        }
        if (r2 == null) {
            this.b = new r(0.0, 0.0, 0.0, 0.0);
            if (n2 == 0) return;
        }
        this.b = r2;
    }

    public I a() {
        return this.g;
    }

    @Override
    public void a(y.c.q q2, b b2) {
        this.a.a(q2, b2);
    }

    @Override
    public A a(c c2, c c3, X x2, y.c.q q2, byte by2) {
        A a2 = this.a.a(c2, c3, x2, q2, by2);
        y y2 = this.a(x2, q2, a2);
        a2.b(y2.c(), y2.d(), y2.a(), y2.b());
        this.f.a((Object)this.c, q2);
        x2.b(this.c, y2.a, y2.b);
        x2.c(this.c, y2.c - a2.i(), y2.d - a2.j());
        return a2;
    }

    private y a(X x2, y.c.q q2, A a2) {
        int n2 = d.g;
        y y2 = null;
        y.c.x x3 = this.d.a();
        do {
            if (!x3.f()) return new y(y2.c() - this.b.b, y2.d() - this.b.a, y2.a() + this.b.b + this.b.d, y2.b() + this.b.a + this.b.c);
            y.c.q q3 = x3.e();
            if (n2 != 0) return y2;
            if (q3 != this.c) {
                t t2;
                block4 : {
                    boolean bl2;
                    boolean bl3 = bl2 = q3.e() == null;
                    if (bl2) {
                        y.c.q q4 = (y.c.q)this.f.b(q3);
                        t t3 = this.a(q4, q2, x2, a2);
                        t t4 = x2.o(q3);
                        t2 = t.b(t3, t4);
                        if (n2 == 0) break block4;
                    }
                    t2 = this.a(q3, q2, x2, a2);
                }
                y2 = this.a(y2, new y(t2, x2.r(q3)));
            }
            x3.g();
        } while (n2 == 0);
        return new y(y2.c() - this.b.b, y2.d() - this.b.a, y2.a() + this.b.b + this.b.d, y2.b() + this.b.a + this.b.c);
    }

    /*
     * Unable to fully structure code
     */
    private t a(y.c.q var1_1, y.c.q var2_2, X var3_3, A var4_4) {
        var13_5 = d.g;
        if (var1_1 == var2_2) {
            var5_6 = new t(var4_4.i(), var4_4.j());
            if (var13_5 == 0) return var5_6;
        }
        var6_7 = 0.0;
        var8_8 = 0.0;
        var10_9 = var1_1.g().c();
        while (var10_9 != var2_2) {
            var11_10 = var10_9.g().c();
            var12_11 = this.a((y.c.q)var10_9);
            if (var11_10 != var2_2) ** GOTO lbl-1000
            var6_7 += var12_11.i() - var12_11.a;
            var8_8 += var12_11.j() - var12_11.b;
            if (var13_5 != 0) lbl-1000: // 2 sources:
            {
                var6_7 += var12_11.a;
                var8_8 += var12_11.b;
            }
            var10_9 = var11_10;
            if (var13_5 == 0) continue;
        }
        var11_10 = var3_3.a(var1_1);
        return new t(var11_10.getX() + var6_7, var11_10.getY() + var8_8);
    }

    private A a(y.c.q q2) {
        return (A)this.e.b(q2);
    }

    private y a(y y2, y y3) {
        if (y2 == null) {
            return y3;
        }
        if (y3 == null) {
            return y2;
        }
        double d2 = Math.min(y2.c(), y3.c());
        double d3 = Math.max(y2.c() + y2.a(), y3.c() + y3.a());
        double d4 = Math.min(y2.d(), y3.d());
        double d5 = Math.max(y2.d() + y2.b(), y3.d() + y3.b());
        return new y(d2, d4, d3 - d2, d5 - d4);
    }

    @Override
    public K a(x x2, X x3, y.c.q q2) {
        return this.a.a(x2, x3, q2);
    }
}

