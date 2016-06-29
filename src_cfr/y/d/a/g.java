/*
 * Decompiled with CFR 0_115.
 */
package y.d.a;

import java.util.Comparator;
import y.c.h;
import y.d.a.b;
import y.d.a.e;
import y.d.a.f;

class g
implements Comparator,
y.g.g {
    private h a;
    private f b;
    private final b c;

    public g(b b2, h h2) {
        this.c = b2;
        this.a = h2;
        this.b = new f(b2);
    }

    public int compare(Object object, Object object2) {
        if (object == object2) {
            return 0;
        }
        int n2 = this.b.compare(this.a.b(object), this.a.b(object2));
        if (n2 != 0) {
            return n2;
        }
        e e2 = (e)this.a.b(object);
        e e3 = (e)this.a.b(object2);
        return y.g.e.a(e3.b(), e2.b());
    }
}

