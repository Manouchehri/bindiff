/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.ArrayList;
import y.c.A;
import y.c.C;
import y.c.d;
import y.c.f;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.y;
import y.d.t;
import y.f.I;
import y.f.X;
import y.f.aF;
import y.f.ae;
import y.f.ah;
import y.f.c;
import y.f.c.D;
import y.f.c.L;
import y.f.c.Q;
import y.f.c.R;
import y.f.c.S;
import y.f.c.V;
import y.f.c.Y;
import y.f.c.Z;
import y.f.c.a;
import y.f.c.aE;
import y.f.c.aa;
import y.f.c.af;
import y.f.c.ag;
import y.f.c.aj;
import y.f.c.ao;
import y.f.c.aw;
import y.f.c.e;
import y.f.c.g;
import y.f.c.h;
import y.f.c.v;
import y.f.c.x;
import y.g.ap;
import y.g.o;

public class K
extends c
implements aF {
    private byte n = 0;
    private long u;
    private long v = Integer.MAX_VALUE;
    private boolean w = true;
    private int x = 1;
    private boolean y = false;
    private boolean z = true;
    private double A = 40.0;
    private double B = 20.0;
    private double C = 10.0;
    private double D = 10.0;
    private R E;
    private Q F;
    private v G;
    private ao H;
    private double I = 20.0;
    static final Object o = "y.layout.hierarchic.HierarchicLayouter.NODE_TYPE_MAP_KEY";
    static final Object p = "y.layout.hierarchic.HierarchicLayouter.NORMAL_NODE_TYPE";
    static final Object q = "y.layout.hierarchic.HierarchicLayouter.BEND_NODE_TYPE";
    static final Object r = "y.layout.hierarchic.HierarchicLayouter.DUMMY_NODE_TYPE";
    static final Object s = "y.layout.hierarchic.HierarchicLayouter.LABEL_NODE_TYPE";
    static final Object t = "y.layout.hierarchic.HierarchicLayouter.SAME_LAYER_DUMMY_TYPE";
    private L J;

    public K() {
        this.f(false);
        this.b(false);
        this.e(true);
        this.F = new h();
        this.H = new aw();
        this.c(2);
        this.b(1);
    }

    public byte q() {
        return this.n;
    }

    public void b(byte by2) {
        boolean bl2 = a.i;
        o.a(this, (Object)new StringBuffer().append("Set Layout style: ").append(by2).toString());
        switch (by2) {
            case 2: {
                this.G = new aa();
                if (!bl2) return;
            }
            case 1: {
                this.G = new V();
                if (!bl2) return;
            }
            case 0: {
                this.G = new Z();
                if (!bl2) return;
            }
            case 3: {
                this.G = new ag();
                if (!bl2) return;
            }
            case 4: {
                this.G = new y.f.c.ae();
                if (!bl2) return;
            }
            case 5: {
                this.G = new S(new y.f.c.ae());
                if (!bl2) return;
            }
        }
        this.G = new V();
    }

    public void c(byte by2) {
        boolean bl2 = a.i;
        af af2 = null;
        switch (by2) {
            case 0: {
                af2 = new af();
                af2.a(0);
                this.E = af2;
                return;
            }
            case 1: {
                this.E = new aj();
                if (!bl2) return;
            }
            case 2: {
                af2 = new af();
                af2.a(2);
                this.E = af2;
                return;
            }
            case 3: {
                af2 = new af();
                af2.a(1);
                this.E = af2;
                return;
            }
            case 4: {
                this.E = new g();
                if (!bl2) return;
            }
            case 5: {
                this.E = new e();
                if (!bl2) return;
            }
            case 6: {
                this.E = new D();
                if (!bl2) return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("layeringStrategy ").append(by2).append(" unknown.").toString());
    }

    public void a(R r2) {
        this.E = r2;
    }

    public R a() {
        return this.E;
    }

    public void a(Q q2) {
        this.F = q2;
    }

    public Q n() {
        return this.F;
    }

    public void a(v v2) {
        this.G = v2;
        this.G.c(this.B);
        this.G.d(this.A);
    }

    public v o() {
        return this.G;
    }

    public double r() {
        return this.C;
    }

    public double s() {
        return this.I;
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
        block17 : {
            var20_2 = a.i;
            this.u = System.currentTimeMillis();
            ae.a(var1_1, false);
            var2_3 = var1_1.t();
            var3_4 = var1_1.t();
            var4_5 = null;
            var5_6 = var1_1.c(K.o);
            if (var5_6 == null) {
                var5_6 = var4_5 = var1_1.t();
                var1_1.a(K.o, var4_5);
                var6_7 = var1_1.o();
                while (var6_7.f()) {
                    var4_5.a((Object)var6_7.e(), K.p);
                    var6_7.g();
                    if (!var20_2) continue;
                    i.g = i.g == false;
                    break;
                }
            }
            var6_7 = new y.c.D();
            var7_8 = null;
            var8_9 = null;
            var9_10 = null;
            var10_11 = null;
            if (this.J != null) {
                var11_12 = var1_1.c(ah.f_);
                if (var11_12 == null) {
                    throw new IllegalStateException(new StringBuffer().append("No DataProvider ").append(ah.f_).append(" bound to graph!").toString());
                }
                var12_14 = var1_1.c(ah.k);
                if (var12_14 == null) {
                    throw new IllegalStateException(new StringBuffer().append("No DataProvider ").append(ah.k).append(" bound to graph!").toString());
                }
                var7_8 = var1_1.t();
                var8_9 = var1_1.u();
                var9_10 = new ap(var7_8, var1_1, ah.f_);
                var10_11 = new ap(var8_9, var1_1, ah.k);
                this.J.a(var5_6, var2_3, var3_4, this.E, (y.c.D)var6_7, this.F, var9_10, var7_8, var10_11, var8_9);
            }
            var11_13 = var1_1.u();
            var12_14 = new f();
            var13_15 = new aE(var1_1, var2_3, var3_4, var11_13);
            var13_15.a(true);
            var14_16 = new x(var1_1, var2_3, var3_4, var11_13, (y.c.D)var6_7);
            var14_16.a(this.y);
            var14_16.b(this.z);
            if (var7_8 != null) {
                var14_16.a(var7_8, var9_10, var8_9, var10_11);
            }
            var15_17 = this.q() == 1;
            var14_16.c(var15_17);
            var14_16.a(this.r());
            var14_16.b(this.s());
            if (!var15_17) ** GOTO lbl-1000
            var14_16.c(this.A);
            this.G.d(0.0);
            if (var20_2) lbl-1000: // 2 sources:
            {
                var14_16.c(this.A);
                this.G.d(0.0);
            }
            this.G.c(this.B);
            this.G.a(this.C);
            this.G.b(this.D);
            this.G.a(var3_4);
            var14_16.b();
            if (this.J == null || !this.J.a(1) && this.J.b() == null) ** GOTO lbl-1000
            var16_18 = this.J.a(var1_1, var2_3, (f)var12_14);
            if (var20_2) lbl-1000: // 2 sources:
            {
                var16_18 = this.E.a(var1_1, var2_3, (f)var12_14);
                for (var17_19 = 0; var17_19 < var16_18; ++var17_19) {
                    var6_7.add(new StringBuffer().append("LayerID").append(var17_19).toString());
                    if (!var20_2) continue;
                }
            }
            for (var17_20 = var12_14.k(); var17_20 != null; var17_20 = var17_20.a()) {
                var11_13.a(var17_20.c(), true);
                if (!var20_2) {
                    if (!var20_2) continue;
                }
                break block17;
            }
            var16_18 = var14_16.a(var16_18, (f)var12_14);
            var16_18 = var14_16.a(var16_18);
            this.H.a(var1_1, var2_3, var3_4);
            var16_18 = var14_16.b(var16_18);
            var16_18 = var14_16.c(var16_18);
        }
        if (this.n() instanceof h) {
            var17_20 = (h)this.n();
            var17_20.b(this.w);
            var18_21 = System.currentTimeMillis() - this.u;
            var17_20.a(this.v - var18_21);
        }
        var17_20 = this.a(var1_1, var2_3, var16_18);
        var17_20 = var14_16.a(var17_20);
        var17_20 = var13_15.a(var17_20);
        var17_20 = var14_16.b(var17_20);
        this.G.a(var1_1, var17_20, var2_3);
        var17_20 = var14_16.c(var17_20);
        var14_16.d(var17_20);
        var13_15.a(var14_16.f());
        var14_16.c();
        this.H.b(var1_1, var2_3, var3_4);
        var14_16.d();
        this.d(var1_1);
        this.a(var1_1, (f)var12_14);
        var14_16.e();
        var13_15.c();
        if (var4_5 != null) {
            var1_1.d_(K.o);
            var1_1.a(var4_5);
        }
        if (var9_10 != null) {
            var9_10.b();
        }
        if (var10_11 != null) {
            var10_11.b();
        }
        if (var7_8 != null) {
            var1_1.a(var7_8);
        }
        if (var8_9 != null) {
            var1_1.a(var8_9);
        }
        var1_1.a(var11_13);
        var1_1.a(var3_4);
        var1_1.a(var2_3);
    }

    protected y[] a(X x2, A a2, int n2) {
        if (this.J == null) return this.F.a(x2, a2, n2);
        if (this.J.a(2)) return this.J.a(x2, a2, n2);
        if (this.J.b() == null) return this.F.a(x2, a2, n2);
        return this.J.a(x2, a2, n2);
    }

    static A a(i i2) {
        return (A)i2.c(o);
    }

    static Object a(y y2, y.c.c c2) {
        Object object;
        boolean bl2 = a.i;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        for (p p2 = y2.k(); p2 != null; ++n7, p2 = p2.a()) {
            Object object2;
            object = object2 = c2.b(p2.c());
            if (bl2) return object;
            if (object == null) {
                ++n2;
                if (!bl2) continue;
            }
            if (object2 == p) {
                ++n3;
                if (!bl2) continue;
            }
            if (object2 == r) {
                ++n5;
                if (!bl2) continue;
            }
            if (object2 == q) {
                ++n6;
                if (!bl2) continue;
            }
            if (object2 != s) continue;
            ++n4;
            if (!bl2) continue;
        }
        if (n7 == n2) {
            return p;
        }
        if ((n7 -= n2) == n4) {
            return s;
        }
        if (n7 == n6) {
            return q;
        }
        if (n7 == n4 + n6) {
            return q;
        }
        if (n7 == n5 + n6) {
            return r;
        }
        if (n7 == n3 + n6 + n4) {
            return p;
        }
        if (n5 > 0) {
            object = r;
            return object;
        }
        object = p;
        return object;
    }

    private void a(X x2, f f2) {
        boolean bl2 = a.i;
        y.c.e e2 = f2.a();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            t t2 = x2.p(d2);
            t t3 = x2.q(d2);
            x2.c(d2);
            y.d.v v2 = x2.j(d2);
            x2.b(d2, v2.g());
            x2.d(d2, t2);
            x2.c(d2, t3);
            e2.g();
        } while (!bl2);
    }

    private void d(X x2) {
        boolean bl2 = a.i;
        y.c.e e2 = x2.p();
        block0 : do {
            if (!e2.f()) return;
            d d2 = e2.a();
            I i2 = x2.g(d2);
            if (i2.pointCount() > 0) {
                int n2;
                ArrayList<t> arrayList = new ArrayList<t>(i2.pointCount());
                y.d.v v2 = x2.l(d2);
                C c2 = v2.a();
                t t2 = (t)c2.d();
                c2.g();
                double d3 = t2.a();
                double d4 = t2.b();
                if (c2.f()) {
                    t2 = (t)c2.d();
                    double d5 = t2.a();
                    double d6 = t2.b();
                    c2.g();
                    while (c2.f()) {
                        t t3 = (t)c2.d();
                        double d7 = t3.a();
                        double d8 = t3.b();
                        double d9 = (d3 - d7) * (d6 - d8) / (d4 - d8) + d7;
                        n2 = (int)(Math.abs(d9 - d5) DCMPL (double)this.x);
                        if (!bl2) {
                            if (n2 > 0) {
                                arrayList.add(t2);
                                d3 = d5;
                                d4 = d6;
                            }
                            t2 = t3;
                            d5 = d7;
                            d6 = d8;
                            c2.g();
                            if (!bl2) continue;
                        }
                        break;
                    }
                } else {
                    n2 = arrayList.size();
                }
                if (n2 < i2.pointCount()) {
                    i2.clearPoints();
                    for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                        t t4 = (t)arrayList.get(i3);
                        i2.addPoint(t4.a, t4.b);
                        if (bl2) continue block0;
                        if (!bl2) continue;
                    }
                }
            }
            e2.g();
        } while (!bl2);
    }

    public Y t() {
        if (this.J != null) return this.J;
        this.J = new L();
        return this.J;
    }

    boolean u() {
        if (this.J == null) return false;
        if (this.t().b() == null) return false;
        return true;
    }

    public void v() {
        if (this.J == null) return;
        this.J.c();
        this.J = null;
    }
}

