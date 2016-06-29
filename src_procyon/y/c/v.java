package y.c;

class v implements e
{
    d a;
    private final q b;
    
    v(final q b) {
        this.b = b;
        this.a = b.c;
    }
    
    v(final q b, final d a) {
        this.b = b;
        this.a = a;
    }
    
    public boolean f() {
        return this.a != null;
    }
    
    public void g() {
        this.a = this.a.a;
    }
    
    public void h() {
        this.a = this.a.c;
    }
    
    public void b() {
        this.g();
        if (this.a == null) {
            this.i();
        }
    }
    
    public void c() {
        this.h();
        if (this.a == null) {
            this.j();
        }
    }
    
    public void i() {
        this.a = this.b.c;
    }
    
    public void j() {
        this.a = this.b.d;
    }
    
    public int k() {
        return this.b.f;
    }
    
    public Object d() {
        return this.a;
    }
    
    public d a() {
        return this.a;
    }
}
