/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.x;
import y.d.q;
import y.d.t;
import y.d.y;
import y.f.X;
import y.f.aj;
import y.f.i.v;
import y.f.i.w;

class B {
    private X a;
    private y.c.y b;

    private B(X x2) {
        this.a = x2;
        this.b = new y.c.y();
    }

    public y.c.y a() {
        B b2;
        int n2 = v.f;
        this.b();
        x x2 = this.a.o();
        block0 : do {
            boolean bl2 = x2.f();
            block1 : while (bl2) {
                y.c.q q2 = x2.e();
                y y2 = this.a.s(q2);
                b2 = this;
                if (n2 != 0) return b2.b;
                aj[] arraj = b2.a.a_(x2.e());
                if (arraj != null && arraj.length > 0) {
                    for (int i2 = 0; i2 < arraj.length; ++i2) {
                        aj aj2 = arraj[i2];
                        y y3 = aj2.getBox();
                        bl2 = this.a(y2, y3, 3.0);
                        if (n2 != 0) continue block1;
                        if (bl2) continue;
                        y.c.q q3 = this.a.d();
                        this.a.a(q3, y3);
                        this.a.b(q3, y3.e());
                        this.b.add(q3);
                        if (n2 == 0) continue;
                    }
                }
                x2.g();
                if (n2 == 0) continue block0;
            }
            break block0;
            break;
        } while (true);
        b2 = this;
        return b2.b;
    }

    private boolean a(y y2, y y3, double d2) {
        if (y2.d() >= y3.d() + d2) return false;
        if (y2.c() >= y3.c() + d2) return false;
        if (y2.d() + y2.b() <= y3.d() + y3.b() - d2) return false;
        if (y2.c() + y2.a() <= y3.c() + y3.a() - d2) return false;
        return true;
    }

    public void b() {
        int n2 = v.f;
        if (this.b.isEmpty()) return;
        x x2 = this.b.a();
        while (x2.f()) {
            this.a.a(x2.e());
            x2.g();
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        this.b.clear();
    }

    B(X x2, w w2) {
        this(x2);
    }
}

