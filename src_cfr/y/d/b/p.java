/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import java.util.Comparator;
import y.d.t;

class p
implements Comparator {
    p() {
    }

    public int compare(Object object, Object object2) {
        if (object == object2) {
            return 0;
        }
        t t2 = (t)object;
        t t3 = (t)object2;
        if (t2.a() < t3.a()) {
            return -1;
        }
        if (t2.a() > t3.a()) {
            return 1;
        }
        if (t2.b() < t3.b()) {
            return -1;
        }
        if (t2.b() <= t3.b()) return 0;
        return 1;
    }
}

