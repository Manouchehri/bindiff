package y.h;

import y.c.*;
import y.d.*;
import y.f.*;

class in implements dE
{
    private gu a;
    private dh b;
    private n c;
    private gv d;
    private gv e;
    private t f;
    private double g;
    private double h;
    
    in(final gu a) {
        this.a = a;
    }
    
    public void a(final dD dd) {
        this.g = dd.c();
        this.h = dd.d();
        final aA aa = (aA)dd.b();
        this.c = aa.getOrientedBox();
        this.f = this.c.k();
        final Object modelParameter = aa.getModelParameter();
        final gv gv = (gv)((modelParameter instanceof gv) ? modelParameter : this.a.c());
        this.d = gv;
        this.e = gv;
        final dB a = dd.a();
        if (a.e()) {
            (this.b = a.c()).a(a.view);
            this.b.a(new t(this.g, this.h), (aA)dd.b());
        }
    }
    
    public void b(final dD dd) {
        final boolean z = fj.z;
        final it it = new it(this, dd);
        Label_0217: {
            if (dd.e()) {
                final iq iq = this.a(((aA)dd.b()).getEdge()) ? this.a(it) : this.b(it);
                final D d = new D();
                Label_0096: {
                    if (iq == null) {
                        it.d();
                        if (!z) {
                            break Label_0096;
                        }
                    }
                    d.add(iq);
                    it.f = iq.c();
                }
                final t a = it.a(d);
                final n c = it.c();
                final double b = it.b();
                if (t.a(c.k(), a) <= ((b < 1.0) ? 0.1 : (0.1 / b))) {
                    break Label_0217;
                }
                final aB realizer = it.a.getRealizer();
                it.e.b(a);
                it.f = (gv)it.b.b(it.e, realizer, realizer.getSourceRealizer(), realizer.getTargetRealizer());
                if (!z) {
                    break Label_0217;
                }
            }
            this.b.h();
            it.d();
        }
        this.e = it.f;
        it.a.setModelParameter(it.f);
    }
    
    private boolean a(final d d) {
        final aB i = ((bu)d.a()).i(d);
        return d.e() && i.bendCount() == 1;
    }
    
    public void c(final dD dd) {
        this.b();
    }
    
    public void a() {
        this.b();
    }
    
    private void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }
    
    private iq a(final it it) {
        final double a = it.a();
        final gu b = it.b;
        final n e = it.e;
        final aB realizer = it.a.getRealizer();
        final gv a2 = b.a(e, realizer, this.d, (byte)0);
        final t e2 = realizer.firstBend().e();
        if (t.a(e.k(), e2) < a) {
            final ir ir = new ir();
            ir.a(e2);
            ir.a(it.d);
            return new iq(a2, e2, ir);
        }
        return null;
    }
    
    private iq b(final it it) {
        final boolean z = fj.z;
        final double a = it.a();
        final gu b = it.b;
        final gv c = it.c;
        final n e = it.e;
        final aA a2 = it.a;
        final aB realizer = a2.getRealizer();
        final fj sourceRealizer = realizer.getSourceRealizer();
        final fj targetRealizer = realizer.getTargetRealizer();
        final gv a3 = b.a(e, realizer, c, (byte)0);
        final t k = b.a(e.d(), realizer, sourceRealizer, targetRealizer, a3).k();
        final m g = a3.g();
        ir ir = null;
        if (g != null) {
            final t c2 = g.c();
            final t d = g.d();
            ir = new ir(c2.a(), c2.b(), d.a(), d.b());
            ir.a(it.d);
        }
        if (t.a(e.k(), k) < a) {
            final y.f.D d2 = new y.f.D();
            d2.setModelParameter(a3);
            d2.a(b);
            d2.a(e);
            d2.a(a2.getPreferredPlacementDescriptor());
            final D a4 = b.a(d2, realizer, sourceRealizer, targetRealizer);
            Q q = null;
            double n = a * 0.5;
            if (a4 != null && !a4.isEmpty()) {
                final int n2 = realizer.pointCount() + 1;
                final y.c.C m = a4.m();
                while (m.f()) {
                    final B b2 = (B)m.d();
                    final t i = b2.d().k();
                    if (z) {
                        return new iq(a3, k, ir);
                    }
                    if (ir != null && a(a3, b2.b(), n2)) {
                        ir.a(i);
                        final double a5 = t.a(i, k);
                        if (a5 < n) {
                            q = b2;
                            n = a5;
                        }
                    }
                    m.g();
                    if (z) {
                        break;
                    }
                }
            }
            if (q != null) {
                return new iq((gv)q.b(), q.d().k(), ir);
            }
            return new iq(a3, k, ir);
        }
        return null;
    }
    
    private static boolean a(final Object o, final Object o2, final int n) {
        final gv gv = (gv)o;
        final int a = gv.a();
        final int n2 = (a < 0) ? (a + n) : a;
        final gv gv2 = (gv)o2;
        final int a2 = gv2.a();
        return n2 == ((a2 < 0) ? (a2 + n) : a2) && gv.e() == gv2.e();
    }
    
    static double a(final in in) {
        return in.g;
    }
    
    static double b(final in in) {
        return in.h;
    }
    
    static t c(final in in) {
        return in.f;
    }
    
    static gu d(final in in) {
        return in.a;
    }
    
    static gv e(final in in) {
        return in.e;
    }
    
    static gv f(final in in) {
        return in.d;
    }
    
    static dh g(final in in) {
        return in.b;
    }
    
    static n h(final in in) {
        return in.c;
    }
}
