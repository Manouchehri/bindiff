/*
 * Decompiled with CFR 0_115.
 */
package y.f.f;

import y.c.A;
import y.c.h;
import y.c.x;
import y.f.U;
import y.f.V;
import y.f.X;
import y.f.aI;
import y.f.ad;
import y.f.ah;
import y.f.an;
import y.f.e;
import y.f.f.b.b;
import y.f.f.b.p;
import y.f.f.c.f;
import y.f.f.c.m;
import y.f.f.d;
import y.f.f.d.F;
import y.f.f.d.o;
import y.f.f.d.t;
import y.f.f.d.w;
import y.f.f.e.a;
import y.f.f.e.i;
import y.f.f.e.k;
import y.f.f.e.n;
import y.f.k.L;
import y.g.q;

public class c
extends y.f.c {
    private static final Object o = "y.layout.orthogonal.OrthogonalLayouter.INCREMENTAL_NODES_DPKEY";
    private static final Object p = "y.layout.orthogonal.OrthogonalLayouter.INCREMENTAL_EDGES_DPKEY";
    public static final Object n = "y.layout.orthogonal.OrthogonalLayouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY";
    private int q = 0;
    private int r = 25;
    private boolean s = true;
    private boolean t = true;
    private boolean u = true;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private boolean y;
    private boolean z;
    private boolean A = false;
    private boolean B = false;
    private ad C = new V();
    private y.f.f.a D;

    protected y.f.f.a a() {
        return new y.f.f.a();
    }

    public y.f.f.a n() {
        if (this.D != null) return this.D;
        this.D = this.a();
        return this.D;
    }

    public c() {
        this.f(false);
        this.b(false);
        ad ad2 = this.f();
        if (ad2 instanceof y.f.b.b) {
            ((y.f.b.b)ad2).a(false);
        }
        an an2 = new an();
        an2.a(false);
        this.e(an2);
    }

    public boolean o() {
        return this.z;
    }

    public void a(int n2) {
        if (n2 < 1) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal value for grid size: ").append(n2).toString());
        }
        this.r = n2;
    }

    public int p() {
        return this.r;
    }

    public void b(int n2) {
        if (n2 < 0) throw new IllegalArgumentException(new StringBuffer().append("Illegal value for layout style: ").append(n2).toString());
        if (n2 > 6) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal value for layout style: ").append(n2).toString());
        }
        this.q = n2;
    }

    public int q() {
        return this.q;
    }

    public boolean r() {
        return this.v;
    }

    @Override
    public boolean b(X x2) {
        return true;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void a(X var1_1) {
        block44 : {
            block38 : {
                var12_2 = y.f.f.a.a;
                var2_3 = new y.f.f.b.a();
                var2_3.a(this.r);
                var2_3.a(this.n());
                var3_4 = null;
                var4_5 = null;
                var5_6 = null;
                var6_7 = null;
                var7_8 = null;
                var8_9 = null;
                v0 = var9_10 = this.q == 0 || this.q == 4 || this.q == 1;
                if (var9_10) {
                    var2_3.a(new F());
                }
                if (this.q == 4) {
                    var10_11 = new d();
                    var10_11.c(y.f.k.a.s);
                    var10_11.b(Math.max(this.r, 10));
                    var10_11.a(Math.max(this.r, 10));
                    var10_11.c(Math.max(this.r, 20));
                    var10_11.m();
                    var11_12 = new L((ah)var10_11);
                    var11_12.a(this.r() == false);
                    var2_3.b(var11_12);
                    var2_3.g(true);
                    if (!var12_2) break block38;
                    y.c.i.g = y.c.i.g == false;
                }
                var2_3.g(false);
            }
            if (!this.v) ** GOTO lbl42
            var3_4 = var1_1.u();
            var4_5 = var1_1.t();
            this.a(var1_1, var4_5, var3_4);
            var10_11 = new y.f.h.d();
            var10_11.a(var3_4);
            var10_11.a(var4_5);
            var5_6 = var10_11;
            if (!var9_10) ** GOTO lbl-1000
            var10_11.a(true);
            if (var12_2) lbl-1000: // 2 sources:
            {
                var10_11.a(false);
            }
            ** GOTO lbl49
lbl42: // 1 sources:
            var10_11 = new y.f.h.c();
            var10_11.a(-1);
            var10_11.b(this.w == false);
            var10_11.d(this.u);
            var10_11.a(this.t);
            var10_11.c(this.w);
            var5_6 = var10_11;
lbl49: // 2 sources:
            if (var9_10) {
                if (this.v) {
                    var10_11 = new w();
                    var10_11.a(var3_4);
                    var6_7 = var10_11;
                } else {
                    var10_11 = new o();
                    var10_11.a(this.o());
                    var6_7 = var10_11;
                }
            } else {
                var10_11 = new k();
                var10_11.a(this.o());
                var6_7 = var10_11;
            }
            if (var9_10) {
                block39 : {
                    var10_11 = new t();
                    var10_11.a(false);
                    var1_1.a(t.a, q.a(new Integer(5)));
                    switch (this.q) {
                        case 0: 
                        case 4: {
                            var10_11.a(0);
                            if (!var12_2) break;
                        }
                        case 1: {
                            var10_11.a(1);
                        }
                    }
                    if (this.y) {
                        var10_11.a(3);
                        var10_11.a(new m());
                        var10_11.a(true);
                    }
                    var10_11.b(0);
                    if (this.s) {
                        var10_11.b(2);
                        if (!var12_2) break block39;
                    }
                    var10_11.b(3);
                }
                var7_8 = var10_11;
            } else if (this.q() == 2 || this.q() == 3) {
                block40 : {
                    var10_11 = new n();
                    var10_11.b(0);
                    if (this.s) {
                        var10_11.b(2);
                        if (!var12_2) break block40;
                    }
                    var10_11.b(3);
                }
                var10_11.a(0);
                var7_8 = var10_11;
            } else if (this.q() == 6 || this.q() == 5) {
                block41 : {
                    var10_11 = new y.f.f.e.m();
                    var10_11.a(0);
                    if (this.s) {
                        var10_11.b(2);
                        if (!var12_2) break block41;
                    }
                    var10_11.b(3);
                }
                var7_8 = var10_11;
            }
            if (this.q() == 2 || this.q() == 3) {
                block42 : {
                    var10_11 = new i();
                    if (this.q() == 3) {
                        var10_11.a(1);
                        if (!var12_2) break block42;
                    }
                    var10_11.a(0);
                }
                var8_9 = var10_11;
            } else if (this.q == 6 || this.q == 5) {
                block43 : {
                    var10_11 = new a();
                    if (this.q() == 5) {
                        var10_11.a(2);
                        if (!var12_2) break block43;
                    }
                    var10_11.a(3);
                }
                var8_9 = var10_11;
            }
            var2_3.a((y.f.h.o)var5_6);
            var2_3.a((b)var6_7);
            var2_3.a((p)var7_8);
            var2_3.a((y.f.f.b.d)var8_9);
            if (!var9_10) {
                var2_3.g(false);
            }
            if (!var9_10) {
                var2_3.h(false);
            }
            if (var9_10) {
                var2_3.i(var1_1.c(U.a) != null);
                if (!var12_2) break block44;
            }
            var2_3.i(false);
        }
        var2_3.j(var1_1.c(U.b) != null && (this.q == 0 || this.q == 4));
        if (this.e() instanceof e) {
            var10_11 = (e)this.e();
            var10_11.a(this.p());
            var10_11.b(0.0);
        }
        var2_3.m();
        var2_3.c(var1_1);
        if (this.v) {
            var1_1.a(var3_4);
            var1_1.a(var4_5);
        }
        if (var9_10) {
            var1_1.d_(t.a);
        }
        new aI().c(var1_1);
    }

    private void a(X x2, A a2, h h2) {
        y.c.c c2;
        Object object;
        Object object2;
        boolean bl2 = y.f.f.a.a;
        y.c.c c3 = x2.c(p);
        if (c3 != null) {
            object2 = x2.p();
            while (object2.f()) {
                object = object2.a();
                c2 = h2;
                if (!bl2) {
                    c2.a(object, c3.d(object));
                    object2.g();
                    if (!bl2) continue;
                }
                break;
            }
        } else {
            c2 = x2.c(o);
        }
        if ((object2 = c2) == null) return;
        object = x2.o();
        do {
            if (!object.f()) return;
            y.c.q q2 = object.e();
            a2.a((Object)q2, object2.d(q2));
            object.g();
        } while (!bl2);
    }
}

