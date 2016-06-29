/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import y.f.h.a.f;
import y.f.h.a.m;
import y.f.h.a.n;
import y.f.h.a.o;

abstract class r {
    f a = new f();

    r() {
    }

    abstract String a();

    f r() {
        return this.a;
    }

    m c(m m2) {
        return this.a.c(m2);
    }

    m s() {
        return this.a.g();
    }

    m f(int n2) {
        m m2;
        if (n2 == 0) {
            m2 = this.a.g();
            return m2;
        }
        m2 = this.a.h();
        return m2;
    }

    int a(m m2, int n2) {
        if (!this.a.i()) {
            return n2;
        }
        if (this.a.g() == m2) {
            return 0;
        }
        if (this.a.h() != m2) throw new RuntimeException(new StringBuffer().append("Edge ").append(m2.toString()).append(" not adjacent to the node").append(this.toString()).append("!").toString());
        return 1;
    }

    m t() {
        if (this.a.g().c()) {
            return this.a.e().b().a();
        }
        if (!this.a.h().c()) return null;
        return this.a.f().b().a();
    }

    boolean u() {
        return this.a.i();
    }

    o d(m m2) {
        return this.a.a(m2);
    }

    o e(m m2) {
        return this.a.b(m2);
    }

    abstract int f();

    boolean g() {
        return false;
    }

    abstract n b();
}

