/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import java.util.Collection;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.f.f.a.a.p;
import y.f.f.a.b.a;
import y.f.f.a.b.l;
import y.f.f.a.b.o;

public class x
implements l {
    private f a = new f();
    private i b;

    @Override
    public f a() {
        return this.a;
    }

    @Override
    public void a(a a2) {
        e e2;
        o o2;
        boolean bl2;
        block3 : {
            bl2 = a.c;
            this.b = a2.d();
            this.a.clear();
            o2 = new o(a2.d(), a2.b());
            o2.d();
            this.a.addAll(o2.b());
            e2 = this.a.a();
            while (e2.f()) {
                this.b.d(e2.a());
                e2.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            e2 = o2.c().a();
        }
        while (e2.f()) {
            a2.k(e2.a());
            e2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        o2.a();
    }
}

