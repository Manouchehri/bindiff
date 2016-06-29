package y.f.i;

import y.d.*;
import y.g.*;
import y.f.b.*;
import y.f.*;
import y.c.*;
import java.util.*;

public class E extends a
{
    public static final Object a;
    private double b;
    private double c;
    private double d;
    private double e;
    private boolean f;
    private t g;
    private double h;
    private t i;
    private List n;
    private List o;
    private int p;
    private int q;
    private int r;
    private final ArrayList s;
    private Object t;
    private c u;
    private double v;
    private byte w;
    
    public E() {
        this.b = 10.0;
        this.c = 1.0;
        this.d = 5.0;
        this.e = 50.0;
        this.g = new t(0.0, 0.0);
        this.h = 10.0;
        this.q = 50;
        this.r = 20;
        this.t = E.a;
        this.w = 0;
        (this.s = new ArrayList()).add(ax.b(1));
        this.s.add(ax.b(4));
        this.s.add(ax.b(2));
        this.s.add(ax.b(8));
        this.n = new ArrayList();
        this.o = new ArrayList();
    }
    
    public void a(final byte w) {
        this.w = w;
    }
    
    private boolean e() {
        return this.w == 1 || this.w == 3;
    }
    
    private boolean f() {
        return this.w == 2 || this.w == 3;
    }
    
    public void c(final X x) {
        final int i = y.f.i.v.f;
        boolean b = false;
        if (x.c("y.layout.router.ORTHOGONAL_PATTERN_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY") == null) {
            this.b(x);
            x.a("y.layout.router.ORTHOGONAL_PATTERN_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY", y.g.q.a(Boolean.TRUE));
            b = true;
        }
        this.a(x);
        X x2 = null;
        Label_0456: {
            if (x.h() > 0) {
                new ac().c(x);
                this.u = x.c(this.t);
                boolean b2 = false;
                this.d(x);
                D d = new D();
                int n = 0;
                do {
                    int j = 0;
                Label_0091:
                    while (j < 2) {
                        x2 = x;
                        if (i != 0) {
                            break Label_0456;
                        }
                        final e p = x.p();
                    Label_0404_Outer:
                        while (p.f()) {
                            double n2 = Double.MAX_VALUE;
                            d.clear();
                            final d a = p.a();
                            j = n;
                            if (i != 0) {
                                continue Label_0091;
                            }
                            Label_0431: {
                                if (j != 0 || !a.e()) {
                                    if (n != 1 || a.e()) {
                                        if (this.u == null || this.u.d(a)) {
                                            final y.c.q c = a.c();
                                            final y.c.q d2 = a.d();
                                            final Collection a2 = this.a(x, a, true);
                                            final Collection a3 = this.a(x, a, false);
                                        Label_0404:
                                            while (true) {
                                            Label_0399:
                                                for (final ax ax : a2) {
                                                    for (final ax ax2 : a3) {
                                                        final D a4 = this.a(x, c, d2, ax, ax2);
                                                        final double a5 = this.a(a, a4, ax, ax2);
                                                        final double n3 = dcmpg(a5, n2);
                                                        if (i != 0) {
                                                            break Label_0404;
                                                        }
                                                        if (n3 < 0) {
                                                            d = a4;
                                                            n2 = a5;
                                                            b2 = false;
                                                        }
                                                        final D a6 = this.a(x, d2, c, ax2, ax);
                                                        final double a7 = this.a(a, a6, ax, ax2);
                                                        if (a7 >= n2) {
                                                            continue Label_0404_Outer;
                                                        }
                                                        d = a6;
                                                        n2 = a7;
                                                        b2 = true;
                                                        if (i != 0 || i != 0) {
                                                            break Label_0399;
                                                        }
                                                    }
                                                    continue Label_0404_Outer;
                                                    double n3 = 0.0;
                                                    if (n3 > 1) {
                                                        if (b2) {
                                                            d.n();
                                                        }
                                                        x.a(a, d);
                                                        this.c(d);
                                                    }
                                                    break Label_0431;
                                                }
                                                d.size();
                                                continue Label_0404;
                                            }
                                        }
                                    }
                                }
                            }
                            p.g();
                            if (i != 0) {
                                break;
                            }
                        }
                        ++n;
                    }
                    break;
                } while (i == 0);
            }
            if (!b) {
                return;
            }
            x2 = x;
        }
        x2.d_("y.layout.router.ORTHOGONAL_PATTERN_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY");
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
    
    private Collection a(final am am) {
        final HashSet<ax> set = new HashSet<ax>();
        set.add(ax.a(-am.getWidth() * 0.5 + this.b, -am.getHeight() * 0.5, 1, 0.1));
        set.add(ax.a(am.getWidth() * 0.5 - this.b, -am.getHeight() * 0.5, 1, 0.1));
        set.add(ax.a(am.getWidth() * 0.5, this.b - am.getHeight() * 0.5, 4, 0.1));
        set.add(ax.a(am.getWidth() * 0.5, am.getHeight() * 0.5 - this.b, 4, 0.1));
        set.add(ax.a(am.getWidth() * 0.5 - this.b, am.getHeight() * 0.5, 2, 0.1));
        set.add(ax.a(-am.getWidth() * 0.5 + this.b, am.getHeight() * 0.5, 2, 0.1));
        set.add(ax.a(-am.getWidth() * 0.5, am.getHeight() * 0.5 - this.b, 8, 0.1));
        set.add(ax.a(-am.getWidth() * 0.5, -am.getHeight() * 0.5 + this.b, 8, 0.1));
        return set;
    }
    
    private void d(final X x) {
        final int f = y.f.i.v.f;
        this.o.clear();
        this.n.clear();
        final x o = x.o();
    Label_0630:
        while (true) {
            while (o.f()) {
                final y.c.q e = o.e();
                final am h = ((X)e.e()).h(e);
                final I i = new I(e, h.getX(), h.getY(), h.getWidth(), h.getHeight());
                final F f2 = new F(true, h.getX(), h.getY(), h.getY() + h.getHeight(), i);
                final F f3 = new F(false, h.getX() + h.getWidth(), h.getY(), h.getY() + h.getHeight(), i);
                this.n.add(f2);
                this.n.add(f3);
                final I j = new I(e, h.getY(), h.getX(), h.getHeight(), h.getWidth());
                final F f4 = new F(true, h.getY(), h.getX(), h.getX() + h.getWidth(), j);
                final F f5 = new F(false, h.getY() + h.getHeight(), h.getX(), h.getX() + h.getWidth(), j);
                this.o.add(f4);
                this.o.add(f5);
                if (f == 0) {
                    final e l = e.l();
                    while (l.f()) {
                        final d a = l.a();
                        final E e2 = this;
                        if (f != 0) {
                            break Label_0630;
                        }
                        Label_0605: {
                            if (this.u != null && !this.u.d(a)) {
                                t t = null;
                                for (final t t2 : x.m(a)) {
                                    if (f != 0) {
                                        break Label_0605;
                                    }
                                    if (t != null) {
                                        t t3 = null;
                                        t t4 = null;
                                        Label_0498: {
                                            if (t2.a() <= t.a()) {
                                                t3 = t2;
                                                t4 = t;
                                                if (f == 0) {
                                                    break Label_0498;
                                                }
                                            }
                                            t3 = t;
                                            t4 = t2;
                                        }
                                        t t5 = null;
                                        t t6 = null;
                                        Label_0533: {
                                            if (t2.b() <= t.b()) {
                                                t5 = t2;
                                                t6 = t;
                                                if (f == 0) {
                                                    break Label_0533;
                                                }
                                            }
                                            t5 = t;
                                            t6 = t2;
                                        }
                                        this.a(this.n, t3.a(), t3.b(), t4.a(), t4.b());
                                        this.a(this.o, t5.b(), t5.a(), t6.b(), t6.a());
                                    }
                                    t = t2;
                                    if (f != 0) {
                                        break;
                                    }
                                }
                            }
                            l.g();
                        }
                        if (f != 0) {
                            break;
                        }
                    }
                    o.g();
                    if (f != 0) {
                        break;
                    }
                    continue;
                    E e2 = null;
                    e2.a(this.o);
                }
                return;
            }
            this.a(this.n);
            final E e2 = this;
            continue Label_0630;
        }
    }
    
    private static boolean a(final X x, final d d) {
        return x.n(d.c()) + x.q(d.c()) >= x.n(d.d()) && x.n(d.d()) + x.q(d.d()) >= x.n(d.c());
    }
    
    private static boolean b(final X x, final d d) {
        return x.m(d.c()) + x.p(d.c()) >= x.m(d.d()) && x.m(d.d()) + x.p(d.d()) >= x.m(d.c());
    }
    
    private Collection a(final X x, final d d, final boolean b) {
        final int f = y.f.i.v.f;
        c c = null;
        Label_0032: {
            if (b) {
                c = x.c(ax.a);
                if (f == 0) {
                    break Label_0032;
                }
            }
            c = x.c(ax.b);
        }
        Collection<ax> collection = null;
        if (c != null) {
            collection = (Collection<ax>)c.b(d);
        }
        else {
            c c2 = null;
            Label_0083: {
                if (b) {
                    c2 = x.c(aF.a);
                    if (f == 0) {
                        break Label_0083;
                    }
                }
                c2 = x.c(aF.b);
            }
            if (c2 != null) {
                final aE ae = (aE)c2.b(d);
                if (ae != null) {
                    collection = new ArrayList<ax>();
                    final int b2 = this.b(ae.b());
                    ax ax = null;
                    Label_0186: {
                        if (ae.a()) {
                            t t = null;
                            Label_0157: {
                                if (b) {
                                    t = x.n(d);
                                    if (f == 0) {
                                        break Label_0157;
                                    }
                                }
                                t = x.o(d);
                            }
                            ax = y.f.ax.a(t.a(), t.b(), b2);
                            if (f == 0) {
                                break Label_0186;
                            }
                        }
                        ax = y.f.ax.b(b2);
                    }
                    collection.add(ax);
                }
            }
        }
        Label_0538: {
            if (collection == null) {
                final c c3 = x.c(ay.a);
                if (c3 != null) {
                    final ay ay = (ay)c3.b(b ? d.c() : d.d());
                    if (ay != null) {
                        collection = new ArrayList<ax>();
                        final Iterator a = ay.a();
                        while (a.hasNext()) {
                            collection.add(a.next().a());
                            if (f != 0) {
                                break Label_0538;
                            }
                            if (f != 0) {
                                break;
                            }
                        }
                    }
                }
            }
            if (collection == null && (this.w == 2 || this.w == 1)) {
                collection = new ArrayList<ax>();
                final t l = x.l(d.c());
                final t i = x.l(d.d());
                if (this.w == 1 && !a(x, d)) {
                    final boolean b3 = i.b() < l.b();
                    if ((b && b3) || (!b && !b3)) {
                        collection.add(ax.b(1));
                        if (f == 0) {
                            break Label_0538;
                        }
                    }
                    collection.add(ax.b(2));
                    if (f == 0) {
                        break Label_0538;
                    }
                }
                if (this.w == 2 && !b(x, d)) {
                    final boolean b4 = l.a() > i.a();
                    if ((b && b4) || (!b && !b4)) {
                        collection.add(ax.b(8));
                        if (f == 0) {
                            break Label_0538;
                        }
                    }
                    collection.add(ax.b(4));
                }
            }
        }
        if (collection == null) {
            collection = new ArrayList<ax>(this.s);
            if (d.e()) {
                collection.addAll(this.a(x.a((Object)(b ? d.c() : d.d()))));
            }
        }
        return this.a(collection);
    }
    
    private int b(final byte b) {
        final int f = y.f.i.v.f;
        Label_0081: {
            switch (b) {
                case 0: {
                    final int n = 15;
                    if (f != 0) {
                        break Label_0081;
                    }
                    return n;
                }
                case 1: {
                    final int n = 1;
                    if (f != 0) {
                        break Label_0081;
                    }
                    return n;
                }
                case 4: {
                    final int n = 4;
                    if (f != 0) {
                        break Label_0081;
                    }
                    return n;
                }
                case 2: {
                    final int n = 2;
                    if (f != 0) {
                        break Label_0081;
                    }
                    return n;
                }
                case 8: {
                    final int n = 8;
                    if (f != 0) {
                        break;
                    }
                    return n;
                }
            }
        }
        return 15;
    }
    
    private Collection a(final Collection collection) {
        final int f = y.f.i.v.f;
        ArrayList<ax> list = new ArrayList<ax>();
        boolean b = false;
        Label_0338: {
            Label_0332: {
                if (collection == null) {
                    list = (ArrayList<ax>)this.s;
                    if (f == 0) {
                        break Label_0332;
                    }
                }
                for (final ax ax : collection) {
                    Label_0120: {
                        if ((ax.a() & 0x1) == 0x1) {
                            if (ax.b()) {
                                list.add(ax.a(ax.c(), ax.d(), 1, ax.f()));
                                if (f == 0) {
                                    break Label_0120;
                                }
                            }
                            list.add(ax.a(1, ax.f()));
                        }
                    }
                    Label_0186: {
                        if ((ax.a() & 0x4) == 0x4) {
                            if (ax.b()) {
                                list.add(ax.a(ax.c(), ax.d(), 4, ax.f()));
                                if (f == 0) {
                                    break Label_0186;
                                }
                            }
                            list.add(ax.a(4, ax.f()));
                        }
                    }
                    Label_0252: {
                        if ((ax.a() & 0x2) == 0x2) {
                            if (ax.b()) {
                                list.add(ax.a(ax.c(), ax.d(), 2, ax.f()));
                                if (f == 0) {
                                    break Label_0252;
                                }
                            }
                            list.add(ax.a(2, ax.f()));
                        }
                    }
                    if ((ax.a() & 0x8) == 0x8) {
                        b = ax.b();
                        if (f != 0) {
                            break Label_0338;
                        }
                        if (b) {
                            list.add(ax.a(ax.c(), ax.d(), 8, ax.f()));
                            if (f == 0) {
                                continue;
                            }
                        }
                        list.add(ax.a(8, ax.f()));
                        if (f != 0) {
                            break;
                        }
                        continue;
                    }
                }
            }
            list.isEmpty();
        }
        if (b) {
            list = (ArrayList<ax>)this.s;
        }
        return list;
    }
    
    private D a(final X x, final y.c.q q, final y.c.q q2, final ax ax, final ax ax2) {
        final int f = y.f.i.v.f;
        ax ax3 = ax;
        ax ax4 = ax2;
        final D d = new D();
        am a = x.a((Object)q);
        am a2 = x.a((Object)q2);
        final int a3 = ax3.a();
        int n = ax4.a();
        final double[] array = { 1.0, 0.0, 0.0, 1.0 };
        Label_0462: {
            switch (a3) {
                default: {
                    this.i = this.g;
                    if (f != 0) {
                        break Label_0462;
                    }
                    break;
                }
                case 4: {
                    array[0] = 0.0;
                    array[1] = -1.0;
                    array[2] = 1.0;
                    array[3] = 0.0;
                    a = new y.f.x(a.getY(), -(a.getX() + a.getWidth()), a.getHeight(), a.getWidth());
                    a2 = new y.f.x(a2.getY(), -(a2.getX() + a2.getWidth()), a2.getHeight(), a2.getWidth());
                    this.i = new t(this.g.b(), -this.g.a());
                    n = this.a(n, (byte)2);
                    if (f != 0) {
                        break Label_0462;
                    }
                    break;
                }
                case 2: {
                    array[0] = -1.0;
                    array[2] = (array[1] = 0.0);
                    array[3] = -1.0;
                    a = new y.f.x(-(a.getX() + a.getWidth()), -(a.getY() + a.getHeight()), a.getWidth(), a.getHeight());
                    a2 = new y.f.x(-(a2.getX() + a2.getWidth()), -(a2.getY() + a2.getHeight()), a2.getWidth(), a2.getHeight());
                    this.i = new t(-this.g.a(), -this.g.b());
                    n = this.a(n, (byte)1);
                    if (f != 0) {
                        break Label_0462;
                    }
                    break;
                }
                case 8: {
                    array[0] = 0.0;
                    array[1] = 1.0;
                    array[2] = -1.0;
                    array[3] = 0.0;
                    a = new y.f.x(-(a.getY() + a.getHeight()), a.getX(), a.getHeight(), a.getWidth());
                    a2 = new y.f.x(-(a2.getY() + a2.getHeight()), a2.getX(), a2.getHeight(), a2.getWidth());
                    this.i = new t(-this.g.b(), this.g.a());
                    n = this.a(n, (byte)0);
                    break;
                }
            }
        }
        Label_0700: {
            if (!ax.b()) {
                ax3 = this.a(ax, a, 1);
                if (f == 0) {
                    break Label_0700;
                }
            }
            ax3 = ax.a(ax3.c() * array[0] + ax3.d() * array[2], ax3.c() * array[1] + ax3.d() * array[3], ax3.a(), ax3.f());
        }
        Label_0790: {
            if (!ax2.b()) {
                ax4 = this.a(ax2, a2, n);
                if (f == 0) {
                    break Label_0790;
                }
            }
            ax4 = ax.a(ax4.c() * array[0] + ax4.d() * array[2], ax4.c() * array[1] + ax4.d() * array[3], ax4.a(), ax4.f());
        }
        int a4 = 0;
        Label_0814: {
            if (q == q2) {
                a4 = 8;
                if (f == 0) {
                    break Label_0814;
                }
            }
            a4 = this.a(a, a2);
        }
        final double n2 = a.getX() + 0.5 * a.getWidth();
        final double n3 = a.getY() + 0.5 * a.getHeight();
        final double n4 = a2.getX() + 0.5 * a2.getWidth();
        final double n5 = a2.getY() + 0.5 * a2.getHeight();
        final double n6 = n2 + ax3.c();
        final double n7 = n3 + ax3.d();
        final double n8 = n4 + ax4.c();
        final double n9 = n5 + ax4.d();
        d.add(new t(n2 + ax3.c(), n3 + ax3.d()));
        Label_6553: {
            switch (a4) {
                case 8: {
                    final double n10 = Math.min(a.getHeight(), a.getWidth()) / 2.0;
                    this.d(d, n7 - a.getY() + n10, true);
                    Label_1332: {
                        switch (n) {
                            case 1: {
                                final double n11 = n6 - n8;
                                Label_1157: {
                                    if (n11 != 0.0) {
                                        this.b(d, n11, false);
                                        if (f == 0) {
                                            break Label_1157;
                                        }
                                    }
                                    this.b(d, n6 - a.getX(), false);
                                }
                                this.a(d, n9 - this.b(d), false);
                                if (f != 0) {
                                    break Label_1332;
                                }
                                break Label_6553;
                            }
                            case 4: {
                                this.c(d, a.getX() + a.getWidth() - n6 + n10, true);
                                this.a(d, n9 - this.b(d), false);
                                this.b(d, this.a(d) - n8, false);
                                if (f != 0) {
                                    break Label_1332;
                                }
                                break Label_6553;
                            }
                            case 2: {
                                this.b(d, n6 - a.getX() + n10, true);
                                this.a(d, a.getY() + a.getHeight() + n10 - this.b(d), true);
                                this.c(d, n8 - this.a(d), false);
                                this.d(d, this.b(d) - n9, false);
                                if (f != 0) {
                                    break Label_1332;
                                }
                                break Label_6553;
                            }
                            case 8: {
                                this.b(d, n6 - a.getX() + n10, true);
                                this.a(d, n9 - this.b(d), false);
                                this.c(d, n8 - this.a(d), false);
                                if (f != 0) {
                                    break;
                                }
                                break Label_6553;
                            }
                        }
                    }
                    if (f != 0) {
                        break Label_6553;
                    }
                    break;
                }
                case 0: {
                    final double n12 = a.getX() + a.getWidth() - n6;
                    final double n13 = a2.getX() + a2.getWidth() - n6;
                    final double n14 = n8 - n6;
                    final double n15 = a.getY() + a.getHeight();
                    final double y = a2.getY();
                    double a5 = 0.0;
                    Label_1529: {
                        if (this.f) {
                            a5 = this.a(a.getY() + a.getHeight() + this.b, true, true);
                            if (f == 0) {
                                break Label_1529;
                            }
                        }
                        a5 = a.getY() + a.getHeight() + this.b;
                    }
                    Label_2017: {
                        switch (n) {
                            case 1: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                if (n14 > n12 + this.b) {
                                    this.c(d, n14, false);
                                    this.a(d, n9 - this.b(d), false);
                                    if (f == 0) {
                                        break Label_6553;
                                    }
                                }
                                this.c(d, n12 + this.b, true);
                                Label_1768: {
                                    if (this.a(n15, y, a5)) {
                                        this.a(d, a.getY() + a.getHeight() + this.b - this.b(d), true);
                                        if (f == 0) {
                                            break Label_1768;
                                        }
                                    }
                                    this.a(d, a.getY() + a.getHeight() + 0.5 * (a2.getY() - (a.getY() + a.getHeight())) - this.b(d), false);
                                }
                                this.b(d, this.a(d) - n8, false);
                                this.a(d, n9 - this.b(d), false);
                                if (f != 0) {
                                    break Label_2017;
                                }
                                break Label_6553;
                            }
                            case 4: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                this.c(d, Math.max(n13, n12) + this.b, true);
                                this.a(d, n9 - this.b(d), false);
                                this.b(d, this.a(d) - n8, false);
                                if (f != 0) {
                                    break Label_2017;
                                }
                                break Label_6553;
                            }
                            case 2: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                Label_1946: {
                                    if (n13 > n12) {
                                        this.c(d, n13 + this.b, true);
                                        if (f == 0) {
                                            break Label_1946;
                                        }
                                    }
                                    this.c(d, n12 + this.b, true);
                                }
                                this.a(d, a2.getY() + a2.getHeight() + this.b - this.b(d), true);
                                this.b(d, this.a(d) - n8, false);
                                this.d(d, this.b(d) - n9, false);
                                if (f != 0) {
                                    break Label_2017;
                                }
                                break Label_6553;
                            }
                            case 8: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                Label_2080: {
                                    if (n13 > n12) {
                                        this.c(d, n13 + this.b, true);
                                        if (f == 0) {
                                            break Label_2080;
                                        }
                                    }
                                    this.c(d, n12 + this.b, true);
                                }
                                this.a(d, a2.getY() + a2.getHeight() + this.b - this.b(d), true);
                                this.b(d, this.a(d) - a2.getX() + this.b, true);
                                this.d(d, this.b(d) - n9, false);
                                this.c(d, n8 - this.a(d), false);
                                if (f != 0) {
                                    break;
                                }
                                break Label_6553;
                            }
                        }
                    }
                    if (f != 0) {
                        break Label_6553;
                    }
                    break;
                }
                case 1: {
                    final boolean b = n6 < a2.getX();
                    final boolean b2 = n6 > a2.getX() + a2.getWidth();
                    Label_3116: {
                        switch (n) {
                            case 1: {
                                Label_2458: {
                                    if (b) {
                                        this.d(d, n7 - a2.getY() + this.b, true);
                                        this.c(d, n8 - n6, false);
                                        if (f == 0) {
                                            break Label_2458;
                                        }
                                    }
                                    if (b2) {
                                        this.d(d, n7 - a2.getY() + this.b, true);
                                        this.b(d, n6 - n8, false);
                                        if (f == 0) {
                                            break Label_2458;
                                        }
                                    }
                                    this.d(d, n7 - a.getY() + this.b, true);
                                    this.c(d, a2.getX() + a2.getWidth() - n6 + this.b, true);
                                    this.d(d, a.getY() - a2.getY(), true);
                                    this.b(d, this.a(d) - n8, false);
                                }
                                this.a(d, n9 - this.b(d), false);
                                if (f != 0) {
                                    break Label_3116;
                                }
                                break Label_6553;
                            }
                            case 4: {
                                if (b2) {
                                    this.d(d, n7 - n9, false);
                                    this.b(d, n6 - n8, false);
                                    if (f == 0) {
                                        break Label_6553;
                                    }
                                }
                                this.d(d, n7 - a.getY() + this.b, true);
                                this.c(d, a2.getX() + a2.getWidth() - n6 + this.b, true);
                                this.d(d, this.b(d) - n9, false);
                                this.b(d, this.a(d) - n8, false);
                                if (f != 0) {
                                    break Label_3116;
                                }
                                break Label_6553;
                            }
                            case 2: {
                                double n16 = a.getX();
                                if (a2.getX() > a.getX()) {
                                    n16 = a2.getX();
                                }
                                double n17 = a2.getX() + a2.getWidth();
                                if (a.getX() + a.getWidth() < a2.getX() + a2.getWidth()) {
                                    n17 = a.getX() + a.getWidth();
                                }
                                final double n18 = n16 + 0.5 * (n17 - n16);
                                if (ax.b() && ax2.b()) {
                                    if (Math.abs(n6 - n8) < 0.001) {
                                        this.d(d, n7 - n9, false);
                                        if (f == 0) {
                                            break Label_6553;
                                        }
                                    }
                                    this.d(d, n7 - a.getY() + this.b, true);
                                    this.c(d, n8 - n6, false);
                                    this.d(d, this.b(d) - n9, false);
                                    if (f == 0) {
                                        break Label_6553;
                                    }
                                }
                                if (ax.b()) {
                                    if (n6 >= n16 && n6 <= n17) {
                                        this.d(d, n7 - n9, false);
                                        if (f == 0) {
                                            break Label_6553;
                                        }
                                    }
                                    this.d(d, n7 - a.getY() + this.b, true);
                                    this.c(d, n18 - n6, false);
                                    this.d(d, a.getY() - n9 - this.b, false);
                                    if (f == 0) {
                                        break Label_6553;
                                    }
                                }
                                if (ax2.b()) {
                                    if (n8 >= n16 && n8 <= n17) {
                                        d.clear();
                                        d.add(new t(n8, a.getY()));
                                        this.d(d, n7 - n9, false);
                                        if (f == 0) {
                                            break Label_6553;
                                        }
                                    }
                                    this.d(d, n7 - a.getY() + this.b, true);
                                    this.c(d, n8 - n6, false);
                                    this.d(d, a.getY() - n9 - this.b, false);
                                    if (f == 0) {
                                        break Label_6553;
                                    }
                                }
                                d.clear();
                                d.add(new t(n18, a.getY()));
                                this.d(d, a.getY() - (a2.getY() + a2.getHeight()), false);
                                if (f != 0) {
                                    break Label_3116;
                                }
                                break Label_6553;
                            }
                            case 8: {
                                if (b) {
                                    this.d(d, n7 - n9, false);
                                    this.c(d, n8 - n6, false);
                                    if (f == 0) {
                                        break Label_6553;
                                    }
                                }
                                this.d(d, n7 - a.getY() + this.b, true);
                                this.b(d, n6 - a2.getX() + this.b, true);
                                this.d(d, this.b(d) - n9, false);
                                this.c(d, n8 - this.a(d), false);
                                if (f != 0) {
                                    break;
                                }
                                break Label_6553;
                            }
                        }
                    }
                    if (f != 0) {
                        break Label_6553;
                    }
                    break;
                }
                case 4: {
                    final double n19 = a.getX() + a.getWidth();
                    final double x2 = a2.getX();
                    double a6 = 0.0;
                    Label_3324: {
                        if (this.f) {
                            a6 = this.a(a.getX() + a.getWidth() + this.b, true, true);
                            if (f == 0) {
                                break Label_3324;
                            }
                        }
                        a6 = a.getX() + a.getWidth() + this.b;
                    }
                    Label_3737: {
                        switch (n) {
                            case 1: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                this.c(d, n8 - n6, false);
                                this.a(d, n9 - this.b(d), false);
                                if (f != 0) {
                                    break Label_3737;
                                }
                                break Label_6553;
                            }
                            case 4: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                this.c(d, a2.getX() + a2.getWidth() - n6 + this.b, true);
                                this.a(d, n9 - this.b(d), false);
                                this.b(d, this.a(d) - n8, false);
                                if (f != 0) {
                                    break Label_3737;
                                }
                                break Label_6553;
                            }
                            case 2: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                Label_3716: {
                                    if (this.a(n19, x2, a6)) {
                                        this.c(d, a.getX() + a.getWidth() + this.b - n6, true);
                                        this.a(d, a2.getY() + a2.getHeight() + this.b - this.b(d), true);
                                        this.c(d, n8 - this.a(d), false);
                                        if (f == 0) {
                                            break Label_3716;
                                        }
                                    }
                                    this.c(d, a2.getX() + a2.getWidth() + this.b - n6, true);
                                    this.a(d, a2.getY() + a2.getHeight() + this.b - this.b(d), true);
                                    this.b(d, this.a(d) - n8, false);
                                }
                                this.d(d, this.b(d) - n9, false);
                                if (f != 0) {
                                    break Label_3737;
                                }
                                break Label_6553;
                            }
                            case 8: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                Label_3829: {
                                    if (this.a(n19, x2, a6)) {
                                        this.c(d, a.getX() + a.getWidth() + this.b - n6, true);
                                        if (f == 0) {
                                            break Label_3829;
                                        }
                                    }
                                    this.b(d, n6 - a.getX() + this.b, true);
                                }
                                this.a(d, n9 - this.b(d), false);
                                this.c(d, n8 - this.a(d), false);
                                if (f != 0) {
                                    break;
                                }
                                break Label_6553;
                            }
                        }
                    }
                    if (f != 0) {
                        break Label_6553;
                    }
                    break;
                }
                case 5: {
                    final double n20 = a2.getX() + a2.getWidth();
                    final double x3 = a.getX();
                    double a7 = 0.0;
                    Label_3943: {
                        if (this.f) {
                            a7 = this.a(a.getX() - this.b, false, true);
                            if (f == 0) {
                                break Label_3943;
                            }
                        }
                        a7 = a.getX() - this.b;
                    }
                    Label_4405: {
                        switch (n) {
                            case 1: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                this.b(d, n6 - n8, false);
                                this.a(d, n9 - this.b(d), false);
                                if (f != 0) {
                                    break Label_4405;
                                }
                                break Label_6553;
                            }
                            case 4: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                Label_4139: {
                                    if (this.a(n20, x3, a7)) {
                                        this.b(d, n6 - a.getX() + this.b, true);
                                        if (f == 0) {
                                            break Label_4139;
                                        }
                                    }
                                    this.c(d, a.getX() + a.getWidth() - n6 + this.b, true);
                                }
                                this.a(d, n9 - this.b(d), false);
                                this.b(d, this.a(d) - n8, false);
                                if (f != 0) {
                                    break Label_4405;
                                }
                                break Label_6553;
                            }
                            case 2: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                if (this.a(n20, x3, a7)) {
                                    this.b(d, n6 - a.getX() + this.b, true);
                                    this.a(d, this.b + a2.getY() + a2.getHeight() - this.b(d), true);
                                    this.b(d, this.a(d) - n8, false);
                                    this.d(d, this.b(d) - n9, false);
                                    if (f == 0) {
                                        break Label_6553;
                                    }
                                }
                                this.c(d, a.getX() + a.getWidth() - n6 + this.b, true);
                                this.a(d, this.b + a2.getY() + a2.getHeight() - this.b(d), true);
                                this.b(d, this.a(d) - n8, false);
                                this.d(d, this.b(d) - n9, false);
                                if (f != 0) {
                                    break Label_4405;
                                }
                                break Label_6553;
                            }
                            case 8: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                this.b(d, n6 - a2.getX() + this.b, true);
                                this.a(d, n9 - this.b(d), false);
                                this.c(d, n8 - this.a(d), false);
                                if (f != 0) {
                                    break;
                                }
                                break Label_6553;
                            }
                        }
                    }
                    if (f != 0) {
                        break Label_6553;
                    }
                    break;
                }
                case 7: {
                    final double n21 = a2.getY() + a2.getHeight();
                    final double y2 = a.getY();
                    double a8 = 0.0;
                    Label_4563: {
                        if (this.f) {
                            a8 = this.a(a.getY() - this.b, false, false);
                            if (f == 0) {
                                break Label_4563;
                            }
                        }
                        a8 = a.getY() - this.b;
                    }
                    Label_4869: {
                        switch (n) {
                            case 1: {
                                this.d(d, n7 - a2.getY() + this.b, true);
                                this.b(d, n6 - n8, false);
                                this.a(d, n9 - this.b(d), false);
                                if (f != 0) {
                                    break Label_4869;
                                }
                                break Label_6553;
                            }
                            case 4: {
                                this.d(d, n7 - n9, false);
                                this.b(d, n6 - n8, false);
                                if (f != 0) {
                                    break Label_4869;
                                }
                                break Label_6553;
                            }
                            case 2: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                if (this.a(n21, y2, a8)) {
                                    this.b(d, n6 - n8, false);
                                    this.d(d, this.b(d) - n9, false);
                                    if (f == 0) {
                                        break Label_6553;
                                    }
                                }
                                this.c(d, a.getX() + a.getWidth() + this.b - this.a(d), true);
                                this.a(d, a.getY() + a.getHeight() + this.b - this.b(d), true);
                                this.b(d, this.a(d) - n8, false);
                                this.d(d, this.b(d) - n9, false);
                                if (f != 0) {
                                    break Label_4869;
                                }
                                break Label_6553;
                            }
                            case 8: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                Label_5053: {
                                    if (this.a(n21, y2, a8)) {
                                        this.b(d, n6 - a2.getX() + this.b, true);
                                        this.d(d, this.b(d) - n9, false);
                                        if (f == 0) {
                                            break Label_5053;
                                        }
                                    }
                                    this.c(d, a.getX() + a.getWidth() - n6 + this.b, true);
                                    this.a(d, a.getY() + a.getHeight() + this.b - this.b(d), true);
                                    this.b(d, this.a(d) - a2.getX() + this.b, true);
                                    this.d(d, this.b(d) - n9, false);
                                }
                                this.c(d, n8 - this.a(d), false);
                                if (f != 0) {
                                    break;
                                }
                                break Label_6553;
                            }
                        }
                    }
                    if (f != 0) {
                        break Label_6553;
                    }
                    break;
                }
                case 6: {
                    final double n22 = a2.getY() + a2.getHeight();
                    final double y3 = a.getY();
                    double a9 = 0.0;
                    Label_5151: {
                        if (this.f) {
                            a9 = this.a(a.getY() - this.b, false, false);
                            if (f == 0) {
                                break Label_5151;
                            }
                        }
                        a9 = a.getY() - this.b;
                    }
                    Label_5629: {
                        switch (n) {
                            case 1: {
                                this.d(d, n7 - a2.getY() + this.b, true);
                                this.c(d, n8 - n6, false);
                                this.a(d, n9 - this.b(d), false);
                                if (f != 0) {
                                    break Label_5629;
                                }
                                break Label_6553;
                            }
                            case 4: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                Label_5447: {
                                    if (this.a(n22, y3, a9)) {
                                        this.c(d, a2.getX() + a2.getWidth() - n6 + this.b, true);
                                        this.d(d, this.b(d) - n9, false);
                                        if (f == 0) {
                                            break Label_5447;
                                        }
                                    }
                                    this.b(d, n6 - a.getX() + this.b, true);
                                    this.a(d, a.getY() + a.getHeight() + this.b - this.b(d), true);
                                    this.c(d, a2.getX() + a2.getWidth() + this.b - this.a(d), true);
                                    this.d(d, this.b(d) - n9, false);
                                }
                                this.b(d, this.a(d) - n8, false);
                                if (f != 0) {
                                    break Label_5629;
                                }
                                break Label_6553;
                            }
                            case 2: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                if (this.a(n22, y3, a9)) {
                                    this.c(d, n8 - n6, false);
                                    this.d(d, this.b(d) - n9, false);
                                    if (f == 0) {
                                        break Label_6553;
                                    }
                                }
                                this.b(d, n6 - a.getX() + this.b, true);
                                this.a(d, a.getY() + a.getHeight() + this.b - this.b(d), true);
                                this.c(d, n8 - this.a(d), false);
                                this.d(d, this.b(d) - n9, false);
                                if (f != 0) {
                                    break Label_5629;
                                }
                                break Label_6553;
                            }
                            case 8: {
                                this.d(d, n7 - n9, false);
                                this.c(d, n8 - n6, false);
                                if (f != 0) {
                                    break;
                                }
                                break Label_6553;
                            }
                        }
                    }
                    if (f != 0) {
                        break Label_6553;
                    }
                    break;
                }
                case 2: {
                    final double n23 = n7 - a.getY();
                    final double n24 = n7 - a2.getY();
                    final double n25 = n7 - n9;
                    final double n26 = a.getX() + a.getWidth();
                    final double x4 = a2.getX();
                    double a10 = 0.0;
                    Label_5782: {
                        if (this.f) {
                            a10 = this.a(a.getX() + a.getWidth() + this.b, true, true);
                            if (f == 0) {
                                break Label_5782;
                            }
                        }
                        a10 = a.getX() + a.getWidth() + this.b;
                    }
                    Label_6353: {
                        switch (n) {
                            case 1: {
                                Label_5889: {
                                    if (n23 > n24) {
                                        this.d(d, n7 - a.getY() + this.b, true);
                                        if (f == 0) {
                                            break Label_5889;
                                        }
                                    }
                                    this.d(d, n7 - a2.getY() + this.b, true);
                                }
                                this.c(d, n8 - n6, false);
                                this.a(d, n9 - this.b(d), false);
                                if (f != 0) {
                                    break Label_6353;
                                }
                                break Label_6553;
                            }
                            case 4: {
                                Label_5979: {
                                    if (n23 > n24) {
                                        this.d(d, n7 - a.getY() + this.b, true);
                                        if (f == 0) {
                                            break Label_5979;
                                        }
                                    }
                                    this.d(d, n7 - a2.getY() + this.b, true);
                                }
                                this.c(d, a2.getX() + a2.getWidth() - n6 + this.b, true);
                                this.a(d, n9 - this.b(d), false);
                                this.b(d, this.a(d) - n8, false);
                                if (f != 0) {
                                    break Label_6353;
                                }
                                break Label_6553;
                            }
                            case 2: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                if (this.a(n26, x4, a10)) {
                                    this.c(d, a.getX() + a.getWidth() - n6 + this.b, true);
                                    this.a(d, a2.getY() + a2.getHeight() + this.b - this.b(d), true);
                                    this.c(d, n8 - this.a(d), false);
                                    this.d(d, this.b(d) - n9, false);
                                    if (f == 0) {
                                        break Label_6553;
                                    }
                                }
                                this.b(d, n6 - a.getX() + this.b, true);
                                Label_6316: {
                                    if (a.getY() + a.getHeight() + this.b > a2.getY() + a2.getHeight()) {
                                        this.a(d, a.getY() + a.getHeight() + this.b - this.b(d), true);
                                        if (f == 0) {
                                            break Label_6316;
                                        }
                                    }
                                    this.a(d, a2.getY() + a2.getHeight() + this.b - this.b(d), true);
                                }
                                this.c(d, n8 - this.a(d), false);
                                this.d(d, this.b(d) - n9, false);
                                if (f != 0) {
                                    break Label_6353;
                                }
                                break Label_6553;
                            }
                            case 8: {
                                if (n25 >= n23 + this.b) {
                                    this.d(d, n25, false);
                                    this.c(d, n8 - n6, false);
                                    if (f == 0) {
                                        break Label_6553;
                                    }
                                }
                                this.d(d, n23 + this.b, true);
                                Label_6511: {
                                    if (this.a(n26, x4, a10)) {
                                        this.c(d, a.getX() + a.getWidth() + this.b - this.a(d), true);
                                        if (f == 0) {
                                            break Label_6511;
                                        }
                                    }
                                    this.c(d, a2.getX() - 0.5 * (a2.getX() - (a.getX() + a.getWidth())) - this.a(d), false);
                                }
                                this.a(d, n9 - this.b(d), false);
                                this.c(d, n8 - this.a(d), false);
                                if (f != 0) {
                                    break;
                                }
                                break Label_6553;
                            }
                        }
                    }
                    if (f != 0) {
                        break Label_6553;
                    }
                    break;
                }
                case 3: {
                    final double n27 = n7 - a.getY();
                    final double n28 = n7 - a2.getY();
                    final double n29 = n7 - n9;
                    final double n30 = a2.getX() + a2.getWidth();
                    final double x5 = a.getX();
                    double a11 = 0.0;
                    Label_6656: {
                        if (this.f) {
                            a11 = this.a(a.getX() - this.b, false, true);
                            if (f == 0) {
                                break Label_6656;
                            }
                        }
                        a11 = a.getX() - this.b;
                    }
                    Label_7320: {
                        switch (n) {
                            case 1: {
                                Label_6761: {
                                    if (n27 > n28) {
                                        this.d(d, n7 - a.getY() + this.b, true);
                                        if (f == 0) {
                                            break Label_6761;
                                        }
                                    }
                                    this.d(d, n7 - a2.getY() + this.b, true);
                                }
                                this.b(d, n6 - n8, false);
                                this.a(d, n9 - this.b(d), false);
                                if (f != 0) {
                                    break Label_7320;
                                }
                                break;
                            }
                            case 4: {
                                if (n29 >= n27 + this.b) {
                                    this.d(d, n29, false);
                                    this.b(d, n6 - n8, false);
                                    if (f == 0) {
                                        break;
                                    }
                                }
                                this.d(d, n27 + this.b, true);
                                Label_6944: {
                                    if (this.a(n30, x5, a11)) {
                                        this.b(d, n6 - a.getX() + this.b, true);
                                        if (f == 0) {
                                            break Label_6944;
                                        }
                                    }
                                    this.b(d, n6 - (a2.getX() + a2.getWidth()) - 0.5 * (a.getX() - (a2.getX() + a2.getWidth())), false);
                                }
                                this.a(d, n9 - this.b(d), false);
                                this.b(d, this.a(d) - n8, false);
                                if (f != 0) {
                                    break Label_7320;
                                }
                                break;
                            }
                            case 2: {
                                this.d(d, n7 - a.getY() + this.b, true);
                                if (this.a(n30, x5, a11)) {
                                    this.b(d, n6 - a.getX() + this.b, true);
                                    this.a(d, a2.getY() + a2.getHeight() + this.b - this.b(d), true);
                                    this.b(d, this.a(d) - n8, false);
                                    this.d(d, this.b(d) - n9, false);
                                    if (f == 0) {
                                        break;
                                    }
                                }
                                this.c(d, a.getX() + a.getWidth() - n6 + this.b, true);
                                if (a.getY() + a.getHeight() + this.b > a2.getY() + a2.getHeight()) {
                                    this.a(d, a.getY() + a.getHeight() + this.b - this.b(d), true);
                                    this.b(d, this.a(d) - n8, false);
                                    this.d(d, this.b(d) - n9, false);
                                    if (f == 0) {
                                        break;
                                    }
                                }
                                this.a(d, a2.getY() + a2.getHeight() + this.b - this.b(d), true);
                                this.b(d, this.a(d) - n8, false);
                                this.d(d, this.b(d) - n9, false);
                                if (f != 0) {
                                    break Label_7320;
                                }
                                break;
                            }
                            case 8: {
                                Label_7377: {
                                    if (n27 > n28) {
                                        this.d(d, n7 - a.getY() + this.b, true);
                                        if (f == 0) {
                                            break Label_7377;
                                        }
                                    }
                                    this.d(d, n7 - a2.getY() + this.b, true);
                                }
                                this.b(d, n6 - a2.getX() + this.b, true);
                                this.a(d, n9 - this.b(d), false);
                                this.c(d, n8 - this.a(d), false);
                                if (f != 0) {
                                    break;
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        p p5 = d.k();
        while (p5 != null) {
            final t t = (t)p5.c();
            p5.a(new t(t.a * array[0] + t.b * array[1], t.a * array[2] + t.b * array[3]));
            p5 = p5.a();
            if (f != 0) {
                break;
            }
        }
        return d;
    }
    
    protected double a(final d d, final D d2, final ax ax, final ax ax2) {
        final double e = this.e(d, d2, ax, ax2);
        final double c = this.c(d, d2, ax, ax2);
        final double f = this.f(d, d2, ax, ax2);
        final double d3 = this.d(d, d2, ax, ax2);
        final double b = this.b(d, d2, ax, ax2);
        if (d.e()) {
            return c + f + d3 + b;
        }
        double n = 0.0;
        if (this.w != 0) {
            final byte a = this.a(d2, ax, ax2);
            if (this.e() && a != 1 && a != 3) {
                n = 100000.0;
                if (y.f.i.v.f == 0) {
                    return e + c + f + b + n;
                }
            }
            if (this.f() && a != 2 && a != 3) {
                n = 100000.0;
            }
        }
        return e + c + f + b + n;
    }
    
    private byte a(final D d, final ax ax, final ax ax2) {
        final int f = y.f.i.v.f;
        final int[] array = new int[4];
        t t = null;
        H h = null;
        H h2 = null;
        final C m = d.m();
        while (m.f()) {
            final t t2 = (t)m.d();
            if (t != null) {
                final H h3 = new H(t, t2);
                final int[] array2 = array;
                final int d2 = h3.d();
                ++array2[d2];
                if (h == null) {
                    h = h3;
                }
                h2 = h3;
            }
            t = t2;
            m.g();
            if (f != 0) {
                break;
            }
        }
        byte b = 0;
        if ((array[0] == 0 || array[1] == 0) && (ax.a() != 255 || H.a(h)) && (ax2.a() != 255 || H.a(h2))) {
            b = 1;
            if (f == 0) {
                return b;
            }
        }
        if ((array[2] == 0 || array[3] == 0) && (ax.a() != 255 || !H.a(h)) && (ax2.a() != 255 || !H.a(h2))) {
            b = 2;
            if (f == 0) {
                return b;
            }
        }
        if ((array[2] == 0 || array[3] == 0) && (array[0] == 0 || array[1] == 0)) {
            b = 3;
        }
        return b;
    }
    
    protected double b(final d d, final D d2, final ax ax, final ax ax2) {
        return ax.f() + ax2.f();
    }
    
    protected double c(final d d, final D d2, final ax ax, final ax ax2) {
        return this.c * (d2.size() - 2);
    }
    
    protected double d(final d d, final D d2, final ax ax, final ax ax2) {
        if (ax.a() == ax2.a() && d.c() == d.d()) {
            return this.c + 1.0;
        }
        return 0.0;
    }
    
    protected double e(final d d, final D d2, final ax ax, final ax ax2) {
        final int f = y.f.i.v.f;
        double n = 0.0;
        t t = null;
        for (final t t2 : d2) {
            if (f != 0) {
                return 0.0;
            }
            if (t != null) {
                n += t.a(t2);
            }
            t = t2;
            if (f != 0) {
                break;
            }
        }
        if (n > 0.0) {
            return 1.0 - 1.0 / n;
        }
        return 0.0;
    }
    
    protected double f(final d d, final D d2, final ax ax, final ax ax2) {
        final int f = y.f.i.v.f;
        double n = 0.0;
        if (this.b() == 0.0 && this.d() == 0.0 && this.c() == 0.0) {
            return n;
        }
        t t = null;
        for (final t t2 : d2) {
            Label_0235: {
                if (t != null) {
                    ++this.p;
                    if (Math.abs(t2.a() - t.a()) <= 0.001) {
                        n = this.a(d, n, this.n, t2.a(), Math.min(t2.b(), t.b()), Math.max(t2.b(), t.b()));
                        if (f == 0) {
                            break Label_0235;
                        }
                    }
                    if (Math.abs(t2.b() - t.b()) <= 0.001) {
                        n = this.a(d, n, this.o, t2.b(), Math.min(t2.a(), t.a()), Math.max(t2.a(), t.a()));
                        if (f == 0) {
                            break Label_0235;
                        }
                    }
                    throw new IllegalStateException("Edge is not routed orthogonally!");
                }
            }
            t = t2;
            if (f != 0) {
                break;
            }
        }
        return n;
    }
    
    private double a(final d d, double n, final List list, final double n2, final double n3, final double n4) {
        final int f = y.f.i.v.f;
        int n5 = this.a(n2, list) - 1;
        if (n5 >= 0) {
            F f2 = list.get(n5);
            int e = f2.e;
            while (e != 0 && f2 != null) {
                Label_0139: {
                    if (!f2.a) {
                        f2.f.a = this.p;
                        if (f == 0) {
                            break Label_0139;
                        }
                    }
                    if (f2.a) {
                        if (f2.f.a == this.p) {
                            break Label_0139;
                        }
                        n += f2.f.a(d, n2, n3, n4, this);
                        --e;
                        if (f == 0) {
                            break Label_0139;
                        }
                    }
                    throw new InternalError("Event Type undefined!");
                }
                f2 = ((n5 > 0) ? list.get(--n5) : null);
                if (f != 0) {
                    break;
                }
            }
        }
        return n;
    }
    
    private int a(final double n, final List list) {
        final int f = y.f.i.v.f;
        if (list.isEmpty()) {
            return 0;
        }
        if (list.get(0).b > n) {
            return 0;
        }
        int n2 = 0;
        int size = list.size();
        int n5;
        while (true) {
            final int n3 = (n2 + size) / 2;
            final F f2 = list.get(n3);
            while (true) {
                Label_0128: {
                    if (f2.b < n) {
                        n2 = n3;
                        if (f == 0) {
                            break Label_0128;
                        }
                    }
                    final double n4 = dcmpl(f2.b, n);
                    if (n4 > 0) {
                        size = n3;
                        if (f == 0) {
                            break Label_0128;
                        }
                    }
                    if (f2.a) {
                        n2 = n3;
                        if (f == 0) {
                            break Label_0128;
                        }
                    }
                    size = n3;
                }
                if (size - n2 <= 1) {
                    final double n4;
                    n5 = (int)(n4 = size);
                    if (f == 0) {
                        break;
                    }
                    continue;
                }
                break;
            }
        }
        return n5;
    }
    
    private int a(final F f, final List list) {
        final int f2 = y.f.i.v.f;
        if (list.isEmpty()) {
            return 0;
        }
        if (list.get(0).compareTo(f) > 0) {
            return 0;
        }
        if (list.get(list.size() - 1).compareTo(f) < 0) {
            return list.size();
        }
        int n = 0;
        int size = list.size();
        int n3 = 0;
        while (true) {
            final int n2 = (n + size) / 2;
            while (true) {
                Label_0118: {
                    if (list.get(n2).compareTo(f) <= 0) {
                        n = n2;
                        if (f2 == 0) {
                            break Label_0118;
                        }
                    }
                    size = n3;
                }
                if (size - n <= 1) {
                    n3 = size;
                    if (f2 == 0) {
                        break;
                    }
                    continue;
                }
                break;
            }
        }
        return n3;
    }
    
    private boolean a(final double n, final double n2, final double n3) {
        return n3 - n >= this.b && n2 - n3 >= this.b;
    }
    
    private double a(final D d) {
        return ((t)d.i()).a();
    }
    
    private double b(final D d) {
        return ((t)d.i()).b();
    }
    
    private ax a(final ax ax, final am am, final int n) {
        final int f = y.f.i.v.f;
        double n2 = 0.0;
        double n3 = 0.0;
        Label_0221: {
            switch (n) {
                default: {
                    Label_0091: {
                        if (this.f) {
                            n2 = this.a(am.getX() + 0.5 * am.getWidth(), true);
                            if (f == 0) {
                                break Label_0091;
                            }
                        }
                        n2 = 0.0;
                    }
                    n3 = -am.getHeight() * 0.5;
                    if (f != 0) {
                        break Label_0221;
                    }
                    break;
                }
                case 4: {
                    n2 = am.getWidth() * 0.5;
                    if (this.f) {
                        n3 = this.a(am.getY() + 0.5 * am.getHeight(), false);
                        if (f == 0) {
                            break;
                        }
                    }
                    n3 = 0.0;
                    if (f != 0) {
                        break Label_0221;
                    }
                    break;
                }
                case 2: {
                    Label_0204: {
                        if (this.f) {
                            n2 = this.a(am.getX() + 0.5 * am.getWidth(), true);
                            if (f == 0) {
                                break Label_0204;
                            }
                        }
                        n2 = 0.0;
                    }
                    n3 = am.getHeight() * 0.5;
                    if (f != 0) {
                        break Label_0221;
                    }
                    break;
                }
                case 8: {
                    n2 = -am.getWidth() * 0.5;
                    if (this.f) {
                        n3 = this.a(am.getY() + 0.5 * am.getHeight(), false);
                        if (f == 0) {
                            break;
                        }
                    }
                    n3 = 0.0;
                    break;
                }
            }
        }
        return ax.a(n2, n3, ax.a(), ax.f());
    }
    
    private double a(final double n, final boolean b) {
        if (!this.f || this.h <= 0.0) {
            return 0.0;
        }
        final double n2 = b ? this.g.a() : this.g.b();
        final double n3 = Math.floor((n - n2) / this.h) * this.h - n;
        final double n4 = Math.ceil((n - n2) / this.h) * this.h - n;
        if (Math.abs(n3) < Math.abs(n4)) {
            return n3;
        }
        return n4;
    }
    
    private byte a(final am am, final am am2) {
        final int f = y.f.i.v.f;
        byte b = 0;
        final double x = am.getX();
        final double y = am.getY();
        final double width = am.getWidth();
        final double height = am.getHeight();
        final double x2 = am2.getX();
        final double y2 = am2.getY();
        final double width2 = am2.getWidth();
        final double height2 = am2.getHeight();
        final boolean b2 = x < x2 && x + width < x2;
        final boolean b3 = x > x2 && x > x2 + width2;
        final boolean b4 = y < y2 && y + height < y2;
        final boolean b5 = y > y2 && y > y2 + height2;
        if (!b2 && !b3) {
            if (y + height < y2) {
                b = 0;
                if (f == 0) {
                    return b;
                }
            }
            if (y > y2 + height2) {
                b = 1;
                if (f == 0) {
                    return b;
                }
            }
            if (y < y2) {
                b = 0;
                if (f == 0) {
                    return b;
                }
            }
            b = 1;
            if (f == 0) {
                return b;
            }
        }
        if (!b4 && !b5) {
            if (x + width < x2) {
                b = 2;
                if (f == 0) {
                    return b;
                }
            }
            if (x > x2 + width2) {
                b = 3;
                if (f == 0) {
                    return b;
                }
            }
            if (x < x2) {
                b = 2;
                if (f == 0) {
                    return b;
                }
            }
            b = 3;
            if (f == 0) {
                return b;
            }
        }
        if (x < x2) {
            if (y < y2) {
                b = 4;
                if (f == 0) {
                    return b;
                }
            }
            if (y <= y2) {
                return b;
            }
            b = 6;
            if (f == 0) {
                return b;
            }
        }
        if (x > x2) {
            if (y < y2) {
                b = 5;
                if (f == 0) {
                    return b;
                }
            }
            if (y > y2) {
                b = 7;
            }
        }
        return b;
    }
    
    private static boolean[] a(final int n) {
        final int f = v.f;
        final boolean[] array = new boolean[4];
        if ((n & 0x1) != 0x0) {
            array[0] = true;
            if (f == 0) {
                return array;
            }
        }
        if ((n & 0x4) != 0x0) {
            array[1] = true;
            if (f == 0) {
                return array;
            }
        }
        if ((n & 0x2) != 0x0) {
            array[2] = true;
            if (f == 0) {
                return array;
            }
        }
        if ((n & 0x8) != 0x0) {
            array[3] = true;
        }
        return array;
    }
    
    private static int a(final boolean[] array) {
        final int f = v.f;
        int n = 0;
        if (array[0]) {
            n |= 0x1;
            if (f == 0) {
                return n;
            }
        }
        if (array[1]) {
            n |= 0x4;
            if (f == 0) {
                return n;
            }
        }
        if (array[2]) {
            n |= 0x2;
            if (f == 0) {
                return n;
            }
        }
        if (array[3]) {
            n |= 0x8;
        }
        return n;
    }
    
    private int a(final int n, final byte b) {
        final int f = y.f.i.v.f;
        final boolean[] a = a(n);
        int i = 0;
        while (i < a.length) {
            final int a2;
            final boolean b2 = (a2 = (a[i] ? 1 : 0)) != 0;
            if (f != 0) {
                return a2;
            }
            Label_0153: {
                if (b2) {
                    int n2 = 0;
                    Label_0096: {
                        switch (b) {
                            case 0: {
                                n2 = (i + 1) % a.length;
                                if (f != 0) {
                                    break Label_0096;
                                }
                                break;
                            }
                            case 1: {
                                n2 = (i + 2) % a.length;
                                if (f != 0) {
                                    break Label_0096;
                                }
                                break;
                            }
                            case 2: {
                                n2 = (i + 3) % a.length;
                                if (f != 0) {
                                    throw new IllegalArgumentException("Undefined angle given: " + b);
                                }
                                break;
                            }
                        }
                    }
                    a[n2] = true;
                    a[i] = false;
                    if (f != 0) {
                        break Label_0153;
                    }
                    break;
                }
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
        return a(a);
    }
    
    private double a(final double n, final boolean b, final boolean b2) {
        if (!this.f) {
            return n;
        }
        if (b) {
            if (b2) {
                return Math.ceil((n - this.i.a()) / this.h) * this.h + this.i.a();
            }
            return Math.ceil((n - this.i.b()) / this.h) * this.h + this.i.b();
        }
        else {
            if (b2) {
                return Math.floor((n - this.i.a()) / this.h) * this.h + this.i.a();
            }
            return Math.floor((n - this.i.b()) / this.h) * this.h + this.i.b();
        }
    }
    
    private void a(final D d, final double n, final boolean b) {
        final double a = this.a(d);
        final double b2 = this.b(d);
        double a2 = 0.0;
        Label_0050: {
            if (b && this.f) {
                a2 = this.a(b2 + n, true, false);
                if (y.f.i.v.f == 0) {
                    break Label_0050;
                }
            }
            a2 = b2 + n;
        }
        d.add(new t(a, a2));
    }
    
    private void b(final D d, final double n, final boolean b) {
        final double a = this.a(d);
        final double b2 = this.b(d);
        double a2 = 0.0;
        Label_0050: {
            if (b && this.f) {
                a2 = this.a(a - n, false, true);
                if (y.f.i.v.f == 0) {
                    break Label_0050;
                }
            }
            a2 = a - n;
        }
        d.add(new t(a2, b2));
    }
    
    private void c(final D d, final double n, final boolean b) {
        final double a = this.a(d);
        final double b2 = this.b(d);
        double a2 = 0.0;
        Label_0050: {
            if (b && this.f) {
                a2 = this.a(a + n, true, true);
                if (y.f.i.v.f == 0) {
                    break Label_0050;
                }
            }
            a2 = a + n;
        }
        d.add(new t(a2, b2));
    }
    
    private void d(final D d, final double n, final boolean b) {
        final double a = this.a(d);
        final double b2 = this.b(d);
        double a2 = 0.0;
        Label_0050: {
            if (b && this.f) {
                a2 = this.a(b2 - n, false, false);
                if (y.f.i.v.f == 0) {
                    break Label_0050;
                }
            }
            a2 = b2 - n;
        }
        d.add(new t(a, a2));
    }
    
    private void a(final List list, final double n, final double n2, final double n3, final double n4) {
        final G g = new G(n, n2, n3, n4);
        final F f = new F(true, n, Math.min(n2, n4), Math.max(n2, n4), g);
        final F f2 = new F(false, n3, Math.min(n2, n4), Math.max(n2, n4), g);
        list.add(f);
        list.add(f2);
    }
    
    private void a(final List list) {
        final int f = y.f.i.v.f;
        y.g.e.a(list, null);
        final HashSet<J> set = (HashSet<J>)new HashSet<Object>();
        int e = 0;
        int n = 0;
        double b = -1.7976931348623157E308;
        int i = 0;
        while (i < list.size()) {
            final F f2 = list.get(i);
            Label_0298: {
                if (f2.b > b && n > this.q) {
                    final ArrayList list2 = new ArrayList<Object>();
                    for (final J j : set) {
                        if (i - j.a > this.r) {
                            list2.add(j);
                            final F a = j.a(false, f2.b);
                            a.e = --e;
                            list.add(i, a);
                            n -= i - f2.f.a;
                            ++i;
                            if (f != 0) {
                                break Label_0298;
                            }
                            if (f != 0) {
                                break;
                            }
                            continue;
                        }
                    }
                    int k = list2.size() - 1;
                    while (k >= 0) {
                        final J l = list2.get(k);
                        final F a2 = l.a(true, f2.b);
                        a2.e = ++e;
                        list.add(i, a2);
                        l.a = i;
                        ++i;
                        n += e;
                        --k;
                        if (f != 0) {
                            break Label_0298;
                        }
                        if (f != 0) {
                            break;
                        }
                    }
                }
                b = f2.b;
            }
            Label_0376: {
                if (f2.a) {
                    set.add(f2.f);
                    f2.f.a = i;
                    ++e;
                    if (f == 0) {
                        break Label_0376;
                    }
                }
                set.remove(f2.f);
                n -= i - f2.f.a;
                f2.f.a = 0;
                --e;
            }
            n += e;
            f2.e = e;
            ++i;
            if (f != 0) {
                break;
            }
        }
    }
    
    private void c(final D d) {
        final int f = y.f.i.v.f;
        t t = null;
        for (final t t2 : d) {
            if (t != null) {
                this.a(new t(t2.b, t2.a), new t(t.b, t.a), this.o);
                this.a(t2, t, this.n);
            }
            t = t2;
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final t t, final t t2, final List list) {
        final int f = y.f.i.v.f;
        t t3 = null;
        t t4 = null;
        Label_0034: {
            if (t.a() <= t2.a()) {
                t3 = t;
                t4 = t2;
                if (f == 0) {
                    break Label_0034;
                }
            }
            t3 = t2;
            t4 = t;
        }
        final G g = new G(t3.a(), t3.b(), t4.a(), t4.b());
        final F f2 = new F(true, t3.a(), t3.b(), t4.b(), g);
        final F f3 = new F(false, t4.a(), t4.b(), t3.b(), g);
        final int a = this.a(f3, list);
        final int a2 = this.a(f2, list);
        f3.e = ((list.size() > a - 1 && a > 0) ? list.get(a - 1).e : 0);
        int i = a2;
    Label_0265_Outer:
        while (true) {
            while (true) {
                while (i < a) {
                    final F f4 = list.get(i);
                    ++f4.e;
                    ++i;
                    if (f != 0) {
                        final int e = 0;
                        f2.e = e + 1;
                        list.add(a, f3);
                        list.add(a2, f2);
                        return;
                    }
                    if (f != 0) {
                        break;
                    }
                }
                if (list.size() > a2 - 1 && a2 > 0) {
                    final int e = list.get(a2 - 1).e;
                    continue;
                }
                break;
            }
            continue Label_0265_Outer;
        }
    }
    
    public void a(final Object t) {
        this.t = t;
    }
    
    public double b() {
        return this.d;
    }
    
    public double c() {
        return this.e;
    }
    
    public double d() {
        return this.v;
    }
    
    static {
        a = "y.layout.router.OrthogonalPatternEdgeRouter.AFFECTED_EDGES";
    }
}
