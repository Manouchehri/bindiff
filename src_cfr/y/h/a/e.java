/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import java.util.HashMap;
import java.util.Map;
import y.c.q;

final class E {
    q a;
    q b;
    Map c;

    E(q q2, q q3) {
        if (q2 == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (q3 == null) {
            throw new IllegalArgumentException("target == null");
        }
        this.a = q2;
        this.b = q3;
    }

    q a() {
        return this.a;
    }

    q b() {
        return this.b;
    }

    Object a(String string, Object object) {
        if (this.c != null) return this.c.put(string, object);
        this.c = new HashMap();
        return this.c.put(string, object);
    }

    Object a(String string) {
        if (this.c == null) {
            return null;
        }
        Object v0 = this.c.get(string);
        return v0;
    }

    Object b(String string) {
        if (this.c == null) {
            return null;
        }
        Object v0 = this.c.remove(string);
        return v0;
    }

    public String toString() {
        return new StringBuffer().append("source = ").append(this.a).append("  target = ").append(this.b).toString();
    }
}

