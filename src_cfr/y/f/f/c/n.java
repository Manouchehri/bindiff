/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import y.a.u;
import y.c.A;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.q;
import y.c.x;
import y.f.f.b.h;
import y.f.f.c.g;
import y.f.f.c.k;
import y.f.f.c.l;
import y.f.f.c.o;
import y.f.f.c.p;

public class n
implements l {
    private boolean a = false;

    @Override
    public void a(h h2, p p2, p p3) {
        y.g.o.a(this, 3, "Simplex Compaction");
        this.a(p2);
        this.a(p3);
    }

    public void a(boolean bl2) {
        this.a = bl2;
    }

    public void a(p p2) {
        int n2;
        block15 : {
            Object object;
            i i2;
            A a2;
            y.c.h h2;
            Object object2;
            y.c.h h3;
            A a3;
            block14 : {
                block13 : {
                    block12 : {
                        n2 = g.a;
                        i2 = p2.f();
                        h3 = i2.u();
                        h2 = i2.u();
                        a2 = i2.t();
                        a3 = i2.t();
                        object2 = i2.o();
                        while (object2.f()) {
                            a3.a((Object)object2.e(), new f());
                            object2.g();
                            if (n2 == 0) {
                                if (n2 == 0) continue;
                            }
                            break block12;
                        }
                        object2 = i2.p();
                        while (object2.f()) {
                            h2.a((Object)object2.a(), (int)p2.b(object2.a()));
                            h3.a((Object)object2.a(), p2.c(object2.a()));
                            object2.g();
                            if (n2 == 0) {
                                if (n2 == 0) continue;
                            }
                            break block12;
                        }
                        if (!this.a) {
                            object2 = new k();
                            object2.a(p2);
                        }
                    }
                    object2 = i2.o();
                    while (object2.f()) {
                        a2.a((Object)object2.e(), p2.b(object2.e()).i());
                        object2.g();
                        if (n2 == 0) {
                            if (n2 == 0) continue;
                        }
                        break block13;
                    }
                    object2 = i2.o();
                }
                while (object2.f()) {
                    object = object2.e();
                    g g2 = p2.b((q)object);
                    o o2 = p2.a(g2);
                    if (n2 == 0) {
                        if (o2 != null && o2.a == g2) {
                            d d2 = object.a(o2.b.a());
                            h3.a((Object)d2, 20000);
                        }
                        object2.g();
                        if (n2 == 0) continue;
                    }
                    break block14;
                }
                u.a(i2, a2, h3, h2);
            }
            object2 = i2.o();
            while (object2.f()) {
                object = p2.b(object2.e());
                object.a(a2.a(object2.e()));
                object2.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block15;
            }
            i2.a(a2);
            i2.a(a3);
            i2.a(h3);
            i2.a(h2);
        }
        if (!i.g) return;
        g.a = ++n2;
    }
}

