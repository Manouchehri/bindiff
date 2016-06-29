/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.HashMap;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.h;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.c.K;
import y.f.c.Q;
import y.f.c.R;
import y.f.c.Y;
import y.f.c.a;
import y.f.c.aB;
import y.f.c.aI;
import y.g.am;

final class L
implements Q,
R,
Y {
    aI a = new aI();
    aB b = new aB();
    HashMap c;
    c d;
    A e;
    c f;
    h g;
    R h;
    Q i;
    c j;
    c k;
    c l;
    D m;
    Object n;
    boolean[] o = new boolean[5];

    L() {
    }

    void a(c c2, c c3, c c4, R r2, D d2, Q q2, c c5, A a2, c c6, h h2) {
        this.l = c4;
        this.m = d2;
        this.k = c3;
        this.j = c2;
        this.d = c5;
        this.e = a2;
        this.f = c6;
        this.g = h2;
        this.i = q2;
        this.h = r2;
    }

    void a(Object object) {
        this.n = object;
    }

    void b(X x2, A a2, int n2) {
        Object object;
        boolean bl2 = a.i;
        Object[] arrobject = this.m.toArray();
        C c2 = x2.o();
        while (c2.f()) {
            q q2 = c2.e();
            object = this.d.b(q2);
            if (object == null) {
                Object object2 = this.j.b(q2);
                if (object2 != K.q) throw new IllegalStateException(new StringBuffer().append("Could not determine id of node ").append(q2).append(" [").append(object2).append("]").toString());
                d d2 = (d)this.l.b(q2);
                if (d2 == null) {
                    throw new IllegalStateException(new StringBuffer().append("Could not create id for ").append(q2).toString());
                }
                Object object3 = this.f.b(d2);
                if (object3 == null) {
                    throw new IllegalStateException(new StringBuffer().append("No ID stored for ").append(d2).toString());
                }
                int n3 = this.k.a(q2);
                this.e.a((Object)q2, am.a("BendNode", object3, arrobject[n3]));
                if (bl2) {
                    throw new IllegalStateException(new StringBuffer().append("Could not determine id of node ").append(q2).append(" [").append(object2).append("]").toString());
                }
            }
            c2.g();
            if (!bl2) continue;
        }
        c2 = x2.p();
        do {
            if (!c2.f()) return;
            d d3 = c2.a();
            object = this.f.b(d3);
            if (object == null) {
                this.g.a((Object)d3, am.a("DummyEdge", this.d.b(d3.c()), this.d.b(d3.d())));
            }
            c2.g();
        } while (!bl2);
    }

    @Override
    public Object a() {
        return new HashMap();
    }

    @Override
    public Object b() {
        return this.c;
    }

    @Override
    public boolean a(byte by2) {
        return this.o[by2];
    }

    @Override
    public void b(Object object) {
        if (object != null) {
            if (!(object instanceof HashMap)) return;
        }
        this.c = (HashMap)object;
    }

    @Override
    public void a(byte by2, boolean bl2) {
        this.o[by2] = bl2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int a(X var1_1, A var2_2, f var3_3) {
        block5 : {
            var9_4 = a.i;
            this.a.a(this.h, this.d, this.f, this.n);
            if (!this.a(1)) ** GOTO lbl-1000
            this.a.a(false);
            this.a.c(this.c);
            var4_5 = this.a.a(var1_1, var2_2, var3_3);
            this.a.d(this.c);
            if (var9_4) lbl-1000: // 2 sources:
            {
                this.a.a(true);
                this.a.c(this.c);
                var4_5 = this.a.a(var1_1, var2_2, var3_3);
                this.a.d(this.c);
            }
            var5_6 = new Object[var4_5];
            var6_7 = var1_1.o();
            while (var6_7.f()) {
                var7_9 = var6_7.e();
                var8_10 = var2_2.a(var7_9);
                if (!var9_4) {
                    if (var5_6[var8_10] == null) {
                        var5_6[var8_10] = this.a.a(var7_9);
                    }
                    var6_7.g();
                    if (!var9_4) continue;
                }
                break block5;
            }
            this.m.clear();
        }
        var6_8 = 0;
        do {
            if (var6_8 >= var4_5) return var4_5;
            this.m.b(var5_6[var6_8]);
            ++var6_8;
        } while (!var9_4);
        return var4_5;
    }

    @Override
    public y[] a(X x2, A a2, int n2) {
        y[] arry;
        this.b(x2, a2, n2);
        this.b.a(this.i, this.d);
        if (this.a(2)) {
            this.b.a(false);
            this.b.a(this.c);
            arry = this.b.a(x2, a2, n2);
            this.b.b(this.c);
            if (!a.i) return arry;
        }
        this.b.a(true);
        this.b.a(this.c);
        arry = this.b.a(x2, a2, n2);
        this.b.b(this.c);
        return arry;
    }

    public void c() {
        this.f = null;
        this.l = null;
        this.j = null;
        this.g = null;
        this.d = null;
        this.e = null;
        this.h = null;
        this.i = null;
        this.a = null;
        this.b = null;
        this.c = null;
    }
}

