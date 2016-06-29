/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.f.aA;
import y.f.ax;

final class aB
implements aA {
    ax a;
    int b;
    int c;

    aB(ax ax2, int n2) {
        this.a = ax2;
        this.c = n2;
        this.b = n2;
    }

    public aB(aB aB2) {
        this(aB2.a, aB2.c);
    }

    @Override
    public int b() {
        return this.b;
    }

    @Override
    public ax a() {
        return this.a;
    }

    public String toString() {
        return new StringBuffer().append("PortCandidateSet.Entry(candidate=").append(this.a).append(", connections=").append(this.b).append(')').toString();
    }
}

