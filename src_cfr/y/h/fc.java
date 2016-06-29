/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.d.t;
import y.h.fB;
import y.h.fj;

final class fC {
    final fB a;
    final fB b;
    private boolean c;

    fC(t t2, double d2, double d3) {
        this.a = new fB(this, t2.a(), d2);
        this.b = new fB(this, t2.b(), d3);
        this.c = true;
    }

    boolean a() {
        return this.c;
    }

    void b() {
        this.c = false;
    }

    void a(double d2, double d3, byte by2) {
        switch (by2) {
            case 0: {
                this.b.b(d3);
                if (!fj.z) return;
            }
            case 1: {
                this.a.b(d2);
            }
        }
    }
}

