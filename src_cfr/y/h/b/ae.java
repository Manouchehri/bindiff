/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.Cursor;
import java.awt.geom.Rectangle2D;
import y.c.q;
import y.d.r;
import y.h.b.a;
import y.h.b.aa;
import y.h.b.f;
import y.h.b.i;
import y.h.bu;
import y.h.c;
import y.h.cW;
import y.h.ch;
import y.h.dw;
import y.h.eD;
import y.h.eF;
import y.h.eR;
import y.h.fj;

abstract class ae
extends c
implements eF {
    ch h;
    a i;

    ae() {
    }

    @Override
    public void a(ch ch2, eD eD2, fj fj2) {
        if (fj2 instanceof a) {
            this.h = ch2;
            this.i = (a)fj2;
            if (a.H == 0) return;
        }
        this.h = null;
        this.i = null;
    }

    @Override
    public Cursor c(dw dw2) {
        return null;
    }

    @Override
    public void e() {
        this.i();
        super.e();
    }

    void i() {
        this.h = null;
        this.i = null;
    }

    boolean e(dw dw2) {
        if (dw2.e() != 1) return false;
        return true;
    }

    boolean f(dw dw2) {
        if (dw2.c() != 501) return false;
        if (!this.e(dw2)) return false;
        return true;
    }

    boolean g(dw dw2) {
        if (dw2.c() != 500) return false;
        if (dw2.f() != 1) return false;
        if (!this.e(dw2)) return false;
        return true;
    }

    boolean h(dw dw2) {
        if (dw2.c() != 500) return false;
        if (dw2.f() != 2) return false;
        if (!this.e(dw2)) return false;
        return true;
    }

    boolean a(a a2, y.h.b.c c2, double d2, double d3, boolean bl2) {
        if (bl2 && c2.k() == 0) {
            Rectangle2D rectangle2D;
            double d4 = a2.l().c(0).h().getY();
            if (d4 <= (rectangle2D = c2.h()).getY()) return false;
            rectangle2D.setFrame(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), d4 - rectangle2D.getY());
            return rectangle2D.contains(d2, d3);
        }
        r r2 = c2.i();
        if (r2.a <= 0.0) return false;
        Rectangle2D rectangle2D = c2.h();
        rectangle2D.setFrame(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), r2.a);
        return rectangle2D.contains(d2, d3);
    }

    boolean a(a a2, f f2, double d2, double d3, boolean bl2) {
        if (bl2 && f2.n() == 0) {
            Rectangle2D rectangle2D;
            double d4 = a2.l().b(0).h().getX();
            if (d4 <= (rectangle2D = f2.h()).getX()) return false;
            rectangle2D.setFrame(rectangle2D.getX(), rectangle2D.getY(), d4 - rectangle2D.getX(), rectangle2D.getHeight());
            return rectangle2D.contains(d2, d3);
        }
        r r2 = f2.i();
        if (r2.b <= 0.0) return false;
        Rectangle2D rectangle2D = f2.h();
        rectangle2D.setFrame(rectangle2D.getX(), rectangle2D.getY(), r2.b, rectangle2D.getHeight());
        return rectangle2D.contains(d2, d3);
    }

    q a(cW cW2) {
        if (cW2.t()) {
            return cW2.i();
        }
        if (!cW2.s()) return null;
        return cW2.l().f();
    }

    static fj a(bu bu2, q q2) {
        return aa.a(bu2, q2);
    }
}

