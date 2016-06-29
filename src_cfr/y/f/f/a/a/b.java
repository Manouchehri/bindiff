/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.a;

import y.c.D;
import y.c.q;
import y.f.f.a.a.f;

public class b
extends f {
    protected q a;

    public b() {
        this(null, null, null);
    }

    public b(b b2, D d2, q q2) {
        super(b2, d2);
        this.a = q2;
    }

    public q b_() {
        return this.a;
    }

    public String toString() {
        return new StringBuffer().append("\n\nNode: ").append(this.a).append("\nDepth: ").append(this.d).toString();
    }
}

