/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import y.c.d;
import y.c.q;
import y.d.y;
import y.f.X;
import y.f.b.c;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ad;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.x;

class aY
extends ab {
    private int b;
    private q c;
    private q d;
    private y e;
    private y f;
    private c g;
    private boolean h;

    aY() {
    }

    @Override
    protected void c() {
        super.c();
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    @Override
    protected void a(Z z2) {
        super.a(z2);
        this.g = z2.b();
    }

    @Override
    protected void b(aa aa2) {
        super.b(aa2);
        this.b = aa2.d().f().d();
        this.h = this.b > 0;
        if (!this.h) return;
        this.c = aa2.c().c();
        this.d = aa2.c().d();
        this.e = aa2.f().g();
        this.f = aa2.g().g();
    }

    @Override
    protected double a(f f2) {
        if (!this.h) {
            return 0.0;
        }
        double d2 = 0.0;
        if (f2.b() == null) return d2;
        R r2 = f2.a();
        R r3 = f2.b().a();
        boolean bl2 = this.a(r2);
        boolean bl3 = this.a(r3);
        if (!bl2) {
            if (!bl3) return d2;
        }
        d2 += (double)this.b;
        return d2;
    }

    @Override
    double[] a(f f2, R r2, P[] arrp, v[] arrv, double[] arrd) {
        if (!this.h) {
            this.b("punish group node crossing", 0.0, false);
            return new double[arrp.length];
        }
        double d2 = 0.0;
        if (this.a(f2, r2)) {
            d2 = this.b;
        }
        double[] arrd2 = new double[arrp.length];
        if (d2 > 0.0) {
            Arrays.fill(arrd2, d2);
        }
        this.b("punish group node crossing", d2, false);
        return arrd2;
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(R var1_1) {
        var4_2 = ab.a;
        var2_3 = this.b(var1_1).iterator();
        do lbl-1000: // 3 sources:
        {
            if (!var2_3.hasNext()) {
                return false;
            }
            var3_4 = (q)var2_3.next();
            if (!this.g.d(var3_4)) ** GOTO lbl-1000
            v0 = this.c(var3_4);
            if (var4_2 != 0) return v0;
        } while (v0);
        return true;
    }

    private boolean a(f f2, R r2) {
        List list;
        R r3 = f2.a();
        List list2 = this.b(r3);
        q q2 = this.a(list2, list = this.b(r2));
        if (q2 != null && !this.a(q2)) {
            return true;
        }
        q q3 = this.b(list2, list);
        if (q3 == null) return false;
        boolean bl2 = this.b(q3);
        boolean bl3 = this.a(q3);
        if (!bl3) return false;
        if (bl3) {
            if (q3 == this.c) return false;
        }
        if (!bl2) return true;
        if (q3 != this.d) return true;
        return false;
    }

    private boolean a(q q2) {
        return this.a(this.f, q2);
    }

    private boolean b(q q2) {
        return this.a(this.e, q2);
    }

    private boolean a(y y2, q q2) {
        y y3 = this.a().a().s(q2);
        y y4 = new y(y3.c() - 1.0E-6, y3.d() - 1.0E-6, y3.a() + 2.0E-6, y3.b() + 2.0E-6);
        return y4.b(y2);
    }

    private q a(List list, List list2) {
        q q2;
        Iterator iterator = list2.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!this.g.d(q2 = (q)iterator.next()) || list.contains(q2));
        return q2;
    }

    private q b(List list, List list2) {
        q q2;
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!this.g.d(q2 = (q)iterator.next()) || list2.contains(q2));
        return q2;
    }

    private boolean c(q q2) {
        return this.a(q2, this.b().c().c());
    }

    private boolean a(q q2, q q3) {
        int n2 = ab.a;
        q q4 = q3;
        do {
            if (q4 == this.g.b()) return false;
            if (q4 == q2) {
                return true;
            }
            q4 = this.g.a(q4);
        } while (n2 == 0);
        return false;
    }

    private List b(R r2) {
        return (List)r2.a(T.a);
    }
}

