package y.f.c;

import y.f.*;
import y.g.*;
import y.c.*;
import java.util.*;

class at
{
    private Map a;
    private av b;
    private Q c;
    private au d;
    
    public at(final Q c) {
        this.a = new HashMap();
        this.d = new au();
        this.c = c;
    }
    
    public void a(final Object o, final X x, final A a, final int n, final y y, final y y2, final c c, final c c2, final c c3, final c c4, final c c5, final c c6) {
        final boolean i = a.i;
        final w w = new w();
        final A t = w.t();
        final h u = w.u();
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        final HashMap<Object, d> hashMap2 = new HashMap<Object, d>();
        A t2 = null;
        if (c3 != null) {
            t2 = w.t();
            w.a(aF.a, t2);
        }
        A t3 = null;
        if (c4 != null) {
            t3 = w.t();
            w.a(aF.b, t3);
        }
        w.a(ah.f_, t);
        w.a(ah.k, u);
        final x o2 = x.o();
        while (true) {
            while (o2.f()) {
                final q e = o2.e();
                final q d = w.d();
                final Object b;
                t.a(d, b = c.b(e));
                hashMap.put(b, d);
                final X x2;
                final w w2 = (w)(x2 = w);
                if (i) {
                    final e p12 = x2.p();
                    while (p12.f()) {
                        final d a2 = p12.a();
                        final d a3 = w.a(hashMap.get(c.b(a2.c())), hashMap.get(c.b(a2.d())));
                        w.a(a3, x.b((Object)a2));
                        final Object b2;
                        u.a(a3, b2 = c2.b(a2));
                        hashMap2.put(b2, a3);
                        if (c3 != null) {
                            final Object b3 = c3.b(a2);
                            if (b3 != null) {
                                t2.a(a3, b3);
                            }
                        }
                        if (c4 != null) {
                            final Object b4 = c4.b(a2);
                            if (b4 != null) {
                                t3.a(a3, b4);
                            }
                        }
                        p12.g();
                        if (i) {
                            break;
                        }
                    }
                    final q[] array = new q[y.size()];
                    int n2 = 0;
                    p p13 = y.k();
                    while (true) {
                        while (p13 != null) {
                            final q[] array2 = array;
                            if (i) {
                                final q[] array3 = array2;
                                int n3 = 0;
                                p p14 = y2.k();
                                while (p14 != null) {
                                    array3[n3] = hashMap.get(c.b(p14.c()));
                                    p14 = p14.a();
                                    ++n3;
                                    if (i) {
                                        break;
                                    }
                                }
                                final A t4 = w.t();
                                final x o3 = x.o();
                                while (o3.f()) {
                                    final q e2 = o3.e();
                                    t4.a(hashMap.get(c.b(e2)), a.b(e2));
                                    o3.g();
                                    if (i) {
                                        break;
                                    }
                                }
                                this.a.put(o, new av(this.c, o, w, t4, n, array, array3, hashMap, hashMap2));
                                return;
                            }
                            array2[n2] = hashMap.get(c.b(p13.c()));
                            p13 = p13.a();
                            ++n2;
                            if (i) {
                                break;
                            }
                        }
                        final q[] array4 = new q[y2.size()];
                        continue;
                    }
                }
                w2.a(d, x.a((Object)e));
                o2.g();
                if (i) {
                    break;
                }
            }
            X x2 = x;
            continue;
        }
    }
    
    public void a(final Object o) {
        final boolean i = y.f.c.a.i;
        final av b = this.a.get(o);
        if (this.b == null) {
            this.b = b;
        }
        final c c = b.b.c(ah.f_);
        final x o2 = b.b.o();
        while (o2.f()) {
            final av av = this.a.get(c.b(o2.e()));
            if (i) {
                return;
            }
            if (av != null) {
                this.b(b, av);
            }
            o2.g();
            if (i) {
                break;
            }
        }
        this.a(this.b);
    }
    
    private void b(final av av, final av av2) {
        final boolean i = y.f.c.a.i;
        final c c = av2.b.c(ah.f_);
        final q q = av.i.get(av2.a);
        final c c2 = av.b.c(ah.f_);
        final c c3 = av.b.c(ah.k);
        int n = 0;
        while (true) {
            do {
                int j = 0;
            Label_0063:
                while (j < av2.g.length) {
                    final q q2 = av2.g[n];
                    final Object b = c.b(q2);
                    Object o = null;
                    final am am = (am)b;
                    final int equals;
                    final int n2 = equals = ("UpperGroupNode".equals(am.a) ? 1 : 0);
                    if (i) {
                        int n3 = equals;
                        while (true) {
                            do {
                                int k = 0;
                            Label_0771:
                                while (k < av2.h.length) {
                                    final av av3 = av2;
                                    if (i) {
                                        final x o2 = av3.b.o();
                                        while (o2.f()) {
                                            final av av4 = this.a.get(c.b(o2.e()));
                                            if (i) {
                                                return;
                                            }
                                            if (av4 != null) {
                                                this.b(av2, av4);
                                            }
                                            o2.g();
                                            if (i) {
                                                break;
                                            }
                                        }
                                        this.a(av2);
                                        return;
                                    }
                                    final q q3 = av2.h[n3];
                                    final Object b2 = c.b(q3);
                                    Object o3 = null;
                                    final am am2 = (am)b2;
                                    if ("LowerGroupNode".equals(am2.a)) {
                                        final Object a = ((am)am2.b).a;
                                        for (d d = q.f(); d != null; d = d.g()) {
                                            final Object b3 = c3.b(d);
                                            k = ((b3 instanceof am) ? 1 : 0);
                                            if (i) {
                                                continue Label_0771;
                                            }
                                            if (k != 0) {
                                                try {
                                                    final am am3 = (am)b3;
                                                    if ("SourceGroupNodeConnector".equals(am3.a)) {
                                                        final Object b4 = ((am)((am)am3.b).b).b;
                                                        if (b4 instanceof am && ((am)b4).a instanceof am) {
                                                            final am am4 = (am)((am)b4).a;
                                                            if (am4.a instanceof am && "SourceOutEdge".equals(((am)am4.a).a) && a.equals(am4.b)) {
                                                                final Object b5 = am4.b;
                                                                o3 = d;
                                                                if (!i) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                catch (ClassCastException ex) {}
                                                catch (NullPointerException ex2) {}
                                            }
                                        }
                                    }
                                    else if ("LowerDummyNode".equals(am2.a)) {
                                        final Object a2 = ((am)((am)b2).b).a;
                                        d d2 = q.f();
                                        while (d2 != null) {
                                            final Object b6 = c3.b(d2);
                                            final boolean b7 = b6 instanceof am;
                                            if (i) {
                                                continue Label_0771;
                                            }
                                            if (b7) {
                                                try {
                                                    final am am5 = (am)b6;
                                                    Label_1426: {
                                                        if ("DummyEdge".equals(am5.a)) {
                                                            final am am6 = (am)c2.b(d2.d());
                                                            if ("LowerSameLayerEdgeSupport".equals(am6.a) && a2.equals(((am)((am)am6.b).b).a)) {
                                                                o3 = d2;
                                                                if (!i) {
                                                                    break;
                                                                }
                                                            }
                                                            if (!"BendNode".equals(am6.a)) {
                                                                break Label_1426;
                                                            }
                                                            final Object a3 = ((am)((am)((am)am6.b).a).b).a;
                                                            if (a3 instanceof am && ((am)a3).b instanceof am && a2.equals(((am)((am)a3).b).a)) {
                                                                o3 = d2;
                                                                if (!i) {
                                                                    break;
                                                                }
                                                            }
                                                            if (!a2.equals(a3)) {
                                                                break Label_1426;
                                                            }
                                                            o3 = d2;
                                                            if (!i) {
                                                                break;
                                                            }
                                                        }
                                                        final Object a4 = ((am)am5.b).a;
                                                        if (a2.equals(a4)) {
                                                            o3 = d2;
                                                            if (!i) {
                                                                break;
                                                            }
                                                        }
                                                        if (a4 instanceof am) {
                                                            final Object a5 = ((am)a4).a;
                                                            if (("InEdge".equals(a5) || "OutEdge".equals(a5)) && a2.equals(((am)((am)a4).b).a)) {
                                                                o3 = d2;
                                                                if (!i) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                catch (ClassCastException ex3) {}
                                                catch (NullPointerException ex4) {}
                                            }
                                            d2 = d2.g();
                                            if (i) {
                                                break;
                                            }
                                        }
                                    }
                                    if (o3 != null) {
                                        av2.e.a(q3, o3);
                                    }
                                    ++n3;
                                }
                                break;
                            } while (!i);
                            final av av3 = av2;
                            continue;
                        }
                    }
                    if (n2 != 0) {
                        final Object a6 = ((am)am.b).a;
                        for (d d3 = q.g(); d3 != null; d3 = d3.h()) {
                            final Object b8 = c3.b(d3);
                            j = ((b8 instanceof am) ? 1 : 0);
                            if (i) {
                                continue Label_0063;
                            }
                            if (j != 0) {
                                try {
                                    final am am7 = (am)b8;
                                    if ("TargetGroupNodeConnector".equals(am7.a)) {
                                        final Object b9 = ((am)((am)am7.b).a).b;
                                        if (b9 instanceof am && ((am)b9).a instanceof am) {
                                            final am am8 = (am)((am)b9).a;
                                            if (am8.a instanceof am && "TargetInEdge".equals(((am)am8.a).a) && a6.equals(am8.b)) {
                                                final Object b10 = am8.b;
                                                o = d3;
                                                if (!i) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                catch (ClassCastException ex5) {}
                                catch (NullPointerException ex6) {}
                            }
                        }
                    }
                    else if ("UpperDUmmyNode".equals(am.a)) {
                        final Object a7 = ((am)((am)b).b).a;
                        d d4 = q.g();
                        while (d4 != null) {
                            final Object b11 = c3.b(d4);
                            final boolean b12 = b11 instanceof am;
                            if (i) {
                                continue Label_0063;
                            }
                            if (b12) {
                                try {
                                    final am am9 = (am)b11;
                                    Label_0718: {
                                        if ("DummyEdge".equals(am9.a)) {
                                            final am am10 = (am)c2.b(d4.c());
                                            if ("UpperSameLayerEdgeSupport".equals(am10.a) && a7.equals(((am)((am)am10.b).b).a)) {
                                                o = d4;
                                                if (!i) {
                                                    break;
                                                }
                                            }
                                            if (!"BendNode".equals(am10.a)) {
                                                break Label_0718;
                                            }
                                            final Object a8 = ((am)((am)((am)am10.b).a).b).a;
                                            if (a8 instanceof am && ((am)a8).b instanceof am && a7.equals(((am)((am)a8).b).a)) {
                                                o = d4;
                                                if (!i) {
                                                    break;
                                                }
                                            }
                                            if (!a7.equals(a8)) {
                                                break Label_0718;
                                            }
                                            o = d4;
                                            if (!i) {
                                                break;
                                            }
                                        }
                                        final Object a9 = ((am)am9.b).a;
                                        if (a7.equals(a9)) {
                                            o = d4;
                                            if (!i) {
                                                break;
                                            }
                                        }
                                        if (a9 instanceof am) {
                                            final Object a10 = ((am)a9).a;
                                            if (("InEdge".equals(a10) || "OutEdge".equals(a10)) && a7.equals(((am)((am)a9).b).a)) {
                                                o = d4;
                                                if (!i) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                catch (ClassCastException ex7) {}
                                catch (NullPointerException ex8) {}
                            }
                            d4 = d4.h();
                            if (i) {
                                break;
                            }
                        }
                    }
                    if (o != null) {
                        av2.e.a(q2, o);
                    }
                    ++n;
                }
                break;
            } while (!i);
            int equals = 0;
            continue;
        }
    }
    
    private void a(final av av) {
        final boolean i = y.f.c.a.i;
        final c c = av.b.c(ah.f_);
        av.k = new D[av.c.d.length];
        int j = 0;
        while (j < av.c.d.length) {
        Label_0046:
            while (true) {
                av av2 = null;
                p p = av2.c.d[j].k();
                while (p != null) {
                    final av av3 = av2 = (av)this.a.get(c.b(p.c()));
                    if (i) {
                        continue Label_0046;
                    }
                    if (av2 != null) {
                        if (av.k[j] == null) {
                            av.k[j] = new D();
                        }
                        av.k[j].add(av3);
                    }
                    p = p.a();
                    if (i) {
                        break;
                    }
                }
                break;
            }
            ++j;
            if (i) {
                break;
            }
        }
    }
    
    public Map a() {
        final boolean i = y.f.c.a.i;
        final av b = this.b;
        int a = Integer.MAX_VALUE;
        int n = 20;
        while (n-- > 0 && a > 0) {
            if (this.c(null, b) == 0) {
                break;
            }
            a = this.a(null, b);
            if (i) {
                break;
            }
        }
        final HashMap hashMap = new HashMap();
        this.a(b, hashMap);
        return hashMap;
    }
    
    private void a(final av av, final Map map) {
        final boolean i = y.f.c.a.i;
        final c c = av.b.c(ah.f_);
        final x o = av.b.o();
        while (o.f()) {
            final Object b = c.b(o.e());
            map.put(b, new Integer(av.c.a[o.e().d()]));
            final av av2 = this.a.get(b);
            if (av2 != null) {
                this.a(av2, map);
            }
            o.g();
            if (i) {
                break;
            }
        }
    }
    
    private int c(final av av, final av av2) {
        final boolean i = y.f.c.a.i;
        final y.f.c.h h = (av != null) ? av.c : null;
        final y.f.c.h c = av2.c;
        av2.b.c(ah.f_);
        int n = 0;
        Label_0452: {
            if (av != null) {
                final int n2 = (av2.g != null && av2.g.length > 0) ? 1 : 0;
                int j;
                p p2;
                int n3;
                p p3;
                int n4;
                p p4;
                d d;
                Label_0183:Label_0286_Outer:
                while (true) {
                    if (n2 != 0) {
                        this.d.a = av.c.k;
                        this.d.c = c.a;
                        this.d.b = av2.e;
                        c.d[0].sort(this.d);
                        j = 0;
                        p2 = c.d[0].k();
                        while (p2 != null) {
                            c.a[((q)p2.c()).d()] = j;
                            p2 = p2.a();
                            ++j;
                            if (i) {
                                break Label_0183;
                            }
                            if (i) {
                                break;
                            }
                        }
                    }
                    Label_0180: {
                        break Label_0180;
                        while (true) {
                            while (j < c.d.length) {
                                n3 = j;
                                if (!i) {
                                    if (n3 > 0) {
                                        c.a(j);
                                    }
                                    Label_0276: {
                                        if (av2.k[j] != null) {
                                            p3 = av2.k[j].k();
                                            while (p3 != null) {
                                                n += this.c(av2, (av)p3.c());
                                                p3 = p3.a();
                                                if (i) {
                                                    break Label_0276;
                                                }
                                                if (i) {
                                                    break;
                                                }
                                            }
                                        }
                                        ++j;
                                    }
                                    if (i) {
                                        break;
                                    }
                                    continue Label_0286_Outer;
                                }
                                else {
                                    if (n3 != 0 && c.d.length - n2 > 0) {
                                        c.a(n2, c.d.length - 1);
                                    }
                                    Label_0447: {
                                        if (av2.h != null && av2.h.length > 0) {
                                            n4 = 1;
                                            p4 = c.d[c.d.length - 1].k();
                                            while (p4 != null) {
                                                d = (d)av2.e.b(p4.c());
                                                if (i) {
                                                    break Label_0447;
                                                }
                                                if (d != null) {
                                                    h.g[d.b()] = n4++;
                                                }
                                                p4 = p4.a();
                                                if (i) {
                                                    break;
                                                }
                                            }
                                        }
                                        n += c.f();
                                    }
                                    if (i) {
                                        break Label_0452;
                                    }
                                    return n;
                                }
                            }
                            c.a();
                            continue;
                        }
                    }
                    j = 0;
                    continue Label_0183;
                }
            }
        }
        int k = 0;
        int n5 = 0;
        while (k < av2.f) {
            n5 = k;
            if (i) {
                n = n5;
                return n;
            }
            if (n5 > 0) {
                c.a(k);
            }
            Label_0546: {
                if (av2.k[k] != null) {
                    p p5 = av2.k[k].k();
                    while (p5 != null) {
                        n += this.c(av2, (av)p5.c());
                        p5 = p5.a();
                        if (i) {
                            break Label_0546;
                        }
                        if (i) {
                            break;
                        }
                    }
                }
                ++k;
            }
            if (i) {
                break;
            }
        }
        final int n6 = n + c.f();
        return n5;
    }
    
    public int a(final av av, final av av2) {
        final boolean i = y.f.c.a.i;
        final y.f.c.h h = (av != null) ? av.c : null;
        final y.f.c.h c = av2.c;
        av2.b.c(ah.f_);
        int n = 0;
        Label_0468: {
            if (av != null) {
                final int n2 = (av2.h != null && av2.h.length > 0) ? 1 : 0;
                int j;
                p p2;
                int n3;
                int n4;
                p p3;
                int n5;
                p p4;
                d d;
                Label_0204:Label_0460_Outer:
                while (true) {
                    if (n2 != 0) {
                        this.d.a = av.c.j;
                        this.d.c = c.a;
                        this.d.b = av2.e;
                        c.d[c.d.length - 1].sort(this.d);
                        j = 0;
                        p2 = c.d[c.d.length - 1].k();
                        while (p2 != null) {
                            c.a[((q)p2.c()).d()] = j;
                            p2 = p2.a();
                            ++j;
                            if (i) {
                                break Label_0204;
                            }
                            if (i) {
                                break;
                            }
                        }
                    }
                    Label_0194: {
                        break Label_0194;
                    Label_0463_Outer:
                        while (true) {
                        Label_0463:
                            while (true) {
                                while (j >= 0) {
                                    n3 = j;
                                    n4 = c.d.length - 1;
                                    if (!i) {
                                        if (n3 < n4) {
                                            c.b(j);
                                        }
                                        Label_0299: {
                                            if (av2.k[j] != null) {
                                                p3 = av2.k[j].k();
                                                while (p3 != null) {
                                                    n += this.a(av2, (av)p3.c());
                                                    p3 = p3.a();
                                                    if (i) {
                                                        break Label_0299;
                                                    }
                                                    if (i) {
                                                        break;
                                                    }
                                                }
                                            }
                                            --j;
                                        }
                                        if (i) {
                                            break;
                                        }
                                        continue Label_0460_Outer;
                                    }
                                    else {
                                        n = n3 + n4;
                                        if (i) {
                                            break Label_0468;
                                        }
                                        return n;
                                    }
                                }
                                if (c.a() && c.d.length - n2 > 0) {
                                    c.a(c.d.length - ((n2 != 0) ? 2 : 1), 0);
                                }
                                if (av2.g != null && av2.g.length > 0) {
                                    n5 = 1;
                                    p4 = c.d[0].k();
                                    while (p4 != null) {
                                        d = (d)av2.e.b(p4.c());
                                        if (i) {
                                            continue Label_0463;
                                        }
                                        if (d != null) {
                                            h.h[d.b()] = n5++;
                                        }
                                        p4 = p4.a();
                                        if (i) {
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            c.f();
                            continue Label_0463_Outer;
                        }
                    }
                    j = c.d.length - 1;
                    continue Label_0204;
                }
            }
        }
        int k = av2.f - 1;
        int n6 = 0;
        int n7 = 0;
        while (k >= 0) {
            n6 = k;
            n7 = av2.f - 1;
            if (i) {
                n = n6 + n7;
                return n;
            }
            if (n6 < n7) {
                c.b(k);
            }
            Label_0569: {
                if (av2.k[k] != null) {
                    p p5 = av2.k[k].k();
                    while (p5 != null) {
                        n += this.a(av2, (av)p5.c());
                        p5 = p5.a();
                        if (i) {
                            break Label_0569;
                        }
                        if (i) {
                            break;
                        }
                    }
                }
                --k;
            }
            if (i) {
                break;
            }
        }
        c.f();
        return n6 + n7;
    }
}
