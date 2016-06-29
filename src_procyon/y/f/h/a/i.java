package y.f.h.a;

class i extends r
{
    private n b;
    private n c;
    private h d;
    private boolean e;
    
    i(final n b, final n c) {
        this.e = false;
        this.b = b;
        this.c = c;
    }
    
    public String toString() {
        if (this.a != null) {
            return this.f() + "^" + this.c.f() + ": " + this.a.toString();
        }
        return this.f() + "^" + this.c.f();
    }
    
    String a() {
        return this.f() + "^" + this.c.f();
    }
    
    n b() {
        return this.b;
    }
    
    n c() {
        return this.c;
    }
    
    void d() {
        this.a.c();
        if (this.c != null) {
            this.c.j().g();
        }
    }
    
    void e() {
        this.e = true;
        if (this.d != null) {
            this.d.b();
        }
        this.d = null;
    }
    
    void a(final h d) {
        this.d = d;
    }
    
    int f() {
        return this.b.f();
    }
    
    boolean a(final int n) {
        return this.c.l() < n;
    }
    
    boolean b(final int n) {
        return this.c.l() == n;
    }
    
    boolean g() {
        return this.e;
    }
}
