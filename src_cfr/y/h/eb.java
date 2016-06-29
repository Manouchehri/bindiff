/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.q;
import y.g.e;
import y.h.dV;

final class eB
implements Comparable {
    final double a;
    final q b;

    private eB(double d2, q q2) {
        this.a = d2;
        this.b = q2;
    }

    public int compareTo(Object object) {
        return e.a(this.a, ((eB)object).a);
    }

    public String toString() {
        return new StringBuffer().append("SweepEntry{coordinate=").append(this.a).append(", node=").append(this.b).append('}').toString();
    }

    eB(double d2, q q2, dV dV2) {
        this(d2, q2);
    }
}

