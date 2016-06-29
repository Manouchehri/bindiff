package y.f.i.a;

import y.g.*;
import y.f.*;
import y.c.*;
import java.util.*;

class bF extends ab
{
    private final List b;
    private final Set c;
    private final HashMap d;
    private final HashMap e;
    private final HashMap f;
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
        this.c = new HashSet();
        this.b = new D();
        this.e = new HashMap();
        this.f = new HashMap();
        this.d = new HashMap();
    }
    
    protected void a(final Z z) {
        super.a(z);
        final X a = z.a();
        this.m = (a.c(aF.c) != null || a.c(aF.d) != null);
        if (this.m) {
            this.d();
        }
    }
    
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
    
    private void d() {
        final int a = ab.a;
        final X a2 = this.a().a();
        final c c = a2.c(aF.c);
        final c c2 = a2.c(aF.d);
        final h b = M.b();
        a2.a(y.a, b);
        this.j = M.b();
        final e p = a2.p();
        while (true) {
            while (p.f()) {
                final d a3 = p.a();
                final c c3 = c;
                if (a != 0) {
                    bF bf = null;
                    Label_0589: {
                        if (c3 != null) {
                            final h b2 = M.b();
                            final e p2 = a2.p();
                            while (p2.f()) {
                                final d a4 = p2.a();
                                bf = this;
                                if (a != 0) {
                                    break Label_0589;
                                }
                                Label_0554: {
                                    if (this.t.b(a4) != null) {
                                        if (b.b(a4) != null) {
                                            if (this.j.d(a4)) {
                                                b2.a(a4, new bP(this, (x)this.t.b(a4), a4, true));
                                                if (a == 0) {
                                                    break Label_0554;
                                                }
                                            }
                                            b2.a(a4, new bP(this, (x)this.t.b(a4), a4, false));
                                            if (a == 0) {
                                                break Label_0554;
                                            }
                                        }
                                        b2.a(a4, this.t.b(a4));
                                    }
                                }
                                p2.g();
                                if (a != 0) {
                                    break;
                                }
                            }
                            a2.a("y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY", b2);
                        }
                        this.h = M.c();
                        this.g = M.c();
                        bf = this;
                    }
                    bf.i = M.c();
                    return;
                }
                Label_0208: {
                    if (c3 != null && c.b(a3) != null) {
                        b.a(a3, new bQ(a3.c(), c.b(a3)));
                        if (a == 0) {
                            break Label_0208;
                        }
                    }
                    if (c2 != null && c2.b(a3) != null) {
                        b.a(a3, new bQ(a3.d(), c2.b(a3)));
                        a2.c(a3);
                        ae.a(a2.b((Object)a3));
                        this.j.a(a3, true);
                    }
                }
                p.g();
                if (a != 0) {
                    break;
                }
            }
            this.p = a2.c(aF.a);
            this.q = a2.c(aF.b);
            this.r = a2.c(ax.a);
            this.s = a2.c(ax.b);
            this.n = c;
            this.o = c2;
            a2.a(aF.a, new bG(this));
            a2.a(aF.b, new bH(this));
            a2.a(ax.a, new bI(this));
            a2.a(ax.b, new bJ(this));
            a2.a(aF.c, new bK(this));
            a2.a(aF.d, new bL(this));
            this.t = a2.c("y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY");
            final c t = this.t;
            continue;
        }
    }
    
    private void e() {
        final int a = ab.a;
        final X a2 = this.a().a();
        Label_0048: {
            if (this.p != null) {
                a2.a(aF.a, this.p);
                this.p = null;
                if (a == 0) {
                    break Label_0048;
                }
            }
            a2.d_(aF.a);
        }
        Label_0083: {
            if (this.q != null) {
                a2.a(aF.b, this.q);
                this.q = null;
                if (a == 0) {
                    break Label_0083;
                }
            }
            a2.d_(aF.b);
        }
        Label_0118: {
            if (this.r != null) {
                a2.a(ax.a, this.r);
                this.r = null;
                if (a == 0) {
                    break Label_0118;
                }
            }
            a2.d_(ax.a);
        }
        Label_0153: {
            if (this.s != null) {
                a2.a(ax.b, this.s);
                this.s = null;
                if (a == 0) {
                    break Label_0153;
                }
            }
            a2.d_(ax.b);
        }
        Label_0188: {
            if (this.n != null) {
                a2.a(aF.c, this.n);
                this.n = null;
                if (a == 0) {
                    break Label_0188;
                }
            }
            a2.d_(aF.c);
        }
        Label_0223: {
            if (this.o != null) {
                a2.a(aF.d, this.o);
                this.o = null;
                if (a == 0) {
                    break Label_0223;
                }
            }
            a2.d_(aF.d);
        }
        Label_0256: {
            if (this.t != null) {
                a2.a("y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY", this.t);
                this.t = null;
                if (a == 0) {
                    break Label_0256;
                }
            }
            a2.d_("y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY");
        }
        final e p = a2.p();
        while (true) {
            while (p.f()) {
                final d a3 = p.a();
                final bF bf = this;
                if (a != 0) {
                    bf.j = null;
                    return;
                }
                if (this.j.d(a3)) {
                    a2.c(a3);
                    ae.a(a2.b((Object)a3));
                }
                p.g();
                if (a != 0) {
                    break;
                }
            }
            a2.d_(y.a);
            this.h = null;
            this.g = null;
            this.i = null;
            final bF bf = this;
            continue;
        }
    }
    
    protected void a(final aa aa) {
        final int a = ab.a;
        super.a(aa);
        if (!this.m) {
            return;
        }
        this.d.clear();
        final c c = this.a().a().c(y.a);
        if (c != null) {
            final e b = aa.b();
            while (b.f()) {
                final d a2 = b.a();
                final boolean d = this.j.d(a2);
                final Object b2 = c.b(a2);
                if (b2 != null) {
                    final x a3 = this.a().c().a(a2);
                    final double n = d ? a3.b() : a3.a();
                    if (!this.d.containsKey(b2) || this.d.get(b2) < n) {
                        this.d.put(b2, new Double(n));
                    }
                }
                b.g();
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    protected void b(final aa aa) {
        super.b(aa);
        if (!this.m) {
            return;
        }
        final X a = this.a().a();
        final d c = aa.c();
        this.k = a.c(y.a).b(c);
        List list = (List)this.g.b(this.k);
        if (this.k == null || this.l == null || !this.l.equals(this.k)) {
            this.f();
            if (list == null) {
                list = new D();
                this.g.a(this.k, list);
            }
        }
        this.l = this.k;
        list.add(c);
    }
    
    protected void c(final aa aa) {
        final int a = ab.a;
        super.c(aa);
        if (!this.m) {
            return;
        }
        final List list = (List)this.g.b(this.k);
        if (list != null) {
            list.remove(this.b().c());
        }
        final U a2 = aa.a().a(this.b().c());
        if (a2 != null) {
            int i = 0;
            while (i < a2.b()) {
                final List list2 = (List)this.h.b(a2.a(i));
                if (list2 != null) {
                    list2.remove(a2);
                }
                ++i;
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    private void f() {
        this.c.clear();
        this.b.clear();
        this.e.clear();
        this.f.clear();
    }
    
    protected void d(final aa aa) {
        if (!this.m) {
            return;
        }
        this.g(aa);
        this.i.a(this.k, this.b);
    }
    
    protected void e(final aa aa) {
        if (!this.m) {
            return;
        }
        final List f = this.f(aa);
        this.b(f);
        this.c(f);
        this.a(aa, f);
    }
    
    private List f(final aa aa) {
        final int a = ab.a;
        final HashSet<Object> set = new HashSet<Object>();
        final D d = new D();
        final c c = this.a().a().c(y.a);
        final e b = aa.b();
        while (b.f()) {
            final d a2 = b.a();
            if (c != null && c.b(a2) != null && set.add(c.b(a2))) {
                d.add(c.b(a2));
            }
            b.g();
            if (a != 0) {
                break;
            }
        }
        return d;
    }
    
    private void b(final List list) {
        final int a = ab.a;
        final Iterator<Object> iterator = list.iterator();
    Label_0182:
        while (true) {
            iterator.hasNext();
            int i = 0;
        Label_0018:
            while (i != 0) {
                final Iterator iterator2 = ((List)this.g.b(iterator.next())).iterator();
                while (iterator2.hasNext()) {
                    final U a2 = this.b().a().a(iterator2.next());
                    if (this.f.containsKey(a2)) {
                        final f f = this.f.get(a2);
                        final f f2 = this.e.get(f);
                        final int a3 = a2.a(f);
                        a2.a(a3, f2);
                        i = a2.b();
                        if (a != 0) {
                            continue Label_0018;
                        }
                        if (i <= a3 + 1) {
                            continue;
                        }
                        a2.a(a3 + 1).a(f2);
                        if (a != 0) {
                            break Label_0182;
                        }
                        continue;
                    }
                }
                continue Label_0182;
            }
            break;
        }
    }
    
    private void c(final List list) {
        final int a = ab.a;
        final Iterator<Object> iterator = list.iterator();
    Label_0129:
        while (iterator.hasNext()) {
            final List list2 = (List)this.i.b(iterator.next());
            if (list2 != null && !list2.isEmpty()) {
                for (final f f : list2) {
                    if (this.e.containsKey(f)) {
                        ((f)this.e.get(f)).a(f.c());
                        if (a != 0 || a != 0) {
                            break Label_0129;
                        }
                        continue;
                    }
                }
            }
        }
    }
    
    private void a(final aa aa, final List list) {
        final int a = ab.a;
        final Iterator<Object> iterator = list.iterator();
    Label_0388:
        while (true) {
            Iterator<Object> iterator2 = iterator;
        Label_0013:
            while (iterator2.hasNext()) {
                final List list2 = (List)this.g.b(iterator.next());
                final D d = new D();
                final Iterator<d> iterator3 = list2.iterator();
                while (iterator3.hasNext()) {
                    final U a2 = aa.a().a(iterator3.next());
                    if (a2 != null) {
                        d.add(a2);
                        if (a != 0) {
                            continue Label_0388;
                        }
                        if (a != 0) {
                            break;
                        }
                        continue;
                    }
                }
            Label_0352_Outer:
                while (!d.isEmpty()) {
                    Object o = null;
                    final D d2 = new D();
                    final D d3 = new D();
                    final Iterator iterator4 = iterator2 = (Iterator<Object>)d.iterator();
                    if (a != 0) {
                        continue Label_0013;
                    }
                    final Iterator iterator5 = iterator4;
                Label_0383_Outer:
                    while (true) {
                    Label_0383:
                        while (true) {
                            while (iterator5.hasNext()) {
                                final U u = iterator5.next();
                                final f a3 = u.a(0);
                                if (o == null) {
                                    o = a3;
                                    d3.add(u);
                                    d2.add(aa.i().a(u));
                                    if (a == 0) {
                                        continue Label_0352_Outer;
                                    }
                                }
                                if (o.equals(a3)) {
                                    d2.add(aa.i().a(u));
                                    d3.add(u);
                                    if (a == 0) {
                                        if (a != 0) {
                                            break;
                                        }
                                        continue Label_0352_Outer;
                                    }
                                    else {
                                        if (d.size() == d3.size()) {
                                            d.clear();
                                            if (a == 0) {
                                                continue Label_0352_Outer;
                                            }
                                        }
                                        d.removeAll(d3);
                                        if (a != 0) {
                                            break Label_0388;
                                        }
                                        continue Label_0352_Outer;
                                    }
                                }
                            }
                            if (d2.size() > 1) {
                                final D d4 = new D();
                                d4.add(new bN(this, d2, 0));
                                while (!d4.isEmpty()) {
                                    final D a4 = ((bN)d4.remove(0)).a();
                                    if (a4.size() > 0) {
                                        d4.a(a4);
                                        if (a != 0) {
                                            continue Label_0383;
                                        }
                                        if (a != 0) {
                                            break;
                                        }
                                        continue Label_0352_Outer;
                                    }
                                }
                            }
                            break;
                        }
                        continue Label_0383_Outer;
                    }
                }
                continue Label_0388;
            }
            break;
        }
    }
    
    protected double a(final f f) {
        if (!this.c.isEmpty() && !this.c.contains(f)) {
            return this.b().d().f().p();
        }
        return 0.0;
    }
    
    protected void a(final List list) {
        if (this.m) {
            list.addAll(this.b);
        }
    }
    
    private void g(final aa aa) {
        final int a = ab.a;
        final U a2 = aa.a().a(aa.c());
        if (a2 == null) {
            return;
        }
        final D d = new D();
        final HashMap<Object, f> hashMap = new HashMap<Object, f>();
        this.a(aa, d, hashMap);
        this.b.clear();
        this.c.clear();
    Label_0307_Outer:
        for (final f f : d) {
            final f f2 = hashMap.get(f);
            final P i = this.a(a2, f).i();
            if (i.d(f2.c())) {
                this.c.add(f2);
                this.b.add(f2);
                if (a == 0) {
                    continue Label_0307_Outer;
                }
            }
            final f f3 = new f(f);
            f3.a(i);
            this.e.put(f3, f);
            final D d2 = new D();
            while (true) {
                for (final U u : (List)this.h.b(f2)) {
                    if (i.c(this.a(u, f).i())) {
                        d2.add(u);
                        if (a == 0) {
                            if (a != 0) {
                                break;
                            }
                            continue Label_0307_Outer;
                        }
                        else {
                            if (d2.size() <= 0) {
                                continue Label_0307_Outer;
                            }
                            this.c.add(f3);
                            this.b.add(f3);
                            if (a != 0) {
                                break Label_0307_Outer;
                            }
                            continue Label_0307_Outer;
                        }
                    }
                }
                this.h.a(f3, d2);
                continue;
            }
        }
    }
    
    private v a(final U u, final f f) {
        final w a = this.b().i().a(u);
        final v a2 = a.a(f);
        if (a2 != null) {
            return a2;
        }
        return a.a(this.f.get(u));
    }
    
    private void a(final aa aa, final D d, final HashMap hashMap) {
        final int a = ab.a;
        final U a2 = aa.a().a(aa.c());
        if (a2 == null) {
            return;
        }
        int i = 0;
        while (i < a2.b()) {
            final f a3 = a2.a(i);
            final R a4 = a3.a();
            if ((this.b.size() == 0 || this.c.contains(a3)) && !aa.b(a4) && !aa.d(a4)) {
                final f f = this.e.containsKey(a3) ? this.e.get(a3) : a3;
                if (a3 != f) {
                    this.f.put(a2, a3);
                }
                hashMap.put(f, a3);
                d.add(f);
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
    }
    
    protected void a(final U u) {
        final int a = ab.a;
        if (this.m) {
            int i = 0;
            while (i < u.b()) {
                final f a2 = u.a(i);
                List list = (List)this.h.b(a2);
                if (list == null) {
                    list = new D();
                    this.h.a(a2, list);
                }
                list.add(u);
                ++i;
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    static h a(final bF bf) {
        return bf.j;
    }
    
    static c b(final bF bf) {
        return bf.q;
    }
    
    static c c(final bF bf) {
        return bf.p;
    }
    
    static c d(final bF bf) {
        return bf.s;
    }
    
    static c e(final bF bf) {
        return bf.r;
    }
    
    static c f(final bF bf) {
        return bf.o;
    }
    
    static c g(final bF bf) {
        return bf.n;
    }
    
    static HashMap h(final bF bf) {
        return bf.d;
    }
}
