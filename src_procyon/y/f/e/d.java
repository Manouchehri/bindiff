package y.f.e;

import y.g.*;
import y.a.*;
import java.util.*;
import y.d.*;
import y.f.b.*;
import y.f.*;
import y.c.*;

public class d extends c
{
    public static final Object n;
    public static final Object o;
    private byte q;
    public static final Object p;
    private byte r;
    private double s;
    private double t;
    private double u;
    private double v;
    private double w;
    private double x;
    private h y;
    private double z;
    private double A;
    private boolean B;
    private int C;
    private X D;
    private g[] E;
    private int F;
    private g[] G;
    private ar H;
    private boolean I;
    private long J;
    private double K;
    private double L;
    private al M;
    private double N;
    private double O;
    private double[] P;
    private double[] Q;
    private boolean R;
    private boolean S;
    private byte T;
    private byte U;
    private int V;
    private y.f.b.c W;
    private List X;
    private List Y;
    private Map Z;
    private byte[] aa;
    private double ab;
    private double ac;
    private int ad;
    private int ae;
    private int af;
    private a ag;
    private double ah;
    private int[] ai;
    private byte aj;
    
    public d() {
        this.q = 1;
        this.r = 0;
        this.s = 0.65;
        this.t = Math.max(0.1, 1.0);
        this.v = 80.0;
        this.A = 3.0;
        this.B = true;
        this.I = true;
        this.J = 30000L;
        this.K = 0.0;
        this.R = false;
        this.S = false;
        this.T = 1;
        this.U = 1;
        this.V = 1000;
        this.ad = 1;
        this.ae = 1;
        this.af = 1;
        this.ag = new y.f.b.h();
        this.ah = 0.2;
        super.a(new f(this, null));
        this.d(false);
        ((aN)this.c()).a((byte)1);
    }
    
    public void a(final int n) {
        if (n > 2 || n < 0) {
            throw new IllegalArgumentException("Repulsion must lie within [0,2]");
        }
        this.U = (byte)n;
    }
    
    public void b(final int n) {
        if (n > 2 || n < 0) {
            throw new IllegalArgumentException("Attraction must lie within [0,2]");
        }
        this.T = (byte)n;
    }
    
    public a a() {
        return this.ag;
    }
    
    public void a(final a ag) {
        this.ag = ag;
    }
    
    public double n() {
        return this.ah;
    }
    
    public void a(final double ah) {
        if (ah >= 0.0 && ah <= 1.0) {
            this.ah = ah;
            if (!y.f.e.i.b) {
                return;
            }
        }
        throw new IllegalArgumentException(ah + " not in [0,1]");
    }
    
    public byte o() {
        return this.aj;
    }
    
    public void b(final double t) {
        this.t = t;
    }
    
    public void g(final boolean s) {
        this.S = s;
    }
    
    public boolean p() {
        return this.S;
    }
    
    public void h(final boolean r) {
        this.R = r;
    }
    
    public boolean q() {
        return this.R;
    }
    
    public void c(final double k) {
        this.K = k;
    }
    
    public void b(final byte r) {
        this.r = r;
        if (this.r != 0) {
            this.c((byte)2);
        }
    }
    
    public byte r() {
        return this.r;
    }
    
    public void c(final byte q) {
        this.q = q;
    }
    
    public void a(final long j) {
        this.J = j;
    }
    
    public void d(final double a) {
        this.A = a;
    }
    
    public void c(final int n) {
        this.v = n;
    }
    
    public void i(final boolean b) {
        this.B = b;
    }
    
    public boolean b(final X x) {
        return true;
    }
    
    public void a(final X d) {
        final boolean b = y.f.e.i.b;
        if (d == null) {
            return;
        }
        this.D = d;
        final boolean b2 = y.f.b.c.b(d);
        C c = null;
        if (b2) {
            if (!this.d(d)) {
                return;
            }
        }
        else {
            c = new C(d);
            if (this.q()) {
                c.a();
            }
            if (!this.a(d, null)) {
                return;
            }
        }
        try {
            final h h = new h();
            long n = 0L;
            final long max = Math.max((long)(this.A * e(this.G.length) + 20 * this.G.length), 10000L);
            final double n2 = this.t * this.t * this.G.length;
            int n3 = this.V;
            try {
                while (this.w > n2 && n < max) {
                    final g d2 = this.d((int)(n & 0x7FFFFFFFL));
                    if (n3-- == 0) {
                        if (this.M.d() > this.J) {
                            n = max;
                        }
                        y.a.a.a();
                        n3 = this.V;
                    }
                    if (this.r != 1 || d2.m) {
                        this.f(d2, h);
                        this.e(d2, h);
                        this.d(d2, h);
                    }
                    Label_0299: {
                        if (this.I) {
                            this.a(d2, h);
                            this.b(d2, h);
                            if (!b) {
                                break Label_0299;
                            }
                        }
                        this.a(this.T, d2, h);
                        this.b(this.U, d2, h);
                    }
                    final double sqrt = Math.sqrt(h.a * h.a + h.b * h.b + h.c * h.c);
                    this.a(d2, h, sqrt);
                    this.b(d2, h, sqrt);
                    if (b2) {
                        this.b(d2);
                        this.a(d2);
                    }
                    ++n;
                    if (b) {
                        break;
                    }
                }
            }
            catch (y.a.a a) {}
            finally {
                this.u();
            }
        }
        finally {
            if (b2) {
                this.s();
                if (!b) {
                    return;
                }
            }
            if (this.q()) {
                c.b();
            }
        }
    }
    
    private boolean d(final X d) {
        final boolean b = y.f.e.i.b;
        this.D = d;
        if (d == null) {
            return false;
        }
        this.W = new y.f.b.c(d);
        this.X = new ArrayList(500);
        final y.c.c c = d.c(d.o);
        int[] array = null;
        if (this.r == 1) {
            array = new int[d.e()];
            y.a.b.a(d, d.c(d.n), y.g.M.a(array));
        }
        this.ai = new int[d.e()];
        final q b2 = this.W.b();
        if (c != null) {
            this.Z = new HashMap();
        }
        final x o = d.o();
    Label_0510:
        while (true) {
            do {
                o.f();
                boolean d2 = false;
            Label_0691_Outer:
                while (d2) {
                    final q e = o.e();
                    this.ai[e.d()] = -1;
                    q q = this.W.a(e);
                    if (!b) {
                        Label_0369: {
                            if (q != b2) {
                                if (c == null) {
                                    goto Label_0234;
                                }
                                boolean d3 = false;
                                Label_0236: {
                                    while (q != b2) {
                                        d3 = c.d(q);
                                        if (b || (d3 && !b)) {
                                            break Label_0236;
                                        }
                                        q = this.W.a(q);
                                        if (b) {
                                            goto Label_0234;
                                        }
                                    }
                                    goto Label_0234;
                                }
                                Label_0296: {
                                    if (!d3) {
                                        q = this.W.a(e);
                                        while (q != b2) {
                                            this.X.add(d.a(e, q));
                                            q = this.W.a(q);
                                            if (b) {
                                                continue Label_0510;
                                            }
                                            if (b) {
                                                break Label_0296;
                                            }
                                        }
                                        break Label_0369;
                                    }
                                }
                                q q2 = q;
                                q q3 = this.W.a(q);
                                while (q3 != b2) {
                                    d2 = c.d(q3);
                                    if (b) {
                                        continue Label_0691_Outer;
                                    }
                                    if (d2) {
                                        q2 = q3;
                                    }
                                    q3 = this.W.a(q3);
                                    if (b) {
                                        break;
                                    }
                                }
                                this.ai[e.d()] = q2.d();
                            }
                        }
                        o.g();
                        continue Label_0510;
                    }
                    final int n;
                    int i = n;
                    while (i < this.X.size()) {
                        final y.c.d d4 = this.X.get(i);
                        Label_0590: {
                            if (this.W.a(d4.c()) == d4.d()) {
                                this.aa[d4.b()] = 1;
                                if (!b) {
                                    break Label_0590;
                                }
                            }
                            this.aa[d4.b()] = 2;
                        }
                        ++i;
                        if (b) {
                            break;
                        }
                    }
                    final y.c.e p = d.p();
                    while (true) {
                        while (p.f()) {
                            final y.c.d a = p.a();
                            final int b3 = a.b();
                            final d d5 = this;
                            if (!b) {
                                Label_0678: {
                                    if (this.aa[b3] == 0) {
                                        if (this.W.a(a)) {
                                            this.aa[b3] = 0;
                                            if (!b) {
                                                break Label_0678;
                                            }
                                        }
                                        this.aa[b3] = 3;
                                    }
                                }
                                p.g();
                                if (b) {
                                    break;
                                }
                                continue Label_0691_Outer;
                            }
                            else {
                                final double n2 = d5.n();
                                double n3 = 0.0;
                                Label_0807: {
                                    if (n2 == 0.0) {
                                        this.ae = 0;
                                        this.ad = 2;
                                        this.af = 0;
                                        n3 = 0.001;
                                        if (!b) {
                                            break Label_0807;
                                        }
                                    }
                                    if (n2 < 0.1) {
                                        this.ae = 1;
                                        this.ad = 0;
                                        this.af = 0;
                                        n3 = 0.001 + 0.01 * n2;
                                        if (!b) {
                                            break Label_0807;
                                        }
                                    }
                                    this.ae = 1;
                                    this.ad = 0;
                                    this.af = 0;
                                    n3 = 0.011 + n2 * n2 * n2 * 10.0;
                                }
                                this.ab = Math.pow(this.v, -(this.ad + 1));
                                this.ac = n3 * Math.pow(this.v, -(this.af + 1));
                                if (!this.a(d, array)) {
                                    if (this.W != null) {
                                        this.W.c();
                                    }
                                    if (this.Y != null) {
                                        int j = 0;
                                        while (j < this.Y.size()) {
                                            d.e((y.c.d)this.Y.get(j));
                                            ++j;
                                            if (b) {
                                                return false;
                                            }
                                            if (b) {
                                                break;
                                            }
                                        }
                                        this.Y.clear();
                                    }
                                    return false;
                                }
                                final boolean[] array2 = new boolean[d.f()];
                                final x a2 = this.W.c(this.W.b()).a();
                                boolean d6 = false;
                                while (a2.f()) {
                                    final q e2 = a2.e();
                                    final g p2 = this.E[e2.d()];
                                    d6 = this.W.d(e2);
                                    if (b) {
                                        return d6;
                                    }
                                    Label_1304: {
                                        Label_1248: {
                                            if (d6) {
                                                Label_1189: {
                                                    if (c != null && c.d(e2)) {
                                                        this.Z.put(e2, d.o(e2));
                                                        p2.o = 3;
                                                        final y c2 = this.W.c(e2);
                                                        p2.s = c2;
                                                        if (!array2[e2.d()]) {
                                                            p p3 = c2.k();
                                                            while (p3 != null) {
                                                                final q q4 = (q)p3.c();
                                                                final g g = this.E[q4.d()];
                                                                g.p = p2;
                                                                array2[q4.d()] = true;
                                                                g.h = d.j(q4) - d.j(e2);
                                                                g.i = d.k(q4) - d.k(e2);
                                                                g.j = 0.0;
                                                                p3 = p3.a();
                                                                if (b) {
                                                                    break Label_1304;
                                                                }
                                                                if (b) {
                                                                    break Label_1189;
                                                                }
                                                            }
                                                        }
                                                        break Label_1248;
                                                    }
                                                }
                                                final y b4 = this.W.b(e2);
                                                if (b4 == null || b4.size() == 0) {
                                                    p2.o = 0;
                                                    if (!b) {
                                                        break Label_1248;
                                                    }
                                                }
                                                p2.o = 1;
                                                p2.s = b4;
                                                if (!b) {
                                                    break Label_1248;
                                                }
                                            }
                                            p2.o = 0;
                                        }
                                        if (p2.p == null && this.W.a(e2) != this.W.b()) {
                                            p2.p = this.E[this.W.a(e2).d()];
                                        }
                                        a2.g();
                                    }
                                    if (b) {
                                        break;
                                    }
                                }
                                this.a(this.W, this.W.b());
                                return d6;
                            }
                        }
                        final d d5 = this;
                        continue;
                    }
                }
                break;
            } while (!b);
            if (c != null) {
                this.Y = new ArrayList(32);
                final y.c.e p4 = d.p();
                while (p4.f()) {
                    final y.c.d a3 = p4.a();
                    p4.g();
                    final int n4 = this.ai[a3.c().d()];
                    if (n4 >= 0) {
                        final int n = this.ai[a3.d().d()];
                        if (b) {
                            continue Label_0510;
                        }
                        if (n != n4) {
                            continue;
                        }
                        d.d(a3);
                        this.Y.add(a3);
                        if (b) {
                            break;
                        }
                        continue;
                    }
                }
            }
            this.aa = new byte[d.g()];
            continue Label_0510;
        }
    }
    
    private double a(final y.f.b.c c, final q q) {
        final boolean b = y.f.e.i.b;
        final y b2 = c.b(q);
        double n = 0.0;
        p p2 = b2.k();
        while (p2 != null) {
            final q q2 = (q)p2.c();
            final g g = this.E[q2.d()];
            double n2 = 0.0;
            Label_0120: {
                if (c.d(q2) && !c.b(q2).isEmpty() && g.o != 3) {
                    n2 = this.a(c, q2);
                    g.r = n2;
                    g.k = n2;
                    if (!b) {
                        break Label_0120;
                    }
                }
                n2 = this.E[q2.d()].k;
            }
            n += n2 * n2 * 3.0;
            p2 = p2.a();
            if (b) {
                break;
            }
        }
        return Math.sqrt(e(Math.sqrt(n / (b2.size() + 1)) + this.v * 0.9) * b2.size()) * 0.5 + this.v;
    }
    
    private void s() {
        final boolean b = y.f.e.i.b;
        Label_0320: {
            Label_0282: {
                int f = 0;
                Label_0081: {
                    if (this.X != null) {
                        int i = 0;
                        while (i < this.X.size()) {
                            final y.c.d d = this.X.get(i);
                            final int n = f = (this.D.f(d) ? 1 : 0);
                            if (b) {
                                break Label_0081;
                            }
                            if (n != 0) {
                                this.D.a(d);
                            }
                            ++i;
                            if (b) {
                                break;
                            }
                        }
                    }
                    if (this.Y == null) {
                        break Label_0282;
                    }
                    f = 0;
                }
                int j = f;
                while (j < this.Y.size()) {
                    final y.c.d d2 = this.Y.get(j);
                    this.D.e(d2);
                    final I b2 = this.D.b((Object)d2);
                    if (b) {
                        break Label_0320;
                    }
                    Label_0277: {
                        if (b2.pointCount() > 0) {
                            final q a = this.E[d2.c().d()].p.a;
                            final t o = this.D.o(a);
                            final t t = this.Z.get(a);
                            final double n2 = o.a - t.a;
                            final double n3 = o.b - t.b;
                            int k = 0;
                            while (k < b2.pointCount()) {
                                final t point = b2.getPoint(k);
                                b2.setPoint(k, point.a + n2, point.b + n3);
                                ++k;
                                if (b) {
                                    break Label_0277;
                                }
                                if (b) {
                                    break;
                                }
                            }
                        }
                        ++j;
                    }
                    if (b) {
                        break;
                    }
                }
            }
            new j(null, new e(this)).c(this.D);
            this.X = null;
            this.ai = null;
            this.aa = null;
        }
        if (this.W != null) {
            this.W.c();
            this.W = null;
        }
        this.Y = null;
    }
    
    private boolean a(final X d, int[] array) {
        final boolean b = y.f.e.i.b;
        if (d == null || d.e() < 1) {
            return false;
        }
        this.D = d;
        this.C = 1;
        this.M = new al();
        this.F = d.f();
        this.u = e(this.v);
        this.E = new g[this.F];
        this.V = 1 + 100000 / this.F;
        this.L = this.K / (this.v * 6.0);
        this.N = Math.pow(this.v, -(this.T + 1));
        this.O = Math.pow(this.v, this.U + 1);
        this.w = 0.0;
        this.x = 0.0;
        this.y = new h();
        this.z = Math.max(20.0 * this.v, 10.0);
        Label_0214: {
            if (this.p()) {
                this.H = new ar(666L);
                if (!b) {
                    break Label_0214;
                }
            }
            this.H = new ar();
        }
        double n = 0.0;
        Label_0277: {
            if (this.q == 2) {
                n = Math.max(0.1, Math.min(this.s * this.v * 0.75, this.z));
                if (!b) {
                    break Label_0277;
                }
            }
            n = Math.max(0.1, Math.min(this.s * this.v, this.z));
        }
        final y.c.c c = d.c(d.n);
        if (this.r() != 0 && c == null) {
            throw new IllegalStateException("No DataProvider that specifies which nodes are to be laid out.");
        }
        if (array == null && this.r == 1) {
            array = new int[this.F];
            y.a.b.a(d, c, y.g.M.a(array));
        }
        int f = this.F;
        int n2 = 0;
        byte b3 = 0;
        Label_1621: {
            Label_1476: {
            Label_1346:
                while (true) {
                    d d2 = null;
                    Label_0822: {
                        Label_0663: {
                            switch (this.r()) {
                                case 0: {
                                    y.f.ae.a(d);
                                    if (this.ai != null) {
                                        int i = 0;
                                        while (i < this.ai.length) {
                                            final int n3 = this.ai[i];
                                            if (b) {
                                                break Label_1346;
                                            }
                                            if (n3 >= 0) {
                                                --f;
                                            }
                                            ++i;
                                            if (b) {
                                                break Label_0663;
                                            }
                                        }
                                        break;
                                    }
                                    break;
                                }
                                case 1: {
                                    final boolean[] array2 = new boolean[d.e()];
                                    f = 0;
                                    final x o = d.o();
                                    while (o.f()) {
                                        final q e = o.e();
                                        d2 = this;
                                        if (b) {
                                            break Label_0822;
                                        }
                                        if (this.ai == null || this.ai[e.d()] < 0) {
                                            if (c.d(e)) {
                                                ++n2;
                                                array2[e.d()] = true;
                                            }
                                            if (c.d(e) || (array[e.d()] < 5 && array[e.d()] >= 0)) {
                                                ++f;
                                                array2[e.d()] = true;
                                            }
                                        }
                                        o.g();
                                        if (b) {
                                            break;
                                        }
                                    }
                                    if (n2 < 1) {
                                        return false;
                                    }
                                    final y.c.e p2 = d.p();
                                    while (p2.f()) {
                                        final y.c.d a = p2.a();
                                        final boolean b2 = (b3 = (byte)(array2[a.c().d()] ? 1 : 0)) != 0;
                                        if (b) {
                                            break Label_1621;
                                        }
                                        if (b2 || array2[a.d().d()]) {
                                            y.f.ae.a(d, a);
                                        }
                                        p2.g();
                                        if (b) {
                                            break Label_0663;
                                        }
                                    }
                                    break;
                                }
                                case 2: {
                                    f = 0;
                                    final y.c.e p3 = d.p();
                                    while (p3.f()) {
                                        final y.c.d a2 = p3.a();
                                        final boolean b4 = (b3 = (byte)(c.d(a2.c()) ? 1 : 0)) != 0;
                                        if (b) {
                                            break Label_1621;
                                        }
                                        if (b4 || c.d(a2.d())) {
                                            y.f.ae.a(d, a2);
                                        }
                                        p3.g();
                                        if (b) {
                                            break;
                                        }
                                    }
                                    final x o2 = d.o();
                                    while (o2.f()) {
                                        final q e2 = o2.e();
                                        final boolean b5 = (b3 = (byte)(c.d(e2) ? 1 : 0)) != 0;
                                        if (b) {
                                            break Label_1621;
                                        }
                                        if (b5 && (this.ai == null || this.ai[e2.d()] < 0)) {
                                            ++f;
                                        }
                                        o2.g();
                                        if (b) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        d2 = this;
                    }
                    d2.G = new g[f];
                    final x o3 = d.o();
                    int i;
                    while (true) {
                        while (o3.f()) {
                            final q e3 = o3.e();
                            final byte r = this.r;
                            if (b) {
                                i = r;
                                break Label_1346;
                            }
                            g g = null;
                            Label_1199: {
                                switch (r) {
                                    default: {
                                        g = new g(e3, n, true, this.v, this.F, this.H, d, this.q);
                                        if (this.ai == null || this.ai[e3.d()] < 0) {
                                            this.G[--f] = g;
                                            if (!b) {
                                                break;
                                            }
                                        }
                                        g.g = 0.0;
                                        g.j = 0.0;
                                        if (b) {
                                            break Label_1199;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        if (c.d(e3)) {
                                            g = new g(e3, n, true, this.v, this.F, this.H, d, this.q);
                                            if (this.ai == null || this.ai[e3.d()] < 0) {
                                                this.G[--f] = g;
                                                if (!b) {
                                                    break;
                                                }
                                            }
                                            g.g = 0.0;
                                            if (!b) {
                                                break;
                                            }
                                        }
                                        g = new g(e3, n / (array[e3.d()] + 2), false, this.v, this.F, this.H, d, this.q);
                                        g.n = array[e3.d()];
                                        if (this.ai == null || this.ai[e3.d()] < 0) {
                                            if (array[e3.d()] < 5 && array[e3.d()] >= 0) {
                                                this.G[--f] = g;
                                                if (!b) {
                                                    break;
                                                }
                                            }
                                            g.g = 0.0;
                                            if (!b) {
                                                break;
                                            }
                                        }
                                        g.g = 0.0;
                                        if (b) {
                                            break Label_1199;
                                        }
                                        break;
                                    }
                                    case 2: {
                                        if (c.d(e3)) {
                                            g = new g(e3, n, true, this.v, this.F, this.H, d, this.q);
                                            if (this.ai == null || this.ai[e3.d()] < 0) {
                                                this.G[--f] = g;
                                                if (!b) {
                                                    break;
                                                }
                                            }
                                            g.g = 0.0;
                                            if (!b) {
                                                break;
                                            }
                                        }
                                        g = new g(e3, 0.0, false, this.v, this.F, this.H, d, this.q);
                                        break;
                                    }
                                }
                            }
                            this.E[e3.d()] = g;
                            o3.g();
                            if (b) {
                                break;
                            }
                        }
                        continue;
                    }
                    int n3 = 0;
                    if (n3 < this.G.length) {
                        final g g2 = this.G[i];
                        this.w += g2.g;
                        this.x += e(g2.g);
                        final h y = this.y;
                        y.a += g2.h;
                        final h y2 = this.y;
                        y2.b += g2.i;
                        final h y3 = this.y;
                        y3.c += g2.j;
                        ++i;
                        if (b) {
                            break Label_1476;
                        }
                        if (!b) {
                            continue Label_1346;
                        }
                    }
                    break;
                }
                if (f > 0) {
                    throw new RuntimeException("Unexpected number of nodes allocated!");
                }
            }
            if (d.c(d.p) != null || this.r == 1) {
                this.I = true;
                this.P = new double[d.g()];
                this.Q = new double[d.g()];
                final y.c.e p4 = d.p();
                while (p4.f()) {
                    final y.c.d a3 = p4.a();
                    final double a4 = this.a(a3);
                    this.P[a3.b()] = Math.pow(a4, -(this.T + 1));
                    this.Q[a3.b()] = Math.pow(a4, this.U + 1);
                    p4.g();
                    if (!b) {
                        continue;
                    }
                    return this.G.length > 0;
                }
            }
            else {
                this.I = false;
            }
            b3 = this.r();
        }
        if (b3 != 0) {
            this.t();
        }
        return this.G.length > 0;
    }
    
    private void t() {
        final boolean b = y.f.e.i.b;
        final D d = new D();
        final A t = this.D.t();
        final Object o = new Object();
        final Object o2 = new Object();
        final y.c.c c = this.D.c(y.f.e.d.n);
        final x o3 = this.D.o();
        while (true) {
            do {
                Label_0059: {
                    o3.f();
                }
                boolean d2 = false;
                Label_0066:
                while (d2) {
                    final q e = o3.e();
                    final boolean d3 = c.d(e);
                    if (!b) {
                        if (d3) {
                            final x m = e.m();
                            while (m.f()) {
                                final q e2 = m.e();
                                d2 = c.d(e2);
                                if (b) {
                                    continue Label_0066;
                                }
                                if (d2 && t.b(e2) == null) {
                                    t.a(e2, o);
                                    d.b(e2);
                                }
                                m.g();
                                if (b) {
                                    break;
                                }
                            }
                        }
                        o3.g();
                        continue Label_0059;
                    }
                    if (!d3) {
                        d.g();
                        q q;
                        int n;
                        int n2;
                        int n3;
                        Label_0200:
                        while (true) {
                            Object b2 = null;
                            q = (q)b2;
                            n = 0;
                            n2 = 0;
                            n3 = 0;
                            if (!b) {
                                final x i = q.m();
                                while (i.f()) {
                                    final q e3 = i.e();
                                    b2 = t.b(e3);
                                    if (b) {
                                        continue Label_0200;
                                    }
                                    if (b2 == null && c.d(e3)) {
                                        t.a(e3, o);
                                        d.b(e3);
                                    }
                                    if (c.d(e3) || t.b(e3) == o2) {
                                        n2 += (int)this.E[e3.d()].h;
                                        n3 += (int)this.E[e3.d()].i;
                                        ++n;
                                    }
                                    i.g();
                                    if (b) {
                                        break;
                                    }
                                }
                                break;
                            }
                            return;
                        }
                        if (n > 0) {
                            this.E[q.d()].h = n2 / n;
                            this.E[q.d()].i = n3 / n;
                        }
                        t.a(q, o2);
                        if (!b) {
                            break;
                        }
                    }
                    this.D.a(t);
                    return;
                }
                break;
            } while (!b);
            d.isEmpty();
            continue;
        }
    }
    
    private g d(final int n) {
        final int length = this.G.length;
        final int n2 = length - n % length - 1;
        final int nextInt = this.H.nextInt(n2 + 1);
        final g g = this.G[nextInt];
        this.G[nextInt] = this.G[n2];
        return this.G[n2] = g;
    }
    
    private void a(final g g, final h h) {
        final boolean b = y.f.e.i.b;
        g.a.d();
        double n3;
        double n2;
        double n = n2 = (n3 = 0.0);
        ++this.C;
        g.f = this.C;
        double n4 = 0.0;
        Label_0086: {
            if (g.s != null && g.r > 0.0) {
                n4 = Math.pow(g.q / g.r, 3.0) * this.ac;
                if (!b) {
                    break Label_0086;
                }
            }
            n4 = 0.0;
        }
        final boolean b2 = this.aa == null;
        g p3 = null;
        Label_0883: {
            if (g.o == 3) {
                p p2 = this.W.f(g.a).k();
                while (p2 != null) {
                    final y.c.d d = (y.c.d)p2.c();
                    final g g2 = this.E[d.c().d()];
                    final g g3 = this.E[d.d().d()];
                    g3.f = this.C;
                    p3 = g2.p;
                    if (b) {
                        break Label_0883;
                    }
                    double n5 = 0.0;
                    double n6 = 0.0;
                    double n7 = 0.0;
                    Label_0343: {
                        if (p3 != null && g2.p.o == 3) {
                            n5 = g2.p.h + g2.h - (g.h + g3.h);
                            n6 = g2.p.i + g2.i - (g.i + g3.i);
                            n7 = g2.p.j + g2.j - (g.j + g3.j);
                            if (!b) {
                                break Label_0343;
                            }
                        }
                        n5 = g2.h - (g.h + g3.h);
                        n6 = g2.i - (g.i + g3.i);
                        n7 = g2.j - (g.j + g3.j);
                    }
                    final double n8 = n5 * n5 + n6 * n6 + n7 * n7;
                    Label_0483: {
                        double n10 = 0.0;
                        Label_0453: {
                            if (this.B) {
                                final double sqrt = Math.sqrt(n8);
                                final double n9 = sqrt - (g2.k + g3.k);
                                if (n9 <= 0.0) {
                                    break Label_0483;
                                }
                                n10 = this.ab * Math.pow(n9, this.ad + 1) / sqrt;
                                if (!b) {
                                    break Label_0453;
                                }
                            }
                            n10 = this.ab * Math.pow(n8, this.ad * 0.5);
                        }
                        n2 += n5 * n10;
                        n += n6 * n10;
                        n3 += n7 * n10;
                    }
                    p2 = p2.a();
                    if (b) {
                        break;
                    }
                }
                p p4 = this.W.g(g.a).k();
                while (p4 != null) {
                    final y.c.d d2 = (y.c.d)p4.c();
                    final g g4 = this.E[d2.d().d()];
                    final g g5 = this.E[d2.c().d()];
                    g5.f = this.C;
                    final g p5 = g4.p;
                    if (b) {
                        break;
                    }
                    double n11 = 0.0;
                    double n12 = 0.0;
                    double n13 = 0.0;
                    Label_0730: {
                        if (p5 != null && g4.p.o == 3) {
                            n11 = g4.p.h + g4.h - (g.h + g5.h);
                            n12 = g4.p.i + g4.i - (g.i + g5.i);
                            n13 = g4.p.j + g4.j - (g.j + g5.j);
                            if (!b) {
                                break Label_0730;
                            }
                        }
                        n11 = g4.h - (g.h + g5.h);
                        n12 = g4.i - (g.i + g5.i);
                        n13 = g4.j - (g.j + g5.j);
                    }
                    final double n14 = n11 * n11 + n12 * n12 + n13 * n13;
                    Label_0870: {
                        double n16 = 0.0;
                        Label_0840: {
                            if (this.B) {
                                final double sqrt2 = Math.sqrt(n14);
                                final double n15 = sqrt2 - (g4.k + g5.k);
                                if (n15 <= 0.0) {
                                    break Label_0870;
                                }
                                n16 = this.ab * Math.pow(n15, this.ad + 1) / sqrt2;
                                if (!b) {
                                    break Label_0840;
                                }
                            }
                            n16 = this.ab * Math.pow(n14, this.ad * 0.5);
                        }
                        n2 += n11 * n16;
                        n += n12 * n16;
                        n3 += n13 * n16;
                    }
                    p4 = p4.a();
                    if (b) {
                        break;
                    }
                }
            }
        }
        y.c.d d3 = p3.a.g();
        while (true) {
            while (d3 != null) {
                final g g6 = this.E[d3.c().d()];
                g6.f = this.C;
                final g p6;
                final g g7 = p6 = g6.p;
                if (b) {
                    y.c.d d4 = p6.a.f();
                    while (d4 != null) {
                        final g g8 = this.E[d4.d().d()];
                        g8.f = this.C;
                        final g p7 = g8.p;
                        if (b) {
                            return;
                        }
                        double n17 = 0.0;
                        double n18 = 0.0;
                        double n19 = 0.0;
                        Label_1838: {
                            if (p7 != null && p7.o == 3) {
                                n17 = p7.h + g8.h - g.h;
                                n18 = p7.i + g8.i - g.i;
                                n19 = p7.j + g8.j - g.j;
                                if (!b) {
                                    break Label_1838;
                                }
                            }
                            n17 = g8.h - g.h;
                            n18 = g8.i - g.i;
                            n19 = g8.j - g.j;
                        }
                        final double n20 = n17 * n17 + n18 * n18 + n19 * n19;
                        double n21 = 1.0;
                        final double sqrt3 = Math.sqrt(n20);
                        Label_2501: {
                            if (sqrt3 != 0.0) {
                                double max = 0.0;
                                Label_1914: {
                                    if (this.B) {
                                        max = Math.max(1.0E-6, sqrt3 - (g.k + g8.k));
                                        if (!b) {
                                            break Label_1914;
                                        }
                                    }
                                    max = sqrt3;
                                }
                                Label_2464: {
                                    if (b2 || this.aa[d4.b()] == 0) {
                                        Label_2058: {
                                            Label_2007: {
                                                switch (this.T) {
                                                    case 0: {
                                                        n21 = max * this.P[d4.b()];
                                                        if (b) {
                                                            break Label_2007;
                                                        }
                                                        break Label_2058;
                                                    }
                                                    case 1: {
                                                        n21 = max * max * this.P[d4.b()];
                                                        if (b) {
                                                            break Label_2007;
                                                        }
                                                        break Label_2058;
                                                    }
                                                    case 2: {
                                                        n21 = max * max * max * this.P[d4.b()];
                                                        if (b) {
                                                            break;
                                                        }
                                                        break Label_2058;
                                                    }
                                                }
                                            }
                                            n21 = Math.pow(max, this.T + 1) * this.P[d4.b()];
                                        }
                                        Label_2137: {
                                            switch (this.U) {
                                                case 0: {
                                                    n21 -= this.Q[d4.b()] / max;
                                                    if (b) {
                                                        break Label_2137;
                                                    }
                                                    break Label_2464;
                                                }
                                                case 1: {
                                                    n21 -= this.Q[d4.b()] / (max * max);
                                                    if (b) {
                                                        break Label_2137;
                                                    }
                                                    break Label_2464;
                                                }
                                                case 2: {
                                                    n21 -= this.Q[d4.b()] / (max * max * max);
                                                    if (b) {
                                                        break;
                                                    }
                                                    break Label_2464;
                                                }
                                            }
                                        }
                                        n21 -= this.Q[d4.b()] / Math.pow(max, this.U + 1);
                                        if (!b) {
                                            break Label_2464;
                                        }
                                    }
                                    Label_2459: {
                                        switch (this.aa[d4.b()]) {
                                            default: {
                                                n21 = 0.0;
                                                if (b) {
                                                    break Label_2459;
                                                }
                                                break;
                                            }
                                            case 3: {
                                                n21 = this.ab * Math.pow(sqrt3, this.ad + 1);
                                                Label_2341: {
                                                    switch (this.U) {
                                                        case 0: {
                                                            n21 -= this.Q[d4.b()] / max;
                                                            if (b) {
                                                                break Label_2341;
                                                            }
                                                            break Label_2464;
                                                        }
                                                        case 1: {
                                                            n21 -= this.Q[d4.b()] / (max * max);
                                                            if (b) {
                                                                break Label_2341;
                                                            }
                                                            break Label_2464;
                                                        }
                                                        case 2: {
                                                            n21 -= this.Q[d4.b()] / (max * max * max);
                                                            if (b) {
                                                                break;
                                                            }
                                                            break Label_2464;
                                                        }
                                                    }
                                                }
                                                n21 -= this.Q[d4.b()] / Math.pow(max, this.U + 1);
                                                if (b) {
                                                    break Label_2459;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                g8.a.d();
                                                n21 = Math.pow(g8.q / g8.r, 3.0) * this.ac * Math.pow(sqrt3, this.af + 1);
                                                if (b) {
                                                    break Label_2459;
                                                }
                                                break;
                                            }
                                            case 2: {
                                                if (b) {
                                                    break;
                                                }
                                                break Label_2501;
                                            }
                                        }
                                    }
                                }
                                final double n22 = n21 / sqrt3;
                                n2 += n17 * n22;
                                n += n18 * n22;
                                n3 += n19 * n22;
                            }
                        }
                        d4 = d4.g();
                        if (b) {
                            break;
                        }
                    }
                    h.a += n2;
                    h.b += n;
                    h.c += n3;
                    return;
                }
                double n23 = 0.0;
                double n24 = 0.0;
                double n25 = 0.0;
                Label_1041: {
                    if (p6 != null && g7.o == 3) {
                        n23 = g7.h + g6.h - g.h;
                        n24 = g7.i + g6.i - g.i;
                        n25 = g7.j + g6.j - g.j;
                        if (!b) {
                            break Label_1041;
                        }
                    }
                    n23 = g6.h - g.h;
                    n24 = g6.i - g.i;
                    n25 = g6.j - g.j;
                }
                final double n26 = n23 * n23 + n24 * n24 + n25 * n25;
                double n27 = 1.0;
                final double sqrt4 = Math.sqrt(n26);
                Label_1667: {
                    if (sqrt4 != 0.0) {
                        double max2 = 0.0;
                        Label_1117: {
                            if (this.B) {
                                max2 = Math.max(1.0E-6, sqrt4 - (g.k + g6.k));
                                if (!b) {
                                    break Label_1117;
                                }
                            }
                            max2 = sqrt4;
                        }
                        Label_1630: {
                            if (b2 || this.aa[d3.b()] == 0) {
                                Label_1258: {
                                    Label_1207: {
                                        switch (this.T) {
                                            case 0: {
                                                n27 = max2 * this.P[d3.b()];
                                                if (b) {
                                                    break Label_1207;
                                                }
                                                break Label_1258;
                                            }
                                            case 1: {
                                                n27 = max2 * max2 * this.P[d3.b()];
                                                if (b) {
                                                    break Label_1207;
                                                }
                                                break Label_1258;
                                            }
                                            case 2: {
                                                n27 = max2 * max2 * max2 * this.P[d3.b()];
                                                if (b) {
                                                    break;
                                                }
                                                break Label_1258;
                                            }
                                        }
                                    }
                                    n27 = Math.pow(max2, this.T + 1) * this.P[d3.b()];
                                }
                                Label_1337: {
                                    switch (this.U) {
                                        case 0: {
                                            n27 -= this.Q[d3.b()] / max2;
                                            if (b) {
                                                break Label_1337;
                                            }
                                            break Label_1630;
                                        }
                                        case 1: {
                                            n27 -= this.Q[d3.b()] / (max2 * max2);
                                            if (b) {
                                                break Label_1337;
                                            }
                                            break Label_1630;
                                        }
                                        case 2: {
                                            n27 -= this.Q[d3.b()] / (max2 * max2 * max2);
                                            if (b) {
                                                break;
                                            }
                                            break Label_1630;
                                        }
                                    }
                                }
                                n27 -= this.Q[d3.b()] / Math.pow(max2, this.U + 1);
                                if (!b) {
                                    break Label_1630;
                                }
                            }
                            Label_1625: {
                                switch (this.aa[d3.b()]) {
                                    default: {
                                        n27 = 0.0;
                                        if (b) {
                                            break Label_1625;
                                        }
                                        break;
                                    }
                                    case 3: {
                                        n27 = this.ab * Math.pow(sqrt4, this.ad + 1);
                                        Label_1541: {
                                            switch (this.U) {
                                                case 0: {
                                                    n27 -= this.Q[d3.b()] / max2;
                                                    if (b) {
                                                        break Label_1541;
                                                    }
                                                    break Label_1630;
                                                }
                                                case 1: {
                                                    n27 -= this.Q[d3.b()] / (max2 * max2);
                                                    if (b) {
                                                        break Label_1541;
                                                    }
                                                    break Label_1630;
                                                }
                                                case 2: {
                                                    n27 -= this.Q[d3.b()] / (max2 * max2 * max2);
                                                    if (b) {
                                                        break;
                                                    }
                                                    break Label_1630;
                                                }
                                            }
                                        }
                                        n27 -= this.Q[d3.b()] / Math.pow(max2, this.U + 1);
                                        if (b) {
                                            break Label_1625;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        n27 = n4 * Math.pow(sqrt4, this.af + 1);
                                        if (b) {
                                            break Label_1625;
                                        }
                                        break;
                                    }
                                    case 2: {
                                        if (b) {
                                            break;
                                        }
                                        break Label_1667;
                                    }
                                }
                            }
                        }
                        final double n28 = n27 / sqrt4;
                        n2 += n23 * n28;
                        n += n24 * n28;
                        n3 += n25 * n28;
                    }
                }
                d3 = d3.h();
                if (b) {
                    break;
                }
            }
            continue;
        }
    }
    
    private void b(final g g, final h h) {
        final boolean b = y.f.e.i.b;
        if (g != null && g.o == 3) {
            p p2 = g.s.k();
            while (p2 != null) {
                final g g2 = this.E[((q)p2.c()).d()];
                final double h2 = g2.h;
                final double i = g2.i;
                final double j = g2.j;
                final g g3 = g2;
                g3.h += g.h;
                final g g4 = g2;
                g4.i += g.i;
                final g g5 = g2;
                g5.j += g.j;
                g2.f = g.f;
                this.c(g2, h);
                g2.h = h2;
                g2.i = i;
                g2.j = j;
                p2 = p2.a();
                if (b) {
                    return;
                }
                if (b) {
                    break;
                }
            }
        }
        this.c(g, h);
    }
    
    private void c(final g g, final h h) {
        final boolean b = y.f.e.i.b;
        double n3;
        double n2;
        double n = n2 = (n3 = 0.0);
        int i = this.F - 1;
        while (i >= 0) {
            final g g2 = this.E[i];
            if (b) {
                return;
            }
            Label_0402: {
                if (g2.f != g.f) {
                    final g p2 = g2.p;
                    double n4 = 0.0;
                    double n5 = 0.0;
                    double n6 = 0.0;
                    Label_0189: {
                        if (p2 != null && p2.o == 3) {
                            if (p2 == g) {
                                break Label_0402;
                            }
                            if (p2 == g.p) {
                                break Label_0402;
                            }
                            n4 = g.h - (p2.h + g2.h);
                            n5 = g.i - (p2.i + g2.i);
                            n6 = g.j - (p2.j + g2.j);
                            if (!b) {
                                break Label_0189;
                            }
                        }
                        n4 = g.h - g2.h;
                        n5 = g.i - g2.i;
                        n6 = g.j - g2.j;
                    }
                    final double n7 = n4 * n4 + n5 * n5 + n6 * n6;
                    if (n7 != 0.0) {
                        final double sqrt = Math.sqrt(n7);
                        double max = 0.0;
                        Label_0262: {
                            if (this.B) {
                                max = Math.max(1.0E-6, sqrt - (g.k + g2.k));
                                if (!b) {
                                    break Label_0262;
                                }
                            }
                            max = sqrt;
                        }
                        double n8 = 0.0;
                        Label_0374: {
                            Label_0329: {
                                switch (this.U) {
                                    case 0: {
                                        n8 = this.O / (max * sqrt);
                                        if (b) {
                                            break Label_0329;
                                        }
                                        break Label_0374;
                                    }
                                    case 1: {
                                        n8 = this.O / (max * max * sqrt);
                                        if (b) {
                                            break Label_0329;
                                        }
                                        break Label_0374;
                                    }
                                    case 2: {
                                        n8 = this.O / (max * max * max * sqrt);
                                        if (b) {
                                            break;
                                        }
                                        break Label_0374;
                                    }
                                }
                            }
                            n8 = this.O / (Math.pow(max, this.U + 1) * sqrt);
                        }
                        n2 += n4 * n8;
                        n += n5 * n8;
                        n3 += n6 * n8;
                    }
                }
            }
            --i;
            if (b) {
                break;
            }
        }
        h.a += n2;
        h.b += n;
        h.c += n3;
    }
    
    private void a(final int n, final g g, final h h) {
        final boolean b = y.f.e.i.b;
        double n4;
        double n3;
        double n2 = n3 = (n4 = 0.0);
        ++this.C;
        g.f = this.C;
        g.a.d();
        double n5 = 0.0;
        Label_0079: {
            if (g.o == 1) {
                n5 = Math.pow(g.q / g.r, 3.0) * this.ac;
                if (!b) {
                    break Label_0079;
                }
            }
            n5 = 0.0;
        }
        final boolean b2 = this.aa != null;
        g p4 = null;
        Label_0876: {
            if (g.o == 3) {
                p p3 = this.W.f(g.a).k();
                while (p3 != null) {
                    final y.c.d d = (y.c.d)p3.c();
                    final g g2 = this.E[d.c().d()];
                    final g g3 = this.E[d.d().d()];
                    g3.f = this.C;
                    p4 = g2.p;
                    if (b) {
                        break Label_0876;
                    }
                    double n6 = 0.0;
                    double n7 = 0.0;
                    double n8 = 0.0;
                    Label_0336: {
                        if (p4 != null && g2.p.o == 3) {
                            n6 = g2.p.h + g2.h - (g.h + g3.h);
                            n7 = g2.p.i + g2.i - (g.i + g3.i);
                            n8 = g2.p.j + g2.j - (g.j + g3.j);
                            if (!b) {
                                break Label_0336;
                            }
                        }
                        n6 = g2.h - (g.h + g3.h);
                        n7 = g2.i - (g.i + g3.i);
                        n8 = g2.j - (g.j + g3.j);
                    }
                    final double n9 = n6 * n6 + n7 * n7 + n8 * n8;
                    Label_0476: {
                        double n11 = 0.0;
                        Label_0446: {
                            if (this.B) {
                                final double sqrt = Math.sqrt(n9);
                                final double n10 = sqrt - (g2.k + g3.k);
                                if (n10 <= 0.0) {
                                    break Label_0476;
                                }
                                n11 = this.ab * Math.pow(n10, this.ad + 1) / sqrt;
                                if (!b) {
                                    break Label_0446;
                                }
                            }
                            n11 = this.ab * Math.pow(n9, this.ad * 0.5);
                        }
                        n3 += n6 * n11;
                        n2 += n7 * n11;
                        n4 += n8 * n11;
                    }
                    p3 = p3.a();
                    if (b) {
                        break;
                    }
                }
                p p5 = this.W.g(g.a).k();
                while (p5 != null) {
                    final y.c.d d2 = (y.c.d)p5.c();
                    final g g4 = this.E[d2.d().d()];
                    final g g5 = this.E[d2.c().d()];
                    g5.f = this.C;
                    final g p6 = g4.p;
                    if (b) {
                        break;
                    }
                    double n12 = 0.0;
                    double n13 = 0.0;
                    double n14 = 0.0;
                    Label_0723: {
                        if (p6 != null && g4.p.o == 3) {
                            n12 = g4.p.h + g4.h - (g.h + g5.h);
                            n13 = g4.p.i + g4.i - (g.i + g5.i);
                            n14 = g4.p.j + g4.j - (g.j + g5.j);
                            if (!b) {
                                break Label_0723;
                            }
                        }
                        n12 = g4.h - (g.h + g5.h);
                        n13 = g4.i - (g.i + g5.i);
                        n14 = g4.j - (g.j + g5.j);
                    }
                    final double n15 = n12 * n12 + n13 * n13 + n14 * n14;
                    Label_0863: {
                        double n17 = 0.0;
                        Label_0833: {
                            if (this.B) {
                                final double sqrt2 = Math.sqrt(n15);
                                final double n16 = sqrt2 - (g4.k + g5.k);
                                if (n16 <= 0.0) {
                                    break Label_0863;
                                }
                                n17 = this.ab * Math.pow(n16, this.ad + 1) / sqrt2;
                                if (!b) {
                                    break Label_0833;
                                }
                            }
                            n17 = this.ab * Math.pow(n15, this.ad * 0.5);
                        }
                        n3 += n12 * n17;
                        n2 += n13 * n17;
                        n4 += n14 * n17;
                    }
                    p5 = p5.a();
                    if (b) {
                        break;
                    }
                }
            }
        }
        y.c.d d3 = p4.a.g();
        while (true) {
            while (d3 != null) {
                final int b3 = d3.b();
                final g g6 = this.E[d3.c().d()];
                final g p7;
                final g g7 = p7 = g6.p;
                if (b) {
                    y.c.d d4 = p7.a.f();
                    while (d4 != null) {
                        final int b4 = d4.b();
                        final g g8 = this.E[d4.d().d()];
                        final g p8 = g8.p;
                        if (b) {
                            return;
                        }
                        double n18 = 0.0;
                        double n19 = 0.0;
                        double n20 = 0.0;
                        Label_1683: {
                            if (p8 != null && p8.o == 3) {
                                n18 = p8.h + g8.h - g.h;
                                n19 = p8.i + g8.i - g.i;
                                n20 = p8.j + g8.j - g.j;
                                if (!b) {
                                    break Label_1683;
                                }
                            }
                            n18 = g8.h - g.h;
                            n19 = g8.i - g.i;
                            n20 = g8.j - g.j;
                        }
                        final double n21 = n18 * n18 + n19 * n19 + n20 * n20;
                        Label_2182: {
                            double n22 = 0.0;
                            Label_2152: {
                                if (b2 && this.aa[b4] != 0) {
                                    Label_1899: {
                                        switch (this.aa[b4]) {
                                            default: {
                                                if (b) {
                                                    break Label_1899;
                                                }
                                                break Label_2182;
                                            }
                                            case 1: {
                                                g8.f = this.C;
                                                n22 = Math.pow(g8.q / g8.r, 3.0) * this.ac * Math.pow(n21, this.af * 0.5);
                                                if (b) {
                                                    break Label_1899;
                                                }
                                                break Label_2152;
                                            }
                                            case 3: {
                                                if (this.B) {
                                                    final double sqrt3 = Math.sqrt(n21);
                                                    final double n23 = sqrt3 - (g8.k + g.k);
                                                    if (n23 <= 0.0) {
                                                        break Label_2182;
                                                    }
                                                    n22 = this.ab * Math.pow(n23, this.ad + 1) / sqrt3;
                                                    if (!b) {
                                                        break Label_2152;
                                                    }
                                                }
                                                n22 = this.ab * Math.pow(n21, this.ad * 0.5);
                                                if (b) {
                                                    break Label_1899;
                                                }
                                                break Label_2152;
                                            }
                                            case 2: {
                                                g8.f = this.C;
                                                if (b) {
                                                    break;
                                                }
                                                break Label_2182;
                                            }
                                        }
                                    }
                                }
                                if (this.B) {
                                    final double sqrt4 = Math.sqrt(n21);
                                    final double n24 = sqrt4 - (g8.k + g.k);
                                    if (n24 <= 0.0) {
                                        break Label_2182;
                                    }
                                    Label_2017: {
                                        switch (n) {
                                            case 0: {
                                                n22 = n24 * this.N / sqrt4;
                                                if (b) {
                                                    break Label_2017;
                                                }
                                                break Label_2152;
                                            }
                                            case 1: {
                                                n22 = n24 * n24 * this.N / sqrt4;
                                                if (b) {
                                                    break Label_2017;
                                                }
                                                break Label_2152;
                                            }
                                            case 2: {
                                                n22 = n24 * n24 * n24 * this.N / sqrt4;
                                                if (b) {
                                                    break;
                                                }
                                                break Label_2152;
                                            }
                                        }
                                    }
                                    n22 = this.N * Math.pow(n24, n + 1) / sqrt4;
                                    if (!b) {
                                        break Label_2152;
                                    }
                                }
                                Label_2120: {
                                    switch (n) {
                                        case 0: {
                                            n22 = this.N;
                                            if (b) {
                                                break Label_2120;
                                            }
                                            break Label_2152;
                                        }
                                        case 1: {
                                            n22 = this.N * Math.sqrt(n21);
                                            if (b) {
                                                break Label_2120;
                                            }
                                            break Label_2152;
                                        }
                                        case 2: {
                                            n22 = this.N * n21;
                                            if (b) {
                                                break;
                                            }
                                            break Label_2152;
                                        }
                                    }
                                }
                                n22 = this.N * Math.pow(n21, n * 0.5);
                            }
                            n3 += n18 * n22;
                            n2 += n19 * n22;
                            n4 += n20 * n22;
                        }
                        d4 = d4.g();
                        if (b) {
                            break;
                        }
                    }
                    h.a += n3;
                    h.b += n2;
                    h.c += n4;
                    return;
                }
                double n25 = 0.0;
                double n26 = 0.0;
                double n27 = 0.0;
                Label_1032: {
                    if (p7 != null && g7.o == 3) {
                        n25 = g7.h + g6.h - g.h;
                        n26 = g7.i + g6.i - g.i;
                        n27 = g7.j + g6.j - g.j;
                        if (!b) {
                            break Label_1032;
                        }
                    }
                    n25 = g6.h - g.h;
                    n26 = g6.i - g.i;
                    n27 = g6.j - g.j;
                }
                final double n28 = n25 * n25 + n26 * n26 + n27 * n27;
                Label_1514: {
                    double n29 = 0.0;
                    Label_1484: {
                        if (b2 && this.aa[b3] != 0) {
                            Label_1231: {
                                switch (this.aa[b3]) {
                                    default: {
                                        if (b) {
                                            break Label_1231;
                                        }
                                        break Label_1514;
                                    }
                                    case 1: {
                                        g6.f = this.C;
                                        n29 = n5 * Math.pow(n28, this.af * 0.5);
                                        if (b) {
                                            break Label_1231;
                                        }
                                        break Label_1484;
                                    }
                                    case 3: {
                                        if (this.B) {
                                            final double sqrt5 = Math.sqrt(n28);
                                            final double n30 = sqrt5 - (g6.k + g.k);
                                            if (n30 <= 0.0) {
                                                break Label_1514;
                                            }
                                            n29 = this.ab * Math.pow(n30, this.ad + 1) / sqrt5;
                                            if (!b) {
                                                break Label_1484;
                                            }
                                        }
                                        n29 = this.ab * Math.pow(n28, this.ad * 0.5);
                                        if (b) {
                                            break Label_1231;
                                        }
                                        break Label_1484;
                                    }
                                    case 2: {
                                        g6.f = this.C;
                                        if (b) {
                                            break;
                                        }
                                        break Label_1514;
                                    }
                                }
                            }
                        }
                        if (this.B) {
                            final double sqrt6 = Math.sqrt(n28);
                            final double n31 = sqrt6 - (g6.k + g.k);
                            if (n31 <= 0.0) {
                                break Label_1514;
                            }
                            Label_1349: {
                                switch (n) {
                                    case 0: {
                                        n29 = n31 * this.N / sqrt6;
                                        if (b) {
                                            break Label_1349;
                                        }
                                        break Label_1484;
                                    }
                                    case 1: {
                                        n29 = n31 * n31 * this.N / sqrt6;
                                        if (b) {
                                            break Label_1349;
                                        }
                                        break Label_1484;
                                    }
                                    case 2: {
                                        n29 = n31 * n31 * n31 * this.N / sqrt6;
                                        if (b) {
                                            break;
                                        }
                                        break Label_1484;
                                    }
                                }
                            }
                            n29 = this.N * Math.pow(n31, n + 1) / sqrt6;
                            if (!b) {
                                break Label_1484;
                            }
                        }
                        Label_1452: {
                            switch (n) {
                                case 0: {
                                    n29 = this.N;
                                    if (b) {
                                        break Label_1452;
                                    }
                                    break Label_1484;
                                }
                                case 1: {
                                    n29 = this.N * Math.sqrt(n28);
                                    if (b) {
                                        break Label_1452;
                                    }
                                    break Label_1484;
                                }
                                case 2: {
                                    n29 = this.N * n28;
                                    if (b) {
                                        break;
                                    }
                                    break Label_1484;
                                }
                            }
                        }
                        n29 = this.N * Math.pow(n28, n * 0.5);
                    }
                    n3 += n25 * n29;
                    n2 += n26 * n29;
                    n4 += n27 * n29;
                }
                d3 = d3.h();
                if (b) {
                    break;
                }
            }
            continue;
        }
    }
    
    private void b(final int n, final g g, final h h) {
        final boolean b = y.f.e.i.b;
        if (g != null && g.o == 3) {
            p p3 = g.s.k();
            while (p3 != null) {
                final g g2 = this.E[((q)p3.c()).d()];
                final double h2 = g2.h;
                final double i = g2.i;
                final double j = g2.j;
                final g g3 = g2;
                g3.h += g.h;
                final g g4 = g2;
                g4.i += g.i;
                final g g5 = g2;
                g5.j += g.j;
                g2.f = g.f;
                this.c(n, g2, h);
                g2.h = h2;
                g2.i = i;
                g2.j = j;
                p3 = p3.a();
                if (b) {
                    return;
                }
                if (b) {
                    break;
                }
            }
        }
        this.c(n, g, h);
    }
    
    private void c(final int n, final g g, final h h) {
        final boolean b = y.f.e.i.b;
        double n4;
        double n3;
        double n2 = n3 = (n4 = 0.0);
        final boolean b2 = this.aa != null;
        int i = this.F - 1;
        while (i >= 0) {
            final g g2 = this.E[i];
            if (b) {
                return;
            }
            Label_0537: {
                if (!b2 || g2.f != g.f) {
                    final g p3 = g2.p;
                    double n5 = 0.0;
                    double n6 = 0.0;
                    double n7 = 0.0;
                    Label_0209: {
                        if (p3 != null && p3.o == 3) {
                            if (p3 == g) {
                                break Label_0537;
                            }
                            if (p3 == g.p) {
                                break Label_0537;
                            }
                            n5 = g.h - (p3.h + g2.h);
                            n6 = g.i - (p3.i + g2.i);
                            n7 = g.j - (p3.j + g2.j);
                            if (!b) {
                                break Label_0209;
                            }
                        }
                        n5 = g.h - g2.h;
                        n6 = g.i - g2.i;
                        n7 = g.j - g2.j;
                    }
                    final double n8 = n5 * n5 + n6 * n6 + n7 * n7;
                    if (n8 != 0.0) {
                        double n10 = 0.0;
                        Label_0507: {
                            if (this.B) {
                                final double sqrt = Math.sqrt(n8);
                                final double n9 = sqrt - (g.k + g2.k);
                                if (n9 <= 0.0) {
                                    n10 = this.O / (1.0E-8 * sqrt);
                                    if (!b) {
                                        break Label_0507;
                                    }
                                }
                                Label_0361: {
                                    switch (n) {
                                        case 0: {
                                            n10 = this.O / (n9 * sqrt);
                                            if (b) {
                                                break Label_0361;
                                            }
                                            break Label_0507;
                                        }
                                        case 1: {
                                            n10 = this.O / (n9 * n9 * sqrt);
                                            if (b) {
                                                break Label_0361;
                                            }
                                            break Label_0507;
                                        }
                                        case 2: {
                                            n10 = this.O / (n9 * n9 * n9 * sqrt);
                                            if (b) {
                                                break;
                                            }
                                            break Label_0507;
                                        }
                                    }
                                }
                                n10 = this.O / (Math.pow(n9, n + 1) * sqrt);
                                if (!b) {
                                    break Label_0507;
                                }
                            }
                            Label_0470: {
                                switch (n) {
                                    case 0: {
                                        n10 = this.O / n8;
                                        if (b) {
                                            break Label_0470;
                                        }
                                        break Label_0507;
                                    }
                                    case 1: {
                                        n10 = this.O / (n8 * Math.sqrt(n8));
                                        if (b) {
                                            break Label_0470;
                                        }
                                        break Label_0507;
                                    }
                                    case 2: {
                                        n10 = this.O / (n8 * n8);
                                        if (b) {
                                            break;
                                        }
                                        break Label_0507;
                                    }
                                }
                            }
                            n10 = this.O / Math.pow(n8, (n + 2) * 0.5);
                        }
                        n3 += n5 * n10;
                        n2 += n6 * n10;
                        n4 += n7 * n10;
                    }
                }
            }
            --i;
            if (b) {
                break;
            }
        }
        h.a += n3;
        h.b += n2;
        h.c += n4;
    }
    
    private void d(final g g, final h h) {
        h.c += (this.y.c / this.G.length - g.j) * this.G.length / this.x;
    }
    
    private void e(final g g, final h h) {
        if (this.L != 0.0) {
            final double n = this.y.a / this.G.length - g.h;
            final double n2 = this.y.b / this.G.length - g.i;
            final double n3 = this.y.c / this.G.length - g.j;
            h.a += n * this.L;
            h.b += n2 * this.L;
            h.c += n3 * this.L;
        }
    }
    
    private void f(final g g, final h h) {
        final double n = 1.0E-4 * (g.g + 2.0);
        if (n > 0.0) {
            h.a = this.H.a(-n, n);
            h.b = this.H.a(-n, n);
            h.c = this.H.a(-n, n);
        }
    }
    
    private void a(final g g) {
        if (g.r == 0.0) {
            return;
        }
        final double min = Math.min(g.q, g.r);
        if (min > 0.0) {
            if (g.k < min - 10.0) {
                g.k = (9.0 * g.k + min) / 10.0;
                if (!y.f.e.i.b) {
                    return;
                }
            }
            if (g.k > min + 10.0) {
                g.k = (3.0 * g.k + min) / 4.0;
            }
        }
    }
    
    private void b(final g g) {
        final boolean b = y.f.e.i.b;
        final g p = g.p;
        if (p != null && p.o == 1) {
            final D s = p.s;
            double q = this.v + 1.0;
            p p2 = s.k();
            while (p2 != null) {
                final g g2 = this.E[((q)p2.c()).d()];
                final double n = p.h - g2.h;
                final double n2 = p.i - g2.i;
                final double n3 = p.j - g2.j;
                final double n4 = Math.sqrt(n * n + n2 * n2 + n3 * n3) + g2.k;
                if (b) {
                    return;
                }
                if (n4 > q) {
                    q = n4;
                }
                p2 = p2.a();
                if (b) {
                    break;
                }
            }
            p.q = q;
        }
    }
    
    void a(final g g, final h h, final double n) {
        final boolean b = y.f.e.i.b;
        if (n != 0.0 && g.e != 0.0) {
            final double l = (h.a * g.b + h.b * g.c + h.c * g.d) / (n * g.e);
            this.x -= g.g * g.g;
            this.w -= g.g;
            Label_0136: {
                if (g.l * l > 0.0) {
                    g.g += l * 0.45;
                    if (!b) {
                        break Label_0136;
                    }
                }
                g.g += l * 0.15;
            }
            Label_0179: {
                if (g.g > this.z) {
                    g.g = this.z;
                    if (!b) {
                        break Label_0179;
                    }
                }
                if (g.g < 0.1) {
                    g.g = 0.1;
                }
            }
            if (this.r == 1 && !g.m) {
                g.g *= 1.0 - 0.066 * (g.n + 1);
            }
            this.w += g.g;
            this.x += g.g * g.g;
            g.l = l;
        }
    }
    
    void b(final g g, final h h, final double e) {
        if (e > 0.0) {
            final double n = g.g / e;
            final double n2 = h.a * n;
            g.h += n2;
            final h y = this.y;
            y.a += n2;
            final double n3 = h.b * n;
            g.i += n3;
            final h y2 = this.y;
            y2.b += n3;
            final double n4 = h.c * n;
            g.j += n4;
            final h y3 = this.y;
            y3.c += n4;
            g.e = e;
            g.b = h.a;
            g.c = h.b;
            g.d = h.c;
        }
    }
    
    private void u() {
        final boolean b = y.f.e.i.b;
        g[] e = null;
        Label_0125: {
            if (this.W != null) {
                p p = this.W.c(this.W.b()).k();
                while (p != null) {
                    e = this.E;
                    if (b) {
                        break Label_0125;
                    }
                    final g g = e[((q)p.c()).d()];
                    final g p2 = g.p;
                    if (p2 != null && p2.o == 3) {
                        final g g2 = g;
                        g2.h += p2.h;
                        final g g3 = g;
                        g3.i += p2.i;
                        final g g4 = g;
                        g4.j += p2.j;
                    }
                    p = p.a();
                    if (b) {
                        break;
                    }
                }
            }
            final g[] e2 = this.E;
        }
        int i = e.length - 1;
        while (i >= 0) {
            final g g5 = this.E[i];
            this.D.a(g5.a, g5.h, g5.i);
            --i;
            if (b) {
                break;
            }
        }
    }
    
    private static int e(final int n) {
        return n * n;
    }
    
    private static double e(final double n) {
        return n * n;
    }
    
    private double a(final y.c.d d) {
        double n = this.v;
        final y.c.c c = this.D.c(d.p);
        if (c != null && c.a(d) > 0) {
            n = c.a(d);
        }
        if (this.r == 1) {
            final y.c.c c2 = this.D.c(d.n);
            if (!c2.d(d.c()) && !c2.d(d.d())) {
                final double n2 = this.D.j(d.c()) - this.D.j(d.d());
                final double n3 = this.D.k(d.c()) - this.D.k(d.d());
                n = Math.sqrt(n2 * n2 + n3 * n3) * 0.95 + 1.0;
                if (this.B) {
                    n = Math.max(1.0, n - (this.E[d.c().d()].k + this.E[d.d().d()].k));
                }
            }
        }
        return n;
    }
    
    static {
        n = "SPHERE_OF_ACTION_NODES";
        o = "y.layout.organic.OrganicLayouter.FIXED_GROUP_NODES_DPKEY";
        p = "OrganicLayouter.EDGE_LENGTH_DATA";
    }
}
