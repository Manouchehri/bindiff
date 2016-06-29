package y.f.i;

import y.g.*;
import y.d.*;
import y.c.*;
import java.awt.geom.*;
import java.util.*;
import y.f.*;

public class v extends a
{
    private X g;
    private byte h;
    private boolean i;
    private t n;
    private int o;
    private int p;
    private double q;
    private double r;
    private i s;
    private f t;
    private q u;
    private q v;
    private d w;
    private boolean x;
    private c y;
    private c z;
    private N A;
    private aF B;
    private A C;
    private A D;
    private h E;
    private A F;
    private boolean G;
    private boolean H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private al P;
    private al Q;
    private al R;
    private al S;
    private al T;
    private al U;
    private al V;
    private al W;
    private h X;
    private h Y;
    private A Z;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    private int ad;
    private boolean ae;
    private int af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private double aj;
    private byte ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private f ap;
    private HashMap aq;
    private byte ar;
    private boolean as;
    private boolean at;
    private boolean au;
    Object a;
    Object b;
    private boolean av;
    private boolean aw;
    Map c;
    private h ax;
    private h ay;
    private int az;
    private double aA;
    private double aB;
    private double aC;
    private double aD;
    private double aE;
    private int aF;
    private boolean aG;
    aQ d;
    A e;
    private A aH;
    private A aI;
    private P aJ;
    private N aK;
    private N aL;
    private N aM;
    private d[] aN;
    private boolean aO;
    private boolean aP;
    private boolean aQ;
    private boolean aR;
    private boolean aS;
    private boolean aT;
    public static int f;
    
    public Object b() {
        return this.b;
    }
    
    public Object c() {
        return this.a;
    }
    
    public void a(final Object a) {
        if (a == null) {
            throw new IllegalArgumentException("null");
        }
        this.a = a;
    }
    
    public void a(final boolean at) {
        this.at = at;
    }
    
    public boolean d() {
        return this.at;
    }
    
    public byte e() {
        return this.ar;
    }
    
    public void a(final byte ar) {
        this.ar = ar;
    }
    
    public boolean f() {
        return this.as;
    }
    
    public void b(final boolean as) {
        this.as = as;
    }
    
    private boolean D() {
        return this.ar == 1 || this.ar == 3;
    }
    
    private boolean E() {
        return this.ar == 2 || this.ar == 3;
    }
    
    private boolean F() {
        return this.ar != 0;
    }
    
    public v() {
        this(null);
    }
    
    public v(final ah ah) {
        this.aq = new HashMap();
        this.ar = 0;
        this.as = false;
        this.at = false;
        this.a = y.f.ah.h_;
        this.b = y.f.ah.g_;
        this.aE = 0.0;
        this.aF = 0;
        this.aG = false;
        this.aQ = false;
        this.aR = false;
        this.aS = true;
        this.aT = true;
        super.a(ah);
        this.av = true;
        this.au = true;
        this.aw = false;
        this.c((byte)3);
        this.am = true;
        this.h = 0;
        this.i = false;
        this.n = new t(0.0, 0.0);
        this.o = 2;
        this.p = this.o;
        this.q = 2.0;
        this.r = this.q;
        this.aa = true;
        this.aO = true;
        this.ag = true;
        this.ah = true;
        this.ai = true;
        this.aj = 0.5;
        this.G = false;
        this.H = false;
        this.an = true;
        this.ab = true;
        this.aP = false;
    }
    
    public void c(final X g) {
        final int f = y.f.i.v.f;
        boolean b = false;
        if (g.c("y.layout.router.ORTHOGONAL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY") == null) {
            this.b(g);
            g.a("y.layout.router.ORTHOGONAL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY", y.g.q.a(Boolean.TRUE));
            b = true;
        }
        if (this.h == 2) {
            final Object c = this.c();
            if (g.c(c) == null) {
                throw new IllegalStateException("No DataProvider " + c + " registered with graph!");
            }
        }
        else if (this.h == 4) {
            final Object b2 = this.b();
            if (g.c(b2) == null) {
                throw new IllegalStateException("No DataProvider " + b2 + " registered with graph!");
            }
        }
        final ah a = this.a();
        if (a != null) {
            a.c(g);
        }
        Label_0881: {
            if (g.h() > 0) {
                final ar ar = new ar(g, this);
                ar.b();
                ar.d();
                this.P = new al();
                this.g = g;
                this.ap = new f();
                this.ay = g.u();
                this.az = 0;
                final B b3 = new B(g, null);
                if (this.d()) {
                    b3.a();
                }
                this.Z = y.g.M.a();
                this.g();
                this.i();
                this.X = y.g.M.b();
                this.Y = y.g.M.b();
                final h b4 = y.g.M.b();
                e e = this.t.a();
                while (true) {
                Label_0411_Outer:
                    while (e.f()) {
                        b4.a(e.a(), true);
                        e.g();
                        if (f != 0) {
                            while (true) {
                                while (e.f()) {
                                    final d a2 = e.a();
                                    final boolean d = b4.d(a2);
                                    if (f != 0) {
                                        Label_0468: {
                                            while (true) {
                                                if (!d) {
                                                    this.b(this.ap.d());
                                                    if (f != 0) {
                                                        break Label_0468;
                                                    }
                                                    if (f == 0) {
                                                        this.ap.isEmpty();
                                                        continue Label_0411_Outer;
                                                    }
                                                }
                                                break;
                                            }
                                            this.N = this.s.e();
                                            this.O = this.s.g();
                                        }
                                        if (this.aO) {
                                            this.j();
                                        }
                                        if (this.aG && this.m()) {
                                            this.n();
                                            if (this.aO) {
                                                this.j();
                                            }
                                        }
                                        boolean b5 = false;
                                        Label_0786: {
                                            Label_0778: {
                                                if (this.az > 0 && this.i) {
                                                    final v e2 = this.e(this);
                                                    e2.d(false);
                                                    e2.b((byte)2);
                                                    final Object c2 = this.c();
                                                    final c c3 = g.c(c2);
                                                    g.a(c2, this.ay);
                                                    e2.c(g);
                                                    g.d_(c2);
                                                    if (c3 == null) {
                                                        break Label_0778;
                                                    }
                                                    g.a(c2, c3);
                                                    if (f == 0) {
                                                        break Label_0778;
                                                    }
                                                }
                                                if (this.az > 0 && this.ab) {
                                                    final y.f.i.a a3 = new y.f.i.a();
                                                    final c c4 = g.c("edge2RoutedByChannelEdgeRouter");
                                                    if (c4 != null) {
                                                        final e p = g.p();
                                                        while (p.f()) {
                                                            final d a4 = p.a();
                                                            b5 = (c4.b(a4) instanceof b);
                                                            if (f != 0) {
                                                                break Label_0786;
                                                            }
                                                            if (b5) {
                                                                ((b)c4.b(a4)).a(this.ay.d(a4));
                                                            }
                                                            p.g();
                                                            if (f != 0) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    g.a(y.f.i.a.a, this.ay);
                                                    final E e3 = new E();
                                                    e3.a(y.f.i.a.a);
                                                    e3.a(this.e());
                                                    a3.b(e3);
                                                    a3.c(g);
                                                    g.d_(y.f.i.a.a);
                                                }
                                            }
                                            this.h();
                                            this.d();
                                        }
                                        if (b5) {
                                            b3.b();
                                        }
                                        g.a(this.ay);
                                        this.s = null;
                                        this.t = null;
                                        this.z = null;
                                        this.y = null;
                                        this.A = null;
                                        this.B = null;
                                        this.C = null;
                                        this.D = null;
                                        this.E = null;
                                        this.F = null;
                                        this.P.b();
                                        if (this.G) {
                                            System.out.print(this.S());
                                        }
                                        ar.e();
                                        break Label_0881;
                                    }
                                    if (!d) {
                                        this.a(a2, g);
                                    }
                                    e.g();
                                    if (f != 0) {
                                        break;
                                    }
                                }
                                this.K();
                                continue;
                            }
                        }
                        if (f != 0) {
                            break;
                        }
                    }
                    e = g.p();
                    continue;
                }
            }
        }
        if (b) {
            g.d_("y.layout.router.ORTHOGONAL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY");
        }
    }
    
    private v e(final v v) {
        final v v2 = new v();
        v2.a(v.a());
        v2.a(v.d());
        v2.d(v.v());
        v2.g(v.z());
        v2.b(v.x());
        v2.e(v.u());
        v2.a(v.k());
        v2.e(v.B());
        v2.h(v.A());
        v2.b(v.f());
        v2.a((int)v.r().a, (int)v.r().b);
        v2.d(v.q());
        v2.b(v.s());
        v2.i(v.C());
        v2.f(v.w());
        v2.c(v.t());
        v2.d(v.v());
        v2.a(v.e());
        v2.c(v.l());
        v2.c(v.y());
        v2.b(v.p());
        v2.a(v.c());
        return v2;
    }
    
    private void b(final X x) {
        this.a(x, x);
    }
    
    private void a(final n n, final O o) {
        final int f = y.f.i.v.f;
        c c = n.c(y.f.b.f.d);
        if (c == null) {
            c = y.g.q.a(Boolean.FALSE);
        }
        final Iterator x = n.x();
        while (x.hasNext()) {
            final Object next = x.next();
            if (!c.d(next)) {
                this.a(o, next);
                if (f == 0) {
                    continue;
                }
            }
            this.b(o, next);
            if (f != 0) {
                break;
            }
        }
    }
    
    protected void a(final O o, final Object o2) {
        final am a = o.a(o2);
        if (a.getWidth() == 0.0 || a.getHeight() == 0.0) {
            throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        }
    }
    
    protected void b(final O o, final Object o2) {
        final am a = o.a(o2);
        if (a.getWidth() == 0.0 || a.getHeight() == 0.0) {
            throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        }
    }
    
    void g() {
        final int f = y.f.i.v.f;
        this.D = this.g.t();
        this.E = this.g.u();
        this.ax = this.g.u();
        final e p = this.g.p();
        while (p.f()) {
            this.E.a(p.a(), new ae(p.a()));
            p.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    void h() {
        this.g.a(this.D);
        this.g.a(this.E);
        this.g.a(this.ax);
    }
    
    void i() {
        this.aF = 0;
        this.R();
        this.L();
        this.G();
        if (this.aa) {
            this.F = this.s.t();
        }
        this.S = new al();
        this.N();
        this.S.b();
        if (this.ac) {
            this.c((double)this.ad);
            if (y.f.i.v.f == 0) {
                return;
            }
        }
        if (this.i) {
            this.c(0.5 * this.o);
        }
    }
    
    private void G() {
        final int f = y.f.i.v.f;
        this.c = new HashMap();
        final x o = this.g.o();
        while (o.f()) {
            final q e = o.e();
            final aJ aj = (aJ)this.z.b(e);
            Label_0324: {
                Label_0186: {
                    if (this.c(e)) {
                        this.a(aj.a);
                        this.a(aj.c);
                        C c = aj.a.m();
                        while (true) {
                            while (c.f()) {
                                this.c.put(c.d(), e);
                                c.g();
                                if (f != 0) {
                                    while (c.f()) {
                                        this.c.put(c.d(), e);
                                        c.g();
                                        if (f != 0) {
                                            break Label_0324;
                                        }
                                        if (f != 0) {
                                            break;
                                        }
                                    }
                                    break Label_0186;
                                }
                                if (f != 0) {
                                    break;
                                }
                            }
                            c = aj.c.m();
                            continue;
                        }
                    }
                }
                Label_0318: {
                    if (this.d(e)) {
                        this.a(aj.g);
                        this.a(aj.e);
                        C c2 = aj.g.m();
                        while (true) {
                            while (c2.f()) {
                                this.c.put(c2.d(), e);
                                c2.g();
                                if (f != 0) {
                                    while (c2.f()) {
                                        this.c.put(c2.d(), e);
                                        c2.g();
                                        if (f != 0) {
                                            break Label_0324;
                                        }
                                        if (f != 0) {
                                            break;
                                        }
                                    }
                                    break Label_0318;
                                }
                                if (f != 0) {
                                    break;
                                }
                            }
                            c2 = aj.e.m();
                            continue;
                        }
                    }
                }
                o.g();
            }
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final D d) {
        final int f = y.f.i.v.f;
        final C m = d.m();
        while (m.f()) {
            ((ao)m.d()).n = true;
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private boolean a(final d d, final boolean b) {
        final int f = y.f.i.v.f;
        final ae ae = (ae)this.E.b(d);
        if (ae.a(b) && !this.g.k(d).isEmpty()) {
            return false;
        }
        if (ae.b(b)) {
            return true;
        }
        final Collection c = ae.c(b);
        boolean b2 = false;
        if (c != null && !c.isEmpty()) {
            final Iterator<ax> iterator = c.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().b()) {
                    b2 = true;
                    if (f == 0) {
                        return b2;
                    }
                    break;
                }
            }
        }
        return b2;
    }
    
    void j() {
        final int f = y.f.i.v.f;
        final aK ak = new aK();
        ak.n = this.c();
        ak.i = this.b();
        ak.h = this.h;
        ak.a = this.aQ;
        ak.b = this.ag;
        ak.c = this.i;
        ak.d = this.n;
        ak.e = this.o;
        ak.f = this.p;
        ak.g = this.q;
        final w w = new w(this);
        final y.f.i.x x = new y.f.i.x(this);
        final c c = this.g.c(y.f.aF.a);
        final c c2 = this.g.c(y.f.aF.b);
        this.g.a(y.f.aF.a, w);
        this.g.a(y.f.aF.b, x);
        final I i = new I(this.g);
        final e p = this.g.p();
        while (p.f()) {
            if (this.ax.d(p.a())) {
                i.a(p.a());
            }
            p.g();
            if (f != 0) {
                y.c.i.g = !y.c.i.g;
                break;
            }
        }
        final g g = new g(ak);
        final h b = y.g.M.b(new boolean[this.g.g()]);
        this.a(b);
        this.g.a(y.f.i.g.a, y.g.q.a(b));
        g.c(this.g);
        this.g.d_(y.f.i.g.a);
        i.f();
        this.g.d_(y.f.aF.a);
        this.g.d_(y.f.aF.b);
        if (c != null) {
            this.g.a(y.f.aF.a, c);
        }
        if (c2 != null) {
            this.g.a(y.f.aF.b, c2);
        }
    }
    
    public boolean a(final String s, final Object o) {
        final int f = y.f.i.v.f;
        boolean b = false;
        if ("CD".equals(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.ah = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("SD".equals(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.ai = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("AMD".equals(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.aa = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("Stats".equals(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.G = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("swStats".equals(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.H = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("addS".equals(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.aQ = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("smallSPR".equals(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.aS = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("lessSPR".equals(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.aT = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("TT".equals(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.ag = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("routingPreferMiddleOfNode".equals(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.am = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("AllowRigModification".equalsIgnoreCase(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.av = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("IgnoreUnselectedEdges".equalsIgnoreCase(s)) {
            if (!(o instanceof Boolean)) {
                return b;
            }
            this.aw = (boolean)o;
            b = true;
            if (f == 0) {
                return b;
            }
        }
        if ("ObserveOccupiedPorts".equalsIgnoreCase(s) && o instanceof Boolean) {
            this.au = (boolean)o;
            b = true;
        }
        return b;
    }
    
    private void c(final double n) {
        final int f = y.f.i.v.f;
        final x o = this.g.o();
        while (o.f()) {
            final q e = o.e();
            if (!this.b(e)) {
                final ap ap = new ap(this.g.l(e), this.C);
                final aJ aj = (aJ)this.z.b(e);
                final ao b = this.b(aj.a);
                if (b != null) {
                    this.a(e, b, ap, n);
                }
                final ao b2 = this.b(aj.c);
                if (b2 != null) {
                    this.a(e, b2, ap, n);
                }
                final ao b3 = this.b(aj.e);
                if (b3 != null) {
                    this.a(e, b3, ap, n);
                }
                final ao b4 = this.b(aj.g);
                if (b4 != null) {
                    this.a(e, b4, ap, n);
                }
            }
            o.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final q q, final ao ao, final ap ap, final double n) {
        final int f = y.f.i.v.f;
        final q q2 = (q)this.B.b(ao);
        ap.a(q2);
        final f f2 = new f(q2.j());
        f2.sort(ap);
        Label_1798: {
            if (ao.x()) {
                final boolean b = ao.s() < this.g.l(q).b;
                double n2 = 0.0;
                Label_0122: {
                    if (b) {
                        n2 = this.g.n(q) - n;
                        if (f == 0) {
                            break Label_0122;
                        }
                    }
                    n2 = this.g.n(q) + this.g.q(q) + n;
                }
                int n3 = 0;
                final e a = f2.a();
                while (a.f() && n3 == 0) {
                    final d a2 = a.a();
                    final ao ao2 = (ao)this.C.b(a2.a(q2));
                    Label_1775: {
                        if (ao2 != null) {
                            boolean b2 = false;
                            Label_0231: {
                                if (b) {
                                    b2 = (ao2.u() <= n2);
                                    if (f == 0) {
                                        break Label_0231;
                                    }
                                }
                                b2 = (ao2.t() >= n2);
                            }
                            if (b2) {
                                break;
                            }
                            boolean b3 = false;
                            Label_0285: {
                                if (b) {
                                    b3 = (ao2.t() >= n2);
                                    if (f == 0) {
                                        break Label_0285;
                                    }
                                }
                                b3 = (ao2.u() <= n2);
                            }
                            final double[] array = new double[4];
                            final double[] array2 = new double[4];
                            array[0] = ao2.k.a;
                            array[1] = this.g.m(q);
                            array[2] = this.g.m(q) + this.g.p(q);
                            array[3] = ao2.l.a;
                            array2[0] = ao2.k.b;
                            array2[1] = ao2.k.b;
                            array2[2] = ao2.l.b;
                            array2[3] = ao2.l.b;
                            if (b3) {
                                boolean b4 = false;
                                boolean b5 = false;
                                if (ao2.k.a < this.g.m(q) && ao2.l.a > this.g.m(q)) {
                                    b4 = true;
                                }
                                if (ao2.l.a > this.g.m(q) + this.g.p(q) && ao2.k.a < this.g.m(q) + this.g.p(q)) {
                                    b5 = true;
                                }
                                if (this.aT) {
                                    if (b4 && b5) {
                                        final y.f.i.al al = (y.f.i.al)this.a(ao2, array, array2, ao2.x());
                                        this.a(ao2, (byte)8);
                                        ao2.k = new t(this.g.m(q) + this.g.p(q), ao2.k.b);
                                        if (f == 0) {
                                            break Label_1775;
                                        }
                                    }
                                    if (b4) {
                                        ao2.l = new t(this.g.m(q), ao2.l.b);
                                        this.a(ao2, (byte)4);
                                        if (f == 0) {
                                            break Label_1775;
                                        }
                                    }
                                    if (b5) {
                                        ao2.k = new t(this.g.m(q) + this.g.p(q), ao2.k.b);
                                        this.a(ao2, (byte)8);
                                        if (f == 0) {
                                            break Label_1775;
                                        }
                                    }
                                    if (this.aS) {
                                        ao2.k = new t(this.g.m(q), ao2.k.b);
                                        ao2.l = new t(this.g.m(q) + this.g.p(q), ao2.k.b);
                                        if (f == 0) {
                                            break Label_1775;
                                        }
                                    }
                                    ao2.l = new t(ao2.l.a, ao2.k.b);
                                    if (f == 0) {
                                        break Label_1775;
                                    }
                                }
                                if (b4) {
                                    final y.f.i.al al2 = new y.f.i.al(ao2.k.a, ao2.k.b, this.g.m(q), ao2.l.b, ao2.x());
                                    Label_0891: {
                                        if (!b5) {
                                            this.c(ao2, al2);
                                            if (f == 0) {
                                                break Label_0891;
                                            }
                                        }
                                        this.b(ao2, al2, (byte)8);
                                    }
                                    this.a(ao2, al2, ao2.x(), true);
                                    this.a(ao2, al2);
                                }
                                if (b5) {
                                    final y.f.i.al al3 = new y.f.i.al(this.g.m(q) + this.g.p(q), ao2.k.b, ao2.l.a, ao2.l.b, ao2.x());
                                    Label_1000: {
                                        if (!b4) {
                                            this.c(ao2, al3);
                                            if (f == 0) {
                                                break Label_1000;
                                            }
                                        }
                                        this.b(ao2, al3, (byte)4);
                                    }
                                    this.a(ao2, al3, ao2.x(), false);
                                    this.a(ao2, al3);
                                }
                                if (this.aS) {
                                    ao2.k = new t(this.g.m(q), ao2.k.b);
                                    ao2.l = new t(this.g.m(q) + this.g.p(q), ao2.k.b);
                                    if (f == 0) {
                                        break Label_1775;
                                    }
                                }
                                ao2.l = new t(ao2.l.a, ao2.k.b);
                                if (f == 0) {
                                    break Label_1775;
                                }
                            }
                            double b6 = 0.0;
                            double b7 = 0.0;
                            Label_1234: {
                                if (this.aT) {
                                    if (b) {
                                        array2[1] = n2;
                                        array2[2] = ao2.l.b;
                                        if (f == 0) {
                                            break Label_1234;
                                        }
                                    }
                                    array2[1] = ao2.k.b;
                                    array2[2] = n2;
                                    if (f == 0) {
                                        break Label_1234;
                                    }
                                }
                                if (b) {
                                    b6 = n2;
                                    b7 = ao2.l.b;
                                    if (f == 0) {
                                        break Label_1234;
                                    }
                                }
                                b6 = ao2.k.b;
                                b7 = n2;
                            }
                            boolean b8 = false;
                            boolean b9 = false;
                            if (ao2.k.a < this.g.m(q) && ao2.l.a > this.g.m(q)) {
                                b8 = true;
                            }
                            if (ao2.l.a > this.g.m(q) + this.g.p(q) && ao2.k.a < this.g.m(q) + this.g.p(q)) {
                                b9 = true;
                            }
                            Label_1652: {
                                if (this.aT) {
                                    if (b8 && b9) {
                                        final y.f.i.al al4 = (y.f.i.al)this.a(ao2, array, array2, ao2.x());
                                        final y.f.i.al al5 = (y.f.i.al)this.b(ao2, array, array2, ao2.x());
                                        if (f == 0) {
                                            break Label_1652;
                                        }
                                    }
                                    if (b8) {
                                        final y.f.i.al al6 = (y.f.i.al)this.a(ao2, array, array2, ao2.x());
                                        if (f == 0) {
                                            break Label_1652;
                                        }
                                    }
                                    if (!b9) {
                                        break Label_1652;
                                    }
                                    final y.f.i.al al7 = (y.f.i.al)this.b(ao2, array, array2, ao2.x());
                                    if (f == 0) {
                                        break Label_1652;
                                    }
                                }
                                if (b8) {
                                    final y.f.i.al al8 = new y.f.i.al(ao2.k.a, b6, this.g.m(q), b7, ao2.x());
                                    Label_1533: {
                                        if (!b9) {
                                            this.c(ao2, al8);
                                            if (f == 0) {
                                                break Label_1533;
                                            }
                                        }
                                        this.b(ao2, al8, (byte)8);
                                    }
                                    this.a(ao2, al8, ao2.x(), true);
                                    this.a(ao2, al8);
                                }
                                if (b9) {
                                    final y.f.i.al al9 = new y.f.i.al(this.g.m(q) + this.g.p(q), b6, ao2.l.a, b7, ao2.x());
                                    Label_1630: {
                                        if (!b8) {
                                            this.c(ao2, al9);
                                            if (f == 0) {
                                                break Label_1630;
                                            }
                                        }
                                        this.b(ao2, al9, (byte)4);
                                    }
                                    this.a(ao2, al9, ao2.x(), false);
                                    this.a(ao2, al9);
                                }
                            }
                            Label_1772: {
                                if (this.aT) {
                                    if (b) {
                                        ao2.l = new t(ao2.l.a, n2);
                                        if (f == 0) {
                                            break Label_1772;
                                        }
                                    }
                                    ao2.k = new t(ao2.k.a, n2);
                                    if (f == 0) {
                                        break Label_1772;
                                    }
                                }
                                if (b) {
                                    ao2.l = new t(ao2.l.a, b6);
                                    if (f == 0) {
                                        break Label_1772;
                                    }
                                }
                                ao2.k = new t(ao2.k.a, b7);
                            }
                            n3 = 1;
                        }
                    }
                    this.a(a2.a(q2));
                    a.g();
                    if (f != 0) {
                        break Label_1798;
                    }
                }
                return;
            }
        }
        final boolean b10 = ao.r() < this.g.l(q).a;
        double n4 = 0.0;
        Label_1869: {
            if (b10) {
                n4 = this.g.m(q) - n;
                if (f == 0) {
                    break Label_1869;
                }
            }
            n4 = this.g.m(q) + this.g.p(q) + n;
        }
        int n5 = 0;
        final e a3 = f2.a();
        while (a3.f() && n5 == 0) {
            final d a4 = a3.a();
            final ao ao3 = (ao)this.C.b(a4.a(q2));
            Label_3518: {
                if (ao3 != null) {
                    boolean b11 = false;
                    Label_1978: {
                        if (b10) {
                            b11 = (ao3.u() <= n4);
                            if (f == 0) {
                                break Label_1978;
                            }
                        }
                        b11 = (ao3.t() >= n4);
                    }
                    if (b11) {
                        break;
                    }
                    boolean b12 = false;
                    Label_2032: {
                        if (b10) {
                            b12 = (ao3.t() >= n4);
                            if (f == 0) {
                                break Label_2032;
                            }
                        }
                        b12 = (ao3.u() <= n4);
                    }
                    final double[] array3 = new double[4];
                    final double[] array4 = new double[4];
                    array3[0] = ao3.k.a;
                    array3[1] = ao3.k.a;
                    array3[2] = ao3.l.a;
                    array3[3] = ao3.l.a;
                    array4[0] = ao3.k.b;
                    array4[1] = this.g.n(q);
                    array4[2] = this.g.n(q) + this.g.q(q);
                    array4[3] = ao3.l.b;
                    if (b12) {
                        boolean b13 = false;
                        boolean b14 = false;
                        if (ao3.k.b < this.g.n(q) && ao3.l.b > this.g.n(q)) {
                            b13 = true;
                        }
                        if (ao3.l.b > this.g.n(q) + this.g.q(q) && ao3.k.b < this.g.n(q) + this.g.q(q)) {
                            b14 = true;
                        }
                        if (this.aT) {
                            if (b13 && b14) {
                                final y.f.i.al al10 = (y.f.i.al)this.a(ao3, array3, array4, ao3.x());
                                this.a(ao3, (byte)1);
                                ao3.k = new t(ao3.k.a, this.g.n(q) + this.g.q(q));
                                if (f == 0) {
                                    break Label_3518;
                                }
                            }
                            if (b13) {
                                ao3.l = new t(ao3.l.a, this.g.n(q));
                                this.a(ao3, (byte)2);
                                if (f == 0) {
                                    break Label_3518;
                                }
                            }
                            if (b14) {
                                ao3.k = new t(ao3.k.a, this.g.n(q) + this.g.q(q));
                                this.a(ao3, (byte)1);
                                if (f == 0) {
                                    break Label_3518;
                                }
                            }
                            if (this.aS) {
                                ao3.k = new t(ao3.k.a, this.g.n(q));
                                ao3.l = new t(ao3.k.a, this.g.n(q) + this.g.q(q));
                                if (f == 0) {
                                    break Label_3518;
                                }
                            }
                            ao3.l = new t(ao3.k.a, ao3.l.b);
                            if (f == 0) {
                                break Label_3518;
                            }
                        }
                        if (b13) {
                            final y.f.i.al al11 = new y.f.i.al(ao3.k.a, ao3.k.b, ao3.l.a, this.g.n(q), ao3.x());
                            Label_2635: {
                                if (!b14) {
                                    this.c(ao3, al11);
                                    if (f == 0) {
                                        break Label_2635;
                                    }
                                }
                                this.b(ao3, al11, (byte)1);
                            }
                            this.a(ao3, al11, ao3.x(), true);
                            this.a(ao3, al11);
                        }
                        if (b14) {
                            final y.f.i.al al12 = new y.f.i.al(ao3.k.a, this.g.n(q) + this.g.q(q), ao3.l.a, ao3.l.b, ao3.x());
                            Label_2744: {
                                if (!b13) {
                                    this.c(ao3, al12);
                                    if (f == 0) {
                                        break Label_2744;
                                    }
                                }
                                this.b(ao3, al12, (byte)2);
                            }
                            this.a(ao3, al12, ao3.x(), false);
                            this.a(ao3, al12);
                        }
                        if (this.aS) {
                            ao3.k = new t(ao3.k.a, this.g.n(q));
                            ao3.l = new t(ao3.k.a, this.g.n(q) + this.g.q(q));
                            if (f == 0) {
                                break Label_3518;
                            }
                        }
                        ao3.l = new t(ao3.k.a, ao3.l.b);
                        if (f == 0) {
                            break Label_3518;
                        }
                    }
                    double a5 = 0.0;
                    double a6 = 0.0;
                    Label_2978: {
                        if (this.aT) {
                            if (b10) {
                                array3[1] = n4;
                                array3[2] = ao3.l.a;
                                if (f == 0) {
                                    break Label_2978;
                                }
                            }
                            array3[1] = ao3.k.a;
                            array3[2] = n4;
                            if (f == 0) {
                                break Label_2978;
                            }
                        }
                        if (b10) {
                            a5 = n4;
                            a6 = ao3.l.a;
                            if (f == 0) {
                                break Label_2978;
                            }
                        }
                        a5 = ao3.k.a;
                        a6 = n4;
                    }
                    boolean b15 = false;
                    boolean b16 = false;
                    if (ao3.k.b < this.g.n(q) && ao3.l.b > this.g.n(q)) {
                        b15 = true;
                    }
                    if (ao3.l.b > this.g.n(q) + this.g.q(q) && ao3.k.b < this.g.n(q) + this.g.q(q)) {
                        b16 = true;
                    }
                    Label_3395: {
                        if (this.aT) {
                            if (b15 && b16) {
                                final y.f.i.al al13 = (y.f.i.al)this.a(ao3, array3, array4, ao3.x());
                                final y.f.i.al al14 = (y.f.i.al)this.b(ao3, array3, array4, ao3.x());
                                if (f == 0) {
                                    break Label_3395;
                                }
                            }
                            if (b15) {
                                final y.f.i.al al15 = (y.f.i.al)this.a(ao3, array3, array4, ao3.x());
                                if (f == 0) {
                                    break Label_3395;
                                }
                            }
                            if (!b16) {
                                break Label_3395;
                            }
                            final y.f.i.al al16 = (y.f.i.al)this.b(ao3, array3, array4, ao3.x());
                            if (f == 0) {
                                break Label_3395;
                            }
                        }
                        if (b15) {
                            final y.f.i.al al17 = new y.f.i.al(a5, ao3.k.b, a6, this.g.n(q), ao3.x());
                            Label_3276: {
                                if (!b16) {
                                    this.c(ao3, al17);
                                    if (f == 0) {
                                        break Label_3276;
                                    }
                                }
                                this.b(ao3, al17, (byte)1);
                            }
                            this.a(ao3, al17, ao3.x(), true);
                            this.a(ao3, al17);
                        }
                        if (b16) {
                            final y.f.i.al al18 = new y.f.i.al(a5, this.g.n(q) + this.g.q(q), a6, ao3.l.b, ao3.x());
                            Label_3373: {
                                if (!b15) {
                                    this.c(ao3, al18);
                                    if (f == 0) {
                                        break Label_3373;
                                    }
                                }
                                this.b(ao3, al18, (byte)2);
                            }
                            this.a(ao3, al18, ao3.x(), false);
                            this.a(ao3, al18);
                        }
                    }
                    Label_3515: {
                        if (this.aT) {
                            if (b10) {
                                ao3.l = new t(n4, ao3.l.b);
                                if (f == 0) {
                                    break Label_3515;
                                }
                            }
                            ao3.k = new t(n4, ao3.k.b);
                            if (f == 0) {
                                break Label_3515;
                            }
                        }
                        if (b10) {
                            ao3.l = new t(a5, ao3.l.b);
                            if (f == 0) {
                                break Label_3515;
                            }
                        }
                        ao3.k = new t(a6, ao3.k.b);
                    }
                    n5 = 1;
                }
            }
            this.a(a4.a(q2));
            a3.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final D d, final ao ao) {
        final int f = y.f.i.v.f;
        final C m = d.m();
        while (m.f()) {
            if (m.d() == ao) {
                d.b(m);
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final D d, final ao ao, final byte b) {
        final int f = y.f.i.v.f;
        final C m = d.m();
        while (m.f()) {
            final aJ aj = (aJ)this.z.b(m.d());
            Label_0225: {
                switch (b) {
                    case 1: {
                        this.a(aj.a, ao);
                        if (f != 0) {
                            break Label_0225;
                        }
                        break;
                    }
                    case 10: {
                        this.a(aj.b, ao);
                        if (f != 0) {
                            break Label_0225;
                        }
                        break;
                    }
                    case 2: {
                        this.a(aj.c, ao);
                        if (f != 0) {
                            break Label_0225;
                        }
                        break;
                    }
                    case 20: {
                        this.a(aj.d, ao);
                        if (f != 0) {
                            break Label_0225;
                        }
                        break;
                    }
                    case 8: {
                        this.a(aj.e, ao);
                        if (f != 0) {
                            break Label_0225;
                        }
                        break;
                    }
                    case 80: {
                        this.a(aj.f, ao);
                        if (f != 0) {
                            break Label_0225;
                        }
                        break;
                    }
                    case 4: {
                        this.a(aj.g, ao);
                        if (f != 0) {
                            break Label_0225;
                        }
                        break;
                    }
                    case 40: {
                        this.a(aj.h, ao);
                        break;
                    }
                }
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final ao ao, final byte b) {
        final int f = y.f.i.v.f;
        final aJ aj = (aJ)this.y.b(ao);
        if (aj == null) {
            return;
        }
        Label_0192: {
            switch (b) {
                case 1: {
                    this.a(aj.a, ao, (byte)2);
                    aj.a.clear();
                    this.a(aj.b, ao, (byte)20);
                    aj.b.clear();
                    if (f != 0) {
                        break Label_0192;
                    }
                    break;
                }
                case 2: {
                    this.a(aj.c, ao, (byte)1);
                    aj.c.clear();
                    this.a(aj.d, ao, (byte)10);
                    aj.d.clear();
                    if (f != 0) {
                        break Label_0192;
                    }
                    break;
                }
                case 8: {
                    this.a(aj.e, ao, (byte)4);
                    aj.e.clear();
                    this.a(aj.f, ao, (byte)40);
                    aj.f.clear();
                    if (f != 0) {
                        break Label_0192;
                    }
                    break;
                }
                case 4: {
                    this.a(aj.g, ao, (byte)8);
                    aj.g.clear();
                    this.a(aj.h, ao, (byte)80);
                    aj.h.clear();
                    break;
                }
            }
        }
    }
    
    private void a(final ao ao, final ao ao2) {
        final int f = y.f.i.v.f;
        final double[] array = new double[2];
        final double v = ao2.v();
        final double w = ao2.w();
        final q q = (q)this.B.b(ao);
        final q d = this.s.d();
        this.C.a(d, ao2);
        this.B.a(ao2, d);
        final e j = q.j();
        while (j.f()) {
            final d a = j.a();
            final q a2 = a.a(q);
            final ao ao3 = (ao)this.C.b(a2);
            if (ao3 != null) {
                Label_0180: {
                    if (ao.x()) {
                        array[0] = ao3.k.b;
                        array[1] = ao3.l.b;
                        if (f == 0) {
                            break Label_0180;
                        }
                    }
                    array[0] = ao3.k.a;
                    array[1] = ao3.l.a;
                }
                if (array[0] < w) {
                    if (array[1] > v) {
                        this.A.a(this.s.a(d, a2), this.A.b(a));
                    }
                }
            }
            j.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private av H() {
        final int f = y.f.i.v.f;
        this.T = new al();
        av av = null;
        Label_0107: {
            if (this.h == 0) {
                av = new av(this.g, new f());
                if (f == 0) {
                    break Label_0107;
                }
            }
            final f[] q = this.Q();
            this.t = q[0];
            final f f2 = q[1];
            if (!this.aw) {
                av = new av(this.g, f2);
                if (f == 0) {
                    break Label_0107;
                }
            }
            av = new av(this.g, new f());
        }
        this.T.b();
        final int n = this.ae ? this.af : 5;
        double n2 = this.i ? (n * this.o) : (n * 2 * this.q);
        if (!this.u()) {
            n2 += this.v();
        }
        av.a(n2);
        av.b(this.i ? 0.5 : this.q);
        av.a(true);
        av.a((byte)8);
        return av;
    }
    
    private void I() {
        final int i = y.f.i.v.f;
        final e p = this.g.p();
        while (true) {
            while (p.f()) {
                final d a = p.a();
                final ae ae = (ae)this.E.b(a);
                Collection a2 = y.f.i.ad.a(this.g, a, y.f.i.ad.b(this.g, a, true), true);
                final Collection b = y.f.i.ad.b(this.g, a, false);
                final X g = this.g;
                final Object a3;
                final d d = (d)(a3 = a);
                if (i != 0) {
                    final c c = g.c(a3);
                    if (c != null) {
                        final x o = this.g.o();
                        do {
                            Label_0189: {
                                o.f();
                            }
                            boolean a4 = false;
                            Label_0196:
                            while (a4) {
                                final q e = o.e();
                                if (c.b(e) != null) {
                                    final y.f.i.D e2 = this.e(e);
                                    final e j = e.j();
                                    while (j.f()) {
                                        final d a5 = j.a();
                                        final ae ae2 = (ae)this.E.b(a5);
                                        final boolean equals = a5.c().equals(e);
                                        a4 = a(ae2.c(equals));
                                        if (i != 0) {
                                            continue Label_0196;
                                        }
                                        if (!a4) {
                                            ae2.a(equals, (Collection)e2.a());
                                            ae2.a(true, equals);
                                        }
                                        j.g();
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                }
                                o.g();
                                continue Label_0189;
                            }
                            break;
                        } while (i == 0);
                    }
                    return;
                }
                Collection a6 = y.f.i.ad.a(g, d, b, false);
                if (a.e()) {
                    if (a2 == null) {
                        a2 = new ArrayList(1);
                    }
                    if (a6 == null) {
                        a6 = new ArrayList(1);
                    }
                    y.f.i.ad.a(this.g, a, a2, a6);
                }
                ae.a(true, a2);
                ae.a(false, a6);
                p.g();
                if (i != 0) {
                    break;
                }
            }
            final X g2 = this.g;
            Object a3 = y.f.ay.a;
            continue;
        }
    }
    
    private static boolean a(final Collection collection) {
        final int f = v.f;
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        boolean b = false;
        for (final ax ax : collection) {
            if (ax.b() || !ax.a(1) || !ax.a(2) || !ax.a(4) || !ax.a(8)) {
                b = true;
                if (f == 0) {
                    return b;
                }
                return b;
            }
        }
        return b;
    }
    
    private void J() {
        final int f = y.f.i.v.f;
        this.I();
        final h u = this.g.u();
        e e = this.t.a();
        while (true) {
            while (e.f()) {
                final d a = e.a();
                this.b(a, true);
                this.b(a, false);
                u.a(a, true);
                e.g();
                if (f != 0) {
                    while (e.f()) {
                        final d a2 = e.a();
                        if (f != 0) {
                            return;
                        }
                        if (!u.d(a2)) {
                            this.c(a2, true);
                            this.c(a2, false);
                        }
                        e.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    this.g.a(u);
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            e = this.g.p();
            continue;
        }
    }
    
    private void b(final d d, final boolean b) {
        final int f = y.f.i.v.f;
        final ae ae = (ae)this.E.b(d);
        final q q = b ? d.c() : d.d();
        final Collection c = ae.c(b);
        final D d2 = new D();
        if (c != null && !c.isEmpty()) {
            while (true) {
                for (final ax ax : c) {
                    final boolean b2 = ax.b();
                    if (f == 0) {
                        if (b2) {
                            if (ax.a(1)) {
                                final double n = this.g.j(q) + ax.c();
                                final ao a = this.a(q, n, (byte)1);
                                if (a != null) {
                                    ((y.f.i.al)a).a(d, n, (byte)2, b);
                                    d2.add(new af(a, ax));
                                }
                            }
                            if (ax.a(2)) {
                                final double n2 = this.g.j(q) + ax.c();
                                final ao a2 = this.a(q, n2, (byte)2);
                                if (a2 != null) {
                                    ((y.f.i.al)a2).a(d, n2, (byte)1, b);
                                    d2.add(new af(a2, ax));
                                }
                            }
                            if (ax.a(4)) {
                                final double n3 = this.g.k(q) + ax.d();
                                final ao a3 = this.a(q, n3, (byte)4);
                                if (a3 != null) {
                                    ((y.f.i.al)a3).a(d, n3, (byte)8, b);
                                    d2.add(new af(a3, ax));
                                }
                            }
                            if (!ax.a(8)) {
                                continue;
                            }
                            final double n4 = this.g.k(q) + ax.d();
                            final ao a4 = this.a(q, n4, (byte)8);
                            if (a4 == null) {
                                continue;
                            }
                            ((y.f.i.al)a4).a(d, n4, (byte)4, b);
                            d2.add(new af(a4, ax));
                            if (f == 0) {
                                continue;
                            }
                        }
                        if (f != 0) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if (b2 && d2.isEmpty()) {
                            this.ap.add(d);
                            if (f == 0) {
                                return;
                            }
                        }
                        if (!d2.isEmpty()) {
                            ae.a(b, d2);
                        }
                        return;
                    }
                }
                continue;
            }
        }
    }
    
    private void c(final d d, final boolean b) {
        final ae ae = (ae)this.E.b(d);
        final Collection c = ae.c(b);
        if (c != null && c.size() == 1 && c.iterator().next().b()) {
            ae.b(b, true);
        }
    }
    
    private void K() {
        final int f = y.f.i.v.f;
        this.J = 0;
        this.K = 0;
        this.I = 0;
        this.W = new al(false);
        this.V = new al();
        this.J();
        final e a = new aI(this.g, this.t, this).a().a();
        while (a.f()) {
            this.a(a.a());
            a.g();
            if (f != 0) {
                return;
            }
            if (f != 0) {
                break;
            }
        }
        this.V.b();
    }
    
    private f a(final d d, final q q, final q q2, final boolean b) {
        final int f = y.f.i.v.f;
        final f f2 = new f();
        final ae ae = (ae)this.E.b(d);
        final Collection c = ae.c(b);
        boolean b8 = false;
        Label_1807: {
            Label_1803: {
                if (c == null || c.isEmpty()) {
                    if (this.ar == 2) {
                        final aJ aj = (aJ)this.z.b(q);
                        this.a(aj.e, q2, f2, null);
                        this.a(aj.g, q2, f2, null);
                        if (f == 0) {
                            break Label_1803;
                        }
                    }
                    if (this.ar == 1) {
                        final aJ aj2 = (aJ)this.z.b(q);
                        this.a(aj2.a, q2, f2, null);
                        this.a(aj2.c, q2, f2, null);
                        if (f == 0) {
                            break Label_1803;
                        }
                    }
                    this.a(q, q2, f2);
                    if (f == 0) {
                        break Label_1803;
                    }
                }
                byte ar = 0;
                Label_0689: {
                    if (this.ar == 1 || this.ar == 3) {
                        final boolean b2 = (b && this.g.n(d.d()) + this.g.q(d.d()) < this.g.n(d.c())) || (!b && this.g.n(d.c()) + this.g.q(d.c()) < this.g.n(d.d()));
                        final boolean b3 = (!b && this.g.n(d.d()) + this.g.q(d.d()) < this.g.n(d.c())) || (b && this.g.n(d.c()) + this.g.q(d.c()) < this.g.n(d.d()));
                        if (b2 || b3) {
                            final D e = ae.e(b);
                            if (e != null) {
                                final C m = e.m();
                                while (m.f()) {
                                    final af af = (af)m.d();
                                    final boolean b4 = (ar = (byte)(b2 ? 1 : 0)) != 0;
                                    if (f != 0) {
                                        break Label_0689;
                                    }
                                    if (((b4 && af.b.a(1)) || (b3 && af.b.a(2))) && this.a(q, af)) {
                                        final d a = this.s.a(q2, (q)this.B.b(af.a));
                                        this.aq.put(a, af.b);
                                        f2.add(a);
                                    }
                                    m.g();
                                    if (f != 0) {
                                        break;
                                    }
                                }
                            }
                            final aJ aj3 = (aJ)this.z.b(q);
                            for (final ax ax : c) {
                                if (!ax.b()) {
                                    final boolean b5 = (ar = (byte)(b2 ? 1 : 0)) != 0;
                                    if (f != 0) {
                                        break Label_0689;
                                    }
                                    if (b5 && ax.a(1) && this.a(q, 1)) {
                                        this.a(aj3.a, q2, f2, ax);
                                        if (f == 0) {
                                            continue;
                                        }
                                    }
                                    if (!b3 || !ax.a(2) || !this.a(q, 2)) {
                                        continue;
                                    }
                                    this.a(aj3.c, q2, f2, ax);
                                    if (f != 0) {
                                        break;
                                    }
                                    continue;
                                }
                            }
                        }
                    }
                    ar = this.ar;
                }
                if (ar == 2 || this.ar == 3) {
                    final boolean b6 = (b && this.g.m(d.d()) + this.g.p(d.d()) < this.g.m(d.c())) || (!b && this.g.m(d.c()) + this.g.p(d.c()) < this.g.m(d.d()));
                    final boolean b7 = (!b && this.g.m(d.d()) + this.g.p(d.d()) < this.g.m(d.c())) || (b && this.g.m(d.c()) + this.g.p(d.c()) < this.g.m(d.d()));
                    if (b6 || b7) {
                        final D e2 = ae.e(b);
                        if (e2 != null) {
                            final C i = e2.m();
                            while (i.f()) {
                                final af af2 = (af)i.d();
                                b8 = b6;
                                if (f != 0) {
                                    break Label_1807;
                                }
                                if (((b8 && af2.b.a(8)) || (b7 && af2.b.a(4))) && this.a(q, af2)) {
                                    final d a2 = this.s.a(q2, (q)this.B.b(af2.a));
                                    this.aq.put(a2, af2.b);
                                    f2.add(a2);
                                }
                                i.g();
                                if (f != 0) {
                                    break;
                                }
                            }
                        }
                        final aJ aj4 = (aJ)this.z.b(q);
                        for (final ax ax2 : c) {
                            if (!ax2.b()) {
                                final boolean b9 = b6;
                                if (f != 0) {
                                    break Label_1807;
                                }
                                if (b9 && ax2.a(8) && this.a(q, 8)) {
                                    this.a(aj4.e, q2, f2, ax2);
                                    if (f == 0) {
                                        continue;
                                    }
                                }
                                if (!b7 || !ax2.a(4) || !this.a(q, 4)) {
                                    continue;
                                }
                                this.a(aj4.g, q2, f2, ax2);
                                if (f != 0) {
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                }
                final D d2 = new D();
                boolean a3 = false;
                Label_1545: {
                    if (f2.isEmpty()) {
                        final D e3 = ae.e(b);
                        if (e3 != null) {
                            final C j = e3.m();
                            while (j.f()) {
                                final af af3 = (af)j.d();
                                d2.add(af3);
                                a3 = this.a(q, af3);
                                if (f != 0) {
                                    break Label_1545;
                                }
                                if (a3) {
                                    final d a4 = this.s.a(q2, (q)this.B.b(af3.a));
                                    this.aq.put(a4, af3.b);
                                    f2.add(a4);
                                }
                                j.g();
                                if (f != 0) {
                                    break;
                                }
                            }
                        }
                        final aJ aj5 = (aJ)this.z.b(q);
                        for (final ax ax3 : c) {
                            if (!ax3.b()) {
                                final boolean a5 = ax3.a(1);
                                if (f != 0) {
                                    break Label_1545;
                                }
                                if (a5 && this.a(q, 1)) {
                                    this.a(aj5.a, q2, f2, ax3);
                                }
                                if (ax3.a(2) && this.a(q, 2)) {
                                    this.a(aj5.c, q2, f2, ax3);
                                }
                                if (ax3.a(8) && this.a(q, 8)) {
                                    this.a(aj5.e, q2, f2, ax3);
                                }
                                if (!ax3.a(4) || !this.a(q, 4)) {
                                    continue;
                                }
                                this.a(aj5.g, q2, f2, ax3);
                                if (f != 0) {
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                    f2.isEmpty();
                }
                if (a3) {
                    final C k = d2.m();
                    while (k.f()) {
                        final af af4 = (af)k.d();
                        final d a6 = this.s.a(q2, (q)this.B.b(af4.a));
                        this.aq.put(a6, af4.b);
                        f2.add(a6);
                        k.g();
                        if (f != 0) {
                            break Label_1803;
                        }
                        if (f != 0) {
                            break;
                        }
                    }
                    final aJ aj6 = (aJ)this.z.b(q);
                    for (final ax ax4 : c) {
                        if (!ax4.b()) {
                            final boolean a7 = ax4.a(1);
                            if (f != 0) {
                                break Label_1807;
                            }
                            if (a7) {
                                this.a(aj6.a, q2, f2, ax4);
                            }
                            if (ax4.a(2)) {
                                this.a(aj6.c, q2, f2, ax4);
                            }
                            if (ax4.a(8)) {
                                this.a(aj6.e, q2, f2, ax4);
                            }
                            if (!ax4.a(4)) {
                                continue;
                            }
                            this.a(aj6.g, q2, f2, ax4);
                            if (f != 0) {
                                break;
                            }
                            continue;
                        }
                    }
                }
            }
            final boolean an = this.an;
        }
        if (b8 || (this.ao && this.am) || this.al) {
            this.a(f2, q, q2, d, 1.0, 0.5);
            if (f == 0) {
                return f2;
            }
        }
        this.a(f2, 1.0);
        return f2;
    }
    
    private static boolean a(final m m, final double n) {
        return Math.abs(m.c().a - m.d().a) < n;
    }
    
    private static boolean a(final m m, final boolean b) {
        if (b) {
            return m.c().b < m.d().b;
        }
        return m.c().a < m.d().a;
    }
    
    private boolean a(final q q, final int n) {
        final y.f.i.D d = (y.f.i.D)this.Z.b(q);
        return d == null || d.a(n) > d.b(n).size();
    }
    
    private boolean a(final q q, final af af) {
        final int f = y.f.i.v.f;
        final ax b = af.b;
        if (!b.b()) {
            return this.a(q, b.a());
        }
        final y.f.i.D d = (y.f.i.D)this.Z.b(q);
        if (d == null) {
            return true;
        }
        final D b2 = d.b(b.a());
        int a = d.a(b.c(), b.d());
        if (a == -1) {
            if (!this.a(q, b.a())) {
                return false;
            }
            a = 1;
        }
        int n = 0;
        final C m = b2.m();
        double n2 = 0.0;
        while (m.f()) {
            final t t = (t)m.d();
            n2 = dcmpg(y.d.t.a(t.a, t.b, b.c(), b.d()), 2.0);
            if (f != 0) {
                return n2 != 0.0;
            }
            if (n2 < 0 && ++n >= a) {
                return false;
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
        return n2 != 0.0;
    }
    
    private y.f.i.D e(final q q) {
        if (this.Z.b(q) == null) {
            final c c = this.g.c(y.f.ay.a);
            y.f.i.D d = null;
            Label_0070: {
                if (c != null && c.b(q) != null) {
                    d = new y.f.i.D((ay)c.b(q));
                    if (y.f.i.v.f == 0) {
                        break Label_0070;
                    }
                }
                d = new y.f.i.D();
            }
            this.Z.a(q, d);
            return d;
        }
        return (y.f.i.D)this.Z.b(q);
    }
    
    private void a(final d d, final X x) {
        final int f = y.f.i.v.f;
        final y.d.v l = x.l(d);
        final y.f.i.D e = this.e(d.c());
        final m a = l.a(0);
        p p2 = null;
        Label_0125: {
            if (a(a, 0.01)) {
                if (a(a, true)) {
                    p2 = e.a(x.n(d), 2);
                    if (f == 0) {
                        break Label_0125;
                    }
                }
                p2 = e.a(x.n(d), 1);
                if (f == 0) {
                    break Label_0125;
                }
            }
            if (a(a, false)) {
                p2 = e.a(x.n(d), 4);
                if (f == 0) {
                    break Label_0125;
                }
            }
            p2 = e.a(x.n(d), 8);
        }
        this.X.a(d, p2);
        final y.f.i.D e2 = this.e(d.d());
        final m a2 = l.a(l.h() - 2);
        p p3 = null;
        Label_0256: {
            if (a(a2, 0.01)) {
                if (a(a2, true)) {
                    p3 = e2.a(x.o(d), 1);
                    if (f == 0) {
                        break Label_0256;
                    }
                }
                p3 = e2.a(x.o(d), 2);
                if (f == 0) {
                    break Label_0256;
                }
            }
            if (a(a2, false)) {
                p3 = e2.a(x.o(d), 8);
                if (f == 0) {
                    break Label_0256;
                }
            }
            p3 = e2.a(x.o(d), 4);
        }
        this.Y.a(d, p3);
    }
    
    private void b(final d d, final X x) {
        final int f = y.f.i.v.f;
        final y.d.v l = x.l(d);
        final y.f.i.D e = this.e(d.c());
        final m a = l.a(0);
        final p p2 = (p)this.X.b(d);
        Label_0120: {
            if (a(a, 0.01)) {
                if (a(a, true)) {
                    e.a(p2, 2);
                    if (f == 0) {
                        break Label_0120;
                    }
                }
                e.a(p2, 1);
                if (f == 0) {
                    break Label_0120;
                }
            }
            if (a(a, false)) {
                e.a(p2, 4);
                if (f == 0) {
                    break Label_0120;
                }
            }
            e.a(p2, 8);
        }
        this.X.a(d, null);
        final y.f.i.D e2 = this.e(d.d());
        final m a2 = l.a(l.h() - 2);
        final p p3 = (p)this.Y.b(d);
        Label_0245: {
            if (a(a2, 0.01)) {
                if (a(a2, true)) {
                    e2.a(p3, 1);
                    if (f == 0) {
                        break Label_0245;
                    }
                }
                e2.a(p3, 2);
                if (f == 0) {
                    break Label_0245;
                }
            }
            if (a(a2, false)) {
                e2.a(p3, 8);
                if (f == 0) {
                    break Label_0245;
                }
            }
            e2.a(p3, 4);
        }
        this.Y.a(d, null);
    }
    
    private D a(final d d, final q q, final q q2) {
        final int f = y.f.i.v.f;
        final q c = d.c();
        final boolean b = true;
        boolean b2 = !this.aa;
        final ae ae = (ae)this.E.b(d);
        D d2 = null;
        while (true) {
            final f a = this.a(d, c, q, b);
            final f a2 = this.a(d, d.a(c), q2, !b);
            while (true) {
                D a3 = null;
                Label_0109: {
                    if (b) {
                        a3 = this.a(q, q2, ae);
                        if (f == 0) {
                            break Label_0109;
                        }
                    }
                    this.a(q2, q, ae);
                    a3 = d2;
                }
                if (this.aa && a3 == null) {
                    Label_0195: {
                        if (this.i) {
                            this.p /= 2;
                            if (this.p >= 2) {
                                break Label_0195;
                            }
                            this.p = 2;
                            b2 = true;
                            if (f == 0) {
                                break Label_0195;
                            }
                        }
                        this.r = Math.floor(0.5 * this.r);
                        if (this.r < 2.0) {
                            this.r = 2.0;
                            b2 = true;
                        }
                    }
                    if (!b2) {
                        this.O();
                    }
                }
                this.a(q, a);
                a.clear();
                this.a(q2, a2);
                a2.clear();
                this.aq.clear();
                if (b2 || a3 != null) {
                    d2 = a3;
                    if (f == 0) {
                        break;
                    }
                    continue;
                }
                break;
            }
        }
        return d2;
    }
    
    private void a(final d w) {
        final int f = y.f.i.v.f;
        this.u = w.c();
        this.v = w.d();
        this.w = w;
        final q d = this.s.d();
        final q d2 = this.s.d();
        ((ae)this.E.b(w)).a = this.aF++;
        D d3 = this.a(w, d, d2);
        if (d3 == null && this.F() && !this.as && !this.i) {
            final byte ar = this.ar;
            Label_0282: {
                if (this.ar == 3) {
                    final boolean b = Math.abs(this.g.m(this.u) - this.g.m(this.v)) < Math.abs(this.g.n(this.u) - this.g.n(this.v));
                    this.ar = (byte)(b ? 1 : 2);
                    d3 = this.a(w, d, d2);
                    if (d3 != null) {
                        break Label_0282;
                    }
                    this.ar = (byte)(b ? 2 : 1);
                    d3 = this.a(w, d, d2);
                    if (f == 0) {
                        break Label_0282;
                    }
                }
                if (this.ar == 1 || this.ar == 2) {
                    this.ar = (byte)((this.ar == 1) ? 2 : 1);
                    d3 = this.a(w, d, d2);
                }
            }
            if (d3 == null) {
                this.ar = 0;
                d3 = this.a(w, d, d2);
            }
            this.ar = ar;
        }
        if (d3 != null) {
            ++this.J;
            try {
                this.a(w, d3, this.av);
                this.r = this.q;
                this.p = this.o;
                if (this.au) {
                    this.a(w, this.g);
                }
                return;
            }
            catch (IllegalStateException ex) {
                this.b(w);
                if (f == 0) {
                    return;
                }
            }
        }
        this.b(w);
    }
    
    private void b(final d d) {
        ++this.K;
        ++this.az;
        if (!this.ab) {
            final D d2 = new D();
            d2.add(this.g.p(d));
            d2.add(this.g.q(d));
            this.g.a(d, d2);
        }
        this.ax.a(d, true);
        this.ay.a(d, true);
    }
    
    private D a(final q q, final q q2, final ae ae) {
        final int f = y.f.i.v.f;
        D a = null;
        boolean a2 = false;
        int n = 1;
        f f2 = null;
        int n2 = 0;
        Label_0333: {
            while (!a2) {
                n2 = n;
                if (f != 0 || n2 >= 8) {
                    break Label_0333;
                }
                this.W.a();
                final f a3 = this.a(this.s, q, q2, false, this.A, ae);
                if (f2 == null) {
                    f2 = a3;
                }
                this.W.b();
                ++this.I;
                a = this.a(a3, q);
                ax ax = null;
                ax ax2 = null;
                if (!a3.isEmpty()) {
                    ax = this.aq.get(a3.b());
                    if (ax != null && ax.b() && ax.b()) {
                        this.g.a(this.w, new t(ax.c(), ax.d()));
                        ae.b(true, true);
                    }
                    ax2 = this.aq.get(a3.c());
                    if (ax2 != null && ax2.b() && ax2.b()) {
                        this.g.b(this.w, new t(ax2.c(), ax2.d()));
                        ae.b(false, true);
                    }
                }
                a2 = this.a(a, (ax != null && ax.b()) || ae.d(true), (ax2 != null && ax2.b()) || ae.d(false));
                ++n;
                if (f != 0) {
                    goto Label_0331;
                }
            }
            goto Label_0331;
        }
        if (n2 == 0) {
            return null;
        }
        return a;
    }
    
    private void L() {
        final int f = y.f.i.v.f;
        double a = Double.MAX_VALUE;
        double a2 = 0.0;
        double b = Double.MAX_VALUE;
        double b2 = 0.0;
        final x o = this.s.o();
        while (o.f()) {
            final ao ao = (ao)this.C.b(o.e());
            if (f != 0) {
                return;
            }
            if (!ao.x()) {
                if (ao.k.a < a) {
                    a = ao.k.a;
                }
                if (ao.k.b < b) {
                    b = ao.k.b;
                }
                if (ao.l.a > a2) {
                    a2 = ao.l.a;
                }
                if (ao.l.a > b2) {
                    b2 = ao.l.b;
                }
            }
            o.g();
            if (f != 0) {
                break;
            }
        }
        this.aA = a;
        this.aB = a2;
        this.aC = b;
        this.aD = b2;
    }
    
    private void M() {
        final int f = y.f.i.v.f;
        final double m = this.g.m(this.u);
        final double i = this.g.m(this.v);
        final double min = Math.min(m, i);
        q q = null;
        Label_0063: {
            if (min == m) {
                q = this.u;
                if (f == 0) {
                    break Label_0063;
                }
            }
            q = this.v;
        }
        final double n = m + this.g.p(this.u);
        final double max = Math.max(n, i + this.g.p(this.v));
        q q2 = null;
        Label_0127: {
            if (max == n) {
                q2 = this.u;
                if (f == 0) {
                    break Label_0127;
                }
            }
            q2 = this.v;
        }
        final double n2 = this.g.n(this.u);
        final double n3 = this.g.n(this.v);
        final double min2 = Math.min(n2, n3);
        q q3 = null;
        Label_0185: {
            if (min2 == n2) {
                q3 = this.u;
                if (f == 0) {
                    break Label_0185;
                }
            }
            q3 = this.v;
        }
        final double n4 = n2 + this.g.q(this.u);
        final double max2 = Math.max(n4, n3 + this.g.q(this.v));
        q q4 = null;
        Label_0251: {
            if (max2 == n4) {
                q4 = this.u;
                if (f == 0) {
                    break Label_0251;
                }
            }
            q4 = this.v;
        }
        final ap ap = new ap(new t(min, min2), this.C);
        final ap ap2 = new ap(new t(max, max2), this.C);
        final x o = this.s.o();
        while (o.f()) {
            final y.f.i.al al = (y.f.i.al)this.C.b(o.e());
            if (al != null) {
                al.a(0);
            }
            o.g();
            if (f != 0) {
                break;
            }
        }
        final ao b = this.b(((aJ)this.z.b(q)).e);
        if (b != null) {
            this.a(b, ap);
        }
        final ao b2 = this.b(((aJ)this.z.b(q3)).a);
        if (b2 != null) {
            this.a(b2, ap);
        }
        final ao b3 = this.b(((aJ)this.z.b(q2)).g);
        if (b3 != null) {
            this.a(b3, ap2);
        }
        final ao b4 = this.b(((aJ)this.z.b(q4)).c);
        if (b4 != null) {
            this.a(b4, ap2);
        }
    }
    
    private ao b(final D d) {
        final int f = y.f.i.v.f;
        double n = 0.0;
        final C m = d.m();
        ao ao = null;
        while (m.f()) {
            ao = (ao)m.d();
            if (f != 0) {
                return ao;
            }
            final double q = ao.q();
            if (q > n) {
                n = q;
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
        return ao;
    }
    
    private void a(final ao ao, final ap ap) {
        final int f = y.f.i.v.f;
        final q q = (q)this.B.b(ao);
        ap.a(q);
        final f f2 = new f(q.j());
        f2.sort(ap);
        int n = 0;
        final e a = f2.a();
        while (a.f()) {
            final y.f.i.al al = (y.f.i.al)this.C.b(a.a().a(q));
            if (al != null) {
                al.a(Math.max(n, al.k()));
                n += 2;
            }
            a.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    d[] a(final int n) {
        if (this.aN == null || this.aN.length < n) {
            if (this.aN == null) {
                this.aN = new d[Math.max(n + 20, 500)];
                if (y.f.i.v.f == 0) {
                    return this.aN;
                }
            }
            this.aN = new d[Math.max(n + 20, this.aN.length)];
        }
        return this.aN;
    }
    
    private boolean a(final ae ae, final boolean b, final boolean b2, final boolean b3) {
        final int f = y.f.i.v.f;
        final Collection c = ae.c(b);
        if (c == null || c.isEmpty()) {
            return true;
        }
        int n = true ? 1 : 0;
        for (final ax ax : c) {
            final int n2 = b ? 1 : 0;
            if (f != 0) {
                return n2 != 0;
            }
            if (b) {
                if (b2) {
                    if (b3) {
                        n = ((ax.a(1) || ax.a(4) || ax.a(8)) ? 1 : 0);
                        if (f == 0) {
                            continue;
                        }
                    }
                    n = ((ax.a(2) || ax.a(4) || ax.a(8)) ? 1 : 0);
                    if (f == 0) {
                        continue;
                    }
                }
                if (b3) {
                    n = ((ax.a(8) || ax.a(1) || ax.a(2)) ? 1 : 0);
                    if (f == 0) {
                        continue;
                    }
                }
                n = ((ax.a(4) || ax.a(1) || ax.a(2)) ? 1 : 0);
                if (f == 0) {
                    continue;
                }
            }
            if (b2) {
                if (b3) {
                    n = ((ax.a(2) || ax.a(4) || ax.a(8)) ? 1 : 0);
                    if (f == 0) {
                        continue;
                    }
                }
                n = ((ax.a(1) || ax.a(4) || ax.a(8)) ? 1 : 0);
                if (f == 0) {
                    continue;
                }
            }
            if (b3) {
                n = ((ax.a(4) || ax.a(1) || ax.a(2)) ? 1 : 0);
                if (f == 0) {
                    continue;
                }
            }
            n = ((ax.a(8) || ax.a(1) || ax.a(2)) ? 1 : 0);
            if (f != 0) {
                break;
            }
        }
        final int n2 = n;
        return n2 != 0;
    }
    
    private f a(final i i, final q q, final q q2, final boolean b, final h h, final ae ae) {
        final int j = y.f.i.v.f;
        final d a = ae.a();
        final boolean b2 = this.g.n(a.c()) > this.g.n(a.d());
        final boolean b3 = this.g.m(a.c()) > this.g.m(a.d());
        final double n = (b2 || this.a(ae, true, true, b2)) ? this.g.n(a.c()) : -1.7976931348623157E308;
        final double n2 = (!b2 || this.a(ae, true, true, b2)) ? (this.g.n(a.c()) + this.g.q(a.c())) : Double.MAX_VALUE;
        final double n3 = (!b2 || this.a(ae, false, true, b2)) ? this.g.n(a.d()) : -1.7976931348623157E308;
        final double n4 = (b2 || this.a(ae, false, true, b2)) ? (this.g.n(a.d()) + this.g.q(a.d())) : Double.MAX_VALUE;
        final double n5 = (b3 || this.a(ae, true, false, b3)) ? this.g.m(a.c()) : -1.7976931348623157E308;
        final double n6 = (!b3 || this.a(ae, true, false, b3)) ? (this.g.m(a.c()) + this.g.p(a.c())) : Double.MAX_VALUE;
        final double n7 = (!b3 || this.a(ae, false, false, b3)) ? this.g.m(a.d()) : -1.7976931348623157E308;
        final double n8 = (b3 || this.a(ae, false, false, b3)) ? (this.g.m(a.d()) + this.g.p(a.d())) : Double.MAX_VALUE;
        f f = null;
        this.aJ.a(0);
        this.aK.a(Double.POSITIVE_INFINITY);
        this.aL.a(Double.POSITIVE_INFINITY);
        this.aM.a(0.0);
        double aj = 1.0;
        double n9 = 1.0;
        if (this.ah && this.ai) {
            aj = this.aj;
            n9 = 1.0 - aj;
        }
        int k = 0;
        int n10 = 0;
        double n11 = Double.POSITIVE_INFINITY;
        if (b) {
            throw new IllegalStateException("No logic for directed graphs.");
        }
        final A a2 = y.g.M.a();
        final y.g.a.f f2 = new y.g.a.f(i.f(), a2, a2);
        final A a3 = y.g.M.a();
        final y.g.a.f f3 = new y.g.a.f(i.f(), a3, a3);
        f2.a(q, 0.0);
        this.aJ.a(q, 64);
        f3.a(q2, 0.0);
        this.aJ.a(q2, 16);
        double b4 = 0.0;
        double b5 = 0.0;
        if (this.aR) {
            this.M();
        }
        final t c = this.c(this.w);
        final double max = Math.max(Math.abs(c.a - this.aA), Math.abs(c.a - this.aB));
        final double max2 = Math.max(Math.abs(c.b - this.aC), Math.abs(c.b - this.aD));
        double n12 = 0.0;
        final f f4 = new f();
    Label_0726:
        while (true) {
        Label_3315:
            while (k == 0) {
                final boolean b6 = false;
                if (j == 0) {
                    int n13 = b6 ? 1 : 0;
                Label_0739:
                    while (true) {
                        while (!f2.c() && n13 == 0) {
                            n13 = 1;
                            b5 = f2.b();
                            if (b5 + b4 > n11) {
                                n10 = 1;
                                if (j == 0) {
                                    break;
                                }
                            }
                            final q q3 = (q)f2.a();
                            this.aJ.a(q3, 192);
                            final ao ao = (ao)this.C.b(q3);
                            double n14 = b2 ? n2 : n;
                            boolean x = false;
                            Label_0957: {
                                if (this.D() && ao != null && ao.x()) {
                                    ao ao2 = ao;
                                    q a4 = q3;
                                    while (ao2 != null) {
                                        x = ao2.x();
                                        if (j != 0) {
                                            break Label_0957;
                                        }
                                        if (!x) {
                                            break;
                                        }
                                        a4 = ((d)this.aH.b(a4)).a(a4);
                                        ao2 = ((a4 == null) ? null : ((ao)this.C.b(a4)));
                                        if (j != 0) {
                                            break;
                                        }
                                    }
                                    if (ao2 != null) {
                                        n14 = (b2 ? ao2.t() : ao2.u());
                                    }
                                }
                            }
                            double n15 = x ? n6 : n5;
                            boolean x2 = false;
                            Label_1095: {
                                if (this.E() && ao != null && !ao.x()) {
                                    ao ao3 = ao;
                                    q a5 = q3;
                                    while (ao3 != null) {
                                        x2 = ao3.x();
                                        if (j != 0) {
                                            break Label_1095;
                                        }
                                        if (x2) {
                                            break;
                                        }
                                        a5 = ((d)this.aH.b(a5)).a(a5);
                                        ao3 = ((a5 == null) ? null : ((ao)this.C.b(a5)));
                                        if (j != 0) {
                                            break;
                                        }
                                    }
                                    if (ao3 != null) {
                                        n15 = (b3 ? ao3.t() : ao3.u());
                                    }
                                }
                                final boolean ah = this.ah;
                            }
                            if (x2 && ao != null) {
                                n12 = (ao.x() ? max2 : max);
                            }
                            double f5 = 0.0;
                            if (this.ai && ao != null) {
                                f5 = this.f(q3);
                            }
                            int n16 = 1;
                            d d = q3.f();
                            int b7 = 0;
                            do {
                                if (d == null) {
                                    if (n16 == 0) {
                                        continue Label_0739;
                                    }
                                    b7 = q3.b();
                                    if (j != 0) {
                                        break;
                                    }
                                    if (b7 <= 0) {
                                        continue Label_0739;
                                    }
                                    n16 = 0;
                                    d = q3.g();
                                }
                                final q a6 = d.a(q3);
                                final int a7 = this.aJ.a(a6);
                                final ao ao4 = (ao)this.C.b(a6);
                                boolean b8 = !this.F() || ao4 == null;
                                if (!b8 && this.D()) {
                                    b8 = ((ao4.x() && !this.E()) || (!ao4.x() && ((!b2 && ao4.t() >= n14 && ao4.u() <= n4) || (b2 && ao4.u() <= n14 && ao4.t() >= n3))));
                                }
                                if (!b8 && this.E()) {
                                    b8 = ((!ao4.x() && !this.D()) || (ao4.x() && ((!b3 && ao4.t() >= n15 && ao4.u() <= n8) || (b3 && ao4.u() <= n15 && ao4.t() >= n7))));
                                }
                                if (a7 != 192 && b8) {
                                    final double n17 = b5 + h.c(d);
                                    double c2 = this.aM.c(d);
                                    if (this.ah && ao != null && ao4 != null) {
                                        final boolean x3 = ao.x();
                                        c2 = aj * (Math.abs((x3 ? c.b : c.a) - (x3 ? ao4.s() : ao4.r())) / (2.0 * n12 + 1.0));
                                    }
                                    if (this.ai && ao != null && ao4 != null) {
                                        c2 += n9 * ((f5 - (ao.x() ? (ao4.l.b - ao4.k.b) : (ao4.l.a - ao4.k.a))) / (2.0 * f5 + 1.0));
                                    }
                                    if (this.aR) {
                                        final y.f.i.al al = (y.f.i.al)this.C.b(a6);
                                        if (al != null) {
                                            c2 += al.k();
                                        }
                                    }
                                    final double n18 = n17 + c2;
                                    this.aM.a(d, c2);
                                    Label_1912: {
                                        switch (a7) {
                                            case 0: {
                                                if (this.m()) {
                                                    this.a(a6, q3, this.e, q, q2, h);
                                                }
                                                f2.a(a6, n18);
                                                this.aK.a(a6, n18);
                                                this.aJ.a(a6, 64);
                                                this.aH.a(a6, d);
                                                if (j != 0) {
                                                    break Label_1912;
                                                }
                                                break;
                                            }
                                            case 64: {
                                                if (n18 >= f2.a(a6)) {
                                                    break;
                                                }
                                                f2.b(a6, n18);
                                                this.aK.a(a6, n18);
                                                this.aH.a(a6, d);
                                                if (j != 0) {
                                                    break Label_1912;
                                                }
                                                break;
                                            }
                                            case 192: {
                                                if (j != 0) {
                                                    break Label_1912;
                                                }
                                                break;
                                            }
                                            case 16:
                                            case 144: {
                                                if (!this.a(q3, ao, a6, ao4, true, b2, b3)) {
                                                    break;
                                                }
                                                this.aH.a(a6, d);
                                                final double n19 = n18 + this.aL.c(a6);
                                                if (n19 < n11) {
                                                    f = this.a(q, a6, q2);
                                                    n11 = n19;
                                                    break;
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                                d = ((n16 != 0) ? d.g() : d.h());
                            } while (j == 0);
                            int n20 = b7;
                        Label_3287:
                            while (true) {
                                while (!f3.c() && n20 == 0) {
                                    n20 = 1;
                                    b4 = f3.b();
                                    if (b4 + b5 > n11) {
                                        n10 = 1;
                                        if (j == 0) {
                                            break;
                                        }
                                    }
                                    final q q4 = (q)f3.a();
                                    this.aJ.a(q4, 144);
                                    final ao ao5 = (ao)this.C.b(q4);
                                    double n21 = b2 ? n3 : n4;
                                    boolean x4 = false;
                                    Label_2232: {
                                        if (this.D() && ao5 != null && ao5.x()) {
                                            ao ao6 = ao5;
                                            q a8 = q4;
                                            while (ao6 != null) {
                                                x4 = ao6.x();
                                                if (j != 0) {
                                                    break Label_2232;
                                                }
                                                if (!x4) {
                                                    break;
                                                }
                                                a8 = ((d)this.aI.b(a8)).a(a8);
                                                ao6 = ((a8 == null) ? null : ((ao)this.C.b(a8)));
                                                if (j != 0) {
                                                    break;
                                                }
                                            }
                                            if (ao6 != null) {
                                                n21 = (b2 ? ao6.u() : ao6.t());
                                            }
                                        }
                                    }
                                    double n22 = x4 ? n7 : n8;
                                    boolean x5 = false;
                                    Label_2370: {
                                        if (this.E() && ao5 != null && !ao5.x()) {
                                            ao ao7 = ao5;
                                            q a9 = q4;
                                            while (ao7 != null) {
                                                x5 = ao7.x();
                                                if (j != 0) {
                                                    break Label_2370;
                                                }
                                                if (x5) {
                                                    break;
                                                }
                                                a9 = ((d)this.aI.b(a9)).a(a9);
                                                ao7 = ((a9 == null) ? null : ((ao)this.C.b(a9)));
                                                if (j != 0) {
                                                    break;
                                                }
                                            }
                                            if (ao7 != null) {
                                                n22 = (b3 ? ao7.u() : ao7.t());
                                            }
                                        }
                                        final boolean ah2 = this.ah;
                                    }
                                    if (x5 && ao5 != null) {
                                        n12 = (ao5.x() ? max2 : max);
                                    }
                                    double f6 = 0.0;
                                    if (this.ai && ao5 != null) {
                                        f6 = this.f(q4);
                                    }
                                    int n23 = 1;
                                    d d2 = q4.f();
                                    do {
                                        if (d2 == null) {
                                            if (n23 == 0) {
                                                continue Label_3287;
                                            }
                                            final int b9 = q4.b();
                                            if (j != 0) {
                                                break Label_3287;
                                            }
                                            if (b9 <= 0) {
                                                continue Label_3287;
                                            }
                                            n23 = 0;
                                            d2 = q4.g();
                                        }
                                        final q a10 = d2.a(q4);
                                        final int a11 = this.aJ.a(a10);
                                        final ao ao8 = (ao)this.C.b(a10);
                                        boolean b10 = !this.F() || ao8 == null;
                                        if (!b10 && this.D()) {
                                            b10 = ((ao8.x() && !this.E()) || (!ao8.x() && ((!b2 && ao8.u() <= n21 && ao8.t() >= n) || (b2 && ao8.t() >= n21 && ao8.u() <= n2))));
                                        }
                                        if (!b10 && this.E()) {
                                            b10 = ((!ao8.x() && !this.D()) || (ao8.x() && ((!b3 && ao8.u() <= n22 && ao8.t() >= n5) || (b3 && ao8.t() >= n22 && ao8.u() <= n6))));
                                        }
                                        if (a11 != 144 && b10) {
                                            final double n24 = b4 + h.c(d2);
                                            double c3 = this.aM.c(d2);
                                            if (this.ah && ao5 != null && ao8 != null) {
                                                final boolean x6 = ao5.x();
                                                c3 = aj * (Math.abs((x6 ? c.b : c.a) - (x6 ? ao8.s() : ao8.r())) / (2.0 * n12 + 1.0));
                                            }
                                            if (this.ai && ao5 != null && ao8 != null) {
                                                c3 += n9 * ((f6 - (ao5.x() ? (ao8.l.b - ao8.k.b) : (ao8.l.a - ao8.k.a))) / (2.0 * f6 + 1.0));
                                            }
                                            if (this.aR) {
                                                final y.f.i.al al2 = (y.f.i.al)this.C.b(a10);
                                                if (al2 != null) {
                                                    c3 += al2.k();
                                                }
                                            }
                                            final double n25 = n24 + c3;
                                            this.aM.a(d2, c3);
                                            Label_3184: {
                                                switch (a11) {
                                                    case 0: {
                                                        if (this.m()) {
                                                            this.a(a10, q4, this.e, q, q2, h);
                                                        }
                                                        f3.a(a10, n25);
                                                        this.aL.a(a10, n25);
                                                        this.aJ.a(a10, 16);
                                                        this.aI.a(a10, d2);
                                                        if (j != 0) {
                                                            break Label_3184;
                                                        }
                                                        break;
                                                    }
                                                    case 16: {
                                                        if (n25 >= f3.a(a10)) {
                                                            break;
                                                        }
                                                        f3.b(a10, n25);
                                                        this.aL.a(a10, n25);
                                                        this.aI.a(a10, d2);
                                                        if (j != 0) {
                                                            break Label_3184;
                                                        }
                                                        break;
                                                    }
                                                    case 144: {
                                                        if (j != 0) {
                                                            break Label_3184;
                                                        }
                                                        break;
                                                    }
                                                    case 64:
                                                    case 192: {
                                                        if (!this.a(q4, ao5, a10, ao8, false, b2, b3)) {
                                                            break;
                                                        }
                                                        this.aI.a(a10, d2);
                                                        final double n26 = n25 + this.aK.c(a10);
                                                        if (n26 < n11) {
                                                            f = this.a(q, a10, q2);
                                                            n11 = n26;
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        d2 = ((n23 != 0) ? d2.g() : d2.h());
                                    } while (j == 0);
                                    break;
                                    int b9 = 0;
                                    k = (((b9 != 0 && f3.c()) || n10 != 0) ? 1 : 0);
                                    if (j != 0) {
                                        break Label_3315;
                                    }
                                    continue Label_0726;
                                }
                                f2.c();
                                continue Label_3287;
                            }
                        }
                        continue;
                    }
                }
                if (b6) {
                    this.a(f, this.e);
                    this.a(i, this.e);
                }
                return f;
            }
            if (f == null) {
                f = new f();
            }
            this.m();
            continue;
        }
    }
    
    private boolean a(final q q, final ao ao, final q q2, final ao ao2, final boolean b, final boolean b2, final boolean b3) {
        final int f = y.f.i.v.f;
        if (!this.F() || ao2 == null || ao == null) {
            return true;
        }
        boolean x2 = false;
        Label_0362: {
            Label_0358: {
                if (this.D()) {
                    double n = Double.MAX_VALUE;
                    ao ao3 = b ? ao : ao2;
                    q q3 = b ? q : q2;
                    while (true) {
                        while (ao3 != null) {
                            final double x;
                            final boolean b4 = (x = (ao3.x() ? 1 : 0)) != 0.0;
                            if (f == 0) {
                                if (!b4) {
                                    break;
                                }
                                final d d = (d)this.aH.b(q3);
                                q3 = ((d == null) ? null : d.a(q3));
                                ao3 = ((q3 == null) ? null : ((ao)this.C.b(q3)));
                                if (f != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (x == 0) {
                                    break Label_0358;
                                }
                                ao ao4 = b ? ao2 : ao;
                                q q4 = b ? q2 : q;
                                while (ao4 != null) {
                                    x2 = ao4.x();
                                    if (f != 0) {
                                        break Label_0362;
                                    }
                                    if (!x2) {
                                        break;
                                    }
                                    final d d2 = (d)this.aI.b(q4);
                                    q4 = ((d2 == null) ? null : d2.a(q4));
                                    ao4 = ((q4 == null) ? null : ((ao)this.C.b(q4)));
                                    if (f != 0) {
                                        break;
                                    }
                                }
                                if (ao4 == null || ao4 == ao3) {
                                    break Label_0358;
                                }
                                final double n2 = b2 ? ao4.u() : ao4.t();
                                if (!(b2 ? (n2 < n) : (n2 > n))) {
                                    return false;
                                }
                                break Label_0358;
                            }
                        }
                        if (ao3 != null) {
                            n = (b2 ? ao3.t() : ao3.u());
                        }
                        double x = dcmpl(n, Double.MAX_VALUE);
                        continue;
                    }
                }
            }
            this.E();
        }
        boolean x4 = false;
        if (x2) {
            double n3 = Double.MAX_VALUE;
            ao ao5 = b ? ao : ao2;
            q q5 = b ? q : q2;
            while (true) {
                while (ao5 != null) {
                    final double x3;
                    final boolean b5 = (x3 = (ao5.x() ? 1 : 0)) != 0.0;
                    if (f == 0) {
                        if (b5) {
                            break;
                        }
                        final d d3 = (d)this.aH.b(q5);
                        q5 = ((d3 == null) ? null : d3.a(q5));
                        ao5 = ((q5 == null) ? null : ((ao)this.C.b(q5)));
                        if (f != 0) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if (x3 == 0) {
                            return x4;
                        }
                        ao ao6 = b ? ao2 : ao;
                        q q6 = b ? q2 : q;
                        while (ao6 != null) {
                            x4 = ao6.x();
                            if (f != 0) {
                                return x4;
                            }
                            if (x4) {
                                break;
                            }
                            final d d4 = (d)this.aI.b(q6);
                            q6 = ((d4 == null) ? null : d4.a(q6));
                            ao6 = ((q6 == null) ? null : ((ao)this.C.b(q6)));
                            if (f != 0) {
                                break;
                            }
                        }
                        if (ao6 == null || ao6 == ao5) {
                            return x4;
                        }
                        final double n4 = b3 ? ao6.u() : ao6.t();
                        if (!(b3 ? (n4 < n3) : (n4 > n3))) {
                            return false;
                        }
                        return x4;
                    }
                }
                if (ao5 != null) {
                    n3 = (b3 ? ao5.t() : ao5.u());
                }
                double x3 = dcmpl(n3, Double.MAX_VALUE);
                continue;
            }
        }
        return x4;
    }
    
    public void a(final double ae) {
        this.aE = ae;
    }
    
    public double k() {
        return this.aE;
    }
    
    public void c(final boolean ag) {
        this.aG = ag;
    }
    
    public boolean l() {
        return this.aG;
    }
    
    boolean m() {
        return this.aE > 0.0;
    }
    
    boolean a(final d d, final c c) {
        final Object b = c.b(d.c());
        final Object b2 = c.b(d.d());
        return b != null && b == b2;
    }
    
    void a(final i i, final A a) {
        final int j = y.f.i.v.f;
        final d[] a2 = this.a(2 * this.g.g());
        x x = i.o();
    Label_0252:
        while (true) {
            do {
                x.f();
                boolean a3 = false;
            Label_0032:
                while (a3) {
                    final q e = x.e();
                    final q q = (q)a.b(e);
                    if (j == 0) {
                        Label_0245: {
                            if (q != null && q != e) {
                                int n = 0;
                                d d = e.g();
                                while (true) {
                                    while (d != null) {
                                        a2[n++] = d;
                                        d = d.h();
                                        if (j != 0) {
                                            while (d != null) {
                                                a2[n++] = d;
                                                d = d.g();
                                                if (j != 0) {
                                                    continue Label_0252;
                                                }
                                                if (j != 0) {
                                                    break;
                                                }
                                            }
                                            int k = 0;
                                            while (k < n) {
                                                final d d2 = a2[k];
                                                a3 = this.a(d2, a);
                                                if (j != 0) {
                                                    continue Label_0032;
                                                }
                                                Label_0228: {
                                                    if (!a3) {
                                                        if (d2.c() == e) {
                                                            i.a(d2, q, d2.d());
                                                            if (j == 0) {
                                                                break Label_0228;
                                                            }
                                                        }
                                                        i.a(d2, d2.c(), q);
                                                    }
                                                }
                                                ++k;
                                                if (j != 0) {
                                                    break;
                                                }
                                            }
                                            this.d.a(e);
                                            break Label_0245;
                                        }
                                        if (j != 0) {
                                            break;
                                        }
                                    }
                                    d = e.f();
                                    continue;
                                }
                            }
                        }
                        x.g();
                        continue Label_0252;
                    }
                    while (x.f()) {
                        a.a(x.e(), null);
                        x.g();
                        if (j != 0) {
                            break;
                        }
                    }
                    return;
                }
                break;
            } while (j == 0);
            x = i.o();
            continue;
        }
    }
    
    void a(final f f, final A a) {
        final int f2 = y.f.i.v.f;
        p p2 = f.k();
        while (p2 != null) {
            final d d = (d)p2.c();
            final q q = (q)a.b(d.c());
            final q q2 = (q)a.b(d.d());
            if (q != null && q == q2) {
                f.h(p2);
            }
            p2 = p2.a();
            if (f2 != 0) {
                break;
            }
        }
    }
    
    void a(final q q, final q q2, final A a, final q q3, final q q4, final h h) {
        final int f = y.f.i.v.f;
        final ao ao = (ao)this.C.b(q);
        final ao ao2 = (ao)this.C.b(q2);
        if (ao == null || a.b(q) != null) {
            return;
        }
        final y y = new y(this, q, q3, ao);
        final d[] a2 = this.a(q.a());
        int n = 0;
        d d = q.g();
        while (true) {
        Label_0165_Outer:
            while (d != null) {
                a2[n++] = d;
                d = d.h();
                if (f != 0) {
                    while (true) {
                        while (d != null) {
                            a2[n++] = d;
                            d = d.g();
                            if (f != 0) {
                                q q5 = null;
                                int i = 0;
                                int n2 = 0;
                                this.s.g();
                                this.s.e();
                                int j = 0;
                                while (j < n) {
                                    final ao ao3 = (ao)this.C.b(a2[j].a(q));
                                    int n3 = (j == n - 1) ? 1 : 0;
                                    if (n3 == 0) {
                                        final ao ao4 = (ao)this.C.b(a2[j + 1].a(q));
                                        if (ao4 != null && ao3 != null && ao4.t() - ao3.u() > 0.01) {
                                            n3 = 1;
                                        }
                                        if (ao4 != null && ao4.n && ao.t() < ao4.p && ao.u() > ao4.o) {
                                            final q q6 = this.c.get(ao4);
                                            if (q6 != null && q6 != this.u && q6 != this.v) {
                                                n3 = 1;
                                            }
                                        }
                                    }
                                    q q7 = q2;
                                    Label_0677: {
                                        q a3 = null;
                                        Label_0633: {
                                            while (true) {
                                                q c = null;
                                                if (c == q7) {
                                                    n2 = 1;
                                                }
                                                if (n3 == 0) {
                                                    break Label_0677;
                                                }
                                                if (n2 == 0) {
                                                    a3 = this.d.a();
                                                    this.C.a(a3, ao);
                                                    a.a(a3, q);
                                                    this.aJ.a(a3, 0);
                                                    this.aK.a(a3, Double.POSITIVE_INFINITY);
                                                    this.aL.a(a3, Double.POSITIVE_INFINITY);
                                                    while (i <= j) {
                                                        final d d2 = a2[i++];
                                                        d2.d();
                                                        d2.c();
                                                        final ao ao5 = (ao)this.C.b(d2.d());
                                                        final ao ao6 = (ao)this.C.b(d2.c());
                                                        c = d2.c();
                                                        q7 = q;
                                                        if (f != 0) {
                                                            continue Label_0677;
                                                        }
                                                        if (c == q) {
                                                            this.s.a(d2, a3, d2.d());
                                                            if (f == 0) {
                                                                continue Label_0165_Outer;
                                                            }
                                                        }
                                                        this.s.a(d2, d2.c(), a3);
                                                    }
                                                    break Label_0633;
                                                }
                                                break;
                                            }
                                            a3 = q;
                                            a.a(a3, q);
                                        }
                                        i = j + 1;
                                        if (q5 != null) {
                                            h.a(this.d.a(q5, a3), this.aE);
                                        }
                                        q5 = a3;
                                        n2 = 0;
                                    }
                                    ++j;
                                    if (f != 0) {
                                        break;
                                    }
                                }
                                return;
                            }
                            if (f != 0) {
                                break;
                            }
                        }
                        y.g.e.a(a2, 0, n, y);
                        continue;
                    }
                }
                if (f != 0) {
                    break;
                }
            }
            d = q.f();
            continue;
        }
    }
    
    void n() {
        final int f = y.f.i.v.f;
        final f o = this.o();
        if (o.isEmpty()) {
            return;
        }
        final h u = this.g.u();
        Object o2 = o.a();
        while (true) {
            while (((C)o2).f()) {
                final d a = ((e)o2).a();
                u.a(a, true);
                final boolean au = this.au;
                if (f != 0) {
                    c c = null;
                    Label_0268: {
                        while (true) {
                            if (au) {
                                final d a2 = ((e)o2).a();
                                final h h = (h)(c = u);
                                if (f != 0) {
                                    break Label_0268;
                                }
                                Label_0250: {
                                    if (h.d(a2)) {
                                        e e = null;
                                        if (this.b(a2.c())) {
                                            e = a2.c().j();
                                        }
                                        else if (this.b(a2.d())) {
                                            e = a2.d().j();
                                        }
                                        if (e != null) {
                                            while (e.f()) {
                                                u.a(e.a(), true);
                                                e.g();
                                                if (f != 0) {
                                                    break Label_0250;
                                                }
                                                if (f != 0) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    ((e)o2).g();
                                }
                                if (f == 0) {
                                    ((C)o2).f();
                                    continue;
                                }
                            }
                            break;
                        }
                        o2 = this.c();
                        c = this.g.c(o2);
                    }
                    final c c2 = c;
                    final byte h2 = this.h;
                    this.h = 2;
                    this.g.a(o2, u);
                    this.h();
                    this.g();
                    this.i();
                    this.K();
                    this.h = h2;
                    this.g.d_(o2);
                    if (c2 != null) {
                        this.g.a(o2, c2);
                    }
                    this.g.a(u);
                    return;
                }
                if (au && !this.ax.d(a)) {
                    this.b(a, this.g);
                }
                ((e)o2).g();
                if (f != 0) {
                    break;
                }
            }
            o2 = this.g.p();
            continue;
        }
    }
    
    int a(final h h) {
        final int f = y.f.i.v.f;
        int n = 0;
        final c c = this.g.c(this.b());
        final c c2 = this.g.c(this.c());
        final e p = this.g.p();
        while (p.f()) {
            final int h2;
            final byte b = (byte)(h2 = this.h);
            if (f != 0) {
                return h2;
            }
            Label_0193: {
                if (b == 2) {
                    if (!c2.d(p.a())) {
                        break Label_0193;
                    }
                    h.a(p.a(), true);
                    ++n;
                    if (f == 0) {
                        break Label_0193;
                    }
                }
                if (this.h == 4) {
                    final d a = p.a();
                    if ((!c.d(a.c()) && !c.d(a.d())) || h.d(a)) {
                        break Label_0193;
                    }
                    h.a(a, true);
                    ++n;
                    if (f == 0) {
                        break Label_0193;
                    }
                }
                h.a(p.a(), true);
                ++n;
            }
            p.g();
            if (f != 0) {
                break;
            }
        }
        return n;
    }
    
    f o() {
        final int i = y.f.i.v.f;
        final int[] array = new int[this.g.g()];
        final h b = y.g.M.b(new boolean[this.g.g()]);
        int a = this.a(b);
        final d[] array2 = new d[a];
        final e p = this.g.p();
        while (p.f()) {
            if (b.d(p.a())) {
                array2[--a] = p.a();
            }
            p.g();
            if (i != 0) {
                break;
            }
        }
        final ArrayList<y.f.i.C> list = new ArrayList<y.f.i.C>(this.g.g());
        final ArrayList<y.f.i.C> list2 = new ArrayList<y.f.i.C>(this.g.g());
        int n = 0;
        do {
            double n2 = 0.0;
            Label_0136: {
                n2 = n;
            }
            Label_0138:
            while (n2 < array2.length) {
                final d d = array2[n];
                final D m = this.g.m(d);
                t t = (t)m.j();
                final t t2 = (t)m.i();
                final am h = this.g.h(d.d());
                Label_0391: {
                    if (t2.a < h.getX()) {
                        t = new t(h.getX(), t.b);
                        if (i == 0) {
                            break Label_0391;
                        }
                    }
                    if (t2.a > h.getX() + h.getWidth()) {
                        t = new t(h.getX() + h.getWidth(), t.b);
                        if (i == 0) {
                            break Label_0391;
                        }
                    }
                    if (t2.b < h.getY()) {
                        t = new t(t.a, h.getY());
                        if (i == 0) {
                            break Label_0391;
                        }
                    }
                    if (t2.b > h.getY() + h.getHeight()) {
                        t = new t(t.a, h.getY() + h.getHeight());
                    }
                }
                m.add(t);
                t t3 = (t)m.g();
                final t t4 = (t)m.f();
                final am h2 = this.g.h(d.c());
                while (true) {
                    Label_0475: {
                        if (t4.a >= h2.getX()) {
                            break Label_0475;
                        }
                        t3 = new t(h2.getX(), t3.b);
                        if (i != 0) {
                            break Label_0475;
                        }
                        while (!m.isEmpty()) {
                            final t t5 = (t)m.g();
                            final y.f.i.C c = new y.f.i.C(t3, t5, d);
                            final double n3 = n2 = dcmpg(Math.abs(t3.a - t5.a), 0.01);
                            if (i != 0) {
                                continue Label_0138;
                            }
                            Label_0712: {
                                if (n3 < 0) {
                                    list.add(c);
                                    if (i == 0) {
                                        break Label_0712;
                                    }
                                }
                                list2.add(c);
                            }
                            t3 = t5;
                            if (i != 0) {
                                break;
                            }
                        }
                        ++n;
                        continue Label_0136;
                    }
                    if (t4.a > h2.getX() + h2.getWidth()) {
                        t3 = new t(h2.getX() + h2.getWidth(), t3.b);
                        if (i == 0) {
                            continue;
                        }
                    }
                    if (t4.b < h2.getY()) {
                        t3 = new t(t3.a, h2.getY());
                        if (i == 0) {
                            continue;
                        }
                    }
                    if (t4.b > h2.getY() + h2.getHeight()) {
                        t3 = new t(t3.a, h2.getY() + h2.getHeight());
                    }
                    continue;
                }
            }
            break;
        } while (i == 0);
        final z z = new z(this);
        y.g.e.a(list2, z);
        final y.f.i.C c2 = new y.f.i.C(null, null, null);
        final y.f.i.C c3 = new y.f.i.C(null, null, null);
        int n4 = 0;
        int n5 = 0;
        while (true) {
            do {
                double n6 = 0.0;
                Label_0776: {
                    n6 = n5;
                }
                Label_0778:
                while (n6 < list.size()) {
                    final y.f.i.C c4 = list.get(n5);
                    final int a2 = ((ae)this.E.b(c4.c)).a;
                    final double a3 = c4.a.a;
                    if (i == 0) {
                        double n7 = 0.0;
                        double n8 = 0.0;
                        Label_0944: {
                            if (c4.a.b < c4.b.b) {
                                n7 = c4.a.b;
                                n8 = c4.b.b;
                                c2.a = c4.a;
                                c3.a = c4.b;
                                if (i == 0) {
                                    break Label_0944;
                                }
                            }
                            n7 = c4.b.b;
                            n8 = c4.a.b;
                            c2.a = c4.b;
                            c3.a = c4.a;
                        }
                        int binarySearch = Collections.binarySearch(list2, c2, z);
                        if (binarySearch < 0) {
                            binarySearch = -binarySearch - 1;
                        }
                        int binarySearch2 = Collections.binarySearch(list2, c3, z);
                        if (binarySearch2 < 0) {
                            binarySearch2 = -binarySearch2 - 1;
                        }
                        int j = binarySearch;
                        while (j < binarySearch2) {
                            final y.f.i.C c5 = list2.get(j);
                            final double n9 = n6 = dcmpg(c5.a.b, n7);
                            if (i != 0) {
                                continue Label_0778;
                            }
                            Label_1187: {
                                if (n9 > 0) {
                                    if (c5.a.b < n8) {
                                        double n10 = c5.a.a;
                                        double n11 = c5.b.a;
                                        if (n10 > n11) {
                                            n11 = c5.a.a;
                                            n10 = c5.b.a;
                                        }
                                        if (n10 < a3 && n11 > a3) {
                                            ++n4;
                                            final int a4 = ((ae)this.E.b(c5.c)).a;
                                            if (a2 > a4) {
                                                final int[] array3 = array;
                                                final int b2 = c5.c.b();
                                                ++array3[b2];
                                                if (i == 0) {
                                                    break Label_1187;
                                                }
                                            }
                                            if (a2 < a4) {
                                                final int[] array4 = array;
                                                final int b3 = c4.c.b();
                                                ++array4[b3];
                                            }
                                        }
                                    }
                                }
                            }
                            ++j;
                            if (i != 0) {
                                break;
                            }
                        }
                        ++n5;
                        continue Label_0776;
                    }
                    final f f = new f();
                    final double max = Math.max(0.1 * this.g.g(), 5.0);
                    int k = 0;
                    while (k < array2.length) {
                        final d d2 = array2[k];
                        if (array[d2.b()] == 0) {
                            break;
                        }
                        if (f.size() > max) {
                            break;
                        }
                        f.add(d2);
                        ++k;
                        if (i != 0) {
                            break;
                        }
                    }
                    return f;
                }
                break;
            } while (i == 0);
            y.g.e.a(array2, new y.f.i.A(this, array));
            continue;
        }
    }
    
    private double f(final q q) {
        final int f = y.f.i.v.f;
        double n = 0.0;
        final boolean x = ((ao)this.C.b(q)).x();
        d d = q.f();
        while (true) {
            while (d != null) {
                final boolean e = d.e();
                if (f != 0) {
                    while (true) {
                        if (!e) {
                            final ao ao = (ao)this.C.b(d.a(q));
                            if (ao != null) {
                                final double n2 = x ? (ao.l.b - ao.k.b) : (ao.l.a - ao.k.a);
                                if (n2 > n) {
                                    n = n2;
                                }
                            }
                        }
                        d = d.h();
                        if (f == 0) {
                            if (d != null) {
                                d.e();
                                continue;
                            }
                        }
                        break;
                    }
                    return n;
                }
                if (!e) {
                    final ao ao2 = (ao)this.C.b(d.a(q));
                    if (ao2 != null) {
                        final double n3 = x ? (ao2.l.b - ao2.k.b) : (ao2.l.a - ao2.k.a);
                        if (n3 > n) {
                            n = n3;
                        }
                    }
                }
                d = d.g();
                if (f != 0) {
                    break;
                }
            }
            d = q.g();
            continue;
        }
    }
    
    private f a(final q q, final q q2, final q q3) {
        final int f = y.f.i.v.f;
        final f f2 = new f();
        q a = q2;
        while (true) {
            while (a != q) {
                final d d = (d)this.aH.b(a);
                f2.add(d);
                a = d.a(a);
                if (f != 0) {
                    q a2 = q2;
                    f f3 = null;
                    while (a2 != q3) {
                        final d d2 = (d)this.aI.b(a2);
                        f3 = f2;
                        if (f != 0) {
                            return f3;
                        }
                        f3.add(d2);
                        a2 = d2.a(a2);
                        if (f != 0) {
                            break;
                        }
                    }
                    return f3;
                }
                if (f != 0) {
                    break;
                }
            }
            f2.n();
            continue;
        }
    }
    
    private ao a(final q q, final double n, final byte b) {
        final int f = y.f.i.v.f;
        int n2 = 0;
        final aJ aj = (aJ)this.z.b(q);
        D d = null;
        D d2 = null;
        double n3 = 0.0;
        double abs = 0.0;
        switch (b) {
            case 1: {
                d = aj.a;
                d2 = aj.b;
                n3 = this.g.n(q);
                break;
            }
            case 2: {
                d = aj.c;
                d2 = aj.d;
                n3 = this.g.n(q);
                break;
            }
            case 8: {
                d = aj.e;
                d2 = aj.f;
                n3 = this.g.m(q);
                break;
            }
            case 4: {
                d = aj.g;
                d2 = aj.h;
                n3 = this.g.m(q);
                break;
            }
        }
        final C m = d.m();
        while (true) {
            while (m.f()) {
                final int n4 = n2;
                if (f != 0) {
                    ao ao = null;
                    if (n4 == 0) {
                        final C i = d2.m();
                        while (i.f()) {
                            ao = (ao)i.d();
                            if (f != 0) {
                                break;
                            }
                            final ao ao2 = ao;
                            if (n >= ao2.t() && n <= ao2.u() && Math.abs(n3 - ao2.v()) <= abs) {
                                abs = Math.abs(n3 - ao2.v());
                            }
                            i.g();
                            if (f != 0) {
                                break;
                            }
                        }
                    }
                    return ao;
                }
                if (n4 != 0) {
                    break;
                }
                final ao ao3 = (ao)m.d();
                if (n >= ao3.t() && n <= ao3.u()) {
                    n2 = 1;
                }
                m.g();
                if (f != 0) {
                    break;
                }
            }
            abs = Double.MAX_VALUE;
            continue;
        }
    }
    
    private D a(final double n, final double n2, final boolean b) {
        final int f = y.f.i.v.f;
        D d = null;
        final double n3 = b ? this.n.a : this.n.b;
        double n4 = (int)Math.floor((n - n3) / this.p) * this.p + n3;
        if (n4 < n) {
            n4 += this.p;
        }
        double n5 = (int)Math.floor((n2 - n3) / this.p) * this.p + n3;
        if (n5 >= n2) {
            n5 -= this.p;
        }
        D d2 = null;
        if (n4 >= n && n5 < n2) {
            d = new D();
            double n6 = n4;
            while (n6 <= n5) {
                d2 = d;
                if (f != 0) {
                    break;
                }
                d2.add(new Double(n6));
                n6 += this.p;
                if (f != 0) {
                    break;
                }
            }
        }
        return d2;
    }
    
    private D a(final ao ao) {
        return this.a(ao.t(), ao.u(), ao.x());
    }
    
    private int b(final ao ao) {
        final int i = y.f.i.v.f;
        int n = 0;
        final y.f.i.al al = (y.f.i.al)ao;
        if (al.m()) {
            final D a = this.a(al);
            if (a != null) {
                final C m = al.l().m();
                do {
                    double f = 0.0;
                    Label_0044: {
                        f = (m.f() ? 1 : 0);
                    }
                    Label_0051:
                    while (f != 0) {
                        final int empty;
                        final boolean b = (empty = (a.isEmpty() ? 1 : 0)) != 0;
                        if (i != 0) {
                            return empty;
                        }
                        if (!b) {
                            final double b2 = ((y.f.i.am)m.d()).b;
                            final C j = a.m();
                            while (j.f()) {
                                final double n2 = f = dcmpg(Math.abs(b2 - (double)j.d()), 0.5);
                                if (i != 0) {
                                    continue Label_0051;
                                }
                                if (n2 <= 0) {
                                    a.b(j);
                                    ++n;
                                }
                                j.g();
                                if (i != 0) {
                                    break;
                                }
                            }
                            m.g();
                            continue Label_0044;
                        }
                        break;
                    }
                    break;
                } while (i == 0);
            }
        }
        return n;
    }
    
    private int a(final double n, final double n2) {
        int n3 = 0;
        final double floor = Math.floor(n / this.p);
        if (n - floor * this.p == 0.0) {
            ++n3;
        }
        final double floor2 = Math.floor(n2 / this.p);
        if (n2 - floor2 * this.p == 0.0) {
            --n3;
        }
        return (int)(floor2 - floor) + n3;
    }
    
    private boolean a(final D d, boolean b, boolean b2) {
        final int f = y.f.i.v.f;
        if (d.isEmpty()) {
            return false;
        }
        if (((ao)d.f()).n) {
            b = true;
        }
        if (((ao)d.i()).n) {
            b2 = true;
        }
        boolean b3 = true;
        Label_0240: {
            if (this.i) {
                int i = b ? 1 : 0;
                while (i < d.size() - (b2 ? 1 : 0)) {
                    final ao ao = (ao)d.a(i);
                    Label_0232: {
                        if (ao != null) {
                            final q q = (q)this.B.b(ao);
                            if (this.a(ao.t(), ao.u()) - this.b(ao) < 1) {
                                final e j = q.j();
                                while (true) {
                                    while (j.f()) {
                                        this.A.a(j.a(), 100.0);
                                        j.g();
                                        if (f != 0) {
                                            b3 = false;
                                            break Label_0232;
                                        }
                                        if (f != 0) {
                                            break;
                                        }
                                    }
                                    if (this.aa) {
                                        this.F.a(q, true);
                                    }
                                    continue;
                                }
                            }
                        }
                    }
                    ++i;
                    if (f != 0) {
                        break Label_0240;
                    }
                }
                return b3;
            }
        }
        final double n = 2.0 * this.r;
        int k = b ? 1 : 0;
    Label_0413_Outer:
        while (k < d.size() - (b2 ? 1 : 0)) {
            final ao ao2 = (ao)d.a(k);
            Label_0503: {
                if (ao2 != null) {
                    final q q2 = (q)this.B.b(ao2);
                    if (ao2.p() < n) {
                        Label_0418: {
                            if (ao2.p() < this.r + 1.0) {
                                final e l = q2.j();
                                while (true) {
                                    while (l.f()) {
                                        this.A.a(l.a(), 100.0);
                                        l.g();
                                        if (f == 0) {
                                            if (f != 0) {
                                                break;
                                            }
                                            continue Label_0413_Outer;
                                        }
                                        else {
                                            if (f != 0) {
                                                break Label_0418;
                                            }
                                            break Label_0503;
                                        }
                                    }
                                    if (this.aa) {
                                        this.F.a(q2, true);
                                    }
                                    b3 = false;
                                    continue;
                                }
                            }
                        }
                        if (!this.a(d, n, k)) {
                            final e m = q2.j();
                            while (true) {
                                while (m.f()) {
                                    this.A.a(m.a(), 100.0);
                                    m.g();
                                    if (f != 0) {
                                        b3 = false;
                                        break Label_0503;
                                    }
                                    if (f != 0) {
                                        break;
                                    }
                                }
                                if (this.aa) {
                                    this.F.a(q2, true);
                                }
                                continue;
                            }
                        }
                    }
                }
            }
            ++k;
            if (f != 0) {
                break;
            }
        }
        return b3;
    }
    
    private boolean a(final D d, final double n, final int n2) {
        final int f = y.f.i.v.f;
        int n3 = 0;
        int n4 = 0;
        y.f.i.al al = null;
        y.f.i.al al2 = null;
        final y.f.i.al al3 = (y.f.i.al)d.a(n2);
        Label_0116: {
            if (n2 > 0) {
                al = (y.f.i.al)d.a(n2 - 1);
            }
            else {
                if (al3.x()) {
                    n3 = ((this.g.k(this.u) < al3.s()) ? 1 : 0);
                    if (f == 0) {
                        break Label_0116;
                    }
                }
                n3 = ((this.g.j(this.u) < al3.r()) ? 1 : 0);
            }
        }
        Label_0210: {
            if (n2 < d.size() - 1) {
                al2 = (y.f.i.al)d.a(n2 + 1);
            }
            else {
                if (al3.x()) {
                    n4 = ((this.g.k(this.v) < al3.s()) ? 1 : 0);
                    if (f == 0) {
                        break Label_0210;
                    }
                }
                n4 = ((this.g.j(this.v) < al3.r()) ? 1 : 0);
            }
        }
        double n5 = 0.0;
        double n6 = 0.0;
        Label_0751: {
            if (al == null && al2 == null) {
                if (al3.x()) {
                    n5 = al3.k.b;
                    n6 = al3.l.b;
                    if (f == 0) {
                        break Label_0751;
                    }
                }
                n5 = al3.k.a;
                n6 = al3.l.a;
                if (f == 0) {
                    break Label_0751;
                }
            }
            if (al == null) {
                if (n3 != 0) {
                    n5 = (al3.x() ? al3.k.b : al3.k.a);
                    if (al2.x()) {
                        n6 = Math.max(al2.k.a, al2.l.a);
                        if (f == 0) {
                            break Label_0751;
                        }
                    }
                    n6 = Math.max(al2.k.b, al2.l.b);
                    if (f == 0) {
                        break Label_0751;
                    }
                }
                n6 = (al3.x() ? al3.l.b : al3.l.a);
                if (al2.x()) {
                    n5 = Math.min(al2.k.a, al2.l.a);
                    if (f == 0) {
                        break Label_0751;
                    }
                }
                n5 = Math.min(al2.k.b, al2.l.b);
                if (f == 0) {
                    break Label_0751;
                }
            }
            if (al2 == null) {
                if (n4 != 0) {
                    n5 = (al3.x() ? al3.k.b : al3.k.a);
                    if (al.x()) {
                        n6 = Math.max(al.k.a, al.l.a);
                        if (f == 0) {
                            break Label_0751;
                        }
                    }
                    n6 = Math.max(al.k.b, al.l.b);
                    if (f == 0) {
                        break Label_0751;
                    }
                }
                n6 = (al3.x() ? al3.l.b : al3.l.a);
                if (al.x()) {
                    n5 = Math.min(al.k.a, al.l.a);
                    if (f == 0) {
                        break Label_0751;
                    }
                }
                n5 = Math.min(al.k.b, al.l.b);
                if (f == 0) {
                    break Label_0751;
                }
            }
            if (al3.x()) {
                n5 = Math.min(al.k.b, al2.k.b);
                n6 = Math.max(al.l.b, al2.l.b);
                if (f == 0) {
                    break Label_0751;
                }
            }
            n5 = Math.min(al.k.a, al2.k.a);
            n6 = Math.max(al.l.a, al2.l.a);
        }
        final double n7 = n - al3.p();
        final double[] array = { n5, n6 };
        final D d2 = new D();
        final boolean a = this.a(al3, true, array, d2);
        double c = 0.0;
        if (a) {
            c = this.c(d2);
        }
        array[0] = n5;
        array[1] = n6;
        final D d3 = new D();
        final boolean a2 = this.a(al3, false, array, d3);
        double c2 = 0.0;
        if (a2) {
            c2 = this.c(d3);
        }
        if (c + c2 < n7) {
            al3.d(false);
            return false;
        }
        al3.d(true);
        al3.c(array[0]);
        al3.d(array[1]);
        if (c < n7 && c2 < n7) {
            Label_0998: {
                if (c < c2) {
                    al3.a(al3.t() - c);
                    al3.b(al3.u() + (n7 - c));
                    if (f == 0) {
                        break Label_0998;
                    }
                }
                al3.a(al3.t() - (n7 - c2));
                al3.b(al3.u() + c2);
            }
            al3.a(d2);
            al3.b(d3);
            if (f == 0) {
                return true;
            }
        }
        if (c < n7) {
            al3.a(al3.t() - c);
            al3.b(al3.u() + (n7 - c));
            al3.a(d2);
            al3.b(d3);
            if (f == 0) {
                return true;
            }
        }
        if (c2 < n7) {
            al3.a(al3.t() - (n7 - c2));
            al3.b(al3.u() + c2);
            al3.a(d2);
            al3.b(d3);
            if (f == 0) {
                return true;
            }
        }
        if (c < c2) {
            al3.a(al3.t() - n7);
            al3.b(al3.u());
            al3.a(d2);
            if (f == 0) {
                return true;
            }
        }
        al3.a(al3.t());
        al3.b(al3.u() + n7);
        al3.b(d3);
        return true;
    }
    
    private boolean a(final y.f.i.al al, final boolean b, final double[] array, final D d) {
        final int f = y.f.i.v.f;
        final D d2 = b ? al.b : al.c;
        double n = 0.0;
        double n2 = array[1];
        double n3 = array[0];
        final C m = d2.m();
        double n4 = 0.0;
        while (m.f()) {
            final y.f.i.al al2 = (y.f.i.al)m.d();
            final double v = al2.v();
            final double w = al2.w();
            n4 = dcmpg(w, array[0]);
            if (f != 0) {
                return n4 <= 0 && n3 >= array[1] && n >= Math.abs(n3 - n2);
            }
            if (n4 > 0) {
                if (v < array[1]) {
                    d.add(al2);
                    if (v < n2) {
                        n2 = v;
                    }
                    if (w > n3) {
                        n3 = w;
                    }
                    n += w - v;
                }
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
        final double n5 = dcmpl(n2, array[0]);
        return n4 <= 0 && n3 >= array[1] && n >= Math.abs(n3 - n2);
    }
    
    private double c(final D d) {
        final int f = y.f.i.v.f;
        if (d.isEmpty()) {
            return 0.0;
        }
        double n = Double.POSITIVE_INFINITY;
        final C m = d.m();
        double p = 0.0;
        while (m.f()) {
            final double n2 = p = ((y.f.i.al)m.d()).p();
            if (f != 0) {
                return p;
            }
            if (p < n) {
                n = n2;
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
        return p;
    }
    
    private void N() {
        final int f = y.f.i.v.f;
        this.A.a(1.0);
        Label_0202: {
            if (this.i) {
                final e p = this.s.p();
                while (p.f()) {
                    final d a = p.a();
                    final ao ao = (ao)this.C.b(a.c());
                    final ao ao2 = (ao)this.C.b(a.d());
                    final int a2 = this.a(ao.t(), ao.u());
                    final int a3 = this.a(ao2.t(), ao2.u());
                    Label_0190: {
                        if (a2 < 1) {
                            this.A.a(a, 100.0);
                            if (!this.aa) {
                                break Label_0190;
                            }
                            this.F.a(a.c(), true);
                            if (f == 0) {
                                break Label_0190;
                            }
                        }
                        if (a3 < 1) {
                            this.A.a(a, 100.0);
                            if (this.aa) {
                                this.F.a(a.d(), true);
                            }
                        }
                    }
                    p.g();
                    if (f != 0) {
                        break Label_0202;
                    }
                }
                return;
            }
        }
        final double n = this.r + 1.0;
        final e p2 = this.s.p();
        while (p2.f()) {
            final d a4 = p2.a();
            final ao ao3 = (ao)this.C.b(a4.c());
            final ao ao4 = (ao)this.C.b(a4.d());
            Label_0374: {
                if (ao3.p() < n && !ao3.n) {
                    this.A.a(a4, 100.0);
                    if (!this.aa) {
                        break Label_0374;
                    }
                    this.F.a(a4.c(), true);
                    if (f == 0) {
                        break Label_0374;
                    }
                }
                if (ao4.p() < n && !ao4.n) {
                    this.A.a(a4, 100.0);
                    if (this.aa) {
                        this.F.a(a4.d(), true);
                    }
                }
            }
            p2.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void O() {
        final int f = y.f.i.v.f;
        Label_0160: {
            if (this.i) {
                final x o = this.s.o();
                while (o.f()) {
                    final q e = o.e();
                    Label_0155: {
                        if (this.F.d(e)) {
                            final ao ao = (ao)this.C.b(e);
                            if (this.a(ao.t(), ao.u()) >= 1) {
                                final e j = e.j();
                                while (j.f()) {
                                    this.A.a(j.a(), 1.0);
                                    j.g();
                                    if (f != 0) {
                                        break Label_0155;
                                    }
                                    if (f != 0) {
                                        break;
                                    }
                                }
                                this.F.a(e, false);
                            }
                        }
                        o.g();
                    }
                    if (f != 0) {
                        break Label_0160;
                    }
                }
                return;
            }
        }
        final double n = this.r + 1.0;
        final x o2 = this.s.o();
        while (o2.f()) {
            final q e2 = o2.e();
            Label_0314: {
                if (this.F.d(e2)) {
                    final ao ao2 = (ao)this.C.b(e2);
                    if (ao2.p() >= n || !ao2.n) {
                        final e i = e2.j();
                        while (i.f()) {
                            this.A.a(i.a(), 1.0);
                            i.g();
                            if (f != 0) {
                                break Label_0314;
                            }
                            if (f != 0) {
                                break;
                            }
                        }
                        this.F.a(e2, false);
                    }
                }
                o2.g();
            }
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final f f, final q q, final q q2, final d d, final double n, final double n2) {
        final int f2 = y.f.i.v.f;
        final t l = this.g.l(q);
        final f[] array = new f[4];
        int i = 0;
        while (i < 4) {
            array[i] = new f();
            ++i;
            if (f2 != 0) {
                break;
            }
        }
        final e a = f.a();
        while (true) {
            d a2;
            ao ao;
            int x;
            d[] array2;
            int j;
            double n3;
            e a3;
            e e;
            d a4;
            ao ao2;
            e a5;
            d d2 = null;
            Object b;
            ao ao3;
            boolean x2 = false;
            double abs;
            double abs2;
            double abs3;
            double abs4;
            ao ao4 = null;
            Label_0657_Outer:Label_0768_Outer:
            while (a.f()) {
                a2 = a.a();
                ao = (ao)this.C.b(a2.a(q2));
                x = (ao.x() ? 1 : 0);
                if (f2 == 0) {
                    Label_0191: {
                        if (x != 0) {
                            if (ao.s() < l.b) {
                                array[0].add(a2);
                                if (f2 == 0) {
                                    break Label_0191;
                                }
                            }
                            array[1].add(a2);
                            if (f2 == 0) {
                                break Label_0191;
                            }
                        }
                        if (ao.r() < l.a) {
                            array[2].add(a2);
                            if (f2 == 0) {
                                break Label_0191;
                            }
                        }
                        array[3].add(a2);
                    }
                    a.g();
                    if (f2 != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    array2 = new d[x];
                    j = 0;
                    while (true) {
                        while (true) {
                            while (j < 4) {
                                n3 = Double.POSITIVE_INFINITY;
                                a3 = array[j].a();
                                if (f2 != 0) {
                                    e = a3;
                                    while (e.f()) {
                                        a4 = e.a();
                                        ao2 = (ao)this.C.b(a4.a(q2));
                                        if (f2 != 0) {
                                            return;
                                        }
                                        Label_0756: {
                                            if (ao2.n) {
                                                if (d.d() == q) {
                                                    this.A.a(a4, 0.0);
                                                    if (f2 == 0) {
                                                        break Label_0756;
                                                    }
                                                }
                                                if (d.c() == q) {
                                                    this.A.a(a4, 0.5);
                                                }
                                            }
                                        }
                                        e.g();
                                        if (f2 != 0) {
                                            break;
                                        }
                                    }
                                    this.a(f);
                                    return;
                                }
                                a5 = a3;
                            Label_0561_Outer:
                                while (true) {
                                    while (true) {
                                        while (true) {
                                            Label_0568: {
                                                Label_0551: {
                                                    if (!a5.f()) {
                                                        break Label_0551;
                                                    }
                                                    d2 = a5.a();
                                                    b = this.C.b(d2.a(q2));
                                                    ao3 = (ao)b;
                                                    x2 = ao3.x();
                                                    if (f2 != 0) {
                                                        break Label_0568;
                                                    }
                                                    Label_0539: {
                                                        if (x2) {
                                                            if (l.a >= ao3.k.a && l.a <= ao3.l.a) {
                                                                array2[j] = d2;
                                                                if (f2 == 0) {
                                                                    break Label_0551;
                                                                }
                                                            }
                                                            abs = Math.abs(l.a - ao3.k.a);
                                                            abs2 = Math.abs(l.a - ao3.l.a);
                                                            if (abs < n3) {
                                                                array2[j] = d2;
                                                                n3 = abs;
                                                            }
                                                            if (abs2 >= n3) {
                                                                break Label_0539;
                                                            }
                                                            array2[j] = d2;
                                                            n3 = abs2;
                                                            if (f2 == 0) {
                                                                break Label_0539;
                                                            }
                                                        }
                                                        if (l.b >= ao3.k.b && l.b <= ao3.l.b) {
                                                            array2[j] = d2;
                                                            if (f2 == 0) {
                                                                break Label_0551;
                                                            }
                                                        }
                                                        abs3 = Math.abs(l.b - ao3.k.b);
                                                        abs4 = Math.abs(l.b - ao3.l.b);
                                                        if (abs3 < n3) {
                                                            array2[j] = d2;
                                                            n3 = abs3;
                                                        }
                                                        if (abs4 < n3) {
                                                            array2[j] = d2;
                                                            n3 = abs4;
                                                        }
                                                    }
                                                    a5.g();
                                                    if (f2 == 0) {
                                                        continue Label_0657_Outer;
                                                    }
                                                }
                                                a5 = array[j].a();
                                                a5.f();
                                            }
                                            if (!x2) {
                                                break;
                                            }
                                            d2 = a5.a();
                                            ao4 = (ao)(b = d2);
                                            if (f2 != 0) {
                                                continue Label_0561_Outer;
                                            }
                                            break;
                                        }
                                        Label_0625: {
                                            if (ao4 == array2[j]) {
                                                this.A.a(d2, n);
                                                if (f2 == 0) {
                                                    break Label_0625;
                                                }
                                            }
                                            this.A.a(d2, n + n2);
                                        }
                                        a5.g();
                                        if (f2 != 0) {
                                            break;
                                        }
                                        continue;
                                    }
                                }
                                ++j;
                                if (f2 != 0) {
                                    break;
                                }
                            }
                            if (this.b(q)) {
                                f.a();
                                continue Label_0768_Outer;
                            }
                            break;
                        }
                        continue;
                    }
                }
            }
            continue;
        }
    }
    
    private void a(final f f, final double n) {
        final int f2 = y.f.i.v.f;
        final e a = f.a();
        while (a.f()) {
            this.A.a(a.a(), n);
            a.g();
            if (f2 != 0) {
                return;
            }
            if (f2 != 0) {
                break;
            }
        }
        this.a(f);
    }
    
    private void a(final f f) {
        final int f2 = y.f.i.v.f;
        final e a = f.a();
        while (a.f()) {
            final d a2 = a.a();
            final ax ax = this.aq.get(a2);
            if (ax != null) {
                this.A.a(a2, this.A.c(a2) + ax.f());
            }
            a.g();
            if (f2 != 0) {
                break;
            }
        }
    }
    
    private void b(final D d, final ao ao, final byte b) {
        final int f = y.f.i.v.f;
        final C m = d.m();
        while (m.f()) {
            final aJ aj = (aJ)this.z.b(m.d());
            Label_0229: {
                switch (b) {
                    case 1: {
                        aj.a.add(ao);
                        if (f != 0) {
                            break Label_0229;
                        }
                        break;
                    }
                    case 2: {
                        aj.c.add(ao);
                        if (f != 0) {
                            break Label_0229;
                        }
                        break;
                    }
                    case 8: {
                        aj.e.add(ao);
                        if (f != 0) {
                            break Label_0229;
                        }
                        break;
                    }
                    case 4: {
                        aj.g.add(ao);
                        if (f != 0) {
                            break Label_0229;
                        }
                        break;
                    }
                    case 10: {
                        aj.b.add(ao);
                        if (f != 0) {
                            break Label_0229;
                        }
                        break;
                    }
                    case 20: {
                        aj.d.add(ao);
                        if (f != 0) {
                            break Label_0229;
                        }
                        break;
                    }
                    case 80: {
                        aj.f.add(ao);
                        if (f != 0) {
                            break Label_0229;
                        }
                        break;
                    }
                    case 40: {
                        aj.h.add(ao);
                        break;
                    }
                }
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final ao ao, final ao ao2, final byte b) {
        final int f = y.f.i.v.f;
        final aJ aj = (aJ)this.y.b(ao);
        if (aj == null) {
            return;
        }
        final aJ aj2 = new aJ();
        Label_0228: {
            switch (b) {
                case 1: {
                    aj2.a = aj.a;
                    aj2.b = aj.b;
                    this.b(aj.a, ao2, (byte)2);
                    this.b(aj.b, ao2, (byte)20);
                    if (f != 0) {
                        break Label_0228;
                    }
                    break;
                }
                case 2: {
                    aj2.c = aj.c;
                    aj2.d = aj.d;
                    this.b(aj.c, ao2, (byte)1);
                    this.b(aj.d, ao2, (byte)10);
                    if (f != 0) {
                        break Label_0228;
                    }
                    break;
                }
                case 8: {
                    aj2.e = aj.e;
                    aj2.f = aj.f;
                    this.b(aj.e, ao2, (byte)4);
                    this.b(aj.f, ao2, (byte)40);
                    if (f != 0) {
                        break Label_0228;
                    }
                    break;
                }
                case 4: {
                    aj2.g = aj.g;
                    aj2.h = aj.h;
                    this.b(aj.g, ao2, (byte)8);
                    this.b(aj.h, ao2, (byte)80);
                    break;
                }
            }
        }
        ((aF)this.y).a(ao2, aj2);
    }
    
    private void b(final ao ao, final ao ao2) {
        final int f = y.f.i.v.f;
        final q q = (q)this.B.b(ao);
        final q d = this.s.d();
        this.C.a(d, ao2);
        this.B.a(ao2, d);
        final double t = ao2.t();
        final double u = ao2.u();
        final e j = q.j();
        while (j.f()) {
            final d a = j.a();
            final q a2 = a.a(q);
            final ao ao3 = (ao)this.C.b(a2);
            Label_0206: {
                if (ao3 != null) {
                    if (ao3.v() >= u) {
                        break Label_0206;
                    }
                    if (ao3.w() <= t) {
                        break Label_0206;
                    }
                    this.A.a(this.s.a(d, a2), this.A.b(a));
                    if (f == 0) {
                        break Label_0206;
                    }
                }
                this.A.a(this.s.a(d, a2), this.A.b(a));
            }
            j.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final ao ao, final ao ao2, final boolean b, final boolean b2) {
        final int f = y.f.i.v.f;
        final aJ aj = (aJ)this.y.b(ao);
        if (aj == null) {
            return;
        }
        final aJ aj2 = new aJ();
        Label_0237: {
            if (b) {
                if (b2) {
                    aj2.a = aj.a;
                    aj2.b = aj.b;
                    this.b(aj.a, ao2, (byte)2);
                    this.b(aj.b, ao2, (byte)20);
                    if (f == 0) {
                        break Label_0237;
                    }
                }
                aj2.c = aj.c;
                aj2.d = aj.d;
                this.b(aj.c, ao2, (byte)1);
                this.b(aj.d, ao2, (byte)10);
                if (f == 0) {
                    break Label_0237;
                }
            }
            if (b2) {
                aj2.e = aj.e;
                aj2.f = aj.f;
                this.b(aj.e, ao2, (byte)4);
                this.b(aj.f, ao2, (byte)40);
                if (f == 0) {
                    break Label_0237;
                }
            }
            aj2.g = aj.g;
            aj2.h = aj.h;
            this.b(aj.g, ao2, (byte)8);
            this.b(aj.h, ao2, (byte)80);
        }
        ((aF)this.y).a(ao2, aj2);
    }
    
    private void a(final ao ao, final ao ao2, final boolean b) {
        final aJ aj = (aJ)this.y.b(ao);
        if (aj == null) {
            return;
        }
        final aJ aj2 = new aJ();
        Label_0213: {
            if (b) {
                aj2.a = aj.a;
                aj2.b = aj.b;
                this.b(aj.a, ao2, (byte)2);
                this.b(aj.b, ao2, (byte)20);
                aj2.c = aj.c;
                aj2.d = aj.d;
                this.b(aj.c, ao2, (byte)1);
                this.b(aj.d, ao2, (byte)10);
                if (y.f.i.v.f == 0) {
                    break Label_0213;
                }
            }
            aj2.e = aj.e;
            aj2.f = aj.f;
            this.b(aj.e, ao2, (byte)4);
            this.b(aj.f, ao2, (byte)40);
            aj2.g = aj.g;
            aj2.h = aj.h;
            this.b(aj.g, ao2, (byte)8);
            this.b(aj.h, ao2, (byte)80);
        }
        ((aF)this.y).a(ao2, aj2);
    }
    
    private void c(final ao ao, final ao ao2) {
        final int f = y.f.i.v.f;
        final y.f.i.al al = (y.f.i.al)ao;
        if (al.m()) {
            final C m = al.l().m();
            y.f.i.am am;
            ae ae;
            D d;
            p p2 = null;
            af af = null;
            ao ao3 = null;
            ao ao4;
            ao ao6;
            ao ao5 = null;
            Label_0143_Outer:Label_0201_Outer:
            while (m.f()) {
                am = (y.f.i.am)m.d();
                Label_0265: {
                    if (am.b >= ao2.t() && am.b < ao2.u()) {
                        ae = (ae)this.E.b(am.a);
                        d = ae.e(true);
                        while (true) {
                            while (true) {
                                Label_0222: {
                                    Label_0181: {
                                        if (d == null) {
                                            break Label_0181;
                                        }
                                        p2 = d.k();
                                        while (true) {
                                            if (p2 == null) {
                                                break Label_0181;
                                            }
                                            af = (af)p2.c();
                                            ao3 = ao;
                                            ao4 = ao;
                                            ao5 = (ao6 = af.a);
                                            if (f != 0) {
                                                break Label_0222;
                                            }
                                            if (ao4 == ao6) {
                                                af.a = ao2;
                                                al.b(am);
                                                ((y.f.i.al)ao2).a(am);
                                            }
                                            p2 = d.c(p2);
                                            if (f == 0) {
                                                continue Label_0143_Outer;
                                            }
                                            break;
                                        }
                                    }
                                    d = ae.e(false);
                                    if (d == null) {
                                        break Label_0265;
                                    }
                                    p2 = d.k();
                                    if (p2 == null) {
                                        break Label_0265;
                                    }
                                    af = (af)p2.c();
                                    ao3 = ao;
                                    ao4 = ao;
                                    ao5 = (ao6 = af.a);
                                }
                                if (f != 0) {
                                    continue Label_0201_Outer;
                                }
                                break;
                            }
                            if (ao3 == ao5) {
                                af.a = ao2;
                                al.b(am);
                                ((y.f.i.al)ao2).a(am);
                            }
                            p2 = d.c(p2);
                            if (f == 0) {
                                continue;
                            }
                            break;
                        }
                    }
                }
                m.g();
                if (f != 0) {
                    break;
                }
            }
        }
    }
    
    private void b(final ao ao, final ao ao2, final byte b) {
        final int f = y.f.i.v.f;
        final y.f.i.al al = (y.f.i.al)ao;
        if (al.m()) {
            final C m = al.l().m();
            y.f.i.am am;
            ae ae;
            D d;
            p p3 = null;
            af af = null;
            ao ao3 = null;
            ao ao4;
            ao ao6;
            ao ao5 = null;
            Label_0150_Outer:Label_0214_Outer:
            while (m.f()) {
                am = (y.f.i.am)m.d();
                Label_0279: {
                    if (am.c == b && am.b >= ao2.t() && am.b < ao2.u()) {
                        ae = (ae)this.E.b(am.a);
                        d = ae.e(true);
                        while (true) {
                        Label_0240:
                            while (true) {
                                Label_0194: {
                                    if (d == null) {
                                        break Label_0194;
                                    }
                                    p3 = d.k();
                                    while (true) {
                                        if (p3 == null) {
                                            break Label_0194;
                                        }
                                        af = (af)p3.c();
                                        ao3 = ao;
                                        ao4 = ao;
                                        ao5 = (ao6 = af.a);
                                        if (f != 0) {
                                            break Label_0240;
                                        }
                                        if (ao4 == ao6) {
                                            af.a = ao2;
                                            al.b(am);
                                            ((y.f.i.al)ao2).a(am);
                                        }
                                        p3 = d.c(p3);
                                        if (f == 0) {
                                            continue Label_0150_Outer;
                                        }
                                        break;
                                    }
                                }
                                d = ae.e(false);
                                if (d == null) {
                                    break Label_0279;
                                }
                                p3 = d.k();
                                if (p3 == null) {
                                    break Label_0279;
                                }
                                af = (af)p3.c();
                                ao3 = ao;
                                ao4 = ao;
                                ao5 = (ao6 = af.a);
                                if (f != 0) {
                                    continue Label_0214_Outer;
                                }
                                break;
                            }
                            if (ao3 == ao5) {
                                af.a = ao2;
                                al.b(am);
                                ((y.f.i.al)ao2).a(am);
                            }
                            p3 = d.c(p3);
                            if (f == 0) {
                                continue;
                            }
                            break;
                        }
                    }
                }
                m.g();
                if (f != 0) {
                    break;
                }
            }
        }
    }
    
    private boolean a(final double[] array, final boolean b) {
        if (array[1] <= array[0]) {
            array[1] = array[0];
            return true;
        }
        if (b) {
            if (this.i) {
                if (this.a(array[0], array[1]) < 1) {
                    array[1] = array[0];
                    return true;
                }
            }
            else if (array[1] - array[0] < 2.0 * this.r) {
                array[1] = array[0];
                return true;
            }
        }
        return false;
    }
    
    private boolean b(final double[] array, final boolean b) {
        if (array[2] >= array[3]) {
            array[2] = array[3];
            return true;
        }
        if (b) {
            if (this.i) {
                if (this.a(array[2], array[3]) < 1) {
                    array[2] = array[3];
                    return true;
                }
            }
            else if (array[3] - array[2] < 2.0 * this.r) {
                array[2] = array[3];
                return true;
            }
        }
        return false;
    }
    
    private void a(final y.f.i.al al, final D d, final boolean b) {
        final int f = y.f.i.v.f;
        final C m = d.m();
        while (m.f()) {
            final y.f.i.al al2 = (y.f.i.al)m.d();
            if (al2.v() < al.w()) {
                if (al2.w() > al.v()) {
                    al.a(b, al2);
                    al2.a(!b, al);
                }
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void c(final ao ao) {
        final int f = y.f.i.v.f;
        final y.f.i.al al = (y.f.i.al)ao;
        final double n = al.t() - al.g();
        final double n2 = al.h() - al.u();
        final double[] array = new double[4];
        final double[] array2 = new double[4];
        double n3 = 0.0;
        Label_0663: {
            if (n > 0.0) {
                if (ao.x()) {
                    final C m = al.i.m();
                    while (m.f()) {
                        final y.f.i.al al2 = (y.f.i.al)m.d();
                        final D d = new D(al2.c);
                        al2.c(false, null);
                        al2.e(false);
                        final t l = new t(al2.l.a - n, al2.l.b);
                        array[0] = al2.k.a;
                        array[1] = l.a;
                        array[2] = al2.l.a;
                        array[3] = al2.l.a;
                        array2[0] = al2.k.b;
                        array2[1] = al.i();
                        array2[2] = al.j();
                        array2[3] = al2.l.b;
                        n3 = dcmpg(al2.v(), al.i());
                        if (f != 0) {
                            break Label_0663;
                        }
                        if (n3 < 0) {
                            final y.f.i.al al3 = (y.f.i.al)this.a(al2, array, array2, true);
                            al2.a(false, al3);
                            al3.a(true, al2);
                            this.a(al3, d, false);
                        }
                        if (al2.w() > al.j()) {
                            final y.f.i.al al4 = (y.f.i.al)this.b(al2, array, array2, true);
                            al2.a(false, al4);
                            al4.a(true, al2);
                            this.a(al4, d, false);
                        }
                        al2.l = l;
                        m.g();
                    }
                }
                else {
                    final C i = al.i.m();
                    while (i.f()) {
                        final y.f.i.al al5 = (y.f.i.al)i.d();
                        final D d2 = new D(al5.c);
                        al5.c(false, null);
                        al5.e(false);
                        final t j = new t(al5.l.a, al5.l.b - n);
                        array2[0] = al5.k.b;
                        array2[1] = j.b;
                        array2[2] = al5.l.b;
                        array2[3] = al5.l.b;
                        array[0] = al5.k.a;
                        array[1] = al.i();
                        array[2] = al.j();
                        array[3] = al5.l.a;
                        final double n4 = dcmpg(al5.v(), al.i());
                        if (f != 0) {
                            break Label_0663;
                        }
                        if (n4 < 0) {
                            final y.f.i.al al6 = (y.f.i.al)this.a(al5, array, array2, false);
                            al5.a(false, al6);
                            al6.a(true, al5);
                            this.a(al6, d2, false);
                        }
                        if (al5.w() > al.j()) {
                            final y.f.i.al al7 = (y.f.i.al)this.b(al5, array, array2, false);
                            al5.a(false, al7);
                            al7.a(true, al5);
                            this.a(al7, d2, false);
                        }
                        al5.l = j;
                        i.g();
                        if (f != 0) {
                            break;
                        }
                    }
                }
            }
            final double n5 = dcmpl(n2, 0.0);
        }
        Label_1279: {
            if (n3 > 0) {
                Label_0976: {
                    if (ao.x()) {
                        final C k = al.j.m();
                        while (k.f()) {
                            final y.f.i.al al8 = (y.f.i.al)k.d();
                            final D d3 = new D(al8.b);
                            al8.c(true, null);
                            al8.e(true);
                            final t k2 = new t(al8.k.a + n2, al8.k.b);
                            array[0] = al8.k.a;
                            array[1] = al8.k.a;
                            array[2] = k2.a;
                            array[3] = al8.l.a;
                            array2[0] = al8.k.b;
                            array2[1] = al.i();
                            array2[2] = al.j();
                            array2[3] = al8.l.b;
                            if (f != 0) {
                                return;
                            }
                            if (al8.v() < al.i()) {
                                final y.f.i.al al9 = (y.f.i.al)this.a(al8, array, array2, true);
                                al8.a(true, al9);
                                al9.a(false, al8);
                                this.a(al9, d3, true);
                            }
                            if (al8.w() > al.j()) {
                                final y.f.i.al al10 = (y.f.i.al)this.b(al8, array, array2, true);
                                al8.a(true, al10);
                                al10.a(false, al8);
                                this.a(al10, d3, true);
                            }
                            al8.k = k2;
                            k.g();
                            if (f != 0) {
                                break Label_0976;
                            }
                        }
                        break Label_1279;
                    }
                }
                final C m2 = al.j.m();
                while (m2.f()) {
                    final y.f.i.al al11 = (y.f.i.al)m2.d();
                    final D d4 = new D(al11.b);
                    al11.c(true, null);
                    al11.e(true);
                    final t k3 = new t(al11.k.a, al11.k.b + n2);
                    array2[0] = al11.k.b;
                    array2[1] = al11.k.b;
                    array2[2] = k3.b;
                    array2[3] = al11.l.b;
                    array[0] = al11.k.a;
                    array[1] = al.i();
                    array[2] = al.j();
                    array[3] = al11.l.a;
                    if (f != 0) {
                        return;
                    }
                    if (al11.v() < al.i()) {
                        final y.f.i.al al12 = (y.f.i.al)this.a(al11, array, array2, false);
                        al11.a(true, al12);
                        al12.a(false, al11);
                        this.a(al12, d4, true);
                    }
                    if (al11.w() > al.j()) {
                        final y.f.i.al al13 = (y.f.i.al)this.b(al11, array, array2, false);
                        al11.a(true, al13);
                        al13.a(false, al11);
                        this.a(al13, d4, true);
                    }
                    al11.k = k3;
                    m2.g();
                    if (f != 0) {
                        break;
                    }
                }
            }
        }
        this.a((q)this.B.b(ao));
    }
    
    private void a(final ao ao, final t t, final t t2) {
        final int f = y.f.i.v.f;
        if (t.a != t2.a) {
            throw new IllegalArgumentException("Segment is not vertical.");
        }
        final double[] array = new double[4];
        final double[] array2 = new double[4];
        final q q = (q)this.B.b(ao);
        final double min = Math.min(t.b, t2.b);
        final double max = Math.max(t.b, t2.b);
        final double p3 = this.P();
        array2[0] = ao.k.b;
        array2[1] = min - p3;
        final boolean a = this.a(array2, true);
        array2[2] = max + p3;
        array2[3] = ao.l.b;
        final boolean b = this.b(array2, true);
        array[0] = ao.k.a;
        array[1] = t.a - p3;
        final boolean a2 = this.a(array, false);
        array[2] = t.a + p3;
        array[3] = ao.l.a;
        final boolean b2 = this.b(array, false);
        y.f.i.al al = null;
        D d = null;
        if (!a2 && !b2) {
            al = new y.f.i.al(array[0], array2[0], array[1], array2[3], true);
            this.c(ao, al);
            this.a(ao, al, true);
            this.b(ao, al);
            final y.f.i.al al2 = (y.f.i.al)ao;
            al2.c(true, al);
            al.a(true, al2.b);
            ao.k = new t(array[2], array2[0]);
        }
        else if (!a2) {
            final y.f.i.al al3 = (y.f.i.al)ao;
            d = new D(al3.c);
            al3.c(false, null);
            al3.e(false);
            ao.l = new t(array[1], array2[3]);
        }
        else {
            final y.f.i.al al4 = (y.f.i.al)ao;
            d = new D(al4.b);
            al4.c(true, null);
            al4.e(true);
            ao.k = new t(array[2], array2[0]);
        }
        Label_0577: {
            if (!a) {
                final y.f.i.al al5 = (y.f.i.al)this.a(ao, array, array2, true);
                if (!a2 && !b2) {
                    al.a(false, al5);
                    al5.a(true, al);
                    al5.a(false, (y.f.i.al)ao);
                    ((y.f.i.al)ao).a(true, al5);
                    if (f == 0) {
                        break Label_0577;
                    }
                }
                if (!a2) {
                    ((y.f.i.al)ao).a(false, al5);
                    al5.a(true, (y.f.i.al)ao);
                    this.b(al5, d, false);
                    if (f == 0) {
                        break Label_0577;
                    }
                }
                ((y.f.i.al)ao).a(true, al5);
                al5.a(false, (y.f.i.al)ao);
                this.b(al5, d, true);
            }
        }
        Label_0716: {
            if (!b) {
                final y.f.i.al al6 = (y.f.i.al)this.b(ao, array, array2, true);
                if (!a2 && !b2) {
                    al.a(false, al6);
                    al6.a(true, al);
                    al6.a(false, (y.f.i.al)ao);
                    ((y.f.i.al)ao).a(true, al6);
                    if (f == 0) {
                        break Label_0716;
                    }
                }
                if (!a2) {
                    ((y.f.i.al)ao).a(false, al6);
                    al6.a(true, (y.f.i.al)ao);
                    this.b(al6, d, false);
                    if (f == 0) {
                        break Label_0716;
                    }
                }
                ((y.f.i.al)ao).a(true, al6);
                al6.a(false, (y.f.i.al)ao);
                this.b(al6, d, true);
            }
        }
        this.a((q)this.B.b(ao));
    }
    
    private void b(final y.f.i.al al, final D d, final boolean b) {
        final int f = y.f.i.v.f;
        final C m = d.m();
        while (m.f()) {
            final y.f.i.al al2 = (y.f.i.al)m.d();
            if (al2.v() < al.w()) {
                if (al2.w() > al.v()) {
                    al.a(b, al2);
                }
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void b(final ao ao, final t t, final t t2) {
        final int f = y.f.i.v.f;
        if (t.b != t2.b) {
            throw new IllegalArgumentException("Segment is not horizontal.");
        }
        final double[] array = new double[4];
        final double[] array2 = new double[4];
        final q q = (q)this.B.b(ao);
        final double min = Math.min(t.a, t2.a);
        final double max = Math.max(t.a, t2.a);
        double r = 0.0;
        Label_0106: {
            if (this.i) {
                r = this.p / 2.0;
                if (f == 0) {
                    break Label_0106;
                }
            }
            r = this.r;
        }
        array[0] = ao.k.a;
        array[1] = min - r;
        final boolean a = this.a(array, true);
        array[2] = max + r;
        array[3] = ao.l.a;
        final boolean b = this.b(array, true);
        array2[0] = ao.k.b;
        array2[1] = t.b - r;
        final boolean a2 = this.a(array2, false);
        array2[2] = t.b + r;
        array2[3] = ao.l.b;
        final boolean b2 = this.b(array2, false);
        y.f.i.al al = null;
        D d = null;
        if (!a2 && !b2) {
            al = new y.f.i.al(array[0], array2[0], array[3], array2[1], false);
            this.c(ao, al);
            this.a(ao, al, false);
            this.b(ao, al);
            final y.f.i.al al2 = (y.f.i.al)ao;
            al2.c(true, al);
            al.a(true, al2.b);
            ao.k = new t(array[0], array2[2]);
        }
        else if (!a2) {
            final y.f.i.al al3 = (y.f.i.al)ao;
            d = new D(al3.c);
            al3.c(false, null);
            al3.e(false);
            ao.l = new t(array[3], array2[1]);
        }
        else {
            final y.f.i.al al4 = (y.f.i.al)ao;
            d = new D(al4.b);
            al4.c(true, null);
            al4.e(true);
            ao.k = new t(array[0], array2[2]);
        }
        Label_0600: {
            if (!a) {
                final y.f.i.al al5 = (y.f.i.al)this.a(ao, array, array2, false);
                if (!a2 && !b2) {
                    al.a(false, al5);
                    al5.a(true, al);
                    al5.a(false, (y.f.i.al)ao);
                    ((y.f.i.al)ao).a(true, al5);
                    if (f == 0) {
                        break Label_0600;
                    }
                }
                if (!a2) {
                    ((y.f.i.al)ao).a(false, al5);
                    al5.a(true, (y.f.i.al)ao);
                    this.b(al5, d, false);
                    if (f == 0) {
                        break Label_0600;
                    }
                }
                ((y.f.i.al)ao).a(true, al5);
                al5.a(false, (y.f.i.al)ao);
                this.b(al5, d, true);
            }
        }
        Label_0739: {
            if (!b) {
                final y.f.i.al al6 = (y.f.i.al)this.b(ao, array, array2, false);
                if (!a2 && !b2) {
                    al.a(false, al6);
                    al6.a(true, al);
                    al6.a(false, (y.f.i.al)ao);
                    ((y.f.i.al)ao).a(true, al6);
                    if (f == 0) {
                        break Label_0739;
                    }
                }
                if (!a2) {
                    ((y.f.i.al)ao).a(false, al6);
                    al6.a(true, (y.f.i.al)ao);
                    this.b(al6, d, false);
                    if (f == 0) {
                        break Label_0739;
                    }
                }
                ((y.f.i.al)ao).a(true, al6);
                al6.a(false, (y.f.i.al)ao);
                this.b(al6, d, true);
            }
        }
        this.a((q)this.B.b(ao));
    }
    
    void a(final q q) {
        final int f = y.f.i.v.f;
        if (q == null) {
            return;
        }
        final ao ao = (ao)this.C.b(q);
        if (ao != null) {
            final Rectangle2D.Double double1 = new Rectangle2D.Double(ao.k.a, ao.k.b, ao.l.a - ao.k.a, ao.l.b - ao.k.b);
            final e j = q.j();
            while (j.f()) {
                final ao ao2 = (ao)this.C.b(j.a().a(q));
                if (ao2 != null && !double1.intersects(ao2.k.a, ao2.k.b, ao2.l.a - ao2.k.a, ao2.l.b - ao2.k.b)) {
                    q.e().a(j.a());
                }
                j.g();
                if (f != 0) {
                    break;
                }
            }
        }
    }
    
    private ao a(final ao ao, final double[] array, final double[] array2, final boolean b) {
        final int f = y.f.i.v.f;
        final double[] array3 = new double[4];
        final double[] array4 = new double[2];
        ao ao2 = null;
        byte b2 = 0;
        Label_0063: {
            if (b) {
                array3[0] = array2[0];
                array3[1] = array2[1];
                b2 = 1;
                if (f == 0) {
                    break Label_0063;
                }
            }
            array3[0] = array[0];
            array3[1] = array[1];
            b2 = 8;
        }
        final q q = (q)this.B.b(ao);
        if (array3[1] > array3[0]) {
            if (b) {
                ao2 = new y.f.i.al(array[1], array2[0], array[2], array2[1], true);
                this.b(ao, ao2, b2);
            }
            else {
                ao2 = new y.f.i.al(array[0], array2[1], array[1], array2[2], false);
                this.b(ao, ao2, b2);
            }
            final q d = this.s.d();
            this.C.a(d, ao2);
            this.B.a(ao2, d);
            final e j = q.j();
            while (j.f()) {
                final d a = j.a();
                final q a2 = a.a(q);
                final ao ao3 = (ao)this.C.b(a2);
                if (f != 0) {
                    return ao2;
                }
                if (ao3 != null) {
                    Label_0313: {
                        if (b) {
                            array4[0] = ao3.k.b;
                            array4[1] = ao3.l.b;
                            if (f == 0) {
                                break Label_0313;
                            }
                        }
                        array4[0] = ao3.k.a;
                        array4[1] = ao3.l.a;
                    }
                    if (array4[0] < array3[1]) {
                        if (array4[1] > array3[0]) {
                            this.A.a(this.s.a(d, a2), this.A.b(a));
                        }
                    }
                }
                j.g();
                if (f != 0) {
                    break;
                }
            }
            this.a(ao, ao2, b2);
        }
        return ao2;
    }
    
    private ao b(final ao ao, final double[] array, final double[] array2, final boolean b) {
        final int f = y.f.i.v.f;
        final double[] array3 = new double[4];
        final double[] array4 = new double[2];
        ao ao2 = null;
        byte b2 = 0;
        Label_0062: {
            if (b) {
                array3[2] = array2[2];
                array3[3] = array2[3];
                b2 = 2;
                if (f == 0) {
                    break Label_0062;
                }
            }
            array3[2] = array[2];
            array3[3] = array[3];
            b2 = 4;
        }
        final q q = (q)this.B.b(ao);
        if (array3[2] < array3[3]) {
            if (b) {
                ao2 = new y.f.i.al(array[1], array2[2], array[2], array2[3], true);
                this.b(ao, ao2, b2);
            }
            else {
                ao2 = new y.f.i.al(array[2], array2[1], array[3], array2[2], false);
                this.b(ao, ao2, b2);
            }
            final q d = this.s.d();
            this.C.a(d, ao2);
            this.B.a(ao2, d);
            final e j = q.j();
            while (j.f()) {
                final d a = j.a();
                final q a2 = a.a(q);
                final ao ao3 = (ao)this.C.b(a2);
                if (f != 0) {
                    return ao2;
                }
                if (ao3 != null) {
                    Label_0312: {
                        if (b) {
                            array4[0] = ao3.k.b;
                            array4[1] = ao3.l.b;
                            if (f == 0) {
                                break Label_0312;
                            }
                        }
                        array4[0] = ao3.k.a;
                        array4[1] = ao3.l.a;
                    }
                    if (array4[0] < array3[3]) {
                        if (array4[1] > array3[2]) {
                            this.A.a(this.s.a(d, a2), this.A.b(a));
                        }
                    }
                }
                j.g();
                if (f != 0) {
                    break;
                }
            }
            this.a(ao, ao2, b2);
        }
        return ao2;
    }
    
    private void c(final ao ao, final t t, final t t2) {
        if (ao.x()) {
            this.a(ao, t, t2);
            if (y.f.i.v.f == 0) {
                return;
            }
        }
        this.b(ao, t, t2);
    }
    
    private D d(final D d) {
        final int f = y.f.i.v.f;
        Object o = null;
        final ao ao = (ao)d.f();
        final boolean x = ao.x();
        final double n = x ? ao.s() : ao.r();
        final q q = (q)this.B.b(ao);
        double abs = Double.MAX_VALUE;
        final x m = q.m();
        while (true) {
            while (m.f()) {
                final ao ao3;
                final ao ao2 = ao3 = (ao)this.C.b(m.e());
                if (f == 0) {
                    if (ao3 != null) {
                        final double n2 = x ? ao2.s() : ao2.r();
                        if (Math.abs(n - n2) < abs) {
                            o = ao2;
                            abs = Math.abs(n - n2);
                        }
                    }
                    m.g();
                    if (f != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    if (ao3 == null) {
                        throw new IllegalStateException("Sightpatch missing for special case treatment");
                    }
                    final D d2 = new D();
                    d2.add(ao);
                    d2.add(o);
                    d2.add(ao);
                    return d2;
                }
            }
            continue;
        }
    }
    
    private void a(final d w, D d, final boolean b) {
        final int f = y.f.i.v.f;
        final D d2 = new D();
        final ae ae = (ae)this.E.b(w);
        final t c = this.c(w);
        this.w = w;
        t t = null;
        t t2 = null;
        Label_0405: {
            if (d.size() == 1) {
                final ao ao = (ao)d.f();
                this.x = true;
                final t a = this.a(w.c(), ao, c);
                this.x = false;
                final t a2 = this.a(w.d(), ao, c);
                Label_0290: {
                    if (ae.b(true) && !ae.b(false)) {
                        t = a;
                        t2 = (ao.x() ? new t(this.g.p(w).a, a2.b) : new t(a2.a, this.g.p(w).b));
                        ae.c(false, true);
                        if (f == 0) {
                            break Label_0290;
                        }
                    }
                    if (!ae.b(true) && ae.b(false)) {
                        t = (ao.x() ? new t(this.g.q(w).a, a.b) : new t(a.a, this.g.q(w).b));
                        t2 = a2;
                        ae.c(true, true);
                        if (f == 0) {
                            break Label_0290;
                        }
                    }
                    t = a;
                    t2 = a2;
                }
                if (!ae.b(true) || !ae.b(false) || !(ao.x() ? (this.g.p(w).a == this.g.q(w).a) : (this.g.p(w).b == this.g.q(w).b))) {
                    break Label_0405;
                }
                d = this.d(d);
                if (f == 0) {
                    break Label_0405;
                }
            }
            t = null;
            t2 = null;
        }
        ao ao2 = (ao)d.f();
        t t3 = null;
        Label_0506: {
            if (ae.b(true)) {
                t3 = this.g.p(w);
                if (f == 0) {
                    break Label_0506;
                }
            }
            if (ae.d(true)) {
                t3 = t;
                if (f == 0) {
                    break Label_0506;
                }
            }
            this.x = true;
            if (d.size() == 1) {
                t3 = this.a(w.c(), w.d(), ao2, c);
                if (f == 0) {
                    break Label_0506;
                }
            }
            t3 = this.a(w.c(), ao2, c);
        }
        y.f.i.al al = (y.f.i.al)ao2;
        this.g.c(w, t3);
        d2.add(t3);
        double n = t3.a;
        double n2 = t3.b;
        final ao ao3 = (ao)d.i();
        t q = null;
        Label_0702: {
            if (ae.b(false)) {
                q = this.g.q(w);
                if (f == 0) {
                    break Label_0702;
                }
            }
            if (ae.d(false)) {
                q = t2;
                if (f == 0) {
                    break Label_0702;
                }
            }
            this.x = false;
            final t a3 = this.a(w.d(), ao3, c);
            if (d.size() == 1 && (this.an || (this.ao && this.am) || this.al)) {
                if (ao3.x()) {
                    q = new t(n, a3.b);
                    if (f == 0) {
                        break Label_0702;
                    }
                }
                q = new t(a3.a, n2);
                if (f == 0) {
                    break Label_0702;
                }
            }
            q = a3;
        }
        t t4 = t3;
        p p3 = d.k().a();
        while (true) {
            while (p3 != null) {
                al = (y.f.i.al)ao2;
                final t t5 = t4;
                ao2 = (ao)p3.c();
                final boolean a4 = this.a(p3, t3, q);
                if (f != 0) {
                    Label_1949: {
                        if (al.n && !ao3.n) {
                            if (al.x()) {
                                if (t4.a > q.a) {
                                    t4 = new t(t4.a - 2.0 * this.P() - 1.0, t4.b);
                                    if (f == 0) {
                                        break Label_1949;
                                    }
                                }
                                t4 = new t(t4.a + 2.0 * this.P() + 1.0, t4.b);
                                if (f == 0) {
                                    break Label_1949;
                                }
                            }
                            if (t4.b > q.b) {
                                t4 = new t(t4.a, t4.b - 2.0 * this.P() - 1.0);
                                if (f == 0) {
                                    break Label_1949;
                                }
                            }
                            t4 = new t(t4.a, t4.b + 2.0 * this.P() + 1.0);
                        }
                    }
                    if (b && !ao3.n) {
                        if (((y.f.i.al)ao3).f()) {
                            this.c(ao3);
                        }
                        this.c(ao3, t4, q);
                    }
                    this.g.a(w, d2);
                    boolean x = false;
                    Label_2119: {
                        if (ae.b(true)) {
                            final t p4 = this.g.p(w);
                            final C m = ae.e(true).m();
                            while (m.f()) {
                                final y.f.i.al al2 = (y.f.i.al)((af)m.d()).a;
                                x = al2.x();
                                if (f != 0) {
                                    break Label_2119;
                                }
                                al2.a(w, x ? p4.a : p4.b, true);
                                m.g();
                                if (f != 0) {
                                    break;
                                }
                            }
                        }
                        ae.b(false);
                    }
                    if (x) {
                        final t q2 = this.g.q(w);
                        final C i = ae.e(false).m();
                        while (i.f()) {
                            final y.f.i.al al3 = (y.f.i.al)((af)i.d()).a;
                            if (f != 0) {
                                return;
                            }
                            al3.a(w, al3.x() ? q2.a : q2.b, false);
                            i.g();
                            if (f != 0) {
                                break;
                            }
                        }
                    }
                    this.a(w, d);
                    return;
                }
                Label_1518: {
                    if (p3.a() != null) {
                        if (ao2.x()) {
                            if (this.i) {
                                Label_0907: {
                                    if (this.ao || (this.al && a4)) {
                                        if (Math.abs(ao2.k.a - c.a) <= Math.abs(ao2.l.a - c.a)) {
                                            n = this.a(ao2, true, true);
                                            if (f == 0) {
                                                break Label_0907;
                                            }
                                        }
                                        n = this.a(ao2, true, false);
                                        if (f == 0) {
                                            break Label_0907;
                                        }
                                    }
                                    if (this.an || (this.al && !a4)) {
                                        n = this.e(ao2);
                                        if (f == 0) {
                                            break Label_0907;
                                        }
                                    }
                                    n = this.a(ao2, true, true);
                                }
                                t4 = new t(n, n2);
                                if (f == 0) {
                                    break Label_1518;
                                }
                            }
                            if (this.ao || (this.al && a4)) {
                                if (Math.abs(ao2.k.a - c.a) <= Math.abs(ao2.l.a - c.a)) {
                                    t4 = new t(n = ao2.k.a + this.r, n2);
                                    if (f == 0) {
                                        break Label_1518;
                                    }
                                }
                                t4 = new t(n = ao2.l.a - this.r, n2);
                                if (f == 0) {
                                    break Label_1518;
                                }
                            }
                            if (this.an || (this.al && !a4)) {
                                t4 = new t(n = this.d(ao2), n2);
                                if (f == 0) {
                                    break Label_1518;
                                }
                            }
                            t4 = new t(n = ao2.k.a + this.r, n2);
                            if (f == 0) {
                                break Label_1518;
                            }
                        }
                        if (this.i) {
                            Label_1258: {
                                if (this.ao || (this.al && a4)) {
                                    if (Math.abs(ao2.k.b - c.b) <= Math.abs(ao2.l.b - c.b)) {
                                        n2 = this.a(ao2, false, true);
                                        if (f == 0) {
                                            break Label_1258;
                                        }
                                    }
                                    n2 = this.a(ao2, false, false);
                                    if (f == 0) {
                                        break Label_1258;
                                    }
                                }
                                if (this.an || (this.al && !a4)) {
                                    n2 = this.e(ao2);
                                    if (f == 0) {
                                        break Label_1258;
                                    }
                                }
                                n2 = this.a(ao2, false, true);
                            }
                            t4 = new t(n, n2);
                            if (f == 0) {
                                break Label_1518;
                            }
                        }
                        if (this.ao || (this.al && a4)) {
                            if (Math.abs(ao2.k.b - c.b) <= Math.abs(ao2.l.b - c.b)) {
                                t4 = new t(n, n2 = ao2.k.b + this.r);
                                if (f == 0) {
                                    break Label_1518;
                                }
                            }
                            t4 = new t(n, n2 = ao2.l.b - this.r);
                            if (f == 0) {
                                break Label_1518;
                            }
                        }
                        if (this.an || (this.al && !a4)) {
                            t4 = new t(n, n2 = this.d(ao2));
                            if (f == 0) {
                                break Label_1518;
                            }
                        }
                        t4 = new t(n, n2 = ao2.k.b + this.r);
                        if (f == 0) {
                            break Label_1518;
                        }
                    }
                    if (ao2.x()) {
                        t4 = new t(q.a, n2);
                        if (f == 0) {
                            break Label_1518;
                        }
                    }
                    t4 = new t(n, q.b);
                }
                d2.add(t4);
                Label_1693: {
                    if (ao2.n) {
                        if (ao2.x()) {
                            if (t5.a < q.a) {
                                t4 = new t(q.a - 2.0 * this.P() - 1.0, n2);
                                if (f == 0) {
                                    break Label_1693;
                                }
                            }
                            t4 = new t(q.a + 2.0 * this.P() + 1.0, n2);
                            if (f == 0) {
                                break Label_1693;
                            }
                        }
                        if (t5.b < q.b) {
                            t4 = new t(n, q.b - 2.0 * this.P() - 1.0);
                            if (f == 0) {
                                break Label_1693;
                            }
                        }
                        t4 = new t(n, q.b + 2.0 * this.P() + 1.0);
                    }
                }
                if (b && !al.n) {
                    if (al.f()) {
                        this.c(al);
                    }
                    this.c(al, t5, t4);
                }
                p3 = p3.a();
                if (f != 0) {
                    break;
                }
            }
            this.g.d(w, q);
            d2.add(q);
            continue;
        }
    }
    
    private boolean a(final p p3, final t t, final t t2) {
        final int f = y.f.i.v.f;
        final ao ao = (ao)p3.c();
        final boolean x = ao.x();
        final double n = x ? ao.r() : ao.s();
        if (p3.a() == null || p3.b() == null) {
            return false;
        }
        final p b = p3.b().b();
        double n2 = 0.0;
        Label_0124: {
            if (b == null) {
                n2 = (x ? t.a() : t.b());
                if (f == 0) {
                    break Label_0124;
                }
            }
            final ao ao2 = (ao)b.c();
            n2 = (x ? ao2.r() : ao2.s());
        }
        final p a = p3.a().a();
        if (a == null) {
            final double n3 = x ? t2.a() : t2.b();
            if (f == 0) {
                return (n2 > n && n3 > n) || (n2 < n && n3 < n);
            }
        }
        final ao ao3 = (ao)a.c();
        final double n3 = x ? ao3.r() : ao3.s();
        return (n2 > n && n3 > n) || (n2 < n && n3 < n);
    }
    
    void a(final d d, final D d2) {
        ao ao;
        t t;
        t t2;
        if (this.b(d.c())) {
            ao = (ao)d2.f();
            final D m = this.g.m(d);
            t = (t)m.get(0);
            t2 = (t)m.get(1);
        }
        else {
            if (!this.b(d.d())) {
                return;
            }
            ao = (ao)d2.i();
            final D i = this.g.m(d);
            t = (t)i.get(i.size() - 1);
            t2 = (t)i.get(i.size() - 2);
        }
        if (ao.n) {
            final double n = ao.x() ? t.b : t.a;
            ao.p = Math.max(ao.p, (float)n);
            ao.o = Math.min(ao.o, (float)n);
            final double n2 = ao.x() ? t2.b : t2.a;
            ao.p = Math.max(ao.p, (float)n2);
            ao.o = Math.min(ao.o, (float)n2);
        }
    }
    
    private double P() {
        if (this.i) {
            return this.p / 2.0;
        }
        return this.r;
    }
    
    private t a(final q q, final q q2, final ao ao, final t t) {
        final t a = this.a(q, ao, t);
        if ((!this.an && !this.ao && !this.al) || !this.am) {
            return a;
        }
        final t a2 = this.a(q2, ao, t);
        if (ao.x()) {
            if (Math.abs(a.a - this.g.j(q)) < Math.abs(a2.a - this.g.j(q2))) {
                return a;
            }
            return new t(a2.a, a.b);
        }
        else {
            if (Math.abs(a.b - this.g.k(q)) < Math.abs(a2.b - this.g.k(q2))) {
                return a;
            }
            return new t(a.a, a2.b);
        }
    }
    
    private t c(final d d) {
        final double[] array = new double[4];
        final double[] array2 = new double[4];
        final q c = d.c();
        final q d2 = d.d();
        final double m = this.g.m(c);
        final double n = m + this.g.p(c);
        final double n2 = this.g.n(c);
        final double n3 = n2 + this.g.q(c);
        final double i = this.g.m(d2);
        final double n4 = i + this.g.p(d2);
        final double n5 = this.g.n(d2);
        final double n6 = n5 + this.g.q(d2);
        array[0] = m;
        array[1] = n;
        array[2] = i;
        array[3] = n4;
        array2[0] = n2;
        array2[1] = n3;
        array2[2] = n5;
        array2[3] = n6;
        Arrays.sort(array);
        Arrays.sort(array2);
        return new t((array[1] + array[2]) / 2.0, (array2[1] + array2[2]) / 2.0);
    }
    
    private double a(final ao ao, final boolean b, final boolean b2) {
        final int f = y.f.i.v.f;
        double a = 0.0;
        Label_0304: {
            if (b) {
                if (b2) {
                    a = (int)Math.floor((ao.k.a - this.n.a) / this.p) * this.p + this.n.a;
                    if (a >= ao.k.a) {
                        break Label_0304;
                    }
                    a += this.p;
                    if (f == 0) {
                        break Label_0304;
                    }
                }
                a = (int)Math.floor((ao.l.a - this.n.a) / this.p) * this.p + this.n.a;
                if (a < ao.l.a) {
                    break Label_0304;
                }
                a -= this.p;
                if (f == 0) {
                    break Label_0304;
                }
            }
            if (b2) {
                a = (int)Math.floor((ao.k.b - this.n.b) / this.p) * this.p + this.n.b;
                if (a >= ao.k.b) {
                    break Label_0304;
                }
                a += this.p;
                if (f == 0) {
                    break Label_0304;
                }
            }
            a = (int)Math.floor((ao.l.b - this.n.b) / this.p) * this.p + this.n.b;
            if (a >= ao.l.b) {
                a -= this.p;
            }
        }
        if (((y.f.i.al)ao).m()) {
            a = this.a(a, ao, b2);
        }
        return a;
    }
    
    private double d(final ao ao) {
        return this.a(ao, ao.x() ? ao.r() : ao.s());
    }
    
    private double a(final ao ao, final double n) {
        final int f = y.f.i.v.f;
        final D d = new D();
        double n2 = (ao.x() ? ao.k.a : ao.k.b) + this.r;
        final double n3 = ao.x() ? ao.l.a : ao.l.b;
        double n4 = n2;
        while (true) {
            while (n4 <= n3) {
                d.add(new Double(n4));
                n4 += 2.0 * this.r;
                if (f != 0) {
                    final C m = d.m();
                    double abs = 0.0;
                    while (m.f()) {
                        final double doubleValue = (double)m.d();
                        abs = Math.abs(n - doubleValue);
                        if (f != 0) {
                            return abs;
                        }
                        if (abs < n4) {
                            n4 = Math.abs(n - doubleValue);
                            n2 = doubleValue;
                        }
                        m.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    return abs;
                }
                if (f != 0) {
                    break;
                }
            }
            n4 = Math.abs(n - n2);
            continue;
        }
    }
    
    private double e(final ao ao) {
        return this.b(ao, ao.x() ? ao.r() : ao.s());
    }
    
    private double b(final ao ao, final double n) {
        final int i = y.f.i.v.f;
        final y.f.i.al al = (y.f.i.al)ao;
        final D a = this.a(ao);
        if (a == null) {
            throw new IllegalStateException("No grid lines available.");
        }
        double n2 = n;
        boolean empty = false;
        Label_0397: {
            Label_0392: {
                if (al.m()) {
                    final C m = al.l().m();
                    boolean b = false;
                    final D d = new D();
                    while (true) {
                        while (m.f()) {
                            final boolean b2 = b;
                            if (i == 0) {
                                if (b2) {
                                    break;
                                }
                                final y.f.i.am am = (y.f.i.am)m.d();
                                if (am.a == this.w) {
                                    d.add(am);
                                }
                                m.g();
                                if (i != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (b2) {
                                    final y.f.i.am am2 = (y.f.i.am)d.f();
                                    if (am2.a != this.w) {
                                        goto Label_0255;
                                    }
                                    b = true;
                                    n2 = am2.b;
                                    if (i == 0) {
                                        goto Label_0255;
                                    }
                                }
                                final C j = d.m();
                                boolean b3 = false;
                                Label_0257: {
                                    while (j.f()) {
                                        b3 = b;
                                        if (i != 0 || b3) {
                                            break Label_0257;
                                        }
                                        final y.f.i.am am3 = (y.f.i.am)j.d();
                                        if (am3.a == this.w && am3.d == this.x) {
                                            b = true;
                                            n2 = am3.b;
                                        }
                                        j.g();
                                        if (i != 0) {
                                            goto Label_0255;
                                        }
                                    }
                                    goto Label_0255;
                                }
                                if (b3) {
                                    return n2;
                                }
                                m.i();
                                do {
                                    double f = 0.0;
                                    Label_0270: {
                                        f = (m.f() ? 1 : 0);
                                    }
                                    Label_0277:
                                    while (f != 0) {
                                        empty = a.isEmpty();
                                        if (i != 0) {
                                            break Label_0397;
                                        }
                                        if (!empty) {
                                            final double b4 = ((y.f.i.am)m.d()).b;
                                            final C k = a.m();
                                            while (k.f()) {
                                                final double n3 = f = dcmpg(Math.abs(b4 - (double)k.d()), 0.5);
                                                if (i != 0) {
                                                    continue Label_0277;
                                                }
                                                if (n3 <= 0) {
                                                    a.b(k);
                                                }
                                                k.g();
                                                if (i != 0) {
                                                    break;
                                                }
                                            }
                                            m.g();
                                            continue Label_0270;
                                        }
                                        break;
                                    }
                                    break;
                                } while (i == 0);
                                break Label_0392;
                            }
                        }
                        d.size();
                        continue;
                    }
                }
            }
            a.isEmpty();
        }
        if (empty) {
            throw new IllegalStateException("All grid lines removed.");
        }
        double abs = Double.POSITIVE_INFINITY;
        final C l = a.m();
        double abs2 = 0.0;
        while (l.f()) {
            final double doubleValue = (double)l.d();
            abs2 = Math.abs(doubleValue - n);
            if (i != 0) {
                return abs2;
            }
            if (abs2 < abs) {
                abs = Math.abs(doubleValue - n);
            }
            l.g();
            if (i != 0) {
                break;
            }
        }
        return abs2;
    }
    
    private double a(double n, final ao ao, final boolean b) {
        final int f = y.f.i.v.f;
        final double t = ao.t();
        final double u = ao.u();
        final D l = ((y.f.i.al)ao).l();
        boolean b2 = false;
        final C m = l.m();
        boolean b3 = false;
        Label_0123: {
            while (m.f()) {
                b3 = b2;
                if (f != 0 || b3) {
                    break Label_0123;
                }
                final y.f.i.am am = (y.f.i.am)m.d();
                if (am.a == this.w && am.b == n && am.d == this.x) {
                    b2 = true;
                }
                m.g();
                if (f != 0) {
                    goto Label_0121;
                }
            }
            goto Label_0121;
        }
        if (b3) {
            return n;
        }
        final double n2 = n;
        m.i();
        while (m.f() && !b2) {
            if (((y.f.i.am)m.d()).b == n) {
                n += (b ? this.p : (-this.p));
                if (n < t || n >= u) {
                    n = n2;
                }
                b2 = true;
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
        return n;
    }
    
    private t a(final q q, final ao ao, final t t) {
        final int f = y.f.i.v.f;
        double n7 = 0.0;
        if (ao.x()) {
            double n = 0.0;
            Label_0608: {
                if (this.i) {
                    if (this.ao) {
                        if (this.am) {
                            n = this.b(ao, this.g.j(q));
                            if (f == 0) {
                                break Label_0608;
                            }
                        }
                        if (Math.abs(ao.k.a - t.a) <= Math.abs(ao.l.a - t.a)) {
                            n = this.a(ao, true, true);
                            if (f == 0) {
                                break Label_0608;
                            }
                        }
                        n = this.a(ao, true, false);
                        if (f == 0) {
                            break Label_0608;
                        }
                    }
                    if (this.an || this.al) {
                        if (this.am) {
                            n = this.b(ao, this.g.j(q));
                            if (f == 0) {
                                break Label_0608;
                            }
                        }
                        n = this.e(ao);
                        if (f == 0) {
                            break Label_0608;
                        }
                    }
                    n = this.a(ao, true, true);
                    if (f == 0) {
                        break Label_0608;
                    }
                }
                if (this.ao) {
                    if (this.am) {
                        final double j = this.g.j(q);
                        final double n2 = j - this.r;
                        final double n3 = j + this.r;
                        Label_0311: {
                            if (n2 >= ao.k.a && n3 <= ao.l.a) {
                                n = j;
                                if (f == 0) {
                                    break Label_0311;
                                }
                            }
                            if (n2 >= ao.k.a) {
                                n = ao.l.a - this.r;
                                if (f == 0) {
                                    break Label_0311;
                                }
                            }
                            n = ao.k.a + this.r;
                        }
                        if (n >= ao.k.a && n <= ao.l.a) {
                            break Label_0608;
                        }
                        n = ao.r();
                        if (f == 0) {
                            break Label_0608;
                        }
                    }
                    if (Math.abs(ao.k.a - t.a) <= Math.abs(ao.l.a - t.a)) {
                        n = ao.k.a + this.r;
                        if (f == 0) {
                            break Label_0608;
                        }
                    }
                    n = ao.l.a - this.r;
                    if (f == 0) {
                        break Label_0608;
                    }
                }
                if (this.an || this.al) {
                    final double n4 = this.am ? this.g.j(q) : ao.r();
                    final double n5 = n4 - this.r;
                    final double n6 = n4 + this.r;
                    Label_0557: {
                        if (n5 >= ao.k.a && n6 <= ao.l.a) {
                            n = n4;
                            if (f == 0) {
                                break Label_0557;
                            }
                        }
                        if (n5 >= ao.k.a) {
                            n = ao.l.a - this.r;
                            if (f == 0) {
                                break Label_0557;
                            }
                        }
                        n = ao.k.a + this.r;
                    }
                    if (n >= ao.k.a && n <= ao.l.a) {
                        break Label_0608;
                    }
                    n = ao.r();
                    if (f == 0) {
                        break Label_0608;
                    }
                }
                n = ao.k.a + this.r;
            }
            if (this.aP) {
                n7 = this.g.k(q);
                if (f == 0) {
                    return new t(n, n7);
                }
            }
            if (ao.k.b < this.g.n(q)) {
                n7 = this.g.n(q);
                if (f == 0) {
                    return new t(n, n7);
                }
            }
            n7 = this.g.n(q) + this.g.q(q);
            if (f == 0) {
                return new t(n, n7);
            }
        }
        Label_1270: {
            if (this.i) {
                if (this.ao) {
                    if (this.am) {
                        n7 = this.e(ao);
                        if (f == 0) {
                            break Label_1270;
                        }
                    }
                    if (Math.abs(ao.k.b - t.b) <= Math.abs(ao.l.b - t.b)) {
                        n7 = this.a(ao, false, true);
                        if (f == 0) {
                            break Label_1270;
                        }
                    }
                    n7 = this.a(ao, false, false);
                    if (f == 0) {
                        break Label_1270;
                    }
                }
                if (this.an || this.al) {
                    if (this.am) {
                        n7 = this.e(ao);
                        if (f == 0) {
                            break Label_1270;
                        }
                    }
                    n7 = this.b(ao, this.g.k(q));
                    if (f == 0) {
                        break Label_1270;
                    }
                }
                n7 = this.a(ao, false, true);
                if (f == 0) {
                    break Label_1270;
                }
            }
            if (this.ao) {
                if (this.am) {
                    final double k = this.g.k(q);
                    final double n8 = k - this.r;
                    final double n9 = k + this.r;
                    Label_0973: {
                        if (n8 >= ao.k.b && n9 <= ao.l.b) {
                            n7 = k;
                            if (f == 0) {
                                break Label_0973;
                            }
                        }
                        if (n8 >= ao.k.b) {
                            n7 = ao.l.b - this.r;
                            if (f == 0) {
                                break Label_0973;
                            }
                        }
                        n7 = ao.k.b + this.r;
                    }
                    if (n7 >= ao.k.b && n7 <= ao.l.b) {
                        break Label_1270;
                    }
                    n7 = ao.s();
                    if (f == 0) {
                        break Label_1270;
                    }
                }
                if (Math.abs(ao.k.b - t.b) <= Math.abs(ao.l.b - t.b)) {
                    n7 = ao.k.b + this.r;
                    if (f == 0) {
                        break Label_1270;
                    }
                }
                n7 = ao.l.b - this.r;
                if (f == 0) {
                    break Label_1270;
                }
            }
            if (this.an || this.al) {
                final double n10 = this.am ? this.g.k(q) : ao.s();
                final double n11 = n10 - this.r;
                final double n12 = n10 + this.r;
                Label_1219: {
                    if (n11 >= ao.k.b && n12 <= ao.l.b) {
                        n7 = n10;
                        if (f == 0) {
                            break Label_1219;
                        }
                    }
                    if (n11 >= ao.k.b) {
                        n7 = ao.l.b - this.r;
                        if (f == 0) {
                            break Label_1219;
                        }
                    }
                    n7 = ao.k.b + this.r;
                }
                if (n7 >= ao.k.b && n7 <= ao.l.b) {
                    break Label_1270;
                }
                n7 = ao.s();
                if (f == 0) {
                    break Label_1270;
                }
            }
            n7 = ao.k.b + this.r;
        }
        if (this.aP) {
            final double n = this.g.j(q);
            if (f == 0) {
                return new t(n, n7);
            }
        }
        if (ao.k.a < this.g.m(q)) {
            final double n = this.g.m(q);
            if (f == 0) {
                return new t(n, n7);
            }
        }
        double n = this.g.m(q) + this.g.p(q);
        return new t(n, n7);
    }
    
    private void a(final q q, final f f) {
        final int f2 = y.f.i.v.f;
        final e a = f.a();
        while (a.f()) {
            final d a2 = a.a();
            final ao ao = (ao)this.C.b(a2.a(q));
            this.s.a(a2);
            a.g();
            if (f2 != 0) {
                return;
            }
            if (f2 != 0) {
                break;
            }
        }
        if (q.a() > 0) {
            final e j = q.j();
            while (j.f()) {
                final d a3 = j.a();
                final ao ao2 = (ao)this.C.b(a3.a(q));
                this.s.a(a3);
                j.g();
                if (f2 != 0) {
                    break;
                }
            }
        }
    }
    
    private void a(final q q, final q q2, final f f) {
        final aJ aj = (aJ)this.z.b(q);
        this.a(aj.a, q2, f, null);
        this.a(aj.c, q2, f, null);
        this.a(aj.e, q2, f, null);
        this.a(aj.g, q2, f, null);
    }
    
    private void a(final D d, final q q, final f f, final ax ax) {
        final int f2 = y.f.i.v.f;
        if (d.size() == 0) {
            return;
        }
        Label_0148: {
            if (this.i) {
                final C m = d.m();
                while (m.f()) {
                    final ao ao = (ao)m.d();
                    if (ao != null && this.a(ao.t(), ao.u()) > 0) {
                        final d a = this.s.a(q, (q)this.B.b(ao));
                        f.add(a);
                        if (ax != null) {
                            this.aq.put(a, ax);
                        }
                    }
                    m.g();
                    if (f2 != 0) {
                        break Label_0148;
                    }
                }
                return;
            }
        }
        final double n = this.r + 1.0;
        final C i = d.m();
        while (i.f()) {
            final ao ao2 = (ao)i.d();
            if (ao2 != null) {
                if (ao2.n) {}
                if (ao2.p() >= n || ao2.n) {
                    final d a2 = this.s.a(q, (q)this.B.b(ao2));
                    f.add(a2);
                    if (ax != null) {
                        this.aq.put(a2, ax);
                    }
                }
            }
            i.g();
            if (f2 != 0) {
                break;
            }
        }
    }
    
    private D a(final f f, final q q) {
        final int f2 = y.f.i.v.f;
        final D d = new D();
        q q2 = q;
        final e a = f.a();
        while (a.f()) {
            final q a2 = a.a().a(q2);
            final ao ao = (ao)this.C.b(a2);
            if (ao == null) {
                break;
            }
            d.add(ao);
            q2 = a2;
            a.g();
            if (f2 != 0) {
                break;
            }
        }
        return d;
    }
    
    private f[] Q() {
        final int f = y.f.i.v.f;
        final h b = y.g.M.b(new boolean[this.g.g()]);
        this.a(b);
        final f[] array = { new f(), new f() };
        final e p = this.g.p();
        while (p.f()) {
            Label_0112: {
                if (b.d(p.a())) {
                    array[0].add(p.a());
                    if (f == 0) {
                        break Label_0112;
                    }
                }
                array[1].add(p.a());
            }
            p.g();
            if (f != 0) {
                break;
            }
        }
        return array;
    }
    
    private void R() {
        final int i = y.f.i.v.f;
        final av h = this.H();
        this.U = new al();
        h.g();
        this.U.b();
        final D a = h.a();
        final D b = h.b();
        final c e = h.e();
        this.y = h.c();
        this.z = h.d();
        if (this.H) {
            System.out.print(h.f());
        }
        this.Q = new al();
        if (this.C != null && this.s != null) {
            this.s.a(this.C);
        }
        this.s = new i();
        this.C = this.s.t();
        this.B = new aF();
        this.Q.b();
        this.R = new al();
        int n = 0;
        final C m = b.m();
        while (true) {
            while (m.f()) {
                ++n;
                final ao ao = (ao)m.d();
                final byte h2 = this.h;
                if (i != 0) {
                    int n2 = h2;
                    final C j = a.m();
                    while (true) {
                        do {
                            double f = 0.0;
                            Label_0305: {
                                f = (j.f() ? 1 : 0);
                            }
                            Label_0312:
                            while (f != 0) {
                                ++n2;
                                final ao ao2 = (ao)j.d();
                                final byte h3 = this.h;
                                if (i == 0) {
                                    Label_0649: {
                                        Label_0643: {
                                            if (h3 == 0 || this.f(ao2)) {
                                                if (ao2.t() == ao2.u()) {
                                                    break Label_0649;
                                                }
                                                final q d = this.s.d();
                                                this.B.a(ao2, d);
                                                this.C.a(d, ao2);
                                                final Rectangle2D.Double double1 = new Rectangle2D.Double(ao2.k.a, ao2.k.b, ao2.l.a - ao2.k.a, ao2.l.b - ao2.k.b);
                                                final C k = ((D)e.b(ao2)).m();
                                                while (k.f()) {
                                                    final ao ao3 = (ao)k.d();
                                                    final double n3 = f = dcmpl(ao3.t(), ao3.u());
                                                    if (i != 0) {
                                                        continue Label_0312;
                                                    }
                                                    if (n3 != 0) {
                                                        final Rectangle2D.Double double2 = new Rectangle2D.Double(ao3.k.a, ao3.k.b, ao3.l.a - ao3.k.a, ao3.l.b - ao3.k.b);
                                                        if (this.B.b(ao3) != null && double1.intersects(double2)) {
                                                            this.s.a(d, (q)this.B.b(ao3));
                                                        }
                                                    }
                                                    k.g();
                                                    if (i != 0) {
                                                        break Label_0643;
                                                    }
                                                }
                                                break Label_0649;
                                            }
                                        }
                                        this.h(ao2);
                                    }
                                    j.g();
                                    continue Label_0305;
                                }
                                if (h3 != 0) {
                                    this.e = this.s.t();
                                    this.d = new aQ(this.s);
                                }
                                return;
                            }
                            break;
                        } while (i == 0);
                        this.R.b();
                        this.L = this.s.f();
                        this.M = this.s.h();
                        this.aJ = new P(this.s.t(), 0);
                        this.aI = this.s.t();
                        this.aH = this.s.t();
                        this.aL = new N(this.s.t(), 0.0);
                        this.aK = new N(this.s.t(), 0.0);
                        this.aM = new N(this.s.u(), 0.0);
                        this.A = new N(this.s.u(), 0.0);
                        this.m();
                        continue;
                    }
                }
                Label_0284: {
                    if (h2 == 0 || this.f(ao)) {
                        if (ao.t() == ao.u()) {
                            break Label_0284;
                        }
                        final q d2 = this.s.d();
                        this.B.a(ao, d2);
                        this.C.a(d2, ao);
                        if (i == 0) {
                            break Label_0284;
                        }
                    }
                    this.h(ao);
                }
                m.g();
                if (i != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    private boolean f(final ao ao) {
        boolean g = true;
        if (ao.y()) {
            g = this.g(ao);
        }
        return g;
    }
    
    private boolean g(final ao ao) {
        final int f = y.f.i.v.f;
        boolean b = false;
        final aJ aj = (aJ)this.y.b(ao);
        boolean b2 = false;
        Label_0244: {
            if (ao.x()) {
                C c = aj.a.m();
                while (true) {
                    while (c.f()) {
                        b |= this.a((q)c.d(), ao);
                        c.g();
                        if (f != 0) {
                            while (true) {
                                while (c.f()) {
                                    b |= this.a((q)c.d(), ao);
                                    c.g();
                                    if (f != 0) {
                                        while (true) {
                                            while (c.f()) {
                                                b |= this.a((q)c.d(), ao);
                                                c.g();
                                                if (f != 0) {
                                                    while (c.f()) {
                                                        b2 = (b | this.a((q)c.d(), ao));
                                                        if (f != 0) {
                                                            break;
                                                        }
                                                        b = b2;
                                                        c.g();
                                                        if (f != 0) {
                                                            break Label_0244;
                                                        }
                                                    }
                                                    return b2;
                                                }
                                                if (f != 0) {
                                                    break;
                                                }
                                            }
                                            c = aj.d.m();
                                            continue;
                                        }
                                    }
                                    if (f != 0) {
                                        break;
                                    }
                                }
                                c = aj.b.m();
                                continue;
                            }
                        }
                        if (f != 0) {
                            break;
                        }
                    }
                    c = aj.c.m();
                    continue;
                }
            }
        }
        C c2 = aj.e.m();
        while (true) {
            while (c2.f()) {
                b |= this.a((q)c2.d(), ao);
                c2.g();
                if (f != 0) {
                    while (true) {
                        while (c2.f()) {
                            b |= this.a((q)c2.d(), ao);
                            c2.g();
                            if (f != 0) {
                                while (true) {
                                    while (c2.f()) {
                                        b |= this.a((q)c2.d(), ao);
                                        c2.g();
                                        if (f != 0) {
                                            while (c2.f()) {
                                                final boolean b3 = b | this.a((q)c2.d(), ao);
                                                if (f != 0) {
                                                    break;
                                                }
                                                b = b3;
                                                c2.g();
                                                if (f != 0) {
                                                    break;
                                                }
                                            }
                                            return b2;
                                        }
                                        if (f != 0) {
                                            break;
                                        }
                                    }
                                    c2 = aj.h.m();
                                    continue;
                                }
                            }
                            if (f != 0) {
                                break;
                            }
                        }
                        c2 = aj.f.m();
                        continue;
                    }
                }
                if (f != 0) {
                    break;
                }
            }
            c2 = aj.g.m();
            continue;
        }
    }
    
    private boolean a(final q q, final ao ao) {
        final int f = y.f.i.v.f;
        boolean b = false;
        final double t = ao.t();
        final double u = ao.u();
        final c c = this.g.c(this.b());
        final c c2 = this.g.c(this.c());
        byte b2 = 0;
        Label_0104: {
            if (ao.x()) {
                b2 = (byte)((ao.s() < this.g.k(q)) ? 1 : 2);
                if (f == 0) {
                    break Label_0104;
                }
            }
            b2 = (byte)((ao.r() < this.g.j(q)) ? 8 : 4);
        }
        e e = q.k();
        while (true) {
            while (e.f()) {
                d d = e.a();
                final byte h = this.h;
                final byte b3 = 2;
                if (f != 0) {
                    while (true) {
                        if (h != b3 || c2.d(d)) {
                            if (this.h != 4 || c.d(q) || c.d(d.a(q))) {
                                final aE d2 = y.f.aE.d(this.g, d);
                                if (d2 != null && d2.a() && d2.b() == b2) {
                                    final double n = ao.x() ? this.g.p(d).a : this.g.p(d).b;
                                    b |= (t <= n && u >= n);
                                }
                                if (d2 == null) {
                                    final ax b4 = this.b(y.f.i.ad.a(this.g, d, true));
                                    if (b4 != null && b4.b() && b4.a() == (b2 & 0xF)) {
                                        final double n2 = ao.x() ? this.g.p(d).a : this.g.p(d).b;
                                        b |= (t <= n2 && u >= n2);
                                    }
                                }
                            }
                        }
                        e.g();
                        if (f == 0) {
                            if (e.f()) {
                                d = e.a();
                                final byte h2;
                                final byte b5 = h2 = this.h;
                                if (f == 0) {
                                    continue;
                                }
                                return b5 != 0;
                            }
                        }
                        break;
                    }
                    final byte b5 = (byte)(b ? 1 : 0);
                    return b5 != 0;
                }
                if (h != b3 || c2.d(d)) {
                    if (this.h != 4 || c.d(q) || c.d(d.a(q))) {
                        final aE e2 = y.f.aE.e(this.g, d);
                        if (e2 != null && e2.a() && e2.b() == b2) {
                            final double n3 = ao.x() ? this.g.q(d).a : this.g.q(d).b;
                            b |= (t <= n3 && u >= n3);
                        }
                        if (e2 == null) {
                            final ax b6 = this.b(y.f.i.ad.a(this.g, d, false));
                            if (b6 != null && b6.b() && b6.a() == (b2 & 0xF)) {
                                final double n4 = ao.x() ? this.g.q(d).a : this.g.q(d).b;
                                b |= (t <= n4 && u >= n4);
                            }
                        }
                    }
                }
                e.g();
                if (f != 0) {
                    break;
                }
            }
            e = q.l();
            continue;
        }
    }
    
    private ax b(final Collection collection) {
        final int f = y.f.i.v.f;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ax ax = null;
        ax ax3 = null;
        for (final ax ax2 : collection) {
            if (ax == null) {
                ax = ax2;
            }
            if (!ax2.b()) {
                ax3 = ax2;
                if (f == 0) {
                    ax = ax3;
                    break;
                }
                return ax3;
            }
        }
        return ax3;
    }
    
    private void h(final ao ao) {
        final int f = y.f.i.v.f;
        final aJ aj = (aJ)this.y.b(ao);
        Label_0116: {
            if (ao.x()) {
                this.a(aj.a, ao, (byte)2);
                this.a(aj.b, ao, (byte)20);
                this.a(aj.c, ao, (byte)1);
                this.a(aj.d, ao, (byte)10);
                if (f == 0) {
                    break Label_0116;
                }
            }
            this.a(aj.e, ao, (byte)4);
            this.a(aj.f, ao, (byte)40);
            this.a(aj.g, ao, (byte)8);
            this.a(aj.h, ao, (byte)80);
        }
        final y.f.i.al al = (y.f.i.al)ao;
        C c = al.b.m();
        while (true) {
            while (c.f()) {
                ((y.f.i.al)c.d()).b(false, al);
                c.g();
                if (f != 0) {
                    while (c.f()) {
                        ((y.f.i.al)c.d()).b(true, al);
                        c.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            c = al.c.m();
            continue;
        }
    }
    
    private String S() {
        final int f = y.f.i.v.f;
        String s = "" + "\n===Orthogonal Edge Router===\n" + "Chosen style is ";
        Label_0138: {
            switch (this.h) {
                case 0: {
                    s += "ROUTE_ALL_EDGES";
                    if (f != 0) {
                        break Label_0138;
                    }
                    break;
                }
                case 2: {
                    s += "ROUTE_SELECTED_EDGES";
                    if (f != 0) {
                        break Label_0138;
                    }
                    break;
                }
                case 4: {
                    s += "ROUTE_EDGES_AT_SELECTED_NODES";
                    break;
                }
            }
        }
        if (this.i) {
            s = s + "; Grid Width = " + this.o + "\n";
            if (f == 0) {
                return s + "Number of edges routed = " + this.J + "\n" + "Number of bad edges = " + this.K + "\n" + "Total routing time = " + this.P + "\n" + "Time for all edges = " + this.V + "\n" + "Number of Dijkstra runs = " + this.I + "\n" + "Time for Dijkstra runs = " + this.W + "\n" + "RIG initially = " + this.L + " nodes, " + this.M + " edges\n" + "RIG finally = " + this.N + " nodes, " + this.O + " edges\n" + "Time for preparing the RIG = " + this.Q + "\n" + "Time for building the RIG = " + this.R + "\n" + "Time for decorating the RIG = " + this.S + "\n" + "Time for instantiating the sweepline " + "= " + this.T + "\n" + "Time for running the sweepline = " + this.U + "\n" + "===Orthogonal Edge Router===\n";
            }
        }
        s = s + "; Minimum Distance = " + this.q + "\n";
        return s + "Number of edges routed = " + this.J + "\n" + "Number of bad edges = " + this.K + "\n" + "Total routing time = " + this.P + "\n" + "Time for all edges = " + this.V + "\n" + "Number of Dijkstra runs = " + this.I + "\n" + "Time for Dijkstra runs = " + this.W + "\n" + "RIG initially = " + this.L + " nodes, " + this.M + " edges\n" + "RIG finally = " + this.N + " nodes, " + this.O + " edges\n" + "Time for preparing the RIG = " + this.Q + "\n" + "Time for building the RIG = " + this.R + "\n" + "Time for decorating the RIG = " + this.S + "\n" + "Time for instantiating the sweepline " + "= " + this.T + "\n" + "Time for running the sweepline = " + this.U + "\n" + "===Orthogonal Edge Router===\n";
    }
    
    public void b(final byte h) {
        switch (h) {
            case 0:
            case 2:
            case 4: {
                this.h = h;
                if (y.f.i.v.f != 0) {
                    break;
                }
                return;
            }
        }
        throw new IllegalArgumentException("Argument '" + h + "' not allowed.");
    }
    
    public byte p() {
        return this.h;
    }
    
    public void d(final boolean i) {
        this.i = i;
    }
    
    public boolean q() {
        return this.i;
    }
    
    public void a(final int n, final int n2) {
        this.n = new t(n, n2);
    }
    
    public t r() {
        return this.n;
    }
    
    public void b(final int n) {
        if (Math.abs(n) >= 2) {
            this.o = Math.abs(n);
            this.p = this.o;
        }
    }
    
    public int s() {
        return this.o;
    }
    
    public void c(final int n) {
        if (Math.abs(n) >= 4) {
            this.q = Math.abs(0.5 * n);
            this.r = this.q;
        }
    }
    
    public int t() {
        return (int)(this.q * 2.0);
    }
    
    public void e(final boolean b) {
        this.ac = !b;
    }
    
    public boolean u() {
        return !this.ac;
    }
    
    public void d(final int ad) {
        if (Math.abs(ad) >= 2) {
            this.ad = ad;
        }
    }
    
    public int v() {
        return this.ad;
    }
    
    public void f(final boolean ao) {
        this.aO = ao;
    }
    
    public boolean w() {
        return this.aO;
    }
    
    public void b(double aj) {
        if (aj < 0.0) {
            aj = 0.0;
        }
        if (aj > 1.0) {
            aj = 1.0;
        }
        this.aj = aj;
    }
    
    public double x() {
        return this.aj;
    }
    
    public void c(final byte ak) {
        this.ak = ak;
        this.al = (3 == ak);
        this.an = (2 == ak);
        this.ao = (1 == ak);
    }
    
    public byte y() {
        return this.ak;
    }
    
    public void g(final boolean ab) {
        this.ab = ab;
    }
    
    public boolean z() {
        return this.ab;
    }
    
    public void h(final boolean ae) {
        this.ae = ae;
    }
    
    public boolean A() {
        return this.ae;
    }
    
    public void e(final int n) {
        this.af = Math.abs(n);
    }
    
    public int B() {
        return this.af;
    }
    
    public void i(final boolean ap) {
        this.aP = ap;
    }
    
    public boolean C() {
        return this.aP;
    }
    
    boolean b(final q q) {
        final c c = this.g.c(y.f.i.i.a);
        return c != null && c.b(q) != null;
    }
    
    boolean c(final q q) {
        final c c = this.g.c(y.f.i.i.a);
        return c != null && y.f.i.i.b.equals(c.b(q));
    }
    
    boolean d(final q q) {
        final c c = this.g.c(y.f.i.i.a);
        return c != null && y.f.i.i.c.equals(c.b(q));
    }
    
    static boolean a(final v v, final d d, final boolean b) {
        return v.a(d, b);
    }
    
    static A a(final v v) {
        return v.C;
    }
    
    static q b(final v v) {
        return v.u;
    }
    
    static q c(final v v) {
        return v.v;
    }
    
    static X d(final v v) {
        return v.g;
    }
}
