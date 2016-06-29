/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.awt.geom.Rectangle2D;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.e;
import y.c.f;
import y.c.h;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.d.m;
import y.d.s;
import y.d.t;
import y.d.y;
import y.f.I;
import y.f.X;
import y.f.a;
import y.f.aE;
import y.f.ah;
import y.f.i.aD;
import y.f.i.aF;
import y.f.i.aH;
import y.f.i.aJ;
import y.f.i.aL;
import y.f.i.aM;
import y.f.i.aN;
import y.f.i.aO;
import y.f.i.aP;
import y.f.i.ae;
import y.f.i.ai;
import y.f.i.aj;
import y.f.i.ak;
import y.f.i.ao;
import y.f.i.aq;
import y.f.i.av;
import y.f.i.v;
import y.g.a.d;

class aK
extends a {
    private X p;
    private aH q;
    private A r;
    private h s;
    private A t;
    private i u;
    private h v;
    private h w;
    private D x;
    private D y;
    private c z;
    private c A;
    private c B;
    private aF C;
    private A D;
    private A E;
    private D F;
    boolean a;
    boolean b;
    boolean c;
    t d;
    int e;
    int f;
    double g;
    byte h;
    Object i = ah.g_;
    Object n = ah.h_;
    Set o;

    aK() {
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void c(X var1_1) {
        block9 : {
            var4_2 = v.f;
            if (this.h == 2 ? (var3_4 = var1_1.c(var2_3 = this.n)) == null : this.h == 4 && (var3_4 = var1_1.c(var2_3 = this.i)) == null) {
                throw new IllegalStateException(new StringBuffer().append("No DataProvider ").append(var2_3).append(" registered with graph!").toString());
            }
            var2_3 = this.a();
            if (var2_3 != null) {
                var2_3.c(var1_1);
            }
            if (var1_1.h() == 0) {
                return;
            }
            this.p = var1_1;
            this.w = var1_1.u();
            var3_4 = var1_1.p();
            while (var3_4.f()) {
                this.w.a((Object)var3_4.a(), new ae(var3_4.a()));
                var3_4.g();
                if (var4_2 == 0) {
                    if (var4_2 == 0) continue;
                }
                break block9;
            }
            this.g();
            this.u = new i();
            this.t = this.u.t();
            this.r = this.u.t();
            this.s = this.u.u();
            this.q = new aH();
            this.v = var1_1.u();
            this.b(var1_1);
            this.i();
            this.h();
            this.b();
        }
        switch (this.h) {
            case 4: {
                this.e();
                if (var4_2 == 0) ** GOTO lbl38
            }
            case 2: {
                this.f();
                if (var4_2 == 0) ** GOTO lbl38
            }
        }
        this.c();
lbl38: // 3 sources:
        this.d();
        var1_1.a(this.v);
        var1_1.a(this.w);
        this.C = null;
        this.A = null;
        this.z = null;
        this.B = null;
        this.A = null;
        this.y = null;
        this.x = null;
        this.D = null;
    }

    /*
     * Unable to fully structure code
     */
    private void g() {
        var9_1 = v.f;
        var7_2 = this.p.p();
        do {
            if (var7_2.f() == false) return;
            var3_3 = var7_2.a();
            var6_6 = (ae)this.w.b(var3_3);
            var4_4 = aE.d(this.p, var3_3);
            var5_5 = aE.e(this.p, var3_3);
            if (var4_4 != null && var4_4.a()) {
                var6_6.b(true, true);
            }
            if (var5_5 != null && var5_5.a()) {
                var6_6.b(false, true);
            }
            v0 = var8_7 = this.p.k(var3_3).size() == 0;
            if (!var8_7) ** GOTO lbl-1000
            if (!var6_6.b(true)) ** GOTO lbl-1000
            if (var6_6.b(false)) ** GOTO lbl-1000
            var6_6.c(false, true);
            if (var9_1 != 0) lbl-1000: // 3 sources:
            {
                ** if (!var8_7) goto lbl23
            }
            ** GOTO lbl23
lbl-1000: // 2 sources:
            {
                if (!var6_6.b(true) && var6_6.b(false)) {
                    var6_6.c(true, true);
                }
            }
lbl23: // 5 sources:
            var7_2.g();
        } while (var9_1 == 0);
    }

    private void h() {
        C c2;
        int n2;
        i i2;
        int n3;
        ao ao2;
        q q2;
        int n4;
        block9 : {
            n3 = v.f;
            i2 = new i();
            if (this.D != null) {
                i2.a(this.D);
            }
            this.D = i2.t();
            this.C = new aF();
            n2 = 0;
            c2 = this.y.m();
            while (c2.f()) {
                ++n2;
                ao2 = (ao)c2.d();
                n4 = (int)(ao2.t() DCMPL ao2.u());
                if (n3 == 0) {
                    if (n4 != 0) {
                        q2 = i2.d();
                        this.C.a(ao2, q2);
                        this.D.a((Object)q2, ao2);
                    }
                    c2.g();
                    if (n3 == 0) continue;
                }
                break block9;
            }
            n4 = 0;
        }
        n2 = n4;
        c2 = this.x.m();
        do {
            boolean bl2 = c2.f();
            block2 : do {
                if (!bl2) return;
                ++n2;
                ao2 = (ao)c2.d();
                if (ao2.t() == ao2.u()) break;
                q2 = i2.d();
                this.C.a(ao2, q2);
                this.D.a((Object)q2, ao2);
                Rectangle2D.Double double_ = new Rectangle2D.Double(ao2.k.a, ao2.k.b, ao2.l.a - ao2.k.a, ao2.l.b - ao2.k.b);
                C c3 = ((D)this.B.b(ao2)).m();
                boolean bl3 = false;
                while (c3.f()) {
                    ao ao3 = (ao)c3.d();
                    bl2 = ao3.t() DCMPL ao3.u();
                    if (n3 != 0) continue block2;
                    if (bl2) {
                        Rectangle2D.Double double_2 = new Rectangle2D.Double(ao3.k.a, ao3.k.b, ao3.l.a - ao3.k.a, ao3.l.b - ao3.k.b);
                        q q3 = (q)this.C.b(ao3);
                        if (q3 != null && double_.intersects(double_2)) {
                            i2.a(q2, (q)this.C.b(ao3));
                        }
                    }
                    c3.g();
                    if (n3 == 0) continue;
                }
                break block2;
                break;
            } while (true);
            c2.g();
        } while (n3 == 0);
    }

    private void i() {
        av av2;
        block2 : {
            av2 = new av(this.p, new f());
            if (this.c) {
                av2.a(5 * this.e);
                av2.b(0.5);
                if (v.f == 0) break block2;
            }
            av2.b(this.g);
        }
        av2.b(true);
        av2.a(8);
        av2.g();
        this.x = av2.a();
        this.y = av2.b();
        this.z = av2.c();
        this.A = av2.d();
        this.B = av2.e();
    }

    void b() {
        int n2 = v.f;
        e e2 = this.p.p();
        do {
            if (!e2.f()) return;
            y.c.d d2 = e2.a();
            if (!this.v.d(d2)) {
                this.a(d2);
            }
            e2.g();
        } while (n2 == 0);
    }

    private void a(y.c.d d2) {
        ai ai2;
        t t2;
        int n2;
        ae ae2;
        m m2;
        s s2;
        m m3;
        t t3;
        block9 : {
            n2 = v.f;
            s2 = null;
            m3 = null;
            m2 = null;
            Object var9_6 = null;
            q q2 = d2.c();
            ae2 = (ae)this.w.b(d2);
            if (ae2 == null) {
                ae2 = new ae(d2);
                this.w.a((Object)d2, ae2);
            }
            s2 = this.p.l(d2).j();
            m3 = s2.a();
            t3 = m3.c();
            t2 = m3.d();
            if (this.p.s(q2).a(t3) && this.p.s(q2).a(t2)) {
                this.v.a((Object)d2, true);
                return;
            }
            ai2 = this.a(d2, t3, t2, q2);
            if (ai2 == null) {
                this.v.a((Object)d2, true);
                return;
            }
            if (ai2.x()) {
                ai2.a(d2, t3.a, t3.b, t2.b);
                if (n2 == 0) break block9;
            }
            ai2.a(d2, t3.b, t3.a, t2.a);
        }
        this.q.a(m3, ai2);
        ae2.a(m3);
        s2.g();
        do {
            ai ai3;
            block10 : {
                if (!s2.f()) return;
                m2 = s2.a();
                t3 = m2.c();
                ai3 = this.a(d2, t3, t2 = m2.d(), ai2);
                if (ai3 == null) {
                    this.v.a((Object)d2, true);
                    return;
                }
                if (ai3.x()) {
                    ai3.a(d2, t3.a, t3.b, t2.b);
                    if (n2 == 0) break block10;
                }
                ai3.a(d2, t3.b, t3.a, t2.a);
            }
            this.q.a(m2, ai3);
            ae2.a(m2);
            ai2 = ai3;
            s2.g();
        } while (n2 == 0);
    }

    private ai a(y.c.d d2, t t2, t t3, q q2) {
        int n2 = v.f;
        byte[] arrby = new byte[]{1, 2, 8, 4};
        ai ai2 = null;
        aJ aJ2 = (aJ)this.A.b(q2);
        int n3 = this.a(q2, t2, t3);
        if (n3 == -9) {
            return null;
        }
        D d3 = null;
        double d4 = 0.0;
        switch (arrby[n3]) {
            case 1: {
                d3 = aJ2.a;
                d4 = t2.a;
                break;
            }
            case 2: {
                d3 = aJ2.c;
                d4 = t2.a;
                break;
            }
            case 8: {
                d3 = aJ2.e;
                d4 = t2.b;
                break;
            }
            case 4: {
                d3 = aJ2.g;
                d4 = t2.b;
            }
        }
        boolean bl2 = false;
        C c2 = d3.m();
        do {
            if (!c2.f()) return ai2;
            if (bl2) return ai2;
            ai ai3 = (ai)c2.d();
            if (d4 >= ai3.t() && d4 < ai3.u()) {
                bl2 = true;
                ai2 = ai3;
            }
            c2.g();
        } while (n2 == 0);
        return ai2;
    }

    private ai a(y.c.d d2, t t2, t t3, ai ai2) {
        int n2 = v.f;
        ai ai3 = null;
        q q2 = (q)this.C.b(ai2);
        double d3 = ai2.x() ? t2.b : t2.a;
        boolean bl2 = false;
        e e2 = q2.j();
        do {
            if (!e2.f()) return ai3;
            if (bl2) return ai3;
            ai ai4 = (ai)this.D.b(e2.a().a(q2));
            if (d3 >= ai4.t() && d3 < ai4.u()) {
                bl2 = true;
                ai3 = ai4;
            }
            e2.g();
        } while (n2 == 0);
        return ai3;
    }

    private int a(q q2, t t2, t t3) {
        double d2;
        int n2;
        int n3 = v.f;
        if (Math.abs(t2.a - t3.a) < 0.01) {
            d2 = this.p.n(q2) + this.p.q(q2) / 2.0;
            n2 = t3.b <= d2 ? 0 : 1;
            if (n3 == 0) return n2;
        }
        if (Math.abs(t2.b - t3.b) >= 0.01) return -9;
        d2 = this.p.m(q2) + this.p.p(q2) / 2.0;
        n2 = t3.a <= d2 ? 2 : 3;
        if (n3 == 0) return n2;
        return -9;
    }

    /*
     * Unable to fully structure code
     */
    void c() {
        block17 : {
            var7_1 = v.f;
            var2_2 = new d(this.p);
            this.E = this.p.t();
            var4_3 = this.p.o();
            while (var4_3.f()) {
                var1_4 = var4_3.e();
                var5_6 = new aO(this, var1_4, null);
                this.E.a((Object)var1_4, var5_6);
                v0 = var3_5 = var5_6.c().size();
                if (var7_1 == 0) {
                    if (v0 > 0) {
                        var2_2.a(var1_4, - var3_5);
                    }
                    var4_3.g();
                    if (var7_1 == 0) continue;
                }
                ** GOTO lbl18
            }
            do lbl-1000: // 4 sources:
            {
                v0 = var2_2.a();
lbl18: // 2 sources:
                if (v0 != 0) break;
                var1_4 = var2_2.b();
                var4_3 = (aO)this.E.b(var1_4);
                this.a(var1_4, var4_3.c());
                this.u.j();
                v1 = var4_3.b();
                if (var7_1 != 0) break block17;
                if (!v1) ** GOTO lbl32
                var3_5 = var4_3.c().size();
                if (var3_5 <= 0) ** GOTO lbl30
                var2_2.c(var1_4, - var3_5);
                if (var7_1 == 0) ** GOTO lbl-1000
lbl30: // 2 sources:
                var2_2.c();
                if (var7_1 == 0) ** GOTO lbl-1000
lbl32: // 2 sources:
                var2_2.c();
            } while (var7_1 == 0);
            v1 = this.b;
        }
        if (!v1) ** GOTO lbl97
        var4_3 = this.p.o();
        block2 : while (var4_3.f()) {
            var1_4 = var4_3.e();
            var5_6 = (aJ)this.A.b(var1_4);
            v2 = var5_6.a.m();
            if (var7_1 == 0) {
                block20 : {
                    block19 : {
                        block18 : {
                            var6_7 = v2;
                            while (var6_7.f()) {
                                ((ai)var6_7.d()).c(false);
                                var6_7.g();
                                if (var7_1 == 0) {
                                    if (var7_1 == 0) continue;
                                }
                                break block18;
                            }
                            var6_7 = var5_6.c.m();
                        }
                        while (var6_7.f()) {
                            ((ai)var6_7.d()).c(true);
                            var6_7.g();
                            if (var7_1 == 0) {
                                if (var7_1 == 0) continue;
                            }
                            break block19;
                        }
                        var6_7 = var5_6.e.m();
                    }
                    while (var6_7.f()) {
                        ((ai)var6_7.d()).c(false);
                        var6_7.g();
                        if (var7_1 == 0) {
                            if (var7_1 == 0) continue;
                        }
                        break block20;
                    }
                    var6_7 = var5_6.g.m();
                }
                while (var6_7.f()) {
                    ((ai)var6_7.d()).c(true);
                    var6_7.g();
                    if (var7_1 != 0) continue block2;
                    if (var7_1 == 0) continue;
                }
                var6_7 = (aO)this.E.b(var1_4);
                var6_7.a();
                var3_5 = var6_7.c().size();
                if (var3_5 > 0) {
                    var2_2.a(var1_4, - var3_5);
                }
                var4_3.g();
                if (var7_1 == 0) continue;
            }
            ** GOTO lbl84
        }
        while (!var2_2.a()) {
            var1_4 = var2_2.b();
            v2 = this.E.b(var1_4);
lbl84: // 2 sources:
            var4_3 = (aO)v2;
            this.a(var1_4, var4_3.c());
            this.u.j();
            if (var7_1 != 0) return;
            if (var4_3.b()) {
                var3_5 = var4_3.c().size();
                if (var3_5 > 0) {
                    var2_2.c(var1_4, - var3_5);
                    if (var7_1 == 0) continue;
                }
                var2_2.c();
                if (var7_1 == 0) continue;
            }
            var2_2.c();
            if (var7_1 == 0) continue;
        }
lbl97: // 3 sources:
        this.p.a(this.E);
        var2_2.f();
    }

    void b(X x2) {
        int n2 = v.f;
        this.o = new HashSet();
        e e2 = x2.p();
        do {
            D d2;
            if (!e2.f()) return;
            y.c.d d3 = e2.a();
            if (d3.e() && (d2 = x2.m(d3)).size() >= 5) {
                boolean bl2;
                D d4 = new D();
                d4.add(d2.g());
                d4.add(d2.g());
                d4.add(d2.f());
                q q2 = x2.d();
                x2.b(q2, 1.0, 1.0);
                x2.a(q2, (t)d2.f());
                y.c.d d5 = x2.a(d3.c(), q2);
                ae ae2 = new ae(d5);
                boolean bl3 = ((ae)this.w.b(d3)).b(true);
                if (bl3) {
                    ae2.b(true, true);
                }
                if (bl2 = ((ae)this.w.b(d3)).b(false)) {
                    ae2.b(false, true);
                }
                this.w.a((Object)d5, ae2);
                x2.a(d5, d4);
                x2.a(d3, q2, d3.d());
                x2.a(d3, d2);
                this.o.add(q2);
            }
            e2.g();
        } while (n2 == 0);
    }

    void d() {
        int n2 = v.f;
        for (q q2 : this.o) {
            y.c.d d2 = q2.f();
            y.c.d d3 = q2.g();
            D d4 = this.p.m(d2);
            D d5 = this.p.m(d3);
            d5.j();
            d5.a(d4);
            this.p.a(d3);
            this.p.a(d2, d3.c(), d2.d());
            this.p.a(q2);
            this.p.a(d2, d5);
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        this.o = null;
    }

    /*
     * Unable to fully structure code
     */
    void e() {
        block18 : {
            var8_1 = v.f;
            var2_2 = new d(this.p);
            this.E = this.p.t();
            var4_3 = this.p.c(this.i);
            var5_4 = this.p.o();
            while (var5_4.f()) {
                var1_5 = var5_4.e();
                v0 = var4_3.d(var1_5);
                if (var8_1 == 0) {
                    if (v0) {
                        var6_7 = new aO(this, var1_5, null);
                        this.E.a((Object)var1_5, var6_7);
                        var3_6 = var6_7.c().size();
                        if (var3_6 > 0) {
                            var2_2.a(var1_5, - var3_6);
                        }
                    }
                    var5_4.g();
                    if (var8_1 == 0) continue;
                }
                ** GOTO lbl21
            }
            do lbl-1000: // 4 sources:
            {
                v0 = var2_2.a();
lbl21: // 2 sources:
                if (v0) break;
                var1_5 = var2_2.b();
                var5_4 = (aO)this.E.b(var1_5);
                this.a(var1_5, var5_4.c());
                this.u.j();
                v1 = var5_4.b();
                if (var8_1 != 0) break block18;
                if (!v1) ** GOTO lbl35
                var3_6 = var5_4.c().size();
                if (var3_6 <= 0) ** GOTO lbl33
                var2_2.c(var1_5, - var3_6);
                if (var8_1 == 0) ** GOTO lbl-1000
lbl33: // 2 sources:
                var2_2.c();
                if (var8_1 == 0) ** GOTO lbl-1000
lbl35: // 2 sources:
                var2_2.c();
            } while (var8_1 == 0);
            v1 = this.b;
        }
        if (!v1) ** GOTO lbl104
        var5_4 = this.p.o();
        while (var5_4.f()) {
            var1_5 = var5_4.e();
            v2 = var4_3.d(var1_5);
            if (var8_1 == 0) {
                block22 : {
                    if (v2) {
                        block21 : {
                            block20 : {
                                block19 : {
                                    var6_7 = (aJ)this.A.b(var1_5);
                                    var7_8 = var6_7.a.m();
                                    while (var7_8.f()) {
                                        ((ai)var7_8.d()).c(false);
                                        var7_8.g();
                                        if (var8_1 == 0) {
                                            if (var8_1 == 0) continue;
                                        }
                                        break block19;
                                    }
                                    var7_8 = var6_7.c.m();
                                }
                                while (var7_8.f()) {
                                    ((ai)var7_8.d()).c(true);
                                    var7_8.g();
                                    if (var8_1 == 0) {
                                        if (var8_1 == 0) continue;
                                    }
                                    break block20;
                                }
                                var7_8 = var6_7.e.m();
                            }
                            while (var7_8.f()) {
                                ((ai)var7_8.d()).c(false);
                                var7_8.g();
                                if (var8_1 == 0) {
                                    if (var8_1 == 0) continue;
                                }
                                break block21;
                            }
                            var7_8 = var6_7.g.m();
                        }
                        while (var7_8.f()) {
                            ((ai)var7_8.d()).c(true);
                            var7_8.g();
                            if (var8_1 == 0) {
                                if (var8_1 == 0) continue;
                            }
                            break block22;
                        }
                        var7_8 = (aO)this.E.b(var1_5);
                        var7_8.a();
                        var3_6 = var7_8.c().size();
                        if (var3_6 > 0) {
                            var2_2.a(var1_5, - var3_6);
                        }
                    }
                    var5_4.g();
                }
                if (var8_1 == 0) continue;
            }
            ** GOTO lbl89
        }
        do lbl-1000: // 4 sources:
        {
            v2 = var2_2.a();
lbl89: // 2 sources:
            if (v2) break;
            var1_5 = var2_2.b();
            var5_4 = (aO)this.E.b(var1_5);
            this.a(var1_5, var5_4.c());
            this.u.j();
            if (var8_1 != 0) return;
            if (!var5_4.b()) ** GOTO lbl102
            var3_6 = var5_4.c().size();
            if (var3_6 <= 0) ** GOTO lbl100
            var2_2.c(var1_5, - var3_6);
            if (var8_1 == 0) ** GOTO lbl-1000
lbl100: // 2 sources:
            var2_2.c();
            if (var8_1 == 0) ** GOTO lbl-1000
lbl102: // 2 sources:
            var2_2.c();
        } while (var8_1 == 0);
lbl104: // 3 sources:
        this.p.a(this.E);
        var2_2.f();
    }

    /*
     * Unable to fully structure code
     */
    void f() {
        block22 : {
            block21 : {
                var10_1 = v.f;
                var1_2 = new y.c.y();
                var2_3 = this.p.c(this.n);
                var3_4 = this.p.t();
                var4_5 = this.p.o();
                block0 : do {
                    v0 = var4_5.f();
                    block1 : while (v0) {
                        var5_6 = var4_5.e();
                        if (var10_1 != 0) break block21;
                        var6_7 /* !! */  = var5_6.j();
                        while (var6_7 /* !! */ .f()) {
                            var7_9 = var6_7 /* !! */ .a();
                            v0 = this.v.d(var7_9);
                            if (var10_1 != 0) continue block1;
                            if (!v0 && var2_3.d(var7_9) && !var3_4.d(var5_6)) {
                                var1_2.add(var5_6);
                                var3_4.a(var5_6, true);
                                if (var10_1 == 0) break;
                            }
                            var6_7 /* !! */ .g();
                            if (var10_1 == 0) continue;
                        }
                        var4_5.g();
                        if (var10_1 == 0) continue block0;
                    }
                    break block0;
                    break;
                } while (true);
                this.p.a(var3_4);
            }
            var5_6 = new d(this.p);
            this.E = this.p.t();
            var7_9 = var1_2.a();
            while (var7_9.f()) {
                var4_5 = var7_9.e();
                var8_10 = new aO(this, (q)var4_5, var2_3);
                this.E.a(var4_5, var8_10);
                v1 = var6_8 = var8_10.c().size();
                if (var10_1 == 0) {
                    if (v1 > 0) {
                        var5_6.a((q)var4_5, - var6_8);
                    }
                    var7_9.g();
                    if (var10_1 == 0) continue;
                }
                ** GOTO lbl42
            }
            do lbl-1000: // 4 sources:
            {
                v1 = var5_6.a();
lbl42: // 2 sources:
                if (v1 != 0) break;
                var4_5 = var5_6.b();
                var7_9 = (aO)this.E.b(var4_5);
                this.a((q)var4_5, var7_9.c());
                this.u.j();
                v2 = var7_9.b();
                if (var10_1 != 0) break block22;
                if (!v2) ** GOTO lbl56
                var6_7 /* !! */  = (e)var7_9.c().size();
                if (var6_7 /* !! */  <= 0) ** GOTO lbl54
                var5_6.c((q)var4_5, (int)(- var6_7 /* !! */ ));
                if (var10_1 == 0) ** GOTO lbl-1000
lbl54: // 2 sources:
                var5_6.c();
                if (var10_1 == 0) ** GOTO lbl-1000
lbl56: // 2 sources:
                var5_6.c();
            } while (var10_1 == 0);
            v2 = this.b;
        }
        if (!v2) ** GOTO lbl121
        var7_9 = var1_2.a();
        block5 : while (var7_9.f()) {
            var4_5 = var7_9.e();
            var8_10 = (aJ)this.A.b(var4_5);
            v3 = var8_10.a.m();
            if (var10_1 == 0) {
                block25 : {
                    block24 : {
                        block23 : {
                            var9_11 = v3;
                            while (var9_11.f()) {
                                ((ai)var9_11.d()).c(false);
                                var9_11.g();
                                if (var10_1 == 0) {
                                    if (var10_1 == 0) continue;
                                }
                                break block23;
                            }
                            var9_11 = var8_10.c.m();
                        }
                        while (var9_11.f()) {
                            ((ai)var9_11.d()).c(true);
                            var9_11.g();
                            if (var10_1 == 0) {
                                if (var10_1 == 0) continue;
                            }
                            break block24;
                        }
                        var9_11 = var8_10.e.m();
                    }
                    while (var9_11.f()) {
                        ((ai)var9_11.d()).c(false);
                        var9_11.g();
                        if (var10_1 == 0) {
                            if (var10_1 == 0) continue;
                        }
                        break block25;
                    }
                    var9_11 = var8_10.g.m();
                }
                while (var9_11.f()) {
                    ((ai)var9_11.d()).c(true);
                    var9_11.g();
                    if (var10_1 != 0) continue block5;
                    if (var10_1 == 0) continue;
                }
                var9_11 = (aO)this.E.b(var4_5);
                var9_11.a();
                var6_7 /* !! */  = (e)var9_11.c().size();
                if (var6_7 /* !! */  > 0) {
                    var5_6.a((q)var4_5, (int)(- var6_7 /* !! */ ));
                }
                var7_9.g();
                if (var10_1 == 0) continue;
            }
            ** GOTO lbl108
        }
        while (!var5_6.a()) {
            var4_5 = var5_6.b();
            v3 = this.E.b(var4_5);
lbl108: // 2 sources:
            var7_9 = (aO)v3;
            this.a((q)var4_5, var7_9.c());
            this.u.j();
            if (var10_1 != 0) return;
            if (var7_9.b()) {
                var6_7 /* !! */  = (e)var7_9.c().size();
                if (var6_7 /* !! */  > 0) {
                    var5_6.c((q)var4_5, (int)(- var6_7 /* !! */ ));
                    if (var10_1 == 0) continue;
                }
                var5_6.c();
                if (var10_1 == 0) continue;
            }
            var5_6.c();
            if (var10_1 == 0) continue;
        }
lbl121: // 3 sources:
        this.p.a(this.E);
        var5_6.f();
    }

    /*
     * Unable to fully structure code
     */
    private void a(q var1_1, f var2_2) {
        block33 : {
            var30_3 = v.f;
            if (var2_2.size() < 2) {
                return;
            }
            var3_4 = new aq(this.p, var1_1);
            var2_2.sort(var3_4);
            var4_5 = (aO)this.E.b(var1_1);
            var5_6 = new byte[]{1, 2, 8, 4};
            var6_7 = (aJ)this.A.b(var1_1);
            var7_8 = null;
            var8_9 = false;
            switch (var5_6[var4_5.d()]) {
                case 1: {
                    var7_8 = var6_7.a;
                    var8_9 = false;
                    break;
                }
                case 2: {
                    var7_8 = var6_7.c;
                    var8_9 = true;
                    break;
                }
                case 8: {
                    var7_8 = var6_7.e;
                    var8_9 = false;
                    break;
                }
                case 4: {
                    var7_8 = var6_7.g;
                    var8_9 = true;
                }
            }
            var9_10 = new aD(this.p.o(var1_1));
            var7_8.sort(var9_10);
            this.a(var7_8, var8_9);
            var10_11 = new aF();
            var11_12 = false;
            var12_13 = null;
            var13_14 = var7_8.m();
            while (var13_14.f()) {
                v0 = var13_14.d();
                block7 : while ((var15_16 = (var14_15 = (ai)v0).a(var8_9)) != null) {
                    var16_18 = var15_16.m();
                    while (var16_18.f()) {
                        var17_19 = (ak)var16_18.d();
                        var17_19.c = var18_20 = this.u.d();
                        v0 = var12_13;
                        if (var30_3 != 0) continue block7;
                        if (v0 != null) {
                            var12_13.b(var18_20);
                        }
                        var19_21 = new aM();
                        var19_21.a = true;
                        var19_21.a(new aP((ai)var14_15, var17_19.a));
                        var19_21.a(var17_19.b);
                        this.t.a(var18_20, var19_21);
                        if (var12_13 == null) {
                            var10_11.a((ao)var14_15, var18_20);
                        }
                        var12_13 = var19_21;
                        var16_18.g();
                        if (var30_3 == 0) continue;
                    }
                    break block7;
                }
                var13_14.g();
                if (var30_3 == 0) continue;
            }
            var12_13 = null;
            var13_14 = var2_2.a();
            while (var13_14.f()) {
                block31 : {
                    block30 : {
                        block29 : {
                            var14_15 = var13_14.a();
                            var15_17 = var14_15.c() == var1_1;
                            var16_18 = (ae)this.w.b(var14_15);
                            if (var16_18.b(var15_17) || var16_18.d(var15_17) || var16_18.c() || this.v.d(var14_15)) ** GOTO lbl100
                            var17_19 = this.u.d();
                            var16_18.a((q)var17_19);
                            if (var12_13 != null) {
                                var12_13.b(var17_19);
                            }
                            var12_13 = var18_20 = new aM();
                            var18_20.a = false;
                            var18_20.a(var14_15);
                            this.t.a(var17_19, var18_20);
                            var19_21 = var16_18.b();
                            if (var15_17) {
                                var19_21.i();
                                if (var30_3 == 0) break block29;
                            }
                            var19_21.j();
                        }
                        var20_22 = (m)var19_21.d();
                        var21_23 = (ai)this.q.b(var20_22);
                        v1 = var28_27 = var8_9 != false ? var21_23.v() : var21_23.w();
                        if (!var21_23.x()) ** GOTO lbl-1000
                        var22_24 = Math.min(var20_22.c().b, var20_22.d().b);
                        var24_25 = Math.max(var20_22.c().b, var20_22.d().b);
                        var26_26 = var20_22.c().a;
                        if (var30_3 != 0) lbl-1000: // 2 sources:
                        {
                            var22_24 = Math.min(var20_22.c().a, var20_22.d().a);
                            var24_25 = Math.max(var20_22.c().a, var20_22.d().a);
                            var26_26 = var20_22.c().b;
                        }
                        if (var8_9) {
                            var22_24 = var28_27;
                            if (var30_3 == 0) break block30;
                        }
                        var24_25 = var28_27;
                    }
                    if (var19_21.k() == 1) {
                        aM.a((aM)var18_20, var21_23.q());
                        if (var30_3 == 0) break block31;
                    }
                    aM.a((aM)var18_20, var24_25 - var22_24);
                }
                this.a((q)var17_19, var21_23, aM.a((aM)var18_20), var8_9, var26_26);
lbl100: // 2 sources:
                var13_14.g();
                if (var30_3 == 0) continue;
            }
            var13_14 = null;
            var14_15 = this.u.o();
            while (var14_15.f()) {
                var15_16 = var14_15.e();
                var16_18 = (aM)this.t.b(var15_16);
                v2 = var16_18.a;
                if (var30_3 == 0) {
                    if (!v2) {
                        block32 : {
                            var17_19 = (y.c.d)var16_18.a();
                            if (this.p.m((y.c.d)var17_19).size() == 2) {
                                var13_14 = this.a(var1_1, (y.c.d)var17_19, var7_8);
                                if (var30_3 == 0) break block32;
                            }
                            var13_14 = this.b(var1_1, (y.c.d)var17_19, var7_8);
                        }
                        var18_20 = var13_14.m();
                        while (var18_20.f()) {
                            var19_21 = (ai)var18_20.d();
                            this.a((q)var15_16, (ai)var19_21, aM.a((aM)var16_18), var8_9);
                            var18_20.g();
                            if (var30_3 == 0) {
                                if (var30_3 == 0) continue;
                            }
                            break;
                        }
                    } else {
                        var14_15.g();
                    }
                    if (var30_3 == 0) continue;
                }
                break block33;
            }
            v2 = this.u.i();
        }
        if (v2 != false) return;
        this.a(var1_1, var2_2, var8_9);
    }

    /*
     * Unable to fully structure code
     */
    private void a(q var1_1, f var2_2, boolean var3_3) {
        block32 : {
            var30_4 = v.f;
            var5_5 = null;
            this.F = new D();
            var6_6 = this.u.o();
            var9_7 = (aM)this.t.b(var6_6.e());
            if (!var9_7.a) {
                return;
            }
            var7_8 = ((aP)var9_7.a()).b;
            while (var6_6.f() && ((aM)this.t.b((Object)var6_6.d())).a) {
                var6_6.g();
            }
            while (var6_6.f()) {
                var4_9 = var6_6.e();
                var5_5 = (aM)this.t.b(var4_9);
                this.a(this.F, var5_5.c());
                var6_6.g();
                if (var30_4 == 0) {
                    if (var30_4 == 0) continue;
                }
                break block32;
            }
            var6_6.i();
        }
        var10_10 = false;
        block2 : do lbl-1000: // 3 sources:
        {
            v0 = var6_6.f();
            block3 : while (v0 && !var10_10) {
                block33 : {
                    var4_9 = var6_6.e();
                    var5_5 = (aM)this.t.b(var4_9);
                    if (!var5_5.a) ** GOTO lbl62
                    this.b(this.F, var5_5.c());
                    var11_11 = false;
                    var12_13 = var4_9.j();
                    while (var12_13.f()) {
                        v1 = var11_11;
                        if (var30_4 == 0) {
                            if (v1) break;
                            var13_14 = var12_13.a();
                            var14_15 = var13_14.a(var4_9);
                            if (var14_15.a() == 1) {
                                var15_16 = (aM)this.t.b(var14_15);
                                this.a(this.F, var5_5.c(), var15_16.c());
                                this.s.a(var13_14, true);
                                this.r.a((Object)var14_15, true);
                                var11_11 = true;
                            }
                            var12_13.g();
                            if (var30_4 == 0) continue;
                        }
                        break block33;
                    }
                    v1 = var11_11;
                }
                if (v1) {
                    var12_13 = var4_9.j();
                    while (var12_13.f()) {
                        var13_14 = var12_13.a();
                        v0 = this.s.d(var13_14);
                        if (var30_4 != 0) continue block3;
                        if (!v0) {
                            this.u.a((y.c.d)var13_14);
                        }
                        var12_13.g();
                        if (var30_4 == 0) continue;
                    }
                    this.r.a((Object)var4_9, true);
                }
                var6_6.g();
                if (var30_4 == 0) ** GOTO lbl-1000
lbl62: // 2 sources:
                var10_10 = true;
                if (var30_4 == 0) continue block2;
            }
            break block2;
            break;
        } while (true);
        var11_12 = 0.0;
        var11_12 = var7_8;
        var13_14 = new y.c.y();
        var14_15 = null;
        var15_16 = null;
        var16_17 = null;
        while (var6_6.f()) {
            block34 : {
                var4_9 = var6_6.e();
                var5_5 = (aM)this.t.b(var4_9);
                v2 = this.r.d(var4_9);
                if (var30_4 != 0) ** GOTO lbl147
                if (v2) ** GOTO lbl138
                var17_18 = new f();
                var18_19 = new y.f.i.aE(var4_9, this.t);
                var19_21 = new f(var4_9.j());
                var19_21.sort(var18_19);
                var20_22 = false;
                var21_23 = false;
                var22_26 = false;
                var23_29 = new aL(this);
                var23_29.a(var4_9);
                var24_30 = var19_21.a();
                while (var24_30.f()) {
                    v3 = var21_23;
                    if (var30_4 == 0) {
                        if (v3) break;
                        var25_33 = var24_30.a();
                        var14_15 = var25_33.a(var4_9);
                        var15_16 = (aM)this.t.b(var14_15);
                        var26_34 = ((aP)var15_16.a()).b;
                        if (!this.r.d(var4_9) && this.b(this.F, var15_16.c(), var5_5.c())) {
                            var17_18.add(var25_33);
                        }
                        v4 = var21_23 = var26_34 >= var11_12;
                        if (var21_23 && var17_18.isEmpty()) {
                            var21_23 = false;
                        }
                        var24_30.g();
                        if (var30_4 == 0) continue;
                    }
                    ** GOTO lbl105
                }
                var16_17 = null;
                do {
                    v3 = var17_18.isEmpty();
lbl105: // 2 sources:
                    if (v3) break;
                    v5 = var20_22;
                    if (var30_4 != 0) break block34;
                    if (v5) break;
                    var16_17 = (y.c.d)var17_18.j();
                    var14_15 = var16_17.a(var4_9);
                    var20_22 = var23_29.b(var14_15);
                    var15_16 = (aM)this.t.b(var14_15);
                    var11_12 = Math.max(var11_12, ((aP)var15_16.a()).b);
                } while (var30_4 == 0);
                if (var16_17 == null) return;
                v6 = true;
                v5 = var20_22 = v6;
            }
            if (!v5) {
                return;
            }
            this.a(this.F, var15_16.c(), var5_5.c());
            this.s.a((Object)var16_17, true);
            this.r.a((Object)var4_9, true);
            this.r.a((Object)var14_15, true);
            var24_30 = var14_15.j();
            while (var24_30.f()) {
                v7 = var25_33 = var24_30.a();
                if (var30_4 == 0) {
                    if (v7 != var16_17) {
                        var26_35 = var25_33.a(var14_15);
                        this.u.a((y.c.d)var25_33);
                        if (!this.r.d(var26_35) && var26_35.a() == 1) {
                            var13_14.add(var26_35);
                            this.a((y.c.y)var13_14);
                        }
                    }
                    var24_30.g();
                    if (var30_4 == 0) continue;
                }
                ** GOTO lbl150
lbl138: // 2 sources:
                var14_15 = var4_9.j().a().a(var4_9);
                var15_16 = (aM)this.t.b(var14_15);
                var11_12 = Math.max(var11_12, ((aP)var15_16.a()).b);
                break;
            }
            var6_6.g();
            if (var30_4 == 0) continue;
        }
        var6_6.i();
        do {
            block36 : {
                block35 : {
                    v2 = var6_6.f();
lbl147: // 2 sources:
                    if (v2 == false) return;
                    var4_9 = var6_6.e();
                    v7 = this.t.b(var4_9);
lbl150: // 2 sources:
                    var5_5 = (aM)v7;
                    var16_17 = null;
                    if (!var5_5.a) ** GOTO lbl207
                    var17_18 = ((aP)var5_5.a()).a;
                    var18_20 = ((aP)var5_5.a()).b;
                    var20_22 = false;
                    var21_25 = var4_9.j();
                    while (var21_25.f()) {
                        v8 = var20_22;
                        if (var30_4 == 0) {
                            if (v8) break;
                            var22_27 = var21_25.a();
                            if (this.s.d(var22_27)) {
                                var16_17 = var22_27;
                                var20_22 = true;
                            }
                            var21_25.g();
                            if (var30_4 == 0) continue;
                        }
                        break block35;
                    }
                    v8 = var20_22;
                }
                if (!v8) ** GOTO lbl207
                var14_15 = var16_17.a(var4_9);
                var15_16 = (aM)this.t.b(var14_15);
                var21_25 = (y.c.d)var15_16.a();
                var22_28 = (ae)this.w.b(var21_25);
                var23_29 = var22_28.b();
                v9 = var24_32 = var1_1 == var21_25.c();
                if (var24_32) {
                    var23_29.i();
                    if (var30_4 == 0) break block36;
                }
                var23_29.j();
            }
            var25_33 = (ai)this.q.b(var23_29.d());
            var26_36 = var25_33.a((y.c.d)var21_25, var3_3);
            if (var17_18 == var25_33 || var26_36 == null) ** GOTO lbl-1000
            var25_33.a(var26_36);
            var17_18.a((y.c.d)var21_25, var18_20, var26_36.c, var26_36.d);
            this.a((y.c.d)var21_25, var24_32, var18_20, (ai)var17_18);
            if (var30_4 != 0) lbl-1000: // 2 sources:
            {
                if (var26_36 != null && var18_20 != var26_36.b) {
                    var17_18.a(var26_36, var18_20);
                    this.a((y.c.d)var21_25, var24_32, var18_20, null);
                }
            }
            if (var23_29.k() != 1) ** GOTO lbl195
            var22_28.f(true);
            if (var30_4 == 0) ** GOTO lbl207
lbl195: // 2 sources:
            this.b((y.c.d)var21_25);
            var23_29 = var22_28.b();
            if (!var24_32) ** GOTO lbl-1000
            var23_29.i();
            var23_29.g();
            if (var30_4 != 0) lbl-1000: // 2 sources:
            {
                var23_29.j();
                var23_29.h();
            }
            var27_37 = (m)var23_29.d();
            var28_38 = (ai)this.q.b(var27_37);
            var29_39 = var28_38.a((y.c.d)var21_25);
            var28_38.a(var29_39, var27_37.c(), var27_37.d());
lbl207: // 4 sources:
            var6_6.g();
        } while (var30_4 == 0);
    }

    private void b(y.c.d d2) {
        int n2 = v.f;
        ae ae2 = (ae)this.w.b(d2);
        s s2 = this.p.l(d2).j();
        C c2 = ae2.b();
        D d3 = new D();
        while (c2.f()) {
            m m2 = (m)c2.d();
            m m3 = (m)s2.d();
            ai ai2 = (ai)this.q.b(m2);
            this.q.a(m2, null);
            this.q.a(m3, ai2);
            d3.add(m3);
            c2.g();
            s2.g();
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        ae2.a(d3);
    }

    private void a(y.c.d d2, boolean bl2, double d3, ai ai2) {
        ae ae2;
        C c2;
        block16 : {
            ae2 = (ae)this.w.b(d2);
            c2 = ae2.b();
            if (bl2) {
                c2.i();
                if (v.f == 0) break block16;
            }
            c2.j();
        }
        m m2 = (m)c2.d();
        ai ai3 = (ai)this.q.b(m2);
        I i2 = this.p.g(d2);
        t t2 = null;
        t t3 = null;
        if (bl2) {
            if (ai3.x()) {
                t2 = new t(d3, this.p.p((y.c.d)d2).b);
                this.p.c(d2, t2);
                if (i2.pointCount() > 0) {
                    t3 = new t(d3, i2.getPoint((int)0).b);
                    i2.setPoint(0, t3.a, t3.b);
                } else {
                    t3 = new t(d3, this.p.q((y.c.d)d2).b);
                    this.p.d(d2, t3);
                }
            } else {
                t2 = new t(this.p.p((y.c.d)d2).a, d3);
                this.p.c(d2, t2);
                if (i2.pointCount() > 0) {
                    t3 = new t(i2.getPoint((int)0).a, d3);
                    i2.setPoint(0, t3.a, t3.b);
                } else {
                    t3 = new t(this.p.q((y.c.d)d2).a, d3);
                    this.p.d(d2, t3);
                }
            }
        } else if (ai3.x()) {
            t2 = new t(d3, this.p.q((y.c.d)d2).b);
            this.p.d(d2, t2);
            if (i2.pointCount() > 0) {
                t3 = new t(d3, i2.getPoint((int)(i2.pointCount() - 1)).b);
                i2.setPoint(i2.pointCount() - 1, t3.a, t3.b);
            } else {
                t3 = new t(d3, this.p.p((y.c.d)d2).b);
                this.p.c(d2, t3);
            }
        } else {
            t2 = new t(this.p.q((y.c.d)d2).a, d3);
            this.p.d(d2, t2);
            if (i2.pointCount() > 0) {
                t3 = new t(i2.getPoint((int)(i2.pointCount() - 1)).a, d3);
                i2.setPoint(i2.pointCount() - 1, t3.a, t3.b);
            } else {
                t3 = new t(this.p.p((y.c.d)d2).a, d3);
                this.p.c(d2, t3);
            }
        }
        m m3 = new m(t2, t3);
        this.q.a(m2, null);
        this.q.a(m3, ai2 != null ? ai2 : ai3);
        ae2.a(bl2, m3);
    }

    /*
     * Unable to fully structure code
     */
    private D a(q var1_1, y.c.d var2_2, D var3_3) {
        var20_4 = v.f;
        var4_5 = new D();
        var5_6 = (ae)this.w.b(var2_2);
        var6_7 = var5_6.b();
        var6_7.i();
        var7_8 = (ao)this.q.b(var6_7.d());
        var8_9 = var7_8.q();
        var10_10 = (aJ)this.z.b(var7_8);
        var11_11 = null;
        var12_12 = null;
        var13_13 = var7_8.x() != false ? var10_10.a : var10_10.e;
        var14_14 = var7_8.x() != false ? var10_10.c : var10_10.g;
        if (var13_13.isEmpty() != false) return var4_5;
        if (var14_14.isEmpty()) {
            return var4_5;
        }
        var11_11 = (q)var13_13.f();
        var12_12 = (q)var14_14.f();
        var15_15 = var3_3.m();
        do {
            if (var15_15.f() == false) return var4_5;
            var16_16 = (ao)var15_15.d();
            if (var16_16 == var7_8 || var16_16.q() != var8_9) ** GOTO lbl32
            var17_17 = (aJ)this.z.b(var16_16);
            if (!var7_8.x()) ** GOTO lbl-1000
            var18_18 = (q)var17_17.a.f();
            var19_19 = (q)var17_17.c.f();
            if (var20_4 != 0) lbl-1000: // 2 sources:
            {
                var18_18 = (q)var17_17.e.f();
                var19_19 = (q)var17_17.g.f();
            }
            if (var11_11 == var18_18 && var12_12 == var19_19) {
                var4_5.add(var16_16);
            }
lbl32: // 4 sources:
            var15_15.g();
        } while (var20_4 == 0);
        return var4_5;
    }

    /*
     * Unable to fully structure code
     */
    private D b(q var1_1, y.c.d var2_2, D var3_3) {
        var16_4 = v.f;
        var4_5 = new D();
        var5_6 = (ae)this.w.b(var2_2);
        var6_7 = var5_6.b();
        v0 = var7_8 = var1_1 == var2_2.c();
        if (!var7_8) ** GOTO lbl-1000
        var6_7.i();
        var9_9 = (ao)this.q.b(var6_7.d());
        var6_7.g();
        var8_10 = (m)var6_7.d();
        if (var16_4 != 0) lbl-1000: // 2 sources:
        {
            var6_7.j();
            var9_9 = (ao)this.q.b(var6_7.d());
            var6_7.h();
            var8_10 = (m)var6_7.d();
        }
        var10_11 = (ao)this.q.b(var8_10);
        var11_12 = (q)this.C.b(var10_11);
        var12_13 = var3_3.m();
        do {
            if (var12_13.f() == false) return var4_5;
            v1 = var12_13.d();
            block1 : while ((var13_14 = (ao)v1) != var9_9) {
                var14_15 = (q)this.C.b(var13_14);
                var15_16 = var14_15.m();
                while (var15_16.f()) {
                    v1 = var15_16.e();
                    if (var16_4 != 0) continue block1;
                    if (v1 == var11_12) {
                        var4_5.add(var13_14);
                    }
                    var15_16.g();
                    if (var16_4 == 0) continue;
                }
                break block1;
            }
            var12_13.g();
        } while (var16_4 == 0);
        return var4_5;
    }

    private void a(D d2, boolean bl2) {
        int n2 = v.f;
        if (d2.isEmpty()) {
            return;
        }
        C c2 = d2.m();
        do {
            if (!c2.f()) return;
            ai ai2 = (ai)c2.d();
            this.a(ai2, bl2);
            this.a(ai2);
            c2.g();
        } while (n2 == 0);
    }

    private void a(ai ai2) {
        int n2 = v.f;
        ai2.e();
        q q2 = (q)this.C.b(ai2);
        x x2 = q2.m();
        do {
            int n3 = x2.f();
            block1 : do {
                C c2;
                if (n3 == 0) return;
                ai ai3 = (ai)this.D.b(x2.e());
                if (ai3 == null || (c2 = ai3.a()) == null) break;
                while (c2.f()) {
                    aj aj2 = (aj)c2.d();
                    n3 = aj2.d DCMPG ai2.t();
                    if (n2 != 0) continue block1;
                    if (n3 > 0 && aj2.c < ai2.u()) {
                        ai2.b(aj2);
                    }
                    c2.g();
                    if (n2 == 0) continue;
                }
                break block1;
                break;
            } while (true);
            x2.g();
        } while (n2 == 0);
    }

    /*
     * Exception decompiling
     */
    private void a(ai var1_1, boolean var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:371)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:449)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    private D a(double d2, double d3, boolean bl2) {
        double d4;
        D d5;
        int n2 = v.f;
        D d6 = null;
        double d7 = bl2 ? this.d.a : this.d.b;
        int n3 = (int)Math.floor((d2 - d7) / (double)this.f);
        double d8 = (double)(n3 * this.f) + d7;
        if (d8 < d2) {
            d8 += (double)this.f;
        }
        if ((d4 = (double)((n3 = (int)Math.floor((d3 - d7) / (double)this.f)) * this.f) + d7) >= d3) {
            d4 -= (double)this.f;
        }
        if (d8 >= d2 && d4 < d3) {
            d6 = new D();
            for (double d9 = d8; d9 <= d4; d9 += (double)this.f) {
                d5 = d6;
                if (n2 != 0) return d5;
                d5.add(new Double(d9));
                if (n2 == 0) continue;
            }
        }
        d5 = d6;
        return d5;
    }

    private D a(ao ao2) {
        return this.a(ao2.t(), ao2.u(), ao2.x());
    }

    /*
     * Unable to fully structure code
     */
    private void a(q var1_1, ai var2_2, double var3_3, boolean var5_4, double var6_5) {
        var15_6 = v.f;
        var8_7 = var2_2.a(var5_4);
        if (var8_7 == null) {
            return;
        }
        var9_8 = var8_7.m();
        do {
            if (var9_8.f() == false) return;
            var10_9 = (ak)var9_8.d();
            if (var10_9.a != var6_5 || var1_1.e() != this.u || var10_9.c.e() != this.u) ** GOTO lbl-1000
            var11_10 = this.u.a(var1_1, var10_9.c);
            if (var15_6 != 0) lbl-1000: // 2 sources:
            {
                if (var10_9.b >= var3_3) {
                    var11_11 = var5_4 != false ? var2_2.v() + var3_3 : var2_2.w() - var3_3;
                    var13_12 = (aM)this.t.b(var1_1);
                    if (var1_1.e() == this.u && var10_9.c.e() == this.u) {
                        var14_13 = this.u.a(var1_1, var10_9.c);
                    }
                }
            }
            var9_8.g();
        } while (var15_6 == 0);
    }

    private void a(q q2, ai ai2, double d2, boolean bl2) {
        int n2 = v.f;
        D d3 = ai2.a(bl2);
        if (d3 == null) {
            return;
        }
        C c2 = d3.m();
        do {
            aM aM2;
            double d4;
            if (!c2.f()) return;
            ak ak2 = (ak)c2.d();
            if (ak2.b >= d2 && !ai2.a(ak2.a, d4 = bl2 ? ai2.v() + d2 : ai2.w() - d2, (y.c.d)(aM2 = (aM)this.t.b(q2)).a()) && q2.e() == this.u && ak2.c.e() == this.u) {
                y.c.d d5 = this.u.a(q2, ak2.c);
            }
            c2.g();
        } while (n2 == 0);
    }

    private void a(D d2, double d3) {
        aN aN2;
        boolean bl2;
        block4 : {
            int n2 = v.f;
            boolean bl3 = false;
            p p2 = d2.k();
            while (p2 != null) {
                bl2 = bl3;
                if (n2 == 0) {
                    if (bl2) break;
                    aN2 = (aN)p2.c();
                    double d4 = aN2.a;
                    if (d4 < d3) {
                        p2 = d2.c(p2);
                        if (n2 == 0) continue;
                    }
                    if (d4 == d3) {
                        ++aN2.c;
                        bl3 = true;
                        if (n2 == 0) continue;
                    }
                    aN2 = new aN(d3, 0, 1);
                    p2 = d2.a(aN2, p2);
                    bl3 = true;
                    if (n2 == 0) continue;
                }
                break block4;
            }
            bl2 = bl3;
        }
        if (bl2) return;
        aN2 = new aN(d3, 0, 1);
        d2.add(aN2);
    }

    /*
     * Unable to fully structure code
     */
    private void b(D var1_1, double var2_2) {
        var9_3 = v.f;
        var4_4 = false;
        var5_5 = var1_1.k();
        do lbl-1000: // 3 sources:
        {
            if (var5_5 == null) return;
            if (var4_4 != false) return;
            var6_6 = (aN)var5_5.c();
            var7_7 = var6_6.a;
            if (var7_7 > var2_2) ** GOTO lbl13
            ++var6_6.b;
            var5_5 = var1_1.c(var5_5);
            if (var9_3 == 0) ** GOTO lbl-1000
lbl13: // 2 sources:
            var4_4 = true;
        } while (var9_3 == 0);
    }

    private void a(D d2, double d3, double d4) {
        int n2 = v.f;
        boolean bl2 = false;
        C c2 = d2.m();
        do {
            if (!c2.f()) return;
            if (bl2) return;
            aN aN2 = (aN)c2.d();
            if (aN2.a <= d3) {
                --aN2.b;
            }
            if (aN2.a == d4) {
                --aN2.c;
            }
            if (aN2.c == 0) {
                d2.b(c2);
            }
            bl2 = aN2.a > d3;
            c2.g();
        } while (n2 == 0);
    }

    private boolean b(D d2, double d3, double d4) {
        boolean bl2;
        int n2 = v.f;
        boolean bl3 = true;
        int n3 = 0;
        C c2 = d2.m();
        c2.j();
        while (c2.f()) {
            bl2 = bl3;
            if (n2 != 0) return bl2;
            if (!bl2) break;
            aN aN2 = (aN)c2.d();
            int n4 = aN2.b;
            int n5 = aN2.c;
            if (aN2.a <= d3) {
                --n4;
            }
            if (aN2.a == d4) {
                --n5;
            }
            if (n5 > 0 && n4 < (n3 += n5)) {
                bl3 = false;
            }
            if (n4 < n5) {
                bl3 = false;
            }
            c2.h();
            if (n2 == 0) continue;
        }
        bl2 = bl3;
        return bl2;
    }

    private void a(y.c.y y2) {
        int n2 = v.f;
        x x2 = y2.a();
        do {
            boolean bl2 = x2.f();
            block1 : do {
                if (!bl2) return;
                q q2 = x2.e();
                aM aM2 = (aM)this.t.b(q2);
                y.c.d d2 = q2.j().a();
                q q3 = d2.a(q2);
                aM aM3 = (aM)this.t.b(q3);
                this.a(this.F, aM3.c(), aM2.c());
                this.s.a((Object)d2, true);
                this.r.a((Object)q2, true);
                this.r.a((Object)q3, true);
                y2.b(x2);
                e e2 = q3.j();
                while (e2.f()) {
                    y.c.d d3 = e2.a();
                    bl2 = this.s.d(d3);
                    if (n2 != 0) continue block1;
                    if (!bl2) {
                        q q4 = d2.a(q3);
                        this.u.a(d3);
                        if (!this.r.d(q4) && q4.a() == 1) {
                            y2.add(q4);
                        }
                    }
                    e2.g();
                    if (n2 == 0) continue;
                }
                break block1;
                break;
            } while (true);
            x2.g();
        } while (n2 == 0);
    }

    static h a(aK aK2) {
        return aK2.v;
    }

    static A b(aK aK2) {
        return aK2.t;
    }

    static A c(aK aK2) {
        return aK2.r;
    }

    static void a(aK aK2, D d2, double d3) {
        aK2.a(d2, d3);
    }

    static void b(aK aK2, D d2, double d3) {
        aK2.b(d2, d3);
    }
}

