/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import y.c.C;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.f.f.a.a.b;
import y.f.f.a.a.c;
import y.f.f.a.a.f;
import y.f.f.a.b.a;

public class n
extends c {
    protected y.c.f c = new y.c.f();

    public void a(d d2) {
        this.c.add(d2);
    }

    public void a(i i2) {
        C c2;
        boolean bl2;
        block3 : {
            bl2 = a.c;
            c2 = this.c.a();
            while (c2.f()) {
                i2.d(c2.a());
                c2.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            c2 = this.a.a();
        }
        do {
            if (!c2.f()) return;
            b b2 = (b)c2.d();
            i2.c(b2.b_());
            c2.g();
        } while (!bl2);
    }

    public void b(i i2) {
        boolean bl2 = a.c;
        C c2 = this.a.a();
        while (c2.f()) {
            b b2 = (b)c2.d();
            i2.d(b2.b_());
            c2.g();
            if (!bl2) continue;
        }
        c2 = this.c.a();
        do {
            if (!c2.f()) return;
            i2.e(c2.a());
            c2.g();
        } while (!bl2);
    }

    public String toString() {
        return this.c.toString();
    }
}

