/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import y.d.t;
import y.f.k.P;
import y.f.k.V;
import y.f.k.Y;

class X
extends V {
    X() {
        super(null);
    }

    X(P p2, P p3) {
        super(p3);
        Y y2 = new Y();
        y2.a(new t(p2.f(), p2.g()));
        y2.a(new t(p2.e(), p2.d()));
        this.a(y2);
        y2 = new Y();
        y2.a(new t(p3.f(), p3.g()));
        y2.a(new t(p3.e(), p3.d()));
        this.a(y2);
    }
}

