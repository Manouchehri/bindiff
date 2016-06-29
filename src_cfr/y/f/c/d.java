/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import y.c.A;
import y.c.c;
import y.c.f;
import y.c.i;
import y.c.q;
import y.f.X;
import y.f.c.R;
import y.f.c.a;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.ba;
import y.f.c.w;
import y.g.e;

public class D
implements R,
aT {
    public static final Object a = "y.layout.hierarchic.GivenLayersLayerer.LAYER_ID_KEY";

    public int a(i i2, c c2, y.c.a a2) {
        int n2;
        int n3;
        int n4;
        boolean bl2 = a.i;
        if (i2.i()) {
            return 0;
        }
        Object[] arrobject = i2.m();
        e.a(arrobject, e.b(c2));
        int n5 = n2 = c2.a(arrobject[0]);
        int n6 = n2;
        for (int i3 = 0; i3 < arrobject.length; ++i3) {
            int n7 = c2.a(arrobject[i3]);
            n3 = n7 - n5;
            n4 = 1;
            if (bl2) return n3 + n4;
            if (n3 > n4) {
                n6 += n7 - n5 - 1;
            }
            a2.a(arrobject[i3], n7 - n6);
            n5 = n7;
            if (!bl2) continue;
        }
        n3 = n5 - n6;
        n4 = 1;
        return n3 + n4;
    }

    @Override
    public int a(X x2, A a2, f f2) {
        if (x2.i()) {
            return 0;
        }
        c c2 = x2.c(a);
        if (c2 == null) {
            throw new IllegalArgumentException("Given graph does not yield LAYER_ID_KEY DataProvider");
        }
        int n2 = this.a((i)x2, c2, a2);
        f2.a(w.a(x2, a2));
        return n2;
    }

    @Override
    public void a(X x2, aU aU2, aV aV2) {
        new ba(this).a(x2, aU2, aV2);
    }
}

