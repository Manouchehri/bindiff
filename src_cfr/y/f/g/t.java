/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.c.D;
import y.d.m;
import y.d.o;
import y.d.q;
import y.d.s;
import y.d.u;
import y.d.v;
import y.d.y;
import y.f.C;
import y.f.E;
import y.f.I;
import y.f.aj;
import y.f.al;
import y.f.am;
import y.f.g.d;
import y.f.g.n;

class t
implements o {
    Object a;
    Object b;
    byte c;
    private final n d;

    t(n n2, Object object, Object object2, byte by2) {
        this.d = n2;
        this.a = object;
        this.b = object2;
        this.c = by2;
    }

    public boolean a() {
        if (this.c == 2) return true;
        if (this.c == 3) return true;
        return false;
    }

    public void a(double d2, double d3) {
        Object object;
        boolean bl2 = d.d;
        if (this.c == 1) {
            block3 : {
                object = n.b(this.d).j((y.c.d)this.a);
                D d4 = new D();
                u u2 = object.b();
                while (u2.f()) {
                    y.d.t t2 = u2.a();
                    d4.add(new y.d.t(t2.a + d2, t2.b + d3));
                    u2.g();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block3;
                }
                n.b(this.d).b((y.c.d)this.a, d4);
            }
            if (!bl2) return;
        }
        if (this.c != 0) return;
        object = n.b(this.d).o((y.c.q)this.a);
        n.b(this.d).b((y.c.q)this.a, new y.d.t(object.a + d2, object.b + d3));
    }

    @Override
    public y h() {
        boolean bl2 = d.d;
        if (this.c == 1) {
            double d2 = Double.MAX_VALUE;
            double d3 = Double.MAX_VALUE;
            double d4 = -1.7976931348623157E308;
            double d5 = -1.7976931348623157E308;
            v v2 = n.b(this.d).l((y.c.d)this.a);
            u u2 = v2.b();
            do {
                if (!u2.f()) return new y(d2, d3, d4 - d2, d5 - d3);
                y.d.t t2 = u2.a();
                d2 = Math.min(d2, t2.a);
                d3 = Math.min(d3, t2.b);
                d4 = Math.max(d4, t2.a);
                d5 = Math.max(d5, t2.b);
                u2.g();
            } while (!bl2);
            return new y(d2, d3, d4 - d2, d5 - d3);
        }
        if (this.c == 3) {
            y.c.d d6 = (y.c.d)this.b;
            C c2 = (C)this.a;
            y.d.n n2 = c2.getLabelModel().a(c2.getOrientedBox().d(), n.b(this.d).b(d6), n.b(this.d).a(d6.c()), n.b(this.d).a(d6.d()), c2.getModelParameter());
            return n2.h();
        }
        if (this.c == 2) {
            y.c.q q2 = (y.c.q)this.b;
            aj aj2 = (aj)this.a;
            y.d.n n3 = aj2.a().a(aj2.getOrientedBox().d(), n.b(this.d).a(q2), aj2.getModelParameter());
            return n3.h();
        }
        am am2 = n.b(this.d).a(this.a);
        return new y(am2.getX(), am2.getY(), am2.getWidth(), am2.getHeight());
    }

    public boolean a(y y2) {
        boolean bl2 = d.d;
        if (this.c != 1) return y.a(y2, this.h());
        v v2 = n.b(this.d).l((y.c.d)this.a);
        s s2 = v2.j();
        do {
            if (!s2.f()) return false;
            m m2 = s2.a();
            boolean bl3 = m2.a(y2);
            if (bl2) return bl3;
            if (bl3) {
                return true;
            }
            s2.g();
        } while (!bl2);
        return false;
    }
}

