/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.C;
import y.c.y;
import y.f.X;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.bx;

public class D
implements bx {
    private Comparator a;

    public D() {
        this(null);
    }

    public D(Comparator comparator) {
        this.a(comparator);
    }

    public void a(Comparator comparator) {
        this.a = comparator;
    }

    @Override
    public void a(X x2, aU aU2, aV aV2, aP aP2) {
        boolean bl2 = N.x;
        int n2 = 0;
        do {
            if (n2 >= aU2.b()) return;
            y.c.D d2 = new y.c.D(aU2.a(n2).d().m());
            d2.sort(this.a);
            aU2.a(n2).a(d2);
            ++n2;
        } while (!bl2);
    }
}

