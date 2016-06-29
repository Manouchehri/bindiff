/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import y.c.C;
import y.c.D;
import y.c.i;
import y.d.t;
import y.f.S;
import y.f.X;
import y.f.aG;
import y.f.am;
import y.f.f.b.e;
import y.f.f.b.h;
import y.f.f.b.n;
import y.f.f.d.A;
import y.f.f.d.B;
import y.f.f.d.E;
import y.f.f.d.J;
import y.f.f.d.K;
import y.f.f.d.M;
import y.f.f.d.c;
import y.f.f.d.d;
import y.f.f.d.f;
import y.f.f.d.o;
import y.f.f.d.s;
import y.f.f.d.z;
import y.f.h.N;
import y.f.h.p;
import y.f.h.q;
import y.f.v;
import y.f.x;

public class y {
    private static int q = 0;
    private static boolean r = false;
    protected i a;
    protected h b;
    protected M c;
    protected i d;
    protected v e;
    protected K f;
    protected boolean g = true;
    protected D h;
    protected int i;
    private boolean s = false;
    protected y.c.A j;
    protected y.c.h k;
    protected y.c.h l;
    protected y.c.h m;
    protected int n = -1;
    protected int o = -1;
    protected int p;

    public y(h h2, short s2, int n2) {
        this.a = h2.a();
        this.b = h2;
        this.i = n2;
        if (this.i < 1) {
            throw new IllegalArgumentException("Invalid grid distance !");
        }
        this.c = this.a(s2);
        if (this.c == null) {
            throw new IllegalArgumentException("Invalid node model !");
        }
        this.g = this.c.a();
    }

    protected M a(short s2) {
        switch (s2) {
            case 3: {
                return new c();
            }
            case 2: {
                return new J(this.i);
            }
            case 1: {
                return new E(this.i);
            }
            case 4: {
                return new s();
            }
            case 0: {
                return new d(this.i);
            }
        }
        return null;
    }

    public static void a(boolean bl2) {
        if (bl2) {
            q = 1;
            r = true;
            if (!o.p) return;
        }
        q = 0;
        r = false;
    }

    public void b(boolean bl2) {
        this.s = bl2;
    }

    public K a() {
        return this.f;
    }

    public D b() {
        return this.h;
    }

    /*
     * Unable to fully structure code
     */
    public void c() {
        block27 : {
            block26 : {
                block25 : {
                    block22 : {
                        var23_1 = o.p;
                        this.c.a(this.b);
                        var1_2 = this.a.t();
                        var2_3 = this.b.d();
                        var3_4 = var2_3.a().a();
                        var4_5 = 30.0;
                        var6_6 = this.a.u();
                        this.d = new i();
                        if (y.r) {
                            this.e = new v();
                        }
                        this.f = new K(this.d);
                        this.j = this.a.t();
                        this.h();
                        this.k = this.a.u();
                        this.l = this.a.u();
                        this.i();
                        this.a(this.b, this.f);
                        var7_7 = this.b.p();
                        y.g.o.a(this, 3, "-----> Create edges for nodes:");
                        var8_8 = this.a.o();
                        while (var8_8.f()) {
                            var9_9 = null;
                            var10_10 = var8_8.e();
                            var11_17 = new y.c.q[4];
                            var12_18 = (A)this.j.b(var10_10);
                            var11_17[0] = var12_18.a();
                            var11_17[1] = var12_18.d();
                            var11_17[2] = var12_18.c();
                            var11_17[3] = var12_18.b();
                            v0 = this;
                            if (var23_1) break block22;
                            var13_19 = v0.a(var10_10);
                            if (var13_19 != null) {
                                var9_9 = var10_10.a(var13_19);
                            }
                            v1 = var13_19;
                            block1 : do {
                                var14_20 = v1;
                                for (var15_21 = 0; var15_21 < 4; ++var15_21) {
                                    block24 : {
                                        v1 = var13_19;
                                        if (var23_1) continue block1;
                                        var16_22 = v1 != null;
                                        var17_23 = var11_17[var15_21];
                                        var18_24 = y.q;
                                        while (var16_22) {
                                            v2 = this.b.g(var14_20);
                                            v3 = var15_21;
                                            if (!var23_1) {
                                                if (v2 == v3) {
                                                    block23 : {
                                                        var19_25 = (y.c.q)this.k.b(var14_20);
                                                        var20_26 = (y.c.q)this.l.b(var14_20);
                                                        var21_27 = this.a(var10_10, (y.c.q)var17_23, var19_25, var15_21, var4_5, var18_24);
                                                        var1_2.a((Object)var10_10, var21_27);
                                                        var17_23 = (y.c.q)this.k.b(var14_20);
                                                        var22_28 = this.d.a(var19_25, var20_26);
                                                        if (var7_7[var14_20.b()]) {
                                                            this.f.s(var22_28);
                                                        }
                                                        this.f.a(var22_28, this.b.e(var14_20));
                                                        this.f.b(var22_28, 1.0);
                                                        if (this.b.j(var14_20)) {
                                                            this.f.b(var22_28, Math.max(this.b.i(var14_20), 1));
                                                            if (!var23_1) break block23;
                                                        }
                                                        this.f.b(var22_28, 1);
                                                    }
                                                    this.f.c(var22_28, this.b.l(var14_20));
                                                    this.f.d(var22_28, this.b.m(var14_20));
                                                    var6_6.a((Object)var14_20, var22_28);
                                                    var9_9.b();
                                                    var14_20 = var9_9.a();
                                                    if (var14_20 != var13_19) continue;
                                                    var16_22 = false;
                                                    if (!var23_1) break;
                                                }
                                                var16_22 = false;
                                                if (!var23_1) break;
                                            }
                                            break block24;
                                        }
                                        v2 = var15_21;
                                        v3 = 3;
                                    }
                                    if (v2 == v3) {
                                        this.a(var10_10, (y.c.q)var17_23, (y.c.q)var11_17[0], 3, var4_5, y.q);
                                        if (!var23_1) continue;
                                    }
                                    this.a(var10_10, (y.c.q)var17_23, (y.c.q)var11_17[var15_21 + 1], var15_21, var4_5, y.q);
                                    if (!var23_1) continue;
                                }
                                break;
                            } while (true);
                            var8_8.g();
                            if (!var23_1) continue;
                        }
                        v0 = this;
                    }
                    var8_8 = v0.a.p();
                    while (var8_8.f()) {
                        var9_9 = var8_8.a();
                        v4 = var9_9.d();
                        if (!var23_1) {
                            if (v4.d() < var9_9.c().d()) {
                                var10_12 = this.b.a((y.c.d)var9_9);
                                this.f.a((y.c.d)var6_6.b(var9_9), (y.c.d)var6_6.b(var10_12));
                            }
                            var8_8.g();
                            if (!var23_1) continue;
                        }
                        break block25;
                    }
                    y.g.o.a(this, 3, "Create Faces:");
                    this.f.f();
                    this.k();
                    v4 = var6_6.b(var3_4);
                }
                var8_8 = (y.c.d)v4;
                this.f.a(this.f.b((y.c.d)var8_8));
                this.h = new D();
                var9_9 = this.a.o();
                while (var9_9.f()) {
                    var10_14 = var9_9.e();
                    v5 = this;
                    if (!var23_1) {
                        if (v5.c.a(var10_14)) {
                            var11_17 = (y.c.d)var1_2.b(var10_14);
                            var12_18 = this.f.b((y.c.d)var11_17);
                            this.h.add(var12_18);
                        }
                        var9_9.g();
                        if (!var23_1) continue;
                    }
                    break block26;
                }
                this.j();
                v5 = this;
            }
            var9_9 = v5.d.p();
            while (var9_9.f()) {
                var10_16 = var9_9.a();
                v6 = this.f.g(var10_16.c());
                if (!var23_1) {
                    if (v6 && this.f.g(var10_16.d()) && !this.f.j(var10_16)) {
                        this.f.b(var10_16, 0);
                    }
                    var9_9.g();
                    if (!var23_1) continue;
                }
                ** GOTO lbl136
            }
            y.g.o.a(this, 3, "-----> Center Edges:");
            this.m = this.a.u();
            var9_9 = this.a.p();
            do {
                v6 = var9_9.f();
lbl136: // 2 sources:
                if (!v6) break;
                this.m.a((Object)var9_9.a(), 0.0);
                var9_9.g();
                if (var23_1) break block27;
            } while (!var23_1);
            this.d();
            this.a.a(var6_6);
            this.a.a(var1_2);
        }
        if (i.g == false) return;
        o.p = var23_1 == false;
    }

    private void a(h h2, h h3) {
        boolean bl2 = o.p;
        C c2 = h2.i();
        do {
            if (!c2.f()) return;
            n n2 = (n)c2.d();
            h3.a(this.a(n2));
            c2.g();
        } while (!bl2);
    }

    private n a(n n2) {
        n n3;
        boolean bl2 = o.p;
        y.c.q q2 = n2.a();
        y.c.q q3 = n2.b();
        A a2 = (A)this.j.b(q2);
        A a3 = (A)this.j.b(q3);
        y.f.f.b.o o2 = n2.e();
        if (o2 == y.f.f.b.o.c) {
            n3 = new n(a2.b(), a3.a(), n2.c(), n2.d(), o2);
            if (!bl2) return n3;
        }
        if (o2 == y.f.f.b.o.a) {
            n3 = new n(a2.a(), a3.b(), n2.c(), n2.d(), o2);
            if (!bl2) return n3;
        }
        if (o2 != y.f.f.b.o.b) return new n(a2.a(), a3.d(), n2.c(), n2.d(), o2);
        n3 = new n(a2.d(), a3.a(), n2.c(), n2.d(), o2);
        if (!bl2) return n3;
        return new n(a2.a(), a3.d(), n2.c(), n2.d(), o2);
    }

    protected void d() {
        if (this.c.c()) {
            this.m();
            if (!o.p) return;
        }
        this.l();
    }

    /*
     * Unable to fully structure code
     */
    private void h() {
        var8_1 = o.p;
        var1_2 = this.a.o();
        do {
            if (var1_2.f() == false) return;
            var2_3 = var1_2.e();
            if (this.c.a(var2_3)) ** GOTO lbl-1000
            var3_4 = this.d.d();
            if (this.b.d(var2_3)) {
                this.f.c((y.c.q)var3_4);
            }
            if (this.b.g(var2_3)) {
                this.f.f((y.c.q)var3_4);
            }
            if (this.b.b(var2_3)) {
                this.f.c((y.c.q)var3_4);
            }
            this.j.a((Object)var2_3, new z((y.c.q)var3_4));
            if (var8_1) lbl-1000: // 2 sources:
            {
                var3_4 = new B();
                var4_5 = this.d.d();
                this.f.l(var4_5);
                var3_4.a(var4_5);
                var5_6 = this.d.d();
                this.f.l(var5_6);
                var3_4.d(var5_6);
                var6_7 = this.d.d();
                this.f.l(var6_7);
                var3_4.c(var6_7);
                var7_8 = this.d.d();
                this.f.l(var7_8);
                var3_4.b(var7_8);
                this.j.a((Object)var2_3, var3_4);
            }
            var1_2.g();
        } while (!var8_1);
    }

    /*
     * Unable to fully structure code
     */
    protected y.c.d a(y.c.q var1_1) {
        block11 : {
            var8_2 = o.p;
            if (var1_1.c() == 0) {
                return null;
            }
            var2_3 = new short[]{0, 0, 0, 0};
            var3_4 = 4;
            var5_5 = null;
            var6_6 = var1_1.l();
            while (var6_6.f()) {
                var5_5 = var6_6.a();
                var7_7 = this.b.g(var5_5);
                var2_3[var7_7] = 1;
                v0 = var7_7;
                v1 = var3_4;
                if (!var8_2) {
                    if (v0 < v1) {
                        var3_4 = var7_7;
                    }
                    var6_6.g();
                    if (!var8_2) continue;
                }
                break block11;
            }
            v0 = var2_3[0] + var2_3[1] + var2_3[2] + var2_3[3];
            v1 = 1;
        }
        if (v0 == v1) ** GOTO lbl38
        var6_6 = var1_1.l();
        var4_8 = true;
        while (var4_8) {
            var5_5 = var6_6.a();
            v2 = this.b.g(var5_5);
            v3 = var3_4;
            if (!var8_2) {
                if (v2 != v3) {
                    var4_8 = false;
                }
                var6_6.b();
                if (!var8_2) continue;
            }
            ** GOTO lbl56
        }
        var4_8 = true;
        ** GOTO lbl50
lbl38: // 1 sources:
        var4_9 = true;
        var6_6 = var1_1.l();
        while (var4_9) {
            v4 = var6_6.a();
            if (var8_2 != false) return v4;
            var5_5 = v4;
            if (this.b.d(var5_5) == 4) {
                var4_9 = false;
            }
            var6_6.b();
            if (!var8_2) continue;
        }
        v4 = var5_5;
        return v4;
lbl50: // 2 sources:
        while (var4_8) {
            v5 = var6_6.a();
            if (var8_2 != false) return v5;
            var5_5 = v5;
            v2 = this.b.g(var5_5);
            v3 = var3_4;
lbl56: // 2 sources:
            if (v2 == v3) {
                var4_8 = false;
            }
            var6_6.b();
            if (!var8_2) continue;
        }
        v5 = var5_5;
        return v5;
    }

    /*
     * Unable to fully structure code
     */
    private y.c.d a(y.c.q var1_1, y.c.q var2_2, y.c.q var3_3, int var4_4, double var5_5, int var7_6) {
        if (var2_2.equals(var3_3)) {
            return null;
        }
        var8_7 = y.f.f.b.o.a(var4_4).a();
        var9_8 = y.f.f.b.o.a(var4_4).b();
        var10_9 = this.d.a(var2_2, var3_3);
        this.f.a(var10_9, var8_7.toString());
        this.f.b(var10_9, var5_5);
        this.f.b(var10_9, var7_6);
        var11_10 = var3_3.l();
        if (var11_10.f()) ** GOTO lbl-1000
        var12_11 = this.d.a(var3_3, var2_2);
        if (o.p) lbl-1000: // 2 sources:
        {
            var11_10.g();
            var13_12 = var11_10.a();
            var12_11 = this.d.a(var3_3, var13_12, var2_2, null, 1, 0);
        }
        this.f.a(var12_11, var9_8.toString());
        this.f.b(var12_11, var5_5);
        this.f.b(var12_11, var7_6);
        this.f.a(var10_9, var12_11);
        return var12_11;
    }

    private void i() {
        C c2;
        Object object;
        boolean bl2;
        block5 : {
            y y2;
            bl2 = o.p;
            c2 = this.a.o();
            block0 : do {
                int n2 = c2.f();
                if (n2 == 0) break;
                y.c.q q2 = c2.e();
                object = this.b.h(q2);
                y2 = this;
                if (bl2) break block5;
                y.c.d d2 = y2.a(q2);
                int n3 = 0;
                while (n3 < 4) {
                    block6 : {
                        n2 = 0;
                        if (bl2) break block0;
                        for (int i2 = v1583820; i2 < object[n3]; ++i2) {
                            y.c.q q3 = this.a(d2);
                            this.k.a((Object)d2, q3);
                            d2 = this.b.b().j(d2);
                            if (!bl2) {
                                if (!bl2) continue;
                            }
                            break block6;
                        }
                        ++n3;
                    }
                    if (!bl2) continue;
                }
                c2.g();
            } while (!bl2);
            y2 = this;
        }
        c2 = y2.a.p();
        do {
            if (!c2.f()) return;
            y.c.d d3 = c2.a();
            object = this.b.a(d3);
            this.l.a((Object)d3, this.k.b(object));
            this.l.a(object, this.k.b(d3));
            c2.g();
        } while (!bl2);
    }

    private y.c.q a(y.c.d d2) {
        y.c.q q2;
        if (!this.c.a(d2.c())) {
            A a2 = (A)this.j.b(d2.c());
            q2 = a2.a();
            if (!o.p) return q2;
        }
        q2 = this.d.d();
        this.f.e(q2);
        return q2;
    }

    private void j() {
        boolean bl2 = o.p;
        y.c.x x2 = this.a.o();
        do {
            if (!x2.f()) return;
            y.c.q q2 = x2.e();
            if (this.c.a(q2)) {
                A a2 = (A)this.j.b(q2);
                y.c.q q3 = a2.a();
                y.c.q q4 = a2.c();
                int n2 = this.c.d(q2) ? 0 : 1;
                n n3 = new n(q3, q4, this.c.b(q2), n2, y.f.f.b.o.b);
                this.f.a(n3);
                n n4 = new n(q3, q4, this.c.c(q2), n2, y.f.f.b.o.c);
                this.f.a(n4);
            }
            x2.g();
        } while (!bl2);
    }

    private void k() {
        boolean bl2 = o.p;
        q q2 = this.f.c();
        do {
            if (!q2.f()) return;
            p p2 = q2.a();
            y.c.e e2 = p2.a();
            y.c.d d2 = e2.a();
            e2.g();
            y.c.d d3 = e2.a();
            block1 : do {
                y.c.d d4 = e2.a();
                y.f.f.b.o o2 = this.f.h(d2).c();
                int n2 = o2.f();
                int n3 = this.f.g(d4);
                this.f.a(d4, y.f.f.b.o.a(n3 - n2).f());
                d2 = d4;
                e2.b();
                do {
                    if (e2.a() != d3) continue block1;
                    q2.g();
                } while (bl2);
                break;
            } while (true);
        } while (!bl2);
    }

    private void l() {
        boolean bl2 = o.p;
        y.g.o.a(this, 1, "Do not center edges !");
        y.c.x x2 = this.a.o();
        do {
            int n2 = x2.f();
            block1 : do {
                if (n2 == 0) return;
                y.c.q q2 = x2.e();
                if (!this.c.a(q2)) break;
                int[][] arrn = this.b.i(q2);
                for (int i2 = 0; i2 < 4; ++i2) {
                    int n3;
                    y.f.f.b.o o2 = y.f.f.b.o.a(i2);
                    int[] arrn2 = arrn[i2];
                    n2 = n3 = arrn2[0] + arrn2[1] + arrn2[2];
                    if (bl2) continue block1;
                    if (n2 == 0) continue;
                    y.c.f f2 = new y.c.f();
                    y.c.f f3 = new y.c.f();
                    y.c.d d2 = this.a(q2, o2, f2, f3, arrn2);
                    block3 : do {
                        y.c.d d3 = d2;
                        y.c.f f4 = new y.c.f();
                        f4.a(f2.a());
                        f4.add(d3);
                        f4.a(f3.a());
                        char c2 = o2.e() ? '>' : '_';
                        y.c.d d4 = null;
                        y.c.e e2 = f4.a();
                        while (e2.f()) {
                            y.c.d d5 = d4;
                            d4 = e2.a();
                            d2 = d5;
                            if (bl2) continue block3;
                            if (d2 != null) {
                                y.c.q q3 = (y.c.q)this.k.b(d5);
                                y.c.q q4 = (y.c.q)this.k.b(d4);
                                n n4 = new n(q3, q4, 1, 1, y.f.f.b.o.a(c2));
                                this.f.a(n4);
                            }
                            e2.g();
                            if (!bl2) continue;
                        }
                        break block3;
                        break;
                    } while (true);
                    if (!bl2) continue;
                }
                break;
            } while (true);
            x2.g();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private void m() {
        var30_1 = o.p;
        var1_2 = this.b.a().c(e.a);
        var2_3 = this.b.a().c("MIN_DIST_DP_KEY");
        var3_4 = this.c instanceof d != false && var1_2 != null;
        var4_5 = this.a.o();
        do {
            v0 = var4_5.f();
            block1 : do {
                if (v0 == 0) return;
                var5_6 = var4_5.e();
                if (!this.c.a(var5_6)) break;
                var6_7 = (A)this.j.b(var5_6);
                var7_8 = this.b.i(var5_6);
                for (var8_9 = 0; var8_9 < 4; ++var8_9) {
                    var9_10 = y.f.f.b.o.a(var8_9);
                    var10_11 = var7_8[var8_9];
                    v0 = var11_12 = var10_11[0] + var10_11[1] + var10_11[2];
                    if (var30_1) continue block1;
                    if (v0 == 0) continue;
                    var12_13 = new y.c.f();
                    var13_14 = new y.c.f();
                    var14_15 = this.a(var5_6, var9_10, var12_13, var13_14, var10_11);
                    var13_14.n();
                    var15_16 = 0;
                    var16_17 = 0;
                    if (var9_10.e()) {
                        var16_17 = this.c.e(var5_6);
                        var15_16 = this.c.b(var5_6);
                    }
                    if (var9_10.d()) {
                        var16_17 = this.c.f(var5_6);
                        var15_16 = this.c.c(var5_6);
                    }
                    var17_18 = (int)this.c.b();
                    var18_19 = (int)Math.ceil((double)var16_17 / (double)var17_18);
                    var19_20 = var16_17;
                    var20_21 = var16_17;
                    var21_22 = var18_19;
                    var22_23 = var18_19;
                    if (var2_3 == null || !this.b.d(var5_6)) ** GOTO lbl51
                    var23_25 = (f)var2_3.b(var5_6);
                    if (var23_25 == null) ** GOTO lbl49
                    var24_26 = (double)this.i / (double)var17_18;
                    if (!var9_10.e()) ** GOTO lbl-1000
                    var19_20 += (int)Math.floor((double)var23_25.c() / var24_26);
                    var20_21 += (int)Math.floor((double)var23_25.d() / var24_26);
                    if (var30_1) lbl-1000: // 2 sources:
                    {
                        if (var9_10.d()) {
                            var19_20 += (int)Math.floor((double)var23_25.a() / var24_26);
                            var20_21 += (int)Math.floor((double)var23_25.b() / var24_26);
                        }
                    }
lbl49: // 6 sources:
                    var21_22 = (int)Math.ceil((double)var19_20 / (double)var17_18);
                    var22_23 = (int)Math.ceil((double)var20_21 / (double)var17_18);
lbl51: // 2 sources:
                    var23_24 = (int)Math.floor((double)(var15_16 - var21_22 - var22_23) * 0.5);
                    this.a(var12_13, var6_7, var15_16, var23_24, var17_18, var20_21 + var19_20, var21_22, true);
                    if (var14_15 == null) ** GOTO lbl71
                    if (!var3_4 || var1_2.b(var5_6) == null) ** GOTO lbl-1000
                    var24_27 = (S)var1_2.b(var5_6);
                    var25_28 = var24_27.f();
                    var26_29 = this.b.c(var14_15) != false ? var9_10.c() : var9_10;
                    var27_30 = var26_29 == y.f.f.b.o.a || var26_29 == y.f.f.b.o.b;
                    var28_31 = var23_24 + var18_19;
                    var29_32 = var23_24 + var18_19;
                    if (var25_28.l() || var25_28.m()) ** GOTO lbl-1000
                    var28_31 = var27_30 != false ? 0 : 2 * var28_31;
                    v1 = var29_32 = var27_30 != false ? 2 * var29_32 : 0;
                    if (var30_1) lbl-1000: // 2 sources:
                    {
                        if (var25_28.l()) {
                            var28_31 = var27_30 != false ? 2 * var28_31 : 0;
                            var29_32 = var27_30 != false ? 0 : 2 * var29_32;
                        }
                    }
                    this.a(var14_15, var6_7, var28_31, var29_32);
                    if (var30_1) lbl-1000: // 2 sources:
                    {
                        this.a(var14_15, var6_7, var23_24 + var21_22, var23_24 + var22_23);
                    }
lbl71: // 4 sources:
                    this.a(var13_14, var6_7, var15_16, var23_24, var17_18, var20_21 + var19_20, var21_22, false);
                    if (!var30_1) continue;
                }
                break;
            } while (true);
            var4_5.g();
        } while (!var30_1);
    }

    /*
     * Unable to fully structure code
     */
    private void a(y.c.f var1_1, A var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, boolean var8_8) {
        block11 : {
            block10 : {
                var22_9 = o.p;
                var9_10 = var1_1.size();
                if (var9_10 == 0) {
                    return;
                }
                var10_11 = var8_8 != false ? 1 : -1;
                var11_12 = new int[var4_4 + 1];
                var12_13 = 1.0;
                if (var4_4 <= 0) ** GOTO lbl30
                var14_14 = (int)Math.ceil((double)var9_10 / (double)var4_4);
                var15_16 = var14_14 * var4_4 - var9_10;
                var11_12[0] = (int)Math.ceil((double)var14_14 * 0.5);
                var11_12[var4_4] = (int)Math.floor((double)var14_14 * 0.5);
                for (var16_17 = 1; var16_17 < var4_4; ++var16_17) {
                    var11_12[var16_17] = var14_14;
                    if (!var22_9) {
                        if (!var22_9) continue;
                    }
                    break block10;
                }
                var16_17 = 0;
            }
            while (var16_17 < var15_16) {
                v0 = var11_12;
                v1 = var16_17++;
                v0[v1] = v0[v1] - 1;
                if (!var22_9) {
                    if (!var22_9) continue;
                }
                break block11;
            }
            var12_13 = (double)var5_5 / (double)var14_14;
        }
        if (!var22_9) ** GOTO lbl35
lbl30: // 2 sources:
        var11_12[0] = var9_10;
        if (var3_3 != 0) ** GOTO lbl-1000
        var12_13 = 0.0;
        if (var22_9) lbl-1000: // 2 sources:
        {
            var12_13 = (double)(var3_3 * var5_5 - var6_6) / ((double)var9_10 * 2.0);
        }
lbl35: // 4 sources:
        var14_15 = var1_1.a();
        var15_16 = var7_7 + var4_4;
        var16_17 = 0;
        block2 : do {
            if (var16_17 >= var11_12.length) return;
            var17_18 = 0.0;
            if (var16_17 > 0) {
                var17_18 = (double)(- (int)Math.ceil((double)(var11_12[var16_17] - 1) / 2.0)) * var12_13;
            }
            if (var16_17 == var11_12.length - 1) {
                var17_18 = (double)(- var11_12[var16_17]) * var12_13;
            }
            for (var19_19 = 0; var19_19 < var11_12[var16_17]; var17_18 += var12_13, ++var19_19) {
                var20_20 = var14_15.a();
                var21_21 = var15_16 - var10_11 * (var4_4 - var16_17);
                this.a(var20_20, var2_2, var21_21, var3_3 - var21_21);
                var14_15.g();
                this.m.a((Object)var20_20, (double)var10_11 * var17_18);
                this.m.a((Object)this.b.a(var20_20), (double)var10_11 * var17_18);
                if (var22_9) continue block2;
                if (!var22_9) continue;
            }
            ++var16_17;
        } while (!var22_9);
    }

    private void a(y.c.d d2, A a2, int n2, int n3) {
        n n4 = null;
        n n5 = null;
        y.c.q q2 = (y.c.q)this.k.b(d2);
        y.f.f.b.o o2 = this.b.h(d2);
        if (o2.a(y.f.f.b.o.d)) {
            n4 = new n(a2.a(), q2, n2, 1, y.f.f.b.o.c);
            n5 = new n(q2, a2.b(), n3, 1, y.f.f.b.o.c);
        }
        if (o2.a(y.f.f.b.o.b)) {
            n4 = new n(a2.d(), q2, n2, 1, y.f.f.b.o.c);
            n5 = new n(q2, a2.c(), n3, 1, y.f.f.b.o.c);
        }
        if (o2.a(y.f.f.b.o.a)) {
            n4 = new n(a2.a(), q2, n2, 1, y.f.f.b.o.b);
            n5 = new n(q2, a2.d(), n3, 1, y.f.f.b.o.b);
        }
        if (o2.a(y.f.f.b.o.c)) {
            n4 = new n(a2.b(), q2, n2, 1, y.f.f.b.o.b);
            n5 = new n(q2, a2.c(), n3, 1, y.f.f.b.o.b);
        }
        this.f.a(n4);
        this.f.a(n5);
    }

    /*
     * Unable to fully structure code
     */
    protected y.c.d a(y.c.q var1_1, y.f.f.b.o var2_2, y.c.f var3_3, y.c.f var4_4, int[] var5_5) {
        block5 : {
            var13_6 = o.p;
            var3_3.clear();
            var4_4.clear();
            var6_7 = null;
            var7_8 = var1_1.a(this.a(var1_1));
            var8_9 = 0;
            var9_10 = var5_5[0] + var5_5[1] + var5_5[2];
            if (var9_10 == 0) {
                return null;
            }
            var10_11 = new y.c.f();
            var11_12 = new y.c.f();
            while (var8_9 < var9_10) {
                var12_13 = var7_8.a();
                v0 = this.b.h(var12_13).a(var2_2);
                if (var13_6) break block5;
                if (!v0) ** GOTO lbl25
                if (var8_9 >= var5_5[2]) ** GOTO lbl20
                var10_11.add(var12_13);
                if (!var13_6) ** GOTO lbl24
lbl20: // 2 sources:
                if (var8_9 != var5_5[2] || var5_5[1] != 1) ** GOTO lbl-1000
                var6_7 = var12_13;
                if (var13_6) lbl-1000: // 2 sources:
                {
                    var11_12.add(var12_13);
                }
lbl24: // 4 sources:
                ++var8_9;
lbl25: // 2 sources:
                var7_8.b();
                if (!var13_6) continue;
            }
            v0 = var2_2.a(y.f.f.b.o.d);
        }
        if (!v0 && !var2_2.a(y.f.f.b.o.c)) ** GOTO lbl-1000
        var10_11.n();
        var11_12.n();
        var3_3.a(var11_12.a());
        var4_4.a(var10_11.a());
        if (var13_6) lbl-1000: // 2 sources:
        {
            var3_3.a(var10_11.a());
            var4_4.a(var11_12.a());
        }
        if (var6_7 != null) return var6_7;
        if (var3_3.size() > var4_4.size()) {
            var6_7 = var3_3.c();
            var3_3.h(var3_3.l());
            if (var13_6 == false) return var6_7;
        }
        var6_7 = var4_4.b();
        var4_4.h(var4_4.k());
        return var6_7;
    }

    public void a(y.c.A a2, X x2) {
        block34 : {
            Object object;
            boolean bl2;
            double d3;
            double d2;
            Object object2;
            Object object3;
            Object object4;
            y y2;
            boolean bl3;
            block30 : {
                t t2;
                block29 : {
                    boolean bl4;
                    block28 : {
                        block27 : {
                            bl2 = o.p;
                            y.g.o.a(this, (Object)new StringBuffer().append("Grid: ").append(this.i).toString());
                            d3 = this.i;
                            d2 = this.i;
                            int n2 = Integer.MAX_VALUE;
                            int n3 = Integer.MIN_VALUE;
                            int n4 = Integer.MAX_VALUE;
                            int n5 = Integer.MIN_VALUE;
                            object2 = this.d.o();
                            while (object2.f()) {
                                object4 = object2.e();
                                object = (t)a2.b(object4);
                                n2 = Math.min(n2, (int)object.a());
                                n3 = Math.max(n3, (int)object.a());
                                n4 = Math.min(n4, (int)object.b());
                                n5 = Math.max(n5, (int)object.b());
                                object2.g();
                                if (!bl2) {
                                    if (!bl2) continue;
                                }
                                break block27;
                            }
                            this.n = n3 - n2;
                            this.o = n5 - n4;
                            this.p = 0;
                        }
                        object2 = this.a.p();
                        while (object2.f()) {
                            object4 = object2.a();
                            object = (t)a2.b(this.k.b(object4));
                            object3 = (t)a2.b(this.l.b(object4));
                            bl4 = this.b.h((y.c.d)object4).a(y.f.f.b.o.b);
                            if (!bl2) {
                                if (bl4) {
                                    this.p = (int)((double)this.p + (object3.a() - object.a()));
                                }
                                if (this.b.h((y.c.d)object4).a(y.f.f.b.o.c)) {
                                    this.p = (int)((double)this.p + (object3.b() - object.b()));
                                }
                                object2.g();
                                if (!bl2) continue;
                            }
                            break block28;
                        }
                        bl4 = r;
                    }
                    if (bl4) {
                        object2 = this.d.t();
                        object4 = this.d.o();
                        while (object4.f()) {
                            object = object4.e();
                            object3 = (t)a2.b(object);
                            t2 = new t(object3.a() * d3, object3.b() * d2);
                            x x3 = new x();
                            x3.setSize(20.0, 20.0);
                            x3.a(t2.a(), t2.b());
                            this.e.a(object, x3);
                            object2.a(object, new StringBuffer().append("").append(object.d()).toString());
                            object4.g();
                            if (!bl2) {
                                if (!bl2) continue;
                            }
                            break block29;
                        }
                        this.d.a((y.c.A)object2);
                    }
                    y.g.o.a(this, 3, "Merging nodes:");
                }
                object2 = this.a.o();
                while (object2.f()) {
                    object4 = object2.e();
                    object = (A)this.j.b(object4);
                    object3 = (t)a2.b(object.a());
                    t2 = (t)a2.b(object.c());
                    double d4 = (t2.a() - object3.a()) * d3;
                    double d5 = (t2.b() - object3.b()) * d2;
                    bl3 = this.b.d((y.c.q)object4);
                    if (!bl2) {
                        if (!bl3) {
                            x2.b((y.c.q)object4, 0.0, 0.0);
                        }
                        if (this.g) {
                            x2.a((y.c.q)object4, new y.d.q(d4 + d3 / 2.0, d5 + d2 / 2.0));
                        }
                        y.d.q q2 = x2.r((y.c.q)object4);
                        double d6 = q2.a();
                        double d7 = q2.b();
                        double d8 = object3.a() * d3 + (d4 - d6) / 2.0;
                        double d9 = object3.b() * d2 + (d5 - d7) / 2.0;
                        x2.b((y.c.q)object4, new t(d8, d9));
                        object2.g();
                        if (!bl2) continue;
                    }
                    break block30;
                }
                bl3 = this.s;
            }
            if (bl3) {
                this.a(x2);
            }
            object2 = this.a.p();
            while (object2.f()) {
                object4 = object2.a();
                object = object4.c();
                object3 = object4.d();
                double d10 = 0.0;
                double d11 = 0.0;
                y2 = this;
                if (!bl2) {
                    block33 : {
                        t t2;
                        block32 : {
                            void var20_29;
                            block31 : {
                                if (y2.b.h((y.c.d)object4).e()) {
                                    d10 = this.m.c(object4) * (double)this.i / this.c.b();
                                    if (!bl2) break block31;
                                }
                                d11 = this.m.c(object4) * (double)this.i / this.c.b();
                            }
                            t t3 = (t)a2.b(this.k.b(object4));
                            t t4 = new t(t3.a() * d3 + d10, t3.b() * d2 + d11);
                            t t5 = (t)a2.b(this.l.b(object4));
                            t2 = new t(t5.a() * d3 + d10, t5.b() * d2 + d11);
                            if (!this.g) {
                                if (this.b.h((y.c.d)object4).a(y.f.f.b.o.d)) {
                                    t t6 = new t(x2.m((y.c.q)object), t4.b());
                                    t2 = new t(x2.m((y.c.q)object3) + x2.p((y.c.q)object3), t2.b());
                                }
                                if (this.b.h((y.c.d)object4).a(y.f.f.b.o.b)) {
                                    void var20_23;
                                    t t7 = new t(x2.m((y.c.q)object) + x2.p((y.c.q)object), var20_23.b());
                                    t2 = new t(x2.m((y.c.q)object3), t2.b());
                                }
                                if (this.b.h((y.c.d)object4).a(y.f.f.b.o.a)) {
                                    void var20_25;
                                    t t8 = new t(var20_25.a(), x2.n((y.c.q)object));
                                    t2 = new t(t2.a(), x2.n((y.c.q)object3) + x2.q((y.c.q)object3));
                                }
                                if (this.b.h((y.c.d)object4).a(y.f.f.b.o.c)) {
                                    void var20_27;
                                    t t9 = new t(var20_27.a(), x2.n((y.c.q)object) + x2.q((y.c.q)object));
                                    t2 = new t(t2.a(), x2.n((y.c.q)object3));
                                }
                            }
                            if (this.b.d((y.c.q)object)) {
                                x2.c((y.c.d)object4, (t)var20_29);
                                if (!bl2) break block32;
                            }
                            x2.a((y.c.q)object, (t)var20_29);
                        }
                        if (this.b.d((y.c.q)object3)) {
                            x2.d((y.c.d)object4, t2);
                            if (!bl2) break block33;
                        }
                        x2.a((y.c.q)object3, t2);
                    }
                    object2.g();
                    if (!bl2) continue;
                }
                break block34;
            }
            this.a.a(this.j);
            this.a.a(this.m);
            this.a.a(this.k);
            this.a.a(this.l);
            y2 = this;
        }
        y2.c.d();
    }

    /*
     * Unable to fully structure code
     */
    private void a(X var1_1) {
        var18_2 = o.p;
        var2_3 = new y.c.f();
        var3_4 = (y.f.h.D)this.b.b();
        var4_5 = this.a.p();
        while (var4_5.f()) {
            var5_6 = var4_5.a();
            v0 = var3_4.n(var5_6);
            if (!var18_2) {
                if (!v0 && this.a(var5_6, var1_1) && var3_4.e(var5_6.c()) && var3_4.e(var5_6.d())) {
                    var2_3.add(var5_6);
                }
                var4_5.g();
                if (!var18_2) continue;
            }
            ** GOTO lbl17
        }
        var4_5 = var2_3.a();
        do {
            v0 = var4_5.f();
lbl17: // 2 sources:
            if (v0 == false) return;
            var5_6 = var4_5.a();
            var6_7 = var5_6.c().k();
            v1 = var6_7.a();
            block2 : while (v1 != null) {
                block13 : {
                    if (var3_4.n(var6_7.a())) {
                        var6_7.b();
                    }
                    var7_8 = var6_7.a();
                    var8_9 = var3_4.h(var7_8);
                    var6_7 = var5_6.d().l();
                    if (var6_7.a() == null) break;
                    if (var3_4.n(var6_7.a())) {
                        var6_7.b();
                    }
                    var9_10 = var6_7.a();
                    var10_11 = var3_4.h(var9_10);
                    if (var3_4.f(var7_8.c()) && var3_4.f(var9_10.d()) || !var3_4.f(var7_8.c()) && !var3_4.f(var9_10.d())) break;
                    if (!var3_4.f(var7_8.c())) {
                        var7_8 = var9_10;
                        var8_9 = var10_11;
                    }
                    var3_4.h(var5_6.c());
                    var11_12 = var3_4.h(var5_6.d());
                    var3_4.e(var11_12);
                    var12_13 = var3_4.h(var11_12);
                    this.m.a((Object)var11_12, this.m.c(var7_8));
                    this.m.a((Object)var12_13, this.m.c(var7_8));
                    this.b.a(var11_12, this.b.e(var7_8));
                    this.b.a(var12_13, this.b.e(var8_9));
                    this.k.a((Object)var11_12, this.k.b(var7_8));
                    this.l.a((Object)var11_12, this.l.b(var7_8));
                    this.l.a((Object)var12_13, this.k.b(var7_8));
                    this.k.a((Object)var12_13, this.l.b(var7_8));
                    var13_14 = var11_12;
                    block3 : while (var3_4.b(var13_14.c())) {
                        var14_15 = var3_4.d(var13_14);
                        var15_16 = var13_14.c().a(var13_14);
                        var15_16.b();
                        v2 = var15_16.a();
                        if (!var18_2) {
                            var16_17 = v2;
                            while (var3_4.d(var3_4.h(var16_17)) != var14_15) {
                                var15_16.b();
                                var16_17 = var15_16.a();
                                if (var18_2) continue block3;
                                if (!var18_2) continue;
                            }
                            var17_18 = var3_4.h(var16_17);
                            this.m.a((Object)var17_18, this.m.c(var7_8));
                            this.m.a((Object)var16_17, this.m.c(var7_8));
                            var13_14 = var17_18;
                            if (!var18_2) continue;
                        }
                        break block13;
                    }
                    v2 = var13_14 = var11_12;
                }
                block5 : while (var3_4.b(var13_14.d())) {
                    var14_15 = var3_4.d(var13_14);
                    var15_16 = var13_14.d().a(var13_14);
                    var15_16.b();
                    v1 = var15_16.a();
                    if (var18_2) continue block2;
                    var16_17 = v1;
                    while (var3_4.d(var16_17) != var14_15) {
                        var15_16.b();
                        var16_17 = var15_16.a();
                        if (var18_2) continue block5;
                        if (!var18_2) continue;
                    }
                    var17_18 = var3_4.h(var16_17);
                    this.m.a((Object)var16_17, this.m.c(var7_8));
                    this.m.a((Object)var17_18, this.m.c(var7_8));
                    var13_14 = var16_17;
                    if (!var18_2) continue;
                }
                break block2;
            }
            var4_5.g();
        } while (!var18_2);
    }

    private boolean a(y.c.d d2, X x2) {
        if (x2.m(d2.c()) != x2.m(d2.d())) return false;
        if (x2.n(d2.c()) != x2.n(d2.d())) return false;
        return true;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.o;
    }

    public int g() {
        return this.p;
    }
}

