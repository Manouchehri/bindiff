/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import java.util.Iterator;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;
import y.f.f.b.h;
import y.f.f.b.n;
import y.f.f.c.a;
import y.f.f.c.g;
import y.f.f.c.o;

public class p {
    private int a;
    private h b;
    private i c;
    private y.c.h d;
    private y.c.h e;
    private A f;
    private A g;
    private A h;
    private a i;
    private int j;
    private D k;
    private g[] l;
    private boolean m = false;

    public p(int n2, h h2) {
        this.a = n2;
        this.b = h2;
        this.a(n2, h2);
        this.a();
    }

    public void a() {
        this.b(this.a, this.b);
        this.c(this.a, this.b);
    }

    public void b() {
        this.b(this.a, this.b);
    }

    public void c() {
        this.b.a().a(this.h);
        this.c = null;
        this.i = null;
        this.k = null;
        this.l = null;
    }

    public Iterator d() {
        return this.k.iterator();
    }

    public C e() {
        return this.k.m();
    }

    public g a(q q2) {
        return (g)this.h.b(q2);
    }

    public g a(d d2) {
        return this.a(d2.c());
    }

    public double b(d d2) {
        if (!this.m) return this.d.c(d2);
        return this.a(d2.c(), d2.d());
    }

    public double a(q q2, q q3) {
        if (this.m) {
            return this.i.a(this.b(q2).b(), this.b(q3).b());
        }
        d d2 = q2.a(q3);
        if (d2 != null) return this.d.c(d2);
        return 2.147483647E9;
    }

    public g b(q q2) {
        return (g)this.f.b(q2);
    }

    public d a(g g2, g g3, int n2) {
        if (g2.c() != this.a) throw new RuntimeException("Invalid call to set min-dist !");
        if (g3.c() != this.a) {
            throw new RuntimeException("Invalid call to set min-dist !");
        }
        q q2 = g2.a();
        q q3 = g3.a();
        n2 += g2.k() + g3.j();
        if (!this.m) {
            d d2 = q2.a(q3);
            if (d2 == null) {
                d2 = this.c.a(q2, q3);
                this.d.a((Object)d2, (double)n2);
                this.a(d2, 0);
                if (g.a == 0) return d2;
            }
            if (this.d.c(d2) >= (double)n2) return d2;
            this.d.a((Object)d2, (double)n2);
            return d2;
        }
        if (this.i.a(g2.b(), g3.b()) == Integer.MAX_VALUE) {
            this.i.a(g2.b(), g3.b(), n2);
            d d3 = this.c.a(q2, q3);
            this.a(d3, 0);
            return d3;
        }
        if (this.i.a(g2.b(), g3.b()) >= n2) return null;
        this.i.a(g2.b(), g3.b(), n2);
        return null;
    }

    public o a(g g2) {
        q q2 = g2.a();
        return (o)this.g.b(q2);
    }

    public void a(d d2, int n2) {
        this.e.a((Object)d2, n2);
    }

    public int c(d d2) {
        Object object = this.e.b(d2);
        if (object != null) return this.e.a(d2);
        return 0;
    }

    /*
     * Unable to fully structure code
     */
    private void a(int var1_1, h var2_2) {
        block11 : {
            var12_3 = g.a;
            var3_4 = var2_2.a();
            switch (var1_1) {
                case 0: {
                    var4_5 = y.f.f.b.o.c;
                    var5_6 = y.f.f.b.o.a;
                    var6_7 = 0;
                    if (var12_3 == 0) ** GOTO lbl16
                }
                case 1: {
                    var4_5 = y.f.f.b.o.b;
                    var5_6 = y.f.f.b.o.d;
                    var6_7 = 1;
                    if (var12_3 == 0) ** GOTO lbl16
                }
            }
            y.g.o.a((Object)new StringBuffer().append("Constraint Graph Constructor: Unknown type:").append(var1_1).toString());
            return;
lbl16: // 2 sources:
            this.c = new i();
            this.f = this.c.t();
            this.h = var3_4.t();
            this.k = new D();
            this.j = 0;
            var7_8 = var3_4.o();
            while (var7_8.f()) {
                var8_9 = var7_8.e();
                var9_10 = this.a((q)var8_9, var5_6, var2_2);
                if (var12_3 == 0) {
                    if (var9_10 == null) {
                        var10_11 = this.c.d();
                        var11_12 = new g(var10_11, this.j, var6_7);
                        this.k.add(var11_12);
                        ++this.j;
                        this.f.a((Object)var10_11, var11_12);
                        this.h.a(var8_9, var11_12);
                        var11_12.a((q)var8_9);
                        var9_10 = this.a((q)var8_9, var4_5, var2_2);
                        while (var9_10 != null) {
                            var8_9 = var9_10.d();
                            var11_12.a((q)var8_9);
                            this.h.a(var8_9, var11_12);
                            var11_12.b(Math.max(var2_2.l(var9_10), var11_12.j()));
                            var11_12.c(Math.max(var2_2.m(var9_10), var11_12.k()));
                            var9_10 = this.a((q)var8_9, var4_5, var2_2);
                            if (var12_3 == 0) {
                                if (var12_3 == 0) continue;
                            }
                            break;
                        }
                    } else {
                        var7_8.g();
                    }
                    if (var12_3 == 0) continue;
                }
                break block11;
            }
            this.l = new g[this.j];
        }
        var7_8 = this.k.iterator();
        while (var7_8.hasNext()) {
            this.l[var8_9.b()] = var8_9 = (g)var7_8.next();
            if (var12_3 != 0) return;
            if (var12_3 == 0) continue;
        }
        this.d = this.c.u();
        this.e = this.c.u();
    }

    /*
     * Unable to fully structure code
     */
    private void b(int var1_1, h var2_2) {
        var12_3 = g.a;
        this.m = false;
        var3_4 = var2_2.a();
        var4_5 = this.c.p();
        while (var4_5.f()) {
            this.c.a(var4_5.a());
            var4_5.g();
            if (var12_3 == 0) {
                if (var12_3 == 0) continue;
            }
            ** GOTO lbl-1000
        }
        switch (var1_1) {
            case 0: lbl-1000: // 2 sources:
            {
                var4_5 = y.f.f.b.o.b;
                var5_6 = y.f.f.b.o.d;
                ** break;
            }
            case 1: {
                var4_5 = y.f.f.b.o.c;
                var5_6 = y.f.f.b.o.a;
                ** break;
            }
        }
        y.g.o.a(this, 1, new StringBuffer().append("Constraint Graph Constructor: Unknown type:").append(var1_1).toString());
        return;
lbl22: // 2 sources:
        var6_7 = var3_4.p();
        while (var6_7.f()) {
            var7_8 = var6_7.a();
            v0 = var2_2.j((d)var7_8);
            if (var12_3 == 0) {
                if (v0) {
                    var8_9 = null;
                    var9_10 = null;
                    if (var2_2.h((d)var7_8).a((y.f.f.b.o)var4_5)) {
                        var8_9 = this.a(var7_8.c());
                        var9_10 = this.a(var7_8.d());
                    }
                    if (var2_2.h((d)var7_8).a(var5_6)) {
                        var8_9 = this.a(var7_8.d());
                        var9_10 = this.a(var7_8.c());
                    }
                    if (var8_9 != null && var9_10 != null) {
                        var10_11 = this.a(var8_9, var9_10, var2_2.i((d)var7_8));
                        var11_12 = (int)var2_2.k((d)var7_8);
                        if (this.c(var10_11) < var11_12) {
                            this.a(var10_11, var11_12);
                        }
                    }
                }
                var6_7.g();
                if (var12_3 == 0) continue;
            }
            ** GOTO lbl47
        }
        var6_7 = var2_2.i();
        do {
            v0 = var6_7.f();
lbl47: // 2 sources:
            if (v0 == false) return;
            var7_8 = (n)var6_7.d();
            if (var7_8.d() != 2) {
                var8_9 = null;
                var9_10 = null;
                if (var7_8.e().a((y.f.f.b.o)var4_5)) {
                    var8_9 = this.a(var7_8.a());
                    var9_10 = this.a(var7_8.b());
                }
                if (var7_8.e().a(var5_6)) {
                    var8_9 = this.a(var7_8.b());
                    var9_10 = this.a(var7_8.a());
                }
                if (var8_9 != null && var9_10 != null) {
                    this.a(var8_9, var9_10, var7_8.c());
                }
            }
            var6_7.g();
        } while (var12_3 == 0);
    }

    /*
     * Unable to fully structure code
     */
    private void c(int var1_1, h var2_2) {
        var10_3 = g.a;
        y.g.o.a(this, 5, "Init max-dist graph: ");
        this.g = this.c.t();
        switch (var1_1) {
            case 0: {
                var3_4 = y.f.f.b.o.b;
                var4_5 = y.f.f.b.o.d;
                if (var10_3 == 0) ** GOTO lbl15
            }
            case 1: {
                var3_4 = y.f.f.b.o.c;
                var4_5 = y.f.f.b.o.a;
                if (var10_3 == 0) ** GOTO lbl15
            }
        }
        y.g.o.a(this, 5, new StringBuffer().append("Constraint Graph Constructor: Unknown type:").append(var1_1).toString());
        return;
lbl15: // 2 sources:
        var5_6 = var2_2.i();
        do {
            if (var5_6.f() == false) return;
            var6_7 = (n)var5_6.d();
            if (var6_7.d() != 1) {
                var7_8 = null;
                var8_9 = null;
                if (var6_7.e().a(var3_4)) {
                    var7_8 = this.a(var6_7.a());
                    var8_9 = this.a(var6_7.b());
                }
                if (var6_7.e().a(var4_5)) {
                    var7_8 = this.a(var6_7.b());
                    var8_9 = this.a(var6_7.a());
                }
                if (var7_8 != null && var8_9 != null) {
                    var9_10 = new o(var7_8, var8_9, var6_7.c());
                    this.g.a((Object)var7_8.a(), var9_10);
                    this.g.a((Object)var8_9.a(), var9_10);
                }
            }
            var5_6.g();
        } while (var10_3 == 0);
    }

    private d a(q q2, y.f.f.b.o o2, h h2) {
        int n2 = g.a;
        e e2 = q2.l();
        do {
            if (!e2.f()) return null;
            d d2 = e2.a();
            if (h2.h(d2).a(o2)) {
                return d2;
            }
            e2.g();
        } while (n2 == 0);
        return null;
    }

    public i f() {
        return this.c;
    }
}

