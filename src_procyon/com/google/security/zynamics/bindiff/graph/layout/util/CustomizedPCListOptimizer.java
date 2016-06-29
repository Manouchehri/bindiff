package com.google.security.zynamics.bindiff.graph.layout.util;

import y.d.*;
import y.f.*;
import y.g.*;
import java.util.*;
import y.c.*;
import y.f.c.a.*;

public class CustomizedPCListOptimizer implements br
{
    private boolean backloopRouting;
    
    public CustomizedPCListOptimizer() {
        this.backloopRouting = false;
    }
    
    private static boolean isBackwardEdge(final d d, final A a) {
        return a.a(d.c()) > a.a(d.d());
    }
    
    private void assignEdgePorts(final q q, final f f, final X x, final boolean b, final aP ap) {
        final f f2 = new f();
        final f f3 = new f();
        final f f4 = new f();
        final e a = f.a();
        while (a.f()) {
            final d a2 = a.a();
            final double n = b ? x.n(a2).a() : x.o(a2).a();
            if (n < 0.0) {
                f2.add(a2);
            }
            else if (n > 0.0) {
                f4.add(a2);
            }
            else {
                f3.add(a2);
            }
            a.g();
        }
        final double n2 = x.p(q) * 0.5;
        final double n3 = n2 / 3.0;
        this.distributeEdges(f2, -n2, -n3, q, x, ap, b);
        this.distributeEdges(f3, -n3, n3, q, x, ap, b);
        this.distributeEdges(f4, n3, n2, q, x, ap, b);
    }
    
    private void distributeEdges(final f f, final double n, final double n2, final q q, final X x, final aP ap, final boolean b) {
        final double n3 = x.q(q) * 0.5;
        final double n4 = (n2 - n) / (f.size() + 1);
        double n5 = n + n4;
        final e a = f.a();
        while (a.f()) {
            final d a2 = a.a();
            if (b) {
                x.a(a2, new t(n5, n3));
            }
            else {
                x.b(a2, new t(n5, -n3));
            }
            ap.a(a2, b, aE.a((byte)(b ? 2 : 1), true));
            a.g();
            n5 += n4;
        }
    }
    
    private ax getCandidateWithDirection(final Collection collection, final byte b) {
        if (collection == null) {
            return null;
        }
        for (final ax ax : collection) {
            if (ax.a() == b) {
                return ax;
            }
        }
        return null;
    }
    
    private aE transformToPortConstraint(final ax ax, final d d, final boolean b, final X x) {
        if (ax.b()) {
            final t t = new t(ax.c(), ax.d());
            if (b) {
                x.a(d, t);
            }
            else {
                x.b(d, t);
            }
        }
        return ax.e();
    }
    
    public boolean isBackloopRouting() {
        return this.backloopRouting;
    }
    
    @Override
    public void optimizeAfterLayering(final X x, final aU au, final aV av, final aP ap) {
        final A a = M.a();
        for (int i = 0; i < au.b(); ++i) {
            final x a2 = au.a(i).d().a();
            while (a2.f()) {
                a.a(a2.e(), i);
                a2.g();
            }
        }
        final e p4 = x.p();
        while (p4.f()) {
            final d a3 = p4.a();
            if (!a3.e()) {
                final y.f.c.a.A a4 = av.a(a3);
                final int n = (!this.backloopRouting && isBackwardEdge(a3, a)) ? 1 : 2;
                final ax candidateWithDirection = this.getCandidateWithDirection(a4.d(), (byte)n);
                if (candidateWithDirection != null) {
                    ap.a(a3, true, this.transformToPortConstraint(candidateWithDirection, a3, true, x));
                }
                else {
                    ap.a(a3, true, aE.a((byte)n));
                }
                final int n2 = (!this.backloopRouting && isBackwardEdge(a3, a)) ? 2 : 1;
                final ax candidateWithDirection2 = this.getCandidateWithDirection(a4.f(), (byte)n2);
                if (candidateWithDirection2 != null) {
                    ap.a(a3, false, this.transformToPortConstraint(candidateWithDirection2, a3, false, x));
                }
                else {
                    ap.a(a3, false, aE.a((byte)n2));
                }
            }
            p4.g();
        }
    }
    
    @Override
    public void optimizeAfterSequencing(final X x, final aU au, final aV av, final aP ap) {
        final ArrayList<q> list = new ArrayList<q>(64);
        final A a = M.a();
        int n = 0;
        final x o = x.o();
        while (o.f()) {
            n += av.a(o.e()).e();
            o.g();
        }
        final int e = x.e();
        final d[] array = new d[n / 2];
        int n2 = 2;
        for (int i = 0; i < au.b(); ++i) {
            for (p p4 = au.a(i).d().k(); p4 != null; p4 = p4.a()) {
                final q q = (q)p4.c();
                final aX a2 = av.a(q);
                if (a2.e() > 0) {
                    for (p p5 = a2.d(); p5 != null; p5 = p5.a()) {
                        final d d = (d)p5.c();
                        if (d.c() == q) {
                            final q d2 = x.d();
                            a.a(d2, true);
                            final y.f.c.a.A a3 = av.a(d);
                            list.add(d2);
                            int n3;
                            if (a3.j()) {
                                ap.b(d2, q, d, false, true);
                                ap.a(d2, d.d(), d, false, true);
                                n3 = Math.max(n2, d.d().b());
                            }
                            else {
                                ap.a(q, d2, d, true, false);
                                ap.b(d.d(), d2, d, true, false);
                                n3 = Math.max(n2, d.d().c());
                            }
                            n2 = Math.max(2, n3);
                            array[d2.d() - e] = d;
                        }
                    }
                }
                n2 = Math.max(n2, Math.max(q.b(), q.c()));
            }
        }
        final x o2 = x.o();
        while (o2.f()) {
            final q e2 = o2.e();
            if (!a.d(e2) && av.a(e2).b() == 0) {
                final f f = new f(e2.k());
                f.sort(new CustomizedPCListOptimizer$EdgeOrderComparator(this, a, e2, av, null));
                this.assignEdgePorts(e2, f, x, false, ap);
                final f f2 = new f(e2.l());
                f2.sort(new CustomizedPCListOptimizer$EdgeOrderComparator(this, a, e2, av, null));
                this.assignEdgePorts(e2, f2, x, true, ap);
            }
            o2.g();
        }
        for (int j = 0; j < list.size(); ++j) {
            final q q2 = list.get(j);
            final d d3 = array[q2.d() - e];
            x.e(d3);
            y.f.c.a.A a4 = av.a(d3);
            if (q2.c() > 0) {
                final d f3 = q2.f();
                final d h = q2.h();
                final y.f.c.a.A a5 = av.a(f3);
                final y.f.c.a.A a6 = av.a(h);
                if (f3.d() == d3.c()) {
                    if (a5.e() != a4.c()) {
                        a4 = ap.a(d3, true, a5.e());
                    }
                    if (a6.e() != a4.e()) {
                        ap.a(d3, false, a6.e());
                    }
                    x.a(d3, x.o(f3));
                    x.b(d3, x.o(h));
                }
                else {
                    if (a6.e() != a4.c()) {
                        a4 = ap.a(d3, true, a6.e());
                    }
                    if (a5.e() != a4.e()) {
                        ap.a(d3, false, a5.e());
                    }
                    x.a(d3, x.o(h));
                    x.b(d3, x.o(f3));
                }
            }
            else {
                final d g = q2.g();
                final d k = q2.i();
                final y.f.c.a.A a7 = av.a(g);
                final y.f.c.a.A a8 = av.a(k);
                if (g.c() == d3.c()) {
                    if (a7.c() != a4.c()) {
                        a4 = ap.a(d3, true, a7.c());
                    }
                    if (a8.c() != a4.e()) {
                        ap.a(d3, false, a8.c());
                    }
                    x.a(d3, x.n(g));
                    x.b(d3, x.n(k));
                }
                else {
                    if (a8.c() != a4.c()) {
                        a4 = ap.a(d3, true, a8.c());
                    }
                    if (a7.c() != a4.e()) {
                        ap.a(d3, false, a7.c());
                    }
                    x.a(d3, x.n(k));
                    x.b(d3, x.n(g));
                }
            }
            x.d(d3);
        }
        for (int l = 0; l < list.size(); ++l) {
            x.a((q)list.get(l));
        }
    }
    
    public void setBackloopRouting(final boolean backloopRouting) {
        this.backloopRouting = backloopRouting;
    }
}
