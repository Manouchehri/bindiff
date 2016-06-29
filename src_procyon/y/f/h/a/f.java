package y.f.h.a;

import java.util.*;

class f
{
    private o a;
    private o b;
    
    f() {
        this.a = new o(null, null, null);
        this.b = new o(null, null, this.a);
        this.a.a(0, this.b);
    }
    
    boolean a() {
        return this.a.a(null) == this.b;
    }
    
    void b() {
        this.a.a(0, this.b);
        this.a.a(1, null);
        this.b.a(1, this.a);
        this.b.a(0, null);
    }
    
    void c() {
        final o a = this.a;
        this.a = this.b;
        this.b = a;
    }
    
    public Iterator d() {
        return new g(this);
    }
    
    o a(final m m) {
        final o o = new o(m, null, null);
        this.a(o);
        return o;
    }
    
    void a(final o o) {
        this.b.a(null).b(this.b.a(null).a(this.b), o);
    }
    
    o b(final m m) {
        final o o = new o(m, null, null);
        this.b(o);
        return o;
    }
    
    void b(final o o) {
        this.a.b(null, o);
    }
    
    void a(final f f) {
        this.b.a(null).a(this.b.a(null).a(this.b), f);
    }
    
    void b(final f f) {
        this.a.a(null, f);
    }
    
    void c(final f f) {
        f.c();
        this.a(f);
    }
    
    void d(final f f) {
        f.c();
        this.b(f);
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
    
    void c(final o o) {
        this.b.a(null).a(this.b, o);
    }
    
    void d(final o o) {
        this.a.a(null).a(this.a, o);
    }
    
    m c(final m m) {
        if (this.a()) {
            throw new RuntimeException("Cannot search for the opposite element if list is empty!");
        }
        if (this.a.a(null).a() == m) {
            return this.b.a(null).a();
        }
        if (this.b.a(null).a() == m) {
            return this.a.a(null).a();
        }
        throw new RuntimeException("Element " + m.toString() + " is not at one of the ends of the list " + this.toString() + "!");
    }
    
    boolean i() {
        return !this.a() && this.a.a(null).a() != this.b.a(null).a();
    }
    
    public String toString() {
        final boolean g = y.f.h.a.b.g;
        String s = "[";
        final Iterator d = this.d();
        String s2 = null;
        while (d.hasNext()) {
            s2 = s;
            if (g) {
                return s2;
            }
            if (s2 != "[") {
                s += ", ";
            }
            s = s + "(" + d.next().toString() + ")";
            if (g) {
                break;
            }
        }
        new StringBuffer().append(s).append("]").toString();
        return s2;
    }
    
    static o e(final f f) {
        return f.a;
    }
    
    static o f(final f f) {
        return f.b;
    }
}
