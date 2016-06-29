/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.Iterator;
import y.f.h.a.b;
import y.f.h.a.g;
import y.f.h.a.m;
import y.f.h.a.o;

class f {
    private o a = new o(null, null, null);
    private o b = new o(null, null, this.a);

    f() {
        this.a.a(0, this.b);
    }

    boolean a() {
        if (this.a.a(null) != this.b) return false;
        return true;
    }

    void b() {
        this.a.a(0, this.b);
        this.a.a(1, null);
        this.b.a(1, this.a);
        this.b.a(0, null);
    }

    void c() {
        o o2 = this.a;
        this.a = this.b;
        this.b = o2;
    }

    public Iterator d() {
        return new g(this);
    }

    o a(m m2) {
        o o2 = new o(m2, null, null);
        this.a(o2);
        return o2;
    }

    void a(o o2) {
        o o3 = this.b.a(null).a(this.b);
        this.b.a(null).b(o3, o2);
    }

    o b(m m2) {
        o o2 = new o(m2, null, null);
        this.b(o2);
        return o2;
    }

    void b(o o2) {
        this.a.b(null, o2);
    }

    void a(f f2) {
        o o2 = this.b.a(null).a(this.b);
        this.b.a(null).a(o2, f2);
    }

    void b(f f2) {
        this.a.a(null, f2);
    }

    void c(f f2) {
        f2.c();
        this.a(f2);
    }

    void d(f f2) {
        f2.c();
        this.b(f2);
    }

    o e() {
        return this.a.a(null);
    }

    o f() {
        return this.b.a(null);
    }

    m g() {
        return this.a.a(null).a();
    }

    m h() {
        return this.b.a(null).a();
    }

    void c(o o2) {
        this.b.a(null).a(this.b, o2);
    }

    void d(o o2) {
        this.a.a(null).a(this.a, o2);
    }

    m c(m m2) {
        if (this.a()) throw new RuntimeException("Cannot search for the opposite element if list is empty!");
        if (this.a.a(null).a() == m2) {
            return this.b.a(null).a();
        }
        if (this.b.a(null).a() != m2) throw new RuntimeException(new StringBuffer().append("Element ").append(m2.toString()).append(" is not at one of the ends of the list ").append(this.toString()).append("!").toString());
        return this.a.a(null).a();
    }

    boolean i() {
        if (this.a()) return false;
        if (this.a.a(null).a() == this.b.a(null).a()) return false;
        return true;
    }

    public String toString() {
        String string;
        boolean bl2 = b.g;
        String string2 = "[";
        Iterator iterator = this.d();
        while (iterator.hasNext()) {
            string = string2;
            if (bl2) return string;
            if (string != "[") {
                string2 = new StringBuffer().append(string2).append(", ").toString();
            }
            string2 = new StringBuffer().append(string2).append("(").append(iterator.next().toString()).append(")").toString();
            if (!bl2) continue;
        }
        string = new StringBuffer().append(string2).append("]").toString();
        return string;
    }

    static o e(f f2) {
        return f2.a;
    }

    static o f(f f2) {
        return f2.b;
    }
}

