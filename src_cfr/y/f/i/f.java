/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.f.i.J;
import y.f.i.v;
import y.g.e;

class F
implements Comparable {
    final boolean a;
    final double b;
    final double c;
    final double d;
    int e;
    final J f;

    F(boolean bl2, double d2, double d3, double d4, J j2) {
        this.a = bl2;
        this.f = j2;
        this.b = d2;
        if (d3 < d4) {
            this.c = d3;
            this.d = d4;
            if (v.f == 0) return;
        }
        this.c = d4;
        this.d = d3;
    }

    public int compareTo(Object object) {
        F f2 = (F)object;
        int n2 = e.a(this.b, f2.b);
        if (n2 != 0) {
            return n2;
        }
        if (this.a) {
            if (!f2.a) return -1;
            return 0;
        }
        if (!f2.a) return 0;
        return 1;
    }

    public String toString() {
        return new StringBuffer().append("Event{open=").append(this.a).append(", x=").append(this.b).append(", yBegin=").append(this.c).append(", yEnd=").append(this.d).append(", openEventCount=").append(this.e).append(", graphicalObject=").append(this.f).append('}').toString();
    }
}

