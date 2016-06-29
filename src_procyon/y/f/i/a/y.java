package y.f.i.a;

import y.g.*;
import y.f.*;
import y.d.*;
import y.c.*;
import java.util.*;

public class y extends a
{
    static final Object a;
    static final Object b;
    private I c;
    private O d;
    private V e;
    private i f;
    private x g;
    private byte h;
    private Object i;
    private Object n;
    private boolean o;
    private boolean p;
    private L q;
    private boolean r;
    private long s;
    private boolean t;
    private double u;
    private double v;
    private double w;
    private List x;
    private List y;
    
    public y(final ah ah) {
        super(ah);
        this.i = ah.h_;
        this.n = ah.g_;
        this.r = false;
        this.s = Long.MAX_VALUE;
        this.t = false;
        this.u = 30.0;
        this.v = 0.3;
        this.w = 10.0;
        this.g = new x();
    }
    
    public y() {
        this(null);
    }
    
    public long b() {
        return this.s;
    }
    
    public x c() {
        return this.g;
    }
    
    protected x a(final d d) {
        final c c = d.a().c("y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY");
        if (c != null) {
            final x x = (x)c.b(d);
            if (x != null) {
                return x;
            }
        }
        return this.g;
    }
    
    public boolean d() {
        return this.t;
    }
    
    public void a(final boolean t) {
        this.t = t;
    }
    
    public boolean e() {
        return this.r;
    }
    
    public void a(final byte h) {
        switch (h) {
            case 0:
            case 2:
            case 4: {
                this.h = h;
            }
            default: {
                throw new IllegalArgumentException("Argument '" + h + "' not allowed.");
            }
        }
    }
    
    public byte f() {
        return this.h;
    }
    
    public Object g() {
        return this.n;
    }
    
    public Object h() {
        return this.i;
    }
    
    public void a(final Object i) {
        if (i == null) {
            throw new IllegalArgumentException("null");
        }
        this.i = i;
    }
    
    boolean a(final d d, final y.c.i i) {
        if (this.f() == 0) {
            return true;
        }
        final c c = i.c(this.h());
        return c != null && c.d(d);
    }
    
    static boolean a(final d d, final X x) {
        final int a = ab.a;
        final v l = x.l(d);
        t t = null;
        final u b = l.b();
        while (b.f()) {
            final t a2 = b.a();
            if (t != null && Math.abs(t.a - a2.a) > 1.0E-6 && Math.abs(t.b - a2.b) > 1.0E-6) {
                return false;
            }
            t = a2;
            b.g();
            if (a != 0) {
                break;
            }
        }
        return true;
    }
    
    static boolean b(final d d, final X x) {
        final int a = ab.a;
        final v l = x.l(d);
        int i = 0;
        int n = 0;
        while (i < l.h() - 1) {
            final m a2 = l.a(i);
            final double f = a2.f();
            n = i;
            if (a != 0) {
                return n != 0;
            }
            if (n == 0 || i == l.h() - 1) {
                if (!a2.b() && !a2.a()) {
                    return false;
                }
            }
            else {
                if ((0.999999 >= f || f >= 1.000001) && (-1.000001 >= f || f >= -0.999999) && !a2.b() && !a2.a()) {
                    return false;
                }
                if ((0.999999 < f && f < 1.000001) || (-1.000001 < f && f < -0.999999)) {
                    final m a3 = l.a(i - 1);
                    final double a4 = a3.c().a();
                    final double a5 = a3.d().a();
                    final double a6 = a2.c().a();
                    final double a7 = a2.d().a();
                    if ((a3.b() && a4 < a5 && a6 > a7) || (a4 > a5 && a6 < a7)) {
                        return false;
                    }
                    final double b = a3.c().b();
                    final double b2 = a3.d().b();
                    final double b3 = a2.c().b();
                    final double b4 = a2.d().b();
                    if ((a3.a() && b < b2 && b3 > b4) || (b > b2 && b3 < b4)) {
                        return false;
                    }
                }
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
        return n != 0;
    }
    
    private static m[] a(final List list) {
        final int a = ab.a;
        if (list == null || list.size() == 0) {
            return new m[0];
        }
        final ArrayList list2 = new ArrayList<m>();
        ArrayList list3 = null;
        for (final m m : list) {
            if (m.g() > 1.0E-6) {
                list3 = list2;
                if (a != 0) {
                    return list3.toArray(new m[list2.size()]);
                }
                list3.add(m);
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
        return list3.toArray(new m[list2.size()]);
    }
    
    private static v a(final v v) {
        final int a = ab.a;
        if (v == null || v.h() <= 1) {
            return v;
        }
        final ArrayList<t> list = new ArrayList<t>(v.h());
        t t = null;
        final u b = v.b();
        while (b.f()) {
            final t a2 = b.a();
            if (t == null || !t.equals(a2)) {
                list.add(a2);
            }
            t = a2;
            b.g();
            if (a != 0) {
                break;
            }
        }
        return new v(list);
    }
    
    static m[] c(final d d, final X x) {
        final int a = ab.a;
        final ArrayList<m> list = new ArrayList<m>();
        boolean a2 = false;
        t t = null;
        m m = null;
        final v a3 = a(x.l(d));
        if (a3.h() <= 1) {
            return new m[0];
        }
        final s j = a3.j();
        while (j.f()) {
            m = (m)j.d();
            if (a != 0) {
                return a(list);
            }
            Label_0267: {
                if (t == null) {
                    t = m.c();
                    a2 = m.a();
                    if (a == 0) {
                        break Label_0267;
                    }
                }
                if ((m.a() && !a2) || (m.b() && a2)) {
                    list.add(new m(t, m.c()));
                    t = m.c();
                    a2 = !a2;
                    if (a == 0) {
                        break Label_0267;
                    }
                }
                if (!m.b() && !m.a()) {
                    final t d2 = m.d();
                    final t t2 = a2 ? new t(t.a(), d2.b()) : new t(d2.a(), t.b());
                    list.add(new m(t, t2));
                    t = t2;
                    a2 = !a2;
                }
            }
            j.g();
            if (a != 0) {
                break;
            }
        }
        list.add(new m(t, m.d()));
        return a(list);
    }
    
    public boolean i() {
        return this.o;
    }
    
    public boolean j() {
        return this.p;
    }
    
    public L k() {
        return this.q;
    }
    
    public void a(final double w) {
        this.w = w;
    }
    
    public double l() {
        return this.w;
    }
    
    protected I a(final O o) {
        return new I(o);
    }
    
    protected void a(final I i) {
        final int a = ab.a;
        final Iterator<J> iterator = (Iterator<J>)this.m().iterator();
        while (iterator.hasNext()) {
            i.a(iterator.next());
            if (a != 0) {
                break;
            }
        }
    }
    
    protected void b(final I i) {
        final int a = ab.a;
        for (final J j : this.m()) {
            j.a();
            i.b(j);
            if (a != 0) {
                return;
            }
            if (a != 0) {
                break;
            }
        }
        this.c.a();
        this.c = null;
    }
    
    public List m() {
        if (this.x == null) {
            (this.x = new ArrayList()).add(new az());
            this.x.add(new aC());
            this.x.add(new ar());
            this.x.add(new bX());
            this.x.add(new bp());
            this.x.add(new bS());
            this.x.add(new aD());
        }
        return this.x;
    }
    
    protected V n() {
        return new V();
    }
    
    protected void a(final V v) {
        final int a = ab.a;
        final Iterator<ab> iterator = (Iterator<ab>)this.o().iterator();
        while (iterator.hasNext()) {
            v.a(iterator.next());
            if (a != 0) {
                break;
            }
        }
    }
    
    public List o() {
        if (this.y == null) {
            (this.y = new ArrayList()).add(new ax());
            this.y.add(new ay());
            this.y.add(new aY());
            this.y.add(new aX());
            this.y.add(new bb());
            this.y.add(new av());
            this.y.add(new aV());
            this.y.add(new aZ());
            this.y.add(new aw());
            this.y.add(new bW());
            this.y.add(new aG());
            this.y.add(new bi());
            this.y.add(new bF());
            this.y.add(new aM());
            this.y.add(new bf());
            this.y.add(new ca());
            this.y.add(new bj());
            this.y.add(new bk());
        }
        return this.y;
    }
    
    protected i p() {
        return new i();
    }
    
    protected n q() {
        return new n();
    }
    
    protected aa a(final V v, final Z z) {
        return new aa(v, z);
    }
    
    protected Z a(final X x, final y.f.b.c c) {
        return new Z(x, c, this);
    }
    
    public void c(final X x) {
        final int a = ab.a;
        if (this.a() != null) {
            this.a().c(x);
        }
        if (x.h() == 0) {
            return;
        }
        final bm bm = new bm(x, this);
        bm.a();
        bm.b();
        final long currentTimeMillis = System.currentTimeMillis();
        R.f();
        final y.f.b.c c = new y.f.b.c(x);
        this.a(this.c = this.a(this.t()));
        final Z a2 = this.a(x, c);
        a2.a(currentTimeMillis);
        this.c.a(a2);
        this.a(this.e = this.s());
        this.e.a(a2);
        this.f = this.u();
        x.a(y.f.i.a.y.b, M.b());
        x.a(new z(this, x));
        try {
            final boolean b = this.b() == Long.MAX_VALUE;
            int n = 0;
            if (!b) {
                final e p = x.p();
                while (p.f()) {
                    if (this.a((d)p.d(), (y.c.i)x)) {
                        ++n;
                    }
                    p.g();
                    if (a != 0) {
                        break;
                    }
                }
            }
            final f f = new f();
            final aa a3 = this.a(this.e, a2);
            Label_0310: {
                if (b) {
                    a3.b(Long.MAX_VALUE);
                    if (a == 0) {
                        break Label_0310;
                    }
                }
                a3.b(Math.max(100L, this.b() / Math.max(1, n)));
            }
            final h b2 = M.b();
            final f f2 = new f();
            final F f3 = new F(x);
        Label_0334:
            while (true) {
                while (f3.hasNext()) {
                    Object o = f3.next();
                Label_0435_Outer:
                    while (true) {
                        final f f4 = (f)o;
                        final f f5 = new f();
                        final e a4 = f4.a();
                        while (true) {
                            while (a4.f()) {
                                final d a5 = a4.a();
                                final boolean a6 = this.a(a5, (y.c.i)x);
                                if (a != 0) {
                                    Label_0497: {
                                        if (a6) {
                                            a3.a(Long.MAX_VALUE);
                                            if (a == 0) {
                                                break Label_0497;
                                            }
                                        }
                                        final int n2 = n - f2.size();
                                        a3.a((long)(((n2 > 0) ? (f5.size() / n2) : 1.0) * a2.d()));
                                    }
                                    this.e.b(a3);
                                    final ac i = a3.i();
                                    for (final d d : f5) {
                                        final U u = (U)(o = i.b(d));
                                        if (a != 0) {
                                            continue Label_0435_Outer;
                                        }
                                        if (u == null) {
                                            b2.a(d, false);
                                            f.add(d);
                                            if (a == 0) {
                                                continue Label_0435_Outer;
                                            }
                                        }
                                        b2.a(d, true);
                                        f2.add(d);
                                        if (a != 0) {
                                            break Label_0334;
                                        }
                                    }
                                    continue Label_0334;
                                }
                                if (a6) {
                                    f5.add(a5);
                                }
                                a4.g();
                                if (a != 0) {
                                    break;
                                }
                            }
                            a3.a(f5);
                            continue;
                        }
                    }
                }
                break;
            }
            boolean a7 = false;
            final i u2 = this.u();
            u2.a(a2);
            if (!f2.isEmpty()) {
                u2.a(f2, a3.i());
                a7 = a3.i().a();
            }
            this.a(x, f);
            if (this.e() && a2.d() > 0L) {
                this.a(this.a(x, f2, b2, 0.1), a3, a2);
                a7 |= a3.i().a();
                if (a2.d() > 0L) {
                    this.a(this.a(x, f2, b2, 0.1), a3, a2);
                    a7 |= a3.i().a();
                }
            }
            Label_0925: {
                if (this.d()) {
                    final aN an = new aN();
                    if (a7 || !f.isEmpty()) {
                        final ae ae = new ae(null);
                        ae.c(this.u);
                        ae.b(this.v);
                        ae.a(a2.c().l());
                        ae.b(this.h());
                        ae.a(this.g());
                        ae.a((byte)((this.f() == 0) ? 0 : ((this.f() == 2) ? 2 : 4)));
                        ae.c(x);
                        if (a == 0) {
                            break Label_0925;
                        }
                    }
                    an.b(this.u);
                    an.a(this.v);
                    an.a(f2, a3.i(), a2);
                }
            }
            this.b(x);
        }
        finally {
            this.b(this.c);
            this.e.d();
            this.f.a();
            x.d_(y.f.i.a.y.b);
            c.c();
        }
        try {
            x.a(aH.a, new A(this));
            new aH(this.d()).c(x);
        }
        finally {
            x.d_(aH.a);
        }
        bm.c();
    }
    
    private void b(final X x) {
        final y.g.I i = new y.g.I(x);
        i.c();
        new aI().c(x);
        i.f();
    }
    
    private boolean b(final d d) {
        final c c = d.a().c(aF.c);
        return c != null && c.b(d) != null;
    }
    
    private f a(final X x, final f f, final h h, final double n) {
        final int a = ab.a;
        if (n >= 1.0) {
            return f;
        }
        final f f2 = new f();
        final h b = M.b();
        final h b2 = M.b();
        final h b3 = M.b();
        final D d = new D();
        final e p4 = x.p();
        while (true) {
            while (p4.f()) {
                final d a2 = p4.a();
                b2.a(a2, x.k(a2).size());
                final int n2;
                final boolean b4 = (n2 = (b(a2, x) ? 1 : 0)) != 0;
                if (a != 0) {
                    final int n3 = n2;
                    final e a3 = f.a();
                    f f3 = null;
                    while (a3.f()) {
                        f3 = f2;
                        if (a != 0) {
                            return f3;
                        }
                        if (f3.size() >= n3) {
                            break;
                        }
                        final d a4 = a3.a();
                        if (!this.b(a4) && !b.d(a4)) {
                            b.a(a4, true);
                            f2.add(a4);
                        }
                        a3.g();
                        if (a != 0) {
                            break;
                        }
                    }
                    a(f2);
                    return f3;
                }
                Label_0176: {
                    if (b4) {
                        final s j = x.l(a2).j();
                        while (j.f()) {
                            d.add(new E(a2, j.a(), null));
                            j.g();
                            if (a != 0) {
                                break Label_0176;
                            }
                            if (a != 0) {
                                break;
                            }
                        }
                    }
                    p4.g();
                }
                if (a != 0) {
                    break;
                }
            }
            y.d.f.a(d, new B(this, b3, h, b, f2));
            f.sort(new y.f.i.a.D(b2, b3, null));
            int n2 = Math.min(3, (int)Math.ceil(f.size() * n));
            continue;
        }
    }
    
    private static void a(final D d) {
        final int a = ab.a;
        final y.g.ar ar = new y.g.ar(42L);
        final Object[] array = d.toArray();
        ar.a(array);
        d.clear();
        int i = 0;
        while (i < array.length) {
            d.add(array[i]);
            ++i;
            if (a != 0) {
                break;
            }
        }
    }
    
    private void a(final f f, final aa aa, final Z z) {
        final int a = ab.a;
        final X a2 = z.a();
        final ac i = aa.i();
        final h h = (h)a2.c(y.f.i.a.y.b);
        final e p3 = a2.p();
        while (p3.f()) {
            final d a3 = p3.a();
            if (i.b(a3) != null) {
                i.a(a3).a();
            }
            p3.g();
            if (a != 0) {
                break;
            }
        }
        final f f2 = new f();
        final G g = new G(f, a2);
    Label_0486:
        while (true) {
            while (g.hasNext()) {
                Object o = g.next();
                f f3 = null;
                f f4 = null;
            Label_0471:
                while (true) {
                    f3 = (f)o;
                    final h b = M.b();
                    f4 = f3;
                    if (a != 0) {
                        break Label_0486;
                    }
                    final e a4 = f4.a();
                Label_0279_Outer:
                    while (a4.f()) {
                        final d a5 = a4.a();
                        aa.a().a(a5, null);
                        final D d = (D)h.b(a5);
                        b.a(a5, d);
                        h.a(a5, null);
                        final C c = (C)(o = d.m());
                        if (a == 0) {
                            final C c2 = c;
                            while (true) {
                                while (c2.f()) {
                                    ((be)c2.d()).b();
                                    c2.g();
                                    if (a == 0) {
                                        if (a != 0) {
                                            break;
                                        }
                                        continue Label_0279_Outer;
                                    }
                                    else {
                                        if (a != 0) {
                                            break Label_0279_Outer;
                                        }
                                        continue Label_0279_Outer;
                                    }
                                }
                                a4.g();
                                continue;
                            }
                        }
                        continue Label_0471;
                    }
                    aa.a(f3);
                    this.s().b(aa);
                    boolean b2 = false;
                    final e a6 = f3.a();
                    while (a6.f()) {
                        final U u = (U)(o = i.b(a6.a()));
                        if (a != 0) {
                            continue Label_0471;
                        }
                        if (u == null) {
                            b2 = true;
                            if (a == 0) {
                                break;
                            }
                        }
                        a6.g();
                        if (a != 0) {
                            break;
                        }
                    }
                    if (b2) {
                        final e a7 = f3.a();
                    Label_0466_Outer:
                        while (a7.f()) {
                            final C c3 = (C)(o = ((D)b.b(a7.a())).m());
                            if (a == 0) {
                                final C c4 = c3;
                                while (true) {
                                    while (c4.f()) {
                                        ((be)c4.d()).a();
                                        c4.g();
                                        if (a == 0) {
                                            if (a != 0) {
                                                break;
                                            }
                                            continue Label_0466_Outer;
                                        }
                                        else {
                                            if (a != 0) {
                                                break Label_0471;
                                            }
                                            continue Label_0466_Outer;
                                        }
                                    }
                                    a7.g();
                                    continue;
                                }
                            }
                            continue Label_0471;
                        }
                        continue Label_0486;
                    }
                    break;
                }
                f2.addAll(f3);
                if (a == 0) {
                    continue;
                }
                if (!f4.isEmpty()) {
                    this.u().a(f2, i);
                }
                return;
            }
            continue Label_0486;
        }
    }
    
    private void a(final X x, final f f) {
        final int a = ab.a;
        if (f.isEmpty()) {
            return;
        }
        final h u = x.u();
        final e a2 = f.a();
        while (true) {
            while (a2.f()) {
                u.a(a2.a(), true);
                a2.g();
                if (a != 0) {
                    final y.f.i.a a3 = new y.f.i.a();
                    x.a(y.f.i.a.a, new y.f.i.a.C(this, new HashSet(f)));
                    a3.c(x);
                    x.d_(y.f.i.a.a);
                    return;
                }
                if (a != 0) {
                    break;
                }
            }
            x.a("EDGES_WITHOUT_ROUTE_DPKEY", u);
            continue;
        }
    }
    
    public I r() {
        return this.c;
    }
    
    private O t() {
        if (this.d == null) {
            this.d = this.q();
        }
        return this.d;
    }
    
    V s() {
        if (this.e == null) {
            this.e = this.n();
        }
        return this.e;
    }
    
    private i u() {
        if (this.f == null) {
            this.f = this.p();
        }
        return this.f;
    }
    
    static boolean a(final y y, final d d) {
        return y.b(d);
    }
    
    static {
        a = "EdgeRouter.EDGE_BUNDLE_ID";
        b = "EdgeRouter.REGISTERED_EDGE_INFO_KEY";
    }
}
