/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import java.util.Comparator;
import y.d.b.b;
import y.d.b.c;
import y.d.b.d;
import y.d.b.u;
import y.d.b.z;

public class m {
    protected u a;
    private b b;
    private b c;
    private b d;
    private b e;
    private z f;
    private z g;

    public m(b b2, b b3, d d2) {
        this.b = b2;
        this.c = b3;
        this.f = this.c.a().c(this.b.c()).b(this.b.a().c(this.c.c()));
        this.g = this.c.b().c(this.b.c()).b(this.b.b().c(this.c.c()));
        this.a = d2;
        if (this.a.c().compare(this.b, this.c) < 0) {
            this.d = this.b;
            this.e = this.c;
            if (c.a == 0) return;
        }
        this.d = this.c;
        this.e = this.b;
    }

    public b a() {
        return this.b;
    }

    public b b() {
        return this.c;
    }

    public z c() {
        return this.f;
    }

    public z d() {
        return this.g;
    }

    public boolean e() {
        return this.b.equals(this.c);
    }

    public boolean a(b b2) {
        b b3;
        if (this.e()) {
            return this.b.equals(b2);
        }
        b b4 = this.a();
        if (this.a.c(b4, b3 = this.b(), b2) != 0) {
            return false;
        }
        Comparator comparator = this.a.c();
        if (comparator.compare(this.d, b2) > 0) return false;
        if (comparator.compare(b2, this.e) > 0) return false;
        return true;
    }

    public boolean b(b b2) {
        if (b2.equals(this.b)) {
            return false;
        }
        if (!b2.equals(this.c)) return this.a(b2);
        return false;
    }

    public b a(m m2) {
        b b2 = this.b;
        b b3 = this.c;
        b b4 = m2.a();
        b b5 = m2.b();
        if (this.e()) {
            if (!m2.a(b2)) return null;
            return b2;
        }
        if (m2.e()) {
            if (!this.a(b4)) return null;
            return b4;
        }
        int n2 = this.a.a(this, m2.a());
        int n3 = this.a.a(this, m2.b());
        int n4 = this.a.a(m2, this.a());
        int n5 = this.a.a(m2, this.b());
        if (n2 == 0 && n3 == 0) {
            if (m2.a(b2)) {
                return b2;
            }
            if (m2.a(b3)) {
                return b3;
            }
            if (this.a(b4)) {
                return b4;
            }
            if (!this.a(b5)) return null;
            return b5;
        }
        if (n2 == n3) return null;
        if (n4 == n5) return null;
        return this.b(m2);
    }

    public b b(m m2) {
        b b2 = this.b;
        b b3 = this.c;
        b b4 = m2.a();
        b b5 = m2.b();
        z z2 = this.g.c(m2.c()).b(m2.d().c(this.f));
        if (z2.c() == 0) {
            return null;
        }
        z z3 = b3.a().c(b2.b()).b(b2.a().c(b3.b()));
        z z4 = b5.a().c(b4.b()).b(b4.a().c(b5.b()));
        z z5 = z4.c(this.f).b(z3.c(m2.c()));
        z z6 = z4.c(this.g).b(z3.c(m2.d()));
        return new b(z5, z6, z2);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof m)) {
            return false;
        }
        m m2 = (m)object;
        if (!m2.a().equals(this.b)) {
            return false;
        }
        if (m2.b().equals(this.c)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.b.hashCode();
        return 31 * n2 + this.c.hashCode();
    }

    public String toString() {
        return new StringBuffer().append("[S: ").append(this.b).append(" - T:").append(this.c).append("]").toString();
    }
}

