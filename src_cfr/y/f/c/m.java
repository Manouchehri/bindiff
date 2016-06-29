/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import java.util.HashMap;
import y.c.A;
import y.c.C;
import y.c.x;
import y.f.V;
import y.f.X;
import y.f.aF;
import y.f.aR;
import y.f.aT;
import y.f.ad;
import y.f.an;
import y.f.ax;
import y.f.ay;
import y.f.c;
import y.f.c.D;
import y.f.c.O;
import y.f.c.P;
import y.f.c.a;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.aW;
import y.f.c.a.aY;
import y.f.c.a.bK;
import y.f.c.a.bb;
import y.f.c.a.bk;
import y.f.c.a.bn;
import y.f.c.a.br;
import y.f.c.a.bx;
import y.f.c.a.d;
import y.f.c.a.f;
import y.f.c.a.m;
import y.f.c.a.q;
import y.f.c.a.z;
import y.f.c.af;
import y.f.c.aj;
import y.f.c.e;
import y.f.c.g;

public class M
extends c {
    public static final Object n = "y.layout.IncrementalHierarchicLayouter.STRAIGHT_EDGES_DPKEY";
    public static final Object o = N.n;
    public static final Object p = N.r;
    public static final Object q = N.s;
    public static final Object r = "y.layout.hierarchic.incremental.HierarchicLayouter.SWIMLANE_DESCRIPTOR_DPKEY";
    private byte s = 66;
    private y.c.c t;
    private y.c.c u;
    private boolean v = false;
    private boolean w = true;
    private byte x = 1;
    private long y = Long.MAX_VALUE;
    private N z;
    private y.f.c.a.aT A;
    private bx B;
    private y.f.c.a.aT C;
    private bx D;
    private byte E;
    private B F;
    private aY G;
    private double H = 20.0;
    private boolean I = false;
    private boolean J = false;
    private ad K;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;

    public byte a() {
        return this.s;
    }

    public boolean n() {
        return this.v;
    }

    public long o() {
        return this.y;
    }

    public boolean p() {
        return this.w;
    }

    public void g(boolean bl2) {
        this.w = bl2;
    }

    public M() {
        this.f(false);
        this.b(false);
        this.e(false);
        this.d(false);
        this.E = 1;
        N n2 = this.u();
        this.K = n2.b();
        this.D = n2.u();
        this.C = n2.t();
        this.b(new bn());
        this.a(new y.f.c.ay());
        an an2 = new an();
        an2.a(false);
        this.e(an2);
    }

    public boolean q() {
        return this.M;
    }

    public void h(boolean bl2) {
        this.M = bl2;
    }

    public boolean r() {
        return this.L;
    }

    public void i(boolean bl2) {
        this.C().c(bl2);
    }

    public void j(boolean bl2) {
        boolean bl3 = a.i;
        this.I = bl2;
        if (this.I || this.J) {
            this.c(this.K);
            ad ad2 = this.b();
            if (!(ad2 instanceof V)) throw new IllegalStateException("No LabelLayoutTranslator registered");
            ((V)ad2).d(this.I);
            ((V)ad2).a(this.I);
            ((V)ad2).c(this.J);
            if (bl3) {
                throw new IllegalStateException("No LabelLayoutTranslator registered");
            }
            this.c(true);
            if (!bl3) return;
        }
        this.c(false);
    }

    public void k(boolean bl2) {
        this.J = bl2;
        this.j(this.I);
    }

    public void a(double d2) {
        this.H = d2;
    }

    public void b(double d2) {
        this.s().a(d2);
    }

    public void c(double d2) {
        this.s().b(d2);
    }

    public void d(double d2) {
        this.s().c(d2);
    }

    protected q s() {
        z z2 = this.u().y();
        if (!(z2 instanceof q)) throw new IllegalStateException();
        return (q)z2;
    }

    protected N t() {
        return new N();
    }

    public N u() {
        if (this.z != null) return this.z;
        this.z = this.t();
        return this.z;
    }

    /*
     * Unable to fully structure code
     */
    public void b(byte var1_1) {
        var2_2 = null;
        var3_9 = null;
        switch (var1_1) {
            case 0: {
                var3_9 = new af();
                var3_9.a(0);
                var2_3 = var3_9;
                ** break;
            }
            case 1: {
                var2_4 = new aj();
                ** break;
            }
            case 2: {
                var3_9 = new af();
                var3_9.a(2);
                var2_5 = var3_9;
                ** break;
            }
            case 3: {
                var3_9 = new af();
                var3_9.a(1);
                var2_6 = var3_9;
                ** break;
            }
            case 4: {
                var2_7 = new g();
                this.z.a("y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges", Boolean.FALSE);
                ** break;
            }
            case 5: {
                this.a(new e());
                this.g(false);
                return;
            }
            case 6: {
                this.a(new D());
                this.g(false);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown strategy: ").append(var1_1).toString());
lbl35: // 5 sources:
        if (this.x == 0) {
            var4_10 = new f((y.f.c.a.aT)var2_8);
            this.a(var4_10);
            if (a.i == false) return;
        }
        this.a(new aW((y.f.c.a.aT)var2_8));
    }

    @Override
    public boolean b(X x2) {
        return this.u().b(x2);
    }

    /*
     * Unable to fully structure code
     */
    private void d(X var1_1) {
        block7 : {
            var12_2 = a.i;
            var2_3 = var1_1.c(M.r);
            if (var2_3 == null) return;
            var3_4 = var1_1.t();
            var4_5 = new HashMap<Object, Object>();
            var5_6 = new y.c.D();
            var6_7 = false;
            var7_8 = var1_1.o();
            while (var7_8.f()) {
                var8_10 = var7_8.e();
                var9_11 = (bK)var2_3.b(var8_10);
                if (var12_2) break block7;
                if (var9_11 == null) ** GOTO lbl23
                if (var4_5.containsKey(var9_11)) ** GOTO lbl-1000
                var5_6.add(var9_11);
                var10_12 = new aT(0, var9_11.a() == false);
                var3_4.a(var8_10, var10_12);
                var4_5.put(var9_11, var10_12);
                if (var12_2) lbl-1000: // 2 sources:
                {
                    var10_12 = (aT)var4_5.get(var9_11);
                    var3_4.a(var8_10, var10_12);
                }
                var6_7 = var6_7 != false || var9_11.a() == false;
lbl23: // 2 sources:
                var7_8.g();
                if (!var12_2) continue;
            }
            if (var6_7) {
                block8 : {
                    var5_6.sort(new O(null));
                    var7_9 = 0;
                    var8_10 = var5_6.m();
                    while (var8_10.f()) {
                        var9_11 = (aT)var4_5.get(var8_10.d());
                        var9_11.a(var7_9++);
                        var8_10.g();
                        if (!var12_2) {
                            if (!var12_2) continue;
                        }
                        break block8;
                    }
                    aR.a(var1_1, var3_4, 5, 2);
                }
                var8_10 = var1_1.o();
                while (var8_10.f()) {
                    var9_11 = var8_10.e();
                    var10_12 = (bK)var2_3.b(var9_11);
                    if (var12_2 != false) return;
                    if (var10_12 != null) {
                        var11_13 = (aT)var3_4.b(var9_11);
                        var10_12.a(new Integer(var11_13.a()));
                    }
                    var8_10.g();
                    if (!var12_2) continue;
                }
            }
        }
        var1_1.a(var3_4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void a(X var1_1) {
        var9_2 = a.i;
        if (var1_1 == null) {
            return;
        }
        this.d(var1_1);
        var2_3 = this.u();
        this.a(var1_1, var2_3);
        var3_4 = var1_1.c(N.o);
        if (var3_4 != null) ** GOTO lbl-1000
        var4_5 = y.g.q.a(this.C());
        if (var9_2) lbl-1000: // 2 sources:
        {
            var1_1.d_(N.o);
            var4_5 = new P(var3_4, this.C());
        }
        var1_1.a(N.o, var4_5);
        var5_6 = var1_1.c(N.p);
        if (var5_6 != null) ** GOTO lbl-1000
        var4_5 = y.g.q.a(this.E());
        if (var9_2) lbl-1000: // 2 sources:
        {
            var1_1.d_(N.p);
            var4_5 = new P(var5_6, this.E());
        }
        var1_1.a(N.p, var4_5);
        var6_7 = null;
        if (this.A() != 0) {
            var6_7 = var1_1.c(M.o);
            var1_1.d_(M.o);
        }
        try {
            var2_3.a(var1_1);
            var8_8 = null;
            var1_1.d_(N.o);
            if (var3_4 != null) {
                var1_1.a(N.o, var3_4);
            }
            var1_1.d_(N.p);
            if (var5_6 != null) {
                var1_1.a(N.p, var5_6);
            }
            if (this.A() != 0 && var6_7 != null) {
                var1_1.a(M.o, var6_7);
            }
            this.b(var1_1, var2_3);
            return;
        }
        catch (Throwable var7_10) {
            var8_9 = null;
            var1_1.d_(N.o);
            if (var3_4 != null) {
                var1_1.a(N.o, var3_4);
            }
            var1_1.d_(N.p);
            if (var5_6 != null) {
                var1_1.a(N.p, var5_6);
            }
            if (this.A() != 0 && var6_7 != null) {
                var1_1.a(M.o, var6_7);
            }
            this.b(var1_1, var2_3);
            throw var7_10;
        }
    }

    protected int v() {
        ad ad2 = this.g();
        if (!(ad2 instanceof an)) return 4;
        an an2 = (an)ad2;
        return an2.c();
    }

    protected void a(X x2, N n2) {
        boolean bl2 = a.i;
        if (n2.x() == null) {
            this.N = true;
            if (x2.c(ay.a) != null || x2.c(ax.a) != null || x2.c(ax.b) != null) {
                bb bb2 = new bb();
                bb2.a(this.h());
                bb2.a(this.v());
                n2.a(bb2);
            }
        }
        n2.e(this.g());
        if (this.L) {
            this.t = x2.c(aF.c);
            x2.d_(aF.c);
            this.u = x2.c(aF.d);
            x2.d_(aF.d);
        }
        n2.a("y.layout.hierarchic.incremental.HierarchicLayouter.automaticEdgeGroupingEnabled", this.r() ? Boolean.TRUE : Boolean.FALSE);
        n2.a("y.layout.hierarchic.incremental.HierarchicLayouter.backloopRoutingEnabled", this.q() ? Boolean.TRUE : Boolean.FALSE);
        n2.a(this.o());
        n2.a("DefaultEdgeRouter.defaultMinLayerDistance", new Double(this.H));
        n2.a("DefaultEdgeRouter.minimumEdgeDistance", new Double(this.C().d()));
        n2.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.enabled", !this.p() ? Boolean.FALSE : Boolean.TRUE);
        if (!(n2.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.interEdgePromotionEnabled") instanceof Boolean)) {
            n2.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.interEdgePromotionEnabled", this.p() ? Boolean.TRUE : Boolean.FALSE);
        }
        if (!(n2.a("y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges") instanceof Boolean)) {
            n2.a("y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges", Boolean.TRUE);
        }
        n2.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.alignment", new Byte(this.a()));
        n2.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.compactionEnabled", this.n() ? Boolean.TRUE : Boolean.FALSE);
        n2.a("y.layout.hierarchic.incremental.HierarchicLayouter.useAspectRatioLayerer", this.x == 0 ? Boolean.TRUE : Boolean.FALSE);
        boolean bl3 = bk.d(x2) || x2.c(y.f.c.a.aR.a) != null;
        switch (this.A()) {
            default: {
                block10 : {
                    if (bl3 && !(this.w() instanceof m)) {
                        n2.a(new m(this.w()));
                        if (!bl2) break block10;
                    }
                    n2.a(this.w());
                }
                n2.a(this.x());
                if (!bl2) return;
            }
            case 0: 
        }
        n2.a(this.y());
        n2.a(this.z());
    }

    protected void b(X x2, N n2) {
        if (this.N) {
            n2.a((br)null);
        }
        if (this.t != null) {
            x2.a(aF.c, this.t);
            this.t = null;
        }
        if (this.u == null) return;
        x2.a(aF.d, this.u);
        this.u = null;
    }

    public y.f.c.a.aT w() {
        return this.C;
    }

    public void a(y.f.c.a.aT aT2) {
        if (aT2 == null) {
            throw new NullPointerException();
        }
        this.C = aT2;
    }

    public bx x() {
        return this.D;
    }

    public y.f.c.a.aT y() {
        if (this.A != null) return this.A;
        this.A = new e();
        return this.A;
    }

    public bx z() {
        if (this.B != null) return this.B;
        this.B = new d();
        return this.B;
    }

    public byte A() {
        return this.E;
    }

    public void c(byte by2) {
        if (by2 != 1 && by2 != 0) {
            throw new IllegalArgumentException();
        }
        this.E = by2;
    }

    protected B B() {
        return new B();
    }

    public B C() {
        if (this.F != null) return this.F;
        this.F = this.B();
        return this.F;
    }

    protected aY D() {
        return new aY();
    }

    public aY E() {
        if (this.G != null) return this.G;
        this.G = this.D();
        return this.G;
    }
}

