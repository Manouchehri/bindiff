/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.c.D;
import y.d.t;
import y.f.g.u;

class q {
    final int a;
    final int b;
    final int c;
    final D d;

    private q(t t2, int n2) {
        this.a = (int)t2.a;
        this.b = (int)t2.b;
        this.c = n2;
        this.d = new D();
    }

    q(t t2, int n2, u u2) {
        this(t2, n2);
        this.d.add(u2);
    }

    q(t t2, int n2, u u2, u u3) {
        this(t2, n2);
        this.d.add(u2);
        this.d.add(u3);
    }
}

