package y.f.c;

import y.g.*;
import java.util.*;
import y.c.*;
import y.d.*;
import y.f.*;

class az
{
    private c a;
    private c b;
    private A c;
    private A d;
    private h e;
    private h f;
    private X g;
    private D h;
    private D i;
    private D j;
    private D k;
    private Map l;
    private Map m;
    private Set n;
    private Set o;
    private h p;
    private ap q;
    private A r;
    private c s;
    private h t;
    private c u;
    private D v;
    
    public az(final X g, final A c, final D v, final A d, final c a, final c b, final h e, final h f) {
        this.v = v;
        this.g = g;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        if (g.c(U.a) != null) {
            this.p = g.u();
            this.q = new ap(this.p, g, U.a);
        }
    }
    
    public void a(final A r, final c s, final h t, final c u) {
        this.r = r;
        this.t = t;
        this.s = s;
        this.u = u;
    }
    
    public boolean a() {
        return true;
    }
    
    public Object a(final q q) {
        aA aa = this.l.get(q);
        if (aa == null) {
            aa = this.m.get(q);
        }
        return (aa == null) ? null : aa.a;
    }
    
    public void a(final D d) {
        final boolean i = y.f.c.a.i;
        final A a = K.a((i)this.g);
        final ArrayList list = new ArrayList<d>(255);
        final HashSet<d> set = new HashSet<d>();
        this.h = new D();
        this.i = new D();
        this.j = new D();
        this.k = new D();
        this.l = new HashMap();
        this.m = new HashMap();
        int n = 0;
        final HashMap<Object, aA> hashMap = new HashMap<Object, aA>();
        final HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        final HashMap<Object, aA> hashMap3 = new HashMap<Object, aA>();
        final ArrayList<Object> list2 = new ArrayList<Object>(255);
        final ArrayList<Object> list3 = new ArrayList<Object>();
        final ArrayList list4 = new ArrayList<S>();
        final ArrayList list5 = new ArrayList();
        final ArrayList<S> list6 = new ArrayList<S>();
        p p = this.v.k();
        p p2 = d.k();
    Label_3127:
        while (true) {
            while (p2.a() != null) {
                final y y = (y)p2.c();
                final y y2 = (y)p2.a().c();
                hashMap3.clear();
                list2.clear();
                final p k = y.k();
                int a11 = 0;
                int n6 = 0;
                Label_3173: {
                    if (!i) {
                        p a2 = k;
                        while (a2 != null) {
                            final q q = (q)a2.c();
                            this.c.a(q, n);
                            final d d3;
                            final d d2 = d3 = q.f();
                            if (i) {
                                break Label_3127;
                            }
                            d g = d2;
                            while (g != null) {
                                final Object b;
                                final Object o = b = this.a.b(g);
                                if (i) {
                                    break Label_3127;
                                }
                                if (b != null) {
                                    aA aa = hashMap3.get(o);
                                    if (aa == null) {
                                        aa = new aA(o);
                                        hashMap3.put(o, aa);
                                        list2.add(aa);
                                    }
                                    aa.b.add(g);
                                }
                                g = g.g();
                                if (i) {
                                    break;
                                }
                            }
                            a2 = a2.a();
                            if (i) {
                                break;
                            }
                        }
                        if (hashMap3.size() > 0) {
                            ++n;
                            final y y3 = new y();
                            p2 = d.b(y3, p2);
                            p = this.v.b(am.a("SourceGroupNodeLayer", p.c()), p);
                            this.j.add(new Integer(n));
                            int j = list2.size() - 1;
                            while (j >= 0) {
                                final aA h = list2.get(j);
                                this.h.add(h);
                                final q d4 = this.g.d();
                                a.a(d4, K.r);
                                d d3;
                                final A a3 = (A)(d3 = (d)this.r);
                                if (i) {
                                    break Label_3127;
                                }
                                if (a3 != null) {
                                    this.r.a(d4, am.a("SourceGroupNode", h.a, p.c()));
                                }
                                h.d = d4;
                                this.g.a((Object)d4).setSize(0.0, 0.0);
                                this.l.put(d4, h);
                                y3.add(d4);
                                this.c.a(d4, n);
                                final aA g2 = hashMap.get(h.a);
                                if (g2 != null) {
                                    final d a4 = this.g.a(g2.d, d4);
                                    if (this.t != null) {
                                        this.t.a(a4, am.a("GroupNodeConnectorEdge", this.r.b(g2.d), this.r.b(d4)));
                                    }
                                    final aA aa2 = g2;
                                    final aA aa3 = h;
                                    final d d5 = a4;
                                    aa3.f = d5;
                                    aa2.e = d5;
                                    h.g = g2;
                                    g2.h = h;
                                    h.c.addAll(g2.c);
                                    g2.c.clear();
                                    g2.c = null;
                                }
                                d a5 = null;
                                list3.clear();
                                p p3 = h.b.k();
                                while (p3 != null) {
                                    final d d6 = (d)p3.c();
                                    list6.clear();
                                    final q c = d6.c();
                                    final d d7 = d3 = a5;
                                    if (i) {
                                        break Label_3127;
                                    }
                                    if (d7 == null || c != a5.c()) {
                                        if (list3.size() > 0 && a5 != null) {
                                            this.p.a(a5, list3.toArray(new S[list3.size()]));
                                            list3.clear();
                                        }
                                        a5 = this.g.a(c, d4);
                                        if (this.t != null) {
                                            this.t.a(a5, am.a("SourceGroupNodeConnector", this.s.b(c), this.r.b(d4)));
                                        }
                                        this.g.a(a5, this.g.n(d6));
                                        this.e.a(a5, this.e.b(d6));
                                    }
                                    Label_1299: {
                                        if (this.p != null) {
                                            final S[] array = (S[])this.q.b(d6);
                                            if (array != null && array.length > 0) {
                                                int l = array.length - 1;
                                                while (l >= 0) {
                                                    final boolean m = array[l].f().i();
                                                    if (i) {
                                                        break Label_1299;
                                                    }
                                                    Label_1087: {
                                                        if (m) {
                                                            list3.add(array[l]);
                                                            if (!i) {
                                                                break Label_1087;
                                                            }
                                                        }
                                                        list6.add(array[l]);
                                                    }
                                                    --l;
                                                    if (i) {
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (this.b.b(d6) == null) {
                                            final d a6 = this.g.a(d4, d6.d());
                                            if (this.t != null) {
                                                this.t.a(a6, am.a("SimpleSourceGroupNodeConnector", this.u.b(d6), this.r.b(d4), this.s.b(d6.d())));
                                            }
                                            this.g.b(a6, this.g.o(d6));
                                            this.f.a(a6, this.f.b(d6));
                                            h.i.put(d6, a6);
                                            if (list6.size() <= 0) {
                                                break Label_1299;
                                            }
                                            this.p.a(a6, list6.toArray((Object[])new S[list6.size()]));
                                            if (!i) {
                                                break Label_1299;
                                            }
                                        }
                                        h.c.add(d6);
                                    }
                                    if (set.add(d6)) {
                                        list.add(d6);
                                    }
                                    p3 = p3.a();
                                    if (i) {
                                        break;
                                    }
                                }
                                if (list3.size() > 0 && a5 != null) {
                                    this.p.a(a5, list3.toArray(new S[list3.size()]));
                                    list3.clear();
                                }
                                if (!h.c.isEmpty()) {
                                    hashMap.put(h.a, h);
                                }
                                --j;
                                if (i) {
                                    break;
                                }
                            }
                        }
                        hashMap3.clear();
                        list2.clear();
                        p p4 = y2.k();
                        while (p4 != null) {
                            final d d3;
                            final d d8 = d3 = ((q)p4.c()).g();
                            if (i) {
                                break Label_3127;
                            }
                            d h2 = d8;
                            while (h2 != null) {
                                final Object b2;
                                final Object o2 = b2 = this.b.b(h2);
                                if (i) {
                                    break Label_3127;
                                }
                                if (b2 != null) {
                                    aA aa4 = hashMap3.get(o2);
                                    if (aa4 == null) {
                                        aa4 = new aA(o2);
                                        hashMap3.put(o2, aa4);
                                        list2.add(aa4);
                                    }
                                    aa4.b.add(h2);
                                }
                                h2 = h2.h();
                                if (i) {
                                    break;
                                }
                            }
                            p4 = p4.a();
                            if (i) {
                                break;
                            }
                        }
                        if (hashMap3.size() > 0) {
                            ++n;
                            final y y4 = new y();
                            p2 = d.b(y4, p2);
                            p = this.v.b(am.a("TargetGroupNodeLayer", p.a().c()), p);
                            this.k.add(new Integer(n));
                            int n2 = list2.size() - 1;
                            while (n2 >= 0) {
                                final aA h3 = list2.get(n2);
                                this.i.add(h3);
                                final q d9 = this.g.d();
                                d d3;
                                final A a7 = (A)(d3 = (d)this.r);
                                if (i) {
                                    break Label_3127;
                                }
                                if (a7 != null) {
                                    this.r.a(d9, am.a("TargetGroupNode", h3.a, p.c()));
                                }
                                a.a(d9, K.r);
                                h3.d = d9;
                                this.g.a((Object)d9).setSize(0.0, 0.0);
                                this.m.put(d9, h3);
                                y4.add(d9);
                                this.c.a(d9, n);
                                final aA g3 = hashMap2.get(h3.a);
                                if (g3 != null) {
                                    g3.h = h3;
                                    h3.g = g3;
                                }
                                hashMap2.put(h3.a, h3);
                                d a8 = null;
                                list4.clear();
                                p p5 = h3.b.k();
                                while (p5 != null) {
                                    list6.clear();
                                    list3.clear();
                                    final d d10 = (d)p5.c();
                                    final q d11 = d10.d();
                                    final d d12 = d3 = a8;
                                    if (i) {
                                        break Label_3127;
                                    }
                                    if (d12 == null || d11 != a8.d()) {
                                        if (list4.size() > 0 && a8 != null) {
                                            this.p.a(a8, list4.toArray(new S[list4.size()]));
                                            list4.clear();
                                        }
                                        a8 = this.g.a(d9, d11);
                                        if (this.t != null) {
                                            this.t.a(a8, am.a("TargetGroupNodeConnector", this.r.b(d9), this.s.b(d11)));
                                        }
                                        this.g.b(a8, this.g.o(d10));
                                        this.f.a(a8, this.f.b(d10));
                                    }
                                    if (this.p != null) {
                                        final S[] array2 = (S[])this.q.b(d10);
                                        if (array2 != null && array2.length > 0) {
                                            int n3 = array2.length - 1;
                                            while (n3 >= 0) {
                                                final aG f = array2[n3].f();
                                                final byte a9;
                                                final byte b3 = a9 = f.a();
                                                final int n5;
                                                final int n4 = n5 = 2;
                                                if (i) {
                                                    break Label_3173;
                                                }
                                                Label_2216: {
                                                    if (b3 == n4) {
                                                        list4.add(array2[n3]);
                                                        if (!i) {
                                                            break Label_2216;
                                                        }
                                                    }
                                                    if (f.i()) {
                                                        list3.add(array2[n3]);
                                                        if (!i) {
                                                            break Label_2216;
                                                        }
                                                    }
                                                    list6.add(array2[n3]);
                                                }
                                                --n3;
                                                if (i) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    final Object b4 = this.a.b(d10);
                                    aA aa5 = null;
                                    aA g4 = h3;
                                    q q2 = null;
                                    Label_2441: {
                                        if (b4 == null) {
                                            q2 = d10.c();
                                            if (!i) {
                                                break Label_2441;
                                            }
                                        }
                                        aa5 = hashMap.get(b4);
                                        q2 = aa5.d;
                                        final int a10 = this.c.a(q2);
                                        while (g4.g != null) {
                                            a11 = this.c.a(g4.g.d);
                                            n6 = a10;
                                            if (i) {
                                                break Label_3173;
                                            }
                                            if (a11 <= n6) {
                                                break;
                                            }
                                            if (g4.f == null) {
                                                final aA aa6 = g4;
                                                final aA g5 = g4.g;
                                                final d a12 = this.g.a(g4.g.d, g4.d);
                                                g5.e = a12;
                                                aa6.f = a12;
                                                if (this.t != null) {
                                                    this.t.a(g4.f, am.a("GroupNodeConnectorEdge", this.r.b(g4.g.d), this.r.b(g4.d)));
                                                }
                                            }
                                            g4 = g4.g;
                                            if (i) {
                                                break;
                                            }
                                        }
                                    }
                                    Label_3012: {
                                        if (aa5 == null) {
                                            final d a13 = this.g.a(q2, g4.d);
                                            if (this.t != null) {
                                                this.t.a(a13, am.a("SimpleTargetGroupNodeConnector", this.u.b(d10), this.s.b(q2), this.r.b(g4.d)));
                                            }
                                            g4.i.put(d10, a13);
                                            this.g.a(a13, this.g.n(d10));
                                            this.e.a(a13, this.e.b(d10));
                                            if (list6.size() > 0) {
                                                if (list3.size() > 0) {
                                                    list3.addAll(list6);
                                                    this.p.a(a13, list3.toArray(new S[list3.size()]));
                                                    if (!i) {
                                                        break Label_3012;
                                                    }
                                                }
                                                this.p.a(a13, list6.toArray(new S[list6.size()]));
                                                if (!i) {
                                                    break Label_3012;
                                                }
                                            }
                                            if (list3.size() <= 0) {
                                                break Label_3012;
                                            }
                                            this.p.a(a13, list3.toArray(new S[list3.size()]));
                                            if (!i) {
                                                break Label_3012;
                                            }
                                        }
                                        d d13 = aa5.d.a(g4.d);
                                        Label_2989: {
                                            Label_2946: {
                                                if (d13 == null) {
                                                    d13 = this.g.a(aa5.d, g4.d);
                                                    if (this.t != null) {
                                                        this.t.a(d13, am.a("GroupNodeConnectorEdge", this.r.b(aa5.d), this.r.b(g4.d)));
                                                    }
                                                    if (list6.size() <= 0) {
                                                        break Label_2946;
                                                    }
                                                    this.p.a(d13, list6.toArray(new S[list6.size()]));
                                                    if (!i) {
                                                        break Label_2946;
                                                    }
                                                }
                                                if (list6.size() > 0) {
                                                    final S[] array3 = (S[])this.p.b(d13);
                                                    if (array3 != null) {
                                                        int n7 = array3.length - 1;
                                                        while (n7 >= 0) {
                                                            list6.add(array3[n7]);
                                                            --n7;
                                                            if (i) {
                                                                break Label_2989;
                                                            }
                                                            if (i) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    this.p.a(d13, list6.toArray(new S[list6.size()]));
                                                }
                                            }
                                            aa5.i.put(d10, d13);
                                            g4.i.put(d10, d13);
                                            aa5.c.remove(d10);
                                        }
                                        if (aa5.c.isEmpty()) {
                                            hashMap.remove(b4);
                                        }
                                    }
                                    if (set.add(d10)) {
                                        list.add(d10);
                                    }
                                    p5 = p5.a();
                                    if (i) {
                                        break;
                                    }
                                }
                                if (list4.size() > 0 && a8 != null) {
                                    this.p.a(a8, list4.toArray(new S[list4.size()]));
                                    list4.clear();
                                }
                                --n2;
                                if (i) {
                                    break;
                                }
                            }
                        }
                        p = p.a();
                        p2 = p2.a();
                        ++n;
                        if (i) {
                            break;
                        }
                        continue;
                        Object b = null;
                        ((y)b).k();
                    }
                    p a14 = k;
                    while (a14 != null) {
                        this.c.a(a14.c(), n);
                        a14 = a14.a();
                        if (i) {
                            break;
                        }
                    }
                    list.size();
                }
                int n8 = a11 - n6;
                while (n8 >= 0) {
                    this.g.d(list.get(n8));
                    --n8;
                    if (i) {
                        break;
                    }
                }
                return;
            }
            d.i();
            continue Label_3127;
        }
    }
    
    public void b(final D d) {
        final boolean i = y.f.c.a.i;
        this.n = new HashSet();
        p p = this.h.k();
        while (true) {
            while (p != null) {
                this.n.add(this.c.b(((aA)p.c()).d));
                p = p.a();
                if (i) {
                    p p2 = this.i.k();
                    while (p2 != null) {
                        this.o.add(this.c.b(((aA)p2.c()).d));
                        p2 = p2.a();
                        if (i) {
                            break;
                        }
                    }
                    return;
                }
                if (i) {
                    break;
                }
            }
            this.o = new HashSet();
            continue;
        }
    }
    
    public void b() {
        final boolean i = y.f.c.a.i;
        p p = this.h.k();
        while (p != null) {
            Object o = p.c();
        Label_0021:
            while (true) {
                final aA aa = (aA)o;
                p p2 = aa.b.k();
                while (p2 != null) {
                    final d d = (d)p2.c();
                    final X x = (X)(o = this.g);
                    if (i) {
                        continue Label_0021;
                    }
                    I j = null;
                    Label_0106: {
                        if (!x.f(d)) {
                            this.g.e(d);
                            j = this.g.b((Object)d);
                            j.clearPoints();
                            if (!i) {
                                break Label_0106;
                            }
                        }
                        j = this.g.b((Object)d);
                    }
                    final q d2 = aa.d;
                    d.c();
                Label_0335:
                    while (true) {
                        q c = null;
                        q c2 = null;
                        d d3 = c.b(c2);
                        I b;
                        t p3;
                        int k;
                        t point;
                        t q;
                        Label_0289_Outer:Label_0317_Outer:
                        while (d3 != null) {
                            b = this.g.b((Object)d3);
                            c = d3.c();
                            c2 = d.c();
                            if (i) {
                                continue Label_0335;
                            }
                            Label_0201: {
                                if (c == c2) {
                                    j.setSourcePoint(b.getSourcePoint());
                                    if (!i) {
                                        break Label_0201;
                                    }
                                }
                                p3 = this.g.p(d3);
                                j.addPoint(p3.a, p3.b);
                            }
                            k = 0;
                            while (true) {
                                while (true) {
                                    while (k < b.pointCount()) {
                                        point = b.getPoint(k);
                                        j.addPoint(point.a, point.b);
                                        ++k;
                                        if (!i) {
                                            if (i) {
                                                break;
                                            }
                                            continue Label_0289_Outer;
                                        }
                                        else {
                                            q = this.g.q(d3);
                                            j.addPoint(q.a, q.b);
                                            d3 = this.a(d3.d(), d);
                                            if (i) {
                                                break Label_0335;
                                            }
                                            continue Label_0289_Outer;
                                        }
                                    }
                                    if (d3.d() != d.d()) {
                                        continue Label_0317_Outer;
                                    }
                                    j.setTargetPoint(b.getTargetPoint());
                                    if (i) {
                                        continue Label_0317_Outer;
                                    }
                                    break;
                                }
                                continue;
                            }
                        }
                        break;
                    }
                    p2 = p2.a();
                    if (i) {
                        break;
                    }
                }
                break;
            }
            p = p.a();
            if (i) {
                break;
            }
        }
        final ArrayList<Object> list = new ArrayList<Object>(50);
        p p4 = this.i.k();
        while (true) {
        Label_0819_Outer:
            while (p4 != null) {
                final aA aa2 = (aA)p4.c();
                final p l = aa2.b.k();
                while (true) {
                    q q2 = null;
                    boolean f = false;
                    Label_0842: {
                        Object o2 = null;
                        Label_0827: {
                            if (!i) {
                                p a = l;
                            Label_0739_Outer:
                                while (a != null) {
                                    final d d4 = (d)a.c();
                                    final X x2 = (X)(o2 = this.g);
                                    if (!i) {
                                        I m = null;
                                        Label_0474: {
                                            if (!x2.f(d4)) {
                                                this.g.e(d4);
                                                m = this.g.b((Object)d4);
                                                m.clearPoints();
                                                if (!i) {
                                                    break Label_0474;
                                                }
                                            }
                                            m = this.g.b((Object)d4);
                                        }
                                        final q d5 = aa2.d;
                                        d4.d();
                                    Label_0674:
                                        while (true) {
                                            q d7 = null;
                                            q d8 = null;
                                            d d6 = d7.a(d8);
                                            list.clear();
                                            I b2;
                                            int n;
                                            Label_0640_Outer:Label_0656_Outer:
                                            while (d6 != null) {
                                                b2 = this.g.b((Object)d6);
                                                d7 = d6.d();
                                                d8 = d4.d();
                                                if (i) {
                                                    continue Label_0674;
                                                }
                                                Label_0563: {
                                                    if (d7 == d8) {
                                                        m.setTargetPoint(b2.getTargetPoint());
                                                        if (!i) {
                                                            break Label_0563;
                                                        }
                                                    }
                                                    list.add(this.g.q(d6));
                                                }
                                                n = b2.pointCount() - 1;
                                                while (true) {
                                                    while (true) {
                                                        while (n >= 0) {
                                                            list.add(b2.getPoint(n));
                                                            --n;
                                                            if (!i) {
                                                                if (i) {
                                                                    break;
                                                                }
                                                                continue Label_0640_Outer;
                                                            }
                                                            else {
                                                                list.add(this.g.p(d6));
                                                                d6 = this.b(d6.c(), d4);
                                                                if (i) {
                                                                    break Label_0674;
                                                                }
                                                                continue Label_0640_Outer;
                                                            }
                                                        }
                                                        if (d6.c() != d4.c()) {
                                                            continue Label_0656_Outer;
                                                        }
                                                        m.setSourcePoint(b2.getSourcePoint());
                                                        if (i) {
                                                            continue Label_0656_Outer;
                                                        }
                                                        break;
                                                    }
                                                    continue Label_0739_Outer;
                                                }
                                            }
                                            break;
                                        }
                                        int n2 = list.size() - 1;
                                        while (true) {
                                            while (n2 >= 0) {
                                                final t t = list.get(n2);
                                                m.addPoint(t.a, t.b);
                                                --n2;
                                                if (!i) {
                                                    if (i) {
                                                        break;
                                                    }
                                                    continue Label_0739_Outer;
                                                }
                                                else {
                                                    if (i) {
                                                        break Label_0739_Outer;
                                                    }
                                                    continue Label_0739_Outer;
                                                }
                                            }
                                            a = a.a();
                                            continue Label_0819_Outer;
                                        }
                                    }
                                    break Label_0827;
                                }
                                p4 = p4.a();
                                if (i) {
                                    break;
                                }
                                continue Label_0819_Outer;
                            }
                            else {
                                p4 = l;
                                while (p4 != null) {
                                    q2 = ((aA)p4.c()).d;
                                    f = this.g.f(q2);
                                    if (i) {
                                        break Label_0842;
                                    }
                                    if (f) {
                                        this.g.a(q2);
                                    }
                                    p4 = p4.a();
                                    if (i) {
                                        break;
                                    }
                                }
                                p4 = this.i.k();
                            }
                            if (p4 == null) {
                                return;
                            }
                            o2 = p4.c();
                        }
                        q2 = ((aA)o2).d;
                        this.g.f(q2);
                    }
                    if (f) {
                        this.g.a(q2);
                    }
                    p4 = p4.a();
                    if (!i) {
                        continue;
                    }
                    break;
                }
                return;
            }
            this.h.k();
            continue;
        }
    }
    
    private d a(final q q, final d d) {
        if (q == d.d()) {
            return null;
        }
        final aA aa = this.l.get(q);
        if (aa == null) {
            return null;
        }
        d e = aa.i.get(d);
        if (e == null) {
            e = aa.e;
        }
        return e;
    }
    
    private d b(final q q, final d d) {
        if (q == d.c()) {
            return null;
        }
        final aA aa = this.m.get(q);
        if (aa == null) {
            return null;
        }
        d f = aa.i.get(d);
        if (f == null) {
            f = aa.f;
        }
        if (f != null && this.l.containsKey(f.c())) {
            return null;
        }
        return f;
    }
    
    public void c() {
        if (this.q != null) {
            this.q.b();
            this.g.a(this.p);
            this.p = null;
            this.q = null;
        }
        this.d = null;
        this.c = null;
        this.g = null;
        this.e = null;
        this.a = null;
        this.j = null;
        this.h = null;
        this.l = null;
        this.f = null;
        this.b = null;
        this.k = null;
        this.i = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
    }
    
    Set d() {
        return this.o;
    }
    
    Set e() {
        return this.n;
    }
}
