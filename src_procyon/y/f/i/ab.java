package y.f.i;

import y.g.*;
import java.util.*;
import java.awt.geom.*;
import y.c.*;
import y.f.*;

public class ab extends a
{
    private int a;
    
    public ab(final ah ah) {
        this.a = 200;
        this.a(ah);
    }
    
    public void c(final X x) {
        final int f = v.f;
        final v c = this.c();
        if (c == null) {
            throw new IllegalStateException("No OrthogonalEdgeRouter in coreLayouter");
        }
        if (!this.a(x, c)) {
            this.a().c(x);
            return;
        }
        final y y = new y();
        Label_0281: {
            Label_0183: {
                if (c.p() == 4) {
                    final c c2 = x.c(c.b());
                    if (c2 != null) {
                        final x o = x.o();
                        while (o.f()) {
                            Label_0178: {
                                if (c2.d(o.e())) {
                                    y.add(o.e());
                                    final x m = o.e().m();
                                    while (m.f()) {
                                        y.add(m.e());
                                        m.g();
                                        if (f != 0) {
                                            break Label_0178;
                                        }
                                        if (f != 0) {
                                            break;
                                        }
                                    }
                                }
                                o.g();
                            }
                            if (f != 0) {
                                break Label_0183;
                            }
                        }
                    }
                    break Label_0281;
                }
            }
            if (c.p() == 2) {
                final c c3 = x.c(c.c());
                if (c3 != null) {
                    final e p = x.p();
                    while (p.f()) {
                        if (c3.d(p.a())) {
                            y.add(p.a().c());
                            y.add(p.a().d());
                        }
                        p.g();
                        if (f != 0) {
                            break;
                        }
                    }
                }
            }
        }
        final Rectangle2D a = ae.a(x, y.a());
        final double n = Math.max(5 * c.t(), 50);
        a.setFrame(a.getX() - n, a.getY() - n, a.getWidth() + 2.0 * n, a.getHeight() + 2.0 * n);
        final I i = new I(x);
        final HashSet set = new HashSet<q>();
        final e p2 = x.p();
        while (true) {
            while (p2.f()) {
                final d a2 = p2.a();
                final X x2 = x;
                if (f != 0) {
                    final x o2 = x2.o();
                    while (true) {
                        while (o2.f()) {
                            final q e = o2.e();
                            final X x3 = x;
                            if (f != 0) {
                                final q d = x3.d();
                                x.b(d, 10.0, 20.0 + a.getHeight());
                                x.c(d, a.getX() - 10.0, a.getY() - 10.0);
                                final q d2 = x.d();
                                x.b(d2, 10.0, 20.0 + a.getHeight());
                                x.c(d2, a.getX() + a.getWidth(), a.getY() - 10.0);
                                final q d3 = x.d();
                                x.b(d3, 20.0 + a.getWidth(), 10.0);
                                x.c(d3, a.getX() - 10.0, a.getY() - 10.0);
                                final q d4 = x.d();
                                x.b(d4, 20.0 + a.getWidth(), 10.0);
                                x.c(d4, a.getX() - 10.0, a.getY() + a.getHeight());
                                this.a().c(x);
                                x.a(d);
                                x.a(d2);
                                x.a(d3);
                                x.a(d4);
                                i.f();
                                return;
                            }
                            final am h = x.h(e);
                            if (!a.intersects(h.getX(), h.getY(), h.getWidth(), h.getHeight()) && !set.contains(e)) {
                                i.a(e);
                            }
                            o2.g();
                            if (f != 0) {
                                break;
                            }
                        }
                        final X x3 = x;
                        continue;
                    }
                }
                Label_0448: {
                    if (ae.a(x, a2, a)) {
                        set.add(a2.c());
                        set.add(a2.d());
                        if (f == 0) {
                            break Label_0448;
                        }
                    }
                    i.a(a2);
                }
                p2.g();
                if (f != 0) {
                    break;
                }
            }
            final X x2 = x;
            continue;
        }
    }
    
    public int b() {
        return this.a;
    }
    
    v c() {
        final int f = v.f;
        ah ah = this.a();
        while (ah instanceof ad) {
            if (ah instanceof v) {
                return (v)ah;
            }
            ah = ((v)ah).a();
            if (f != 0) {
                break;
            }
        }
        return null;
    }
    
    boolean a(final X x, final v v) {
        return v.p() != 0 && x.e() + x.g() >= this.b();
    }
}
