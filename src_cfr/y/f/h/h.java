/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import y.c.f;
import y.f.h.D;
import y.f.h.G;
import y.f.h.N;
import y.f.h.x;

public class H
implements x {
    x a = null;
    private int b = 0;
    private G c;

    public H(x x2) {
        if (x2 == null) {
            throw new IllegalArgumentException("You must specify a handler for non-planar graphs!");
        }
        this.a = x2;
        this.c = new G();
    }

    @Override
    public void a(D d2) {
        if (this.c.a(d2)) {
            this.b = 1;
            if (!N.d) return;
        }
        this.a.a(d2);
        this.b = 2;
    }

    @Override
    public f c_() {
        if (this.b == 0) {
            throw new RuntimeException("Invalid Execution Order: call 'createPlanarization' first!");
        }
        if (this.b != 1) return this.a.c_();
        return this.c.a();
    }
}

