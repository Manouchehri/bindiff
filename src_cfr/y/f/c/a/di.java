/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.A;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.h;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.c.R;
import y.f.c.a.N;
import y.f.c.a.Z;
import y.f.c.a.aQ;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aY;
import y.f.c.a.bK;
import y.f.c.a.dj;
import y.f.c.a.dl;
import y.f.c.a.dn;
import y.g.M;

class di
implements R {
    private aT a;

    public di(aT aT2) {
        if (aT2 == null) {
            throw new NullPointerException();
        }
        this.a = aT2;
    }

    @Override
    public int a(X x2, A a2, f f2) {
        Object object;
        boolean bl2;
        Object object2;
        int n2;
        block6 : {
            bl2 = N.x;
            A a3 = M.a();
            h h2 = M.b();
            dl dl2 = new dl(a3, h2);
            object2 = x2.o();
            while (object2.f()) {
                q q2 = object2.e();
                object = new dj(null, null, null);
                a3.a((Object)q2, object);
                object2.g();
                if (!bl2) continue;
            }
            object2 = new dn(dl2);
            this.a.a(x2, (aU)object2, dl2);
            int n3 = 0;
            while (n3 < object2.b()) {
                block7 : {
                    object = object2.a(n3);
                    if (bl2) break block6;
                    x x3 = object.d().a();
                    while (x3.f()) {
                        q q3 = x3.e();
                        a2.a((Object)q3, n3);
                        x3.g();
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block7;
                    }
                    ++n3;
                }
                if (!bl2) continue;
            }
            f2.clear();
        }
        e e2 = x2.p();
        while (e2.f()) {
            object = e2.a();
            n2 = a2.a(object.c());
            if (bl2) return n2;
            if (n2 > a2.a(object.d())) {
                x2.c((d)object);
                f2.add(object);
            }
            e2.g();
            if (!bl2) continue;
        }
        n2 = object2.b();
        return n2;
    }
}

