/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import java.util.Collection;
import y.a.v;
import y.c.d;
import y.c.f;
import y.c.h;
import y.c.i;
import y.c.q;
import y.f.f.a.a.b;
import y.f.f.a.a.e;
import y.f.f.a.a.n;
import y.f.f.a.b.B;
import y.f.f.a.b.C;
import y.f.f.a.b.D;
import y.f.f.a.b.a;
import y.f.h.p;

public class A
extends D {
    private q e;
    private q f;
    private f g;
    private h h;

    public A(a a2) {
        super(a2);
        this.h = this.c.u();
        this.b();
        this.e = this.c.d();
        this.f = this.c.d();
        this.g = new f();
    }

    @Override
    public void a() {
        this.c();
        this.c.a(this.e);
        this.c.a(this.f);
        this.c.a(this.h);
        super.a();
    }

    public f a(q q2, q q3) {
        f f2 = null;
        this.c();
        this.b(q2, q3);
        return v.a(this.c, this.e, this.f, true, v.a(this.c));
    }

    public double a(d d2, f f2) {
        double[] arrd;
        d[] arrd2;
        block2 : {
            A a2;
            boolean bl2 = a.c;
            f f3 = this.a.d(d2);
            this.c();
            this.b(d2.c(), d2.d());
            arrd = v.a(this.c);
            arrd2 = f3.a();
            while (arrd2.f()) {
                d d3 = arrd2.a();
                a2 = this;
                if (!bl2) {
                    d d4 = a2.e(d3);
                    arrd[d4.b()] = 0.0;
                    arrd2.g();
                    if (!bl2) continue;
                }
                break block2;
            }
            a2 = this;
        }
        arrd2 = new d[a2.c.e()];
        double d5 = v.a(this.c, this.e, this.f, true, arrd, arrd2);
        f2.addAll(v.a(this.e, this.f, arrd2));
        return d5;
    }

    private void b(q q2, q q3) {
        Object object;
        boolean bl2;
        Object object2;
        block9 : {
            Object object3;
            block8 : {
                A a2;
                d d2;
                block7 : {
                    bl2 = a.c;
                    object3 = this.a.a(q2).a();
                    while (object3.f()) {
                        object = object3.a();
                        object2 = this.a(this.a.b((d)object));
                        d2 = this.c.a(this.e, (q)object2);
                        this.a(d2, 0);
                        this.f(d2);
                        object3.g();
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block7;
                    }
                    object3 = this.a.a(q3).a();
                }
                while (object3.f()) {
                    object = object3.a();
                    object2 = this.a(this.a.b((d)object));
                    d2 = this.c.a((q)object2, this.f);
                    this.a(d2, 1);
                    a2 = this;
                    if (!bl2) {
                        a2.f(d2);
                        object3.g();
                        if (!bl2) continue;
                    }
                    break block8;
                }
                a2 = this;
            }
            object3 = a2.d.a(q2);
            object = this.d.a(q3);
            object2 = n.c((e)object3, (e)object);
            for (object3 = object3.c(); object3 != object2; object3 = object3.c()) {
                this.a(((b)object3).b_(), 3);
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block9;
            }
            object = object.c();
        }
        do {
            if (object == object2) return;
            this.a(((b)object).b_(), 4);
            object = object.c();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    public void a(q var1_1, int var2_2) {
        var12_3 = a.c;
        var3_4 = this.a.b(var1_1);
        var11_5 = var3_4.a();
        do {
            if (var11_5.f() == false) return;
            var4_6 = var11_5.a();
            var8_10 = this.a.b(var4_6);
            var6_8 = this.a(var8_10);
            var5_7 = this.a.i(var4_6);
            if (var5_7.c() == var1_1) {
                var5_7 = this.a.c(var5_7);
            }
            var9_11 = this.a.b(var5_7);
            var7_9 = this.a(var9_11);
            if (var2_2 != 3) ** GOTO lbl-1000
            var10_12 = this.c.a(var6_8, var7_9);
            this.a(var10_12, var1_1);
            this.a(var10_12, 3);
            this.f(var10_12);
            if (var12_3) lbl-1000: // 2 sources:
            {
                var10_12 = this.c.a(var7_9, var6_8);
                this.a(var10_12, var1_1);
                this.a(var10_12, 4);
                this.f(var10_12);
            }
            var11_5.g();
        } while (!var12_3);
    }

    private void c() {
        block3 : {
            A a2;
            boolean bl2 = a.c;
            y.c.e e2 = this.g.a();
            while (e2.f()) {
                a2 = this;
                if (!bl2) {
                    if (a2.c.f(e2.a())) {
                        this.c.a(e2.a());
                    }
                    e2.g();
                    if (!bl2) continue;
                }
                break block3;
            }
            a2 = this;
        }
        a2.g.clear();
    }

    private void f(d d2) {
        this.g.add(d2);
    }

    public void a(p p2, p[] arrp) {
        boolean bl2;
        Object object;
        Object object2;
        block11 : {
            A a2;
            int n2;
            Object object3;
            block10 : {
                int n3;
                bl2 = a.c;
                q q2 = this.a(p2);
                y.c.e e2 = p2.a();
                while (e2.f()) {
                    object3 = e2.a();
                    object2 = this.a.c((d)object3);
                    d d2 = this.e((d)object3);
                    object = this.e((d)object2);
                    n3 = (int)this.c.f(d2) ? 1 : 0;
                    if (!bl2) {
                        if (n3 != 0) {
                            this.c.a(d2);
                        }
                        if (this.c.f((d)object)) {
                            this.c.a((d)object);
                        }
                        e2.g();
                        if (!bl2) continue;
                    }
                    break block10;
                }
                this.c.a(q2);
                n3 = n2 = 0;
            }
            while (n2 < arrp.length) {
                object3 = arrp[n2];
                object2 = this.c.d();
                a2 = this;
                if (!bl2) {
                    a2.a((p)object3, (q)object2);
                    ++n2;
                    if (!bl2) continue;
                }
                break block11;
            }
            a2 = this;
        }
        boolean[] arrbl = new boolean[a2.b.g()];
        int n4 = 0;
        do {
            int n5 = n4;
            block3 : do {
                if (n5 >= arrp.length) return;
                object2 = arrp[n4];
                q q2 = this.a((p)object2);
                object = object2.a();
                while (object.f()) {
                    d d2 = object.a();
                    d d3 = this.a.c(d2);
                    p p3 = this.a.b(d3);
                    q q3 = this.a(p3);
                    n5 = arrbl[d2.b()];
                    if (bl2) continue block3;
                    if (n5 == 0) {
                        d d4 = this.c.a(q2, q3);
                        this.a(d2, d4);
                        arrbl[d2.b()] = true;
                        d d5 = this.c.a(q3, q2);
                        this.a(d3, d5);
                        arrbl[d3.b()] = true;
                    }
                    object.g();
                    if (!bl2) continue;
                }
                break block3;
                break;
            } while (true);
            ++n4;
        } while (!bl2);
    }

    public void a(d d2, int n2) {
        this.g((d)d2).a = n2;
    }

    public int a(d d2) {
        if (this.d(d2) == null) return this.g((d)d2).a;
        return 2;
    }

    public void a(d d2, q q2) {
        this.g((d)d2).b = q2;
    }

    public q b(d d2) {
        return this.g((d)d2).b;
    }

    public d c(d d2) {
        return this.d(d2);
    }

    private C g(d d2) {
        C c2 = (C)this.h.b(d2);
        if (c2 != null) return c2;
        c2 = this.d();
        this.h.a((Object)d2, c2);
        return c2;
    }

    private C d() {
        return new C(null);
    }
}

