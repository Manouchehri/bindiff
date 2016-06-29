package y.h;

import y.h.a.*;
import y.c.*;
import y.d.*;
import java.util.*;
import java.awt.geom.*;
import y.f.*;

public class fo implements fs
{
    private boolean a;
    private WeakHashMap b;
    
    public fo() {
        this.a = true;
        this.b = new WeakHashMap();
    }
    
    public boolean a() {
        return this.a;
    }
    
    public void a(final q q) {
        this.b.put(q, this.b());
        this.d(q);
    }
    
    public void b(final q q) {
        final fr fr = this.b.get(q);
        if (fr == null) {
            return;
        }
        this.a(new f(y.h.fr.a(fr).keySet().iterator()), q);
        y.h.fr.a(fr).clear();
        this.b.remove(q);
    }
    
    protected f c(final q q) {
        final v a = v.a(q.e());
        if (a == null || a.l(q)) {
            return new f();
        }
        if (a.k(q)) {
            return this.a(q, q.e());
        }
        return this.e(q);
    }
    
    protected void a(final d d, final q q) {
        this.c(d, q);
    }
    
    protected void b(final d d, final q q) {
        if (d.a() != null) {
            this.d(d, q);
        }
    }
    
    private void d(final q q) {
        final boolean z = fj.z;
        final e a = this.c(q).a();
        while (a.f()) {
            this.a(a.a(), q);
            a.g();
            if (z) {
                break;
            }
        }
    }
    
    private void a(final f f, final q q) {
        final boolean z = fj.z;
        final e a = f.a();
        while (a.f()) {
            this.b(a.a(), q);
            a.g();
            if (z) {
                break;
            }
        }
    }
    
    private void a(final q q, final v v, final y y, final boolean[] array) {
        final boolean z = fj.z;
        y.add(q);
        if (v.k(q)) {
            final x p4 = v.p(q);
            while (p4.f()) {
                final q e = p4.e();
                array[e.d()] = true;
                this.a(e, v, y, array);
                p4.g();
                if (z) {
                    break;
                }
            }
        }
    }
    
    protected boolean a(final d d, final bu bu) {
        final c a = a(bu);
        return a != null && a.d(d);
    }
    
    private f a(final q q, final i i) {
        final boolean z = fj.z;
        final v a = v.a(i);
        final y y = new y();
        final boolean[] array = new boolean[i.e()];
        this.a(q, a, y, array);
        final f f = new f();
        final x a2 = y.a();
        while (a2.f()) {
            final q e;
            final q q2 = e = a2.e();
        Label_0074:
            while (true) {
                q q3 = null;
                final e j = q3.j();
                while (j.f()) {
                    final d a3 = j.a();
                    q3 = q2;
                    if (z) {
                        continue Label_0074;
                    }
                    if (q3 == q || !array[a3.a(q2).d()]) {
                        f.add(a3);
                    }
                    j.g();
                    if (z) {
                        break;
                    }
                }
                break;
            }
            a2.g();
            if (z) {
                break;
            }
        }
        return f;
    }
    
    private static c a(final bu bu) {
        c c = bu.c(aC.ORTHOGONAL_ROUTING_DPKEY);
        if (c == null && bu.C() != null && bu.C().g() != bu) {
            c = bu.C().g().c(aC.ORTHOGONAL_ROUTING_DPKEY);
        }
        return c;
    }
    
    private f e(final q q) {
        return new f(q.j());
    }
    
    private fr b() {
        return new fr(null);
    }
    
    private fr f(final q q) {
        if (this.b.containsKey(q)) {
            return this.b.get(q);
        }
        final fr b = this.b();
        this.b.put(q, b);
        return b;
    }
    
    private void c(final d d, final q q) {
        final fr f = this.f(q);
        final bu bu = (bu)d.a();
        final t p2 = bu.p(d);
        final t q2 = bu.q(d);
        final t l = bu.l(q);
        final double n = bu.p(q) / 2.0;
        final double n2 = bu.q(q) / 2.0;
        final t g = new t((n == 0.0) ? 0.0 : ((p2.a() - l.a()) / n), (n2 == 0.0) ? 0.0 : ((p2.b() - l.b()) / n2));
        final t h = new t((n == 0.0) ? 0.0 : ((q2.a() - l.a()) / n), (n2 == 0.0) ? 0.0 : ((q2.b() - l.b()) / n2));
        final boolean a = this.a(d, bu);
        byte a2 = 3;
        byte a3 = 3;
        if (a) {
            final aB i = bu.i(d);
            if (d.c() == q) {
                a2 = ic.a(null, i, true, (byte)0);
            }
            if (d.d() == q) {
                a3 = ic.a(null, i, false, (byte)0);
            }
        }
        final fq fq = new fq(a, a2, a3, new u(bu.g(d)), d.c(), d.d());
        fq.g = g;
        fq.h = h;
        Label_0527: {
            if (this.a()) {
                final v c = bu.C();
                if (c != null) {
                    if (c.k(q)) {
                        final boolean b = c.n(d.c()) == q;
                        final boolean b2 = c.n(d.d()) == q;
                        if (!(b ^ b2)) {
                            break Label_0527;
                        }
                        if (b) {
                            final eU b3 = eU.b(bu.i(d));
                            if (b3 != null && a(b3, bu.t(d.c()))) {
                                fq.i = b3;
                            }
                        }
                        if (!b2) {
                            break Label_0527;
                        }
                        final eU d2 = eU.d(bu.i(d));
                        if (d2 == null || !a(d2, bu.t(d.d()))) {
                            break Label_0527;
                        }
                        fq.j = d2;
                        if (!fj.z) {
                            break Label_0527;
                        }
                    }
                    if (c.j(q) && c.e(d)) {
                        if (d.c() == q) {
                            fq.i = a(c, d, q, true);
                        }
                        if (d.d() == q) {
                            fq.j = a(c, d, q, false);
                        }
                    }
                }
            }
        }
        f.a().put(d, fq);
    }
    
    private static boolean a(final eU eu, final fj fj) {
        return eU.a(eu, fj);
    }
    
    private static eU a(final v v, final d d, final q q, final boolean b) {
        final Map map = (Map)a(v, d, b ? "HierarchyManager.InterEdgeData.SOURCE_PORT" : "HierarchyManager.InterEdgeData.TARGET_PORT");
        if (map == null || map.isEmpty()) {
            return null;
        }
        final q q2 = b ? v.b(d) : v.c(d);
        if (q2 == q) {
            final q a = q2;
            if (!fj.z) {
                return map.get(a);
            }
        }
        final q a = v.a(q2, v.m(q));
        return map.get(a);
    }
    
    private void d(final d d, final q q) {
        final boolean z = fj.z;
        final fq fq = this.b.get(q).a().get(d);
        if (fq == null) {
            return;
        }
        final i e = q.e();
        if (!(e instanceof bu)) {
            return;
        }
        final bu bu = (bu)e;
        final q c = d.c();
        final q d2 = d.d();
        final I d3 = fq.d;
        final t sourcePoint = d3.getSourcePoint();
        final t targetPoint = d3.getTargetPoint();
        final double a = fq.g.a();
        final double b = fq.g.b();
        final double a2 = fq.h.a();
        final double b2 = fq.h.b();
        final double n = a * bu.p(q) / 2.0;
        final double n2 = b * bu.q(q) / 2.0;
        final double n3 = a2 * bu.p(q) / 2.0;
        final double n4 = b2 * bu.q(q) / 2.0;
        final double n5 = bu.j(q) + n;
        final double n6 = bu.k(q) + n2;
        final double n7 = bu.j(q) + n3;
        final double n8 = bu.k(q) + n4;
        final am a3 = bu.a((Object)c);
        final am a4 = bu.a((Object)d2);
        t l = null;
        Label_0343: {
            if (new Rectangle2D.Double(a3.getX() - 1.0, a3.getY() - 1.0, a3.getWidth() + 2.0, a3.getHeight() + 2.0).contains(n5, n6)) {
                l = new t(n5, n6);
                if (!z) {
                    break Label_0343;
                }
            }
            l = bu.l(c);
        }
        t i = null;
        Label_0427: {
            if (new Rectangle2D.Double(a4.getX() - 1.0, a4.getY() - 1.0, a4.getWidth() + 2.0, a4.getHeight() + 2.0).contains(n7, n8)) {
                i = new t(n7, n8);
                if (!z) {
                    break Label_0427;
                }
            }
            i = bu.l(d2);
        }
        bu.a(new f(d).a());
        final aB j = bu.i(d);
        j.clearBends();
        int k = 0;
        while (true) {
            while (k < d3.pointCount()) {
                final t point = d3.getPoint(k);
                j.addPoint(point.a(), point.b());
                ++k;
                if (z) {
                    final boolean a5 = this.a(d, q, false);
                    Label_0553: {
                        if (k != 0) {
                            bu.c(d, l);
                            if (!z) {
                                break Label_0553;
                            }
                        }
                        j.setSourcePoint(sourcePoint);
                    }
                    Label_0578: {
                        if (a5) {
                            bu.d(d, i);
                            if (!z) {
                                break Label_0578;
                            }
                        }
                        j.setTargetPoint(targetPoint);
                    }
                    if (fq.a) {
                        if (k != 0) {
                            ic.a(null, j, true, fq.b);
                        }
                        if (a5) {
                            ic.a(null, j, false, fq.c);
                        }
                    }
                    if (this.a()) {
                        final v c2 = bu.C();
                        if (c2 != null) {
                            if (c2.j(q) && c2.e(d)) {
                                if (k != 0) {
                                    a(c2, d, fq, true);
                                    fq.i = null;
                                }
                                if (!a5) {
                                    return;
                                }
                                a(c2, d, fq, false);
                                fq.j = null;
                                if (!z) {
                                    return;
                                }
                            }
                            if (c2.k(q)) {
                                final boolean b3 = c2.n(d.c()) == q;
                                final boolean b4 = c2.n(d.d()) == q;
                                if (b3 ^ b4) {
                                    final aB m = bu.i(d);
                                    if (b3) {
                                        eU.a(fq.i, m);
                                    }
                                    if (b4) {
                                        eU.b(fq.j, m);
                                    }
                                }
                            }
                        }
                    }
                    return;
                }
                if (z) {
                    break;
                }
            }
            k = (this.a(d, q, true) ? 1 : 0);
            continue;
        }
    }
    
    private static void a(final v v, final d d, final fq fq, final boolean b) {
        final q q = b ? fq.e : fq.f;
        final eU eu = b ? fq.i : fq.j;
        final String s = b ? "HierarchyManager.InterEdgeData.SOURCE_PORT" : "HierarchyManager.InterEdgeData.TARGET_PORT";
        Map<q, eU> map = (Map<q, eU>)a(v, d, s);
        if (map == null) {
            map = new WeakHashMap<q, eU>();
            a(v, d, s, map);
        }
        map.put(q, eu);
    }
    
    private static Object a(final v v, final d d, final String s) {
        return v.d(d).a(s);
    }
    
    private static void a(final v v, final d d, final String s, final Object o) {
        v.d(d).a(s, o);
    }
    
    protected boolean a(final d d, final q q, final boolean b) {
        final fr fr = this.b.get(q);
        if (fr == null) {
            return false;
        }
        final fq fq = fr.a().get(d);
        if (fq == null) {
            return false;
        }
        if (b) {
            return fq.e == q || fq.e != d.c();
        }
        return fq.f == q || fq.f != d.d();
    }
}
