/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import y.c.D;
import y.c.b;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.q;
import y.f.I;
import y.f.X;
import y.f.aF;
import y.f.ae;
import y.f.ax;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.U;
import y.f.i.a.V;
import y.f.i.a.Z;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ac;
import y.f.i.a.ad;
import y.f.i.a.bG;
import y.f.i.a.bH;
import y.f.i.a.bI;
import y.f.i.a.bJ;
import y.f.i.a.bK;
import y.f.i.a.bL;
import y.f.i.a.bN;
import y.f.i.a.bP;
import y.f.i.a.bQ;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.w;
import y.f.i.a.x;
import y.f.i.a.y;
import y.g.M;

class bF
extends ab {
    private final List b = new D();
    private final Set c = new HashSet();
    private final HashMap d = new HashMap();
    private final HashMap e = new HashMap();
    private final HashMap f = new HashMap();
    private b g;
    private b h;
    private b i;
    private h j;
    private Object k;
    private Object l;
    private boolean m;
    private c n;
    private c o;
    private c p;
    private c q;
    private c r;
    private c s;
    private c t;

    bF() {
    }

    @Override
    protected void a(Z z2) {
        super.a(z2);
        X x2 = z2.a();
        this.m = x2.c(aF.c) != null || x2.c(aF.d) != null;
        if (!this.m) return;
        this.d();
    }

    @Override
    protected void c() {
        if (this.m) {
            this.e();
            this.f();
            this.l = null;
            this.k = null;
            this.d.clear();
        }
        super.c();
    }

    /*
     * Unable to fully structure code
     */
    private void d() {
        block7 : {
            block6 : {
                var8_1 = ab.a;
                var1_2 = this.a().a();
                var2_3 = var1_2.c(aF.c);
                var3_4 = var1_2.c(aF.d);
                var4_5 = M.b();
                var1_2.a(y.a, var4_5);
                this.j = M.b();
                var5_6 = var1_2.p();
                while (var5_6.f()) {
                    var6_7 = var5_6.a();
                    v0 = var2_3;
                    if (var8_1 != 0) break block6;
                    if (v0 == null || var2_3.b(var6_7) == null) ** GOTO lbl-1000
                    var7_8 = var2_3.b(var6_7);
                    var4_5.a(var6_7, new bQ(var6_7.c(), var7_8));
                    if (var8_1 != 0) lbl-1000: // 2 sources:
                    {
                        if (var3_4 != null && var3_4.b(var6_7) != null) {
                            var7_8 = var3_4.b(var6_7);
                            var4_5.a(var6_7, new bQ(var6_7.d(), var7_8));
                            var1_2.c((d)var6_7);
                            ae.a(var1_2.b(var6_7));
                            this.j.a(var6_7, true);
                        }
                    }
                    var5_6.g();
                    if (var8_1 == 0) continue;
                }
                this.p = var1_2.c(aF.a);
                this.q = var1_2.c(aF.b);
                this.r = var1_2.c(ax.a);
                this.s = var1_2.c(ax.b);
                this.n = var2_3;
                this.o = var3_4;
                var1_2.a(aF.a, new bG(this));
                var1_2.a(aF.b, new bH(this));
                var1_2.a(ax.a, new bI(this));
                var1_2.a(ax.b, new bJ(this));
                var1_2.a(aF.c, new bK(this));
                var1_2.a(aF.d, new bL(this));
                v0 = this.t = var1_2.c("y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY");
            }
            if (v0 == null) ** GOTO lbl58
            var5_6 = M.b();
            var6_7 = var1_2.p();
            while (var6_7.f()) {
                var7_8 = var6_7.a();
                v1 = this;
                if (var8_1 != 0) break block7;
                if (v1.t.b(var7_8) == null) ** GOTO lbl55
                if (var4_5.b(var7_8) == null) ** GOTO lbl-1000
                if (!this.j.d(var7_8)) ** GOTO lbl-1000
                var5_6.a(var7_8, new bP(this, (x)this.t.b(var7_8), (d)var7_8, true));
                if (var8_1 != 0) lbl-1000: // 2 sources:
                {
                    var5_6.a(var7_8, new bP(this, (x)this.t.b(var7_8), (d)var7_8, false));
                    ** if (var8_1 == 0) goto lbl55
                }
                ** GOTO lbl55
lbl-1000: // 2 sources:
                {
                    var5_6.a(var7_8, this.t.b(var7_8));
                }
lbl55: // 4 sources:
                var6_7.g();
                if (var8_1 == 0) continue;
            }
            var1_2.a("y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY", (c)var5_6);
lbl58: // 2 sources:
            this.h = M.c();
            this.g = M.c();
            v1 = this;
        }
        v1.i = M.c();
    }

    private void e() {
        block24 : {
            X x2;
            bF bF2;
            int n2;
            block23 : {
                block22 : {
                    block21 : {
                        block20 : {
                            block19 : {
                                block18 : {
                                    block17 : {
                                        n2 = ab.a;
                                        x2 = this.a().a();
                                        if (this.p != null) {
                                            x2.a(aF.a, this.p);
                                            this.p = null;
                                            if (n2 == 0) break block17;
                                        }
                                        x2.d_(aF.a);
                                    }
                                    if (this.q != null) {
                                        x2.a(aF.b, this.q);
                                        this.q = null;
                                        if (n2 == 0) break block18;
                                    }
                                    x2.d_(aF.b);
                                }
                                if (this.r != null) {
                                    x2.a(ax.a, this.r);
                                    this.r = null;
                                    if (n2 == 0) break block19;
                                }
                                x2.d_(ax.a);
                            }
                            if (this.s != null) {
                                x2.a(ax.b, this.s);
                                this.s = null;
                                if (n2 == 0) break block20;
                            }
                            x2.d_(ax.b);
                        }
                        if (this.n != null) {
                            x2.a(aF.c, this.n);
                            this.n = null;
                            if (n2 == 0) break block21;
                        }
                        x2.d_(aF.c);
                    }
                    if (this.o != null) {
                        x2.a(aF.d, this.o);
                        this.o = null;
                        if (n2 == 0) break block22;
                    }
                    x2.d_(aF.d);
                }
                if (this.t != null) {
                    x2.a("y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY", this.t);
                    this.t = null;
                    if (n2 == 0) break block23;
                }
                x2.d_("y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY");
            }
            e e2 = x2.p();
            while (e2.f()) {
                d d2 = e2.a();
                bF2 = this;
                if (n2 == 0) {
                    if (bF2.j.d(d2)) {
                        x2.c(d2);
                        ae.a(x2.b(d2));
                    }
                    e2.g();
                    if (n2 == 0) continue;
                }
                break block24;
            }
            x2.d_(y.a);
            this.h = null;
            this.g = null;
            this.i = null;
            bF2 = this;
        }
        bF2.j = null;
    }

    @Override
    protected void a(aa aa2) {
        int n2 = ab.a;
        super.a(aa2);
        if (!this.m) {
            return;
        }
        this.d.clear();
        c c2 = this.a().a().c(y.a);
        if (c2 == null) return;
        e e2 = aa2.b();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            boolean bl2 = this.j.d(d2);
            Object object = c2.b(d2);
            if (object != null) {
                double d3;
                x x2 = this.a().c().a(d2);
                double d4 = d3 = bl2 ? x2.b() : x2.a();
                if (!this.d.containsKey(object) || (Double)this.d.get(object) < d3) {
                    this.d.put(object, new Double(d3));
                }
            }
            e2.g();
        } while (n2 == 0);
    }

    @Override
    protected void b(aa aa2) {
        super.b(aa2);
        if (!this.m) {
            return;
        }
        X x2 = this.a().a();
        d d2 = aa2.c();
        c c2 = x2.c(y.a);
        this.k = c2.b(d2);
        List list = (List)this.g.b(this.k);
        if (this.k == null || this.l == null || !this.l.equals(this.k)) {
            this.f();
            if (list == null) {
                list = new D();
                this.g.a(this.k, list);
            }
        }
        this.l = this.k;
        list.add(d2);
    }

    @Override
    protected void c(aa aa2) {
        U u2;
        int n2 = ab.a;
        super.c(aa2);
        if (!this.m) {
            return;
        }
        List list = (List)this.g.b(this.k);
        if (list != null) {
            list.remove(this.b().c());
        }
        if ((u2 = aa2.a().a(this.b().c())) == null) return;
        int n3 = 0;
        int n4 = u2.b();
        do {
            if (n3 >= n4) return;
            f f2 = u2.a(n3);
            List list2 = (List)this.h.b(f2);
            if (list2 != null) {
                list2.remove(u2);
            }
            ++n3;
        } while (n2 == 0);
    }

    private void f() {
        this.c.clear();
        this.b.clear();
        this.e.clear();
        this.f.clear();
    }

    @Override
    protected void d(aa aa2) {
        if (!this.m) {
            return;
        }
        this.g(aa2);
        this.i.a(this.k, this.b);
    }

    @Override
    protected void e(aa aa2) {
        if (!this.m) {
            return;
        }
        List list = this.f(aa2);
        this.b(list);
        this.c(list);
        this.a(aa2, list);
    }

    private List f(aa aa2) {
        int n2 = ab.a;
        HashSet<Object> hashSet = new HashSet<Object>();
        D d2 = new D();
        c c2 = this.a().a().c(y.a);
        e e2 = aa2.b();
        do {
            if (!e2.f()) return d2;
            d d3 = e2.a();
            if (c2 != null && c2.b(d3) != null && hashSet.add(c2.b(d3))) {
                d2.add(c2.b(d3));
            }
            e2.g();
        } while (n2 == 0);
        return d2;
    }

    /*
     * Unable to fully structure code
     */
    private void b(List var1_1) {
        var11_2 = ab.a;
        var2_3 = var1_1.iterator();
        block0 : do {
            v0 = var2_3.hasNext();
            block1 : do {
                if (v0 == 0) return;
                var3_4 = (List)this.g.b(var2_3.next());
                var4_5 = var3_4.iterator();
                do lbl-1000: // 4 sources:
                {
                    if (!var4_5.hasNext()) continue block0;
                    var5_6 = (d)var4_5.next();
                    var6_7 = this.b().a().a(var5_6);
                    if (!this.f.containsKey(var6_7)) ** GOTO lbl-1000
                    var7_8 = (f)this.f.get(var6_7);
                    var8_9 = (f)this.e.get(var7_8);
                    var9_10 = var6_7.a(var7_8);
                    var6_7.a(var9_10, var8_9);
                    v0 = var6_7.b();
                    if (var11_2 != 0) continue block1;
                    if (v0 <= var9_10 + 1) ** GOTO lbl-1000
                    var10_11 = var6_7.a(var9_10 + 1);
                    var10_11.a(var8_9);
                } while (var11_2 == 0);
                break;
            } while (true);
            break;
        } while (true);
    }

    /*
     * Unable to fully structure code
     */
    private void c(List var1_1) {
        var7_2 = ab.a;
        var2_3 = var1_1.iterator();
        block0 : do lbl-1000: // 3 sources:
        {
            if (var2_3.hasNext() == false) return;
            var3_4 = (List)this.i.b(var2_3.next());
            if (var3_4 == null || var3_4.isEmpty()) ** GOTO lbl-1000
            var4_5 = var3_4.iterator();
            do lbl-1000: // 3 sources:
            {
                if (!var4_5.hasNext()) continue block0;
                var5_6 = (f)var4_5.next();
                if (!this.e.containsKey(var5_6)) ** GOTO lbl-1000
                var6_7 = (f)this.e.get(var5_6);
                var6_7.a(var5_6.c());
                if (var7_2 != 0) return;
            } while (var7_2 == 0);
            break;
        } while (true);
    }

    /*
     * Unable to fully structure code
     */
    private void a(aa var1_1, List var2_2) {
        var12_3 = ab.a;
        var3_4 = var2_2.iterator();
        block0 : do lbl-1000: // 3 sources:
        {
            v0 = var3_4;
            block1 : do {
                if (v0.hasNext() == false) return;
                var4_5 = (List)this.g.b(var3_4.next());
                var5_6 = new D();
                for (Object var7_8 : var4_5) {
                    var8_9 = var1_1.a().a((d)var7_8);
                    if (var8_9 == null) continue;
                    var5_6.add(var8_9);
                    if (var12_3 != 0) ** GOTO lbl-1000
                    if (var12_3 == 0) continue;
                }
                block3 : do lbl-1000: // 3 sources:
                {
                    block9 : {
                        if (var5_6.isEmpty()) continue block0;
                        var6_7 = null;
                        var7_8 = new D();
                        var8_9 = new D();
                        v0 = var5_6.iterator();
                        if (var12_3 != 0) continue block1;
                        var9_10 = v0;
                        while (var9_10.hasNext()) {
                            var10_11 = (U)var9_10.next();
                            var11_12 = var10_11.a(0);
                            if (var6_7 == null) {
                                var6_7 = var11_12;
                                var8_9.add(var10_11);
                                var7_8.add(var1_1.i().a((U)var10_11));
                                if (var12_3 == 0) continue;
                            }
                            if (!var6_7.equals(var11_12)) continue;
                            var7_8.add(var1_1.i().a((U)var10_11));
                            var8_9.add(var10_11);
                            if (var12_3 == 0) {
                                if (var12_3 == 0) continue;
                            }
                            break block9;
                        }
                        if (var7_8.size() > 1) {
                            var9_10 = new D();
                            var9_10.add(new bN(this, (List)var7_8, 0));
                            while (!var9_10.isEmpty()) {
                                var10_11 = (bN)var9_10.remove(0);
                                var11_12 = var10_11.a();
                                if (var11_12.size() <= 0) continue;
                                var9_10.a((D)var11_12);
                                if (var12_3 != 0) continue block3;
                                if (var12_3 == 0) continue;
                            }
                        }
                    }
                    if (var5_6.size() != var8_9.size()) ** GOTO lbl51
                    var5_6.clear();
                    if (var12_3 == 0) ** GOTO lbl-1000
lbl51: // 2 sources:
                    var5_6.removeAll((Collection)var8_9);
                } while (var12_3 == 0);
                break;
            } while (true);
            break;
        } while (true);
    }

    @Override
    protected double a(f f2) {
        if (this.c.isEmpty()) return 0.0;
        if (this.c.contains(f2)) return 0.0;
        return this.b().d().f().p();
    }

    @Override
    protected void a(List list) {
        if (!this.m) return;
        list.addAll(this.b);
    }

    /*
     * Unable to fully structure code
     */
    private void g(aa var1_1) {
        var17_2 = ab.a;
        var2_3 = var1_1.a().a(var1_1.c());
        if (var2_3 == null) {
            return;
        }
        var3_4 = new D();
        var4_5 = new HashMap<K, V>();
        this.a(var1_1, var3_4, var4_5);
        this.b.clear();
        this.c.clear();
        var5_6 = var3_4.iterator();
        do lbl-1000: // 4 sources:
        {
            block4 : {
                if (var5_6.hasNext() == false) return;
                var6_7 = (f)var5_6.next();
                var7_8 = (f)var4_5.get(var6_7);
                var8_9 = this.a(var2_3, var6_7);
                var9_10 = var8_9.i();
                if (!var9_10.d(var7_8.c())) ** GOTO lbl21
                this.c.add(var7_8);
                this.b.add(var7_8);
                if (var17_2 == 0) ** GOTO lbl-1000
lbl21: // 2 sources:
                var10_11 = new f(var6_7);
                var10_11.a(var9_10);
                this.e.put(var10_11, var6_7);
                var11_12 = new D();
                var12_13 = (List)this.h.b(var7_8);
                for (U var14_15 : var12_13) {
                    var15_16 = this.a(var14_15, var6_7);
                    var16_17 = var15_16.i();
                    if (!var9_10.c(var16_17)) continue;
                    var11_12.add(var14_15);
                    if (var17_2 == 0) {
                        if (var17_2 == 0) continue;
                    }
                    break block4;
                }
                this.h.a((Object)var10_11, var11_12);
            }
            if (var11_12.size() <= 0) ** GOTO lbl-1000
            this.c.add(var10_11);
            this.b.add(var10_11);
        } while (var17_2 == 0);
    }

    private v a(U u2, f f2) {
        w w2 = this.b().i().a(u2);
        v v2 = w2.a(f2);
        if (v2 != null) {
            return v2;
        }
        f f3 = (f)this.f.get(u2);
        return w2.a(f3);
    }

    private void a(aa aa2, D d2, HashMap hashMap) {
        int n2 = ab.a;
        U u2 = aa2.a().a(aa2.c());
        if (u2 == null) {
            return;
        }
        int n3 = 0;
        int n4 = u2.b();
        do {
            if (n3 >= n4) return;
            f f2 = u2.a(n3);
            R r2 = f2.a();
            if (!(this.b.size() != 0 && !this.c.contains(f2) || aa2.b(r2) || aa2.d(r2))) {
                f f3;
                f f4 = f3 = this.e.containsKey(f2) ? (f)this.e.get(f2) : f2;
                if (f2 != f3) {
                    this.f.put(u2, f2);
                }
                hashMap.put(f3, f2);
                d2.add(f3);
            }
            ++n3;
        } while (n2 == 0);
    }

    @Override
    protected void a(U u2) {
        int n2 = ab.a;
        if (!this.m) return;
        int n3 = 0;
        int n4 = u2.b();
        do {
            if (n3 >= n4) return;
            f f2 = u2.a(n3);
            List list = (List)this.h.b(f2);
            if (list == null) {
                list = new D();
                this.h.a((Object)f2, list);
            }
            list.add(u2);
            ++n3;
        } while (n2 == 0);
    }

    static h a(bF bF2) {
        return bF2.j;
    }

    static c b(bF bF2) {
        return bF2.q;
    }

    static c c(bF bF2) {
        return bF2.p;
    }

    static c d(bF bF2) {
        return bF2.s;
    }

    static c e(bF bF2) {
        return bF2.r;
    }

    static c f(bF bF2) {
        return bF2.o;
    }

    static c g(bF bF2) {
        return bF2.n;
    }

    static HashMap h(bF bF2) {
        return bF2.d;
    }
}

