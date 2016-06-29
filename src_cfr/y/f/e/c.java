/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.awt.Rectangle;
import y.a.A;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.x;
import y.c.y;
import y.d.q;
import y.d.t;
import y.f.X;
import y.f.e.i;
import y.f.k.o;
import y.g.I;

class C {
    X a;
    y.c.A b;
    f[] c;
    y[] d;
    I e;
    boolean f = false;

    C(X x2) {
        this.a = x2;
    }

    void a() {
        Object object;
        boolean bl2;
        int n2;
        Object object2;
        block9 : {
            C c2;
            o o2;
            block8 : {
                bl2 = i.b;
                this.b = this.a.t();
                this.e = new I(this.a);
                this.d = A.a(this.a);
                this.c = A.a((y.c.i)this.a, this.d);
                o2 = new o();
                if (this.d.length == 1 && this.d[0].size() == this.a.f()) {
                    o2.a(360);
                    if (!bl2) break block8;
                }
                o2.a(360);
            }
            this.e.a();
            n2 = 0;
            while (n2 < this.c.length) {
                block10 : {
                    f f2 = this.c[n2];
                    this.a(f2.a());
                    o2.a(this.a);
                    object2 = this.d[n2].b();
                    object = this.a.r((y.c.q)object2);
                    Rectangle rectangle = this.a.a();
                    this.a.b((y.c.q)object2, rectangle.width, rectangle.height);
                    rectangle.setSize((int)object.a(), (int)object.b());
                    c2 = this;
                    if (bl2) break block9;
                    c2.b.a(object2, rectangle);
                    while (!this.a.i()) {
                        this.a.c(this.a.k());
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block10;
                    }
                    ++n2;
                }
                if (!bl2) continue;
            }
            c2 = this;
        }
        c2.e.f();
        n2 = 0;
        block2 : do {
            if (n2 >= this.d.length) return;
            y y2 = this.d[n2];
            object2 = y2.a();
            if (object2.f()) {
                object = object2.e();
                object2.g();
                while (object2.f()) {
                    this.e.a(object2.e());
                    object2.g();
                    if (bl2) continue block2;
                    if (!bl2) continue;
                }
            }
            ++n2;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    void b() {
        var34_1 = i.b;
        this.e.f();
        var1_2 = new int[this.a.f()];
        var2_3 = 0;
        while (var2_3 < this.d.length) {
            v0 = var3_4 = this.d[var2_3];
            if (!var34_1) {
                block10 : {
                    var4_5 = v0.a();
                    while (var4_5.f()) {
                        var5_6 = var4_5.e();
                        var1_2[var5_6.d()] = var2_3 + 1;
                        var4_5.g();
                        if (!var34_1) {
                            if (!var34_1) continue;
                        }
                        break block10;
                    }
                    ++var2_3;
                }
                if (!var34_1) continue;
            }
            ** GOTO lbl26
        }
        var2_3 = 0;
        block2 : do {
            v1 = var2_3;
            v2 = this.d.length;
            block3 : while (v1 < v2) {
                v0 = var3_4 = this.d[var2_3];
lbl26: // 2 sources:
                var4_5 = v0.b();
                var5_6 = this.a.l((y.c.q)var4_5);
                var6_8 = (Rectangle)this.b.b(var4_5);
                var7_9 = this.a.r((y.c.q)var4_5);
                var8_10 = var5_6.a() - var7_9.a() / 2.0;
                var10_11 = var5_6.b() - var7_9.b() / 2.0;
                var12_12 = var6_8.x;
                var14_13 = var6_8.y;
                var16_14 = var8_10 - var12_12;
                var18_15 = var10_11 - var14_13;
                this.a.b((y.c.q)var4_5, var6_8.width, var6_8.height);
                this.a.a((y.c.q)var4_5, 0.0, 0.0);
                var20_16 = var1_2[var4_5.d()];
                var21_17 = 0.0;
                var23_18 = 0.0;
                if (var34_1 != false) return;
                var27_20 = var4_5.j();
                while (var27_20.f()) {
                    var28_22 = var27_20.a();
                    var29_24 = var28_22.a((y.c.q)var4_5);
                    v1 = var1_2[var29_24.d()];
                    v2 = var20_16;
                    if (var34_1) continue block3;
                    if (v1 != v2) {
                        var30_25 = var5_6.a() - this.a.j(var29_24);
                        var32_7 = var5_6.b() - this.a.k(var29_24);
                        var25_19 = Math.sqrt(var30_25 * var30_25 + var32_7 * var32_7);
                        var21_17 += (var30_25 /= var25_19);
                        var23_18 += (var32_7 /= var25_19);
                    }
                    var27_20.g();
                    if (!var34_1) continue;
                }
                if (var21_17 != 0.0 && var23_18 != 0.0) {
                    var25_19 = Math.sqrt(var21_17 * var21_17 + var23_18 * var23_18);
                    this.a(var3_4.a(), var21_17 /= var25_19, var23_18 /= var25_19);
                }
                var27_20 = var3_4.a();
                while (var27_20.f()) {
                    var28_23 = var27_20.e();
                    this.a.d(var28_23, var16_14, var18_15);
                    var27_20.g();
                    if (var34_1) continue block2;
                    if (!var34_1) continue;
                }
                ++var2_3;
                if (!var34_1) continue block2;
            }
            break block2;
            break;
        } while (true);
        this.a.a(this.b);
        this.c = null;
        this.d = null;
        this.e = null;
    }

    void a(x x2, double d2, double d3) {
        boolean bl2 = i.b;
        x2.i();
        do {
            if (!x2.f()) return;
            y.c.q q2 = x2.e();
            double d4 = this.a.j(q2);
            double d5 = this.a.k(q2);
            this.a.a(x2.e(), d4 * d2 - d3 * d5, d4 * d3 + d2 * d5);
            x2.g();
        } while (!bl2);
    }

    void a(e e2) {
        boolean bl2 = i.b;
        e2.i();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            if (!this.a.f(d2.c())) {
                this.a.d(d2.c());
            }
            if (!this.a.f(d2.d())) {
                this.a.d(d2.d());
            }
            if (!this.a.f(d2)) {
                this.a.e(d2);
            }
            e2.g();
        } while (!bl2);
    }
}

