package y.f.c;

import java.util.*;
import y.c.*;
import y.f.*;
import y.f.c.a.*;

public class M extends c
{
    public static final Object n;
    public static final Object o;
    public static final Object p;
    public static final Object q;
    public static final Object r;
    private byte s;
    private y.c.c t;
    private y.c.c u;
    private boolean v;
    private boolean w;
    private byte x;
    private long y;
    private N z;
    private aT A;
    private bx B;
    private aT C;
    private bx D;
    private byte E;
    private B F;
    private aY G;
    private double H;
    private boolean I;
    private boolean J;
    private ad K;
    private boolean L;
    private boolean M;
    private boolean N;
    
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
    
    public void g(final boolean w) {
        this.w = w;
    }
    
    public M() {
        this.s = 66;
        this.v = false;
        this.w = true;
        this.x = 1;
        this.y = Long.MAX_VALUE;
        this.H = 20.0;
        this.I = false;
        this.J = false;
        this.L = false;
        this.M = false;
        this.f(this.N = false);
        this.b(false);
        this.e(false);
        this.d(false);
        this.E = 1;
        final N u = this.u();
        this.K = u.b();
        this.D = u.u();
        this.C = u.t();
        this.b(new bn());
        this.a(new ay());
        final an an = new an();
        an.a(false);
        this.e(an);
    }
    
    public boolean q() {
        return this.M;
    }
    
    public void h(final boolean m) {
        this.M = m;
    }
    
    public boolean r() {
        return this.L;
    }
    
    public void i(final boolean b) {
        this.C().c(b);
    }
    
    public void j(final boolean i) {
        final boolean j = a.i;
        this.I = i;
        Label_0099: {
            if (this.I || this.J) {
                this.c(this.K);
                final ad b = this.b();
                if (b instanceof V) {
                    ((V)b).d(this.I);
                    ((V)b).a(this.I);
                    ((V)b).c(this.J);
                    if (!j) {
                        this.c(true);
                        if (j) {
                            break Label_0099;
                        }
                        return;
                    }
                }
                throw new IllegalStateException("No LabelLayoutTranslator registered");
            }
        }
        this.c(false);
    }
    
    public void k(final boolean j) {
        this.J = j;
        this.j(this.I);
    }
    
    public void a(final double h) {
        this.H = h;
    }
    
    public void b(final double n) {
        this.s().a(n);
    }
    
    public void c(final double n) {
        this.s().b(n);
    }
    
    public void d(final double n) {
        this.s().c(n);
    }
    
    protected q s() {
        final z y = this.u().y();
        if (y instanceof q) {
            return (q)y;
        }
        throw new IllegalStateException();
    }
    
    protected N t() {
        return new N();
    }
    
    public N u() {
        if (this.z == null) {
            this.z = this.t();
        }
        return this.z;
    }
    
    public void b(final byte b) {
        R r = null;
        switch (b) {
            case 0: {
                final af af = new af();
                af.a((byte)0);
                r = af;
                break;
            }
            case 1: {
                r = new aj();
                break;
            }
            case 2: {
                final af af2 = new af();
                af2.a((byte)2);
                r = af2;
                break;
            }
            case 3: {
                final af af3 = new af();
                af3.a((byte)1);
                r = af3;
                break;
            }
            case 4: {
                r = new g();
                this.z.a("y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges", Boolean.FALSE);
                break;
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
            default: {
                throw new IllegalArgumentException("Unknown strategy: " + b);
            }
        }
        if (this.x == 0) {
            this.a(new f((aT)r));
            if (!a.i) {
                return;
            }
        }
        this.a(new aW((aT)r));
    }
    
    public boolean b(final X x) {
        return this.u().b(x);
    }
    
    private void d(final X x) {
        final boolean i = a.i;
        final y.c.c c = x.c(y.f.c.M.r);
        if (c != null) {
            final A t = x.t();
            final HashMap<bK, y.f.aT> hashMap = new HashMap<bK, y.f.aT>();
            final y.c.D d = new y.c.D();
            boolean b = false;
            final x o = x.o();
        Label_0398:
            while (true) {
                while (o.f()) {
                    final y.c.q e = o.e();
                    final bK bk = (bK)c.b(e);
                    if (i) {
                        x.a(t);
                        return;
                    }
                    if (bk != null) {
                        Label_0185: {
                            if (!hashMap.containsKey(bk)) {
                                d.add(bk);
                                final y.f.aT at = new y.f.aT(0, !bk.a());
                                t.a(e, at);
                                hashMap.put(bk, at);
                                if (!i) {
                                    break Label_0185;
                                }
                            }
                            t.a(e, hashMap.get(bk));
                        }
                        b = (b || !bk.a());
                    }
                    o.g();
                    if (i) {
                        break;
                    }
                }
                if (b) {
                    d.sort(new O(null));
                    int n = 0;
                    final C m = d.m();
                    while (true) {
                        while (m.f()) {
                            hashMap.get(m.d()).a(n++);
                            m.g();
                            if (i) {
                                final x o2 = x.o();
                                while (o2.f()) {
                                    final y.c.q e2 = o2.e();
                                    final bK bk2 = (bK)c.b(e2);
                                    if (i) {
                                        return;
                                    }
                                    if (bk2 != null) {
                                        bk2.a(new Integer(((y.f.aT)t.b(e2)).a()));
                                    }
                                    o2.g();
                                    if (i) {
                                        break;
                                    }
                                }
                                continue Label_0398;
                            }
                            if (i) {
                                break;
                            }
                        }
                        aR.a(x, t, 5, 2);
                        continue;
                    }
                }
                continue Label_0398;
            }
        }
    }
    
    public void a(final X x) {
        final boolean i = a.i;
        if (x == null) {
            return;
        }
        this.d(x);
        final N u = this.u();
        this.a(x, u);
        final y.c.c c = x.c(y.f.c.a.N.o);
        y.c.c a = null;
        Label_0073: {
            if (c == null) {
                a = y.g.q.a(this.C());
                if (!i) {
                    break Label_0073;
                }
            }
            x.d_(y.f.c.a.N.o);
            a = new P(c, this.C());
        }
        x.a(y.f.c.a.N.o, a);
        final y.c.c c2 = x.c(y.f.c.a.N.p);
        y.c.c a2 = null;
        Label_0132: {
            if (c2 == null) {
                a2 = y.g.q.a(this.E());
                if (!i) {
                    break Label_0132;
                }
            }
            x.d_(y.f.c.a.N.p);
            a2 = new P(c2, this.E());
        }
        x.a(y.f.c.a.N.p, a2);
        y.c.c c3 = null;
        if (this.A() != 0) {
            c3 = x.c(y.f.c.M.o);
            x.d_(y.f.c.M.o);
        }
        try {
            u.a(x);
        }
        finally {
            x.d_(y.f.c.a.N.o);
            if (c != null) {
                x.a(y.f.c.a.N.o, c);
            }
            x.d_(y.f.c.a.N.p);
            if (c2 != null) {
                x.a(y.f.c.a.N.p, c2);
            }
            if (this.A() != 0 && c3 != null) {
                x.a(y.f.c.M.o, c3);
            }
            this.b(x, u);
        }
    }
    
    protected int v() {
        final ad g = this.g();
        if (g instanceof an) {
            return ((an)g).c();
        }
        return 4;
    }
    
    protected void a(final X x, final N n) {
        final boolean i = a.i;
        if (n.x() == null) {
            this.N = true;
            if (x.c(y.f.ay.a) != null || x.c(ax.a) != null || x.c(ax.b) != null) {
                final bb bb = new bb();
                bb.a(this.h());
                bb.a(this.v());
                n.a(bb);
            }
        }
        n.e(this.g());
        if (this.L) {
            this.t = x.c(aF.c);
            x.d_(aF.c);
            this.u = x.c(aF.d);
            x.d_(aF.d);
        }
        n.a("y.layout.hierarchic.incremental.HierarchicLayouter.automaticEdgeGroupingEnabled", this.r() ? Boolean.TRUE : Boolean.FALSE);
        n.a("y.layout.hierarchic.incremental.HierarchicLayouter.backloopRoutingEnabled", this.q() ? Boolean.TRUE : Boolean.FALSE);
        n.a(this.o());
        n.a("DefaultEdgeRouter.defaultMinLayerDistance", new Double(this.H));
        n.a("DefaultEdgeRouter.minimumEdgeDistance", new Double(this.C().d()));
        n.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.enabled", this.p() ? Boolean.TRUE : Boolean.FALSE);
        if (!(n.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.interEdgePromotionEnabled") instanceof Boolean)) {
            n.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.interEdgePromotionEnabled", this.p() ? Boolean.TRUE : Boolean.FALSE);
        }
        if (!(n.a("y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges") instanceof Boolean)) {
            n.a("y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges", Boolean.TRUE);
        }
        n.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.alignment", new Byte(this.a()));
        n.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.compactionEnabled", this.n() ? Boolean.TRUE : Boolean.FALSE);
        n.a("y.layout.hierarchic.incremental.HierarchicLayouter.useAspectRatioLayerer", (this.x == 0) ? Boolean.TRUE : Boolean.FALSE);
        final boolean b = bk.d(x) || x.c(y.f.c.a.aR.a) != null;
        Label_0471: {
            switch (this.A()) {
                default: {
                    Label_0458: {
                        if (b && !(this.w() instanceof m)) {
                            n.a(new m(this.w()));
                            if (!i) {
                                break Label_0458;
                            }
                        }
                        n.a(this.w());
                    }
                    n.a(this.x());
                    if (i) {
                        break Label_0471;
                    }
                    break;
                }
                case 0: {
                    n.a(this.y());
                    n.a(this.z());
                    break;
                }
            }
        }
    }
    
    protected void b(final X x, final N n) {
        if (this.N) {
            n.a((br)null);
        }
        if (this.t != null) {
            x.a(aF.c, this.t);
            this.t = null;
        }
        if (this.u != null) {
            x.a(aF.d, this.u);
            this.u = null;
        }
    }
    
    public aT w() {
        return this.C;
    }
    
    public void a(final aT c) {
        if (c == null) {
            throw new NullPointerException();
        }
        this.C = c;
    }
    
    public bx x() {
        return this.D;
    }
    
    public aT y() {
        if (this.A == null) {
            this.A = new e();
        }
        return this.A;
    }
    
    public bx z() {
        if (this.B == null) {
            this.B = new d();
        }
        return this.B;
    }
    
    public byte A() {
        return this.E;
    }
    
    public void c(final byte e) {
        if (e != 1 && e != 0) {
            throw new IllegalArgumentException();
        }
        this.E = e;
    }
    
    protected B B() {
        return new B();
    }
    
    public B C() {
        if (this.F == null) {
            this.F = this.B();
        }
        return this.F;
    }
    
    protected aY D() {
        return new aY();
    }
    
    public aY E() {
        if (this.G == null) {
            this.G = this.D();
        }
        return this.G;
    }
    
    static {
        n = "y.layout.IncrementalHierarchicLayouter.STRAIGHT_EDGES_DPKEY";
        o = N.n;
        p = N.r;
        q = N.s;
        r = "y.layout.hierarchic.incremental.HierarchicLayouter.SWIMLANE_DESCRIPTOR_DPKEY";
    }
}
