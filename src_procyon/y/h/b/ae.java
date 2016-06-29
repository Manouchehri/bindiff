package y.h.b;

import java.awt.*;
import java.awt.geom.*;
import y.d.*;
import y.c.*;
import y.h.*;

abstract class ae extends c implements eF
{
    ch h;
    a i;
    
    public void a(final ch h, final eD ed, final fj fj) {
        if (fj instanceof a) {
            this.h = h;
            this.i = (a)fj;
            if (y.h.b.a.H == 0) {
                return;
            }
        }
        this.h = null;
        this.i = null;
    }
    
    public Cursor c(final dw dw) {
        return null;
    }
    
    public void e() {
        this.i();
        super.e();
    }
    
    void i() {
        this.h = null;
        this.i = null;
    }
    
    boolean e(final dw dw) {
        return dw.e() == 1;
    }
    
    boolean f(final dw dw) {
        return dw.c() == 501 && this.e(dw);
    }
    
    boolean g(final dw dw) {
        return dw.c() == 500 && dw.f() == 1 && this.e(dw);
    }
    
    boolean h(final dw dw) {
        return dw.c() == 500 && dw.f() == 2 && this.e(dw);
    }
    
    boolean a(final a a, final y.h.b.c c, final double n, final double n2, final boolean b) {
        if (b && c.k() == 0) {
            final double y = a.l().c(0).h().getY();
            final Rectangle2D h = c.h();
            if (y > h.getY()) {
                h.setFrame(h.getX(), h.getY(), h.getWidth(), y - h.getY());
                return h.contains(n, n2);
            }
        }
        else {
            final r i = c.i();
            if (i.a > 0.0) {
                final Rectangle2D h2 = c.h();
                h2.setFrame(h2.getX(), h2.getY(), h2.getWidth(), i.a);
                return h2.contains(n, n2);
            }
        }
        return false;
    }
    
    boolean a(final a a, final f f, final double n, final double n2, final boolean b) {
        if (b && f.n() == 0) {
            final double x = a.l().b(0).h().getX();
            final Rectangle2D h = f.h();
            if (x > h.getX()) {
                h.setFrame(h.getX(), h.getY(), x - h.getX(), h.getHeight());
                return h.contains(n, n2);
            }
        }
        else {
            final r i = f.i();
            if (i.b > 0.0) {
                final Rectangle2D h2 = f.h();
                h2.setFrame(h2.getX(), h2.getY(), i.b, h2.getHeight());
                return h2.contains(n, n2);
            }
        }
        return false;
    }
    
    q a(final cW cw) {
        if (cw.t()) {
            return cw.i();
        }
        if (cw.s()) {
            return cw.l().f();
        }
        return null;
    }
    
    static fj a(final bu bu, final q q) {
        return aa.a(bu, q);
    }
}
