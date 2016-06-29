/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.H;
import y.a.h;

final class I {
    public H a;
    public H b;

    I() {
    }

    public void a(H h2) {
        h2.b = null;
        h2.a = null;
        if (this.b == null) {
            this.a = this.b = h2;
            if (!h.a) return;
        }
        this.b.a = h2;
        h2.b = this.b;
        this.b = h2;
    }

    public void b(H h2) {
        boolean bl2;
        block3 : {
            bl2 = h.a;
            if (h2 != this.a) {
                h2.b.a = h2.a;
                if (!bl2) break block3;
            }
            this.a = h2.a;
        }
        if (h2 != this.b) {
            h2.a.b = h2.b;
            if (!bl2) return;
        }
        this.b = h2.b;
    }
}

