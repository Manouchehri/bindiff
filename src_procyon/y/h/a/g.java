package y.h.a;

import y.h.*;
import java.awt.geom.*;
import y.d.*;
import y.c.*;

final class g implements a
{
    final e a;
    
    public g(final e a) {
        this.a = a;
    }
    
    public void setAutoBoundsEnabled(final boolean b) {
        final int a = v.a;
        if (!e.a(this.a) && b) {
            if (!this.a.isGroupClosed() && !this.a()) {
                final f m = e.b(this.a).m;
                final Rectangle2D f = m.f(this.a);
                final double n = f.getX() + f.getWidth();
                final double n2 = f.getY() + f.getHeight();
                e.a(this.a, (e.c(this.a) + e.d(this.a) > n) ? (e.e(this.a) + e.f(this.a) - n) : 0.0);
                e.b(this.a, (e.g(this.a) < f.getY()) ? (f.getY() - e.h(this.a)) : 0.0);
                e.c(this.a, (e.i(this.a) + e.j(this.a) > n2) ? (e.k(this.a) + e.l(this.a) - n2) : 0.0);
                e.d(this.a, (e.m(this.a) < f.getX()) ? (f.getX() - e.n(this.a)) : 0.0);
                e.a(this.a, b);
                m.c(this.a);
                if (a == 0) {
                    return;
                }
            }
            e.a(this.a, b);
            if (a == 0) {
                return;
            }
        }
        e.a(this.a, b);
    }
    
    public boolean isAutoBoundsEnabled() {
        return this.a.g() && !this.a.isGroupClosed();
    }
    
    public Rectangle2D getMinimalAutoBounds() {
        final f m = e.o(this.a).m;
        if (m != null) {
            return m.f(this.a);
        }
        final Rectangle2D.Double double1 = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        this.a.calcUnionRect(double1);
        return double1;
    }
    
    public void setAutoBoundsInsets(final r r) {
        this.a.b(r);
    }
    
    public r getAutoBoundsInsets() {
        final f m = e.p(this.a).m;
        if (m != null) {
            return m.h(this.a);
        }
        return new r(0.0, 0.0, 0.0, 0.0);
    }
    
    private boolean a() {
        final q node = this.a.getNode();
        if (node == null) {
            return true;
        }
        final v b = this.b();
        return b == null || !b.p(node).f();
    }
    
    private v b() {
        final q node = this.a.getNode();
        if (node == null) {
            return null;
        }
        return v.a(node.e());
    }
}
