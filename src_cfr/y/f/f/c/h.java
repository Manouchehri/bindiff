/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import y.c.A;
import y.c.C;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.q;
import y.c.x;
import y.f.f.c.g;
import y.f.f.c.i;
import y.f.f.c.j;
import y.f.f.c.l;
import y.f.f.c.o;
import y.f.f.c.p;
import y.g.M;

public class h
implements l {
    @Override
    public void a(y.f.f.b.h h2, p p2, p p3) {
        y.g.o.a(this, 3, "Flow Compaction");
        this.a(p2);
        this.a(p3);
    }

    public void a(p p2) {
        int n2;
        y.c.h h2;
        Object object;
        Object object2;
        int[] arrn;
        Object object3;
        y.c.i i2;
        Object object4;
        int n3;
        f f2;
        block9 : {
            int n4;
            block8 : {
                n3 = g.a;
                i2 = p2.f();
                arrn = new int[i2.f()];
                h2 = i2.u();
                f2 = new f();
                n4 = 0;
                e e2 = i2.p();
                while (e2.f()) {
                    object2 = e2.a();
                    h2.a(object2, (int)p2.b((d)object2));
                    object4 = p2.c((d)object2);
                    int[] arrn2 = arrn;
                    int n5 = object2.c().d();
                    arrn2[n5] = arrn2[n5] - object4;
                    int[] arrn3 = arrn;
                    int n6 = object2.d().d();
                    arrn3[n6] = arrn3[n6] + object4;
                    n4 += object4;
                    e2.g();
                    if (n3 == 0) {
                        if (n3 == 0) continue;
                        y.c.i.g = !y.c.i.g;
                        break;
                    }
                    break block8;
                }
                y.g.o.a(this, (Object)new StringBuffer().append("Total weight: ").append(n4).toString());
            }
            n2 = n4 + 1;
            object2 = i2.o();
            while (object2.f()) {
                q q2 = object2.e();
                int[] arrn4 = arrn;
                int n7 = q2.d();
                arrn4[n7] = arrn4[n7] + (n2 * q2.c() - n2 * q2.b());
                object2.g();
                if (n3 == 0) {
                    if (n3 == 0) continue;
                }
                break block9;
            }
            object2 = i2.o();
        }
        while (object2.f()) {
            object4 = p2.b(object2.e());
            object = p2.a((g)object4);
            if (object != null && object.a() == object4) {
                object3 = i2.a(object.b().a(), object.a().a());
                h2.a(object3, (int)object.c());
                f2.add(object3);
            }
            object2.g();
            if (n3 == 0) continue;
        }
        object2 = new i(this, n2);
        object4 = new j(this);
        object = M.a(arrn);
        object3 = i2.u();
        A a2 = i2.t();
        y.a.l.a(i2, (c)object4, (c)object2, (c)h2, (c)object, (y.c.h)object3, a2);
        C c2 = i2.o();
        while (c2.f()) {
            g g2 = p2.b(c2.e());
            g2.a(a2.a(c2.e()));
            c2.g();
            if (n3 == 0) continue;
        }
        c2 = f2.a();
        while (c2.f()) {
            i2.a(c2.a());
            c2.g();
            if (n3 != 0) return;
            if (n3 == 0) continue;
        }
        i2.a(h2);
        i2.a((y.c.h)object3);
        i2.a(a2);
    }
}

