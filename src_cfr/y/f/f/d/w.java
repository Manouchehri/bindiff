/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import y.c.A;
import y.c.C;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.d.t;
import y.d.z;
import y.f.X;
import y.f.f.b.b;
import y.f.f.b.h;
import y.f.f.d.D;
import y.f.f.d.G;
import y.f.f.d.o;
import y.f.f.d.x;

public class w
implements b {
    private static boolean d = false;
    protected i a;
    protected h b;
    protected c c;
    private int e = 0;
    private int f = 10;
    private int g = 5;
    private int h = 2;

    public w() {
        this.c = new x(this);
    }

    @Override
    public void a(h h2) {
        this.b = h2;
        this.a = h2.a();
    }

    @Override
    public int b() {
        return this.e;
    }

    public void a(y.c.h h2) {
        this.c = h2;
    }

    @Override
    public void a() {
        boolean bl2 = o.p;
        X x2 = (X)this.a;
        A a2 = this.a.t();
        y.c.h h2 = this.a.u();
        this.a(x2, h2, this.c, a2);
        y.c.h h3 = this.a.u();
        this.b(h3);
        int n2 = 2 * (this.g + this.h);
        y.c.h h4 = x2.u();
        Object object = x2.p();
        while (object.f()) {
            h4.a((Object)object.a(), n2);
            object.g();
            if (!bl2) continue;
        }
        object = new G();
        object.a(this.b);
        object.a(a2);
        object.c(h3);
        object.a(h4);
        object.b(d);
        y.c.h h5 = this.a.u();
        object.b(h5);
        object.a();
        this.a(h5, h2);
        this.b.j();
        this.a.a(h5);
        this.a.a(h2);
        this.a.a(a2);
        this.a.a(h3);
        this.e = object.b();
        x2.a(h4);
    }

    private void b(y.c.h h2) {
        boolean bl2 = o.p;
        y.c.x x2 = this.a.o();
        do {
            boolean bl3 = x2.f();
            block1 : do {
                if (!bl3) return;
                q q2 = x2.e();
                if (!this.b.g(q2)) break;
                e e2 = q2.l();
                while (e2.f()) {
                    d d2 = e2.a();
                    bl3 = this.a(d2.d());
                    if (bl2) continue block1;
                    if (!bl3) {
                        h2.a((Object)this.b.a(d2), true);
                    }
                    e2.g();
                    if (!bl2) continue;
                }
                break block1;
                break;
            } while (true);
            x2.g();
        } while (!bl2);
    }

    private void a(y.c.h h2, y.c.h h3) {
        block6 : {
            w w2;
            boolean bl2 = o.p;
            y.f.f.b.o o2 = null;
            double d2 = Double.MAX_VALUE;
            d d3 = this.a.p().a();
            for (int i2 = 0; i2 < 4; ++i2) {
                y.f.f.b.o o3;
                double d4;
                double d5;
                block7 : {
                    o3 = y.f.f.b.o.a(i2);
                    this.b.a(h2, d3, o3);
                    d4 = 0.0;
                    w2 = this;
                    if (bl2) break block6;
                    e e2 = w2.a.p();
                    while (e2.f()) {
                        d d6 = e2.a();
                        d5 = (double)this.c.d(d6) ? 1 : 0;
                        if (!bl2) {
                            if (d5 == false && !this.c.d(this.b.a(d6))) {
                                int n2 = this.b.h(d6).b(2).g();
                                double d7 = (double)n2 * 3.141592653589793 / 2.0;
                                double d8 = h3.c(d6);
                                if (!Double.isNaN(d8)) {
                                    double d9 = y.d.b.a(d7, - d8);
                                    if (d9 > 3.141592653589793) {
                                        d9 = 6.283185307179586 - d9;
                                    }
                                    d4 += d9;
                                }
                            }
                            e2.g();
                            if (!bl2) continue;
                        }
                        break block7;
                    }
                    d5 = d4 DCMPG d2;
                }
                if (d5 >= 0) continue;
                d2 = d4;
                o2 = o3;
                if (!bl2) continue;
            }
            this.b.a(h2, d3, o2);
            w2 = this;
        }
        w2.b.l();
    }

    private boolean a(q q2) {
        if (this.b.b(q2)) return true;
        if (this.b.g(q2)) return true;
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private void a(X var1_1, y.c.h var2_2, c var3_3, A var4_4) {
        var20_5 = o.p;
        var5_6 = new double[var1_1.h()];
        var6_7 = new z(0.0, 1.0);
        var7_8 = var1_1.p();
        while (var7_8.f()) {
            var8_9 = var7_8.a();
            if (!var3_3.d(var8_9)) {
                var9_10 = new z(var1_1.q(var8_9), var1_1.p(var8_9));
                var5_6[var8_9.b()] = var10_11 = z.d(var6_7, (z)var9_10);
                var2_2.a((Object)var8_9, var10_11);
            }
            var7_8.g();
            if (!var20_5) continue;
        }
        var7_8 = var1_1.o();
        block1 : do {
            v0 = var7_8.f();
            block2 : do {
                block13 : {
                    if (v0 == false) return;
                    var8_9 = var7_8.e();
                    var9_10 = new y.c.D();
                    var10_12 = 0;
                    var11_13 = var8_9.l();
                    while (var11_13.f()) {
                        v1 = (int)var3_3.d(var11_13.a()) ? 1 : 0;
                        if (!var20_5) {
                            if (v1 == 0) {
                                ++var10_12;
                            }
                            var11_13.g();
                            if (!var20_5) continue;
                        }
                        break block13;
                    }
                    v1 = var10_12;
                }
                if (v1 < 2) break;
                var12_15 = var8_9.l();
                while (var3_3.d(var12_15.a())) {
                    var12_15.g();
                    if (var20_5) continue block1;
                    if (!var20_5) continue;
                }
                var13_16 = new D();
                var13_16.a(var12_15.a());
                var14_17 = new d[2];
                var14_17[0] = var12_15.a();
                var12_15.g();
                for (var15_18 = 0; var15_18 < var8_9.c(); ++var15_18) {
                    var14_17[1] = var12_15.a();
                    var13_16.a(var14_17[1]);
                    v0 = var3_3.d(var14_17[1]);
                    if (var20_5) continue block2;
                    if (v0) ** GOTO lbl76
                    var16_19 = y.d.b.a(var5_6[var14_17[1].b()], - var5_6[var14_17[0].b()]);
                    if (var16_19 != 0.0) ** GOTO lbl-1000
                    var18_20 = new z(var1_1.n(var14_17[0]));
                    if (!z.b(var18_20, var19_22 = new z(var1_1.n(var14_17[1])))) ** GOTO lbl-1000
                    var11_14 = -1;
                    if (var20_5) lbl-1000: // 2 sources:
                    {
                        var11_14 = 3;
                        ** if (!var20_5) goto lbl60
                    }
                    ** GOTO lbl60
lbl-1000: // 2 sources:
                    {
                        var18_21 = (int)Math.floor(2.0 * var16_19 / 3.141592653589793 + 0.5);
                        var11_14 = var18_21 - 1;
                    }
lbl60: // 3 sources:
                    var13_16.a(var11_14);
                    if (!this.b.g((q)var8_9)) ** GOTO lbl-1000
                    if (var11_14 != 0) ** GOTO lbl65
                    var13_16.a(new Integer(Math.max(0, 2 * (this.g - this.h))));
                    if (!var20_5) ** GOTO lbl72
lbl65: // 2 sources:
                    if (var11_14 != 2) ** GOTO lbl-1000
                    var13_16.a(new Integer(Math.max(0, 2 * (this.h - this.g))));
                    if (var20_5) lbl-1000: // 2 sources:
                    {
                        var13_16.a(new Integer(this.f));
                        ** if (!var20_5) goto lbl72
                    }
                    ** GOTO lbl72
lbl-1000: // 2 sources:
                    {
                        var13_16.a(new Integer(this.f));
                    }
lbl72: // 4 sources:
                    var9_10.add(var13_16);
                    var13_16 = new D();
                    var13_16.a(var14_17[1]);
                    var14_17[0] = var14_17[1];
lbl76: // 2 sources:
                    var12_15.b();
                    if (!var20_5) continue;
                }
                break;
            } while (true);
            var4_4.a((Object)var8_9, var9_10);
            var7_8.g();
        } while (!var20_5);
    }
}

