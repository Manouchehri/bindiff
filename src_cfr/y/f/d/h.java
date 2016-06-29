/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.util.Comparator;
import y.c.A;
import y.c.q;
import y.f.d.f;
import y.f.d.r;

class h
implements Comparator {
    r[] a;
    private final f b;

    h(f f2, r[] arrr) {
        this.b = f2;
        this.a = arrr;
    }

    public int compare(Object object, Object object2) {
        q q2 = (q)object;
        q q3 = (q)object2;
        boolean bl2 = this.a[this.b.p.a(q2)].c();
        boolean bl3 = this.a[this.b.p.a(q3)].c();
        if (bl2 && bl3) {
            return 0;
        }
        if (bl2) {
            return -1;
        }
        if (bl3) {
            return 1;
        }
        if (f.a(this.b).c(q2) < f.a(this.b).c(q3)) {
            return 1;
        }
        if (f.a(this.b).c(q3) >= f.a(this.b).c(q2)) return 0;
        return -1;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof h)) return false;
        if (this.a != ((h)object).a) return false;
        return true;
    }

    public int hashCode() {
        if (this.a == null) return 0;
        int n2 = this.a.hashCode();
        return n2;
    }
}

