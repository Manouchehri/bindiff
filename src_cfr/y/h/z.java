/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.ArrayList;
import java.util.BitSet;
import y.c.d;
import y.c.e;
import y.c.q;
import y.h.Y;
import y.h.a.v;
import y.h.am;
import y.h.fj;

final class Z
implements am {
    private final q a;
    private final e b;
    private final Y c;

    Z(Y y2, q q2, q q3) {
        this.c = y2;
        this.a = q2;
        this.b = q3.l();
        this.b.j();
    }

    @Override
    public boolean a() {
        boolean bl2;
        block3 : {
            boolean bl3 = fj.z;
            while (this.b.f()) {
                bl2 = this.c.f.isEmpty();
                if (!bl3) {
                    if (!bl2) break;
                    d d2 = this.b.a();
                    q q2 = this.c.a.n(d2.d());
                    if (!(d2.e() || q2 != Y.a(this.c) && this.c.b.get(q2.d()) || q2 == this.a)) {
                        this.c.b(d2);
                    }
                    this.b.h();
                    if (!bl3) continue;
                }
                break block3;
            }
            bl2 = this.b.f();
        }
        if (bl2) return false;
        return true;
    }
}

