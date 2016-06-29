package y.f.c.a;

import y.g.*;
import java.awt.geom.*;
import y.f.*;
import y.d.*;
import y.c.*;
import java.util.*;

class bY implements dC
{
    private static final double a;
    private bP b;
    private E c;
    private boolean d;
    private boolean e;
    private boolean f;
    private double g;
    private double h;
    private double i;
    private double j;
    private double k;
    private double l;
    private double m;
    private boolean n;
    private double o;
    private boolean p;
    private double q;
    private boolean r;
    private Map s;
    private long t;
    private List u;
    private List v;
    private List w;
    private List x;
    private List y;
    private Map z;
    private bt A;
    private bt B;
    
    bY(final bP b, final E c) {
        this.e = true;
        this.g = 0.2;
        this.h = 150.0;
        this.i = 10.0;
        this.j = 20.0;
        this.k = 10.0;
        this.l = 15.0;
        this.m = 0.0;
        this.n = false;
        this.o = 10.0;
        this.p = false;
        this.q = 10.0;
        this.t = Long.MAX_VALUE;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.b = b;
        this.c = c;
    }
    
    public void a(final boolean f) {
        this.f = f;
    }
    
    public void b(final boolean r) {
        this.r = r;
    }
    
    void a(final Map s) {
        this.s = s;
        final Number value = s.get("DefaultEdgeRouter.minimumNodeToEdgeDistance");
        if (value instanceof Number) {
            this.a(value.doubleValue());
        }
        final Number value2 = s.get("DefaultEdgeRouter.enforceExactLayering");
        if (value2 instanceof Boolean) {
            this.b((boolean)value2);
        }
        final Number value3 = s.get("DefaultEdgeRouter.minimumEdgeDistance");
        if (value3 instanceof Number) {
            this.b(value3.doubleValue());
        }
        final Number value4 = s.get("DefaultEdgeRouter.polygonalGroupRoutingEnabled");
        if (value4 instanceof Boolean) {
            this.a((boolean)value4);
        }
        final Number value5 = s.get("DefaultEdgeRouter.polygonalRoutingEnabled");
        if (value5 instanceof Boolean) {
            this.e = (boolean)value5;
        }
        final Number value6 = s.get("DefaultEdgeRouter.defaultMaxBonusDist");
        if (value6 instanceof Number) {
            this.h = value6.doubleValue();
        }
        final Number value7 = s.get("DefaultEdgeRouter.defaultMinPolyDistance");
        if (value7 instanceof Number) {
            this.i = value7.doubleValue();
        }
        final Number value8 = s.get("DefaultEdgeRouter.defaultMinLayerDistance");
        if (value8 instanceof Number) {
            this.j = value8.doubleValue();
        }
        final Number value9 = s.get("DefaultEdgeRouter.defaultMinPolyDistance");
        if (value9 instanceof Number) {
            this.i = value9.doubleValue();
        }
        final Number value10 = s.get("DefaultEdgeRouter.defaultMinimumSlope");
        if (value10 instanceof Number) {
            this.g = value10.doubleValue();
        }
        final Number value11 = s.get("DefaultEdgeRouter.defaultMinimumFirstSegmentLength");
        if (value11 instanceof Number) {
            this.k = value11.doubleValue();
        }
        final Number value12 = s.get("DefaultEdgeRouter.defaultMinimumLastSegmentLength");
        if (value12 instanceof Number) {
            this.l = value12.doubleValue();
        }
        final Number value13 = s.get("DefaultEdgeRouter.fromSketchMode");
        if (value13 instanceof Boolean) {
            this.n = (boolean)value13;
        }
        final Number value14 = s.get("DefaultEdgeRouter.assignLaneToProxyNodes");
        if (value14 instanceof Boolean) {
            this.p = (boolean)value14;
        }
    }
    
    public void a(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        this.z = new HashMap();
        this.b(x, au, av);
    Label_0161:
        for (final Map.Entry<d, V> entry : this.z.entrySet()) {
            final d d = (d)entry.getKey();
            final D d2 = entry.getValue();
            final I b = x.b((Object)d);
            b.clearPoints();
            p p3 = d2.k();
            while (p3 != null) {
                final Point2D.Double double1 = (Point2D.Double)p3.c();
                b.addPoint(double1.x, double1.y);
                p3 = p3.a();
                if (x2 || x2) {
                    return;
                }
                if (x2) {
                    break Label_0161;
                }
            }
        }
        this.z = null;
    }
    
    private static bK a(final d d, final q q, final aV av) {
        final bK h = av.a(q).h();
        final aX a = av.a(d.a(q));
        if (a.b() == 2) {
            return h;
        }
        final bK h2 = a.h();
        return (h != null && h.equals(h2)) ? h : null;
    }
    
    public void a(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        ae.a(x, false);
        this.u.clear();
        this.v.clear();
        this.w.clear();
        final ArrayList<Object> list = new ArrayList<Object>(32);
        final ArrayList<Object> list2 = new ArrayList<Object>(32);
        final ArrayList<Object> list3 = new ArrayList<Object>(32);
        final ArrayList<Object> list4 = new ArrayList<Object>(32);
        final ArrayList<Object> list5 = new ArrayList<Object>(32);
        final ArrayList<Object> list6 = new ArrayList<Object>(32);
        final ArrayList<Object> list7 = new ArrayList<Object>(32);
        final ArrayList<Object> list8 = new ArrayList<Object>(32);
        final ArrayList<Object> list9 = new ArrayList<Object>(32);
        final ArrayList<Object> list10 = new ArrayList<Object>(32);
        final ArrayList<Object> list11 = new ArrayList<Object>(32);
        final ArrayList<Object> list12 = new ArrayList<Object>(32);
        final ArrayList list13 = new ArrayList<d>(32);
        final cY cy = new cY(x, au, av);
        final cT ct = new cT(x, au, av);
        final ca ca = new ca(x);
        int n = 0;
        do {
            int i = 0;
        Label_0219:
            while (i < au.b()) {
                final aQ a = au.a(n);
                int n2 = 0;
                final y d = a.d();
                q q = null;
                p p4 = d.k();
                while (p4 != null) {
                    Object o = p4.c();
                    Label_2943: {
                        q a2 = null;
                        p p5 = null;
                    Label_1147:
                        while (true) {
                            a2 = (q)o;
                            final aX a3 = av.a(a2);
                            final byte b2;
                            final byte b = b2 = a3.b();
                            if (x2) {
                                continue Label_0219;
                            }
                            if (b == 0 || a3.b() == 12 || a3.b() == 13 || a3.b() == 15) {
                                if (list13.size() != 0) {
                                    final Rectangle2D.Double a4 = this.b.a(x, av, q, a2, list13);
                                    if (a4 != null) {
                                        this.w.add(ap.a(a, a4, (d[])list13.toArray(new d[list13.size()])));
                                        final p l = d.l();
                                        d.h(l);
                                        d.a(l, p4);
                                    }
                                }
                                ca.a = a2;
                                q = a2;
                                list13.clear();
                                list5.clear();
                                list7.clear();
                                list6.clear();
                                list8.clear();
                                list9.clear();
                                list11.clear();
                                list10.clear();
                                list12.clear();
                                p5 = a3.d();
                                while (true) {
                                    while (p5 != null) {
                                        final d d2 = (d)p5.c();
                                        final q a5 = d2.a(a2);
                                        final A a6 = av.a(d2);
                                        final I b3 = x.b((Object)d2);
                                        final int n3 = av.a(a5).k() - a3.k();
                                        final q c = d2.c();
                                        if (x2) {
                                            d d3 = c.g();
                                            while (d3 != null) {
                                                final A a7 = av.a(d3);
                                                final aE ae = (aE)(o = a7.e());
                                                if (x2) {
                                                    continue Label_2943;
                                                }
                                                Label_1008: {
                                                    if (ae != null && !a7.e().c()) {
                                                        if (a7.e().f()) {
                                                            list.add(d3);
                                                            if (!x2) {
                                                                break Label_1008;
                                                            }
                                                        }
                                                        if (a7.e().e()) {
                                                            list2.add(d3);
                                                        }
                                                    }
                                                }
                                                d3 = d3.h();
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                            list3.clear();
                                            list4.clear();
                                            d d4 = a2.f();
                                            while (d4 != null) {
                                                final A a8 = av.a(d4);
                                                final aE ae2 = (aE)(o = a8.c());
                                                if (x2) {
                                                    continue Label_2943;
                                                }
                                                Label_1135: {
                                                    if (ae2 != null && !a8.c().d()) {
                                                        if (a8.c().f()) {
                                                            list3.add(d4);
                                                            if (!x2) {
                                                                break Label_1135;
                                                            }
                                                        }
                                                        if (a8.c().e()) {
                                                            list4.add(d4);
                                                        }
                                                    }
                                                }
                                                d4 = d4.g();
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                            break Label_1147;
                                        }
                                        aE ae3 = null;
                                        Label_0631: {
                                            if (c == a2) {
                                                ae3 = a6.c();
                                                if (!x2) {
                                                    break Label_0631;
                                                }
                                            }
                                            ae3 = a6.e();
                                        }
                                        Label_0877: {
                                            if (av.a(d2).a() == 4) {
                                                if (n3 <= 0) {
                                                    break Label_0877;
                                                }
                                                list13.add(d2);
                                                if (!x2) {
                                                    break Label_0877;
                                                }
                                            }
                                            b3.clearPoints();
                                            if (ae3 != null && !ae3.c() && !ae3.d() && !ae3.g()) {
                                                if (ae3.e()) {
                                                    if (n3 < 0) {
                                                        if (a6.j()) {
                                                            list6.add(d2);
                                                            if (!x2) {
                                                                break Label_0877;
                                                            }
                                                        }
                                                        list10.add(d2);
                                                        if (!x2) {
                                                            break Label_0877;
                                                        }
                                                    }
                                                    if (a6.j()) {
                                                        list8.add(d2);
                                                        if (!x2) {
                                                            break Label_0877;
                                                        }
                                                    }
                                                    list12.add(d2);
                                                    if (!x2) {
                                                        break Label_0877;
                                                    }
                                                }
                                                if (n3 > 0) {
                                                    if (a6.j()) {
                                                        list5.add(d2);
                                                        if (!x2) {
                                                            break Label_0877;
                                                        }
                                                    }
                                                    list9.add(d2);
                                                    if (!x2) {
                                                        break Label_0877;
                                                    }
                                                }
                                                if (a6.j()) {
                                                    list7.add(d2);
                                                    if (!x2) {
                                                        break Label_0877;
                                                    }
                                                }
                                                list11.add(d2);
                                            }
                                        }
                                        p5 = p5.a();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    list.clear();
                                    list2.clear();
                                    p5 = p4;
                                    continue;
                                }
                            }
                            break Label_2943;
                        }
                        int p6 = 0;
                        Label_1304: {
                            if (list11.size() > 0) {
                                y.g.e.a(list11, ca);
                                int j = list11.size() - 1;
                                while (j >= 0) {
                                    final d d5 = list11.get(j);
                                    p6 = (this.p ? 1 : 0);
                                    if (x2) {
                                        break Label_1304;
                                    }
                                    Label_1265: {
                                        if (p6 != 0) {
                                            this.v.add(ap.a(a, a2, d5, a(d5, a2, av)));
                                            if (!x2) {
                                                break Label_1265;
                                            }
                                        }
                                        this.v.add(ap.a(a, a2, d5));
                                    }
                                    final p k = d.l();
                                    d.h(k);
                                    d.a(k, p4);
                                    --j;
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            list3.size();
                        }
                        int p7 = 0;
                        Label_1447: {
                            if (p6 > 0) {
                                y.g.e.a(list3, ct);
                                int n4 = 0;
                                while (n4 < list3.size()) {
                                    final d d6 = list3.get(n4);
                                    p7 = (this.p ? 1 : 0);
                                    if (x2) {
                                        break Label_1447;
                                    }
                                    Label_1408: {
                                        if (p7 != 0) {
                                            this.u.add(ap.a(d6, true, a(d6, a2, av)));
                                            if (!x2) {
                                                break Label_1408;
                                            }
                                        }
                                        this.u.add(ap.a(d6, true));
                                    }
                                    final p m = d.l();
                                    d.h(m);
                                    d.a(m, p4);
                                    ++n4;
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            list9.size();
                        }
                        int p8 = 0;
                        Label_1597: {
                            if (p7 > 0) {
                                y.g.e.a(list9, ca);
                                int n5 = list9.size() - 1;
                                while (n5 >= 0) {
                                    final d d7 = list9.get(n5);
                                    p8 = (this.p ? 1 : 0);
                                    if (x2) {
                                        break Label_1597;
                                    }
                                    Label_1558: {
                                        if (p8 != 0) {
                                            this.v.add(ap.a(a, a2, d7, a(d7, a2, av)));
                                            if (!x2) {
                                                break Label_1558;
                                            }
                                        }
                                        this.v.add(ap.a(a, a2, d7));
                                    }
                                    final p l2 = d.l();
                                    d.h(l2);
                                    d.a(l2, p4);
                                    --n5;
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            list7.size();
                        }
                        int p9 = 0;
                        Label_1746: {
                            if (p8 > 0) {
                                y.g.e.a(list7, ca);
                                int n6 = 0;
                                while (n6 < list7.size()) {
                                    final d d8 = list7.get(n6);
                                    p9 = (this.p ? 1 : 0);
                                    if (x2) {
                                        break Label_1746;
                                    }
                                    Label_1707: {
                                        if (p9 != 0) {
                                            this.v.add(ap.a(a, a2, d8, a(d8, a2, av)));
                                            if (!x2) {
                                                break Label_1707;
                                            }
                                        }
                                        this.v.add(ap.a(a, a2, d8));
                                    }
                                    final p l3 = d.l();
                                    d.h(l3);
                                    d.a(l3, p4);
                                    ++n6;
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            list.size();
                        }
                        int p10 = 0;
                        Label_1889: {
                            if (p9 > 0) {
                                y.g.e.a(list, cy);
                                int n7 = 0;
                                while (n7 < list.size()) {
                                    final d d9 = list.get(n7);
                                    p10 = (this.p ? 1 : 0);
                                    if (x2) {
                                        break Label_1889;
                                    }
                                    Label_1850: {
                                        if (p10 != 0) {
                                            this.u.add(ap.a(d9, false, a(d9, a2, av)));
                                            if (!x2) {
                                                break Label_1850;
                                            }
                                        }
                                        this.u.add(ap.a(d9, false));
                                    }
                                    final p l4 = d.l();
                                    d.h(l4);
                                    d.a(l4, p4);
                                    ++n7;
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            list5.size();
                        }
                        int p11 = 0;
                        Label_2038: {
                            if (p10 > 0) {
                                y.g.e.a(list5, ca);
                                int n8 = 0;
                                while (n8 < list5.size()) {
                                    final d d10 = list5.get(n8);
                                    p11 = (this.p ? 1 : 0);
                                    if (x2) {
                                        break Label_2038;
                                    }
                                    Label_1999: {
                                        if (p11 != 0) {
                                            this.v.add(ap.a(a, a2, d10, a(d10, a2, av)));
                                            if (!x2) {
                                                break Label_1999;
                                            }
                                        }
                                        this.v.add(ap.a(a, a2, d10));
                                    }
                                    final p l5 = d.l();
                                    d.h(l5);
                                    d.a(l5, p4);
                                    ++n8;
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            list6.size();
                        }
                        int p12 = 0;
                        Label_2192: {
                            if (p11 > 0) {
                                y.g.e.a(list6, ca);
                                int n9 = list6.size() - 1;
                                while (n9 >= 0) {
                                    final d d11 = list6.get(n9);
                                    p12 = (this.p ? 1 : 0);
                                    if (x2) {
                                        break Label_2192;
                                    }
                                    Label_2149: {
                                        if (p12 != 0) {
                                            this.v.add(ap.a(a, a2, d11, a(d11, a2, av)));
                                            if (!x2) {
                                                break Label_2149;
                                            }
                                        }
                                        this.v.add(ap.a(a, a2, d11));
                                    }
                                    final p l6 = d.l();
                                    d.h(l6);
                                    d.b(l6, p5);
                                    p5 = l6;
                                    --n9;
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            list2.size();
                        }
                        int p13 = 0;
                        Label_2339: {
                            if (p12 > 0) {
                                y.g.e.a(list2, cy);
                                int n10 = 0;
                                while (n10 < list2.size()) {
                                    final d d12 = list2.get(n10);
                                    p13 = (this.p ? 1 : 0);
                                    if (x2) {
                                        break Label_2339;
                                    }
                                    Label_2296: {
                                        if (p13 != 0) {
                                            this.u.add(ap.a(d12, false, a(d12, a2, av)));
                                            if (!x2) {
                                                break Label_2296;
                                            }
                                        }
                                        this.u.add(ap.a(d12, false));
                                    }
                                    final p l7 = d.l();
                                    d.h(l7);
                                    d.b(l7, p5);
                                    p5 = l7;
                                    ++n10;
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            list8.size();
                        }
                        int p14 = 0;
                        Label_2493: {
                            if (p13 > 0) {
                                y.g.e.a(list8, ca);
                                int n11 = list8.size() - 1;
                                while (n11 >= 0) {
                                    final d d13 = list8.get(n11);
                                    p14 = (this.p ? 1 : 0);
                                    if (x2) {
                                        break Label_2493;
                                    }
                                    Label_2450: {
                                        if (p14 != 0) {
                                            this.v.add(ap.a(a, a2, d13, a(d13, a2, av)));
                                            if (!x2) {
                                                break Label_2450;
                                            }
                                        }
                                        this.v.add(ap.a(a, a2, d13));
                                    }
                                    final p l8 = d.l();
                                    d.h(l8);
                                    d.b(l8, p5);
                                    p5 = l8;
                                    --n11;
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            list10.size();
                        }
                        int p15 = 0;
                        Label_2646: {
                            if (p14 > 0) {
                                y.g.e.a(list10, ca);
                                int n12 = 0;
                                while (n12 < list10.size()) {
                                    final d d14 = list10.get(n12);
                                    p15 = (this.p ? 1 : 0);
                                    if (x2) {
                                        break Label_2646;
                                    }
                                    Label_2603: {
                                        if (p15 != 0) {
                                            this.v.add(ap.a(a, a2, d14, a(d14, a2, av)));
                                            if (!x2) {
                                                break Label_2603;
                                            }
                                        }
                                        this.v.add(ap.a(a, a2, d14));
                                    }
                                    final p l9 = d.l();
                                    d.h(l9);
                                    d.b(l9, p5);
                                    p5 = l9;
                                    ++n12;
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            list4.size();
                        }
                        int p16 = 0;
                        Label_2793: {
                            if (p15 > 0) {
                                y.g.e.a(list4, ct);
                                int n13 = 0;
                                while (n13 < list4.size()) {
                                    final d d15 = list4.get(n13);
                                    p16 = (this.p ? 1 : 0);
                                    if (x2) {
                                        break Label_2793;
                                    }
                                    Label_2750: {
                                        if (p16 != 0) {
                                            this.u.add(ap.a(d15, true, a(d15, a2, av)));
                                            if (!x2) {
                                                break Label_2750;
                                            }
                                        }
                                        this.u.add(ap.a(d15, true));
                                    }
                                    final p l10 = d.l();
                                    d.h(l10);
                                    d.b(l10, p5);
                                    p5 = l10;
                                    ++n13;
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            list12.size();
                        }
                        if (p16 > 0) {
                            y.g.e.a(list12, ca);
                            int n14 = 0;
                            while (n14 < list12.size()) {
                                final d d16 = list12.get(n14);
                                i = (this.p ? 1 : 0);
                                if (x2) {
                                    continue Label_0219;
                                }
                                Label_2903: {
                                    if (i != 0) {
                                        this.v.add(ap.a(a, a2, d16, a(d16, a2, av)));
                                        if (!x2) {
                                            break Label_2903;
                                        }
                                    }
                                    this.v.add(ap.a(a, a2, d16));
                                }
                                final p l11 = d.l();
                                d.h(l11);
                                d.b(l11, p5);
                                p5 = l11;
                                ++n14;
                                if (x2) {
                                    break;
                                }
                            }
                        }
                        p4 = p5;
                    }
                    p4 = p4.a();
                    ++n2;
                    if (x2) {
                        break;
                    }
                }
                ++n;
            }
            break;
        } while (!x2);
    }
    
    public void b(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        int i = 0;
        while (i < this.u.size()) {
            ap.b((q)this.u.get(i));
            ++i;
            if (x2) {
                return;
            }
            if (x2) {
                break;
            }
        }
        this.u.clear();
    }
    
    public void c(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        int i = 0;
        while (i < this.v.size()) {
            final q q = this.v.get(i);
            final aX a = av.a(q);
            final q f = a.f();
            final d g = a.g();
            final aX a2 = av.a(f);
            final am a3 = x.a((Object)f);
            if (x2) {
                return;
            }
            final aE ae = (f == g.c()) ? av.a(g).c() : av.a(g).e();
            Label_0394: {
                if (ae != null && (ae.e() || ae.f()) && av.a(f).b() == 0) {
                    final t o = x.o(q);
                    final c a4 = a2.a(0, a3);
                    final c a5 = a2.a(2, a3);
                    final double n = o.a - a3.getX();
                    if (o.a > a3.getX()) {
                        final double width = a3.getWidth();
                        final double n2 = (Math.abs(width - n) > 1.0E-4) ? n : width;
                        if (a4 != null) {
                            a4.a(width, n2, o.b - a3.getY());
                        }
                        if (a5 == null) {
                            break Label_0394;
                        }
                        a5.b(width, n2, o.b - a3.getY());
                        if (!x2) {
                            break Label_0394;
                        }
                    }
                    final double n3 = (Math.abs(n) > 1.0E-4) ? n : 0.0;
                    if (a4 != null) {
                        a4.a(n3, 0.0, o.b - a3.getY());
                    }
                    if (a5 != null) {
                        a5.b(n3, 0.0, o.b - a3.getY());
                    }
                }
            }
            ap.a(q);
            ++i;
            if (x2) {
                break;
            }
        }
        this.v.clear();
    }
    
    public void d(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        int i = 0;
        while (i < this.w.size()) {
            ap.e((q)this.w.get(i));
            ++i;
            if (x2) {
                return;
            }
            if (x2) {
                break;
            }
        }
        this.w.clear();
    }
    
    public void e(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        this.x = new ArrayList(62);
        this.y = new ArrayList(62);
        int n = 0;
    Label_0323:
        do {
        Label_0315:
            while (true) {
                au.b();
                int i = 0;
                int n2 = 0;
            Label_0042:
                while (i < n2) {
                    final aQ a = au.a(n);
                    p p4 = a.d().k();
                    while (p4 != null) {
                        final q q = (q)p4.c();
                        final byte b = av.a(q).b();
                        final byte b3;
                        final byte b2 = b3 = b;
                        if (x2) {
                            continue Label_0315;
                        }
                        if (b2 == 0 || b == 15) {
                            d j = q.i();
                            while (j != null) {
                                final d k = j.j();
                                final A a2 = av.a(j);
                                i = av.a(j.c()).j();
                                n2 = n;
                                if (x2) {
                                    continue Label_0042;
                                }
                                Label_0211: {
                                    if (i == n2) {
                                        this.a(x, a, a2, ap, q, j);
                                        if (!x2) {
                                            break Label_0211;
                                        }
                                    }
                                    this.b(x, a, a2, ap, q, j);
                                }
                                j = k;
                                if (x2) {
                                    break;
                                }
                            }
                            d h = q.h();
                            while (h != null) {
                                final d l = h.i();
                                final A a3 = av.a(h);
                                final int m = av.a(h.d()).j();
                                final int n3 = n;
                                if (x2) {
                                    continue Label_0042;
                                }
                                if (m != n3) {
                                    this.b(x, a, a3, ap, q, h);
                                }
                                h = l;
                                if (x2) {
                                    break;
                                }
                            }
                        }
                        p4 = p4.a();
                        if (x2) {
                            break;
                        }
                    }
                    break Label_0315;
                }
                break Label_0323;
            }
            ++n;
        } while (!x2);
    }
    
    public void a(final X x, final aQ aq, final A a, final aP ap, final q q, final d d) {
        final aE c = a.c();
        final aE e = a.e();
        if (c != null && e != null && ((c.d() && e.c()) || (c.c() && e.d()))) {
            this.y.add(ap.b(aq, d));
        }
    }
    
    public void b(final X x, final aQ aq, final A a, final aP ap, final q q, final d d) {
        if (q == d.d()) {
            if (a.e() == null || !a.e().d()) {
                return;
            }
            this.x.add(ap.a(aq, d, q));
            if (!N.x) {
                return;
            }
        }
        if (a.c() != null && a.c().c()) {
            this.x.add(ap.a(aq, d, q));
        }
    }
    
    public void f(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        int i = 0;
        while (true) {
            while (i < this.x.size()) {
                ap.c((d)this.x.get(i));
                ++i;
                if (x2) {
                    while (i < this.y.size()) {
                        ap.d((q)this.y.get(i));
                        ++i;
                        if (x2) {
                            return;
                        }
                        if (x2) {
                            break;
                        }
                    }
                    this.y.clear();
                    this.y = null;
                    this.x.clear();
                    this.x = null;
                    return;
                }
                if (x2) {
                    break;
                }
            }
            i = 0;
            continue;
        }
    }
    
    private boolean a(final aQ aq, final aQ aq2) {
        final bt b = aq.b();
        final bt b2 = aq2.b();
        if (b != null && b2 != null) {
            return b != b2;
        }
        return (b != null || b2 != null) && ((b == null && b2 != this.B) || (b2 == null && b != this.B));
    }
    
    private D a(final bt bt, final bt bt2, final X x) {
        final boolean x2 = N.x;
        final bk c = bk.c(x);
        final D d = new D();
        D d2 = null;
        if (c != null && (bt != null || bt2 != null)) {
            Label_0079: {
                if (bt == null) {
                    final int a = bt2.a();
                    int i = 0;
                    while (i < a) {
                        d2 = d;
                        if (x2) {
                            break;
                        }
                        d2.b(c.a(i));
                        ++i;
                        if (x2) {
                            break Label_0079;
                        }
                    }
                    return d2;
                }
            }
            Label_0134: {
                if (bt2 == null) {
                    int j = bt.a() + 1;
                    while (j < c.e().size()) {
                        final D d3 = d;
                        if (x2) {
                            break;
                        }
                        d3.b(c.a(j));
                        ++j;
                        if (x2) {
                            break Label_0134;
                        }
                    }
                    return d2;
                }
            }
            final int min = Math.min(bt.a(), bt2.a());
            final int max = Math.max(bt.a(), bt2.a());
            int k = min + 1;
            while (k < max) {
                final D d4 = d;
                if (x2) {
                    break;
                }
                d4.b(c.a(k));
                ++k;
                if (x2) {
                    break;
                }
            }
        }
        return d2;
    }
    
    private void a(final bt bt, final X x) {
        final boolean x2 = N.x;
        final D a = this.a(null, bt, x);
        if (!a.isEmpty()) {
            a.n();
            double h = bt.h();
            final C m = a.m();
            while (m.f()) {
                final bt bt2 = (bt)m.d();
                h -= bt2.b();
                bt2.g(h);
                bt2.d(bt2.b());
                m.g();
                if (x2) {
                    break;
                }
            }
        }
    }
    
    private void b(final bt bt, final X x) {
        final boolean x2 = N.x;
        final D a = this.a(bt, null, x);
        if (!a.isEmpty()) {
            double n = bt.h() + bt.e();
            final C m = a.m();
            while (m.f()) {
                final bt bt2 = (bt)m.d();
                bt2.g(n);
                bt2.d(bt2.b());
                n += bt2.e();
                m.g();
                if (x2) {
                    break;
                }
            }
        }
    }
    
    private double b(final bt bt, final bt bt2, final X x) {
        final boolean x2 = N.x;
        double n = bt.h() + bt.e();
        final C m = this.a(bt, bt2, x).m();
        double n2 = 0.0;
        while (m.f()) {
            final bt bt3 = (bt)m.d();
            bt3.g(n);
            bt3.d(bt3.b());
            n2 = n + bt3.e();
            if (x2) {
                return n2;
            }
            n = n2;
            m.g();
            if (x2) {
                break;
            }
        }
        return n2;
    }
    
    private double c(final bt bt, final bt bt2, final X x) {
        final boolean x2 = N.x;
        double n = 0.0;
        final D a = this.a(bt, bt2, x);
        double n2 = 0.0;
        if (!a.isEmpty()) {
            final C m = a.m();
            while (m.f()) {
                n2 = n + ((bt)m.d()).b();
                if (x2) {
                    break;
                }
                n = n2;
                m.g();
                if (x2) {
                    break;
                }
            }
        }
        return n2;
    }
    
    private boolean a(final X x, final aV av) {
        final boolean x2 = N.x;
        if (av == null) {
            return false;
        }
        final y.c.e p2 = x.p();
        while (p2.f()) {
            final A a = av.a(p2.a());
            if (a == null || a.k() == null || a.k().h().b() != 2) {
                return false;
            }
            p2.g();
            if (x2) {
                break;
            }
        }
        return true;
    }
    
    private void b(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final ArrayList<d> list = new ArrayList<d>(120);
        double n = 0.0;
        final cr cr = new cr();
        final long currentTimeMillis = System.currentTimeMillis();
        cr.a((this.t == Long.MAX_VALUE) ? Long.MAX_VALUE : (this.t / au.b()));
        Label_0129: {
            if (this.t < 10L) {
                cr.a(0);
                cr.b(0);
                cr.c(0);
                if (!x2) {
                    break Label_0129;
                }
            }
            cr.a(Integer.MAX_VALUE);
            cr.b(Integer.MAX_VALUE);
            cr.c(Integer.MAX_VALUE);
        }
        if (this.s != null) {
            final Number value = this.s.get("ChannelRouter.maximalConstraintSimplexDuration");
            if (value instanceof Number) {
                cr.a(value.longValue());
            }
            final Number value2 = this.s.get("ChannelRouter.segmentMisgraphEdgeLimit");
            if (value2 instanceof Number) {
                cr.a(value2.intValue());
            }
            final Number value3 = this.s.get("ChannelRouter.maxConstraintsCount");
            if (value3 instanceof Number) {
                cr.c(value3.intValue());
            }
            final Number value4 = this.s.get("ChannelRouter.segmentMisGraphLimit");
            if (value4 instanceof Number) {
                cr.b(value4.intValue());
            }
        }
        final HashMap<d, q> hashMap = new HashMap<d, q>();
    Label_0389:
        while (true) {
        Label_0383:
            for (final q q : this.w) {
                final an an = (an)av.a(q);
                int i = 0;
                while (i < an.a.length) {
                    hashMap.put(an.a[i], q);
                    ++i;
                    if (x2 || x2) {
                        break Label_0389;
                    }
                    if (x2) {
                        break Label_0383;
                    }
                }
                continue;
                final c c = new c(-1.7976931348623157E308, Double.MAX_VALUE, -1.7976931348623157E308);
                final boolean a = this.a(x, av);
                int j = 0;
            Label_0606_Outer:
                while (j < au.b()) {
                    final aQ a2 = au.a(j);
                    final y d = a2.d();
                    final c c2 = new c(-1.7976931348623157E308, Double.MAX_VALUE, Double.MAX_VALUE);
                    double max = -1.7976931348623157E308;
                    p p3 = d.l();
                    while (true) {
                        while (p3 != null) {
                            final q q2 = (q)p3.c();
                            final am a3 = x.a((Object)q2);
                            a3.setLocation(a3.getX(), a3.getY() + n);
                            final int n2 = j;
                            if (!x2) {
                                if (n2 == 0) {
                                    this.a(x, av, c2, q2, a3, 0.0, true);
                                }
                                this.a(x, av, c, q2, a3, 0.0, false);
                                max = Math.max(max, a3.getY() + a3.getHeight());
                                p3 = p3.b();
                                if (x2) {
                                    break;
                                }
                                continue Label_0606_Outer;
                            }
                            else {
                                if (n2 == 0) {
                                    cr.a(c2);
                                    this.b.a(x, cr, a2, av, true, n);
                                    this.c.a(cr, a2, true, n);
                                    this.A = a2.b();
                                    if (this.A != null) {
                                        cr.a(this.A, 0.0, 0.0, this.A.c(), -1.7976931348623157E308, false, Double.MAX_VALUE, false);
                                    }
                                    cr.j();
                                    this.b.b(x, cr, a2, av, true, 0.0);
                                    this.b.a(x, c, a2, av, 0.0, hashMap);
                                    this.c.b(cr, a2, true, 0.0);
                                    if (this.A != null) {
                                        this.A.g(cr.d(this.A));
                                        this.a(this.A, x);
                                        this.B = this.A;
                                    }
                                }
                                cr.a();
                                if (System.currentTimeMillis() - currentTimeMillis > this.t) {
                                    cr.a(100);
                                    cr.b(20);
                                    cr.c(500);
                                }
                                this.b.a(x, cr, a2, av, false, n);
                                this.c.a(cr, a2, false, n);
                                final double d2 = c.d();
                                cr.b(d2);
                                list.clear();
                                Label_8512: {
                                    Label_8370: {
                                        if (j < au.b() - 1) {
                                            final aQ a4 = au.a(j + 1);
                                            double n3 = 0.0;
                                            aQ a5 = null;
                                            Label_0937: {
                                                if (j < au.b() - 2) {
                                                    a5 = au.a(j + 2);
                                                    if (!x2) {
                                                        break Label_0937;
                                                    }
                                                }
                                                a5 = null;
                                            }
                                            boolean b2 = false;
                                            boolean b = false;
                                            Label_1060: {
                                                if (this.f || a) {
                                                    b = (b2 = false);
                                                    if (!x2) {
                                                        break Label_1060;
                                                    }
                                                }
                                                final byte e = a4.e();
                                                Label_1029: {
                                                    if (e == 2) {
                                                        b2 = true;
                                                        b = (a5 != null && a5.e() == 3);
                                                        if (!x2) {
                                                            break Label_1029;
                                                        }
                                                    }
                                                    if (e == 3) {
                                                        b2 = false;
                                                        b = true;
                                                        if (!x2) {
                                                            break Label_1029;
                                                        }
                                                    }
                                                    b2 = false;
                                                    b = false;
                                                }
                                                if (b2 && b) {
                                                    j += 2;
                                                    if (!x2) {
                                                        break Label_1060;
                                                    }
                                                }
                                                if (b2 || b) {
                                                    ++j;
                                                }
                                            }
                                            final aQ a6 = au.a(j + 1);
                                            this.A = null;
                                            if (this.a(a2, a6)) {
                                                this.A = a6.b();
                                                final double c3 = this.c(this.B, this.A, x);
                                                final cy a7 = cr.a(this.A, c3, this.B.d(), this.A.c(), -1.7976931348623157E308, false, Double.MAX_VALUE, true);
                                                a7.k = this.B.h() + this.B.b() + c3 * 0.5;
                                                a7.i = a7.k;
                                            }
                                            double min = Double.MAX_VALUE;
                                            final c c4 = new c(-1.7976931348623157E308, Double.MAX_VALUE, Double.MAX_VALUE);
                                            p p4 = a6.d().l();
                                            while (true) {
                                                while (p4 != null) {
                                                    final q q3 = (q)p4.c();
                                                    final am a8 = x.a(p4.c());
                                                    min = Math.min(min, a8.getY() + n);
                                                    this.a(x, av, c4, q3, a8, n, true);
                                                    p4 = p4.b();
                                                    if (!x2) {
                                                        if (x2) {
                                                            break;
                                                        }
                                                        continue Label_0606_Outer;
                                                    }
                                                    else {
                                                        double n4 = -c.c(c4) + this.b();
                                                        this.b.a(x, cr, a6, av, true, n);
                                                        this.c.a(cr, a6, true, n);
                                                        double n5 = 0.0;
                                                        Label_8308: {
                                                            Label_8304: {
                                                                while (true) {
                                                                    p p5 = null;
                                                                    Object a16 = null;
                                                                    Label_7528: {
                                                                        Label_2297: {
                                                                            if (!b2 && !b) {
                                                                                p5 = d.k();
                                                                                while (p5 != null) {
                                                                                    final q q4 = (q)p5.c();
                                                                                    final d d4;
                                                                                    final d d3 = d4 = q4.f();
                                                                                    if (x2) {
                                                                                        break Label_7528;
                                                                                    }
                                                                                    if (d3 != null) {
                                                                                        final byte b3 = av.a(q4).b();
                                                                                        if (b3 != 12 && b3 != 13) {
                                                                                            d d5 = q4.f();
                                                                                            while (d5 != null) {
                                                                                                final t p6 = x.p(d5);
                                                                                                final t q5 = x.q(d5);
                                                                                                n5 = dcmpl(p6.a, q5.a);
                                                                                                if (x2) {
                                                                                                    break Label_8308;
                                                                                                }
                                                                                                Label_1656: {
                                                                                                    if (n5 != 0) {
                                                                                                        if (this.d(av, d5)) {
                                                                                                            list.add(d5);
                                                                                                            if (!x2) {
                                                                                                                break Label_1656;
                                                                                                            }
                                                                                                        }
                                                                                                        final cy a9 = cr.a(d5, this.m, this.a(x, av, d5), p6.a, true, q5.a, false, this.b(av, d5), av.a(d5).k().i());
                                                                                                        if (a(av.a(d5.c()))) {
                                                                                                            a9.k = p6.b + this.a(av, d5, true);
                                                                                                            a9.i = p6.b;
                                                                                                        }
                                                                                                        if (a(av.a(d5.d()))) {
                                                                                                            a9.l = q5.b + n - this.a(av, d5, false);
                                                                                                            a9.j = q5.b + n;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                if (a(av.a(d5.c())) && a(av.a(d5.d()))) {
                                                                                                    n4 = this.a(x, av, d5, p6.a, p6.b, q5.a, q5.b + n, n, n4);
                                                                                                }
                                                                                                d5 = d5.g();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    p5 = p5.a();
                                                                                    if (x2) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                n3 += this.a(x, av, a2, max, a6, min, cr, list, n, n4);
                                                                                p5 = d.k();
                                                                                while (p5 != null) {
                                                                                    final q q6 = (q)p5.c();
                                                                                    final d d4;
                                                                                    final d d6 = d4 = q6.f();
                                                                                    if (x2) {
                                                                                        break Label_7528;
                                                                                    }
                                                                                    if (d6 != null) {
                                                                                        final byte b4 = av.a(q6).b();
                                                                                        if (b4 != 12 && b4 != 13) {
                                                                                            d d7 = q6.f();
                                                                                            while (d7 != null) {
                                                                                                final t p7 = x.p(d7);
                                                                                                final t q7 = x.q(d7);
                                                                                                final double n6 = dcmpl(p7.a, q7.a);
                                                                                                if (x2) {
                                                                                                    break Label_8308;
                                                                                                }
                                                                                                Label_2273: {
                                                                                                    if (n6 != 0 && !this.d(av, d7)) {
                                                                                                        final D a10 = this.a(d7);
                                                                                                        if (this.b(av, d7)) {
                                                                                                            final cy a11 = cr.a(d7);
                                                                                                            if (Double.isNaN(a11.d)) {
                                                                                                                break Label_2273;
                                                                                                            }
                                                                                                            if (a11.a() == 1) {
                                                                                                                a10.add(new Point2D.Double(p7.a, a11.d - (p7.a - a11.q)));
                                                                                                                if (a11.p != a11.q) {
                                                                                                                    a10.add(new Point2D.Double(a11.q, a11.d));
                                                                                                                    a10.add(new Point2D.Double(a11.p, a11.d));
                                                                                                                }
                                                                                                                a10.add(new Point2D.Double(q7.a, a11.d + (a11.p - q7.a)));
                                                                                                                if (!x2) {
                                                                                                                    break Label_2273;
                                                                                                                }
                                                                                                            }
                                                                                                            a10.add(new Point2D.Double(p7.a, a11.d - (a11.p - p7.a)));
                                                                                                            if (a11.p != a11.q) {
                                                                                                                a10.add(new Point2D.Double(a11.p, a11.d));
                                                                                                                a10.add(new Point2D.Double(a11.q, a11.d));
                                                                                                            }
                                                                                                            a10.add(new Point2D.Double(q7.a, a11.d + (q7.a - a11.q)));
                                                                                                            if (!x2) {
                                                                                                                break Label_2273;
                                                                                                            }
                                                                                                        }
                                                                                                        final double d8 = cr.d(d7);
                                                                                                        if (!Double.isNaN(d8)) {
                                                                                                            a10.add(new Point2D.Double(p7.a, d8));
                                                                                                            a10.add(new Point2D.Double(q7.a, d8));
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                d7 = d7.g();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    p5 = p5.a();
                                                                                    if (x2) {
                                                                                        break Label_2297;
                                                                                    }
                                                                                }
                                                                                break Label_8304;
                                                                            }
                                                                        }
                                                                        Label_5090: {
                                                                            if (b2 && b) {
                                                                                p5 = a4.d().k();
                                                                                while (p5 != null) {
                                                                                    final q q8 = (q)p5.c();
                                                                                    final boolean b6;
                                                                                    final boolean b5 = b6 = this.c.e(q8);
                                                                                    if (x2) {
                                                                                        break Label_8308;
                                                                                    }
                                                                                    Label_3185: {
                                                                                        if (!b5) {
                                                                                            final Object a12 = a(q8, av);
                                                                                            if (a12 == null) {
                                                                                                final q d9 = q8.f().d();
                                                                                                if (a(d9, av) != null) {
                                                                                                    break Label_3185;
                                                                                                }
                                                                                                final d g = q8.g();
                                                                                                final t p8 = x.p(g);
                                                                                                final t q9 = x.q(d9.f());
                                                                                                Label_2618: {
                                                                                                    if (p8.a != q9.a) {
                                                                                                        if (this.d(av, g)) {
                                                                                                            list.add(g);
                                                                                                            if (!x2) {
                                                                                                                break Label_2618;
                                                                                                            }
                                                                                                        }
                                                                                                        final cy a13 = cr.a(g, this.m, this.a(x, av, g), p8.a, true, q9.a, false, this.b(av, g), this.a(av, g));
                                                                                                        if (a(av.a(g.c()))) {
                                                                                                            a13.k = p8.b + this.a(av, g, true);
                                                                                                            a13.i = p8.b;
                                                                                                        }
                                                                                                        if (a(av.a(d9.f().d()))) {
                                                                                                            a13.l = q9.b + n - this.a(av, d9.f(), false);
                                                                                                            a13.j = q9.b + n;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                if (!a(av.a(g.c())) || !a(av.a(d9.f().d()))) {
                                                                                                    break Label_3185;
                                                                                                }
                                                                                                n4 = this.a(x, av, g, p8.a, p8.b, q9.a, q9.b + n, n, n4);
                                                                                                if (!x2) {
                                                                                                    break Label_3185;
                                                                                                }
                                                                                            }
                                                                                            double max2 = -1.7976931348623157E308;
                                                                                            double max3 = -1.7976931348623157E308;
                                                                                            final double k = x.j(q8);
                                                                                            d d10 = q8.g();
                                                                                            while (d10 != null) {
                                                                                                final t p9 = x.p(d10);
                                                                                                final boolean c5 = this.c(av, d10);
                                                                                                final double a14 = this.a(av, d10);
                                                                                                final double n7 = dcmpl(p9.a, k);
                                                                                                if (x2) {
                                                                                                    break Label_8308;
                                                                                                }
                                                                                                Label_2893: {
                                                                                                    if (n7 != 0) {
                                                                                                        final cy a15 = cr.a(d10, a12, this.m, this.a(x, av, d10), p9.a, true, k, true, c5, a14);
                                                                                                        if (!a(av.a(d10.c()))) {
                                                                                                            break Label_2893;
                                                                                                        }
                                                                                                        a15.k = p9.b + this.a(av, d10, true);
                                                                                                        a15.i = p9.b;
                                                                                                        if (!x2) {
                                                                                                            break Label_2893;
                                                                                                        }
                                                                                                    }
                                                                                                    max2 = Math.max(max2, p9.b + this.a(av, d10, true));
                                                                                                    max3 = Math.max(max2, p9.b);
                                                                                                }
                                                                                                d10 = d10.h();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            final Object o = new Object();
                                                                                            d d11 = q8.f();
                                                                                            while (d11 != null) {
                                                                                                final q d12 = d11.d();
                                                                                                final Object o2 = a16 = a(d12, av);
                                                                                                if (x2) {
                                                                                                    break Label_7528;
                                                                                                }
                                                                                                Label_3173: {
                                                                                                    if (a16 == null) {
                                                                                                        final d f = d12.f();
                                                                                                        final t q10 = x.q(f);
                                                                                                        if (q10.a == k) {
                                                                                                            break Label_3173;
                                                                                                        }
                                                                                                        final cy a17 = cr.a(d11, o, this.m, this.a(x, av, d11), k, true, q10.a, false, this.c(av, d11), this.a(av, d11));
                                                                                                        if (a(av.a(f.d()))) {
                                                                                                            a17.l = q10.b + n - this.a(av, f, false);
                                                                                                            a17.j = q10.b + n;
                                                                                                        }
                                                                                                        a17.k = max2;
                                                                                                        a17.i = max3;
                                                                                                        if (!x2) {
                                                                                                            break Label_3173;
                                                                                                        }
                                                                                                    }
                                                                                                    if (!o2.equals(a12)) {
                                                                                                        final double l = x.j(d12);
                                                                                                        if (k != l) {
                                                                                                            cr.a(d11, k, true, l, false, this.c(av, d11), this.a(av, d11));
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                d11 = d11.g();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    p5 = p5.a();
                                                                                    if (x2) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                p5 = a5.d().k();
                                                                                while (p5 != null) {
                                                                                    final q q11 = (q)p5.c();
                                                                                    final boolean b6;
                                                                                    final boolean b7 = b6 = this.c.e(q11);
                                                                                    if (x2) {
                                                                                        break Label_8308;
                                                                                    }
                                                                                    if (!b7) {
                                                                                        final Object a18 = a(q11, av);
                                                                                        if (a18 != null) {
                                                                                            double min2 = Double.MAX_VALUE;
                                                                                            double min3 = Double.MAX_VALUE;
                                                                                            final double m = x.j(q11);
                                                                                            d d13 = q11.f();
                                                                                            while (d13 != null) {
                                                                                                final t q12 = x.q(d13);
                                                                                                final double n8 = dcmpl(m, q12.a);
                                                                                                if (x2) {
                                                                                                    break Label_8308;
                                                                                                }
                                                                                                Label_3465: {
                                                                                                    if (n8 != 0) {
                                                                                                        final cy a19 = cr.a(d13, a18, this.m, this.a(x, av, d13), m, false, q12.a, false, this.c(av, d13), this.a(av, d13));
                                                                                                        if (!a(av.a(d13.d()))) {
                                                                                                            break Label_3465;
                                                                                                        }
                                                                                                        a19.l = q12.b + n - this.a(av, d13, false);
                                                                                                        a19.j = q12.b + n;
                                                                                                        if (!x2) {
                                                                                                            break Label_3465;
                                                                                                        }
                                                                                                    }
                                                                                                    min2 = Math.min(min2, q12.b + n - this.a(av, d13, false));
                                                                                                    min3 = Math.min(min2, q12.b + n);
                                                                                                }
                                                                                                d13 = d13.g();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            final Object o3 = new Object();
                                                                                            d d14 = q11.g();
                                                                                            while (d14 != null) {
                                                                                                final q c6 = d14.c();
                                                                                                final Object a20 = a(c6, av);
                                                                                                if (x2) {
                                                                                                    break Label_7528;
                                                                                                }
                                                                                                if (a20 == null) {
                                                                                                    final d g2 = c6.g();
                                                                                                    final t p10 = x.p(g2);
                                                                                                    if (p10.a != m) {
                                                                                                        final cy a21 = cr.a(g2, o3, this.m, this.a(x, av, g2), p10.a, true, m, false, this.c(av, g2), this.a(av, g2));
                                                                                                        if (a(av.a(g2.c()))) {
                                                                                                            a21.k = p10.b + this.a(av, g2, true);
                                                                                                            a21.i = p10.b;
                                                                                                        }
                                                                                                        a21.l = min2;
                                                                                                        a21.j = min3;
                                                                                                    }
                                                                                                }
                                                                                                d14 = d14.h();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    p5 = p5.a();
                                                                                    if (x2) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                n3 += this.a(x, av, a2, max, a6, min, cr, list, n, n4);
                                                                                p5 = a4.d().k();
                                                                                while (p5 != null) {
                                                                                    final q q13 = (q)p5.c();
                                                                                    final boolean b6;
                                                                                    final boolean b8 = b6 = this.c.e(q13);
                                                                                    if (x2) {
                                                                                        break Label_8308;
                                                                                    }
                                                                                    Label_4706: {
                                                                                        if (!b8) {
                                                                                            final double j2 = x.j(q13);
                                                                                            final Object a22 = a(q13, av);
                                                                                            if (a22 == null) {
                                                                                                final d f2 = q13.f();
                                                                                                final q d15 = f2.d();
                                                                                                if (a(d15, av) == null) {
                                                                                                    final d g3 = q13.g();
                                                                                                    final d f3 = d15.f();
                                                                                                    if (this.d(av, g3)) {
                                                                                                        break Label_4706;
                                                                                                    }
                                                                                                    final t p11 = x.p(g3);
                                                                                                    final t q14 = x.q(f3);
                                                                                                    x.a(q13, p11.a, d2);
                                                                                                    x.a(d15, q14.a, d2);
                                                                                                    Label_4244: {
                                                                                                        if (p11.a != q14.a) {
                                                                                                            final cy a23 = cr.a(g3);
                                                                                                            final double d16 = a23.d;
                                                                                                            if (!Double.isNaN(d16)) {
                                                                                                                if (a23.n) {
                                                                                                                    final D a24 = this.a(g3);
                                                                                                                    double n9 = 0.0;
                                                                                                                    Label_4159: {
                                                                                                                        if (p11.a < q14.a) {
                                                                                                                            a24.add(new Point2D.Double(p11.a, d16 - (a23.p - a23.b)));
                                                                                                                            if (a23.p != a23.q) {
                                                                                                                                a24.add(new Point2D.Double(a23.p, d16));
                                                                                                                                a24.add(new Point2D.Double(a23.q, d16));
                                                                                                                            }
                                                                                                                            n9 = d16 + (a23.c - a23.q);
                                                                                                                            if (!x2) {
                                                                                                                                break Label_4159;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        a24.add(new Point2D.Double(p11.a, d16 - (a23.c - a23.q)));
                                                                                                                        if (a23.p != a23.q) {
                                                                                                                            a24.add(new Point2D.Double(a23.q, d16));
                                                                                                                            a24.add(new Point2D.Double(a23.p, d16));
                                                                                                                        }
                                                                                                                        n9 = d16 + (a23.p - a23.b);
                                                                                                                    }
                                                                                                                    x.d(g3, new t(q14.a, n9));
                                                                                                                    x.c(f3, new t(q14.a, n9));
                                                                                                                    if (!x2) {
                                                                                                                        break Label_4244;
                                                                                                                    }
                                                                                                                }
                                                                                                                x.d(g3, new t(p11.a, d16));
                                                                                                                x.c(f3, new t(q14.a, d16));
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    x.c(f2, x.q(g3));
                                                                                                    x.d(f2, x.p(d15.f()));
                                                                                                    if (!x2) {
                                                                                                        break Label_4706;
                                                                                                    }
                                                                                                }
                                                                                                x.a(q13, j2, d2);
                                                                                                if (!x2) {
                                                                                                    break Label_4706;
                                                                                                }
                                                                                            }
                                                                                            x.a(q13, j2, d2);
                                                                                            if (cr.c(a22)) {
                                                                                                final double e2 = cr.e(a22);
                                                                                                x.a(q13, j2, e2);
                                                                                                d d17 = q13.g();
                                                                                                while (d17 != null) {
                                                                                                    final t p12 = x.p(d17);
                                                                                                    final double n10 = dcmpl(p12.a, j2);
                                                                                                    if (x2) {
                                                                                                        break Label_8308;
                                                                                                    }
                                                                                                    Label_4453: {
                                                                                                        if (n10 != 0) {
                                                                                                            final double d18 = cr.d(d17);
                                                                                                            if (!Double.isNaN(d18)) {
                                                                                                                x.d(d17, new t(p12.a, d18));
                                                                                                                if (!x2) {
                                                                                                                    break Label_4453;
                                                                                                                }
                                                                                                            }
                                                                                                            x.d(d17, new t(p12.a, e2));
                                                                                                            if (!x2) {
                                                                                                                break Label_4453;
                                                                                                            }
                                                                                                        }
                                                                                                        x.d(d17, new t(p12.a, e2));
                                                                                                    }
                                                                                                    d17 = d17.h();
                                                                                                    if (x2) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            d d19 = q13.f();
                                                                                            while (d19 != null) {
                                                                                                final q d20 = d19.d();
                                                                                                final Object a25 = a(d20, av);
                                                                                                if (x2) {
                                                                                                    break Label_7528;
                                                                                                }
                                                                                                Label_4694: {
                                                                                                    if (a25 == null) {
                                                                                                        final t q15 = x.q(d20.f());
                                                                                                        x.a(d20, j2, d2);
                                                                                                        if (q15.a == j2) {
                                                                                                            break Label_4694;
                                                                                                        }
                                                                                                        final double d21 = cr.d(d19);
                                                                                                        if (Double.isNaN(d21)) {
                                                                                                            break Label_4694;
                                                                                                        }
                                                                                                        x.d(d19, new t(j2, d21));
                                                                                                        x.c(d20.f(), new t(q15.a, d21));
                                                                                                        if (!x2) {
                                                                                                            break Label_4694;
                                                                                                        }
                                                                                                    }
                                                                                                    final double j3 = x.j(d20);
                                                                                                    x.a(d20, j3, d2);
                                                                                                    if (!a25.equals(a22)) {
                                                                                                        if (j2 != j3) {
                                                                                                            final double d22 = cr.d(d19);
                                                                                                            if (!Double.isNaN(d22)) {
                                                                                                                final D a26 = this.a(d19);
                                                                                                                a26.add(new Point2D.Double(j2, d22));
                                                                                                                a26.add(new Point2D.Double(j3, d22));
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                d19 = d19.g();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    p5 = p5.a();
                                                                                    if (x2) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                p5 = a5.d().k();
                                                                                while (p5 != null) {
                                                                                    final q q16 = (q)p5.c();
                                                                                    final boolean b6;
                                                                                    final boolean b9 = b6 = this.c.e(q16);
                                                                                    if (x2) {
                                                                                        break Label_8308;
                                                                                    }
                                                                                    if (!b9) {
                                                                                        final Object a27 = a(q16, av);
                                                                                        if (a27 != null) {
                                                                                            final double j4 = x.j(q16);
                                                                                            Label_4927: {
                                                                                                Label_4917: {
                                                                                                    if (cr.c(a27)) {
                                                                                                        final double e3 = cr.e(a27);
                                                                                                        x.a(q16, j4, e3);
                                                                                                        d d23 = q16.f();
                                                                                                        while (d23 != null) {
                                                                                                            final t q17 = x.q(d23);
                                                                                                            final double n11 = dcmpl(q17.a, j4);
                                                                                                            if (x2) {
                                                                                                                break Label_8308;
                                                                                                            }
                                                                                                            Label_4905: {
                                                                                                                if (n11 != 0) {
                                                                                                                    x.c(d23, new t(q17.a, cr.d(d23)));
                                                                                                                    if (!x2) {
                                                                                                                        break Label_4905;
                                                                                                                    }
                                                                                                                }
                                                                                                                x.c(d23, new t(q17.a, e3));
                                                                                                            }
                                                                                                            d23 = d23.g();
                                                                                                            if (x2) {
                                                                                                                break Label_4917;
                                                                                                            }
                                                                                                        }
                                                                                                        break Label_4927;
                                                                                                    }
                                                                                                }
                                                                                                x.a(q16, j4, d2);
                                                                                            }
                                                                                            d d24 = q16.g();
                                                                                            while (d24 != null) {
                                                                                                final q c7 = d24.c();
                                                                                                final Object a28 = a(c7, av);
                                                                                                if (x2) {
                                                                                                    break Label_7528;
                                                                                                }
                                                                                                Label_5066: {
                                                                                                    if (a28 == null) {
                                                                                                        final d g4 = c7.g();
                                                                                                        final t p13 = x.p(g4);
                                                                                                        if (p13.a != j4) {
                                                                                                            final double d25 = cr.d(g4);
                                                                                                            if (Double.isNaN(d25)) {
                                                                                                                break Label_5066;
                                                                                                            }
                                                                                                            x.d(g4, new t(p13.a, d25));
                                                                                                            x.c(d24, new t(j4, d25));
                                                                                                            if (!x2) {
                                                                                                                break Label_5066;
                                                                                                            }
                                                                                                        }
                                                                                                        x.a(c7, new t(j4, d2));
                                                                                                    }
                                                                                                }
                                                                                                d24 = d24.h();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    p5 = p5.a();
                                                                                    if (x2) {
                                                                                        break Label_5090;
                                                                                    }
                                                                                }
                                                                                break Label_8304;
                                                                            }
                                                                        }
                                                                        Label_6707: {
                                                                            if (b2) {
                                                                                p p14 = a4.d().k();
                                                                                while (p14 != null) {
                                                                                    final q q18 = (q)p14.c();
                                                                                    final boolean b6;
                                                                                    final boolean b10 = b6 = this.c.e(q18);
                                                                                    if (x2) {
                                                                                        break Label_8308;
                                                                                    }
                                                                                    Label_5870: {
                                                                                        if (!b10) {
                                                                                            final Object a29 = a(q18, av);
                                                                                            if (a29 == null) {
                                                                                                final d g5 = q18.g();
                                                                                                final t p15 = x.p(g5);
                                                                                                final d f4 = q18.f();
                                                                                                final t q19 = x.q(f4);
                                                                                                Label_5381: {
                                                                                                    if (p15.a != q19.a) {
                                                                                                        if (this.d(av, g5)) {
                                                                                                            list.add(g5);
                                                                                                            if (!x2) {
                                                                                                                break Label_5381;
                                                                                                            }
                                                                                                        }
                                                                                                        final cy a30 = cr.a(g5, this.m, this.a(x, av, g5), p15.a, true, q19.a, false, this.b(av, g5), this.a(av, g5));
                                                                                                        if (a(av.a(g5.c()))) {
                                                                                                            a30.k = p15.b + this.a(av, g5, true);
                                                                                                            a30.i = p15.b;
                                                                                                        }
                                                                                                        if (a(av.a(f4.d()))) {
                                                                                                            a30.l = q19.b + n - this.a(av, f4, false);
                                                                                                            a30.j = q19.b + n;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                if (!a(av.a(g5.c())) || !a(av.a(f4.d()))) {
                                                                                                    break Label_5870;
                                                                                                }
                                                                                                n4 = this.a(x, av, g5, p15.a, p15.b, q19.a, q19.b + n, n, n4);
                                                                                                if (!x2) {
                                                                                                    break Label_5870;
                                                                                                }
                                                                                            }
                                                                                            double max4 = -1.7976931348623157E308;
                                                                                            double max5 = -1.7976931348623157E308;
                                                                                            final double j5 = x.j(q18);
                                                                                            d d26 = q18.g();
                                                                                            while (d26 != null) {
                                                                                                final t p16 = x.p(d26);
                                                                                                final boolean c8 = this.c(av, d26);
                                                                                                final double a31 = this.a(av, d26);
                                                                                                final double n12 = dcmpl(p16.a, j5);
                                                                                                if (x2) {
                                                                                                    break Label_8308;
                                                                                                }
                                                                                                Label_5670: {
                                                                                                    if (n12 != 0) {
                                                                                                        final cy a32 = cr.a(d26, a29, this.m, this.a(x, av, d26), p16.a, true, j5, false, c8, a31);
                                                                                                        if (!a(av.a(d26.c()))) {
                                                                                                            break Label_5670;
                                                                                                        }
                                                                                                        a32.k = p16.b + this.a(av, d26, true);
                                                                                                        a32.i = p16.b;
                                                                                                        if (!x2) {
                                                                                                            break Label_5670;
                                                                                                        }
                                                                                                    }
                                                                                                    if (a(av.a(d26.c()))) {
                                                                                                        max4 = Math.max(max4, p16.b + this.a(av, d26, true));
                                                                                                        max5 = Math.max(max4, p16.b);
                                                                                                    }
                                                                                                }
                                                                                                d26 = d26.h();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            final Object o4 = new Object();
                                                                                            d d27 = q18.f();
                                                                                            while (d27 != null) {
                                                                                                final q d28 = d27.d();
                                                                                                final t q20 = x.q(d27);
                                                                                                final double n13 = dcmpl(q20.a, j5);
                                                                                                if (x2) {
                                                                                                    break Label_8308;
                                                                                                }
                                                                                                if (n13 != 0) {
                                                                                                    final cy a33 = cr.a(d27, o4, this.m, this.a(x, av, d27), j5, false, q20.a, false, this.c(av, d27), this.a(av, d27));
                                                                                                    if (a(av.a(d28))) {
                                                                                                        a33.l = q20.b + n - this.a(av, d27, false);
                                                                                                        a33.j = q20.b + n;
                                                                                                    }
                                                                                                    a33.k = max4;
                                                                                                    a33.i = max5;
                                                                                                }
                                                                                                d27 = d27.g();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    p14 = p14.a();
                                                                                    if (x2) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                n3 += this.a(x, av, a2, max, a6, min, cr, list, n, n4);
                                                                                p p17 = a4.d().k();
                                                                                while (p17 != null) {
                                                                                    final q q21 = (q)p17.c();
                                                                                    final boolean b6;
                                                                                    final boolean b11 = b6 = this.c.e(q21);
                                                                                    if (x2) {
                                                                                        break Label_8308;
                                                                                    }
                                                                                    Label_6695: {
                                                                                        if (!b11) {
                                                                                            final Object a34 = a(q21, av);
                                                                                            if (a34 == null) {
                                                                                                final d g6 = q21.g();
                                                                                                final t p18 = x.p(g6);
                                                                                                final d f5 = q21.f();
                                                                                                final t q22 = x.q(f5);
                                                                                                if (this.d(av, g6) && p18.a != q22.a) {
                                                                                                    break Label_6695;
                                                                                                }
                                                                                                x.a(q21, p18.a, d2);
                                                                                                if (p18.a == q22.a) {
                                                                                                    break Label_6695;
                                                                                                }
                                                                                                final cy a35 = cr.a(g6);
                                                                                                final double d29 = a35.d;
                                                                                                if (Double.isNaN(d29)) {
                                                                                                    break Label_6695;
                                                                                                }
                                                                                                if (a35.n) {
                                                                                                    final D a36 = this.a(g6);
                                                                                                    double n14 = 0.0;
                                                                                                    Label_6313: {
                                                                                                        if (p18.a < q22.a) {
                                                                                                            a36.add(new Point2D.Double(p18.a, d29 - (a35.p - a35.b)));
                                                                                                            if (a35.p != a35.q) {
                                                                                                                a36.add(new Point2D.Double(a35.p, d29));
                                                                                                                a36.add(new Point2D.Double(a35.q, d29));
                                                                                                            }
                                                                                                            n14 = d29 + (a35.c - a35.q);
                                                                                                            if (!x2) {
                                                                                                                break Label_6313;
                                                                                                            }
                                                                                                        }
                                                                                                        a36.add(new Point2D.Double(p18.a, d29 - (a35.c - a35.q)));
                                                                                                        if (a35.p != a35.q) {
                                                                                                            a36.add(new Point2D.Double(a35.q, d29));
                                                                                                            a36.add(new Point2D.Double(a35.p, d29));
                                                                                                        }
                                                                                                        n14 = d29 + (a35.p - a35.b);
                                                                                                    }
                                                                                                    x.d(g6, new t(q22.a, n14));
                                                                                                    x.c(f5, new t(q22.a, n14));
                                                                                                    if (!x2) {
                                                                                                        break Label_6695;
                                                                                                    }
                                                                                                }
                                                                                                x.d(g6, new t(p18.a, d29));
                                                                                                x.c(f5, new t(q22.a, d29));
                                                                                                if (!x2) {
                                                                                                    break Label_6695;
                                                                                                }
                                                                                            }
                                                                                            final double j6 = x.j(q21);
                                                                                            Label_6585: {
                                                                                                Label_6575: {
                                                                                                    if (cr.c(a34)) {
                                                                                                        final double e4 = cr.e(a34);
                                                                                                        x.a(q21, j6, e4);
                                                                                                        d d30 = q21.g();
                                                                                                        while (d30 != null) {
                                                                                                            final t p19 = x.p(d30);
                                                                                                            final double n15 = dcmpl(p19.a, j6);
                                                                                                            if (x2) {
                                                                                                                break Label_8308;
                                                                                                            }
                                                                                                            Label_6563: {
                                                                                                                if (n15 != 0) {
                                                                                                                    final double d31 = cr.d(d30);
                                                                                                                    if (!Double.isNaN(d31)) {
                                                                                                                        x.d(d30, new t(p19.a, d31));
                                                                                                                        if (!x2) {
                                                                                                                            break Label_6563;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    x.d(d30, new t(p19.a, e4));
                                                                                                                    if (!x2) {
                                                                                                                        break Label_6563;
                                                                                                                    }
                                                                                                                }
                                                                                                                x.d(d30, new t(p19.a, e4));
                                                                                                            }
                                                                                                            d30 = d30.h();
                                                                                                            if (x2) {
                                                                                                                break Label_6575;
                                                                                                            }
                                                                                                        }
                                                                                                        break Label_6585;
                                                                                                    }
                                                                                                }
                                                                                                x.a(q21, j6, d2);
                                                                                            }
                                                                                            d d32 = q21.f();
                                                                                            while (d32 != null) {
                                                                                                final t q23 = x.q(d32);
                                                                                                final double n16 = dcmpl(q23.a, j6);
                                                                                                if (x2) {
                                                                                                    break Label_8308;
                                                                                                }
                                                                                                if (n16 != 0) {
                                                                                                    final double d33 = cr.d(d32);
                                                                                                    if (!Double.isNaN(d33)) {
                                                                                                        final D a37 = this.a(d32);
                                                                                                        a37.add(new Point2D.Double(j6, d33));
                                                                                                        a37.add(new Point2D.Double(q23.a, d33));
                                                                                                    }
                                                                                                }
                                                                                                d32 = d32.g();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    p17 = p17.a();
                                                                                    if (x2) {
                                                                                        break Label_6707;
                                                                                    }
                                                                                }
                                                                                break Label_8304;
                                                                            }
                                                                        }
                                                                        p p20 = a4.d().k();
                                                                        while (p20 != null) {
                                                                            final q q24 = (q)p20.c();
                                                                            final boolean b6;
                                                                            final boolean b12 = b6 = this.c.e(q24);
                                                                            if (x2) {
                                                                                break Label_8308;
                                                                            }
                                                                            Label_7467: {
                                                                                if (!b12) {
                                                                                    final Object a38 = a(q24, av);
                                                                                    if (a38 == null) {
                                                                                        final d g7 = q24.g();
                                                                                        final t p21 = x.p(g7);
                                                                                        final d f6 = q24.f();
                                                                                        final t q25 = x.q(f6);
                                                                                        Label_6993: {
                                                                                            if (p21.a != q25.a) {
                                                                                                if (this.d(av, g7)) {
                                                                                                    list.add(g7);
                                                                                                    if (!x2) {
                                                                                                        break Label_6993;
                                                                                                    }
                                                                                                }
                                                                                                final cy a39 = cr.a(f6, this.m, this.a(x, av, g7), p21.a, true, q25.a, false, this.b(av, g7), this.a(av, g7));
                                                                                                if (a(av.a(g7.c()))) {
                                                                                                    a39.k = p21.b + this.a(av, g7, true);
                                                                                                    a39.i = p21.b;
                                                                                                }
                                                                                                if (a(av.a(f6.d()))) {
                                                                                                    a39.l = q25.b + n - this.a(av, f6, false);
                                                                                                    a39.j = q25.b + n;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (!a(av.a(g7.c())) || !a(av.a(f6.d()))) {
                                                                                            break Label_7467;
                                                                                        }
                                                                                        n4 = this.a(x, av, g7, p21.a, p21.b, q25.a, q25.b + n, n, n4);
                                                                                        if (!x2) {
                                                                                            break Label_7467;
                                                                                        }
                                                                                    }
                                                                                    double min4 = Double.MAX_VALUE;
                                                                                    double min5 = Double.MAX_VALUE;
                                                                                    final double j7 = x.j(q24);
                                                                                    d d34 = q24.f();
                                                                                    while (d34 != null) {
                                                                                        final t q26 = x.q(d34);
                                                                                        final boolean c9 = this.c(av, d34);
                                                                                        final double a40 = this.a(av, d34);
                                                                                        final double n17 = dcmpl(j7, q26.a);
                                                                                        if (x2) {
                                                                                            break Label_8308;
                                                                                        }
                                                                                        Label_7277: {
                                                                                            if (n17 != 0) {
                                                                                                final cy a41 = cr.a(d34, a38, this.m, this.a(x, av, d34), j7, false, q26.a, false, c9, a40);
                                                                                                if (!a(av.a(d34.d()))) {
                                                                                                    break Label_7277;
                                                                                                }
                                                                                                a41.l = q26.b + n - this.a(av, d34, false);
                                                                                                a41.j = q26.b + n;
                                                                                                if (!x2) {
                                                                                                    break Label_7277;
                                                                                                }
                                                                                            }
                                                                                            min4 = Math.min(min4, q26.b + n - this.a(av, d34, false));
                                                                                            min5 = Math.min(min5, q26.b + n);
                                                                                        }
                                                                                        d34 = d34.g();
                                                                                        if (x2) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    final Object o5 = new Object();
                                                                                    d d35 = q24.g();
                                                                                    while (d35 != null) {
                                                                                        final t p22 = x.p(d35);
                                                                                        final double n18 = dcmpl(p22.a, j7);
                                                                                        if (x2) {
                                                                                            break Label_8308;
                                                                                        }
                                                                                        if (n18 != 0) {
                                                                                            final cy a42 = cr.a(d35, o5, this.m, this.a(x, av, d35), p22.a, true, j7, false, this.c(av, d35), this.a(av, d35));
                                                                                            if (a(av.a(d35.c()))) {
                                                                                                a42.k = p22.b + this.a(av, d35, true);
                                                                                                a42.i = p22.b;
                                                                                            }
                                                                                            a42.l = min4;
                                                                                            a42.j = min5;
                                                                                        }
                                                                                        d35 = d35.h();
                                                                                        if (x2) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            p20 = p20.a();
                                                                            if (x2) {
                                                                                break;
                                                                            }
                                                                        }
                                                                        n3 += this.a(x, av, a2, max, a6, min, cr, list, n, n4);
                                                                        p5 = a4.d().k();
                                                                        if (p5 == null) {
                                                                            break Label_8304;
                                                                        }
                                                                        p5.c();
                                                                    }
                                                                    final q q27 = (q)a16;
                                                                    boolean b6;
                                                                    final boolean b13 = b6 = this.c.e(q27);
                                                                    if (x2) {
                                                                        break Label_8308;
                                                                    }
                                                                    Label_8292: {
                                                                        if (!b13) {
                                                                            final Object a43 = a(q27, av);
                                                                            if (a43 == null) {
                                                                                final d f7 = q27.f();
                                                                                final t q28 = x.q(f7);
                                                                                final d g8 = q27.g();
                                                                                final t p23 = x.p(g8);
                                                                                if (this.d(av, f7) && p23.a != q28.a) {
                                                                                    break Label_8292;
                                                                                }
                                                                                x.a(q27, p23.a, d2);
                                                                                if (p23.a == q28.a) {
                                                                                    break Label_8292;
                                                                                }
                                                                                final cy a44 = cr.a(f7);
                                                                                final double d36 = a44.d;
                                                                                if (Double.isNaN(d36)) {
                                                                                    break Label_8292;
                                                                                }
                                                                                if (a44.n) {
                                                                                    final D a45 = this.a(g8);
                                                                                    double n19 = 0.0;
                                                                                    Label_7910: {
                                                                                        if (p23.a < q28.a) {
                                                                                            a45.add(new Point2D.Double(p23.a, d36 - (a44.p - a44.b)));
                                                                                            if (a44.p != a44.q) {
                                                                                                a45.add(new Point2D.Double(a44.p, d36));
                                                                                                a45.add(new Point2D.Double(a44.q, d36));
                                                                                            }
                                                                                            n19 = d36 + (a44.c - a44.q);
                                                                                            if (!x2) {
                                                                                                break Label_7910;
                                                                                            }
                                                                                        }
                                                                                        a45.add(new Point2D.Double(p23.a, d36 - (a44.c - a44.q)));
                                                                                        if (a44.p != a44.q) {
                                                                                            a45.add(new Point2D.Double(a44.q, d36));
                                                                                            a45.add(new Point2D.Double(a44.p, d36));
                                                                                        }
                                                                                        n19 = d36 + (a44.p - a44.b);
                                                                                    }
                                                                                    x.d(g8, new t(q28.a, n19));
                                                                                    x.c(f7, new t(q28.a, n19));
                                                                                    if (!x2) {
                                                                                        break Label_8292;
                                                                                    }
                                                                                }
                                                                                x.d(g8, new t(p23.a, d36));
                                                                                x.c(f7, new t(q28.a, d36));
                                                                                if (!x2) {
                                                                                    break Label_8292;
                                                                                }
                                                                            }
                                                                            final double j8 = x.j(q27);
                                                                            Label_8182: {
                                                                                Label_8172: {
                                                                                    if (cr.c(a43)) {
                                                                                        final double e5 = cr.e(a43);
                                                                                        x.a(q27, j8, e5);
                                                                                        d d37 = q27.f();
                                                                                        while (d37 != null) {
                                                                                            final t q29 = x.q(d37);
                                                                                            final double n20 = dcmpl(q29.a, j8);
                                                                                            if (x2) {
                                                                                                break Label_8308;
                                                                                            }
                                                                                            Label_8160: {
                                                                                                if (n20 != 0) {
                                                                                                    final double d38 = cr.d(d37);
                                                                                                    if (!Double.isNaN(d38)) {
                                                                                                        x.c(d37, new t(q29.a, d38));
                                                                                                        if (!x2) {
                                                                                                            break Label_8160;
                                                                                                        }
                                                                                                    }
                                                                                                    x.c(d37, new t(q29.a, e5));
                                                                                                    if (!x2) {
                                                                                                        break Label_8160;
                                                                                                    }
                                                                                                }
                                                                                                x.c(d37, new t(q29.a, e5));
                                                                                            }
                                                                                            d37 = d37.g();
                                                                                            if (x2) {
                                                                                                break Label_8172;
                                                                                            }
                                                                                        }
                                                                                        break Label_8182;
                                                                                    }
                                                                                }
                                                                                x.a(q27, j8, d2);
                                                                            }
                                                                            d d39 = q27.g();
                                                                            while (d39 != null) {
                                                                                final t p24 = x.p(d39);
                                                                                final double n21 = dcmpl(p24.a, j8);
                                                                                if (x2) {
                                                                                    break Label_8308;
                                                                                }
                                                                                if (n21 != 0) {
                                                                                    final double d40 = cr.d(d39);
                                                                                    if (!Double.isNaN(d40)) {
                                                                                        final D a46 = this.a(d39);
                                                                                        a46.add(new Point2D.Double(p24.a, d40));
                                                                                        a46.add(new Point2D.Double(j8, d40));
                                                                                    }
                                                                                }
                                                                                d39 = d39.h();
                                                                                if (x2) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    p5 = p5.a();
                                                                    if (!x2) {
                                                                        continue;
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                            boolean b6 = this.r;
                                                        }
                                                        if (n5 == 0) {
                                                            n += n3;
                                                        }
                                                        this.b.b(x, cr, a6, av, true, n);
                                                        this.b.a(x, c, a6, av, n, hashMap);
                                                        this.c.b(cr, a6, true, n);
                                                        if (x2) {
                                                            break Label_8370;
                                                        }
                                                        break Label_8512;
                                                    }
                                                }
                                                cr.a(c4);
                                                continue;
                                            }
                                        }
                                    }
                                    this.A = a2.b();
                                    if (this.A != null) {
                                        final cy a47 = cr.a(this.A, 0.0, this.A.d(), 0.0, -1.7976931348623157E308, true, Double.MAX_VALUE, true);
                                        a47.k = this.A.h() + this.A.b();
                                        a47.i = a47.k;
                                    }
                                    cr.j();
                                    this.b.a(x, c, a2, av, n, hashMap);
                                    if (this.A != null) {
                                        this.A.d(cr.d(this.A) - this.A.h());
                                        this.b(this.A, x);
                                    }
                                }
                                this.b.b(x, cr, a2, av, false, 0.0);
                                this.b.a(x, c, a2, av, 0.0, hashMap);
                                this.c.b(cr, a2, false, 0.0);
                                ++j;
                                if (x2) {
                                    break Label_0606_Outer;
                                }
                                continue Label_0606_Outer;
                            }
                        }
                        cr.b(c);
                        continue;
                    }
                }
                return;
            }
            cr.c(0.0);
            continue Label_0389;
        }
    }
    
    private double a(final aV av, final d d) {
        return this.d ? 0.0 : av.a(d).k().i();
    }
    
    private boolean b(final aV av, final d d) {
        return !this.d && av != null && av.a(d).k() != null && av.a(d).k().h().c() == 1;
    }
    
    private boolean c(final aV av, final d d) {
        return !this.d && av != null && av.a(d).k() != null && av.a(d).k().h().b() != 0;
    }
    
    private final double a(final X x, final aV av, final d d, final double n, final double n2, final double n3, final double n4, final double n5, double max) {
        final B k = av.a(d).k();
        if (k != null) {
            max = Math.max(max, k.c() - Math.abs(n - n3) - (n4 - n2));
        }
        return max;
    }
    
    protected double a(final X x, final aV av, final d d) {
        final B k = av.a(d).k();
        return (k != null) ? k.d() : this.q;
    }
    
    private final boolean d(final aV av, final d d) {
        if (this.d) {
            return false;
        }
        final B k = av.a(d).k();
        final byte b = av.a(d.c()).b();
        if (b == 6 || b == 7) {
            return this.f || (k != null && k.h().b() == 2);
        }
        final byte b2 = av.a(d.d()).b();
        if (b2 == 6 || b2 == 7) {
            return this.f || (k != null && k.h().b() == 2);
        }
        if (k != null) {
            return k.h().c() == 2;
        }
        return this.e;
    }
    
    private final double a(final aV av, final d d, final boolean b) {
        final A a = av.a(d);
        final B k = a.k();
        if (k != null) {
            if (b) {
                return a.i() ? k.b() : k.a();
            }
            return a.i() ? k.a() : k.b();
        }
        else {
            if (b) {
                return a.i() ? this.l : this.k;
            }
            return a.i() ? this.k : this.l;
        }
    }
    
    private final double e(final aV av, final d d) {
        final B k = av.a(d).k();
        return (k != null) ? k.e() : this.g;
    }
    
    private final double f(final aV av, final d d) {
        final B k = av.a(d).k();
        return (k != null) ? k.c() : this.i;
    }
    
    private final double a(final X x, final aV av, final aQ aq, final aQ aq2) {
        return this.h;
    }
    
    private final double b(final X x, final aV av, final aQ aq, final aQ aq2) {
        return this.j;
    }
    
    private final double a(final X x, final aV av, final aQ aq, final double n, final aQ aq2, final double n2, final cr cr, final List list, final double n3, final double n4) {
        final boolean x2 = N.x;
        final int n5 = aq2.c() - aq.c() - 1;
        double max = 0.0;
        double max2 = 0.0;
        Label_1015: {
            Label_0993: {
                if (list.size() > 0) {
                    cr.d();
                    cr.f();
                    cr.g();
                    final bZ[] array = new bZ[list.size() * 2];
                    int i = 0;
                    while (true) {
                    Label_0988_Outer:
                        while (i < list.size()) {
                            final d d = list.get(i);
                            final double a = x.p(d).a;
                            final double a2 = x.q(a(d, n5)).a;
                            array[i * 2] = new bZ(a, d);
                            array[i * 2 + 1] = new bZ(a2, d);
                            ++i;
                            if (x2) {
                                int n6 = 0;
                                final ArrayList<d> list2 = (ArrayList<d>)new ArrayList<Object>(list.size());
                                y.g.e.a(array, 0, i, null);
                                final BitSet set = new BitSet(x.h());
                                int n7 = 0;
                                double n8 = -1.7976931348623157E308;
                                double n9 = Double.MAX_VALUE;
                                int j = 0;
                                while (true) {
                                    while (j < i) {
                                        final d d2 = (d)array[j].b;
                                        if (!x2) {
                                            Label_0975: {
                                                if (set.get(d2.b())) {
                                                    Label_0665: {
                                                        if (--n6 == 0) {
                                                            final double a3 = array[n7].a;
                                                            final double a4 = array[j].a;
                                                            double b = cr.b(a3, a4, 0.0);
                                                            if (Double.isNaN(b)) {
                                                                b = n;
                                                            }
                                                            final double min = Math.min(n9, b);
                                                            double a5 = cr.a(a3, a4, 0.0);
                                                            if (Double.isNaN(a5)) {
                                                                a5 = n2;
                                                            }
                                                            final double max3 = Math.max(n8, a5);
                                                            int k = 0;
                                                            while (true) {
                                                                while (k < list2.size()) {
                                                                    final d d3 = list2.get(k);
                                                                    final t p10 = x.p(d3);
                                                                    final t q = x.q(a(d3, n5));
                                                                    final D a6 = this.a(d3);
                                                                    final double n10 = dcmpl(max3, p10.b);
                                                                    if (x2) {
                                                                        n7 = (int)n10;
                                                                        break Label_0665;
                                                                    }
                                                                    double b2 = 0.0;
                                                                    Label_0503: {
                                                                        if (n10 > 0) {
                                                                            a6.add(new Point2D.Double(p10.a, b2 = max3));
                                                                            if (!x2) {
                                                                                break Label_0503;
                                                                            }
                                                                        }
                                                                        a6.add(new Point2D.Double(p10.a, b2 = p10.b));
                                                                    }
                                                                    double n11 = 0.0;
                                                                    Label_0574: {
                                                                        if (min < q.b + n3) {
                                                                            a6.add(new Point2D.Double(q.a, n11 = min));
                                                                            if (!x2) {
                                                                                break Label_0574;
                                                                            }
                                                                        }
                                                                        a6.add(new Point2D.Double(q.a, n11 = q.b + n3));
                                                                    }
                                                                    final double abs = Math.abs(p10.a - q.a);
                                                                    final double n12 = n11 - b2;
                                                                    max = Math.max(max, this.f(av, d3) - n12);
                                                                    max2 = Math.max(max2, abs * this.e(av, d3) - n12);
                                                                    ++k;
                                                                    if (x2) {
                                                                        break;
                                                                    }
                                                                }
                                                                n8 = -1.7976931348623157E308;
                                                                n9 = Double.MAX_VALUE;
                                                                list2.clear();
                                                                continue Label_0988_Outer;
                                                            }
                                                        }
                                                    }
                                                    set.clear(d2.b());
                                                    if (!x2) {
                                                        break Label_0975;
                                                    }
                                                }
                                                set.set(d2.b());
                                                ++n6;
                                                list2.add(d2);
                                                final d a7 = a(d2, n5);
                                                Label_0839: {
                                                    if (a(av.a(d2.c()))) {
                                                        if (this.n) {
                                                            n8 = Math.max(n8, Math.min(x.p(d2).b + this.a(av, d2, true), (x.p(d2).b + n2) * 0.4));
                                                            if (!x2) {
                                                                break Label_0839;
                                                            }
                                                        }
                                                        n8 = Math.max(n8, x.p(d2).b + this.a(av, d2, true));
                                                        if (!x2) {
                                                            break Label_0839;
                                                        }
                                                    }
                                                    n8 = Math.max(n8, x.p(d2).b);
                                                }
                                                if (a(av.a(a7.d()))) {
                                                    if (this.n) {
                                                        n9 = Math.min(n9, Math.max(x.q(a7).b + n3 - this.a(av, d2, false), (x.q(a7).b + n) * 0.6));
                                                        if (!x2) {
                                                            break Label_0975;
                                                        }
                                                    }
                                                    n9 = Math.min(n9, x.q(a7).b + n3 - this.a(av, d2, false));
                                                    if (!x2) {
                                                        break Label_0975;
                                                    }
                                                }
                                                n9 = Math.min(n9, x.q(a7).b + n3);
                                            }
                                            ++j;
                                            if (x2) {
                                                break;
                                            }
                                            continue Label_0988_Outer;
                                        }
                                        else {
                                            if (x2) {
                                                break Label_0993;
                                            }
                                            break Label_1015;
                                        }
                                    }
                                    cr.h();
                                    continue;
                                }
                            }
                            if (x2) {
                                break;
                            }
                        }
                        i = list.size() * 2;
                        continue;
                    }
                }
            }
            if (this.n) {
                cr.i();
                if (!x2) {
                    break Label_1015;
                }
            }
            cr.j();
        }
        final double n13 = n2 - n;
        final double b3 = this.b(x, av, aq, aq2);
        final double n14 = b3 - n13;
        double n15 = this.n ? cr.e() : cr.d(b3);
        if (!this.n) {
            n15 = Math.max(Math.max(Math.max(n4, n15), n14), Math.max(max, max + Math.min(this.a(x, av, aq, aq2), max2 - max)));
        }
        Label_1528: {
            Label_1499: {
                Label_1193: {
                    if (n5 == 0) {
                        if (n15 != 0.0) {
                            int l = 0;
                            while (l < list.size()) {
                                final Point2D.Double double1 = (Point2D.Double)this.a(list.get(l)).i();
                                double1.y += n15;
                                ++l;
                                if (x2) {
                                    break Label_1528;
                                }
                                if (x2) {
                                    break Label_1193;
                                }
                            }
                        }
                        break Label_1499;
                    }
                }
                Label_1373: {
                    if (n5 == 2) {
                        int n16 = 0;
                        while (n16 < list.size()) {
                            final d d4 = list.get(n16);
                            final D a8 = this.a(d4);
                            final Point2D.Double double2 = (Point2D.Double)a8.f();
                            final Point2D.Double double3 = (Point2D.Double)a8.i();
                            a8.clear();
                            final q d5 = d4.d();
                            final d f = d5.f();
                            final q d6 = f.d();
                            final d f2 = d6.f();
                            x.b(d4, y.d.t.c);
                            x.a(f, y.d.t.c);
                            x.b(f, y.d.t.c);
                            x.a(f2, y.d.t.c);
                            x.a(d5, double2.x, double2.y);
                            x.a(d6, double3.x, double3.y + n15);
                            ++n16;
                            if (x2) {
                                break Label_1528;
                            }
                            if (x2) {
                                break Label_1373;
                            }
                        }
                        break Label_1499;
                    }
                }
                if (n5 == 1) {
                    int n17 = 0;
                    while (n17 < list.size()) {
                        final d d7 = list.get(n17);
                        final Point2D.Double double5;
                        final Point2D.Double double4 = double5 = (Point2D.Double)this.a(d7).i();
                        double5.y += n15;
                        final q d8 = d7.d();
                        final d f3 = d8.f();
                        x.b(d7, y.d.t.c);
                        x.a(f3, y.d.t.c);
                        x.a(d8, double4.x, double4.y);
                        ++n17;
                        if (x2) {
                            break Label_1528;
                        }
                        if (x2) {
                            break;
                        }
                    }
                }
            }
            if (n15 != 0.0) {
                cr.e(n15);
            }
            n15 = this.c.a(cr, b3, n15);
        }
        if (this.A != null) {
            final double d9 = cr.d(this.A);
            final double c = this.c(this.B, this.A, x);
            Label_1656: {
                if (c > 0.0) {
                    this.B.d(d9 - c * 0.5 - this.B.h());
                    this.b(this.B, this.A, x);
                    this.A.g(d9 + c * 0.5);
                    if (!x2) {
                        break Label_1656;
                    }
                }
                this.B.d(d9 - this.B.h());
                this.A.g(d9);
            }
            this.B = this.A;
        }
        return n15;
    }
    
    private static final d a(final d d, final int n) {
        switch (n) {
            default: {
                return d;
            }
            case 1: {
                return d.d().f();
            }
            case 2: {
                return d.d().f().d().f();
            }
        }
    }
    
    private static final boolean a(final aX ax) {
        return ax.b() == 0 || ax.b() == 5;
    }
    
    private static final Object a(final q q, final aV av) {
        return (q.a() == 2) ? null : av.a(q).a();
    }
    
    private final D a(final d d) {
        D d2 = this.z.get(d);
        if (d2 == null) {
            d2 = new D();
            this.z.put(d, d2);
        }
        return d2;
    }
    
    private void a(final X x, final aV av, final c c, final q q, final am am, final double n, final boolean b) {
        final boolean x2 = N.x;
        final aX a = av.a(q);
        final byte b2 = a.b();
        if (b2 == 2 || b2 == 3) {
            final B k = av.a(a.g()).k();
            final q f = a.f();
            final t l = x.l(q);
            final double j = x.j(f);
            final bs h = k.h();
            if ((b2 == 3 && h.d() == 1) || (b2 == 2 && h.c() == 1)) {
                final double n2 = k.i() / bY.a;
                if (b) {
                    if (j > l.a) {
                        final c c2 = new c(l.a, j, l.b + n);
                        c2.a(l.a, l.a + n2, l.b + n - n2, 1.0);
                        c.b(c2);
                        if (!x2) {
                            return;
                        }
                    }
                    final c c3 = new c(j, l.a, l.b + n);
                    c3.a(l.a - n2, l.a, l.b + n, -1.0);
                    c.b(c3);
                    if (!x2) {
                        return;
                    }
                }
                if (j > l.a) {
                    final c c4 = new c(l.a, j, l.b + n);
                    c4.a(l.a, l.a + n2, l.b + n + n2, -1.0);
                    c.a(c4);
                    if (!x2) {
                        return;
                    }
                }
                final c c5 = new c(j, l.a, l.b + n);
                c5.a(l.a - n2, l.a, l.b + n, 1.0);
                c.a(c5);
                if (!x2) {
                    return;
                }
            }
            if (b) {
                if (j > l.a) {
                    c.a(l.a, j + 1.0, l.b + n);
                    if (!x2) {
                        return;
                    }
                }
                c.a(j, l.a + 1.0, l.b + n);
                if (!x2) {
                    return;
                }
            }
            if (j > l.a) {
                c.b(l.a, j + 1.0, l.b + n);
                if (!x2) {
                    return;
                }
            }
            c.b(j, l.a + 1.0, l.b + n);
            return;
        }
        final double a2 = this.a();
        this.b.a(x, av, c, q, am, a, n, b);
        Label_0811: {
            if (b) {
                c.a(am.getX() - a2, am.getX() + am.getWidth() + a2, n + am.getY());
                final c a3 = a.a(0);
                if (a3 != null) {
                    a3.b(am.getX());
                    a3.a(am.getY() + n);
                    c.b(a3);
                    a3.a(-(am.getY() + n));
                    a3.b(-am.getX());
                }
                d d = q.g();
                while (d != null) {
                    final t q2 = x.q(d);
                    if (q2.a < am.getX() - a2 || q2.a > am.getX() + am.getWidth() + a2) {
                        c.a(q2.a - a2, q2.a + a2, n + am.getY());
                    }
                    d = d.h();
                    if (x2) {
                        break Label_0811;
                    }
                }
                return;
            }
        }
        c.b(am.getX() - a2, am.getX() + am.getWidth() + a2, n + am.getY() + am.getHeight());
        final c a4 = a.a(2);
        if (a4 != null) {
            a4.b(am.getX());
            a4.a(am.getY() + n);
            c.a(a4);
            a4.a(-(am.getY() + n));
            a4.b(-am.getX());
        }
        d d2 = q.f();
        while (d2 != null) {
            final t p7 = x.p(d2);
            if (p7.a < am.getX() - a2 || p7.a > am.getX() + am.getWidth() + a2) {
                c.b(p7.a - a2, p7.a + a2, n + am.getY() + am.getHeight());
            }
            d2 = d2.g();
            if (x2) {
                break;
            }
        }
    }
    
    static final int a(final byte b, final int n) {
        switch (b) {
            default: {
                return n;
            }
            case 1: {
                return 0;
            }
            case 4: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 8: {
                return 3;
            }
        }
    }
    
    static final int a(final aE ae, final int n) {
        if (ae == null) {
            return n;
        }
        return a(ae.b(), n);
    }
    
    public double a() {
        return this.o;
    }
    
    public void a(final double o) {
        this.o = o;
    }
    
    public double b() {
        return this.q;
    }
    
    public void b(final double q) {
        this.q = q;
        this.b.a(q);
    }
    
    public void a(final long n) {
        this.t = Math.max(0L, n);
    }
    
    static {
        a = Math.sqrt(2.0);
    }
}
