/*
 * Decompiled with CFR 0_115.
 */
package y.f.b;

import java.util.Collection;
import y.c.i;
import y.c.q;
import y.c.y;
import y.f.b.c;
import y.f.b.j;
import y.g.I;

class l {
    private c a;
    private I b;
    private final j c;

    l(j j2, i i2, c c2) {
        this.c = j2;
        this.a = c2;
        this.b = new I(i2);
    }

    public void a(q q2) {
        int n2 = c.a;
        this.b.a();
        if (q2 == null || j.a(this.c, q2)) {
            y y2 = new y();
            y y3 = new y(this.a.b(q2));
            do {
                if (y3.isEmpty()) return;
                q q3 = y3.d();
                y2.add(q3);
                if (j.a(this.c, q3, this.a) && !j.a(this.c, q3)) {
                    y3.addAll(this.a.b(q3));
                }
                this.b.a(y2, true);
            } while (n2 == 0);
        }
        this.b.a(q2, false);
    }

    public void a() {
        this.b.f();
    }
}

