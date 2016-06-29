/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import java.util.HashMap;
import java.util.Map;
import y.a.j;
import y.c.A;
import y.c.C;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.a.f;
import y.f.w;
import y.g.I;
import y.g.J;
import y.g.M;

class s
extends w {
    static final Object k = "y.layout.circular.CircularLayouter.CIRCULAR_CUSTOM_GROUPS_DPKEY";
    private A m;
    private A n;
    private A o;
    private A p;
    private A q;
    private h r;
    private i s;
    private Map t;
    byte l;
    private q u;
    private I v;
    private J w;
    private y.c.f x;

    public s(i i2) {
        this.s = i2;
        this.m = this.t();
        this.r = this.u();
    }

    y t(q q2) {
        return (y)this.m.b(q2);
    }

    y u(q q2) {
        return (y)this.p.b(q2);
    }

    /*
     * Unable to fully structure code
     */
    public void F() {
        var13_1 = f.u;
        if (this.n == null) {
            this.n = this.t();
        }
        var1_2 = new int[this.s.f() + 1];
        var2_3 = 1;
        var3_4 = this.o();
        block0 : do lbl-1000: // 3 sources:
        {
            if (var3_4.f() == false) return;
            var4_5 = this.t(var3_4.e());
            var5_6 = var4_5.a();
            while (var5_6.f()) {
                var6_7 = var5_6.e();
                var1_2[var6_7.d()] = var2_3;
                var5_6.g();
                if (var13_1 != 0) ** GOTO lbl-1000
                if (var13_1 == 0) continue;
            }
            var5_6 = new y.c.f();
            var6_7 = var4_5.a();
            block2 : do {
                v0 = var6_7.f();
                block3 : while (v0 != 0) {
                    var7_8 = var6_7.e();
                    var8_9 = var1_2[var7_8.d()];
                    if (var13_1 != 0) continue block0;
                    var9_10 = var7_8.l();
                    while (var9_10.f()) {
                        var10_11 = var9_10.a();
                        var11_12 = var10_11.d();
                        v0 = var12_13 = var1_2[var11_12.d()];
                        if (var13_1 != 0) continue block3;
                        if (v0 == var8_9) {
                            var5_6.c(var10_11);
                        }
                        var9_10.g();
                        if (var13_1 == 0) continue;
                    }
                    var6_7.g();
                    if (var13_1 == 0) continue block2;
                }
                break block2;
                break;
            } while (true);
            this.n.a((Object)var3_4.e(), var5_6);
            var3_4.g();
            ++var2_3;
        } while (var13_1 == 0);
    }

    void G() {
        C c2;
        s s2;
        int n2;
        block7 : {
            n2 = f.u;
            this.p = this.t();
            this.q = this.s.t();
            c2 = this.o();
            while (c2.f()) {
                q q2 = c2.e();
                s2 = this;
                if (n2 == 0) {
                    s2.p.a((Object)q2, new y());
                    c2.g();
                    if (n2 == 0) continue;
                }
                break block7;
            }
            s2 = this;
        }
        c2 = s2.p();
        do {
            boolean bl2 = c2.f();
            block2 : do {
                if (!bl2) return;
                d d2 = c2.a();
                y.c.f f2 = this.i(d2);
                e e2 = f2.a();
                while (e2.f()) {
                    q q2;
                    d d3 = e2.a();
                    q q3 = d3.c();
                    q q4 = d3.d();
                    bl2 = this.q.d(q3);
                    if (n2 != 0) continue block2;
                    if (!bl2) {
                        q2 = (q)this.o.b(q3);
                        this.u(q2).add(q3);
                        this.q.a((Object)q3, true);
                    }
                    if (!this.q.d(q4)) {
                        q2 = (q)this.o.b(q4);
                        this.u(q2).add(q4);
                        this.q.a((Object)q4, true);
                    }
                    e2.g();
                    if (n2 == 0) continue;
                }
                break block2;
                break;
            } while (true);
            c2.g();
        } while (n2 == 0);
    }

    y.c.f i(d d2) {
        return (y.c.f)this.r.b(d2);
    }

    void a(d d2, y.c.f f2) {
        this.r.a((Object)d2, f2);
    }

    public void a(byte by2) {
        int n2 = f.u;
        this.l = by2;
        this.o = this.s.t();
        switch (by2) {
            case 2: {
                this.a(this.s.c(k));
                if (n2 == 0) break;
            }
            case 0: {
                A a2 = this.s.t();
                j.a(this.s, a2);
                this.a(a2);
                this.s.a(a2);
                if (n2 == 0) break;
            }
            case 1: {
                this.I();
            }
        }
        this.w = new J(this.s, this.o);
        this.G();
        this.J();
        this.F();
        this.O();
    }

    protected void a(c c2) {
        this.b(c2);
        this.H();
    }

    /*
     * Unable to fully structure code
     */
    void b(c var1_1) {
        var10_2 = f.u;
        var2_3 = new HashMap<Object, q>();
        var4_4 = this.s.o();
        while (var4_4.f()) {
            var5_6 = var4_4.e();
            var6_9 = var1_1.b(var5_6);
            if (var6_9 == null) ** GOTO lbl-1000
            if (var2_3.containsKey(var6_9)) ** GOTO lbl-1000
            var7_11 = this.d();
            var2_3.put(var6_9, var7_11);
            var3_5 = new y();
            this.m.a((Object)var7_11, var3_5);
            var3_5.add(var5_6);
            this.o.a((Object)var5_6, var7_11);
            if (var10_2 != 0) lbl-1000: // 2 sources:
            {
                var7_12 = var2_3.get(var6_9);
                var3_5 = (y)this.m.b(var7_12);
                var3_5.add(var5_6);
                this.o.a((Object)var5_6, var7_12);
                ** if (var10_2 == 0) goto lbl27
            }
            ** GOTO lbl27
lbl-1000: // 2 sources:
            {
                var7_13 = this.d();
                var3_5 = new y();
                this.m.a((Object)var7_13, var3_5);
                var3_5.add(var5_6);
                this.o.a((Object)var5_6, var7_13);
            }
lbl27: // 3 sources:
            var4_4.g();
            if (var10_2 == 0) continue;
        }
        var4_4 = this.s.p();
        do {
            if (var4_4.f() == false) return;
            var5_8 = var4_4.a();
            var6_9 = (q)this.o.b(var5_8.c());
            if (var6_9 == (var7_15 = (q)this.o.b(var5_8.d()))) ** GOTO lbl43
            var8_16 = var6_9.c(var7_15);
            if (var8_16 != null) ** GOTO lbl-1000
            var8_16 = this.a((q)var6_9, var7_15);
            var9_17 = new y.c.f();
            var9_17.add(var5_8);
            this.a(var8_16, var9_17);
            if (var10_2 != 0) lbl-1000: // 2 sources:
            {
                this.i(var8_16).add(var5_8);
            }
lbl43: // 4 sources:
            var4_4.g();
        } while (var10_2 == 0);
    }

    protected void H() {
        h h2;
        int n2;
        boolean[] arrbl;
        e e2;
        block7 : {
            y.c.f f2;
            Object object;
            block6 : {
                n2 = f.u;
                h2 = this.u();
                object = this.p();
                while (object.f()) {
                    arrbl = object.a();
                    f2 = this.i((d)arrbl);
                    if (n2 == 0) {
                        int n3 = f2.size();
                        h2.a((Object)arrbl, 1.0 / (double)(n3 * n3));
                        object.g();
                        if (n2 == 0) continue;
                    }
                    break block6;
                }
                f2 = y.a.y.a(this, h2);
            }
            object = f2;
            arrbl = new boolean[this.g()];
            this.x = new y.c.f();
            e2 = object.a();
            while (e2.f()) {
                arrbl[e2.a().b()] = true;
                e2.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block7;
            }
            e2 = this.p();
        }
        while (e2.f()) {
            d d2 = e2.a();
            if (n2 != 0) return;
            if (!arrbl[d2.b()]) {
                this.x.add(d2);
            }
            e2.g();
            if (n2 == 0) continue;
        }
        this.v = new I(this);
        this.v.a(this.x);
        this.a(h2);
    }

    /*
     * Unable to fully structure code
     */
    void I() {
        block22 : {
            block21 : {
                var20_1 = f.u;
                var1_2 = this.s.t();
                var2_3 = M.b(new int[this.s.g()]);
                var3_4 = y.a.h.a(this.s, var2_3, var1_2);
                var4_5 = y.a.h.a(this.s, var2_3, var3_4);
                var5_6 = new HashMap<q[], q>();
                var6_7 = new boolean[this.s.f()];
                var7_8 = this.s.o();
                while (var7_8.f()) {
                    var8_11 = var7_8.e();
                    v0 = var1_2.d(var8_11);
                    if (var20_1 == 0) {
                        if (v0 != 0) {
                            var9_12 = this.d();
                            var10_19 = new y();
                            var10_19.add(var8_11);
                            this.m.a((Object)var9_12, var10_19);
                            var5_6.put(var8_11, var9_12);
                            this.o.a((Object)var8_11, var9_12);
                        }
                        var7_8.g();
                        if (var20_1 == 0) continue;
                    }
                    break block21;
                }
                v0 = 0;
            }
            var7_9 = v0;
            block1 : do {
                v1 = var7_9;
                block2 : while (v1 < var4_5.length) {
                    var8_11 = var4_5[var7_9];
                    v2 = var8_11.size();
                    if (var20_1 != 0) break block22;
                    if (v2 != 1 || !var1_2.d((var9_14 = var8_11.b()).c()) || !var1_2.d(var9_14.d())) ** GOTO lbl-1000
                    var10_19 = this.a((q)var5_6.get(var9_14.c()), (q)var5_6.get(var9_14.d()));
                    var11_20 = new y.c.f();
                    var11_20.add(var9_14);
                    this.a((d)var10_19, (y.c.f)var11_20);
                    if (var20_1 != 0) lbl-1000: // 2 sources:
                    {
                        var9_15 = this.d();
                        var10_19 = new y();
                        var11_20 = var8_11.a();
                        while (var11_20.f()) {
                            var12_21 = var11_20.a();
                            var13_22 = var12_21.c();
                            v1 = var6_7[var13_22.d()];
                            if (var20_1 != 0) continue block2;
                            if (v1 == 0 && !var1_2.d(var13_22)) {
                                var10_19.add(var13_22);
                                var6_7[var13_22.d()] = true;
                                this.o.a((Object)var13_22, var9_15);
                            }
                            if (!var6_7[(var13_22 = var12_21.d()).d()] && !var1_2.d(var13_22)) {
                                var10_19.add(var13_22);
                                var6_7[var13_22.d()] = true;
                                this.o.a((Object)var13_22, var9_15);
                            }
                            var11_20.g();
                            if (var20_1 == 0) continue;
                        }
                        this.m.a((Object)var9_15, var10_19);
                        var5_6.put(var8_11, var9_15);
                    }
                    ++var7_9;
                    if (var20_1 == 0) continue block1;
                }
                break block1;
                break;
            } while (true);
            v2 = this.s.h();
        }
        var7_10 = new y.c.f[v2];
        var8_11 = new q[2];
        var9_17 = false;
        block4 : do {
            v3 = var9_18;
            block5 : while (v3 < var4_5.length) {
                var10_19 = var4_5[var9_18];
                var11_20 = (q)var5_6.get(var10_19);
                if (var20_1 != 0) return;
                if (var11_20 != null) {
                    block23 : {
                        var12_21 = var10_19.a();
                        while (var12_21.f()) {
                            var7_10[var12_21.a().b()] = var10_19;
                            var12_21.g();
                            if (var20_1 == 0) {
                                if (var20_1 == 0) continue;
                            }
                            break block23;
                        }
                        var12_21 = var10_19.a();
                    }
                    block7 : do {
                        v4 = var12_21.f();
                        block8 : while (v4) {
                            var8_11[0] = var12_21.a().c();
                            var8_11[1] = var12_21.a().d();
                            v3 = 0;
                            if (var20_1 != 0) continue block5;
                            var13_24 = v3;
                            block9 : do {
                                v5 = var13_24;
                                block10 : while (v5 < 2) {
                                    var14_25 = var8_11[var13_24];
                                    var15_26 = (q)var5_6.get(var14_25);
                                    v4 = var1_2.d(var14_25);
                                    if (var20_1 != 0) continue block8;
                                    if (v4 && var15_26.c((q)var11_20) == null) {
                                        var16_27 = new y.c.f();
                                        var17_28 = var14_25.j();
                                        while (var17_28.f()) {
                                            var18_29 = var17_28.a();
                                            var19_30 = var18_29.a(var14_25);
                                            v5 = (int)var1_2.d(var19_30) ? 1 : 0;
                                            if (var20_1 != 0) continue block10;
                                            if (v5 == 0 && var7_10[var18_29.b()] == var10_19) {
                                                var16_27.add(var18_29);
                                            }
                                            var17_28.g();
                                            if (var20_1 == 0) continue;
                                        }
                                        var17_28 = this.a((q)var11_20, var15_26);
                                        this.a((d)var17_28, var16_27);
                                    }
                                    ++var13_24;
                                    if (var20_1 == 0) continue block9;
                                }
                                break block9;
                                break;
                            } while (true);
                            var12_21.g();
                            if (var20_1 == 0) continue block7;
                        }
                        break block7;
                        break;
                    } while (true);
                }
                ++var9_18;
                if (var20_1 == 0) continue block4;
            }
            break block4;
            break;
        } while (true);
        this.s.a(var1_2);
    }

    void J() {
        int n2 = f.u;
        this.t = new HashMap();
        if (this.l == 1) {
            e e2 = this.p();
            while (e2.f()) {
                d d2 = e2.a();
                block1 : do {
                    d d3 = d2;
                    y.c.f f2 = this.i(d3);
                    if (n2 != 0) return;
                    if (f2.size() <= 1) break;
                    e e3 = f2.a();
                    q q2 = this.t(d3.d()).b();
                    q q3 = e3.a().a(q2);
                    e3.g();
                    while (e3.f()) {
                        q q4 = e3.a().a(q2);
                        d2 = q3.c(q4);
                        if (n2 != 0) continue block1;
                        if (d2 == null) {
                            d d4 = this.s.a(q3, q4);
                            this.t.put(d4, Boolean.TRUE);
                        }
                        q3 = q4;
                        e3.g();
                        if (n2 == 0) continue;
                    }
                    break block1;
                    break;
                } while (true);
                e2.g();
                if (n2 == 0) continue;
            }
        }
        this.w.a(this.o);
    }

    void K() {
        int n2 = f.u;
        e e2 = this.s.p();
        do {
            if (!e2.f()) return;
            if (this.t.containsKey(e2.a())) {
                this.s.a(e2.a());
            }
            e2.g();
        } while (n2 == 0);
    }

    void L() {
        this.K();
        this.s.a(this.o);
        this.s.a(this.q);
    }

    protected void M() {
        q q2;
        block3 : {
            s s2;
            int n2 = f.u;
            int n3 = -1;
            q q3 = null;
            x x2 = this.o();
            while (x2.f()) {
                q q4 = x2.e();
                s2 = this;
                q2 = q4;
                if (n2 == 0) {
                    if (s2.t(q2).size() > n3) {
                        q3 = q4;
                        n3 = this.t(q4).size();
                    }
                    x2.g();
                    if (n2 == 0) continue;
                }
                break block3;
            }
            s2 = this;
            q2 = q3;
        }
        s2.u = q2;
    }

    public q N() {
        return this.u;
    }

    void O() {
        this.M();
        y.c.f f2 = y.a.A.a((i)this, this.u);
    }

    public void P() {
        this.w.a();
    }

    public void Q() {
        this.w.b();
    }

    public void v(q q2) {
        this.w.b((Object)q2);
    }

    public void w(q q2) {
        this.w.a((Object)q2);
    }

    public q x(q q2) {
        return (q)this.o.b(q2);
    }
}

