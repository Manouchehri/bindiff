/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import java.util.HashMap;
import java.util.Map;
import y.a.h;
import y.c.C;
import y.c.b;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;

class aa
extends i {
    Map a;
    Map b;

    public aa(i i2) {
        boolean bl2;
        C c2;
        i i3;
        block3 : {
            bl2 = h.a;
            this.b = new HashMap();
            this.a = new HashMap();
            c2 = i2.o();
            while (c2.f()) {
                q q2 = this.d();
                this.b.put(q2, c2.e());
                i3 = this;
                if (!bl2) {
                    i3.a.put(c2.e(), q2);
                    c2.g();
                    if (!bl2) continue;
                }
                break block3;
            }
            i3 = i2;
        }
        c2 = i3.p();
        do {
            if (!c2.f()) return;
            d d2 = c2.a();
            d d3 = this.a((q)this.a.get(d2.c()), (q)this.a.get(d2.d()));
            this.b.put(d3, d2);
            this.a.put(d2, d3);
            c2.g();
        } while (!bl2);
    }

    public void a(C c2, c c3, b b2) {
        boolean bl2 = h.a;
        do {
            if (!c2.f()) return;
            Object object = c2.d();
            b2.a(object, c3.a(this.b.get(object)));
            c2.g();
        } while (!bl2);
    }

    public void b(C c2, c c3, b b2) {
        boolean bl2 = h.a;
        do {
            if (!c2.f()) return;
            Object object = c2.d();
            b2.a(object, c3.c(this.b.get(object)));
            c2.g();
        } while (!bl2);
    }

    public void c(C c2, c c3, b b2) {
        boolean bl2 = h.a;
        do {
            if (!c2.f()) return;
            Object object = c2.d();
            b2.a(object, c3.a(this.a.get(object)));
            c2.g();
        } while (!bl2);
    }
}

