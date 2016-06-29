/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import y.c.D;
import y.c.d;
import y.f.h.a.n;
import y.f.h.a.r;

class m {
    private D a = null;
    private r b;
    private r c;
    private boolean d = false;
    private int e = 1;

    m(r r2, r r3, d d2) {
        this.a = new D();
        this.a.add(d2);
        this.b = r2;
        this.c = r3;
    }

    m(r r2, r r3) {
        this.b = r2;
        this.c = r3;
    }

    public String toString() {
        String string = new StringBuffer().append(this.b.a()).append("->").append(this.c.a()).toString();
        if (this.e < 0) {
            string = new StringBuffer().append("-").append(string).toString();
        }
        if (this.b()) {
            string = new StringBuffer().append(string).append("*").toString();
        }
        if (this.k()) return string;
        return new StringBuffer().append(string).append(" (ne)").toString();
    }

    D d() {
        return this.a;
    }

    boolean b() {
        if (this.a != null) return false;
        return true;
    }

    boolean c() {
        if (this.a == null) return false;
        if (this.d) return false;
        return true;
    }

    r a(r r2) {
        if (this.b.g()) {
            this.b = this.b.b();
        }
        if (this.b == r2) {
            return this.c;
        }
        if (this.c != r2) throw new RuntimeException(new StringBuffer().append("The edge ").append(this.toString()).append(" is not connected to the node ").append(r2.toString()).append("!").toString());
        return this.b;
    }

    void b(r r2) {
        this.b = r2;
    }

    r e() {
        if (!this.b.g()) return this.b;
        this.b = this.b.b();
        return this.b;
    }

    r f() {
        return this.c;
    }

    void g() {
        this.e *= -1;
    }

    int h() {
        return this.e;
    }

    void a(d d2) {
        this.a.add(d2);
    }

    d i() {
        return (d)this.a.f();
    }

    void j() {
        this.d = true;
    }

    boolean k() {
        return this.d;
    }

    int a() {
        return 1;
    }
}

