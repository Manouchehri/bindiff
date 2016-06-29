/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import java.util.Comparator;
import y.c.C;
import y.c.D;
import y.c.p;
import y.d.g;
import y.d.h;
import y.d.i;
import y.d.k;
import y.d.l;
import y.d.o;
import y.d.t;
import y.d.y;
import y.g.al;
import y.g.e;

public class f {
    public static void a(D d2, g g2) {
        Object object;
        Object object2;
        boolean bl2 = t.d;
        k[] arrk = f.a(d2);
        al al2 = new al();
        double d3 = Double.MAX_VALUE;
        double d4 = -1.7976931348623157E308;
        for (object2 = d2.k(); object2 != null; object2 = object2.a()) {
            object = ((o)object2.c()).h();
            double d5 = object.b;
            if (d5 < 0.0) continue;
            d3 = Math.min(d3, object.d);
            d4 = Math.max(d4, object.d + d5);
            if (!bl2) continue;
        }
        object2 = new l(d3, d4, 15);
        object = new al();
        int n2 = 0;
        do {
            if (n2 >= arrk.length) return;
            k k2 = arrk[n2];
            switch (k2.b) {
                case 0: {
                    object2.a(k2.c, g2);
                    object2.a(k2.c);
                    if (!bl2) break;
                }
                case 1: {
                    object2.b(k2.c);
                }
            }
            ++n2;
        } while (!bl2);
    }

    static k[] a(D d2) {
        D d3;
        int n2;
        Object[] arrobject;
        block3 : {
            boolean bl2 = t.d;
            d3 = new D();
            arrobject = d2.m();
            while (arrobject.f()) {
                o o2 = (o)arrobject.d();
                y y2 = o2.h();
                double d4 = y2.b;
                double d5 = y2.a;
                n2 = (int)(d4 DCMPG 0.0);
                if (!bl2) {
                    if (n2 >= 0 && d5 >= 0.0) {
                        h h2 = new h(y2.d, y2.d + d4, o2);
                        k k2 = new k(y2.c, 0, h2);
                        k k3 = new k(y2.c + d5, 1, h2);
                        d3.add(k2);
                        d3.add(k3);
                    }
                    arrobject.g();
                    if (!bl2) continue;
                }
                break block3;
            }
            n2 = d3.size();
        }
        arrobject = new k[n2];
        d3.toArray(arrobject);
        e.a(arrobject, (Comparator)new i());
        return arrobject;
    }
}

