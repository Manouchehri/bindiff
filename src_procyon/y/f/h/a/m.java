package y.f.h.a;

import y.c.*;

class m
{
    private D a;
    private r b;
    private r c;
    private boolean d;
    private int e;
    
    m(final r b, final r c, final d d) {
        this.a = null;
        this.d = false;
        this.e = 1;
        (this.a = new D()).add(d);
        this.b = b;
        this.c = c;
    }
    
    m(final r b, final r c) {
        this.a = null;
        this.d = false;
        this.e = 1;
        this.b = b;
        this.c = c;
    }
    
    public String toString() {
        String s = this.b.a() + "->" + this.c.a();
        if (this.e < 0) {
            s = "-" + s;
        }
        if (this.b()) {
            s += "*";
        }
        if (!this.k()) {
            s += " (ne)";
        }
        return s;
    }
    
    D d() {
        return this.a;
    }
    
    boolean b() {
        return this.a == null;
    }
    
    boolean c() {
        return this.a != null && !this.d;
    }
    
    r a(final r r) {
        if (this.b.g()) {
            this.b = this.b.b();
        }
        if (this.b == r) {
            return this.c;
        }
        if (this.c == r) {
            return this.b;
        }
        throw new RuntimeException("The edge " + this.toString() + " is not connected to the node " + r.toString() + "!");
    }
    
    void b(final r b) {
        this.b = b;
    }
    
    r e() {
        if (this.b.g()) {
            this.b = this.b.b();
        }
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
    
    void a(final d d) {
        this.a.add(d);
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
