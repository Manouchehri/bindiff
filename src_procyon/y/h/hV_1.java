package y.h;

import y.a.*;
import y.d.*;
import y.g.*;
import y.h.a.*;
import y.f.i.*;
import y.c.*;
import java.util.*;
import y.f.*;

class hV
{
    private cF f;
    static final Object a;
    static final Object b;
    static final Object c;
    static final Object d;
    static final Object e;
    
    hV(final cF f) {
        this.f = f;
    }
    
    void a(final bu bu) {
        final y y = new y();
        final f f = new f();
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        this.f.a(bu, y, f, hashMap, hashMap2);
        if (y.isEmpty() && f.isEmpty()) {
            final D d = new D();
            final D d2 = new D();
            final HashMap hashMap3 = new HashMap();
            final HashMap hashMap4 = new HashMap();
            this.f.a(bu, d, d2, hashMap3, hashMap4);
            this.f.b(bu, d, d2, hashMap3, hashMap4);
            this.f.c(bu, d, d2, hashMap3, hashMap4);
            if (!fj.z) {
                return;
            }
        }
        this.f.b(bu, y, f, hashMap, hashMap2);
        this.f.c(bu, y, f, hashMap, hashMap2);
    }
    
    void a(final bu bu, final y y, final f f, final Map map, final Map map2) {
        final boolean z = fj.z;
        final y a = this.f.a(bu);
        if (!a.isEmpty()) {
            final y[] a2 = y.a.b.a(bu, a, false, bu.t(), 2);
            y y2 = null;
            Label_0068: {
                if (a2.length > 1) {
                    y2 = a2[1];
                    if (!z) {
                        break Label_0068;
                    }
                }
                y2 = new y();
            }
            this.a(bu, a, y2, new f(bu.p()), false, y, f, map, map2);
            if (!z) {
                return;
            }
        }
        final y y3 = new y();
        final f b = this.f.b(bu);
        final e a3 = b.a();
        while (a3.f()) {
            final d a4 = a3.a();
            y3.add(a4.c());
            y3.add(a4.d());
            a3.g();
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        this.a(bu, new y(), y3, b, true, new y(), f, map, map2);
    }
    
    y b(final bu bu) {
        final boolean z = fj.z;
        final y y = new y();
        final x o = bu.o();
        while (o.f()) {
            final q e = o.e();
            if (bu.v(e)) {
                y.add(e);
            }
            o.g();
            if (z) {
                break;
            }
        }
        return y;
    }
    
    f c(final bu bu) {
        final boolean z = fj.z;
        final f f = new f();
        final e p = bu.p();
        while (p.f()) {
            final d a = p.a();
            if (bu.r(a)) {
                f.add(a);
            }
            p.g();
            if (z) {
                break;
            }
        }
        return f;
    }
    
    void b(final bu bu, final y y, final f f, final Map map, final Map map2) {
        if (y.isEmpty()) {
            this.a(bu, f, map2, 20.0, 20.0);
            if (!fj.z) {
                return;
            }
        }
        this.a(bu, y, f, map2);
        a(bu, y);
        bu.d_(hV.d);
    }
    
    void a(final bu bu, final y y, final f f, final Map map) {
        final boolean z = fj.z;
        final HashSet set = new HashSet(y);
        final h b = M.b();
        final f f2 = new f();
        final e a = f.a();
        while (true) {
            while (a.f()) {
                final d a2 = a.a();
                final boolean contains = set.contains(a2.c());
                if (z) {
                    if (!contains) {
                        final Object o = ae.b(bu, new hW(this, set)) ? hV.b : hV.a;
                        final e a3 = f2.a();
                        while (a3.f()) {
                            b.a(a3.a(), o);
                            a3.g();
                            if (z) {
                                return;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                    bu.a(hV.d, b);
                    return;
                }
                if ((contains && !set.contains(a2.d())) || (!set.contains(a2.c()) && set.contains(a2.d()))) {
                    final Object a4 = a(bu, map.get(a2));
                    b.a(a2, a4);
                    if (a4 == hV.c) {
                        f2.add(a2);
                    }
                }
                a.g();
                if (z) {
                    break;
                }
            }
            f2.isEmpty();
            continue;
        }
    }
    
    static Object a(final bu bu, final d d) {
        final boolean z = fj.z;
        boolean b = false;
        final s j = bu.l(d).j();
        double n = 0.0;
        while (j.f()) {
            final m a = j.a();
            final t c = a.c();
            final t d2 = a.d();
            n = dcmpg(Math.abs(c.a() - d2.a()), 1.0E-12);
            if (z) {
                return (n != 0 && b) ? hV.b : hV.c;
            }
            Label_0117: {
                if (n < 0) {
                    b = true;
                    if (!z) {
                        break Label_0117;
                    }
                }
                if (Math.abs(c.b() - d2.b()) >= 1.0E-12 || z) {
                    return hV.a;
                }
            }
            j.g();
            if (z) {
                break;
            }
        }
        return (n != 0 && b) ? hV.b : hV.c;
    }
    
    void a(final bu bu, final y y, final f f) {
        bu.N();
        if (y.isEmpty()) {
            if (f.isEmpty()) {
                return;
            }
            bu.a(f.a(), true);
            if (!fj.z) {
                return;
            }
        }
        bu.a(y.a(), true);
    }
    
    private void a(final bu bu, final y y, final y y2, final f f, final boolean b, final y y3, final f f2, final Map map, final Map map2) {
        final boolean z = fj.z;
        final HashSet set = new HashSet(y);
        final y y4 = new y(y);
        y4.addAll(y2);
        final HashMap<Object, q> hashMap = new HashMap<Object, q>();
        final f f3 = new f();
        final bF bf = new bF(new hZ(bu.a_(), f3, map, hashMap, map2));
        final B b2 = new B();
        b2.a(bf);
        bf.a(b2);
        final x a = b2.a(bu, y4.a(), f.a(), bu).a();
        do {
            boolean f4 = false;
            Label_0135: {
                f4 = a.f();
            }
            Label_0142:
            while (f4) {
                final q e = a.e();
                final q q = map.get(e);
                final boolean contains = set.contains(q);
                if (!z) {
                    Label_0560: {
                        if (!contains) {
                            final q q2 = map.get(e);
                            final e a2 = new f(e.j()).a();
                            while (a2.f()) {
                                final q a3 = a2.a().a(e);
                                final q q3 = map.get(a3);
                                f4 = b;
                                if (z) {
                                    continue Label_0142;
                                }
                                Label_0458: {
                                    if (b || set.contains(q3)) {
                                        final d a4 = a2.a();
                                        if (a4.c() == a3) {
                                            bu.a(a4, a3, q2);
                                            final v c = bu.C();
                                            if (c == null || !bu.C().e(a4)) {
                                                break Label_0458;
                                            }
                                            final q c2 = c.c(a4);
                                            final q b3 = c.b(a4);
                                            c.a(a4);
                                            c.b(a4, b3, map.get(c2));
                                            if (!z) {
                                                break Label_0458;
                                            }
                                        }
                                        bu.a(a4, q2, a3);
                                        final v c3 = bu.C();
                                        if (c3 != null && bu.C().e(a4)) {
                                            final q c4 = c3.c(a4);
                                            final q b4 = c3.b(a4);
                                            c3.a(a4);
                                            c3.b(a4, map.get(b4), c4);
                                        }
                                    }
                                }
                                a2.g();
                                if (z) {
                                    break;
                                }
                            }
                            e.e().a(e);
                            if (!z) {
                                break Label_0560;
                            }
                        }
                        y3.add(e);
                        final v c5 = bu.C();
                        if (c5 != null) {
                            final q n = c5.n(q);
                            if (set.contains(n)) {
                                c5.c(e, hashMap.get(n));
                                if (!z) {
                                    break Label_0560;
                                }
                            }
                            c5.c(e, n);
                        }
                    }
                    a.g();
                    continue Label_0135;
                }
                return;
            }
            break;
        } while (!z);
        f2.addAll(f3);
    }
    
    void a(final bu bu, final f f, final Map map, final double n, final double n2) {
        final boolean z = fj.z;
        final h b = M.b();
        final e a = f.a();
        while (true) {
            while (a.f()) {
                final d a2 = a.a();
                if (z) {
                    final as as = new as();
                    as.a(5.0);
                    as.b(false);
                    as.a(true);
                    try {
                        final bI bi = new bI((byte)1);
                        bi.a(false);
                        bi.b(true);
                        bi.d().a(true);
                        bi.a(bu, as);
                    }
                    finally {
                        bu.d_(y.f.as.a);
                    }
                    return;
                }
                Label_0174: {
                    if (a2.e() && bu.i(a2).bendCount() <= 1) {
                        final aB i = bu.i(a2);
                        final fj sourceRealizer = i.getSourceRealizer();
                        if (bu.i(a2).bendCount() == 0) {
                            i.appendBend(i.getSourcePort().a(sourceRealizer), i.getSourcePort().b(sourceRealizer) - 20.0 - sourceRealizer.getHeight());
                        }
                        this.a(bu, n, n2, a2, true, false, false, a2.c());
                        if (!z) {
                            break Label_0174;
                        }
                    }
                    b.a(a2, true);
                    b.a(map.get(a2), true);
                }
                a.g();
                if (z) {
                    break;
                }
            }
            bu.a(as.a, b);
            continue;
        }
    }
    
    static void a(final bu bu, final y y) {
        final boolean z = fj.z;
        final A t = bu.t();
        final x a = y.a();
        while (true) {
            while (a.f()) {
                t.a(a.e(), true);
                a.g();
                if (z) {
                    final boolean b = bu.c(hV.d) != null;
                    final y.f.g.d d = new y.f.g.d();
                    d.b((byte)3);
                    d.a((byte)2);
                    Label_0246: {
                        if (b) {
                            final y.f.i.v v = new y.f.i.v();
                            v.b((byte)2);
                            v.a(hV.e);
                            v.f(true);
                            v.d(4);
                            v.e(false);
                            v.c(5);
                            v.c(true);
                            v.a((byte)1);
                            v.b(true);
                            v.c((byte)1);
                            v.a("routingPreferMiddleOfNode", Boolean.TRUE);
                            d.b(new hX(new y.f.i.i(new n(new ab(new y.f.i.X(v))))));
                            if (!z) {
                                break Label_0246;
                            }
                        }
                        d.c((byte)2);
                    }
                    d.d((byte)5);
                    d.a(true);
                    d.b(false);
                    try {
                        final bI bi = new bI((byte)1);
                        bi.a(false);
                        bi.b(true);
                        bi.d().a(true);
                        bi.a(bu, d);
                    }
                    finally {
                        bu.d_(y.f.g.d.a);
                        bu.a(t);
                    }
                    return;
                }
                if (z) {
                    break;
                }
            }
            bu.a(y.f.g.d.a, t);
            continue;
        }
    }
    
    void a(final bu bu, final double n, final double n2, final d d, final boolean b, final boolean b2, final boolean b3, final q q) {
        final boolean z = fj.z;
        final aB i = bu.i(d);
        if (i.bendCount() > 0) {
            int n3 = 0;
            final y.h.y bends = i.bends();
            while (bends.f()) {
                Label_0201: {
                    if (d.c() == q && n3 == 0 && (b2 || b3)) {
                        if (b2) {
                            bends.a().b(0.0, n2);
                            if (!z) {
                                break Label_0201;
                            }
                        }
                        if (!b3) {
                            break Label_0201;
                        }
                        bends.a().b(n, 0.0);
                        if (!z) {
                            break Label_0201;
                        }
                    }
                    if (d.d() == q && n3 == i.bendCount() - 1 && (b2 || b3)) {
                        if (b2) {
                            bends.a().b(0.0, n2);
                            if (!z) {
                                break Label_0201;
                            }
                        }
                        if (!b3) {
                            break Label_0201;
                        }
                        bends.a().b(n, 0.0);
                        if (!z) {
                            break Label_0201;
                        }
                    }
                    bends.a().b(n, n2);
                }
                if (b) {
                    bends.a().a(true);
                }
                bends.g();
                ++n3;
                if (z) {
                    break;
                }
            }
        }
    }
    
    void a(final bu bu, final List list, final List list2, final Map map, final Map map2) {
        final boolean z = fj.z;
        final List c = this.f.c(bu);
        Label_0193: {
            if (!c.isEmpty()) {
                final HashSet<q> set = new HashSet<q>();
                final y y = new y();
                final Iterator<eR> iterator = c.iterator();
                while (true) {
                    while (iterator.hasNext()) {
                        final q f = iterator.next().f();
                        if (set.add(f)) {
                            y.add(f);
                            if (z) {
                                for (final eR er : c) {
                                    final eR er2 = (eR)er.clone();
                                    er.g().addLabel(er2);
                                    list.add(er2);
                                    map.put(er2, er);
                                    if (z) {
                                        break Label_0193;
                                    }
                                }
                                return;
                            }
                            if (z) {
                                break;
                            }
                            continue;
                        }
                    }
                    bu.a(y.a());
                    continue;
                }
            }
        }
        final List d = this.f.d(bu);
        if (!d.isEmpty()) {
            final HashSet<d> set2 = new HashSet<d>();
            final f f2 = new f();
            final Iterator<aA> iterator3 = d.iterator();
            while (true) {
                while (iterator3.hasNext()) {
                    final d edge = iterator3.next().getEdge();
                    if (!set2.contains(edge)) {
                        set2.add(edge);
                        f2.add(edge);
                        if (z) {
                            for (final aA aa : d) {
                                final aA aa2 = (aA)aa.clone();
                                aa.getRealizer().addLabel(aa2);
                                list2.add(aa2);
                                map2.put(aa2, aa);
                                if (z) {
                                    break;
                                }
                            }
                            return;
                        }
                        if (z) {
                            break;
                        }
                        continue;
                    }
                }
                bu.a(f2.a());
                continue;
            }
        }
    }
    
    List d(final bu bu) {
        final boolean z = fj.z;
        final D d = new D();
        final x o = bu.o();
        do {
            Label_0018: {
                o.f();
            }
            boolean a = false;
            Label_0024:
            while (a) {
                final fj t = bu.t(o.e());
                int i = 0;
                while (i < t.labelCount()) {
                    final eR label = t.getLabel(i);
                    a = bu.a((gZ)label);
                    if (z) {
                        continue Label_0024;
                    }
                    if (a) {
                        d.add(label);
                    }
                    ++i;
                    if (z) {
                        break;
                    }
                }
                o.g();
                continue Label_0018;
            }
            break;
        } while (!z);
        return d;
    }
    
    List e(final bu bu) {
        final boolean z = fj.z;
        final D d = new D();
        final e p = bu.p();
        do {
            Label_0018: {
                p.f();
            }
            boolean a = false;
            Label_0024:
            while (a) {
                final aB i = bu.i(p.a());
                int j = 0;
                while (j < i.labelCount()) {
                    final aA label = i.getLabel(j);
                    a = bu.a((gZ)label);
                    if (z) {
                        continue Label_0024;
                    }
                    if (a) {
                        d.add(label);
                    }
                    ++j;
                    if (z) {
                        break;
                    }
                }
                p.g();
                continue Label_0018;
            }
            break;
        } while (!z);
        return d;
    }
    
    void a(final List list, final List list2) {
        final boolean z = fj.z;
        Object o = list.iterator();
    Label_0201:
        while (true) {
            eR er;
            al a;
            D d;
            fj g;
            boolean b;
            aA aa;
            E labelModel;
            D d2;
            aB realizer;
            int i;
            int j;
            Label_0207_Outer:Label_0122_Outer:
            while (((Iterator)o).hasNext()) {
                er = ((Iterator<eR>)o).next();
                a = er.a();
                d = new D();
                g = er.g();
                b = false;
                if (z) {
                Label_0306_Outer:
                    while (true) {
                        if (b) {
                            aa = (aA)((Iterator<eR>)o).next();
                            labelModel = aa.getLabelModel();
                            d2 = new D();
                            realizer = aa.getRealizer();
                            i = 0;
                            while (true) {
                                while (i < realizer.labelCount()) {
                                    d2.add(realizer.getLabel(i).getOrientedBox());
                                    ++i;
                                    if (!z) {
                                        if (z) {
                                            break;
                                        }
                                        continue Label_0207_Outer;
                                    }
                                    else {
                                        if (labelModel instanceof gu) {
                                            b(aa, d2);
                                            if (!z) {
                                                break Label_0201;
                                            }
                                        }
                                        c(aa, d2);
                                        if (z) {
                                            return;
                                        }
                                        break Label_0201;
                                    }
                                }
                                Label_0286: {
                                    break Label_0286;
                                    ((Iterator)o).hasNext();
                                    continue Label_0306_Outer;
                                }
                                if (!(labelModel instanceof K)) {
                                    continue Label_0122_Outer;
                                }
                                a(aa, d2);
                                if (z) {
                                    continue Label_0122_Outer;
                                }
                                break;
                            }
                            continue Label_0201;
                        }
                        break;
                    }
                    return;
                }
                j = (b ? 1 : 0);
                while (true) {
                    while (j < g.labelCount()) {
                        d.add(g.getLabel(j).getOrientedBox());
                        ++j;
                        if (!z) {
                            if (z) {
                                break;
                            }
                            continue Label_0122_Outer;
                        }
                        else {
                            if (a instanceof gw) {
                                c(er, d);
                                if (!z) {
                                    continue Label_0201;
                                }
                            }
                            if (a instanceof fM) {
                                b(er, d);
                                if (!z) {
                                    continue Label_0201;
                                }
                            }
                            if (a instanceof y.h.b.h) {
                                d(er, d);
                                if (!z) {
                                    continue Label_0201;
                                }
                            }
                            e(er, d);
                            if (z) {
                                break Label_0207_Outer;
                            }
                            continue Label_0201;
                        }
                    }
                    if (!(a instanceof y.f.A)) {
                        continue;
                    }
                    a(er, d);
                    if (z) {
                        continue;
                    }
                    break;
                }
            }
            o = list2.iterator();
            continue Label_0201;
        }
    }
    
    void a(final bu bu, final List list, final List list2) {
        final boolean z = fj.z;
        bu.N();
        Iterator<gZ> iterator = list.iterator();
        while (true) {
            while (iterator.hasNext()) {
                bu.a(iterator.next(), true);
                if (z) {
                    while (iterator.hasNext()) {
                        bu.a(iterator.next(), true);
                        if (z) {
                            break;
                        }
                    }
                    return;
                }
                if (z) {
                    break;
                }
            }
            iterator = list2.iterator();
            continue;
        }
    }
    
    private static void a(final eR er, final D d) {
        final boolean z = fj.z;
        final fj g = er.g();
        final y.f.A a = (y.f.A)er.a();
        final HashSet set = new HashSet<Object>(17);
        int i = 0;
        while (i < g.labelCount()) {
            final eR label = g.getLabel(i);
            if (label.getModelParameter() instanceof Integer) {
                set.add(label.getModelParameter());
            }
            ++i;
            if (z) {
                break;
            }
        }
        final y.c.C m = a.a(er, g).m();
        while (m.f()) {
            final Q q = (Q)m.d();
            final Object b = q.b();
            if (!set.contains(b) && b(q.d(), d)) {
                er.setModelParameter(b);
                return;
            }
            m.g();
            if (z) {
                break;
            }
        }
    }
    
    private static void b(final eR er, final D d) {
        final boolean z = fj.z;
        final fj g = er.g();
        final fM fm = (fM)er.a();
        final boolean[] array = new boolean[5];
        final eU a = fM.a(er);
        int i = 0;
        while (i < g.labelCount()) {
            final eR label = g.getLabel(i);
            if (a == fM.a(label) && label.getModelParameter() instanceof fN) {
                array[fM.b(label.getModelParameter())] = true;
            }
            ++i;
            if (z) {
                break;
            }
        }
        final y.c.C m = fm.a(er, (am)g).m();
        while (m.f()) {
            final Q q = (Q)m.d();
            final Object b = q.b();
            if (!array[fM.b(b)] && b(q.d(), d)) {
                er.setModelParameter(b);
                return;
            }
            m.g();
            if (z) {
                break;
            }
        }
    }
    
    private static void c(final eR er, final D d) {
        final boolean z = fj.z;
        gx gx = (gx)er.getModelParameter();
        final y.d.n n = new y.d.n(er.getOrientedBox());
        while (!a(n, d)) {
            n.e(n.k().a(), n.k().b() + n.f() + 5.0);
            gx modelParameter = (gx)er.getBestModelParameterForBounds(n);
            final gx gx2 = (gx)er.getModelParameter();
            er.setModelParameter(modelParameter);
            if (gx2.e() != 0.0) {
                final Object a = ((gw)er.a()).a(gx.a(), modelParameter.b(), gx.c(), modelParameter.d(), gx.e(), modelParameter.f(), modelParameter.g(), modelParameter.h());
                er.setModelParameter(a);
                modelParameter = (gx)a;
            }
            if (gx2.f() != 0.0) {
                final Object a2 = ((gw)er.a()).a(modelParameter.a(), gx.b(), modelParameter.c(), gx.d(), modelParameter.e(), gx.f() + n.f() + 5.0, modelParameter.g(), modelParameter.h());
                er.setModelParameter(a2);
                modelParameter = (gx)a2;
            }
            gx = modelParameter;
            if (z) {
                break;
            }
        }
    }
    
    private static void d(final eR er, final D d) {
        final boolean z = fj.z;
        final y.d.n n = new y.d.n(er.getOrientedBox());
        while (!a(n, d)) {
            n.e(n.k().a() + n.e() + 5.0, n.k().b());
            er.setModelParameter(er.getBestModelParameterForBounds(n));
            if (z) {
                break;
            }
        }
    }
    
    private static void e(final eR er, final D d) {
        final boolean z = fj.z;
        final y.d.n n = new y.d.n(er.getOrientedBox());
        while (!a(n, d)) {
            n.e(n.k().a(), n.k().b() + n.f() + 5.0);
            er.setModelParameter(er.getBestModelParameterForBounds(n));
            if (z) {
                break;
            }
        }
    }
    
    private static void a(final aA aa, final D d) {
        final boolean z = fj.z;
        final y.d.n n = new y.d.n(aa.getOrientedBox());
        while (!a(n, d)) {
            n.e(n.k().a(), n.k().b() + n.f() + 5.0);
            aa.setModelParameter(aa.getBestModelParameterForBounds(n));
            if (z) {
                break;
            }
        }
    }
    
    private static void b(final aA aa, final D d) {
        final boolean z = fj.z;
        final aB realizer = aa.getRealizer();
        final gu gu = (gu)aa.getLabelModel();
        final gv gv = (gv)aa.getModelParameter();
        final int n = realizer.pointCount() + 1;
        gv gv2 = gv;
        int i = 0;
        int n2 = 1;
        while (i == 0) {
            final int a = gv2.a();
            int n3 = 0;
            double n4 = 0.0;
            Label_0371: {
                if (n2 != 0) {
                    if (gv2.b() + 0.1 > b(aa)) {
                        n3 = a + 1;
                        if (n3 < n && n3 != 0) {
                            final aA aa2 = (aA)aa.clone();
                            aa2.setLabelModel(new gu(), new gv(n3, gv2.b(), gv2.c(), gv2.d(), gv2.e(), gv2.f()));
                            realizer.addLabel(aa2);
                            n4 = a(aa2);
                            realizer.removeLabel(aa2);
                            if (!z) {
                                break Label_0371;
                            }
                        }
                        n4 = gv.b();
                        n3 = gv.a();
                        n2 = 0;
                        if (!z) {
                            break Label_0371;
                        }
                    }
                    n3 = a;
                    n4 = gv2.b() + 0.1;
                    if (!z) {
                        break Label_0371;
                    }
                }
                if (gv2.b() - 0.1 < a(aa)) {
                    n3 = a - 1;
                    if (n3 >= -n && n3 != -1) {
                        final aA aa3 = (aA)aa.clone();
                        aa3.setLabelModel(new gu(), new gv(n3, gv2.b(), gv2.c(), gv2.d(), gv2.e(), gv2.f()));
                        realizer.addLabel(aa3);
                        n4 = b(aa3);
                        realizer.removeLabel(aa3);
                        if (!z) {
                            break Label_0371;
                        }
                    }
                    n4 = gv.b();
                    n3 = gv.a();
                    i = 1;
                    if (!z) {
                        break Label_0371;
                    }
                }
                n3 = a;
                n4 = gv2.b() - 0.1;
            }
            final gv modelParameter = new gv(n3, n4, gv2.c(), gv2.d(), gv2.e(), gv2.f());
            final y.d.n a2 = gu.a(aa.getOrientedBox().d(), realizer, realizer.getSourceRealizer(), realizer.getTargetRealizer(), modelParameter);
            aa.setModelParameter(modelParameter);
            if (a(a2, d)) {
                i = 1;
            }
            gv2 = modelParameter;
            if (z) {
                break;
            }
        }
    }
    
    private static void c(final aA aa, final D d) {
        final boolean z = fj.z;
        final aB realizer = aa.getRealizer();
        final E labelModel = aa.getLabelModel();
        final t k = aa.getOrientedBox().k();
        double n = Double.MAX_VALUE;
        Q q = null;
        final y.c.C m = labelModel.a(aa, realizer, realizer.getSourceRealizer(), realizer.getTargetRealizer()).m();
        while (m.f()) {
            final Q q2 = (Q)m.d();
            final y.d.n d2 = q2.d();
            if (z) {
                return;
            }
            if (a(d2, d)) {
                final double a = t.a(k, q2.d().k());
                if (a < n) {
                    n = a;
                    q = q2;
                }
            }
            m.g();
            if (z) {
                break;
            }
        }
        if (q != null) {
            aa.setModelParameter(q.b());
        }
    }
    
    private static double a(final aA aa) {
        final boolean z = fj.z;
        double min = 1.0;
        final y.d.v l = aa.getGraph2D().l(aa.getEdge());
        final gv gv = (gv)aa.getModelParameter();
        final int a = gv.a();
        final int n = (a < 0) ? (l.h() - 1 + a) : a;
        final E labelModel = aa.getLabelModel();
        final aB realizer = aa.getRealizer();
        final y.c.C m = labelModel.a(aa, realizer, realizer.getSourceRealizer(), realizer.getTargetRealizer()).m();
        while (m.f()) {
            final gv gv2 = (gv)((Q)m.d()).b();
            if (((gv2.a() < 0) ? (l.h() - 1 + gv2.a()) : gv2.a()) == n && gv2.e() == gv.e()) {
                min = Math.min(min, gv2.b());
            }
            m.g();
            if (z) {
                break;
            }
        }
        return Math.max(min, 0.0);
    }
    
    private static double b(final aA aa) {
        final boolean z = fj.z;
        double max = 0.0;
        final y.d.v l = aa.getGraph2D().l(aa.getEdge());
        final E labelModel = aa.getLabelModel();
        final gv gv = (gv)aa.getModelParameter();
        final int a = gv.a();
        final int n = (a < 0) ? (l.h() - 1 + a) : a;
        final aB realizer = aa.getRealizer();
        final y.c.C m = labelModel.a(aa, realizer, realizer.getSourceRealizer(), realizer.getTargetRealizer()).m();
        while (m.f()) {
            final gv gv2 = (gv)((Q)m.d()).b();
            if (((gv2.a() < 0) ? (l.h() - 1 + gv2.a()) : gv2.a()) == n && gv2.e() == gv.e()) {
                max = Math.max(max, gv2.b());
            }
            m.g();
            if (z) {
                break;
            }
        }
        return Math.min(max, 1.0);
    }
    
    private static boolean a(final y.d.n n, final D d) {
        final boolean z = fj.z;
        boolean b = true;
        final y.c.C m = d.m();
        while (m.f()) {
            final boolean b2 = b;
            if (z || !b2) {
                return b2;
            }
            b = !a(n, (y.d.n)m.d(), 0.0);
            m.g();
            if (z) {
                goto Label_0064;
            }
        }
        goto Label_0064;
    }
    
    private static boolean b(final y.d.n n, final D d) {
        final boolean z = fj.z;
        boolean b = true;
        final y.c.C m = d.m();
        while (m.f()) {
            final boolean b2 = b;
            if (z || !b2) {
                return b2;
            }
            b = !y.d.n.a((y.d.n)m.d(), n, 0.0);
            m.g();
            if (z) {
                goto Label_0064;
            }
        }
        goto Label_0064;
    }
    
    private static boolean a(final y.d.n n, final y.d.n n2, final double n3) {
        final t[] a = y.d.n.a(n2);
        return y.d.n.a(n, new m(a[0], a[1]), n3) || y.d.n.a(n, new m(a[1], a[2]), n3) || y.d.n.a(n, new m(a[2], a[3]), n3) || y.d.n.a(n, new m(a[3], a[0]), n3);
    }
    
    static {
        a = "STRAIGHT_LINE";
        b = "ORTHOGONAL";
        c = "PARAXIAL";
        d = "MARKED_INTER_EDGES";
        e = "ORTHOGONAL_INTER_EDGES";
    }
}
