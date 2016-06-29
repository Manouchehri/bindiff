/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import java.util.Comparator;
import y.c.i;
import y.d.t;
import y.f.f.e.a;
import y.g.e;

class d
implements Comparator {
    i a;
    int b;
    private final a c;

    d(a a2) {
        this.c = a2;
    }

    public int compare(Object object, Object object2) {
        int n2 = a.a;
        t t2 = a.a(this.c).p((y.c.d)object);
        t t3 = a.a(this.c).p((y.c.d)object2);
        int n3 = 0;
        switch (this.b) {
            case 0: {
                n3 = e.a(t2.a, t3.a);
                if (n2 == 0) return n3;
            }
            case 3: {
                n3 = e.a(t2.b, t3.b);
                if (n2 == 0) return n3;
            }
            case 2: {
                n3 = e.a(t3.a, t2.a);
                if (n2 == 0) return n3;
            }
            case 1: {
                n3 = e.a(t3.b, t2.b);
            }
        }
        return n3;
    }
}

