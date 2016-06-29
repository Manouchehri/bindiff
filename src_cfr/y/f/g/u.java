/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import java.util.Comparator;
import y.d.m;
import y.d.t;
import y.f.g.o;
import y.f.g.s;

class u
extends m {
    static final Comparator a = new s(null);
    private final int b;
    private final m c;

    u(t t2, t t3, int n2) {
        super(t2, t3);
        this.c = null;
        this.b = n2;
    }

    u(t t2, t t3, int n2, m m2) {
        super(t2, t3);
        this.b = n2;
        this.c = m2;
    }

    @Override
    public boolean b() {
        if (this.c().b != this.d().b) return false;
        return true;
    }

    public int l() {
        return this.b;
    }

    public m m() {
        return this.c;
    }

    @Override
    public String toString() {
        return new StringBuffer().append(this.c()).append(" ").append(this.d()).append(" priority: ").append(this.b).toString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        u u2 = (u)object;
        if (this.b != u2.b) {
            return false;
        }
        if (!this.c().equals(u2.c())) return false;
        if (this.d().equals(u2.d())) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.b;
        n2 = 31 * n2 + this.c().hashCode();
        return 31 * n2 + this.d().hashCode();
    }
}

