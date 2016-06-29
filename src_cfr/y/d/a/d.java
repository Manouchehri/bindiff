/*
 * Decompiled with CFR 0_115.
 */
package y.d.a;

import java.util.Comparator;
import y.d.a.b;
import y.d.a.e;
import y.d.a.f;
import y.g.g;

class d
implements Comparator,
g {
    Object a;
    Comparator b;
    private final b c;

    d(b b2) {
        this.c = b2;
        this.b = new f(b2);
    }

    void a(Object object) {
        this.a = object;
    }

    public int compare(Object object, Object object2) {
        e e2 = (e)object;
        e e3 = (e)object2;
        int n2 = b.a(this.c).c(e3.c, e3.d, this.a);
        if (n2 == 0) return this.b.compare(e2, e3);
        return - n2;
    }
}

