package y.c;

public class d extends I
{
    d a;
    d b;
    d c;
    d d;
    q e;
    q f;
    int g;
    i h;
    
    protected d(final i i, final q q, final d d, final q q2, final d d2, final int n, final int n2) {
        i.a(this, q, d, q2, d2, n, n2);
    }
    
    public d a(final i i, final q q, final q q2) {
        return new d(i, q, null, q2, null, 0, 0);
    }
    
    public i a() {
        return this.h;
    }
    
    public int b() {
        if (this.h.f) {
            this.h.B();
        }
        return this.g;
    }
    
    public q c() {
        return this.e;
    }
    
    public q d() {
        return this.f;
    }
    
    public q a(final q q) {
        return (this.e == q) ? this.f : this.e;
    }
    
    public boolean e() {
        return this.f == this.e;
    }
    
    public String toString() {
        return this.c() + " -> " + this.d();
    }
    
    protected void f() {
        final d d = null;
        this.d = d;
        this.c = d;
        this.b = d;
        this.a = d;
    }
    
    public d g() {
        return this.a;
    }
    
    public d h() {
        return this.b;
    }
    
    public d i() {
        return this.c;
    }
    
    public d j() {
        return this.d;
    }
    
    void a(final i h, final q e, final q f, final int n) {
        this.a(n);
        this.h = h;
        this.e = e;
        this.f = f;
    }
    
    void a(final i h) {
        this.h = h;
    }
}
