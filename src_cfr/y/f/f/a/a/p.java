/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.a;

import java.util.HashMap;
import java.util.Map;
import y.c.D;
import y.c.i;
import y.c.q;
import y.f.f.a.a.a;
import y.f.f.a.a.b;
import y.f.f.a.a.f;
import y.f.f.a.a.n;

public class p
extends a {
    protected i b;
    protected Map c = new HashMap();

    public p() {
    }

    public p(i i2) {
        this();
        this.a(i2);
    }

    public b a(b b2, q q2) {
        return this.a(b2, null, q2);
    }

    public b a(b b2, D d2, q q2) {
        b b3 = new b(b2, d2, q2);
        if (q2 == null) return b3;
        this.a(q2, b3);
        return b3;
    }

    public void a(i i2) {
        this.b = i2;
    }

    public void a(b b2) {
        if (b2 == null) {
            this.a = this.a(null, null, null);
            if (!f.e) return;
        }
        this.a = b2;
    }

    public void a(q q2, b b2) {
        this.c.put(q2, b2);
    }

    public b a(q q2) {
        return (b)this.c.get(q2);
    }

    public String toString() {
        return n.a(this);
    }
}

