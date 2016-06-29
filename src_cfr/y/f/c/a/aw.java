/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.a.h;
import y.c.A;
import y.c.c;
import y.c.i;
import y.c.q;
import y.c.y;
import y.f.X;
import y.f.c.a.N;
import y.f.c.a.aS;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.x;
import y.g.J;
import y.g.e;

public class aW
implements aT {
    private aT a;
    private aS b;
    private Comparator c;

    public aW(aT aT2) {
        this(aT2, new x(), null);
    }

    public aW(aT aT2, aS aS2, Comparator comparator) {
        if (aT2 == null) throw new NullPointerException();
        if (aS2 == null) {
            throw new NullPointerException();
        }
        this.c = comparator;
        this.b = aS2;
        this.a = aT2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(X x2, aU aU2, aV aV2) {
        boolean bl2 = N.x;
        aT aT2 = this.a();
        aS aS2 = this.b();
        A a2 = x2.t();
        try {
            int n2;
            Object object;
            y[] arry;
            block8 : {
                n2 = h.a((i)x2, a2);
                if (n2 == 1) {
                    aT2.a(x2, aU2, aV2);
                    if (!bl2) return;
                }
                arry = new y[n2];
                for (int i2 = 0; i2 < arry.length; ++i2) {
                    arry[i2] = new y();
                    if (bl2) return;
                    if (!bl2) continue;
                }
                object = x2.o();
                while (object.f()) {
                    arry[a2.a(object.e())].add(object.e());
                    object.g();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block8;
                }
                this.a(arry, a2);
            }
            object = new J(x2, a2);
            for (int i3 = 0; i3 < n2; ++i3) {
                Object object2 = a2.b(arry[i3].b());
                object.c(object2);
                aU aU3 = aU2.a();
                aT2.a(x2, aU3, aV2);
                aS2.a(x2, aV2, aU3, aU2);
                if (bl2) return;
                if (!bl2) continue;
            }
            object.b();
            return;
        }
        finally {
            x2.a(a2);
        }
    }

    protected void a(y[] arry, c c2) {
        Comparator comparator = this.c();
        if (comparator == null) return;
        e.a(arry, comparator);
    }

    public aT a() {
        return this.a;
    }

    public aS b() {
        return this.b;
    }

    public Comparator c() {
        return this.c;
    }
}

