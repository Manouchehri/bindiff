/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.c.A;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.g.M;
import y.g.p;

public class I {
    private i c;
    protected f a;
    protected y b;
    private boolean d = true;

    public I(i i2) {
        this.c = i2;
        this.a = new f();
        this.b = new y();
    }

    public void a() {
        boolean bl2 = p.c;
        x x2 = this.c.o();
        do {
            if (!x2.f()) return;
            this.a(x2.e());
            x2.g();
        } while (!bl2);
    }

    public void b() {
        boolean bl2 = p.c;
        e e2 = this.c.p();
        do {
            if (!e2.f()) return;
            this.a(e2.a());
            e2.g();
        } while (!bl2);
    }

    public void c() {
        boolean bl2 = p.c;
        e e2 = this.c.p();
        do {
            if (!e2.f()) return;
            if (e2.a().e()) {
                this.a(e2.a());
            }
            e2.g();
        } while (!bl2);
    }

    public void d() {
        this.c();
        this.e();
    }

    /*
     * Unable to fully structure code
     */
    public void e() {
        var8_1 = p.c;
        var1_2 = this.c.t();
        var2_3 = this.c.o();
        while (var2_3.f()) {
            block5 : {
                var3_4 = var2_3.e();
                if (var8_1 != false) return;
                var4_5 = var3_4.j();
                while (var4_5.f()) {
                    var5_6 = var4_5.a();
                    var6_7 = var5_6.a(var3_4);
                    v0 = var7_8 = (d)var1_2.b(var6_7);
                    if (var8_1) ** GOTO lbl23
                    if (v0 == var5_6) ** GOTO lbl18
                    if (var7_8 != null) ** GOTO lbl-1000
                    var1_2.a((Object)var6_7, var5_6);
                    if (var8_1) lbl-1000: // 2 sources:
                    {
                        this.a(var5_6);
                    }
lbl18: // 4 sources:
                    var4_5.g();
                    if (!var8_1) continue;
                }
                var4_5 = var3_4.j();
                while (var4_5.f()) {
                    v0 = var5_6 = var4_5.a();
lbl23: // 2 sources:
                    var6_7 = v0.a(var3_4);
                    var1_2.a((Object)var6_7, null);
                    var4_5.g();
                    if (!var8_1) {
                        if (!var8_1) continue;
                    }
                    break block5;
                }
                var2_3.g();
            }
            if (!var8_1) continue;
        }
        this.c.a(var1_2);
    }

    public void f() {
        this.g();
        this.h();
    }

    /*
     * Unable to fully structure code
     */
    public void g() {
        var2_1 = p.c;
        do lbl-1000: // 3 sources:
        {
            if (this.b.isEmpty() != false) return;
            var1_2 = this.b.d();
            if (this.c.f(var1_2)) ** GOTO lbl-1000
            this.b(var1_2);
        } while (!var2_1);
    }

    /*
     * Unable to fully structure code
     */
    public void h() {
        var2_1 = p.c;
        do lbl-1000: // 3 sources:
        {
            if (this.a.isEmpty() != false) return;
            var1_2 = this.a.d();
            if (this.c.f(var1_2)) ** GOTO lbl-1000
            this.b(var1_2);
        } while (!var2_1);
    }

    public void a(q q2) {
        boolean bl2;
        boolean bl3;
        block7 : {
            d d2;
            bl2 = p.c;
            d d3 = q2.g();
            while (d3 != null) {
                d2 = d3;
                d3 = d3.h();
                this.a.c(d2);
                bl3 = this.d;
                if (!bl2) {
                    if (bl3) {
                        this.c.d(d2);
                        if (!bl2) continue;
                    }
                    this.c.a(d2);
                    if (!bl2) continue;
                }
                break block7;
            }
            d3 = q2.f();
            while (d3 != null) {
                d2 = d3;
                d3 = d3.g();
                this.a.c(d2);
                bl3 = this.d;
                if (!bl2) {
                    if (bl3) {
                        this.c.d(d2);
                        if (!bl2) continue;
                    }
                    this.c.a(d2);
                    if (!bl2) continue;
                }
                break block7;
            }
            this.b.c(q2);
            bl3 = this.d;
        }
        if (bl3) {
            this.c.c(q2);
            if (!bl2) return;
        }
        this.c.a(q2);
    }

    public void a(d d2) {
        this.a.c(d2);
        if (this.d) {
            this.c.d(d2);
            if (!p.c) return;
        }
        this.c.a(d2);
    }

    public void a(f f2) {
        boolean bl2 = p.c;
        y.c.p p2 = f2.k();
        do {
            if (p2 == null) return;
            this.a((d)p2.c());
            p2 = p2.a();
        } while (!bl2);
    }

    public void a(y y2) {
        boolean bl2 = p.c;
        y.c.p p2 = y2.k();
        do {
            if (p2 == null) return;
            this.a((q)p2.c());
            p2 = p2.a();
        } while (!bl2);
    }

    public void a(e e2) {
        boolean bl2 = p.c;
        do {
            if (!e2.f()) return;
            this.a(e2.a());
            e2.g();
        } while (!bl2);
    }

    public static void a(i i2, e e2) {
        boolean bl2 = p.c;
        e2.i();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            if (!i2.f(d2.c())) {
                i2.d(d2.c());
            }
            if (!i2.f(d2.d())) {
                i2.d(d2.d());
            }
            if (!i2.f(d2)) {
                i2.e(d2);
            }
            e2.g();
        } while (!bl2);
    }

    public i i() {
        return this.c;
    }

    protected void b(d d2) {
        if (this.d) {
            this.c.e(d2);
            if (!p.c) return;
        }
        this.c.b(d2);
    }

    public void c(d d2) {
        if (d2.a() == null) {
            this.b(d2);
        }
        this.a.remove(d2);
    }

    /*
     * Unable to fully structure code
     */
    public void a(y var1_1, boolean var2_2) {
        block10 : {
            block9 : {
                var7_3 = p.c;
                var3_4 = new y();
                for (var4_5 = var1_1.k(); var4_5 != null; var4_5 = var4_5.a()) {
                    var5_6 = (q)var4_5.c();
                    v0 = var5_6.e();
                    if (!var7_3) {
                        if (v0 != null) continue;
                        this.b((q)var5_6);
                        var3_4.add(var5_6);
                        if (!var7_3) continue;
                    }
                    break block9;
                }
                v0 = this.c;
            }
            var4_5 = M.a(new boolean[v0.e()]);
            for (var5_6 = var3_4.k(); var5_6 != null; var5_6 = var5_6.a()) {
                var4_5.a(var5_6.c(), true);
                if (!var7_3) {
                    if (!var7_3) continue;
                }
                break block10;
            }
            var5_6 = this.b.k();
        }
        while (var5_6 != null) {
            v1 = ((q)var5_6.c()).e();
            if (!var7_3) {
                if (v1 == this.c) {
                    this.b.h((y.c.p)var5_6);
                }
                var5_6 = var5_6.a();
                if (!var7_3) continue;
            }
            ** GOTO lbl35
        }
        if (var2_2 == false) return;
        var5_6 = this.a.k();
        do {
            if (var5_6 == null) return;
            v1 = var5_6.c();
lbl35: // 2 sources:
            if ((var6_7 = (d)v1).c().e() == this.c && var6_7.d().e() == this.c && (var4_5.d(var6_7.d()) || var4_5.d(var6_7.c()))) {
                this.a.h((y.c.p)var5_6);
                this.b(var6_7);
            }
            var5_6 = var5_6.a();
        } while (!var7_3);
    }

    public void a(q q2, boolean bl2) {
        boolean bl3 = p.c;
        if (q2.e() == null) {
            this.b(q2);
        }
        this.b.remove(q2);
        if (!bl2) return;
        y.c.p p2 = this.a.k();
        do {
            if (p2 == null) return;
            d d2 = (d)p2.c();
            if (d2.c() == q2 && d2.d().e() == this.c || d2.d() == q2 && d2.c().e() == this.c) {
                this.a.h(p2);
                this.b(d2);
            }
            p2 = p2.a();
        } while (!bl3);
    }

    protected void b(q q2) {
        if (this.d) {
            this.c.d(q2);
            if (!p.c) return;
        }
        this.c.b(q2);
    }
}

