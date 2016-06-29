/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.q;
import y.d.t;
import y.f.X;
import y.f.aE;
import y.f.ax;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.U;
import y.f.i.a.ab;
import y.f.i.a.bl;
import y.f.i.a.f;

class aU {
    private X a;
    private d b;
    private List[] c;
    private List[] d;
    private bl[] e;
    private HashMap f;
    private HashMap g;

    aU(d d2) {
        this.a = (X)d2.a();
        this.b = d2;
        this.c = new List[2];
        this.d = new List[2];
        this.e = new bl[2];
        this.c(true);
        this.c(false);
        this.a();
    }

    /*
     * Unable to fully structure code
     */
    private void c(boolean var1_1) {
        var11_2 = ab.a;
        var2_3 = var1_1 != false ? 0 : 1;
        var3_4 = new D();
        var4_5 = var1_1 != false ? ax.a : ax.b;
        var5_6 = this.a.c(var4_5);
        if (var5_6 != null && (var6_7 = (List)var5_6.b(this.b)) != null) {
            var3_4.addAll(var6_7);
        }
        v0 = var6_7 = var1_1 != false ? aE.d(this.a, this.b) : aE.e(this.a, this.b);
        if (var6_7 != null) {
            var7_8 = this.a((aE)var6_7, var1_1);
            var3_4.add(var7_8);
        }
        var7_8 = var1_1 != false ? this.b.c() : this.b.d();
        this.e[var2_3] = var8_9 = bl.a((q)var7_8);
        if (!var3_4.isEmpty() || var8_9 != null) ** GOTO lbl17
        var9_10 = null;
        if (var11_2 == 0) ** GOTO lbl26
lbl17: // 2 sources:
        if (!var3_4.isEmpty()) ** GOTO lbl20
        var9_10 = var8_9.a();
        if (var11_2 == 0) ** GOTO lbl26
lbl20: // 2 sources:
        if (var8_9 != null) ** GOTO lbl-1000
        var9_10 = var3_4;
        if (var11_2 != 0) lbl-1000: // 2 sources:
        {
            var10_11 = var8_9.b();
            var3_4.removeAll(var10_11);
            var9_10 = var3_4;
        }
lbl26: // 5 sources:
        this.c[var2_3] = var9_10;
        this.d[var2_3] = this.a(var9_10);
    }

    private ax a(aE aE2, boolean bl2) {
        int n2 = aE2.g() ? 255 : (int)aE2.b();
        if (!aE2.a()) return ax.b(n2);
        t t2 = bl2 ? this.a.n(this.b) : this.a.o(this.b);
        return ax.a(t2.a(), t2.b(), n2);
    }

    public List a(List list) {
        D d2;
        int n2 = ab.a;
        D d3 = new D();
        if (list != null) {
            for (ax ax2 : list) {
                if (!ax2.b()) continue;
                d2 = d3;
                if (n2 != 0) return d2;
                d2.add(ax2);
                if (n2 == 0) continue;
            }
        }
        d2 = d3;
        return d2;
    }

    public List a(List list, R r2, R r3, boolean bl2) {
        D d2;
        int n2 = ab.a;
        D d3 = new D();
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ax ax2;
                if (!aU.a(bl2 ? r2 : r3, bl2 ? r3 : r2, ax2 = (ax)iterator.next())) continue;
                d2 = d3;
                if (n2 != 0) return d2;
                d2.add(ax2);
                if (n2 == 0) continue;
            }
        }
        d2 = d3;
        return d2;
    }

    public List a(U u2, boolean bl2) {
        int n2 = u2.b();
        f f2 = u2.a(bl2 ? 0 : n2 - 2);
        f f3 = u2.a(bl2 ? 1 : n2 - 1);
        return this.a(f2.a(), f3.a(), f3.c(), bl2);
    }

    /*
     * Unable to fully structure code
     */
    public List a(R var1_1, R var2_2, P var3_3, boolean var4_4) {
        var14_5 = ab.a;
        v0 = var5_6 = var4_4 != false ? 0 : 1;
        if (this.c[var5_6] == null) {
            return Collections.EMPTY_LIST;
        }
        var6_7 = this.a(this.c[var5_6], var1_1, var2_2, var4_4);
        if (var6_7.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        var7_8 = new D();
        var8_9 = var3_3.e();
        var9_10 = var6_7.iterator();
        do lbl-1000: // 4 sources:
        {
            if (var9_10.hasNext() == false) return var7_8;
            var10_11 = (ax)var9_10.next();
            if (var10_11.b()) ** GOTO lbl17
            var7_8.add(var10_11);
            if (var14_5 == 0) ** GOTO lbl-1000
lbl17: // 2 sources:
            var11_12 = this.a(var10_11, var4_4);
            v1 = var12_13 = var3_3.a() != false ? var11_12.b() : var11_12.a();
            if (var8_9.d() != 0.0 || var8_9.a() != var12_13) ** GOTO lbl-1000
            var7_8.add(var10_11);
        } while (var14_5 == 0);
        return var7_8;
    }

    private void a() {
        t t2;
        int n2 = ab.a;
        List list = this.d[0];
        List list2 = this.d[1];
        if (list != null) {
            this.f = new HashMap(list.size());
            for (ax ax2 : list) {
                t2 = aU.a(ax2, this.b.c());
                this.f.put(ax2, t2);
                if (n2 != 0) return;
                if (n2 == 0) continue;
            }
        }
        if (list2 == null) return;
        this.g = new HashMap(list2.size());
        Iterator iterator = list2.iterator();
        do {
            ax ax2;
            if (!iterator.hasNext()) return;
            ax2 = (ax)iterator.next();
            t2 = aU.a(ax2, this.b.d());
            this.g.put(ax2, t2);
        } while (n2 == 0);
    }

    public List a(boolean bl2) {
        int n2;
        if (bl2) {
            n2 = 0;
            return this.c[n2];
        }
        n2 = 1;
        return this.c[n2];
    }

    public List b(boolean bl2) {
        int n2;
        if (bl2) {
            n2 = 0;
            return this.d[n2];
        }
        n2 = 1;
        return this.d[n2];
    }

    public t a(ax ax2, boolean bl2) {
        if (bl2 && this.f != null) {
            return (t)this.f.get(ax2);
        }
        if (bl2) return null;
        if (this.g == null) return null;
        return (t)this.g.get(ax2);
    }

    public void b(U u2, boolean bl2) {
        int n2 = ab.a;
        int n3 = bl2 ? 0 : 1;
        bl bl3 = this.e[n3];
        if (bl3 == null) return;
        List list = this.a(u2, bl2);
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) return;
            ax ax2 = (ax)iterator.next();
            bl3.a(ax2);
        } while (n2 == 0);
    }

    private static boolean a(R r2, R r3, ax ax2) {
        if (ax2.a() == 1) {
            if (r2.i() != r3.k()) return false;
            return true;
        }
        if (ax2.a() == 2) {
            if (r2.k() != r3.i()) return false;
            return true;
        }
        if (ax2.a() == 4) {
            if (r2.j() != r3.h()) return false;
            return true;
        }
        if (ax2.a() != 8) return true;
        if (r2.h() != r3.j()) return false;
        return true;
    }

    private static t a(ax ax2, q q2) {
        X x2 = (X)q2.e();
        t t2 = x2.l(q2);
        double d2 = t2.a() + ax2.c();
        double d3 = t2.b() + ax2.d();
        return new t(d2, d3);
    }
}

