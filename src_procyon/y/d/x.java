package y.d;

class x implements s
{
    u a;
    t b;
    
    x(final u a) {
        this.b = null;
        this.a = a;
        if (this.a.f()) {
            this.b = this.a.a();
            this.a.g();
        }
    }
    
    public boolean f() {
        return this.a.f();
    }
    
    public void g() {
        this.b = this.a.a();
        this.a.g();
    }
    
    public void h() {
        throw new UnsupportedOperationException();
    }
    
    public void i() {
        this.a.i();
        if (this.a.f()) {
            this.b = this.a.a();
            this.a.g();
        }
    }
    
    public void j() {
        this.a.j();
        this.a.h();
        if (this.a.f()) {
            this.b = this.a.a();
            this.a.g();
        }
    }
    
    public Object d() {
        return this.a();
    }
    
    public m a() {
        final t a = this.a.a();
        if (this.b == null || a == null) {
            throw new NullPointerException();
        }
        return new m(this.b, a);
    }
    
    public int k() {
        if (this.a.k() < 2) {
            return 0;
        }
        return this.a.k() - 1;
    }
}
