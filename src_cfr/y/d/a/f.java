/*
 * Decompiled with CFR 0_115.
 */
package y.d.a;

import java.util.Comparator;
import y.d.a.b;
import y.d.a.e;
import y.g.g;

class f
implements Comparator,
g {
    Comparator a;
    private final b b;

    f(b b2) {
        this.b = b2;
        this.a = b.a(this.b).b();
    }

    public int compare(Object object, Object object2) {
        if (object == object2) {
            return 0;
        }
        e e2 = (e)object;
        e e3 = (e)object2;
        return this.a.compare(e3.g, e2.g);
    }
}

