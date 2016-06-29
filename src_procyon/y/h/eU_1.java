package y.h;

import y.c.*;
import java.util.*;
import y.d.*;
import java.awt.geom.*;
import java.awt.*;

public class eU
{
    private static final eY f;
    private static final gq g;
    fj a;
    fP b;
    fe c;
    boolean d;
    Object e;
    
    public eU() {
        this.a = null;
        this.b = fm.a;
        this.c = j().a();
        this.d = false;
        this.e = null;
    }
    
    public eU(final eU eu) {
        this.a = null;
        this.b = eu.b;
        this.c = eu.c;
        this.d = eu.d;
        if (this.c.g == null) {
            this.e = eu.e;
            if (!fj.z) {
                return;
            }
        }
        this.e = this.c.g.a(eu, eu.e, this);
    }
    
    public eU a() {
        return this.a(this);
    }
    
    public eU a(final eU eu) {
        return new eU(eu);
    }
    
    protected void a(final fj a) {
        this.a = a;
    }
    
    public fj b() {
        return this.a;
    }
    
    public void a(final aB ab) {
        a(this, ab);
    }
    
    public static void a(final eU eu, final aB ab) {
        final boolean z = fj.z;
        if (eu == null) {
            ab.vb = null;
            if (!z) {
                return;
            }
        }
        final Object d = d(eu);
        if (d != null) {
            ab.vb = d;
            ab.setSourcePoint(b(eu));
            if (!z) {
                return;
            }
        }
        throw new IllegalArgumentException("NodePort not in NodeRealizer.");
    }
    
    public static eU b(final aB ab) {
        return a(ab, true);
    }
    
    public void c(final aB ab) {
        b(this, ab);
    }
    
    public static void b(final eU eu, final aB ab) {
        final boolean z = fj.z;
        if (eu == null) {
            ab.zb = null;
            if (!z) {
                return;
            }
        }
        final Object d = d(eu);
        if (d != null) {
            ab.zb = d;
            ab.setTargetPoint(b(eu));
            if (!z) {
                return;
            }
        }
        throw new IllegalArgumentException("NodePort not in NodeRealizer.");
    }
    
    public static eU d(final aB ab) {
        return a(ab, false);
    }
    
    private static eU a(final aB ab, final boolean b) {
        final Object o = b ? ab.vb : ab.zb;
        if (o != null && ab.i() != null) {
            return (b ? ab.getSourceRealizer() : ab.getTargetRealizer()).b(o);
        }
        return null;
    }
    
    public e c() {
        return this.a(true, true).a();
    }
    
    public e d() {
        return this.a(true, false).a();
    }
    
    public e e() {
        return this.a(false, true).a();
    }
    
    private f a(final boolean b, final boolean b2) {
        final f f = new f();
        final fj b3 = this.b();
        if (b3 != null) {
            final Object d = d(this);
            final q node = b3.getNode();
            if (node != null && node.a() > 0 && node.e() != null) {
                final bu d2 = b3.d();
                final HashSet<d> set = new HashSet<d>();
                if (b) {
                    final e k = node.k();
                    while (k.f()) {
                        if (d == d2.i(k.a()).zb && set.add(k.a())) {
                            f.add(k.a());
                        }
                        k.g();
                    }
                }
                if (b2) {
                    final e l = node.l();
                    while (l.f()) {
                        if (d == d2.i(l.a()).vb && set.add(l.a())) {
                            f.add(l.a());
                        }
                        l.g();
                    }
                }
            }
        }
        return f;
    }
    
    public boolean f() {
        return this.d;
    }
    
    public void a(final boolean d) {
        if (this.d != d) {
            this.d = d;
            final fj b = this.b();
            if (b != null) {
                final bu d2 = b.d();
                if (d2 != null) {
                    d2.e(this);
                }
            }
            if (this.c.f != null) {
                this.c.f.a(this);
            }
        }
    }
    
    public fP g() {
        return this.b;
    }
    
    public void a(final fP b) {
        this.b = b;
        this.i();
    }
    
    public t h() {
        final fP g = this.g();
        return g.a().a(this, g);
    }
    
    void i() {
        if (d(this) != null) {
            this.l();
            this.m();
        }
    }
    
    private void l() {
        final Iterator<eR> iterator = fM.a(this).iterator();
        while (iterator.hasNext()) {
            iterator.next().setOffsetDirty();
        }
    }
    
    private void m() {
        final bu d = this.b().d();
        if (d != null) {
            final t b = b(this);
            final e e = this.e();
            while (e.f()) {
                d.i(e.a()).setSourcePoint(b);
                e.g();
            }
            final e d2 = this.d();
            while (d2.f()) {
                d.i(d2.a()).setTargetPoint(b);
                d2.g();
            }
        }
    }
    
    public static eY j() {
        return eU.f;
    }
    
    static eU a(final bu bu, final d d, final boolean b) {
        return a(bu.i(d), b);
    }
    
    static t b(final eU eu) {
        final t h = eu.h();
        final fj b = eu.b();
        return new t(h.a() - b.getCenterX(), h.b() - b.getCenterY());
    }
    
    static void a(final eU eu, final t t) {
        a(eu, t.a(), t.b());
    }
    
    static void a(final eU eu, final double n, final double n2) {
        final fj b = eu.b();
        b(eu, b.getCenterX() + n, b.getCenterY() + n2);
    }
    
    static void b(final eU eu, final double n, final double n2) {
        eu.a(eu.g().a().a(eu.b(), new t(n, n2)));
    }
    
    static Rectangle2D c(final eU eu) {
        final y k = eu.k();
        return new Rectangle2D.Double(k.c(), k.d(), k.a(), k.b());
    }
    
    static Object d(final eU eu) {
        final fj b = eu.b();
        return (b == null) ? null : b.c(eu);
    }
    
    static int e(final eU eu) {
        final boolean z = fj.z;
        final fj b = eu.b();
        if (b != null) {
            int n = 0;
            final Iterator ports = b.ports();
            while (ports.hasNext()) {
                if (ports.next() == eu) {
                    return n;
                }
                ++n;
                if (z) {
                    break;
                }
            }
        }
        return -1;
    }
    
    static eU a(final fj fj, final double n, final double n2) {
        final boolean z = fj.z;
        final int portCount = fj.portCount();
        if (portCount > 0) {
            double n3 = Double.POSITIVE_INFINITY;
            int n4 = portCount;
            while (n4-- > 0) {
                final eU port = fj.getPort(n4);
                final t h = port.h();
                final double a = a(h.a(), h.b(), n, n2);
                if (n3 > a) {
                    n3 = a;
                    final eU eu = port;
                    if (!z && !z) {
                        continue;
                    }
                    return eu;
                }
            }
            goto Label_0096;
        }
        goto Label_0096;
    }
    
    static double a(final double n, final double n2, final double n3, final double n4) {
        final double n5 = n - n3;
        final double n6 = n2 - n4;
        return n5 * n5 + n6 * n6;
    }
    
    static boolean a(final eU eu, final fj fj) {
        return a(eu.b(), fj);
    }
    
    static boolean a(final fj fj, final fj fj2) {
        return fj == fj2 || (fj2 instanceof gd && fj == ((gd)fj2).e());
    }
    
    public boolean a(final double n, final double n2) {
        if (this.c.c == null) {
            return eU.g.a(this, n, n2);
        }
        return this.c.c.a(this, n, n2);
    }
    
    public boolean a(final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        if (this.c.d == null) {
            return eU.g.a(this, n, n2, n3, n4, point2D);
        }
        return this.c.d.a(this, n, n2, n3, n4, point2D);
    }
    
    public void a(final Graphics2D graphics2D) {
        if (this.c.b == null) {
            eU.g.a(this, graphics2D);
            if (!fj.z) {
                return;
            }
        }
        this.c.b.a(this, graphics2D);
    }
    
    public y k() {
        if (this.c.e == null) {
            return eU.g.a(this);
        }
        return this.c.e.a(this);
    }
    
    public void a(final Rectangle2D rectangle2D) {
        if (this.c.h == null) {
            eU.g.a(this, rectangle2D);
            if (!fj.z) {
                return;
            }
        }
        this.c.h.a(this, rectangle2D);
    }
    
    static boolean a(final eU eu, final Graphics2D graphics2D) {
        return eu.f() && hk.b(graphics2D);
    }
    
    static {
        f = new eY(null);
        g = new gq();
    }
}
