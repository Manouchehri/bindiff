/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import y.c.q;
import y.c.x;
import y.f.X;
import y.f.k.d;

class U {
    X a;
    q b;

    public U(X x2) {
        this.a = x2;
        this.b();
    }

    public q a() {
        if (this.b != null) return this.b;
        this.b();
        return this.b;
    }

    public boolean a(q q2) {
        if (q2.c() != 0) return false;
        return true;
    }

    private void b() {
        int n2 = d.g;
        x x2 = this.a.o();
        do {
            if (!x2.f()) return;
            if (x2.e().b() == 0) {
                this.b = x2.e();
                return;
            }
            x2.g();
        } while (n2 == 0);
    }
}

